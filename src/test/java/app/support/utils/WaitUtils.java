package app.support.utils;

import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;
import consolecolor.ColorConsole;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import report.Report;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitUtils {

    private final int explicitWait = Integer.parseInt(LoadProperty.CONFIGURATION.getProperty("explicitWait"));

    /**
     * This method is for static wait
     *
     * @param millis
     */
    public void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
            System.out.println(ColorConsole.ANSI_WHITE + "Tiempo de espera: " + millis + ColorConsole.ANSI_RESET);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * To wait for element to be invisible
     *
     * @param ele -> WebElement
     */
    public boolean waitForElementInvisible(final WebElement ele) {
        boolean a = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(explicitWait))
                .until(ExpectedConditions.invisibilityOf(ele));
        if (a) {
            System.out.println(
                    ColorConsole.ANSI_RED + "Se visualiza elemento: " + ele.toString() + ColorConsole.ANSI_RESET);
        } else {
            System.out.println(
                    ColorConsole.ANSI_GREEN + "No se visualiza elemento: " + ele.toString() + ColorConsole.ANSI_RESET);
        }
        return a;
    }

    /**
     * To wait for given element to be present
     *
     * @param ele -> WebElement
     */
    public boolean waitForElementPresent(final WebElement ele) {

        WebElement el = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(explicitWait))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ele.toString())));

        if (el != null) {
            System.out.println(
                    ColorConsole.ANSI_GREEN + "Se elemento presente: " + ele.toString() + ColorConsole.ANSI_RESET);
            return true;
        } else {
            System.out.println(
                    ColorConsole.ANSI_RED + "No se presenta elemento: " + ele.toString() + ColorConsole.ANSI_RESET);
            return false;
        }
    }

    /**
     * To wait for element to be visible
     *
     * @param ele -> WebElement
     */
    public boolean waitForElementVisible(WebElement ele) {
        WebElement el = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(explicitWait))
                .until(ExpectedConditions.visibilityOf(ele));
        if (el != null) {
            System.out.println(ColorConsole.ANSI_GREEN + "Se visualiza elemento: " + ele.toString() + ".\n contenido: "
                    + ele.getText() + ColorConsole.ANSI_RESET);
            return true;
        } else {
            System.out.println(
                    ColorConsole.ANSI_RED + "No se visualiza elemento: " + ele.toString() + ColorConsole.ANSI_RESET);
            return false;
        }
    }

    /**
     * Get only number for String
     */
    public Integer getNumber(String text) {
        char[] cade = text.toCharArray();
        String n = "";
        for (Integer i = 0; i < cade.length; i++) {
            if (Character.isDigit(cade[i])) {
                n += cade[i];
            }
        }
        return Integer.parseInt(n);
    }

    /**
     * Scroll down
     */
    public void scrollDown(WebElement element) throws Exception {
        try {
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) Browser.getDriver();

            js.executeScript("window.scrollBy(0," + (element.getSize().height) + ")");
        } catch (Exception e) {
            Report.FAILED("No se logro realizar el scroll.");
        }
    }

    /**
     * Se realiza mas de un scroll por la medida del elemento seleccionado
     */
    public void scrollDown(WebElement element, int cant) throws Exception {
        try {
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) Browser.getDriver();
            for (int i = 0; i <= cant; i++) {
                js.executeScript("window.scrollBy(0," + (element.getSize().height) + ")");
            }
        } catch (Exception e) {
            Report.FAILED("No se logro realizar el scroll.");
        }
    }

    /**
     * Wait for element to be clickable
     */
    public WebElement waitForElementClickable(WebElement ele) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(explicitWait))
                .until(ExpectedConditions.elementToBeClickable(ele));
    }

    /**
     * Wait for element to be clickable by Locator
     */
    public WebElement waitForElementClickable(By locator) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(explicitWait))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isElementPresent(By locator) {
        try {
            Browser.getDriver().findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement ele) {
        try {
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void type(WebElement element, String text) {
        waitForElementVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void type(By locator, String text) {
        WebElement element = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(explicitWait))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void type(String text, By locator) { // Overload for convenience
        type(locator, text);
    }

    public void type(String text, WebElement element) { // Overload for convenience
        type(element, text);
    }

    public void typeAndEnter(String text, WebElement element) {
        waitForElementVisible(element);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(org.openqa.selenium.Keys.ENTER);
    }

    public void typeAndEnter(String text, By locator) {
        WebElement element = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(explicitWait))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        element.sendKeys(org.openqa.selenium.Keys.ENTER);
    }

    public void click(WebElement element) {
        waitForElementClickable(element).click();
    }

    public void click(By locator) {
        waitForElementClickable(locator).click();
    }

    public boolean isElementSelected(By locator) {
        try {
            return Browser.getDriver().findElement(locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    // Compat methods
    public WebElement fluentWait(By locator) {
        return waitForElementClickable(locator);
    }

    public WebElement fluentWait(WebElement element) {
        return waitForElementClickable(element);
    }

    public WebElement explicitWaitElementToBeClickable(By locator) {
        return waitForElementClickable(locator);
    }

    public boolean checkSeguro(By locator) {
        return isElementSelected(locator);
    }

    public void waitForProcessingToComplete(int seconds) {
        staticWait(seconds * 1000L);
    }

    public void clickWhenReady(By locator) {
        waitForElementClickable(locator).click();
    }

    public void clickWhenReady(WebElement element) {
        waitForElementClickable(element).click();
    }

    public void clickWhenIsReady(By locator) {
        waitForElementClickable(locator).click();
    }

    public void clickWhenIsReady(WebElement element) {
        waitForElementClickable(element).click();
    }

    public void write(WebElement element, String text) {
        type(element, text);
    }

    public void typing(String text, WebElement element) {
        type(element, text);
    }

    public void clickElement(WebElement element) {
        click(element);
    }

    public boolean elementIsNotPresent(WebElement element) {
        return !isElementPresent(element);
    }

    public void pressEnter(WebDriver driver) {
        new org.openqa.selenium.interactions.Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
    }

    public void setInputValue(WebElement element, String value, String logMsg) {
        type(element, value);
        System.out.println(logMsg);
    }

    public void doubleClick(By locator) {
        WebElement element = waitForElementClickable(locator);
        new org.openqa.selenium.interactions.Actions(Browser.getDriver()).doubleClick(element).perform();
    }

    public void typeWithTab(String text, WebElement element) {
        waitForElementVisible(element);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(org.openqa.selenium.Keys.TAB);
    }

    public void goToUrl(String url) {
        Browser.getDriver().get(url);
    }

    public void isElementDisplayed(By locator) {
        waitForElementVisible(Browser.getDriver().findElement(locator));
    }

    public void performScrollDown(WebElement element) {
        ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void performScrollDownWebELement(WebElement element) {
        performScrollDown(element);
    }

    public void scrollToBottomWithKeys() {
        new org.openqa.selenium.interactions.Actions(Browser.getDriver()).sendKeys(org.openqa.selenium.Keys.END)
                .perform();
    }

    public void aceptarPopup(WebDriver driver) {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
        }
    }

    public boolean isAlertPresent() {
        try {
            Browser.getDriver().switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void selectAllText(WebDriver driver, WebElement element) {
        new org.openqa.selenium.interactions.Actions(driver).click(element)
                .keyDown(org.openqa.selenium.Keys.COMMAND) // or CONTROL, assuming mac
                .sendKeys("a")
                .keyUp(org.openqa.selenium.Keys.COMMAND)
                .perform();
    }

    public void selectOptionDropDown(By locator, String value) {
        type(value, locator);
        pressEnter(Browser.getDriver());
    }

}
