package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements DynamiteModule.b {
    public final DynamiteModule.b.b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.b bVar = new DynamiteModule.b.b();
        int b = aVar.b(context, str);
        bVar.a = b;
        if (b != 0) {
            bVar.c = -1;
        } else {
            int a = aVar.a(context, str, true);
            bVar.b = a;
            if (a != 0) {
                bVar.c = 1;
            }
        }
        return bVar;
    }
}
