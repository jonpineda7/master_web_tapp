package app.pages.packs.compraCartera;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.WebBasePage;

import static cl.automation.avattar.utils.CommonsHooks.getDataFromCsv;


public class carteraActions extends WebBasePage {

    public carteraActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //locators
    By causal = By.xpath("//input[@aria-label='Causal operación']");
    By ctaSol = By.xpath("//input[@aria-label='Cuotas solicitadas']");
    By calcMonto= By.xpath("//button[@aria-label='Datos crédito:Calcular monto']");
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
        fluentWait(addCtaExt).click();
        waitForProcessingToComplete(2);
        typeAndEnter(getDataFromCsv(sheetName, row , 5), numCredExt);
        waitForProcessingToComplete(2);
        fluentWait(dt).click();
        typeAndEnter(getDataFromCsv(sheetName, row , 6), deudaTotalExt);
        waitForProcessingToComplete(2);

        fluentWait(in).click();
        typeAndEnter(getDataFromCsv(sheetName,  row , 11), instit);
        waitForProcessingToComplete(2);

        fluentWait(monExcento).click();
        typeAndEnter(getDataFromCsv(sheetName, row , 12), monExcento);
        waitForProcessingToComplete(2);

        fluentWait(monAfecto).click();
        typeAndEnter(getDataFromCsv(sheetName, row , 13), monAfecto);
        waitForProcessingToComplete(2);

        fluentWait(impuesto).click();
        typeAndEnter(getDataFromCsv(sheetName, row , 14), impuesto);
        waitForProcessingToComplete(2);

        typeAndEnter(getDataFromCsv(sheetName, row , 15), tasaImp);
        waitForProcessingToComplete(2);
        typeAndEnter(getDataFromCsv(sheetName, row , 16), fechaOtor);
        waitForProcessingToComplete(2);
        //typeAndEnter(ReadFile.getCellValue(fileName, sheetName, row , 17), monEfectivo);
        //Thread.sleep(2000);

        //fluentWait(causal).sendKeys("C");

        typeAndEnter("Otra",causal);

        waitForProcessingToComplete(2);
        fluentWait(causal).sendKeys(Keys.ENTER);
        waitForProcessingToComplete(2);
        typeAndEnter(getDataFromCsv(sheetName, row , 3), ctaSol);
        waitForProcessingToComplete(2);
        typeAndEnter("28Motivos personales/Otros",txtObjetivo);

        if(!isElementPresent(tappListFalse)){
            waitForProcessingToComplete(2);
            click(tappList);
            click(tappItem);
            waitForProcessingToComplete(2);
        }

        if (checkSeguro(segCesCheck)){
            //fluentWait(segCesCheck).click();
            typeAndEnter(getDataFromCsv(sheetName, row , 19), sitLab);
            fluentWait(calcMonto).click();
            waitForProcessingToComplete(5);

        }
        else{
            fluentWait(calcMonto).click();
            waitForProcessingToComplete(5);
        }

        fluentWait(btnSimular).click();
        waitForProcessingToComplete(5);


    }
}
