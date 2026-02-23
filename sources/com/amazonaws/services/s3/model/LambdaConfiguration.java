package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.EnumSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LambdaConfiguration extends NotificationConfiguration implements Serializable {
    private final String functionARN;

    public LambdaConfiguration(String str, EnumSet enumSet) {
        super(enumSet);
        this.functionARN = str;
    }

    public String getFunctionARN() {
        return this.functionARN;
    }

    public LambdaConfiguration(String str, String... strArr) {
        super(strArr);
        this.functionARN = str;
    }
}
