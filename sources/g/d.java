package G;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d {
    public static final ThreadLocal a = new ThreadLocal();

    public static class a {
        public static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean a(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("\udfffd");
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i = 0;
            while (i < length) {
                int charCount = Character.charCount(str.codePointAt(i)) + i;
                f += paint.measureText(str, i, charCount);
                i = charCount;
            }
            if (measureText3 >= f) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        O.d b = b();
        paint.getTextBounds("\udfffd", 0, 2, (Rect) b.a);
        paint.getTextBounds(str, 0, length, (Rect) b.b);
        return !((Rect) b.a).equals(b.b);
    }

    public static O.d b() {
        ThreadLocal threadLocal = a;
        O.d dVar = (O.d) threadLocal.get();
        if (dVar == null) {
            O.d dVar2 = new O.d(new Rect(), new Rect());
            threadLocal.set(dVar2);
            return dVar2;
        }
        ((Rect) dVar.a).setEmpty();
        ((Rect) dVar.b).setEmpty();
        return dVar;
    }
}
