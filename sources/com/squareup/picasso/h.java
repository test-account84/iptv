package com.squareup.picasso;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class h implements ViewTreeObserver.OnPreDrawListener {
    public final x a;
    public final WeakReference c;
    public e d;

    public h(x xVar, ImageView imageView, e eVar) {
        this.a = xVar;
        this.c = new WeakReference(imageView);
        this.d = eVar;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void a() {
        this.d = null;
        ImageView imageView = (ImageView) this.c.get();
        if (imageView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            viewTreeObserver.removeOnPreDrawListener(this);
            this.a.l().k(width, height).h(imageView, this.d);
        }
        return true;
    }
}
