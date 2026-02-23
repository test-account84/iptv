package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b {
    public final int a;
    public final com.google.android.gms.common.api.a b;
    public final a.d c;
    public final String d;

    public b(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        this.b = aVar;
        this.c = dVar;
        this.d = str;
        this.a = com.google.android.gms.common.internal.q.c(aVar, dVar, str);
    }

    public static b a(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        return new b(aVar, dVar, str);
    }

    public final String b() {
        return this.b.d();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return com.google.android.gms.common.internal.q.b(this.b, bVar.b) && com.google.android.gms.common.internal.q.b(this.c, bVar.c) && com.google.android.gms.common.internal.q.b(this.d, bVar.d);
    }

    public final int hashCode() {
        return this.a;
    }
}
