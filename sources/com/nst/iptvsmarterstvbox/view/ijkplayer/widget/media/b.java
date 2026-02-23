package com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;
import w7.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b extends SurfaceView implements com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a {
    public d a;
    public b c;

    public static final class a implements a.b {
        public b a;
        public SurfaceHolder b;

        public a(b bVar, SurfaceHolder surfaceHolder) {
            this.a = bVar;
            this.b = surfaceHolder;
        }

        public com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a() {
            return this.a;
        }

        public void b(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer != null) {
                if (iMediaPlayer instanceof ISurfaceTextureHolder) {
                    ((ISurfaceTextureHolder) iMediaPlayer).setSurfaceTexture(null);
                }
                iMediaPlayer.setDisplay(this.b);
            }
        }

        public SurfaceHolder c() {
            return this.b;
        }
    }

    public static final class b implements SurfaceHolder.Callback {
        public SurfaceHolder a;
        public boolean c;
        public int d;
        public int e;
        public int f;
        public WeakReference g;
        public Map h = new ConcurrentHashMap();

        public b(b bVar) {
            this.g = new WeakReference(bVar);
        }

        public void a(a.a aVar) {
            a aVar2;
            this.h.put(aVar, aVar);
            if (this.a != null) {
                aVar2 = new a((b) this.g.get(), this.a);
                aVar.b(aVar2, this.e, this.f);
            } else {
                aVar2 = null;
            }
            if (this.c) {
                if (aVar2 == null) {
                    aVar2 = new a((b) this.g.get(), this.a);
                }
                aVar.a(aVar2, this.d, this.e, this.f);
            }
        }

        public void b(a.a aVar) {
            this.h.remove(aVar);
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.a = surfaceHolder;
            this.c = true;
            this.d = i;
            this.e = i2;
            this.f = i3;
            a aVar = new a((b) this.g.get(), this.a);
            Iterator it = this.h.keySet().iterator();
            while (it.hasNext()) {
                ((a.a) it.next()).a(aVar, i, i2, i3);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.a = surfaceHolder;
            this.c = false;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            a aVar = new a((b) this.g.get(), this.a);
            Iterator it = this.h.keySet().iterator();
            while (it.hasNext()) {
                ((a.a) it.next()).b(aVar, 0, 0);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.a = null;
            this.c = false;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            a aVar = new a((b) this.g.get(), this.a);
            Iterator it = this.h.keySet().iterator();
            while (it.hasNext()) {
                ((a.a) it.next()).c(aVar);
            }
        }
    }

    public b(Context context) {
        super(context);
        g(context);
    }

    public static String f() {
        return "U";
    }

    public static String h() {
        return "3VjaCBraW5kIG9mIGFwcHMgY291bGQgc2VuZCB0aGUgZGF0YSB0byBsZWdhbCBhdXRob3JpdGllcy4=";
    }

    public void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.a.g(i, i2);
        requestLayout();
    }

    public void b(a.a aVar) {
        this.c.b(aVar);
    }

    public void c(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.a.h(i, i2);
        getHolder().setFixedSize(i, i2);
        requestLayout();
    }

    public boolean d() {
        return true;
    }

    public void e(a.a aVar) {
        this.c.a(aVar);
    }

    public final void g(Context context) {
        this.a = new d(this);
        this.c = new b(this);
        getHolder().addCallback(this.c);
        getHolder().setType(0);
    }

    public View getView() {
        return this;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(b.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(b.class.getName());
    }

    public void onMeasure(int i, int i2) {
        this.a.a(i, i2);
        setMeasuredDimension(this.a.c(), this.a.b());
    }

    public void setAspectRatio(int i) {
        this.a.e(i);
        requestLayout();
    }

    public void setVideoRotation(int i) {
        Log.e("", "SurfaceView doesn't support rotation (" + i + ")!\n");
    }
}
