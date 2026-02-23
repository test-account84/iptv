package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.t;
import com.squareup.picasso.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class z extends y {
    public final Context a;

    public z(Context context) {
        this.a = context;
    }

    public static Bitmap j(Resources resources, int i, w wVar) {
        BitmapFactory.Options d = y.d(wVar);
        if (y.g(d)) {
            BitmapFactory.decodeResource(resources, i, d);
            y.b(wVar.h, wVar.i, d, wVar);
        }
        return BitmapFactory.decodeResource(resources, i, d);
    }

    public boolean c(w wVar) {
        if (wVar.e != 0) {
            return true;
        }
        return "android.resource".equals(wVar.d.getScheme());
    }

    public y.a f(w wVar, int i) {
        Resources o = G.o(this.a, wVar);
        return new y.a(j(o, G.n(o, wVar), wVar), t.e.DISK);
    }
}
