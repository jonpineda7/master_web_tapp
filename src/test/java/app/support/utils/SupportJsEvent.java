package app.support.utils;

import app.support.browsers.Browser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SupportJsEvent {

    /**
     * Metodo para hacer click en un elemento
     * */
    public static void clickElement(WebElement e){
        JavascriptExecutor executor = (JavascriptExecutor) Browser.getDriver();
        executor.executeScript("arguments[0].click();", e);
    }
}
