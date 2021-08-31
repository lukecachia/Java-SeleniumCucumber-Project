package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.LandingPage;
import utils.DriverUtil;

public class Hooks {

    public DriverUtil driverUtil = new DriverUtil();
    public static WebDriver webDriver;


    @Before("@browser")
    public void startWebDriver(Scenario scenario){
        System.out.println("Starting scenario: " + scenario.getName());
        webDriver = driverUtil.startWebDriver("chrome");

    }

    @After()
    public void closeWebDriver() throws InterruptedException {
        Thread.sleep(3000);
        driverUtil.stopWebDriver();

    }


}
