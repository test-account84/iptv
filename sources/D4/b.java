package d4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b {
    public final File a;
    public final File b;

    public static final class a extends OutputStream {
        public final FileOutputStream a;
        public boolean c = false;

        public a(File file) {
            this.a = new FileOutputStream(file);
        }

        public void close() {
            if (this.c) {
                return;
            }
            this.c = true;
            flush();
            try {
                this.a.getFD().sync();
            } catch (IOException e) {
                B.k("AtomicFile", "Failed to sync file descriptor:", e);
            }
            this.a.close();
        }

        public void flush() {
            this.a.flush();
        }

        public void write(int i) {
            this.a.write(i);
        }

        public void write(byte[] bArr) {
            this.a.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.a.write(bArr, i, i2);
        }
    }

    public b(File file) {
        this.a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    public void a() {
        this.a.delete();
        this.b.delete();
    }

    public void b(OutputStream outputStream) {
        outputStream.close();
        this.b.delete();
    }

    public boolean c() {
        return this.a.exists() || this.b.exists();
    }

    public InputStream d() {
        e();
        return new FileInputStream(this.a);
    }

    public final void e() {
        if (this.b.exists()) {
            this.a.delete();
            this.b.renameTo(this.a);
        }
    }

    public OutputStream f() {
        if (this.a.exists()) {
            if (this.b.exists()) {
                this.a.delete();
            } else if (!this.a.renameTo(this.b)) {
                B.j("AtomicFile", "Couldn't rename file " + this.a + " to backup file " + this.b);
            }
        }
        try {
            return new a(this.a);
        } catch (FileNotFoundException e) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.a, e);
            }
            try {
                return new a(this.a);
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + this.a, e2);
            }
        }
    }
}
