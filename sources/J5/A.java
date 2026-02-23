package j5;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import l5.g;
import l5.k;
import l5.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a extends Drawable implements n, H.b {
    public b a;

    public static final class b extends Drawable.ConstantState {
        public g a;
        public boolean b;

        public b(b bVar) {
            this.a = (g) bVar.a.getConstantState().newDrawable();
            this.b = bVar.b;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this), null);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public b(g gVar) {
            this.a = gVar;
            this.b = false;
        }
    }

    public a(b bVar) {
        this.a = bVar;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.a = new b(this.a);
        return this;
    }

    public void draw(Canvas canvas) {
        b bVar = this.a;
        if (bVar.b) {
            bVar.a.draw(canvas);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    public int getOpacity() {
        return this.a.a.getOpacity();
    }

    public boolean isStateful() {
        return true;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.a.setBounds(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.a.a.setState(iArr)) {
            onStateChange = true;
        }
        boolean e = j5.b.e(iArr);
        b bVar = this.a;
        if (bVar.b == e) {
            return onStateChange;
        }
        bVar.b = e;
        return true;
    }

    public void setAlpha(int i) {
        this.a.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.a.setColorFilter(colorFilter);
    }

    public void setShapeAppearanceModel(k kVar) {
        this.a.a.setShapeAppearanceModel(kVar);
    }

    public void setTint(int i) {
        this.a.a.setTint(i);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.a.a.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.a.a.setTintMode(mode);
    }

    public /* synthetic */ a(b bVar, a aVar) {
        this(bVar);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }
}
