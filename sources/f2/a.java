package F2;

import C2.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a {
    public static final a e = new a().b();
    public final f a;
    public final List b;
    public final b c;
    public final String d;

    public static final class a {
        public f a = null;
        public List b = new ArrayList();
        public b c = null;
        public String d = "";

        public a a(d dVar) {
            this.b.add(dVar);
            return this;
        }

        public a b() {
            return new a(this.a, Collections.unmodifiableList(this.b), this.c, this.d);
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a d(b bVar) {
            this.c = bVar;
            return this;
        }

        public a e(f fVar) {
            this.a = fVar;
            return this;
        }
    }

    public a(f fVar, List list, b bVar, String str) {
        this.a = fVar;
        this.b = list;
        this.c = bVar;
        this.d = str;
    }

    public static a e() {
        return new a();
    }

    public String a() {
        return this.d;
    }

    public b b() {
        return this.c;
    }

    public List c() {
        return this.b;
    }

    public f d() {
        return this.a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
