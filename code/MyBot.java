package code;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class MyBot extends TelegramLongPollingBot {

    // Здесь нужно указать токен вашего бота
    private final String BOT_TOKEN = "6070234115:AAGvwjAvTqYocvLOk3EVflk5_U--6d0pfCM";
    // Здесь нужно указать ваш chatId
    private final String CHAT_ID = "480828614";
    @Override
    public void onUpdateReceived(Update update) {
        // Метод onUpdateReceived вызывается при получении нового сообщения.
        // Мы его не используем, поэтому оставляем пустым.
    }

    public void sendMessage(String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(CHAT_ID);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Yuskbot";
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
