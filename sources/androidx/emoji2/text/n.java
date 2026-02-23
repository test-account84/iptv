package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class n extends SpannableStringBuilder {
    public final Class a;
    public final List c;

    public static class a implements TextWatcher, SpanWatcher {
        public final Object a;
        public final AtomicInteger c = new AtomicInteger(0);

        public a(Object obj) {
            this.a = obj;
        }

        public final void a() {
            this.c.incrementAndGet();
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.a).afterTextChanged(editable);
        }

        public final boolean b(Object obj) {
            return obj instanceof i;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.a).beforeTextChanged(charSequence, i, i2, i3);
        }

        public final void c() {
            this.c.decrementAndGet();
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if (this.c.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.a).onSpanAdded(spannable, obj, i, i2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x001e A[PHI: r11
          0x001e: PHI (r11v1 int) = (r11v0 int), (r11v3 int) binds: [B:8:0x0013, B:12:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onSpanChanged(android.text.Spannable r9, java.lang.Object r10, int r11, int r12, int r13, int r14) {
            /*
                r8 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r8.c
                int r0 = r0.get()
                if (r0 <= 0) goto Lf
                boolean r0 = r8.b(r10)
                if (r0 == 0) goto Lf
                return
            Lf:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 28
                if (r0 >= r1) goto L1e
                r0 = 0
                if (r11 <= r12) goto L19
                r11 = 0
            L19:
                if (r13 <= r14) goto L1e
                r4 = r11
                r6 = 0
                goto L20
            L1e:
                r4 = r11
                r6 = r13
            L20:
                java.lang.Object r11 = r8.a
                r1 = r11
                android.text.SpanWatcher r1 = (android.text.SpanWatcher) r1
                r2 = r9
                r3 = r10
                r5 = r12
                r7 = r14
                r1.onSpanChanged(r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.n.a.onSpanChanged(android.text.Spannable, java.lang.Object, int, int, int, int):void");
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if (this.c.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.a).onSpanRemoved(spannable, obj, i, i2);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.a).onTextChanged(charSequence, i, i2, i3);
        }
    }

    public n(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.c = new ArrayList();
        O.h.g(cls, "watcherClass cannot be null");
        this.a = cls;
    }

    public static n c(Class cls, CharSequence charSequence) {
        return new n(cls, charSequence);
    }

    public void a() {
        b();
    }

    public final void b() {
        for (int i = 0; i < this.c.size(); i++) {
            ((a) this.c.get(i)).a();
        }
    }

    public void d() {
        i();
        e();
    }

    public final void e() {
        for (int i = 0; i < this.c.size(); i++) {
            ((a) this.c.get(i)).onTextChanged(this, 0, length(), length());
        }
    }

    public final a f(Object obj) {
        for (int i = 0; i < this.c.size(); i++) {
            a aVar = (a) this.c.get(i);
            if (aVar.a == obj) {
                return aVar;
            }
        }
        return null;
    }

    public final boolean g(Class cls) {
        return this.a == cls;
    }

    public int getSpanEnd(Object obj) {
        a f;
        if (h(obj) && (f = f(obj)) != null) {
            obj = f;
        }
        return super.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        a f;
        if (h(obj) && (f = f(obj)) != null) {
            obj = f;
        }
        return super.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        a f;
        if (h(obj) && (f = f(obj)) != null) {
            obj = f;
        }
        return super.getSpanStart(obj);
    }

    public Object[] getSpans(int i, int i2, Class cls) {
        if (!g(cls)) {
            return super.getSpans(i, i2, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i, i2, a.class);
        Object[] objArr = (Object[]) Array.newInstance(cls, aVarArr.length);
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            objArr[i3] = aVarArr[i3].a;
        }
        return objArr;
    }

    public final boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    public final void i() {
        for (int i = 0; i < this.c.size(); i++) {
            ((a) this.c.get(i)).c();
        }
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i, i2, cls);
    }

    public void removeSpan(Object obj) {
        a aVar;
        if (h(obj)) {
            aVar = f(obj);
            if (aVar != null) {
                obj = aVar;
            }
        } else {
            aVar = null;
        }
        super.removeSpan(obj);
        if (aVar != null) {
            this.c.remove(aVar);
        }
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.c.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i, i2, i3);
    }

    public CharSequence subSequence(int i, int i2) {
        return new n(this.a, this, i, i2);
    }

    public n(Class cls, CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
        this.c = new ArrayList();
        O.h.g(cls, "watcherClass cannot be null");
        this.a = cls;
    }

    public SpannableStringBuilder delete(int i, int i2) {
        super.delete(i, i2);
        return this;
    }

    public SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence) {
        b();
        super.replace(i, i2, charSequence);
        i();
        return this;
    }

    public SpannableStringBuilder append(char c) {
        super.append(c);
        return this;
    }

    public SpannableStringBuilder insert(int i, CharSequence charSequence, int i2, int i3) {
        super.insert(i, charSequence, i2, i3);
        return this;
    }

    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        b();
        super.replace(i, i2, charSequence, i3, i4);
        i();
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence, int i, int i2) {
        super.append(charSequence, i, i2);
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }
}
