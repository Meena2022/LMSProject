package com.nn.cucumberRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features="src/test/resources/Features/",
					glue= {"com/nn/stepDefs","Hooks"},
					plugin= {"html:target/Cucumber.html",	
							"json:target/Cucumber.json",
							"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

							}
                  )

public class TestRunner {

}
