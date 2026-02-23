package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o0 {
    public static final Uri f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    public final String a;
    public final String b;
    public final ComponentName c;
    public final int d;
    public final boolean e;

    public o0(String str, String str2, int i, boolean z) {
        r.g(str);
        this.a = str;
        r.g(str2);
        this.b = str2;
        this.c = null;
        this.d = 4225;
        this.e = z;
    }

    public final ComponentName a() {
        return this.c;
    }

    public final Intent b(Context context) {
        Bundle bundle;
        if (this.a == null) {
            return new Intent().setComponent(this.c);
        }
        if (this.e) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.a);
            try {
                bundle = context.getContentResolver().call(f, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundle = null;
            }
            r2 = bundle != null ? (Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
            if (r2 == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.a)));
            }
        }
        return r2 == null ? new Intent(this.a).setPackage(this.b) : r2;
    }

    public final String c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return q.b(this.a, o0Var.a) && q.b(this.b, o0Var.b) && q.b(this.c, o0Var.c) && this.e == o0Var.e;
    }

    public final int hashCode() {
        return q.c(this.a, this.b, this.c, 4225, Boolean.valueOf(this.e));
    }

    public final String toString() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        r.m(this.c);
        return this.c.flattenToString();
    }
}
