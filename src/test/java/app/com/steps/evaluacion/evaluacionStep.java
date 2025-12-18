package app.com.steps.evaluacion;

import app.support.browsers.Browser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import app.pages.evaluacion.evaluacionActions;

import java.io.IOException;

public class evaluacionStep {
    private evaluacionActions EvaluacionActions;

    public evaluacionStep() throws IOException {
        this.EvaluacionActions = new evaluacionActions(Browser.getDriver());
    }

    @When("ejecutivo realiza la simulación de la oferta hoja: {string} fila: {int}")
    public void entersimulationData(String sheetName, int row) throws Exception {
        EvaluacionActions.entersimulationData(sheetName, row);
    }

    @Then("sistema muestra la oferta evaluada")
    public void visualiza_la_oferta_evaluada() throws InterruptedException {
        EvaluacionActions.vistaOferta();
    }
}
