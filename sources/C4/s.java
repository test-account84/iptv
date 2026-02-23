package c4;

import d4.k0;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s extends BufferedOutputStream {
    public boolean a;

    public s(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(OutputStream outputStream) {
        d4.a.g(this.a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.a = false;
    }

    public void close() {
        this.a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            k0.g1(th);
        }
    }

    public s(OutputStream outputStream, int i) {
        super(outputStream, i);
    }
}
