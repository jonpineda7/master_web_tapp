package app.pages.refinanciar;

import app.support.browsers.Browser;
import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static app.support.utils.CsvUtils.getDataFromCsv;

public class refinActions {

    WaitUtils wu = new WaitUtils();

    public refinActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // locators
    By ctaFinan = By.xpath("//button[@aria-label='Cuentas financieras:Nuevo']");

    By numCred = By.xpath("//span[@class='siebui-icon-pick']");
    By btnCtaFinanAceptar = By.xpath("//button[@data-display='Aceptar']");
    By causalRef = By.xpath("//input[@aria-label='Causal operación']");
    By ctaRef = By.xpath("//input[@aria-label='Cuotas solicitadas']");
    By calcMonto = By.xpath("//button[@aria-label='Datos crédito:Calcular monto']");
    By btnSimularRepa = By.xpath("//button[@aria-label='Datos crédito:Simular']");
    By segCesCheck = By.xpath("//input[@aria-label='Seguro cesantía']");
    By sitLab = By.xpath("//input[@aria-label='Situación laboral']");
    By txtObjetivo = By.xpath("//td[@valign='middle']/div/input[@aria-label='Objetivo crédito']");
    By tappList = By.xpath("//input[@aria-label='Apertura TAPP']/following-sibling::span");
    // *[@id="s_3_1_1_0_icon"]

    By flagCtaPlanilla = By.xpath("//tr/td/div/input[@aria-label='Cuotas Planilla']");

    By tappListFalse = By.xpath("//input[@aria-readonly='true' and @aria-label='Apertura TAPP']");
    By tappItem = By.xpath("//ul/li/div[contains(text(),'Cliente no quiere tarjeta TAPP')]");

    By montoEfec = By.xpath("//input[@aria-label='Monto efectivo']");

    public void enterDataNewRefin(String sheetName, int row) throws Exception {

        wu.explicitWaitElementToBeClickable(flagCtaPlanilla).click(); // marcar antes de agregar la cuenta financiera
                                                                      // para creditos vigentes norm o en mora
        wu.explicitWaitElementToBeClickable(ctaFinan).click();
        Thread.sleep(2000);
        wu.explicitWaitElementToBeClickable(numCred).click();
        Thread.sleep(2000);
        wu.explicitWaitElementToBeClickable(btnCtaFinanAceptar).click();
        Thread.sleep(2000);

        wu.typeAndEnter("Modificación carga con aumento", causalRef);

        Thread.sleep(2000);

        wu.typeAndEnter(getDataFromCsv(sheetName, row, 11), ctaRef);

        if (wu.checkSeguro(segCesCheck)) {
            // fluentWait(segCesCheck).click();
            wu.typeAndEnter(getDataFromCsv(sheetName, row, 19), sitLab);
            wu.fluentWait(calcMonto).click();
            Thread.sleep(5000);
        } else {
            wu.fluentWait(calcMonto).click();
            Thread.sleep(5000);
        }

        wu.typeAndEnter("28Motivos personales/Otros", txtObjetivo);

        if (!wu.isElementPresent(tappListFalse)) {
            Thread.sleep(2000);
            wu.click(tappList);
            wu.click(tappItem);
            Thread.sleep(2000);
        }

        wu.fluentWait(btnSimularRepa).click();
        Thread.sleep(5000);

    }

    public void RefinEfectivo(String sheetName, int row) throws Exception {

        wu.explicitWaitElementToBeClickable(flagCtaPlanilla).click(); // marcar antes de agregar la cuenta financiera
                                                                      // para creditos vigentes norm o en mora
        wu.explicitWaitElementToBeClickable(ctaFinan).click();
        Thread.sleep(2000);
        wu.explicitWaitElementToBeClickable(numCred).click();
        Thread.sleep(2000);
        wu.explicitWaitElementToBeClickable(btnCtaFinanAceptar).click();
        Thread.sleep(2000);

        wu.typeAndEnter("Modificación carga con aumento", causalRef);

        Thread.sleep(2000);

        wu.typeAndEnter(getDataFromCsv(sheetName, row, 11), ctaRef);
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 13), montoEfec);

        if (wu.checkSeguro(segCesCheck)) {
            // fluentWait(segCesCheck).click();
            wu.typeAndEnter(getDataFromCsv(sheetName, row, 19), sitLab);
            wu.fluentWait(calcMonto).click();
            Thread.sleep(5000);
        } else {
            wu.fluentWait(calcMonto).click();
            Thread.sleep(5000);
        }

        wu.typeAndEnter("28Motivos personales/Otros", txtObjetivo);

        if (!wu.isElementPresent(tappListFalse)) {
            Thread.sleep(2000);
            wu.click(tappList);
            wu.click(tappItem);
            Thread.sleep(2000);
        }

        wu.fluentWait(btnSimularRepa).click();
        Thread.sleep(5000);

    }
}
