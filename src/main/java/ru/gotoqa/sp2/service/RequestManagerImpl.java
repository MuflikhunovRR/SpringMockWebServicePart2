package ru.gotoqa.sp2.service;

import org.springframework.stereotype.Component;
import ru.gotoqa.sp2.models.Messages;
import ru.gotoqa.sp2.models.PhonesByCardNumberRq;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Muflikhunov Roman
 */
@Component
public class RequestManagerImpl implements RequestManager{
    private Map<String, PhonesByCardNumberRq> request = new HashMap<>();

    @Override
    public PhonesByCardNumberRq createRequest(PhonesByCardNumberRq cardNumberRq) {
        PhonesByCardNumberRq newCardNumberRq = new PhonesByCardNumberRq();
        newCardNumberRq.setRqUid(cardNumberRq.getRqUid());
        Messages messagesObject = new Messages();
        messagesObject.setId(cardNumberRq.getMessages().getId());
        messagesObject.setType(cardNumberRq.getMessages().getType());
        messagesObject.setCardNumbers(cardNumberRq.getMessages().getCardNumbers());
        newCardNumberRq.setMessages(messagesObject);
        request.put(newCardNumberRq.getRqUid(), newCardNumberRq);
        return newCardNumberRq;
    }

    @Override
    public boolean updateRequest(PhonesByCardNumberRq cardNumberRq) {
        return request.replace(cardNumberRq.getRqUid(), cardNumberRq) != null;
    }

    @Override
    public boolean deleteRequest(String rqUid) {
        return request.remove(rqUid) != null;
    }

    @Override
    public PhonesByCardNumberRq getRequest(String rqUid) {
        return request.get(rqUid);
    }

    @Override
    public Collection<PhonesByCardNumberRq> getRequest() {
        return request.values();
    }
}
