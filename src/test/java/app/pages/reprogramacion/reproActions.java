package app.pages.packs.reprogramacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.WebBasePage;

import static cl.automation.avattar.utils.CommonsHooks.getDataFromCsv;


public class reproActions extends WebBasePage {

    public reproActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

//Locators
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

        fluentWait(ctaFinanciera).click();
        waitForProcessingToComplete(5);

        //fluentWait(despliegaLista).sendKeys("N");
        typeAndEnter("Nº de cuenta",despliegaLista);
        //fluentWait(despliegaLista).sendKeys(Keys.ENTER);

        type(getDataFromCsv(sheetName, row, 1), valorFiltro);

        waitForProcessingToComplete(2);
        fluentWait(cuentas);

        fluentWait(filtrar).click();
        waitForProcessingToComplete(2);
        fluentWait(btnSincronizar).click();

        waitForProcessingToComplete(15);
        fluentWait(btnReprogramar).click();
        waitForProcessingToComplete(20);

        typeAndEnter("Modificación carga sin aumento",causalOp);
        //fluentWait(causalOp).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        typeAndEnter("28Motivos personales/Otros",txtObjetivo);
        fluentWait(btnCalcMont).click();
        Thread.sleep(2000);
        fluentWait(btnSimular).click();
        Thread.sleep(2000);


    }
}
