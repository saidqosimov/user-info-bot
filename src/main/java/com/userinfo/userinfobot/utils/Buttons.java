package com.userinfo.userinfobot.utils;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
public class Buttons {

    public ReplyKeyboardMarkup keyboardButtons() {
        return ReplyKeyboardButtonUtil.keyboard(ReplyKeyboardButtonUtil.collection(
                ReplyKeyboardButtonUtil.row(
                        ReplyKeyboardButtonUtil.requestUserButton(Constants.GET_USER_KEYWORDS[0])
                ),
                ReplyKeyboardButtonUtil.row(
                        ReplyKeyboardButtonUtil.requestPublicChatButton(Constants.GET_SGROUP_KEYWORDS[0]),
                        ReplyKeyboardButtonUtil.requestPrivateChatButton(Constants.GET_PGROUP_KEYWORDS[0])
                ),
                ReplyKeyboardButtonUtil.row(
                        ReplyKeyboardButtonUtil.requestPublicChannelButton(Constants.GET_SCHANNEL_KEYWORDS[0]),
                        ReplyKeyboardButtonUtil.requestPrivateChannelButton(Constants.GET_PCHANNEL_KEYWORDS[0])
                ),
                ReplyKeyboardButtonUtil.row(
                        ReplyKeyboardButtonUtil.requestBotButton(Constants.GET_BOTS_KEYWORDS[0]),
                        ReplyKeyboardButtonUtil.requestPremiumUserButton(Constants.GET_PREMIUMUSERS_KEYWORDS[0])
                )
        ));
    }
}
