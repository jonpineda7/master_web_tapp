package app.com.steps.reprogramacion;

import io.cucumber.java.en.And;
import pages.reprogramacion.reproActions;
import steps.Hooks;

public class reproSteps {

    reproActions ReproActions;

    public reproSteps() {
        this.ReproActions = new reproActions(Hooks.driver);
    }

    @And("ejecutivo ingresa datos a reprogramar hoja: {string} fila: {int}")
    public void el_usuario_visualiza_el_detalle_de_la_simulacion(String sheetName, int row) throws Exception {
        ReproActions.irReprogramar(sheetName, row);
    }
}