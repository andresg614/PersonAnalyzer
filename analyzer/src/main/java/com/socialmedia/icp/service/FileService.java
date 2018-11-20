package com.socialmedia.icp.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.socialmedia.icp.model.dto.PersonDataDTO;

@Service
public class FileService {
	private static Logger logger = Logger.getLogger(FileService.class);
	
	public List<PersonDataDTO> readFile(String filePath) {
		List<PersonDataDTO> listTemp = new ArrayList<PersonDataDTO>();

		try {
			File inputFile = new File(filePath);
			InputStream inputStream = new FileInputStream(inputFile);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			listTemp = bufferedReader.lines().map(lineToPersonDataDTO).collect(Collectors.toList());

			bufferedReader.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return listTemp;
	}

	private Function<String, PersonDataDTO> lineToPersonDataDTO = (line) -> {
		String[] fields = line.split("\\|");
		
		if (fields.length != 8) {
			System.out.println(fields.length);
		}
		
		PersonDataDTO personTemp = new PersonDataDTO();

		personTemp.setPersonId(fields[0]);
		personTemp.setName(fields[1]);
		personTemp.setLastName(fields[2]);
		personTemp.setCurrentRole(fields[3]);
		personTemp.setCountry(fields[4]);
		personTemp.setIndustry(fields[5]);
		personTemp.setNumberRecommends(fields[6]);
		personTemp.setNumberConnects(fields[7]);

		return personTemp;
	};

	public void writeFile(List<PersonDataDTO> listPersons, String filePath) {
		try {
			File outputFile = new File(filePath);
			OutputStream outputStream = new FileOutputStream(outputFile);
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

			for (int i = 0; i < listPersons.size(); i++) {
				bufferedWriter.write(listPersons.get(i).getPersonId() + "\n");
			}

			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}