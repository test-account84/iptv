package l1;

import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c implements d {
    public static final int d = (Runtime.getRuntime().availableProcessors() * 2) + 1;
    public final a a;
    public final a b;
    public final Executor c;

    public c() {
        f fVar = new f(10);
        this.a = new a(d, fVar);
        this.b = new a(2, fVar);
        this.c = new e();
    }

    public Executor a() {
        return this.c;
    }

    public a b() {
        return this.b;
    }

    public a c() {
        return this.a;
    }
}
