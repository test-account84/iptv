package org.simpleframework.xml.core;

import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class MethodName {
    private Method method;
    private String name;
    private MethodType type;

    public MethodName(Method method, MethodType methodType, String str) {
        this.method = method;
        this.type = methodType;
        this.name = str;
    }

    public Method getMethod() {
        return this.method;
    }

    public String getName() {
        return this.name;
    }

    public MethodType getType() {
        return this.type;
    }
}
