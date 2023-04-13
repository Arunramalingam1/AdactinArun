package com.report;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {
	
	public static void generateJvmreport(String jsonfile) {
		
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\AdactinHotelAutomation\\target");
		Configuration configuration = new Configuration(file,"Adactin Automation");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Browser version", "109");
		configuration.addClassifications("testing", "regresion");
		
		List<String> jsonFiles = new LinkedList<String>();
		jsonFiles.add(jsonfile);

		
		ReportBuilder reportbuilder = new ReportBuilder(jsonFiles, configuration);
		reportbuilder.generateReports(); 
		

	}

}
