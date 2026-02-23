package g1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h {
    public final boolean a;
    public final boolean b;

    public static final class a {
        public boolean a;
        public boolean b;

        public a() {
        }

        public h a() {
            if (this.a) {
                return new h(true, this.b, null);
            }
            throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
        }

        public a b() {
            this.a = true;
            return this;
        }

        public /* synthetic */ a(L l) {
            this();
        }
    }

    public h(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public static a c() {
        return new a(null);
    }

    public boolean a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public /* synthetic */ h(boolean z, boolean z2, M m) {
        this(z, z2);
    }
}
