package d4;

import android.util.SparseBooleanArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s {
    public final SparseBooleanArray a;

    public static final class b {
        public final SparseBooleanArray a = new SparseBooleanArray();
        public boolean b;

        public b a(int i) {
            d4.a.g(!this.b);
            this.a.append(i, true);
            return this;
        }

        public b b(s sVar) {
            for (int i = 0; i < sVar.d(); i++) {
                a(sVar.c(i));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i : iArr) {
                a(i);
            }
            return this;
        }

        public b d(int i, boolean z) {
            return z ? a(i) : this;
        }

        public s e() {
            d4.a.g(!this.b);
            this.b = true;
            return new s(this.a, null);
        }
    }

    public s(SparseBooleanArray sparseBooleanArray) {
        this.a = sparseBooleanArray;
    }

    public boolean a(int i) {
        return this.a.get(i);
    }

    public boolean b(int... iArr) {
        for (int i : iArr) {
            if (a(i)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i) {
        d4.a.c(i, 0, d());
        return this.a.keyAt(i);
    }

    public int d() {
        return this.a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (k0.a >= 24) {
            return this.a.equals(sVar.a);
        }
        if (d() != sVar.d()) {
            return false;
        }
        for (int i = 0; i < d(); i++) {
            if (c(i) != sVar.c(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (k0.a >= 24) {
            return this.a.hashCode();
        }
        int d = d();
        for (int i = 0; i < d(); i++) {
            d = (d * 31) + c(i);
        }
        return d;
    }

    public /* synthetic */ s(SparseBooleanArray sparseBooleanArray, a aVar) {
        this(sparseBooleanArray);
    }
}
