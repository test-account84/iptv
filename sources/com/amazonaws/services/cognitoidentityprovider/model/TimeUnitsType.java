package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum TimeUnitsType {
    Seconds("seconds"),
    Minutes("minutes"),
    Hours("hours"),
    Days("days");

    private static final Map enumMap;
    private String value;

    static {
        TimeUnitsType timeUnitsType = Seconds;
        TimeUnitsType timeUnitsType2 = Minutes;
        TimeUnitsType timeUnitsType3 = Hours;
        TimeUnitsType timeUnitsType4 = Days;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("seconds", timeUnitsType);
        hashMap.put("minutes", timeUnitsType2);
        hashMap.put("hours", timeUnitsType3);
        hashMap.put("days", timeUnitsType4);
    }

    TimeUnitsType(String str) {
        this.value = str;
    }

    public static TimeUnitsType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (TimeUnitsType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
