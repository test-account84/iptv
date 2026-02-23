package j$.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class F3 {
    public static final F3 MAYBE_MORE;
    public static final F3 NO_MORE;
    public static final F3 UNLIMITED;
    private static final /* synthetic */ F3[] a;

    static {
        F3 f3 = new F3("NO_MORE", 0);
        NO_MORE = f3;
        F3 f32 = new F3("MAYBE_MORE", 1);
        MAYBE_MORE = f32;
        F3 f33 = new F3("UNLIMITED", 2);
        UNLIMITED = f33;
        a = new F3[]{f3, f32, f33};
    }

    public static F3 valueOf(String str) {
        return (F3) Enum.valueOf(F3.class, str);
    }

    public static F3[] values() {
        return (F3[]) a.clone();
    }
}
