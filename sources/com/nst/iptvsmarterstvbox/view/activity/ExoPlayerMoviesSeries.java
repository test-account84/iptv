package com.nst.iptvsmarterstvbox.view.activity;

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
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
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
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
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
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b4.o;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.gms.cast.MediaInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.EpisodesUsingSinglton;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.PanelAvailableChannelsPojo;
import com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.MaintanencePannelActivity;
import com.nst.iptvsmarterstvbox.sbpfunction.callbackclientreport.ClientFeedbackCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import d4.k0;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m7.w;
import o1.a;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p3.B;
import p3.u;
import p7.z0;
import q7.c0;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ExoPlayerMoviesSeries extends androidx.appcompat.app.b implements View.OnClickListener, MediaController.MediaPlayerControl, CompoundButton.OnCheckedChangeListener {
    public static ProgressBar U4;
    public static String W4;
    public static String X4;
    public static ProgressBar a5;
    public LinearLayout A;
    public ImageView A0;
    public CheckBox A1;
    public String A2;
    public String A3;
    public LinearLayout B;
    public ImageView B0;
    public CheckBox B1;
    public String B3;
    public LinearLayout C;
    public SeekBar C0;
    public CheckBox C1;
    public String C3;
    public LinearLayout D;
    public SeekBar D0;
    public EditText D1;
    public t2.a D3;
    public AlertDialog D4;
    public LinearLayout E;
    public SeekBar E0;
    public LinearLayout F;
    public RadioGroup F0;
    public LinearLayout G;
    public RadioGroup G0;
    public q7.n G2;
    public LinearLayout H;
    public RadioGroup H0;
    public RecyclerView.o H2;
    public LinearLayout I;
    public TextView I0;
    public Context I2;
    public SharedPreferences I3;
    public LinearLayout J;
    public TextView J0;
    public String J1;
    public Animation J2;
    public SharedPreferences.Editor J3;
    public LayoutInflater J4;
    public LinearLayout K;
    public TextView K0;
    public Animation K2;
    public View K4;
    public LinearLayout L;
    public TextView L0;
    public List L1;
    public Animation L2;
    public TextView L4;
    public LinearLayout M;
    public TextView M0;
    public JsonArray M1;
    public Animation M2;
    public ProgressBar M4;
    public LinearLayout N;
    public TextView N0;
    public String N1;
    public Animation N2;
    public SharedPreferences N3;
    public RecyclerView N4;
    public LinearLayout O;
    public TextView O0;
    public Animation O2;
    public SharedPreferences.Editor O3;
    public TextView O4;
    public LinearLayout P;
    public TextView P0;
    public SharedPreferences.Editor P1;
    public Animation P2;
    public LinearLayout Q;
    public TextView Q0;
    public LiveStreamDBHandler Q1;
    public Handler Q2;
    public TextView Q4;
    public LinearLayout R;
    public TextView R0;
    public SimpleDateFormat R1;
    public String R2;
    public View R4;
    public LinearLayout S;
    public TextView S0;
    public Date S1;
    public SharedPreferences S3;
    public LinearLayout T;
    public TextView T0;
    public DateFormat T1;
    public SeriesRecentWatchDatabase T2;
    public SharedPreferences.Editor T3;
    public LinearLayout U;
    public TextView U0;
    public String U1;
    public RecentWatchDBHandler U2;
    public SharedPreferences U3;
    public LinearLayout V;
    public TextView V0;
    public String V1;
    public u7.a V2;
    public o4.e V3;
    public LinearLayout W;
    public TextView W0;
    public String W1;
    public SharedPreferences W2;
    public o4.b W3;
    public LinearLayout X;
    public TextView X0;
    public String X1;
    public SharedPreferences X2;
    public LinearLayout Y;
    public TextView Y0;
    public SharedPreferences Y2;
    public LinearLayout Z;
    public TextView Z0;
    public SharedPreferences Z2;
    public TextView a1;
    public SharedPreferences a3;
    public TextView b1;
    public SharedPreferences b3;
    public TextView c1;
    public SharedPreferences c3;
    public TextView d1;
    public Handler d2;
    public SharedPreferences d3;
    public boolean e;
    public LinearLayout e0;
    public TextView e1;
    public SharedPreferences e3;
    public o4.y e4;
    public LinearLayout f;
    public LinearLayout f0;
    public TextView f1;
    public int f2;
    public SharedPreferences.Editor f3;
    public ArrayList f4;
    public Animation g;
    public RelativeLayout g0;
    public TextView g1;
    public SharedPreferences.Editor g3;
    public androidx.appcompat.app.a g4;
    public Animation h;
    public RelativeLayout h0;
    public TextView h1;
    public TextView h2;
    public SharedPreferences.Editor h3;
    public BroadcastReceiver h4;
    public z0 i;
    public RelativeLayout i0;
    public TextView i1;
    public PlayerView i2;
    public SharedPreferences.Editor i3;
    public String j;
    public RelativeLayout j0;
    public TextView j1;
    public ImageView j2;
    public SharedPreferences.Editor j3;
    public String k;
    public RelativeLayout k0;
    public TextView k1;
    public LinearLayout k2;
    public String k3;
    public PictureInPictureParams.Builder k4;
    public LinearLayout l;
    public RelativeLayout l0;
    public FrameLayout l1;
    public LinearLayout l2;
    public ArrayList l3;
    public ArrayList l4;
    public RelativeLayout m0;
    public FrameLayout m1;
    public TextView m2;
    public ArrayList m3;
    public SharedPreferences m4;
    public Handler n;
    public RelativeLayout n0;
    public FrameLayout n1;
    public String n2;
    public List n3;
    public RelativeLayout o0;
    public MediaRouteButton o1;
    public int o2;
    public boolean o4;
    public RelativeLayout p0;
    public RecyclerView p1;
    public AudioManager p2;
    public o.a p4;
    public ImageView q0;
    public CheckBox q1;
    public int q2;
    public String q3;
    public Z3.m q4;
    public I1 r;
    public ImageView r0;
    public CheckBox r1;
    public Handler r2;
    public m.d r4;
    public StringBuilder s;
    public ImageView s0;
    public CheckBox s1;
    public GestureDetector s2;
    public i0 s4;
    public Formatter t;
    public ImageView t0;
    public CheckBox t1;
    public boolean t4;
    public SharedPreferences u;
    public ImageView u0;
    public CheckBox u1;
    public int u4;
    public SharedPreferences.Editor v;
    public ImageView v0;
    public CheckBox v1;
    public long v4;
    public LinearLayout w;
    public ImageView w0;
    public CheckBox w1;
    public Animation w4;
    public LinearLayout x;
    public ImageView x0;
    public CheckBox x1;
    public LinearLayout y;
    public ImageView y0;
    public CheckBox y1;
    public Handler y2;
    public List y4;
    public LinearLayout z;
    public ImageView z0;
    public CheckBox z1;
    public String z2;
    public String z4;
    public static final int[] S4 = {0, 1, 2, 3, 4, 5};
    public static boolean T4 = false;
    public static boolean V4 = false;
    public static boolean Y4 = true;
    public static boolean Z4 = true;
    public final i7.c d = new i7.c(this);
    public String m = "mobile";
    public int o = 0;
    public boolean p = false;
    public boolean q = false;
    public String E1 = "Live";
    public String F1 = "";
    public String G1 = "";
    public String H1 = "";
    public String I1 = "";
    public String K1 = "";
    public String O1 = "";
    public String Y1 = "";
    public String Z1 = "movie";
    public String a2 = "";
    public String b2 = "";
    public String c2 = "";
    public boolean e2 = false;
    public ArrayList g2 = new ArrayList();
    public a.b t2 = null;
    public IMediaPlayer u2 = null;
    public long v2 = -1;
    public int w2 = 4;
    public int x2 = S4[0];
    public boolean B2 = false;
    public boolean C2 = false;
    public boolean D2 = false;
    public int E2 = 0;
    public List F2 = new ArrayList();
    public String S2 = "";
    public String o3 = "";
    public int p3 = -1;
    public Boolean r3 = Boolean.TRUE;
    public int s3 = -1;
    public String t3 = "";
    public int u3 = -1;
    public int v3 = 0;
    public String w3 = "";
    public int x3 = 0;
    public Thread y3 = null;
    public String z3 = "";
    public Handler E3 = new j(Looper.getMainLooper());
    public final SeekBar.OnSeekBarChangeListener F3 = new s();
    public NSTIJKPlayerEpisodes.M G3 = new w();
    public final SeekBar.OnSeekBarChangeListener H3 = new x();
    public String K3 = "";
    public String L3 = "";
    public String M3 = "";
    public int P3 = 0;
    public float Q3 = -1.0f;
    public final SeekBar.OnSeekBarChangeListener R3 = new y();
    public String X3 = "";
    public String Y3 = "";
    public String Z3 = "";
    public String a4 = "";
    public int b4 = 0;
    public int c4 = 0;
    public int d4 = 0;
    public boolean i4 = false;
    public boolean j4 = false;
    public boolean n4 = m7.a.u0;
    public int x4 = 5;
    public int A4 = 0;
    public int B4 = 0;
    public Handler C4 = new Handler();
    public String E4 = "";
    public Runnable F4 = new z();
    public BroadcastReceiver G4 = new C();
    public int H4 = 0;
    public boolean I4 = false;
    public int P4 = 0;

    public class A implements View.OnClickListener {
        public A() {
        }

        public void onClick(View view) {
            ExoPlayerMoviesSeries.this.l2.setVisibility(8);
        }
    }

    public class B implements View.OnClickListener {
        public B() {
        }

        public void onClick(View view) {
        }
    }

    public class C extends BroadcastReceiver {
        public C() {
        }

        public void onReceive(Context context, Intent intent) {
            MyApplication.E("Constant.PIP_MODE_SWITCH_USER : ");
            if ("pip_mode_switch_user".equals(intent.getAction())) {
                ExoPlayerMoviesSeries.this.finish();
            }
        }
    }

    public class D implements Runnable {
        public D() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Log.e("honey", "count: " + ExoPlayerMoviesSeries.k2(ExoPlayerMoviesSeries.this));
                    if (SharepreferenceDBHandler.getMaintanceModeState(ExoPlayerMoviesSeries.D1(ExoPlayerMoviesSeries.this))) {
                        ExoPlayerMoviesSeries.D1(ExoPlayerMoviesSeries.this).startActivity(new Intent(ExoPlayerMoviesSeries.D1(ExoPlayerMoviesSeries.this), MaintanencePannelActivity.class));
                    }
                    Thread.sleep(10000L);
                } catch (Exception e) {
                    Log.e("honey", "exc2: " + e.getMessage());
                } catch (InterruptedException e2) {
                    Log.e("honey", "exc1: " + e2.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class E implements View.OnFocusChangeListener {
        public final View a;

        public E(View view) {
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

        /* JADX WARN: Removed duplicated region for block: B:101:0x01ee  */
        /* JADX WARN: Removed duplicated region for block: B:334:0x060f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFocusChange(android.view.View r26, boolean r27) {
            /*
                Method dump skipped, instructions count: 2138
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.E.onFocusChange(android.view.View, boolean):void");
        }
    }

    public class F implements d4.p {
        public F() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Pair a(p1 p1Var) {
            String string = ExoPlayerMoviesSeries.this.getString(a7.j.M1);
            u.b cause = p1Var.getCause();
            if (cause instanceof u.b) {
                u.b bVar = cause;
                p3.t tVar = bVar.d;
                string = tVar == null ? bVar.getCause() instanceof B.c ? ExoPlayerMoviesSeries.this.getString(a7.j.R1) : bVar.c ? ExoPlayerMoviesSeries.this.getString(a7.j.P1, new Object[]{bVar.a}) : ExoPlayerMoviesSeries.this.getString(a7.j.O1, new Object[]{bVar.a}) : ExoPlayerMoviesSeries.this.getString(a7.j.N1, new Object[]{tVar.a});
            }
            return Pair.create(0, string);
        }

        public /* synthetic */ F(ExoPlayerMoviesSeries exoPlayerMoviesSeries, j jVar) {
            this();
        }
    }

    public class G implements t1.d {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                if (exoPlayerMoviesSeries.q) {
                    return;
                }
                exoPlayerMoviesSeries.o++;
                m7.w.P0(ExoPlayerMoviesSeries.D1(exoPlayerMoviesSeries), ExoPlayerMoviesSeries.D1(ExoPlayerMoviesSeries.this).getResources().getString(a7.j.g5) + " (" + ExoPlayerMoviesSeries.this.o + "/" + ExoPlayerMoviesSeries.i2(ExoPlayerMoviesSeries.this) + ")");
                ExoPlayerMoviesSeries.j2(ExoPlayerMoviesSeries.this);
                ExoPlayerMoviesSeries.this.U2();
            }
        }

        public G() {
        }

        private void C(String str) {
            ExoPlayerMoviesSeries.w1(ExoPlayerMoviesSeries.this).b(a7.f.G).e();
            ExoPlayerMoviesSeries.w1(ExoPlayerMoviesSeries.this).b(a7.f.K).c(str);
        }

        public /* synthetic */ void A(Q2.e eVar) {
            v1.a(this, eVar);
        }

        public /* synthetic */ void B(boolean z) {
            v1.j(this, z);
        }

        public void E(int i) {
            if (i == 2) {
                if (ExoPlayerMoviesSeries.y2()) {
                    return;
                }
                LinearLayout linearLayout = ExoPlayerMoviesSeries.this.J;
                if (linearLayout != null && linearLayout.getVisibility() == 0) {
                    ExoPlayerMoviesSeries.this.J.setVisibility(8);
                }
                ExoPlayerMoviesSeries.U4.setVisibility(0);
                return;
            }
            if (i == 4) {
                o();
                return;
            }
            if (i == 3) {
                if (ExoPlayerMoviesSeries.this.l.getVisibility() == 0) {
                    ExoPlayerMoviesSeries.this.J.setVisibility(0);
                }
                ExoPlayerMoviesSeries.this.o = 0;
                ExoPlayerMoviesSeries.U4.setVisibility(8);
                ExoPlayerMoviesSeries.this.r.play();
                LiveStreamDBHandler liveStreamDBHandler = ExoPlayerMoviesSeries.this.Q1;
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

        public /* synthetic */ void Y(Z3.z zVar) {
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

        public /* synthetic */ void j(e4.C c) {
            v1.E(this, c);
        }

        public /* synthetic */ void j0(boolean z, int i) {
            v1.n(this, z, i);
        }

        public /* synthetic */ void k(List list) {
            v1.d(this, list);
        }

        public void l0(p1 p1Var) {
            if (ExoPlayerMoviesSeries.this.q || p1Var.a == 1002) {
                return;
            }
            if (p1Var.toString().contains("com.google.android.exoplayer2.ext.ffmpeg.FfmpegDecoderException")) {
                m7.w.P0(ExoPlayerMoviesSeries.D1(ExoPlayerMoviesSeries.this), "Audio track issue found. Please change the audio track to none.");
            } else {
                o();
            }
        }

        public /* synthetic */ void m0(t1 t1Var, t1.c cVar) {
            v1.g(this, t1Var, cVar);
        }

        public /* synthetic */ void n0(boolean z) {
            v1.i(this, z);
        }

        public final void o() {
            ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
            if (exoPlayerMoviesSeries.o >= ExoPlayerMoviesSeries.i2(exoPlayerMoviesSeries)) {
                C(ExoPlayerMoviesSeries.D1(ExoPlayerMoviesSeries.this).getResources().getString(a7.j.b7));
                ExoPlayerMoviesSeries.j2(ExoPlayerMoviesSeries.this);
                ExoPlayerMoviesSeries.this.p = false;
                ExoPlayerMoviesSeries.U4.setVisibility(8);
                return;
            }
            ExoPlayerMoviesSeries exoPlayerMoviesSeries2 = ExoPlayerMoviesSeries.this;
            if (exoPlayerMoviesSeries2.q) {
                return;
            }
            exoPlayerMoviesSeries2.p = true;
            ExoPlayerMoviesSeries.q2(exoPlayerMoviesSeries2).postDelayed(new a(), 3000L);
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

        public /* synthetic */ G(ExoPlayerMoviesSeries exoPlayerMoviesSeries, j jVar) {
            this();
        }
    }

    public class H extends GestureDetector.SimpleOnGestureListener {
        public boolean a;

        public H() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
            if (exoPlayerMoviesSeries.r == null) {
                return true;
            }
            exoPlayerMoviesSeries.i2.getWidth();
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
            ExoPlayerMoviesSeries.h2(ExoPlayerMoviesSeries.this);
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ExoPlayerMoviesSeries exoPlayerMoviesSeries;
            String str;
            switch (i) {
                case 0:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "10";
                    break;
                case 1:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "12";
                    break;
                case 2:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "14";
                    break;
                case 3:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "16";
                    break;
                case 4:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "18";
                    break;
                case 5:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "20";
                    break;
                case 6:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "22";
                    break;
                case 7:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "24";
                    break;
                case 8:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "26";
                    break;
                case 9:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "28";
                    break;
                case 10:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "30";
                    break;
                case 11:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "32";
                    break;
                case 12:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "34";
                    break;
                case 13:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "36";
                    break;
                case 14:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "38";
                    break;
                case 15:
                    exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    str = "40";
                    break;
                default:
                    return;
            }
            ExoPlayerMoviesSeries.y1(exoPlayerMoviesSeries, str);
            ExoPlayerMoviesSeries.this.N0.setText(str);
            dialogInterface.cancel();
        }
    }

    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            TextView textView;
            String str;
            int currentPosition = ((int) ExoPlayerMoviesSeries.this.r.getCurrentPosition()) + ExoPlayerMoviesSeries.M1(ExoPlayerMoviesSeries.this);
            ExoPlayerMoviesSeries.this.r.seekTo(currentPosition > 0 ? ((int) r0.getCurrentPosition()) + ExoPlayerMoviesSeries.M1(ExoPlayerMoviesSeries.this) : 0L);
            ExoPlayerMoviesSeries.N1(ExoPlayerMoviesSeries.this, 0);
            ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
            exoPlayerMoviesSeries.n1.startAnimation(exoPlayerMoviesSeries.h);
            ExoPlayerMoviesSeries.this.n1.setVisibility(8);
            String str2 = ExoPlayerMoviesSeries.this.b2;
            if (str2 == null || !str2.equals("catch_up")) {
                textView = ExoPlayerMoviesSeries.this.P0;
                str = "-10s";
            } else {
                textView = ExoPlayerMoviesSeries.this.P0;
                str = "-60s";
            }
            textView.setText(str);
            if (ExoPlayerMoviesSeries.this.l.getVisibility() == 8) {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries2 = ExoPlayerMoviesSeries.this;
                exoPlayerMoviesSeries2.P0.startAnimation(exoPlayerMoviesSeries2.h);
                ExoPlayerMoviesSeries.this.P0.setVisibility(8);
            }
            ExoPlayerMoviesSeries.this.v2(1000);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            TextView textView;
            String str;
            ExoPlayerMoviesSeries.this.r.seekTo(((int) r0.getCurrentPosition()) + ExoPlayerMoviesSeries.M1(ExoPlayerMoviesSeries.this));
            ExoPlayerMoviesSeries.N1(ExoPlayerMoviesSeries.this, 0);
            ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
            exoPlayerMoviesSeries.m1.startAnimation(exoPlayerMoviesSeries.h);
            ExoPlayerMoviesSeries.this.m1.setVisibility(8);
            String str2 = ExoPlayerMoviesSeries.this.b2;
            if (str2 == null || !str2.equals("catch_up")) {
                textView = ExoPlayerMoviesSeries.this.Q0;
                str = "+10s";
            } else {
                textView = ExoPlayerMoviesSeries.this.Q0;
                str = "+60s";
            }
            textView.setText(str);
            if (ExoPlayerMoviesSeries.this.l.getVisibility() == 8) {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries2 = ExoPlayerMoviesSeries.this;
                exoPlayerMoviesSeries2.Q0.startAnimation(exoPlayerMoviesSeries2.h);
                ExoPlayerMoviesSeries.this.Q0.setVisibility(8);
            }
            ExoPlayerMoviesSeries.this.v2(1000);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            ExoPlayerMoviesSeries.O1(ExoPlayerMoviesSeries.this).dismiss();
        }
    }

    public class g implements p1.c {
        public g() {
        }

        public static /* synthetic */ void c(g gVar, int i, o7.a aVar) {
            gVar.h(i, aVar);
        }

        public static /* synthetic */ void d(g gVar) {
            gVar.f();
        }

        public static /* synthetic */ void e(g gVar, ArrayList arrayList) {
            gVar.g(arrayList);
        }

        public void a(JSONObject jSONObject) {
            ExoPlayerMoviesSeries exoPlayerMoviesSeries;
            JSONArray jSONArray;
            JSONArray jSONArray2;
            ExoPlayerMoviesSeries.Q1(ExoPlayerMoviesSeries.this, true);
            ExoPlayerMoviesSeries.R1(ExoPlayerMoviesSeries.this).setVisibility(0);
            try {
                HashSet hashSet = new HashSet();
                try {
                    JSONObject jSONObject2 = new JSONObject(String.valueOf(jSONObject));
                    if (!jSONObject2.has("data") || jSONObject2.isNull("data")) {
                        Toast.makeText(ExoPlayerMoviesSeries.D1(ExoPlayerMoviesSeries.this), "No subtitle found.. ", 0).show();
                        exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    } else {
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("data");
                        if (jSONArray3 != null && jSONArray3.length() > 0) {
                            for (int i = 0; i < jSONArray3.length(); i++) {
                                JSONObject jSONObject3 = jSONArray3.getJSONObject(i).getJSONObject("attributes");
                                String string = jSONObject3.getString("language");
                                Log.i("OutletName", jSONObject3.getString("language"));
                                String string2 = jSONObject3.getString("language");
                                if (string.equals("en")) {
                                    string2 = "English";
                                } else if (string.equals("ar")) {
                                    hashSet.add("ARABIC");
                                    string2 = "ARABIC";
                                } else if (string.equals("fr")) {
                                    hashSet.add("FRENCH");
                                    string2 = "FRENCH";
                                } else if (string.equals("nl")) {
                                    hashSet.add("DUTCH");
                                    string2 = "DUTCH";
                                } else if (string.equals("hr")) {
                                    string2 = "CROTIAN";
                                } else if (string.equals("pt-BR")) {
                                    string2 = "PORTUGESE (BRAZIL)";
                                } else if (string.equals("es")) {
                                    string2 = "SPANISH";
                                } else if (string.equals("pt-PT")) {
                                    string2 = "PORTUGESE";
                                } else if (string.equals("zh-CN")) {
                                    string2 = "CHINESE";
                                } else if (string.equals("ro")) {
                                    string2 = "ROMANIAN";
                                } else if (string.equals("cs")) {
                                    string2 = "CZECH";
                                } else if (string.equals("sv")) {
                                    string2 = "SWEDISH";
                                } else if (string.equals("el")) {
                                    string2 = "GREEK";
                                } else if (string.equals("it")) {
                                    string2 = "ITALIAN";
                                } else if (string.equals("fi")) {
                                    string2 = "Finnish";
                                } else if (string.equals("he")) {
                                    string2 = "Hebrew";
                                } else if (string.equals("tr")) {
                                    string2 = "Turkish";
                                } else if (string.equals("sr")) {
                                    string2 = "Serbian";
                                } else if (string.equals("hu")) {
                                    string2 = "Hungarian";
                                } else if (string.equals("ms")) {
                                    string2 = "Malay";
                                } else if (string.equals("bg")) {
                                    string2 = "Bulgarian";
                                } else if (string.equals("pl")) {
                                    string2 = "Polish";
                                } else if (string.equals("de")) {
                                    string2 = "German";
                                } else if (string.equals("vi")) {
                                    string2 = "Vietnamese";
                                } else if (string.equals("ja")) {
                                    string2 = "JAPANESE";
                                } else if (string.equals("ru")) {
                                    string2 = "RUSSIAN";
                                } else if (string.equals("bs")) {
                                    string2 = "BOSNIAN";
                                } else if (string.equals("it")) {
                                    string2 = "ITALIAN";
                                } else if (string.equals("zh-TW")) {
                                    string2 = "MANARIN CHINESE";
                                } else if (string.equals("tl")) {
                                    string2 = "TAGALOG";
                                } else if (string.equals("ko")) {
                                    string2 = "KOREAN";
                                } else if (string.equals("no")) {
                                    string2 = "NORWEGIAN";
                                } else if (string.equals("th")) {
                                    string2 = "THAI";
                                } else if (string.equals("da")) {
                                    string2 = "DANISH";
                                } else if (string.equals("uk")) {
                                    string2 = "UKRAINIAN";
                                }
                                jSONObject3.getString("release");
                                int i2 = jSONObject3.getInt("download_count");
                                try {
                                    jSONArray = jSONObject3.getJSONArray("files");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    jSONArray = null;
                                }
                                if (jSONArray != null) {
                                    int i3 = 0;
                                    while (i3 < jSONArray.length()) {
                                        JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                                        if (jSONObject4 != null) {
                                            try {
                                                jSONArray2 = jSONArray;
                                                try {
                                                    ExoPlayerMoviesSeries.this.o2 = jSONObject4.getInt("file_id");
                                                } catch (Exception unused) {
                                                }
                                            } catch (Exception unused2) {
                                            }
                                        } else {
                                            jSONArray2 = jSONArray;
                                        }
                                        i3++;
                                        jSONArray = jSONArray2;
                                    }
                                    o7.a aVar = new o7.a();
                                    aVar.e(string2);
                                    aVar.f(ExoPlayerMoviesSeries.this.o2);
                                    aVar.d(i2);
                                    aVar.g(ExoPlayerMoviesSeries.this.o2);
                                    ExoPlayerMoviesSeries.S1(ExoPlayerMoviesSeries.this).add(aVar);
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            int i4 = -1;
                            for (int i5 = 0; i5 < ExoPlayerMoviesSeries.S1(ExoPlayerMoviesSeries.this).size(); i5++) {
                                if (arrayList.contains(((o7.a) ExoPlayerMoviesSeries.S1(ExoPlayerMoviesSeries.this).get(i5)).b())) {
                                    int i6 = 0;
                                    while (true) {
                                        if (i6 >= arrayList.size()) {
                                            break;
                                        }
                                        if (((String) arrayList.get(i6)).equals(((o7.a) ExoPlayerMoviesSeries.S1(ExoPlayerMoviesSeries.this).get(i6)).b())) {
                                            i4 = i6;
                                            break;
                                        }
                                        i6++;
                                    }
                                    if (((o7.a) ExoPlayerMoviesSeries.S1(ExoPlayerMoviesSeries.this).get(i5)).a() > ((Integer) arrayList2.get(i4)).intValue()) {
                                        arrayList3.remove(i4);
                                        arrayList3.add(i4, (o7.a) ExoPlayerMoviesSeries.S1(ExoPlayerMoviesSeries.this).get(i5));
                                    }
                                } else {
                                    arrayList.add(((o7.a) ExoPlayerMoviesSeries.S1(ExoPlayerMoviesSeries.this).get(i5)).b());
                                    arrayList2.add(Integer.valueOf(((o7.a) ExoPlayerMoviesSeries.S1(ExoPlayerMoviesSeries.this).get(i5)).a()));
                                    arrayList3.add((o7.a) ExoPlayerMoviesSeries.S1(ExoPlayerMoviesSeries.this).get(i5));
                                }
                            }
                            c0 c0Var = new c0(ExoPlayerMoviesSeries.this.getApplicationContext(), arrayList3);
                            ExoPlayerMoviesSeries.U1(ExoPlayerMoviesSeries.this).setLayoutManager(new LinearLayoutManager(ExoPlayerMoviesSeries.this.getApplicationContext()));
                            ExoPlayerMoviesSeries.U1(ExoPlayerMoviesSeries.this).setAdapter(c0Var);
                            ExoPlayerMoviesSeries.U1(ExoPlayerMoviesSeries.this).setVisibility(8);
                            new Handler(Looper.getMainLooper()).postDelayed(new p7.x(this, arrayList3), 2000L);
                            c0Var.n0(new p7.y(this));
                            return;
                        }
                        Toast.makeText(ExoPlayerMoviesSeries.D1(ExoPlayerMoviesSeries.this), "No subtitle found.. ", 0).show();
                        exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                    }
                    ExoPlayerMoviesSeries.V1(exoPlayerMoviesSeries, "");
                } catch (JSONException e2) {
                    ExoPlayerMoviesSeries.V1(ExoPlayerMoviesSeries.this, String.valueOf(e2));
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                ExoPlayerMoviesSeries.V1(ExoPlayerMoviesSeries.this, "");
                e3.printStackTrace();
            }
        }

        public void b(m1.a aVar) {
            if (ExoPlayerMoviesSeries.P1(ExoPlayerMoviesSeries.this)) {
                return;
            }
            ExoPlayerMoviesSeries.X1(ExoPlayerMoviesSeries.this);
            if (ExoPlayerMoviesSeries.W1(ExoPlayerMoviesSeries.this) <= 10) {
                new Handler(Looper.getMainLooper()).postDelayed(new p7.z(this), 500L);
            } else {
                ExoPlayerMoviesSeries.V1(ExoPlayerMoviesSeries.this, String.valueOf(aVar));
            }
        }

        public final /* synthetic */ void f() {
            ExoPlayerMoviesSeries.Y1(ExoPlayerMoviesSeries.this, false);
        }

        public final /* synthetic */ void g(ArrayList arrayList) {
            ExoPlayerMoviesSeries.U1(ExoPlayerMoviesSeries.this).setVisibility(0);
            if (arrayList.size() > 0) {
                ExoPlayerMoviesSeries.R1(ExoPlayerMoviesSeries.this).setVisibility(8);
                ExoPlayerMoviesSeries.b2(ExoPlayerMoviesSeries.this).setVisibility(8);
            }
            ExoPlayerMoviesSeries.a5.setVisibility(8);
        }

        public final /* synthetic */ void h(int i, o7.a aVar) {
            try {
                ExoPlayerMoviesSeries.this.o2 = aVar.c();
                ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                ExoPlayerMoviesSeries.a2(exoPlayerMoviesSeries, exoPlayerMoviesSeries.getSharedPreferences("allowedFormatsubtitle", 0));
                String string = ExoPlayerMoviesSeries.Z1(ExoPlayerMoviesSeries.this).getString("allowedFormatsubtitle", "vip");
                ExoPlayerMoviesSeries.a5.setVisibility(0);
                ExoPlayerMoviesSeries.O1(ExoPlayerMoviesSeries.this).dismiss();
                if (string.equals("default")) {
                    Toast.makeText(ExoPlayerMoviesSeries.this, "Please wait", 0).show();
                    ExoPlayerMoviesSeries.this.C2(true);
                } else {
                    Toast.makeText(ExoPlayerMoviesSeries.this, "Please wait", 0).show();
                    ExoPlayerMoviesSeries.this.V3(true);
                }
            } catch (Exception e) {
                ExoPlayerMoviesSeries.V1(ExoPlayerMoviesSeries.this, String.valueOf(e));
                e.printStackTrace();
            }
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            ExoPlayerMoviesSeries.this.C2(false);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            ExoPlayerMoviesSeries.this.V3(false);
        }
    }

    public class j extends Handler {
        public j(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ExoPlayerMoviesSeries.J1(ExoPlayerMoviesSeries.this);
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                ExoPlayerMoviesSeries.w1(ExoPlayerMoviesSeries.this).b(a7.f.U).a();
                ExoPlayerMoviesSeries.w1(ExoPlayerMoviesSeries.this).b(a7.f.v).a();
                ExoPlayerMoviesSeries.w1(ExoPlayerMoviesSeries.this).b(a7.f.y).a();
                return;
            }
            if (ExoPlayerMoviesSeries.x1(ExoPlayerMoviesSeries.this) >= 0) {
                ExoPlayerMoviesSeries.this.r.seekTo((int) ExoPlayerMoviesSeries.x1(r5));
                ExoPlayerMoviesSeries.z1(ExoPlayerMoviesSeries.this, -1L);
            }
        }
    }

    public class k implements View.OnFocusChangeListener {
        public View a;

        public k(View view) {
            this.a = view;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null) {
                    return;
                }
                this.a.getTag().equals("iv_cross");
                return;
            }
            View view3 = this.a;
            if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("iv_cross")) {
                return;
            }
            view.setBackground(ExoPlayerMoviesSeries.this.getResources().getDrawable(a7.e.L));
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            I1 i1;
            float f;
            switch (i) {
                case 0:
                    ExoPlayerMoviesSeries.c2(ExoPlayerMoviesSeries.this, "0.25x");
                    ExoPlayerMoviesSeries.this.O0.setText(ExoPlayerMoviesSeries.this.getResources().getString(a7.j.n7) + " (0.25x)");
                    i1 = ExoPlayerMoviesSeries.this.r;
                    f = 0.25f;
                    break;
                case 1:
                    ExoPlayerMoviesSeries.c2(ExoPlayerMoviesSeries.this, "0.5x");
                    ExoPlayerMoviesSeries.this.O0.setText(ExoPlayerMoviesSeries.this.getResources().getString(a7.j.n7) + " (0.5x)");
                    i1 = ExoPlayerMoviesSeries.this.r;
                    f = 0.5f;
                    break;
                case 2:
                    ExoPlayerMoviesSeries.c2(ExoPlayerMoviesSeries.this, "0.75x");
                    ExoPlayerMoviesSeries.this.O0.setText(ExoPlayerMoviesSeries.this.getResources().getString(a7.j.n7) + " (0.75x)");
                    i1 = ExoPlayerMoviesSeries.this.r;
                    f = 0.75f;
                    break;
                case 3:
                    ExoPlayerMoviesSeries.c2(ExoPlayerMoviesSeries.this, "1x (Normal)");
                    ExoPlayerMoviesSeries.this.O0.setText(ExoPlayerMoviesSeries.this.getResources().getString(a7.j.n7) + " (1x)");
                    i1 = ExoPlayerMoviesSeries.this.r;
                    f = 1.0f;
                    break;
                case 4:
                    ExoPlayerMoviesSeries.c2(ExoPlayerMoviesSeries.this, "1.25x");
                    ExoPlayerMoviesSeries.this.O0.setText(ExoPlayerMoviesSeries.this.getResources().getString(a7.j.n7) + " (1.25x)");
                    i1 = ExoPlayerMoviesSeries.this.r;
                    f = 1.25f;
                    break;
                case 5:
                    ExoPlayerMoviesSeries.c2(ExoPlayerMoviesSeries.this, "1.5x");
                    ExoPlayerMoviesSeries.this.O0.setText(ExoPlayerMoviesSeries.this.getResources().getString(a7.j.n7) + " (1.5x)");
                    i1 = ExoPlayerMoviesSeries.this.r;
                    f = 1.5f;
                    break;
                case 6:
                    ExoPlayerMoviesSeries.c2(ExoPlayerMoviesSeries.this, "1.75x");
                    ExoPlayerMoviesSeries.this.O0.setText(ExoPlayerMoviesSeries.this.getResources().getString(a7.j.n7) + " (1.75x)");
                    i1 = ExoPlayerMoviesSeries.this.r;
                    f = 1.75f;
                    break;
                case 7:
                    ExoPlayerMoviesSeries.c2(ExoPlayerMoviesSeries.this, "2x");
                    ExoPlayerMoviesSeries.this.O0.setText(ExoPlayerMoviesSeries.this.getResources().getString(a7.j.n7) + " (2x)");
                    i1 = ExoPlayerMoviesSeries.this.r;
                    f = 2.0f;
                    break;
                default:
                    return;
            }
            i1.x0(f);
            dialogInterface.cancel();
        }
    }

    public class m implements DialogInterface.OnDismissListener {
        public m() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
            if (exoPlayerMoviesSeries.r != null) {
                ExoPlayerMoviesSeries.C1(exoPlayerMoviesSeries);
            }
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public void run() {
            ExoPlayerMoviesSeries.d2(ExoPlayerMoviesSeries.this);
        }
    }

    public class o extends BroadcastReceiver {
        public o() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"media_control".equals(intent.getAction())) {
                return;
            }
            int intExtra = intent.getIntExtra("control_type", 0);
            if (intExtra != 1) {
                if (intExtra == 2 && Build.VERSION.SDK_INT >= 26) {
                    ExoPlayerMoviesSeries.this.S3(a7.e.r0, "play", 1, 1);
                    return;
                }
                return;
            }
            ExoPlayerMoviesSeries.e2(ExoPlayerMoviesSeries.this);
            if (Build.VERSION.SDK_INT >= 26) {
                ExoPlayerMoviesSeries.this.S3(a7.e.x0, "pause", 2, 2);
            }
        }
    }

    public class p implements Runnable {
        public p() {
        }

        public void run() {
            ExoPlayerMoviesSeries.this.S2();
        }
    }

    public class q implements View.OnTouchListener {
        public q() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent != null && ExoPlayerMoviesSeries.f2(ExoPlayerMoviesSeries.this).onTouchEvent(motionEvent);
        }
    }

    public class r implements Runnable {
        public final /* synthetic */ LinearLayout a;

        public r(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        public void run() {
            LinearLayout linearLayout;
            this.a.setVisibility(8);
            if (ExoPlayerMoviesSeries.this.l.getVisibility() != 0 || (linearLayout = ExoPlayerMoviesSeries.this.J) == null) {
                return;
            }
            linearLayout.setVisibility(0);
        }
    }

    public class s implements SeekBar.OnSeekBarChangeListener {
        public s() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                ExoPlayerMoviesSeries.w1(ExoPlayerMoviesSeries.this).b(a7.f.G).a();
                ExoPlayerMoviesSeries.z1(ExoPlayerMoviesSeries.this, (int) (((int) r5.r.getDuration()) * ((i * 1.0d) / 1000.0d)));
                ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                exoPlayerMoviesSeries.e = true;
                exoPlayerMoviesSeries.r.seekTo(ExoPlayerMoviesSeries.x1(exoPlayerMoviesSeries));
                ExoPlayerMoviesSeries.this.E3();
                ExoPlayerMoviesSeries.this.v2(3000);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
            exoPlayerMoviesSeries.e = true;
            ExoPlayerMoviesSeries.T1(exoPlayerMoviesSeries).setStreamMute(3, true);
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (ExoPlayerMoviesSeries.g2(ExoPlayerMoviesSeries.this) == null) {
                return;
            }
            ExoPlayerMoviesSeries.this.E3();
            ExoPlayerMoviesSeries.this.v2(3000);
            ExoPlayerMoviesSeries.T1(ExoPlayerMoviesSeries.this).setStreamMute(3, false);
            ExoPlayerMoviesSeries.this.e = false;
        }
    }

    public class t implements Callback {
        public t() {
        }

        public void onFailure(Call call, Throwable th) {
            Toast.makeText(ExoPlayerMoviesSeries.this, "Something went Wrong Report not Submited", 0).show();
            Log.e("onFailure", th.getMessage().toString());
        }

        public void onResponse(Call call, Response response) {
            ExoPlayerMoviesSeries exoPlayerMoviesSeries;
            String message;
            Toast makeText;
            if (response != null) {
                if (response.body() == null || !response.isSuccessful()) {
                    if (response.message() != null && !response.message().equals("")) {
                        exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                        message = response.message();
                        makeText = Toast.makeText(exoPlayerMoviesSeries, message, 0);
                    }
                    makeText = Toast.makeText(ExoPlayerMoviesSeries.this, "Something went Wrong Report not Submited", 0);
                } else {
                    if (((ClientFeedbackCallback) response.body()).a() != null && ((ClientFeedbackCallback) response.body()).a().equalsIgnoreCase("success")) {
                        exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                        message = "Reported Successfully";
                        makeText = Toast.makeText(exoPlayerMoviesSeries, message, 0);
                    }
                    makeText = Toast.makeText(ExoPlayerMoviesSeries.this, "Something went Wrong Report not Submited", 0);
                }
                makeText.show();
            }
        }
    }

    public class u implements View.OnClickListener {
        public final /* synthetic */ Dialog a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ ArrayList g;
        public final /* synthetic */ String h;
        public final /* synthetic */ List i;
        public final /* synthetic */ String j;

        public u(Dialog dialog, int i, int i2, int i3, int i4, ArrayList arrayList, String str, List list, String str2) {
            this.a = dialog;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = arrayList;
            this.h = str;
            this.i = list;
            this.j = str2;
        }

        public void onClick(View view) {
            ExoPlayerMoviesSeries.this.l.setVisibility(0);
            this.a.dismiss();
            ExoPlayerMoviesSeries.l2(ExoPlayerMoviesSeries.this, this.c, this.d, this.e, this.f, this.g, this.h, this.i, null, false, this.j);
        }
    }

    public class v implements View.OnClickListener {
        public final /* synthetic */ Dialog a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ ArrayList g;
        public final /* synthetic */ String h;
        public final /* synthetic */ List i;
        public final /* synthetic */ String j;

        public v(Dialog dialog, int i, int i2, int i3, int i4, ArrayList arrayList, String str, List list, String str2) {
            this.a = dialog;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = arrayList;
            this.h = str;
            this.i = list;
            this.j = str2;
        }

        public void onClick(View view) {
            ExoPlayerMoviesSeries.this.l.setVisibility(0);
            this.a.dismiss();
            ExoPlayerMoviesSeries.l2(ExoPlayerMoviesSeries.this, this.c, this.d, this.e, this.f, this.g, this.h, this.i, null, false, this.j);
        }
    }

    public class w extends NSTIJKPlayerEpisodes.M {
        public w() {
        }

        public void a() {
            ExoPlayerMoviesSeries.this.S3(a7.e.x0, "pause", 2, 2);
        }

        public void b() {
            ExoPlayerMoviesSeries.this.S3(a7.e.r0, "play", 1, 1);
        }
    }

    public class x implements SeekBar.OnSeekBarChangeListener {
        public x() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView textView;
            Drawable drawable;
            if (ExoPlayerMoviesSeries.T1(ExoPlayerMoviesSeries.this) != null) {
                try {
                    ExoPlayerMoviesSeries.T1(ExoPlayerMoviesSeries.this).setStreamVolume(3, i, 0);
                    int streamVolume = (int) ((ExoPlayerMoviesSeries.T1(ExoPlayerMoviesSeries.this).getStreamVolume(3) / ExoPlayerMoviesSeries.m2(ExoPlayerMoviesSeries.this)) * 100.0f);
                    if (streamVolume == 0 || streamVolume < 0) {
                        ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                        textView = exoPlayerMoviesSeries.U0;
                        drawable = exoPlayerMoviesSeries.getResources().getDrawable(a7.e.w0);
                    } else if (streamVolume < 40) {
                        ExoPlayerMoviesSeries exoPlayerMoviesSeries2 = ExoPlayerMoviesSeries.this;
                        textView = exoPlayerMoviesSeries2.U0;
                        drawable = exoPlayerMoviesSeries2.getResources().getDrawable(a7.e.t0);
                    } else if (streamVolume < 80) {
                        ExoPlayerMoviesSeries exoPlayerMoviesSeries3 = ExoPlayerMoviesSeries.this;
                        textView = exoPlayerMoviesSeries3.U0;
                        drawable = exoPlayerMoviesSeries3.getResources().getDrawable(a7.e.u0);
                    } else if (streamVolume < 100) {
                        ExoPlayerMoviesSeries exoPlayerMoviesSeries4 = ExoPlayerMoviesSeries.this;
                        textView = exoPlayerMoviesSeries4.U0;
                        drawable = exoPlayerMoviesSeries4.getResources().getDrawable(a7.e.v0);
                    } else {
                        ExoPlayerMoviesSeries exoPlayerMoviesSeries5 = ExoPlayerMoviesSeries.this;
                        textView = exoPlayerMoviesSeries5.U0;
                        drawable = exoPlayerMoviesSeries5.getResources().getDrawable(a7.e.v0);
                    }
                    textView.setBackground(drawable);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ExoPlayerMoviesSeries.this.E3();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ExoPlayerMoviesSeries.this.E3();
            ExoPlayerMoviesSeries.this.v2(3000);
        }
    }

    public class y implements SeekBar.OnSeekBarChangeListener {
        public y() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView textView;
            Resources resources;
            int i2;
            ExoPlayerMoviesSeries.o2(ExoPlayerMoviesSeries.this, i);
            int n2 = (int) ((ExoPlayerMoviesSeries.n2(ExoPlayerMoviesSeries.this) / 255.0f) * 100.0f);
            if (n2 < 20) {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                textView = exoPlayerMoviesSeries.T0;
                resources = exoPlayerMoviesSeries.getResources();
                i2 = a7.e.i0;
            } else if (n2 < 30) {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries2 = ExoPlayerMoviesSeries.this;
                textView = exoPlayerMoviesSeries2.T0;
                resources = exoPlayerMoviesSeries2.getResources();
                i2 = a7.e.j0;
            } else if (n2 < 40) {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries3 = ExoPlayerMoviesSeries.this;
                textView = exoPlayerMoviesSeries3.T0;
                resources = exoPlayerMoviesSeries3.getResources();
                i2 = a7.e.k0;
            } else if (n2 < 50) {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries4 = ExoPlayerMoviesSeries.this;
                textView = exoPlayerMoviesSeries4.T0;
                resources = exoPlayerMoviesSeries4.getResources();
                i2 = a7.e.l0;
            } else if (n2 < 60) {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries5 = ExoPlayerMoviesSeries.this;
                textView = exoPlayerMoviesSeries5.T0;
                resources = exoPlayerMoviesSeries5.getResources();
                i2 = a7.e.m0;
            } else if (n2 < 70) {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries6 = ExoPlayerMoviesSeries.this;
                textView = exoPlayerMoviesSeries6.T0;
                resources = exoPlayerMoviesSeries6.getResources();
                i2 = a7.e.n0;
            } else {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries7 = ExoPlayerMoviesSeries.this;
                textView = exoPlayerMoviesSeries7.T0;
                resources = exoPlayerMoviesSeries7.getResources();
                i2 = a7.e.o0;
            }
            textView.setBackground(resources.getDrawable(i2));
            Log.i("brightnessIs", "brightNess:" + ExoPlayerMoviesSeries.n2(ExoPlayerMoviesSeries.this));
            WindowManager.LayoutParams attributes = ExoPlayerMoviesSeries.this.getWindow().getAttributes();
            attributes.screenBrightness = ExoPlayerMoviesSeries.n2(ExoPlayerMoviesSeries.this) / 255.0f;
            try {
                ExoPlayerMoviesSeries.p2(ExoPlayerMoviesSeries.this).R((int) ExoPlayerMoviesSeries.n2(ExoPlayerMoviesSeries.this));
            } catch (Exception e) {
                Log.i("brightnessError", e.toString());
            }
            ExoPlayerMoviesSeries.this.getWindow().setAttributes(attributes);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ExoPlayerMoviesSeries.this.E3();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ExoPlayerMoviesSeries.this.E3();
            ExoPlayerMoviesSeries.this.v2(3000);
        }
    }

    public class z implements Runnable {
        public z() {
        }

        public void run() {
            try {
                Log.i("durationIS", "total:" + ExoPlayerMoviesSeries.this.r.getDuration() + "cur:" + ExoPlayerMoviesSeries.this.r.getCurrentPosition());
                ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                exoPlayerMoviesSeries.I0.setText(exoPlayerMoviesSeries.J3((int) exoPlayerMoviesSeries.r.getCurrentPosition()));
                ExoPlayerMoviesSeries exoPlayerMoviesSeries2 = ExoPlayerMoviesSeries.this;
                exoPlayerMoviesSeries2.J0.setText(exoPlayerMoviesSeries2.J3((int) exoPlayerMoviesSeries2.r.getDuration()));
                int duration = (int) ExoPlayerMoviesSeries.this.r.getDuration();
                if (duration > 0) {
                    ExoPlayerMoviesSeries.this.C0.setProgress((int) ((((int) ExoPlayerMoviesSeries.this.r.getCurrentPosition()) * 1000) / duration));
                    if (ExoPlayerMoviesSeries.this.r.isPlaying()) {
                        ExoPlayerMoviesSeries.this.s0.setVisibility(8);
                        ExoPlayerMoviesSeries.this.t0.setVisibility(0);
                    }
                }
            } catch (Exception unused) {
            }
            ExoPlayerMoviesSeries.q2(ExoPlayerMoviesSeries.this).postDelayed(this, 1000L);
        }
    }

    public static /* synthetic */ o4.e A1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.V3;
    }

    public static /* synthetic */ o4.e B1(ExoPlayerMoviesSeries exoPlayerMoviesSeries, o4.e eVar) {
        exoPlayerMoviesSeries.V3 = eVar;
        return eVar;
    }

    public static /* synthetic */ void C1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        exoPlayerMoviesSeries.T2();
    }

    public static /* synthetic */ Context D1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.I2;
    }

    public static /* synthetic */ void E1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        exoPlayerMoviesSeries.j3();
    }

    public static long E2(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static /* synthetic */ String F1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.a4;
    }

    public static /* synthetic */ String G1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.Y3;
    }

    public static String G2(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    public static /* synthetic */ String H1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.X3;
    }

    public static /* synthetic */ String I1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.Z3;
    }

    public static /* synthetic */ int J1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.w3();
    }

    public static /* synthetic */ int K1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.b4;
    }

    public static /* synthetic */ int L1(ExoPlayerMoviesSeries exoPlayerMoviesSeries, int i2) {
        exoPlayerMoviesSeries.b4 = i2;
        return i2;
    }

    public static /* synthetic */ int M1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.P3;
    }

    public static /* synthetic */ int N1(ExoPlayerMoviesSeries exoPlayerMoviesSeries, int i2) {
        exoPlayerMoviesSeries.P3 = i2;
        return i2;
    }

    public static /* synthetic */ AlertDialog O1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.D4;
    }

    public static /* synthetic */ boolean P1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.I4;
    }

    public static /* synthetic */ boolean Q1(ExoPlayerMoviesSeries exoPlayerMoviesSeries, boolean z2) {
        exoPlayerMoviesSeries.I4 = z2;
        return z2;
    }

    public static String Q2(String str) {
        Matcher matcher = Pattern.compile("(?:youtube(?:-nocookie)?\\.com\\/(?:[^\\/\\n\\s]+\\/\\S+\\/|(?:v|e(?:mbed)?)\\/|\\S*?[?&]v=)|youtu\\.be\\/)([a-zA-Z0-9_-]{11})", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static /* synthetic */ ProgressBar R1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.M4;
    }

    public static /* synthetic */ List S1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.y4;
    }

    public static /* synthetic */ AudioManager T1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.p2;
    }

    private void T2() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ RecyclerView U1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.N4;
    }

    public static /* synthetic */ void V1(ExoPlayerMoviesSeries exoPlayerMoviesSeries, String str) {
        exoPlayerMoviesSeries.b3(str);
    }

    public static /* synthetic */ int W1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.H4;
    }

    public static /* synthetic */ int X1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        int i2 = exoPlayerMoviesSeries.H4;
        exoPlayerMoviesSeries.H4 = i2 + 1;
        return i2;
    }

    public static /* synthetic */ void Y1(ExoPlayerMoviesSeries exoPlayerMoviesSeries, boolean z2) {
        exoPlayerMoviesSeries.K3(z2);
    }

    public static /* synthetic */ SharedPreferences Z1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.X2;
    }

    public static /* synthetic */ SharedPreferences a2(ExoPlayerMoviesSeries exoPlayerMoviesSeries, SharedPreferences sharedPreferences) {
        exoPlayerMoviesSeries.X2 = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ TextView b2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.O4;
    }

    public static /* synthetic */ void c2(ExoPlayerMoviesSeries exoPlayerMoviesSeries, String str) {
        exoPlayerMoviesSeries.n3(str);
    }

    public static /* synthetic */ void d2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        exoPlayerMoviesSeries.R2();
    }

    public static /* synthetic */ void e2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        exoPlayerMoviesSeries.d3();
    }

    public static /* synthetic */ GestureDetector f2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.s2;
    }

    public static /* synthetic */ IMediaPlayer g2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.u2;
    }

    public static /* synthetic */ void h2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        exoPlayerMoviesSeries.P3();
    }

    public static /* synthetic */ int i2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.x4;
    }

    public static /* synthetic */ void j2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        exoPlayerMoviesSeries.q3();
    }

    public static /* synthetic */ int k2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.x3;
    }

    public static /* synthetic */ void l2(ExoPlayerMoviesSeries exoPlayerMoviesSeries, int i2, int i3, int i4, int i5, ArrayList arrayList, String str, List list, Object obj, boolean z2, String str2) {
        exoPlayerMoviesSeries.M2(i2, i3, i4, i5, arrayList, str, list, obj, z2, str2);
    }

    public static /* synthetic */ int m2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.q2;
    }

    public static /* synthetic */ float n2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.Q3;
    }

    public static /* synthetic */ float o2(ExoPlayerMoviesSeries exoPlayerMoviesSeries, float f2) {
        exoPlayerMoviesSeries.Q3 = f2;
        return f2;
    }

    public static /* synthetic */ u7.a p2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.V2;
    }

    public static /* synthetic */ Handler q2(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.r2;
    }

    private void q3() {
        try {
            if (this.r != null) {
                this.N3 = this.I2.getSharedPreferences("currentSeekTime", 0);
                long currentPosition = (int) this.r.getCurrentPosition();
                SharedPreferences sharedPreferences = this.I2.getSharedPreferences("currentSeekTime", 0);
                this.N3 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.O3 = edit;
                edit.putString("currentSeekTime", String.valueOf(currentPosition));
                this.O3.apply();
                String str = this.b2;
                if (str == null || !str.equals("movies")) {
                    String str2 = this.b2;
                    if (str2 != null && str2.equals("series") && ((this.r == null || x7.a.f().a() == null || !this.k3.equals("m3u")) && x7.a.f() != null && x7.a.f().e() != null && currentPosition != -1 && currentPosition != 0)) {
                        ArrayList c2 = this.i.c(x7.a.f().e());
                        this.f4 = c2;
                        if (c2 != null && c2.size() > 0) {
                            try {
                                int K2 = K2(this.n3, m7.w.r0(x7.a.f().e()));
                                GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                                getEpisdoeDetailsCallback.setId(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getId());
                                getEpisdoeDetailsCallback.setTitle(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getTitle());
                                getEpisdoeDetailsCallback.setContainerExtension(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getContainerExtension());
                                getEpisdoeDetailsCallback.setAdded(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getAdded());
                                getEpisdoeDetailsCallback.setSeriesCover(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesCover());
                                getEpisdoeDetailsCallback.setCategoryId(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getCategoryId());
                                getEpisdoeDetailsCallback.setElapsed_time(String.valueOf(currentPosition));
                                getEpisdoeDetailsCallback.setSeriesId(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesId());
                                getEpisdoeDetailsCallback.setImage(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getImage());
                                getEpisdoeDetailsCallback.setMovieImage(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getMovieImage());
                                getEpisdoeDetailsCallback.setMainSeriesImg(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getMainSeriesImg());
                                getEpisdoeDetailsCallback.setSeriesNum(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesNum());
                                getEpisdoeDetailsCallback.setSeasonNumber(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeasonNumber());
                                getEpisdoeDetailsCallback.setEpisodeNum(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getEpisodeNumber());
                                getEpisdoeDetailsCallback.setSeriesName(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesName());
                                this.F1 = ((GetEpisdoeDetailsCallback) this.n3.get(K2)).getCategoryId();
                                this.G1 = ((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesName();
                                if (SharepreferenceDBHandler.getCurrentAPPType(this.I2).equals("onestream_api")) {
                                    getEpisdoeDetailsCallback.setLinks(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getLinks());
                                }
                                I1 i1 = this.r;
                                getEpisdoeDetailsCallback.setDurationSec(i1 != null ? String.valueOf(((int) i1.getDuration()) / 1000) : ((GetEpisdoeDetailsCallback) this.n3.get(K2)).getDurationSec());
                                this.i.b(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getId());
                                this.i.i(this.I2, ((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesId());
                                this.i.g(this.I2, getEpisdoeDetailsCallback);
                            } catch (Exception unused) {
                            }
                        }
                    }
                } else {
                    r3(1);
                }
            }
            I1 i12 = this.r;
            if (i12 != null) {
                i12.release();
                this.r = null;
                this.q4 = null;
            }
        } catch (Exception unused2) {
        }
    }

    public static /* synthetic */ void u1(ExoPlayerMoviesSeries exoPlayerMoviesSeries, DialogInterface dialogInterface) {
        exoPlayerMoviesSeries.W2(dialogInterface);
    }

    public static /* synthetic */ t2.a w1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.D3;
    }

    public static /* synthetic */ long x1(ExoPlayerMoviesSeries exoPlayerMoviesSeries) {
        return exoPlayerMoviesSeries.v2;
    }

    public static /* synthetic */ void y1(ExoPlayerMoviesSeries exoPlayerMoviesSeries, String str) {
        exoPlayerMoviesSeries.M3(str);
    }

    public static boolean y2() {
        ProgressBar progressBar = U4;
        return progressBar != null && progressBar.getVisibility() == 0;
    }

    public static /* synthetic */ long z1(ExoPlayerMoviesSeries exoPlayerMoviesSeries, long j2) {
        exoPlayerMoviesSeries.v2 = j2;
        return j2;
    }

    public final void A2() {
        int i2;
        int i3;
        int i4;
        I1 i1;
        long j2;
        GetEpisdoeDetailsCallback getEpisdoeDetailsCallback;
        z0 z0Var;
        List list = this.n3;
        if (list == null || list.size() <= 0) {
            return;
        }
        List list2 = this.F2;
        if (list2 != null) {
            list2.clear();
        }
        if (this.T2 != null) {
            if (this.r != null) {
                this.N3 = this.I2.getSharedPreferences("currentSeekTime", 0);
                try {
                    j2 = (int) this.r.getCurrentPosition();
                } catch (Exception unused) {
                    j2 = 1000;
                }
                SharedPreferences sharedPreferences = this.I2.getSharedPreferences("currentSeekTime", 0);
                this.N3 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.O3 = edit;
                edit.putString("currentSeekTime", String.valueOf(j2));
                this.O3.apply();
                Log.i("seekTimeIS", "seekTime:" + j2);
                if (this.r == null || x7.a.f().a() == null || !this.k3.equals("m3u")) {
                    try {
                        if (x7.a.f() != null && x7.a.f().e() != null && j2 != -1 && j2 != 0) {
                            Log.i("elsePartIS", "ifHere");
                            int K2 = K2(this.n3, m7.w.r0(x7.a.f().e()));
                            getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                            getEpisdoeDetailsCallback.setId(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getId());
                            getEpisdoeDetailsCallback.setTitle(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getTitle());
                            getEpisdoeDetailsCallback.setContainerExtension(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getContainerExtension());
                            getEpisdoeDetailsCallback.setAdded(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getAdded());
                            getEpisdoeDetailsCallback.setSeriesCover(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesCover());
                            getEpisdoeDetailsCallback.setCategoryId(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getCategoryId());
                            getEpisdoeDetailsCallback.setElapsed_time(String.valueOf(j2));
                            getEpisdoeDetailsCallback.setSeriesId(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesId());
                            getEpisdoeDetailsCallback.setSeriesId(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesId());
                            getEpisdoeDetailsCallback.setImage(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getImage());
                            getEpisdoeDetailsCallback.setMovieImage(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getMovieImage());
                            getEpisdoeDetailsCallback.setMainSeriesImg(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getMainSeriesImg());
                            getEpisdoeDetailsCallback.setSeriesNum(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesNum());
                            getEpisdoeDetailsCallback.setSeasonNumber(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeasonNumber());
                            getEpisdoeDetailsCallback.setEpisodeNum(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getEpisodeNumber());
                            getEpisdoeDetailsCallback.setSeriesName(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesName());
                            I1 i12 = this.r;
                            getEpisdoeDetailsCallback.setDurationSec(i12 != null ? String.valueOf(((int) i12.getDuration()) / 1000) : ((GetEpisdoeDetailsCallback) this.n3.get(K2)).getDurationSec());
                            this.i.b(((GetEpisdoeDetailsCallback) this.n3.get(K2)).getId());
                            this.i.i(this.I2, ((GetEpisdoeDetailsCallback) this.n3.get(K2)).getSeriesId());
                            z0Var = this.i;
                        } else if (x7.a.f() != null && x7.a.f().e() != null && j2 != -1 && j2 != 0) {
                            Log.i("elsePartIS", "ifHere");
                            int K22 = K2(this.n3, m7.w.r0(x7.a.f().e()));
                            getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                            getEpisdoeDetailsCallback.setId(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getId());
                            getEpisdoeDetailsCallback.setTitle(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getTitle());
                            getEpisdoeDetailsCallback.setContainerExtension(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getContainerExtension());
                            getEpisdoeDetailsCallback.setAdded(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getAdded());
                            getEpisdoeDetailsCallback.setSeriesCover(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getSeriesCover());
                            getEpisdoeDetailsCallback.setCategoryId(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getCategoryId());
                            getEpisdoeDetailsCallback.setElapsed_time(String.valueOf(j2));
                            getEpisdoeDetailsCallback.setSeriesId(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getSeriesId());
                            getEpisdoeDetailsCallback.setSeriesId(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getSeriesId());
                            getEpisdoeDetailsCallback.setImage(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getImage());
                            getEpisdoeDetailsCallback.setMovieImage(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getMovieImage());
                            getEpisdoeDetailsCallback.setMainSeriesImg(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getMainSeriesImg());
                            getEpisdoeDetailsCallback.setSeriesNum(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getSeriesNum());
                            getEpisdoeDetailsCallback.setSeasonNumber(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getSeasonNumber());
                            getEpisdoeDetailsCallback.setEpisodeNum(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getEpisodeNumber());
                            getEpisdoeDetailsCallback.setSeriesName(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getSeriesName());
                            this.F1 = ((GetEpisdoeDetailsCallback) this.n3.get(K22)).getCategoryId();
                            this.G1 = ((GetEpisdoeDetailsCallback) this.n3.get(K22)).getSeriesName();
                            I1 i13 = this.r;
                            getEpisdoeDetailsCallback.setDurationSec(i13 != null ? String.valueOf(((int) i13.getDuration()) / 1000) : ((GetEpisdoeDetailsCallback) this.n3.get(K22)).getDurationSec());
                            this.i.b(((GetEpisdoeDetailsCallback) this.n3.get(K22)).getId());
                            this.i.i(this.I2, ((GetEpisdoeDetailsCallback) this.n3.get(K22)).getSeriesId());
                            z0Var = this.i;
                        }
                        z0Var.g(this.I2, getEpisdoeDetailsCallback);
                    } catch (Exception unused2) {
                    }
                }
            }
            ArrayList allSeriesRecentWatch = this.T2.getAllSeriesRecentWatch("getalldata");
            for (int i5 = 0; i5 < this.n3.size(); i5++) {
                if (((GetEpisdoeDetailsCallback) this.n3.get(i5)).getSeasonNumber().equals(Integer.valueOf(this.c4))) {
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback2 = (GetEpisdoeDetailsCallback) this.n3.get(i5);
                    int i6 = 0;
                    while (true) {
                        if (i6 >= allSeriesRecentWatch.size()) {
                            break;
                        }
                        if (((GetEpisdoeDetailsCallback) this.n3.get(i5)).getId().equals(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i6)).getId())) {
                            getEpisdoeDetailsCallback2.setElapsed_time(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i6)).getElapsed_time());
                            try {
                                i2 = Math.round(Integer.parseInt(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i6)).getElapsed_time()) / 1000.0f);
                                try {
                                    i3 = (!getEpisdoeDetailsCallback2.getDurationSec().equals("") || (i1 = this.r) == null) ? m7.w.r0(getEpisdoeDetailsCallback2.getDurationSec()) : ((int) i1.getDuration()) / 1000;
                                } catch (Exception unused3) {
                                    i3 = 0;
                                    i4 = Math.round((i2 / i3) * 100.0f);
                                    getEpisdoeDetailsCallback2.setEpisode_watched_percentage(i4);
                                    this.F2.add(getEpisdoeDetailsCallback2);
                                }
                            } catch (Exception unused4) {
                                i2 = 0;
                            }
                            try {
                                i4 = Math.round((i2 / i3) * 100.0f);
                            } catch (Exception unused5) {
                                i4 = 0;
                            }
                            getEpisdoeDetailsCallback2.setEpisode_watched_percentage(i4);
                        } else {
                            i6++;
                        }
                    }
                    this.F2.add(getEpisdoeDetailsCallback2);
                }
            }
        }
    }

    public void A3() {
        if (V4 || x2() || this.l.getVisibility() != 8) {
            return;
        }
        this.l.startAnimation(this.g);
        this.l.setVisibility(0);
        if (this.H.getVisibility() == 8) {
            this.H.startAnimation(this.g);
            this.H.setVisibility(0);
        }
        if (this.P0.getVisibility() == 8) {
            this.P0.startAnimation(this.g);
            this.P0.setVisibility(0);
        }
        if (this.J.getVisibility() == 8) {
            this.J.startAnimation(this.g);
            this.J.setVisibility(0);
        }
        if (this.Q0.getVisibility() == 8) {
            this.Q0.startAnimation(this.g);
            this.Q0.setVisibility(0);
        }
        if (this.I.getVisibility() == 8) {
            this.I.startAnimation(this.g);
            this.I.setVisibility(0);
        }
    }

    public final void B2() {
        if (this.P4 <= 5) {
            Toast.makeText(this, "Api Error, reconnects in 3sec(" + this.P4 + "/5) ", 0).show();
        }
        this.P4++;
        new Handler().postDelayed(new h(), 3000L);
    }

    public final void B3(int i2) {
        C3(getString(i2));
    }

    public void C2(boolean z2) {
        String string;
        Log.e("calling:", "vipserbver");
        a5.setVisibility(0);
        TextView findViewById = ((LayoutInflater) getSystemService("layout_inflater")).inflate(a7.g.p2, findViewById(a7.f.ih)).findViewById(a7.f.Yg);
        new o1.a().c(a.a.BASIC);
        OkHttpClient okHttpClient = new OkHttpClient();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        okHttpClient.setConnectTimeout(15L, timeUnit);
        okHttpClient.setReadTimeout(15L, timeUnit);
        MediaType parse = MediaType.parse("application/json");
        Log.e("comingfileid", String.valueOf(this.o2));
        try {
            com.squareup.okhttp.Response execute = okHttpClient.newCall(new Request.Builder().url("https://api.opensubtitles.com/api/v1/download").post(RequestBody.create(parse, "{\n  \"file_id\":" + this.o2 + "\n}")).addHeader("User-Agent", "IPTVSmartersPlayer").addHeader("Accept", "application/json").addHeader("Api-Key", "ZCyXegBRifdfqktSPAiyrtlpknf2RBrL").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJrVzBLUlE1S3FiT08wZXpQS0NOazBOY1dWU1BvcmlONiIsImV4cCI6MTcwMDkwMTcwN30.VPitYBEcXa-iFREzVDtyDxJZlmSjDKeh0iWIUltJtFM").build()).execute();
            if (execute.body() != null) {
                String string2 = execute.body().string();
                try {
                    JSONObject jSONObject = new JSONObject(string2);
                    Log.e("vipserverrespnse", string2);
                    try {
                        if (jSONObject.getString("link") != null) {
                            Log.e("vipserverrespnse", this.z4);
                            if (!this.z4.isEmpty()) {
                                Log.e("TAG1:", this.z4);
                                r2(Uri.parse(this.z4));
                                return;
                            } else {
                                Log.e("TAG1:", this.z4);
                                if (jSONObject.getString("message") == null || jSONObject.getString("message").isEmpty()) {
                                    return;
                                } else {
                                    string = jSONObject.getString("message");
                                }
                            }
                        } else {
                            if (jSONObject.getString("message") == null) {
                                return;
                            }
                            Log.e("vipserverrespnse", jSONObject.getString("message"));
                            string = jSONObject.getString("message");
                        }
                        findViewById.setText(string);
                    } catch (Exception e2) {
                        if (this.P4 <= 5) {
                            B2();
                        } else {
                            findViewById.setText((jSONObject.getString("message") == null || jSONObject.getString("message").isEmpty()) ? String.valueOf(e2) : jSONObject.getString("message"));
                        }
                        Log.e("TAG2:", String.valueOf(e2));
                    }
                } catch (JSONException e3) {
                    if (this.P4 <= 5) {
                        B2();
                    } else {
                        findViewById.setText(String.valueOf(e3));
                    }
                    e3.printStackTrace();
                }
            }
        } catch (IOException e4) {
            if (this.P4 <= 5) {
                B2();
            } else {
                findViewById.setText(String.valueOf(e4));
            }
            Log.e("TAG4:", String.valueOf(e4));
            e4.printStackTrace();
        }
    }

    public final void C3(String str) {
        Toast.makeText(getApplicationContext(), str, 1).show();
    }

    public final void D2(String str) {
        this.U2.deleteMovieRecentWatch(str);
    }

    public final void D3() {
        try {
            if (this.o4 || !com.nst.iptvsmarterstvbox.view.demo.b.b0(this.r)) {
                return;
            }
            this.o4 = true;
            com.nst.iptvsmarterstvbox.view.demo.b.P(this.r, new p7.w(this)).show(getSupportFragmentManager(), (String) null);
        } catch (Exception unused) {
        }
    }

    public void E3() {
        Handler handler;
        if (V4 || x2() || (handler = this.i2.u) == null) {
            return;
        }
        handler.removeCallbacksAndMessages((Object) null);
    }

    public final void F2() {
        ImageView imageView = this.s0;
        imageView.setOnFocusChangeListener(new E(imageView));
        ImageView imageView2 = this.t0;
        imageView2.setOnFocusChangeListener(new E(imageView2));
        this.k2.setOnFocusChangeListener(new E(this.D));
        ImageView imageView3 = this.q0;
        imageView3.setOnFocusChangeListener(new E(imageView3));
        SeekBar seekBar = this.C0;
        seekBar.setOnFocusChangeListener(new E(seekBar));
        ImageView imageView4 = this.r0;
        imageView4.setOnFocusChangeListener(new E(imageView4));
        ImageView imageView5 = this.A0;
        imageView5.setOnFocusChangeListener(new E(imageView5));
        LinearLayout linearLayout = this.B;
        linearLayout.setOnFocusChangeListener(new E(linearLayout));
        LinearLayout linearLayout2 = this.C;
        linearLayout2.setOnFocusChangeListener(new E(linearLayout2));
        LinearLayout linearLayout3 = this.D;
        linearLayout3.setOnFocusChangeListener(new E(linearLayout3));
        LinearLayout linearLayout4 = this.E;
        linearLayout4.setOnFocusChangeListener(new E(linearLayout4));
        ImageView imageView6 = this.u0;
        imageView6.setOnFocusChangeListener(new E(imageView6));
        ImageView imageView7 = this.v0;
        imageView7.setOnFocusChangeListener(new E(imageView7));
        ImageView imageView8 = this.w0;
        imageView8.setOnFocusChangeListener(new E(imageView8));
        ImageView imageView9 = this.w0;
        imageView9.setOnFocusChangeListener(new E(imageView9));
        TextView textView = this.X0;
        textView.setOnFocusChangeListener(new E(textView));
        TextView textView2 = this.Z0;
        textView2.setOnFocusChangeListener(new E(textView2));
        RelativeLayout relativeLayout = this.n0;
        relativeLayout.setOnFocusChangeListener(new E(relativeLayout));
        ImageView imageView10 = this.B0;
        imageView10.setOnFocusChangeListener(new E(imageView10));
        LinearLayout linearLayout5 = this.X;
        linearLayout5.setOnFocusChangeListener(new E(linearLayout5));
        LinearLayout linearLayout6 = this.Y;
        linearLayout6.setOnFocusChangeListener(new E(linearLayout6));
        CheckBox checkBox = this.q1;
        checkBox.setOnFocusChangeListener(new E(checkBox));
        CheckBox checkBox2 = this.r1;
        checkBox2.setOnFocusChangeListener(new E(checkBox2));
        CheckBox checkBox3 = this.s1;
        checkBox3.setOnFocusChangeListener(new E(checkBox3));
        CheckBox checkBox4 = this.t1;
        checkBox4.setOnFocusChangeListener(new E(checkBox4));
        LinearLayout linearLayout7 = this.Z;
        linearLayout7.setOnFocusChangeListener(new E(linearLayout7));
        CheckBox checkBox5 = this.u1;
        checkBox5.setOnFocusChangeListener(new E(checkBox5));
        CheckBox checkBox6 = this.v1;
        checkBox6.setOnFocusChangeListener(new E(checkBox6));
        CheckBox checkBox7 = this.w1;
        checkBox7.setOnFocusChangeListener(new E(checkBox7));
        CheckBox checkBox8 = this.x1;
        checkBox8.setOnFocusChangeListener(new E(checkBox8));
        CheckBox checkBox9 = this.y1;
        checkBox9.setOnFocusChangeListener(new E(checkBox9));
        LinearLayout linearLayout8 = this.e0;
        linearLayout8.setOnFocusChangeListener(new E(linearLayout8));
        LinearLayout linearLayout9 = this.f0;
        linearLayout9.setOnFocusChangeListener(new E(linearLayout9));
        CheckBox checkBox10 = this.z1;
        checkBox10.setOnFocusChangeListener(new E(checkBox10));
        CheckBox checkBox11 = this.A1;
        checkBox11.setOnFocusChangeListener(new E(checkBox11));
        CheckBox checkBox12 = this.B1;
        checkBox12.setOnFocusChangeListener(new E(checkBox12));
        CheckBox checkBox13 = this.C1;
        checkBox13.setOnFocusChangeListener(new E(checkBox13));
        EditText editText = this.D1;
        editText.setOnFocusChangeListener(new E(editText));
        TextView textView3 = this.b1;
        textView3.setOnFocusChangeListener(new E(textView3));
    }

    public void F3() {
        Handler handler = this.n;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        RelativeLayout relativeLayout = this.p0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public final int G3(int i2, int i3) {
        return this.U2.isStreamAvailable(String.valueOf(i2), i3);
    }

    public void H2() {
        if (this.W.getVisibility() == 0) {
            this.X.setNextFocusRightId(a7.f.K3);
            this.Y.setNextFocusRightId(a7.f.e2);
            this.Z.setNextFocusRightId(a7.f.a2);
            this.e0.setNextFocusRightId(a7.f.V1);
        }
    }

    public final int H3(String str, int i2) {
        return this.Q1.isStreamAvailable(str, i2);
    }

    public int I2(ArrayList arrayList, int i2) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (m7.w.r0(((LiveStreamsDBModel) arrayList.get(i3)).getStreamId()) == i2) {
                return i3;
            }
        }
        return 0;
    }

    public final int I3(String str, int i2) {
        return this.U2.isStreamAvailable(str, i2);
    }

    public int J2(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((LiveStreamsDBModel) arrayList.get(i2)).getStreamIdOneStream().equals(str)) {
                return i2;
            }
        }
        return 0;
    }

    public String J3(int i2) {
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = (i3 / 60) % 60;
        int i6 = i3 / 3600;
        try {
            this.s.setLength(0);
            return i6 > 0 ? this.t.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)}).toString() : this.t.format("%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)}).toString();
        } catch (Exception unused) {
            return this.t.format("%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)}).toString();
        }
    }

    public int K2(List list, int i2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (m7.w.r0(((GetEpisdoeDetailsCallback) list.get(i3)).getId()) == i2) {
                return i3;
            }
        }
        return 0;
    }

    public final void K3(boolean z2) {
        LayoutInflater from;
        int i2;
        this.I4 = false;
        a5.setVisibility(0);
        this.l2.setVisibility(8);
        if (z2) {
            this.H4 = 0;
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
            this.J4 = layoutInflater;
            View inflate = layoutInflater.inflate(a7.g.p2, findViewById(a7.f.ih));
            this.K4 = inflate;
            this.L4 = inflate.findViewById(a7.f.Yg);
            AlertDialog.Builder builder = new AlertDialog.Builder(this, a7.k.a);
            if (this.V2.A().equals(m7.a.K0)) {
                from = LayoutInflater.from(getApplicationContext());
                i2 = a7.g.b3;
            } else {
                from = LayoutInflater.from(getApplicationContext());
                i2 = a7.g.a3;
            }
            View inflate2 = from.inflate(i2, (ViewGroup) null);
            this.M4 = inflate2.findViewById(a7.f.Nc);
            this.N4 = inflate2.findViewById(a7.f.Dd);
            inflate2.findViewById(a7.f.l2).setOnClickListener(new f());
            TextView findViewById = inflate2.findViewById(a7.f.X2);
            this.O4 = findViewById;
            findViewById.setVisibility(8);
            this.y4 = new ArrayList();
            this.O4.setVisibility(8);
            builder.setView(inflate2);
            this.D4 = builder.create();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(this.D4.getWindow().getAttributes());
            layoutParams.width = -2;
            layoutParams.height = -2;
            new Rect();
            this.D4.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            this.D4.getWindow().setAttributes(layoutParams);
            this.D4.setCancelable(true);
            this.D4.show();
        }
        OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        okhttp3.OkHttpClient build = builder2.connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).build();
        Log.e("jaskirat", "tmdb_id" + this.n2);
        j1.a.a("https://api.opensubtitles.com/api/v1/subtitles?tmdb_id=" + this.n2).p("User-Agent", "IPTVSmartersPlayer").p("Accept", "application/json").p("Api-Key", "ZCyXegBRifdfqktSPAiyrtlpknf2RBrL").p("Content-Type", "application/json").p("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJrVzBLUlE1S3FiT08wZXpQS0NOazBOY1dWU1BvcmlONiIsImV4cCI6MTcwMDkwMTcwN30.VPitYBEcXa-iFREzVDtyDxJZlmSjDKeh0iWIUltJtFM").t("test").r(build).s(k1.e.LOW).q().o(new g());
    }

    public int L2(List list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((GetEpisdoeDetailsCallback) list.get(i2)).getId().equals(str)) {
                return i2;
            }
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void L3() {
        int i2;
        CharSequence[] charSequenceArr = {"10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40"};
        a.a aVar = new a.a(this);
        aVar.setTitle(getResources().getString(a7.j.R7));
        String string = this.I3.getString("pref.using_sub_font_size", m7.a.x0);
        string.hashCode();
        char c2 = 65535;
        switch (string.hashCode()) {
            case 1567:
                if (string.equals("10")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1569:
                if (string.equals("12")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1571:
                if (string.equals("14")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1573:
                if (string.equals("16")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1575:
                if (string.equals("18")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1598:
                if (string.equals("20")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1600:
                if (string.equals("22")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1602:
                if (string.equals("24")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1604:
                if (string.equals("26")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1606:
                if (string.equals("28")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1629:
                if (string.equals("30")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1631:
                if (string.equals("32")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1633:
                if (string.equals("34")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1635:
                if (string.equals("36")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 1637:
                if (string.equals("38")) {
                    c2 = 14;
                    break;
                }
                break;
            case 1660:
                if (string.equals("40")) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            default:
                i2 = 0;
                break;
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                break;
            case 5:
                i2 = 5;
                break;
            case 6:
                i2 = 6;
                break;
            case 7:
                i2 = 7;
                break;
            case '\b':
                i2 = 8;
                break;
            case '\t':
                i2 = 9;
                break;
            case '\n':
                i2 = 10;
                break;
            case 11:
                i2 = 11;
                break;
            case '\f':
                i2 = 12;
                break;
            case '\r':
                i2 = 13;
                break;
            case 14:
                i2 = 14;
                break;
            case 15:
                i2 = 15;
                break;
        }
        aVar.l(charSequenceArr, i2, new a());
        try {
            androidx.appcompat.app.a create = aVar.create();
            this.g4 = create;
            create.setOnDismissListener(new b());
            this.g4.show();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x09d8  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0c6a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0453  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void M2(int r22, int r23, int r24, int r25, java.util.ArrayList r26, java.lang.String r27, java.util.List r28, java.lang.Object r29, boolean r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 3370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.M2(int, int, int, int, java.util.ArrayList, java.lang.String, java.util.List, java.lang.Object, boolean, java.lang.String):void");
    }

    public final void M3(String str) {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("pref.using_sub_font_size", 0);
            this.I3 = sharedPreferences;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            this.J3 = edit;
            if (edit != null) {
                edit.putString("pref.using_sub_font_size", str);
                this.J3.apply();
            }
        } catch (Exception unused) {
        }
    }

    public final ArrayList N2(int i2, int i3) {
        return this.U2.getStreamStatus(String.valueOf(i2), i3);
    }

    public final void N3() {
        this.k2.setVisibility(0);
        this.k2.requestFocus();
        this.l2.setVisibility(0);
    }

    public final LiveStreamsDBModel O2(String str, int i2) {
        return this.Q1.getStreamStatus(str, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int O3() {
        /*
            r6 = this;
            int r0 = r6.w2
            r1 = 1
            int r0 = r0 + r1
            r6.w2 = r0
            java.lang.String r0 = "loginPrefs"
            r2 = 0
            android.content.SharedPreferences r0 = r6.getSharedPreferences(r0, r2)
            r6.u = r0
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r6.v = r0
            int r0 = r6.w2
            int[] r3 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.S4
            int r4 = r3.length
            int r0 = r0 % r4
            r6.w2 = r0
            r0 = r3[r0]
            r6.x2 = r0
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
            int r5 = r6.x2
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "aspectRatioIS"
            android.util.Log.i(r5, r4)
            com.google.android.exoplayer2.ui.PlayerView r4 = r6.i2
            int r5 = r6.x2
            r4.setResizeMode(r5)
            int r4 = r6.w2
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
            android.content.SharedPreferences$Editor r1 = r6.v
            java.lang.String r3 = "aspect_ratio"
            int r4 = r6.w2
            r1.putInt(r3, r4)
            android.content.SharedPreferences$Editor r1 = r6.v
            r1.apply()
            r0.setVisibility(r2)
            android.widget.LinearLayout r1 = r6.J
            if (r1 == 0) goto Lad
            int r1 = r1.getVisibility()
            if (r1 != 0) goto Lad
            android.widget.LinearLayout r1 = r6.J
            r2 = 8
            r1.setVisibility(r2)
        Lad:
            android.os.Handler r1 = r6.y2
            r2 = 0
            r1.removeCallbacksAndMessages(r2)
            android.os.Handler r1 = r6.y2
            com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries$r r2 = new com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries$r
            r2.<init>(r0)
            r3 = 3000(0xbb8, double:1.482E-320)
            r1.postDelayed(r2, r3)
            int r0 = r6.x2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.O3():int");
    }

    public final ArrayList P2(String str, int i2) {
        return this.U2.getStreamStatus(String.valueOf(str), i2);
    }

    public final void P3() {
        E3();
        if (this.l2.getVisibility() == 0) {
            this.l2.setVisibility(8);
        }
        if (this.l.getVisibility() == 0) {
            R2();
            return;
        }
        z3();
        u2(5000);
        v2(3000);
    }

    public final void Q3() {
        LinearLayout linearLayout = this.f;
        if (linearLayout != null) {
            linearLayout.setClickable(true);
            this.f.setOnTouchListener(new q());
        }
    }

    public final void R2() {
        if (this.l.getVisibility() == 0) {
            this.l.startAnimation(this.h);
            if (this.H.getVisibility() == 0) {
                this.H.startAnimation(this.h);
            }
            if (this.P0.getVisibility() == 0) {
                this.P0.startAnimation(this.h);
            }
            if (this.J.getVisibility() == 0) {
                this.J.startAnimation(this.h);
            }
            if (this.Q0.getVisibility() == 0) {
                this.Q0.startAnimation(this.h);
            }
            if (this.I.getVisibility() == 0) {
                this.I.startAnimation(this.h);
            }
            this.l.setVisibility(8);
            if (this.H.getVisibility() == 0) {
                this.H.setVisibility(8);
            }
            if (this.P0.getVisibility() == 0) {
                this.P0.setVisibility(8);
            }
            if (this.J.getVisibility() == 0) {
                this.J.setVisibility(8);
            }
            if (this.Q0.getVisibility() == 0) {
                this.Q0.setVisibility(8);
            }
            if (this.I.getVisibility() == 0) {
                this.I.setVisibility(8);
            }
        }
    }

    public final void R3() {
    }

    public void S2() {
        if (this.r != null) {
            T2();
            this.E3.removeMessages(1);
        }
        if (!V4 && this.l.getVisibility() == 0) {
            this.l.startAnimation(this.h);
            if (this.H.getVisibility() == 0) {
                this.H.startAnimation(this.h);
            }
            if (this.P0.getVisibility() == 0) {
                this.P0.startAnimation(this.h);
            }
            if (this.J.getVisibility() == 0) {
                this.J.startAnimation(this.h);
            }
            if (this.Q0.getVisibility() == 0) {
                this.Q0.startAnimation(this.h);
            }
            if (this.I.getVisibility() == 0) {
                this.I.startAnimation(this.h);
            }
            this.l.setVisibility(8);
            if (this.H.getVisibility() == 0) {
                this.H.setVisibility(8);
            }
            if (this.P0.getVisibility() == 0) {
                this.P0.setVisibility(8);
            }
            if (this.J.getVisibility() == 0) {
                this.J.setVisibility(8);
            }
            if (this.Q0.getVisibility() == 0) {
                this.Q0.setVisibility(8);
            }
            if (this.I.getVisibility() == 0) {
                this.I.setVisibility(8);
            }
        }
        if (this.r != null) {
            T2();
            this.E3.removeMessages(1);
        }
        if (V4 || this.l.getVisibility() != 0) {
            return;
        }
        this.l.startAnimation(this.h);
        if (this.H.getVisibility() == 0) {
            this.H.startAnimation(this.h);
        }
        if (this.P0.getVisibility() == 0) {
            this.P0.startAnimation(this.h);
        }
        if (this.J.getVisibility() == 0) {
            this.J.startAnimation(this.h);
        }
        if (this.Q0.getVisibility() == 0) {
            this.Q0.startAnimation(this.h);
        }
        if (this.I.getVisibility() == 0) {
            this.I.startAnimation(this.h);
        }
        this.l.setVisibility(8);
        if (this.H.getVisibility() == 0) {
            this.H.setVisibility(8);
        }
        if (this.P0.getVisibility() == 0) {
            this.P0.setVisibility(8);
        }
        if (this.J.getVisibility() == 0) {
            this.J.setVisibility(8);
        }
        if (this.Q0.getVisibility() == 0) {
            this.Q0.setVisibility(8);
        }
        if (this.I.getVisibility() == 0) {
            this.I.setVisibility(8);
        }
    }

    public void S3(int i2, String str, int i3, int i4) {
        try {
            if (this.m.equals("mobile") && this.j4 && this.n4) {
                ArrayList arrayList = new ArrayList();
                PendingIntent broadcast = PendingIntent.getBroadcast(this, i4, new Intent("media_control").putExtra("control_type", i3), 67108864);
                Icon a2 = p7.p.a(this, i2);
                p7.u.a();
                arrayList.add(p7.t.a(a2, str, str, broadcast));
                p7.q.a(this.k4, arrayList);
                p7.r.a(this, p7.n.a(this.k4));
            }
        } catch (Exception unused) {
        }
    }

    public final void T3() {
        I1 i1 = this.r;
        if (i1 != null) {
            this.t4 = i1.E();
            this.u4 = this.r.l0();
            this.v4 = Math.max(0L, this.r.R());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0198 A[PHI: r17
      0x0198: PHI (r17v6 android.content.Intent) = 
      (r17v5 android.content.Intent)
      (r17v5 android.content.Intent)
      (r17v5 android.content.Intent)
      (r17v5 android.content.Intent)
      (r17v5 android.content.Intent)
      (r17v7 android.content.Intent)
     binds: [B:84:0x01bc, B:86:0x01c2, B:88:0x01ca, B:90:0x01d4, B:82:0x01b7, B:29:0x0196] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0082 A[PHI: r16
      0x0082: PHI (r16v8 java.lang.String) = (r16v4 java.lang.String), (r16v5 java.lang.String), (r16v6 java.lang.String), (r16v9 java.lang.String) binds: [B:116:0x00a6, B:113:0x0099, B:110:0x008c, B:7:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean U2() {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.U2():boolean");
    }

    public final void U3() {
        Z3.m mVar = this.q4;
        if (mVar != null) {
            this.r4 = mVar.K();
        }
    }

    public final void V2() {
        this.n = new Handler();
        this.Q2 = new Handler();
        this.J2 = AnimationUtils.loadAnimation(this.I2, a7.b.q);
        this.K2 = AnimationUtils.loadAnimation(this.I2, a7.b.r);
        this.g = AnimationUtils.loadAnimation(this.I2, a7.b.h);
        this.h = AnimationUtils.loadAnimation(this.I2, a7.b.i);
        this.P2 = AnimationUtils.loadAnimation(this.I2, a7.b.o);
        this.O2 = AnimationUtils.loadAnimation(this.I2, a7.b.n);
        this.M2 = AnimationUtils.loadAnimation(this.I2, a7.b.s);
        this.N2 = AnimationUtils.loadAnimation(this.I2, a7.b.t);
        this.L2 = AnimationUtils.loadAnimation(this.I2, a7.b.p);
        this.w4 = AnimationUtils.loadAnimation(this.I2, a7.b.k);
        try {
            x3();
        } catch (Exception unused) {
        }
        if (this.m.equals("mobile")) {
            try {
                o4.b e2 = o4.b.e(this);
                this.W3 = e2;
                this.V3 = e2.c().c();
                o4.a.b(getApplicationContext(), this.o1);
            } catch (Exception unused2) {
            }
        }
    }

    public void V3(boolean z2) {
        if (z2) {
            this.B4 = 0;
            a5.setVisibility(0);
            View inflate = ((LayoutInflater) this.I2.getSystemService("layout_inflater")).inflate(a7.g.p2, findViewById(a7.f.ih));
            this.R4 = inflate;
            this.Q4 = inflate.findViewById(a7.f.Yg);
        }
        new o1.a().c(a.a.BASIC);
        com.squareup.okhttp.OkHttpClient okHttpClient = new com.squareup.okhttp.OkHttpClient();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        okHttpClient.setConnectTimeout(60L, timeUnit);
        okHttpClient.setReadTimeout(60L, timeUnit);
        MediaType parse = MediaType.parse("application/json");
        Log.e("comingfileid", String.valueOf(this.o2));
        try {
            com.squareup.okhttp.Response execute = okHttpClient.newCall(new Request.Builder().url("https://vip-api.opensubtitles.com/api/v1/download").post(RequestBody.create(parse, "{\n  \"file_id\":" + this.o2 + "\n}")).addHeader("User-Agent", "IPTVSmartersPlayer").addHeader("Accept", "application/json").addHeader("Api-Key", "ZCyXegBRifdfqktSPAiyrtlpknf2RBrL").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJrVzBLUlE1S3FiT08wZXpQS0NOazBOY1dWU1BvcmlONiIsImV4cCI6MTcwMDkwMTcwN30.VPitYBEcXa-iFREzVDtyDxJZlmSjDKeh0iWIUltJtFM").build()).execute();
            if (execute == null || execute.body() == null) {
                if (this.B4 < 5) {
                    p3();
                    return;
                }
                return;
            }
            String string = execute.body().string();
            try {
                JSONObject jSONObject = new JSONObject(string);
                Log.e("vipserverrespnse", string);
                try {
                    String string2 = jSONObject.getString("link");
                    this.z4 = string2;
                    r2(Uri.parse(string2));
                } catch (Exception e2) {
                    if (this.B4 <= 5) {
                        p3();
                    } else if (jSONObject.getString("message") == null || jSONObject.getString("message").isEmpty()) {
                        this.Q4.setText(String.valueOf(e2));
                    } else {
                        this.Q4.setText(jSONObject.getString("message"));
                    }
                    e2.printStackTrace();
                }
            } catch (JSONException e3) {
                if (this.B4 < 5) {
                    p3();
                } else {
                    this.Q4.setText(String.valueOf(e3));
                }
                e3.printStackTrace();
            }
        } catch (IOException e4) {
            if (this.B4 < 5) {
                p3();
            } else {
                this.Q4.setText(String.valueOf(e4));
            }
            e4.printStackTrace();
        }
    }

    public final /* synthetic */ void W2(DialogInterface dialogInterface) {
        this.o4 = false;
    }

    public final void X2(int i2, int i3, int i4, int i5, ArrayList arrayList, String str, List list, boolean z2, String str2) {
        Object obj;
        boolean z3;
        ArrayList arrayList2;
        String str3;
        ExoPlayerMoviesSeries exoPlayerMoviesSeries;
        int i6;
        int i7;
        int i8;
        int i9;
        List list2;
        if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
            if (str.equals("movies")) {
                obj = null;
                z3 = false;
                str3 = "movies";
                list2 = null;
                exoPlayerMoviesSeries = this;
                i6 = i2;
                i7 = i3;
                i8 = i4;
                i9 = i5;
                arrayList2 = arrayList;
            } else {
                if (!str.equals("series")) {
                    return;
                }
                obj = null;
                z3 = true;
                arrayList2 = null;
                str3 = "series";
                exoPlayerMoviesSeries = this;
                i6 = i2;
                i7 = i3;
                i8 = i4;
                i9 = i5;
                list2 = list;
            }
            exoPlayerMoviesSeries.M2(i6, i7, i8, i9, arrayList2, str3, list2, obj, z3, str2);
            return;
        }
        List a2 = Listsingleton.b().a();
        Dialog dialog = new Dialog(this, a7.k.g);
        dialog.requestWindowFeature(1);
        dialog.setContentView(a7.g.N1);
        dialog.getWindow().setBackgroundDrawable((Drawable) null);
        dialog.getWindow().setLayout(-1, -2);
        dialog.setCancelable(false);
        ImageView findViewById = dialog.findViewById(a7.f.L4);
        ImageView findViewById2 = dialog.findViewById(a7.f.W4);
        this.w = dialog.findViewById(a7.f.C7);
        if (findViewById.getVisibility() == 0) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        findViewById2.setOnClickListener(new u(dialog, i2, i3, i4, i5, arrayList, str, list, str2));
        this.w.setOnClickListener(new v(dialog, i2, i3, i4, i5, arrayList, str, list, str2));
        findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
        findViewById2.setOnFocusChangeListener(new k(findViewById2));
        findViewById2.setNextFocusUpId(a7.f.W4);
        findViewById2.setNextFocusDownId(a7.f.W4);
        findViewById2.setNextFocusRightId(a7.f.W4);
        findViewById2.setNextFocusLeftId(a7.f.W4);
        findViewById2.requestFocus();
        if (a2 != null) {
            try {
                if (a2.size() > 0) {
                    if (a2.size() > m7.a.k1) {
                        com.squareup.picasso.t.q(this.I2).l((String) a2.get(m7.a.k1)).g(findViewById);
                        m7.a.k1++;
                    } else {
                        com.squareup.picasso.t.q(this.I2).l((String) a2.get(0)).g(findViewById);
                        m7.a.k1 = 1;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        dialog.show();
        findViewById2.requestFocus();
        dialog.getWindow().setBackgroundDrawableResource(a7.c.z);
    }

    public void Y2() {
        if (this.i2 == null) {
            return;
        }
        v2(0);
        int i2 = Build.VERSION.SDK_INT;
        Rational rational = new Rational(this.i2.getWidth(), this.i2.getHeight());
        Log.i("aspectRatioIS", "ratio:" + rational);
        if (i2 >= 26) {
            try {
                p7.n.a(p7.m.a(this.k4, rational));
                p7.o.a(this, p7.n.a(this.k4));
                Log.i("calledPictureIN", "calledTry");
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
                Log.i("calledPictureIN", "calledCatch" + e2.toString());
                try {
                    p7.n.a(p7.m.a(this.k4, new Rational(547, 307)));
                    p7.o.a(this, p7.n.a(this.k4));
                } catch (Exception unused) {
                    System.out.println(e2.getMessage());
                }
            }
        }
    }

    public final void Z2() {
        int d2 = x7.a.f().d();
        String str = this.b2;
        str.hashCode();
        if (str.equals("series")) {
            Log.i("sizeIS", "size:" + this.n3.size());
            List list = this.n3;
            if (list != null && list.size() > 0 && d2 == this.n3.size() - 1) {
                Log.i("sizeIShere", "sizeIS:" + this.n3.size());
                x7.a.f().w(0);
                return;
            }
        }
        x7.a.f().w(d2 + 1);
    }

    public void a3(String str) {
        R2();
        this.D3.b(a7.f.G).e();
        this.D3.b(a7.f.K).c(str);
    }

    public final void b3(String str) {
        this.O4.setVisibility(0);
        a5.setVisibility(8);
        this.M4.setVisibility(8);
        this.D4.dismiss();
        this.L4.setText(str);
        this.O4.setText("No subtitles found");
    }

    public final void c3() {
        this.s0.setOnClickListener(this);
        this.t0.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.q0.setOnClickListener(this);
        this.k2.setOnClickListener(this);
        this.h2.setOnClickListener(this);
        this.l1.setOnClickListener(this);
        this.C0.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.r0.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.u0.setOnClickListener(this);
        this.v0.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.x0.setOnClickListener(this);
        this.A0.setOnClickListener(this);
        this.P0.setOnClickListener(this);
        this.Q0.setOnClickListener(this);
        this.B0.setOnClickListener(this);
        this.n0.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        this.c1.setOnClickListener(this);
        this.U.setOnClickListener(this);
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

    public final void d3() {
        I1 i1;
        try {
            if (!this.r3.booleanValue() || (i1 = this.r) == null) {
                return;
            }
            i1.play();
        } catch (Exception unused) {
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.i2.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final void e3(ArrayList arrayList, int i2) {
        String str;
        String str2;
        SharedPreferences.Editor editor;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        E3();
        z3();
        u2(5000);
        Log.i("openedStreamID", "id:" + i2);
        int I2 = I2(arrayList, i2);
        String name = ((LiveStreamsDBModel) arrayList.get(I2)).getName();
        this.Z3 = ((LiveStreamsDBModel) arrayList.get(I2)).getStreamIcon();
        this.Y3 = name;
        this.b4 = m7.w.r0(String.valueOf(((LiveStreamsDBModel) arrayList.get(I2)).getMovieElapsedTime()));
        m7.w.S0(w7.k.a() + w7.k.i());
        ((LiveStreamsDBModel) arrayList.get(I2)).getNum();
        int q0 = m7.w.q0(((LiveStreamsDBModel) arrayList.get(I2)).getStreamId());
        int i3 = this.u3;
        this.a2 = ((LiveStreamsDBModel) arrayList.get(I2)).getContaiinerExtension();
        ((LiveStreamsDBModel) arrayList.get(I2)).getCategoryId();
        this.s3 = m7.w.q0(((LiveStreamsDBModel) arrayList.get(I2)).getStreamId());
        x7.a.f().w(I2);
        this.F1 = ((LiveStreamsDBModel) arrayList.get(I2)).getCategoryId();
        this.G1 = ((LiveStreamsDBModel) arrayList.get(I2)).getName();
        int H3 = this.k3.equals("m3u") ? H3(String.valueOf(Uri.parse(this.R2)), SharepreferenceDBHandler.getUserID(this.I2)) : G3(q0, SharepreferenceDBHandler.getUserID(this.I2));
        SharedPreferences.Editor editor2 = this.f3;
        if (editor2 != null) {
            editor2.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) arrayList.get(I2)).getStreamId()));
            this.f3.apply();
        }
        String str3 = this.b2;
        if (str3 != null && str3.equals("movies") && (editor = this.f3) != null) {
            editor.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) arrayList.get(I2)).getStreamId()));
            this.f3.apply();
        }
        SharedPreferences.Editor editor3 = this.g3;
        if (editor3 != null) {
            editor3.putString("currentlyPlayingVideoPosition", String.valueOf(I2));
            this.g3.apply();
        }
        SimpleDateFormat simpleDateFormat = this.R1;
        if (E2(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.I2))), this.T1.format(this.S1)) >= w7.c.p() && (str = this.W1) != null && this.X1 != null && (!W4.equals(str) || (this.W1 != null && (str2 = this.X1) != null && !X4.equals(str2)))) {
            this.r3 = Boolean.FALSE;
        }
        this.p3 = q0;
        this.V0.setText(name);
        Log.i("streamCheck", "streamCHK:" + H3);
        if (!m7.a.V0.booleanValue() || !m7.a.e1.equalsIgnoreCase("1")) {
            M2(i3, H3, I2, q0, arrayList, "movies", null, null, false, "");
        } else if (SharepreferenceDBHandler.getEventAdsView(this) < m7.a.f1) {
            M2(i3, H3, I2, q0, arrayList, "movies", null, null, false, "");
            SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(this) + 1, this);
        } else {
            SharepreferenceDBHandler.setEventAdsView(0, this);
            X2(i3, H3, I2, q0, arrayList, "movies", null, false, "");
        }
    }

    public final void f3(ArrayList arrayList, String str) {
        String str2;
        String str3;
        SharedPreferences.Editor editor;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        E3();
        z3();
        u2(5000);
        Log.i("openedStreamID", "id:" + str);
        int J2 = J2(arrayList, str);
        String name = ((LiveStreamsDBModel) arrayList.get(J2)).getName();
        this.Z3 = ((LiveStreamsDBModel) arrayList.get(J2)).getStreamIcon();
        this.Y3 = name;
        this.b4 = m7.w.r0(String.valueOf(((LiveStreamsDBModel) arrayList.get(J2)).getMovieElapsedTime()));
        this.A3 = ((LiveStreamsDBModel) arrayList.get(J2)).getUrl();
        m7.w.S0(w7.k.a() + w7.k.i());
        ((LiveStreamsDBModel) arrayList.get(J2)).getNum();
        String streamIdOneStream = ((LiveStreamsDBModel) arrayList.get(J2)).getStreamIdOneStream();
        int i2 = this.u3;
        this.a2 = ((LiveStreamsDBModel) arrayList.get(J2)).getContaiinerExtension();
        ((LiveStreamsDBModel) arrayList.get(J2)).getCategoryId();
        this.s3 = m7.w.q0(((LiveStreamsDBModel) arrayList.get(J2)).getStreamId());
        x7.a.f().w(J2);
        this.F1 = ((LiveStreamsDBModel) arrayList.get(J2)).getCategoryId();
        this.G1 = ((LiveStreamsDBModel) arrayList.get(J2)).getName();
        int I3 = I3(streamIdOneStream, SharepreferenceDBHandler.getUserID(this.I2));
        SharedPreferences.Editor editor2 = this.f3;
        if (editor2 != null) {
            editor2.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) arrayList.get(J2)).getStreamId()));
            this.f3.apply();
        }
        String str4 = this.b2;
        if (str4 != null && str4.equals("movies") && (editor = this.f3) != null) {
            editor.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) arrayList.get(J2)).getStreamId()));
            this.f3.apply();
        }
        SharedPreferences.Editor editor3 = this.g3;
        if (editor3 != null) {
            editor3.putString("currentlyPlayingVideoPosition", String.valueOf(J2));
            this.g3.apply();
        }
        SimpleDateFormat simpleDateFormat = this.R1;
        if (E2(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.I2))), this.T1.format(this.S1)) >= w7.c.p() && (str2 = this.W1) != null && this.X1 != null && (!W4.equals(str2) || (this.W1 != null && (str3 = this.X1) != null && !X4.equals(str3)))) {
            this.r3 = Boolean.FALSE;
        }
        this.q3 = streamIdOneStream;
        this.V0.setText(name);
        Log.i("streamCheck", "streamCHK:" + I3);
        if (!m7.a.V0.booleanValue() || !m7.a.e1.equalsIgnoreCase("1")) {
            M2(i2, I3, J2, 0, arrayList, "movies", null, null, false, streamIdOneStream);
        } else if (SharepreferenceDBHandler.getEventAdsView(this) < m7.a.f1) {
            M2(i2, I3, J2, 0, arrayList, "movies", null, null, false, streamIdOneStream);
            SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(this) + 1, this);
        } else {
            SharepreferenceDBHandler.setEventAdsView(0, this);
            X2(i2, I3, J2, 0, arrayList, "movies", null, false, streamIdOneStream);
        }
    }

    public final void g3(ArrayList arrayList, int i2) {
        String str;
        String str2;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        String name = ((File) arrayList.get(i2)).getName();
        String S0 = m7.w.S0(w7.k.a() + w7.k.i());
        SimpleDateFormat simpleDateFormat = this.R1;
        if (E2(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.I2))), this.T1.format(this.S1)) >= w7.c.p() && (str = this.W1) != null && this.X1 != null && (!W4.equals(str) || (this.W1 != null && (str2 = this.X1) != null && !X4.equals(str2)))) {
            this.r3 = Boolean.FALSE;
            this.D3.b(a7.f.G).e();
            this.D3.b(a7.f.K).c(S0 + this.U1 + this.V1);
        }
        if (this.r3.booleanValue()) {
            x7.a.f().w(i2);
            this.V0.setText(name);
            q3();
            this.X3 = this.k;
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

    public final void h3(List list, int i2, boolean z2) {
        String str;
        String str2;
        SharedPreferences.Editor editor;
        if (list == null || list.size() <= 0) {
            Log.i("sizeIs", "lessThanZero");
            return;
        }
        if (this.r != null && this.s3 == i2) {
            Log.i("calledSeriesCase", "ifCalled");
            if (!z2) {
                return;
            }
        }
        E3();
        z3();
        u2(5000);
        Log.i("calledMethod", "firstTimeSeries");
        int K2 = K2(list, i2);
        String title = ((GetEpisdoeDetailsCallback) list.get(K2)).getTitle();
        this.Z3 = ((GetEpisdoeDetailsCallback) list.get(K2)).getMovieImage();
        this.Y3 = title;
        this.a4 = String.valueOf(((GetEpisdoeDetailsCallback) list.get(K2)).getSeasonNumber());
        this.b4 = m7.w.r0(((GetEpisdoeDetailsCallback) list.get(K2)).getElapsed_time());
        this.c4 = ((GetEpisdoeDetailsCallback) list.get(K2)).getSeasonNumber().intValue();
        Log.i("calledSeriesCase", "session:" + ((GetEpisdoeDetailsCallback) list.get(K2)).getSeasonNumber());
        m7.w.S0(w7.k.a() + w7.k.i());
        ((GetEpisdoeDetailsCallback) list.get(K2)).getId();
        int q0 = m7.w.q0(((GetEpisdoeDetailsCallback) list.get(K2)).getId());
        int i3 = this.u3;
        this.a2 = ((GetEpisdoeDetailsCallback) list.get(K2)).getContainerExtension();
        ((GetEpisdoeDetailsCallback) list.get(K2)).getCategoryId();
        this.o3 = ((GetEpisdoeDetailsCallback) list.get(K2)).getId();
        this.F1 = ((GetEpisdoeDetailsCallback) list.get(K2)).getCategoryId();
        this.G1 = ((GetEpisdoeDetailsCallback) list.get(K2)).getSeriesName();
        x7.a.f().w(K2);
        int h2 = this.i.h(this.o3, SharepreferenceDBHandler.getUserID(this.I2));
        SharedPreferences.Editor editor2 = this.f3;
        if (editor2 != null) {
            editor2.putString("currentlyPlayingVideo", String.valueOf(((GetEpisdoeDetailsCallback) list.get(K2)).getId()));
            this.f3.apply();
        }
        String str3 = this.b2;
        if (str3 != null && str3.equals("series") && (editor = this.f3) != null) {
            editor.putString("currentlyPlayingVideo", String.valueOf(((GetEpisdoeDetailsCallback) list.get(K2)).getId()));
            this.f3.apply();
        }
        SharedPreferences.Editor editor3 = this.g3;
        if (editor3 != null) {
            editor3.putString("currentlyPlayingVideoPosition", String.valueOf(K2));
            this.g3.apply();
        }
        SimpleDateFormat simpleDateFormat = this.R1;
        if (E2(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.I2))), this.T1.format(this.S1)) >= w7.c.p() && (str = this.W1) != null && this.X1 != null && (!W4.equals(str) || (this.W1 != null && (str2 = this.X1) != null && !X4.equals(str2)))) {
            this.r3 = Boolean.FALSE;
        }
        this.p3 = q0;
        this.V0.setText(title);
        if (!m7.a.V0.booleanValue() || !m7.a.e1.equalsIgnoreCase("1")) {
            M2(i3, h2, K2, q0, null, "series", list, null, z2, "");
        } else if (SharepreferenceDBHandler.getEventAdsView(this) < m7.a.f1) {
            M2(i3, h2, K2, q0, null, "series", list, null, z2, "");
            SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(this) + 1, this);
        } else {
            SharepreferenceDBHandler.setEventAdsView(0, this);
            X2(i3, h2, K2, q0, null, "series", list, z2, "");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:60|(2:86|87)|62|63|64|(3:65|66|67)|68|69|70|71|(3:73|(1:75)|76)|77|78) */
    /* JADX WARN: Removed duplicated region for block: B:73:0x03e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i3(java.util.List r19, java.lang.String r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 1199
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.i3(java.util.List, java.lang.String, boolean):void");
    }

    public boolean isPlaying() {
        return false;
    }

    public final void j3() {
        String str;
        MediaInfo a2;
        o4.e eVar;
        try {
            String type = SharepreferenceDBHandler.getType(this.I2);
            str = "";
            if (type.equals("loadurl")) {
                String str2 = this.L3;
                this.M3 = str2;
                int lastIndexOf = str2.lastIndexOf(47);
                str = lastIndexOf > 1 ? this.M3.substring(lastIndexOf + 1) : "";
                String str3 = this.M3;
                this.X3 = str3;
                a2 = i7.a.a(str, "", "", 0, str3, "videos/mp4", this.Z3, "", (List) null);
                eVar = this.V3;
            } else {
                int ipAddress = ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress();
                String format = String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
                String str4 = ".";
                if (type.equals("devicedata")) {
                    this.M3 = this.L3;
                }
                int lastIndexOf2 = this.M3.lastIndexOf(47);
                if (lastIndexOf2 > 1) {
                    str = this.M3.substring(lastIndexOf2 + 1);
                    str4 = this.M3.substring(0, lastIndexOf2);
                }
                String str5 = str;
                this.d.b();
                this.d.a(format, str4);
                String str6 = "http://" + format + ":8080/" + str5;
                this.X3 = str6;
                a2 = i7.a.a(str5, "", "", 0, str6, "videos/mp4", this.Z3, "", (List) null);
                eVar = this.V3;
            }
            i7.a.c(0, true, a2, eVar, this.I2);
        } catch (Exception unused) {
        }
    }

    public void k3(String str, int i2, String str2, String str3, String str4, String str5) {
        if (this.r != null) {
            RelativeLayout relativeLayout = this.g0;
            if (relativeLayout != null) {
                relativeLayout.startAnimation(this.h);
                this.g0.setVisibility(8);
            }
            this.z3 = str2;
            TextView textView = this.V0;
            if (textView != null) {
                textView.setText(str2);
            }
            SeekBar seekBar = this.C0;
            if (seekBar != null) {
                seekBar.setProgress(0);
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.I2).equals("onestream_api")) {
                i3(this.n3, str4, false);
            } else {
                h3(this.n3, i2, false);
            }
        }
    }

    public final void l3() {
        try {
            SharedPreferences.Editor edit = this.S3.edit();
            this.T3 = edit;
            if (edit != null) {
                edit.putString("pref.using_playback_speed", "1x (Normal)");
                this.T3.apply();
            }
            this.O0.setText(getResources().getString(a7.j.n7) + " (1x)");
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3() {
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
            android.content.SharedPreferences r7 = r0.S3
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
            com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries$l r2 = new com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries$l
            r2.<init>()
            r5.l(r1, r3, r2)
            androidx.appcompat.app.a r1 = r5.create()
            r0.g4 = r1
            com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries$m r2 = new com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries$m
            r2.<init>()
            r1.setOnDismissListener(r2)
            androidx.appcompat.app.a r1 = r0.g4
            r1.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.m3():void");
    }

    public final void n3(String str) {
        SharedPreferences.Editor edit = this.S3.edit();
        this.T3 = edit;
        if (edit != null) {
            edit.putString("pref.using_playback_speed", str);
            this.T3.apply();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:229:? A[ADDED_TO_REGION, REMOVE, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x01ee A[PHI: r28
      0x01ee: PHI (r28v4 java.lang.String) = 
      (r28v3 java.lang.String)
      (r28v3 java.lang.String)
      (r28v3 java.lang.String)
      (r28v3 java.lang.String)
      (r28v3 java.lang.String)
      (r28v5 java.lang.String)
     binds: [B:292:0x0212, B:294:0x0218, B:296:0x0220, B:298:0x022a, B:290:0x020d, B:244:0x01ec] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0077 A[PHI: r24
      0x0077: PHI (r24v10 java.lang.String) = (r24v6 java.lang.String), (r24v7 java.lang.String), (r24v8 java.lang.String), (r24v11 java.lang.String) binds: [B:323:0x009b, B:320:0x008e, B:317:0x0081, B:5:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x050d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o3() {
        /*
            Method dump skipped, instructions count: 2576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.o3():void");
    }

    public void onBackPressed() {
        RelativeLayout relativeLayout = this.p0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            F3();
            return;
        }
        if (this.l2.getVisibility() == 0) {
            this.l2.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.n0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            this.n0.setVisibility(8);
            this.W.setVisibility(8);
            this.W.startAnimation(this.h);
            this.n0.startAnimation(this.h);
            this.z1.setChecked(false);
            this.A1.setChecked(false);
            this.B1.setChecked(false);
            this.C1.setChecked(false);
            this.u1.setChecked(false);
            this.v1.setChecked(false);
            this.w1.setChecked(false);
            this.x1.setChecked(false);
            this.y1.setChecked(false);
            this.q1.setChecked(false);
            this.r1.setChecked(false);
            this.s1.setChecked(false);
            this.t1.setChecked(false);
            this.D1.setText("");
            return;
        }
        RelativeLayout relativeLayout3 = this.g0;
        if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0) {
            this.g0.startAnimation(this.h);
            this.g0.setVisibility(8);
            return;
        }
        E3();
        if (this.h0.getVisibility() == 0) {
            this.h0.startAnimation(this.P2);
            this.h0.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout4 = this.n0;
        if (relativeLayout4 != null && relativeLayout4.getVisibility() == 0) {
            this.n0.setVisibility(8);
            this.W.setVisibility(8);
            this.W.startAnimation(this.h);
            this.n0.startAnimation(this.h);
            this.z1.setChecked(false);
            this.A1.setChecked(false);
            this.B1.setChecked(false);
            this.C1.setChecked(false);
            this.u1.setChecked(false);
            this.v1.setChecked(false);
            this.w1.setChecked(false);
            this.x1.setChecked(false);
            this.y1.setChecked(false);
            this.q1.setChecked(false);
            this.r1.setChecked(false);
            this.s1.setChecked(false);
            this.t1.setChecked(false);
            this.D1.setText("");
            return;
        }
        if (this.l.getVisibility() != 0) {
            m7.a.m0 = true;
            if (this.m.equals("mobile") && this.j4 && this.n4) {
                try {
                    Log.i("pictureMethod", "calledHere");
                    Y2();
                    return;
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            }
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
            return;
        }
        if (this.l.getVisibility() == 0) {
            this.l.startAnimation(this.h);
            if (this.H.getVisibility() == 0) {
                this.H.startAnimation(this.h);
            }
            if (this.P0.getVisibility() == 0) {
                this.P0.startAnimation(this.h);
            }
            if (this.J.getVisibility() == 0) {
                this.J.startAnimation(this.h);
            }
            if (this.Q0.getVisibility() == 0) {
                this.Q0.startAnimation(this.h);
            }
            if (this.I.getVisibility() == 0) {
                this.I.startAnimation(this.h);
            }
            this.l.setVisibility(8);
            if (this.H.getVisibility() == 0) {
                this.H.setVisibility(8);
            }
            if (this.P0.getVisibility() == 0) {
                this.P0.setVisibility(8);
            }
            if (this.J.getVisibility() == 0) {
                this.J.setVisibility(8);
            }
            if (this.Q0.getVisibility() == 0) {
                this.Q0.setVisibility(8);
            }
            if (this.I.getVisibility() == 0) {
                this.I.setVisibility(8);
            }
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        CheckBox checkBox;
        boolean isChecked = ((CheckBox) compoundButton).isChecked();
        int id = compoundButton.getId();
        if (id == a7.f.V1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.z1;
            }
        } else if (id == a7.f.X1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.A1;
            }
        } else if (id == a7.f.Y1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.B1;
            }
        } else if (id == a7.f.W1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.C1;
            }
        } else if (id == a7.f.e2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.q1;
            }
        } else if (id == a7.f.g2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.r1;
            }
        } else if (id == a7.f.h2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.s1;
            }
        } else if (id == a7.f.f2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.t1;
            }
        } else if (id == a7.f.a2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.u1;
            }
        } else if (id == a7.f.c2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.v1;
            }
        } else if (id == a7.f.d2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.w1;
            }
        } else if (id == a7.f.b2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.x1;
            }
        } else if (id != a7.f.Z1 || !isChecked) {
            return;
        } else {
            checkBox = this.y1;
        }
        this.J1 = checkBox.getText().toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x06ba  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x06d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r18) {
        /*
            Method dump skipped, instructions count: 2641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.onClick(android.view.View):void");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        s2(configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0692 A[Catch: Exception -> 0x0698, TRY_LEAVE, TryCatch #2 {Exception -> 0x0698, blocks: (B:41:0x0683, B:43:0x0692), top: B:40:0x0683 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0836  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x08a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0910  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x08c5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x07c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r20) {
        /*
            Method dump skipped, instructions count: 2422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
        this.q = true;
        try {
            if (this.G4 != null) {
                p0.a.b(this.I2).e(this.G4);
            }
        } catch (Exception e2) {
            Log.e("fsgd", "fdfh", e2);
        }
        try {
            q3();
        } catch (Exception unused) {
        }
        try {
            Thread thread = this.y3;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.y3.interrupt();
        } catch (Exception unused2) {
        }
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        boolean z2 = keyEvent.getRepeatCount() == 0;
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
                                                    if (this.h0.getVisibility() != 0 && this.g0.getVisibility() != 0 && this.i0.getVisibility() != 0 && this.i0.getVisibility() != 0) {
                                                        this.l.getVisibility();
                                                        this.n0.getVisibility();
                                                    }
                                                    return true;
                                                case 20:
                                                    E3();
                                                    if (this.h0.getVisibility() != 0 && this.g0.getVisibility() != 0 && this.i0.getVisibility() != 0 && this.i0.getVisibility() != 0 && this.n0.getVisibility() != 0 && this.l.getVisibility() == 8) {
                                                        this.l.startAnimation(this.g);
                                                        this.l.setVisibility(0);
                                                        this.s0.requestFocus();
                                                        this.t0.requestFocus();
                                                    }
                                                    return true;
                                                case 21:
                                                    E3();
                                                    if (this.h0.getVisibility() == 0 || this.g0.getVisibility() == 0) {
                                                        return false;
                                                    }
                                                    if (this.i0.getVisibility() == 0 || this.i0.getVisibility() == 0 || this.n0.getVisibility() == 0) {
                                                        return true;
                                                    }
                                                    if (this.l.getVisibility() == 8) {
                                                        this.l.startAnimation(this.g);
                                                        this.l.setVisibility(0);
                                                        if (!this.C0.isFocused()) {
                                                            this.C0.requestFocus();
                                                        }
                                                    }
                                                    if (this.C0.isFocused()) {
                                                        F3();
                                                    } else {
                                                        u2(5000);
                                                    }
                                                    return true;
                                                case 22:
                                                    E3();
                                                    if (this.h0.getVisibility() == 0 || this.g0.getVisibility() == 0) {
                                                        return false;
                                                    }
                                                    if (this.i0.getVisibility() == 0 || this.i0.getVisibility() == 0 || this.n0.getVisibility() == 0) {
                                                        return true;
                                                    }
                                                    if (this.l.getVisibility() == 8) {
                                                        this.l.startAnimation(this.g);
                                                        this.l.setVisibility(0);
                                                        if (!this.C0.isFocused()) {
                                                            this.C0.requestFocus();
                                                        }
                                                    }
                                                    if (this.C0.isFocused()) {
                                                        F3();
                                                    } else {
                                                        u2(5000);
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
                                E3();
                                if (this.l.getVisibility() == 8) {
                                    this.l.startAnimation(this.g);
                                    this.l.setVisibility(0);
                                    if (!this.C0.isFocused()) {
                                        this.C0.requestFocus();
                                    }
                                }
                                u2(5000);
                                this.C0.setProgress(this.C0.getProgress() + 10);
                            } catch (Exception unused) {
                            }
                            return true;
                        }
                        try {
                            E3();
                            if (this.l.getVisibility() == 8) {
                                this.l.startAnimation(this.g);
                                this.l.setVisibility(0);
                                if (!this.C0.isFocused()) {
                                    this.C0.requestFocus();
                                }
                            }
                            u2(5000);
                            this.C0.setProgress(this.C0.getProgress() - 10);
                        } catch (Exception unused2) {
                        }
                        return true;
                    }
                }
                if (this.n0.getVisibility() == 0) {
                    return true;
                }
                if (this.r == null) {
                    P3();
                } else if (this.h0.getVisibility() == 8) {
                    (this.r.isPlaying() ? this.t0 : this.s0).performClick();
                }
                return true;
            }
            I1 i1 = this.r;
            if (i1 != null) {
                ((!z2 || i1.isPlaying()) ? this.t0 : this.s0).performClick();
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
        this.q = true;
        String str = this.b2;
        if (str == null || !str.equals("movies")) {
            String str2 = this.b2;
            if (str2 != null && str2.equals("series")) {
                A2();
            }
        } else {
            r3(0);
        }
        getIntent().getAction();
        try {
            o4.b bVar = this.W3;
            if (bVar != null) {
                bVar.c().e(this.e4, o4.e.class);
            }
        } catch (Exception unused) {
        }
    }

    public void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        try {
            super/*androidx.activity.ComponentActivity*/.onPictureInPictureModeChanged(z2, configuration);
            if (z2) {
                m7.a.p1 = true;
                PlayerView playerView = this.i2;
                if (playerView != null && playerView.a != null) {
                    playerView.setShowOrHideSubtitles("gone");
                    this.i2.a.setVisibility(8);
                }
                o oVar = new o();
                this.h4 = oVar;
                registerReceiver(oVar, new IntentFilter("media_control"));
                return;
            }
            T4 = true;
            unregisterReceiver(this.h4);
            this.i4 = false;
            this.h4 = null;
            PlayerView playerView2 = this.i2;
            if (playerView2 == null || playerView2.a == null) {
                return;
            }
            playerView2.setShowOrHideSubtitles("visible");
            this.i2.a.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.e*/.onRequestPermissionsResult(i2, strArr, iArr);
        if (iArr.length == 0 || iArr[0] == 0) {
            return;
        }
        B3(a7.j.O7);
        finish();
    }

    public void onResume() {
        Intent intent;
        AppOpsManager appOpsManager;
        super/*androidx.fragment.app.e*/.onResume();
        this.q = false;
        Context context = this.I2;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("auto_start", 0);
            this.m4 = sharedPreferences;
            boolean z2 = sharedPreferences.getBoolean("picinpic", m7.a.u0);
            this.n4 = z2;
            if (z2 && this.m.equals("mobile")) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    this.k4 = p7.v.a();
                }
                if (i2 >= 26) {
                    try {
                        if (getPackageManager().hasSystemFeature("android.software.picture_in_picture") && (appOpsManager = (AppOpsManager) this.I2.getSystemService("appops")) != null && appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), this.I2.getPackageName()) == 0) {
                            this.j4 = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        String str = this.b2;
        if (str == null || !str.equals("series")) {
            String str2 = this.b2;
            if (str2 != null && str2.equals("movies") && (intent = getIntent()) != null && intent.getBooleanExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false)) {
                intent.putExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false);
                setIntent(intent);
                if (getIntent().getIntExtra("OPENED_STREAM_ID", 0) != this.s3 && !getIntent().getSerializableExtra("ONESTREAM_STREAM_ID").equals(this.t3)) {
                    this.l3 = VodAllCategoriesSingleton.getInstance().getvodList();
                    o3();
                }
            }
        } else {
            Intent intent2 = getIntent();
            if (intent2 != null && intent2.getBooleanExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false)) {
                intent2.putExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false);
                setIntent(intent2);
                if (getIntent().getIntExtra("OPENED_STREAM_ID", 0) != this.s3 && !getIntent().getSerializableExtra("ONESTREAM_STREAM_ID").equals(this.t3)) {
                    this.n3 = EpisodesUsingSinglton.getInstance().getEpisodeList();
                    o3();
                }
            }
        }
        m7.w.m(this.I2);
        if (this.r != null) {
            T2();
            if (this.e2) {
                Y4 = false;
            }
        }
        o4.b bVar = this.W3;
        if (bVar != null) {
            bVar.c().a(this.e4, o4.e.class);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        U3();
        T3();
        bundle.putBundle("track_selector_parameters", this.r4.h());
        bundle.putBoolean("auto_play", this.t4);
        bundle.putInt("window", this.u4);
        bundle.putLong("position", this.v4);
    }

    public void onStart() {
        PlayerView playerView;
        super.onStart();
        if (k0.a <= 23 || (playerView = this.i2) == null) {
            return;
        }
        playerView.D();
    }

    public void onStop() {
        super.onStop();
        try {
            this.q = true;
            q3();
            if (this.m.equals("mobile") && this.j4 && this.n4) {
                finishAndRemoveTask();
            }
        } catch (Exception e2) {
            Log.e("loggg", "exception");
            Log.e("loggg", e2.getMessage());
        }
    }

    public void onUserLeaveHint() {
        if (this.m.equals("mobile") && this.j4 && this.n4 && !p7.s.a(this)) {
            try {
                Y2();
                this.i4 = true;
            } catch (Exception unused) {
            }
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super/*android.app.Activity*/.onWindowFocusChanged(z2);
        T2();
        if (z2) {
            s2(getResources().getConfiguration());
        }
    }

    public final void p3() {
        if (this.B4 <= 5) {
            Toast.makeText(this.I2, "Api Error, reconnects in 3sec(" + this.B4 + "/5) ", 0).show();
        }
        this.B4++;
        new Handler().postDelayed(new i(), 3000L);
    }

    public void pause() {
    }

    public void r2(Uri uri) {
        long currentPosition = this.r.getCurrentPosition();
        boolean isPlaying = this.r.isPlaying();
        H0 f2 = this.r.f();
        if (f2 == null || f2.c == null) {
            return;
        }
        this.r.w0(new H0.c().m(f2.c.a).k(Collections.singletonList(new H0.k.a(uri).n("application/x-subrip").p(1).i())).a(), false);
        this.r.prepare();
        this.r.seekTo(currentPosition);
        if (isPlaying) {
            this.r.play();
        }
    }

    public final void r3(int i2) {
        long j2;
        int J2;
        Context context;
        ArrayList arrayList;
        long j3;
        I1 i1 = this.r;
        if (i1 != null) {
            if (i2 == 0) {
                this.N3 = this.I2.getSharedPreferences("currentSeekTime", 0);
                try {
                    j3 = (int) this.r.getCurrentPosition();
                } catch (Exception unused) {
                    j3 = 0;
                }
                SharedPreferences sharedPreferences = this.I2.getSharedPreferences("currentSeekTime", 0);
                this.N3 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.O3 = edit;
                edit.putString("currentSeekTime", String.valueOf(j3));
                this.O3.apply();
                j2 = j3;
            } else {
                try {
                    j2 = (int) i1.getCurrentPosition();
                } catch (Exception unused2) {
                    j2 = 0;
                }
            }
            new LiveStreamsDBModel();
            if (this.k3.equals("m3u")) {
                O2(String.valueOf(Uri.parse(this.R2)), SharepreferenceDBHandler.getUserID(this.I2));
                return;
            }
            try {
                if (this.k3.equals("onestream_api")) {
                    if (this.r == null || x7.a.f().m() == null || j2 == -1 || j2 == 0) {
                        return;
                    }
                    Log.i("calledHere", "openedStreamId:" + this.s3 + "userID:" + SharepreferenceDBHandler.getUserID(this.I2));
                    Log.i("calledHere", "playerResumeDBModel:" + new Gson().toJson(SharepreferenceDBHandler.getCurrentAPPType(this.I2).equals("onestream_api") ? P2(this.t3, SharepreferenceDBHandler.getUserID(this.I2)) : N2(this.s3, SharepreferenceDBHandler.getUserID(this.I2))));
                    try {
                        Log.i("seekTime", "time:" + j2);
                    } catch (Exception unused3) {
                    }
                    J2 = SharepreferenceDBHandler.getCurrentAPPType(this.I2).equals("onestream_api") ? J2(this.l3, this.t3) : I2(this.l3, this.s3);
                    D2(SharepreferenceDBHandler.getCurrentAPPType(this.I2).equals("onestream_api") ? ((LiveStreamsDBModel) this.l3.get(J2)).getStreamIdOneStream() : ((LiveStreamsDBModel) this.l3.get(J2)).getStreamId());
                    context = this.I2;
                    arrayList = this.l3;
                } else {
                    if (this.r == null || x7.a.f().k() == -1 || j2 == -1 || j2 == 0) {
                        return;
                    }
                    Log.i("calledHere", "openedStreamId:" + this.s3 + "userID:" + SharepreferenceDBHandler.getUserID(this.I2));
                    Log.i("calledHere", "playerResumeDBModel:" + new Gson().toJson(SharepreferenceDBHandler.getCurrentAPPType(this.I2).equals("onestream_api") ? P2(this.t3, SharepreferenceDBHandler.getUserID(this.I2)) : N2(this.s3, SharepreferenceDBHandler.getUserID(this.I2))));
                    try {
                        Log.i("seekTime", "time:" + j2);
                    } catch (Exception unused4) {
                    }
                    J2 = SharepreferenceDBHandler.getCurrentAPPType(this.I2).equals("onestream_api") ? J2(this.l3, this.t3) : I2(this.l3, this.s3);
                    D2(SharepreferenceDBHandler.getCurrentAPPType(this.I2).equals("onestream_api") ? ((LiveStreamsDBModel) this.l3.get(J2)).getStreamIdOneStream() : ((LiveStreamsDBModel) this.l3.get(J2)).getStreamId());
                    context = this.I2;
                    arrayList = this.l3;
                }
                u3(context, arrayList, J2, j2);
            } catch (Exception unused5) {
            }
            Log.i("calledHere", "ifPart");
        }
    }

    public final void s2(Configuration configuration) {
        PlayerView playerView;
        boolean z2;
        Log.i("methodCalled", "calledMethod");
        View decorView = getWindow().getDecorView();
        if (configuration.orientation == 2) {
            decorView.setSystemUiVisibility(5894);
            playerView = this.i2;
            z2 = false;
        } else {
            decorView.setSystemUiVisibility(256);
            playerView = this.i2;
            z2 = true;
        }
        playerView.setAdjustViewBounds(z2);
    }

    public final void s3() {
        TextView textView;
        StringBuilder sb;
        E3();
        if (x2() || this.r == null || this.m1.getVisibility() != 8) {
            return;
        }
        this.d2.removeCallbacksAndMessages((Object) null);
        String str = this.c2;
        if (str != null && !str.equals("")) {
            this.P3 -= 10000;
        }
        String str2 = this.b2;
        this.P3 = (str2 == null || !str2.equals("catch_up")) ? this.P3 - 10000 : this.P3 - 60000;
        if (this.P3 > 0) {
            textView = this.S0;
            sb = new StringBuilder();
            sb.append("+");
        } else {
            textView = this.S0;
            sb = new StringBuilder();
        }
        sb.append(this.P3 / 1000);
        sb.append("s");
        textView.setText(sb.toString());
        this.P0.setText("");
        this.P0.startAnimation(this.M2);
        this.P0.setVisibility(0);
        if (this.n1.getVisibility() == 8) {
            this.n1.startAnimation(this.L2);
            this.n1.setVisibility(0);
        } else {
            this.n1.startAnimation(this.M2);
        }
        this.d2.postDelayed(new d(), 1000L);
    }

    public void seekTo(int i2) {
    }

    public void start() {
    }

    public void t2() {
        File[] O = m7.w.O(this.I2);
        for (File file : O) {
            if (file.toString().endsWith(".ts")) {
                Arrays.asList(new File[]{file});
            }
        }
        if (O.length > 0) {
            ArrayList arrayList = this.g2;
            if (arrayList != null) {
                arrayList.clear();
            }
            for (File file2 : O) {
                if (file2.toString().endsWith(".ts")) {
                    this.g2.addAll(Arrays.asList(new File[]{file2}));
                }
            }
            Collections.reverse(this.g2);
            this.l4 = this.g2;
        }
    }

    public void t3() {
        TextView textView;
        StringBuilder sb;
        E3();
        if (x2() || this.r == null || this.n1.getVisibility() != 8) {
            return;
        }
        this.d2.removeCallbacksAndMessages((Object) null);
        String str = this.c2;
        if (str != null && !str.equals("")) {
            this.P3 += 10000;
        }
        String str2 = this.b2;
        if (str2 == null || !str2.equals("catch_up")) {
            this.P3 += 10000;
        } else {
            this.P3 += 60000;
        }
        if (this.P3 > 0) {
            textView = this.R0;
            sb = new StringBuilder();
            sb.append("+");
        } else {
            textView = this.R0;
            sb = new StringBuilder();
        }
        sb.append(this.P3 / 1000);
        sb.append("s");
        textView.setText(sb.toString());
        this.Q0.setText("");
        this.Q0.startAnimation(this.M2);
        this.Q0.setVisibility(0);
        if (this.m1.getVisibility() == 8) {
            this.m1.startAnimation(this.L2);
            this.m1.setVisibility(0);
        } else {
            this.m1.startAnimation(this.M2);
        }
        this.d2.postDelayed(new e(), 1000L);
    }

    public final void u2(int i2) {
        if (V4) {
            return;
        }
        try {
            PlayerView playerView = this.i2;
            if (playerView != null) {
                playerView.v = new n();
                PlayerView playerView2 = this.i2;
                playerView2.u.postDelayed(playerView2.v, i2);
            }
        } catch (Exception unused) {
        }
    }

    public void u3(Context context, ArrayList arrayList, int i2, long j2) {
        String num = ((LiveStreamsDBModel) arrayList.get(i2)).getNum();
        String name = ((LiveStreamsDBModel) arrayList.get(i2)).getName();
        String streamType = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamType();
        String streamId = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamId();
        String streamIdOneStream = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamIdOneStream();
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
        this.F1 = ((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId();
        this.G1 = ((LiveStreamsDBModel) arrayList.get(i2)).getName();
        PanelAvailableChannelsPojo panelAvailableChannelsPojo = new PanelAvailableChannelsPojo();
        panelAvailableChannelsPojo.setNum(Integer.valueOf(m7.w.r0(num)));
        panelAvailableChannelsPojo.setName(name);
        panelAvailableChannelsPojo.setStreamType(streamType);
        if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api")) {
            panelAvailableChannelsPojo.setStreamId(streamId);
        } else {
            panelAvailableChannelsPojo.setStreamId(streamIdOneStream);
        }
        panelAvailableChannelsPojo.setStreamIcon(streamIcon);
        panelAvailableChannelsPojo.setEpgChannelId(epgChannelId);
        panelAvailableChannelsPojo.setAdded(added);
        panelAvailableChannelsPojo.setCategoryId(categoryId);
        panelAvailableChannelsPojo.setCustomSid(customSid);
        panelAvailableChannelsPojo.setTvArchive(Integer.valueOf(m7.w.r0(tvArchive)));
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
        int i3 = this.u3;
        if (i3 != 0) {
            try {
                panelAvailableChannelsPojo.setMovieDuration(i3);
            } catch (Exception unused2) {
            }
            panelAvailableChannelsPojo.setRatingFromTen(valueOf);
            panelAvailableChannelsPojo.setRatingFromFive(valueOf2);
            this.U2.addAllAvailableChannel(panelAvailableChannelsPojo);
        }
        I1 i1 = this.r;
        if (i1 != null) {
            int duration = (int) (i1.getDuration() / 1000);
            this.u3 = duration;
            j3 = duration;
        }
        panelAvailableChannelsPojo.setMovieDuration(j3);
        panelAvailableChannelsPojo.setRatingFromTen(valueOf);
        panelAvailableChannelsPojo.setRatingFromFive(valueOf2);
        this.U2.addAllAvailableChannel(panelAvailableChannelsPojo);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v1() {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.v1():void");
    }

    public void v2(int i2) {
        if (V4) {
            return;
        }
        this.i2.v = new p();
        PlayerView playerView = this.i2;
        playerView.u.postDelayed(playerView.v, i2);
    }

    public final void v3() {
        RecyclerView recyclerView = this.p1;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.I2, 1);
            this.H2 = gridLayoutManager;
            this.p1.setLayoutManager(gridLayoutManager);
            this.p1.setItemAnimator(new androidx.recyclerview.widget.c());
        }
    }

    public void w2() {
        this.L1 = new ArrayList();
        this.M1 = new JsonArray();
        if (this.u1.isChecked()) {
            this.L1.add(this.u1.getText().toString());
            this.M1.add(this.u1.getText().toString());
        }
        if (this.v1.isChecked()) {
            this.L1.add(this.v1.getText().toString());
            this.M1.add(this.v1.getText().toString());
        }
        if (this.w1.isChecked()) {
            this.L1.add(this.w1.getText().toString());
            this.M1.add(this.w1.getText().toString());
        }
        if (this.x1.isChecked()) {
            this.L1.add(this.x1.getText().toString());
            this.M1.add(this.x1.getText().toString());
        }
        if (this.y1.isChecked()) {
            this.L1.add(this.y1.getText().toString());
            this.M1.add(this.y1.getText().toString());
        }
        if (this.q1.isChecked()) {
            this.L1.add(this.q1.getText().toString());
            this.M1.add(this.q1.getText().toString());
        }
        if (this.r1.isChecked()) {
            this.L1.add(this.r1.getText().toString());
            this.M1.add(this.r1.getText().toString());
        }
        if (this.s1.isChecked()) {
            this.L1.add(this.s1.getText().toString());
            this.M1.add(this.s1.getText().toString());
        }
        if (this.t1.isChecked()) {
            this.L1.add(this.t1.getText().toString());
            this.M1.add(this.t1.getText().toString());
        }
        if (this.z1.isChecked()) {
            this.L1.add(this.z1.getText().toString());
            this.M1.add(this.z1.getText().toString());
        }
        if (this.A1.isChecked()) {
            this.L1.add(this.A1.getText().toString());
            this.M1.add(this.A1.getText().toString());
        }
        if (this.B1.isChecked()) {
            this.L1.add(this.B1.getText().toString());
            this.M1.add(this.B1.getText().toString());
        }
        if (this.C1.isChecked()) {
            this.L1.add(this.C1.getText().toString());
            this.M1.add(this.C1.getText().toString());
        }
        this.N1 = new Gson().toJson(this.M1);
        Log.e("TAG", this.M1 + "");
    }

    public final int w3() {
        int currentPosition = (int) this.r.getCurrentPosition();
        int duration = (int) this.r.getDuration();
        SeekBar seekBar = this.C0;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 1000) / duration));
            }
            this.C0.setSecondaryProgress(this.r.k0() * 10);
        }
        return currentPosition;
    }

    public boolean x2() {
        RelativeLayout relativeLayout = this.i0;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public final void x3() {
        this.e4 = new c();
    }

    public final void y3() {
        this.l.startAnimation(this.h);
        this.l.setVisibility(8);
        this.g0.startAnimation(this.g);
        this.g0.setVisibility(0);
        List list = this.F2;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.W0.setText(getResources().getString(a7.j.J6) + " - " + ((GetEpisdoeDetailsCallback) this.F2.get(0)).getSeasonNumber());
        try {
            v3();
            q7.n nVar = new q7.n(this.I2, null, null, null, "from_player", this.m, this.p1);
            this.G2 = nVar;
            this.p1.setAdapter(nVar);
            this.p1.requestFocus();
        } catch (Exception unused) {
        }
    }

    public void z2() {
        this.t4 = true;
        this.u4 = -1;
        this.v4 = -9223372036854775807L;
    }

    public void z3() {
        ImageView imageView;
        if (V4) {
            this.i2.M();
            this.i2.p(3000);
            return;
        }
        if (!x2() && this.h0.getVisibility() == 8 && this.l.getVisibility() == 8) {
            this.l.startAnimation(this.g);
            this.l.setVisibility(0);
            Log.i("calledHere", "hereForPlayPause");
            try {
                this.P0.setVisibility(0);
                this.Q0.setVisibility(0);
                this.H.setVisibility(0);
                this.I.setVisibility(0);
                if (U4.getVisibility() == 0) {
                    this.J.setVisibility(8);
                } else {
                    this.J.setVisibility(0);
                }
                if (this.r.isPlaying()) {
                    this.t0.setVisibility(0);
                    imageView = this.s0;
                } else {
                    this.s0.setVisibility(0);
                    imageView = this.t0;
                }
                imageView.setVisibility(8);
            } catch (Exception unused) {
            }
        }
    }

    public class c implements o4.y {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0033 A[Catch: Exception -> 0x001c, TryCatch #0 {Exception -> 0x001c, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x0033, B:13:0x0021, B:16:0x002b, B:19:0x003c, B:21:0x0044, B:22:0x006a, B:24:0x008f, B:26:0x0096, B:27:0x00a2), top: B:2:0x0005 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(o4.e r10) {
            /*
                r9 = this;
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.B1(r0, r10)
                java.lang.String r10 = ""
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                android.content.Context r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.D1(r0)     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getType(r0)     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto L1f
                java.lang.String r1 = "local"
                boolean r1 = r0.equals(r1)     // Catch: java.lang.Exception -> L1c
                if (r1 != 0) goto L33
                goto L1f
            L1c:
                r10 = move-exception
                goto Lb9
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
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r10 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.E1(r10)     // Catch: java.lang.Exception -> L1c
                goto Ld3
            L3a:
                if (r0 == 0) goto L6a
                java.lang.String r1 = "series"
                boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto L6a
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1c
                r10.<init>()     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                android.content.res.Resources r0 = r0.getResources()     // Catch: java.lang.Exception -> L1c
                int r1 = a7.j.J6     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Exception -> L1c
                r10.append(r0)     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = " - "
                r10.append(r0)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.F1(r0)     // Catch: java.lang.Exception -> L1c
                r10.append(r0)     // Catch: java.lang.Exception -> L1c
                java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> L1c
            L6a:
                r1 = r10
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r10 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.G1(r10)     // Catch: java.lang.Exception -> L1c
                java.lang.String r2 = ""
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r10 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r4 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.H1(r10)     // Catch: java.lang.Exception -> L1c
                java.lang.String r5 = "videos/mp4"
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r10 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r6 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.I1(r10)     // Catch: java.lang.Exception -> L1c
                java.lang.String r7 = ""
                r8 = 0
                r3 = 0
                com.google.android.gms.cast.MediaInfo r10 = i7.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                O2.I1 r0 = r0.r     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto Ld3
                long r0 = r0.getCurrentPosition()     // Catch: java.lang.Exception -> L1c
                int r1 = (int) r0     // Catch: java.lang.Exception -> L1c
                if (r1 == 0) goto La2
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                O2.I1 r1 = r0.r     // Catch: java.lang.Exception -> L1c
                long r1 = r1.getCurrentPosition()     // Catch: java.lang.Exception -> L1c
                int r2 = (int) r1     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.L1(r0, r2)     // Catch: java.lang.Exception -> L1c
            La2:
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                int r0 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.K1(r0)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r1 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                o4.e r1 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.A1(r1)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r2 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this     // Catch: java.lang.Exception -> L1c
                android.content.Context r2 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.D1(r2)     // Catch: java.lang.Exception -> L1c
                r3 = 1
                i7.a.c(r0, r3, r10, r1, r2)     // Catch: java.lang.Exception -> L1c
                goto Ld3
            Lb9:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onApplicationConnected: "
                r0.append(r1)
                java.lang.String r10 = r10.getMessage()
                r0.append(r10)
                java.lang.String r10 = r0.toString()
                java.lang.String r0 = "honey"
                android.util.Log.e(r0, r10)
            Ld3:
                com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries r10 = com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.this
                r10.invalidateOptionsMenu()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries.c.a(o4.e):void");
        }

        public final void b() {
            ExoPlayerMoviesSeries.this.invalidateOptionsMenu();
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
            TextView textView;
            StringBuilder sb;
            String string;
            ExoPlayerMoviesSeries.B1(ExoPlayerMoviesSeries.this, eVar);
            if (ExoPlayerMoviesSeries.A1(ExoPlayerMoviesSeries.this) != null) {
                ExoPlayerMoviesSeries exoPlayerMoviesSeries = ExoPlayerMoviesSeries.this;
                if (exoPlayerMoviesSeries.r != null) {
                    ExoPlayerMoviesSeries.C1(exoPlayerMoviesSeries);
                    ExoPlayerMoviesSeries.this.r.pause();
                }
                LinearLayout linearLayout = ExoPlayerMoviesSeries.this.O;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                ExoPlayerMoviesSeries exoPlayerMoviesSeries2 = ExoPlayerMoviesSeries.this;
                if (exoPlayerMoviesSeries2.a1 != null) {
                    if (ExoPlayerMoviesSeries.A1(exoPlayerMoviesSeries2).q() == null || ExoPlayerMoviesSeries.A1(ExoPlayerMoviesSeries.this).q().J() == null) {
                        textView = ExoPlayerMoviesSeries.this.a1;
                        sb = new StringBuilder();
                        string = ExoPlayerMoviesSeries.this.getResources().getString(a7.j.v0);
                    } else {
                        textView = ExoPlayerMoviesSeries.this.a1;
                        sb = new StringBuilder();
                        sb.append(ExoPlayerMoviesSeries.this.getResources().getString(a7.j.w0));
                        sb.append(" ");
                        string = ExoPlayerMoviesSeries.A1(ExoPlayerMoviesSeries.this).q().J();
                    }
                    sb.append(string);
                    sb.append("...");
                    textView.setText(sb.toString());
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
