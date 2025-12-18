package app.pages.reprogramacion;

import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static app.support.utils.CsvUtils.getDataFromCsv;

public class reproActions {

    WaitUtils wu = new WaitUtils();

    public reproActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Locators
    By cuentas = By.xpath("//div[@id='a_1']/div/div");

    By ctaFinanciera = By.xpath("//a[contains(.,'Cuentas financieras')]");
    By btnSincronizar = By.xpath("(//span[contains(.,'Sincronizar')])[2]");
    By despliegaLista = By.xpath("//input[@aria-label='Buscar']");
    By valorFiltro = By.xpath("//input[contains(@aria-label,'Que empiece por')]");
    By filtrar = By.xpath("//button[contains(@id,'s_1_1_0_0_Ctrl')]");
    By btnReprogramar = By.xpath("//button[@aria-label='Cuentas:Reprogramar']");
    By btnCalcMont = By.xpath("//button[@data-display='Calcular monto']");
    By btnSimular = By.xpath("//button[@aria-label='Datos crédito:Simular']");
    By causalOp = By.xpath("//input[@aria-label='Causal operación']");

    By txtObjetivo = By.xpath("//input[@aria-label='Objetivo crédito']");

    public void irReprogramar(String sheetName, int row) throws Exception {

        wu.fluentWait(ctaFinanciera).click();
        wu.waitForProcessingToComplete(5);

        // fluentWait(despliegaLista).sendKeys("N");
        wu.typeAndEnter("Nº de cuenta", despliegaLista);
        // fluentWait(despliegaLista).sendKeys(Keys.ENTER);

        wu.type(getDataFromCsv(sheetName, row, 1), valorFiltro);

        wu.waitForProcessingToComplete(2);
        wu.fluentWait(cuentas);

        wu.fluentWait(filtrar).click();
        wu.waitForProcessingToComplete(2);
        wu.fluentWait(btnSincronizar).click();

        wu.waitForProcessingToComplete(15);
        wu.fluentWait(btnReprogramar).click();
        wu.waitForProcessingToComplete(20);

        wu.typeAndEnter("Modificación carga sin aumento", causalOp);
        // fluentWait(causalOp).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        wu.typeAndEnter("28Motivos personales/Otros", txtObjetivo);
        wu.fluentWait(btnCalcMont).click();
        Thread.sleep(2000);
        wu.fluentWait(btnSimular).click();
        Thread.sleep(2000);

    }
}
