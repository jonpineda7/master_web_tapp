package app.pages.ventaNormalPage;

import app.pages.ventaNormalPage.ventaNormalActions;
import app.support.browsers.Browser;
import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static app.support.utils.CsvUtils.getDataFromCsv;

public class ventaNormalActions {

    WaitUtils wu = new WaitUtils();
    WebDriver driver;

    public ventaNormalActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    By labelWelcome = By.id("s_3_l_salutation");
    By inputRut = By.name("s_1_1_2_0");
    By buttonGo = By.name("s_1_1_0_0");
    By linkRut = By.xpath("//table[@id='s_1_l']/tbody/tr[2]/td[2]/a");
    By linkOpportunities = By.id("s_3_1_18_0_mb");
    By buttonOpportunitiesNew = By.id("s_1_1_7_0_Ctrl");
    By cellAffiliationType = By.id("1_s_1_l_OCS_Tipo_Afiliacion");
    By iconAffiliationType = By.id("s_1_2_52_0_icon");
    By selectDropDown = By.xpath("//td[@class='siebui-popup-filter']/span[2]/span");
    By tipoContrato = By.xpath("/html/body/ul[3]/li[10]/div");
    By inputSearch = By.xpath("//td[@class='siebui-popup-filter']/span[4]/input");
    By cellProduct = By.id("1_s_1_l_OCS_Product_Name");
    By iconProduct = By.id("s_1_2_47_0_icon");
    By cellCON1 = By.xpath("//td[@id='2_s_4_l_OCS_Codigo_Flexcube']");
    By buttonAccept = By.xpath("//div[@class='siebui-popup-btm']/span/button/span[text()='Aceptar']");
    By buttonAutomaticEconomicOffer = By.xpath("//button[@data-display='Oferta económica automática']");
    By inputRequestedAmount = By.xpath("//input[@aria-label='Monto solicitado']");
    By inputRequestedQuotas = By.xpath("//input[@aria-label='Cuotas solicitadas']");
    By buttonSimulate = By.xpath("//button[@data-display='Simular']");
    By buttonAcceptSimulation = By.xpath("//button[@data-display='Aceptar']");
    By inputFixedAssets1 = By.name("s_2_1_9_0");
    By inputFixedAssets2 = By.name("s_2_1_10_0");
    By inputFixedAssets3 = By.name("s_2_1_11_0");
    By inputCISerialNumber = By.xpath("//input[@aria-label='Número de serie CI']");
    By buttonEvaluate = By.xpath("//button[@data-display='Evaluar']");
    By segCesCheck = By.xpath("//input[@aria-label='Seguro cesantía']");// objeto en venta nrmal
    By sitLab = By.xpath("//*[contains(@aria-label, 'Situ')]");// objeto en venta nrmal
    By objetivo = By.xpath("//*[@id=\"a_3\"]/div/table/tbody/tr[4]/td[9]/div/input");
    By tapp = By.xpath("//td[@valign='middle']/div/input[@aria-label='Apertura TAPP']");

    By tappList = By.xpath("//input[@aria-label='Apertura TAPP']/following-sibling::span");
    // *[@id="s_3_1_1_0_icon"]

    By tappItem = By.xpath("//ul/li/div[contains(text(),'Cliente no quiere tarjeta TAPP')]");

    By objetivoList = By.xpath(
            "/html/body/div[1]/div/div[6]/div/div[7]/div/div[1]/div/div[3]/div[2]/div/form/div/span/div[3]/div/div/table/tbody/tr[7]/td[5]/div/span");
    By itemObjetivo = By.xpath("/html/body/div[1]/div/div[6]/div/div[7]/ul[6]/li[8]/div");
    By txtObjetivo = By.xpath("//input[@aria-label='Objetivo crédito']");

    By lblEstudiante = By.xpath("//span[contains(text(),'Antecedentes académicos')]");
    By inpInstEdu = By.xpath("//input[@aria-label='Institución educacional']");
    By inpTipoUni = By.xpath("//input[@aria-label='Tipo universidad']");
    By inpCarrera = By.xpath("//input[@aria-label='Carrera']");
    By inpAnnioAcad = By.xpath("//input[@aria-label='Año academico']");
    By inpSemAcad = By.xpath("//input[@aria-label='Semestre académico']");
    By inpAnnioCar = By.xpath("//input[@aria-label='Total años carrera']");
    By inpArancel = By.xpath("//input[@aria-label='Valor arancel']");
    By inpMatricula = By.xpath("//input[@aria-label='Valor matricula']");

    By tappListFalse = By.xpath("//input[@aria-readonly='true' and @aria-label='Apertura TAPP']");

    public void selectMenuOption(String menuOption) {
        wu.fluentWait(labelWelcome);
        driver.findElement(By.xpath("//div[@id='s_sctrl_tabScreen']/ul/li[contains(.,'" + menuOption + "')]")).click();
    }

    public void selectSubMenuOption(String subMenuOption) {
        wu.fluentWait(By.xpath("//div[@id='s_sctrl_tabView']/ul/li[contains(.,'" + subMenuOption + "')][1]"));
        driver.findElement(By.xpath("//div[@id='s_sctrl_tabView']/ul/li[contains(.,'" + subMenuOption + "')][1]"))
                .click();
    }

    public void enterRut(String sheetName, int row) throws Exception {
        wu.fluentWait(inputRut);
        wu.type(getDataFromCsv(sheetName, row, 0), inputRut);
        wu.click(buttonGo);
        wu.fluentWait(linkRut).click();
    }

    public void selectNewOpportunity() throws InterruptedException {
        wu.fluentWait(linkOpportunities).click();
        wu.fluentWait(buttonOpportunitiesNew).click();
        Thread.sleep(2000);
    }

    public void enterDataNewOpportunity(String sheetName, int row) throws Exception {
        wu.explicitWaitElementToBeClickable(cellAffiliationType).click();
        wu.click(iconAffiliationType);
        Thread.sleep(2000);
        wu.selectOptionDropDown(selectDropDown, getDataFromCsv(sheetName, 0, 1));
        wu.click(selectDropDown);
        // Thread.sleep(2000);
        // click(tipoContrato);
        Thread.sleep(2000);
        wu.typeAndEnter(getDataFromCsv(sheetName, row, 1), inputSearch);
        wu.explicitWaitElementToBeClickable(cellProduct).click();
        wu.click(iconProduct);
        Thread.sleep(2000);
        wu.click(cellCON1);
        wu.click(buttonAccept);
        Thread.sleep(3000);
        wu.fluentWait(buttonAutomaticEconomicOffer).click();
    }

    public void enterCreditData(String sheetName, int row) throws Exception {

        wu.fluentWait(inputRequestedAmount);
        wu.typeWithTab(getDataFromCsv(sheetName, row, 9), driver.findElement(inputRequestedAmount));
        wu.typeWithTab(getDataFromCsv(sheetName, row, 3), driver.findElement(inputRequestedQuotas));

        if (wu.checkSeguro(segCesCheck)) {
            // fluentWait(segCesCheck).click();
            wu.typeAndEnter(getDataFromCsv(sheetName, row, 19), sitLab);
            // fluentWait(calcMonto).click();
            Thread.sleep(3000);
        } else {
            // fluentWait(calcMonto).click();
            System.out.println("No requiere seguro segun regla de negocio");
            Thread.sleep(2000);
        }

        // click(objetivoList);
        // click(itemObjetivo);
        wu.typeAndEnter("28Motivos personales/Otros", txtObjetivo);

        Thread.sleep(2000);

        if (!wu.isElementPresent(tappListFalse)) {
            Thread.sleep(2000);
            wu.click(tappList);
            wu.click(tappItem);
            Thread.sleep(2000);
        }

        Thread.sleep(2000);

        if (wu.isElementPresent(lblEstudiante)) {

            wu.typeWithTab("UNIVERSIDAD SAN SEBASTIAN", driver.findElement(inpInstEdu));

            wu.typeAndEnter("Centro de Formación Técnica", inpTipoUni);

            wu.typeAndEnter("otra", inpCarrera);

            wu.typeAndEnter("1", inpAnnioAcad);

            wu.typeAndEnter("1", inpSemAcad);

            wu.typeAndEnter("1", inpAnnioCar);

            wu.typeAndEnter("1000000", inpArancel);

            wu.typeAndEnter("500000", inpMatricula);

        } else {
            System.out.println("Elemento no presente");
        }
        wu.performScrollDown(driver.findElement(buttonSimulate));
        // click(buttonSimulate);
        wu.clickWhenReady(buttonSimulate);
    }

    public void entersimulationData(String sheetName, int row) throws Exception {
        wu.fluentWait(buttonAcceptSimulation).click();
        wu.typeWithTab(getDataFromCsv(sheetName, row, 10), driver.findElement(inputFixedAssets1));
        wu.typeWithTab(getDataFromCsv(sheetName, row, 2), driver.findElement(inputCISerialNumber));
        wu.explicitWaitElementToBeClickable(buttonEvaluate).click();
        Thread.sleep(25000);
    }

}
