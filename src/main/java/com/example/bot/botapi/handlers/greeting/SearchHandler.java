package com.example.bot.botapi.handlers.greeting;

import com.example.bot.botapi.BotState;
import com.example.bot.botapi.InputMessageHandler;
import com.example.bot.cache.UserDataCache;
import com.example.bot.service.ReplyMessagesService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class SearchHandler implements InputMessageHandler {
    private UserDataCache userDataCache;
    private ReplyMessagesService messagesService;

    public SearchHandler(UserDataCache userDataCache, ReplyMessagesService messagesService) {
        this.userDataCache = userDataCache;
        this.messagesService = messagesService;
    }

    @Override
    public SendMessage handle(Message message) {
        return processUsersInput(message);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SEARCH_SNEAKERS;
    }

    private SendMessage processUsersInput(Message inputMsg) {
        int userId = inputMsg.getFrom().getId();
        long chatId = inputMsg.getChatId();

        SendMessage replyToUser = messagesService.getReplyMessage(chatId,"");
        userDataCache.setUsersCurrentBotState(userId,BotState.FILLING_PROFILE);

        return replyToUser;
    }
}
