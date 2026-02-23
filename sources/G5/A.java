package g5;

import G.e;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import i5.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a {
    public static float a(String[] strArr, int i) {
        float parseFloat = Float.parseFloat(strArr[i]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    public static boolean c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("(");
        return str.startsWith(sb.toString()) && str.endsWith(")");
    }

    public static int d(Context context, int i, int i2) {
        return b.c(context, i, i2);
    }

    public static TimeInterpolator e(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be a string");
        }
        String valueOf = String.valueOf(typedValue.string);
        if (!c(valueOf, "cubic-bezier")) {
            if (c(valueOf, "path")) {
                return R.a.b(e.e(b(valueOf, "path")));
            }
            throw new IllegalArgumentException("Invalid motion easing type: " + valueOf);
        }
        String[] split = b(valueOf, "cubic-bezier").split(",");
        if (split.length == 4) {
            return R.a.a(a(split, 0), a(split, 1), a(split, 2), a(split, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
    }
}
