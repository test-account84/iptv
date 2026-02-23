package O1;

import W1.a;
import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h {
    public final Context a;
    public U1.c b;
    public V1.b c;
    public W1.h d;
    public ExecutorService e;
    public ExecutorService f;
    public S1.a g;
    public a.a h;

    public h(Context context) {
        this.a = context.getApplicationContext();
    }

    public g a() {
        if (this.e == null) {
            this.e = new X1.a(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f == null) {
            this.f = new X1.a(1);
        }
        W1.i iVar = new W1.i(this.a);
        if (this.c == null) {
            this.c = new V1.d(iVar.a());
        }
        if (this.d == null) {
            this.d = new W1.g(iVar.c());
        }
        if (this.h == null) {
            this.h = new W1.f(this.a);
        }
        if (this.b == null) {
            this.b = new U1.c(this.d, this.h, this.f, this.e);
        }
        if (this.g == null) {
            this.g = S1.a.DEFAULT;
        }
        return new g(this.b, this.d, this.c, this.a, this.g);
    }
}
