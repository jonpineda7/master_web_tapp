package app.pages.compraCartera;

import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static app.support.utils.CsvUtils.getDataFromCsv;

public class carteraActions {

    WaitUtils wu = new WaitUtils();

    public carteraActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // locators
    By causal = By.xpath("//input[@aria-label='Causal operación']");
    By ctaSol = By.xpath("//input[@aria-label='Cuotas solicitadas']");
    By calcMonto = By.xpath("//button[@aria-label='Datos crédito:Calcular monto']");
    By btnSimular = By.xpath("//button[@aria-label='Datos crédito:Simular']");
    By addCtaExt = By.xpath("//button[@aria-label='Cuentas externas:Nuevo']");
    By numCredExt = By.xpath("//input[@id='1_OCS_Numero_Credito']");
    By deudaTotalExt = By.xpath("//input[@id='1_OCS_Deuda_Total']");
    By instit = By.xpath("//input[@id='1_OCS_Institucion']");

    By monExcento = By.xpath("//input[@name='s_3_1_1_0']");
    By monAfecto = By.xpath("//input[@name='s_3_1_0_0']");
    By impuesto = By.xpath("//input[@name='s_3_1_2_0']");
    By tasaImp = By.xpath("//input[@name='s_3_1_3_0']");
    By fechaOtor = By.xpath("//input[@name='s_3_1_6_0']");

    By dt = By.xpath("//td[@id='1_s_1_l_OCS_Deuda_Total']");
    By in = By.xpath("//td[@id='1_s_1_l_OCS_Institucion']");
    By segCesCheck = By.xpath("//input[@aria-label='Seguro cesantía']");
    By sitLab = By.xpath("//input[@aria-label='Situación laboral']");
    By txtObjetivo = By.xpath("//input[@aria-label='Objetivo crédito']");
    By tappList = By.xpath("//input[@aria-label='Apertura TAPP']/following-sibling::span");
    By tappListFalse = By.xpath("//input[@aria-readonly='true' and @aria-label='Apertura TAPP']");
    By tappItem = By.xpath("//ul/li/div[contains(text(),'Cliente no quiere tarjeta TAPP')]");

    public void enterNewCcartera(String sheetName, int row) throws Exception {
        wu.fluentWait(addCtaExt).click();
        wu.waitForProcessingToComplete(2);
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 5), numCredExt);
        wu.waitForProcessingToComplete(2);
        wu.fluentWait(dt).click();
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 6), deudaTotalExt);
        wu.waitForProcessingToComplete(2);

        wu.fluentWait(in).click();
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 11), instit);
        wu.waitForProcessingToComplete(2);

        wu.fluentWait(monExcento).click();
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 12), monExcento);
        wu.waitForProcessingToComplete(2);

        wu.fluentWait(monAfecto).click();
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 13), monAfecto);
        wu.waitForProcessingToComplete(2);

        wu.fluentWait(impuesto).click();
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 14), impuesto);
        wu.waitForProcessingToComplete(2);

        wu.typeAndEnter(getDataFromCsv(sheetName, row, 15), tasaImp);
        wu.waitForProcessingToComplete(2);
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 16), fechaOtor);
        wu.waitForProcessingToComplete(2);
        // typeAndEnter(ReadFile.getCellValue(fileName, sheetName, row , 17),
        // monEfectivo);
        // Thread.sleep(2000);

        // fluentWait(causal).sendKeys("C");

        wu.typeAndEnter("Otra", causal);

        wu.waitForProcessingToComplete(2);
        wu.fluentWait(causal).sendKeys(Keys.ENTER);
        wu.waitForProcessingToComplete(2);
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 3), ctaSol);
        wu.waitForProcessingToComplete(2);
        wu.typeAndEnter("28Motivos personales/Otros", txtObjetivo);

        if (!wu.isElementPresent(tappListFalse)) {
            wu.waitForProcessingToComplete(2);
            wu.click(tappList);
            wu.click(tappItem);
            wu.waitForProcessingToComplete(2);
        }

        if (wu.checkSeguro(segCesCheck)) {
            // fluentWait(segCesCheck).click();
            wu.typeAndEnter(getDataFromCsv(sheetName, row, 19), sitLab);
            wu.fluentWait(calcMonto).click();
            wu.waitForProcessingToComplete(5);

        } else {
            wu.fluentWait(calcMonto).click();
            wu.waitForProcessingToComplete(5);
        }

        wu.fluentWait(btnSimular).click();
        wu.waitForProcessingToComplete(5);

    }
}
