package com.socialmedia.icp.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.socialmedia.icp.model.dto.RulePropertyDTO;

@Configuration
@PropertySource(value = { "classpath:analyzerConfig.properties" }, name="analyzerConfig.properties")
public class GeneralUtils {

	@Autowired
	private Environment env;

	public RulePropertyDTO getRuleProperty(String name) {
		return new RulePropertyDTO(env.getProperty(name + ".value"),
				Double.parseDouble(env.getProperty(name + ".score")));
	}
	
	public String getProperty(String name) {
		return env.getProperty(name);
	}

	public boolean isValidPath(String path) {
		return new File(path).exists();
	}
}