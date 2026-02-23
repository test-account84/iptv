package i1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class f {
    public final int a;
    public final List b;
    public final int c;
    public final InputStream d;
    public final byte[] e;

    public f(int i, List list) {
        this(i, list, -1, null);
    }

    public final InputStream a() {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.e != null) {
            return new ByteArrayInputStream(this.e);
        }
        return null;
    }

    public final int b() {
        return this.c;
    }

    public final List c() {
        return Collections.unmodifiableList(this.b);
    }

    public final int d() {
        return this.a;
    }

    public f(int i, List list, int i2, InputStream inputStream) {
        this.a = i;
        this.b = list;
        this.c = i2;
        this.d = inputStream;
        this.e = null;
    }
}
