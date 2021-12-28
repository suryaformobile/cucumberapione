package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/feature/createRepo.feature"}, glue= {"stepDefinitions"}
                            ,plugin = {"json:target/cucumber.json"} )
//justupdate
public class TestRunner{

}
