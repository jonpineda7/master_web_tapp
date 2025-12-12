package app.support.utils;

import groovy.json.StringEscapeUtils;
import org.yaml.snakeyaml.util.UriEncoder;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static java.lang.Runtime.*;

import static java.lang.Runtime.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Telegram extends TelegramLongPollingBot {

    private final String token = "6305938723:AAFj9_DZpEiNdwqrRL3RjVekLn8PiJgob_k";
    private final String chatId = "-944529720";
    private final String url = "https://api.telegram.org/bot" + token + "/sendMessage?chat_id=" + chatId + "&text=";

    @Override
    public void onUpdateReceived(Update update) {
        // Puedes manejar las actualizaciones aquí si es necesario
    }

    @Override
    public String getBotUsername() {
        // No es necesario proporcionar un username si solo usas el token
        return "";
    }

    @Override
    public String getBotToken() {
        return token;
    }

    // Método para enviar solo texto
    public void enviarTexto(String texto) {
        String sendMessageUrl = url + texto;

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(texto);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    // Método para enviar texto con imagen
    public void enviarTextoConImagen(String texto, String rutaImagen) {
        String sendMessageUrl = url + texto;
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(texto);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(new File(rutaImagen)));

        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //Telegram telegramBot = new Telegram();

        // Ejemplo de enviar solo texto
        //telegramBot.enviarTexto("Este es un mensaje de texto");

        // Ejemplo de enviar texto con imagen
        // Reemplaza "TEXTO_DEL_MENSAJE" y "RUTA_DE_LA_IMAGEN" con los valores deseados
        //telegramBot.enviarTextoConImagen("TEXTO_DEL_MENSAJE", "RUTA_DE_LA_IMAGEN");
    }
}