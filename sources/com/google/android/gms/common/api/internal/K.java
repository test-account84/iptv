package com.google.android.gms.common.api.internal;

import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k {
    public final Executor a;
    public volatile Object b;
    public volatile a c;

    public static final class a {
        public final Object a;
        public final String b;

        public a(Object obj, String str) {
            this.a = obj;
            this.b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b.equals(aVar.b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 31) + this.b.hashCode();
        }
    }

    public interface b {
        void notifyListener(Object obj);

        void onNotifyListenerFailed();
    }

    public k(Looper looper, Object obj, String str) {
        this.a = new D4.a(looper);
        this.b = com.google.android.gms.common.internal.r.n(obj, "Listener must not be null");
        this.c = new a(obj, com.google.android.gms.common.internal.r.g(str));
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public a b() {
        return this.c;
    }

    public void c(b bVar) {
        com.google.android.gms.common.internal.r.n(bVar, "Notifier must not be null");
        this.a.execute(new w0(this, bVar));
    }

    public final void d(b bVar) {
        Object obj = this.b;
        if (obj == null) {
            bVar.onNotifyListenerFailed();
            return;
        }
        try {
            bVar.notifyListener(obj);
        } catch (RuntimeException e) {
            bVar.onNotifyListenerFailed();
            throw e;
        }
    }
}
