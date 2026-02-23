package j$.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class d3 {
    public static final d3 OP;
    public static final d3 SPLITERATOR;
    public static final d3 STREAM;
    public static final d3 TERMINAL_OP;
    public static final d3 UPSTREAM_TERMINAL_OP;
    private static final /* synthetic */ d3[] a;

    static {
        d3 d3Var = new d3("SPLITERATOR", 0);
        SPLITERATOR = d3Var;
        d3 d3Var2 = new d3("STREAM", 1);
        STREAM = d3Var2;
        d3 d3Var3 = new d3("OP", 2);
        OP = d3Var3;
        d3 d3Var4 = new d3("TERMINAL_OP", 3);
        TERMINAL_OP = d3Var4;
        d3 d3Var5 = new d3("UPSTREAM_TERMINAL_OP", 4);
        UPSTREAM_TERMINAL_OP = d3Var5;
        a = new d3[]{d3Var, d3Var2, d3Var3, d3Var4, d3Var5};
    }

    public static d3 valueOf(String str) {
        return (d3) Enum.valueOf(d3.class, str);
    }

    public static d3[] values() {
        return (d3[]) a.clone();
    }
}
