package O5;

import Q5.B;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class x implements B {
    public final File a;
    public final String b;
    public final String c;

    public x(String str, String str2, File file) {
        this.b = str;
        this.c = str2;
        this.a = file;
    }

    private byte[] c() {
        byte[] bArr = new byte[8192];
        try {
            InputStream f = f();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (f == null) {
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        if (f != null) {
                            f.close();
                        }
                        return null;
                    }
                    while (true) {
                        try {
                            int read = f.read(bArr);
                            if (read <= 0) {
                                gZIPOutputStream.finish();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                gZIPOutputStream.close();
                                byteArrayOutputStream.close();
                                f.close();
                                return byteArray;
                            }
                            gZIPOutputStream.write(bArr, 0, read);
                        } finally {
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public B.d.b a() {
        byte[] c = c();
        if (c != null) {
            return B.d.b.a().b(c).c(this.b).a();
        }
        return null;
    }

    public String b() {
        return this.c;
    }

    public InputStream f() {
        if (this.a.exists() && this.a.isFile()) {
            try {
                return new FileInputStream(this.a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
