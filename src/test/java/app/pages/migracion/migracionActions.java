package app.pages.packs.migracion;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.WebBasePage;

import static cl.automation.avattar.utils.CommonsHooks.getDataFromCsv;

public class migracionActions extends WebBasePage {
    public migracionActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Locators
    By labelWelcome = By.id("s_3_l_salutation");
    By cuentas = By.xpath("//div[@id='a_1']/div/div");

    By ctaFinanciera = By.xpath("//a[contains(.,'Cuentas financieras')]");
    By btnSincronizar = By.xpath("(//span[contains(.,'Sincronizar')])[2]");
    By despliegaLista = By.xpath("//input[@aria-label='Buscar']");
    By valorFiltro = By.xpath("//input[contains(@aria-label,'Que empiece por')]");
    By filtrar = By.xpath("//button[contains(@id,'s_1_1_0_0_Ctrl')]");
    By ctaFin = By.xpath("//td[@id=\'1_s_1_l_Account_Number\']/a[@name='Account Number']");

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[3]/td[9]/div/input")
    public WebElement rut;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[3]/td[3]/div/input")
    public WebElement cuenta;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[4]/td[9]/div/input")
    public WebElement cuota;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[3]/td[13]/div/input")
    public WebElement monto;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[6]/td[9]/div/input")
    public WebElement intAnual;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[5]/td[10]/div/input")
    public WebElement intMensual;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[4]/td[5]/div/input")
    public WebElement estado;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[15]/td[5]/div/input")
    public WebElement caeOriginal;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[15]/td[7]/div/input")
    public WebElement caeSinSeg;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[4]/td[7]/div/input")
    public WebElement apellidoP;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[5]/td[8]/div/input")
    public WebElement apellidoM;

    @FindBy(xpath = "//*[@id=\'a_1\']/div/table/tbody/tr[6]/td[7]/div/input")
    public WebElement nombre;

    @FindBy(xpath = "//input[@aria-label='Sucursal de solicitud']")
    public WebElement sucSolic;

    @FindBy(xpath = "//input[@aria-label='Producto']")
    public WebElement producto;

    @FindBy(xpath = "//input[@aria-label='Tipo de moneda']")
    public WebElement moneda;

    @FindBy(xpath = "//input[@aria-label='Impuestos']")
    public WebElement monImpuesto;

    @FindBy(xpath = "//input[@aria-label='Monto gasto notarial']")
    public WebElement gastoNot;

    @FindBy(xpath = "//input[@aria-label='Monto proyección']")
    public WebElement monProyec;

    @FindBy(xpath = "//input[@aria-label='Capital inicial']")
    public WebElement capInicial;


    By btnUltimaCuota = By.xpath("//td[@id='last_pager_s_2_l']");

    @FindBy(xpath = "(//td[@aria-roledescription='Num. Cuo.'])[last()]")
    //(//td[@aria-roledescription='Num. Cuo.'])[last()]
    //(//table[@id='s_2_l']//td[@aria-roledescription='Num. Cuo.'])[last()]
    public WebElement inpUltimaCuota;


    By btnCuadroPago = By.xpath("//a[contains(text(),'Detalle cuadro de pago')]");


    @FindBy(xpath = "//input[@aria-label='# Cuotas morosas']")
    public WebElement inpCmoroso;

    @FindBy(xpath = "//input[@aria-label='# Cuotas pagadas']")
    public WebElement inpCpagadas;




    public void cFinanciera(String sheetName, int row) {


            // Obtenemos el número de cuenta primero para usarlo en el mensaje de error si es necesario
            String numeroCuenta = getDataFromCsv(sheetName, row, 1);

            try {
                fluentWait(ctaFinanciera).click();
                waitForProcessingToComplete(5);

                typeAndEnter("Nº de cuenta", despliegaLista);
                type(numeroCuenta, valorFiltro);
                waitForProcessingToComplete(2);

                // Se asume que 'cuentas' es el contenedor de los resultados del filtro
                fluentWait(cuentas);

                fluentWait(filtrar).click();
                waitForProcessingToComplete(2);

                fluentWait(btnSincronizar).click();
                waitForProcessingToComplete(15);

                // Punto crítico: si la cuenta no existe, esta línea fallará
                clickWhenReady(ctaFin);
                waitForProcessingToComplete(10);

                System.out.println("Éxito: Se encontró y se hizo clic en la cuenta: " + numeroCuenta);

            } catch (NoSuchElementException | TimeoutException e) {
                // Este bloque se ejecuta si cualquier fluentWait o clickWhenReady no encuentra el elemento
                System.err.println("FINALIZANDO PRUEBA: No se encontró el número de cuenta '" + ctaFin + "' después de aplicar el filtro.");

                // Opción A: Lanza una excepción para que el framework de pruebas (JUnit/TestNG) la marque como fallida.
                // Esta es la MEJOR PRÁCTICA.
                throw new RuntimeException("No se encontró el número de cuenta: " + ctaFin, e);

                // Opción B: Termina abruptamente todo el proceso Java. (No recomendado para tests)
                // System.exit(1);

        }

    }


  public String validarRegistros(String RutEsperado, String cuentaEsperado,String PlazoEsperado,String estadoEsperado,String montoEsperado,
                                   String sucEsperado,String cProdEsperado,String monedaEsperado,String mImpEsperado,String mGasEsperado,
                                   String mProyEsperado,String capIniEsperado) {




        StringBuilder resultado = new StringBuilder();

        String rutResp = rut.getAttribute("value").trim().replace(".", "");
        String cuentaResp = cuenta.getAttribute("value").trim();
        String cuotaResp = cuota.getAttribute("value").trim();
        String estadoResp = estado.getAttribute("value").trim();
        String montoResp = monto.getAttribute("value").trim().replace(".", "");
        String sucResp = sucSolic.getAttribute("value").trim();
        String cProdResp = producto.getAttribute("value").trim();
        String monedaResp = moneda.getAttribute("value").trim();
        String mImpResp = monImpuesto.getAttribute("value").trim().replace(".", "");
        String mGasResp = gastoNot.getAttribute("value").trim().replace(".", "");
        String mProyResp = monProyec.getAttribute("value").trim().replace(".", "");
        String capIniResp = capInicial.getAttribute("value").trim().replace(".", "");


        //String caeOriginalResp = caeOriginal.getAttribute("value").trim().replace(",", ".");
        //String caeSinSegResp = caeSinSeg.getAttribute("value").trim().replace(",", ".");
        //String apellidoPResp = apellidoP.getAttribute("value").trim();
        //String apellidoMResp = apellidoM.getAttribute("value").trim();
        //String nombreResp = nombre.getAttribute("value").trim();
        //String intAnualResp = intAnual.getAttribute("value").trim().replace(",", ".");
        //String intMensualResp = intMensual.getAttribute("value").trim().replace(",", ".");



        if (!rutResp.equals(RutEsperado)) {
            resultado.append("Rut NOK (esperado: ").append(RutEsperado).append("| encontrado: ").append(rutResp).append("),");
        }

        if (!cuentaResp.equals(cuentaEsperado)) {
            resultado.append("Cuenta NOK (esperado: ").append(cuentaEsperado).append("| encontrado: ").append(cuentaResp).append("),");
        }

        if (!cuotaResp.equals(PlazoEsperado)) {
            resultado.append("PLazo NOK (esperado: ").append(PlazoEsperado).append("| encontrado: ").append(cuotaResp).append("),");
        }
       /* if (!intAnualResp.equals(intAnualEsperado)) {
            resultado.append("intAnual NOK (esperado: ").append(intAnualEsperado).append("| encontrado: ,").append(intAnualResp).append(",); ");
        }

        if (!intMensualResp.equals(intMensualEsperado)) {
            resultado.append("intMensual NOK (esperado: ").append(intMensualEsperado).append("| encontrado: ,").append(intMensualResp).append(",); ");
        }*/

        if (!estadoResp.equals(estadoEsperado)) {
            resultado.append("estado NOK (esperado: ").append(estadoEsperado).append("| encontrado: ").append(estadoResp).append("),");
        }

        if (!montoResp.equals(montoEsperado)) {
            resultado.append("monto NOK (esperado: ").append(montoEsperado).append("| encontrado: ").append(montoResp).append("),");
        }

        if (!sucResp.equals(sucEsperado)) {
            resultado.append("sucursal NOK (esperado: ").append(sucEsperado).append("| encontrado: ").append(sucResp).append("),");
        }

        if (!cProdResp.equals(cProdEsperado)) {
            resultado.append("cProd NOK (esperado: ").append(cProdEsperado).append("| encontrado: ").append(cProdResp).append(");,");
        }

        if (!monedaResp.equals(monedaEsperado)) {
            resultado.append("moneda NOK (esperado: ").append(monedaEsperado).append("| encontrado: ").append(monedaResp).append("),");
        }

        if (!mImpResp.equals(mImpEsperado)) {
            resultado.append("mImp NOK (esperado: ").append(mImpEsperado).append("| encontrado: ").append(mImpResp).append("),");
        }

        if (!mGasResp.equals(mGasEsperado)) {
            resultado.append("mGas NOK (esperado: ").append(mGasEsperado).append("| encontrado: ").append(mGasResp).append("),");
        }

        if (!mProyResp.equals(mProyEsperado)) {
            resultado.append("mProy NOK (esperado: ").append(mProyEsperado).append("| encontrado: ").append(mProyResp).append("),");
        }

        if (!capIniResp.equals(capIniEsperado)) {
            resultado.append("capIni NOK (esperado: ").append(capIniEsperado).append("| encontrado: ").append(capIniResp).append("),");
        }


       /* if (!caeOriginalResp.equals(caeOriginalEsperado)) {
            resultado.append("caeOriginal NOK (esperado: ").append(caeOriginalEsperado).append("| encontrado: ,").append(caeOriginalResp).append(",); ");
        }

        if (!caeSinSegResp.equals(caeSinSegEsperado)) {
            resultado.append("caeSinSeg NOK (esperado: ").append(caeSinSegEsperado).append("| encontrado: ,").append(caeSinSegResp).append(",); ");
        }*/

       /* if (!apellidoPResp.equals(apellidoPEsperado)) {
            resultado.append("apellidoP NOK (esperado: ").append(apellidoPEsperado).append("| encontrado: ,").append(apellidoPResp).append(",); ");
        }
        if (!apellidoMResp.equals(apellidoMEsperado)) {
            resultado.append("apellidoM NOK (esperado: ").append(apellidoMEsperado).append("| encontrado: ,").append(apellidoMResp).append(",); ");
        }

        if (!nombreResp.equals(nombreEsperado)) {
            resultado.append("nombre NOK (esperado: ").append(nombreEsperado).append("| encontrado: ,").append(nombreResp).append(",); ");
        }*/



        return resultado.length() == 0 ? "MIGRACION OK" : resultado.toString();
    }

    public void cPago(){
        fluentWait(btnCuadroPago).click();
        waitForProcessingToComplete(10);
        if(!isElementPresent(btnUltimaCuota)){
            System.out.println("boton tabla no presente");
        }else {
            clickWhenReady(btnUltimaCuota);
            waitForProcessingToComplete(5);
        }

       /* inpUltimaCuota.click();
        waitForProcessingToComplete(5);*/
    }


    public String validaCuadroPago(String ultimaCuotaEsperada, String cMorosoEsperada, String cPagadaEsperada) {


        StringBuilder resultado = new StringBuilder();

        // Solo los campos visibles en esta página
        String UltimaCuotaResp = inpUltimaCuota.getText().trim();
        String inpCmorosoResp = inpCmoroso.getAttribute("value").trim();
        String inpCpagadasResp = inpCpagadas.getAttribute("value").trim();


        if (!UltimaCuotaResp.equals(ultimaCuotaEsperada)) {
            resultado.append("Cantidad de fila-cuota NOK (esperado: ")
                    .append(ultimaCuotaEsperada)
                    .append(" | encontrado: ,")
                    .append(UltimaCuotaResp)
                    .append(",); ");
        }

        if (!inpCmorosoResp.equals(cMorosoEsperada)) {
            resultado.append("Cuotas en mora NOK (esperado: ")
                    .append(cMorosoEsperada)
                    .append(" | encontrado: ,")
                    .append(inpCmorosoResp)
                    .append(",); ");
        }

        if (!inpCpagadasResp.equals(cPagadaEsperada)) {
            resultado.append("Cuotas pagadas NOK (esperado: ")
                    .append(cPagadaEsperada)
                    .append(" | encontrado: ,")
                    .append(inpCpagadasResp)
                    .append(",); ");
        }

        return resultado.length() == 0 ? "OK" : resultado.toString();
    }
}
