package app.com.steps.flujoGenerico;

import io.cucumber.java.en.And;
import pages.compraCartera.carteraActions;
import pages.refinanciar.refinActions;
import pages.repactacion.RepactacionActions;
import pages.reprogramacion.reproActions;
import pages.ventaNormalPage.ventaNormalActions;
import steps.Hooks;

public class flujosSteps {

    private ventaNormalActions VentaNormalActions;
    private RepactacionActions repactacionActions;
    private carteraActions CarteraActions;
    private reproActions ReproActions;
    private refinActions RefinActions;

    public flujosSteps() {
        this.ReproActions = new reproActions(Hooks.driver);
        this.CarteraActions = new carteraActions(Hooks.driver);
        this.RefinActions = new refinActions(Hooks.driver);
        this.repactacionActions = new RepactacionActions(Hooks.driver);
        this.VentaNormalActions = new ventaNormalActions(Hooks.driver);
    }

    @And("^se gestiona (.+) \"([^\"]+)\" hoja: \"([^\"]+)\" fila: (\\d+)$")
    public void ejecutarPasoDinamico(String paso, String sheetName, int row) throws Exception {
        paso = paso.trim().replaceAll("\\s+", " ").toLowerCase();
        switch (paso) {
            case "venta normal":
                VentaNormalActions.enterCreditData(sheetName, row);
                break;
            case "repactacion":
                //iniciarRepactacion(archivo, hoja, fila);
                repactacionActions.enterDataNewRepactacion(sheetName, row);
                break;
            case "compra de cartera":
                CarteraActions.enterNewCcartera(sheetName, row);
                break;
            case "refinancianciamiento":
                RefinActions.enterDataNewRefin(sheetName, row);
                break;
            case "reprogramacion":
                ReproActions.irReprogramar(sheetName, row);
                break;
            default:
                throw new IllegalArgumentException("Paso no reconocido: " + paso);
        }
    }


}
