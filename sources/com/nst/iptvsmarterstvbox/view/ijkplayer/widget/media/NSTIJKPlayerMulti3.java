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
public class NSTIJKPlayerMulti3 extends FrameLayout implements MediaController.MediaPlayerControl {
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
    public NSTIJKPlayerMulti3 K;
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
            NSTIJKPlayerMulti3 nSTIJKPlayerMulti3 = NSTIJKPlayerMulti3.this;
            nSTIJKPlayerMulti3.z++;
            NSTIJKPlayerMulti3.a(nSTIJKPlayerMulti3);
            w.P0(NSTIJKPlayerMulti3.b(NSTIJKPlayerMulti3.this), NSTIJKPlayerMulti3.b(NSTIJKPlayerMulti3.this).getResources().getString(j.g5) + " (" + NSTIJKPlayerMulti3.this.z + "/" + NSTIJKPlayerMulti3.p(NSTIJKPlayerMulti3.this) + ")");
            NSTIJKPlayerMulti3.this.S();
            NSTIJKPlayerMulti3.this.start();
        }
    }

    public class b implements IMediaPlayer.OnVideoSizeChangedListener {
        public b() {
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            NSTIJKPlayerMulti3.w(NSTIJKPlayerMulti3.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerMulti3.y(NSTIJKPlayerMulti3.this, iMediaPlayer.getVideoHeight());
            NSTIJKPlayerMulti3.A(NSTIJKPlayerMulti3.this, iMediaPlayer.getVideoSarNum());
            NSTIJKPlayerMulti3.C(NSTIJKPlayerMulti3.this, iMediaPlayer.getVideoSarDen());
            if (NSTIJKPlayerMulti3.v(NSTIJKPlayerMulti3.this) == 0 || NSTIJKPlayerMulti3.x(NSTIJKPlayerMulti3.this) == 0) {
                return;
            }
            if (NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this) != null) {
                NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this).c(NSTIJKPlayerMulti3.v(NSTIJKPlayerMulti3.this), NSTIJKPlayerMulti3.x(NSTIJKPlayerMulti3.this));
                NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this).a(NSTIJKPlayerMulti3.z(NSTIJKPlayerMulti3.this), NSTIJKPlayerMulti3.B(NSTIJKPlayerMulti3.this));
            }
            NSTIJKPlayerMulti3.this.requestLayout();
        }
    }

    public class c implements IMediaPlayer.OnPreparedListener {
        public c() {
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerMulti3.E(NSTIJKPlayerMulti3.this, 2);
            if (NSTIJKPlayerMulti3.F(NSTIJKPlayerMulti3.this) != null) {
                NSTIJKPlayerMulti3.F(NSTIJKPlayerMulti3.this).onPrepared(NSTIJKPlayerMulti3.c(NSTIJKPlayerMulti3.this));
            }
            NSTIJKPlayerMulti3.d(NSTIJKPlayerMulti3.this);
            NSTIJKPlayerMulti3.w(NSTIJKPlayerMulti3.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerMulti3.y(NSTIJKPlayerMulti3.this, iMediaPlayer.getVideoHeight());
            if (NSTIJKPlayerMulti3.v(NSTIJKPlayerMulti3.this) == 0 || NSTIJKPlayerMulti3.x(NSTIJKPlayerMulti3.this) == 0) {
                if (NSTIJKPlayerMulti3.i(NSTIJKPlayerMulti3.this) == 3) {
                    NSTIJKPlayerMulti3.this.start();
                }
            } else if (NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this) != null) {
                NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this).c(NSTIJKPlayerMulti3.v(NSTIJKPlayerMulti3.this), NSTIJKPlayerMulti3.x(NSTIJKPlayerMulti3.this));
                NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this).a(NSTIJKPlayerMulti3.z(NSTIJKPlayerMulti3.this), NSTIJKPlayerMulti3.B(NSTIJKPlayerMulti3.this));
                if ((!NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this).d() || (NSTIJKPlayerMulti3.e(NSTIJKPlayerMulti3.this) == NSTIJKPlayerMulti3.v(NSTIJKPlayerMulti3.this) && NSTIJKPlayerMulti3.g(NSTIJKPlayerMulti3.this) == NSTIJKPlayerMulti3.x(NSTIJKPlayerMulti3.this))) && NSTIJKPlayerMulti3.i(NSTIJKPlayerMulti3.this) == 3) {
                    NSTIJKPlayerMulti3.this.start();
                    NSTIJKPlayerMulti3.d(NSTIJKPlayerMulti3.this);
                }
            }
        }
    }

    public class d implements IMediaPlayer.OnCompletionListener {
        public d() {
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerMulti3.E(NSTIJKPlayerMulti3.this, 5);
            NSTIJKPlayerMulti3.j(NSTIJKPlayerMulti3.this, 5);
            NSTIJKPlayerMulti3.d(NSTIJKPlayerMulti3.this);
            NSTIJKPlayerMulti3.k(NSTIJKPlayerMulti3.this, -1);
            if (NSTIJKPlayerMulti3.l(NSTIJKPlayerMulti3.this) != null) {
                NSTIJKPlayerMulti3.l(NSTIJKPlayerMulti3.this).onCompletion(NSTIJKPlayerMulti3.c(NSTIJKPlayerMulti3.this));
            }
        }
    }

    public class e implements IMediaPlayer.OnInfoListener {
        public e() {
        }

        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            String n;
            String str;
            if (NSTIJKPlayerMulti3.m(NSTIJKPlayerMulti3.this) != null) {
                NSTIJKPlayerMulti3.m(NSTIJKPlayerMulti3.this).onInfo(iMediaPlayer, i, i2);
            }
            if (i == 3) {
                NSTIJKPlayerMulti3.k(NSTIJKPlayerMulti3.this, 2);
                n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                str = "MEDIA_INFO_VIDEO_RENDERING_START:";
            } else if (i == 10005) {
                NSTIJKPlayerMulti3.k(NSTIJKPlayerMulti3.this, 1);
                n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                str = "MEDIA_INFO_OPEN_INPUT:";
            } else if (i == 901) {
                n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                str = "MEDIA_INFO_UNSUPPORTED_SUBTITLE:";
            } else {
                if (i != 902) {
                    if (i == 10001) {
                        NSTIJKPlayerMulti3.o(NSTIJKPlayerMulti3.this, i2);
                        Log.d(NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this), "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        if (NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this) != null) {
                            NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this).setVideoRotation(i2);
                        }
                    } else if (i != 10002) {
                        switch (i) {
                            case 700:
                                n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                                str = "MEDIA_INFO_VIDEO_TRACK_LAGGING:";
                                break;
                            case 701:
                                NSTIJKPlayerMulti3.k(NSTIJKPlayerMulti3.this, 1);
                                n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                                str = "MEDIA_INFO_BUFFERING_START:";
                                break;
                            case 702:
                                NSTIJKPlayerMulti3.k(NSTIJKPlayerMulti3.this, 6);
                                n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                                str = "MEDIA_INFO_BUFFERING_END:";
                                break;
                            case 703:
                                n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                                str = "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2;
                                break;
                            default:
                                switch (i) {
                                    case 800:
                                        n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                                        str = "MEDIA_INFO_BAD_INTERLEAVING:";
                                        break;
                                    case 801:
                                        n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                                        str = "MEDIA_INFO_NOT_SEEKABLE:";
                                        break;
                                    case 802:
                                        n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                                        str = "MEDIA_INFO_METADATA_UPDATE:";
                                        break;
                                }
                        }
                    } else {
                        n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
                        str = "MEDIA_INFO_AUDIO_RENDERING_START:";
                    }
                    return true;
                }
                n = NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this);
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
            Log.d(NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this), "Error: " + i + "," + i2);
            NSTIJKPlayerMulti3.E(NSTIJKPlayerMulti3.this, -1);
            NSTIJKPlayerMulti3.j(NSTIJKPlayerMulti3.this, -1);
            NSTIJKPlayerMulti3.d(NSTIJKPlayerMulti3.this);
            NSTIJKPlayerMulti3.k(NSTIJKPlayerMulti3.this, -1);
            if (NSTIJKPlayerMulti3.q(NSTIJKPlayerMulti3.this) != null) {
                NSTIJKPlayerMulti3.q(NSTIJKPlayerMulti3.this).onError(NSTIJKPlayerMulti3.c(NSTIJKPlayerMulti3.this), i, i2);
            }
            return true;
        }
    }

    public class g implements IMediaPlayer.OnBufferingUpdateListener {
        public g() {
        }

        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            NSTIJKPlayerMulti3.r(NSTIJKPlayerMulti3.this, i);
        }
    }

    public class h implements a.a {
        public h() {
        }

        public void a(a.b bVar, int i, int i2, int i3) {
            if (bVar.a() != NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this)) {
                Log.e(NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this), "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerMulti3.f(NSTIJKPlayerMulti3.this, i2);
            NSTIJKPlayerMulti3.h(NSTIJKPlayerMulti3.this, i3);
            boolean z = false;
            boolean z2 = NSTIJKPlayerMulti3.i(NSTIJKPlayerMulti3.this) == 3;
            if (!NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this).d() || (NSTIJKPlayerMulti3.v(NSTIJKPlayerMulti3.this) == i2 && NSTIJKPlayerMulti3.x(NSTIJKPlayerMulti3.this) == i3)) {
                z = true;
            }
            if (NSTIJKPlayerMulti3.c(NSTIJKPlayerMulti3.this) != null && z2 && z) {
                if (NSTIJKPlayerMulti3.s(NSTIJKPlayerMulti3.this) != 0) {
                    NSTIJKPlayerMulti3 nSTIJKPlayerMulti3 = NSTIJKPlayerMulti3.this;
                    nSTIJKPlayerMulti3.seekTo(NSTIJKPlayerMulti3.s(nSTIJKPlayerMulti3));
                }
                NSTIJKPlayerMulti3.this.start();
            }
        }

        public void b(a.b bVar, int i, int i2) {
            if (bVar.a() != NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this)) {
                Log.e(NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this), "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerMulti3.t(NSTIJKPlayerMulti3.this, bVar);
            if (NSTIJKPlayerMulti3.c(NSTIJKPlayerMulti3.this) == null) {
                NSTIJKPlayerMulti3.this.S();
            } else {
                NSTIJKPlayerMulti3 nSTIJKPlayerMulti3 = NSTIJKPlayerMulti3.this;
                NSTIJKPlayerMulti3.u(nSTIJKPlayerMulti3, NSTIJKPlayerMulti3.c(nSTIJKPlayerMulti3), bVar);
            }
        }

        public void c(a.b bVar) {
            if (bVar.a() != NSTIJKPlayerMulti3.D(NSTIJKPlayerMulti3.this)) {
                Log.e(NSTIJKPlayerMulti3.n(NSTIJKPlayerMulti3.this), "onSurfaceDestroyed: unmatched render callback\n");
            } else {
                NSTIJKPlayerMulti3.t(NSTIJKPlayerMulti3.this, null);
                NSTIJKPlayerMulti3.this.U();
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

    public NSTIJKPlayerMulti3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "NSTIJKPlayerMulti3";
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

    public static /* synthetic */ int A(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.H = i2;
        return i2;
    }

    public static /* synthetic */ int B(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.I;
    }

    public static /* synthetic */ int C(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.I = i2;
        return i2;
    }

    public static /* synthetic */ com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a D(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.G;
    }

    public static /* synthetic */ int E(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.f = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnPreparedListener F(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.p;
    }

    public static /* synthetic */ void a(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        nSTIJKPlayerMulti3.K();
    }

    public static /* synthetic */ Activity b(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.J;
    }

    public static /* synthetic */ IMediaPlayer c(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.i;
    }

    public static /* synthetic */ w7.b d(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        nSTIJKPlayerMulti3.getClass();
        return null;
    }

    public static /* synthetic */ int e(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.l;
    }

    public static /* synthetic */ int f(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.l = i2;
        return i2;
    }

    public static /* synthetic */ int g(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.m;
    }

    public static /* synthetic */ int h(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.m = i2;
        return i2;
    }

    public static /* synthetic */ int i(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.g;
    }

    public static /* synthetic */ int j(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.g = i2;
        return i2;
    }

    public static /* synthetic */ void k(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.a0(i2);
    }

    public static /* synthetic */ IMediaPlayer.OnCompletionListener l(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.o;
    }

    public static /* synthetic */ IMediaPlayer.OnInfoListener m(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.s;
    }

    public static /* synthetic */ String n(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.a;
    }

    public static /* synthetic */ int o(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.n = i2;
        return i2;
    }

    public static /* synthetic */ int p(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.A;
    }

    public static /* synthetic */ IMediaPlayer.OnErrorListener q(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.r;
    }

    public static /* synthetic */ int r(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.q = i2;
        return i2;
    }

    public static /* synthetic */ int s(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.t;
    }

    public static /* synthetic */ a.b t(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, a.b bVar) {
        nSTIJKPlayerMulti3.h = bVar;
        return bVar;
    }

    public static /* synthetic */ void u(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, IMediaPlayer iMediaPlayer, a.b bVar) {
        nSTIJKPlayerMulti3.H(iMediaPlayer, bVar);
    }

    public static /* synthetic */ int v(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.j;
    }

    public static /* synthetic */ int w(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.j = i2;
        return i2;
    }

    public static /* synthetic */ int x(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.k;
    }

    public static /* synthetic */ int y(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3, int i2) {
        nSTIJKPlayerMulti3.k = i2;
        return i2;
    }

    public static /* synthetic */ int z(NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        return nSTIJKPlayerMulti3.H;
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
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerMulti3.I(int):tv.danmaku.ijk.media.player.IMediaPlayer");
    }

    public void J() {
        v7.a.d(this.i);
    }

    public final void K() {
        this.M.b(a7.f.D).a();
        this.M.b(a7.f.I).a();
        L();
    }

    public void L() {
        this.M.b(a7.f.R).a();
        this.M.b(a7.f.q2).a();
        this.M.b(a7.f.U9).a();
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
        this.M.b(a7.f.I).a();
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

    public void W(Activity activity, NSTIJKPlayerMulti3 nSTIJKPlayerMulti3) {
        this.J = activity;
        this.K = nSTIJKPlayerMulti3;
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
        this.M.b(a7.f.Lm).a();
        this.M.b(a7.f.I).e();
        this.M.b(a7.f.M).d(str);
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
            this.M.b(a7.f.D).e();
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
                this.M.b(a7.f.I).a();
                this.M.b(a7.f.Lm).e();
                this.M.b(a7.f.D3).a();
                this.M.b(a7.f.C3).e();
                this.M.b(a7.f.D).a();
                if (this.J.findViewById(a7.f.s).isFocusable()) {
                    return;
                }
                R();
                return;
            }
            this.z = 0;
            this.M.b(a7.f.I).a();
            this.M.b(a7.f.Lm).e();
            this.M.b(a7.f.D3).a();
            this.M.b(a7.f.C3).e();
        }
        this.M.b(a7.f.D).a();
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
