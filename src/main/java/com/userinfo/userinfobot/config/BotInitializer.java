package com.userinfo.userinfobot.config;

import com.userinfo.userinfobot.controller.MainController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@RequiredArgsConstructor
public class BotInitializer {
    private final MainController mainController;

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        TelegramBotsApi telegramBotApi = null;
        try {
            telegramBotApi = new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        try {
            telegramBotApi.registerBot(mainController);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}