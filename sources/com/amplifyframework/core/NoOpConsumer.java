package com.amplifyframework.core;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class NoOpConsumer implements Consumer {
    private NoOpConsumer() {
    }

    public static NoOpConsumer create() {
        return new NoOpConsumer();
    }

    public void accept(Object obj) {
    }

    public boolean equals(Object obj) {
        return obj instanceof NoOpConsumer;
    }

    public int hashCode() {
        return NoOpConsumer.class.hashCode();
    }

    public String toString() {
        return "NoOpConsumer {}";
    }
}
