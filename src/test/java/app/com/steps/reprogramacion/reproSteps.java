package app.com.steps.reprogramacion;

import app.support.browsers.Browser;
import io.cucumber.java.en.And;
import app.pages.reprogramacion.reproActions;

public class reproSteps {

    reproActions ReproActions;

    public reproSteps() {
        this.ReproActions = new reproActions(Browser.getDriver());
    }

    @And("ejecutivo ingresa datos a reprogramar hoja: {string} fila: {int}")
    public void el_usuario_visualiza_el_detalle_de_la_simulacion(String sheetName, int row) throws Exception {
        ReproActions.irReprogramar(sheetName, row);
    }
}