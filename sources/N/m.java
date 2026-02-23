package N;

import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class m implements Spannable {

    public static final class a {
        public final TextPaint a;
        public final TextDirectionHeuristic b;
        public final int c;
        public final int d;
        public final PrecomputedText.Params e;

        public static class a {
            public final TextPaint a;
            public TextDirectionHeuristic b;
            public int c;
            public int d;

            public a(TextPaint textPaint) {
                this.a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public a a() {
                return new a(this.a, this.b, this.c, this.d);
            }

            public a b(int i) {
                this.c = i;
                return this;
            }

            public a c(int i) {
                this.d = i;
                return this;
            }

            public a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.b = textDirectionHeuristic;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            this.a = e.a(params);
            this.b = f.a(params);
            this.c = g.a(params);
            this.d = h.a(params);
            this.e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public boolean a(a aVar) {
            int i = Build.VERSION.SDK_INT;
            if ((i >= 23 && (this.c != aVar.b() || this.d != aVar.c())) || this.a.getTextSize() != aVar.e().getTextSize() || this.a.getTextScaleX() != aVar.e().getTextScaleX() || this.a.getTextSkewX() != aVar.e().getTextSkewX() || this.a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) || this.a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i >= 24) {
                if (!d.g.a(b.a(this.a), b.a(aVar.e()))) {
                    return false;
                }
            } else if (!this.a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            return this.a.getTypeface() == null ? aVar.e().getTypeface() == null : this.a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public TextDirectionHeuristic d() {
            return this.b;
        }

        public TextPaint e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.b == aVar.d();
        }

        public int hashCode() {
            return Build.VERSION.SDK_INT >= 24 ? O.c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), b.a(this.a), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d)) : O.c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder sb;
            LocaleList textLocale;
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.a.getTextSize());
            sb2.append(", textScaleX=" + this.a.getTextScaleX());
            sb2.append(", textSkewX=" + this.a.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.a.isElegantTextHeight());
            if (i >= 24) {
                sb = new StringBuilder();
                sb.append(", textLocale=");
                textLocale = b.a(this.a);
            } else {
                sb = new StringBuilder();
                sb.append(", textLocale=");
                textLocale = this.a.getTextLocale();
            }
            sb.append(textLocale);
            sb2.append(sb.toString());
            sb2.append(", typeface=" + this.a.getTypeface());
            if (i >= 26) {
                sb2.append(", variationSettings=" + d.a(this.a));
            }
            sb2.append(", textDir=" + this.b);
            sb2.append(", breakStrategy=" + this.c);
            sb2.append(", hyphenationFrequency=" + this.d);
            sb2.append("}");
            return sb2.toString();
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            this.e = Build.VERSION.SDK_INT >= 29 ? l.a(k.a(j.a(i.a(c.a(textPaint), i), i2), textDirectionHeuristic)) : null;
            this.a = textPaint;
            this.b = textDirectionHeuristic;
            this.c = i;
            this.d = i2;
        }
    }
}
