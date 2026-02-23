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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerSeriesThumbnail extends FrameLayout implements MediaController.MediaPlayerControl {
    public static final int[] U0 = {0, 1, 2, 3, 4, 5};
    public boolean A;
    public LinearLayout A0;
    public boolean B;
    public LinearLayout B0;
    public int C;
    public ProgressBar C0;
    public Handler D;
    public int D0;
    public Handler E;
    public Handler E0;
    public int F;
    public IMediaPlayer.OnVideoSizeChangedListener F0;
    public boolean G;
    public IMediaPlayer.OnPreparedListener G0;
    public int H;
    public IMediaPlayer.OnCompletionListener H0;
    public int I;
    public IMediaPlayer.OnInfoListener I0;
    public boolean J;
    public IMediaPlayer.OnErrorListener J0;
    public SharedPreferences K;
    public IMediaPlayer.OnBufferingUpdateListener K0;
    public SharedPreferences L;
    public IMediaPlayer.OnSeekCompleteListener L0;
    public Context M;
    public IMediaPlayer.OnTimedTextListener M0;
    public u7.a N;
    public a.a N0;
    public com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a O;
    public int O0;
    public int P;
    public int P0;
    public int Q;
    public List Q0;
    public long R;
    public int R0;
    public long S;
    public int S0;
    public long T;
    public boolean T0;
    public long U;
    public TextView V;
    public Activity W;
    public String a;
    public Uri c;
    public String d;
    public Map e;
    public NSTIJKPlayerSeriesThumbnail e0;
    public int f;
    public AudioManager f0;
    public int g;
    public int g0;
    public int h;
    public float h0;
    public a.b i;
    public int i0;
    public IMediaPlayer j;
    public k j0;
    public int k;
    public Boolean k0;
    public int l;
    public Boolean l0;
    public int m;
    public Boolean m0;
    public int n;
    public Boolean n0;
    public int o;
    public Boolean o0;
    public IMediaPlayer.OnCompletionListener p;
    public Boolean p0;
    public IMediaPlayer.OnPreparedListener q;
    public SharedPreferences q0;
    public int r;
    public SharedPreferences r0;
    public IMediaPlayer.OnErrorListener s;
    public SharedPreferences s0;
    public IMediaPlayer.OnInfoListener t;
    public SharedPreferences t0;
    public int u;
    public LiveStreamDBHandler u0;
    public boolean v;
    public Context v0;
    public boolean w;
    public NSTIJKPlayerSeriesThumbnail w0;
    public boolean x;
    public LinearLayout x0;
    public int y;
    public LinearLayout y0;
    public long z;
    public ImageView z0;

    public class a implements a.a {
        public a() {
        }

        public void a(a.b bVar, int i, int i2, int i3) {
            if (bVar.a() != NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this)) {
                Log.e(NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this), "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerSeriesThumbnail.g(NSTIJKPlayerSeriesThumbnail.this, i2);
            NSTIJKPlayerSeriesThumbnail.i(NSTIJKPlayerSeriesThumbnail.this, i3);
            boolean z = false;
            boolean z2 = NSTIJKPlayerSeriesThumbnail.j(NSTIJKPlayerSeriesThumbnail.this) == 3;
            if (!NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this).d() || (NSTIJKPlayerSeriesThumbnail.b(NSTIJKPlayerSeriesThumbnail.this) == i2 && NSTIJKPlayerSeriesThumbnail.q(NSTIJKPlayerSeriesThumbnail.this) == i3)) {
                z = true;
            }
            if (NSTIJKPlayerSeriesThumbnail.F(NSTIJKPlayerSeriesThumbnail.this) != null && z2 && z) {
                if (NSTIJKPlayerSeriesThumbnail.e(NSTIJKPlayerSeriesThumbnail.this) != 0) {
                    NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail = NSTIJKPlayerSeriesThumbnail.this;
                    nSTIJKPlayerSeriesThumbnail.seekTo(NSTIJKPlayerSeriesThumbnail.e(nSTIJKPlayerSeriesThumbnail));
                }
                NSTIJKPlayerSeriesThumbnail.this.start();
            }
        }

        public void b(a.b bVar, int i, int i2) {
            if (bVar.a() != NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this)) {
                Log.e(NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this), "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerSeriesThumbnail.v(NSTIJKPlayerSeriesThumbnail.this, bVar);
            if (NSTIJKPlayerSeriesThumbnail.F(NSTIJKPlayerSeriesThumbnail.this) == null) {
                NSTIJKPlayerSeriesThumbnail.this.U();
            } else {
                NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail = NSTIJKPlayerSeriesThumbnail.this;
                NSTIJKPlayerSeriesThumbnail.w(nSTIJKPlayerSeriesThumbnail, NSTIJKPlayerSeriesThumbnail.F(nSTIJKPlayerSeriesThumbnail), bVar);
            }
        }

        public void c(a.b bVar) {
            if (bVar.a() != NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this)) {
                Log.e(NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this), "onSurfaceDestroyed: unmatched render callback\n");
            } else {
                NSTIJKPlayerSeriesThumbnail.v(NSTIJKPlayerSeriesThumbnail.this, null);
                NSTIJKPlayerSeriesThumbnail.this.W();
            }
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                NSTIJKPlayerSeriesThumbnail.this.L(false);
            } else {
                if (i != 4) {
                    return;
                }
                NSTIJKPlayerSeriesThumbnail.a(NSTIJKPlayerSeriesThumbnail.this).b(a7.f.U).a();
                NSTIJKPlayerSeriesThumbnail.a(NSTIJKPlayerSeriesThumbnail.this).b(a7.f.v).a();
                NSTIJKPlayerSeriesThumbnail.a(NSTIJKPlayerSeriesThumbnail.this).b(a7.f.y).a();
            }
        }
    }

    public class c implements IMediaPlayer.OnVideoSizeChangedListener {
        public c() {
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            NSTIJKPlayerSeriesThumbnail.d(NSTIJKPlayerSeriesThumbnail.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerSeriesThumbnail.s(NSTIJKPlayerSeriesThumbnail.this, iMediaPlayer.getVideoHeight());
            NSTIJKPlayerSeriesThumbnail.y(NSTIJKPlayerSeriesThumbnail.this, iMediaPlayer.getVideoSarNum());
            NSTIJKPlayerSeriesThumbnail.A(NSTIJKPlayerSeriesThumbnail.this, iMediaPlayer.getVideoSarDen());
            if (NSTIJKPlayerSeriesThumbnail.b(NSTIJKPlayerSeriesThumbnail.this) == 0 || NSTIJKPlayerSeriesThumbnail.q(NSTIJKPlayerSeriesThumbnail.this) == 0) {
                return;
            }
            if (NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this) != null) {
                NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this).c(NSTIJKPlayerSeriesThumbnail.b(NSTIJKPlayerSeriesThumbnail.this), NSTIJKPlayerSeriesThumbnail.q(NSTIJKPlayerSeriesThumbnail.this));
                NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this).a(NSTIJKPlayerSeriesThumbnail.x(NSTIJKPlayerSeriesThumbnail.this), NSTIJKPlayerSeriesThumbnail.z(NSTIJKPlayerSeriesThumbnail.this));
            }
            NSTIJKPlayerSeriesThumbnail.this.requestLayout();
        }
    }

    public class d implements IMediaPlayer.OnPreparedListener {
        public d() {
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerSeriesThumbnail.C(NSTIJKPlayerSeriesThumbnail.this, System.currentTimeMillis());
            NSTIJKPlayerSeriesThumbnail.D(NSTIJKPlayerSeriesThumbnail.this, 2);
            if (NSTIJKPlayerSeriesThumbnail.E(NSTIJKPlayerSeriesThumbnail.this) != null) {
                NSTIJKPlayerSeriesThumbnail.E(NSTIJKPlayerSeriesThumbnail.this).onPrepared(NSTIJKPlayerSeriesThumbnail.F(NSTIJKPlayerSeriesThumbnail.this));
            }
            NSTIJKPlayerSeriesThumbnail.c(NSTIJKPlayerSeriesThumbnail.this);
            NSTIJKPlayerSeriesThumbnail.d(NSTIJKPlayerSeriesThumbnail.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerSeriesThumbnail.s(NSTIJKPlayerSeriesThumbnail.this, iMediaPlayer.getVideoHeight());
            int e = NSTIJKPlayerSeriesThumbnail.e(NSTIJKPlayerSeriesThumbnail.this);
            if (e != 0) {
                NSTIJKPlayerSeriesThumbnail.this.seekTo(e);
            }
            if (NSTIJKPlayerSeriesThumbnail.b(NSTIJKPlayerSeriesThumbnail.this) == 0 || NSTIJKPlayerSeriesThumbnail.q(NSTIJKPlayerSeriesThumbnail.this) == 0) {
                if (NSTIJKPlayerSeriesThumbnail.j(NSTIJKPlayerSeriesThumbnail.this) == 3) {
                    NSTIJKPlayerSeriesThumbnail.this.start();
                    return;
                }
                return;
            }
            if (NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this) != null) {
                NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this).c(NSTIJKPlayerSeriesThumbnail.b(NSTIJKPlayerSeriesThumbnail.this), NSTIJKPlayerSeriesThumbnail.q(NSTIJKPlayerSeriesThumbnail.this));
                NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this).a(NSTIJKPlayerSeriesThumbnail.x(NSTIJKPlayerSeriesThumbnail.this), NSTIJKPlayerSeriesThumbnail.z(NSTIJKPlayerSeriesThumbnail.this));
                if (!NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this).d() || (NSTIJKPlayerSeriesThumbnail.f(NSTIJKPlayerSeriesThumbnail.this) == NSTIJKPlayerSeriesThumbnail.b(NSTIJKPlayerSeriesThumbnail.this) && NSTIJKPlayerSeriesThumbnail.h(NSTIJKPlayerSeriesThumbnail.this) == NSTIJKPlayerSeriesThumbnail.q(NSTIJKPlayerSeriesThumbnail.this))) {
                    if (NSTIJKPlayerSeriesThumbnail.j(NSTIJKPlayerSeriesThumbnail.this) == 3) {
                        NSTIJKPlayerSeriesThumbnail.this.start();
                    } else {
                        if (NSTIJKPlayerSeriesThumbnail.this.isPlaying()) {
                            return;
                        }
                        if (e == 0 && NSTIJKPlayerSeriesThumbnail.this.getCurrentPosition() <= 0) {
                            return;
                        }
                    }
                    NSTIJKPlayerSeriesThumbnail.c(NSTIJKPlayerSeriesThumbnail.this);
                }
            }
        }
    }

    public class e implements IMediaPlayer.OnCompletionListener {
        public e() {
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerSeriesThumbnail.D(NSTIJKPlayerSeriesThumbnail.this, 5);
            NSTIJKPlayerSeriesThumbnail.k(NSTIJKPlayerSeriesThumbnail.this, 5);
            NSTIJKPlayerSeriesThumbnail.c(NSTIJKPlayerSeriesThumbnail.this);
            NSTIJKPlayerSeriesThumbnail.l(NSTIJKPlayerSeriesThumbnail.this, -1);
            if (NSTIJKPlayerSeriesThumbnail.m(NSTIJKPlayerSeriesThumbnail.this) != null) {
                NSTIJKPlayerSeriesThumbnail.m(NSTIJKPlayerSeriesThumbnail.this).onCompletion(NSTIJKPlayerSeriesThumbnail.F(NSTIJKPlayerSeriesThumbnail.this));
            }
        }
    }

    public class f implements IMediaPlayer.OnInfoListener {
        public f() {
        }

        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            String o;
            String str;
            if (NSTIJKPlayerSeriesThumbnail.n(NSTIJKPlayerSeriesThumbnail.this) != null) {
                NSTIJKPlayerSeriesThumbnail.n(NSTIJKPlayerSeriesThumbnail.this).onInfo(iMediaPlayer, i, i2);
            }
            if (i == 3) {
                NSTIJKPlayerSeriesThumbnail.l(NSTIJKPlayerSeriesThumbnail.this, 2);
                o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                str = "MEDIA_INFO_VIDEO_RENDERING_START:";
            } else if (i == 10005) {
                NSTIJKPlayerSeriesThumbnail.l(NSTIJKPlayerSeriesThumbnail.this, 1);
                o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                str = "MEDIA_INFO_OPEN_INPUT:";
            } else if (i == 901) {
                o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                str = "MEDIA_INFO_UNSUPPORTED_SUBTITLE:";
            } else {
                if (i != 902) {
                    if (i == 10001) {
                        NSTIJKPlayerSeriesThumbnail.p(NSTIJKPlayerSeriesThumbnail.this, i2);
                        Log.d(NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this), "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        if (NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this) != null) {
                            NSTIJKPlayerSeriesThumbnail.B(NSTIJKPlayerSeriesThumbnail.this).setVideoRotation(i2);
                        }
                    } else if (i != 10002) {
                        switch (i) {
                            case 700:
                                o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                                str = "MEDIA_INFO_VIDEO_TRACK_LAGGING:";
                                break;
                            case 701:
                                NSTIJKPlayerSeriesThumbnail.l(NSTIJKPlayerSeriesThumbnail.this, 1);
                                o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                                str = "MEDIA_INFO_BUFFERING_START:";
                                break;
                            case 702:
                                NSTIJKPlayerSeriesThumbnail.l(NSTIJKPlayerSeriesThumbnail.this, 6);
                                o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                                str = "MEDIA_INFO_BUFFERING_END:";
                                break;
                            case 703:
                                o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                                str = "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2;
                                break;
                            default:
                                switch (i) {
                                    case 800:
                                        o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                                        str = "MEDIA_INFO_BAD_INTERLEAVING:";
                                        break;
                                    case 801:
                                        o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                                        str = "MEDIA_INFO_NOT_SEEKABLE:";
                                        break;
                                    case 802:
                                        o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                                        str = "MEDIA_INFO_METADATA_UPDATE:";
                                        break;
                                }
                        }
                    } else {
                        o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                        str = "MEDIA_INFO_AUDIO_RENDERING_START:";
                    }
                    return true;
                }
                o = NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this);
                str = "MEDIA_INFO_SUBTITLE_TIMED_OUT:";
            }
            Log.d(o, str);
            return true;
        }
    }

    public class g implements IMediaPlayer.OnErrorListener {
        public g() {
        }

        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            Log.d(NSTIJKPlayerSeriesThumbnail.o(NSTIJKPlayerSeriesThumbnail.this), "Error: " + i + "," + i2);
            NSTIJKPlayerSeriesThumbnail.D(NSTIJKPlayerSeriesThumbnail.this, -1);
            NSTIJKPlayerSeriesThumbnail.k(NSTIJKPlayerSeriesThumbnail.this, -1);
            NSTIJKPlayerSeriesThumbnail.c(NSTIJKPlayerSeriesThumbnail.this);
            NSTIJKPlayerSeriesThumbnail.l(NSTIJKPlayerSeriesThumbnail.this, -1);
            if (NSTIJKPlayerSeriesThumbnail.r(NSTIJKPlayerSeriesThumbnail.this) != null) {
                NSTIJKPlayerSeriesThumbnail.r(NSTIJKPlayerSeriesThumbnail.this).onError(NSTIJKPlayerSeriesThumbnail.F(NSTIJKPlayerSeriesThumbnail.this), i, i2);
            }
            return true;
        }
    }

    public class h implements IMediaPlayer.OnBufferingUpdateListener {
        public h() {
        }

        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            NSTIJKPlayerSeriesThumbnail.t(NSTIJKPlayerSeriesThumbnail.this, i);
        }
    }

    public class i implements IMediaPlayer.OnSeekCompleteListener {
        public i() {
        }

        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerSeriesThumbnail.u(NSTIJKPlayerSeriesThumbnail.this, System.currentTimeMillis());
        }
    }

    public class j implements IMediaPlayer.OnTimedTextListener {
        public j() {
        }

        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            if (ijkTimedText != null) {
                NSTIJKPlayerSeriesThumbnail.this.V.setText(ijkTimedText.getText().replace("{\\b1}", "").replace("{\\b0}", "").replace("{\\i1}", "").replace("{\\i0}", ""));
            }
        }
    }

    public class k {
        public final Activity a;
        public View b;

        public k(Activity activity) {
            this.a = activity;
        }

        public k a() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(8);
            }
            return this;
        }

        public k b(int i) {
            this.b = this.a.findViewById(i);
            return this;
        }

        public k c() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(4);
            }
            return this;
        }

        public k d() {
            View view = this.b;
            if (view != null) {
                view.requestFocus();
            }
            return this;
        }

        public k e(CharSequence charSequence) {
            TextView textView = this.b;
            if (textView != null && (textView instanceof TextView)) {
                textView.setText(charSequence);
            }
            return this;
        }

        public k f(int i) {
            View view = this.b;
            if (view != null) {
                view.setVisibility(i);
            }
            return this;
        }

        public k g() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(0);
            }
            return this;
        }
    }

    public NSTIJKPlayerSeriesThumbnail(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "NSTIJKPlayerEPG";
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
        this.B = false;
        this.C = 7000;
        this.F = 0;
        this.H = 0;
        this.I = 5;
        this.J = false;
        this.R = 0L;
        this.S = 0L;
        this.T = 0L;
        this.U = 0L;
        this.h0 = -1.0f;
        Boolean bool = Boolean.FALSE;
        this.k0 = bool;
        this.l0 = bool;
        this.m0 = bool;
        this.n0 = bool;
        this.o0 = bool;
        this.p0 = bool;
        this.D0 = 0;
        this.E0 = new b(Looper.getMainLooper());
        this.F0 = new c();
        this.G0 = new d();
        this.H0 = new e();
        this.I0 = new f();
        this.J0 = new g();
        this.K0 = new h();
        this.L0 = new i();
        this.M0 = new j();
        this.N0 = new a();
        this.O0 = 4;
        this.P0 = U0[0];
        this.Q0 = new ArrayList();
        this.R0 = 0;
        this.S0 = 0;
        this.T0 = false;
        Q(context);
    }

    public static /* synthetic */ int A(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.Q = i2;
        return i2;
    }

    public static /* synthetic */ com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a B(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.O;
    }

    public static /* synthetic */ long C(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, long j2) {
        nSTIJKPlayerSeriesThumbnail.S = j2;
        return j2;
    }

    public static /* synthetic */ int D(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.g = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnPreparedListener E(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.q;
    }

    public static /* synthetic */ IMediaPlayer F(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.j;
    }

    public static /* synthetic */ k a(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.j0;
    }

    public static /* synthetic */ int b(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.k;
    }

    public static /* synthetic */ w7.b c(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        nSTIJKPlayerSeriesThumbnail.getClass();
        return null;
    }

    public static /* synthetic */ int d(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.k = i2;
        return i2;
    }

    public static /* synthetic */ int e(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.u;
    }

    public static /* synthetic */ int f(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.m;
    }

    public static /* synthetic */ int g(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.m = i2;
        return i2;
    }

    public static /* synthetic */ int h(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.n;
    }

    public static /* synthetic */ int i(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.n = i2;
        return i2;
    }

    public static /* synthetic */ int j(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.h;
    }

    public static /* synthetic */ int k(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.h = i2;
        return i2;
    }

    public static /* synthetic */ void l(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.c0(i2);
    }

    public static /* synthetic */ IMediaPlayer.OnCompletionListener m(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.p;
    }

    public static /* synthetic */ IMediaPlayer.OnInfoListener n(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.t;
    }

    public static /* synthetic */ String o(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.a;
    }

    public static /* synthetic */ int p(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.o = i2;
        return i2;
    }

    public static /* synthetic */ int q(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.l;
    }

    public static /* synthetic */ IMediaPlayer.OnErrorListener r(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.s;
    }

    public static /* synthetic */ int s(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.l = i2;
        return i2;
    }

    public static /* synthetic */ int t(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.r = i2;
        return i2;
    }

    public static /* synthetic */ long u(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, long j2) {
        nSTIJKPlayerSeriesThumbnail.U = j2;
        return j2;
    }

    public static /* synthetic */ a.b v(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, a.b bVar) {
        nSTIJKPlayerSeriesThumbnail.i = bVar;
        return bVar;
    }

    public static /* synthetic */ void w(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, IMediaPlayer iMediaPlayer, a.b bVar) {
        nSTIJKPlayerSeriesThumbnail.H(iMediaPlayer, bVar);
    }

    public static /* synthetic */ int x(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.P;
    }

    public static /* synthetic */ int y(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, int i2) {
        nSTIJKPlayerSeriesThumbnail.P = i2;
        return i2;
    }

    public static /* synthetic */ int z(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        return nSTIJKPlayerSeriesThumbnail.Q;
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
    public tv.danmaku.ijk.media.player.IMediaPlayer I(int r10) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSeriesThumbnail.I(int):tv.danmaku.ijk.media.player.IMediaPlayer");
    }

    public void J(int i2) {
        w7.e.b(this.j, i2);
    }

    public void K() {
        v7.a.d(this.j);
    }

    public void L(boolean z) {
        if (z || this.A) {
            b0(false);
            this.j0.b(a7.f.P).a();
            this.j0.b(a7.f.o2).a();
            this.j0.b(a7.f.z).c();
            this.j0.b(a7.f.S9).a();
            this.A = false;
            N();
        }
    }

    public void M(NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3, LinearLayout linearLayout4, ProgressBar progressBar, int i2) {
        this.w0 = nSTIJKPlayerSeriesThumbnail;
        this.x0 = linearLayout;
        this.y0 = linearLayout2;
        this.z0 = imageView;
        this.A0 = linearLayout3;
        this.B0 = linearLayout4;
        this.C0 = progressBar;
        this.D0 = i2;
    }

    public void N() {
        this.j0.b(a7.f.P).a();
        this.j0.b(a7.f.o2).a();
        this.j0.b(a7.f.S9).a();
        this.A = false;
        this.D.removeCallbacksAndMessages((Object) null);
        if (m7.a.B.booleanValue()) {
            this.j0.b(a7.f.Sm).g();
        }
    }

    public final void O() {
        boolean p = this.N.p();
        this.T0 = p;
        if (p) {
            v7.a.b(getContext());
            this.j = v7.a.a();
        }
    }

    public final void P() {
        this.Q0.clear();
        if (this.N.s()) {
            this.Q0.add(1);
        }
        if (this.N.t()) {
            this.Q0.add(2);
        }
        if (this.N.r()) {
            this.Q0.add(0);
        }
        if (this.Q0.isEmpty()) {
            this.Q0.add(1);
        }
        int intValue = ((Integer) this.Q0.get(this.R0)).intValue();
        this.S0 = intValue;
        setRender(intValue);
    }

    public final void Q(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.M = applicationContext;
        this.N = new u7.a(applicationContext);
        O();
        P();
        this.k = 0;
        this.l = 0;
        this.g = 0;
        this.h = 0;
        TextView textView = new TextView(context);
        this.V = textView;
        textView.setTextSize(24.0f);
        this.V.setTextColor(context.getResources().getColor(a7.c.G));
        this.V.setGravity(17);
        addView(this.V, new FrameLayout.LayoutParams(-1, -2, 80));
    }

    public boolean R() {
        return this.T0;
    }

    public final boolean S() {
        int i2;
        return (this.j == null || (i2 = this.g) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public void T() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.setVolume(0.0f, 0.0f);
        }
    }

    public void U() {
        IMediaPlayer.OnErrorListener onErrorListener;
        if (this.c == null || this.i == null) {
            return;
        }
        V(false);
        try {
            ((AudioManager) this.M.getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 1);
        } catch (Exception unused) {
        }
        try {
            this.j = I(this.N.x());
            getContext();
            this.j.setOnPreparedListener(this.G0);
            this.j.setOnVideoSizeChangedListener(this.F0);
            this.j.setOnCompletionListener(this.H0);
            this.j.setOnErrorListener(this.J0);
            this.j.setOnInfoListener(this.I0);
            this.j.setOnBufferingUpdateListener(this.K0);
            this.j.setOnSeekCompleteListener(this.L0);
            this.j.setOnTimedTextListener(this.M0);
            this.r = 0;
            String scheme = this.c.getScheme();
            if (Build.VERSION.SDK_INT >= 23 && this.N.F() && (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                this.j.setDataSource(new w7.a(new File(this.c.toString())));
            } else {
                this.j.setDataSource(this.M, this.c, this.e);
            }
            H(this.j, this.i);
            this.j.setAudioStreamType(3);
            this.j.setScreenOnWhilePlaying(true);
            this.R = System.currentTimeMillis();
            this.j.prepareAsync();
            this.i0 = this.W.getResources().getDisplayMetrics().widthPixels;
            AudioManager audioManager = (AudioManager) this.W.getSystemService("audio");
            this.f0 = audioManager;
            this.g0 = audioManager.getStreamMaxVolume(3);
            T();
            this.g = 1;
        } catch (IllegalArgumentException e2) {
            Log.w(this.a, "Unable to open content: " + this.c, e2);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.J0;
            onErrorListener.onError(this.j, 1, 0);
        } catch (NullPointerException e3) {
            Log.w(this.a, "Unable to open content: " + this.c, e3);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.J0;
            onErrorListener.onError(this.j, 1, 0);
        } catch (Exception e4) {
            Log.w(this.a, "Unable to open content: " + this.c, e4);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.J0;
            onErrorListener.onError(this.j, 1, 0);
        } catch (IOException e5) {
            Log.w(this.a, "Unable to open content: " + this.c, e5);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.J0;
            onErrorListener.onError(this.j, 1, 0);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void V(boolean z) {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.j.release();
            this.j = null;
            this.g = 0;
            if (z) {
                this.h = 0;
            }
            ((AudioManager) this.M.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public void W() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    public void X(int i2) {
        w7.e.e(this.j, i2);
    }

    public void Y(Activity activity, NSTIJKPlayerSeriesThumbnail nSTIJKPlayerSeriesThumbnail) {
        this.W = activity;
        this.e0 = nSTIJKPlayerSeriesThumbnail;
        this.D = new Handler();
        this.E = new Handler();
        this.j0 = new k(activity);
    }

    public final void Z(Uri uri, Map map, boolean z, String str) {
        this.c = uri;
        this.d = str;
        this.e = map;
        this.u = 0;
        this.G = z;
        e0();
        U();
        requestLayout();
        invalidate();
    }

    public void a0(Uri uri, boolean z, String str) {
        Z(uri, null, z, str);
    }

    public void b0(boolean z) {
        this.j0.b(a7.f.w).f(z ? 0 : 8);
        this.j0.b(a7.f.x).f(z ? 0 : 8);
        this.j0.b(a7.f.F).f(z ? 0 : 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c0(int r8) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSeriesThumbnail.c0(int):void");
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

    public void d0() {
        v7.a.d(null);
    }

    public void e0() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.j.release();
            this.j = null;
            this.g = 0;
            this.h = 0;
            ((AudioManager) this.M.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
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
        if (S()) {
            return (int) this.j.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentWindowIndex() {
        return this.F;
    }

    public int getDuration() {
        if (S()) {
            return (int) this.j.getDuration();
        }
        return -1;
    }

    public Boolean getFullScreenValue() {
        return Boolean.valueOf(this.G);
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    public boolean isPlaying() {
        IMediaPlayer iMediaPlayer;
        return S() && (iMediaPlayer = this.j) != null && iMediaPlayer.isPlaying();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 != 5) {
        }
        S();
        return super.onKeyDown(i2, keyEvent);
    }

    public void pause() {
        IMediaPlayer iMediaPlayer;
        if (S() && (iMediaPlayer = this.j) != null && iMediaPlayer.isPlaying()) {
            this.j.pause();
            this.g = 4;
        }
        this.h = 4;
    }

    public void seekTo(int i2) {
        if (S()) {
            this.T = System.currentTimeMillis();
            this.j.seekTo(i2);
            i2 = 0;
        }
        this.u = i2;
    }

    public void setContext(Context context) {
        this.v0 = context;
    }

    public void setCurrentWindowIndex(int i2) {
        this.F = i2;
    }

    public void setHudView(TableLayout tableLayout) {
    }

    public void setLiveStreamDBHandler(LiveStreamDBHandler liveStreamDBHandler) {
        this.u0 = liveStreamDBHandler;
    }

    public void setMediaController(w7.b bVar) {
        G();
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
                surfaceView.setAspectRatio(this.P0);
            }
        }
        setRenderView(surfaceView);
    }

    public void setRenderView(com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar) {
        int i2;
        int i3;
        if (this.O != null) {
            IMediaPlayer iMediaPlayer = this.j;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.O.getView();
            this.O.b(this.N0);
            this.O = null;
            removeView(view);
        }
        if (aVar == null) {
            return;
        }
        this.O = aVar;
        SharedPreferences sharedPreferences = this.M.getSharedPreferences("loginPrefs", 0);
        this.K = sharedPreferences;
        int i4 = sharedPreferences.getInt("aspect_ratio", 4);
        this.O0 = i4;
        aVar.setAspectRatio(i4);
        int i5 = this.k;
        if (i5 > 0 && (i3 = this.l) > 0) {
            aVar.c(i5, i3);
        }
        int i6 = this.P;
        if (i6 > 0 && (i2 = this.Q) > 0) {
            aVar.a(i6, i2);
        }
        View view2 = this.O.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.O.e(this.N0);
        this.O.setVideoRotation(this.o);
    }

    public void setTitle(CharSequence charSequence) {
        this.j0.b(a7.f.O).e(charSequence);
    }

    public void start() {
        if (S()) {
            this.j.start();
            this.g = 3;
        }
        this.h = 3;
    }
}
