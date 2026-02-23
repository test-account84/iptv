package d2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class r {
    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        float width;
        float height;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i && bitmap2.getHeight() == i2) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        float f = 0.0f;
        if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
            width = i2 / bitmap2.getHeight();
            f = (i - (bitmap2.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap2.getWidth();
            height = (i2 - (bitmap2.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f + 0.5f), (int) (height + 0.5f));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, d(bitmap2));
        }
        g(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap b(Bitmap bitmap, V1.b bVar, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * min);
        int height = (int) (bitmap.getHeight() * min);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap.Config d = d(bitmap);
        Bitmap d2 = bVar.d(width, height, d);
        if (d2 == null) {
            d2 = Bitmap.createBitmap(width, height, d);
        }
        g(bitmap, d2);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + "x" + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + d2.getWidth() + "x" + d2.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v("TransformationUtils", sb.toString());
        }
        Canvas canvas = new Canvas(d2);
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return d2;
    }

    public static int c(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap.Config d(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static void e(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
        matrix.postScale(-1.0f, 1.0f);
    }

    public static Bitmap f(Bitmap bitmap, V1.b bVar, int i) {
        Matrix matrix = new Matrix();
        e(i, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Bitmap.Config d = d(bitmap);
        Bitmap d2 = bVar.d(round, round2, d);
        if (d2 == null) {
            d2 = Bitmap.createBitmap(round, round2, d);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(d2).drawBitmap(bitmap, matrix, new Paint(6));
        return d2;
    }

    public static void g(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
