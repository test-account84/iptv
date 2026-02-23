package com.amplifyframework.core.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface Model {

    public enum Type {
        USER,
        SYSTEM
    }

    String getModelName();

    String getPrimaryKeyString();

    Serializable resolveIdentifier();
}
