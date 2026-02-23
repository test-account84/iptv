package com.squareup.picasso;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.squareup.picasso.t;
import com.squareup.picasso.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class k extends g {
    public k(Context context) {
        super(context);
    }

    public static int k(Uri uri) {
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    public boolean c(w wVar) {
        return "file".equals(wVar.d.getScheme());
    }

    public y.a f(w wVar, int i) {
        return new y.a(null, j(wVar), t.e.DISK, k(wVar.d));
    }
}
