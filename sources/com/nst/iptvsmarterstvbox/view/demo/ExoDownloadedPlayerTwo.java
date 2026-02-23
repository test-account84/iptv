package com.nst.iptvsmarterstvbox.view.demo;

import B3.i0;
import O2.H0;
import O2.I1;
import O2.Q1;
import O2.R0;
import O2.V1;
import O2.p1;
import O2.s1;
import O2.t1;
import O2.v1;
import Z3.m;
import Z3.z;
import android.animation.ObjectAnimator;
import android.app.AppOpsManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b4.o;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.gms.cast.MediaInfo;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.DownloadedDataModel;
import com.nst.iptvsmarterstvbox.model.EpisodesUsingSinglton;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.database.DownloadedDBHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.PanelAvailableChannelsPojo;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a;
import d4.k0;
import e4.C;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import m7.w;
import o4.y;
import p3.B;
import p3.u;
import p7.v;
import p7.z0;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ExoDownloadedPlayerTwo extends androidx.appcompat.app.b implements View.OnClickListener, MediaController.MediaPlayerControl {
    public static String n3;
    public static String o3;
    public static ProgressBar p3;
    public LinearLayout A;
    public RelativeLayout A0;
    public SharedPreferences.Editor A1;
    public ImageView B;
    public ImageView B0;
    public SharedPreferences.Editor B1;
    public ImageView C;
    public TextView C0;
    public SharedPreferences.Editor C1;
    public ImageView D;
    public TextView D0;
    public SharedPreferences.Editor D1;
    public y D2;
    public SeekBar E;
    public TextView E0;
    public String E1;
    public ArrayList E2;
    public LinearLayout F;
    public LinearLayout F0;
    public String F1;
    public Handler F2;
    public LinearLayout G;
    public TableLayout G0;
    public String G1;
    public androidx.appcompat.app.a G2;
    public LinearLayout H;
    public LinearLayout H0;
    public LiveStreamDBHandler H1;
    public BroadcastReceiver H2;
    public ImageView I;
    public MediaRouteButton I0;
    public ArrayList I1;
    public LinearLayout J;
    public LinearLayout J0;
    public List J1;
    public LinearLayout K;
    public TextView K0;
    public PictureInPictureParams.Builder K2;
    public LinearLayout L;
    public RelativeLayout L0;
    public int L1;
    public ImageView M;
    public ImageView M0;
    public SharedPreferences M2;
    public ImageView N;
    public ImageView N0;
    public SimpleDateFormat N1;
    public TextView O;
    public LinearLayout O0;
    public Date O1;
    public TextView P;
    public LinearLayout P0;
    public DateFormat P1;
    public PlayerView P2;
    public LinearLayout Q;
    public LinearLayout Q0;
    public String Q1;
    public I1 Q2;
    public RadioGroup R;
    public String R1;
    public boolean R2;
    public RadioGroup S;
    public String S1;
    public o.a S2;
    public RadioGroup T;
    public String T1;
    public List T2;
    public TextView U;
    public Z3.m U2;
    public TextView V;
    public m.d V2;
    public TextView W;
    public q7.n W0;
    public i0 W2;
    public TextView X;
    public RecyclerView.o X0;
    public boolean X2;
    public FrameLayout Y;
    public Context Y0;
    public int Y2;
    public TextView Z;
    public Animation Z0;
    public long Z2;
    public Animation a1;
    public Animation a3;
    public Animation b1;
    public Animation c1;
    public Animation d1;
    public t2.a d2;
    public DownloadedDBHandler e;
    public RelativeLayout e0;
    public Animation e1;
    public LinearLayout e2;
    public AudioManager f;
    public RelativeLayout f0;
    public Animation f1;
    public SharedPreferences f2;
    public int g;
    public RecyclerView g0;
    public Animation g1;
    public Handler h;
    public TextView h0;
    public Animation h1;
    public StringBuilder i;
    public TextView i0;
    public Handler i1;
    public Formatter j;
    public TextView j0;
    public String j1;
    public GestureDetector k;
    public TextView k0;
    public SharedPreferences k2;
    public FrameLayout l0;
    public SeriesRecentWatchDatabase l1;
    public SharedPreferences.Editor l2;
    public FrameLayout m0;
    public RecentWatchDBHandler m1;
    public Handler m2;
    public SeekBar n0;
    public z0 n1;
    public boolean o;
    public SeekBar o0;
    public u7.a o1;
    public LinearLayout p;
    public LinearLayout p0;
    public SharedPreferences p1;
    public LinearLayout q0;
    public SharedPreferences q1;
    public TextView r0;
    public SharedPreferences r1;
    public SharedPreferences r2;
    public SharedPreferences s;
    public TextView s0;
    public SharedPreferences.Editor s1;
    public SharedPreferences.Editor s2;
    public SharedPreferences.Editor t;
    public LinearLayout t0;
    public SharedPreferences t1;
    public SharedPreferences t2;
    public Handler u;
    public TextView u0;
    public SharedPreferences u1;
    public o4.e u2;
    public LinearLayout v;
    public TextView v0;
    public SharedPreferences v1;
    public o4.b v2;
    public LinearLayout w;
    public ImageView w0;
    public SharedPreferences w1;
    public NSTIJKPlayerEpisodes x;
    public LinearLayout x0;
    public SharedPreferences x1;
    public ImageView y;
    public LinearLayout y0;
    public SharedPreferences y1;
    public LinearLayout z;
    public ImageView z0;
    public SharedPreferences.Editor z1;
    public static final int[] m3 = {0, 1, 2, 3, 4, 5};
    public static boolean q3 = true;
    public static boolean r3 = false;
    public static boolean s3 = true;
    public int d = 0;
    public a.b l = null;
    public IMediaPlayer m = null;
    public long n = -1;
    public int q = 4;
    public int r = m3[0];
    public boolean R0 = false;
    public boolean S0 = false;
    public boolean T0 = false;
    public int U0 = 0;
    public List V0 = new ArrayList();
    public String k1 = "";
    public String K1 = "";
    public Boolean M1 = Boolean.TRUE;
    public int U1 = -1;
    public int V1 = -1;
    public int W1 = 0;
    public String X1 = "";
    public String Y1 = "";
    public String Z1 = "";
    public String a2 = "movie";
    public String b2 = "";
    public String c2 = "";
    public String g2 = "";
    public String h2 = "";
    public String i2 = "";
    public String j2 = "";
    public int n2 = 0;
    public float o2 = -1.0f;
    public boolean p2 = false;
    public String q2 = "mobile";
    public String w2 = "";
    public String x2 = "";
    public String y2 = "";
    public String z2 = "";
    public int A2 = 0;
    public int B2 = 0;
    public int C2 = 0;
    public boolean I2 = false;
    public boolean J2 = false;
    public ArrayList L2 = new ArrayList();
    public boolean N2 = m7.a.u0;
    public final i7.c O2 = new i7.c(this);
    public int b3 = 0;
    public int c3 = 5;
    public boolean d3 = false;
    public boolean e3 = false;
    public BroadcastReceiver f3 = new h();
    public Runnable g3 = new j();
    public final SeekBar.OnSeekBarChangeListener h3 = new k();
    public final SeekBar.OnSeekBarChangeListener i3 = new l();
    public NSTIJKPlayerEpisodes.M j3 = new c();
    public final SeekBar.OnSeekBarChangeListener k3 = new g();
    public Handler l3 = new i(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ExoDownloadedPlayerTwo.a2(ExoDownloadedPlayerTwo.this);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            NSTIJKPlayerEpisodes F1;
            int currentPosition;
            if (intent == null || !"media_control".equals(intent.getAction())) {
                return;
            }
            int intExtra = intent.getIntExtra("control_type", 0);
            if (intExtra == 1) {
                if (Build.VERSION.SDK_INT >= 26) {
                    ExoDownloadedPlayerTwo.this.q3(a7.e.x0, "pause", 2, 2);
                    return;
                }
                return;
            }
            if (intExtra == 2) {
                ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this).pause();
                if (Build.VERSION.SDK_INT >= 26) {
                    ExoDownloadedPlayerTwo.this.q3(a7.e.r0, "play", 1, 1);
                    return;
                }
                return;
            }
            if (intExtra != 4) {
                if (intExtra != 5) {
                    return;
                }
                F1 = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this);
                currentPosition = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this).getCurrentPosition() + 10000;
            } else if (ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this).getCurrentPosition() - 10000 <= 0) {
                ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this).seekTo(0);
                return;
            } else {
                F1 = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this);
                currentPosition = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this).getCurrentPosition() - 10000;
            }
            F1.seekTo(currentPosition);
        }
    }

    public class c extends NSTIJKPlayerEpisodes.M {
        public c() {
        }

        public void a() {
            ExoDownloadedPlayerTwo.this.q3(a7.e.x0, "pause", 2, 2);
        }

        public void b() {
            ExoDownloadedPlayerTwo.this.q3(a7.e.r0, "play", 1, 1);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            ExoDownloadedPlayerTwo.this.J2();
        }
    }

    public class e implements View.OnTouchListener {
        public e() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent != null && ExoDownloadedPlayerTwo.k2(ExoDownloadedPlayerTwo.this).onTouchEvent(motionEvent);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ LinearLayout a;

        public f(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        public void run() {
            this.a.setVisibility(8);
            if (ExoDownloadedPlayerTwo.this.e2.getVisibility() != 0 || ExoDownloadedPlayerTwo.h2(ExoDownloadedPlayerTwo.this) == null) {
                return;
            }
            ExoDownloadedPlayerTwo.h2(ExoDownloadedPlayerTwo.this).setVisibility(0);
        }
    }

    public class g implements SeekBar.OnSeekBarChangeListener {
        public g() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView m2;
            Resources resources;
            int i2;
            if (ExoDownloadedPlayerTwo.t2(ExoDownloadedPlayerTwo.this) != null) {
                try {
                    ExoDownloadedPlayerTwo.t2(ExoDownloadedPlayerTwo.this).setStreamVolume(3, i, 0);
                    int streamVolume = (int) ((ExoDownloadedPlayerTwo.t2(ExoDownloadedPlayerTwo.this).getStreamVolume(3) / ExoDownloadedPlayerTwo.l2(ExoDownloadedPlayerTwo.this)) * 100.0f);
                    if (streamVolume == 0 || streamVolume < 0) {
                        m2 = ExoDownloadedPlayerTwo.m2(ExoDownloadedPlayerTwo.this);
                        resources = ExoDownloadedPlayerTwo.this.getResources();
                        i2 = a7.e.w0;
                    } else if (streamVolume < 40) {
                        m2 = ExoDownloadedPlayerTwo.m2(ExoDownloadedPlayerTwo.this);
                        resources = ExoDownloadedPlayerTwo.this.getResources();
                        i2 = a7.e.t0;
                    } else if (streamVolume < 80) {
                        m2 = ExoDownloadedPlayerTwo.m2(ExoDownloadedPlayerTwo.this);
                        resources = ExoDownloadedPlayerTwo.this.getResources();
                        i2 = a7.e.u0;
                    } else if (streamVolume < 100) {
                        m2 = ExoDownloadedPlayerTwo.m2(ExoDownloadedPlayerTwo.this);
                        resources = ExoDownloadedPlayerTwo.this.getResources();
                        i2 = a7.e.v0;
                    } else {
                        m2 = ExoDownloadedPlayerTwo.m2(ExoDownloadedPlayerTwo.this);
                        resources = ExoDownloadedPlayerTwo.this.getResources();
                        i2 = a7.e.v0;
                    }
                    m2.setBackground(resources.getDrawable(i2));
                } catch (Exception unused) {
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ExoDownloadedPlayerTwo.this.j3();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ExoDownloadedPlayerTwo.this.j3();
            ExoDownloadedPlayerTwo.this.w2(3000);
        }
    }

    public class h extends BroadcastReceiver {
        public h() {
        }

        public void onReceive(Context context, Intent intent) {
            MyApplication.E("onReceive CLOSE_TARGET_ACTIVITY : ");
            if ("pip_mode_switch_user".equals(intent.getAction())) {
                ExoDownloadedPlayerTwo.this.finish();
            }
        }
    }

    public class i extends Handler {
        public i(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ExoDownloadedPlayerTwo.n2(ExoDownloadedPlayerTwo.this);
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                ExoDownloadedPlayerTwo.q2(ExoDownloadedPlayerTwo.this).b(a7.f.U).a();
                ExoDownloadedPlayerTwo.q2(ExoDownloadedPlayerTwo.this).b(a7.f.v).a();
                ExoDownloadedPlayerTwo.q2(ExoDownloadedPlayerTwo.this).b(a7.f.y).a();
                return;
            }
            if (ExoDownloadedPlayerTwo.r2(ExoDownloadedPlayerTwo.this) >= 0) {
                ExoDownloadedPlayerTwo.this.Q2.seekTo((int) ExoDownloadedPlayerTwo.r2(r5));
                ExoDownloadedPlayerTwo.s2(ExoDownloadedPlayerTwo.this, -1L);
            }
        }
    }

    public class j implements Runnable {
        public j() {
        }

        public void run() {
            try {
                Log.i("durationIS", "total:" + ExoDownloadedPlayerTwo.this.Q2.getDuration() + "cur:" + ExoDownloadedPlayerTwo.this.Q2.getCurrentPosition());
                TextView v1 = ExoDownloadedPlayerTwo.v1(ExoDownloadedPlayerTwo.this);
                ExoDownloadedPlayerTwo exoDownloadedPlayerTwo = ExoDownloadedPlayerTwo.this;
                v1.setText(exoDownloadedPlayerTwo.l3((int) exoDownloadedPlayerTwo.Q2.getCurrentPosition()));
                TextView I1 = ExoDownloadedPlayerTwo.I1(ExoDownloadedPlayerTwo.this);
                ExoDownloadedPlayerTwo exoDownloadedPlayerTwo2 = ExoDownloadedPlayerTwo.this;
                I1.setText(exoDownloadedPlayerTwo2.l3((int) exoDownloadedPlayerTwo2.Q2.getDuration()));
                int duration = (int) ExoDownloadedPlayerTwo.this.Q2.getDuration();
                if (duration > 0) {
                    ExoDownloadedPlayerTwo.V1(ExoDownloadedPlayerTwo.this).setProgress((int) ((((int) ExoDownloadedPlayerTwo.this.Q2.getCurrentPosition()) * 1000) / duration));
                    if (ExoDownloadedPlayerTwo.this.Q2.isPlaying()) {
                        ExoDownloadedPlayerTwo.g2(ExoDownloadedPlayerTwo.this).setVisibility(8);
                        ExoDownloadedPlayerTwo.o2(ExoDownloadedPlayerTwo.this).setVisibility(0);
                    }
                }
            } catch (Exception unused) {
            }
            ExoDownloadedPlayerTwo.p2(ExoDownloadedPlayerTwo.this).postDelayed(this, 1000L);
        }
    }

    public class k implements SeekBar.OnSeekBarChangeListener {
        public k() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                ExoDownloadedPlayerTwo.q2(ExoDownloadedPlayerTwo.this).b(a7.f.G).a();
                ExoDownloadedPlayerTwo.s2(ExoDownloadedPlayerTwo.this, (int) (((int) r5.Q2.getDuration()) * ((i * 1.0d) / 1000.0d)));
                ExoDownloadedPlayerTwo exoDownloadedPlayerTwo = ExoDownloadedPlayerTwo.this;
                exoDownloadedPlayerTwo.o = true;
                exoDownloadedPlayerTwo.Q2.seekTo(ExoDownloadedPlayerTwo.r2(exoDownloadedPlayerTwo));
                ExoDownloadedPlayerTwo.this.j3();
                ExoDownloadedPlayerTwo.this.w2(3000);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ExoDownloadedPlayerTwo exoDownloadedPlayerTwo = ExoDownloadedPlayerTwo.this;
            exoDownloadedPlayerTwo.o = true;
            ExoDownloadedPlayerTwo.t2(exoDownloadedPlayerTwo).setStreamMute(3, true);
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (ExoDownloadedPlayerTwo.w1(ExoDownloadedPlayerTwo.this) == null) {
                return;
            }
            ExoDownloadedPlayerTwo.this.j3();
            ExoDownloadedPlayerTwo.this.w2(3000);
            ExoDownloadedPlayerTwo.t2(ExoDownloadedPlayerTwo.this).setStreamMute(3, false);
            ExoDownloadedPlayerTwo.this.o = false;
        }
    }

    public class l implements SeekBar.OnSeekBarChangeListener {
        public l() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView z1;
            Resources resources;
            int i2;
            ExoDownloadedPlayerTwo.y1(ExoDownloadedPlayerTwo.this, i);
            int x1 = (int) ((ExoDownloadedPlayerTwo.x1(ExoDownloadedPlayerTwo.this) / 255.0f) * 100.0f);
            if (x1 < 20) {
                z1 = ExoDownloadedPlayerTwo.z1(ExoDownloadedPlayerTwo.this);
                resources = ExoDownloadedPlayerTwo.this.getResources();
                i2 = a7.e.i0;
            } else if (x1 < 30) {
                z1 = ExoDownloadedPlayerTwo.z1(ExoDownloadedPlayerTwo.this);
                resources = ExoDownloadedPlayerTwo.this.getResources();
                i2 = a7.e.j0;
            } else if (x1 < 40) {
                z1 = ExoDownloadedPlayerTwo.z1(ExoDownloadedPlayerTwo.this);
                resources = ExoDownloadedPlayerTwo.this.getResources();
                i2 = a7.e.k0;
            } else if (x1 < 50) {
                z1 = ExoDownloadedPlayerTwo.z1(ExoDownloadedPlayerTwo.this);
                resources = ExoDownloadedPlayerTwo.this.getResources();
                i2 = a7.e.l0;
            } else if (x1 < 60) {
                z1 = ExoDownloadedPlayerTwo.z1(ExoDownloadedPlayerTwo.this);
                resources = ExoDownloadedPlayerTwo.this.getResources();
                i2 = a7.e.m0;
            } else if (x1 < 70) {
                z1 = ExoDownloadedPlayerTwo.z1(ExoDownloadedPlayerTwo.this);
                resources = ExoDownloadedPlayerTwo.this.getResources();
                i2 = a7.e.n0;
            } else {
                z1 = ExoDownloadedPlayerTwo.z1(ExoDownloadedPlayerTwo.this);
                resources = ExoDownloadedPlayerTwo.this.getResources();
                i2 = a7.e.o0;
            }
            z1.setBackground(resources.getDrawable(i2));
            Log.i("brightnessIs", "brightNess:" + ExoDownloadedPlayerTwo.x1(ExoDownloadedPlayerTwo.this));
            WindowManager.LayoutParams attributes = ExoDownloadedPlayerTwo.this.getWindow().getAttributes();
            attributes.screenBrightness = ExoDownloadedPlayerTwo.x1(ExoDownloadedPlayerTwo.this) / 255.0f;
            try {
                ExoDownloadedPlayerTwo.A1(ExoDownloadedPlayerTwo.this).R((int) ExoDownloadedPlayerTwo.x1(ExoDownloadedPlayerTwo.this));
            } catch (Exception e) {
                Log.i("brightnessError", e.toString());
            }
            ExoDownloadedPlayerTwo.this.getWindow().setAttributes(attributes);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ExoDownloadedPlayerTwo.this.j3();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ExoDownloadedPlayerTwo.this.j3();
            ExoDownloadedPlayerTwo.this.w2(3000);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public void run() {
            TextView U1;
            String str;
            int currentPosition = ((int) ExoDownloadedPlayerTwo.this.Q2.getCurrentPosition()) + ExoDownloadedPlayerTwo.R1(ExoDownloadedPlayerTwo.this);
            ExoDownloadedPlayerTwo.this.Q2.seekTo(currentPosition > 0 ? ((int) r0.getCurrentPosition()) + ExoDownloadedPlayerTwo.R1(ExoDownloadedPlayerTwo.this) : 0L);
            ExoDownloadedPlayerTwo.S1(ExoDownloadedPlayerTwo.this, 0);
            ExoDownloadedPlayerTwo.T1(ExoDownloadedPlayerTwo.this).startAnimation(ExoDownloadedPlayerTwo.this.f1);
            ExoDownloadedPlayerTwo.T1(ExoDownloadedPlayerTwo.this).setVisibility(8);
            String str2 = ExoDownloadedPlayerTwo.this.c2;
            if (str2 == null || !str2.equals("catch_up")) {
                U1 = ExoDownloadedPlayerTwo.U1(ExoDownloadedPlayerTwo.this);
                str = "-10s";
            } else {
                U1 = ExoDownloadedPlayerTwo.U1(ExoDownloadedPlayerTwo.this);
                str = "-60s";
            }
            U1.setText(str);
            if (ExoDownloadedPlayerTwo.this.e2.getVisibility() == 8) {
                ExoDownloadedPlayerTwo.U1(ExoDownloadedPlayerTwo.this).startAnimation(ExoDownloadedPlayerTwo.this.f1);
                ExoDownloadedPlayerTwo.U1(ExoDownloadedPlayerTwo.this).setVisibility(8);
            }
            ExoDownloadedPlayerTwo.this.w2(1000);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        public void run() {
            TextView X1;
            String str;
            ExoDownloadedPlayerTwo.this.Q2.seekTo(((int) r0.getCurrentPosition()) + ExoDownloadedPlayerTwo.R1(ExoDownloadedPlayerTwo.this));
            ExoDownloadedPlayerTwo.S1(ExoDownloadedPlayerTwo.this, 0);
            ExoDownloadedPlayerTwo.W1(ExoDownloadedPlayerTwo.this).startAnimation(ExoDownloadedPlayerTwo.this.f1);
            ExoDownloadedPlayerTwo.W1(ExoDownloadedPlayerTwo.this).setVisibility(8);
            String str2 = ExoDownloadedPlayerTwo.this.c2;
            if (str2 == null || !str2.equals("catch_up")) {
                X1 = ExoDownloadedPlayerTwo.X1(ExoDownloadedPlayerTwo.this);
                str = "+10s";
            } else {
                X1 = ExoDownloadedPlayerTwo.X1(ExoDownloadedPlayerTwo.this);
                str = "+60s";
            }
            X1.setText(str);
            if (ExoDownloadedPlayerTwo.this.e2.getVisibility() == 8) {
                ExoDownloadedPlayerTwo.X1(ExoDownloadedPlayerTwo.this).startAnimation(ExoDownloadedPlayerTwo.this.f1);
                ExoDownloadedPlayerTwo.X1(ExoDownloadedPlayerTwo.this).setVisibility(8);
            }
            ExoDownloadedPlayerTwo.this.w2(1000);
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NSTIJKPlayerEpisodes F1;
            float f;
            switch (i) {
                case 0:
                    ExoDownloadedPlayerTwo.Y1(ExoDownloadedPlayerTwo.this, "0.25x");
                    ExoDownloadedPlayerTwo.Z1(ExoDownloadedPlayerTwo.this).setText(ExoDownloadedPlayerTwo.this.getResources().getString(a7.j.n7) + " (0.25x)");
                    F1 = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this);
                    f = 0.25f;
                    break;
                case 1:
                    ExoDownloadedPlayerTwo.Y1(ExoDownloadedPlayerTwo.this, "0.5x");
                    ExoDownloadedPlayerTwo.Z1(ExoDownloadedPlayerTwo.this).setText(ExoDownloadedPlayerTwo.this.getResources().getString(a7.j.n7) + " (0.5x)");
                    F1 = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this);
                    f = 0.5f;
                    break;
                case 2:
                    ExoDownloadedPlayerTwo.Y1(ExoDownloadedPlayerTwo.this, "0.75x");
                    ExoDownloadedPlayerTwo.Z1(ExoDownloadedPlayerTwo.this).setText(ExoDownloadedPlayerTwo.this.getResources().getString(a7.j.n7) + " (0.75x)");
                    F1 = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this);
                    f = 0.75f;
                    break;
                case 3:
                    ExoDownloadedPlayerTwo.Y1(ExoDownloadedPlayerTwo.this, "1x (Normal)");
                    ExoDownloadedPlayerTwo.Z1(ExoDownloadedPlayerTwo.this).setText(ExoDownloadedPlayerTwo.this.getResources().getString(a7.j.n7) + " (1x)");
                    F1 = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this);
                    f = 1.0f;
                    break;
                case 4:
                    ExoDownloadedPlayerTwo.Y1(ExoDownloadedPlayerTwo.this, "1.25x");
                    ExoDownloadedPlayerTwo.Z1(ExoDownloadedPlayerTwo.this).setText(ExoDownloadedPlayerTwo.this.getResources().getString(a7.j.n7) + " (1.25x)");
                    F1 = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this);
                    f = 1.25f;
                    break;
                case 5:
                    ExoDownloadedPlayerTwo.Y1(ExoDownloadedPlayerTwo.this, "1.5x");
                    ExoDownloadedPlayerTwo.Z1(ExoDownloadedPlayerTwo.this).setText(ExoDownloadedPlayerTwo.this.getResources().getString(a7.j.n7) + " (1.5x)");
                    F1 = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this);
                    f = 1.5f;
                    break;
                case 6:
                    ExoDownloadedPlayerTwo.Y1(ExoDownloadedPlayerTwo.this, "1.75x");
                    ExoDownloadedPlayerTwo.Z1(ExoDownloadedPlayerTwo.this).setText(ExoDownloadedPlayerTwo.this.getResources().getString(a7.j.n7) + " (1.75x)");
                    F1 = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this);
                    f = 1.75f;
                    break;
                case 7:
                    ExoDownloadedPlayerTwo.Y1(ExoDownloadedPlayerTwo.this, "2x");
                    ExoDownloadedPlayerTwo.Z1(ExoDownloadedPlayerTwo.this).setText(ExoDownloadedPlayerTwo.this.getResources().getString(a7.j.n7) + " (2x)");
                    F1 = ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this);
                    f = 2.0f;
                    break;
                default:
                    return;
            }
            F1.setSpeed(f);
            ExoDownloadedPlayerTwo.this.Q2.x0(f);
            dialogInterface.cancel();
        }
    }

    public class q implements DialogInterface.OnDismissListener {
        public q() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this) != null) {
                ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this).p2();
            }
        }
    }

    public class r implements View.OnFocusChangeListener {
        public final View a;

        public r(View view) {
            this.a = view;
        }

        public final void a(boolean z) {
            if (z) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{z ? 0.6f : 0.5f});
                ofFloat.setDuration(150L);
                ofFloat.start();
            }
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void c(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            View view3;
            View view4;
            LinearLayout f2;
            int i;
            LinearLayout d2;
            View view5;
            View view6;
            View view7;
            LinearLayout d22;
            if (z) {
                f = z ? 1.08f : 1.0f;
                View view8 = this.a;
                if (view8 == null || view8.getTag() == null || !this.a.getTag().equals("1")) {
                    View view9 = this.a;
                    if (view9 == null || view9.getTag() == null || !this.a.getTag().equals("2")) {
                        View view10 = this.a;
                        if (view10 == null || view10.getTag() == null || !this.a.getTag().equals("3")) {
                            View view11 = this.a;
                            if ((view11 != null && view11.getTag() != null && this.a.getTag().equals("4")) || (((view5 = this.a) != null && view5.getTag() != null && this.a.getTag().equals("5")) || (((view6 = this.a) != null && view6.getTag() != null && this.a.getTag().equals("6")) || ((view7 = this.a) != null && view7.getTag() != null && this.a.getTag().equals("7"))))) {
                                view.setBackground(ExoDownloadedPlayerTwo.this.getResources().getDrawable(a7.e.Q0));
                                return;
                            }
                            View view12 = this.a;
                            if (view12 != null && view12.getTag() != null && this.a.getTag().equals("8")) {
                                return;
                            }
                            View view13 = this.a;
                            if (view13 == null || view13.getTag() == null || !this.a.getTag().equals("9")) {
                                View view14 = this.a;
                                if (view14 == null || view14.getTag() == null || !this.a.getTag().equals("10")) {
                                    View view15 = this.a;
                                    if (view15 == null || view15.getTag() == null || !this.a.getTag().equals("11")) {
                                        View view16 = this.a;
                                        if (view16 == null || view16.getTag() == null || !this.a.getTag().equals("12")) {
                                            return;
                                        } else {
                                            f2 = ExoDownloadedPlayerTwo.f2(ExoDownloadedPlayerTwo.this);
                                        }
                                    } else {
                                        f2 = ExoDownloadedPlayerTwo.e2(ExoDownloadedPlayerTwo.this);
                                    }
                                    i = a7.e.p;
                                } else {
                                    view.setBackground(ExoDownloadedPlayerTwo.this.getResources().getDrawable(a7.e.P0));
                                    b(f);
                                    c(f);
                                    d22 = ExoDownloadedPlayerTwo.d2(ExoDownloadedPlayerTwo.this);
                                }
                            }
                        }
                        view.setBackground(ExoDownloadedPlayerTwo.this.getResources().getDrawable(a7.e.P0));
                        b(f);
                        c(f);
                        return;
                    }
                    view.setBackground(ExoDownloadedPlayerTwo.this.getResources().getDrawable(a7.e.P0));
                    b(f);
                    c(f);
                    d22 = ExoDownloadedPlayerTwo.c2(ExoDownloadedPlayerTwo.this);
                } else {
                    view.setBackground(ExoDownloadedPlayerTwo.this.getResources().getDrawable(a7.e.P0));
                    b(f);
                    c(f);
                    d22 = ExoDownloadedPlayerTwo.b2(ExoDownloadedPlayerTwo.this);
                }
                d22.setVisibility(0);
                return;
            }
            if (z) {
                return;
            }
            f = z ? 1.08f : 1.0f;
            View view17 = this.a;
            if (view17 == null || view17.getTag() == null || !this.a.getTag().equals("1")) {
                View view18 = this.a;
                if (view18 == null || view18.getTag() == null || !this.a.getTag().equals("2")) {
                    View view19 = this.a;
                    if (view19 == null || view19.getTag() == null || !this.a.getTag().equals("3")) {
                        View view20 = this.a;
                        if ((view20 != null && view20.getTag() != null && this.a.getTag().equals("4")) || (((view2 = this.a) != null && view2.getTag() != null && this.a.getTag().equals("5")) || (((view3 = this.a) != null && view3.getTag() != null && this.a.getTag().equals("6")) || ((view4 = this.a) != null && view4.getTag() != null && this.a.getTag().equals("7"))))) {
                            view.setBackground((Drawable) null);
                            return;
                        }
                        View view21 = this.a;
                        if (view21 != null && view21.getTag() != null && this.a.getTag().equals("8")) {
                            return;
                        }
                        View view22 = this.a;
                        if (view22 == null || view22.getTag() == null || !this.a.getTag().equals("9")) {
                            View view23 = this.a;
                            if (view23 == null || view23.getTag() == null || !this.a.getTag().equals("10")) {
                                View view24 = this.a;
                                if (view24 == null || view24.getTag() == null || !this.a.getTag().equals("11")) {
                                    View view25 = this.a;
                                    if (view25 == null || view25.getTag() == null || !this.a.getTag().equals("12")) {
                                        return;
                                    } else {
                                        f2 = ExoDownloadedPlayerTwo.f2(ExoDownloadedPlayerTwo.this);
                                    }
                                } else {
                                    f2 = ExoDownloadedPlayerTwo.e2(ExoDownloadedPlayerTwo.this);
                                }
                                i = a7.e.o;
                            } else {
                                view.setBackground(ExoDownloadedPlayerTwo.this.getResources().getDrawable(a7.e.N0));
                                b(f);
                                c(f);
                                a(z);
                                d2 = ExoDownloadedPlayerTwo.d2(ExoDownloadedPlayerTwo.this);
                            }
                        }
                    }
                    view.setBackground(ExoDownloadedPlayerTwo.this.getResources().getDrawable(a7.e.N0));
                    b(f);
                    c(f);
                    a(z);
                    return;
                }
                view.setBackground(ExoDownloadedPlayerTwo.this.getResources().getDrawable(a7.e.N0));
                b(f);
                c(f);
                a(z);
                d2 = ExoDownloadedPlayerTwo.c2(ExoDownloadedPlayerTwo.this);
            } else {
                view.setBackground(ExoDownloadedPlayerTwo.this.getResources().getDrawable(a7.e.N0));
                b(f);
                c(f);
                a(z);
                d2 = ExoDownloadedPlayerTwo.b2(ExoDownloadedPlayerTwo.this);
            }
            d2.setVisibility(8);
            return;
            f2.setBackgroundResource(i);
        }
    }

    public class s implements d4.p {
        public s() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Pair a(p1 p1Var) {
            String string = ExoDownloadedPlayerTwo.this.getString(a7.j.M1);
            u.b cause = p1Var.getCause();
            if (cause instanceof u.b) {
                u.b bVar = cause;
                p3.t tVar = bVar.d;
                string = tVar == null ? bVar.getCause() instanceof B.c ? ExoDownloadedPlayerTwo.this.getString(a7.j.R1) : bVar.c ? ExoDownloadedPlayerTwo.this.getString(a7.j.P1, new Object[]{bVar.a}) : ExoDownloadedPlayerTwo.this.getString(a7.j.O1, new Object[]{bVar.a}) : ExoDownloadedPlayerTwo.this.getString(a7.j.N1, new Object[]{tVar.a});
            }
            return Pair.create(0, string);
        }

        public /* synthetic */ s(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo, h hVar) {
            this();
        }
    }

    public class t implements t1.d {
        public t() {
        }

        private void C(String str) {
            ExoDownloadedPlayerTwo.q2(ExoDownloadedPlayerTwo.this).b(a7.f.G).e();
            ExoDownloadedPlayerTwo.q2(ExoDownloadedPlayerTwo.this).b(a7.f.K).c(str);
        }

        private void o() {
            ExoDownloadedPlayerTwo exoDownloadedPlayerTwo = ExoDownloadedPlayerTwo.this;
            if (exoDownloadedPlayerTwo.b3 >= ExoDownloadedPlayerTwo.i2(exoDownloadedPlayerTwo)) {
                C(ExoDownloadedPlayerTwo.J1(ExoDownloadedPlayerTwo.this).getResources().getString(a7.j.b7));
                ExoDownloadedPlayerTwo.j2(ExoDownloadedPlayerTwo.this);
                ExoDownloadedPlayerTwo.this.d3 = false;
                ExoDownloadedPlayerTwo.p3.setVisibility(8);
                return;
            }
            ExoDownloadedPlayerTwo exoDownloadedPlayerTwo2 = ExoDownloadedPlayerTwo.this;
            if (exoDownloadedPlayerTwo2.e3) {
                return;
            }
            exoDownloadedPlayerTwo2.d3 = true;
        }

        public /* synthetic */ void A(Q2.e eVar) {
            v1.a(this, eVar);
        }

        public /* synthetic */ void B(boolean z) {
            v1.j(this, z);
        }

        public void E(int i) {
            if (i == 2) {
                if (ExoDownloadedPlayerTwo.y2()) {
                    return;
                }
                if (ExoDownloadedPlayerTwo.h2(ExoDownloadedPlayerTwo.this) != null && ExoDownloadedPlayerTwo.h2(ExoDownloadedPlayerTwo.this).getVisibility() == 0) {
                    ExoDownloadedPlayerTwo.h2(ExoDownloadedPlayerTwo.this).setVisibility(8);
                }
                ExoDownloadedPlayerTwo.p3.setVisibility(0);
                return;
            }
            if (i == 4) {
                o();
                return;
            }
            if (i == 3) {
                if (ExoDownloadedPlayerTwo.this.e2.getVisibility() == 0) {
                    ExoDownloadedPlayerTwo.h2(ExoDownloadedPlayerTwo.this).setVisibility(0);
                }
                ExoDownloadedPlayerTwo.this.b3 = 0;
                ExoDownloadedPlayerTwo.p3.setVisibility(8);
                LiveStreamDBHandler liveStreamDBHandler = ExoDownloadedPlayerTwo.this.H1;
            }
        }

        public /* synthetic */ void J(boolean z) {
            v1.y(this, z);
        }

        public /* synthetic */ void M(int i, boolean z) {
            v1.f(this, i, z);
        }

        public /* synthetic */ void O(t1.b bVar) {
            v1.b(this, bVar);
        }

        public /* synthetic */ void P() {
            v1.w(this);
        }

        public /* synthetic */ void S(t1.e eVar, t1.e eVar2, int i) {
            v1.v(this, eVar, eVar2, i);
        }

        public /* synthetic */ void U(int i, int i2) {
            v1.A(this, i, i2);
        }

        public /* synthetic */ void V(Q1 q1, int i) {
            v1.B(this, q1, i);
        }

        public /* synthetic */ void W(p1 p1Var) {
            v1.s(this, p1Var);
        }

        public /* synthetic */ void Y(z zVar) {
            v1.C(this, zVar);
        }

        public /* synthetic */ void a(boolean z) {
            v1.z(this, z);
        }

        public /* synthetic */ void a0(O2.u uVar) {
            v1.e(this, uVar);
        }

        public /* synthetic */ void b0(int i) {
            v1.u(this, i);
        }

        public /* synthetic */ void d0(boolean z) {
            v1.h(this, z);
        }

        public /* synthetic */ void e(q3.a aVar) {
            v1.m(this, aVar);
        }

        public /* synthetic */ void f0(V1 v1) {
            v1.D(this, v1);
        }

        public /* synthetic */ void g0(boolean z, int i) {
            v1.t(this, z, i);
        }

        public /* synthetic */ void h0(H0 h0, int i) {
            v1.k(this, h0, i);
        }

        public /* synthetic */ void i0(R0 r0) {
            v1.l(this, r0);
        }

        public /* synthetic */ void j(C c) {
            v1.E(this, c);
        }

        public /* synthetic */ void j0(boolean z, int i) {
            v1.n(this, z, i);
        }

        public /* synthetic */ void k(List list) {
            v1.d(this, list);
        }

        public void l0(p1 p1Var) {
            ExoDownloadedPlayerTwo exoDownloadedPlayerTwo = ExoDownloadedPlayerTwo.this;
            if (exoDownloadedPlayerTwo.e3) {
                return;
            }
            if (p1Var.a == 1002) {
                exoDownloadedPlayerTwo.K2();
            } else if (!p1Var.toString().contains("com.google.android.exoplayer2.ext.ffmpeg.FfmpegDecoderException")) {
                o();
            } else {
                w.P0(ExoDownloadedPlayerTwo.J1(ExoDownloadedPlayerTwo.this), "Audio track issue found. Please change the audio track to none.");
                ExoDownloadedPlayerTwo.this.K2();
            }
        }

        public /* synthetic */ void m0(t1 t1Var, t1.c cVar) {
            v1.g(this, t1Var, cVar);
        }

        public /* synthetic */ void n0(boolean z) {
            v1.i(this, z);
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            v1.x(this, i);
        }

        public /* synthetic */ void t(s1 s1Var) {
            v1.o(this, s1Var);
        }

        public /* synthetic */ void u(P3.f fVar) {
            v1.c(this, fVar);
        }

        public /* synthetic */ void z(int i) {
            v1.q(this, i);
        }

        public /* synthetic */ t(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo, h hVar) {
            this();
        }
    }

    public class u extends GestureDetector.SimpleOnGestureListener {
        public boolean a;

        public u() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (ExoDownloadedPlayerTwo.B1(ExoDownloadedPlayerTwo.this) == null) {
                return true;
            }
            ExoDownloadedPlayerTwo.B1(ExoDownloadedPlayerTwo.this).getWidth();
            motionEvent.getX();
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.a = true;
            return super.onDown(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ExoDownloadedPlayerTwo.p3.getVisibility() != 8) {
                return true;
            }
            ExoDownloadedPlayerTwo.C1(ExoDownloadedPlayerTwo.this);
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public static /* synthetic */ u7.a A1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.o1;
    }

    private void A2() {
        int i2;
        int i3;
        int i4;
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
        List list = this.J1;
        if (list == null || list.size() <= 0) {
            return;
        }
        List list2 = this.V0;
        if (list2 != null) {
            list2.clear();
        }
        if (this.l1 != null) {
            if (this.x != null) {
                this.k2 = this.Y0.getSharedPreferences("currentSeekTime", 0);
                long currentPosition = this.x.getCurrentPosition();
                SharedPreferences sharedPreferences = this.Y0.getSharedPreferences("currentSeekTime", 0);
                this.k2 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.l2 = edit;
                edit.putString("currentSeekTime", String.valueOf(currentPosition));
                this.l2.apply();
                if ((this.x == null || x7.a.f().a() == null || !this.F1.equals("m3u")) && x7.a.f() != null && x7.a.f().e() != null && currentPosition != -1 && currentPosition != 0) {
                    ArrayList c2 = this.n1.c(x7.a.f().e());
                    this.E2 = c2;
                    if (c2 != null && c2.size() > 0) {
                        try {
                            int F2 = F2(this.J1, w.r0(x7.a.f().e()));
                            GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                            getEpisdoeDetailsCallback.setId(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getId());
                            getEpisdoeDetailsCallback.setTitle(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getTitle());
                            getEpisdoeDetailsCallback.setContainerExtension(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getContainerExtension());
                            getEpisdoeDetailsCallback.setAdded(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getAdded());
                            getEpisdoeDetailsCallback.setSeriesCover(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeriesCover());
                            getEpisdoeDetailsCallback.setCategoryId(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getCategoryId());
                            getEpisdoeDetailsCallback.setElapsed_time(String.valueOf(currentPosition));
                            getEpisdoeDetailsCallback.setSeriesId(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeriesId());
                            getEpisdoeDetailsCallback.setImage(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getImage());
                            getEpisdoeDetailsCallback.setMovieImage(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getMovieImage());
                            getEpisdoeDetailsCallback.setMainSeriesImg(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getMainSeriesImg());
                            getEpisdoeDetailsCallback.setSeriesNum(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeriesNum());
                            getEpisdoeDetailsCallback.setSeasonNumber(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeasonNumber());
                            getEpisdoeDetailsCallback.setEpisodeNum(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getEpisodeNumber());
                            getEpisdoeDetailsCallback.setSeriesName(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeriesName());
                            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.x;
                            getEpisdoeDetailsCallback.setDurationSec(nSTIJKPlayerEpisodes2 != null ? String.valueOf(nSTIJKPlayerEpisodes2.getDuration() / 1000) : ((GetEpisdoeDetailsCallback) this.J1.get(F2)).getDurationSec());
                            this.n1.b(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getId());
                            this.n1.i(this.Y0, ((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeriesId());
                            this.n1.g(this.Y0, getEpisdoeDetailsCallback);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            ArrayList allSeriesRecentWatch = this.l1.getAllSeriesRecentWatch("getalldata");
            for (int i5 = 0; i5 < this.J1.size(); i5++) {
                if (((GetEpisdoeDetailsCallback) this.J1.get(i5)).getSeasonNumber().equals(Integer.valueOf(this.B2))) {
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback2 = (GetEpisdoeDetailsCallback) this.J1.get(i5);
                    int i6 = 0;
                    while (true) {
                        if (i6 >= allSeriesRecentWatch.size()) {
                            break;
                        }
                        if (((GetEpisdoeDetailsCallback) this.J1.get(i5)).getId().equals(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i6)).getId())) {
                            getEpisdoeDetailsCallback2.setElapsed_time(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i6)).getElapsed_time());
                            try {
                                i2 = Math.round(Integer.parseInt(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i6)).getElapsed_time()) / 1000.0f);
                                try {
                                    i3 = (!getEpisdoeDetailsCallback2.getDurationSec().equals("") || (nSTIJKPlayerEpisodes = this.x) == null) ? w.r0(getEpisdoeDetailsCallback2.getDurationSec()) : nSTIJKPlayerEpisodes.getDuration() / 1000;
                                } catch (Exception unused2) {
                                    i3 = 0;
                                    i4 = Math.round((i2 / i3) * 100.0f);
                                    getEpisdoeDetailsCallback2.setEpisode_watched_percentage(i4);
                                    this.V0.add(getEpisdoeDetailsCallback2);
                                }
                            } catch (Exception unused3) {
                                i2 = 0;
                            }
                            try {
                                i4 = Math.round((i2 / i3) * 100.0f);
                            } catch (Exception unused4) {
                                i4 = 0;
                            }
                            getEpisdoeDetailsCallback2.setEpisode_watched_percentage(i4);
                        } else {
                            i6++;
                        }
                    }
                    this.V0.add(getEpisdoeDetailsCallback2);
                }
            }
        }
    }

    public static /* synthetic */ PlayerView B1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.P2;
    }

    private void B2(String str) {
        this.m1.deleteMovieRecentWatch(str);
    }

    public static /* synthetic */ void C1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        exoDownloadedPlayerTwo.n3();
    }

    private void C2() {
        ImageView imageView = this.C;
        imageView.setOnFocusChangeListener(new r(imageView));
        ImageView imageView2 = this.D;
        imageView2.setOnFocusChangeListener(new r(imageView2));
        ImageView imageView3 = this.y;
        imageView3.setOnFocusChangeListener(new r(imageView3));
        SeekBar seekBar = this.E;
        seekBar.setOnFocusChangeListener(new r(seekBar));
        ImageView imageView4 = this.B;
        imageView4.setOnFocusChangeListener(new r(imageView4));
        ImageView imageView5 = this.N0;
        imageView5.setOnFocusChangeListener(new r(imageView5));
        LinearLayout linearLayout = this.F;
        linearLayout.setOnFocusChangeListener(new r(linearLayout));
        LinearLayout linearLayout2 = this.G;
        linearLayout2.setOnFocusChangeListener(new r(linearLayout2));
        LinearLayout linearLayout3 = this.H;
        linearLayout3.setOnFocusChangeListener(new r(linearLayout3));
        LinearLayout linearLayout4 = this.J;
        linearLayout4.setOnFocusChangeListener(new r(linearLayout4));
        ImageView imageView6 = this.M;
        imageView6.setOnFocusChangeListener(new r(imageView6));
        ImageView imageView7 = this.N;
        imageView7.setOnFocusChangeListener(new r(imageView7));
        ImageView imageView8 = this.w0;
        imageView8.setOnFocusChangeListener(new r(imageView8));
        ImageView imageView9 = this.w0;
        imageView9.setOnFocusChangeListener(new r(imageView9));
        TextView textView = this.C0;
        textView.setOnFocusChangeListener(new r(textView));
        TextView textView2 = this.E0;
        textView2.setOnFocusChangeListener(new r(textView2));
    }

    public static /* synthetic */ o4.e D1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.u2;
    }

    public static String D2(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    public static /* synthetic */ o4.e E1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo, o4.e eVar) {
        exoDownloadedPlayerTwo.u2 = eVar;
        return eVar;
    }

    public static /* synthetic */ NSTIJKPlayerEpisodes F1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.x;
    }

    public static /* synthetic */ LinearLayout G1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.J0;
    }

    private ArrayList G2(int i2, int i3) {
        return this.m1.getStreamStatus(String.valueOf(i2), i3);
    }

    public static /* synthetic */ TextView H1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.K0;
    }

    private LiveStreamsDBModel H2(String str, int i2) {
        return this.H1.getStreamStatus(str, i2);
    }

    public static /* synthetic */ TextView I1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.P;
    }

    private void I2() {
        if (this.e2.getVisibility() == 0) {
            this.e2.startAnimation(this.f1);
            if (this.p0.getVisibility() == 0) {
                this.p0.startAnimation(this.f1);
            }
            if (this.h0.getVisibility() == 0) {
                this.h0.startAnimation(this.f1);
            }
            if (this.t0.getVisibility() == 0) {
                this.t0.startAnimation(this.f1);
            }
            if (this.i0.getVisibility() == 0) {
                this.i0.startAnimation(this.f1);
            }
            if (this.q0.getVisibility() == 0) {
                this.q0.startAnimation(this.f1);
            }
            this.e2.setVisibility(8);
            if (this.p0.getVisibility() == 0) {
                this.p0.setVisibility(8);
            }
            if (this.h0.getVisibility() == 0) {
                this.h0.setVisibility(8);
            }
            if (this.t0.getVisibility() == 0) {
                this.t0.setVisibility(8);
            }
            if (this.i0.getVisibility() == 0) {
                this.i0.setVisibility(8);
            }
            if (this.q0.getVisibility() == 0) {
                this.q0.setVisibility(8);
            }
        }
        this.x.q = false;
    }

    public static /* synthetic */ Context J1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.Y0;
    }

    public static /* synthetic */ void K1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        exoDownloadedPlayerTwo.Q2();
    }

    public static /* synthetic */ String L1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.z2;
    }

    private void L2() {
        this.F2 = new Handler();
        this.i1 = new Handler();
        this.Z0 = AnimationUtils.loadAnimation(this.Y0, a7.b.q);
        this.a1 = AnimationUtils.loadAnimation(this.Y0, a7.b.r);
        this.e1 = AnimationUtils.loadAnimation(this.Y0, a7.b.h);
        this.f1 = AnimationUtils.loadAnimation(this.Y0, a7.b.i);
        this.h1 = AnimationUtils.loadAnimation(this.Y0, a7.b.o);
        this.g1 = AnimationUtils.loadAnimation(this.Y0, a7.b.n);
        this.c1 = AnimationUtils.loadAnimation(this.Y0, a7.b.s);
        this.d1 = AnimationUtils.loadAnimation(this.Y0, a7.b.t);
        this.b1 = AnimationUtils.loadAnimation(this.Y0, a7.b.p);
        this.a3 = AnimationUtils.loadAnimation(this.Y0, a7.b.k);
        try {
            c3();
        } catch (Exception unused) {
        }
        if (this.q2.equals("mobile")) {
            try {
                o4.b e2 = o4.b.e(this);
                this.v2 = e2;
                this.u2 = e2.c().c();
                o4.a.b(getApplicationContext(), this.I0);
            } catch (Exception unused2) {
            }
        }
    }

    public static /* synthetic */ String M1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.x2;
    }

    private /* synthetic */ void M2(DialogInterface dialogInterface) {
        this.R2 = false;
    }

    public static /* synthetic */ String N1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.w2;
    }

    public static /* synthetic */ String O1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.y2;
    }

    private void O2() {
        List list;
        int d2 = x7.a.f().d();
        String str = this.c2;
        str.hashCode();
        if (str.equals("series") && (list = this.J1) != null && list.size() > 0 && d2 == this.J1.size() - 1) {
            x7.a.f().w(0);
        } else {
            x7.a.f().w(d2 + 1);
        }
    }

    public static /* synthetic */ int P1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.A2;
    }

    private void P2() {
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.x0.setOnClickListener(this);
        this.z0.setOnClickListener(this);
        this.N0.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                this.x.setMovieListener(this.j3);
            } catch (Exception unused) {
            }
        }
        this.h0.setOnClickListener(this);
        this.i0.setOnClickListener(this);
    }

    public static /* synthetic */ int Q1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo, int i2) {
        exoDownloadedPlayerTwo.A2 = i2;
        return i2;
    }

    private void Q2() {
        String str;
        MediaInfo a2;
        o4.e eVar;
        try {
            String type = SharepreferenceDBHandler.getType(this.Y0);
            str = "";
            if (type.equals("loadurl")) {
                String str2 = this.i2;
                this.j2 = str2;
                int lastIndexOf = str2.lastIndexOf(47);
                str = lastIndexOf > 1 ? this.j2.substring(lastIndexOf + 1) : "";
                String str3 = this.j2;
                this.w2 = str3;
                a2 = i7.a.a(str, "", "", 0, str3, "videos/mp4", this.y2, "", (List) null);
                eVar = this.u2;
            } else {
                int ipAddress = ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress();
                String format = String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
                String str4 = ".";
                if (type.equals("devicedata")) {
                    this.j2 = this.i2;
                }
                int lastIndexOf2 = this.j2.lastIndexOf(47);
                if (lastIndexOf2 > 1) {
                    str = this.j2.substring(lastIndexOf2 + 1);
                    str4 = this.j2.substring(0, lastIndexOf2);
                }
                String str5 = str;
                this.O2.b();
                this.O2.a(format, str4);
                String str6 = "http://" + format + ":8080/" + str5;
                this.w2 = str6;
                a2 = i7.a.a(str5, "", "", 0, str6, "videos/mp4", this.y2, "", (List) null);
                eVar = this.u2;
            }
            i7.a.c(0, true, a2, eVar, this.Y0);
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int R1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.n2;
    }

    private void R2() {
        try {
            SharedPreferences.Editor edit = this.r2.edit();
            this.s2 = edit;
            if (edit != null) {
                edit.putString("pref.using_playback_speed", "1x (Normal)");
                this.s2.apply();
            }
            this.Z.setText(getResources().getString(a7.j.n7) + " (1x)");
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int S1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo, int i2) {
        exoDownloadedPlayerTwo.n2 = i2;
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void S2() {
        /*
            r17 = this;
            r0 = r17
            r1 = 8
            java.lang.CharSequence[] r1 = new java.lang.CharSequence[r1]
            java.lang.String r2 = "0.25x"
            r3 = 0
            r1[r3] = r2
            java.lang.String r4 = "0.5x"
            r5 = 1
            r1[r5] = r4
            java.lang.String r6 = "0.75x"
            r7 = 2
            r1[r7] = r6
            java.lang.String r8 = "1x (Normal)"
            r9 = 3
            r1[r9] = r8
            java.lang.String r10 = "1.25x"
            r11 = 4
            r1[r11] = r10
            java.lang.String r12 = "1.5x"
            r13 = 5
            r1[r13] = r12
            java.lang.String r14 = "1.75x"
            r15 = 6
            r1[r15] = r14
            java.lang.String r3 = "2x"
            r16 = 7
            r1[r16] = r3
            androidx.appcompat.app.a$a r5 = new androidx.appcompat.app.a$a
            r5.<init>(r0)
            android.content.res.Resources r7 = r17.getResources()
            int r9 = a7.j.i5
            java.lang.String r7 = r7.getString(r9)
            r5.setTitle(r7)
            android.content.SharedPreferences r7 = r0.r2
            java.lang.String r9 = "pref.using_playback_speed"
            java.lang.String r7 = r7.getString(r9, r8)
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L51
        L4f:
            r3 = 0
            goto L88
        L51:
            boolean r2 = r7.equals(r4)
            if (r2 == 0) goto L59
            r3 = 1
            goto L88
        L59:
            boolean r2 = r7.equals(r6)
            if (r2 == 0) goto L61
            r3 = 2
            goto L88
        L61:
            boolean r2 = r7.equals(r8)
            if (r2 == 0) goto L69
            r3 = 3
            goto L88
        L69:
            boolean r2 = r7.equals(r10)
            if (r2 == 0) goto L71
            r3 = 4
            goto L88
        L71:
            boolean r2 = r7.equals(r12)
            if (r2 == 0) goto L79
            r3 = 5
            goto L88
        L79:
            boolean r2 = r7.equals(r14)
            if (r2 == 0) goto L81
            r3 = 6
            goto L88
        L81:
            boolean r2 = r7.equals(r3)
            if (r2 == 0) goto L4f
            r3 = 7
        L88:
            com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo$p r2 = new com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo$p
            r2.<init>()
            r5.l(r1, r3, r2)
            androidx.appcompat.app.a r1 = r5.create()
            r0.G2 = r1
            com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo$q r2 = new com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo$q
            r2.<init>()
            r1.setOnDismissListener(r2)
            androidx.appcompat.app.a r1 = r0.G2
            r1.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.S2():void");
    }

    public static /* synthetic */ FrameLayout T1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.m0;
    }

    private void T2(String str) {
        SharedPreferences.Editor edit = this.r2.edit();
        this.s2 = edit;
        if (edit != null) {
            edit.putString("pref.using_playback_speed", str);
            this.s2.apply();
        }
    }

    public static /* synthetic */ TextView U1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.h0;
    }

    private void U2() {
        try {
            if (this.x != null) {
                this.k2 = this.Y0.getSharedPreferences("currentSeekTime", 0);
                long currentPosition = this.x.getCurrentPosition();
                SharedPreferences sharedPreferences = this.Y0.getSharedPreferences("currentSeekTime", 0);
                this.k2 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.l2 = edit;
                edit.putString("currentSeekTime", String.valueOf(currentPosition));
                this.l2.apply();
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.x;
                if (nSTIJKPlayerEpisodes != null && currentPosition != -1 && currentPosition != 0) {
                    nSTIJKPlayerEpisodes.setCurrentPositionSeekbar(nSTIJKPlayerEpisodes.getCurrentPosition());
                    this.x.setProgress(true);
                    this.x.E2(true);
                }
                String str = this.c2;
                if (str == null || !str.equals("movies")) {
                    String str2 = this.c2;
                    if (str2 != null && str2.equals("series") && ((this.x == null || x7.a.f().a() == null || !this.F1.equals("m3u")) && x7.a.f() != null && x7.a.f().e() != null && currentPosition != -1 && currentPosition != 0)) {
                        ArrayList c2 = this.n1.c(x7.a.f().e());
                        this.E2 = c2;
                        if (c2 != null && c2.size() > 0) {
                            try {
                                int F2 = F2(this.J1, w.r0(x7.a.f().e()));
                                GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                                getEpisdoeDetailsCallback.setId(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getId());
                                getEpisdoeDetailsCallback.setTitle(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getTitle());
                                getEpisdoeDetailsCallback.setContainerExtension(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getContainerExtension());
                                getEpisdoeDetailsCallback.setAdded(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getAdded());
                                getEpisdoeDetailsCallback.setSeriesCover(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeriesCover());
                                getEpisdoeDetailsCallback.setCategoryId(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getCategoryId());
                                getEpisdoeDetailsCallback.setElapsed_time(String.valueOf(currentPosition));
                                getEpisdoeDetailsCallback.setSeriesId(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeriesId());
                                getEpisdoeDetailsCallback.setImage(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getImage());
                                getEpisdoeDetailsCallback.setMovieImage(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getMovieImage());
                                getEpisdoeDetailsCallback.setMainSeriesImg(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getMainSeriesImg());
                                getEpisdoeDetailsCallback.setSeriesNum(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeriesNum());
                                getEpisdoeDetailsCallback.setSeasonNumber(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeasonNumber());
                                getEpisdoeDetailsCallback.setEpisodeNum(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getEpisodeNumber());
                                getEpisdoeDetailsCallback.setSeriesName(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeriesName());
                                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.x;
                                getEpisdoeDetailsCallback.setDurationSec(nSTIJKPlayerEpisodes2 != null ? String.valueOf(nSTIJKPlayerEpisodes2.getDuration() / 1000) : ((GetEpisdoeDetailsCallback) this.J1.get(F2)).getDurationSec());
                                this.n1.b(((GetEpisdoeDetailsCallback) this.J1.get(F2)).getId());
                                this.n1.i(this.Y0, ((GetEpisdoeDetailsCallback) this.J1.get(F2)).getSeriesId());
                                this.n1.g(this.Y0, getEpisdoeDetailsCallback);
                            } catch (Exception unused) {
                            }
                        }
                    }
                } else {
                    W2(1);
                }
            }
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes3 = this.x;
            if (nSTIJKPlayerEpisodes3 != null) {
                if (nSTIJKPlayerEpisodes3.t2()) {
                    this.x.j2();
                } else {
                    this.x.e3();
                    this.x.C2(true);
                    this.x.a3();
                }
                IjkMediaPlayer.native_profileEnd();
            }
        } catch (Exception unused2) {
        }
    }

    public static /* synthetic */ SeekBar V1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.E;
    }

    public static /* synthetic */ FrameLayout W1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.l0;
    }

    private void W2(int i2) {
        long currentPosition;
        ArrayList G2;
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.x;
        if (nSTIJKPlayerEpisodes != null) {
            if (i2 == 0) {
                this.k2 = this.Y0.getSharedPreferences("currentSeekTime", 0);
                currentPosition = this.x.getCurrentPosition();
                SharedPreferences sharedPreferences = this.Y0.getSharedPreferences("currentSeekTime", 0);
                this.k2 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.l2 = edit;
                edit.putString("currentSeekTime", String.valueOf(currentPosition));
                this.l2.apply();
            } else {
                currentPosition = nSTIJKPlayerEpisodes.getCurrentPosition();
            }
            long j2 = currentPosition;
            new LiveStreamsDBModel();
            if (this.F1.equals("m3u")) {
                H2(String.valueOf(Uri.parse(this.j1)), SharepreferenceDBHandler.getUserID(this.Y0));
                return;
            }
            if (this.x == null || x7.a.f().k() == -1 || j2 == -1 || j2 == 0 || (G2 = G2(this.U1, SharepreferenceDBHandler.getUserID(this.Y0))) == null || G2.size() <= 0) {
                return;
            }
            try {
                int E2 = E2(this.I1, this.U1);
                B2(((LiveStreamsDBModel) this.I1.get(E2)).getStreamId());
                Z2(this.Y0, this.I1, E2, j2);
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ TextView X1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.i0;
    }

    private void X2() {
        TextView textView;
        StringBuilder sb;
        j3();
        if (x2() || this.P2 == null || this.l0.getVisibility() != 8) {
            return;
        }
        this.m2.removeCallbacksAndMessages((Object) null);
        String str = this.g2;
        if (str != null && !str.equals("")) {
            this.n2 -= 10000;
        }
        String str2 = this.c2;
        this.n2 = (str2 == null || !str2.equals("catch_up")) ? this.n2 - 10000 : this.n2 - 60000;
        if (this.n2 > 0) {
            textView = this.k0;
            sb = new StringBuilder();
            sb.append("+");
        } else {
            textView = this.k0;
            sb = new StringBuilder();
        }
        sb.append(this.n2 / 1000);
        sb.append("s");
        textView.setText(sb.toString());
        this.h0.setText("");
        this.h0.startAnimation(this.c1);
        this.h0.setVisibility(0);
        if (this.m0.getVisibility() == 8) {
            this.m0.startAnimation(this.b1);
            this.m0.setVisibility(0);
        } else {
            this.m0.startAnimation(this.c1);
        }
        this.m2.postDelayed(new n(), 1000L);
    }

    public static /* synthetic */ void Y1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo, String str) {
        exoDownloadedPlayerTwo.T2(str);
    }

    public static /* synthetic */ TextView Z1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.Z;
    }

    public static /* synthetic */ void a2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        exoDownloadedPlayerTwo.I2();
    }

    private void a3() {
        RecyclerView recyclerView = this.g0;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.Y0, 1);
            this.X0 = gridLayoutManager;
            this.g0.setLayoutManager(gridLayoutManager);
            this.g0.setItemAnimator(new androidx.recyclerview.widget.c());
        }
    }

    public static /* synthetic */ LinearLayout b2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.L;
    }

    private int b3() {
        int currentPosition = (int) this.Q2.getCurrentPosition();
        int duration = (int) this.Q2.getDuration();
        SeekBar seekBar = this.E;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 1000) / duration));
            }
            this.E.setSecondaryProgress(this.x.getBufferPercentage() * 10);
        }
        return currentPosition;
    }

    public static /* synthetic */ LinearLayout c2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.K;
    }

    private void c3() {
        this.D2 = new m();
    }

    public static /* synthetic */ LinearLayout d2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.O0;
    }

    private void d3() {
        this.e2.startAnimation(this.f1);
        this.e2.setVisibility(8);
        this.e0.startAnimation(this.e1);
        this.e0.setVisibility(0);
        List list = this.V0;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.v0.setText(getResources().getString(a7.j.J6) + " - " + ((GetEpisdoeDetailsCallback) this.V0.get(0)).getSeasonNumber());
        try {
            a3();
            q7.n nVar = new q7.n(this.Y0, null, null, null, "from_player", this.q2, this.g0);
            this.W0 = nVar;
            this.g0.setAdapter(nVar);
            this.g0.requestFocus();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ LinearLayout e2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.P0;
    }

    public static /* synthetic */ LinearLayout f2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.Q0;
    }

    public static /* synthetic */ ImageView g2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.C;
    }

    private void g3(int i2) {
        h3(getString(i2));
    }

    public static /* synthetic */ LinearLayout h2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.t0;
    }

    private void h3(String str) {
        Toast.makeText(getApplicationContext(), str, 1).show();
    }

    public static /* synthetic */ int i2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.c3;
    }

    private void i3() {
        try {
            if (this.R2 || !com.nst.iptvsmarterstvbox.view.demo.b.b0(this.Q2)) {
                return;
            }
            this.R2 = true;
            com.nst.iptvsmarterstvbox.view.demo.b.P(this.Q2, new r7.f(this)).show(getSupportFragmentManager(), (String) null);
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void j2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        exoDownloadedPlayerTwo.U2();
    }

    public static /* synthetic */ GestureDetector k2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.k;
    }

    public static /* synthetic */ int l2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.g;
    }

    public static /* synthetic */ TextView m2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.s0;
    }

    public static /* synthetic */ int n2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.b3();
    }

    private void n3() {
        j3();
        if (this.e2.getVisibility() == 0) {
            I2();
            return;
        }
        e3();
        v2(5000);
        w2(3000);
    }

    public static /* synthetic */ ImageView o2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.D;
    }

    private void o3() {
        LinearLayout linearLayout = this.p;
        if (linearLayout != null) {
            linearLayout.setClickable(true);
            this.p.setOnTouchListener(new e());
        }
    }

    public static /* synthetic */ Handler p2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.h;
    }

    private void p3() {
    }

    public static /* synthetic */ t2.a q2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.d2;
    }

    public static /* synthetic */ long r2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.n;
    }

    private void r3() {
        I1 i1 = this.Q2;
        if (i1 != null) {
            this.X2 = i1.E();
            this.Y2 = this.Q2.l0();
            this.Z2 = Math.max(0L, this.Q2.R());
        }
    }

    public static /* synthetic */ long s2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo, long j2) {
        exoDownloadedPlayerTwo.n = j2;
        return j2;
    }

    private void s3() {
        Z3.m mVar = this.U2;
        if (mVar != null) {
            this.V2 = mVar.K();
        }
    }

    public static /* synthetic */ AudioManager t2(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.f;
    }

    public static /* synthetic */ void u1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo, DialogInterface dialogInterface) {
        exoDownloadedPlayerTwo.M2(dialogInterface);
    }

    private void u2(Configuration configuration) {
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
        boolean z;
        View decorView = getWindow().getDecorView();
        if (configuration.orientation == 2) {
            decorView.setSystemUiVisibility(5894);
            nSTIJKPlayerEpisodes = this.x;
            z = false;
        } else {
            decorView.setSystemUiVisibility(256);
            nSTIJKPlayerEpisodes = this.x;
            z = true;
        }
        nSTIJKPlayerEpisodes.setAdjustViewBounds(z);
    }

    public static /* synthetic */ TextView v1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.O;
    }

    private void v2(int i2) {
        if (r3) {
            return;
        }
        this.P2.v = new a();
        PlayerView playerView = this.P2;
        playerView.u.postDelayed(playerView.v, i2);
    }

    public static /* synthetic */ IMediaPlayer w1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.m;
    }

    public static /* synthetic */ float x1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.o2;
    }

    public static /* synthetic */ float y1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo, float f2) {
        exoDownloadedPlayerTwo.o2 = f2;
        return f2;
    }

    public static boolean y2() {
        ProgressBar progressBar = p3;
        return progressBar != null && progressBar.getVisibility() == 0;
    }

    public static /* synthetic */ TextView z1(ExoDownloadedPlayerTwo exoDownloadedPlayerTwo) {
        return exoDownloadedPlayerTwo.r0;
    }

    public int E2(ArrayList arrayList, int i2) {
        return 7;
    }

    public int F2(List list, int i2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (w.r0(((GetEpisdoeDetailsCallback) list.get(i3)).getId()) == i2) {
                return i3;
            }
        }
        return 0;
    }

    public void J2() {
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.x;
        if (nSTIJKPlayerEpisodes != null) {
            nSTIJKPlayerEpisodes.p2();
            this.x.a3.removeMessages(1);
        }
        if (!r3 && this.e2.getVisibility() == 0) {
            this.e2.startAnimation(this.f1);
            if (this.p0.getVisibility() == 0) {
                this.p0.startAnimation(this.f1);
            }
            if (this.h0.getVisibility() == 0) {
                this.h0.startAnimation(this.f1);
            }
            if (this.t0.getVisibility() == 0) {
                this.t0.startAnimation(this.f1);
            }
            if (this.i0.getVisibility() == 0) {
                this.i0.startAnimation(this.f1);
            }
            if (this.q0.getVisibility() == 0) {
                this.q0.startAnimation(this.f1);
            }
            this.e2.setVisibility(8);
            if (this.p0.getVisibility() == 0) {
                this.p0.setVisibility(8);
            }
            if (this.h0.getVisibility() == 0) {
                this.h0.setVisibility(8);
            }
            if (this.t0.getVisibility() == 0) {
                this.t0.setVisibility(8);
            }
            if (this.i0.getVisibility() == 0) {
                this.i0.setVisibility(8);
            }
            if (this.q0.getVisibility() == 0) {
                this.q0.setVisibility(8);
            }
        }
        if (r3 || this.e2.getVisibility() != 0) {
            return;
        }
        this.e2.startAnimation(this.f1);
        if (this.p0.getVisibility() == 0) {
            this.p0.startAnimation(this.f1);
        }
        if (this.h0.getVisibility() == 0) {
            this.h0.startAnimation(this.f1);
        }
        if (this.t0.getVisibility() == 0) {
            this.t0.startAnimation(this.f1);
        }
        if (this.i0.getVisibility() == 0) {
            this.i0.startAnimation(this.f1);
        }
        if (this.q0.getVisibility() == 0) {
            this.q0.startAnimation(this.f1);
        }
        this.e2.setVisibility(8);
        if (this.p0.getVisibility() == 0) {
            this.p0.setVisibility(8);
        }
        if (this.h0.getVisibility() == 0) {
            this.h0.setVisibility(8);
        }
        if (this.t0.getVisibility() == 0) {
            this.t0.setVisibility(8);
        }
        if (this.i0.getVisibility() == 0) {
            this.i0.setVisibility(8);
        }
        if (this.q0.getVisibility() == 0) {
            this.q0.setVisibility(8);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0082 A[PHI: r17
      0x0082: PHI (r17v8 java.lang.String) = (r17v4 java.lang.String), (r17v5 java.lang.String), (r17v6 java.lang.String), (r17v9 java.lang.String) binds: [B:107:0x00a6, B:104:0x0099, B:101:0x008c, B:7:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean K2() {
        /*
            Method dump skipped, instructions count: 1022
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.K2():boolean");
    }

    public void N2() {
        if (this.x == null) {
            return;
        }
        w2(0);
        int i2 = Build.VERSION.SDK_INT;
        Rational rational = (this.x.G2() == 0 || this.x.F2() == 0) ? new Rational(this.x.getWidth(), this.x.getHeight()) : new Rational(this.x.G2(), this.x.F2());
        if (i2 >= 26) {
            try {
                p7.n.a(p7.m.a(this.K2, rational));
                r7.c.a(this, p7.n.a(this.K2));
            } catch (Exception unused) {
                p7.n.a(p7.m.a(this.K2, new Rational(this.x.getWidth(), this.x.getHeight())));
                r7.c.a(this, p7.n.a(this.K2));
            }
        }
    }

    public void V2() {
        if (this.Q2 != null) {
            s3();
            r3();
            this.Q2.release();
            this.Q2 = null;
            this.T2 = Collections.emptyList();
            this.U2 = null;
        }
    }

    public void Y2() {
        TextView textView;
        StringBuilder sb;
        j3();
        if (x2() || this.P2 == null || this.m0.getVisibility() != 8) {
            return;
        }
        this.m2.removeCallbacksAndMessages((Object) null);
        String str = this.g2;
        if (str != null && !str.equals("")) {
            this.n2 += 10000;
        }
        String str2 = this.c2;
        if (str2 == null || !str2.equals("catch_up")) {
            this.n2 += 10000;
        } else {
            this.n2 += 60000;
        }
        if (this.n2 > 0) {
            textView = this.j0;
            sb = new StringBuilder();
            sb.append("+");
        } else {
            textView = this.j0;
            sb = new StringBuilder();
        }
        sb.append(this.n2 / 1000);
        sb.append("s");
        textView.setText(sb.toString());
        this.i0.setText("");
        this.i0.startAnimation(this.c1);
        this.i0.setVisibility(0);
        if (this.l0.getVisibility() == 8) {
            this.l0.startAnimation(this.b1);
            this.l0.setVisibility(0);
        } else {
            this.l0.startAnimation(this.c1);
        }
        this.m2.postDelayed(new o(), 1000L);
    }

    public void Z2(Context context, ArrayList arrayList, int i2, long j2) {
        String num = ((LiveStreamsDBModel) arrayList.get(i2)).getNum();
        String name = ((LiveStreamsDBModel) arrayList.get(i2)).getName();
        String streamType = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamType();
        String streamId = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamId();
        String streamIcon = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamIcon();
        String epgChannelId = ((LiveStreamsDBModel) arrayList.get(i2)).getEpgChannelId();
        String added = ((LiveStreamsDBModel) arrayList.get(i2)).getAdded();
        String categoryId = ((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId();
        String customSid = ((LiveStreamsDBModel) arrayList.get(i2)).getCustomSid();
        String tvArchive = ((LiveStreamsDBModel) arrayList.get(i2)).getTvArchive();
        String directSource = ((LiveStreamsDBModel) arrayList.get(i2)).getDirectSource();
        String tvArchiveDuration = ((LiveStreamsDBModel) arrayList.get(i2)).getTvArchiveDuration();
        String typeName = ((LiveStreamsDBModel) arrayList.get(i2)).getTypeName();
        String categoryName = ((LiveStreamsDBModel) arrayList.get(i2)).getCategoryName();
        String seriesNo = ((LiveStreamsDBModel) arrayList.get(i2)).getSeriesNo();
        String live = ((LiveStreamsDBModel) arrayList.get(i2)).getLive();
        String contaiinerExtension = ((LiveStreamsDBModel) arrayList.get(i2)).getContaiinerExtension();
        String.valueOf(((LiveStreamsDBModel) arrayList.get(i2)).getMovieDuraton());
        String valueOf = String.valueOf(((LiveStreamsDBModel) arrayList.get(i2)).getRatingFromTen());
        String valueOf2 = String.valueOf(((LiveStreamsDBModel) arrayList.get(i2)).getRatingFromFive());
        PanelAvailableChannelsPojo panelAvailableChannelsPojo = new PanelAvailableChannelsPojo();
        panelAvailableChannelsPojo.setNum(Integer.valueOf(w.r0(num)));
        panelAvailableChannelsPojo.setName(name);
        panelAvailableChannelsPojo.setStreamType(streamType);
        panelAvailableChannelsPojo.setStreamId(streamId);
        panelAvailableChannelsPojo.setStreamIcon(streamIcon);
        panelAvailableChannelsPojo.setEpgChannelId(epgChannelId);
        panelAvailableChannelsPojo.setAdded(added);
        panelAvailableChannelsPojo.setCategoryId(categoryId);
        panelAvailableChannelsPojo.setCustomSid(customSid);
        panelAvailableChannelsPojo.setTvArchive(Integer.valueOf(w.r0(tvArchive)));
        panelAvailableChannelsPojo.setDirectSource(directSource);
        panelAvailableChannelsPojo.setTvArchiveDuration(tvArchiveDuration);
        panelAvailableChannelsPojo.setTypeName(typeName);
        panelAvailableChannelsPojo.setCategoryName(categoryName);
        panelAvailableChannelsPojo.setSeriesNo(seriesNo);
        panelAvailableChannelsPojo.setLive(live);
        panelAvailableChannelsPojo.setContainerExtension(contaiinerExtension);
        panelAvailableChannelsPojo.setUserIdReferred(SharepreferenceDBHandler.getUserID(context));
        long j3 = 0;
        try {
            panelAvailableChannelsPojo.setMovieElapsedTime(j2);
        } catch (Exception unused) {
            panelAvailableChannelsPojo.setMovieElapsedTime(0L);
        }
        int i3 = this.V1;
        if (i3 != 0) {
            try {
                panelAvailableChannelsPojo.setMovieDuration(i3);
            } catch (Exception unused2) {
            }
            panelAvailableChannelsPojo.setRatingFromTen(valueOf);
            panelAvailableChannelsPojo.setRatingFromFive(valueOf2);
            this.m1.addAllAvailableChannel(panelAvailableChannelsPojo);
        }
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.x;
        if (nSTIJKPlayerEpisodes != null) {
            int duration = nSTIJKPlayerEpisodes.getDuration() / 1000;
            this.V1 = duration;
            j3 = duration;
        }
        panelAvailableChannelsPojo.setMovieDuration(j3);
        panelAvailableChannelsPojo.setRatingFromTen(valueOf);
        panelAvailableChannelsPojo.setRatingFromFive(valueOf2);
        this.m1.addAllAvailableChannel(panelAvailableChannelsPojo);
    }

    public boolean canPause() {
        return false;
    }

    public boolean canSeekBackward() {
        return false;
    }

    public boolean canSeekForward() {
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.P2.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public void e3() {
        ImageView imageView;
        if (r3) {
            this.P2.M();
            this.P2.p(3000);
            return;
        }
        if (!x2() && this.f0.getVisibility() == 8 && this.e2.getVisibility() == 8) {
            this.e2.startAnimation(this.e1);
            this.e2.setVisibility(0);
            Log.i("calledHere", "hereForPlayPause");
            try {
                this.h0.setVisibility(0);
                this.i0.setVisibility(0);
                this.p0.setVisibility(0);
                this.q0.setVisibility(0);
                if (p3.getVisibility() == 0) {
                    this.t0.setVisibility(8);
                } else {
                    this.t0.setVisibility(0);
                }
                if (this.Q2.isPlaying()) {
                    this.D.setVisibility(0);
                    imageView = this.C;
                } else {
                    this.C.setVisibility(0);
                    imageView = this.D;
                }
                imageView.setVisibility(8);
            } catch (Exception unused) {
            }
        }
    }

    public void f3() {
        if (r3 || x2() || this.e2.getVisibility() != 8) {
            return;
        }
        this.e2.startAnimation(this.e1);
        this.e2.setVisibility(0);
        if (this.p0.getVisibility() == 8) {
            this.p0.startAnimation(this.e1);
            this.p0.setVisibility(0);
        }
        if (this.h0.getVisibility() == 8) {
            this.h0.startAnimation(this.e1);
            this.h0.setVisibility(0);
        }
        if (this.t0.getVisibility() == 8) {
            this.t0.startAnimation(this.e1);
            this.t0.setVisibility(0);
        }
        if (this.i0.getVisibility() == 8) {
            this.i0.startAnimation(this.e1);
            this.i0.setVisibility(0);
        }
        if (this.q0.getVisibility() == 8) {
            this.q0.startAnimation(this.e1);
            this.q0.setVisibility(0);
        }
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        return 0;
    }

    public int getCurrentPosition() {
        return 0;
    }

    public int getDuration() {
        return 0;
    }

    public boolean isPlaying() {
        return false;
    }

    public void j3() {
        Handler handler;
        if (r3 || x2() || (handler = this.P2.u) == null) {
            return;
        }
        handler.removeCallbacksAndMessages((Object) null);
    }

    public void k3() {
        Handler handler = this.F2;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        RelativeLayout relativeLayout = this.L0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public String l3(int i2) {
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = (i3 / 60) % 60;
        int i6 = i3 / 3600;
        try {
            this.i.setLength(0);
            return i6 > 0 ? this.j.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)}).toString() : this.j.format("%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)}).toString();
        } catch (Exception unused) {
            return this.j.format("%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)}).toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m3() {
        /*
            r6 = this;
            int r0 = r6.q
            r1 = 1
            int r0 = r0 + r1
            r6.q = r0
            java.lang.String r0 = "loginPrefs"
            r2 = 0
            android.content.SharedPreferences r0 = r6.getSharedPreferences(r0, r2)
            r6.s = r0
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r6.t = r0
            int r0 = r6.q
            int[] r3 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.m3
            int r4 = r3.length
            int r0 = r0 % r4
            r6.q = r0
            r0 = r3[r0]
            r6.r = r0
            int r0 = a7.f.X6
            android.view.View r0 = r6.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            int r3 = a7.f.n
            android.view.View r3 = r6.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "ratio:"
            r4.append(r5)
            int r5 = r6.r
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "aspectRatioIS"
            android.util.Log.i(r5, r4)
            com.google.android.exoplayer2.ui.PlayerView r4 = r6.P2
            int r5 = r6.r
            r4.setResizeMode(r5)
            int r4 = r6.q
            if (r4 != 0) goto L62
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.j2
        L5a:
            java.lang.String r1 = r1.getString(r4)
        L5e:
            r3.setText(r1)
            goto L8b
        L62:
            if (r4 != r1) goto L6b
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.i2
            goto L5a
        L6b:
            r1 = 2
            if (r4 != r1) goto L75
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.Q8
            goto L5a
        L75:
            r1 = 3
            if (r4 != r1) goto L7f
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.j3
            goto L5a
        L7f:
            r1 = 4
            if (r4 != r1) goto L85
            java.lang.String r1 = "16:9"
            goto L5e
        L85:
            r1 = 5
            if (r4 != r1) goto L8b
            java.lang.String r1 = "4:3"
            goto L5e
        L8b:
            android.content.SharedPreferences$Editor r1 = r6.t
            java.lang.String r3 = "aspect_ratio"
            int r4 = r6.q
            r1.putInt(r3, r4)
            android.content.SharedPreferences$Editor r1 = r6.t
            r1.apply()
            r0.setVisibility(r2)
            android.widget.LinearLayout r1 = r6.t0
            if (r1 == 0) goto Lad
            int r1 = r1.getVisibility()
            if (r1 != 0) goto Lad
            android.widget.LinearLayout r1 = r6.t0
            r2 = 8
            r1.setVisibility(r2)
        Lad:
            android.os.Handler r1 = r6.u
            r2 = 0
            r1.removeCallbacksAndMessages(r2)
            android.os.Handler r1 = r6.u
            com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo$f r2 = new com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo$f
            r2.<init>(r0)
            r3 = 3000(0xbb8, double:1.482E-320)
            r1.postDelayed(r2, r3)
            int r0 = r6.r
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.m3():int");
    }

    public void onBackPressed() {
        long j2;
        RelativeLayout relativeLayout;
        if (this.L0.getVisibility() == 0) {
            k3();
            return;
        }
        if (this.Q2 != null) {
            try {
                j2 = (int) (((int) r0.getDuration()) * ((this.E.getProgress() * 1.0d) / 1000.0d));
            } catch (Exception unused) {
                j2 = 0;
            }
            try {
                Log.i("movieCurrentPosition", "position:" + j2);
                ArrayList arrayList = new ArrayList();
                DownloadedDataModel downloadedDataModel = new DownloadedDataModel();
                downloadedDataModel.setMovieCurrentPosition(j2);
                arrayList.add(downloadedDataModel);
                this.e.updateCurrentPosition(arrayList, this.d);
                Log.i("calledHere", "hereISDATA");
            } catch (Exception unused2) {
            }
        }
        RelativeLayout relativeLayout2 = this.A0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.x;
            if (nSTIJKPlayerEpisodes != null) {
                nSTIJKPlayerEpisodes.m2();
                return;
            }
            return;
        }
        RelativeLayout relativeLayout3 = this.e0;
        if (relativeLayout3 == null || relativeLayout3.getVisibility() != 0) {
            j3();
            if (this.f0.getVisibility() != 0) {
                if (this.e2.getVisibility() != 0) {
                    m7.a.m0 = true;
                    if (this.q2.equals("mobile") && this.J2 && this.N2) {
                        try {
                            N2();
                            return;
                        } catch (Exception unused3) {
                        }
                    }
                    super/*androidx.activity.ComponentActivity*/.onBackPressed();
                    return;
                }
                if (this.e2.getVisibility() == 0) {
                    this.e2.startAnimation(this.f1);
                    if (this.p0.getVisibility() == 0) {
                        this.p0.startAnimation(this.f1);
                    }
                    if (this.h0.getVisibility() == 0) {
                        this.h0.startAnimation(this.f1);
                    }
                    if (this.t0.getVisibility() == 0) {
                        this.t0.startAnimation(this.f1);
                    }
                    if (this.i0.getVisibility() == 0) {
                        this.i0.startAnimation(this.f1);
                    }
                    if (this.q0.getVisibility() == 0) {
                        this.q0.startAnimation(this.f1);
                    }
                    this.e2.setVisibility(8);
                    if (this.p0.getVisibility() == 0) {
                        this.p0.setVisibility(8);
                    }
                    if (this.h0.getVisibility() == 0) {
                        this.h0.setVisibility(8);
                    }
                    if (this.t0.getVisibility() == 0) {
                        this.t0.setVisibility(8);
                    }
                    if (this.i0.getVisibility() == 0) {
                        this.i0.setVisibility(8);
                    }
                    if (this.q0.getVisibility() == 0) {
                        this.q0.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f0.startAnimation(this.h1);
            relativeLayout = this.f0;
        } else {
            this.e0.startAnimation(this.f1);
            relativeLayout = this.e0;
        }
        relativeLayout.setVisibility(8);
    }

    public void onClick(View view) {
        int i2;
        String str;
        int i3;
        int i4;
        StringBuilder sb;
        String str2;
        String valueOf;
        String str3;
        String valueOf2;
        String str4;
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
        ImageView imageView;
        int id = view.getId();
        if (id == a7.f.Cl) {
            Log.i("clickedSeekLeft", "leftSeekClicked");
            this.m2 = new Handler();
            X2();
            return;
        }
        if (id == a7.f.El) {
            this.m2 = new Handler();
            Y2();
            return;
        }
        if (id == a7.f.I5) {
            boolean equals = this.q2.equals("tv");
            j3();
            if (!equals) {
                f3();
                w2(5000);
                this.Q2.play();
                this.D.setVisibility(0);
                this.C.setVisibility(8);
                return;
            }
            e3();
            w2(5000);
            this.Q2.play();
            this.D.setVisibility(0);
            this.C.setVisibility(8);
            imageView = this.D;
        } else {
            if (id != a7.f.H5) {
                if (id == a7.f.c7 || id == a7.f.E4 || id == a7.f.I4 || id == a7.f.J4) {
                    onBackPressed();
                    onBackPressed();
                    return;
                }
                long j2 = 0;
                if (id != a7.f.U8) {
                    if (id == a7.f.x8) {
                        j3();
                        I2();
                        r3 = true;
                        this.P2.M();
                        this.P2.p(3000);
                        return;
                    }
                    if (id == a7.f.i6) {
                        j3();
                        r3 = false;
                        this.y0.startAnimation(this.a1);
                        this.y0.setVisibility(8);
                        f3();
                        w2(3000);
                        return;
                    }
                    if (id != a7.f.w7) {
                        if (id != a7.f.k4) {
                            if (id == a7.f.Z6 || id == a7.f.C4) {
                                j3();
                                I2();
                                i3();
                                return;
                            }
                            if (id == a7.f.n5) {
                                if (this.Q2 != null) {
                                    j3();
                                    I2();
                                    this.Q2.seekTo(0L);
                                    return;
                                }
                                return;
                            }
                            if (id == a7.f.f8) {
                                j3();
                                I2();
                                A2();
                                d3();
                                return;
                            }
                            if (id == a7.f.B7) {
                                j3();
                                v2(5000);
                                m3();
                                return;
                            } else {
                                if (id == a7.f.q9) {
                                    j3();
                                    v2(5000);
                                    k3();
                                    S2();
                                    return;
                                }
                                return;
                            }
                        }
                        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.x;
                        nSTIJKPlayerEpisodes2.seekTo(nSTIJKPlayerEpisodes2.getNewSeekPosition());
                    }
                    j3();
                    I2();
                    return;
                }
                String str5 = this.c2;
                if (str5 == null || str5.equals("movies")) {
                    return;
                }
                j3();
                I2();
                O2();
                SeekBar seekBar = this.E;
                if (seekBar != null) {
                    seekBar.setProgress(0);
                }
                int d2 = x7.a.f().d();
                String str6 = this.c2;
                str6.hashCode();
                if (str6.equals("series")) {
                    List list = this.J1;
                    if (list == null || list.size() <= 1 || d2 > this.J1.size() - 1) {
                        s3 = false;
                        i2 = 0;
                    } else {
                        this.Y1 = ((GetEpisdoeDetailsCallback) this.J1.get(d2)).getTitle();
                        this.b2 = ((GetEpisdoeDetailsCallback) this.J1.get(d2)).getContainerExtension();
                        this.Z1 = ((GetEpisdoeDetailsCallback) this.J1.get(d2)).getId();
                        this.y2 = ((GetEpisdoeDetailsCallback) this.J1.get(d2)).getMovieImage();
                        this.x2 = this.Y1;
                        this.A2 = w.r0(((GetEpisdoeDetailsCallback) this.J1.get(d2)).getElapsed_time());
                        this.z2 = String.valueOf(((GetEpisdoeDetailsCallback) this.J1.get(d2)).getSeasonNumber());
                        this.B2 = ((GetEpisdoeDetailsCallback) this.J1.get(d2)).getSeasonNumber().intValue();
                        i2 = (!((GetEpisdoeDetailsCallback) this.J1.get(d2)).getDurationSec().equals("") || (nSTIJKPlayerEpisodes = this.x) == null) ? w.q0(((GetEpisdoeDetailsCallback) this.J1.get(d2)).getDurationSec()) : nSTIJKPlayerEpisodes.getDuration() / 1000;
                        this.W1 = w.r0(this.Z1);
                        this.U1 = w.q0(this.Z1);
                        this.K1 = ((GetEpisdoeDetailsCallback) this.J1.get(d2)).getId();
                        this.u0.setText(this.Y1);
                        s3 = true;
                    }
                } else {
                    i2 = 0;
                }
                this.C1.clear();
                this.C1.apply();
                this.D1.clear();
                this.D1.apply();
                this.B1.clear();
                this.B1.apply();
                if (s3 && this.M1.booleanValue()) {
                    U2();
                    x7.a.f().x(this.K1);
                    int h2 = this.n1.h(this.K1, SharepreferenceDBHandler.getUserID(this.Y0));
                    if (h2 == 0) {
                        this.x.setProgress(false);
                        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes3 = this.x;
                        nSTIJKPlayerEpisodes3.e = 0;
                        nSTIJKPlayerEpisodes3.f = false;
                        if (!this.F1.equals("m3u") || (str4 = this.c2) == null || str4.equals("recording")) {
                            String str7 = this.c2;
                            if (str7 == null || !str7.equals("recording")) {
                                valueOf2 = String.valueOf(Uri.parse(this.G1 + this.U1 + "." + this.b2));
                            } else {
                                valueOf2 = this.G1;
                            }
                            this.w2 = valueOf2;
                        } else {
                            this.w2 = this.j1;
                            x7.a.f().r("m3u");
                        }
                    }
                    if (h2 > 0) {
                        if (this.n1.a(this.K1) > 0) {
                            try {
                                j2 = this.l1.gettimeElapsed(this.K1).longValue();
                            } catch (Exception unused) {
                            }
                            if (i2 == 0) {
                                i2 = w.r0(this.l1.getTotaltime(this.K1).toString());
                                this.V1 = i2;
                            }
                            if (this.x != null) {
                                x7.a.f().I(j2);
                                this.x.setProgress(true);
                                this.x.setCurrentPositionSeekbar((int) j2);
                                try {
                                    i3 = Math.round(w.r0(String.valueOf(j2)) / 1000.0f);
                                } catch (Exception unused2) {
                                    i3 = 0;
                                    i2 = 0;
                                }
                                try {
                                    i4 = Math.round((i3 / i2) * 100.0f);
                                } catch (Exception unused3) {
                                    i4 = 0;
                                }
                                if (i4 >= 99) {
                                    this.x.setCurrentPositionSeekbar(0);
                                }
                                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes4 = this.x;
                                nSTIJKPlayerEpisodes4.e = 0;
                                nSTIJKPlayerEpisodes4.f = false;
                                if (!this.F1.equals("m3u") || (str2 = this.c2) == null || str2.equals("recording")) {
                                    String str8 = this.c2;
                                    if (str8 == null || !str8.equals("recording")) {
                                        sb = new StringBuilder();
                                        sb.append(this.G1);
                                        sb.append(this.U1);
                                        sb.append(".");
                                        sb.append(this.b2);
                                        valueOf = String.valueOf(Uri.parse(sb.toString()));
                                        this.w2 = valueOf;
                                    }
                                    valueOf = this.G1;
                                    this.w2 = valueOf;
                                }
                                this.w2 = this.j1;
                                x7.a.f().r("m3u");
                            }
                        } else {
                            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes5 = this.x;
                            if (nSTIJKPlayerEpisodes5 != null) {
                                nSTIJKPlayerEpisodes5.setProgress(false);
                                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes6 = this.x;
                                nSTIJKPlayerEpisodes6.e = 0;
                                nSTIJKPlayerEpisodes6.f = false;
                                if (!this.F1.equals("m3u") || (str3 = this.c2) == null || str3.equals("recording")) {
                                    String str9 = this.c2;
                                    if (str9 == null || !str9.equals("recording")) {
                                        sb = new StringBuilder();
                                        sb.append(this.G1);
                                        sb.append(this.U1);
                                        sb.append(".");
                                        sb.append(this.b2);
                                        valueOf = String.valueOf(Uri.parse(sb.toString()));
                                        this.w2 = valueOf;
                                    }
                                    valueOf = this.G1;
                                    this.w2 = valueOf;
                                }
                                this.w2 = this.j1;
                                x7.a.f().r("m3u");
                            }
                        }
                    }
                    String str10 = this.c2;
                    if ((str10 == null || !str10.equals("movies")) && (str = this.c2) != null && str.equals("series")) {
                        x7.a.f().x(this.K1);
                        EpisodesUsingSinglton.getInstance().setEpisodeList(this.J1);
                        x7.a.f().G(w.q0(((GetEpisdoeDetailsCallback) this.J1.get(d2)).getId()));
                        x7.a.f().v(this.J1);
                    }
                    x7.a.f().w(d2);
                }
                String str11 = this.c2;
                str11.hashCode();
                if (str11.equals("series")) {
                    this.L1 = w.q0(((GetEpisdoeDetailsCallback) this.J1.get(d2)).getId());
                    SharedPreferences.Editor editor = this.z1;
                    if (editor != null) {
                        editor.putString("currentlyPlayingVideo", String.valueOf(((GetEpisdoeDetailsCallback) this.J1.get(d2)).getId()));
                        this.z1.apply();
                    }
                }
                SharedPreferences.Editor editor2 = this.A1;
                if (editor2 != null) {
                    editor2.putString("currentlyPlayingVideoPosition", String.valueOf(d2));
                    this.A1.apply();
                    return;
                }
                return;
            }
            boolean equals2 = this.q2.equals("tv");
            j3();
            if (!equals2) {
                f3();
                this.Q2.pause();
                this.D.setVisibility(8);
                this.C.setVisibility(0);
                return;
            }
            e3();
            this.Q2.pause();
            this.D.setVisibility(8);
            this.C.setVisibility(0);
            imageView = this.C;
        }
        imageView.requestFocus();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        u2(configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0695  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r20) {
        /*
            Method dump skipped, instructions count: 1746
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        TextView textView;
        super.onDestroy();
        try {
            if (this.f3 != null) {
                p0.a.b(this.Y0).e(this.f3);
            }
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.x;
            if (nSTIJKPlayerEpisodes != null && (textView = nSTIJKPlayerEpisodes.v) != null) {
                textView.performClick();
            }
        } catch (Exception e2) {
            Log.e("fsgd", "fdfh", e2);
        }
        try {
            U2();
        } catch (Exception unused) {
        }
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        boolean z = keyEvent.getRepeatCount() == 0;
        Log.i("keycodeIS", "keycode:19");
        if (i2 != 46) {
            if (i2 != 62) {
                if (i2 != 66) {
                    if (i2 != 79 && i2 != 85 && i2 != 86) {
                        if (i2 != 89) {
                            if (i2 != 90) {
                                if (i2 != 126 && i2 != 127) {
                                    if (i2 != 274) {
                                        if (i2 != 275) {
                                            switch (i2) {
                                                case 19:
                                                    if (this.f0.getVisibility() != 0 && this.e0.getVisibility() != 0 && this.A0.getVisibility() != 0 && this.A0.getVisibility() != 0) {
                                                        this.e2.getVisibility();
                                                    }
                                                    return true;
                                                case 20:
                                                    j3();
                                                    if (this.f0.getVisibility() != 0 && this.e0.getVisibility() != 0 && this.A0.getVisibility() != 0 && this.A0.getVisibility() != 0 && this.e2.getVisibility() == 8) {
                                                        this.e2.startAnimation(this.e1);
                                                        this.e2.setVisibility(0);
                                                        this.C.requestFocus();
                                                        this.D.requestFocus();
                                                    }
                                                    return true;
                                                case 21:
                                                    j3();
                                                    if (this.f0.getVisibility() == 0 || this.e0.getVisibility() == 0) {
                                                        return false;
                                                    }
                                                    if (this.A0.getVisibility() != 0 && this.A0.getVisibility() != 0) {
                                                        if (this.e2.getVisibility() == 8) {
                                                            this.e2.startAnimation(this.e1);
                                                            this.e2.setVisibility(0);
                                                            if (!this.E.isFocused()) {
                                                                this.E.requestFocus();
                                                            }
                                                        }
                                                        if (this.E.isFocused()) {
                                                            k3();
                                                        } else {
                                                            v2(5000);
                                                        }
                                                    }
                                                    return true;
                                                case 22:
                                                    j3();
                                                    if (this.f0.getVisibility() == 0 || this.e0.getVisibility() == 0) {
                                                        return false;
                                                    }
                                                    if (this.A0.getVisibility() != 0 && this.A0.getVisibility() != 0) {
                                                        if (this.e2.getVisibility() == 8) {
                                                            this.e2.startAnimation(this.e1);
                                                            this.e2.setVisibility(0);
                                                            if (!this.E.isFocused()) {
                                                                this.E.requestFocus();
                                                            }
                                                        }
                                                        if (this.E.isFocused()) {
                                                            k3();
                                                        } else {
                                                            v2(5000);
                                                        }
                                                    }
                                                    return true;
                                                case 23:
                                                    break;
                                                default:
                                                    return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
                                            }
                                        }
                                    }
                                }
                            }
                            try {
                                j3();
                                if (this.e2.getVisibility() == 8) {
                                    this.e2.startAnimation(this.e1);
                                    this.e2.setVisibility(0);
                                    if (!this.E.isFocused()) {
                                        this.E.requestFocus();
                                    }
                                }
                                v2(5000);
                                this.E.setProgress(this.E.getProgress() + 10);
                                this.x.H2(this.E.getProgress());
                            } catch (Exception unused) {
                            }
                            return true;
                        }
                        try {
                            j3();
                            if (this.e2.getVisibility() == 8) {
                                this.e2.startAnimation(this.e1);
                                this.e2.setVisibility(0);
                                if (!this.E.isFocused()) {
                                    this.E.requestFocus();
                                }
                            }
                            v2(5000);
                            this.E.setProgress(this.E.getProgress() - 10);
                            this.x.H2(this.E.getProgress());
                        } catch (Exception unused2) {
                        }
                        return true;
                    }
                }
                if (this.Q2 != null) {
                    if (this.f0.getVisibility() == 8) {
                        (this.Q2.isPlaying() ? this.D : this.C).performClick();
                    }
                } else if (p3.getVisibility() == 8) {
                    n3();
                }
                return true;
            }
            I1 i1 = this.Q2;
            if (i1 != null) {
                ((!z || i1.isPlaying()) ? this.D : this.C).performClick();
            }
        }
        return true;
    }

    public void onNewIntent(Intent intent) {
        super/*androidx.fragment.app.e*/.onNewIntent(intent);
        intent.putExtra("BUNDLE_KEY_NEW_INTENT_CALLED", true);
        setIntent(intent);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        if (k0.a <= 23) {
            PlayerView playerView = this.P2;
            if (playerView != null) {
                playerView.C();
            }
            V2();
        }
        String str = this.c2;
        if (str == null || !str.equals("movies")) {
            String str2 = this.c2;
            if (str2 != null && str2.equals("series")) {
                A2();
            }
        } else {
            W2(0);
        }
        getIntent().getAction();
        try {
            o4.b bVar = this.v2;
            if (bVar != null) {
                bVar.c().e(this.D2, o4.e.class);
            }
        } catch (Exception unused) {
        }
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        try {
            super/*androidx.activity.ComponentActivity*/.onPictureInPictureModeChanged(z, configuration);
            if (z) {
                m7.a.p1 = true;
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.x;
                if (nSTIJKPlayerEpisodes != null && nSTIJKPlayerEpisodes.h != null) {
                    nSTIJKPlayerEpisodes.setShowOrHideSubtitles(false);
                    this.x.h.setVisibility(8);
                }
                b bVar = new b();
                this.H2 = bVar;
                registerReceiver(bVar, new IntentFilter("media_control"));
                return;
            }
            unregisterReceiver(this.H2);
            this.I2 = false;
            this.H2 = null;
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.x;
            if (nSTIJKPlayerEpisodes2 != null && nSTIJKPlayerEpisodes2.h != null) {
                nSTIJKPlayerEpisodes2.setShowOrHideSubtitles(true);
                this.x.h.setVisibility(0);
                this.x.p2();
            }
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes3 = this.x;
            if (nSTIJKPlayerEpisodes3 != null) {
                nSTIJKPlayerEpisodes3.isPlaying();
            }
        } catch (Exception unused) {
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.e*/.onRequestPermissionsResult(i2, strArr, iArr);
        if (iArr.length == 0) {
            return;
        }
        if (iArr[0] == 0) {
            K2();
        } else {
            g3(a7.j.O7);
            finish();
        }
    }

    public void onResume() {
        Intent intent;
        AppOpsManager appOpsManager;
        super/*androidx.fragment.app.e*/.onResume();
        if (k0.a <= 23 || this.Q2 == null) {
            K2();
            PlayerView playerView = this.P2;
            if (playerView != null) {
                playerView.D();
            }
        }
        Context context = this.Y0;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("auto_start", 0);
            this.M2 = sharedPreferences;
            boolean z = sharedPreferences.getBoolean("picinpic", m7.a.u0);
            this.N2 = z;
            if (z && this.q2.equals("mobile")) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    this.K2 = v.a();
                }
                if (i2 >= 26) {
                    try {
                        if (getPackageManager().hasSystemFeature("android.software.picture_in_picture") && (appOpsManager = (AppOpsManager) this.Y0.getSystemService("appops")) != null && appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), this.Y0.getPackageName()) == 0) {
                            this.J2 = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        String str = this.c2;
        if (str == null || !str.equals("series")) {
            String str2 = this.c2;
            if (str2 != null && str2.equals("movies") && (intent = getIntent()) != null && intent.getBooleanExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false)) {
                intent.putExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false);
                setIntent(intent);
                if (getIntent().getIntExtra("OPENED_STREAM_ID", 0) != this.U1) {
                    this.I1 = VodAllCategoriesSingleton.getInstance().getvodList();
                }
            }
        } else {
            Intent intent2 = getIntent();
            if (intent2 != null && intent2.getBooleanExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false)) {
                intent2.putExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false);
                setIntent(intent2);
                if (getIntent().getIntExtra("OPENED_STREAM_ID", 0) != this.U1) {
                    this.J1 = EpisodesUsingSinglton.getInstance().getEpisodeList();
                }
            }
        }
        w.m(this.Y0);
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.x;
        if (nSTIJKPlayerEpisodes != null) {
            nSTIJKPlayerEpisodes.p2();
            if (this.p2) {
                q3 = false;
            }
        }
        o4.b bVar = this.v2;
        if (bVar != null) {
            bVar.c().a(this.D2, o4.e.class);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        s3();
        r3();
        bundle.putBundle("track_selector_parameters", this.V2.h());
        bundle.putBoolean("auto_play", this.X2);
        bundle.putInt("window", this.Y2);
        bundle.putLong("position", this.Z2);
    }

    public void onStart() {
        super.onStart();
        if (k0.a > 23) {
            K2();
            PlayerView playerView = this.P2;
            if (playerView != null) {
                playerView.D();
            }
        }
    }

    public void onStop() {
        super.onStop();
        if (k0.a > 23) {
            PlayerView playerView = this.P2;
            if (playerView != null) {
                playerView.C();
            }
            V2();
        }
        try {
            U2();
            if (this.q2.equals("mobile") && this.J2 && this.N2) {
                finishAndRemoveTask();
            }
        } catch (Exception unused) {
        }
    }

    public void onUserLeaveHint() {
        if (this.q2.equals("mobile") && this.J2 && this.N2 && !r7.e.a(this)) {
            try {
                N2();
                this.I2 = true;
            } catch (Exception unused) {
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        if (z) {
            u2(getResources().getConfiguration());
        }
    }

    public void pause() {
    }

    public void q3(int i2, String str, int i3, int i4) {
        try {
            if (this.q2.equals("mobile") && this.J2 && this.N2) {
                ArrayList arrayList = new ArrayList();
                PendingIntent broadcast = PendingIntent.getBroadcast(this, i4, new Intent("media_control").putExtra("control_type", i3), 67108864);
                Icon a2 = p7.p.a(this, i2);
                PendingIntent broadcast2 = PendingIntent.getBroadcast(this, 4, new Intent("media_control").putExtra("control_type", 4), 67108864);
                PendingIntent broadcast3 = PendingIntent.getBroadcast(this, 5, new Intent("media_control").putExtra("control_type", 5), 67108864);
                Icon a3 = p7.p.a(this, a7.e.s0);
                Icon a4 = p7.p.a(this, a7.e.q0);
                p7.u.a();
                arrayList.add(p7.t.a(a3, "rewind", "rewind", broadcast2));
                p7.u.a();
                arrayList.add(p7.t.a(a2, str, str, broadcast));
                p7.u.a();
                arrayList.add(p7.t.a(a4, "forward", "forward", broadcast3));
                p7.q.a(this.K2, arrayList);
                r7.d.a(this, p7.n.a(this.K2));
            }
        } catch (Exception unused) {
        }
    }

    public void seekTo(int i2) {
    }

    public void start() {
    }

    public void w2(int i2) {
        if (r3) {
            return;
        }
        this.P2.v = new d();
        PlayerView playerView = this.P2;
        playerView.u.postDelayed(playerView.v, i2);
    }

    public boolean x2() {
        RelativeLayout relativeLayout = this.A0;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public void z2() {
        this.X2 = true;
        this.Y2 = -1;
        this.Z2 = -9223372036854775807L;
    }

    public class m implements y {
        public m() {
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0033 A[Catch: Exception -> 0x001c, TryCatch #0 {Exception -> 0x001c, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x0033, B:13:0x0021, B:16:0x002b, B:19:0x003c, B:21:0x0044, B:22:0x006a, B:24:0x0091, B:26:0x009d, B:27:0x00aa), top: B:2:0x0005 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(o4.e r10) {
            /*
                r9 = this;
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.E1(r0, r10)
                java.lang.String r10 = ""
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                android.content.Context r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.J1(r0)     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getType(r0)     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto L1f
                java.lang.String r1 = "local"
                boolean r1 = r0.equals(r1)     // Catch: java.lang.Exception -> L1c
                if (r1 != 0) goto L33
                goto L1f
            L1c:
                r10 = move-exception
                goto Lc1
            L1f:
                if (r0 == 0) goto L29
                java.lang.String r1 = "devicedata"
                boolean r1 = r0.equals(r1)     // Catch: java.lang.Exception -> L1c
                if (r1 != 0) goto L33
            L29:
                if (r0 == 0) goto L3a
                java.lang.String r1 = "loadurl"
                boolean r1 = r0.equals(r1)     // Catch: java.lang.Exception -> L1c
                if (r1 == 0) goto L3a
            L33:
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r10 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.K1(r10)     // Catch: java.lang.Exception -> L1c
                goto Ldb
            L3a:
                if (r0 == 0) goto L6a
                java.lang.String r1 = "series"
                boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto L6a
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1c
                r10.<init>()     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                android.content.res.Resources r0 = r0.getResources()     // Catch: java.lang.Exception -> L1c
                int r1 = a7.j.J6     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Exception -> L1c
                r10.append(r0)     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = " - "
                r10.append(r0)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.L1(r0)     // Catch: java.lang.Exception -> L1c
                r10.append(r0)     // Catch: java.lang.Exception -> L1c
                java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> L1c
            L6a:
                r1 = r10
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r10 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.M1(r10)     // Catch: java.lang.Exception -> L1c
                java.lang.String r2 = ""
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r10 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r4 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.N1(r10)     // Catch: java.lang.Exception -> L1c
                java.lang.String r5 = "videos/mp4"
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r10 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r6 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.O1(r10)     // Catch: java.lang.Exception -> L1c
                java.lang.String r7 = ""
                r8 = 0
                r3 = 0
                com.google.android.gms.cast.MediaInfo r10 = i7.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.F1(r0)     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto Ldb
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.F1(r0)     // Catch: java.lang.Exception -> L1c
                int r0 = r0.getCurrentPosition()     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto Laa
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r1 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.F1(r0)     // Catch: java.lang.Exception -> L1c
                int r1 = r1.getCurrentPosition()     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.Q1(r0, r1)     // Catch: java.lang.Exception -> L1c
            Laa:
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                int r0 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.P1(r0)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r1 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                o4.e r1 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.D1(r1)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r2 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this     // Catch: java.lang.Exception -> L1c
                android.content.Context r2 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.J1(r2)     // Catch: java.lang.Exception -> L1c
                r3 = 1
                i7.a.c(r0, r3, r10, r1, r2)     // Catch: java.lang.Exception -> L1c
                goto Ldb
            Lc1:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onApplicationConnected: "
                r0.append(r1)
                java.lang.String r10 = r10.getMessage()
                r0.append(r10)
                java.lang.String r10 = r0.toString()
                java.lang.String r0 = "honey"
                android.util.Log.e(r0, r10)
            Ldb:
                com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo r10 = com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.this
                r10.invalidateOptionsMenu()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo.m.a(o4.e):void");
        }

        private void b() {
            ExoDownloadedPlayerTwo.this.invalidateOptionsMenu();
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSessionEnded(o4.e eVar, int i) {
            b();
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onSessionResumeFailed(o4.e eVar, int i) {
            b();
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onSessionResumed(o4.e eVar, boolean z) {
            a(eVar);
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onSessionResuming(o4.e eVar, String str) {
            Log.e("honey", "onSessionResuming");
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onSessionStartFailed(o4.e eVar, int i) {
            b();
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void onSessionStarted(o4.e eVar, String str) {
            a(eVar);
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onSessionStarting(o4.e eVar) {
            TextView H1;
            StringBuilder sb;
            String string;
            ExoDownloadedPlayerTwo.E1(ExoDownloadedPlayerTwo.this, eVar);
            if (ExoDownloadedPlayerTwo.D1(ExoDownloadedPlayerTwo.this) != null) {
                if (ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this) != null) {
                    ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this).p2();
                    ExoDownloadedPlayerTwo.F1(ExoDownloadedPlayerTwo.this).pause();
                }
                if (ExoDownloadedPlayerTwo.G1(ExoDownloadedPlayerTwo.this) != null) {
                    ExoDownloadedPlayerTwo.G1(ExoDownloadedPlayerTwo.this).setVisibility(0);
                }
                if (ExoDownloadedPlayerTwo.H1(ExoDownloadedPlayerTwo.this) != null) {
                    if (ExoDownloadedPlayerTwo.D1(ExoDownloadedPlayerTwo.this).q() == null || ExoDownloadedPlayerTwo.D1(ExoDownloadedPlayerTwo.this).q().J() == null) {
                        H1 = ExoDownloadedPlayerTwo.H1(ExoDownloadedPlayerTwo.this);
                        sb = new StringBuilder();
                        string = ExoDownloadedPlayerTwo.this.getResources().getString(a7.j.v0);
                    } else {
                        H1 = ExoDownloadedPlayerTwo.H1(ExoDownloadedPlayerTwo.this);
                        sb = new StringBuilder();
                        sb.append(ExoDownloadedPlayerTwo.this.getResources().getString(a7.j.w0));
                        sb.append(" ");
                        string = ExoDownloadedPlayerTwo.D1(ExoDownloadedPlayerTwo.this).q().J();
                    }
                    sb.append(string);
                    sb.append("...");
                    H1.setText(sb.toString());
                }
            }
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onSessionEnding(o4.e eVar) {
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void onSessionSuspended(o4.e eVar, int i) {
        }
    }
}
