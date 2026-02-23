package t8;

import z8.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a extends s8.a {

    public static final class a {
        public static final a a = new a();
        public static final Integer b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            b = num;
        }
    }

    public c b() {
        return c(24) ? new A8.a() : super.b();
    }

    public final boolean c(int i) {
        Integer num = a.b;
        return num == null || num.intValue() >= i;
    }
}
