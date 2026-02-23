package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.t;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class y {

    public static final class a {
        public final t.e a;
        public final Bitmap b;
        public final InputStream c;
        public final int d;

        public a(Bitmap bitmap, t.e eVar) {
            this((Bitmap) G.d(bitmap, "bitmap == null"), null, eVar, 0);
        }

        public Bitmap a() {
            return this.b;
        }

        public int b() {
            return this.d;
        }

        public t.e c() {
            return this.a;
        }

        public InputStream d() {
            return this.c;
        }

        public a(Bitmap bitmap, InputStream inputStream, t.e eVar, int i) {
            if (!((inputStream != null) ^ (bitmap != null))) {
                throw new AssertionError();
            }
            this.b = bitmap;
            this.c = inputStream;
            this.a = (t.e) G.d(eVar, "loadedFrom == null");
            this.d = i;
        }

        public a(InputStream inputStream, t.e eVar) {
            this(null, (InputStream) G.d(inputStream, "stream == null"), eVar, 0);
        }
    }

    public static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, w wVar) {
        int max;
        double d;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                d = i3 / i;
            } else if (i == 0) {
                d = i4 / i2;
            } else {
                int floor = (int) Math.floor(i4 / i2);
                int floor2 = (int) Math.floor(i3 / i);
                max = wVar.k ? Math.max(floor, floor2) : Math.min(floor, floor2);
            }
            max = (int) Math.floor(d);
        } else {
            max = 1;
        }
        options.inSampleSize = max;
        options.inJustDecodeBounds = false;
    }

    public static void b(int i, int i2, BitmapFactory.Options options, w wVar) {
        a(i, i2, options.outWidth, options.outHeight, options, wVar);
    }

    public static BitmapFactory.Options d(w wVar) {
        boolean c = wVar.c();
        boolean z = wVar.q != null;
        if (!c && !z) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = c;
        if (z) {
            options.inPreferredConfig = wVar.q;
        }
        return options;
    }

    public static boolean g(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public abstract boolean c(w wVar);

    public int e() {
        return 0;
    }

    public abstract a f(w wVar, int i);

    public boolean h(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    public boolean i() {
        return false;
    }
}
