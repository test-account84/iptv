package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class i extends ReplacementSpan {
    public final g b;
    public final Paint.FontMetricsInt a = new Paint.FontMetricsInt();
    public short c = -1;
    public short d = -1;
    public float e = 1.0f;

    public i(g gVar) {
        O.h.g(gVar, "metadata cannot be null");
        this.b = gVar;
    }

    public final g a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.a);
        Paint.FontMetricsInt fontMetricsInt2 = this.a;
        this.e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.b.e();
        this.d = (short) (this.b.e() * this.e);
        short i3 = (short) (this.b.i() * this.e);
        this.c = i3;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i3;
    }
}
