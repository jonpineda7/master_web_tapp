package app.support.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class main {
    public static void main(String[] args) {
        ApiClient ap = new ApiClient();
        String result = ap.getCode();
        JSONArray jsonArray = new JSONArray(result);
        JSONObject primerObjeto = jsonArray.getJSONObject(0);
        // Obtener el valor de la clave "código" del primer objeto
        String codigo = primerObjeto.getString("código");

        System.out.println("Código: " + codigo);
/*
        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonObject.getString("código"));*/
    }
}
