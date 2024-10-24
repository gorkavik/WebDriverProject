import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",
        glue = "org/example/cucumber",
        tags = "@param or @search",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class Runner {

}
