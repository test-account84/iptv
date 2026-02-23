package s1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import okio.Okio;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {
    public static k1.b a(Response response, int i, int i2, Bitmap.Config config, BitmapFactory.Options options, ImageView.ScaleType scaleType) {
        Bitmap bitmap;
        byte[] bArr = new byte[0];
        try {
            bArr = Okio.buffer(response.body().source()).readByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (i == 0 && i2 == 0) {
            options.inPreferredConfig = config;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            int g = g(i, i2, i3, i4, scaleType);
            int g2 = g(i2, i, i4, i3, scaleType);
            options.inJustDecodeBounds = false;
            options.inSampleSize = c(i3, i4, g, g2);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray == null || (decodeByteArray.getWidth() <= g && decodeByteArray.getHeight() <= g2)) {
                bitmap = decodeByteArray;
            } else {
                bitmap = Bitmap.createScaledBitmap(decodeByteArray, g, g2, true);
                decodeByteArray.recycle();
            }
        }
        return bitmap == null ? k1.b.a(e(new m1.a(response))) : k1.b.f(bitmap);
    }

    public static k1.b b(Response response, int i, int i2, Bitmap.Config config, ImageView.ScaleType scaleType) {
        return a(response, i, i2, config, new BitmapFactory.Options(), scaleType);
    }

    public static int c(int i, int i2, int i3, int i4) {
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

    public static m1.a d(m1.a aVar) {
        aVar.e("connectionError");
        aVar.d(0);
        return aVar;
    }

    public static m1.a e(m1.a aVar) {
        aVar.d(0);
        aVar.e("parseError");
        return aVar;
    }

    public static m1.a f(m1.a aVar, k1.a aVar2, int i) {
        m1.a G = aVar2.G(aVar);
        G.d(i);
        G.e("responseFromServerError");
        return G;
    }

    public static int g(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
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

    public static void h(Response response, String str, String str2) {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[2048];
        InputStream inputStream = null;
        try {
            InputStream byteStream = response.body().byteStream();
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                fileOutputStream = new FileOutputStream(new File(file, str2));
                while (true) {
                    try {
                        int read = byteStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = byteStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fileOutputStream == null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            throw th;
                        }
                    }
                }
                fileOutputStream.flush();
                try {
                    byteStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static void i(p1.a aVar, long j, long j2, long j3, boolean z) {
        l1.b.b().a().a().execute(new a(aVar, j, j2, j3, z));
    }

    public class a implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ boolean e;

        public a(p1.a aVar, long j, long j2, long j3, boolean z) {
            this.a = j;
            this.c = j2;
            this.d = j3;
            this.e = z;
        }

        public void run() {
        }
    }
}
