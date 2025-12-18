package app.pages.oportunidad;

import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static app.support.utils.CsvUtils.getDataFromCsv;

public class oportunidadActions {

    WaitUtils wu = new WaitUtils();

    public oportunidadActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // locators
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
        wu.waitForProcessingToComplete(5);
        wu.clickWhenReady(linkOpportunities);
        wu.waitForProcessingToComplete(5);
        wu.clickWhenReady(buttonOpportunitiesNew);
        wu.waitForProcessingToComplete(2);

        if (!getDataFromCsv(sheetName, row, 4).equals("normal")) {
            wu.doubleClick(inputTipoOper);
            // ingresa tipo de operacion distinto a venta normal
            wu.typeAndEnter(getDataFromCsv(sheetName, row, 4), inputTipoOper);
        }

        // ingresa rut de empresa
        wu.clickWhenReady(cellAffiliationType);
        wu.clickWhenReady(iconAffiliationType);
        wu.clickWhenReady(selectDropDown);
        wu.clickWhenReady(rutEmp);
        wu.waitForProcessingToComplete(2);
        // ingreso de producto
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 7), inputSearch);
        wu.waitForProcessingToComplete(5);
        wu.explicitWaitElementToBeClickable(columProd).click();
        wu.clickWhenReady(iconProduct);
        wu.waitForProcessingToComplete(2);
        wu.clickWhenReady(searchProd);
        wu.waitForProcessingToComplete(2);
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 8), inputCprod);
        System.out.println("se ingreso el producto: " + getDataFromCsv(sheetName, row, 8));
        wu.waitForProcessingToComplete(2);
        wu.clickWhenReady(buttonAccept);
        wu.waitForProcessingToComplete(2);
        wu.clickWhenReady(buttonAutomaticEconomicOffer);
        Thread.sleep(5000);

    }

}
