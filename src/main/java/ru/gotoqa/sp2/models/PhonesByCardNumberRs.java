package ru.gotoqa.sp2.models;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Muflikhunov Roman
 */

public class PhonesByCardNumberRs {
    @JsonView
    private String value;
    StatusRule StatusRuleObject;
    @JsonView
    private float timeout;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StatusRule getStatusRuleObject() {
        return StatusRuleObject;
    }

    public void setStatusRuleObject(StatusRule statusRuleObject) {
        StatusRuleObject = statusRuleObject;
    }

    public float getTimeout() {
        return timeout;
    }

    public void setTimeout(float timeout) {
        this.timeout = timeout;
    }
}
