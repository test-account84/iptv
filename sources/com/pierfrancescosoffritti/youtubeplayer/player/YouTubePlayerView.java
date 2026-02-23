package com.pierfrancescosoffritti.youtubeplayer.player;

import W7.c;
import W7.f;
import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.j;
import androidx.lifecycle.o;
import androidx.lifecycle.w;
import b8.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class YouTubePlayerView extends FrameLayout implements b.a, o {
    public final W7.b a;
    public Y7.a c;
    public final b8.b d;
    public final X7.b e;
    public final X7.a f;
    public b8.a g;

    public class a implements b8.a {
        public final /* synthetic */ f a;

        public class a implements f {
            public a() {
            }

            public void a(c cVar) {
                a.this.a.a(cVar);
            }
        }

        public a(f fVar) {
            this.a = fVar;
        }

        public void call() {
            YouTubePlayerView.j(YouTubePlayerView.this).h(new a());
        }
    }

    public class b extends W7.a {
        public b() {
        }

        public void l() {
            YouTubePlayerView.k(YouTubePlayerView.this, null);
        }
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ W7.b j(YouTubePlayerView youTubePlayerView) {
        return youTubePlayerView.a;
    }

    public static /* synthetic */ b8.a k(YouTubePlayerView youTubePlayerView, b8.a aVar) {
        youTubePlayerView.g = aVar;
        return aVar;
    }

    public void c() {
    }

    public void e() {
        b8.a aVar = this.g;
        if (aVar != null) {
            aVar.call();
        } else {
            this.e.a(this.a);
        }
    }

    public Y7.b getPlayerUIController() {
        Y7.a aVar = this.c;
        if (aVar != null) {
            return aVar;
        }
        throw new RuntimeException("You have inflated a custom player UI. You must manage it with your own controller.");
    }

    public final void l(c cVar) {
        Y7.a aVar = this.c;
        if (aVar != null) {
            cVar.b(aVar);
        }
        cVar.b(this.e);
        cVar.b(new b());
    }

    public void m(f fVar, boolean z) {
        if (z) {
            getContext().registerReceiver(this.d, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        this.g = new a(fVar);
        if (b8.c.b(getContext())) {
            this.g.call();
        }
    }

    public void n() {
        this.f.d(this);
    }

    public void onMeasure(int i, int i2) {
        if (getLayoutParams().height == -2) {
            i2 = View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) * 9) / 16, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @w(j.b.ON_STOP)
    public void onStop() {
        this.a.pause();
    }

    @w(j.b.ON_DESTROY)
    public void release() {
        this.a.destroy();
        try {
            getContext().unregisterReceiver(this.d);
        } catch (Exception unused) {
        }
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        W7.b bVar = new W7.b(context);
        this.a = bVar;
        addView(bVar, new FrameLayout.LayoutParams(-1, -1));
        this.c = new Y7.a(this, bVar);
        this.e = new X7.b();
        this.d = new b8.b(this);
        X7.a aVar = new X7.a();
        this.f = aVar;
        aVar.a(this.c);
        l(bVar);
    }
}
