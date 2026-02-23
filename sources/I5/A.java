package i5;

import android.graphics.Typeface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends f {
    public final Typeface a;
    public final a b;
    public boolean c;

    public interface a {
        void a(Typeface typeface);
    }

    public a(a aVar, Typeface typeface) {
        this.a = typeface;
        this.b = aVar;
    }

    public void a(int i) {
        d(this.a);
    }

    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.c = true;
    }

    public final void d(Typeface typeface) {
        if (this.c) {
            return;
        }
        this.b.a(typeface);
    }
}
