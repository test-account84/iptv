package com.amazonaws.services.s3.internal.crypto;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class SecuredCEK {
    private final byte[] encrypted;
    private final String keyWrapAlgorithm;
    private final Map matdesc;

    public SecuredCEK(byte[] bArr, String str, Map map) {
        this.encrypted = bArr;
        this.keyWrapAlgorithm = str;
        this.matdesc = Collections.unmodifiableMap(new TreeMap(map));
    }

    public byte[] getEncrypted() {
        return this.encrypted;
    }

    public String getKeyWrapAlgorithm() {
        return this.keyWrapAlgorithm;
    }

    public Map getMaterialDescription() {
        return this.matdesc;
    }
}
