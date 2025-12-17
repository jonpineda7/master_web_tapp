package app.com.steps.contacto;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.contacto.contactoActions;
import steps.Hooks;

import java.io.IOException;

public class contactoSteps {
    // contactoActions contacto  = new contactoActions(driver);
    private final contactoActions ContactoActions;

    public contactoSteps() throws IOException {
        // Asegurarse que el driver existe
        if (Hooks.driver == null) {
            throw new IllegalStateException("WebDriver no ha sido inicializado");
        }
        this.ContactoActions = new contactoActions(Hooks.driver);
    }


    @When("ingresa un rut de afiliado: hoja: {string} fila: {int}")
    public void ingresa_un_rut_para_evaluar_hoja(String sheetName, int row) throws Throwable {
        try {
            ContactoActions.ingresoRut(sheetName, row);
        } catch (Exception e) {
            System.err.println("Error al ingresar RUT: " + e.getMessage());
            throw e;
        }
        Thread.sleep(5000);

    }

    @And("usuario comprueba afiliacion y comunicacion hoja: {string} fila: {int}")
    public void usuarioCompruebaLaAfiliacionYPreferenciasDeComunicacion(String sheetName, int row) throws Exception {
        ContactoActions.afiliacionCheck(sheetName, row); // mejoras: revisar validaciones en seccion afiliaciones para multicotizantes
        ContactoActions.PreferenciaComunicacionTelefono();
        ContactoActions.PreferenciaComunicacionCorreo();
        ContactoActions.PreferenciaComunicacion();
        //ContactoActions.PreferenciaComunicacionDireccion();


    }

    @Given("ejecutivo ingresa rut de afiliado hoja: {string} fila: {int}")
    public void ElEjecutivoIngresaRutDeAfiliadoHojaFilaNroEscenario(String sheetName, int row) throws Exception {

        try {
            ContactoActions.ingresoRut(sheetName, row);
        } catch (Exception e) {
            System.err.println("Error al ingresar RUT: " + e.getMessage());
            throw e;
        }
        Thread.sleep(5000);


    }

    @And("ha ingresado a la sección de {string} de Siebel")
    public void haIngresadoALaSecciónDeDeSiebel(String menuOption) throws InterruptedException {

        ContactoActions.MenuOption(menuOption);
    }
}
