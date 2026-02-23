package k;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l {
    public final TextView a;
    public final d0.f b;

    public l(TextView textView) {
        this.a = textView;
        this.b = new d0.f(textView, false);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.b.a(inputFilterArr);
    }

    public boolean b() {
        return this.b.b();
    }

    public void c(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, c.j.g0, i, 0);
        try {
            boolean z = obtainStyledAttributes.hasValue(c.j.u0) ? obtainStyledAttributes.getBoolean(c.j.u0, true) : true;
            obtainStyledAttributes.recycle();
            e(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void d(boolean z) {
        this.b.c(z);
    }

    public void e(boolean z) {
        this.b.d(z);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.b.e(transformationMethod);
    }
}
