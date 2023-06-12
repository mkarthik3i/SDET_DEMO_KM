package com.hotel.utill;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		features = {"features"},
        glue = {"stepDefinitions"},
        tags = "@test",
        plugin = {"pretty", "html:Report1"},
        monochrome = true,
        dryRun=false,
        publish = true)

public class CucumberRunner extends AbstractTestNGCucumberTests {

}

	