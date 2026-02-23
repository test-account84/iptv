package com.afollestad.materialdialogs.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import d1.a;
import d1.c;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MDButton extends TextView {
    public boolean a;
    public a c;
    public int d;
    public Drawable e;
    public Drawable f;

    public MDButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        a(context);
    }

    public final void a(Context context) {
        this.d = context.getResources().getDimensionPixelSize(c.d);
        this.c = a.END;
    }

    public void b(boolean z, boolean z2) {
        if (this.a != z || z2) {
            setGravity(z ? this.c.getGravityInt() | 16 : 17);
            setTextAlignment(z ? this.c.getTextAlignment() : 4);
            e1.a.c(this, z ? this.e : this.f);
            if (z) {
                setPadding(this.d, getPaddingTop(), this.d, getPaddingBottom());
            }
            this.a = z;
        }
    }

    public void setAllCapsCompat(boolean z) {
        setAllCaps(z);
    }

    public void setDefaultSelector(Drawable drawable) {
        this.f = drawable;
        if (this.a) {
            return;
        }
        b(false, true);
    }

    public void setStackedGravity(a aVar) {
        this.c = aVar;
    }

    public void setStackedSelector(Drawable drawable) {
        this.e = drawable;
        if (this.a) {
            b(true, true);
        }
    }
}
