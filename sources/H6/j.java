package h6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface j {

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        a(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    a b(String str);
}
