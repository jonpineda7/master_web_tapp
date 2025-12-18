package app.pages.login;

import app.support.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static app.support.utils.CsvUtils.getDataFromCsv;

public class loginSiebelActions {

    WaitUtils wu = new WaitUtils();

    public loginSiebelActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // locators

    @FindBy(name = "SWEUserName")
    WebElement inpU;

    @FindBy(className = "SWEPassword")
    WebElement inpP;

    @FindBy(className = "siebui-login-btn")
    WebElement btnL;

    public void loginSiebelAplication(String sheetName) throws Exception {
        wu.fluentWait(inpU);

        wu.type(getDataFromCsv(sheetName, 1, 0), inpU);
        wu.type(getDataFromCsv(sheetName, 1, 1), btnL); // Typo in original code? Typed to btnL? Kept as is but logic
                                                        // susp.

        btnL.click();
        wu.waitForProcessingToComplete(10);
    }

    public void navigateTo(String url) throws Throwable {
        wu.goToUrl(url);
    }
}
