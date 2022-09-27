package com.nn.cucumberRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features="src/test/resources/Features/Lms_Login.feature",
					glue= {"com/nn/stepDefs"},
					plugin= {"html:target/Cucumber.html",	"json:target/Cucumber.json"}
                  )

public class TestRunner {

}
