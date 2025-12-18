package app.pages.riesgoDesembolso;

import app.support.browsers.Browser;
import app.support.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static app.support.utils.CsvUtils.getDataFromCsv;

public class riesgoDesembolsoActions {

    WaitUtils wu = new WaitUtils();
    WebDriver driver;

    public riesgoDesembolsoActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//*[@id=\'s_3_l\']") // Reemplaza con tu selector real
    protected WebElement tablaDoc;

    By aceptaOferta = By.xpath("//button[@data-display='Aceptar oferta']");

    By checkDoc = By.xpath("//a[contains(text(),'Check List Documentación')]");

    By menuEdicion = By.xpath("//span[contains(text(),'Edición')]");

    By cambiaReg = By.xpath("//li/a[contains(text(),'Cambiar registros')]");

    By Campo = By.xpath("//input[@aria-label='Campo 1']");

    By valor = By.xpath("//input[@aria-label='Valor 1']");

    By btnAceptarCambiaReg = By.xpath("//button[@data-display='Aceptar']");

    By btnAsignaRiesgo = By.xpath("//button[@data-display='Asignar a riesgo']");
    By btnAsignaXomision = By.xpath("//button[@data-display='Asignación a riesgo por omisión']");
    By btnAsignaComite = By.xpath("//button[@data-display='Asignar a comité superior']");

    By inpAlternativAsig = By.xpath("(//td[text()='N2 o N3'])[1]");

    By btnActivar = By.xpath("//button[@data-display='Activar']");

    By datosCobro = By.xpath("//li[8]/a[contains(text(),'Datos cobro-desembolso')]");

    By btnNuevoDblso = By.xpath("//button[@data-display='Nuevo']");

    By tdMedioDblso = By.xpath("//*[@id=\'1_s_2_l_OCS_Medio_de_Pago\']");
    By inpMedioDblso = By.xpath("//input[@name='OCS_Medio_de_Pago']");

    By tdSucursal = By.xpath("//*[@id=\'1_s_2_l_OCS_Sucursal\']"); // ingresar CASA MATRIZ para transf
    By inpSucursal = By.xpath("//input[@name='OCS_Sucursal']"); // ingresar CASA MATRIZ para transf

    By tdMonto = By.xpath("//*[@id=\'1_s_2_l_OCS_Monto_Desembolso\']");
    By inpMonto = By.xpath("//input[@name='OCS_Monto_Desembolso']");

    By tdCuenta = By.xpath("//*[@id=\'1_s_2_l_OCS_Numero_Cuenta\']");
    By inpCuenta = By.xpath("//input[@name='OCS_Numero_Cuenta']");

    By tdBanco = By.xpath("//*[@id=\'1_s_2_l_OCS_Banco\']");
    By inpBanco = By.xpath("//input[@name='OCS_Banco']");

    By tdTipoCuenta = By.xpath("//*[@id=\'1_s_2_l_OCS_Tipo_Cuenta\']");
    By inpTipoCuenta = By.xpath("//input[@name='OCS_Tipo_Cuenta']");

    By btnGuardaMedio = By.xpath("//*[@id=\'s_2_1_4_0_Ctrl\']");

    // localizadores cierre de actividad

    By subMenuActividades = By.xpath("//li[7]/a[contains(text(),'Actividades')]");

    // paso 1 copiar numero de actividad e ingreso a actividades

    @FindBy(xpath = "//td[@id='1_s_3_l_Activity_UID']/a") // Reemplaza con tu selector real
    protected WebElement actividadElemento;

    By MenuActividades = By.xpath("//li[5]/a[contains(text(),'Actividades')]");

    // paso 2 reasignar actividades / cambio de usuario

    By comBoxActividades = By.xpath("//select[@name='s_vis_div']");
    By opcReasigAct = By.xpath("//select[@name='s_vis_div']/option[contains(text(),'Reasignacion de actividades')]");

    By btnConsultaAct = By.xpath("//button[@aria-label='Actividades:Consulta']");
    By tdConsultAct = By.xpath("//td[@aria-roledescription='Nº de actividad']");

    @FindBy(xpath = "//input[@name='Activity_UID']") // Reemplaza con tu selector real
    protected WebElement inpConsultAct;

    By btnCambiaUsuario = By.xpath("//span[1][@aria-label='Seleccionar varios campos']");

    @FindBy(xpath = "//input[@title='Que empiece por']") // Reemplaza con tu selector real
    protected WebElement inpCambiaUsuario;

    By btnMoverUsuario = By.xpath("//button[1][@aria-label='Empleados:Agregar >']");
    By btnAceptarCambiaUsuario = By.xpath("//button[1][@aria-label='Empleados:Aceptar']");

    By user1 = By.xpath("//*[starts-with(@id, '1_s_')]/span[1]");

    By user2 = By.xpath("//*[starts-with(@id, '2_s_')]/span[1]");

    // paso 2 cierre de actividad
    By inpCambiaEstado = By.xpath("//td/div/input[@aria-label='Estado']");

    By tdFolioOferta = By.xpath("//td[@aria-roledescription='Folio Oferta']");

    // paso 3 volver a la oferta

    @FindBy(xpath = "//input[@aria-label='Que empiece por']") // Reemplaza con tu selector real
    protected WebElement inpFolio;

    By suMenuListaRiesgo = By.xpath("//*[@id=\'s_sctrl_tabView\']/ul/li[2]");
    By opcReasigActRiesgo = By.xpath("//select[@name='s_vis_div']/option[contains(text(),'Reasignación Superior')]");

    By inpBuscaIdRiesgo = By.xpath("//button[1][@data-display='Consulta']");

    @FindBy(xpath = "//input[@name='OCS_Activity_UID']") // Reemplaza con tu selector real
    protected WebElement inpID;

    @FindBy(xpath = "//*[@id=\'1_s_2_l_OCS_Activity_UID\']") // Reemplaza con tu selector real
    protected WebElement tdInpID;

    @FindBy(id = "1_s_1_l_OCS_Activity_UID") // Reemplaza con tu selector real
    protected WebElement idRiesgo;

    // aprobar actividad
    By btnAprobarRiesgo = By.xpath("//button[@data-display='Aprobar']");
    By ofertaEconomica = By.xpath("//td/a[@name='Nro Oferta Economica']");

    // mensajes de evaluacion NOK
    By linkEvaluacion = By.xpath("//li/a[contains(text(),'Resultados')]");

    By linkaOferta = By.xpath("//td[@aria-roledescription='Oferta económica']");

    @FindBy(xpath = "//table[@summary='Mensajes evaluación']") // Reemplaza con tu selector real
    protected WebElement tblMsje;

    By btnEdicionEval = By.xpath("//button[@aria-label='Mensajes evaluación:Menú']");
    By opcCambiaRegEval = By.xpath("//li[29]/a[contains(text(),'Cambiar registros')]");
    By btnAprobarEval = By.xpath("//button[@data-display='Aprobar']");
    By linkFolioOf = By.xpath("//td[@aria-roledescription='Folio oferta económica']");
    By linkFolioOf2 = By.xpath("//td[@aria-roledescription='Folio Oferta']");

    // vista principal actividades de riesgo

    By LinkVista = By.xpath("//*[@id=\'siebui-threadbar\']/li[1]/span/a");

    // bitacora firmas

    By linkBitacora = By.xpath("//li/a[contains(text(),'Bitácora de firmas')]");
    By btnRoll = By.xpath("//button[@data-display='Rollback']");
    By linkDetalles = By.xpath("//li/a[contains(text(),'Detalles')]");

    public void aceptaOferta() {
        try {
            // Buscar el botón en la página
            WebElement boton = driver.findElement(aceptaOferta);

            // Verificar si está habilitado
            if (boton.isEnabled()) {
                boton.click();
                System.out.println("Botón 'Aceptar oferta' presionado.");
                wu.waitForProcessingToComplete(100);
            } else {
                System.out.println("Botón 'Aceptar oferta' está deshabilitado.");
                wu.waitForProcessingToComplete(5);
            }
        } catch (Exception e) {
            System.out.println("No se encontró el botón 'Aceptar oferta'.");
        }

    }

    public void checkListDoc() {
        wu.clickWhenReady(checkDoc);
        wu.waitForProcessingToComplete(10);
        wu.selectAllText(driver, tablaDoc);
        wu.waitForProcessingToComplete(3);
        wu.clickWhenReady(menuEdicion);
        wu.waitForProcessingToComplete(3);
        wu.clickWhenReady(cambiaReg);
        wu.waitForProcessingToComplete(3);
        wu.type("Estado", Campo);
        wu.waitForProcessingToComplete(3);
        wu.type("Terminado", valor);
        wu.waitForProcessingToComplete(5);
        wu.clickWhenReady(btnAceptarCambiaReg);
        wu.waitForProcessingToComplete(5);

    }

    // FICO

    public void asignacionAriesgo() {
        wu.waitForProcessingToComplete(10);
        wu.scrollToBottomWithKeys();
        // Lista para almacenar botones activos
        List<WebElement> botonesActivos = new ArrayList<>();

        // Evaluar cada botón y agregarlo si está habilitado
        if (esBotonActivo(btnAsignaRiesgo)) {
            botonesActivos.add(driver.findElement(btnAsignaRiesgo));
        }
        if (esBotonActivo(btnAsignaXomision)) {
            botonesActivos.add(driver.findElement(btnAsignaXomision));
        }
        if (esBotonActivo(btnAsignaComite)) {
            botonesActivos.add(driver.findElement(btnAsignaComite));
        }

        // Si hay botones activos, seleccionar el adecuado y si es N o R
        if (!botonesActivos.isEmpty()) {
            WebElement botonASeleccionar = null;

            if (botonesActivos.size() == 1) {
                botonASeleccionar = botonesActivos.get(1);
            } else if (wu.isElementPresent(inpAlternativAsig)) {
                String textoAlt = driver.findElement(inpAlternativAsig).getText();
                if (textoAlt.contains("N2") || textoAlt.contains("N3")) {
                    wu.clickWhenReady(inpAlternativAsig);
                    botonASeleccionar = driver.findElement(btnAsignaRiesgo);
                }
            }

            // Presionar el botón
            botonASeleccionar.click();
            System.out.println("Botón presionado: " + botonASeleccionar.getAttribute("title"));
            wu.scrollToBottomWithKeys();
            wu.waitForProcessingToComplete(25);

        } else {
            System.out.println("Ningún botón para enviar a riesgo está habilitado.");
            aceptaOferta();

        }

    }

    public void asignacionRiesgo() {
        wu.waitForProcessingToComplete(10);
        wu.scrollToBottomWithKeys();

        List<WebElement> botonesActivos = new ArrayList<>();

        // Evaluación y llenado de la lista (esta parte está bien)
        if (esBotonActivo(btnAsignaRiesgo)) {
            botonesActivos.add(driver.findElement(btnAsignaRiesgo));
        }
        if (esBotonActivo(btnAsignaXomision)) {
            botonesActivos.add(driver.findElement(btnAsignaXomision));
        }
        if (esBotonActivo(btnAsignaComite)) {
            botonesActivos.add(driver.findElement(btnAsignaComite));
        }

        if (!botonesActivos.isEmpty()) {
            WebElement botonASeleccionar = null;

            if (botonesActivos.size() == 1) {
                // CORRECCIÓN: Usar índice 0
                botonASeleccionar = botonesActivos.get(0);
            } else if (wu.isElementPresent(inpAlternativAsig)) {
                String textoAlt = driver.findElement(inpAlternativAsig).getText();
                if (textoAlt.contains("N2") || textoAlt.contains("N3")) {
                    wu.clickWhenReady(inpAlternativAsig);
                    botonASeleccionar = driver.findElement(btnAsignaRiesgo);
                }
            }

            // REFUERZO: Solo presionar el botón si se seleccionó uno (no es null)
            if (botonASeleccionar != null) {
                botonASeleccionar.click();
                System.out.println("Botón presionado: " + botonASeleccionar.getAttribute("title"));
                wu.scrollToBottomWithKeys();
                wu.waitForProcessingToComplete(25);
            } else {
                // Este es el caso donde hay varios botones, pero la lógica N2/N3 no se cumplió.
                System.out.println(
                        "ADVERTENCIA: Hay múltiples botones activos, pero la lógica de selección no asignó un botón.");
                // Aquí podrías añadir una lógica de selección por defecto si es necesario.
                aceptaOferta();
            }

        } else {
            System.out.println("Ningún botón para enviar a riesgo está habilitado.");
            aceptaOferta();
        }
    }

    // Método para verificar si un botón está habilitado
    private boolean esBotonActivo(By locator) {
        try {
            WebElement boton = driver.findElement(locator);
            return boton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void activaOferta() {
        wu.clickWhenReady(datosCobro);
        // isElementPresent(btnActivar);
        wu.waitForProcessingToComplete(10);
        wu.clickWhenReady(btnActivar);
        wu.waitForProcessingToComplete(30);
        wu.aceptarPopup(driver);
        // waitForProcessingToComplete(10);

    }

    public void activaOfertaOK() {
        wu.clickWhenReady(datosCobro);
        // isElementPresent(btnActivar);
        wu.waitForProcessingToComplete(10);
        wu.clickWhenReady(btnActivar);
        wu.waitForProcessingToComplete(100);
        wu.aceptarPopup(driver);
        System.out.println("Credito activado correctamente");

    }

    public void vistaActivaOferta() {
        wu.clickWhenReady(datosCobro);
        wu.isElementPresent(btnActivar);
        // clickWhenReady(btnActivar);
        // waitForProcessingToComplete(100);
        // aceptarPopup(driver);
        wu.waitForProcessingToComplete(10);
        System.out.println("listo para activar");

    }

    public void popUp() {

        wu.isElementPresent(btnActivar);
        wu.clickWhenReady(btnActivar);
        wu.waitForProcessingToComplete(50);
        wu.aceptarPopup(driver);
        wu.waitForProcessingToComplete(10);

    }

    public void popUp2() {

        wu.aceptarPopup(driver);
        wu.waitForProcessingToComplete(10);

    }

    public void AgregaDesembolso(String sheetName, int row) throws Exception {

        System.out.println("ingresando desembolso de $" + getDataFromCsv(sheetName, row, 9));
        wu.clickWhenReady(datosCobro);
        wu.clickWhenReady(btnNuevoDblso);

        wu.clickWhenReady(tdMedioDblso);
        wu.typeAndEnter("Transferencia Electrónica", inpMedioDblso);

        wu.clickWhenReady(tdSucursal);
        wu.type("CASA MATRIZ", inpSucursal);
        wu.waitForProcessingToComplete(5);

        wu.clickWhenReady(tdMonto);
        wu.waitForProcessingToComplete(5);

        wu.type(getDataFromCsv(sheetName, row, 9), inpMonto);

        wu.waitForProcessingToComplete(5);

        wu.clickWhenReady(tdCuenta);
        wu.type("123456789", inpCuenta);

        wu.clickWhenReady(tdBanco);
        wu.type("De Chile", inpBanco);

        wu.clickWhenReady(tdTipoCuenta);
        wu.type("Cuenta Corriente", inpTipoCuenta);

        wu.clickWhenReady(btnGuardaMedio);

        wu.isElementPresent(btnActivar);

        wu.waitForProcessingToComplete(10);

    }

    public void AgregaDesembolsoRefEfectivo(String sheetName, int row) throws Exception {
        System.out.println("paso 1");
        System.out.println("ingresando efectivo a refinanciamiento de $" + getDataFromCsv(sheetName, row, 13));
        wu.clickWhenReady(datosCobro);
        System.out.println("paso datscobro ok");
        wu.clickWhenReady(btnNuevoDblso);
        System.out.println("paso btnscobro ok");
        wu.waitForProcessingToComplete(10);
        wu.clickWhenReady(tdMedioDblso);
        System.out.println("paso medio ok");
        wu.typeAndEnter("Transferencia Electrónica", inpMedioDblso);
        System.out.println("paso 2");
        wu.clickWhenReady(tdSucursal);
        wu.type("DIGITAL", inpSucursal);
        wu.waitForProcessingToComplete(5);

        wu.clickWhenReady(tdMonto);
        wu.waitForProcessingToComplete(5);
        System.out.println("paso 3");
        wu.type(getDataFromCsv(sheetName, row, 13), inpMonto);

        wu.waitForProcessingToComplete(5);

        wu.clickWhenReady(tdCuenta);
        wu.type("123456789", inpCuenta);

        wu.clickWhenReady(tdBanco);
        wu.type("De Chile", inpBanco);

        wu.clickWhenReady(tdTipoCuenta);
        wu.type("Cuenta Corriente", inpTipoCuenta);

        wu.clickWhenReady(btnGuardaMedio);
        System.out.println("paso 4");

        wu.isElementPresent(btnActivar);

        wu.waitForProcessingToComplete(10);

    }

    public void reasignaRiesgo() {
        // scrollToBottomWithKeys();
        // waitForProcessingToComplete(5);

        wu.waitForProcessingToComplete(25);
        // copiar id riesgo
        String idRiesgo = driver.findElement(By.id("1_s_1_l_OCS_Activity_UID")).getText();
        System.out.println("ID actividad riesgo: " + idRiesgo);

        wu.clickWhenReady(MenuActividades);
        wu.waitForProcessingToComplete(5);

        wu.clickWhenReady(suMenuListaRiesgo);
        wu.waitForProcessingToComplete(5);

        wu.clickWhenReady(comBoxActividades);
        wu.clickWhenReady(opcReasigActRiesgo);
        wu.waitForProcessingToComplete(5);
        wu.clickWhenReady(inpBuscaIdRiesgo);
        wu.waitForProcessingToComplete(5);
        inpID.sendKeys(idRiesgo);
        wu.pressEnter(driver);

        wu.waitForProcessingToComplete(5);
        wu.clickWhenReady(btnCambiaUsuario);
        wu.waitForProcessingToComplete(10);
        inpCambiaUsuario.sendKeys("AUTOMA");
        wu.pressEnter(driver);
        wu.waitForProcessingToComplete(5);

        wu.click(user1);
        wu.waitForProcessingToComplete(2);
        wu.click(user1);
        wu.waitForProcessingToComplete(2);
        wu.click(user2);
        wu.waitForProcessingToComplete(2);
        // clickWhenReady(btnMoverUsuario);
        wu.clickWhenReady(btnAceptarCambiaUsuario);
        System.out.println("reasignado ok");

        wu.waitForProcessingToComplete(15);

    }

    public void apruebaRiesgo() {
        tdInpID.click();
        wu.waitForProcessingToComplete(15);
        driver.navigate().back();
        wu.waitForProcessingToComplete(15);
        tdInpID.click();
        // refrescar sino probar volver atras e ingresar a la actividad
        // driver.navigate().refresh();
        wu.waitForProcessingToComplete(10);
        wu.clickWhenReady(btnAprobarRiesgo);
        wu.waitForProcessingToComplete(10);
        wu.clickWhenReady(ofertaEconomica);
        wu.waitForProcessingToComplete(5);

    }

    public void apruebaRiesgoRepa() {
        tdInpID.click();
        wu.waitForProcessingToComplete(15);
        driver.navigate().back();
        wu.waitForProcessingToComplete(15);
        tdInpID.click();
        wu.waitForProcessingToComplete(10);

        wu.clickWhenReady(btnAprobarRiesgo);
        wu.waitForProcessingToComplete(10);
        if (wu.isAlertPresent()) {
            wu.aceptarPopup(driver);
            wu.waitForProcessingToComplete(5);
            wu.click(linkEvaluacion);
            wu.waitForProcessingToComplete(5);
            wu.selectAllText(driver, tblMsje);
            wu.waitForProcessingToComplete(5);
            wu.click(btnEdicionEval);
            wu.waitForProcessingToComplete(5);
            wu.click(opcCambiaRegEval);

            wu.waitForProcessingToComplete(3);
            wu.type("N3", Campo);
            wu.waitForProcessingToComplete(3);
            wu.type("OK", valor);
            wu.waitForProcessingToComplete(5);

            wu.waitForProcessingToComplete(5);
            wu.clickWhenReady(btnAceptarCambiaReg);
            wu.waitForProcessingToComplete(5);
            wu.click(btnAprobarEval);
            wu.waitForProcessingToComplete(5);

            wu.click(LinkVista);

            // driver.navigate().back();
            // waitForProcessingToComplete(10);
            // driver.navigate().back();

            //// driver.navigate().back();
            wu.waitForProcessingToComplete(10);// revisar desde aca

        } else {
            // driver.navigate().back();
            wu.click(LinkVista);
            wu.waitForProcessingToComplete(10);
        }

        wu.clickWhenReady(linkFolioOf);
        wu.waitForProcessingToComplete(10);
        wu.clickWhenReady(linkFolioOf2);
        wu.waitForProcessingToComplete(10);

    }

    // gestion aca usuario x0vcuenca

    public void cerrarActividadesACA() {

        // pasos para llegar a menu actividad
        wu.waitForProcessingToComplete(5);
        // copia actividad
        wu.clickWhenReady(subMenuActividades);
        wu.waitForProcessingToComplete(10);
        wu.performScrollDownWebELement(actividadElemento);
        wu.waitForProcessingToComplete(5);
        String numeroActividad = actividadElemento.getText();
        System.out.println("Número de actividad: " + numeroActividad);

        // ir a menu actividad
        wu.clickWhenReady(MenuActividades);
        wu.waitForProcessingToComplete(10);
        // asociar la actividad a usuario

        // elegir reasignar actividades de combobox
        wu.clickWhenReady(comBoxActividades);
        wu.waitForProcessingToComplete(5);
        wu.clickWhenReady(opcReasigAct);
        wu.waitForProcessingToComplete(5);

        // pegar el id de la actividad
        wu.clickWhenReady(btnConsultaAct);
        wu.waitForProcessingToComplete(5);
        wu.clickWhenReady(tdConsultAct);
        wu.waitForProcessingToComplete(5);
        inpConsultAct.click();
        inpConsultAct.sendKeys(numeroActividad);
        wu.pressEnter(driver);
        wu.waitForProcessingToComplete(5);

        // cambia usuario
        wu.clickWhenReady(btnCambiaUsuario);
        wu.waitForProcessingToComplete(10);
        inpCambiaUsuario.sendKeys("AUTOMA");
        wu.waitForProcessingToComplete(5);
        wu.pressEnter(driver);
        wu.waitForProcessingToComplete(5);
        wu.clickWhenReady(btnMoverUsuario);
        wu.waitForProcessingToComplete(5);
        wu.clickWhenReady(btnAceptarCambiaUsuario);
        wu.waitForProcessingToComplete(10);

        wu.clickWhenReady(tdConsultAct);
        wu.waitForProcessingToComplete(10);
        driver.navigate().back();
        wu.waitForProcessingToComplete(10);
        wu.clickWhenReady(tdConsultAct);
        wu.waitForProcessingToComplete(10);

        // String folio = driver.findElement(numFolio).getAttribute("value");

        wu.doubleClick(inpCambiaEstado);
        wu.typeAndEnter("Terminado", inpCambiaEstado);
        wu.waitForProcessingToComplete(5);

        driver.navigate().back();
        wu.waitForProcessingToComplete(3);

        // volver a la oferta econimica
        wu.clickWhenReady(linkaOferta);
        // System.out.println("volviendo a ofertas con el idFOlio: "+folio);
        wu.waitForProcessingToComplete(10);

        wu.clickWhenReady(tdFolioOferta);
        wu.waitForProcessingToComplete(10);

    }

    public void rollBack() {
        wu.clickWhenReady(linkBitacora);
        wu.waitForProcessingToComplete(5);
        wu.clickWhenReady(btnRoll);
        wu.waitForProcessingToComplete(10);
        wu.clickWhenReady(linkDetalles);
        wu.waitForProcessingToComplete(5);
    }

}
