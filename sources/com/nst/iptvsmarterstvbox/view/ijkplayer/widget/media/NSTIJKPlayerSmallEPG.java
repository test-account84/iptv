package com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TableLayout;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import m7.w;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerSmallEPG extends FrameLayout implements MediaController.MediaPlayerControl {
    public static final int[] M0 = {0, 1, 2, 3, 4, 5};
    public boolean A;
    public IMediaPlayer.OnInfoListener A0;
    public boolean B;
    public IMediaPlayer.OnErrorListener B0;
    public boolean C;
    public IMediaPlayer.OnBufferingUpdateListener C0;
    public int D;
    public IMediaPlayer.OnSeekCompleteListener D0;
    public Handler E;
    public IMediaPlayer.OnTimedTextListener E0;
    public Handler F;
    public a.a F0;
    public boolean G;
    public int G0;
    public int H;
    public int H0;
    public boolean I;
    public List I0;
    public int J;
    public int J0;
    public int K;
    public int K0;
    public boolean L;
    public boolean L0;
    public SharedPreferences M;
    public SharedPreferences N;
    public Context O;
    public u7.a P;
    public com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a Q;
    public int R;
    public int S;
    public long T;
    public long U;
    public long V;
    public long W;
    public String a;
    public Uri c;
    public String d;
    public Map e;
    public TextView e0;
    public int f;
    public Activity f0;
    public int g;
    public NSTIJKPlayerSmallEPG g0;
    public int h;
    public AudioManager h0;
    public a.b i;
    public int i0;
    public IMediaPlayer j;
    public float j0;
    public int k;
    public int k0;
    public int l;
    public m l0;
    public int m;
    public Boolean m0;
    public int n;
    public Boolean n0;
    public int o;
    public Boolean o0;
    public IMediaPlayer.OnCompletionListener p;
    public Boolean p0;
    public IMediaPlayer.OnPreparedListener q;
    public Boolean q0;
    public int r;
    public Boolean r0;
    public IMediaPlayer.OnErrorListener s;
    public SharedPreferences s0;
    public IMediaPlayer.OnInfoListener t;
    public SharedPreferences t0;
    public int u;
    public SharedPreferences u0;
    public boolean v;
    public SharedPreferences v0;
    public boolean w;
    public Handler w0;
    public boolean x;
    public IMediaPlayer.OnVideoSizeChangedListener x0;
    public int y;
    public IMediaPlayer.OnPreparedListener y0;
    public long z;
    public IMediaPlayer.OnCompletionListener z0;

    public class a implements IMediaPlayer.OnBufferingUpdateListener {
        public a() {
        }

        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            NSTIJKPlayerSmallEPG.D(NSTIJKPlayerSmallEPG.this, i);
        }
    }

    public class b implements IMediaPlayer.OnSeekCompleteListener {
        public b() {
        }

        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerSmallEPG.E(NSTIJKPlayerSmallEPG.this, System.currentTimeMillis());
        }
    }

    public class c implements IMediaPlayer.OnTimedTextListener {
        public c() {
        }

        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            if (ijkTimedText != null) {
                NSTIJKPlayerSmallEPG.this.e0.setText(ijkTimedText.getText().replace("{\\b1}", "").replace("{\\b0}", "").replace("{\\i1}", "").replace("{\\i0}", ""));
            }
        }
    }

    public class d implements a.a {
        public d() {
        }

        public void a(a.b bVar, int i, int i2, int i3) {
            if (bVar.a() != NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this)) {
                Log.e(NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this), "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerSmallEPG.r(NSTIJKPlayerSmallEPG.this, i2);
            NSTIJKPlayerSmallEPG.t(NSTIJKPlayerSmallEPG.this, i3);
            boolean z = false;
            boolean z2 = NSTIJKPlayerSmallEPG.u(NSTIJKPlayerSmallEPG.this) == 3;
            if (!NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this).d() || (NSTIJKPlayerSmallEPG.a(NSTIJKPlayerSmallEPG.this) == i2 && NSTIJKPlayerSmallEPG.c(NSTIJKPlayerSmallEPG.this) == i3)) {
                z = true;
            }
            if (NSTIJKPlayerSmallEPG.n(NSTIJKPlayerSmallEPG.this) != null && z2 && z) {
                if (NSTIJKPlayerSmallEPG.p(NSTIJKPlayerSmallEPG.this) != 0) {
                    NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG = NSTIJKPlayerSmallEPG.this;
                    nSTIJKPlayerSmallEPG.seekTo(NSTIJKPlayerSmallEPG.p(nSTIJKPlayerSmallEPG));
                }
                NSTIJKPlayerSmallEPG.this.start();
            }
        }

        public void b(a.b bVar, int i, int i2) {
            if (bVar.a() != NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this)) {
                Log.e(NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this), "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerSmallEPG.F(NSTIJKPlayerSmallEPG.this, bVar);
            if (NSTIJKPlayerSmallEPG.n(NSTIJKPlayerSmallEPG.this) == null) {
                NSTIJKPlayerSmallEPG.this.V();
            } else {
                NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG = NSTIJKPlayerSmallEPG.this;
                NSTIJKPlayerSmallEPG.G(nSTIJKPlayerSmallEPG, NSTIJKPlayerSmallEPG.n(nSTIJKPlayerSmallEPG), bVar);
            }
        }

        public void c(a.b bVar) {
            if (bVar.a() != NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this)) {
                Log.e(NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this), "onSurfaceDestroyed: unmatched render callback\n");
            } else {
                NSTIJKPlayerSmallEPG.F(NSTIJKPlayerSmallEPG.this, null);
                NSTIJKPlayerSmallEPG.this.X();
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            NSTIJKPlayerSmallEPG.this.P();
        }
    }

    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                NSTIJKPlayerSmallEPG.this.N(false);
            } else {
                if (i != 4) {
                    return;
                }
                NSTIJKPlayerSmallEPG.m(NSTIJKPlayerSmallEPG.this).b(a7.f.U).a();
                NSTIJKPlayerSmallEPG.m(NSTIJKPlayerSmallEPG.this).b(a7.f.v).a();
                NSTIJKPlayerSmallEPG.m(NSTIJKPlayerSmallEPG.this).b(a7.f.y).a();
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG = NSTIJKPlayerSmallEPG.this;
            nSTIJKPlayerSmallEPG.J++;
            NSTIJKPlayerSmallEPG.A(nSTIJKPlayerSmallEPG);
            w.P0(NSTIJKPlayerSmallEPG.H(NSTIJKPlayerSmallEPG.this), NSTIJKPlayerSmallEPG.H(NSTIJKPlayerSmallEPG.this).getResources().getString(a7.j.g5) + " (" + NSTIJKPlayerSmallEPG.this.J + "/" + NSTIJKPlayerSmallEPG.I(NSTIJKPlayerSmallEPG.this) + ")");
            NSTIJKPlayerSmallEPG.this.V();
            NSTIJKPlayerSmallEPG.this.start();
        }
    }

    public class h implements IMediaPlayer.OnVideoSizeChangedListener {
        public h() {
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            NSTIJKPlayerSmallEPG.b(NSTIJKPlayerSmallEPG.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerSmallEPG.d(NSTIJKPlayerSmallEPG.this, iMediaPlayer.getVideoHeight());
            NSTIJKPlayerSmallEPG.f(NSTIJKPlayerSmallEPG.this, iMediaPlayer.getVideoSarNum());
            NSTIJKPlayerSmallEPG.h(NSTIJKPlayerSmallEPG.this, iMediaPlayer.getVideoSarDen());
            if (NSTIJKPlayerSmallEPG.a(NSTIJKPlayerSmallEPG.this) == 0 || NSTIJKPlayerSmallEPG.c(NSTIJKPlayerSmallEPG.this) == 0) {
                return;
            }
            if (NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this) != null) {
                NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this).c(NSTIJKPlayerSmallEPG.a(NSTIJKPlayerSmallEPG.this), NSTIJKPlayerSmallEPG.c(NSTIJKPlayerSmallEPG.this));
                NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this).a(NSTIJKPlayerSmallEPG.e(NSTIJKPlayerSmallEPG.this), NSTIJKPlayerSmallEPG.g(NSTIJKPlayerSmallEPG.this));
            }
            NSTIJKPlayerSmallEPG.this.requestLayout();
        }
    }

    public class i implements IMediaPlayer.OnPreparedListener {
        public i() {
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerSmallEPG.j(NSTIJKPlayerSmallEPG.this, System.currentTimeMillis());
            NSTIJKPlayerSmallEPG.k(NSTIJKPlayerSmallEPG.this, 2);
            if (NSTIJKPlayerSmallEPG.l(NSTIJKPlayerSmallEPG.this) != null) {
                NSTIJKPlayerSmallEPG.l(NSTIJKPlayerSmallEPG.this).onPrepared(NSTIJKPlayerSmallEPG.n(NSTIJKPlayerSmallEPG.this));
            }
            NSTIJKPlayerSmallEPG.o(NSTIJKPlayerSmallEPG.this);
            NSTIJKPlayerSmallEPG.b(NSTIJKPlayerSmallEPG.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerSmallEPG.d(NSTIJKPlayerSmallEPG.this, iMediaPlayer.getVideoHeight());
            int p = NSTIJKPlayerSmallEPG.p(NSTIJKPlayerSmallEPG.this);
            if (p != 0) {
                NSTIJKPlayerSmallEPG.this.seekTo(p);
            }
            if (NSTIJKPlayerSmallEPG.a(NSTIJKPlayerSmallEPG.this) == 0 || NSTIJKPlayerSmallEPG.c(NSTIJKPlayerSmallEPG.this) == 0) {
                if (NSTIJKPlayerSmallEPG.u(NSTIJKPlayerSmallEPG.this) == 3) {
                    NSTIJKPlayerSmallEPG.this.start();
                    return;
                }
                return;
            }
            if (NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this) != null) {
                NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this).c(NSTIJKPlayerSmallEPG.a(NSTIJKPlayerSmallEPG.this), NSTIJKPlayerSmallEPG.c(NSTIJKPlayerSmallEPG.this));
                NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this).a(NSTIJKPlayerSmallEPG.e(NSTIJKPlayerSmallEPG.this), NSTIJKPlayerSmallEPG.g(NSTIJKPlayerSmallEPG.this));
                if (!NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this).d() || (NSTIJKPlayerSmallEPG.q(NSTIJKPlayerSmallEPG.this) == NSTIJKPlayerSmallEPG.a(NSTIJKPlayerSmallEPG.this) && NSTIJKPlayerSmallEPG.s(NSTIJKPlayerSmallEPG.this) == NSTIJKPlayerSmallEPG.c(NSTIJKPlayerSmallEPG.this))) {
                    if (NSTIJKPlayerSmallEPG.u(NSTIJKPlayerSmallEPG.this) == 3) {
                        NSTIJKPlayerSmallEPG.this.start();
                    } else {
                        if (NSTIJKPlayerSmallEPG.this.isPlaying()) {
                            return;
                        }
                        if (p == 0 && NSTIJKPlayerSmallEPG.this.getCurrentPosition() <= 0) {
                            return;
                        }
                    }
                    NSTIJKPlayerSmallEPG.o(NSTIJKPlayerSmallEPG.this);
                }
            }
        }
    }

    public class j implements IMediaPlayer.OnCompletionListener {
        public j() {
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerSmallEPG.k(NSTIJKPlayerSmallEPG.this, 5);
            NSTIJKPlayerSmallEPG.v(NSTIJKPlayerSmallEPG.this, 5);
            NSTIJKPlayerSmallEPG.o(NSTIJKPlayerSmallEPG.this);
            NSTIJKPlayerSmallEPG.w(NSTIJKPlayerSmallEPG.this, -1);
            if (NSTIJKPlayerSmallEPG.x(NSTIJKPlayerSmallEPG.this) != null) {
                NSTIJKPlayerSmallEPG.x(NSTIJKPlayerSmallEPG.this).onCompletion(NSTIJKPlayerSmallEPG.n(NSTIJKPlayerSmallEPG.this));
            }
        }
    }

    public class k implements IMediaPlayer.OnInfoListener {
        public k() {
        }

        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            String z;
            String str;
            if (NSTIJKPlayerSmallEPG.y(NSTIJKPlayerSmallEPG.this) != null) {
                NSTIJKPlayerSmallEPG.y(NSTIJKPlayerSmallEPG.this).onInfo(iMediaPlayer, i, i2);
            }
            if (i == 3) {
                NSTIJKPlayerSmallEPG.w(NSTIJKPlayerSmallEPG.this, 2);
                z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                str = "MEDIA_INFO_VIDEO_RENDERING_START:";
            } else if (i == 10005) {
                NSTIJKPlayerSmallEPG.w(NSTIJKPlayerSmallEPG.this, 1);
                z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                str = "MEDIA_INFO_OPEN_INPUT:";
            } else if (i == 901) {
                z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                str = "MEDIA_INFO_UNSUPPORTED_SUBTITLE:";
            } else {
                if (i != 902) {
                    if (i == 10001) {
                        NSTIJKPlayerSmallEPG.B(NSTIJKPlayerSmallEPG.this, i2);
                        Log.d(NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this), "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        if (NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this) != null) {
                            NSTIJKPlayerSmallEPG.i(NSTIJKPlayerSmallEPG.this).setVideoRotation(i2);
                        }
                    } else if (i != 10002) {
                        switch (i) {
                            case 700:
                                z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                                str = "MEDIA_INFO_VIDEO_TRACK_LAGGING:";
                                break;
                            case 701:
                                NSTIJKPlayerSmallEPG.w(NSTIJKPlayerSmallEPG.this, 1);
                                z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                                str = "MEDIA_INFO_BUFFERING_START:";
                                break;
                            case 702:
                                NSTIJKPlayerSmallEPG.w(NSTIJKPlayerSmallEPG.this, 6);
                                z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                                str = "MEDIA_INFO_BUFFERING_END:";
                                break;
                            case 703:
                                z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                                str = "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2;
                                break;
                            default:
                                switch (i) {
                                    case 800:
                                        z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                                        str = "MEDIA_INFO_BAD_INTERLEAVING:";
                                        break;
                                    case 801:
                                        z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                                        str = "MEDIA_INFO_NOT_SEEKABLE:";
                                        break;
                                    case 802:
                                        z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                                        str = "MEDIA_INFO_METADATA_UPDATE:";
                                        break;
                                }
                        }
                    } else {
                        z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                        str = "MEDIA_INFO_AUDIO_RENDERING_START:";
                    }
                    return true;
                }
                z = NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this);
                str = "MEDIA_INFO_SUBTITLE_TIMED_OUT:";
            }
            Log.d(z, str);
            return true;
        }
    }

    public class l implements IMediaPlayer.OnErrorListener {
        public l() {
        }

        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            Log.d(NSTIJKPlayerSmallEPG.z(NSTIJKPlayerSmallEPG.this), "Error: " + i + "," + i2);
            NSTIJKPlayerSmallEPG.k(NSTIJKPlayerSmallEPG.this, -1);
            NSTIJKPlayerSmallEPG.v(NSTIJKPlayerSmallEPG.this, -1);
            NSTIJKPlayerSmallEPG.o(NSTIJKPlayerSmallEPG.this);
            NSTIJKPlayerSmallEPG.w(NSTIJKPlayerSmallEPG.this, -1);
            if (NSTIJKPlayerSmallEPG.C(NSTIJKPlayerSmallEPG.this) != null) {
                NSTIJKPlayerSmallEPG.C(NSTIJKPlayerSmallEPG.this).onError(NSTIJKPlayerSmallEPG.n(NSTIJKPlayerSmallEPG.this), i, i2);
            }
            return true;
        }
    }

    public class m {
        public final Activity a;
        public View b;

        public m(Activity activity) {
            this.a = activity;
        }

        public m a() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(8);
            }
            return this;
        }

        public m b(int i) {
            this.b = this.a.findViewById(i);
            return this;
        }

        public m c() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(4);
            }
            return this;
        }

        public m d() {
            View view = this.b;
            if (view != null) {
                view.requestFocus();
            }
            return this;
        }

        public m e(CharSequence charSequence) {
            TextView textView = this.b;
            if (textView != null && (textView instanceof TextView)) {
                textView.setText(charSequence);
            }
            return this;
        }

        public m f(int i) {
            View view = this.b;
            if (view != null) {
                view.setVisibility(i);
            }
            return this;
        }

        public m g() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(0);
            }
            return this;
        }
    }

    public NSTIJKPlayerSmallEPG(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "NSTIJKPlayerSmallEPG";
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = -1;
        this.z = -1L;
        this.B = true;
        this.C = false;
        this.D = 7000;
        this.H = 0;
        this.J = 0;
        this.K = 5;
        this.L = false;
        this.T = 0L;
        this.U = 0L;
        this.V = 0L;
        this.W = 0L;
        this.j0 = -1.0f;
        Boolean bool = Boolean.FALSE;
        this.m0 = bool;
        this.n0 = bool;
        this.o0 = bool;
        this.p0 = bool;
        this.q0 = bool;
        this.r0 = bool;
        this.w0 = new f(Looper.getMainLooper());
        this.x0 = new h();
        this.y0 = new i();
        this.z0 = new j();
        this.A0 = new k();
        this.B0 = new l();
        this.C0 = new a();
        this.D0 = new b();
        this.E0 = new c();
        this.F0 = new d();
        this.G0 = 4;
        this.H0 = M0[0];
        this.I0 = new ArrayList();
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        S(context);
    }

    public static /* synthetic */ void A(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        nSTIJKPlayerSmallEPG.O();
    }

    public static /* synthetic */ int B(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.o = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnErrorListener C(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.s;
    }

    public static /* synthetic */ int D(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.r = i2;
        return i2;
    }

    public static /* synthetic */ long E(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, long j2) {
        nSTIJKPlayerSmallEPG.W = j2;
        return j2;
    }

    public static /* synthetic */ a.b F(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, a.b bVar) {
        nSTIJKPlayerSmallEPG.i = bVar;
        return bVar;
    }

    public static /* synthetic */ void G(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, IMediaPlayer iMediaPlayer, a.b bVar) {
        nSTIJKPlayerSmallEPG.J(iMediaPlayer, bVar);
    }

    public static /* synthetic */ Activity H(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.f0;
    }

    public static /* synthetic */ int I(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.K;
    }

    public static /* synthetic */ int a(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.k;
    }

    public static /* synthetic */ int b(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.k = i2;
        return i2;
    }

    public static /* synthetic */ int c(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.l;
    }

    public static /* synthetic */ int d(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.l = i2;
        return i2;
    }

    public static /* synthetic */ int e(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.R;
    }

    public static /* synthetic */ int f(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.R = i2;
        return i2;
    }

    public static /* synthetic */ int g(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.S;
    }

    public static /* synthetic */ int h(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.S = i2;
        return i2;
    }

    public static /* synthetic */ com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a i(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.Q;
    }

    public static /* synthetic */ long j(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, long j2) {
        nSTIJKPlayerSmallEPG.U = j2;
        return j2;
    }

    public static /* synthetic */ int k(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.g = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnPreparedListener l(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.q;
    }

    public static /* synthetic */ m m(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.l0;
    }

    public static /* synthetic */ IMediaPlayer n(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.j;
    }

    public static /* synthetic */ w7.b o(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        nSTIJKPlayerSmallEPG.getClass();
        return null;
    }

    public static /* synthetic */ int p(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.u;
    }

    public static /* synthetic */ int q(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.m;
    }

    public static /* synthetic */ int r(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.m = i2;
        return i2;
    }

    public static /* synthetic */ int s(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.n;
    }

    public static /* synthetic */ int t(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.n = i2;
        return i2;
    }

    public static /* synthetic */ int u(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.h;
    }

    public static /* synthetic */ int v(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.h = i2;
        return i2;
    }

    public static /* synthetic */ void w(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG, int i2) {
        nSTIJKPlayerSmallEPG.f0(i2);
    }

    public static /* synthetic */ IMediaPlayer.OnCompletionListener x(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.p;
    }

    public static /* synthetic */ IMediaPlayer.OnInfoListener y(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.t;
    }

    public static /* synthetic */ String z(NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        return nSTIJKPlayerSmallEPG.a;
    }

    public final void J(IMediaPlayer iMediaPlayer, a.b bVar) {
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
    /* JADX WARN: Removed duplicated region for block: B:15:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tv.danmaku.ijk.media.player.IMediaPlayer K(int r10) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSmallEPG.K(int):tv.danmaku.ijk.media.player.IMediaPlayer");
    }

    public void L(int i2) {
        w7.e.b(this.j, i2);
    }

    public void M() {
        v7.a.d(this.j);
    }

    public void N(boolean z) {
        if (z || this.A) {
            d0(false);
            this.l0.b(a7.f.P).a();
            this.l0.b(a7.f.o2).a();
            this.l0.b(a7.f.z).c();
            this.l0.b(a7.f.S9).a();
            this.A = false;
            P();
        }
    }

    public final void O() {
        this.l0.b(a7.f.A).a();
        this.l0.b(a7.f.G).a();
        if (m7.a.B.booleanValue()) {
            this.l0.b(a7.f.Sm).a();
        }
        d0(false);
        P();
    }

    public void P() {
        this.l0.b(a7.f.P).a();
        this.l0.b(a7.f.o2).a();
        this.l0.b(a7.f.S9).a();
        this.A = false;
        this.E.removeCallbacksAndMessages((Object) null);
        if (m7.a.B.booleanValue()) {
            this.l0.b(a7.f.Sm).g();
        }
    }

    public final void Q() {
        boolean p = this.P.p();
        this.L0 = p;
        if (p) {
            v7.a.b(getContext());
            this.j = v7.a.a();
        }
    }

    public final void R() {
        this.I0.clear();
        if (this.P.s()) {
            this.I0.add(1);
        }
        if (this.P.t()) {
            this.I0.add(2);
        }
        if (this.P.r()) {
            this.I0.add(0);
        }
        if (this.I0.isEmpty()) {
            this.I0.add(1);
        }
        int intValue = ((Integer) this.I0.get(this.J0)).intValue();
        this.K0 = intValue;
        setRender(intValue);
    }

    public final void S(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.O = applicationContext;
        this.P = new u7.a(applicationContext);
        Q();
        R();
        this.k = 0;
        this.l = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.g = 0;
        this.h = 0;
        TextView textView = new TextView(context);
        this.e0 = textView;
        textView.setTextSize(24.0f);
        this.e0.setTextColor(context.getResources().getColor(a7.c.G));
        this.e0.setGravity(17);
        addView(this.e0, new FrameLayout.LayoutParams(-1, -2, 80));
    }

    public boolean T() {
        return this.L0;
    }

    public final boolean U() {
        int i2;
        return (this.j == null || (i2 = this.g) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public void V() {
        IMediaPlayer.OnErrorListener onErrorListener;
        if (this.c == null || this.i == null) {
            return;
        }
        W(false);
        try {
            ((AudioManager) this.O.getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 1);
        } catch (Exception unused) {
        }
        try {
            this.j = K(this.P.x());
            getContext();
            this.j.setOnPreparedListener(this.y0);
            this.j.setOnVideoSizeChangedListener(this.x0);
            this.j.setOnCompletionListener(this.z0);
            this.j.setOnErrorListener(this.B0);
            this.j.setOnInfoListener(this.A0);
            this.j.setOnBufferingUpdateListener(this.C0);
            this.j.setOnSeekCompleteListener(this.D0);
            this.j.setOnTimedTextListener(this.E0);
            this.r = 0;
            String scheme = this.c.getScheme();
            if (Build.VERSION.SDK_INT >= 23 && this.P.F() && (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                this.j.setDataSource(new w7.a(new File(this.c.toString())));
            } else {
                this.j.setDataSource(this.O, this.c, this.e);
            }
            J(this.j, this.i);
            this.j.setAudioStreamType(3);
            this.j.setScreenOnWhilePlaying(true);
            this.T = System.currentTimeMillis();
            this.j.prepareAsync();
            this.k0 = this.f0.getResources().getDisplayMetrics().widthPixels;
            AudioManager audioManager = (AudioManager) this.f0.getSystemService("audio");
            this.h0 = audioManager;
            this.i0 = audioManager.getStreamMaxVolume(3);
            this.g = 1;
        } catch (IllegalArgumentException e2) {
            Log.w(this.a, "Unable to open content: " + this.c, e2);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.B0;
            onErrorListener.onError(this.j, 1, 0);
        } catch (NullPointerException e3) {
            Log.w(this.a, "Unable to open content: " + this.c, e3);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.B0;
            onErrorListener.onError(this.j, 1, 0);
        } catch (Exception e4) {
            Log.w(this.a, "Unable to open content: " + this.c, e4);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.B0;
            onErrorListener.onError(this.j, 1, 0);
        } catch (IOException e5) {
            Log.w(this.a, "Unable to open content: " + this.c, e5);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.B0;
            onErrorListener.onError(this.j, 1, 0);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void W(boolean z) {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.j.release();
            this.j = null;
            this.g = 0;
            if (z) {
                this.h = 0;
            }
            ((AudioManager) this.O.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public void X() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    public void Y(int i2) {
        w7.e.e(this.j, i2);
    }

    public void Z(Activity activity, NSTIJKPlayerSmallEPG nSTIJKPlayerSmallEPG) {
        this.f0 = activity;
        this.g0 = nSTIJKPlayerSmallEPG;
        this.E = new Handler();
        this.F = new Handler();
        this.l0 = new m(activity);
    }

    public final void a0(Uri uri, Map map, boolean z, String str) {
        this.c = uri;
        this.d = str;
        this.e = map;
        this.u = 0;
        this.I = z;
        h0();
        V();
        requestLayout();
        invalidate();
    }

    public void b0(Uri uri, boolean z, String str) {
        a0(uri, null, z, str);
    }

    public void c0(int i2) {
        this.l0.b(a7.f.P).g();
        this.l0.b(a7.f.o2).g();
        this.l0.b(a7.f.S9).g();
        if (!this.C) {
            d0(true);
        }
        if (!this.G) {
            this.l0.b(a7.f.z).g();
        }
        this.f0.findViewById(a7.f.t7).setVisibility(0);
        this.E.postDelayed(new e(), 5000L);
        i0();
    }

    public boolean canPause() {
        return this.v;
    }

    public boolean canSeekBackward() {
        return this.w;
    }

    public boolean canSeekForward() {
        return this.x;
    }

    public void d0(boolean z) {
        this.l0.b(a7.f.w).f(z ? 0 : 8);
        this.l0.b(a7.f.x).f(z ? 0 : 8);
        this.l0.b(a7.f.F).f(z ? 0 : 8);
    }

    public final void e0(String str) {
        this.l0.b(a7.f.Im).a();
        this.l0.b(a7.f.G).g();
        this.l0.b(a7.f.K).e(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0120 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f0(int r9) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSmallEPG.f0(int):void");
    }

    public void g0() {
        v7.a.d(null);
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        if (this.j != null) {
            return this.r;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (U()) {
            return (int) this.j.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentWindowIndex() {
        return this.H;
    }

    public int getDuration() {
        if (U()) {
            return (int) this.j.getDuration();
        }
        return -1;
    }

    public Boolean getFullScreenValue() {
        return Boolean.valueOf(this.I);
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    public void h0() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.j.release();
            this.j = null;
            this.g = 0;
            this.h = 0;
            ((AudioManager) this.O.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public final void i0() {
        m mVar;
        int i2;
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer == null || !iMediaPlayer.isPlaying()) {
            this.l0.b(a7.f.C3).a();
            this.l0.b(a7.f.D3).g();
            mVar = this.l0;
            i2 = a7.f.D3;
        } else {
            this.l0.b(a7.f.D3).a();
            this.l0.b(a7.f.C3).g();
            mVar = this.l0;
            i2 = a7.f.C3;
        }
        mVar.b(i2).d();
    }

    public boolean isPlaying() {
        IMediaPlayer iMediaPlayer;
        return U() && (iMediaPlayer = this.j) != null && iMediaPlayer.isPlaying();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 != 5) {
        }
        U();
        return super.onKeyDown(i2, keyEvent);
    }

    public void pause() {
        IMediaPlayer iMediaPlayer;
        if (U() && (iMediaPlayer = this.j) != null && iMediaPlayer.isPlaying()) {
            this.j.pause();
            this.g = 4;
        }
        this.h = 4;
    }

    public void seekTo(int i2) {
        if (U()) {
            this.V = System.currentTimeMillis();
            this.j.seekTo(i2);
            i2 = 0;
        }
        this.u = i2;
    }

    public void setCurrentWindowIndex(int i2) {
        this.H = i2;
    }

    public void setHudView(TableLayout tableLayout) {
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.p = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.s = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.t = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.q = onPreparedListener;
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
            if (this.j != null) {
                surfaceView.getSurfaceHolder().b(this.j);
                surfaceView.c(this.j.getVideoWidth(), this.j.getVideoHeight());
                surfaceView.a(this.j.getVideoSarNum(), this.j.getVideoSarDen());
                surfaceView.setAspectRatio(this.H0);
            }
        }
        setRenderView(surfaceView);
    }

    public void setRenderView(com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar) {
        int i2;
        int i3;
        if (this.Q != null) {
            IMediaPlayer iMediaPlayer = this.j;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.Q.getView();
            this.Q.b(this.F0);
            this.Q = null;
            removeView(view);
        }
        if (aVar == null) {
            return;
        }
        this.Q = aVar;
        SharedPreferences sharedPreferences = this.O.getSharedPreferences("loginPrefs", 0);
        this.M = sharedPreferences;
        int i4 = sharedPreferences.getInt("aspect_ratio", 4);
        this.G0 = i4;
        aVar.setAspectRatio(i4);
        int i5 = this.k;
        if (i5 > 0 && (i3 = this.l) > 0) {
            aVar.c(i5, i3);
        }
        int i6 = this.R;
        if (i6 > 0 && (i2 = this.S) > 0) {
            aVar.a(i6, i2);
        }
        View view2 = this.Q.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.Q.e(this.F0);
        this.Q.setVideoRotation(this.o);
    }

    public void setTitle(CharSequence charSequence) {
        this.l0.b(a7.f.O).e(charSequence);
    }

    public void start() {
        if (U()) {
            this.j.start();
            this.g = 3;
        }
        this.h = 3;
    }
}
