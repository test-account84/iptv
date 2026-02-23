package androidx.emoji2.text;

import L.t;
import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class m {
    public final c0.b a;
    public final char[] b;
    public final a c = new a(1024);
    public final Typeface d;

    public static class a {
        public final SparseArray a;
        public g b;

        public a() {
            this(1);
        }

        public a a(int i) {
            SparseArray sparseArray = this.a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i);
        }

        public final g b() {
            return this.b;
        }

        public void c(g gVar, int i, int i2) {
            a a = a(gVar.b(i));
            if (a == null) {
                a = new a();
                this.a.put(gVar.b(i), a);
            }
            if (i2 > i) {
                a.c(gVar, i + 1, i2);
            } else {
                a.b = gVar;
            }
        }

        public a(int i) {
            this.a = new SparseArray(i);
        }
    }

    public m(Typeface typeface, c0.b bVar) {
        this.d = typeface;
        this.a = bVar;
        this.b = new char[bVar.k() * 2];
        a(bVar);
    }

    public static m b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            t.a("EmojiCompat.MetadataRepo.create");
            return new m(typeface, l.b(byteBuffer));
        } finally {
            t.b();
        }
    }

    public final void a(c0.b bVar) {
        int k = bVar.k();
        for (int i = 0; i < k; i++) {
            g gVar = new g(this, i);
            Character.toChars(gVar.f(), this.b, i * 2);
            h(gVar);
        }
    }

    public char[] c() {
        return this.b;
    }

    public c0.b d() {
        return this.a;
    }

    public int e() {
        return this.a.l();
    }

    public a f() {
        return this.c;
    }

    public Typeface g() {
        return this.d;
    }

    public void h(g gVar) {
        O.h.g(gVar, "emoji metadata cannot be null");
        O.h.a(gVar.c() > 0, "invalid metadata codepoint length");
        this.c.c(gVar, 0, gVar.c() - 1);
    }
}
