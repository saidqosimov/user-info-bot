package com.userinfo.userinfobot.utils;


import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButtonRequestChat;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButtonRequestUser;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReplyKeyboardButtonUtil {
    public static KeyboardButton button(String text) {
        return new KeyboardButton(text);
    }

    public static KeyboardButton requestUserButton(String text) {
        KeyboardButtonRequestUser requestUsers = KeyboardButtonRequestUser.builder()
                .requestId("1234")
                .userIsBot(false)
                .userIsPremium(false)
                .build();

        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        button.setRequestUser(requestUsers);
        return button;
    }
    public static KeyboardButton requestPremiumUserButton(String text) {
        KeyboardButtonRequestUser requestUsers = KeyboardButtonRequestUser.builder()
                .requestId("2345")
                .userIsBot(false)
                .userIsPremium(true)
                .build();

        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        button.setRequestUser(requestUsers);
        return button;
    }
    public static KeyboardButton requestBotButton(String text) {
        KeyboardButtonRequestUser requestUsers = KeyboardButtonRequestUser.builder()
                .requestId("3456")
                .userIsBot(true)
                .userIsPremium(false)
                .build();

        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        button.setRequestUser(requestUsers);
        return button;
    }

    public static KeyboardButton requestPrivateChatButton(String text) {

        KeyboardButtonRequestChat requestChat = KeyboardButtonRequestChat.builder()
                .requestId("4567")
                .chatIsChannel(false)
                .chatHasUsername(false)
                .build();

        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        button.setRequestChat(requestChat);
        return button;
    }

    public static KeyboardButton requestPublicChatButton(String text) {

        KeyboardButtonRequestChat requestChat = KeyboardButtonRequestChat.builder()
                .requestId("5678")
                .chatIsChannel(false)
                .chatHasUsername(true)
                .build();

        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        button.setRequestChat(requestChat);
        return button;
    }

    public static KeyboardButton requestPrivateChannelButton(String text) {

        KeyboardButtonRequestChat requestChat = KeyboardButtonRequestChat.builder()
                .requestId("6789")
                .chatIsChannel(true)
                .chatHasUsername(false)
                .build();

        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        button.setRequestChat(requestChat);
        return button;
    }

    public static KeyboardButton requestPublicChannelButton(String text) {

        KeyboardButtonRequestChat requestChat = KeyboardButtonRequestChat.builder()
                .requestId("7890")
                .chatIsChannel(true)
                .chatHasUsername(true)
                .build();

        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        button.setRequestChat(requestChat);
        return button;
    }

    public static KeyboardRow row(KeyboardButton... keyboardButtons) {
        KeyboardRow row = new KeyboardRow();
        row.addAll(Arrays.asList(keyboardButtons));
        return row;
    }

    public static List<KeyboardRow> collection(KeyboardRow... rows) {
        return new LinkedList<>(Arrays.asList(rows));
    }

    public static ReplyKeyboardMarkup keyboard(List<KeyboardRow> collection) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(collection);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }
}