package com.mine.telegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {
    // https://github.com/rubenlagus/TelegramBots/wiki/Getting-Started
    
    @Override
    public String getBotUsername() {
        // TODO
        return null;
    }

    @Override
    public String getBotToken() {
        // TODO
        return null;
    }

    @Override
    public void onUpdateReceived(final Update update) {
        // TODO
    }
}
