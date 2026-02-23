package com.journeyapps.barcodescanner;

import B6.k;
import B6.o;
import Y6.r;
import Y6.v;
import Y6.x;
import Z6.g;
import Z6.i;
import Z6.j;
import Z6.l;
import Z6.m;
import Z6.n;
import Z6.q;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a extends ViewGroup {
    public static final String B = "a";
    public final f A;
    public g a;
    public WindowManager c;
    public Handler d;
    public boolean e;
    public SurfaceView f;
    public TextureView g;
    public boolean h;
    public r i;
    public int j;
    public List k;
    public m l;
    public i m;
    public v n;
    public v o;
    public Rect p;
    public v q;
    public Rect r;
    public Rect s;
    public v t;
    public double u;
    public q v;
    public boolean w;
    public final SurfaceHolder.Callback x;
    public final Handler.Callback y;
    public Y6.q z;

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            a.a(a.this, new v(i, i2));
            a.b(a.this);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder == null) {
                Log.e(a.c(), "*** WARNING *** surfaceChanged() gave us a null surface!");
            } else {
                a.a(a.this, new v(i2, i3));
                a.b(a.this);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            a.a(a.this, null);
        }
    }

    public class c implements Handler.Callback {
        public c() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == k.j) {
                a.d(a.this, (v) message.obj);
                return true;
            }
            if (i != k.d) {
                if (i != k.c) {
                    return false;
                }
                a.e(a.this).b();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!a.this.r()) {
                return false;
            }
            a.this.u();
            a.e(a.this).c(exc);
            return false;
        }
    }

    public class d implements Y6.q {
        public d() {
        }

        public static /* synthetic */ void b(d dVar) {
            dVar.c();
        }

        public void a(int i) {
            a.f(a.this).postDelayed(new Y6.c(this), 250L);
        }

        public final /* synthetic */ void c() {
            a.g(a.this);
        }
    }

    public class e implements f {
        public e() {
        }

        public void a() {
            Iterator it = a.h(a.this).iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }

        public void b() {
            Iterator it = a.h(a.this).iterator();
            while (it.hasNext()) {
                ((f) it.next()).b();
            }
        }

        public void c(Exception exc) {
            Iterator it = a.h(a.this).iterator();
            while (it.hasNext()) {
                ((f) it.next()).c(exc);
            }
        }

        public void d() {
            Iterator it = a.h(a.this).iterator();
            while (it.hasNext()) {
                ((f) it.next()).d();
            }
        }

        public void e() {
            Iterator it = a.h(a.this).iterator();
            while (it.hasNext()) {
                ((f) it.next()).e();
            }
        }
    }

    public interface f {
        void a();

        void b();

        void c(Exception exc);

        void d();

        void e();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.h = false;
        this.j = -1;
        this.k = new ArrayList();
        this.m = new i();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = 0.1d;
        this.v = null;
        this.w = false;
        this.x = new b();
        this.y = new c();
        this.z = new d();
        this.A = new e();
        p(context, attributeSet, 0, 0);
    }

    public static /* synthetic */ v a(a aVar, v vVar) {
        aVar.q = vVar;
        return vVar;
    }

    public static /* synthetic */ void b(a aVar) {
        aVar.C();
    }

    public static /* synthetic */ String c() {
        return B;
    }

    public static /* synthetic */ void d(a aVar, v vVar) {
        aVar.w(vVar);
    }

    public static /* synthetic */ f e(a aVar) {
        return aVar.A;
    }

    public static /* synthetic */ Handler f(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ void g(a aVar) {
        aVar.z();
    }

    private int getDisplayRotation() {
        return this.c.getDefaultDisplay().getRotation();
    }

    public static /* synthetic */ List h(a aVar) {
        return aVar.k;
    }

    public final void A() {
        TextureView textureView;
        if (this.e) {
            TextureView textureView2 = new TextureView(getContext());
            this.g = textureView2;
            textureView2.setSurfaceTextureListener(D());
            textureView = this.g;
        } else {
            SurfaceView surfaceView = new SurfaceView(getContext());
            this.f = surfaceView;
            surfaceView.getHolder().addCallback(this.x);
            textureView = this.f;
        }
        addView(textureView);
    }

    public final void B(j jVar) {
        if (this.h || this.a == null) {
            return;
        }
        Log.i(B, "Starting preview");
        this.a.z(jVar);
        this.a.B();
        this.h = true;
        x();
        this.A.e();
    }

    public final void C() {
        Rect rect;
        j jVar;
        v vVar = this.q;
        if (vVar == null || this.o == null || (rect = this.p) == null) {
            return;
        }
        if (this.f == null || !vVar.equals(new v(rect.width(), this.p.height()))) {
            TextureView textureView = this.g;
            if (textureView == null || textureView.getSurfaceTexture() == null) {
                return;
            }
            if (this.o != null) {
                this.g.setTransform(l(new v(this.g.getWidth(), this.g.getHeight()), this.o));
            }
            jVar = new j(this.g.getSurfaceTexture());
        } else {
            jVar = new j(this.f.getHolder());
        }
        B(jVar);
    }

    public final TextureView.SurfaceTextureListener D() {
        return new a();
    }

    public g getCameraInstance() {
        return this.a;
    }

    public i getCameraSettings() {
        return this.m;
    }

    public Rect getFramingRect() {
        return this.r;
    }

    public v getFramingRectSize() {
        return this.t;
    }

    public double getMarginFraction() {
        return this.u;
    }

    public Rect getPreviewFramingRect() {
        return this.s;
    }

    public q getPreviewScalingStrategy() {
        q qVar = this.v;
        return qVar != null ? qVar : this.g != null ? new l() : new n();
    }

    public v getPreviewSize() {
        return this.o;
    }

    public void i(f fVar) {
        this.k.add(fVar);
    }

    public final void j() {
        v vVar;
        m mVar;
        v vVar2 = this.n;
        if (vVar2 == null || (vVar = this.o) == null || (mVar = this.l) == null) {
            this.s = null;
            this.r = null;
            this.p = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i = vVar.a;
        int i2 = vVar.c;
        int i3 = vVar2.a;
        int i4 = vVar2.c;
        Rect d2 = mVar.d(vVar);
        if (d2.width() <= 0 || d2.height() <= 0) {
            return;
        }
        this.p = d2;
        this.r = k(new Rect(0, 0, i3, i4), this.p);
        Rect rect = new Rect(this.r);
        Rect rect2 = this.p;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i) / this.p.width(), (rect.top * i2) / this.p.height(), (rect.right * i) / this.p.width(), (rect.bottom * i2) / this.p.height());
        this.s = rect3;
        if (rect3.width() > 0 && this.s.height() > 0) {
            this.A.a();
            return;
        }
        this.s = null;
        this.r = null;
        Log.w(B, "Preview frame is too small");
    }

    public Rect k(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.t != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.t.a) / 2), Math.max(0, (rect3.height() - this.t.c) / 2));
            return rect3;
        }
        int min = (int) Math.min(rect3.width() * this.u, rect3.height() * this.u);
        rect3.inset(min, min);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    public Matrix l(v vVar, v vVar2) {
        float f2;
        float f3 = vVar.a / vVar.c;
        float f4 = vVar2.a / vVar2.c;
        float f5 = 1.0f;
        if (f3 < f4) {
            f5 = f4 / f3;
            f2 = 1.0f;
        } else {
            f2 = f3 / f4;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f5, f2);
        int i = vVar.a;
        int i2 = vVar.c;
        matrix.postTranslate((i - (i * f5)) / 2.0f, (i2 - (i2 * f2)) / 2.0f);
        return matrix;
    }

    public final void m(v vVar) {
        this.n = vVar;
        g gVar = this.a;
        if (gVar == null || gVar.n() != null) {
            return;
        }
        m mVar = new m(getDisplayRotation(), vVar);
        this.l = mVar;
        mVar.e(getPreviewScalingStrategy());
        this.a.x(this.l);
        this.a.m();
        boolean z = this.w;
        if (z) {
            this.a.A(z);
        }
    }

    public g n() {
        g gVar = new g(getContext());
        gVar.w(this.m);
        return gVar;
    }

    public final void o() {
        if (this.a != null) {
            Log.w(B, "initCamera called twice");
            return;
        }
        g n = n();
        this.a = n;
        n.y(this.d);
        this.a.u();
        this.j = getDisplayRotation();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m(new v(i3 - i, i4 - i2));
        View view = this.f;
        if (view != null) {
            Rect rect = this.p;
            if (rect != null) {
                view.layout(rect.left, rect.top, rect.right, rect.bottom);
                return;
            }
        } else {
            view = this.g;
            if (view == null) {
                return;
            }
        }
        view.layout(0, 0, getWidth(), getHeight());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.w);
        return bundle;
    }

    public final void p(Context context, AttributeSet attributeSet, int i, int i2) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        q(attributeSet);
        this.c = (WindowManager) context.getSystemService("window");
        this.d = new Handler(this.y);
        this.i = new r();
    }

    public void q(AttributeSet attributeSet) {
        q oVar;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.a);
        int dimension = (int) obtainStyledAttributes.getDimension(o.c, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(o.b, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.t = new v(dimension, dimension2);
        }
        this.e = obtainStyledAttributes.getBoolean(o.e, true);
        int integer = obtainStyledAttributes.getInteger(o.d, -1);
        if (integer == 1) {
            oVar = new l();
        } else {
            if (integer != 2) {
                if (integer == 3) {
                    oVar = new Z6.o();
                }
                obtainStyledAttributes.recycle();
            }
            oVar = new n();
        }
        this.v = oVar;
        obtainStyledAttributes.recycle();
    }

    public boolean r() {
        return this.a != null;
    }

    public boolean s() {
        g gVar = this.a;
        return gVar == null || gVar.p();
    }

    public void setCameraSettings(i iVar) {
        this.m = iVar;
    }

    public void setFramingRectSize(v vVar) {
        this.t = vVar;
    }

    public void setMarginFraction(double d2) {
        if (d2 >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.u = d2;
    }

    public void setPreviewScalingStrategy(q qVar) {
        this.v = qVar;
    }

    public void setTorch(boolean z) {
        this.w = z;
        g gVar = this.a;
        if (gVar != null) {
            gVar.A(z);
        }
    }

    public void setUseTextureView(boolean z) {
        this.e = z;
    }

    public boolean t() {
        return this.h;
    }

    public void u() {
        TextureView textureView;
        SurfaceView surfaceView;
        x.a();
        Log.d(B, "pause()");
        this.j = -1;
        g gVar = this.a;
        if (gVar != null) {
            gVar.l();
            this.a = null;
            this.h = false;
        } else {
            this.d.sendEmptyMessage(k.c);
        }
        if (this.q == null && (surfaceView = this.f) != null) {
            surfaceView.getHolder().removeCallback(this.x);
        }
        if (this.q == null && (textureView = this.g) != null) {
            textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
        }
        this.n = null;
        this.o = null;
        this.s = null;
        this.i.f();
        this.A.d();
    }

    public void v() {
        g cameraInstance = getCameraInstance();
        u();
        long nanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.p() && System.nanoTime() - nanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public final void w(v vVar) {
        this.o = vVar;
        if (this.n != null) {
            j();
            requestLayout();
            C();
        }
    }

    public void x() {
    }

    public void y() {
        x.a();
        Log.d(B, "resume()");
        o();
        if (this.q != null) {
            C();
        } else {
            SurfaceView surfaceView = this.f;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.x);
            } else {
                TextureView textureView = this.g;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        D().onSurfaceTextureAvailable(this.g.getSurfaceTexture(), this.g.getWidth(), this.g.getHeight());
                    } else {
                        this.g.setSurfaceTextureListener(D());
                    }
                }
            }
        }
        requestLayout();
        this.i.e(getContext(), this.z);
    }

    public final void z() {
        if (!r() || getDisplayRotation() == this.j) {
            return;
        }
        u();
        y();
    }
}
