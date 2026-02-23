package g2;

import Q1.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i implements S1.e {
    public static final b f = new b();
    public static final a g = new a();
    public final Context a;
    public final b b;
    public final V1.b c;
    public final a d;
    public final g2.a e;

    public static class a {
        public final Queue a = q2.h.c(0);

        public synchronized Q1.a a(a.a aVar) {
            Q1.a aVar2;
            aVar2 = (Q1.a) this.a.poll();
            if (aVar2 == null) {
                aVar2 = new Q1.a(aVar);
            }
            return aVar2;
        }

        public synchronized void b(Q1.a aVar) {
            aVar.b();
            this.a.offer(aVar);
        }
    }

    public static class b {
        public final Queue a = q2.h.c(0);

        public synchronized Q1.d a(byte[] bArr) {
            Q1.d dVar;
            try {
                dVar = (Q1.d) this.a.poll();
                if (dVar == null) {
                    dVar = new Q1.d();
                }
            } catch (Throwable th) {
                throw th;
            }
            return dVar.o(bArr);
        }

        public synchronized void b(Q1.d dVar) {
            dVar.a();
            this.a.offer(dVar);
        }
    }

    public i(Context context, V1.b bVar) {
        this(context, bVar, f, g);
    }

    public static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d a(InputStream inputStream, int i, int i2) {
        byte[] e = e(inputStream);
        Q1.d a2 = this.b.a(e);
        Q1.a a3 = this.d.a(this.e);
        try {
            return c(e, i, i2, a2, a3);
        } finally {
            this.b.b(a2);
            this.d.b(a3);
        }
    }

    public final d c(byte[] bArr, int i, int i2, Q1.d dVar, Q1.a aVar) {
        Bitmap d;
        Q1.c c = dVar.c();
        if (c.a() <= 0 || c.b() != 0 || (d = d(aVar, c, bArr)) == null) {
            return null;
        }
        return new d(new g2.b(this.a, this.e, this.c, c2.d.b(), i, i2, c, bArr, d));
    }

    public final Bitmap d(Q1.a aVar, Q1.c cVar, byte[] bArr) {
        aVar.n(cVar, bArr);
        aVar.a();
        return aVar.i();
    }

    public String getId() {
        return "";
    }

    public i(Context context, V1.b bVar, b bVar2, a aVar) {
        this.a = context.getApplicationContext();
        this.c = bVar;
        this.d = aVar;
        this.e = new g2.a(bVar);
        this.b = bVar2;
    }
}
