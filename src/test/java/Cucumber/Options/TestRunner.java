package Cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\Feature\\PlaceValidations.feature",glue= {"StepDefinition"},tags = "@DeletePlace")
public class TestRunner {

}
