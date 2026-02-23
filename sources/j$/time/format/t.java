package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class t {
    public static final t LENIENT;
    public static final t SMART;
    public static final t STRICT;
    private static final /* synthetic */ t[] a;

    static {
        t tVar = new t("STRICT", 0);
        STRICT = tVar;
        t tVar2 = new t("SMART", 1);
        SMART = tVar2;
        t tVar3 = new t("LENIENT", 2);
        LENIENT = tVar3;
        a = new t[]{tVar, tVar2, tVar3};
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) a.clone();
    }
}
