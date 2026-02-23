package i1;

import java.io.ByteArrayOutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k extends ByteArrayOutputStream {
    public final c a;

    public k(c cVar, int i) {
        this.a = cVar;
        ((ByteArrayOutputStream) this).buf = cVar.a(Math.max(i, 256));
    }

    public final void a(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] a = this.a.a((i2 + i) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a, 0, ((ByteArrayOutputStream) this).count);
        this.a.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = a;
    }

    public void close() {
        this.a.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.a.b(((ByteArrayOutputStream) this).buf);
    }

    public synchronized void write(int i) {
        a(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }
}
