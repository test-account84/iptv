package com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media;

import a7.j;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import m7.w;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerMulti4 extends FrameLayout implements MediaController.MediaPlayerControl {
    public int A;
    public boolean B;
    public SharedPreferences C;
    public SharedPreferences D;
    public Context E;
    public u7.a F;
    public com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a G;
    public int H;
    public int I;
    public Activity J;
    public NSTIJKPlayerMulti4 K;
    public AudioManager L;
    public i M;
    public LiveStreamDBHandler N;
    public Context O;
    public IMediaPlayer.OnVideoSizeChangedListener P;
    public IMediaPlayer.OnPreparedListener Q;
    public IMediaPlayer.OnCompletionListener R;
    public IMediaPlayer.OnInfoListener S;
    public IMediaPlayer.OnErrorListener T;
    public IMediaPlayer.OnBufferingUpdateListener U;
    public a.a V;
    public List W;
    public String a;
    public Uri c;
    public Map d;
    public int e;
    public int e0;
    public int f;
    public int f0;
    public int g;
    public boolean g0;
    public a.b h;
    public IMediaPlayer i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public IMediaPlayer.OnCompletionListener o;
    public IMediaPlayer.OnPreparedListener p;
    public int q;
    public IMediaPlayer.OnErrorListener r;
    public IMediaPlayer.OnInfoListener s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public Handler x;
    public boolean y;
    public int z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            NSTIJKPlayerMulti4 nSTIJKPlayerMulti4 = NSTIJKPlayerMulti4.this;
            nSTIJKPlayerMulti4.z++;
            NSTIJKPlayerMulti4.a(nSTIJKPlayerMulti4);
            w.P0(NSTIJKPlayerMulti4.b(NSTIJKPlayerMulti4.this), NSTIJKPlayerMulti4.b(NSTIJKPlayerMulti4.this).getResources().getString(j.g5) + " (" + NSTIJKPlayerMulti4.this.z + "/" + NSTIJKPlayerMulti4.p(NSTIJKPlayerMulti4.this) + ")");
            NSTIJKPlayerMulti4.this.S();
            NSTIJKPlayerMulti4.this.start();
        }
    }

    public class b implements IMediaPlayer.OnVideoSizeChangedListener {
        public b() {
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            NSTIJKPlayerMulti4.w(NSTIJKPlayerMulti4.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerMulti4.y(NSTIJKPlayerMulti4.this, iMediaPlayer.getVideoHeight());
            NSTIJKPlayerMulti4.A(NSTIJKPlayerMulti4.this, iMediaPlayer.getVideoSarNum());
            NSTIJKPlayerMulti4.C(NSTIJKPlayerMulti4.this, iMediaPlayer.getVideoSarDen());
            if (NSTIJKPlayerMulti4.v(NSTIJKPlayerMulti4.this) == 0 || NSTIJKPlayerMulti4.x(NSTIJKPlayerMulti4.this) == 0) {
                return;
            }
            if (NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this) != null) {
                NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this).c(NSTIJKPlayerMulti4.v(NSTIJKPlayerMulti4.this), NSTIJKPlayerMulti4.x(NSTIJKPlayerMulti4.this));
                NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this).a(NSTIJKPlayerMulti4.z(NSTIJKPlayerMulti4.this), NSTIJKPlayerMulti4.B(NSTIJKPlayerMulti4.this));
            }
            NSTIJKPlayerMulti4.this.requestLayout();
        }
    }

    public class c implements IMediaPlayer.OnPreparedListener {
        public c() {
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerMulti4.E(NSTIJKPlayerMulti4.this, 2);
            if (NSTIJKPlayerMulti4.F(NSTIJKPlayerMulti4.this) != null) {
                NSTIJKPlayerMulti4.F(NSTIJKPlayerMulti4.this).onPrepared(NSTIJKPlayerMulti4.c(NSTIJKPlayerMulti4.this));
            }
            NSTIJKPlayerMulti4.d(NSTIJKPlayerMulti4.this);
            NSTIJKPlayerMulti4.w(NSTIJKPlayerMulti4.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerMulti4.y(NSTIJKPlayerMulti4.this, iMediaPlayer.getVideoHeight());
            if (NSTIJKPlayerMulti4.v(NSTIJKPlayerMulti4.this) == 0 || NSTIJKPlayerMulti4.x(NSTIJKPlayerMulti4.this) == 0) {
                if (NSTIJKPlayerMulti4.i(NSTIJKPlayerMulti4.this) == 3) {
                    NSTIJKPlayerMulti4.this.start();
                }
            } else if (NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this) != null) {
                NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this).c(NSTIJKPlayerMulti4.v(NSTIJKPlayerMulti4.this), NSTIJKPlayerMulti4.x(NSTIJKPlayerMulti4.this));
                NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this).a(NSTIJKPlayerMulti4.z(NSTIJKPlayerMulti4.this), NSTIJKPlayerMulti4.B(NSTIJKPlayerMulti4.this));
                if ((!NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this).d() || (NSTIJKPlayerMulti4.e(NSTIJKPlayerMulti4.this) == NSTIJKPlayerMulti4.v(NSTIJKPlayerMulti4.this) && NSTIJKPlayerMulti4.g(NSTIJKPlayerMulti4.this) == NSTIJKPlayerMulti4.x(NSTIJKPlayerMulti4.this))) && NSTIJKPlayerMulti4.i(NSTIJKPlayerMulti4.this) == 3) {
                    NSTIJKPlayerMulti4.this.start();
                    NSTIJKPlayerMulti4.d(NSTIJKPlayerMulti4.this);
                }
            }
        }
    }

    public class d implements IMediaPlayer.OnCompletionListener {
        public d() {
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerMulti4.E(NSTIJKPlayerMulti4.this, 5);
            NSTIJKPlayerMulti4.j(NSTIJKPlayerMulti4.this, 5);
            NSTIJKPlayerMulti4.d(NSTIJKPlayerMulti4.this);
            NSTIJKPlayerMulti4.k(NSTIJKPlayerMulti4.this, -1);
            if (NSTIJKPlayerMulti4.l(NSTIJKPlayerMulti4.this) != null) {
                NSTIJKPlayerMulti4.l(NSTIJKPlayerMulti4.this).onCompletion(NSTIJKPlayerMulti4.c(NSTIJKPlayerMulti4.this));
            }
        }
    }

    public class e implements IMediaPlayer.OnInfoListener {
        public e() {
        }

        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            String n;
            String str;
            if (NSTIJKPlayerMulti4.m(NSTIJKPlayerMulti4.this) != null) {
                NSTIJKPlayerMulti4.m(NSTIJKPlayerMulti4.this).onInfo(iMediaPlayer, i, i2);
            }
            if (i == 3) {
                NSTIJKPlayerMulti4.k(NSTIJKPlayerMulti4.this, 2);
                n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                str = "MEDIA_INFO_VIDEO_RENDERING_START:";
            } else if (i == 10005) {
                NSTIJKPlayerMulti4.k(NSTIJKPlayerMulti4.this, 1);
                n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                str = "MEDIA_INFO_OPEN_INPUT:";
            } else if (i == 901) {
                n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                str = "MEDIA_INFO_UNSUPPORTED_SUBTITLE:";
            } else {
                if (i != 902) {
                    if (i == 10001) {
                        NSTIJKPlayerMulti4.o(NSTIJKPlayerMulti4.this, i2);
                        Log.d(NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this), "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        if (NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this) != null) {
                            NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this).setVideoRotation(i2);
                        }
                    } else if (i != 10002) {
                        switch (i) {
                            case 700:
                                n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                                str = "MEDIA_INFO_VIDEO_TRACK_LAGGING:";
                                break;
                            case 701:
                                NSTIJKPlayerMulti4.k(NSTIJKPlayerMulti4.this, 1);
                                n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                                str = "MEDIA_INFO_BUFFERING_START:";
                                break;
                            case 702:
                                NSTIJKPlayerMulti4.k(NSTIJKPlayerMulti4.this, 6);
                                n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                                str = "MEDIA_INFO_BUFFERING_END:";
                                break;
                            case 703:
                                n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                                str = "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2;
                                break;
                            default:
                                switch (i) {
                                    case 800:
                                        n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                                        str = "MEDIA_INFO_BAD_INTERLEAVING:";
                                        break;
                                    case 801:
                                        n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                                        str = "MEDIA_INFO_NOT_SEEKABLE:";
                                        break;
                                    case 802:
                                        n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                                        str = "MEDIA_INFO_METADATA_UPDATE:";
                                        break;
                                }
                        }
                    } else {
                        n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                        str = "MEDIA_INFO_AUDIO_RENDERING_START:";
                    }
                    return true;
                }
                n = NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this);
                str = "MEDIA_INFO_SUBTITLE_TIMED_OUT:";
            }
            Log.d(n, str);
            return true;
        }
    }

    public class f implements IMediaPlayer.OnErrorListener {
        public f() {
        }

        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            Log.d(NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this), "Error: " + i + "," + i2);
            NSTIJKPlayerMulti4.E(NSTIJKPlayerMulti4.this, -1);
            NSTIJKPlayerMulti4.j(NSTIJKPlayerMulti4.this, -1);
            NSTIJKPlayerMulti4.d(NSTIJKPlayerMulti4.this);
            NSTIJKPlayerMulti4.k(NSTIJKPlayerMulti4.this, -1);
            if (NSTIJKPlayerMulti4.q(NSTIJKPlayerMulti4.this) != null) {
                NSTIJKPlayerMulti4.q(NSTIJKPlayerMulti4.this).onError(NSTIJKPlayerMulti4.c(NSTIJKPlayerMulti4.this), i, i2);
            }
            return true;
        }
    }

    public class g implements IMediaPlayer.OnBufferingUpdateListener {
        public g() {
        }

        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            NSTIJKPlayerMulti4.r(NSTIJKPlayerMulti4.this, i);
        }
    }

    public class h implements a.a {
        public h() {
        }

        public void a(a.b bVar, int i, int i2, int i3) {
            if (bVar.a() != NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this)) {
                Log.e(NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this), "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerMulti4.f(NSTIJKPlayerMulti4.this, i2);
            NSTIJKPlayerMulti4.h(NSTIJKPlayerMulti4.this, i3);
            boolean z = false;
            boolean z2 = NSTIJKPlayerMulti4.i(NSTIJKPlayerMulti4.this) == 3;
            if (!NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this).d() || (NSTIJKPlayerMulti4.v(NSTIJKPlayerMulti4.this) == i2 && NSTIJKPlayerMulti4.x(NSTIJKPlayerMulti4.this) == i3)) {
                z = true;
            }
            if (NSTIJKPlayerMulti4.c(NSTIJKPlayerMulti4.this) != null && z2 && z) {
                if (NSTIJKPlayerMulti4.s(NSTIJKPlayerMulti4.this) != 0) {
                    NSTIJKPlayerMulti4 nSTIJKPlayerMulti4 = NSTIJKPlayerMulti4.this;
                    nSTIJKPlayerMulti4.seekTo(NSTIJKPlayerMulti4.s(nSTIJKPlayerMulti4));
                }
                NSTIJKPlayerMulti4.this.start();
            }
        }

        public void b(a.b bVar, int i, int i2) {
            if (bVar.a() != NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this)) {
                Log.e(NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this), "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerMulti4.t(NSTIJKPlayerMulti4.this, bVar);
            if (NSTIJKPlayerMulti4.c(NSTIJKPlayerMulti4.this) == null) {
                NSTIJKPlayerMulti4.this.S();
            } else {
                NSTIJKPlayerMulti4 nSTIJKPlayerMulti4 = NSTIJKPlayerMulti4.this;
                NSTIJKPlayerMulti4.u(nSTIJKPlayerMulti4, NSTIJKPlayerMulti4.c(nSTIJKPlayerMulti4), bVar);
            }
        }

        public void c(a.b bVar) {
            if (bVar.a() != NSTIJKPlayerMulti4.D(NSTIJKPlayerMulti4.this)) {
                Log.e(NSTIJKPlayerMulti4.n(NSTIJKPlayerMulti4.this), "onSurfaceDestroyed: unmatched render callback\n");
            } else {
                NSTIJKPlayerMulti4.t(NSTIJKPlayerMulti4.this, null);
                NSTIJKPlayerMulti4.this.U();
            }
        }
    }

    public class i {
        public final Activity a;
        public View b;

        public i(Activity activity) {
            this.a = activity;
        }

        public i a() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(8);
            }
            return this;
        }

        public i b(int i) {
            this.b = this.a.findViewById(i);
            return this;
        }

        public i c() {
            View view = this.b;
            if (view != null) {
                view.requestFocus();
            }
            return this;
        }

        public i d(CharSequence charSequence) {
            TextView textView = this.b;
            if (textView != null && (textView instanceof TextView)) {
                textView.setText(charSequence);
            }
            return this;
        }

        public i e() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(0);
            }
            return this;
        }
    }

    public NSTIJKPlayerMulti4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "NSTIJKPlayerMulti4";
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.u = true;
        this.v = true;
        this.w = true;
        this.z = 0;
        this.A = 5;
        this.B = false;
        this.P = new b();
        this.Q = new c();
        this.R = new d();
        this.S = new e();
        this.T = new f();
        this.U = new g();
        this.V = new h();
        this.W = new ArrayList();
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = false;
        O(context);
    }

    public static /* synthetic */ int A(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.H = i2;
        return i2;
    }

    public static /* synthetic */ int B(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.I;
    }

    public static /* synthetic */ int C(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.I = i2;
        return i2;
    }

    public static /* synthetic */ com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a D(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.G;
    }

    public static /* synthetic */ int E(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.f = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnPreparedListener F(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.p;
    }

    public static /* synthetic */ void a(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        nSTIJKPlayerMulti4.K();
    }

    public static /* synthetic */ Activity b(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.J;
    }

    public static /* synthetic */ IMediaPlayer c(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.i;
    }

    public static /* synthetic */ w7.b d(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        nSTIJKPlayerMulti4.getClass();
        return null;
    }

    public static /* synthetic */ int e(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.l;
    }

    public static /* synthetic */ int f(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.l = i2;
        return i2;
    }

    public static /* synthetic */ int g(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.m;
    }

    public static /* synthetic */ int h(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.m = i2;
        return i2;
    }

    public static /* synthetic */ int i(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.g;
    }

    public static /* synthetic */ int j(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.g = i2;
        return i2;
    }

    public static /* synthetic */ void k(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.a0(i2);
    }

    public static /* synthetic */ IMediaPlayer.OnCompletionListener l(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.o;
    }

    public static /* synthetic */ IMediaPlayer.OnInfoListener m(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.s;
    }

    public static /* synthetic */ String n(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.a;
    }

    public static /* synthetic */ int o(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.n = i2;
        return i2;
    }

    public static /* synthetic */ int p(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.A;
    }

    public static /* synthetic */ IMediaPlayer.OnErrorListener q(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.r;
    }

    public static /* synthetic */ int r(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.q = i2;
        return i2;
    }

    public static /* synthetic */ int s(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.t;
    }

    public static /* synthetic */ a.b t(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, a.b bVar) {
        nSTIJKPlayerMulti4.h = bVar;
        return bVar;
    }

    public static /* synthetic */ void u(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, IMediaPlayer iMediaPlayer, a.b bVar) {
        nSTIJKPlayerMulti4.H(iMediaPlayer, bVar);
    }

    public static /* synthetic */ int v(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.j;
    }

    public static /* synthetic */ int w(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.j = i2;
        return i2;
    }

    public static /* synthetic */ int x(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.k;
    }

    public static /* synthetic */ int y(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4, int i2) {
        nSTIJKPlayerMulti4.k = i2;
        return i2;
    }

    public static /* synthetic */ int z(NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        return nSTIJKPlayerMulti4.H;
    }

    public final void G() {
    }

    public final void H(IMediaPlayer iMediaPlayer, a.b bVar) {
        if (iMediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            bVar.b(iMediaPlayer);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tv.danmaku.ijk.media.player.IMediaPlayer I(int r10) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerMulti4.I(int):tv.danmaku.ijk.media.player.IMediaPlayer");
    }

    public void J() {
        v7.a.d(this.i);
    }

    public final void K() {
        this.M.b(a7.f.E).a();
        this.M.b(a7.f.J).a();
        L();
    }

    public void L() {
        this.M.b(a7.f.S).a();
        this.M.b(a7.f.r2).a();
        this.M.b(a7.f.V9).a();
        this.x.removeCallbacksAndMessages((Object) null);
    }

    public final void M() {
        boolean p = this.F.p();
        this.g0 = p;
        if (p) {
            v7.a.b(getContext());
            this.i = v7.a.a();
        }
    }

    public final void N() {
        this.W.clear();
        if (this.F.s()) {
            this.W.add(1);
        }
        if (this.F.t()) {
            this.W.add(2);
        }
        if (this.F.r()) {
            this.W.add(0);
        }
        if (this.W.isEmpty()) {
            this.W.add(1);
        }
        int intValue = ((Integer) this.W.get(this.e0)).intValue();
        this.f0 = intValue;
        setRender(intValue);
    }

    public final void O(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.E = applicationContext;
        this.F = new u7.a(applicationContext);
        M();
        N();
        this.j = 0;
        this.k = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f = 0;
        this.g = 0;
    }

    public boolean P() {
        return this.g0;
    }

    public final boolean Q() {
        int i2;
        return (this.i == null || (i2 = this.f) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public void R() {
        IMediaPlayer iMediaPlayer = this.i;
        if (iMediaPlayer != null) {
            iMediaPlayer.setVolume(0.0f, 0.0f);
        }
    }

    public void S() {
        IMediaPlayer.OnErrorListener onErrorListener;
        if (this.c == null || this.h == null) {
            return;
        }
        T(false);
        try {
            ((AudioManager) this.E.getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 1);
        } catch (Exception unused) {
        }
        this.M.b(a7.f.J).a();
        try {
            IMediaPlayer I = I(this.F.x());
            this.i = I;
            I.setOnPreparedListener(this.Q);
            this.i.setOnVideoSizeChangedListener(this.P);
            this.i.setOnCompletionListener(this.R);
            this.i.setOnErrorListener(this.T);
            this.i.setOnInfoListener(this.S);
            this.i.setOnBufferingUpdateListener(this.U);
            this.q = 0;
            String scheme = this.c.getScheme();
            if (Build.VERSION.SDK_INT >= 23 && this.F.F() && (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                this.i.setDataSource(new w7.a(new File(this.c.toString())));
            } else {
                this.i.setDataSource(this.E, this.c, this.d);
            }
            H(this.i, this.h);
            this.i.setAudioStreamType(3);
            this.i.setScreenOnWhilePlaying(true);
            this.i.prepareAsync();
            this.L = (AudioManager) this.J.getSystemService("audio");
            this.f = 1;
        } catch (Exception e2) {
            Log.w(this.a, "Unable to open content: " + this.c, e2);
            this.f = -1;
            this.g = -1;
            onErrorListener = this.T;
            onErrorListener.onError(this.i, 1, 0);
        } catch (IOException e3) {
            Log.w(this.a, "Unable to open content: " + this.c, e3);
            this.f = -1;
            this.g = -1;
            onErrorListener = this.T;
            onErrorListener.onError(this.i, 1, 0);
        } catch (NullPointerException e4) {
            Log.w(this.a, "Unable to open content: " + this.c, e4);
            this.f = -1;
            this.g = -1;
            onErrorListener = this.T;
            onErrorListener.onError(this.i, 1, 0);
        } catch (IllegalArgumentException e5) {
            Log.w(this.a, "Unable to open content: " + this.c, e5);
            this.f = -1;
            this.g = -1;
            onErrorListener = this.T;
            onErrorListener.onError(this.i, 1, 0);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void T(boolean z) {
        IMediaPlayer iMediaPlayer = this.i;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.i.release();
            this.i = null;
            this.f = 0;
            if (z) {
                this.g = 0;
            }
            ((AudioManager) this.E.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public void U() {
        IMediaPlayer iMediaPlayer = this.i;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    public void V() {
        Handler handler = this.x;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void W(Activity activity, NSTIJKPlayerMulti4 nSTIJKPlayerMulti4) {
        this.J = activity;
        this.K = nSTIJKPlayerMulti4;
        this.x = new Handler();
        this.M = new i(activity);
    }

    public final void X(Uri uri, Map map, boolean z, String str) {
        this.c = uri;
        this.d = map;
        this.t = 0;
        this.y = z;
        c0();
        S();
        requestLayout();
        invalidate();
    }

    public void Y(Uri uri, boolean z, String str) {
        X(uri, null, z, str);
    }

    public final void Z(String str) {
        this.M.b(a7.f.Mm).a();
        this.M.b(a7.f.J).e();
        this.M.b(a7.f.N).d(str);
    }

    public final void a0(int i2) {
        this.e = i2;
        if (i2 == -1) {
            if (this.z < this.A) {
                this.B = true;
                this.x.postDelayed(new a(), 3000L);
                return;
            }
            K();
            this.c = null;
            Z(this.J.getResources().getString(j.b7));
            c0();
            this.B = false;
            return;
        }
        if (i2 == 1) {
            this.M.b(a7.f.E).e();
            return;
        }
        if (i2 == 3) {
            this.z = 0;
            this.M.b(a7.f.D3).a();
            this.M.b(a7.f.C3).e();
            if (this.y) {
                this.M.b(a7.f.C3).c();
            }
        } else {
            if (i2 != 6) {
                if (i2 != 2) {
                    if (i2 == 4) {
                        this.M.b(a7.f.D3).e();
                        this.M.b(a7.f.C3).a();
                        if (this.y) {
                            this.M.b(a7.f.D3).c();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.z = 0;
                this.M.b(a7.f.J).a();
                this.M.b(a7.f.Mm).e();
                this.M.b(a7.f.D3).a();
                this.M.b(a7.f.C3).e();
                this.M.b(a7.f.E).a();
                if (this.J.findViewById(a7.f.t).isFocusable()) {
                    return;
                }
                R();
                return;
            }
            this.z = 0;
            this.M.b(a7.f.J).a();
            this.M.b(a7.f.Mm).e();
            this.M.b(a7.f.D3).a();
            this.M.b(a7.f.C3).e();
        }
        this.M.b(a7.f.E).a();
    }

    public void b0() {
        v7.a.d(null);
    }

    public void c0() {
        IMediaPlayer iMediaPlayer = this.i;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.i.release();
            this.i = null;
            this.f = 0;
            this.g = 0;
            ((AudioManager) this.E.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            a.b bVar = this.h;
            if (bVar == null || bVar.c() == null) {
                return;
            }
            this.h.c().setFormat(-2);
            this.h.c().setFormat(-1);
        }
    }

    public boolean canPause() {
        return this.u;
    }

    public boolean canSeekBackward() {
        return this.v;
    }

    public boolean canSeekForward() {
        return this.w;
    }

    public void d0() {
        IMediaPlayer iMediaPlayer = this.i;
        if (iMediaPlayer != null) {
            iMediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        if (this.i != null) {
            return this.q;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (Q()) {
            return (int) this.i.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (Q()) {
            return (int) this.i.getDuration();
        }
        return -1;
    }

    public boolean isPlaying() {
        IMediaPlayer iMediaPlayer;
        return Q() && (iMediaPlayer = this.i) != null && iMediaPlayer.isPlaying();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 != 5) {
        }
        Q();
        return super.onKeyDown(i2, keyEvent);
    }

    public void pause() {
        IMediaPlayer iMediaPlayer;
        if (Q() && (iMediaPlayer = this.i) != null && iMediaPlayer.isPlaying()) {
            this.i.pause();
            this.f = 4;
        }
        this.g = 4;
    }

    public void seekTo(int i2) {
        if (Q()) {
            this.i.seekTo(i2);
            i2 = 0;
        }
        this.t = i2;
    }

    public void setContext(Context context) {
        this.O = context;
    }

    public void setLiveStreamDBHandler(LiveStreamDBHandler liveStreamDBHandler) {
        this.N = liveStreamDBHandler;
    }

    public void setMediaController(w7.b bVar) {
        G();
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.o = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.r = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.s = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.p = onPreparedListener;
    }

    public void setRender(int i2) {
        SurfaceView surfaceView;
        if (i2 == 0) {
            surfaceView = null;
        } else if (i2 == 1) {
            surfaceView = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.b(getContext());
        } else {
            if (i2 != 2) {
                Log.e(this.a, String.format(Locale.getDefault(), "invalid render %d\n", new Object[]{Integer.valueOf(i2)}));
                return;
            }
            surfaceView = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.c(getContext());
            if (this.i != null) {
                surfaceView.getSurfaceHolder().b(this.i);
                surfaceView.c(this.i.getVideoWidth(), this.i.getVideoHeight());
                surfaceView.a(this.i.getVideoSarNum(), this.i.getVideoSarDen());
            }
        }
        setRenderView(surfaceView);
    }

    public void setRenderView(com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar) {
        int i2;
        int i3;
        if (this.G != null) {
            IMediaPlayer iMediaPlayer = this.i;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.G.getView();
            this.G.b(this.V);
            this.G = null;
            removeView(view);
        }
        if (aVar == null) {
            return;
        }
        this.G = aVar;
        this.C = this.E.getSharedPreferences("loginPrefs", 0);
        int i4 = this.j;
        if (i4 > 0 && (i3 = this.k) > 0) {
            aVar.c(i4, i3);
        }
        int i5 = this.H;
        if (i5 > 0 && (i2 = this.I) > 0) {
            aVar.a(i5, i2);
        }
        View view2 = this.G.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.G.e(this.V);
        this.G.setVideoRotation(this.n);
    }

    public void start() {
        if (Q()) {
            this.i.start();
            this.f = 3;
        }
        this.g = 3;
    }
}
