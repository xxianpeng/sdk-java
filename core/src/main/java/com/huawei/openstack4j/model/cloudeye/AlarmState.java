package com.huawei.openstack4j.model.cloudeye;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by coa.ke on 6/24/17.
 */
public enum AlarmState {
    OK, ALARM, INSUFFICIENT_DATA;

    @JsonValue
    public String value() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static AlarmState value(String v)
    {
        try {
            return valueOf(v.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
