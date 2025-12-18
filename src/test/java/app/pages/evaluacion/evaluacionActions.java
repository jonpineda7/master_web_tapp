package app.pages.evaluacion;

import app.support.browsers.Browser;
import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static app.support.utils.CsvUtils.getDataFromCsv;

public class evaluacionActions {

    WaitUtils wu = new WaitUtils();
    WebDriver driver;

    public evaluacionActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // locators
    By buttonAcceptSimulation = By.xpath("//button[@data-display='Aceptar']");
    By buttonEvaluate = By.xpath("//button[@data-display='Evaluar']");
    By inputCISerialNumber = By.xpath("//input[@aria-label='Número de serie CI']");
    By inputFixedAssets1 = By.xpath("//input[@aria-labelledby='OCSHabFi1_Label_2']");
    By folOferta = By.xpath("//input[contains(@aria-label,'Folio Oferta')]");
    By rutEvaluado = By.xpath("//input[contains(@aria-label,'RUT contacto')]");
    By DvRutEvaluado = By.xpath("//input[contains(@aria-label,'DV')]");

    public void entersimulationData(String sheetName, int row) throws Exception {
        try {
            wu.fluentWait(buttonAcceptSimulation).click();
            Thread.sleep(3000);
            WebElement elFixedAssets1 = driver.findElement(inputFixedAssets1);
            wu.waitForElementVisible(elFixedAssets1);
            wu.typeWithTab(getDataFromCsv(sheetName, row, 10), elFixedAssets1);

            WebElement elCISerialNumber = driver.findElement(inputCISerialNumber);
            wu.waitForElementVisible(elCISerialNumber);
            wu.typeWithTab(getDataFromCsv(sheetName, row, 2), elCISerialNumber);

            wu.explicitWaitElementToBeClickable(buttonEvaluate).click();
            wu.fluentWait(folOferta);
            wu.waitForProcessingToComplete(50); // ajustar tiempo segun problemas en ambiente
        } catch (TimeoutException e) {
            System.out.println("⚠️ **lentitud en sistema, proceso tarda mas de lo habitual** al intentar: ");
            // Hacemos que la prueba falle con un mensaje claro
            throw new Exception("Lentitud de sistema. Falló al intentar: ", e);
        }
    }

    public void vistaOferta() throws InterruptedException {
        Thread.sleep(5000);
        // isElementPresent(folOferta);
        wu.isElementDisplayed(folOferta);

        String folio = driver.findElement(folOferta).getAttribute("value");
        String rutEval = driver.findElement(rutEvaluado).getAttribute("value");
        String DvRut = driver.findElement(DvRutEvaluado).getAttribute("value");

        // Guardar RUT y Folio en WebBasePage - REMOVED LEGACY CALL
        // registrarRutYFolio(rutEval + "-" + DvRut, folio);
        System.out.println(" TODO: registrarRutYFolio was removed as WebBasePage is unimplemented. ");

        System.out.println("Folio creado número: " + folio);
    }

}
