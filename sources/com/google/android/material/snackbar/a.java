package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import d.D;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a {
    public static a c;
    public final Object a = new Object();
    public final Handler b = new Handler(Looper.getMainLooper(), new a());

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a aVar = a.this;
            D.a(message.obj);
            aVar.c(null);
            return true;
        }
    }

    public interface b {
    }

    public static class c {
    }

    public static a b() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public final boolean a(c cVar, int i) {
        throw null;
    }

    public void c(c cVar) {
        synchronized (this.a) {
            a(cVar, 2);
        }
    }

    public final boolean d(b bVar) {
        return false;
    }

    public void e(b bVar) {
        synchronized (this.a) {
            try {
                if (d(bVar)) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.a) {
            try {
                if (d(bVar)) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
