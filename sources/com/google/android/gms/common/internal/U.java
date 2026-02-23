package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class u {
    public final Resources a;
    public final String b;

    public u(Context context) {
        r.m(context);
        Resources resources = context.getResources();
        this.a = resources;
        this.b = resources.getResourcePackageName(w4.o.a);
    }

    public String a(String str) {
        int identifier = this.a.getIdentifier(str, "string", this.b);
        if (identifier == 0) {
            return null;
        }
        return this.a.getString(identifier);
    }
}
