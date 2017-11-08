package bot;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.ArrayList;
import java.util.List;

public class DrinkBot extends TelegramLongPollingBot {

    public static final String PRIVET = "Привет";
    public static final String HOW_ARE_YOU = "Как дела?";
    public static final String WHAT_ARE_YOU_DOING = "Чё делаешь?";
    public static final String SHARE_NUMBERS = "Скинь цифры";
    public static final String BYE = "Пока";

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

    @Override
    public String getBotUsername() {
        return "@InnoDrinksAndSweetsBot:";
    }

    @Override
    public String getBotToken() {
        return "474191917:AAEk7DBYRqGQCypnEqaB7kLr6XBprwhY-tg";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch(message.getText()){
                case "/help":
                    sendMsg(message, "Привет, я робот");
                    break;
                case PRIVET:
                    sendMsg(message, "Привет!");
                    break;
                case HOW_ARE_YOU:
                    sendMsg(message, "Норм, сам как?");
                    break;
                case WHAT_ARE_YOU_DOING:
                    sendMsg(message, "Ботирую");
                    break;
                case SHARE_NUMBERS:
                    sendMsg(message, "Нет!");
                    break;
                case BYE:
                    sendMsg(message, "Пока!");
                    break;
                default:
                    sendMsg(message, "Я не знаю что ответить на это");
                    break;
            }
        }
    }

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);

        addInlineKeyBoard(sendMessage);

        sendMessage.setChatId(message.getChatId().toString());
        //чтобы ответить на предыдущее сообщение:
        // sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void addKeyBoard(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("Комманда 1");
        keyboardFirstRow.add("Комманда 2");

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add("Комманда 3");
        keyboardSecondRow.add("Комманда 4");

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    private void addInlineKeyBoard(SendMessage sendMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        // Создаем список строк клавиатуры
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new InlineKeyboardButton(PRIVET));
        keyboardFirstRow.add(new InlineKeyboardButton(HOW_ARE_YOU));

        // Вторая строчка клавиатуры
        List<InlineKeyboardButton> keyboardSecondRow = new ArrayList<>();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new InlineKeyboardButton(WHAT_ARE_YOU_DOING));
        keyboardSecondRow.add(new InlineKeyboardButton(SHARE_NUMBERS));
        keyboardSecondRow.add(new InlineKeyboardButton(BYE));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        inlineKeyboardMarkup.setKeyboard(keyboard);
    }

}
