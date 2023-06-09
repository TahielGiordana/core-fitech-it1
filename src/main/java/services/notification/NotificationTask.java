package services.notification;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotificationTask extends TelegramLongPollingBot {

    private String token;
    private long chatId;
    private String botUsername;

    public NotificationTask() {
        loadConfig();
    }

    private void loadConfig() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String filePath = "files/Notification.json";
            File configFile = new File(filePath);
            Config config = mapper.readValue(configFile, Config.class);
            token = config.getToken();
            chatId = config.getChatId();
            botUsername = config.getBotUsername();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Config {
        private String token;
        private long chatId;
        private String botUsername;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public long getChatId() {
            return chatId;
        }

        public void setChatId(long chatId) {
            this.chatId = chatId;
        }

        public String getBotUsername() {
            return botUsername;
        }

        public void setBotUsername(String botUsername) {
            this.botUsername = botUsername;
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
    }

    private void sendMessage(String message) {
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void initializeChat() {
        try {
            TelegramBotsApi chatBot = new TelegramBotsApi(DefaultBotSession.class);
            chatBot.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void start(String username, int score) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendMessage("¡Hola " + username + "! Su puntaje actual es: " + score + ".");
            }
        }, 5000);
        initializeChat();
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
