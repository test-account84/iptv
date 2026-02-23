package com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.callback.VodInfoCallback;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PlayerResumeDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.PanelAvailableChannelsPojo;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import mbanje.kurt.fabbutton.FabButton;
import p7.z0;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerVOD extends FrameLayout implements MediaController.MediaPlayerControl, z7.n {
    public static final int[] K1 = {0, 1, 2, 3, 4, 5};
    public boolean A;
    public TextView A0;
    public IMediaPlayer.OnBufferingUpdateListener A1;
    public boolean B;
    public StringBuilder B0;
    public IMediaPlayer.OnSeekCompleteListener B1;
    public boolean C;
    public Formatter C0;
    public IMediaPlayer.OnTimedTextListener C1;
    public int D;
    public SharedPreferences D0;
    public a.a D1;
    public Handler E;
    public SharedPreferences.Editor E0;
    public int E1;
    public Handler F;
    public RecentWatchDBHandler F0;
    public int F1;
    public int G;
    public LiveStreamDBHandler G0;
    public List G1;
    public boolean H;
    public PlayerResumeDBHandler H0;
    public int H1;
    public int I;
    public boolean I0;
    public int I1;
    public int J;
    public int J0;
    public boolean J1;
    public boolean K;
    public int K0;
    public SharedPreferences L;
    public long L0;
    public SharedPreferences.Editor M;
    public int M0;
    public SharedPreferences N;
    public boolean N0;
    public SharedPreferences O;
    public String O0;
    public Context P;
    public String P0;
    public u7.a Q;
    public String Q0;
    public com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a R;
    public ArrayList R0;
    public int S;
    public boolean S0;
    public int T;
    public boolean T0;
    public long U;
    public SharedPreferences U0;
    public long V;
    public SharedPreferences V0;
    public long W;
    public SharedPreferences W0;
    public SharedPreferences X0;
    public SharedPreferences.Editor Y0;
    public SharedPreferences.Editor Z0;
    public String a;
    public SharedPreferences.Editor a1;
    public int b1;
    public Uri c;
    public boolean c1;
    public String d;
    public boolean d1;
    public Map e;
    public long e0;
    public boolean e1;
    public int f;
    public TextView f0;
    public boolean f1;
    public int g;
    public Activity g0;
    public SeriesRecentWatchDatabase g1;
    public int h;
    public NSTIJKPlayerVOD h0;
    public boolean h1;
    public a.b i;
    public AudioManager i0;
    public z0 i1;
    public IMediaPlayer j;
    public int j0;
    public SharedPreferences j1;
    public int k;
    public float k0;
    public n7.l k1;
    public int l;
    public GestureDetector l0;
    public RelativeLayout l1;
    public int m;
    public int m0;
    public FabButton m1;
    public int n;
    public View n0;
    public int n1;
    public int o;
    public C o0;
    public Runnable o1;
    public IMediaPlayer.OnCompletionListener p;
    public androidx.appcompat.app.a p0;
    public Handler p1;
    public IMediaPlayer.OnPreparedListener q;
    public Button q0;
    public PopupWindow q1;
    public int r;
    public Boolean r0;
    public Button r1;
    public IMediaPlayer.OnErrorListener s;
    public Boolean s0;
    public final SeekBar.OnSeekBarChangeListener s1;
    public IMediaPlayer.OnInfoListener t;
    public Boolean t0;
    public Handler t1;
    public int u;
    public Boolean u0;
    public IMediaPlayer.OnVideoSizeChangedListener u1;
    public boolean v;
    public Boolean v0;
    public IMediaPlayer.OnPreparedListener v1;
    public boolean w;
    public Boolean w0;
    public IMediaPlayer.OnCompletionListener w1;
    public boolean x;
    public SeekBar x0;
    public final View.OnClickListener x1;
    public int y;
    public boolean y0;
    public IMediaPlayer.OnInfoListener y1;
    public long z;
    public boolean z0;
    public IMediaPlayer.OnErrorListener z1;

    public class A implements View.OnFocusChangeListener {
        public final View a;

        public A(View view) {
            this.a = view;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                if (z) {
                    return;
                }
                View view2 = this.a;
                if (view2 != null && view2.getTag() != null && this.a.getTag().equals("1") && NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this) != null) {
                    NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this).setBackgroundResource(a7.e.o);
                }
                a(1.0f);
                b(1.0f);
                return;
            }
            View view3 = this.a;
            if (view3 != null && view3.getTag() != null && this.a.getTag().equals("2")) {
                view.setBackground(NSTIJKPlayerVOD.this.getResources().getDrawable(a7.e.I1));
                return;
            }
            float f = z ? 1.12f : 1.0f;
            a(f);
            b(f);
            View view4 = this.a;
            if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1") || NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this) == null) {
                return;
            }
            NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this).setBackgroundResource(a7.e.h);
        }
    }

    public class B extends GestureDetector.SimpleOnGestureListener {
        public boolean a;
        public boolean c;
        public boolean d;

        public B() {
        }

        public void a(boolean z) {
            if (z || NSTIJKPlayerVOD.o(NSTIJKPlayerVOD.this)) {
                NSTIJKPlayerVOD.this.h2(false);
                NSTIJKPlayerVOD.h(NSTIJKPlayerVOD.this).b(a7.f.P).a();
                NSTIJKPlayerVOD.h(NSTIJKPlayerVOD.this).b(a7.f.o2).a();
                NSTIJKPlayerVOD.h(NSTIJKPlayerVOD.this).b(a7.f.z).d();
                NSTIJKPlayerVOD.h(NSTIJKPlayerVOD.this).b(a7.f.S9).a();
                NSTIJKPlayerVOD.this.J1();
            }
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.a = true;
            return super.onDown(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent == null || motionEvent2 == null) {
                return Boolean.parseBoolean((String) null);
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY() - motionEvent2.getY();
            motionEvent2.getX();
            if (this.a) {
                this.d = Math.abs(f) >= Math.abs(f2);
                this.c = x > ((float) NSTIJKPlayerVOD.x(NSTIJKPlayerVOD.this)) * 0.5f;
                this.a = false;
            }
            if (!this.d) {
                float height = y / NSTIJKPlayerVOD.A(NSTIJKPlayerVOD.this).getHeight();
                if (this.c) {
                    NSTIJKPlayerVOD.z(NSTIJKPlayerVOD.this, height);
                } else {
                    NSTIJKPlayerVOD.B(NSTIJKPlayerVOD.this, height);
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (NSTIJKPlayerVOD.o(NSTIJKPlayerVOD.this)) {
                a(false);
            } else {
                LinearLayout findViewById = NSTIJKPlayerVOD.v(NSTIJKPlayerVOD.this).findViewById(a7.f.P);
                LinearLayout findViewById2 = NSTIJKPlayerVOD.v(NSTIJKPlayerVOD.this).findViewById(a7.f.o2);
                LinearLayout findViewById3 = NSTIJKPlayerVOD.v(NSTIJKPlayerVOD.this).findViewById(a7.f.S9);
                if (findViewById.getVisibility() == 0) {
                    findViewById.setVisibility(8);
                    findViewById2.setVisibility(8);
                    findViewById3.setVisibility(8);
                    return true;
                }
                NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
                nSTIJKPlayerVOD.g2(NSTIJKPlayerVOD.r1(nSTIJKPlayerVOD));
            }
            return true;
        }
    }

    public class C {
        public final Activity a;
        public View b;

        public C(Activity activity) {
            this.a = activity;
        }

        public C a() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(8);
            }
            return this;
        }

        public C b(int i) {
            this.b = this.a.findViewById(i);
            return this;
        }

        public C c(int i) {
            ImageView imageView = this.b;
            if (imageView instanceof ImageView) {
                imageView.setImageResource(i);
            }
            return this;
        }

        public C d() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(4);
            }
            return this;
        }

        public C e() {
            View view = this.b;
            if (view != null) {
                view.requestFocus();
            }
            return this;
        }

        public C f(CharSequence charSequence) {
            TextView textView = this.b;
            if (textView != null && (textView instanceof TextView)) {
                textView.setText(charSequence);
            }
            return this;
        }

        public C g(int i) {
            View view = this.b;
            if (view != null) {
                view.setVisibility(i);
            }
            return this;
        }

        public C h() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(0);
            }
            return this;
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            NSTIJKPlayerVOD.A0(NSTIJKPlayerVOD.this);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            NSTIJKPlayerVOD.D0(NSTIJKPlayerVOD.this);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            NSTIJKPlayerVOD.D0(NSTIJKPlayerVOD.this);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            if (view.getId() == M8.c.b || view.getId() == a7.f.H7) {
                NSTIJKPlayerVOD.D0(NSTIJKPlayerVOD.this);
            } else if (view.getId() == a7.f.A1) {
                NSTIJKPlayerVOD.A0(NSTIJKPlayerVOD.this);
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            NSTIJKPlayerVOD.J0(NSTIJKPlayerVOD.this, 1);
            NSTIJKPlayerVOD.K0(NSTIJKPlayerVOD.this).setProgress(NSTIJKPlayerVOD.F0(NSTIJKPlayerVOD.this));
            if (NSTIJKPlayerVOD.F0(NSTIJKPlayerVOD.this) <= 140) {
                NSTIJKPlayerVOD.x0(NSTIJKPlayerVOD.this).postDelayed(NSTIJKPlayerVOD.z0(NSTIJKPlayerVOD.this), 70L);
            }
            if (NSTIJKPlayerVOD.F0(NSTIJKPlayerVOD.this) == 120) {
                NSTIJKPlayerVOD.D0(NSTIJKPlayerVOD.this);
            }
        }
    }

    public class f implements IMediaPlayer.OnInfoListener {
        public f() {
        }

        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            String M0;
            String str;
            if (NSTIJKPlayerVOD.L0(NSTIJKPlayerVOD.this) != null) {
                NSTIJKPlayerVOD.L0(NSTIJKPlayerVOD.this).onInfo(iMediaPlayer, i, i2);
            }
            if (i == 3) {
                NSTIJKPlayerVOD.N0(NSTIJKPlayerVOD.this, 2);
                M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                str = "MEDIA_INFO_VIDEO_RENDERING_START:";
            } else if (i == 10005) {
                NSTIJKPlayerVOD.N0(NSTIJKPlayerVOD.this, 1);
                M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                str = "MEDIA_INFO_OPEN_INPUT:";
            } else if (i == 901) {
                M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                str = "MEDIA_INFO_UNSUPPORTED_SUBTITLE:";
            } else {
                if (i != 902) {
                    if (i == 10001) {
                        NSTIJKPlayerVOD.O0(NSTIJKPlayerVOD.this, i2);
                        Log.d(NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this), "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        if (NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this) != null) {
                            NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this).setVideoRotation(i2);
                        }
                    } else if (i != 10002) {
                        switch (i) {
                            case 700:
                                M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                                str = "MEDIA_INFO_VIDEO_TRACK_LAGGING:";
                                break;
                            case 701:
                                NSTIJKPlayerVOD.N0(NSTIJKPlayerVOD.this, 1);
                                M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                                str = "MEDIA_INFO_BUFFERING_START:";
                                break;
                            case 702:
                                NSTIJKPlayerVOD.N0(NSTIJKPlayerVOD.this, 6);
                                M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                                str = "MEDIA_INFO_BUFFERING_END:";
                                break;
                            case 703:
                                M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                                str = "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2;
                                break;
                            default:
                                switch (i) {
                                    case 800:
                                        M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                                        str = "MEDIA_INFO_BAD_INTERLEAVING:";
                                        break;
                                    case 801:
                                        M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                                        str = "MEDIA_INFO_NOT_SEEKABLE:";
                                        break;
                                    case 802:
                                        M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                                        str = "MEDIA_INFO_METADATA_UPDATE:";
                                        break;
                                }
                        }
                    } else {
                        M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                        str = "MEDIA_INFO_AUDIO_RENDERING_START:";
                    }
                    return true;
                }
                M0 = NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this);
                str = "MEDIA_INFO_SUBTITLE_TIMED_OUT:";
            }
            Log.d(M0, str);
            return true;
        }
    }

    public class g implements IMediaPlayer.OnErrorListener {
        public g() {
        }

        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            Log.d(NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this), "Error: " + i + "," + i2);
            NSTIJKPlayerVOD.Z(NSTIJKPlayerVOD.this, -1);
            NSTIJKPlayerVOD.q0(NSTIJKPlayerVOD.this, -1);
            NSTIJKPlayerVOD.c0(NSTIJKPlayerVOD.this);
            NSTIJKPlayerVOD.N0(NSTIJKPlayerVOD.this, -1);
            if (NSTIJKPlayerVOD.Q0(NSTIJKPlayerVOD.this) != null) {
                NSTIJKPlayerVOD.Q0(NSTIJKPlayerVOD.this).onError(NSTIJKPlayerVOD.g(NSTIJKPlayerVOD.this), i, i2);
            }
            return true;
        }
    }

    public class h implements IMediaPlayer.OnBufferingUpdateListener {
        public h() {
        }

        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            NSTIJKPlayerVOD.R0(NSTIJKPlayerVOD.this, i);
        }
    }

    public class i implements IMediaPlayer.OnSeekCompleteListener {
        public i() {
        }

        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerVOD.S0(NSTIJKPlayerVOD.this, System.currentTimeMillis());
        }
    }

    public class j implements IMediaPlayer.OnTimedTextListener {
        public j() {
        }

        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            if (ijkTimedText == null) {
                NSTIJKPlayerVOD.this.f0.setVisibility(8);
                return;
            }
            String replace = ijkTimedText.getText().replace("{\\b1}", "").replace("{\\b0}", "").replace("{\\i1}", "").replace("{\\i0}", "").replace("{\\c}", "");
            NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
            NSTIJKPlayerVOD.Y0(nSTIJKPlayerVOD, NSTIJKPlayerVOD.s0(nSTIJKPlayerVOD).getSharedPreferences("pref.using_sub_font_size", 0));
            try {
                NSTIJKPlayerVOD.this.f0.setTextSize(2, Float.parseFloat(NSTIJKPlayerVOD.W0(NSTIJKPlayerVOD.this).getString("pref.using_sub_font_size", m7.a.x0)));
            } catch (Exception unused) {
            }
            NSTIJKPlayerVOD.this.f0.setVisibility(0);
            NSTIJKPlayerVOD.this.f0.setText(replace);
        }
    }

    public class k extends o2.g {
        public k() {
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, n2.c cVar) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            RelativeLayout relativeLayout = NSTIJKPlayerVOD.this.l1;
            if (relativeLayout != null) {
                relativeLayout.setBackground(bitmapDrawable);
            }
        }
    }

    public class l implements a.a {
        public l() {
        }

        public void a(a.b bVar, int i, int i2, int i3) {
            if (bVar.a() != NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this)) {
                Log.e(NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this), "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerVOD.l0(NSTIJKPlayerVOD.this, i2);
            NSTIJKPlayerVOD.n0(NSTIJKPlayerVOD.this, i3);
            boolean z = false;
            boolean z2 = NSTIJKPlayerVOD.p0(NSTIJKPlayerVOD.this) == 3;
            if (!NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this).d() || (NSTIJKPlayerVOD.D(NSTIJKPlayerVOD.this) == i2 && NSTIJKPlayerVOD.J(NSTIJKPlayerVOD.this) == i3)) {
                z = true;
            }
            if (NSTIJKPlayerVOD.g(NSTIJKPlayerVOD.this) != null && z2 && z) {
                if (NSTIJKPlayerVOD.j0(NSTIJKPlayerVOD.this) != 0) {
                    NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
                    nSTIJKPlayerVOD.seekTo(NSTIJKPlayerVOD.j0(nSTIJKPlayerVOD));
                }
                NSTIJKPlayerVOD.this.start();
            }
        }

        public void b(a.b bVar, int i, int i2) {
            if (bVar.a() != NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this)) {
                Log.e(NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this), "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerVOD.Z0(NSTIJKPlayerVOD.this, bVar);
            if (NSTIJKPlayerVOD.g(NSTIJKPlayerVOD.this) == null) {
                NSTIJKPlayerVOD.this.R1();
            } else {
                NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
                NSTIJKPlayerVOD.a1(nSTIJKPlayerVOD, NSTIJKPlayerVOD.g(nSTIJKPlayerVOD), bVar);
            }
        }

        public void c(a.b bVar) {
            if (bVar.a() != NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this)) {
                Log.e(NSTIJKPlayerVOD.M0(NSTIJKPlayerVOD.this), "onSurfaceDestroyed: unmatched render callback\n");
            } else {
                NSTIJKPlayerVOD.Z0(NSTIJKPlayerVOD.this, null);
                NSTIJKPlayerVOD.this.U1();
            }
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ LinearLayout a;

        public m(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        public void run() {
            this.a.setVisibility(8);
        }
    }

    public class n implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ PopupWindow c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                n.this.c.dismiss();
            }
        }

        public n(int i, PopupWindow popupWindow) {
            this.a = i;
            this.c = popupWindow;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
            NSTIJKPlayerVOD.c1(nSTIJKPlayerVOD, NSTIJKPlayerVOD.d1(nSTIJKPlayerVOD).edit());
            if (i == 111 || i == 11111111) {
                NSTIJKPlayerVOD.b1(NSTIJKPlayerVOD.this).putInt("currentVideoTrack", -1);
                NSTIJKPlayerVOD.this.B1(this.a);
            } else {
                NSTIJKPlayerVOD.b1(NSTIJKPlayerVOD.this).putInt("currentVideoTrack", i);
                NSTIJKPlayerVOD.this.X1(i);
                int currentPosition = NSTIJKPlayerVOD.A(NSTIJKPlayerVOD.this).getCurrentPosition();
                if (currentPosition != 0) {
                    NSTIJKPlayerVOD nSTIJKPlayerVOD2 = NSTIJKPlayerVOD.this;
                    NSTIJKPlayerVOD.f1(nSTIJKPlayerVOD2, NSTIJKPlayerVOD.v(nSTIJKPlayerVOD2).getSharedPreferences("currentSeekTime", 0));
                    NSTIJKPlayerVOD nSTIJKPlayerVOD3 = NSTIJKPlayerVOD.this;
                    nSTIJKPlayerVOD3.E0 = NSTIJKPlayerVOD.e1(nSTIJKPlayerVOD3).edit();
                    NSTIJKPlayerVOD.this.E0.putString("currentSeekTime", String.valueOf(currentPosition));
                    NSTIJKPlayerVOD.this.E0.apply();
                }
                NSTIJKPlayerVOD.this.R1();
                NSTIJKPlayerVOD.this.start();
                NSTIJKPlayerVOD.this.setCurrentPositionSeekbar(currentPosition);
                NSTIJKPlayerVOD.this.setProgress(true);
            }
            NSTIJKPlayerVOD.b1(NSTIJKPlayerVOD.this).apply();
            new Handler().postDelayed(new a(), 500L);
        }
    }

    public class o implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ PopupWindow c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                o.this.c.dismiss();
            }
        }

        public o(int i, PopupWindow popupWindow) {
            this.a = i;
            this.c = popupWindow;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
            NSTIJKPlayerVOD.h1(nSTIJKPlayerVOD, NSTIJKPlayerVOD.i1(nSTIJKPlayerVOD).edit());
            if (i == 1111 || i == 1111111) {
                NSTIJKPlayerVOD.g1(NSTIJKPlayerVOD.this).putInt("currentAudioTrack", -1);
                NSTIJKPlayerVOD.this.B1(this.a);
            } else {
                NSTIJKPlayerVOD.g1(NSTIJKPlayerVOD.this).putInt("currentAudioTrack", i);
                int currentPosition = (int) NSTIJKPlayerVOD.g(NSTIJKPlayerVOD.this).getCurrentPosition();
                NSTIJKPlayerVOD.this.X1(i);
                NSTIJKPlayerVOD.g(NSTIJKPlayerVOD.this).seekTo(Long.parseLong(String.valueOf(currentPosition)));
            }
            NSTIJKPlayerVOD.g1(NSTIJKPlayerVOD.this).apply();
            new Handler().postDelayed(new a(), 500L);
        }
    }

    public class p implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ PopupWindow c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                p.this.c.dismiss();
            }
        }

        public p(int i, PopupWindow popupWindow) {
            this.a = i;
            this.c = popupWindow;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
            NSTIJKPlayerVOD.k1(nSTIJKPlayerVOD, NSTIJKPlayerVOD.l1(nSTIJKPlayerVOD).edit());
            if (i == 11111 || i == 111111) {
                NSTIJKPlayerVOD.j1(NSTIJKPlayerVOD.this).putInt("currentSubtitleTrack", -1);
                NSTIJKPlayerVOD.this.B1(this.a);
            } else {
                NSTIJKPlayerVOD.j1(NSTIJKPlayerVOD.this).putInt("currentSubtitleTrack", i);
                NSTIJKPlayerVOD.this.X1(i);
            }
            NSTIJKPlayerVOD.j1(NSTIJKPlayerVOD.this).apply();
            new Handler().postDelayed(new a(), 500L);
        }
    }

    public class q implements DialogInterface.OnDismissListener {
        public q() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (NSTIJKPlayerVOD.A(NSTIJKPlayerVOD.this) != null) {
                NSTIJKPlayerVOD.A(NSTIJKPlayerVOD.this).I1();
            }
        }
    }

    public class r implements DialogInterface.OnShowListener {
        public r() {
        }

        public void onShow(DialogInterface dialogInterface) {
            Button n1;
            Resources resources;
            int i;
            NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
            NSTIJKPlayerVOD.o1(nSTIJKPlayerVOD, NSTIJKPlayerVOD.p1(nSTIJKPlayerVOD).e(-2));
            NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this).setTag("1");
            Button n12 = NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this);
            NSTIJKPlayerVOD nSTIJKPlayerVOD2 = NSTIJKPlayerVOD.this;
            n12.setOnFocusChangeListener(nSTIJKPlayerVOD2.new A(NSTIJKPlayerVOD.n1(nSTIJKPlayerVOD2)));
            NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this).setTextColor(NSTIJKPlayerVOD.v(NSTIJKPlayerVOD.this).getResources().getColor(a7.c.G));
            NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this).setTextSize(16.0f);
            ViewGroup.MarginLayoutParams layoutParams = NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this).getLayoutParams();
            layoutParams.setMargins(0, 10, 50, 10);
            if (NSTIJKPlayerVOD.q1(NSTIJKPlayerVOD.this).A().equals(m7.a.K0)) {
                n1 = NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this);
                resources = NSTIJKPlayerVOD.v(NSTIJKPlayerVOD.this).getResources();
                i = a7.e.o;
            } else {
                n1 = NSTIJKPlayerVOD.n1(NSTIJKPlayerVOD.this);
                resources = NSTIJKPlayerVOD.v(NSTIJKPlayerVOD.this).getResources();
                i = a7.e.h;
            }
            n1.setBackground(resources.getDrawable(i));
            layoutParams.width = 240;
            layoutParams.height = 135;
        }
    }

    public class s implements SeekBar.OnSeekBarChangeListener {
        public s() {
        }

        public final String a(long j) {
            int i = (int) (j / 1000);
            int i2 = i % 60;
            int i3 = (i / 60) % 60;
            int i4 = i / 3600;
            return i4 > 0 ? String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)}) : String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z && NSTIJKPlayerVOD.g(NSTIJKPlayerVOD.this) != null) {
                NSTIJKPlayerVOD.h(NSTIJKPlayerVOD.this).b(a7.f.G).a();
                int duration = (int) (NSTIJKPlayerVOD.A(NSTIJKPlayerVOD.this).getDuration() * ((i * 1.0d) / 1000.0d));
                a(duration);
                NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
                if (nSTIJKPlayerVOD.f1) {
                    NSTIJKPlayerVOD.A(nSTIJKPlayerVOD).seekTo(duration);
                }
                TextView B0 = NSTIJKPlayerVOD.B0(NSTIJKPlayerVOD.this);
                StringBuilder sb = new StringBuilder();
                NSTIJKPlayerVOD nSTIJKPlayerVOD2 = NSTIJKPlayerVOD.this;
                sb.append(NSTIJKPlayerVOD.i0(nSTIJKPlayerVOD2, NSTIJKPlayerVOD.A(nSTIJKPlayerVOD2).getCurrentPosition()));
                sb.append("/");
                NSTIJKPlayerVOD nSTIJKPlayerVOD3 = NSTIJKPlayerVOD.this;
                sb.append(NSTIJKPlayerVOD.i0(nSTIJKPlayerVOD3, NSTIJKPlayerVOD.A(nSTIJKPlayerVOD3).getDuration()));
                B0.setText(sb.toString());
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
            nSTIJKPlayerVOD.e1 = true;
            nSTIJKPlayerVOD.g2(3600000);
            NSTIJKPlayerVOD.T0(NSTIJKPlayerVOD.this).removeMessages(1);
            NSTIJKPlayerVOD nSTIJKPlayerVOD2 = NSTIJKPlayerVOD.this;
            if (nSTIJKPlayerVOD2.f1) {
                NSTIJKPlayerVOD.m1(nSTIJKPlayerVOD2).setStreamMute(3, true);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (NSTIJKPlayerVOD.g(NSTIJKPlayerVOD.this) == null) {
                return;
            }
            NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
            if (!nSTIJKPlayerVOD.f1) {
                NSTIJKPlayerVOD.A(nSTIJKPlayerVOD).seekTo((int) (NSTIJKPlayerVOD.A(NSTIJKPlayerVOD.this).getDuration() * ((seekBar.getProgress() * 1.0d) / 1000.0d)));
            }
            NSTIJKPlayerVOD nSTIJKPlayerVOD2 = NSTIJKPlayerVOD.this;
            nSTIJKPlayerVOD2.g2(NSTIJKPlayerVOD.r1(nSTIJKPlayerVOD2));
            NSTIJKPlayerVOD.T0(NSTIJKPlayerVOD.this).removeMessages(1);
            NSTIJKPlayerVOD.m1(NSTIJKPlayerVOD.this).setStreamMute(3, false);
            NSTIJKPlayerVOD nSTIJKPlayerVOD3 = NSTIJKPlayerVOD.this;
            nSTIJKPlayerVOD3.e1 = false;
            NSTIJKPlayerVOD.T0(nSTIJKPlayerVOD3).sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public class t implements View.OnTouchListener {
        public t() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent == null) {
                return false;
            }
            if (NSTIJKPlayerVOD.s1(NSTIJKPlayerVOD.this).onTouchEvent(motionEvent)) {
                return true;
            }
            if ((motionEvent.getAction() & 255) != 1) {
                return false;
            }
            NSTIJKPlayerVOD.t1(NSTIJKPlayerVOD.this);
            return false;
        }
    }

    public class u extends Handler {
        public u(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                NSTIJKPlayerVOD.n(NSTIJKPlayerVOD.this);
                NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
                if (nSTIJKPlayerVOD.e1 || !NSTIJKPlayerVOD.o(nSTIJKPlayerVOD)) {
                    return;
                }
                NSTIJKPlayerVOD.T0(NSTIJKPlayerVOD.this).sendMessageDelayed(NSTIJKPlayerVOD.T0(NSTIJKPlayerVOD.this).obtainMessage(1), 300L);
                NSTIJKPlayerVOD.p(NSTIJKPlayerVOD.this);
                return;
            }
            if (i == 2) {
                NSTIJKPlayerVOD.this.F1(false);
                return;
            }
            if (i == 3) {
                if (NSTIJKPlayerVOD.k(NSTIJKPlayerVOD.this) >= 0) {
                    NSTIJKPlayerVOD.A(NSTIJKPlayerVOD.this).seekTo((int) NSTIJKPlayerVOD.k(NSTIJKPlayerVOD.this));
                    NSTIJKPlayerVOD.l(NSTIJKPlayerVOD.this, -1L);
                    return;
                }
                return;
            }
            if (i != 4) {
                return;
            }
            NSTIJKPlayerVOD.h(NSTIJKPlayerVOD.this).b(a7.f.U).a();
            NSTIJKPlayerVOD.h(NSTIJKPlayerVOD.this).b(a7.f.v).a();
            NSTIJKPlayerVOD.h(NSTIJKPlayerVOD.this).b(a7.f.y).a();
        }
    }

    public class v implements Runnable {
        public v() {
        }

        public void run() {
            Activity v;
            StringBuilder sb;
            Resources resources;
            int i;
            NSTIJKPlayerVOD nSTIJKPlayerVOD = NSTIJKPlayerVOD.this;
            nSTIJKPlayerVOD.I++;
            NSTIJKPlayerVOD.r(nSTIJKPlayerVOD);
            if (NSTIJKPlayerVOD.u(NSTIJKPlayerVOD.this).equals("dfo") || NSTIJKPlayerVOD.u(NSTIJKPlayerVOD.this).equals("devicedata")) {
                v = NSTIJKPlayerVOD.v(NSTIJKPlayerVOD.this);
                sb = new StringBuilder();
                resources = NSTIJKPlayerVOD.v(NSTIJKPlayerVOD.this).getResources();
                i = a7.j.b0;
            } else {
                v = NSTIJKPlayerVOD.v(NSTIJKPlayerVOD.this);
                sb = new StringBuilder();
                resources = NSTIJKPlayerVOD.v(NSTIJKPlayerVOD.this).getResources();
                i = a7.j.g5;
            }
            sb.append(resources.getString(i));
            sb.append(" (");
            sb.append(NSTIJKPlayerVOD.this.I);
            sb.append("/");
            sb.append(NSTIJKPlayerVOD.w(NSTIJKPlayerVOD.this));
            sb.append(")");
            m7.w.P0(v, sb.toString());
            NSTIJKPlayerVOD.this.R1();
            NSTIJKPlayerVOD.this.start();
        }
    }

    public class w implements IMediaPlayer.OnVideoSizeChangedListener {
        public w() {
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            NSTIJKPlayerVOD.E(NSTIJKPlayerVOD.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerVOD.L(NSTIJKPlayerVOD.this, iMediaPlayer.getVideoHeight());
            NSTIJKPlayerVOD.S(NSTIJKPlayerVOD.this, iMediaPlayer.getVideoSarNum());
            NSTIJKPlayerVOD.W(NSTIJKPlayerVOD.this, iMediaPlayer.getVideoSarDen());
            if (NSTIJKPlayerVOD.D(NSTIJKPlayerVOD.this) == 0 || NSTIJKPlayerVOD.J(NSTIJKPlayerVOD.this) == 0) {
                return;
            }
            if (NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this) != null) {
                NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this).c(NSTIJKPlayerVOD.D(NSTIJKPlayerVOD.this), NSTIJKPlayerVOD.J(NSTIJKPlayerVOD.this));
                NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this).a(NSTIJKPlayerVOD.P(NSTIJKPlayerVOD.this), NSTIJKPlayerVOD.T(NSTIJKPlayerVOD.this));
            }
            NSTIJKPlayerVOD.this.requestLayout();
        }
    }

    public class x implements IMediaPlayer.OnPreparedListener {
        public x() {
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerVOD.Y(NSTIJKPlayerVOD.this, System.currentTimeMillis());
            NSTIJKPlayerVOD.Z(NSTIJKPlayerVOD.this, 2);
            if (NSTIJKPlayerVOD.b0(NSTIJKPlayerVOD.this) != null) {
                NSTIJKPlayerVOD.b0(NSTIJKPlayerVOD.this).onPrepared(NSTIJKPlayerVOD.g(NSTIJKPlayerVOD.this));
            }
            NSTIJKPlayerVOD.c0(NSTIJKPlayerVOD.this);
            NSTIJKPlayerVOD.E(NSTIJKPlayerVOD.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerVOD.L(NSTIJKPlayerVOD.this, iMediaPlayer.getVideoHeight());
            int j0 = NSTIJKPlayerVOD.j0(NSTIJKPlayerVOD.this);
            if (j0 != 0) {
                NSTIJKPlayerVOD.this.seekTo(j0);
            }
            if (NSTIJKPlayerVOD.D(NSTIJKPlayerVOD.this) == 0 || NSTIJKPlayerVOD.J(NSTIJKPlayerVOD.this) == 0) {
                if (NSTIJKPlayerVOD.p0(NSTIJKPlayerVOD.this) == 3) {
                    NSTIJKPlayerVOD.this.start();
                    return;
                }
                return;
            }
            if (NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this) != null) {
                NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this).c(NSTIJKPlayerVOD.D(NSTIJKPlayerVOD.this), NSTIJKPlayerVOD.J(NSTIJKPlayerVOD.this));
                NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this).a(NSTIJKPlayerVOD.P(NSTIJKPlayerVOD.this), NSTIJKPlayerVOD.T(NSTIJKPlayerVOD.this));
                if (!NSTIJKPlayerVOD.X(NSTIJKPlayerVOD.this).d() || (NSTIJKPlayerVOD.k0(NSTIJKPlayerVOD.this) == NSTIJKPlayerVOD.D(NSTIJKPlayerVOD.this) && NSTIJKPlayerVOD.m0(NSTIJKPlayerVOD.this) == NSTIJKPlayerVOD.J(NSTIJKPlayerVOD.this))) {
                    if (NSTIJKPlayerVOD.p0(NSTIJKPlayerVOD.this) == 3) {
                        NSTIJKPlayerVOD.this.start();
                    } else {
                        if (NSTIJKPlayerVOD.this.isPlaying()) {
                            return;
                        }
                        if (j0 == 0 && NSTIJKPlayerVOD.this.getCurrentPosition() <= 0) {
                            return;
                        }
                    }
                    NSTIJKPlayerVOD.c0(NSTIJKPlayerVOD.this);
                }
            }
        }
    }

    public class y implements IMediaPlayer.OnCompletionListener {

        public class a extends o2.g {
            public a() {
            }

            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public void b(Bitmap bitmap, n2.c cVar) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                RelativeLayout relativeLayout = NSTIJKPlayerVOD.this.l1;
                if (relativeLayout != null) {
                    relativeLayout.setBackground(bitmapDrawable);
                }
            }
        }

        public y() {
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x0182  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0196  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer r6) {
            /*
                Method dump skipped, instructions count: 439
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerVOD.y.onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer):void");
        }
    }

    public class z implements PopupWindow.OnDismissListener {
        public z() {
        }

        public void onDismiss() {
            if (NSTIJKPlayerVOD.x0(NSTIJKPlayerVOD.this) != null && NSTIJKPlayerVOD.z0(NSTIJKPlayerVOD.this) != null) {
                NSTIJKPlayerVOD.x0(NSTIJKPlayerVOD.this).removeCallbacks(NSTIJKPlayerVOD.z0(NSTIJKPlayerVOD.this));
            }
            NSTIJKPlayerVOD.this.r1.performClick();
            NSTIJKPlayerVOD.this.I1();
        }
    }

    public NSTIJKPlayerVOD(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "NSTIJKPlayerVOD";
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
        this.G = 0;
        this.I = 0;
        this.J = 5;
        this.K = false;
        this.U = 0L;
        this.V = 0L;
        this.W = 0L;
        this.e0 = 0L;
        this.k0 = -1.0f;
        Boolean bool = Boolean.FALSE;
        this.r0 = bool;
        this.s0 = bool;
        this.t0 = bool;
        this.u0 = bool;
        this.v0 = bool;
        this.w0 = bool;
        this.y0 = false;
        this.z0 = false;
        this.I0 = false;
        this.N0 = false;
        this.S0 = false;
        this.T0 = false;
        this.c1 = false;
        this.d1 = false;
        this.h1 = false;
        this.n1 = 0;
        this.s1 = new s();
        this.t1 = new u(Looper.getMainLooper());
        this.u1 = new w();
        this.v1 = new x();
        this.w1 = new y();
        this.x1 = new d();
        this.y1 = new f();
        this.z1 = new g();
        this.A1 = new h();
        this.B1 = new i();
        this.C1 = new j();
        this.D1 = new l();
        this.E1 = 4;
        this.F1 = K1[0];
        this.G1 = new ArrayList();
        this.H1 = 0;
        this.I1 = 0;
        this.J1 = false;
        M1(context);
    }

    public static /* synthetic */ NSTIJKPlayerVOD A(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.h0;
    }

    public static /* synthetic */ void A0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        nSTIJKPlayerVOD.H1();
    }

    public static /* synthetic */ void B(NSTIJKPlayerVOD nSTIJKPlayerVOD, float f2) {
        nSTIJKPlayerVOD.P1(f2);
    }

    public static /* synthetic */ TextView B0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.A0;
    }

    public static /* synthetic */ int D(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.k;
    }

    public static /* synthetic */ void D0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        nSTIJKPlayerVOD.S1();
    }

    public static /* synthetic */ int E(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.k = i2;
        return i2;
    }

    public static /* synthetic */ int F0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.n1;
    }

    private void G1() {
        this.o0.b(a7.f.A).a();
        this.o0.b(a7.f.G).a();
        h2(false);
        J1();
    }

    private void H1() {
        Runnable runnable;
        Handler handler = this.p1;
        if (handler != null && (runnable = this.o1) != null) {
            handler.removeCallbacks(runnable);
        }
        PopupWindow popupWindow = this.q1;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        g2(this.D);
    }

    public static /* synthetic */ int J(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.l;
    }

    public static /* synthetic */ int J0(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        int i3 = nSTIJKPlayerVOD.n1 + i2;
        nSTIJKPlayerVOD.n1 = i3;
        return i3;
    }

    public static /* synthetic */ FabButton K0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.m1;
    }

    private void K1() {
        boolean p2 = this.Q.p();
        this.J1 = p2;
        if (p2) {
            v7.a.b(getContext());
            this.j = v7.a.a();
        }
    }

    public static /* synthetic */ int L(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.l = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnInfoListener L0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.t;
    }

    private void L1() {
        this.G1.clear();
        if (this.Q.s()) {
            this.G1.add(1);
        }
        if (this.Q.t()) {
            this.G1.add(2);
        }
        if (this.Q.r()) {
            this.G1.add(0);
        }
        if (this.G1.isEmpty()) {
            this.G1.add(1);
        }
        int intValue = ((Integer) this.G1.get(this.H1)).intValue();
        this.I1 = intValue;
        setRender(intValue);
    }

    public static /* synthetic */ String M0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.a;
    }

    private void M1(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.P = applicationContext;
        this.Q = new u7.a(applicationContext);
        this.k1 = new n7.l(this, this.P);
        K1();
        L1();
        this.k = 0;
        this.l = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.g = 0;
        this.h = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref.using_sub_font_size", 0);
        this.j1 = sharedPreferences;
        String string = sharedPreferences.getString("pref.using_sub_font_size", m7.a.x0);
        TextView textView = new TextView(context);
        this.f0 = textView;
        try {
            textView.setTextSize(2, Float.parseFloat(string));
        } catch (Exception unused) {
        }
        this.f0.setTextColor(context.getResources().getColor(a7.c.G));
        this.f0.setGravity(17);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams.setMargins(0, 0, 0, 40);
        addView(this.f0, layoutParams);
    }

    public static /* synthetic */ void N0(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.l2(i2);
    }

    public static /* synthetic */ int O0(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.o = i2;
        return i2;
    }

    private boolean O1() {
        int i2;
        return (this.j == null || (i2 = this.g) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public static /* synthetic */ int P(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.S;
    }

    public static /* synthetic */ IMediaPlayer.OnErrorListener Q0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.s;
    }

    public static /* synthetic */ int R0(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.r = i2;
        return i2;
    }

    public static /* synthetic */ int S(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.S = i2;
        return i2;
    }

    public static /* synthetic */ long S0(NSTIJKPlayerVOD nSTIJKPlayerVOD, long j2) {
        nSTIJKPlayerVOD.e0 = j2;
        return j2;
    }

    private void S1() {
        H1();
        AppCompatImageView findViewById = this.g0.findViewById(a7.f.B3);
        if (findViewById != null) {
            findViewById.performClick();
        }
    }

    public static /* synthetic */ int T(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.T;
    }

    public static /* synthetic */ Handler T0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.t1;
    }

    public static /* synthetic */ int W(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.T = i2;
        return i2;
    }

    public static /* synthetic */ SharedPreferences W0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.j1;
    }

    public static /* synthetic */ com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a X(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.R;
    }

    public static /* synthetic */ long Y(NSTIJKPlayerVOD nSTIJKPlayerVOD, long j2) {
        nSTIJKPlayerVOD.V = j2;
        return j2;
    }

    public static /* synthetic */ SharedPreferences Y0(NSTIJKPlayerVOD nSTIJKPlayerVOD, SharedPreferences sharedPreferences) {
        nSTIJKPlayerVOD.j1 = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ int Z(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.g = i2;
        return i2;
    }

    public static /* synthetic */ a.b Z0(NSTIJKPlayerVOD nSTIJKPlayerVOD, a.b bVar) {
        nSTIJKPlayerVOD.i = bVar;
        return bVar;
    }

    public static /* synthetic */ void a1(NSTIJKPlayerVOD nSTIJKPlayerVOD, IMediaPlayer iMediaPlayer, a.b bVar) {
        nSTIJKPlayerVOD.v1(iMediaPlayer, bVar);
    }

    public static /* synthetic */ IMediaPlayer.OnPreparedListener b0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.q;
    }

    public static /* synthetic */ SharedPreferences.Editor b1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.a1;
    }

    private int b2() {
        int currentPosition;
        if (this.e1) {
            return 0;
        }
        if (this.c1) {
            F1(true);
            this.c1 = false;
            return 0;
        }
        if (this.h0.getProgress()) {
            this.h0.setProgress(false);
            currentPosition = this.h0.getCurrentPositionSeekbar();
            this.h0.seekTo(currentPosition);
        } else {
            currentPosition = this.h0.getCurrentPosition();
        }
        int duration = this.h0.getDuration();
        SeekBar seekBar = this.x0;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 1000) / duration));
            }
            this.x0.setSecondaryProgress(this.h0.getBufferPercentage() * 10);
        }
        if (duration == 0) {
            this.A0.setText("Live");
        } else {
            this.A0.setText(p2(currentPosition) + "/" + p2(duration));
        }
        return currentPosition;
    }

    public static /* synthetic */ w7.b c0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        nSTIJKPlayerVOD.getClass();
        return null;
    }

    public static /* synthetic */ SharedPreferences.Editor c1(NSTIJKPlayerVOD nSTIJKPlayerVOD, SharedPreferences.Editor editor) {
        nSTIJKPlayerVOD.a1 = editor;
        return editor;
    }

    private void c2(Context context, ArrayList arrayList, int i2) {
        if (this.F0.getRecentwatchmoviesCount(SharepreferenceDBHandler.getUserID(context)) >= 100) {
            new ArrayList();
            ArrayList allLiveStreasWithCategoryId = this.F0.getAllLiveStreasWithCategoryId("movie", SharepreferenceDBHandler.getUserID(context), "getOnedata");
            if (allLiveStreasWithCategoryId.isEmpty()) {
                this.F0.deleteRecentwatch(Integer.parseInt(((LiveStreamsDBModel) allLiveStreasWithCategoryId.get(0)).getStreamId()), "movie");
            }
        }
        Z1(context, arrayList, i2);
    }

    public static /* synthetic */ SharedPreferences d1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.X0;
    }

    public static /* synthetic */ SharedPreferences e1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.D0;
    }

    public static /* synthetic */ SharedPreferences f1(NSTIJKPlayerVOD nSTIJKPlayerVOD, SharedPreferences sharedPreferences) {
        nSTIJKPlayerVOD.D0 = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ IMediaPlayer g(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.j;
    }

    public static /* synthetic */ SharedPreferences.Editor g1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.Z0;
    }

    private void getRunnable() {
        boolean[] zArr = {false};
        e eVar = new e();
        this.o1 = eVar;
        if (zArr[0]) {
            return;
        }
        eVar.run();
    }

    public static /* synthetic */ C h(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.o0;
    }

    public static /* synthetic */ SharedPreferences.Editor h1(NSTIJKPlayerVOD nSTIJKPlayerVOD, SharedPreferences.Editor editor) {
        nSTIJKPlayerVOD.Z0 = editor;
        return editor;
    }

    public static /* synthetic */ String i0(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        return nSTIJKPlayerVOD.p2(i2);
    }

    public static /* synthetic */ SharedPreferences i1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.W0;
    }

    public static /* synthetic */ int j0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.u;
    }

    public static /* synthetic */ SharedPreferences.Editor j1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.Y0;
    }

    private void j2(String str) {
        this.o0.b(a7.f.Im).a();
        this.o0.b(a7.f.G).h();
        this.o0.b(a7.f.K).f(str);
    }

    public static /* synthetic */ long k(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.z;
    }

    public static /* synthetic */ int k0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.m;
    }

    public static /* synthetic */ SharedPreferences.Editor k1(NSTIJKPlayerVOD nSTIJKPlayerVOD, SharedPreferences.Editor editor) {
        nSTIJKPlayerVOD.Y0 = editor;
        return editor;
    }

    public static /* synthetic */ long l(NSTIJKPlayerVOD nSTIJKPlayerVOD, long j2) {
        nSTIJKPlayerVOD.z = j2;
        return j2;
    }

    public static /* synthetic */ int l0(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.m = i2;
        return i2;
    }

    public static /* synthetic */ SharedPreferences l1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.V0;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0165 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l2(int r9) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerVOD.l2(int):void");
    }

    public static /* synthetic */ int m0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.n;
    }

    public static /* synthetic */ AudioManager m1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.i0;
    }

    public static /* synthetic */ int n(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.b2();
    }

    public static /* synthetic */ int n0(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.n = i2;
        return i2;
    }

    public static /* synthetic */ Button n1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.q0;
    }

    public static /* synthetic */ boolean o(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.A;
    }

    public static /* synthetic */ Button o1(NSTIJKPlayerVOD nSTIJKPlayerVOD, Button button) {
        nSTIJKPlayerVOD.q0 = button;
        return button;
    }

    private int o2(int i2, int i3) {
        return this.F0.isStreamAvailable(String.valueOf(i2), i3);
    }

    public static /* synthetic */ void p(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        nSTIJKPlayerVOD.s2();
    }

    public static /* synthetic */ int p0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.h;
    }

    public static /* synthetic */ androidx.appcompat.app.a p1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.p0;
    }

    private String p2(int i2) {
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = (i3 / 60) % 60;
        int i6 = i3 / 3600;
        this.B0.setLength(0);
        return (i6 > 0 ? this.C0.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)}) : this.C0.format("%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)})).toString();
    }

    public static /* synthetic */ int q0(NSTIJKPlayerVOD nSTIJKPlayerVOD, int i2) {
        nSTIJKPlayerVOD.h = i2;
        return i2;
    }

    public static /* synthetic */ u7.a q1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.Q;
    }

    public static /* synthetic */ void r(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        nSTIJKPlayerVOD.G1();
    }

    public static /* synthetic */ String r0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.O0;
    }

    public static /* synthetic */ int r1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.D;
    }

    private void r2() {
        View findViewById = this.g0.findViewById(a7.f.p);
        this.n0 = findViewById;
        findViewById.setClickable(true);
        this.n0.setOnTouchListener(new t());
    }

    public static /* synthetic */ Context s0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.P;
    }

    public static /* synthetic */ GestureDetector s1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.l0;
    }

    private void s2() {
        C c2;
        int i2;
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer == null || !iMediaPlayer.isPlaying()) {
            this.o0.b(a7.f.C3).a();
            c2 = this.o0;
            i2 = a7.f.D3;
        } else {
            this.o0.b(a7.f.D3).a();
            c2 = this.o0;
            i2 = a7.f.C3;
        }
        c2.b(i2).h();
    }

    public static /* synthetic */ IMediaPlayer.OnCompletionListener t0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.p;
    }

    public static /* synthetic */ void t1(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        nSTIJKPlayerVOD.C1();
    }

    public static /* synthetic */ String u(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.P0;
    }

    private void u1() {
    }

    public static /* synthetic */ Activity v(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.g0;
    }

    private void v1(IMediaPlayer iMediaPlayer, a.b bVar) {
        if (iMediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            bVar.b(iMediaPlayer);
        }
    }

    public static /* synthetic */ int w(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.J;
    }

    private String w1(String str) {
        return TextUtils.isEmpty(str) ? "und" : str;
    }

    public static /* synthetic */ int x(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.m0;
    }

    public static /* synthetic */ Handler x0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.p1;
    }

    public static /* synthetic */ void z(NSTIJKPlayerVOD nSTIJKPlayerVOD, float f2) {
        nSTIJKPlayerVOD.Q1(f2);
    }

    public static /* synthetic */ Runnable z0(NSTIJKPlayerVOD nSTIJKPlayerVOD) {
        return nSTIJKPlayerVOD.o1;
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
    public tv.danmaku.ijk.media.player.IMediaPlayer A1(int r10) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerVOD.A1(int):tv.danmaku.ijk.media.player.IMediaPlayer");
    }

    public void B1(int i2) {
        w7.e.b(this.j, i2);
    }

    public final void C1() {
        this.y = -1;
        this.k0 = -1.0f;
        if (this.z >= 0) {
            this.t1.removeMessages(3);
            this.t1.sendEmptyMessage(3);
        }
        this.t1.removeMessages(4);
        this.t1.sendEmptyMessageDelayed(4, 500L);
    }

    public void D1() {
        v7.a.d(this.j);
    }

    public void E0(String str) {
    }

    public void E1(Boolean bool) {
        this.H = bool.booleanValue();
    }

    public void F1(boolean z2) {
        if (z2 || this.A) {
            this.t1.removeMessages(1);
            h2(false);
            this.o0.b(a7.f.P).a();
            this.o0.b(a7.f.o2).a();
            this.o0.b(a7.f.z).d();
            this.o0.b(a7.f.S9).a();
            this.A = false;
            J1();
        }
    }

    public void I1() {
        this.h0.setSystemUiVisibility(4871);
    }

    public void J1() {
        this.o0.b(a7.f.P).a();
        this.o0.b(a7.f.o2).a();
        this.o0.b(a7.f.S9).a();
        this.A = false;
        this.E.removeCallbacksAndMessages((Object) null);
    }

    public void K(VodInfoCallback vodInfoCallback) {
        List backdropPath = vodInfoCallback.getInfo().getBackdropPath();
        if (backdropPath == null || backdropPath.size() <= 0) {
            return;
        }
        try {
            O1.g.u(this.P.getApplicationContext()).q((String) backdropPath.get(new Random().nextInt(backdropPath.size()))).I().m(new k());
        } catch (Exception unused) {
        }
    }

    public boolean N1() {
        return this.J1;
    }

    public final void P1(float f2) {
        Activity activity = this.g0;
        if (activity != null) {
            if (this.k0 < 0.0f) {
                float f3 = activity.getWindow().getAttributes().screenBrightness;
                this.k0 = f3;
                if (f3 <= 0.0f) {
                    this.k0 = 0.5f;
                } else if (f3 < 0.01f) {
                    this.k0 = 0.01f;
                }
            }
            Log.d(getClass().getSimpleName(), "brightness:" + this.k0 + ",percent:" + f2);
            this.o0.b(a7.f.U).a();
            this.o0.b(a7.f.v).h();
            WindowManager.LayoutParams attributes = this.g0.getWindow().getAttributes();
            float f4 = this.k0 + f2;
            attributes.screenBrightness = f4;
            if (f4 > 1.0f) {
                attributes.screenBrightness = 1.0f;
            } else if (f4 < 0.01f) {
                attributes.screenBrightness = 0.01f;
            }
            this.o0.b(a7.f.u).f(((int) (attributes.screenBrightness * 100.0f)) + "%");
            this.g0.getWindow().setAttributes(attributes);
        }
    }

    public final void Q1(float f2) {
        try {
            AudioManager audioManager = this.i0;
            if (audioManager != null) {
                if (this.y == -1) {
                    int streamVolume = audioManager.getStreamVolume(3);
                    this.y = streamVolume;
                    if (streamVolume < 0) {
                        this.y = 0;
                    }
                }
                F1(true);
                int i2 = this.j0;
                int i3 = ((int) (f2 * i2)) + this.y;
                if (i3 <= i2) {
                    i2 = i3 < 0 ? 0 : i3;
                }
                this.i0.setStreamVolume(3, i2, 0);
                int i4 = (int) (((i2 * 1.0d) / this.j0) * 100.0d);
                String str = i4 + "%";
                if (i4 == 0) {
                    str = "off";
                }
                this.o0.b(a7.f.V).c(i4 == 0 ? a7.e.J0 : a7.e.K0);
                this.o0.b(a7.f.v).a();
                this.o0.b(a7.f.U).h();
                this.o0.b(a7.f.T).f(str).h();
            }
        } catch (Exception unused) {
        }
    }

    public void R1() {
        IMediaPlayer.OnErrorListener onErrorListener;
        if (this.c == null || this.i == null) {
            return;
        }
        T1(false);
        try {
            ((AudioManager) this.P.getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 1);
        } catch (Exception unused) {
        }
        try {
            this.j = A1(this.Q.x());
            getContext();
            this.j.setOnPreparedListener(this.v1);
            this.j.setOnVideoSizeChangedListener(this.u1);
            this.j.setOnCompletionListener(this.w1);
            this.j.setOnErrorListener(this.z1);
            this.j.setOnInfoListener(this.y1);
            this.j.setOnBufferingUpdateListener(this.A1);
            this.j.setOnSeekCompleteListener(this.B1);
            this.j.setOnTimedTextListener(this.C1);
            this.r = 0;
            String scheme = this.c.getScheme();
            if (Build.VERSION.SDK_INT >= 23 && this.Q.F() && (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                this.j.setDataSource(new w7.a(new File(this.c.toString())));
            } else {
                this.j.setDataSource(this.P, this.c, this.e);
            }
            v1(this.j, this.i);
            this.j.setAudioStreamType(3);
            this.j.setScreenOnWhilePlaying(true);
            this.U = System.currentTimeMillis();
            this.j.prepareAsync();
            this.m0 = this.g0.getResources().getDisplayMetrics().widthPixels;
            AudioManager audioManager = (AudioManager) this.g0.getSystemService("audio");
            this.i0 = audioManager;
            this.j0 = audioManager.getStreamMaxVolume(3);
            this.l0 = new GestureDetector(this.g0, new B());
            r2();
            SeekBar seekBar = this.x0;
            if (seekBar != null) {
                seekBar.setOnSeekBarChangeListener(this.s1);
                this.x0.setMax(1000);
            }
            this.B0 = new StringBuilder();
            this.C0 = new Formatter(this.B0, Locale.getDefault());
            this.g = 1;
        } catch (NullPointerException e2) {
            Log.w(this.a, "Unable to open content: " + this.c, e2);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.z1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (IllegalArgumentException e3) {
            Log.w(this.a, "Unable to open content: " + this.c, e3);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.z1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (IOException e4) {
            Log.w(this.a, "Unable to open content: " + this.c, e4);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.z1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (Exception e5) {
            Log.w(this.a, "Unable to open content: " + this.c, e5);
            this.g = -1;
            this.h = -1;
            onErrorListener = this.z1;
            onErrorListener.onError(this.j, 1, 0);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void T1(boolean z2) {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.j.release();
            this.j = null;
            this.g = 0;
            if (z2) {
                this.h = 0;
            }
            ((AudioManager) this.P.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public void U1() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    public void V1(boolean z2) {
        this.c1 = z2;
    }

    public void W1() {
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void X1(int i2) {
        w7.e.e(this.j, i2);
    }

    public void Y1(Activity activity, NSTIJKPlayerVOD nSTIJKPlayerVOD, SeekBar seekBar, TextView textView) {
        this.g0 = activity;
        this.h0 = nSTIJKPlayerVOD;
        this.E = new Handler();
        this.x0 = seekBar;
        this.A0 = textView;
        this.F = new Handler();
        this.F0 = new RecentWatchDBHandler(activity);
        this.G0 = new LiveStreamDBHandler(activity);
        this.o0 = new C(activity);
    }

    public void Z1(Context context, ArrayList arrayList, int i2) {
        String num = ((LiveStreamsDBModel) arrayList.get(i2)).getNum();
        String name = ((LiveStreamsDBModel) arrayList.get(i2)).getName();
        String streamType = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamType();
        String streamId = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamId();
        String streamIcon = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamIcon();
        String epgChannelId = ((LiveStreamsDBModel) arrayList.get(i2)).getEpgChannelId();
        String added = ((LiveStreamsDBModel) arrayList.get(i2)).getAdded();
        String categoryId = ((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId();
        String customSid = ((LiveStreamsDBModel) arrayList.get(i2)).getCustomSid();
        ((LiveStreamsDBModel) arrayList.get(i2)).getTvArchive();
        String directSource = ((LiveStreamsDBModel) arrayList.get(i2)).getDirectSource();
        String tvArchiveDuration = ((LiveStreamsDBModel) arrayList.get(i2)).getTvArchiveDuration();
        String typeName = ((LiveStreamsDBModel) arrayList.get(i2)).getTypeName();
        String categoryName = ((LiveStreamsDBModel) arrayList.get(i2)).getCategoryName();
        String seriesNo = ((LiveStreamsDBModel) arrayList.get(i2)).getSeriesNo();
        String live = ((LiveStreamsDBModel) arrayList.get(i2)).getLive();
        String contaiinerExtension = ((LiveStreamsDBModel) arrayList.get(i2)).getContaiinerExtension();
        String ratingFromTen = ((LiveStreamsDBModel) arrayList.get(i2)).getRatingFromTen();
        String ratingFromFive = ((LiveStreamsDBModel) arrayList.get(i2)).getRatingFromFive();
        PanelAvailableChannelsPojo panelAvailableChannelsPojo = new PanelAvailableChannelsPojo();
        panelAvailableChannelsPojo.setNum(Integer.valueOf(num));
        panelAvailableChannelsPojo.setName(name);
        panelAvailableChannelsPojo.setStreamType(streamType);
        panelAvailableChannelsPojo.setStreamId(streamId);
        panelAvailableChannelsPojo.setStreamIcon(streamIcon);
        panelAvailableChannelsPojo.setEpgChannelId(epgChannelId);
        panelAvailableChannelsPojo.setAdded(added);
        panelAvailableChannelsPojo.setCategoryId(categoryId);
        panelAvailableChannelsPojo.setCustomSid(customSid);
        panelAvailableChannelsPojo.setTvArchive(0);
        panelAvailableChannelsPojo.setDirectSource(directSource);
        panelAvailableChannelsPojo.setTvArchiveDuration(tvArchiveDuration);
        panelAvailableChannelsPojo.setTypeName(typeName);
        panelAvailableChannelsPojo.setCategoryName(categoryName);
        panelAvailableChannelsPojo.setSeriesNo(seriesNo);
        panelAvailableChannelsPojo.setLive(live);
        panelAvailableChannelsPojo.setContainerExtension(contaiinerExtension);
        panelAvailableChannelsPojo.setUserIdReferred(SharepreferenceDBHandler.getUserID(context));
        panelAvailableChannelsPojo.setMovieElapsedTime(0L);
        panelAvailableChannelsPojo.setMovieDuration(0L);
        panelAvailableChannelsPojo.setRatingFromTen(ratingFromTen);
        panelAvailableChannelsPojo.setRatingFromFive(ratingFromFive);
        this.F0.addAllAvailableChannel(panelAvailableChannelsPojo);
    }

    public void a() {
    }

    public void a2() {
        int o2;
        Context context = getContext();
        if (x7.a.f() == null || (o2 = o2(x7.a.f().k(), SharepreferenceDBHandler.getUserID(context))) > 0 || o2 != 0 || this.P0.equals("dfo") || this.P0.equals("devicedata")) {
            return;
        }
        c2(context, x7.a.f().c(), x7.a.f().d());
    }

    public void b() {
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

    public void d(String str) {
    }

    public void d2(String str, boolean z2, String str2, long j2, int i2, String str3, ArrayList arrayList, int i3, int i4, String str4, String str5) {
        this.P0 = str5;
        f2(Uri.parse(str), z2, str2, j2, i2, str3, arrayList, i3, i4, str4);
    }

    public final void e2(Uri uri, Map map, boolean z2, String str, long j2, int i2, String str2, ArrayList arrayList, int i3, int i4, String str3) {
        this.c = uri;
        this.d = str;
        this.e = map;
        this.u = 0;
        this.H = z2;
        this.Q0 = str2;
        this.L0 = j2;
        this.J0 = i2;
        this.M0 = i4;
        this.R0 = arrayList;
        this.H0 = new PlayerResumeDBHandler(this.g0);
        this.F0 = new RecentWatchDBHandler(this.g0);
        this.g1 = new SeriesRecentWatchDatabase(this.g0);
        this.i1 = new z0(this.g0);
        this.G0 = new LiveStreamDBHandler(this.g0);
        this.K0 = SharepreferenceDBHandler.getUserID(this.g0);
        this.G = i3;
        this.O0 = str3;
        n2();
        R1();
        requestLayout();
        invalidate();
    }

    public void f(Context context, String str) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a7.g.P1, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(context);
        this.q1 = popupWindow;
        popupWindow.setContentView(inflate);
        this.q1.setWidth(-1);
        this.q1.setHeight(-1);
        this.q1.setFocusable(true);
        this.q1.setOutsideTouchable(false);
        inflate.findViewById(a7.f.nj).setText(str);
        LinearLayout findViewById = inflate.findViewById(a7.f.H7);
        findViewById.requestFocus();
        this.m1 = inflate.findViewById(a7.f.I2);
        this.r1 = inflate.findViewById(a7.f.A1);
        this.l1 = inflate.findViewById(a7.f.Ne);
        this.p1 = new Handler();
        this.m1.e(false);
        this.n1 = 0;
        this.m1.d(true);
        this.m1.setProgress(this.n1);
        getRunnable();
        this.q1.setOnDismissListener(new z());
        this.r1.setOnClickListener(new a());
        this.m1.setOnClickListener(new b());
        findViewById.setOnClickListener(new c());
        this.q1.showAtLocation(inflate, 1, 0, 0);
    }

    public void f2(Uri uri, boolean z2, String str, long j2, int i2, String str2, ArrayList arrayList, int i3, int i4, String str3) {
        e2(uri, null, z2, str, j2, i2, str2, arrayList, i3, i4, str3);
    }

    public void g2(int i2) {
        if (!this.A) {
            this.o0.b(a7.f.P).h();
            this.o0.b(a7.f.o2).h();
            this.o0.b(a7.f.S9).h();
            h2(true);
            this.A = true;
        }
        s2();
        this.t1.sendEmptyMessage(1);
        this.t1.removeMessages(2);
        if (i2 != 0) {
            this.t1.sendMessageDelayed(this.E.obtainMessage(2), i2);
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
        if (O1()) {
            return (int) this.j.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSeekbar() {
        return this.b1;
    }

    public int getCurrentWindowIndex() {
        return this.G;
    }

    public int getDuration() {
        if (O1()) {
            return (int) this.j.getDuration();
        }
        return -1;
    }

    public Boolean getFullScreenValue() {
        return Boolean.valueOf(this.H);
    }

    public boolean getProgress() {
        return this.d1;
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    public void h2(boolean z2) {
        this.o0.b(a7.f.w).g(z2 ? 0 : 8);
        this.o0.b(a7.f.x).g(z2 ? 0 : 8);
        this.o0.b(a7.f.F).g(z2 ? 0 : 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i2() {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerVOD.i2():void");
    }

    public boolean isPlaying() {
        IMediaPlayer iMediaPlayer;
        return O1() && (iMediaPlayer = this.j) != null && iMediaPlayer.isPlaying();
    }

    public void k2(RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, PopupWindow popupWindow, TextView textView, TextView textView2, TextView textView3) {
        TextView textView4;
        int i2;
        int i3;
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer == null) {
            return;
        }
        Boolean bool = Boolean.FALSE;
        this.w0 = bool;
        this.v0 = bool;
        this.u0 = bool;
        this.s0 = bool;
        this.r0 = bool;
        this.t0 = bool;
        int d2 = w7.e.d(iMediaPlayer, 1);
        int d3 = w7.e.d(this.j, 2);
        int d4 = w7.e.d(this.j, 3);
        ITrackInfo[] trackInfo = this.j.getTrackInfo();
        if (trackInfo == null || trackInfo.length <= 0) {
            textView4 = textView3;
            i2 = 0;
            textView.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            int i4 = 0;
            int i5 = -1;
            for (int length = trackInfo.length; i4 < length; length = i3) {
                ITrackInfo iTrackInfo = trackInfo[i4];
                int i6 = i5 + 1;
                int trackType = iTrackInfo.getTrackType();
                ITrackInfo[] iTrackInfoArr = trackInfo;
                IMediaFormat format = iTrackInfo.getFormat();
                if (format != null && (format instanceof IjkMediaFormat)) {
                    i3 = length;
                    if (trackType == 1) {
                        Boolean bool2 = Boolean.TRUE;
                        this.u0 = bool2;
                        if (!this.r0.booleanValue()) {
                            this.r0 = bool2;
                            RadioButton radioButton = new RadioButton(this.g0);
                            radioButton.setText("Disable");
                            radioButton.setTextColor(getResources().getColor(a7.c.f));
                            radioButton.setTextSize(18.0f);
                            radioButton.setId(11111111);
                            radioButton.setPadding(10, 10, 15, 10);
                            radioButton.setOnFocusChangeListener(new A(radioButton));
                            if (d2 == -1) {
                                radioButton.setChecked(true);
                                radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton.setTag("2");
                            radioGroup.addView(radioButton);
                        }
                        RadioButton radioButton2 = new RadioButton(this.g0);
                        iTrackInfo.getInfoInline();
                        radioButton2.setText(i6 + ", " + iTrackInfo.getInfoInline());
                        if (i6 == -1) {
                            radioButton2.setId(111);
                        } else {
                            radioButton2.setId(i6);
                        }
                        radioButton2.setTextColor(getResources().getColor(a7.c.f));
                        radioButton2.setTextSize(18.0f);
                        radioButton2.setPadding(10, 10, 15, 10);
                        radioButton2.setOnFocusChangeListener(new A(radioButton2));
                        if (i6 == d2) {
                            radioButton2.setChecked(true);
                            radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton2.setTag("2");
                        radioGroup.addView(radioButton2);
                        radioGroup.setOnCheckedChangeListener(new n(d2, popupWindow));
                        i4++;
                        i5 = i6;
                        trackInfo = iTrackInfoArr;
                    } else if (trackType == 2) {
                        Boolean bool3 = Boolean.TRUE;
                        this.v0 = bool3;
                        if (!this.s0.booleanValue()) {
                            this.s0 = bool3;
                            RadioButton radioButton3 = new RadioButton(this.g0);
                            radioButton3.setText("Disable");
                            radioButton3.setTextColor(getResources().getColor(a7.c.f));
                            radioButton3.setTextSize(18.0f);
                            radioButton3.setId(1111111);
                            radioButton3.setPadding(10, 10, 15, 10);
                            radioButton3.setOnFocusChangeListener(new A(radioButton3));
                            if (d3 == -1) {
                                radioButton3.setChecked(true);
                                radioGroup2.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton3.setTag("2");
                            radioGroup2.addView(radioButton3);
                        }
                        RadioButton radioButton4 = new RadioButton(this.g0);
                        radioButton4.setText(i6 + ", " + iTrackInfo.getInfoInline() + ", " + w1(iTrackInfo.getLanguage()));
                        radioButton4.setTextColor(getResources().getColor(a7.c.f));
                        radioButton4.setTextSize(18.0f);
                        if (i6 == -1) {
                            radioButton4.setId(1111);
                        } else {
                            radioButton4.setId(i6);
                        }
                        radioButton4.setPadding(10, 10, 15, 10);
                        radioButton4.setOnFocusChangeListener(new A(radioButton4));
                        if (i6 == d3) {
                            radioButton4.setChecked(true);
                            radioGroup2.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton4.setTag("2");
                        radioGroup2.addView(radioButton4);
                        radioGroup2.setOnCheckedChangeListener(new o(d3, popupWindow));
                    } else if (trackType == 3) {
                        Boolean bool4 = Boolean.TRUE;
                        this.w0 = bool4;
                        if (!this.t0.booleanValue()) {
                            this.t0 = bool4;
                            RadioButton radioButton5 = new RadioButton(this.g0);
                            radioButton5.setText("Disable");
                            radioButton5.setTextColor(getResources().getColor(a7.c.f));
                            radioButton5.setTextSize(18.0f);
                            radioButton5.setId(111111);
                            radioButton5.setPadding(10, 10, 15, 10);
                            radioButton5.setOnFocusChangeListener(new A(radioButton5));
                            if (d4 == -1) {
                                radioButton5.setChecked(true);
                                radioGroup3.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton5.setTag("2");
                            radioGroup3.addView(radioButton5);
                        }
                        RadioButton radioButton6 = new RadioButton(this.g0);
                        radioButton6.setText(i6 + ", " + iTrackInfo.getInfoInline());
                        radioButton6.setTextColor(getResources().getColor(a7.c.f));
                        radioButton6.setTextSize(18.0f);
                        if (i6 == -1) {
                            radioButton6.setId(11111);
                        } else {
                            radioButton6.setId(i6);
                        }
                        radioButton6.setPadding(10, 10, 15, 10);
                        radioButton6.setOnFocusChangeListener(new A(radioButton6));
                        if (i6 == d4) {
                            radioButton6.setChecked(true);
                            radioGroup3.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton6.setTag("2");
                        radioGroup3.addView(radioButton6);
                        radioGroup3.setOnCheckedChangeListener(new p(d4, popupWindow));
                    }
                } else {
                    i3 = length;
                }
                i4++;
                i5 = i6;
                trackInfo = iTrackInfoArr;
            }
            if (this.u0.booleanValue()) {
                i2 = 0;
                textView.setVisibility(8);
            } else {
                i2 = 0;
                textView.setVisibility(0);
            }
            if (this.v0.booleanValue()) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(i2);
            }
            textView4 = textView3;
            if (this.w0.booleanValue()) {
                textView4.setVisibility(8);
                return;
            }
        }
        textView4.setVisibility(i2);
    }

    public void m2() {
        v7.a.d(null);
    }

    public void n2() {
        IMediaPlayer iMediaPlayer = this.j;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.j.release();
            this.j = null;
            this.g = 0;
            this.h = 0;
            ((AudioManager) this.P.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 != 5) {
        }
        O1();
        return super.onKeyDown(i2, keyEvent);
    }

    public void pause() {
        IMediaPlayer iMediaPlayer;
        if (O1() && (iMediaPlayer = this.j) != null && iMediaPlayer.isPlaying()) {
            this.j.pause();
            this.g = 4;
        }
        this.h = 4;
    }

    public int q2() {
        String str;
        Resources resources;
        int i2;
        this.E1++;
        SharedPreferences sharedPreferences = this.g0.getSharedPreferences("loginPrefs", 0);
        this.L = sharedPreferences;
        this.M = sharedPreferences.edit();
        int i3 = this.E1;
        int[] iArr = K1;
        int length = i3 % iArr.length;
        this.E1 = length;
        this.F1 = iArr[length];
        if (this.R != null) {
            LinearLayout findViewById = this.g0.findViewById(a7.f.X6);
            TextView findViewById2 = this.g0.findViewById(a7.f.n);
            this.R.setAspectRatio(this.F1);
            int i4 = this.E1;
            if (i4 == 0) {
                resources = getResources();
                i2 = a7.j.j2;
            } else if (i4 == 1) {
                resources = getResources();
                i2 = a7.j.i2;
            } else if (i4 == 2) {
                resources = getResources();
                i2 = a7.j.Q8;
            } else if (i4 == 3) {
                resources = getResources();
                i2 = a7.j.j3;
            } else {
                if (i4 == 4) {
                    str = "16:9";
                } else {
                    if (i4 == 5) {
                        str = "4:3";
                    }
                    this.M.putInt("aspect_ratio", this.E1);
                    this.M.apply();
                    findViewById.setVisibility(0);
                    this.F.removeCallbacksAndMessages((Object) null);
                    this.F.postDelayed(new m(findViewById), 3000L);
                }
                findViewById2.setText(str);
                this.M.putInt("aspect_ratio", this.E1);
                this.M.apply();
                findViewById.setVisibility(0);
                this.F.removeCallbacksAndMessages((Object) null);
                this.F.postDelayed(new m(findViewById), 3000L);
            }
            str = resources.getString(i2);
            findViewById2.setText(str);
            this.M.putInt("aspect_ratio", this.E1);
            this.M.apply();
            findViewById.setVisibility(0);
            this.F.removeCallbacksAndMessages((Object) null);
            this.F.postDelayed(new m(findViewById), 3000L);
        }
        return this.F1;
    }

    public void seekTo(int i2) {
        if (O1()) {
            this.W = System.currentTimeMillis();
            this.j.seekTo(i2);
            i2 = 0;
        }
        this.u = i2;
    }

    public void setCurrentPositionSeekbar(int i2) {
        this.b1 = i2;
    }

    public void setCurrentWindowIndex(int i2) {
        this.G = i2;
    }

    public void setHudView(TableLayout tableLayout) {
    }

    public void setListData(String str) {
        f(this.g0, str);
    }

    public void setMediaController(w7.b bVar) {
        u1();
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

    public void setProgress(boolean z2) {
        this.d1 = z2;
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
                surfaceView.setAspectRatio(this.F1);
            }
        }
        setRenderView(surfaceView);
    }

    public void setRenderView(com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar) {
        int i2;
        int i3;
        if (this.R != null) {
            IMediaPlayer iMediaPlayer = this.j;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.R.getView();
            this.R.b(this.D1);
            this.R = null;
            removeView(view);
        }
        if (aVar == null) {
            return;
        }
        this.R = aVar;
        SharedPreferences sharedPreferences = this.P.getSharedPreferences("loginPrefs", 0);
        this.L = sharedPreferences;
        int i4 = sharedPreferences.getInt("aspect_ratio", 4);
        this.E1 = i4;
        aVar.setAspectRatio(i4);
        int i5 = this.k;
        if (i5 > 0 && (i3 = this.l) > 0) {
            aVar.c(i5, i3);
        }
        int i6 = this.S;
        if (i6 > 0 && (i2 = this.T) > 0) {
            aVar.a(i6, i2);
        }
        View view2 = this.R.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.R.e(this.D1);
        this.R.setVideoRotation(this.o);
    }

    public void setTitle(CharSequence charSequence) {
        this.o0.b(a7.f.O).f(charSequence);
    }

    public void start() {
        if (O1()) {
            this.j.start();
            this.g = 3;
        }
        this.h = 3;
    }

    public final String x1(int i2, int i3, int i4, int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        if (i4 > 1 || i5 > 1) {
            sb.append("[");
            sb.append(i4);
            sb.append(":");
            sb.append(i5);
            sb.append("]");
        }
        return sb.toString();
    }

    public final String y1(long j2) {
        long j3 = j2 / 1000;
        long j4 = j3 / 3600;
        long j5 = (j3 % 3600) / 60;
        long j6 = j3 % 60;
        return j2 <= 0 ? "--:--" : j4 >= 100 ? String.format(Locale.US, "%d:%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) : j4 > 0 ? String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) : String.format(Locale.US, "%02d:%02d", new Object[]{Long.valueOf(j5), Long.valueOf(j6)});
    }

    public final String z1(int i2) {
        return getContext().getString(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? a7.j.h : a7.j.e : a7.j.f : a7.j.g : a7.j.d : a7.j.i);
    }
}
