package app.support.utils;

import io.cucumber.java.Scenario;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Jira {

    private static final String PROP_JIRA_UPDATE = "JIRA_UPDATE"; // SI|NO
    private static final String PROP_PREFIX_TAG = "PREFIX_TAG"; // TEST2025

    // Si quieres consolidar resultados y enviarlos al final, los guardas aquí
    private final Map<String, String> results = new ConcurrentHashMap<>();

    public void reportScenarioResult(Scenario scenario) {
        if (!isEnabled()) {
            System.out.println("[JIRA] Actualización deshabilitada (JIRA_UPDATE != SI)");
            return;
        }

        String status = scenario.isFailed() ? "FAILED" : "PASSED";
        String prefix = getPrefixTag();

        String testKey = extractTestKeyFromTags(prefix, scenario.getSourceTagNames());

        if (testKey == null || testKey.isBlank()) {
            System.out.println(
                    "[JIRA] (SKIP) No se encontró tag Jira con prefijo '" + prefix + "' en: " + scenario.getName());
            return;
        }

        results.put(testKey, status);

        // Log claro para CI
        System.out.println("[JIRA] Scenario='" + scenario.getName() + "' Key=" + testKey + " Status=" + status);

        // Conexión con ApiClient
        ApiClient.updateJiraExecution(testKey, status);
    }

    public void finishExecution() {
        if (!isEnabled())
            return;

        // Por ahora: log de cierre
        System.out.println("[JIRA] Finalizando ejecución. Total resultados: " + results.size());

        // ✅ Si tu integración crea/actualiza Test Execution, aquí lo haces:
        // ApiClient.importExecution(results, ...);
    }

    private boolean isEnabled() {
        return "SI".equalsIgnoreCase(get(PROP_JIRA_UPDATE, "NO"));
    }

    private String getPrefixTag() {
        return get(PROP_PREFIX_TAG, "TEST");
    }

    private String extractTestKeyFromTags(String prefix, Collection<String> tags) {
        if (prefix == null || prefix.isBlank() || tags == null || tags.isEmpty()) {
            return null;
        }

        String expectedPrefix = "@" + prefix + "-";
        return tags.stream()
                .filter(tag -> tag.startsWith(expectedPrefix))
                .map(tag -> tag.substring(1)) // saca el @
                .findFirst()
                .orElse(null);
    }

    private String get(String key, String defaultValue) {
        String v = System.getProperty(key);
        if (v == null || v.isBlank())
            v = System.getenv(key);
        return (v == null || v.isBlank()) ? defaultValue : v;
    }
}