package pages;

import hooks.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtil;

import java.util.List;

public class LandingPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    private final By keywordInput             = By.id("input-254");
    private final By pageHeader               = By.className("header-sub-title");
    private final By compareKeywordContainer  = By.className("add-term-button");
    private final By compareKeywordTextArea   = By.xpath("//input[contains(@id,\"input-\")]");
    private final By compareAutocomplete      = By.className("autocomplete-entity");
    private final By countryDropdown          = By.className("compare-picker");
    private final By dropdownTextfield        = By.cssSelector("div.hierarchy-autocomplete input");
    private final By dropdownResult           = By.cssSelector("div.hierarchy-picker-label");
    private final By timeframeDropdown        = By.cssSelector("custom-date-picker");
    private final By timeframeListItems       = By.className("custom-date-picker-select-option");
    private final By heatBar                  = By.className("progress-bar-multi-heat-volume");
    private final By percentResult            = By.className("tooltip-percentage");

    public LandingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void navigateToLandingPage(String url) {
        webDriver.navigate().to(url);

    }

    public void inputKeyword(String keyword) {
        webDriver.findElement(keywordInput).sendKeys(keyword, Keys.RETURN);
    }

    public String getTextOfElement(){
        return webDriver.findElement(pageHeader).getText();
    }

    public void inputCompareKeyword(String compareKeyword) throws InterruptedException {


        wait = new WebDriverWait(webDriver, 30);
        wait.until((ExpectedConditions.elementToBeClickable(compareKeywordContainer)));

        webDriver.findElement(compareKeywordContainer).click();
        webDriver.findElements(compareKeywordTextArea).get(1).sendKeys(compareKeyword);

        wait.until((ExpectedConditions.elementToBeClickable(compareAutocomplete)));
        webDriver.findElement(compareAutocomplete).click();
    }

    public void selectCountryState(String countryState) {
        webDriver.findElement(countryDropdown).click();
        webDriver.findElement(dropdownTextfield).sendKeys(countryState);
        webDriver.findElement(dropdownResult).click();
    }

    public void selectTimeframe(String timeframe) throws InterruptedException {
        Thread.sleep(2000);
        webDriver.findElement(timeframeDropdown).click();

        wait = new WebDriverWait(webDriver, 30);
        wait.until((ExpectedConditions.visibilityOfElementLocated(timeframeListItems)));

        List<WebElement> listItems = webDriver.findElements(timeframeListItems);

        for(WebElement listItem : listItems){
            if(listItem.getText().equals(timeframe)){
                listItem.click();
            }
        }
    }

    public void scrollToSection() throws InterruptedException {
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,350)", "");

    }

    public String getPercentualValueFromElement() {
        wait = new WebDriverWait(webDriver, 30);
        wait.until((ExpectedConditions.visibilityOfElementLocated(heatBar)));

        Actions actions = new Actions(webDriver);
        WebElement resultBar = webDriver.findElement(heatBar);

        actions.moveToElement(resultBar).build().perform();
        webDriver.switchTo().activeElement();
        return webDriver.findElement(percentResult).getText();

    }
}
