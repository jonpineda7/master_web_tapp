package app.com.steps.repactacion;

import app.support.browsers.Browser;
import io.cucumber.java.en.When;
import app.pages.repactacion.RepactacionActions;

public class RepactacionSteps {

    private RepactacionActions repactacionActions;

    public RepactacionSteps() {
        this.repactacionActions = new RepactacionActions(Browser.getDriver());
    }

    @When("ejecutivo ingresa datos a repactar hoja: {string} fila: {int}")
    public void el_usuario_visualiza_el_detalle_de_la_repactacion(String sheetName, int row) throws Exception {
        repactacionActions.enterDataNewRepactacion(sheetName, row);
    }
}
