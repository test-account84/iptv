package s3;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public final ByteArrayOutputStream a;
    public final DataOutputStream b;

    public c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        this.b = new DataOutputStream(byteArrayOutputStream);
    }

    public static void b(DataOutputStream dataOutputStream, String str) {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(a aVar) {
        this.a.reset();
        try {
            b(this.b, aVar.a);
            String str = aVar.c;
            if (str == null) {
                str = "";
            }
            b(this.b, str);
            this.b.writeLong(aVar.d);
            this.b.writeLong(aVar.e);
            this.b.write(aVar.f);
            this.b.flush();
            return this.a.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
