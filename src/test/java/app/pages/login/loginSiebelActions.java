package app.pages.packs.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.WebBasePage;

import static cl.automation.avattar.utils.CommonsHooks.getDataFromCsv;


public class loginSiebelActions extends WebBasePage {


    public loginSiebelActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //locators

    @FindBy(name = "SWEUserName")
    WebElement inpU;

    @FindBy(className = "SWEPassword")
    WebElement inpP;

    @FindBy(className = "siebui-login-btn")
    WebElement btnL;

    public void loginSiebelAplication(String sheetName) throws Exception {
        fluentWait(inpU);

        type(getDataFromCsv(sheetName, 1, 0), inpU);
        type(getDataFromCsv(sheetName, 1, 1), btnL);

        btnL.click();
        waitForProcessingToComplete(10);
    }

    public void navigateTo(String url) throws Throwable {
        goToUrl(url);
    }
}
