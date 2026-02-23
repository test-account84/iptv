package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.t;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a {
    public final t a;
    public final w b;
    public final WeakReference c;
    public final boolean d;
    public final int e;
    public final int f;
    public final int g;
    public final Drawable h;
    public final String i;
    public final Object j;
    public boolean k;
    public boolean l;

    public static class a extends WeakReference {
        public final a a;

        public a(a aVar, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.a = aVar;
        }
    }

    public a(t tVar, Object obj, w wVar, int i, int i2, int i3, Drawable drawable, String str, Object obj2, boolean z) {
        this.a = tVar;
        this.b = wVar;
        this.c = obj == null ? null : new a(this, obj, tVar.k);
        this.e = i;
        this.f = i2;
        this.d = z;
        this.g = i3;
        this.h = drawable;
        this.i = str;
        this.j = obj2 == null ? this : obj2;
    }

    public void a() {
        this.l = true;
    }

    public abstract void b(Bitmap bitmap, t.e eVar);

    public abstract void c();

    public String d() {
        return this.i;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public t g() {
        return this.a;
    }

    public t.f h() {
        return this.b.r;
    }

    public w i() {
        return this.b;
    }

    public Object j() {
        return this.j;
    }

    public Object k() {
        WeakReference weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.k;
    }
}
