package B2;

import B2.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class k {

    public static abstract class a {
        public abstract k a();

        public abstract a b(B2.a aVar);

        public abstract a c(b bVar);
    }

    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        b(int i) {
            this.value = i;
        }
    }

    public static a a() {
        return new e.b();
    }

    public abstract B2.a b();

    public abstract b c();
}
