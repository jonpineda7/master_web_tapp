package app.com.steps.desembolso;

import app.support.browsers.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import app.pages.riesgoDesembolso.riesgoDesembolsoActions;

public class desembolsoSteps {

    private riesgoDesembolsoActions RiesgoDesembolsoActions;

    public desembolsoSteps() {
        this.RiesgoDesembolsoActions = new riesgoDesembolsoActions(Browser.getDriver());
    }

    @And("ejecutivo acepta la oferta evaluada")
    public void usuario_acepta_la_oferta() {
        RiesgoDesembolsoActions.aceptaOferta();
    }

    @And("ejecutivo realiza el checklist documentacion")
    public void realizaElChecklistDocumentacion() {
        RiesgoDesembolsoActions.checkListDoc();
    }

    @And("ejecutivo deriva evaluacion al analista de riesgo")
    public void asignaEvaluacionARiesgo() {
        RiesgoDesembolsoActions.asignacionRiesgo();
    }

    @And("ejecutivo deriva evaluacion a riesgo")
    public void asignaEvaluacionRiesgo() {
        RiesgoDesembolsoActions.asignacionRiesgo();
    }

    @And("usuario activa credito")
    public void ActivaCredito() {
        RiesgoDesembolsoActions.activaOferta();
    }

    @And("ejecutivo agrega medio de desembolso: hoja: {string} fila: {int}")
    public void agregaMedioDeDesembolso(String sheetName, int row) throws Exception {
        RiesgoDesembolsoActions.AgregaDesembolso(sheetName, row);
    }

    @And("ejecutivo agrega efectivo a desembolso hoja: {string} fila: {int}")
    public void agregaEfectivo(String sheetName, int row) throws Exception {
        RiesgoDesembolsoActions.AgregaDesembolsoRefEfectivo(sheetName, row);
    }

    @And("ejecutivo activa el credito")
    public void activaElCredito() {
        RiesgoDesembolsoActions.activaOferta();
    }

    @Then("sistema muestra el botón para activar el crédito")
    public void VistaactivaElCredito() {
        RiesgoDesembolsoActions.vistaActivaOferta();
    }

    @And("ejecutivo reasigna actividad al analista de riesgo")
    public void realizaLaGestionDeRiesgo() {
        RiesgoDesembolsoActions.reasignaRiesgo();
    }

    @And("analista de riesgo aprueba actividad")
    public void apruebaActividadDeRiesgo() {
        RiesgoDesembolsoActions.apruebaRiesgo();
    }

    @And("ejecutivo realiza la gestion aca riesgo")
    public void usuarioRealizaLaGestionAcaRiesgo() {
        RiesgoDesembolsoActions.cerrarActividadesACA();
    }

    @And("ejecutivo realiza rollback de firma")
    public void realizaRollbackDeFirma() {
        RiesgoDesembolsoActions.rollBack();
    }

    @Then("ejecutivo finaliza proceso y activa credito")
    public void ejecutivoFinalizaProcesoYActivaCredito() {
        RiesgoDesembolsoActions.activaOfertaOK();
    }

    @And("analista de riesgo aprueba actividad repactacion")
    public void analistaDeRiesgoApruebaActividadRepactacion() {
        RiesgoDesembolsoActions.apruebaRiesgoRepa();
    }
}
