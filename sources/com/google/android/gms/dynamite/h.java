package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h implements DynamiteModule.b {
    public final DynamiteModule.b.b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.b bVar = new DynamiteModule.b.b();
        int b = aVar.b(context, str);
        bVar.a = b;
        int i = 1;
        int i2 = 0;
        int a = b != 0 ? aVar.a(context, str, false) : aVar.a(context, str, true);
        bVar.b = a;
        int i3 = bVar.a;
        if (i3 == 0) {
            if (a == 0) {
                i = 0;
            }
            bVar.c = i;
            return bVar;
        }
        i2 = i3;
        if (a < i2) {
            i = -1;
        }
        bVar.c = i;
        return bVar;
    }
}
