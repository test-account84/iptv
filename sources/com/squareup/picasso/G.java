package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class g extends y {
    public final Context a;

    public g(Context context) {
        this.a = context;
    }

    public boolean c(w wVar) {
        return "content".equals(wVar.d.getScheme());
    }

    public y.a f(w wVar, int i) {
        return new y.a(j(wVar), t.e.DISK);
    }

    public InputStream j(w wVar) {
        return this.a.getContentResolver().openInputStream(wVar.d);
    }
}
