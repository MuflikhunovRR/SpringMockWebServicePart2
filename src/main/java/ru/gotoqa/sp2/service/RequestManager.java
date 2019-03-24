package ru.gotoqa.sp2.service;

import ru.gotoqa.sp2.models.PhonesByCardNumberRq;

import java.util.Collection;

/**
 * @author Muflikhunov Roman
 */
public interface RequestManager {

    public PhonesByCardNumberRq createRequest(PhonesByCardNumberRq cardNumberRq);

    public boolean updateRequest(PhonesByCardNumberRq cardNumberRq);

    public boolean deleteRequest(String rqUid);

    public PhonesByCardNumberRq getRequest(String rqUid);

    public Collection<PhonesByCardNumberRq> getRequest();
}
