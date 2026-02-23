package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class n extends ImageButton {
    public final d a;
    public final o c;
    public boolean d;

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.C);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.a;
        if (dVar != null) {
            dVar.b();
        }
        o oVar = this.c;
        if (oVar != null) {
            oVar.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        o oVar = this.c;
        if (oVar != null) {
            return oVar.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        o oVar = this.c;
        if (oVar != null) {
            return oVar.e();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.c.f() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        d dVar = this.a;
        if (dVar != null) {
            dVar.g(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        o oVar = this.c;
        if (oVar != null) {
            oVar.c();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        o oVar = this.c;
        if (oVar != null && drawable != null && !this.d) {
            oVar.h(drawable);
        }
        super.setImageDrawable(drawable);
        o oVar2 = this.c;
        if (oVar2 != null) {
            oVar2.c();
            if (this.d) {
                return;
            }
            this.c.b();
        }
    }

    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.d = true;
    }

    public void setImageResource(int i) {
        this.c.i(i);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        o oVar = this.c;
        if (oVar != null) {
            oVar.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        o oVar = this.c;
        if (oVar != null) {
            oVar.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        o oVar = this.c;
        if (oVar != null) {
            oVar.k(mode);
        }
    }

    public n(Context context, AttributeSet attributeSet, int i) {
        super(a0.b(context), attributeSet, i);
        this.d = false;
        Z.a(this, getContext());
        d dVar = new d(this);
        this.a = dVar;
        dVar.e(attributeSet, i);
        o oVar = new o(this);
        this.c = oVar;
        oVar.g(attributeSet, i);
    }
}
