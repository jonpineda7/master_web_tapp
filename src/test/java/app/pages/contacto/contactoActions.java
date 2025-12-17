package app.pages.packs.contacto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.WebBasePage;

import java.time.Duration;
import java.util.List;

import static cl.automation.avattar.utils.CommonsHooks.getDataFromCsv;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class contactoActions extends WebBasePage {
    public contactoActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // locators

    @FindBy(xpath = "//input[@name='s_1_1_2_0']")
    protected WebElement inputRut;

    @FindBy(name = "s_1_1_0_0")
    protected WebElement buttonGo;

    @FindBy(xpath = "//table[@id='s_1_l']/tbody/tr[2]/td[2]/a")
    protected WebElement linkRut;

    //Preferencias de comunicación
    @FindBy(xpath = "//a[contains(text(), 'Preferencias de comunicación')]")
    protected WebElement linkPrefCom;

    @FindBy(xpath = "//span[@role='presentation']/label")
    protected WebElement usuario;


    //Preferencias de comunicación: Correo electronico
    @FindBy(xpath = "//button[@aria-label='Correo electrónico:Nuevo']")
    protected WebElement addMail;

    @FindBy(xpath = "//*[@id=\'1_s_2_l_SSA_Primary_Field\']")
    protected WebElement tdCheckboxMail;

    @FindBy(xpath = "//*[@id=\'1_s_2_l_SSA_Primary_Field\']/span")
    protected WebElement checkboxMail;

    @FindBy(xpath = "//*[@id=\'1_s_2_l_Address\']")
    protected WebElement tdMailNuevo;

    @FindBy(xpath = "//*[@id=\'1_Address\']")
    protected WebElement inputMailNuevo;

    @FindBy(xpath = "//*[@id=\'1_s_2_l_Use_Type\']")
    protected WebElement tdTypeMail;

    @FindBy(xpath = "//*[@id=\'1_Use_Type\']")
    protected WebElement inputTypeMail;

    @FindBy(xpath = "//*[@id=\'s_2_1_5_0_Ctrl\']")
    protected WebElement ConsultaCorreo;

    @FindBy(xpath = "//*[@id=\'1_s_2_l__Address_RO\']")
    protected WebElement tdConsultaCorreo;

    @FindBy(xpath = "//*[@id=\'1__Address_RO\']")
    protected WebElement inpConsultaCorreo;

    @FindBy(xpath = "//*[@id=\'s_2_1_4_0_Ctrl\']")
    protected WebElement btnConsultaCorreo;

    @FindBy(xpath = "//button[@aria-label=\'Correo electrónico:Guardar\']")
    protected WebElement saveMail;

    //Preferencias de comunicación: telefono

    @FindBy(xpath = "//button[@aria-label='Teléfono:Nuevo']")
    protected WebElement addFono;

    @FindBy(xpath = "//*[@id=\'1_s_1_l_SSA_Primary_Field\']")
    protected WebElement tdCheckboxFono;

    @FindBy(xpath = "//table[@summary='Teléfono']/tbody/tr[2]/td[2]")
    protected WebElement checkboxFono;

    @FindBy(xpath = " //td[@id='1_s_1_l_Address'][1]")
    protected WebElement tdFonoNuevo;

    @FindBy(xpath = "//input[@id=\'1_Address\']")
    protected WebElement inputFonoNuevo;

    @FindBy(xpath = "//*[@id=\'1_s_1_l_Use_Type\']")
    protected WebElement TypeFono;

    @FindBy(xpath = "//*[@id=\"1_Use_Type\"]")
    protected WebElement inputTypeFono;

    @FindBy(xpath = "//*[@id=\'1_s_1_l_Address_RO\']")
    protected WebElement tdConsultaFono;

    @FindBy(xpath = "//*[@id=\'1_Address_RO\']")   // Reemplaza con tu selector real
    protected WebElement tdConsultaFonoNuevo;

    @FindBy(xpath = "//button[@aria-label='Teléfono:Ir']")
    protected WebElement btnConsultaFono;

    @FindBy(xpath = "//button[@aria-label='Teléfono:Consulta']")
    protected WebElement btnConsulta;

    @FindBy(xpath = "//button[@aria-label=\'Teléfono:Guardar\']")
    protected WebElement saveFono;

    //Afiliaciones
    @FindBy(xpath = "//a[@role='link'][contains(text(),'Afiliaciones')]")
    protected WebElement linkAfiliaciones;

    @FindBy(xpath = "//button[@title='Afiliaciones:Consulta']")
    protected WebElement btnBuscaAfi;

    @FindBy(xpath = "//input[@name='OCS_Parent_Account_RUT']")
    protected WebElement inpRutEmpresa;

    @FindBy(xpath = "//*[@id=\'1_s_1_l_OCS_Tipo_Relacion\']")
    protected WebElement tdTipoAfi;

    @FindBy(xpath = "//input[@aria-label='Estado afiliación']")
    protected WebElement inpEstadoAfil;

    @FindBy(xpath = "//input[@aria-label='Entidad que paga la pensión']")
    protected WebElement inpEntidadAfil;

    @FindBy(xpath = "//input[@aria-label='Tipo de contrato']")
    protected WebElement inpTipoContrato; //crear metodo q valide vacio y complete el campo, depende del tipo afiliado si es pensionado vejez sino indefinido

    @FindBy(xpath = "//input[@aria-label='Tipo afiliación']")
    protected WebElement inpTipoAfil;

    @FindBy(xpath = "//input[@aria-label='Fecha contrato']")
    protected WebElement inpFechaContrato;

    @FindBy(xpath = "//input[@aria-label='Fecha de ingreso a la Compañía']")
    protected WebElement inpFechaIngreso;

    @FindBy(xpath = "//*[@id=\'siebui-threadbar\']/li[2]/span/a")
    protected WebElement linkContacto;

    //End locators

    public void MenuOption(String menuOption) {
        waitForProcessingToComplete(5);
        this.getDriver().findElement(By.xpath("//div[@id='s_sctrl_tabScreen']/ul/li[contains(.,'" + menuOption + "')]")).click();
    }


    public void ingresoRut(String sheetName, int row) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(elementToBeClickable(inputRut));

            String rutValue = getDataFromCsv(sheetName, row, 0);
            System.out.println("Ingresando RUT: " + rutValue);

            inputRut.clear();  // Limpiar campo antes de escribir
            inputRut.sendKeys(rutValue);

            wait.until(elementToBeClickable(buttonGo));
            buttonGo.click();

            wait.until(elementToBeClickable(linkRut));
            linkRut.click();

            System.out.println("RUT ingresado y procesado correctamente");
        } catch (Exception e) {
            System.err.println("Error en ingresoRut: " + e.getMessage());
            throw e;
        }
    }


    public void PreferenciaComunicacionTelefono() {
        final String fonoFicticio = "999999999";
        clickWhenIsReady(linkPrefCom);

        //buscar el fono, si no existe se agrega
        System.out.println("buscando telefono");
        clickWhenIsReady(btnConsulta);
        waitForProcessingToComplete(2);
        clickWhenIsReady(tdConsultaFono);

        write(tdConsultaFonoNuevo, fonoFicticio);
        clickWhenIsReady(btnConsultaFono);
        waitForProcessingToComplete(2);

        if (elementIsNotPresent(tdConsultaFonoNuevo)) {
            System.out.println("se procede a agregar fono ficticio");
            clickWhenIsReady(addFono);
            clickElement(tdFonoNuevo);
            write(inputFonoNuevo, fonoFicticio);
            waitForProcessingToComplete(2);
            clickWhenIsReady(TypeFono);
            typing("Personal", inputTypeFono);
            System.out.println("click ingreso de tipo");
            waitForProcessingToComplete(2);
            clickWhenIsReady(tdCheckboxFono);
            clickWhenIsReady(checkboxFono);
            clickWhenIsReady(saveFono);
            System.out.println("graba fono nuevo");
            waitForProcessingToComplete(2);
            System.out.println("Se agrega fono nuevo principal ficticio");
        } else {

            System.out.println("Fono ficticio ya existe y esta activado correctamente");
        }
    }

    public void PreferenciaComunicacionCorreo() {
        final String correoFicticio = "PRUEBASQA@CAJALOSANDES.CL";
        //clickWhenReady(linkPrefCom);
        //buscar el correo, si no existe se agrega
        waitForProcessingToComplete(3);

        clickWhenIsReady(ConsultaCorreo);

        waitForProcessingToComplete(2);
        tdConsultaCorreo.click();
        write(inpConsultaCorreo, correoFicticio);
        clickWhenIsReady(btnConsultaCorreo);
        waitForProcessingToComplete(2);

        if (elementIsNotPresent(inpConsultaCorreo)) {

            clickWhenIsReady(addMail);
            clickWhenIsReady(tdMailNuevo);
            clickWhenIsReady(inputMailNuevo);
            typing(correoFicticio, inputMailNuevo);
            clickWhenIsReady(tdTypeMail);
            typing("Personal", inputTypeMail);
            clickWhenIsReady(tdCheckboxMail);
            clickWhenIsReady(checkboxMail);
            clickWhenIsReady(saveMail);

            waitForProcessingToComplete(2);
            System.out.println("Correo ficticio agregado y activado correctamente");
        } else {

            System.out.println("Correo ficticio ya existe y esta activado correctamente");
        }

    }


    public void PreferenciaComunicacion() {
        // Localizar todas las celdas de la columna "Principal"

        waitForProcessingToComplete(10);
        List<WebElement> celdasPrincipal = driver.findElements(
                //By.xpath("//table[@summary='Teléfono']/tbody/tr/td[@aria-roledescription='Principal']");
                By.xpath("//table[@summary='Direcciones personales']/tbody/tr/td[@aria-roledescription='Principal']")

        );

        if (celdasPrincipal.isEmpty()) {
            System.out.println("No se encontraron direcciones en la tabla.");
            return;
        }

        boolean yaMarcado = false;

        for (WebElement celda : celdasPrincipal) {
            // Si dentro de la celda existe un span con clase "siebui-icon-checkbox-checked"
            List<WebElement> checkMarcado = celda.findElements(
                    By.xpath("//table[@summary='Direcciones personales']/tbody/tr/td[@aria-roledescription='Principal']/span[contains(@class,'siebui-icon-checkbox-checked')]")
            );
            //table[@summary='Teléfono']/tbody/tr/td[@aria-roledescription='Principal']/span[contains(@class,'siebui-icon-checkbox-checked')]


            if (!checkMarcado.isEmpty()) {
                yaMarcado = true;
                break;
            }
        }

        if (yaMarcado) {
            System.out.println("Ya existe una dirección marcada como principal. No se hace nada.");
        } else {
            // Si ninguna está marcada, hacer clic en la primera celda de la columna "Principal"
            WebElement primeraCelda = celdasPrincipal.get(0);


            primeraCelda.click();
            waitForProcessingToComplete(2);
            primeraCelda.click();
            waitForProcessingToComplete(10);

            System.out.println("Se marcó la primera dirección como principal.");
        }
    }


    public void afiliacionCheck(String sheetName, int row) throws Exception {
        // Navegación y búsqueda inicial
        waitForProcessingToComplete(3);
        clickWhenIsReady(linkAfiliaciones);
        waitForProcessingToComplete(3);
        clickWhenIsReady(btnBuscaAfi);
        waitForProcessingToComplete(2);
        typing(getDataFromCsv(sheetName, row, 7), inpRutEmpresa);
        waitForProcessingToComplete(3);
        pressEnter(driver);
        waitForProcessingToComplete(5);

        // Flujo principal
        clickWhenIsReady(tdTipoAfi);
        waitForProcessingToComplete(5);

        String estadoAfil = inpEstadoAfil.getAttribute("value").trim();
        String tipoContrato = inpTipoContrato.getAttribute("value").trim();
        String tipoAfil = inpTipoAfil.getAttribute("value").trim();
        String fechaContrato = inpFechaContrato.getAttribute("value").trim();
        String entidadPension = inpEntidadAfil.getAttribute("value").trim();
        String fechaIngreso = inpFechaIngreso.getAttribute("value").trim();


        // Estado de afiliado
        if (!estadoAfil.equals("Afiliado")) {
            setInputValue(inpEstadoAfil, "Afiliado", "Se cambia el estado a Afiliado");
        }

        // Tipo de contrato
        if (tipoContrato.isEmpty()) {
            if (tipoAfil.startsWith("Pensionados")) {
                setInputValue(inpTipoContrato, "Vejez", "Se ingresa tipo de contrato");
            } else {
                setInputValue(inpTipoContrato, "Indefinido", "Se ingresa tipo de contrato");
            }
        }

        // Fecha de contrato
        if (fechaContrato.isEmpty()) {
            setInputValue(inpFechaContrato, "01/01/2024 00:00:00", "Se ingresa fecha de contrato");
        }

        // Entidad de pensión (si corresponde) y fecha de ingreso
        if (tipoAfil.equals("Pensionados DL 3.500") && entidadPension.isEmpty()) {
            setInputValue(inpEntidadAfil, "PROVIDA A.F.P.", "Se ingresa entidad que paga la pension");
        }
        if (fechaIngreso.isEmpty()) {
            setInputValue(inpFechaIngreso, "01/01/2024 00:00:00", "Se ingresa fecha de ingreso a la compañia");
        }

        System.out.println("Datos validados correctamente");

        clickWhenIsReady(linkContacto);
        waitForProcessingToComplete(10);
    }


}
