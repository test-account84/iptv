package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum EventType {
    SignIn("SignIn"),
    SignUp("SignUp"),
    ForgotPassword("ForgotPassword"),
    PasswordChange("PasswordChange"),
    ResendCode("ResendCode");

    private static final Map enumMap;
    private String value;

    static {
        EventType eventType = SignIn;
        EventType eventType2 = SignUp;
        EventType eventType3 = ForgotPassword;
        EventType eventType4 = PasswordChange;
        EventType eventType5 = ResendCode;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SignIn", eventType);
        hashMap.put("SignUp", eventType2);
        hashMap.put("ForgotPassword", eventType3);
        hashMap.put("PasswordChange", eventType4);
        hashMap.put("ResendCode", eventType5);
    }

    EventType(String str) {
        this.value = str;
    }

    public static EventType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (EventType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
