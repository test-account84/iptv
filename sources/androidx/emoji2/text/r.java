package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import j$.util.stream.IntStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class r implements Spannable {
    public boolean a = false;
    public Spannable c;

    public static class a {
        public static IntStream a(CharSequence charSequence) {
            return q.a(charSequence);
        }

        public static IntStream b(CharSequence charSequence) {
            return p.a(charSequence);
        }
    }

    public static class b {
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof N.m;
        }
    }

    public static class c extends b {
        public boolean a(CharSequence charSequence) {
            return s.a(charSequence) || (charSequence instanceof N.m);
        }
    }

    public r(Spannable spannable) {
        this.c = spannable;
    }

    public static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    public final void a() {
        CharSequence charSequence = this.c;
        if (!this.a && c().a(charSequence)) {
            this.c = new SpannableString(charSequence);
        }
        this.a = true;
    }

    public Spannable b() {
        return this.c;
    }

    public char charAt(int i) {
        return this.c.charAt(i);
    }

    public /* synthetic */ java.util.stream.IntStream chars() {
        return IntStream.Wrapper.convert(chars());
    }

    public /* synthetic */ java.util.stream.IntStream codePoints() {
        return IntStream.Wrapper.convert(codePoints());
    }

    public int getSpanEnd(Object obj) {
        return this.c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.c.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.c.getSpanStart(obj);
    }

    public Object[] getSpans(int i, int i2, Class cls) {
        return this.c.getSpans(i, i2, cls);
    }

    public int length() {
        return this.c.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.c.nextSpanTransition(i, i2, cls);
    }

    public void removeSpan(Object obj) {
        a();
        this.c.removeSpan(obj);
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        a();
        this.c.setSpan(obj, i, i2, i3);
    }

    public CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    public String toString() {
        return this.c.toString();
    }

    public r(CharSequence charSequence) {
        this.c = new SpannableString(charSequence);
    }

    public IntStream chars() {
        return a.a(this.c);
    }

    public IntStream codePoints() {
        return a.b(this.c);
    }
}
