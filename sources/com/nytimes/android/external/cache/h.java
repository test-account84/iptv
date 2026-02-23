package com.nytimes.android.external.cache;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class h {

    public static final class a extends h implements Serializable {
        public static final a a = new a();

        public boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        public int b(Object obj) {
            return obj.hashCode();
        }
    }

    public static final class b extends h implements Serializable {
        public static final b a = new b();

        public boolean a(Object obj, Object obj2) {
            return false;
        }

        public int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static h c() {
        return a.a;
    }

    public static h f() {
        return b.a;
    }

    public abstract boolean a(Object obj, Object obj2);

    public abstract int b(Object obj);

    public final boolean d(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return a(obj, obj2);
    }

    public final int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return b(obj);
    }
}
