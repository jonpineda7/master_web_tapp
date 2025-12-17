package app.pages.packs.repactacion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.WebBasePage;

import static cl.automation.avattar.utils.CommonsHooks.getDataFromCsv;


public class RepactacionActions extends WebBasePage {
    public RepactacionActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //locators
    By ctaFinan = By.xpath("//*[@id='s_4_1_10_0_Ctrl']");
    By numCred = By.xpath("//*[@id='s_4_2_30_0_icon']");
    By btnCtaFinanAceptar = By.xpath("//button[@data-display='Aceptar']");
    By causalRepa = By.xpath("//input[@aria-label='Causal operación']");
    By ctaRepa = By.xpath("//input[@aria-label='Cuotas solicitadas']");
    By calcMonto= By.xpath("//button[@data-display='Calcular monto']");
    By btnSimularRepa = By.xpath("//button[@data-display='Simular']");
    By segCesCheck = By.xpath("//input[@aria-label='Seguro cesantía']");
    By sitLab = By.xpath("//input[@name='s_5_1_0_0']");
    By objetivoCre = By.xpath("//input[@aria-label='Objetivo crédito']");

    public void enterDataNewRepactacion(String sheetName, int row) throws Exception {

        explicitWaitElementToBeClickable(ctaFinan).click();
        explicitWaitElementToBeClickable(numCred).click();
        Thread.sleep(3000);
        explicitWaitElementToBeClickable(btnCtaFinanAceptar).click();
        Thread.sleep(5000);
        fluentWait(causalRepa).sendKeys("C");
        Thread.sleep(3000);
        fluentWait(causalRepa).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        typeAndEnter("28Motivos personales/Otros",objetivoCre);
        Thread.sleep(3000);
        typeAndEnter(getDataFromCsv(sheetName, row , 11), ctaRepa);

        if (checkSeguro(segCesCheck)){
            //fluentWait(segCesCheck).click();
            typeAndEnter(getDataFromCsv(sheetName, row , 19), sitLab);
            fluentWait(calcMonto).click();
            Thread.sleep(5000);
        }
        else{
            fluentWait(calcMonto).click();
            Thread.sleep(5000);
        }

        fluentWait(btnSimularRepa).click();
        Thread.sleep(5000);


    }

}
