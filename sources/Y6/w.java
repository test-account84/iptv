package Y6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class w {
    public p a;
    public int b;
    public int c;
    public Rect d;
    public int e = 1;
    public boolean f;

    public w(byte[] bArr, int i, int i2, int i3, int i4) {
        this.a = new p(bArr, i, i2);
        this.c = i4;
        this.b = i3;
        if (i * i2 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i + "x" + i2 + " > " + bArr.length);
    }

    public x6.l a() {
        p a = this.a.h(this.c).a(this.d, this.e);
        return new x6.l(a.b(), a.d(), a.c(), 0, 0, a.d(), a.c(), false);
    }

    public Bitmap b(Rect rect, int i) {
        if (rect == null) {
            rect = new Rect(0, 0, this.a.d(), this.a.c());
        } else if (c()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.a.b(), this.b, this.a.d(), this.a.c(), (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.c == 0) {
            return decodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.c);
        return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
    }

    public boolean c() {
        return this.c % 180 != 0;
    }

    public void d(Rect rect) {
        this.d = rect;
    }

    public void e(boolean z) {
        this.f = z;
    }

    public x6.q f(x6.q qVar) {
        float c = (qVar.c() * this.e) + this.d.left;
        float d = (qVar.d() * this.e) + this.d.top;
        if (this.f) {
            c = this.a.d() - c;
        }
        return new x6.q(c, d);
    }
}
