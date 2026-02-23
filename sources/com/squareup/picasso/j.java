package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface j {

    public static class a {
        public final InputStream a;
        public final Bitmap b;
        public final boolean c;
        public final long d;

        public a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.a = inputStream;
            this.b = null;
            this.c = z;
            this.d = j;
        }

        public Bitmap a() {
            return this.b;
        }

        public long b() {
            return this.d;
        }

        public InputStream c() {
            return this.a;
        }
    }

    public static class b extends IOException {
        public final boolean a;
        public final int c;

        public b(String str, int i, int i2) {
            super(str);
            this.a = q.isOfflineOnly(i);
            this.c = i2;
        }
    }

    a a(Uri uri, int i);
}
