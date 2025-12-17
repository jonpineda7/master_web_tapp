package app.pages.packs.riesgoDesembolso;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.WebBasePage;

import java.util.ArrayList;
import java.util.List;

import static cl.automation.avattar.utils.CommonsHooks.getDataFromCsv;

public class riesgoDesembolsoActions extends WebBasePage {

    public riesgoDesembolsoActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//*[@id=\'s_3_l\']")  // Reemplaza con tu selector real
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

    By tdSucursal = By.xpath("//*[@id=\'1_s_2_l_OCS_Sucursal\']"); //ingresar CASA MATRIZ para transf
    By inpSucursal = By.xpath("//input[@name='OCS_Sucursal']"); //ingresar CASA MATRIZ para transf

    By tdMonto = By.xpath("//*[@id=\'1_s_2_l_OCS_Monto_Desembolso\']");
    By inpMonto = By.xpath("//input[@name='OCS_Monto_Desembolso']");

    By tdCuenta = By.xpath("//*[@id=\'1_s_2_l_OCS_Numero_Cuenta\']");
    By inpCuenta = By.xpath("//input[@name='OCS_Numero_Cuenta']");

    By tdBanco = By.xpath("//*[@id=\'1_s_2_l_OCS_Banco\']");
    By inpBanco = By.xpath("//input[@name='OCS_Banco']");

    By tdTipoCuenta = By.xpath("//*[@id=\'1_s_2_l_OCS_Tipo_Cuenta\']");
    By inpTipoCuenta = By.xpath("//input[@name='OCS_Tipo_Cuenta']");

    By btnGuardaMedio = By.xpath("//*[@id=\'s_2_1_4_0_Ctrl\']");

    //localizadores cierre de actividad

    By subMenuActividades = By.xpath("//li[7]/a[contains(text(),'Actividades')]");


    //paso 1 copiar numero de actividad e ingreso a actividades

    @FindBy(xpath = "//td[@id='1_s_3_l_Activity_UID']/a")  // Reemplaza con tu selector real
    protected WebElement actividadElemento;

    By MenuActividades = By.xpath("//li[5]/a[contains(text(),'Actividades')]");


    //paso 2 reasignar actividades / cambio de usuario


    By comBoxActividades = By.xpath("//select[@name='s_vis_div']");
    By opcReasigAct = By.xpath("//select[@name='s_vis_div']/option[contains(text(),'Reasignacion de actividades')]");

    By btnConsultaAct = By.xpath("//button[@aria-label='Actividades:Consulta']");
    By tdConsultAct = By.xpath("//td[@aria-roledescription='Nº de actividad']");

    @FindBy(xpath = "//input[@name='Activity_UID']")  // Reemplaza con tu selector real
    protected WebElement inpConsultAct;


    By btnCambiaUsuario = By.xpath("//span[1][@aria-label='Seleccionar varios campos']");

    @FindBy(xpath = "//input[@title='Que empiece por']")  // Reemplaza con tu selector real
    protected WebElement inpCambiaUsuario;

    By btnMoverUsuario = By.xpath("//button[1][@aria-label='Empleados:Agregar >']");
    By btnAceptarCambiaUsuario = By.xpath("//button[1][@aria-label='Empleados:Aceptar']");


    By user1 = By.xpath("//*[starts-with(@id, '1_s_')]/span[1]");

    By user2 = By.xpath("//*[starts-with(@id, '2_s_')]/span[1]");


    //paso 2 cierre de actividad
    By inpCambiaEstado = By.xpath("//td/div/input[@aria-label='Estado']");

    By tdFolioOferta = By.xpath("//td[@aria-roledescription='Folio Oferta']");

//paso 3 volver a la oferta




    @FindBy(xpath = "//input[@aria-label='Que empiece por']")  // Reemplaza con tu selector real
    protected WebElement inpFolio;



    By suMenuListaRiesgo = By.xpath("//*[@id=\'s_sctrl_tabView\']/ul/li[2]");
    By opcReasigActRiesgo = By.xpath("//select[@name='s_vis_div']/option[contains(text(),'Reasignación Superior')]");

    By inpBuscaIdRiesgo = By.xpath("//button[1][@data-display='Consulta']");

    @FindBy(xpath = "//input[@name='OCS_Activity_UID']")  // Reemplaza con tu selector real
    protected WebElement inpID;

    @FindBy(xpath = "//*[@id=\'1_s_2_l_OCS_Activity_UID\']")  // Reemplaza con tu selector real
    protected WebElement tdInpID;


    @FindBy(id = "1_s_1_l_OCS_Activity_UID")  // Reemplaza con tu selector real
    protected WebElement idRiesgo;

    //aprobar actividad
    By btnAprobarRiesgo = By.xpath("//button[@data-display='Aprobar']");
    By ofertaEconomica = By.xpath("//td/a[@name='Nro Oferta Economica']");

    //mensajes de evaluacion NOK
    By linkEvaluacion= By.xpath("//li/a[contains(text(),'Resultados')]");

    By linkaOferta = By.xpath("//td[@aria-roledescription='Oferta económica']");

    @FindBy(xpath = "//table[@summary='Mensajes evaluación']")  // Reemplaza con tu selector real
    protected WebElement tblMsje;

    By btnEdicionEval = By.xpath("//button[@aria-label='Mensajes evaluación:Menú']");
    By opcCambiaRegEval = By.xpath("//li[29]/a[contains(text(),'Cambiar registros')]");
    By btnAprobarEval = By.xpath("//button[@data-display='Aprobar']");
    By linkFolioOf = By.xpath("//td[@aria-roledescription='Folio oferta económica']");
    By linkFolioOf2 = By.xpath("//td[@aria-roledescription='Folio Oferta']");

    //vista principal actividades de riesgo

    By LinkVista = By.xpath("//*[@id=\'siebui-threadbar\']/li[1]/span/a");

    //bitacora firmas

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
                waitForProcessingToComplete(100);
            } else {
                System.out.println("Botón 'Aceptar oferta' está deshabilitado.");
                waitForProcessingToComplete(5);
            }
        } catch (Exception e) {
            System.out.println("No se encontró el botón 'Aceptar oferta'.");
        }

    }


    public void checkListDoc() {
        clickWhenReady(checkDoc);
        waitForProcessingToComplete(10);
        selectAllText(driver, tablaDoc);
        waitForProcessingToComplete(3);
        clickWhenReady(menuEdicion);
        waitForProcessingToComplete(3);
        clickWhenReady(cambiaReg);
        waitForProcessingToComplete(3);
        type("Estado", Campo);
        waitForProcessingToComplete(3);
        type("Terminado", valor);
        waitForProcessingToComplete(5);
        clickWhenReady(btnAceptarCambiaReg);
        waitForProcessingToComplete(5);

    }

//FICO

    public void asignacionAriesgo() {
        waitForProcessingToComplete(10);
        scrollToBottomWithKeys();
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
            WebElement botonASeleccionar=null;

            if (botonesActivos.size() == 1) {
                botonASeleccionar = botonesActivos.get(1);
            } else if (isElementPresent(inpAlternativAsig)) {
                String textoAlt = driver.findElement(inpAlternativAsig).getText();
                if (textoAlt.contains("N2") || textoAlt.contains("N3")) {
                    clickWhenReady(inpAlternativAsig);
                    botonASeleccionar = driver.findElement(btnAsignaRiesgo);
                }
            }

            // Presionar el botón
            botonASeleccionar.click();
            System.out.println("Botón presionado: " + botonASeleccionar.getAttribute("title"));
            scrollToBottomWithKeys();
            waitForProcessingToComplete(25);

        } else {
            System.out.println("Ningún botón para enviar a riesgo está habilitado.");
            aceptaOferta();


        }

    }

    public void asignacionRiesgo() {
        waitForProcessingToComplete(10);
        scrollToBottomWithKeys();

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
            } else if (isElementPresent(inpAlternativAsig)) {
                String textoAlt = driver.findElement(inpAlternativAsig).getText();
                if (textoAlt.contains("N2") || textoAlt.contains("N3")) {
                    clickWhenReady(inpAlternativAsig);
                    botonASeleccionar = driver.findElement(btnAsignaRiesgo);
                }
            }

            // REFUERZO: Solo presionar el botón si se seleccionó uno (no es null)
            if (botonASeleccionar != null) {
                botonASeleccionar.click();
                System.out.println("Botón presionado: " + botonASeleccionar.getAttribute("title"));
                scrollToBottomWithKeys();
                waitForProcessingToComplete(25);
            } else {
                // Este es el caso donde hay varios botones, pero la lógica N2/N3 no se cumplió.
                System.out.println("ADVERTENCIA: Hay múltiples botones activos, pero la lógica de selección no asignó un botón.");
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
        clickWhenReady(datosCobro);
        //isElementPresent(btnActivar);
        waitForProcessingToComplete(10);
        clickWhenReady(btnActivar);
        waitForProcessingToComplete(30);
        aceptarPopup(driver);
        //waitForProcessingToComplete(10);

    }

    public void activaOfertaOK() {
        clickWhenReady(datosCobro);
        //isElementPresent(btnActivar);
        waitForProcessingToComplete(10);
        clickWhenReady(btnActivar);
        waitForProcessingToComplete(100);
        aceptarPopup(driver);
        System.out.println("Credito activado correctamente");

    }

    public void vistaActivaOferta() {
        clickWhenReady(datosCobro);
        isElementPresent(btnActivar);
        //clickWhenReady(btnActivar);
        //waitForProcessingToComplete(100);
        //aceptarPopup(driver);
        waitForProcessingToComplete(10);
        System.out.println("listo para activar");


    }

    public void popUp() {

        isElementPresent(btnActivar);
        clickWhenReady(btnActivar);
        waitForProcessingToComplete(50);
        aceptarPopup(driver);
        waitForProcessingToComplete(10);


    }

    public void popUp2() {


        aceptarPopup(driver);
        waitForProcessingToComplete(10);


    }


    public void AgregaDesembolso(String sheetName, int row) throws Exception {

        System.out.println("ingresando desembolso de $" + getDataFromCsv(sheetName, row, 9));
        clickWhenReady(datosCobro);
        clickWhenReady(btnNuevoDblso);

        clickWhenReady(tdMedioDblso);
        typeAndEnter("Transferencia Electrónica", inpMedioDblso);

        clickWhenReady(tdSucursal);
        type("CASA MATRIZ", inpSucursal);
        waitForProcessingToComplete(5);

        clickWhenReady(tdMonto);
        waitForProcessingToComplete(5);

        type(getDataFromCsv(sheetName, row, 9), inpMonto);

        waitForProcessingToComplete(5);

        clickWhenReady(tdCuenta);
        type("123456789", inpCuenta);

        clickWhenReady(tdBanco);
        type("De Chile", inpBanco);

        clickWhenReady(tdTipoCuenta);
        type("Cuenta Corriente", inpTipoCuenta);

        clickWhenReady(btnGuardaMedio);

        isElementPresent(btnActivar);

        waitForProcessingToComplete(10);

    }

    public void AgregaDesembolsoRefEfectivo(String sheetName, int row) throws Exception {
        System.out.println("paso 1");
        System.out.println("ingresando efectivo a refinanciamiento de $" + getDataFromCsv(sheetName, row, 13));
        clickWhenReady(datosCobro);System.out.println("paso datscobro ok");
        clickWhenReady(btnNuevoDblso);System.out.println("paso btnscobro ok");
    waitForProcessingToComplete(10);
        clickWhenReady(tdMedioDblso);System.out.println("paso medio ok");
        typeAndEnter("Transferencia Electrónica", inpMedioDblso);
        System.out.println("paso 2");
        clickWhenReady(tdSucursal);
        type("DIGITAL", inpSucursal);
        waitForProcessingToComplete(5);

        clickWhenReady(tdMonto);
        waitForProcessingToComplete(5);
        System.out.println("paso 3");
        type(getDataFromCsv(sheetName, row, 13), inpMonto);

        waitForProcessingToComplete(5);

        clickWhenReady(tdCuenta);
        type("123456789", inpCuenta);

        clickWhenReady(tdBanco);
        type("De Chile", inpBanco);

        clickWhenReady(tdTipoCuenta);
        type("Cuenta Corriente", inpTipoCuenta);

        clickWhenReady(btnGuardaMedio);
        System.out.println("paso 4");

        isElementPresent(btnActivar);

        waitForProcessingToComplete(10);

    }



    public void reasignaRiesgo() {
        //scrollToBottomWithKeys();
        //waitForProcessingToComplete(5);

        waitForProcessingToComplete(25);
        //copiar id riesgo
        String idRiesgo = driver.findElement(By.id("1_s_1_l_OCS_Activity_UID")).getText();
        System.out.println("ID actividad riesgo: " + idRiesgo);

        clickWhenReady(MenuActividades);
        waitForProcessingToComplete(5);

        clickWhenReady(suMenuListaRiesgo);
        waitForProcessingToComplete(5);

        clickWhenReady(comBoxActividades);
        clickWhenReady(opcReasigActRiesgo);
        waitForProcessingToComplete(5);
        clickWhenReady(inpBuscaIdRiesgo);
        waitForProcessingToComplete(5);
        inpID.sendKeys(idRiesgo);
        pressEnter(driver);

        waitForProcessingToComplete(5);
        clickWhenReady(btnCambiaUsuario);
        waitForProcessingToComplete(10);
        inpCambiaUsuario.sendKeys("AUTOMA");
        pressEnter(driver);
        waitForProcessingToComplete(5);

        click(user1);
        waitForProcessingToComplete(2);
        click(user1);
        waitForProcessingToComplete(2);
        click(user2);
        waitForProcessingToComplete(2);
        //clickWhenReady(btnMoverUsuario);
        clickWhenReady(btnAceptarCambiaUsuario);
        System.out.println("reasignado ok");

        waitForProcessingToComplete(15);



    }



    public void apruebaRiesgo() {
        tdInpID.click();
        waitForProcessingToComplete(15);
        driver.navigate().back();
        waitForProcessingToComplete(15);
        tdInpID.click();
        //refrescar sino probar volver atras e ingresar a la actividad
        //driver.navigate().refresh();
        waitForProcessingToComplete(10);
        clickWhenReady(btnAprobarRiesgo);
        waitForProcessingToComplete(10);
        clickWhenReady(ofertaEconomica);
        waitForProcessingToComplete(5);


    }


    public void apruebaRiesgoRepa() {
        tdInpID.click();
        waitForProcessingToComplete(15);
        driver.navigate().back();
        waitForProcessingToComplete(15);
        tdInpID.click();
        waitForProcessingToComplete(10);

        clickWhenReady(btnAprobarRiesgo);
        waitForProcessingToComplete(10);
        if (isAlertPresent()) {
            aceptarPopup(driver);
            waitForProcessingToComplete(5);
            click(linkEvaluacion);
            waitForProcessingToComplete(5);
            selectAllText(driver,tblMsje);
            waitForProcessingToComplete(5);
            click(btnEdicionEval);
            waitForProcessingToComplete(5);
            click(opcCambiaRegEval);

            waitForProcessingToComplete(3);
            type("N3", Campo);
            waitForProcessingToComplete(3);
            type("OK", valor);
            waitForProcessingToComplete(5);

            waitForProcessingToComplete(5);
            clickWhenReady(btnAceptarCambiaReg);
            waitForProcessingToComplete(5);
            click(btnAprobarEval);
            waitForProcessingToComplete(5);

            click(LinkVista);

            //driver.navigate().back();
            //waitForProcessingToComplete(10);
            //driver.navigate().back();

            ////driver.navigate().back();
            waitForProcessingToComplete(10);//revisar desde aca

        }else{
            //driver.navigate().back();
            click(LinkVista);
            waitForProcessingToComplete(10);
        }

        clickWhenReady(linkFolioOf);
        waitForProcessingToComplete(10);
        clickWhenReady(linkFolioOf2);
        waitForProcessingToComplete(10);

    }


    //gestion aca usuario x0vcuenca

    public void cerrarActividadesACA() {


        //pasos para llegar a menu actividad
        waitForProcessingToComplete(5);
        //copia actividad
        clickWhenReady(subMenuActividades);
        waitForProcessingToComplete(10);
        performScrollDownWebELement(actividadElemento);
        waitForProcessingToComplete(5);
        String numeroActividad = actividadElemento.getText();
        System.out.println("Número de actividad: " + numeroActividad);

        //ir a menu actividad
        clickWhenReady(MenuActividades);
        waitForProcessingToComplete(10);
        //asociar la actividad a usuario

        //elegir reasignar actividades de combobox
        clickWhenReady(comBoxActividades);
        waitForProcessingToComplete(5);
        clickWhenReady(opcReasigAct);
        waitForProcessingToComplete(5);

        //pegar el id de la actividad
        clickWhenReady(btnConsultaAct);
        waitForProcessingToComplete(5);
        clickWhenReady(tdConsultAct);
        waitForProcessingToComplete(5);
        inpConsultAct.click();
        inpConsultAct.sendKeys(numeroActividad);
        pressEnter(driver);
        waitForProcessingToComplete(5);

        //cambia usuario
        clickWhenReady(btnCambiaUsuario);
        waitForProcessingToComplete(10);
        inpCambiaUsuario.sendKeys("AUTOMA");
        waitForProcessingToComplete(5);
        pressEnter(driver);
        waitForProcessingToComplete(5);
        clickWhenReady(btnMoverUsuario);
        waitForProcessingToComplete(5);
        clickWhenReady(btnAceptarCambiaUsuario);
        waitForProcessingToComplete(10);

        clickWhenReady(tdConsultAct);
        waitForProcessingToComplete(10);
        driver.navigate().back();
        waitForProcessingToComplete(10);
        clickWhenReady(tdConsultAct);
        waitForProcessingToComplete(10);

        //String folio = driver.findElement(numFolio).getAttribute("value");

        doubleClick(inpCambiaEstado);
        typeAndEnter("Terminado", inpCambiaEstado);
        waitForProcessingToComplete(5);

        driver.navigate().back();
        waitForProcessingToComplete(3);

        // volver a la oferta econimica
        clickWhenReady(linkaOferta);
        //System.out.println("volviendo a ofertas con el idFOlio: "+folio);
        waitForProcessingToComplete(10);

        clickWhenReady(tdFolioOferta);
        waitForProcessingToComplete(10);


    }


    public void rollBack() {
        clickWhenReady(linkBitacora);
        waitForProcessingToComplete(5);
        clickWhenReady(btnRoll);
        waitForProcessingToComplete(10);
        clickWhenReady(linkDetalles);
        waitForProcessingToComplete(5);
    }

}
