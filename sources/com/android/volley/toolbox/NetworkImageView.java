package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.toolbox.a;
import h1.u;
import i1.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NetworkImageView extends ImageView {
    public String a;
    public int c;
    public Drawable d;
    public Bitmap e;
    public int f;
    public Drawable g;
    public Bitmap h;
    public com.android.volley.toolbox.a i;
    public a.g j;

    public class a implements a.h {
        public final /* synthetic */ boolean a;

        public class a implements Runnable {
            public final /* synthetic */ a.g a;

            public a(a.g gVar) {
                this.a = gVar;
            }

            public void run() {
                a.this.b(this.a, false);
            }
        }

        public a(boolean z) {
            this.a = z;
        }

        public void a(u uVar) {
            if (NetworkImageView.a(NetworkImageView.this) != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(NetworkImageView.a(networkImageView));
            } else if (NetworkImageView.b(NetworkImageView.this) != null) {
                NetworkImageView networkImageView2 = NetworkImageView.this;
                networkImageView2.setImageDrawable(NetworkImageView.b(networkImageView2));
            } else if (NetworkImageView.c(NetworkImageView.this) != null) {
                NetworkImageView networkImageView3 = NetworkImageView.this;
                networkImageView3.setImageBitmap(NetworkImageView.c(networkImageView3));
            }
        }

        public void b(a.g gVar, boolean z) {
            if (z && this.a) {
                NetworkImageView.this.post(new a(gVar));
                return;
            }
            if (gVar.d() != null) {
                NetworkImageView.this.setImageBitmap(gVar.d());
                return;
            }
            if (NetworkImageView.d(NetworkImageView.this) != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(NetworkImageView.d(networkImageView));
            } else if (NetworkImageView.e(NetworkImageView.this) != null) {
                NetworkImageView networkImageView2 = NetworkImageView.this;
                networkImageView2.setImageDrawable(NetworkImageView.e(networkImageView2));
            } else if (NetworkImageView.f(NetworkImageView.this) != null) {
                NetworkImageView networkImageView3 = NetworkImageView.this;
                networkImageView3.setImageBitmap(NetworkImageView.f(networkImageView3));
            }
        }
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ int a(NetworkImageView networkImageView) {
        return networkImageView.f;
    }

    public static /* synthetic */ Drawable b(NetworkImageView networkImageView) {
        return networkImageView.g;
    }

    public static /* synthetic */ Bitmap c(NetworkImageView networkImageView) {
        return networkImageView.h;
    }

    public static /* synthetic */ int d(NetworkImageView networkImageView) {
        return networkImageView.c;
    }

    public static /* synthetic */ Drawable e(NetworkImageView networkImageView) {
        return networkImageView.d;
    }

    public static /* synthetic */ Bitmap f(NetworkImageView networkImageView) {
        return networkImageView.e;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(boolean r9) {
        /*
            r8 = this;
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            android.widget.ImageView$ScaleType r7 = r8.getScaleType()
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2a
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            int r2 = r2.width
            r5 = -2
            if (r2 != r5) goto L1f
            r2 = 1
            goto L20
        L1f:
            r2 = 0
        L20:
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            int r6 = r6.height
            if (r6 != r5) goto L2b
            r5 = 1
            goto L2c
        L2a:
            r2 = 0
        L2b:
            r5 = 0
        L2c:
            if (r2 == 0) goto L31
            if (r5 == 0) goto L31
            goto L32
        L31:
            r3 = 0
        L32:
            if (r0 != 0) goto L39
            if (r1 != 0) goto L39
            if (r3 != 0) goto L39
            return
        L39:
            java.lang.String r3 = r8.a
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L4f
            com.android.volley.toolbox.a$g r9 = r8.j
            if (r9 == 0) goto L4b
            r9.c()
            r9 = 0
            r8.j = r9
        L4b:
            r8.h()
            return
        L4f:
            com.android.volley.toolbox.a$g r3 = r8.j
            if (r3 == 0) goto L70
            java.lang.String r3 = r3.e()
            if (r3 == 0) goto L70
            com.android.volley.toolbox.a$g r3 = r8.j
            java.lang.String r3 = r3.e()
            java.lang.String r6 = r8.a
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L68
            return
        L68:
            com.android.volley.toolbox.a$g r3 = r8.j
            r3.c()
            r8.h()
        L70:
            if (r2 == 0) goto L73
            r0 = 0
        L73:
            if (r5 == 0) goto L77
            r6 = 0
            goto L78
        L77:
            r6 = r1
        L78:
            com.android.volley.toolbox.a r2 = r8.i
            java.lang.String r3 = r8.a
            com.android.volley.toolbox.NetworkImageView$a r4 = new com.android.volley.toolbox.NetworkImageView$a
            r4.<init>(r9)
            r5 = r0
            com.android.volley.toolbox.a$g r9 = r2.g(r3, r4, r5, r6, r7)
            r8.j = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.NetworkImageView.g(boolean):void");
    }

    public final void h() {
        int i = this.c;
        if (i != 0) {
            setImageResource(i);
            return;
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            setImageDrawable(drawable);
            return;
        }
        Bitmap bitmap = this.e;
        if (bitmap == null) {
            bitmap = null;
        }
        setImageBitmap(bitmap);
    }

    public void i(String str, com.android.volley.toolbox.a aVar) {
        l.a();
        this.a = str;
        this.i = aVar;
        g(false);
    }

    public void onDetachedFromWindow() {
        a.g gVar = this.j;
        if (gVar != null) {
            gVar.c();
            setImageBitmap((Bitmap) null);
            this.j = null;
        }
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        g(true);
    }

    public void setDefaultImageBitmap(Bitmap bitmap) {
        this.c = 0;
        this.d = null;
        this.e = bitmap;
    }

    public void setDefaultImageDrawable(Drawable drawable) {
        this.c = 0;
        this.e = null;
        this.d = drawable;
    }

    public void setDefaultImageResId(int i) {
        this.e = null;
        this.d = null;
        this.c = i;
    }

    public void setErrorImageBitmap(Bitmap bitmap) {
        this.f = 0;
        this.g = null;
        this.h = bitmap;
    }

    public void setErrorImageDrawable(Drawable drawable) {
        this.f = 0;
        this.h = null;
        this.g = drawable;
    }

    public void setErrorImageResId(int i) {
        this.h = null;
        this.g = null;
        this.f = i;
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
