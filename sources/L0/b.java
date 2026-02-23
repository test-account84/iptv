package L0;

import F.k;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends f implements Animatable {
    public b c;
    public Context d;
    public ArgbEvaluator e;
    public Animator.AnimatorListener f;
    public ArrayList g;
    public final Drawable.Callback h;

    public class a implements Drawable.Callback {
        public a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            b.this.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    public static class b extends Drawable.ConstantState {
        public int a;
        public g b;
        public AnimatorSet c;
        public ArrayList d;
        public s.a e;

        public b(Context context, b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.a = bVar.a;
                g gVar = bVar.b;
                if (gVar != null) {
                    Drawable.ConstantState constantState = gVar.getConstantState();
                    this.b = (g) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    g gVar2 = (g) this.b.mutate();
                    this.b = gVar2;
                    gVar2.setCallback(callback);
                    this.b.setBounds(bVar.b.getBounds());
                    this.b.h(false);
                }
                ArrayList arrayList = bVar.d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.d = new ArrayList(size);
                    this.e = new s.a(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = (Animator) bVar.d.get(i);
                        Animator clone = animator.clone();
                        String str = (String) bVar.e.get(animator);
                        clone.setTarget(this.b.d(str));
                        this.d.add(clone);
                        this.e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public static class c extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public c(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            b bVar = new b();
            Drawable newDrawable = this.a.newDrawable();
            bVar.a = newDrawable;
            newDrawable.setCallback(bVar.h);
            return bVar;
        }

        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable newDrawable = this.a.newDrawable(resources);
            bVar.a = newDrawable;
            newDrawable.setCallback(bVar.h);
            return bVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable newDrawable = this.a.newDrawable(resources, theme);
            bVar.a = newDrawable;
            newDrawable.setCallback(bVar.h);
            return bVar;
        }
    }

    public b() {
        this(null, null, null);
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.a;
        if (drawable != null) {
            H.a.a(drawable, theme);
        }
    }

    public final void b(String str, Animator animator) {
        animator.setTarget(this.c.b.d(str));
        b bVar = this.c;
        if (bVar.d == null) {
            bVar.d = new ArrayList();
            this.c.e = new s.a();
        }
        this.c.d.add(animator);
        this.c.e.put(animator, str);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return H.a.b(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.c.b.draw(canvas);
        if (this.c.c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.a;
        return drawable != null ? H.a.d(drawable) : this.c.b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.c.a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.a;
        return drawable != null ? H.a.e(drawable) : this.c.b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.a.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.c.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.c.b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.getOpacity() : this.c.b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.a;
        return drawable != null ? H.a.h(drawable) : this.c.b.isAutoMirrored();
    }

    public boolean isRunning() {
        AnimatedVectorDrawable animatedVectorDrawable = this.a;
        return animatedVectorDrawable != null ? animatedVectorDrawable.isRunning() : this.c.c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.isStateful() : this.c.b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.c.b.setBounds(rect);
        }
    }

    public boolean onLevelChange(int i) {
        Drawable drawable = this.a;
        return drawable != null ? drawable.setLevel(i) : this.c.b.setLevel(i);
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.a;
        return drawable != null ? drawable.setState(iArr) : this.c.b.setState(iArr);
    }

    public void setAlpha(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.c.b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.a;
        if (drawable != null) {
            H.a.j(drawable, z);
        } else {
            this.c.b.setAutoMirrored(z);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            H.a.n(drawable, i);
        } else {
            this.c.b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.a;
        if (drawable != null) {
            H.a.o(drawable, colorStateList);
        } else {
            this.c.b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            H.a.p(drawable, mode);
        } else {
            this.c.b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.c.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        AnimatedVectorDrawable animatedVectorDrawable = this.a;
        if (animatedVectorDrawable != null) {
            animatedVectorDrawable.start();
        } else {
            if (this.c.c.isStarted()) {
                return;
            }
            this.c.c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        AnimatedVectorDrawable animatedVectorDrawable = this.a;
        if (animatedVectorDrawable != null) {
            animatedVectorDrawable.stop();
        } else {
            this.c.c.end();
        }
    }

    public b(Context context) {
        this(context, null, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        Drawable drawable = this.a;
        if (drawable != null) {
            H.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = k.s(resources, theme, attributeSet, L0.a.e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        g b2 = g.b(resources, resourceId, theme);
                        b2.h(false);
                        b2.setCallback(this.h);
                        g gVar = this.c.b;
                        if (gVar != null) {
                            gVar.setCallback((Drawable.Callback) null);
                        }
                        this.c.b = b2;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, L0.a.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.d;
                        if (context == null) {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, d.i(context, resourceId2));
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.c.a();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.c.b.setColorFilter(colorFilter);
        }
    }

    public b(Context context, b bVar, Resources resources) {
        this.e = null;
        this.f = null;
        this.g = null;
        a aVar = new a();
        this.h = aVar;
        this.d = context;
        if (bVar != null) {
            this.c = bVar;
        } else {
            this.c = new b(context, bVar, aVar, resources);
        }
    }
}
