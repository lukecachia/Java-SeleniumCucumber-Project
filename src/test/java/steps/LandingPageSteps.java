package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LandingPage;

public class LandingPageSteps {

    public LandingPage landingPage = new LandingPage(Hooks.webDriver);

    @Given("I navigate to the desired URL")
    public void iNavigateToTheDesiredURL() {
        landingPage.navigateToLandingPage("https://trends.google.com/trends/");
    }

    @And("I input {string}")
    public void iInput(String keyword) {
        landingPage.inputKeyword(keyword);
    }

    @Then("I verify that I landed on the correct page")
    public void iVerifyThatILandedOnTheCorrectPage() {
        Assert.assertEquals("Explore", landingPage.getTextOfElement(), "Error, the current page" +
                "does not contain the expected element/text. Please check!");
        System.out.println("Page header is: " + landingPage.getTextOfElement());
    }


    @And("I compare with {string}")
    public void iCompareWith(String compareKeyword) throws InterruptedException {
        landingPage.inputCompareKeyword(compareKeyword);
    }

    @Then("I select {string}")
    public void iSelect(String countryState) {
        landingPage.selectCountryState(countryState);
    }

    @Then("I set the {string}")
    public void iSetThe(String timeframe) throws InterruptedException {
        landingPage.selectTimeframe(timeframe);
    }

    @When("I scroll down to the metro section")
    public void iScrollDownToTheMetroSection() throws InterruptedException {
        landingPage.scrollToSection();
    }
}
