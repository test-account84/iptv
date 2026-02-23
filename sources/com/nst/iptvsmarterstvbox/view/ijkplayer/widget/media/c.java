package com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
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
import tv.danmaku.ijk.media.player.ISurfaceTextureHost;
import w7.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class c extends TextureView implements com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a {
    public d a;
    public b c;

    public static final class a implements a.b {
        public c a;
        public SurfaceTexture b;
        public ISurfaceTextureHost c;

        public a(c cVar, SurfaceTexture surfaceTexture, ISurfaceTextureHost iSurfaceTextureHost) {
            this.a = cVar;
            this.b = surfaceTexture;
            this.c = iSurfaceTextureHost;
        }

        public com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a() {
            return this.a;
        }

        public void b(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer == null) {
                return;
            }
            if (!(iMediaPlayer instanceof ISurfaceTextureHolder)) {
                iMediaPlayer.setSurface(d());
                return;
            }
            ISurfaceTextureHolder iSurfaceTextureHolder = (ISurfaceTextureHolder) iMediaPlayer;
            c.f(this.a).e(false);
            SurfaceTexture surfaceTexture = iSurfaceTextureHolder.getSurfaceTexture();
            if (surfaceTexture != null) {
                this.a.setSurfaceTexture(surfaceTexture);
            } else {
                iSurfaceTextureHolder.setSurfaceTexture(this.b);
                iSurfaceTextureHolder.setSurfaceTextureHost(c.f(this.a));
            }
        }

        public SurfaceHolder c() {
            return null;
        }

        public Surface d() {
            if (this.b == null) {
                return null;
            }
            return new Surface(this.b);
        }
    }

    public static final class b implements TextureView.SurfaceTextureListener, ISurfaceTextureHost {
        public SurfaceTexture a;
        public boolean c;
        public int d;
        public int e;
        public WeakReference i;
        public boolean f = true;
        public boolean g = false;
        public boolean h = false;
        public Map j = new ConcurrentHashMap();

        public b(c cVar) {
            this.i = new WeakReference(cVar);
        }

        public static /* synthetic */ SurfaceTexture a(b bVar) {
            return bVar.a;
        }

        public void b(a.a aVar) {
            a aVar2;
            this.j.put(aVar, aVar);
            if (this.a != null) {
                aVar2 = new a((c) this.i.get(), this.a, this);
                aVar.b(aVar2, this.d, this.e);
            } else {
                aVar2 = null;
            }
            if (this.c) {
                if (aVar2 == null) {
                    aVar2 = new a((c) this.i.get(), this.a, this);
                }
                aVar.a(aVar2, 0, this.d, this.e);
            }
        }

        public void c() {
            Log.d("TextureRenderView", "didDetachFromWindow()");
            this.h = true;
        }

        public void d(a.a aVar) {
            this.j.remove(aVar);
        }

        public void e(boolean z) {
            this.f = z;
        }

        public void f() {
            Log.d("TextureRenderView", "willDetachFromWindow()");
            this.g = true;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.a = surfaceTexture;
            this.c = false;
            this.d = 0;
            this.e = 0;
            a aVar = new a((c) this.i.get(), surfaceTexture, this);
            Iterator it = this.j.keySet().iterator();
            while (it.hasNext()) {
                ((a.a) it.next()).b(aVar, 0, 0);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.a = surfaceTexture;
            this.c = false;
            this.d = 0;
            this.e = 0;
            a aVar = new a((c) this.i.get(), surfaceTexture, this);
            Iterator it = this.j.keySet().iterator();
            while (it.hasNext()) {
                ((a.a) it.next()).c(aVar);
            }
            Log.d("TextureRenderView", "onSurfaceTextureDestroyed: destroy: " + this.f);
            return this.f;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.a = surfaceTexture;
            this.c = true;
            this.d = i;
            this.e = i2;
            a aVar = new a((c) this.i.get(), surfaceTexture, this);
            Iterator it = this.j.keySet().iterator();
            while (it.hasNext()) {
                ((a.a) it.next()).a(aVar, 0, i, i2);
            }
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
            String str;
            String str2;
            String str3;
            if (surfaceTexture == null) {
                str = "releaseSurfaceTexture: null";
            } else {
                if (this.h) {
                    if (surfaceTexture != this.a) {
                        str3 = "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture";
                    } else if (this.f) {
                        str = "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView";
                    } else {
                        str3 = "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture";
                    }
                    Log.d("TextureRenderView", str3);
                    surfaceTexture.release();
                    return;
                }
                if (this.g) {
                    if (surfaceTexture != this.a) {
                        str3 = "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture";
                        Log.d("TextureRenderView", str3);
                        surfaceTexture.release();
                        return;
                    } else {
                        if (!this.f) {
                            str2 = "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView";
                            Log.d("TextureRenderView", str2);
                            e(true);
                            return;
                        }
                        str = "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView";
                    }
                } else if (surfaceTexture != this.a) {
                    str3 = "releaseSurfaceTexture: alive: release different SurfaceTexture";
                    Log.d("TextureRenderView", str3);
                    surfaceTexture.release();
                    return;
                } else {
                    if (!this.f) {
                        str2 = "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView";
                        Log.d("TextureRenderView", str2);
                        e(true);
                        return;
                    }
                    str = "releaseSurfaceTexture: alive: will released by TextureView";
                }
            }
            Log.d("TextureRenderView", str);
        }
    }

    public c(Context context) {
        super(context);
        g(context);
    }

    public static /* synthetic */ b f(c cVar) {
        return cVar.c;
    }

    private void g(Context context) {
        this.a = new d(this);
        b bVar = new b(this);
        this.c = bVar;
        setSurfaceTextureListener(bVar);
    }

    public static String h() {
        return "W91ciBUViBTZXJ2aWNlIFByb3ZpZGVyIGhhcyBub3QgcHJvdmlkZWQgeW91ciB0aGUgb3JpZ2luYWwgYXBwLg==";
    }

    public static String i() {
        return "W";
    }

    public void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.a.g(i, i2);
        requestLayout();
    }

    public void b(a.a aVar) {
        this.c.d(aVar);
    }

    public void c(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.a.h(i, i2);
        requestLayout();
    }

    public boolean d() {
        return false;
    }

    public void e(a.a aVar) {
        this.c.b(aVar);
    }

    public a.b getSurfaceHolder() {
        return new a(this, b.a(this.c), this.c);
    }

    public View getView() {
        return this;
    }

    public void onDetachedFromWindow() {
        this.c.f();
        super.onDetachedFromWindow();
        this.c.c();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(c.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(c.class.getName());
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
        this.a.f(i);
        setRotation(i);
    }
}
