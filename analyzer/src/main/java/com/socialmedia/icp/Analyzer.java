package com.socialmedia.icp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.socialmedia.icp.model.dto.PersonDataDTO;
import com.socialmedia.icp.service.FileService;
import com.socialmedia.icp.service.RulesService;
import com.socialmedia.icp.utils.GeneralUtils;

@SpringBootApplication
public class Analyzer implements CommandLineRunner {
	private static Logger logger = Logger.getLogger(Analyzer.class);
	private static List<PersonDataDTO> listPersons = new ArrayList<PersonDataDTO>();

	@Autowired
	private GeneralUtils generalUtils;

	@Autowired
	private FileService fileService;

	@Autowired
	private RulesService rulesService;

	public static void main(String[] args) {
		SpringApplication springApp = new SpringApplication(Analyzer.class);
		springApp.setBannerMode(Banner.Mode.OFF);
		
		try {
			springApp.run(args);
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void run(String... args) throws Exception {
		String inputFile = generalUtils.getProperty("file.path.input");
		String outputFile = generalUtils.getProperty("file.path.output");

		if (generalUtils.isValidPath(inputFile)) {
			listPersons = fileService.readFile(inputFile);

			for (int i = 0; i < listPersons.size(); i++) {
				listPersons.get(i).setScore(rulesService.evaluateRules(listPersons.get(i)));
			}

			listPersons.sort(Comparator.comparing(PersonDataDTO::getScore).reversed());
			
			fileService.writeFile(
					listPersons.subList(0, Integer.parseInt(generalUtils.getProperty("person.max.result"))),
					outputFile);
		} else {
			logger.error("Error: the file people.in must exist and be in the same path as the jar.");
		}
	}
}