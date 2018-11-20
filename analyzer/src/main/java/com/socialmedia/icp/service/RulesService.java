package com.socialmedia.icp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.icp.model.dto.PersonDataDTO;
import com.socialmedia.icp.model.dto.RulePropertyDTO;
import com.socialmedia.icp.utils.GeneralUtils;

@Service
public class RulesService {
	private static Logger logger = Logger.getLogger(RulesService.class);
	
	@Autowired
	private GeneralUtils generalUtils;

	public double evaluateRules(PersonDataDTO input) {
		double score = 0.0;

		try {
			// Evaluate currentRole
			score += evaluateRuleCurrentRole(input.getCurrentRole().trim().toUpperCase());
	
			// Evaluate industry
			score += evaluateRuleIndustry(input.getIndustry().trim().toUpperCase());
	
			// Evaluate country
			score += evaluateRuleCountry(input.getCountry().trim().toUpperCase());
	
			// Evaluate number of recommends()
			score += evaluateRuleNumberRecommends(Integer.parseInt(input.getNumberRecommends()));
	
			// Evaluate number connects()
			score += evaluateRuleNumberConnects(Integer.parseInt(input.getNumberConnects()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return score;
	}

	public double evaluateRuleCurrentRole(String currentRole) {
		RulePropertyDTO category1 = generalUtils.getRuleProperty("rules.role.category1");
		List<String> listCategory1 = new ArrayList<String>(Arrays.asList(category1.getValue().split(",")));
		RulePropertyDTO category2 = generalUtils.getRuleProperty("rules.role.category2");
		List<String> listCategory2 = new ArrayList<String>(Arrays.asList(category2.getValue().split(",")));
		RulePropertyDTO category3 = generalUtils.getRuleProperty("rules.role.category3");
		List<String> listCategory3 = new ArrayList<String>(Arrays.asList(category3.getValue().split(",")));

		if (currentRole.equals("")) {
			return -1;
		}else if (listCategory1.stream().anyMatch(currentRole::contains)) {
			return category1.getScore();
		} else if (listCategory2.stream().anyMatch(currentRole::contains)) {
			return category2.getScore();
		} else if (listCategory3.stream().anyMatch(currentRole::contains)) {
			return category3.getScore();
		}

		return 0;
	}

	public double evaluateRuleIndustry(String industry) {
		RulePropertyDTO category1 = generalUtils.getRuleProperty("rules.industry.category1");
		List<String> listCategory1 = new ArrayList<String>(Arrays.asList(category1.getValue().split(",")));
		RulePropertyDTO category2 = generalUtils.getRuleProperty("rules.industry.category2");
		List<String> listCategory2 = new ArrayList<String>(Arrays.asList(category2.getValue().split(",")));
		RulePropertyDTO category3 = generalUtils.getRuleProperty("rules.industry.category3");
		List<String> listCategory3 = new ArrayList<String>(Arrays.asList(category3.getValue().split(",")));

		if (listCategory1.stream().anyMatch(industry::contains)) {
			return category1.getScore();
		} else if (listCategory2.stream().anyMatch(industry::contains)) {
			return category2.getScore();
		} else if (listCategory3.stream().anyMatch(industry::contains)) {
			return category3.getScore();
		}

		return 0;
	}

	public double evaluateRuleCountry(String country) {
		RulePropertyDTO category1 = generalUtils.getRuleProperty("rules.country.category1");
		List<String> listCategory1 = new ArrayList<String>(Arrays.asList(category1.getValue().split(",")));
		RulePropertyDTO category2 = generalUtils.getRuleProperty("rules.country.category2");
		List<String> listCategory2 = new ArrayList<String>(Arrays.asList(category2.getValue().split(",")));
		RulePropertyDTO category3 = generalUtils.getRuleProperty("rules.country.category3");
		List<String> listCategory3 = new ArrayList<String>(Arrays.asList(category3.getValue().split(",")));

		if (listCategory1.stream().anyMatch(country::contains)) {
			return category1.getScore();
		} else if (listCategory2.stream().anyMatch(country::contains)) {
			return category2.getScore();
		} else if (listCategory3.stream().anyMatch(country::contains)) {
			return category3.getScore();
		}

		return 0;
	}

	public double evaluateRuleNumberRecommends(int numberRecommends) {
		RulePropertyDTO category1 = generalUtils.getRuleProperty("rules.numrecom.category1");
		List<String> listCategory1 = new ArrayList<String>(Arrays.asList(category1.getValue().split(",")));
		RulePropertyDTO category2 = generalUtils.getRuleProperty("rules.numrecom.category2");
		List<String> listCategory2 = new ArrayList<String>(Arrays.asList(category2.getValue().split(",")));
		RulePropertyDTO category3 = generalUtils.getRuleProperty("rules.numrecom.category3");
		List<String> listCategory3 = new ArrayList<String>(Arrays.asList(category3.getValue().split(",")));

		if ((listCategory1.size() == 1 && numberRecommends >= Integer.parseInt(listCategory1.get(0)))
				|| (numberRecommends >= Integer.parseInt(listCategory1.get(0))
						&& numberRecommends <= Integer.parseInt(listCategory1.get(1)))) {
			return category1.getScore();
		} else if ((listCategory2.size() == 1 && numberRecommends >= Integer.parseInt(listCategory2.get(0)))
				|| (numberRecommends >= Integer.parseInt(listCategory2.get(0))
						&& numberRecommends <= Integer.parseInt(listCategory2.get(1)))) {
			return category2.getScore();
		} else if ((listCategory3.size() == 1 && numberRecommends >= Integer.parseInt(listCategory3.get(0)))
				|| (numberRecommends >= Integer.parseInt(listCategory3.get(0))
						&& numberRecommends <= Integer.parseInt(listCategory3.get(1)))) {
			return category3.getScore();
		}

		return 0;
	}

	public double evaluateRuleNumberConnects(int numberConnects) {
		RulePropertyDTO category1 = generalUtils.getRuleProperty("rules.numconnect.category1");
		List<String> listCategory1 = new ArrayList<String>(Arrays.asList(category1.getValue().split(",")));
		RulePropertyDTO category2 = generalUtils.getRuleProperty("rules.numconnect.category2");
		List<String> listCategory2 = new ArrayList<String>(Arrays.asList(category2.getValue().split(",")));
		RulePropertyDTO category3 = generalUtils.getRuleProperty("rules.numconnect.category3");
		List<String> listCategory3 = new ArrayList<String>(Arrays.asList(category3.getValue().split(",")));

		if ((listCategory1.size() == 1 && numberConnects >= Integer.parseInt(listCategory1.get(0)))
				|| (numberConnects >= Integer.parseInt(listCategory1.get(0))
						&& numberConnects <= Integer.parseInt(listCategory1.get(1)))) {
			return category1.getScore();
		} else if ((listCategory2.size() == 1 && numberConnects >= Integer.parseInt(listCategory2.get(0)))
				|| (numberConnects >= Integer.parseInt(listCategory2.get(0))
						&& numberConnects <= Integer.parseInt(listCategory2.get(1)))) {
			return category2.getScore();
		} else if ((listCategory3.size() == 1 && numberConnects >= Integer.parseInt(listCategory3.get(0)))
				|| (numberConnects >= Integer.parseInt(listCategory3.get(0))
						&& numberConnects <= Integer.parseInt(listCategory3.get(1)))) {
			return category3.getScore();
		}

		return 0;
	}
}