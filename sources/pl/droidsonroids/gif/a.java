package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.MediaController;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a extends Drawable implements Animatable, MediaController.MediaPlayerControl {
    public final ScheduledThreadPoolExecutor a;
    public volatile boolean c;
    public long d;
    public final Rect e;
    public final Paint f;
    public final Bitmap g;
    public final GifInfoHandle h;
    public final ConcurrentLinkedQueue i;
    public ColorStateList j;
    public PorterDuffColorFilter k;
    public PorterDuff.Mode l;
    public final boolean m;
    public final f n;
    public final i o;
    public final Rect p;
    public ScheduledFuture q;
    public int r;
    public int s;

    public class a extends j {
        public a(a aVar) {
            super(aVar);
        }

        public void a() {
            if (a.this.h.r()) {
                a.this.start();
            }
        }
    }

    public class b extends j {
        public final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i) {
            super(aVar);
            this.c = i;
        }

        public void a() {
            a aVar = a.this;
            aVar.h.v(this.c, aVar.g);
            this.a.n.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public a(ContentResolver contentResolver, Uri uri) {
        this(GifInfoHandle.o(contentResolver, uri), null, null, true);
    }

    public final void a() {
        ScheduledFuture scheduledFuture = this.q;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.n.removeMessages(-1);
    }

    public int b() {
        return this.h.a();
    }

    public int c() {
        int b2 = this.h.b();
        return (b2 == 0 || b2 < this.h.f()) ? b2 : b2 - 1;
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return d() > 1;
    }

    public boolean canSeekForward() {
        return d() > 1;
    }

    public int d() {
        return this.h.i();
    }

    public void draw(Canvas canvas) {
        boolean z;
        if (this.k == null || this.f.getColorFilter() != null) {
            z = false;
        } else {
            this.f.setColorFilter(this.k);
            z = true;
        }
        canvas.drawBitmap(this.g, this.p, this.e, this.f);
        if (z) {
            this.f.setColorFilter((ColorFilter) null);
        }
    }

    public boolean e() {
        return this.h.m();
    }

    public void f() {
        this.a.execute(new a(this));
    }

    public final void g() {
        if (this.m && this.c) {
            long j = this.d;
            if (j != Long.MIN_VALUE) {
                long max = Math.max(0L, j - SystemClock.uptimeMillis());
                this.d = Long.MIN_VALUE;
                this.a.remove(this.o);
                this.q = this.a.schedule(this.o, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public int getAlpha() {
        return this.f.getAlpha();
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        return 100;
    }

    public ColorFilter getColorFilter() {
        return this.f.getColorFilter();
    }

    public int getCurrentPosition() {
        return this.h.c();
    }

    public int getDuration() {
        return this.h.d();
    }

    public int getIntrinsicHeight() {
        return this.s;
    }

    public int getIntrinsicWidth() {
        return this.r;
    }

    public int getOpacity() {
        return (!this.h.l() || this.f.getAlpha() < 255) ? -2 : -1;
    }

    public void h(int i) {
        this.h.w(i);
    }

    public final void i() {
        this.c = false;
        this.n.removeMessages(-1);
        this.h.p();
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        g();
    }

    public boolean isPlaying() {
        return this.c;
    }

    public boolean isRunning() {
        return this.c;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.j) != null && colorStateList.isStateful());
    }

    public void j(long j) {
        if (this.m) {
            this.d = 0L;
            this.n.sendEmptyMessageAtTime(-1, 0L);
        } else {
            a();
            this.q = this.a.schedule(this.o, Math.max(j, 0L), TimeUnit.MILLISECONDS);
        }
    }

    public final PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void onBoundsChange(Rect rect) {
        this.e.set(rect);
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.j;
        if (colorStateList == null || (mode = this.l) == null) {
            return false;
        }
        this.k = k(colorStateList, mode);
        return true;
    }

    public void pause() {
        stop();
    }

    public void seekTo(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.a.execute(new b(this, i));
    }

    public void setAlpha(int i) {
        this.f.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.f.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.k = k(colorStateList, this.l);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.l = mode;
        this.k = k(this.j, mode);
        invalidateSelf();
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.m) {
            if (z) {
                if (z2) {
                    f();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    public void start() {
        synchronized (this) {
            try {
                if (this.c) {
                    return;
                }
                this.c = true;
                j(this.h.s());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void stop() {
        synchronized (this) {
            try {
                if (this.c) {
                    this.c = false;
                    a();
                    this.h.u();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", new Object[]{Integer.valueOf(this.h.k()), Integer.valueOf(this.h.e()), Integer.valueOf(this.h.i()), Integer.valueOf(this.h.g())});
    }

    public a(AssetFileDescriptor assetFileDescriptor) {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public a(AssetManager assetManager, String str) {
        this(assetManager.openFd(str));
    }

    public a(Resources resources, int i) {
        this(resources.openRawResourceFd(i));
        float b2 = e.b(resources, i);
        this.s = (int) (this.h.e() * b2);
        this.r = (int) (this.h.k() * b2);
    }

    public a(GifInfoHandle gifInfoHandle, a aVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.c = true;
        this.d = Long.MIN_VALUE;
        this.e = new Rect();
        this.f = new Paint(6);
        this.i = new ConcurrentLinkedQueue();
        i iVar = new i(this);
        this.o = iVar;
        this.m = z;
        this.a = scheduledThreadPoolExecutor == null ? c.a() : scheduledThreadPoolExecutor;
        this.h = gifInfoHandle;
        Bitmap bitmap = null;
        if (aVar != null) {
            synchronized (aVar.h) {
                try {
                    if (!aVar.h.m() && aVar.h.e() >= gifInfoHandle.e() && aVar.h.k() >= gifInfoHandle.k()) {
                        aVar.i();
                        bitmap = aVar.g;
                        bitmap.eraseColor(0);
                    }
                } finally {
                }
            }
        }
        if (bitmap == null) {
            this.g = Bitmap.createBitmap(gifInfoHandle.k(), gifInfoHandle.e(), Bitmap.Config.ARGB_8888);
        } else {
            this.g = bitmap;
        }
        this.g.setHasAlpha(!gifInfoHandle.l());
        this.p = new Rect(0, 0, gifInfoHandle.k(), gifInfoHandle.e());
        this.n = new f(this);
        iVar.a();
        this.r = gifInfoHandle.k();
        this.s = gifInfoHandle.e();
    }
}
