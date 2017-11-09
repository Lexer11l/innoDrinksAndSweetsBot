package bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

public class DrinkBot extends TelegramLongPollingBot {

    private static final String PRIVET = "Привет";
    private static final String HOW_ARE_YOU = "Как дела?";
    private static final String WHAT_ARE_YOU_DOING = "Чё делаешь?";
    private static final String SHARE_NUMBERS = "Скинь цифры";
    private static final String BYE = "Пока";
    private static final String BABKI = "Чё с деньгами?";



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
        CallbackQuery query = update.getCallbackQuery();
        if ( query != null && update.hasCallbackQuery()) {
            switch(update.getCallbackQuery().getData()){
                case "/help":
                    sendMsgWithInlineKeyBoard(query, "Привет, я робот");
                    break;
                case PRIVET:
                    sendMsgWithInlineKeyBoard(query, "Привет!");
                    break;
                case HOW_ARE_YOU:
                    sendMsgWithInlineKeyBoard(query, "Норм, сам как?");
                    break;
                case WHAT_ARE_YOU_DOING:
                    sendMsgWithInlineKeyBoard(query, "Ботирую");
                    break;
                case SHARE_NUMBERS:
                    sendMsgWithInlineKeyBoard(query, "Нет!");
                    break;
                case BYE:
                    sendMsgWithInlineKeyBoard(query, "Пока!");
                    break;
                case BABKI:
                    sendMsgWithInlineKeyBoard(query, "С какими деньгами?");
                    break;
                default:
                    sendMsgWithInlineKeyBoard(query, "Я не знаю что ответить на это");
                    break;
            }
        }

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

        addKeyBoard(sendMessage);

        sendMessage.setChatId(message.getChatId().toString());
        //чтобы ответить на предыдущее сообщение:
        // sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMsgWithInlineKeyBoard(CallbackQuery query, String text) {
        long message_id = query.getMessage().getMessageId();
        long chat_id = query.getMessage().getChatId();

        EditMessageText new_message = new EditMessageText()
                    .setChatId(chat_id)
                    .setMessageId(toIntExact(message_id))
                    .setText(text);
        new_message.enableMarkdown(true);

        addInlineKeyBoard(new_message);

        try {
            execute(new_message);
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
        keyboardFirstRow.add("Команда 1");
        keyboardFirstRow.add("Команда 2");

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add("Команда 3");
        keyboardSecondRow.add("Команда 4");

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    private void addInlineKeyBoard(EditMessageText sendMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        // Создаем список строк клавиатуры
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new InlineKeyboardButton().setText(PRIVET).setCallbackData(PRIVET));
        keyboardFirstRow.add(new InlineKeyboardButton().setText(HOW_ARE_YOU).setCallbackData(HOW_ARE_YOU));

        // Вторая строчка клавиатуры
        List<InlineKeyboardButton> keyboardSecondRow = new ArrayList<>();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new InlineKeyboardButton().setText(WHAT_ARE_YOU_DOING).setCallbackData(WHAT_ARE_YOU_DOING));
        keyboardSecondRow.add(new InlineKeyboardButton().setText(SHARE_NUMBERS).setCallbackData(SHARE_NUMBERS));
        keyboardSecondRow.add(new InlineKeyboardButton().setText(BYE).setCallbackData(BYE));
        List<InlineKeyboardButton> keyboardThirdRow = new ArrayList<>();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new InlineKeyboardButton().setText(BABKI).setCallbackData(BABKI));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        inlineKeyboardMarkup.setKeyboard(keyboard);
    }

}
