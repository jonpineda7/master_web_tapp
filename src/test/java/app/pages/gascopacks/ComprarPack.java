package app.pages.gascopacks;

import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;
import app.support.utils.ApiClient;
import app.support.utils.ScreenShot;
import app.support.utils.Telegram;
import app.support.utils.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import report.Report;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import static app.support.utils.ApiClient.existingBuildName;
import static app.support.utils.ApiClient.existingUserName;

public class ComprarPack {
    @FindBy(xpath = "/html/body/app-root/div/app-bienvenida/div/div/div/div[2]/div[2]/div[3]/button")
    private WebElement btnComprarPack;
    @FindBy(id = "nombre")
    private WebElement nombre;
    @FindBy(id = "rut")
    private WebElement rut;
    @FindBy(id = "telefono")
    private WebElement telefono;
    @FindBy(id = "correo")
    private WebElement correo;
    @FindBy(id = "correo2")
    private WebElement correo2;
    @FindBy(id = "input1")
    private WebElement input1;
    @FindBy(className = "combobox-button")
    private WebElement comboBox;
    @FindBy(className = "palomita")
    private WebElement aceptoCondiciones;

    @FindBy(className = "logo_img")
    private WebElement logoImg;
    @FindBy(xpath = "/html/body/app-root/div/app-bienvenida/div/div/div/div[2]/div[2]/div[1]/p/span[3]")
    private WebElement clickAqui;
    @FindBy(className = "contactanos")
    private WebElement contactanos;
    @FindBy(className = "carrusel")
    private WebElement carrusel;
    @FindBy(id = "ingresarCodSms")
    private WebElement continuar;
    WaitUtils wu;
    private ScreenShot sc = new ScreenShot();
    private Telegram tl = new Telegram();
 // private String userName = LoadProperty.BROWSERSTACK.getProperty("browserstack_name");


    public ComprarPack() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    public void aceptarCondiciones() throws URISyntaxException, IOException {
        wu = new WaitUtils();

        try {
            System.out.println("Click en aceptar terminos y condiciones...");
            Report.PASSED("Click en aceptar terminos y condiciones");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementById(\"t&cCheckBox\").click();");
        } catch (Exception e) {
            sc.tomarCapturaDePantalla(Browser.getDriver(), "files/Screenshot/proyectoBase"+ existingUserName + "_" + existingBuildName + ".png" );
            //Enviar notificación Telegram con screenshot
            tl.enviarTextoConImagen("**Error**: ProyectoBase - " + existingUserName + " - " + existingBuildName + ": Problemas al hacer click en aceptar terminos y condiciones ", "files/Screenshot/proyectoBase"+ existingUserName + "_" + existingBuildName + ".png");
            Report.FAILED("Problemas al hacer click en aceptar terminos y condiciones: " + e.getMessage());
        }
    }

    public void clickContactanos() throws URISyntaxException, IOException {
        wu = new WaitUtils();

        try {
            System.out.println("Click en contactanos...");
            Report.PASSED("Click en contactanos...");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName('contactanos')[0].click()");
        } catch (Exception e) {
            Report.FAILED("Problemas al hacer click en contactanos: " + e.getMessage());
        }
    }

    public void clickHazClickAqui() throws URISyntaxException, IOException {
        wu = new WaitUtils();

        // Obtener el identificador de la ventana actual
        String ventanaPrincipal = Browser.getDriver().getWindowHandle();

        try {
            // Espera hasta que el elemento esté presente en la página
            WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10); // Espera hasta 10 segundos
            WebElement spanHazClic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Haz clic aquí')]")));

            // Haz clic en el elemento
            spanHazClic.click();

            Browser.getDriver().switchTo().window(ventanaPrincipal);
        } catch (Exception e) {
            Report.FAILED("Problemas al hacer click en contactanos: " + e.getMessage());
        }
    }

    public void clickComprarPack() throws URISyntaxException, IOException, InterruptedException {
        wu = new WaitUtils();

        try {
            System.out.println("Click en boton comprar pack...");
            Report.PASSED("Click en boton comprar pack...");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn_primario\")[0].click();");
        } catch (Exception e) {
            Report.FAILED("Erorr al hacer click en boton comprar pack: " + e.getMessage());
        }

        Thread.sleep(3000);
    }

    public void clickIconoVolver() throws URISyntaxException, IOException, InterruptedException {
        wu = new WaitUtils();

        try {
            System.out.println("Click en boton volver...");
            Report.PASSED("Click en boton volver...");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName('back')[0].click();");
        } catch (Exception e) {
            Report.FAILED("Erorr al hacer click en boton comprar pack: " + e.getMessage());
        }

        Thread.sleep(3000);
    }

    public void clickLogoGasco() throws URISyntaxException, IOException, InterruptedException {
        wu = new WaitUtils();

        try {
            System.out.println("Click en Logo Gasco...");
            Report.PASSED("Click en Logo Gasco...");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"logo_img\")[0].click();");
        } catch (Exception e) {
            Report.FAILED("Error al hacer click en boton comprar pack: " + e.getMessage());
        }

        Thread.sleep(3000);

        // Obtener el identificador de la ventana actual
        String ventanaPrincipal = Browser.getDriver().getWindowHandle();

        // Cambiar al contexto de la nueva pestaña
        cambiarAContextoDeNuevaPestana(ventanaPrincipal);

        String urlEsperada = "https://gasco.cl/";
        if (Browser.getDriver().getCurrentUrl().equals(urlEsperada)) {
            System.out.println("La URL es la esperada.");
        } else {
            System.out.println("La URL actual (" + Browser.getDriver().getCurrentUrl() + ") no coincide con la esperada (" + urlEsperada + ").");
        }

        Browser.getDriver().switchTo().window(ventanaPrincipal);
        System.out.println("La URL actual (" + Browser.getDriver().getCurrentUrl() + ") no coincide con la esperada (" + urlEsperada + ").");

        Thread.sleep(3000);
    }

    public void seleccionPack() throws URISyntaxException, IOException, InterruptedException {

        Integer numero = (int) (Math.random() * 6 + 0);
        System.out.println("Seleccionando pack N°: " + numero);
        try {
            System.out.println("Click en pack");
            Report.PASSED("Click en pack");
            System.out.println("document.getElementsByClassName(\"card-img-top\")[" + numero + "].click();");
            Thread.sleep(1000);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"card-img-top\")[" + numero + "].click();");
        } catch (Exception e) {
            Report.FAILED("Problemas al hacer click en pack de carga: " + e.getMessage());
        }
        /**
         * Click boton siguiente
         */
        try {
            System.out.println("Click en boton siguiente");
            Report.PASSED("Click en boton siguiente");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName(\"btn_primario\")[0].click();");
        } catch (Exception e) {
            Report.FAILED("Problemas al hacer click en boton siguiente: " + e.getMessage());
        }

        ;
        Thread.sleep(1000);

    }

    public void ingresarDatos(String nombreCliente, String rutCliente, String fono, String email) throws InterruptedException, URISyntaxException, IOException {
        System.out.println("Ingresando datos de formulario...");
        System.out.println("Liberando teléfono: " + fono);
        ApiClient ap = new ApiClient();
        ap.unlockPhone("56" + fono.trim());
        //nombre.sendKeys(nombreCliente);
        System.out.println(nombre.getText());
        wu = new WaitUtils();
        /**
         * Validar elemento icono logo
         */
        if (wu.waitForElementVisible(nombre)) {
            nombre.sendKeys(nombreCliente);
            System.out.println(nombre.getText());

            String valorCampoTexto = nombre.getAttribute("value");
            System.out.println("NOMBRE: " + valorCampoTexto);
            System.out.println("El largo del nombre es: " + valorCampoTexto.length());

        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        if (wu.waitForElementVisible(rut)) {
            rut.sendKeys(rutCliente.trim());

        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        if (wu.waitForElementVisible(telefono)) {
            telefono.sendKeys(fono);
        } else {
            Report.FAILED("[*] No encontró el campo TELÉFONO...");
        }

        if (wu.waitForElementVisible(correo)) {
            correo.clear();
            correo2.clear();
            correo.sendKeys(email);
            correo2.sendKeys(email);
        } else {
            Report.FAILED("[*] No encontró el campo MAIl...");
        }

        Thread.sleep(1000);
        try {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName('palomita')[0].click();");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementById(\"ingresarCodSms\").click();");
        } catch (Exception e) {
            Report.FAILED("[Error] Problemas al realizar click ...");
        }

        Thread.sleep(7000);

    }

    public void forzarIngresoDatos(String nombreCliente, String rutCliente, String fono, String email) throws InterruptedException, URISyntaxException, IOException {
        System.out.println("Ingresando datos de formulario...");
        System.out.println("Liberando teléfono: " + fono);
        ApiClient ap = new ApiClient();
        ap.unlockPhone("56" + fono.trim());
        nombre.sendKeys(nombreCliente);
        System.out.println(nombre.getText());
        wu = new WaitUtils();
        /**
         * Validar elemento icono logo
         */
        if (wu.waitForElementVisible(nombre)) {
            nombre.sendKeys(nombreCliente);
            System.out.println(nombre.getText());

            String valorCampoTexto = nombre.getAttribute("value");
            System.out.println("NOMBRE: " + valorCampoTexto);
            System.out.println("El largo del nombre es: " + valorCampoTexto.length());
            if (valorCampoTexto.length() == 100) {
                Report.PASSED("El largo del campo NOMBRE cumple con el largo máximo(100)");
            } else {
                Report.FAILED("El largo del campo NOMBRE no cumple con el largo máximo(100) ");
            }

        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        if (wu.waitForElementVisible(rut)) {
            rut.sendKeys(rutCliente.trim());
            String valorCampoRut = rut.getAttribute("value");
            if (valorCampoRut.length() >= 11 && valorCampoRut.length() <= 12) {
                Report.PASSED("El largo del campo RUT cumple con el largo máximo(12)");
            } else {
                Report.FAILED("El largo del campo RUT no cumple con el largo máximo(12) ");
            }

        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        if (wu.waitForElementVisible(telefono)) {
            telefono.sendKeys(fono);
            String valorCampoFono = telefono.getAttribute("value");

            if (valorCampoFono.length() == 9) {
                Report.PASSED("El largo del campo TELÉFONO cumple con el largo máximo(9)");
            } else {
                Report.FAILED("El largo del campo TELÉFONO no cumple con el largo máximo(9) ");
            }
        } else {
            Report.FAILED("[*] No encontró el campo TELÉFONO...");
        }

        if (wu.waitForElementVisible(correo)) {
            correo.clear();
            correo2.clear();
            correo.sendKeys(email);

            String valorCampoMail = correo.getAttribute("value");

            if (valorCampoMail.length() == 100) {
                Report.PASSED("El largo del campo MAIL cumple con el largo máximo(100)");
            } else {
                Report.FAILED("El largo del campo MAIL no cumple con el largo máximo(100) ");
            }

            correo2.sendKeys(email);
        } else {
            Report.FAILED("[*] No encontró el campo MAIl...");
        }

        Thread.sleep(1000);
        try {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName('palomita')[0].click();");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementById(\"ingresarCodSms\").click();");
        } catch (Exception e) {
            Report.FAILED("[Error] Problemas al realizar click ...");
        }

        Thread.sleep(7000);

    }

    public void ingresarRutEmpresaValidacion(String rutCliente) throws InterruptedException, URISyntaxException, IOException {
        System.out.println("Ingresando datos de formulario...");

        wu = new WaitUtils();

        if (wu.waitForElementVisible(rut)) {
            rut.sendKeys(rutCliente.trim());
            String valorCampoRut = rut.getAttribute("value");
            if (valorCampoRut.length() >= 11 && valorCampoRut.length() <= 12) {
                Report.PASSED("El largo del campo RUT cumple con el largo máximo(12)");
            } else {
                Report.FAILED("El largo del campo RUT no cumple con el largo máximo(12) ");
            }

            try {
                // Intenta encontrar el elemento label por su clase
                WebElement labelError = Browser.getDriver().findElement(By.className("error_desc"));

                // Obtención del texto del elemento label
                String textoLabel = labelError.getText();

                if (textoLabel.equals("El RUT debe ser de persona natural")) {
                    Report.PASSED("Validación de RUT empresa correcto.");
                } else {
                    Report.FAILED("Validación incorrecta para RUT EMPRESA.");
                }

                // Impresión del texto en la consola
                System.out.println("Texto del elemento label: " + textoLabel);
            } catch (NoSuchElementException e) {
                // Manejo de la excepción si el elemento no se encuentra
                System.out.println("El elemento con la clase 'error_desc' no fue encontrado.");
            } finally {
                // Cierre del navegador
                Browser.getDriver().quit();
            }

        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        Thread.sleep(1000);


        Thread.sleep(7000);

    }

    public void validarDistintosMails(String email, String emailb) throws InterruptedException, URISyntaxException, IOException {
        System.out.println("Ingresando datos de formulario...");

        wu = new WaitUtils();

        if (wu.waitForElementVisible(correo)) {
            correo.clear();
            correo2.clear();
            correo.sendKeys(email);

            String valorCampoMail = correo.getAttribute("value");

            correo2.sendKeys(emailb);

            WebElement elementoP = Browser.getDriver().findElement(By.cssSelector("p[for='correo2'].error_confirmacion.text-center"));

            // Obtener el texto del elemento
            String textoActual = elementoP.getText();

            // Texto esperado
            String textoEsperado = "Verifica que los correos ingresados sean iguales. Recuerda que tu código llegará a este correo.";

            // Validar que el texto sea el esperado
            if (textoActual.equals(textoEsperado)) {
                System.out.println("El texto es correcto: " + textoActual);
            } else {
                System.out.println("El texto no es el esperado. Texto actual: " + textoActual);
            }

            // Crear una instancia de la clase Actions
            Actions actions = new Actions(Browser.getDriver());

            // Seleccionar el texto en el textbox de origen y copiarlo
            actions.moveToElement(correo).click().keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys("a").keyUp(org.openqa.selenium.Keys.CONTROL).sendKeys("c").build().perform();

            // Pegar el texto en el textbox de destino
            actions.moveToElement(correo2).click().keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys("v").keyUp(org.openqa.selenium.Keys.CONTROL).build().perform();

        } else {
            Report.FAILED("[*] No encontró el campo MAIl...");
        }

        Thread.sleep(1000);


        Thread.sleep(7000);

    }

    public void reingresarDatos(String nombreCliente, String rutCliente, String fono, String email) throws InterruptedException, URISyntaxException, IOException {
        System.out.println("Ingresando datos de formulario...");
        System.out.println("Liberando teléfono: " + fono);
        //ApiClient ap = new ApiClient();
        //ap.unlockPhone("56" + fono.trim());

        wu = new WaitUtils();
        /**
         * Validar elemento icono logo
         */
        if (wu.waitForElementVisible(nombre)) {
            nombre.sendKeys(nombreCliente);
        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        if (wu.waitForElementVisible(rut)) {
            rut.sendKeys(rutCliente.trim());
        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        if (wu.waitForElementVisible(telefono)) {
            telefono.sendKeys(fono);
        } else {
            Report.FAILED("[*] No encontró el campo TELÉFONO...");
        }

        if (wu.waitForElementVisible(correo)) {
            correo.clear();
            correo2.clear();
            correo.sendKeys(email);
            correo2.sendKeys(email);
        } else {
            Report.FAILED("[*] No encontró el campo MAIl...");
        }

        Thread.sleep(1000);
        try {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName('palomita')[0].click();");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementById(\"ingresarCodSms\").click();");
        } catch (Exception e) {
            Report.FAILED("[Error] Problemas al realizar click ...");
        }

        Thread.sleep(2000);
        // Encuentra el elemento <p> por su texto
        WebElement elementoP = Browser.getDriver().findElement(By.xpath("//p[contains(text(),'Estimado cliente, ya has realizado 1 compra de pack en el mes. Actualmente no se puede superar este límite mensual.')]"));

        // Obtiene el texto del elemento
        String textoElemento = elementoP.getText();

        // Realiza la validación
        if (textoElemento.equals("Estimado cliente, ya has realizado 1 compra de pack en el mes. Actualmente no se puede superar este límite mensual.")) {
            System.out.println("La validación fue exitosa. El texto coincide.");
        } else {
            System.out.println("La validación falló. El texto no coincide.");
        }

    }

    public void ingresarDatosCheck(String nombreCliente, String rutCliente, String fono, String email) throws InterruptedException, URISyntaxException, IOException {
        System.out.println("Ingresando datos de formulario...");
        System.out.println("Liberando teléfono: " + fono);
        ApiClient ap = new ApiClient();
        ap.unlockPhone("56" + fono.trim());

        wu = new WaitUtils();
        /**
         * Validar elemento icono logo
         */
        if (wu.waitForElementVisible(nombre)) {
            nombre.sendKeys(nombreCliente);
        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        if (wu.waitForElementVisible(rut)) {
            rut.sendKeys(rutCliente.trim());
        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        if (wu.waitForElementVisible(telefono)) {
            telefono.sendKeys(fono);
        } else {
            Report.FAILED("[*] No encontró el campo TELÉFONO...");
        }

        if (wu.waitForElementVisible(correo)) {
            correo.sendKeys(email);
            correo2.sendKeys(email);
        } else {
            Report.FAILED("[*] No encontró el campo MAIl...");
        }

        Thread.sleep(1000);
        try {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName('palomita')[0].click();");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName('palomita')[0].click();");
        } catch (Exception e) {
            Report.FAILED("[Error] Problemas al realizar click ...");
        }

        Thread.sleep(7000);

    }

    public void ingresarDatosValidarContinuar(String nombreCliente, String rutCliente, String fono, String email) throws InterruptedException, URISyntaxException, IOException {
        System.out.println("Ingresando datos de formulario...");
        System.out.println("Liberando teléfono: " + fono);
        ApiClient ap = new ApiClient();
        ap.unlockPhone("56" + fono.trim());

        wu = new WaitUtils();
        /**
         * Validar elemento icono logo
         */
        if (wu.waitForElementVisible(nombre)) {
            nombre.sendKeys(nombreCliente);
        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        if (wu.waitForElementVisible(rut)) {
            rut.sendKeys(rutCliente.trim());
        } else {
            Report.FAILED("[*] No encontró el campo NOMBRE...");
        }

        if (wu.waitForElementVisible(telefono)) {
            telefono.sendKeys(fono);
        } else {
            Report.FAILED("[*] No encontró el campo TELÉFONO...");
        }

        if (wu.waitForElementVisible(correo)) {
            correo.sendKeys(email);
            correo2.sendKeys(email);
        } else {
            Report.FAILED("[*] No encontró el campo MAIl...");
        }

        Thread.sleep(1000);
        try {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName('palomita')[0].click();");
        } catch (Exception e) {
            Report.FAILED("[Error] Problemas al realizar click ...");
        }

        //Validar botón continuar habilitado
        String clasesBoton = continuar.getAttribute("class");

        // Validación de que solo tiene la clase "btn_primario"
        if (clasesBoton.equals("btn_primario")) {
            System.out.println("El botón tiene solo la clase 'btn_primario'.");
            Report.PASSED("Botón continuar habilitado");
        } else {
            System.out.println("El botón no tiene solo la clase 'btn_primario'.");
            Report.FAILED("El botón continuar no se encuentra habilitado");
        }

        Thread.sleep(7000);

    }

    public void verificarCamposGp() throws InterruptedException, URISyntaxException, IOException {
        wu = new WaitUtils();
        boolean errorFlag = false;
        String campo;

        try {
            /**
             * Validar check Acepto Condiciones
             */
            if (!wu.waitForElementVisible(aceptoCondiciones)) {
                Report.FAILED("No se visualiza el elemento " + aceptoCondiciones.toString());
                errorFlag = true;
            }

            /**
             * Validar logo Gasco
             */
            if (!wu.waitForElementVisible(logoImg)) {
                Report.FAILED("No se visualiza el elemento Logo Gasco " + logoImg.toString());
                errorFlag = true;
            }


            /**
             * Validar Contactanos
             */
            if (!wu.waitForElementVisible(contactanos)) {
                Report.FAILED("No se visualiza el elemento Contactanos " + contactanos.toString());
                errorFlag = true;
            }

            /**
             * Validar Carrusel
             */
            if (!wu.waitForElementVisible(carrusel)) {
                Report.FAILED("No se visualiza el elemento Carrusel " + carrusel.toString());
                errorFlag = true;
            }

            /**
             * Todos los campos OK
             */
            if (!errorFlag) {
                Report.PASSED("Se visualizan todos los elementos en el menu Crear Campana");
            }
        } catch (Exception e) {
            Report.FAILED("Problemas al validar campos de " + e.getMessage());
        }

        Thread.sleep(7000);

    }

    public void ingresarCodigoyPago(String codigo) throws InterruptedException, URISyntaxException, IOException {

        try {
            System.out.println("Ingresando código de SMS: " + codigo);
            input1.sendKeys(codigo);
            System.out.println("Click en botón Ir a pagar...");
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementById('ingresarCodSms').click();");

            //input1.sendKeys(codigo);
        } catch (Exception e) {
            Report.FAILED("[Error] Problemas al realizar click en Ingresar Codigo...");
        }

        Thread.sleep(3000);
        /**
         * switch a Iframe de modal
         */
        try {
            Report.PASSED("Cambiando a modal de pago...");
            Browser.getDriver().switchTo().frame("webpay_iframe");
        } catch (Exception e) {
            Report.FAILED("Problemas al cambiar a modal de pago.");
        }
        /**
         * Click en botón pagar
         */
        try {
            WebElement btnPagar = Browser.getDriver().findElement(By.id("btnPagar"));
            btnPagar.click();

        } catch (Exception e) {
            Report.FAILED("[Error] Problemas al realizar click en Pagar...");
        }

        Thread.sleep(7000);

    }

    public void ingresarCodigo(String codigo) throws InterruptedException, URISyntaxException, IOException {
        wu = new WaitUtils();

        try {
            System.out.println("Ingresando código de SMS: " + codigo);
            input1.sendKeys(codigo);
            System.out.println("Esperando tiempo de espera código...");
            //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementById('ingresarCodSms').click();");

            //input1.sendKeys(codigo);
        } catch (Exception e) {
            Report.FAILED("[Error] Problemas al realizar click en Ingresar Codigo...");
        }

        Thread.sleep(109000);

        //Click en Modificar número
        try {
            WebElement btnMod = Browser.getDriver().findElement(By.className("link_cambio_tel"));
            btnMod.click();

        } catch (Exception e) {
            Report.FAILED("[Error] Problemas al realizar click en Modificar Número...");
        }

        Thread.sleep(1000);

        if (wu.waitForElementVisible(telefono)) {
            Report.PASSED("Elemento teléfono encontrado!");
        } else {
            Report.FAILED("Elemento teléfono NO encontrado!");
        }

    }

    public void ingresarCodigoValidacion(String codigo) throws InterruptedException, URISyntaxException, IOException {
        wu = new WaitUtils();

        try {
            System.out.println("Ingresando código de SMS: " + codigo);
            input1.sendKeys(codigo);
            System.out.println("Esperando tiempo de espera código...");
            //((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementById('ingresarCodSms').click();");

            //input1.sendKeys(codigo);
        } catch (Exception e) {
            Report.FAILED("[Error] Problemas al realizar click en Ingresar Codigo...");
        }

    }

    public void ingresarDatosyPagar() throws InterruptedException, URISyntaxException, IOException {

        /**
         * Seleccionar medio de pago
         */
        try {
            Report.PASSED("Seleccionando medio de pago.");
            Browser.getDriver().switchTo().defaultContent();
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementById('debito').click();");
            comboBox.click();
        } catch (Exception e) {
            Report.FAILED("Problemas al seleccionar medio de pago.");
        }

        Thread.sleep(1000);
        /**
         * Seleccionar banco
         */
        try {
            Report.PASSED("Seleccionando Banco");
            WebElement option = Browser.getDriver().findElement(By.xpath("//span[text()='TEST COMMERCE BANK']"));
            option.click();
        } catch (Exception e) {
            Report.FAILED("Problemas al seleccionar el Banco.");
        }

        /**
         * Ingresando número de tarjeta
         */
        try {
            WebElement tar = Browser.getDriver().findElement(By.id("pan"));
            tar.sendKeys("4051 8842 3993 7763");
            Report.PASSED("Ingresando datos de tarjeta");
        } catch (Exception e) {
            Report.FAILED("Problemas al ingresar datos de tarjeta.");
        }

        /**
         *Click en botón Pagar
         */
        try {
            WebElement btnpay = Browser.getDriver().findElement(By.xpath("//button[contains(@class,'submit')]"));
            btnpay.click();
            Report.PASSED("Click en botón pagar.");
        } catch (Exception e) {
            Report.FAILED("Problemas al hacer click en botón Pagar.");
        }

        Thread.sleep(7000);

        /**
         * Ingresar datos de banco
         */
        try {
            WebElement rut = Browser.getDriver().findElement(By.id("rutClient"));
            rut.sendKeys("11.111.111-1");
            WebElement pass = Browser.getDriver().findElement(By.id("passwordClient"));
            pass.sendKeys("123");

            WebElement btna = Browser.getDriver().findElement(By.xpath("//input[contains(@type,'submit')]"));
            btna.click();

            Report.PASSED("Ingresando rut y password Banco");
        } catch (Exception e) {
            Report.FAILED("Problemas al ingresar rut y password.");
        }

        Thread.sleep(2000);
        /**
         *Elegit opción y enviar
         */
        try {
            WebElement btncont = Browser.getDriver().findElement(By.xpath("//input[contains(@type,'submit')]"));
            btncont.click();
        } catch (Exception e) {
            Report.FAILED("Problemas al elegir opción y enviar.");
        }

        Thread.sleep(16000);
        /**
         *Elegit opción y enviar
         */
        try {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("document.getElementsByClassName('btn_inicio')[0].click();");
        } catch (Exception e) {
            Report.FAILED("Problemas al elegir opción y enviar.");
        }
        Thread.sleep(2000);

    }

    private static void cambiarAContextoDeNuevaPestana(String ventanaPrincipal) {
        // Obtener los identificadores de todas las ventanas abiertas
        Set<String> ventanas = Browser.getDriver().getWindowHandles();

        // Iterar sobre las ventanas para encontrar la nueva pestaña
        for (String ventana : ventanas) {
            if (!ventana.equals(ventanaPrincipal)) {
                // Cambiar al contexto de la nueva pestaña
                Browser.getDriver().switchTo().window(ventana);
                break;
            }
        }
    }

    public void enviarMensajeTelegram(String project, String scenarioName) throws InterruptedException, URISyntaxException, IOException {
        Telegram tl = new Telegram();
        //String userName = LoadProperty.BROWSERSTACK.getProperty("browserstack_name");
        //String build_version = LoadProperty.BUILD.getProperty("build_version");
        String[] partsScenario = scenarioName.split(" ");
        tl.enviarTexto(project + " - " + existingUserName + " - " + existingBuildName + " - " + partsScenario[0] + ": Finalizado con exito!");

    }

}
