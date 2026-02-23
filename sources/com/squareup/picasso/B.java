package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.t;
import com.squareup.picasso.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b extends y {
    public static final int b = 22;
    public final AssetManager a;

    public b(Context context) {
        this.a = context.getAssets();
    }

    public static String j(w wVar) {
        return wVar.d.toString().substring(b);
    }

    public boolean c(w wVar) {
        Uri uri = wVar.d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public y.a f(w wVar, int i) {
        return new y.a(this.a.open(j(wVar)), t.e.DISK);
    }
}
