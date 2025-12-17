package app.com.steps.oportunidad;

import io.cucumber.java.en.When;
import pages.oportunidad.oportunidadActions;

import java.io.IOException;

import static steps.Hooks.driver;

public class oportunidadSteps {

    private oportunidadActions OportunidadActions;


    public oportunidadSteps() throws IOException {
        this.OportunidadActions = new oportunidadActions(driver);
    }

    @When("ejecutivo ingresa una oportunidad hoja: {string} fila: {int}")
    public void entersimulationData(String sheetName, int row) throws Exception {

        if (!sheetName.equalsIgnoreCase("REPR")) {
            System.out.println("Ingresando datos en la sección oportunidades para " + sheetName);
            // Aquí va la lógica real para ingresar datos
            OportunidadActions.NewOportunidad(sheetName, row);
        } else {
            System.out.println("Se omite el paso de oportunidades para hoja: " + sheetName);
        }
    }


}
