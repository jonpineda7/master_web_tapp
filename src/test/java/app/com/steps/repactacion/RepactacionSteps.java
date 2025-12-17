package app.com.steps.repactacion;

import io.cucumber.java.en.When;
import pages.repactacion.RepactacionActions;
import steps.Hooks;

public class RepactacionSteps {

    private RepactacionActions repactacionActions;

    public RepactacionSteps(){
        this.repactacionActions = new RepactacionActions(Hooks.driver);
    }

    @When("ejecutivo ingresa datos a repactar hoja: {string} fila: {int}")
    public void el_usuario_visualiza_el_detalle_de_la_repactacion(String sheetName, int row) throws Exception {
        repactacionActions.enterDataNewRepactacion(sheetName, row);

    }
}
