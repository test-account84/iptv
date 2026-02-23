package J1;

import java.io.Closeable;
import java.io.Flushable;
import okio.BufferedSink;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h implements Closeable, Flushable {
    public int a = 0;
    public final int[] c = new int[32];
    public final String[] d = new String[32];
    public final int[] e = new int[32];
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;

    public static h i(BufferedSink bufferedSink) {
        return new g(bufferedSink);
    }

    public abstract h a();

    public abstract h c();

    public abstract h d();

    public abstract h e();

    public abstract h g(String str);

    public final String getPath() {
        return f.a(this.a, this.c, this.d, this.e);
    }

    public abstract h h();

    public final int j() {
        int i = this.a;
        if (i != 0) {
            return this.c[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void k(int i) {
        int i2 = this.a;
        int[] iArr = this.c;
        if (i2 != iArr.length) {
            this.a = i2 + 1;
            iArr[i2] = i;
        } else {
            throw new N1.a("Nesting too deep at " + getPath() + ": circular reference?");
        }
    }

    public final void l(int i) {
        this.c[this.a - 1] = i;
    }

    public final void m(boolean z) {
        this.h = z;
    }

    public abstract h n(Boolean bool);

    public abstract h o(Number number);

    public abstract h p(String str);

    public abstract h q(boolean z);
}
