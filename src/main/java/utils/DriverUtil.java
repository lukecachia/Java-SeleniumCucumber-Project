package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverUtil {

    public WebDriver webDriver;
    private static String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.87 Safari/537.36";

    public WebDriver startWebDriver(String webDriver) {
        if (webDriver == null) {
            throw new IllegalStateException("WebDriver not specified in program variables");
        }

        /* The if condition initiates a web driver depending on
        the value inputted in the vm option. In case of null/invalid
        input an exception is thrown. */

        if (webDriver.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            this.webDriver = new ChromeDriver();
            this.webDriver.manage().window().maximize();
            return this.webDriver;

        } else if (webDriver.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addPreference("general.useragent.override", userAgent);
            this.webDriver = new FirefoxDriver();
            this.webDriver.manage().window().maximize();
            return this.webDriver;

        } else if (webDriver.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            this.webDriver = new InternetExplorerDriver();
            this.webDriver.manage().window().maximize();
            return this.webDriver;

        } else if (webDriver.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            this.webDriver = new EdgeDriver();
            this.webDriver.manage().window().maximize();
            return this.webDriver;

        } else {
            throw new IllegalArgumentException("WebDriver specified not recognised, " +
                    "please use one of the following: chrome, firefox, ie, edge");
        }
    }

    public void stopWebDriver() {
        this.webDriver.quit();
    }
}
