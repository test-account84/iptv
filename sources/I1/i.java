package i1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import h1.m;
import h1.n;
import h1.p;
import h1.v;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i extends n {
    public static final Object x = new Object();
    public final Object r;
    public p.b s;
    public final Bitmap.Config t;
    public final int u;
    public final int v;
    public final ImageView.ScaleType w;

    public i(String str, p.b bVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, p.a aVar) {
        super(0, str, aVar);
        this.r = new Object();
        R(new h1.e(1000, 2, 2.0f));
        this.s = bVar;
        this.t = config;
        this.u = i;
        this.v = i2;
        this.w = scaleType;
    }

    public static int Y(int i, int i2, int i3, int i4) {
        double min = Math.min(i / i3, i2 / i4);
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    public static int Z(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (i3 * (i2 / i4));
        }
        if (i2 == 0) {
            return i;
        }
        double d = i4 / i3;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    public n.c B() {
        return n.c.LOW;
    }

    public p M(h1.k kVar) {
        p X;
        synchronized (x) {
            try {
                try {
                    X = X(kVar);
                } catch (OutOfMemoryError e) {
                    v.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(kVar.b.length), F());
                    return p.a(new m((Throwable) e));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return X;
    }

    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void l(Bitmap bitmap) {
        p.b bVar;
        synchronized (this.r) {
            bVar = this.s;
        }
        if (bVar != null) {
            bVar.a(bitmap);
        }
    }

    public final p X(h1.k kVar) {
        Bitmap decodeByteArray;
        byte[] bArr = kVar.b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.u == 0 && this.v == 0) {
            options.inPreferredConfig = this.t;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int Z = Z(this.u, this.v, i, i2, this.w);
            int Z2 = Z(this.v, this.u, i2, i, this.w);
            options.inJustDecodeBounds = false;
            options.inSampleSize = Y(i, i2, Z, Z2);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > Z || decodeByteArray.getHeight() > Z2)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, Z, Z2, true);
                decodeByteArray.recycle();
                decodeByteArray = createScaledBitmap;
            }
        }
        return decodeByteArray == null ? p.a(new m(kVar)) : p.c(decodeByteArray, e.e(kVar));
    }

    public void h() {
        super.h();
        synchronized (this.r) {
            this.s = null;
        }
    }
}
