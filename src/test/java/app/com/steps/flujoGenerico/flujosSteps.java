package app.com.steps.flujoGenerico;

import app.support.browsers.Browser;
import io.cucumber.java.en.And;
import app.pages.compraCartera.carteraActions;
import app.pages.refinanciar.refinActions;
import app.pages.repactacion.RepactacionActions;
import app.pages.reprogramacion.reproActions;
import app.pages.ventaNormalPage.ventaNormalActions;

public class flujosSteps {

    private ventaNormalActions VentaNormalActions;
    private RepactacionActions repactacionActions;
    private carteraActions CarteraActions;
    private reproActions ReproActions;
    private refinActions RefinActions;

    public flujosSteps() {
        this.ReproActions = new reproActions(Browser.getDriver());
        this.CarteraActions = new carteraActions(Browser.getDriver());
        this.RefinActions = new refinActions(Browser.getDriver());
        this.repactacionActions = new RepactacionActions(Browser.getDriver());
        this.VentaNormalActions = new ventaNormalActions(Browser.getDriver());
    }

    @And("^se gestiona (.+) \"([^\"]+)\" hoja: \"([^\"]+)\" fila: (\\d+)$")
    public void ejecutarPasoDinamico(String paso, String sheetName, int row) throws Exception {
        paso = paso.trim().replaceAll("\\s+", " ").toLowerCase();
        switch (paso) {
            case "venta normal":
                VentaNormalActions.enterCreditData(sheetName, row);
                break;
            case "repactacion":
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
