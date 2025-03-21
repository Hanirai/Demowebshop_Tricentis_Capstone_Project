package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {
	         	"src\\test\\resources\\features\\OrderPlacement.feature"}
                 ,glue= {"com.StepDefinition","Hooks"}
                  ,plugin = {"pretty","html:reports/HTMLReports.html",
							"json:reports/json-report.json",
							"junit:reports/junit_report.xml",
							})

public class OrderRunnerTestcase extends AbstractTestNGCucumberTests{

}
