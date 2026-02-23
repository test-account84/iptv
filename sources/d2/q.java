package d2;

import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class q implements S1.e {
    public final f a;
    public V1.b b;
    public S1.a c;
    public String d;

    public q(V1.b bVar, S1.a aVar) {
        this(f.c, bVar, aVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public U1.l a(InputStream inputStream, int i, int i2) {
        return c.c(this.a.a(inputStream, this.b, i, i2, this.c), this.b);
    }

    public String getId() {
        if (this.d == null) {
            this.d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.a.getId() + this.c.name();
        }
        return this.d;
    }

    public q(f fVar, V1.b bVar, S1.a aVar) {
        this.a = fVar;
        this.b = bVar;
        this.c = aVar;
    }
}
