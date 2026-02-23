package mbanje.kurt.fabbutton;

import M8.e;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class CircleImageView extends AppCompatImageView {
    public int e;
    public int f;
    public int g;
    public boolean h;
    public int i;
    public Paint j;
    public b k;
    public final int l;
    public int m;
    public Paint n;
    public float o;
    public float p;
    public Drawable[] q;
    public TransitionDrawable r;
    public int s;
    public ObjectAnimator t;
    public float u;
    public float v;
    public float w;
    public int x;
    public boolean y;
    public boolean z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            if (CircleImageView.c(CircleImageView.this) != null) {
                CircleImageView.c(CircleImageView.this).b(CircleImageView.d(CircleImageView.this));
            }
        }
    }

    public interface b {
        void a();

        void b(boolean z);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 75;
        this.p = 0.14f;
        this.q = new Drawable[2];
        this.u = 3.5f;
        this.v = 0.0f;
        this.w = 10.0f;
        this.x = 100;
        this.z = true;
        e(context, attributeSet);
    }

    public static /* synthetic */ b c(CircleImageView circleImageView) {
        return circleImageView.k;
    }

    public static /* synthetic */ boolean d(CircleImageView circleImageView) {
        return circleImageView.h;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        setFocusable(false);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        setClickable(true);
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setStyle(Paint.Style.FILL);
        int i = getResources().getDisplayMetrics().densityDpi;
        this.w = i <= 240 ? 1.0f : i <= 320 ? 3.0f : 10.0f;
        Paint paint2 = new Paint(1);
        this.n = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        setWillNotDraw(false);
        setLayerType(1, (Paint) null);
        int i2 = -16777216;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.a);
            i2 = obtainStyledAttributes.getColor(e.j, -16777216);
            this.p = obtainStyledAttributes.getFloat(e.o, this.p);
            this.w = obtainStyledAttributes.getFloat(e.i, this.w);
            this.u = obtainStyledAttributes.getFloat(e.h, this.u);
            this.v = obtainStyledAttributes.getFloat(e.g, this.v);
            setShowShadow(obtainStyledAttributes.getBoolean(e.q, true));
            obtainStyledAttributes.recycle();
        }
        setColor(i2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "currentRingWidth", new float[]{0.0f, 0.0f});
        this.t = ofFloat;
        ofFloat.setDuration(200L);
        this.t.addListener(new a());
    }

    public void f(int i, int i2) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        if (!this.y) {
            setImageBitmap(decodeResource);
        } else {
            g(new BitmapDrawable(getResources(), decodeResource), new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), i2)));
        }
    }

    public final void g(Drawable drawable, Drawable drawable2) {
        Drawable[] drawableArr = this.q;
        drawableArr[0] = drawable;
        drawableArr[1] = drawable2;
        TransitionDrawable transitionDrawable = new TransitionDrawable(this.q);
        this.r = transitionDrawable;
        transitionDrawable.setCrossFadeEnabled(true);
        setImageDrawable(this.r);
    }

    public float getCurrentRingWidth() {
        return this.o;
    }

    public void h(boolean z, boolean z2) {
        if (z) {
            this.r.startTransition(500);
        }
        if (z2) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "currentRingWidth", new float[]{0.0f, 0.0f});
            ofFloat.setFloatValues(new float[]{1.0f});
            ofFloat.setDuration(200L);
            ofFloat.start();
        }
    }

    public void i(boolean z) {
        this.h = z;
        if (z) {
            this.t.setFloatValues(new float[]{this.o, this.s});
        } else {
            this.t.setFloatValues(new float[]{this.s, 0.0f});
        }
        this.t.start();
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(this.f, this.e, this.m + this.o, this.n);
        canvas.drawCircle(this.f, this.e, this.i, this.j);
        super/*android.widget.ImageView*/.onDraw(canvas);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super/*android.widget.ImageView*/.onSizeChanged(i, i2, i3, i4);
        this.f = i / 2;
        this.e = i2 / 2;
        int min = Math.min(i, i2) / 2;
        this.g = min;
        int round = Math.round(min * this.p);
        this.s = round;
        this.i = this.g - round;
        this.n.setStrokeWidth(round);
        this.n.setAlpha(75);
        this.m = this.i - (this.s / 2);
    }

    public void setColor(int i) {
        this.j.setColor(i);
        this.n.setColor(i);
        this.n.setAlpha(75);
        invalidate();
    }

    public void setCurrentRingWidth(float f) {
        this.o = f;
        invalidate();
    }

    public void setFabViewListener(b bVar) {
        this.k = bVar;
    }

    public void setRingWidthRatio(float f) {
        this.p = f;
    }

    public void setShowEndBitmap(boolean z) {
        this.y = z;
    }

    public void setShowShadow(boolean z) {
        if (z) {
            this.j.setShadowLayer(this.w, this.v, this.u, Color.argb(this.x, 0, 0, 0));
        } else {
            this.j.clearShadowLayer();
        }
        invalidate();
    }
}
