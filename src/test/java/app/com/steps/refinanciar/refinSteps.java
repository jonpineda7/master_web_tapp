package app.com.steps.refinanciar;

import io.cucumber.java.en.When;
import pages.refinanciar.refinActions;
import steps.Hooks;

public class refinSteps {
    refinActions RefinActions;
    public refinSteps() {
        this.RefinActions = new refinActions(Hooks.driver);
    }

    @When("ejecutivo ingresa datos a refinanciar hoja: {string} fila: {int}")
    public void el_usuario_visualiza_el_detalle_de_la_repactacion(String sheetName, int row) throws Exception {
        RefinActions.enterDataNewRefin(sheetName, row);

    }

    @When("ejecutivo ingresa datos y efectivo hoja: {string} fila: {int}")
    public void el_usuario_visualiza_el_detalle(String sheetName, int row) throws Exception {
        RefinActions.RefinEfectivo(sheetName, row);

    }
}
