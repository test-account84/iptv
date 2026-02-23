package com.squareup.okhttp.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String name;

    public NamedRunnable(String str, Object... objArr) {
        this.name = String.format(str, objArr);
    }

    public abstract void execute();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            execute();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
