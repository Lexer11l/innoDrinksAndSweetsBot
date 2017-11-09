package bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        System.out.println("HEROKU!");

        try {
            telegramBotsApi.registerBot(new DrinkBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("V");
    }

}
