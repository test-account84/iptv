package com.amplifyframework.core;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class NoOpAction implements Action {
    private NoOpAction() {
    }

    public static NoOpAction create() {
        return new NoOpAction();
    }

    public void call() {
    }

    public boolean equals(Object obj) {
        return obj instanceof NoOpAction;
    }

    public int hashCode() {
        return NoOpAction.class.hashCode();
    }

    public String toString() {
        return "NoOpAction {}";
    }
}
