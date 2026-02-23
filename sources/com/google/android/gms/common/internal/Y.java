package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class y implements a.d {
    public static final y c = a().a();
    public final String b;

    public static class a {
        public String a;

        public /* synthetic */ a(B b) {
        }

        public y a() {
            return new y(this.a, null);
        }
    }

    public /* synthetic */ y(String str, C c2) {
        this.b = str;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.b;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y) {
            return q.b(this.b, ((y) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return q.c(this.b);
    }
}
