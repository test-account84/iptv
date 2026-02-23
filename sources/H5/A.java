package h5;

import R4.b;
import R4.k;
import R4.l;
import T.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import f5.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a extends AppCompatRadioButton {
    public static final int h = k.q;
    public static final int[][] i = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public ColorStateList f;
    public boolean g;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.B);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f == null) {
            int d = Z4.a.d(this, b.h);
            int d2 = Z4.a.d(this, b.j);
            int d3 = Z4.a.d(this, b.m);
            int[][] iArr = i;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = Z4.a.h(d3, d, 1.0f);
            iArr2[1] = Z4.a.h(d3, d2, 0.54f);
            iArr2[2] = Z4.a.h(d3, d2, 0.38f);
            iArr2[3] = Z4.a.h(d3, d2, 0.38f);
            this.f = new ColorStateList(iArr, iArr2);
        }
        return this.f;
    }

    public void onAttachedToWindow() {
        super/*android.widget.RadioButton*/.onAttachedToWindow();
        if (this.g && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.g = z;
        c.c(this, z ? getMaterialThemeColorsTintList() : null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet, int i2) {
        int i3 = h;
        super(p5.a.c(context, attributeSet, i2, i3), attributeSet, i2);
        Context context2 = getContext();
        TypedArray h2 = u.h(context2, attributeSet, l.J3, i2, i3, new int[0]);
        if (h2.hasValue(l.K3)) {
            c.c(this, i5.c.a(context2, h2, l.K3));
        }
        this.g = h2.getBoolean(l.L3, false);
        h2.recycle();
    }
}
