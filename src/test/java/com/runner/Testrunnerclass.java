package com.runner;

import java.io.FileNotFoundException;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "", dryRun = false, features = "src/test/resources/Features", plugin = { "pretty",
		"json:target/index.json" }, monochrome = true, stepNotifications = true, snippets = SnippetType.CAMELCASE, glue = "com.stepdefinition")
public class Testrunnerclass extends BaseClass {
	/**
	 * @see used to Generate Snippets and excecute step definition
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
// This is test runner class
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJvmreport(getProjectPath() + getPropertyfilevalue("jsonpath"));
	}

}
