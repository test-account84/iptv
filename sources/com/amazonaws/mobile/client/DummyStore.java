package com.amazonaws.mobile.client;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class DummyStore implements KeyValueStore {
    private void throwNotInitializedException() {
        throw new IllegalStateException("AWSMobileClient has not been initialized yet.");
    }

    public void clear() {
        throwNotInitializedException();
    }

    public String get(String str) {
        throwNotInitializedException();
        return null;
    }

    public void set(String str, String str2) {
        throwNotInitializedException();
    }

    public Map get(String... strArr) {
        throwNotInitializedException();
        return null;
    }

    public void set(Map map) {
        throwNotInitializedException();
    }
}
