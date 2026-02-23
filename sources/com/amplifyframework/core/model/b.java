package com.amplifyframework.core.model;

import com.amplifyframework.AmplifyException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class b {
    public static Set a(ModelProvider modelProvider) {
        return new HashSet();
    }

    public static Map b(ModelProvider modelProvider) {
        return new HashMap();
    }

    public static Set c(ModelProvider modelProvider) {
        HashSet hashSet = new HashSet();
        if (modelProvider.models() == null) {
            return hashSet;
        }
        Iterator it = modelProvider.models().iterator();
        while (it.hasNext()) {
            hashSet.add(((Class) it.next()).getSimpleName());
        }
        return hashSet;
    }

    public static Map d(ModelProvider modelProvider) {
        HashMap hashMap = new HashMap();
        if (modelProvider.models() == null) {
            return hashMap;
        }
        for (Class cls : modelProvider.models()) {
            try {
                hashMap.put(cls.getSimpleName(), ModelSchema.fromModelClass(cls));
            } catch (AmplifyException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }
}
