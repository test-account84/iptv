package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.emoji2.text.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements e.d {
    public static final ThreadLocal b = new ThreadLocal();
    public final TextPaint a;

    public d() {
        TextPaint textPaint = new TextPaint();
        this.a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public static StringBuilder b() {
        ThreadLocal threadLocal = b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    public boolean a(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23 && i3 > i4) {
            return false;
        }
        StringBuilder b2 = b();
        b2.setLength(0);
        while (i < i2) {
            b2.append(charSequence.charAt(i));
            i++;
        }
        return G.d.a(this.a, b2.toString());
    }
}
