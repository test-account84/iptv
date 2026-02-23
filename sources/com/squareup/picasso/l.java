package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class l extends a {
    public e m;

    public l(t tVar, ImageView imageView, w wVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, e eVar, boolean z) {
        super(tVar, imageView, wVar, i, i2, i3, drawable, str, obj, z);
        this.m = eVar;
    }

    public void a() {
        super.a();
        if (this.m != null) {
            this.m = null;
        }
    }

    public void b(Bitmap bitmap, t.e eVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ImageView imageView = (ImageView) this.c.get();
        if (imageView == null) {
            return;
        }
        t tVar = this.a;
        u.c(imageView, tVar.e, bitmap, eVar, this.d, tVar.m);
        e eVar2 = this.m;
        if (eVar2 != null) {
            eVar2.onSuccess();
        }
    }

    public void c() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView == null) {
            return;
        }
        int i = this.g;
        if (i != 0) {
            imageView.setImageResource(i);
        } else {
            Drawable drawable = this.h;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        e eVar = this.m;
        if (eVar != null) {
            eVar.a();
        }
    }
}
