package com.userinfo.userinfobot.controller;

import com.userinfo.userinfobot.config.ApplicationConfiguration;
import com.userinfo.userinfobot.utils.Buttons;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class MainController extends TelegramLongPollingBot {
    private final ApplicationConfiguration applicationConfiguration;
    private final Buttons buttons;

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if (update.hasMessage()) {
            long chatId = update.getMessage().getChatId();
            if (update.getMessage().getUserShared() != null) {
                sendRequestUserKeyboard(chatId, "User ID : `" + update.getMessage().getUserShared().getUserId().toString()+"`");
            } else if (update.getMessage().getChatShared() != null) {
                sendRequestUserKeyboard(chatId, "Chat ID : `" + update.getMessage().getChatShared().getChatId().toString()+"`");
            } else {
                String username = "";
                if(update.getMessage().getFrom().getUserName()!=null){
                    username = "@"+update.getMessage().getFrom().getUserName();
                }
                sendRequestUserKeyboard(chatId, username+"\nYour ID : `" + chatId+"`\nName : "+update.getMessage().getFrom().getFirstName());
            }
        }

    }

    @SneakyThrows
    private void sendRequestUserKeyboard(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        message.enableMarkdown(true);
        message.setReplyMarkup(buttons.keyboardButtons());
        execute(message);
    }


    @Override
    public String getBotUsername() {
        return applicationConfiguration.getUsername();
    }

    @Override
    public String getBotToken() {
        return applicationConfiguration.getToken();
    }
}
