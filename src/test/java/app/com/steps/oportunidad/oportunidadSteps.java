package app.com.steps.oportunidad;

import app.support.browsers.Browser;
import io.cucumber.java.en.When;
import app.pages.oportunidad.oportunidadActions;

import java.io.IOException;

public class oportunidadSteps {

    private oportunidadActions OportunidadActions;

    public oportunidadSteps() throws IOException {
        this.OportunidadActions = new oportunidadActions(Browser.getDriver());
    }

    @When("ejecutivo ingresa una oportunidad hoja: {string} fila: {int}")
    public void entersimulationData(String sheetName, int row) throws Exception {
        if (!sheetName.equalsIgnoreCase("REPR")) {
            System.out.println("Ingresando datos en la sección oportunidades para " + sheetName);
            OportunidadActions.NewOportunidad(sheetName, row);
        } else {
            System.out.println("Se omite el paso de oportunidades para hoja: " + sheetName);
        }
    }
}
