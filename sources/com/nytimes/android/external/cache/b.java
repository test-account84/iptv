package com.nytimes.android.external.cache;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class b extends w {
    public Object a;

    public b(Object obj) {
        this.a = obj;
    }

    public abstract Object a(Object obj);

    public final boolean hasNext() {
        return this.a != null;
    }

    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            Object obj = this.a;
            this.a = a(obj);
            return obj;
        } catch (Throwable th) {
            this.a = a(this.a);
            throw th;
        }
    }
}
