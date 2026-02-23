package E8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class q extends p {
    public static final String E0(String str, int i) {
        kotlin.jvm.internal.l.e(str, "<this>");
        if (i >= 0) {
            String substring = str.substring(B8.h.e(i, str.length()));
            kotlin.jvm.internal.l.d(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static String F0(String str, int i) {
        kotlin.jvm.internal.l.e(str, "<this>");
        if (i >= 0) {
            String substring = str.substring(0, B8.h.e(i, str.length()));
            kotlin.jvm.internal.l.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }
}
