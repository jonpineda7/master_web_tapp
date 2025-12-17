package app.pages.packs.oportunidad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.WebBasePage;

import static cl.automation.avattar.utils.CommonsHooks.getDataFromCsv;

public class oportunidadActions extends WebBasePage {


    public oportunidadActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //locators
    By cellAffiliationType = By.id("1_s_1_l_OCS_Tipo_Afiliacion");
    By iconAffiliationType = By.id("s_1_2_52_0_icon");
    By selectDropDown = By.xpath("//td[@class='siebui-popup-filter']/span[2]/span");

    By rutEmp = By.xpath("/html/body/ul[3]/li[2]/div");
    By inputTipoOper = By.xpath("//input[@id='1_OCS_Tipo_Operacion']");

    By iconProduct = By.id("s_1_2_47_0_icon");
    By searchProd = By.xpath("//button[@name='s_4_1_21_0']");
    By inputCprod = By.xpath("//input[@name='OCS_Codigo_Flexcube']");
    By buttonAccept = By.xpath("//div[@class='siebui-popup-btm']/span/button/span[text()='Aceptar']");
    By buttonAutomaticEconomicOffer = By.xpath("//button[@data-display='Oferta económica automática']");

    By linkOpportunities = By.xpath("//*[3]/a[contains(text(),'Oportunidades')]");
    By buttonOpportunitiesNew = By.id("s_1_1_7_0_Ctrl");
    By inputSearch = By.xpath("//td[@class='siebui-popup-filter']/span[4]/input");
    By columProd = By.id("1_s_1_l_OCS_Product_Name");

    public void NewOportunidad(String sheetName, int row) throws Exception {
        waitForProcessingToComplete(5);
        clickWhenReady(linkOpportunities);
        waitForProcessingToComplete(5);
        clickWhenReady(buttonOpportunitiesNew);
        waitForProcessingToComplete(2);

        if (!getDataFromCsv(sheetName, row, 4).equals("normal")) {
            doubleClick(inputTipoOper);
            //ingresa tipo de operacion distinto a venta normal
            typeAndEnter(getDataFromCsv(sheetName, row, 4), inputTipoOper);
        }

        //ingresa rut de empresa
        clickWhenReady(cellAffiliationType);
        clickWhenReady(iconAffiliationType);
        clickWhenReady(selectDropDown);
        clickWhenReady(rutEmp);
        waitForProcessingToComplete(2);
        //ingreso de producto
        typeAndEnter(getDataFromCsv(sheetName, row, 7), inputSearch);
        waitForProcessingToComplete(5);
        explicitWaitElementToBeClickable(columProd).click();
        clickWhenReady(iconProduct);
        waitForProcessingToComplete(2);
        clickWhenReady(searchProd);
        waitForProcessingToComplete(2);
        typeAndEnter(getDataFromCsv(sheetName, row, 8), inputCprod);
        System.out.println("se ingreso el producto: " +getDataFromCsv(sheetName, row, 8));
        waitForProcessingToComplete(2);
        clickWhenReady(buttonAccept);
        waitForProcessingToComplete(2);
        clickWhenReady(buttonAutomaticEconomicOffer);
        Thread.sleep(5000);

    }

}
