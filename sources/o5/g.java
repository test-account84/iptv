package O5;

import Q5.B;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g implements B {
    public final byte[] a;
    public final String b;
    public final String c;

    public g(String str, String str2, byte[] bArr) {
        this.b = str;
        this.c = str2;
        this.a = bArr;
    }

    public B.d.b a() {
        byte[] c = c();
        if (c == null) {
            return null;
        }
        return B.d.b.a().b(c).c(this.b).a();
    }

    public String b() {
        return this.c;
    }

    public final byte[] c() {
        if (d()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final boolean d() {
        byte[] bArr = this.a;
        return bArr == null || bArr.length == 0;
    }

    public InputStream f() {
        if (d()) {
            return null;
        }
        return new ByteArrayInputStream(this.a);
    }
}
