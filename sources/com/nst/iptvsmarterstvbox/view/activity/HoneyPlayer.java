package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.AppOpsManager;
import android.app.PictureInPictureParams;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.util.Rational;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.google.android.gms.cast.MediaInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.EpisodesUsingSinglton;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerCreatePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerDeletePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerShortEPGCallback;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.PanelAvailableChannelsPojo;
import com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.MaintanencePannelActivity;
import com.nst.iptvsmarterstvbox.sbpfunction.callbackclientreport.ClientFeedbackCallback;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m7.w;
import o4.y;
import p7.D;
import p7.E;
import p7.v;
import p7.z0;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HoneyPlayer extends androidx.appcompat.app.b implements View.OnClickListener, z7.j, CompoundButton.OnCheckedChangeListener {
    public static TextView U3 = null;
    public static LinearLayout V3 = null;
    public static String W3 = null;
    public static String X3 = null;
    public static ProgressBar Y3 = null;
    public static boolean Z3 = true;
    public static boolean a4 = false;
    public static boolean b4 = true;
    public RadioGroup A;
    public RelativeLayout A0;
    public String A1;
    public String A2;
    public y A3;
    public RadioGroup B;
    public ImageView B0;
    public LiveStreamDBHandler B2;
    public ArrayList B3;
    public TextView C;
    public ImageView C0;
    public ArrayList C2;
    public Handler C3;
    public TextView D;
    public LinearLayout D0;
    public ArrayList D2;
    public Runnable D3;
    public TextView E;
    public LinearLayout E0;
    public String E1;
    public List E2;
    public androidx.appcompat.app.a E3;
    public ImageView F;
    public LinearLayout F0;
    public BroadcastReceiver F3;
    public LinearLayout G;
    public TextView G0;
    public List G1;
    public LinearLayout H;
    public LinearLayout H0;
    public JsonArray H1;
    public String H2;
    public RecyclerView I;
    public RelativeLayout I0;
    public String I1;
    public PictureInPictureParams.Builder I3;
    public TextView J;
    public RelativeLayout J0;
    public SimpleDateFormat J2;
    public ArrayList J3;
    public TextView K;
    public RelativeLayout K0;
    public Date K2;
    public ProgressBar L;
    public TextView L0;
    public DateFormat L2;
    public SharedPreferences L3;
    public FrameLayout M;
    public CheckBox M0;
    public String M2;
    public TextView N;
    public CheckBox N0;
    public String N2;
    public RelativeLayout O;
    public CheckBox O0;
    public String O2;
    public RelativeLayout P;
    public CheckBox P0;
    public String P2;
    public LinearLayout Q;
    public CheckBox Q0;
    public n7.g Q3;
    public RecyclerView R;
    public CheckBox R0;
    public q7.n R1;
    public TextView S;
    public CheckBox S0;
    public RecyclerView.o S1;
    public TextView T;
    public CheckBox T0;
    public Context T1;
    public TextView U;
    public CheckBox U0;
    public Animation U1;
    public TextView V;
    public RelativeLayout V0;
    public Animation V1;
    public FrameLayout W;
    public CheckBox W0;
    public Animation W1;
    public FrameLayout X;
    public CheckBox X0;
    public Animation X1;
    public SeekBar Y;
    public CheckBox Y0;
    public Animation Y1;
    public SeekBar Z;
    public CheckBox Z0;
    public Animation Z1;
    public TextView a1;
    public Animation a2;
    public LinearLayout b1;
    public Animation b2;
    public t2.a b3;
    public TextView c1;
    public Animation c2;
    public LinearLayout c3;
    public LinearLayout d;
    public TextView d1;
    public Handler d2;
    public SharedPreferences d3;
    public LinearLayout e;
    public LinearLayout e0;
    public TextView e1;
    public String e2;
    public NSTIJKPlayerEpisodes f;
    public LinearLayout f0;
    public TextView f1;
    public ImageView g;
    public TextView g0;
    public TextView g1;
    public SeriesRecentWatchDatabase g2;
    public LinearLayout h;
    public TextView h0;
    public TextView h1;
    public RecentWatchDBHandler h2;
    public LinearLayout i;
    public LinearLayout i0;
    public TextView i1;
    public z0 i2;
    public SharedPreferences i3;
    public ImageView j;
    public TextView j0;
    public TextView j1;
    public SharedPreferences j2;
    public SharedPreferences.Editor j3;
    public ImageView k;
    public TextView k0;
    public EditText k1;
    public SharedPreferences k2;
    public ImageView l;
    public ImageView l0;
    public LinearLayout l1;
    public SharedPreferences l2;
    public SeekBar m;
    public LinearLayout m0;
    public LinearLayout m1;
    public SharedPreferences.Editor m2;
    public LinearLayout n;
    public LinearLayout n0;
    public LinearLayout n1;
    public SharedPreferences n2;
    public LinearLayout o;
    public ImageView o0;
    public LinearLayout o1;
    public SharedPreferences o2;
    public SharedPreferences o3;
    public LinearLayout p;
    public RelativeLayout p0;
    public ImageView p1;
    public SharedPreferences p2;
    public SharedPreferences.Editor p3;
    public ImageView q;
    public ImageView q0;
    public RelativeLayout q1;
    public SharedPreferences q2;
    public SharedPreferences q3;
    public LinearLayout r;
    public TextView r0;
    public LinearLayout r1;
    public SharedPreferences r2;
    public o4.e r3;
    public LinearLayout s;
    public TextView s0;
    public LinearLayout s1;
    public SharedPreferences s2;
    public o4.b s3;
    public LinearLayout t;
    public TextView t0;
    public LinearLayout t1;
    public SharedPreferences.Editor t2;
    public ImageView u;
    public LinearLayout u0;
    public LinearLayout u1;
    public SharedPreferences.Editor u2;
    public ImageView v;
    public TableLayout v0;
    public LinearLayout v1;
    public SharedPreferences.Editor v2;
    public TextView w;
    public LinearLayout w0;
    public RelativeLayout w1;
    public SharedPreferences.Editor w2;
    public TextView x;
    public MediaRouteButton x0;
    public SharedPreferences.Editor x2;
    public LinearLayout y;
    public LinearLayout y0;
    public String y2;
    public RadioGroup z;
    public TextView z0;
    public String z1;
    public String z2;
    public String x1 = "Live";
    public String y1 = "";
    public String B1 = "";
    public String C1 = "";
    public String D1 = "";
    public String F1 = "";
    public String J1 = "";
    public Thread K1 = null;
    public int L1 = 0;
    public boolean M1 = false;
    public boolean N1 = false;
    public boolean O1 = false;
    public int P1 = 0;
    public List Q1 = new ArrayList();
    public String f2 = "";
    public String F2 = "";
    public int G2 = -1;
    public Boolean I2 = Boolean.TRUE;
    public int Q2 = -1;
    public String R2 = "";
    public String S2 = "";
    public int T2 = -1;
    public int U2 = 0;
    public String V2 = "";
    public String W2 = "";
    public String X2 = "";
    public String Y2 = "";
    public String Z2 = "";
    public String a3 = "";
    public String e3 = "";
    public String f3 = "";
    public String g3 = "";
    public String h3 = "";
    public int k3 = 0;
    public float l3 = -1.0f;
    public boolean m3 = false;
    public String n3 = "mobile";
    public String t3 = "";
    public String u3 = "";
    public String v3 = "";
    public String w3 = "";
    public int x3 = 0;
    public int y3 = 0;
    public int z3 = 0;
    public boolean G3 = false;
    public boolean H3 = false;
    public ArrayList K3 = new ArrayList();
    public boolean M3 = m7.a.u0;
    public final i7.c N3 = new i7.c(this);
    public String O3 = "";
    public String P3 = "";
    public String R3 = "";
    public BroadcastReceiver S3 = new h();
    public NSTIJKPlayerEpisodes.M T3 = new n();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            HoneyPlayer.this.f2();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            HoneyPlayer.this.E2();
        }
    }

    public class c implements com.squareup.picasso.e {
        public c() {
        }

        public void a() {
            HoneyPlayer.this.I2();
        }

        public void onSuccess() {
            RelativeLayout relativeLayout = HoneyPlayer.this.A0;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
    }

    public class d implements com.squareup.picasso.e {
        public d() {
        }

        public void a() {
            HoneyPlayer.this.I2();
        }

        public void onSuccess() {
            RelativeLayout relativeLayout = HoneyPlayer.this.A0;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
    }

    public class e implements Callback {
        public e() {
        }

        public void onFailure(Call call, Throwable th) {
            Toast.makeText(HoneyPlayer.this, "Something went Wrong Report not Submited", 0).show();
        }

        public void onResponse(Call call, Response response) {
            Toast makeText;
            HoneyPlayer honeyPlayer;
            String message;
            if (response == null) {
                makeText = Toast.makeText(HoneyPlayer.this, "Something went Wrong Report not Submited", 0);
            } else if (response.body() == null || !response.isSuccessful() || ((ClientFeedbackCallback) response.body()).a() == null) {
                if (response.message() != null && !response.message().equals("")) {
                    honeyPlayer = HoneyPlayer.this;
                    message = response.message();
                    makeText = Toast.makeText(honeyPlayer, message, 0);
                }
                makeText = Toast.makeText(HoneyPlayer.this, "Something went Wrong Report not Submited", 0);
            } else {
                if (((ClientFeedbackCallback) response.body()).a().equalsIgnoreCase("success")) {
                    honeyPlayer = HoneyPlayer.this;
                    message = "Reported Successfully";
                    makeText = Toast.makeText(honeyPlayer, message, 0);
                }
                makeText = Toast.makeText(HoneyPlayer.this, "Something went Wrong Report not Submited", 0);
            }
            makeText.show();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            HoneyPlayer.this.Q.setVisibility(8);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
        }
    }

    public class h extends BroadcastReceiver {
        public h() {
        }

        public void onReceive(Context context, Intent intent) {
            MyApplication.E("onReceive CLOSE_TARGET_ACTIVITY : ");
            if ("pip_mode_switch_user".equals(intent.getAction())) {
                HoneyPlayer.this.finish();
            }
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
            float f;
            switch (i) {
                case 0:
                    HoneyPlayer.G1(HoneyPlayer.this, "0.25x");
                    HoneyPlayer.this.N.setText(HoneyPlayer.this.getResources().getString(a7.j.n7) + " (0.25x)");
                    nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                    f = 0.25f;
                    break;
                case 1:
                    HoneyPlayer.G1(HoneyPlayer.this, "0.5x");
                    HoneyPlayer.this.N.setText(HoneyPlayer.this.getResources().getString(a7.j.n7) + " (0.5x)");
                    nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                    f = 0.5f;
                    break;
                case 2:
                    HoneyPlayer.G1(HoneyPlayer.this, "0.75x");
                    HoneyPlayer.this.N.setText(HoneyPlayer.this.getResources().getString(a7.j.n7) + " (0.75x)");
                    nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                    f = 0.75f;
                    break;
                case 3:
                    HoneyPlayer.G1(HoneyPlayer.this, "1x (Normal)");
                    HoneyPlayer.this.N.setText(HoneyPlayer.this.getResources().getString(a7.j.n7) + " (1x)");
                    nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                    f = 1.0f;
                    break;
                case 4:
                    HoneyPlayer.G1(HoneyPlayer.this, "1.25x");
                    HoneyPlayer.this.N.setText(HoneyPlayer.this.getResources().getString(a7.j.n7) + " (1.25x)");
                    nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                    f = 1.25f;
                    break;
                case 5:
                    HoneyPlayer.G1(HoneyPlayer.this, "1.5x");
                    HoneyPlayer.this.N.setText(HoneyPlayer.this.getResources().getString(a7.j.n7) + " (1.5x)");
                    nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                    f = 1.5f;
                    break;
                case 6:
                    HoneyPlayer.G1(HoneyPlayer.this, "1.75x");
                    HoneyPlayer.this.N.setText(HoneyPlayer.this.getResources().getString(a7.j.n7) + " (1.75x)");
                    nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                    f = 1.75f;
                    break;
                case 7:
                    HoneyPlayer.G1(HoneyPlayer.this, "2x");
                    HoneyPlayer.this.N.setText(HoneyPlayer.this.getResources().getString(a7.j.n7) + " (2x)");
                    nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                    f = 2.0f;
                    break;
                default:
                    return;
            }
            nSTIJKPlayerEpisodes.setSpeed(f);
            dialogInterface.cancel();
        }
    }

    public class k implements DialogInterface.OnDismissListener {
        public k() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
            if (nSTIJKPlayerEpisodes != null) {
                nSTIJKPlayerEpisodes.p2();
            }
        }
    }

    public class l implements Runnable {
        public l() {
        }

        public void run() {
            HoneyPlayer.H1(HoneyPlayer.this);
        }
    }

    public class m extends BroadcastReceiver {
        public m() {
        }

        public void onReceive(Context context, Intent intent) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
            int currentPosition;
            if (intent == null || !"media_control".equals(intent.getAction())) {
                return;
            }
            int intExtra = intent.getIntExtra("control_type", 0);
            if (intExtra == 1) {
                HoneyPlayer.this.f.start();
                return;
            }
            if (intExtra == 2) {
                HoneyPlayer.this.f.pause();
                return;
            }
            if (intExtra != 4) {
                if (intExtra != 5) {
                    return;
                }
                nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                currentPosition = nSTIJKPlayerEpisodes.getCurrentPosition() + 10000;
            } else if (HoneyPlayer.this.f.getCurrentPosition() - 10000 <= 0) {
                HoneyPlayer.this.f.seekTo(0);
                return;
            } else {
                nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                currentPosition = nSTIJKPlayerEpisodes.getCurrentPosition() - 10000;
            }
            nSTIJKPlayerEpisodes.seekTo(currentPosition);
        }
    }

    public class n extends NSTIJKPlayerEpisodes.M {
        public n() {
        }

        public void a() {
        }

        public void b() {
        }
    }

    public class o implements Runnable {
        public o() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Log.e("honey", "count: " + HoneyPlayer.y1(HoneyPlayer.this));
                    if (SharepreferenceDBHandler.getMaintanceModeState(HoneyPlayer.x1(HoneyPlayer.this))) {
                        HoneyPlayer.x1(HoneyPlayer.this).startActivity(new Intent(HoneyPlayer.x1(HoneyPlayer.this), MaintanencePannelActivity.class));
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

    public class p implements View.OnFocusChangeListener {
        public final View a;

        public p(View view) {
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

        /* JADX WARN: Removed duplicated region for block: B:107:0x0205  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFocusChange(android.view.View r27, boolean r28) {
            /*
                Method dump skipped, instructions count: 2162
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.p.onFocusChange(android.view.View, boolean):void");
        }
    }

    public static /* synthetic */ String A1(HoneyPlayer honeyPlayer) {
        return honeyPlayer.w3;
    }

    private void A2() {
        this.A3 = new i();
    }

    public static /* synthetic */ String B1(HoneyPlayer honeyPlayer) {
        return honeyPlayer.u3;
    }

    private void B2() {
        this.c3.startAnimation(this.a2);
        this.c3.setVisibility(8);
        this.O.startAnimation(this.Z1);
        this.O.setVisibility(0);
        List list = this.Q1;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.k0.setText(getResources().getString(a7.j.J6) + " - " + ((GetEpisdoeDetailsCallback) this.Q1.get(0)).getSeasonNumber());
        try {
            z2();
            q7.n nVar = new q7.n(this.T1, null, null, null, "from_player", this.n3, this.R);
            this.R1 = nVar;
            this.R.setAdapter(nVar);
            this.R.requestFocus();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ String C1(HoneyPlayer honeyPlayer) {
        return honeyPlayer.t3;
    }

    public static /* synthetic */ String D1(HoneyPlayer honeyPlayer) {
        return honeyPlayer.v3;
    }

    public static /* synthetic */ int E1(HoneyPlayer honeyPlayer) {
        return honeyPlayer.x3;
    }

    public static /* synthetic */ int F1(HoneyPlayer honeyPlayer, int i2) {
        honeyPlayer.x3 = i2;
        return i2;
    }

    public static /* synthetic */ void G1(HoneyPlayer honeyPlayer, String str) {
        honeyPlayer.u2(str);
    }

    public static /* synthetic */ void H1(HoneyPlayer honeyPlayer) {
        honeyPlayer.e2();
    }

    private void I1(Configuration configuration) {
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
        boolean z;
        View decorView = getWindow().getDecorView();
        if (configuration.orientation == 2) {
            decorView.setSystemUiVisibility(5894);
            nSTIJKPlayerEpisodes = this.f;
            z = false;
        } else {
            decorView.setSystemUiVisibility(256);
            nSTIJKPlayerEpisodes = this.f;
            z = true;
        }
        nSTIJKPlayerEpisodes.setAdjustViewBounds(z);
    }

    private int J2(int i2, int i3) {
        return this.h2.isStreamAvailable(String.valueOf(i2), i3);
    }

    private void K1(int i2) {
        if (a4) {
            return;
        }
        this.f.x = new l();
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
        nSTIJKPlayerEpisodes.w.postDelayed(nSTIJKPlayerEpisodes.x, i2);
    }

    private int K2(String str, int i2) {
        return this.B2.isStreamAvailable(str, i2);
    }

    private void M2() {
        V3.setVisibility(0);
        V3.requestFocus();
        this.Q.setVisibility(0);
    }

    private void N2() {
        H2();
        if (this.c3.getVisibility() == 0) {
            e2();
        } else {
            C2();
            K1(5000);
        }
    }

    public static boolean O1() {
        ProgressBar progressBar = Y3;
        if (progressBar == null || progressBar.getVisibility() != 0) {
            V3.setEnabled(true);
            return false;
        }
        V3.setEnabled(true);
        return true;
    }

    private void P1() {
        int i2;
        int i3;
        int i4;
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
        GetEpisdoeDetailsCallback getEpisdoeDetailsCallback;
        z0 z0Var;
        List list = this.E2;
        if (list == null || list.size() <= 0) {
            return;
        }
        List list2 = this.Q1;
        if (list2 != null) {
            list2.clear();
        }
        if (this.g2 != null) {
            if (this.f != null) {
                this.i3 = this.T1.getSharedPreferences("currentSeekTime", 0);
                long currentPosition = this.f.getCurrentPosition();
                SharedPreferences sharedPreferences = this.T1.getSharedPreferences("currentSeekTime", 0);
                this.i3 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.j3 = edit;
                edit.putString("currentSeekTime", String.valueOf(currentPosition));
                this.j3.apply();
                if (this.f == null || x7.a.f().a() == null || !this.z2.equals("m3u")) {
                    try {
                        if (SharepreferenceDBHandler.getCurrentAPPType(this.T1).equals("onestream_api")) {
                            if (x7.a.f() != null && x7.a.f().e() != null && currentPosition != -1 && currentPosition != 0) {
                                ArrayList c2 = this.i2.c(x7.a.f().e());
                                this.B3 = c2;
                                if (c2 != null && c2.size() > 0) {
                                    int Z1 = SharepreferenceDBHandler.getCurrentAPPType(this.T1).equals("onestream_api") ? Z1(this.E2, x7.a.f().e()) : Y1(this.E2, w.r0(x7.a.f().e()));
                                    getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                                    getEpisdoeDetailsCallback.setId(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getId());
                                    getEpisdoeDetailsCallback.setTitle(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getTitle());
                                    getEpisdoeDetailsCallback.setContainerExtension(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getContainerExtension());
                                    getEpisdoeDetailsCallback.setAdded(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getAdded());
                                    getEpisdoeDetailsCallback.setSeriesCover(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesCover());
                                    getEpisdoeDetailsCallback.setCategoryId(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getCategoryId());
                                    getEpisdoeDetailsCallback.setElapsed_time(String.valueOf(currentPosition));
                                    getEpisdoeDetailsCallback.setSeriesId(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesId());
                                    getEpisdoeDetailsCallback.setImage(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getImage());
                                    getEpisdoeDetailsCallback.setMovieImage(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getMovieImage());
                                    getEpisdoeDetailsCallback.setMainSeriesImg(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getMainSeriesImg());
                                    getEpisdoeDetailsCallback.setSeriesNum(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesNum());
                                    getEpisdoeDetailsCallback.setSeasonNumber(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeasonNumber());
                                    getEpisdoeDetailsCallback.setEpisodeNum(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getEpisodeNumber());
                                    getEpisdoeDetailsCallback.setSeriesName(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesName());
                                    getEpisdoeDetailsCallback.setLinks(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getLinks());
                                    this.y1 = ((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getCategoryId();
                                    this.B1 = ((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesName();
                                    NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.f;
                                    getEpisdoeDetailsCallback.setDurationSec(nSTIJKPlayerEpisodes2 != null ? String.valueOf(nSTIJKPlayerEpisodes2.getDuration() / 1000) : ((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getDurationSec());
                                    this.i2.b(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getId());
                                    this.i2.i(this.T1, ((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesId());
                                    z0Var = this.i2;
                                    z0Var.g(this.T1, getEpisdoeDetailsCallback);
                                }
                            }
                        } else if (x7.a.f() != null && x7.a.f().e() != null && currentPosition != -1 && currentPosition != 0) {
                            ArrayList c3 = this.i2.c(x7.a.f().e());
                            this.B3 = c3;
                            if (c3 != null && c3.size() > 0) {
                                int Y1 = Y1(this.E2, w.r0(x7.a.f().e()));
                                getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                                getEpisdoeDetailsCallback.setId(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getId());
                                getEpisdoeDetailsCallback.setTitle(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getTitle());
                                getEpisdoeDetailsCallback.setContainerExtension(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getContainerExtension());
                                getEpisdoeDetailsCallback.setAdded(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getAdded());
                                getEpisdoeDetailsCallback.setSeriesCover(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeriesCover());
                                getEpisdoeDetailsCallback.setCategoryId(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getCategoryId());
                                getEpisdoeDetailsCallback.setElapsed_time(String.valueOf(currentPosition));
                                getEpisdoeDetailsCallback.setSeriesId(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeriesId());
                                getEpisdoeDetailsCallback.setImage(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getImage());
                                getEpisdoeDetailsCallback.setMovieImage(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getMovieImage());
                                getEpisdoeDetailsCallback.setMainSeriesImg(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getMainSeriesImg());
                                getEpisdoeDetailsCallback.setSeriesNum(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeriesNum());
                                getEpisdoeDetailsCallback.setSeasonNumber(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeasonNumber());
                                getEpisdoeDetailsCallback.setEpisodeNum(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getEpisodeNumber());
                                getEpisdoeDetailsCallback.setSeriesName(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeriesName());
                                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes3 = this.f;
                                getEpisdoeDetailsCallback.setDurationSec(nSTIJKPlayerEpisodes3 != null ? String.valueOf(nSTIJKPlayerEpisodes3.getDuration() / 1000) : ((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getDurationSec());
                                this.i2.b(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getId());
                                this.i2.i(this.T1, ((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeriesId());
                                z0Var = this.i2;
                                z0Var.g(this.T1, getEpisdoeDetailsCallback);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            ArrayList allSeriesRecentWatch = this.g2.getAllSeriesRecentWatch("getalldata");
            for (int i5 = 0; i5 < this.E2.size(); i5++) {
                if (((GetEpisdoeDetailsCallback) this.E2.get(i5)).getSeasonNumber().equals(Integer.valueOf(this.y3))) {
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback2 = (GetEpisdoeDetailsCallback) this.E2.get(i5);
                    int i6 = 0;
                    while (true) {
                        if (i6 >= allSeriesRecentWatch.size()) {
                            break;
                        }
                        if (((GetEpisdoeDetailsCallback) this.E2.get(i5)).getId().equals(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i6)).getId())) {
                            getEpisdoeDetailsCallback2.setElapsed_time(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i6)).getElapsed_time());
                            try {
                                i2 = Math.round(Integer.parseInt(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i6)).getElapsed_time()) / 1000.0f);
                                try {
                                    i3 = (!getEpisdoeDetailsCallback2.getDurationSec().equals("") || (nSTIJKPlayerEpisodes = this.f) == null) ? w.r0(getEpisdoeDetailsCallback2.getDurationSec()) : nSTIJKPlayerEpisodes.getDuration() / 1000;
                                } catch (Exception unused2) {
                                    i3 = 0;
                                    i4 = Math.round((i2 / i3) * 100.0f);
                                    getEpisdoeDetailsCallback2.setEpisode_watched_percentage(i4);
                                    this.Q1.add(getEpisdoeDetailsCallback2);
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
                    this.Q1.add(getEpisdoeDetailsCallback2);
                }
            }
        }
    }

    private void Q1(String str) {
        this.h2.deleteMovieRecentWatch(str);
    }

    public static long R1(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private void T1() {
        ImageView imageView = this.k;
        imageView.setOnFocusChangeListener(new p(imageView));
        ImageView imageView2 = this.l;
        imageView2.setOnFocusChangeListener(new p(imageView2));
        ImageView imageView3 = this.g;
        imageView3.setOnFocusChangeListener(new p(imageView3));
        SeekBar seekBar = this.m;
        seekBar.setOnFocusChangeListener(new p(seekBar));
        ImageView imageView4 = this.j;
        imageView4.setOnFocusChangeListener(new p(imageView4));
        ImageView imageView5 = this.C0;
        imageView5.setOnFocusChangeListener(new p(imageView5));
        LinearLayout linearLayout = this.n;
        linearLayout.setOnFocusChangeListener(new p(linearLayout));
        LinearLayout linearLayout2 = this.o;
        linearLayout2.setOnFocusChangeListener(new p(linearLayout2));
        LinearLayout linearLayout3 = this.p;
        linearLayout3.setOnFocusChangeListener(new p(linearLayout3));
        V3.setOnFocusChangeListener(new p(this.p));
        LinearLayout linearLayout4 = this.r;
        linearLayout4.setOnFocusChangeListener(new p(linearLayout4));
        ImageView imageView6 = this.u;
        imageView6.setOnFocusChangeListener(new p(imageView6));
        ImageView imageView7 = this.v;
        imageView7.setOnFocusChangeListener(new p(imageView7));
        ImageView imageView8 = this.l0;
        imageView8.setOnFocusChangeListener(new p(imageView8));
        ImageView imageView9 = this.l0;
        imageView9.setOnFocusChangeListener(new p(imageView9));
        TextView textView = this.r0;
        textView.setOnFocusChangeListener(new p(textView));
        TextView textView2 = this.t0;
        textView2.setOnFocusChangeListener(new p(textView2));
        RelativeLayout relativeLayout = this.q1;
        relativeLayout.setOnFocusChangeListener(new p(relativeLayout));
        ImageView imageView10 = this.p1;
        imageView10.setOnFocusChangeListener(new p(imageView10));
        LinearLayout linearLayout5 = this.r1;
        linearLayout5.setOnFocusChangeListener(new p(linearLayout5));
        LinearLayout linearLayout6 = this.s1;
        linearLayout6.setOnFocusChangeListener(new p(linearLayout6));
        CheckBox checkBox = this.M0;
        checkBox.setOnFocusChangeListener(new p(checkBox));
        CheckBox checkBox2 = this.N0;
        checkBox2.setOnFocusChangeListener(new p(checkBox2));
        CheckBox checkBox3 = this.O0;
        checkBox3.setOnFocusChangeListener(new p(checkBox3));
        CheckBox checkBox4 = this.P0;
        checkBox4.setOnFocusChangeListener(new p(checkBox4));
        LinearLayout linearLayout7 = this.t1;
        linearLayout7.setOnFocusChangeListener(new p(linearLayout7));
        CheckBox checkBox5 = this.Q0;
        checkBox5.setOnFocusChangeListener(new p(checkBox5));
        CheckBox checkBox6 = this.R0;
        checkBox6.setOnFocusChangeListener(new p(checkBox6));
        CheckBox checkBox7 = this.S0;
        checkBox7.setOnFocusChangeListener(new p(checkBox7));
        CheckBox checkBox8 = this.T0;
        checkBox8.setOnFocusChangeListener(new p(checkBox8));
        CheckBox checkBox9 = this.U0;
        checkBox9.setOnFocusChangeListener(new p(checkBox9));
        LinearLayout linearLayout8 = this.u1;
        linearLayout8.setOnFocusChangeListener(new p(linearLayout8));
        LinearLayout linearLayout9 = this.v1;
        linearLayout9.setOnFocusChangeListener(new p(linearLayout9));
        CheckBox checkBox10 = this.W0;
        checkBox10.setOnFocusChangeListener(new p(checkBox10));
        CheckBox checkBox11 = this.X0;
        checkBox11.setOnFocusChangeListener(new p(checkBox11));
        CheckBox checkBox12 = this.Y0;
        checkBox12.setOnFocusChangeListener(new p(checkBox12));
        CheckBox checkBox13 = this.Z0;
        checkBox13.setOnFocusChangeListener(new p(checkBox13));
        EditText editText = this.k1;
        editText.setOnFocusChangeListener(new p(editText));
        TextView textView3 = this.L0;
        textView3.setOnFocusChangeListener(new p(textView3));
    }

    public static String U1(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    private ArrayList a2(int i2, int i3) {
        return this.h2.getStreamStatus(String.valueOf(i2), i3);
    }

    private LiveStreamsDBModel b2(String str, int i2) {
        return this.B2.getStreamStatus(str, i2);
    }

    public static String d2(String str) {
        Matcher matcher = Pattern.compile("(?:youtube(?:-nocookie)?\\.com\\/(?:[^\\/\\n\\s]+\\/\\S+\\/|(?:v|e(?:mbed)?)\\/|\\S*?[?&]v=)|youtu\\.be\\/)([a-zA-Z0-9_-]{11})", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private void e2() {
        if (this.c3.getVisibility() == 0) {
            this.c3.startAnimation(this.a2);
            if (this.e0.getVisibility() == 0) {
                this.e0.startAnimation(this.a2);
            }
            if (this.S.getVisibility() == 0) {
                this.S.startAnimation(this.a2);
            }
            if (this.i0.getVisibility() == 0) {
                this.i0.startAnimation(this.a2);
            }
            if (this.T.getVisibility() == 0) {
                this.T.startAnimation(this.a2);
            }
            if (this.f0.getVisibility() == 0) {
                this.f0.startAnimation(this.a2);
            }
            this.c3.setVisibility(8);
            if (this.e0.getVisibility() == 0) {
                this.e0.setVisibility(8);
            }
            if (this.S.getVisibility() == 0) {
                this.S.setVisibility(8);
            }
            if (this.i0.getVisibility() == 0) {
                this.i0.setVisibility(8);
            }
            if (this.T.getVisibility() == 0) {
                this.T.setVisibility(8);
            }
            if (this.f0.getVisibility() == 0) {
                this.f0.setVisibility(8);
            }
        }
        this.f.q = false;
    }

    private void g2() {
        this.C3 = new Handler();
        this.d2 = new Handler();
        this.Q3 = new n7.g(this, this.T1);
        this.U1 = AnimationUtils.loadAnimation(this.T1, a7.b.q);
        this.V1 = AnimationUtils.loadAnimation(this.T1, a7.b.r);
        this.Z1 = AnimationUtils.loadAnimation(this.T1, a7.b.h);
        this.a2 = AnimationUtils.loadAnimation(this.T1, a7.b.i);
        this.c2 = AnimationUtils.loadAnimation(this.T1, a7.b.o);
        this.b2 = AnimationUtils.loadAnimation(this.T1, a7.b.n);
        this.X1 = AnimationUtils.loadAnimation(this.T1, a7.b.s);
        this.Y1 = AnimationUtils.loadAnimation(this.T1, a7.b.t);
        this.W1 = AnimationUtils.loadAnimation(this.T1, a7.b.p);
        try {
            A2();
        } catch (Exception unused) {
        }
        if (this.n3.equals("mobile")) {
            try {
                o4.b e2 = o4.b.e(this);
                this.s3 = e2;
                this.r3 = e2.c().c();
                o4.a.b(getApplicationContext(), this.x0);
            } catch (Exception unused2) {
            }
        }
    }

    private void i2() {
        List list;
        int d2 = x7.a.f().d();
        String str = this.a3;
        str.hashCode();
        if (str.equals("series") && (list = this.E2) != null && list.size() > 0 && d2 == this.E2.size() - 1) {
            x7.a.f().w(0);
        } else {
            x7.a.f().w(d2 + 1);
        }
    }

    private void k2() {
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        V3.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.m0.setOnClickListener(this);
        this.o0.setOnClickListener(this);
        this.p1.setOnClickListener(this);
        this.q1.setOnClickListener(this);
        this.r1.setOnClickListener(this);
        this.s1.setOnClickListener(this);
        this.t1.setOnClickListener(this);
        this.u1.setOnClickListener(this);
        this.v1.setOnClickListener(this);
        this.a1.setOnClickListener(this);
        this.m1.setOnClickListener(this);
        this.C0.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f.setMovieListener(this.T3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x02d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l2(java.util.ArrayList r35, int r36) {
        /*
            Method dump skipped, instructions count: 896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.l2(java.util.ArrayList, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2(java.util.ArrayList r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 731
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.m2(java.util.ArrayList, java.lang.String):void");
    }

    private void n2(ArrayList arrayList, int i2) {
        String str;
        String str2;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        String name = ((File) arrayList.get(i2)).getName();
        String S0 = w.S0(w7.k.a() + w7.k.i());
        SimpleDateFormat simpleDateFormat = this.J2;
        if (R1(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.T1))), this.L2.format(this.K2)) >= w7.c.p() && (str = this.O2) != null && this.P2 != null && (!W3.equals(str) || (this.O2 != null && (str2 = this.P2) != null && !X3.equals(str2)))) {
            this.I2 = Boolean.FALSE;
            this.b3.b(a7.f.G).e();
            this.b3.b(a7.f.K).c(S0 + this.M2 + this.N2);
        }
        if (this.I2.booleanValue()) {
            x7.a.f().w(i2);
            this.j0.setText(name);
            w2();
            String str3 = this.A2;
            this.t3 = str3;
            this.f.Q2(str3, true, name, 0L, 0, "", null, 0, 0, this.z2, "nst", this.H2);
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
            if (nSTIJKPlayerEpisodes != null) {
                nSTIJKPlayerEpisodes.e = 0;
                nSTIJKPlayerEpisodes.f = false;
                nSTIJKPlayerEpisodes.start();
            }
        }
    }

    private void q2() {
        String str;
        MediaInfo a2;
        o4.e eVar;
        try {
            String type = SharepreferenceDBHandler.getType(this.T1);
            str = "";
            if (type.equals("loadurl")) {
                String str2 = this.g3;
                this.h3 = str2;
                int lastIndexOf = str2.lastIndexOf(47);
                str = lastIndexOf > 1 ? this.h3.substring(lastIndexOf + 1) : "";
                String str3 = this.h3;
                this.t3 = str3;
                a2 = i7.a.a(str, "", "", 0, str3, "videos/mp4", this.v3, "", (List) null);
                eVar = this.r3;
            } else {
                int ipAddress = ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress();
                String format = String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
                String str4 = ".";
                if (type.equals("devicedata")) {
                    this.h3 = this.g3;
                }
                int lastIndexOf2 = this.h3.lastIndexOf(47);
                if (lastIndexOf2 > 1) {
                    str = this.h3.substring(lastIndexOf2 + 1);
                    str4 = this.h3.substring(0, lastIndexOf2);
                }
                String str5 = str;
                this.N3.b();
                this.N3.a(format, str4);
                String str6 = "http://" + format + ":8080/" + str5;
                this.t3 = str6;
                a2 = i7.a.a(str5, "", "", 0, str6, "videos/mp4", this.v3, "", (List) null);
                eVar = this.r3;
            }
            i7.a.c(0, true, a2, eVar, this.T1);
        } catch (Exception unused) {
        }
    }

    private void s2() {
        try {
            SharedPreferences.Editor edit = this.o3.edit();
            this.p3 = edit;
            if (edit != null) {
                edit.putString("pref.using_playback_speed", "1x (Normal)");
                this.p3.apply();
            }
            this.N.setText(getResources().getString(a7.j.n7) + " (1x)");
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void t2() {
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
            android.content.SharedPreferences r7 = r0.o3
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
            com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer$j r2 = new com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer$j
            r2.<init>()
            r5.l(r1, r3, r2)
            androidx.appcompat.app.a r1 = r5.create()
            r0.E3 = r1
            com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer$k r2 = new com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer$k
            r2.<init>()
            r1.setOnDismissListener(r2)
            androidx.appcompat.app.a r1 = r0.E3
            r1.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.t2():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void u1() {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.u1():void");
    }

    private void u2(String str) {
        SharedPreferences.Editor edit = this.o3.edit();
        this.p3 = edit;
        if (edit != null) {
            edit.putString("pref.using_playback_speed", str);
            this.p3.apply();
        }
    }

    public static /* synthetic */ o4.e v1(HoneyPlayer honeyPlayer) {
        return honeyPlayer.r3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:265:? A[ADDED_TO_REGION, REMOVE, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x01fb A[PHI: r30
      0x01fb: PHI (r30v4 java.lang.String) = 
      (r30v3 java.lang.String)
      (r30v3 java.lang.String)
      (r30v3 java.lang.String)
      (r30v3 java.lang.String)
      (r30v3 java.lang.String)
      (r30v5 java.lang.String)
     binds: [B:335:0x021f, B:337:0x0225, B:339:0x022d, B:341:0x0237, B:333:0x021a, B:280:0x01f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0079 A[PHI: r25
      0x0079: PHI (r25v8 java.lang.String) = (r25v4 java.lang.String), (r25v5 java.lang.String), (r25v6 java.lang.String), (r25v9 java.lang.String) binds: [B:367:0x009d, B:364:0x0090, B:361:0x0083, B:5:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x05b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v2() {
        /*
            Method dump skipped, instructions count: 2718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.v2():void");
    }

    public static /* synthetic */ o4.e w1(HoneyPlayer honeyPlayer, o4.e eVar) {
        honeyPlayer.r3 = eVar;
        return eVar;
    }

    private void w2() {
        try {
            if (this.f != null) {
                this.i3 = this.T1.getSharedPreferences("currentSeekTime", 0);
                long currentPosition = this.f.getCurrentPosition();
                SharedPreferences sharedPreferences = this.T1.getSharedPreferences("currentSeekTime", 0);
                this.i3 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.j3 = edit;
                edit.putString("currentSeekTime", String.valueOf(currentPosition));
                this.j3.apply();
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
                if (nSTIJKPlayerEpisodes != null && currentPosition != -1 && currentPosition != 0) {
                    nSTIJKPlayerEpisodes.setCurrentPositionSeekbar(nSTIJKPlayerEpisodes.getCurrentPosition());
                    this.f.setProgress(true);
                    this.f.E2(true);
                }
                String str = this.a3;
                if (str == null || !str.equals("movies")) {
                    String str2 = this.a3;
                    if (str2 != null && str2.equals("series") && (this.f == null || x7.a.f().a() == null || !this.z2.equals("m3u"))) {
                        try {
                            if (SharepreferenceDBHandler.getCurrentAPPType(this.T1).equals("onestream_api")) {
                                if (x7.a.f() != null && x7.a.f().e() != null && currentPosition != -1 && currentPosition != 0) {
                                    ArrayList c2 = this.i2.c(x7.a.f().e());
                                    this.B3 = c2;
                                    if (c2 != null && c2.size() > 0) {
                                        int Z1 = SharepreferenceDBHandler.getCurrentAPPType(this.T1).equals("onestream_api") ? Z1(this.E2, x7.a.f().e()) : Y1(this.E2, w.r0(x7.a.f().e()));
                                        GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                                        getEpisdoeDetailsCallback.setId(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getId());
                                        getEpisdoeDetailsCallback.setTitle(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getTitle());
                                        getEpisdoeDetailsCallback.setContainerExtension(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getContainerExtension());
                                        getEpisdoeDetailsCallback.setAdded(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getAdded());
                                        getEpisdoeDetailsCallback.setSeriesCover(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesCover());
                                        getEpisdoeDetailsCallback.setCategoryId(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getCategoryId());
                                        getEpisdoeDetailsCallback.setElapsed_time(String.valueOf(currentPosition));
                                        getEpisdoeDetailsCallback.setSeriesId(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesId());
                                        getEpisdoeDetailsCallback.setImage(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getImage());
                                        getEpisdoeDetailsCallback.setMovieImage(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getMovieImage());
                                        getEpisdoeDetailsCallback.setMainSeriesImg(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getMainSeriesImg());
                                        getEpisdoeDetailsCallback.setSeriesNum(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesNum());
                                        getEpisdoeDetailsCallback.setSeasonNumber(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeasonNumber());
                                        getEpisdoeDetailsCallback.setEpisodeNum(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getEpisodeNumber());
                                        getEpisdoeDetailsCallback.setSeriesName(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesName());
                                        this.y1 = ((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getCategoryId();
                                        if (SharepreferenceDBHandler.getCurrentAPPType(this.T1).equals("onestream_api")) {
                                            getEpisdoeDetailsCallback.setLinks(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getLinks());
                                        }
                                        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.f;
                                        getEpisdoeDetailsCallback.setDurationSec(nSTIJKPlayerEpisodes2 != null ? String.valueOf(nSTIJKPlayerEpisodes2.getDuration() / 1000) : ((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getDurationSec());
                                        this.i2.b(((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getId());
                                        this.i2.i(this.T1, ((GetEpisdoeDetailsCallback) this.E2.get(Z1)).getSeriesId());
                                        this.i2.g(this.T1, getEpisdoeDetailsCallback);
                                    }
                                }
                            } else if (x7.a.f() != null && x7.a.f().e() != null && currentPosition != -1 && currentPosition != 0) {
                                ArrayList c3 = this.i2.c(x7.a.f().e());
                                this.B3 = c3;
                                if (c3 != null && c3.size() > 0) {
                                    int Y1 = Y1(this.E2, w.r0(x7.a.f().e()));
                                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback2 = new GetEpisdoeDetailsCallback();
                                    getEpisdoeDetailsCallback2.setId(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getId());
                                    getEpisdoeDetailsCallback2.setTitle(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getTitle());
                                    getEpisdoeDetailsCallback2.setContainerExtension(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getContainerExtension());
                                    getEpisdoeDetailsCallback2.setAdded(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getAdded());
                                    getEpisdoeDetailsCallback2.setSeriesCover(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeriesCover());
                                    getEpisdoeDetailsCallback2.setCategoryId(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getCategoryId());
                                    getEpisdoeDetailsCallback2.setElapsed_time(String.valueOf(currentPosition));
                                    getEpisdoeDetailsCallback2.setSeriesId(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeriesId());
                                    getEpisdoeDetailsCallback2.setImage(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getImage());
                                    getEpisdoeDetailsCallback2.setMovieImage(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getMovieImage());
                                    getEpisdoeDetailsCallback2.setMainSeriesImg(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getMainSeriesImg());
                                    getEpisdoeDetailsCallback2.setSeriesNum(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeriesNum());
                                    getEpisdoeDetailsCallback2.setSeasonNumber(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeasonNumber());
                                    getEpisdoeDetailsCallback2.setEpisodeNum(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getEpisodeNumber());
                                    getEpisdoeDetailsCallback2.setSeriesName(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeriesName());
                                    NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes3 = this.f;
                                    getEpisdoeDetailsCallback2.setDurationSec(nSTIJKPlayerEpisodes3 != null ? String.valueOf(nSTIJKPlayerEpisodes3.getDuration() / 1000) : ((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getDurationSec());
                                    this.i2.b(((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getId());
                                    this.i2.i(this.T1, ((GetEpisdoeDetailsCallback) this.E2.get(Y1)).getSeriesId());
                                    this.i2.g(this.T1, getEpisdoeDetailsCallback2);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    x2(1);
                }
            }
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes4 = this.f;
            if (nSTIJKPlayerEpisodes4 != null) {
                if (nSTIJKPlayerEpisodes4.t2()) {
                    this.f.j2();
                } else {
                    this.f.e3();
                    this.f.C2(true);
                    this.f.a3();
                }
                IjkMediaPlayer.native_profileEnd();
            }
        } catch (Exception unused2) {
        }
    }

    public static /* synthetic */ Context x1(HoneyPlayer honeyPlayer) {
        return honeyPlayer.T1;
    }

    private void x2(int i2) {
        long currentPosition;
        ArrayList a2;
        int W1;
        Context context;
        ArrayList c2;
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
        if (nSTIJKPlayerEpisodes != null) {
            if (i2 == 0) {
                this.i3 = this.T1.getSharedPreferences("currentSeekTime", 0);
                currentPosition = this.f.getCurrentPosition();
                SharedPreferences sharedPreferences = this.T1.getSharedPreferences("currentSeekTime", 0);
                this.i3 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.j3 = edit;
                edit.putString("currentSeekTime", String.valueOf(currentPosition));
                this.j3.apply();
            } else {
                currentPosition = nSTIJKPlayerEpisodes.getCurrentPosition();
            }
            long j2 = currentPosition;
            new LiveStreamsDBModel();
            if (this.z2.equals("m3u")) {
                b2(String.valueOf(Uri.parse(this.e2)), SharepreferenceDBHandler.getUserID(this.T1));
                return;
            }
            try {
                if (this.z2.equals("onestream_api")) {
                    if (this.f == null || x7.a.f().m().isEmpty() || j2 == -1 || j2 == 0 || (c2 = c2(this.S2, SharepreferenceDBHandler.getUserID(this.T1))) == null || c2.size() <= 0) {
                        return;
                    }
                    W1 = X1(this.C2, this.S2);
                    Q1(((LiveStreamsDBModel) this.C2.get(W1)).getStreamId());
                    context = this.T1;
                } else {
                    if (this.f == null || x7.a.f().k() == -1 || j2 == -1 || j2 == 0 || (a2 = a2(this.Q2, SharepreferenceDBHandler.getUserID(this.T1))) == null || a2.size() <= 0) {
                        return;
                    }
                    W1 = W1(this.C2, this.Q2);
                    Q1(((LiveStreamsDBModel) this.C2.get(W1)).getStreamId());
                    context = this.T1;
                }
                y2(context, this.C2, W1, j2);
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ int y1(HoneyPlayer honeyPlayer) {
        return honeyPlayer.L1;
    }

    public static /* synthetic */ void z1(HoneyPlayer honeyPlayer) {
        honeyPlayer.q2();
    }

    private void z2() {
        RecyclerView recyclerView = this.R;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.T1, 1);
            this.S1 = gridLayoutManager;
            this.R.setLayoutManager(gridLayoutManager);
            this.R.setItemAnimator(new androidx.recyclerview.widget.c());
        }
    }

    public void C2() {
        if (a4 || N1() || this.P.getVisibility() != 8 || this.c3.getVisibility() != 8) {
            return;
        }
        this.c3.startAnimation(this.Z1);
        this.c3.setVisibility(0);
    }

    public void D0(String str) {
    }

    public void D2() {
        if (a4 || N1() || this.c3.getVisibility() != 8) {
            return;
        }
        this.c3.startAnimation(this.Z1);
        this.c3.setVisibility(0);
        if (this.e0.getVisibility() == 8) {
            this.e0.startAnimation(this.Z1);
            this.e0.setVisibility(0);
        }
        if (this.S.getVisibility() == 8) {
            this.S.startAnimation(this.Z1);
            this.S.setVisibility(0);
        }
        if (this.i0.getVisibility() == 8) {
            this.i0.startAnimation(this.Z1);
            this.i0.setVisibility(0);
        }
        if (this.T.getVisibility() == 8) {
            this.T.startAnimation(this.Z1);
            this.T.setVisibility(0);
        }
        if (this.f0.getVisibility() == 8) {
            this.f0.startAnimation(this.Z1);
            this.f0.setVisibility(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E2() {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.E2():void");
    }

    public void F2(int i2) {
        b bVar = new b();
        this.D3 = bVar;
        this.C3.postDelayed(bVar, i2);
    }

    public final void G2() {
        if (this.P.getVisibility() == 8) {
            this.P.startAnimation(this.b2);
            this.P.setVisibility(0);
            this.v.requestFocus();
        }
    }

    public void H2() {
        Handler handler;
        if (a4 || N1() || (handler = this.f.w) == null) {
            return;
        }
        handler.removeCallbacksAndMessages((Object) null);
    }

    public void I2() {
        Handler handler = this.C3;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        RelativeLayout relativeLayout = this.A0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void J1() {
        File[] O = w.O(this.T1);
        for (File file : O) {
            if (file.toString().endsWith(".ts")) {
                Arrays.asList(new File[]{file});
            }
        }
        if (O.length > 0) {
            ArrayList arrayList = this.K3;
            if (arrayList != null) {
                arrayList.clear();
            }
            for (File file2 : O) {
                if (file2.toString().endsWith(".ts")) {
                    this.K3.addAll(Arrays.asList(new File[]{file2}));
                }
            }
            Collections.reverse(this.K3);
            this.J3 = this.K3;
        }
    }

    public void L1(int i2) {
        if (a4) {
            return;
        }
        this.f.x = new a();
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
        nSTIJKPlayerEpisodes.w.postDelayed(nSTIJKPlayerEpisodes.x, i2);
    }

    public final int L2(String str, int i2) {
        return this.h2.isStreamAvailable(String.valueOf(str), i2);
    }

    public void M0(String str) {
        try {
            w.X();
        } catch (Exception unused) {
        }
    }

    public void M1() {
        this.G1 = new ArrayList();
        this.H1 = new JsonArray();
        if (this.Q0.isChecked()) {
            this.G1.add(this.Q0.getText().toString());
            this.H1.add(this.Q0.getText().toString());
        }
        if (this.R0.isChecked()) {
            this.G1.add(this.R0.getText().toString());
            this.H1.add(this.R0.getText().toString());
        }
        if (this.S0.isChecked()) {
            this.G1.add(this.S0.getText().toString());
            this.H1.add(this.S0.getText().toString());
        }
        if (this.T0.isChecked()) {
            this.G1.add(this.T0.getText().toString());
            this.H1.add(this.T0.getText().toString());
        }
        if (this.U0.isChecked()) {
            this.G1.add(this.U0.getText().toString());
            this.H1.add(this.U0.getText().toString());
        }
        if (this.M0.isChecked()) {
            this.G1.add(this.M0.getText().toString());
            this.H1.add(this.M0.getText().toString());
        }
        if (this.N0.isChecked()) {
            this.G1.add(this.N0.getText().toString());
            this.H1.add(this.N0.getText().toString());
        }
        if (this.O0.isChecked()) {
            this.G1.add(this.O0.getText().toString());
            this.H1.add(this.O0.getText().toString());
        }
        if (this.P0.isChecked()) {
            this.G1.add(this.P0.getText().toString());
            this.H1.add(this.P0.getText().toString());
        }
        if (this.W0.isChecked()) {
            this.G1.add(this.W0.getText().toString());
            this.H1.add(this.W0.getText().toString());
        }
        if (this.X0.isChecked()) {
            this.G1.add(this.X0.getText().toString());
            this.H1.add(this.X0.getText().toString());
        }
        if (this.Y0.isChecked()) {
            this.G1.add(this.Y0.getText().toString());
            this.H1.add(this.Y0.getText().toString());
        }
        if (this.Z0.isChecked()) {
            this.G1.add(this.Z0.getText().toString());
            this.H1.add(this.Z0.getText().toString());
        }
        this.I1 = new Gson().toJson(this.H1);
        Log.e("TAG", this.H1 + "");
    }

    public boolean N1() {
        RelativeLayout relativeLayout = this.p0;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public void P(String str) {
    }

    public void S1() {
        V3.setClickable(true);
        V3.setEnabled(true);
    }

    public void T0(StalkerDeletePlayerLinkCallback stalkerDeletePlayerLinkCallback) {
    }

    public void V1() {
        if (this.o1.getVisibility() == 0) {
            this.r1.setNextFocusRightId(a7.f.K3);
            this.s1.setNextFocusRightId(a7.f.e2);
            this.t1.setNextFocusRightId(a7.f.a2);
            this.u1.setNextFocusRightId(a7.f.V1);
        }
    }

    public int W1(ArrayList arrayList, int i2) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (w.r0(((LiveStreamsDBModel) arrayList.get(i3)).getStreamId()) == i2) {
                return i3;
            }
        }
        return 0;
    }

    public void X(StalkerShortEPGCallback stalkerShortEPGCallback) {
    }

    public int X1(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((LiveStreamsDBModel) arrayList.get(i2)).getStreamIdOneStream().equals(str)) {
                return i2;
            }
        }
        return 0;
    }

    public int Y1(List list, int i2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (w.r0(((GetEpisdoeDetailsCallback) list.get(i3)).getId()) == i2) {
                return i3;
            }
        }
        return 0;
    }

    public int Z1(List list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((GetEpisdoeDetailsCallback) list.get(i2)).getId().equals(str)) {
                return i2;
            }
        }
        return 0;
    }

    public final ArrayList c2(String str, int i2) {
        return this.h2.getStreamStatus(String.valueOf(str), i2);
    }

    public void f2() {
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
        if (nSTIJKPlayerEpisodes != null) {
            nSTIJKPlayerEpisodes.p2();
            this.f.a3.removeMessages(1);
        }
        if (a4 || this.c3.getVisibility() != 0) {
            return;
        }
        this.c3.startAnimation(this.a2);
        if (this.e0.getVisibility() == 0) {
            this.e0.startAnimation(this.a2);
        }
        if (this.S.getVisibility() == 0) {
            this.S.startAnimation(this.a2);
        }
        if (this.i0.getVisibility() == 0) {
            this.i0.startAnimation(this.a2);
        }
        if (this.T.getVisibility() == 0) {
            this.T.startAnimation(this.a2);
        }
        if (this.f0.getVisibility() == 0) {
            this.f0.startAnimation(this.a2);
        }
        this.c3.setVisibility(8);
        if (this.e0.getVisibility() == 0) {
            this.e0.setVisibility(8);
        }
        if (this.S.getVisibility() == 0) {
            this.S.setVisibility(8);
        }
        if (this.i0.getVisibility() == 0) {
            this.i0.setVisibility(8);
        }
        if (this.T.getVisibility() == 0) {
            this.T.setVisibility(8);
        }
        if (this.f0.getVisibility() == 0) {
            this.f0.setVisibility(8);
        }
    }

    public void h2() {
        if (this.f == null) {
            return;
        }
        L1(0);
        int i2 = Build.VERSION.SDK_INT;
        Rational rational = (this.f.G2() == 0 || this.f.F2() == 0) ? new Rational(this.f.getWidth(), this.f.getHeight()) : new Rational(this.f.G2(), this.f.F2());
        if (i2 >= 26) {
            try {
                p7.n.a(p7.m.a(this.I3, rational));
                D.a(this, p7.n.a(this.I3));
            } catch (Exception unused) {
                p7.n.a(p7.m.a(this.I3, new Rational(this.f.getWidth(), this.f.getHeight())));
                D.a(this, p7.n.a(this.I3));
            }
        }
    }

    public void j2(String str) {
        e2();
        this.b3.b(a7.f.G).e();
        this.b3.b(a7.f.K).c(str);
    }

    public final void o2(List list, int i2) {
        String str;
        String str2;
        int i3;
        int i4;
        String str3;
        int i5;
        long j2;
        int i6;
        int i7;
        int i8;
        int i9;
        String str4;
        String str5;
        SharedPreferences.Editor editor;
        if (list == null || list.size() <= 0) {
            return;
        }
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
        if (nSTIJKPlayerEpisodes != null && nSTIJKPlayerEpisodes.getPlayerIsPrepared()) {
            if (this.f.l == i2) {
                return;
            }
        }
        H2();
        C2();
        K1(5000);
        int Y1 = Y1(list, i2);
        String title = ((GetEpisdoeDetailsCallback) list.get(Y1)).getTitle();
        this.v3 = ((GetEpisdoeDetailsCallback) list.get(Y1)).getMovieImage();
        this.u3 = title;
        this.w3 = String.valueOf(((GetEpisdoeDetailsCallback) list.get(Y1)).getSeasonNumber());
        this.x3 = w.r0(((GetEpisdoeDetailsCallback) list.get(Y1)).getElapsed_time());
        this.y3 = ((GetEpisdoeDetailsCallback) list.get(Y1)).getSeasonNumber().intValue();
        w.S0(w7.k.a() + w7.k.i());
        ((GetEpisdoeDetailsCallback) list.get(Y1)).getId();
        int q0 = w.q0(((GetEpisdoeDetailsCallback) list.get(Y1)).getId());
        int i10 = this.T2;
        String containerExtension = ((GetEpisdoeDetailsCallback) list.get(Y1)).getContainerExtension();
        ((GetEpisdoeDetailsCallback) list.get(Y1)).getCategoryId();
        this.F2 = ((GetEpisdoeDetailsCallback) list.get(Y1)).getId();
        this.y1 = ((GetEpisdoeDetailsCallback) list.get(Y1)).getCategoryId();
        this.B1 = ((GetEpisdoeDetailsCallback) list.get(Y1)).getSeriesName();
        x7.a.f().w(Y1);
        int h2 = this.i2.h(this.F2, SharepreferenceDBHandler.getUserID(this.T1));
        SharedPreferences.Editor editor2 = this.t2;
        if (editor2 != null) {
            editor2.putString("currentlyPlayingVideo", String.valueOf(((GetEpisdoeDetailsCallback) list.get(Y1)).getId()));
            this.t2.apply();
        }
        String str6 = this.a3;
        if (str6 != null && str6.equals("series") && (editor = this.t2) != null) {
            editor.putString("currentlyPlayingVideo", String.valueOf(((GetEpisdoeDetailsCallback) list.get(Y1)).getId()));
            this.t2.apply();
        }
        SharedPreferences.Editor editor3 = this.u2;
        if (editor3 != null) {
            editor3.putString("currentlyPlayingVideoPosition", String.valueOf(Y1));
            this.u2.apply();
        }
        SimpleDateFormat simpleDateFormat = this.J2;
        if (R1(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.T1))), this.L2.format(this.K2)) >= w7.c.p() && (str4 = this.O2) != null && this.P2 != null && (!W3.equals(str4) || (this.O2 != null && (str5 = this.P2) != null && !X3.equals(str5)))) {
            this.I2 = Boolean.FALSE;
        }
        this.G2 = q0;
        this.j0.setText(title);
        if (h2 == 0 && this.I2.booleanValue()) {
            w2();
            this.f.setProgress(false);
            if (this.z2.equals("m3u")) {
                x7.a.f().r("m3u");
                String str7 = this.e2;
                this.t3 = str7;
                i3 = i10;
                str3 = title;
                this.f.Q2(str7, true, title, 0L, 0, "", null, Y1, 0, this.z2, "nst", "");
                str = ".";
                str2 = containerExtension;
                i9 = q0;
            } else {
                i3 = i10;
                str3 = title;
                String valueOf = String.valueOf(Uri.parse(this.A2 + q0 + "." + containerExtension));
                this.t3 = valueOf;
                str2 = containerExtension;
                str = ".";
                i9 = q0;
                this.f.Q2(valueOf, true, str3, 0L, q0, "", this.D2, Y1, 0, this.z2, "nst", "");
            }
            EpisodesUsingSinglton.getInstance().setEpisodeList(list);
            x7.a.f().x(this.F2);
            i4 = i9;
            x7.a.f().G(i4);
            x7.a.f().v(list);
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.f;
            i5 = 0;
            nSTIJKPlayerEpisodes2.e = 0;
            nSTIJKPlayerEpisodes2.f = false;
            nSTIJKPlayerEpisodes2.start();
        } else {
            str = ".";
            str2 = containerExtension;
            i3 = i10;
            i4 = q0;
            str3 = title;
            i5 = 0;
        }
        if (h2 <= 0 || this.i2.a(this.F2) <= 0) {
            return;
        }
        try {
            j2 = this.g2.gettimeElapsed(this.F2).longValue();
        } catch (Exception unused) {
            j2 = 0;
        }
        if (i3 == 0) {
            i6 = w.r0(this.g2.getTotaltime(this.F2).toString());
            this.T2 = i6;
        } else {
            i6 = i3;
        }
        if (this.f == null || !this.I2.booleanValue()) {
            return;
        }
        w2();
        String valueOf2 = String.valueOf(Uri.parse(this.A2 + this.F2 + str + str2));
        this.t3 = valueOf2;
        this.f.setProgress(true);
        x7.a.f().I(j2);
        this.f.setCurrentPositionSeekbar((int) j2);
        try {
            i7 = Math.round(w.r0(String.valueOf(j2)) / 1000.0f);
        } catch (Exception unused2) {
            i7 = 0;
            i6 = 0;
        }
        try {
            i8 = Math.round((i7 / i6) * 100.0f);
        } catch (Exception unused3) {
            i8 = 0;
        }
        if (i8 >= 99) {
            this.f.setCurrentPositionSeekbar(i5);
        }
        EpisodesUsingSinglton.getInstance().setEpisodeList(list);
        x7.a.f().x(this.F2);
        this.f.Q2(valueOf2, true, str3, 0L, i4, "", this.D2, Y1, 0, this.z2, "nst", "");
        this.f.start();
    }

    public void onBackPressed() {
        RelativeLayout relativeLayout = this.A0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            I2();
            return;
        }
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
        if (nSTIJKPlayerEpisodes != null) {
            nSTIJKPlayerEpisodes.p2();
        }
        if (this.Q.getVisibility() == 0) {
            this.Q.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.p0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.f;
            if (nSTIJKPlayerEpisodes2 != null) {
                nSTIJKPlayerEpisodes2.m2();
                return;
            }
            return;
        }
        RelativeLayout relativeLayout3 = this.O;
        if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0) {
            this.O.startAnimation(this.a2);
            this.O.setVisibility(8);
            return;
        }
        H2();
        if (this.P.getVisibility() == 0) {
            this.P.startAnimation(this.c2);
            this.P.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout4 = this.q1;
        if (relativeLayout4 != null && relativeLayout4.getVisibility() == 0) {
            this.q1.setVisibility(8);
            this.o1.setVisibility(8);
            this.o1.startAnimation(this.a2);
            this.q1.startAnimation(this.a2);
            this.W0.setChecked(false);
            this.X0.setChecked(false);
            this.Y0.setChecked(false);
            this.Z0.setChecked(false);
            this.Q0.setChecked(false);
            this.R0.setChecked(false);
            this.S0.setChecked(false);
            this.T0.setChecked(false);
            this.U0.setChecked(false);
            this.M0.setChecked(false);
            this.N0.setChecked(false);
            this.O0.setChecked(false);
            this.P0.setChecked(false);
            this.k1.setText("");
            return;
        }
        if (this.c3.getVisibility() != 0) {
            m7.a.m0 = true;
            if (this.n3.equals("mobile") && this.H3 && this.M3) {
                try {
                    h2();
                    return;
                } catch (Exception unused) {
                }
            }
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
            return;
        }
        if (this.c3.getVisibility() == 0) {
            this.c3.startAnimation(this.a2);
            if (this.e0.getVisibility() == 0) {
                this.e0.startAnimation(this.a2);
            }
            if (this.S.getVisibility() == 0) {
                this.S.startAnimation(this.a2);
            }
            if (this.i0.getVisibility() == 0) {
                this.i0.startAnimation(this.a2);
            }
            if (this.T.getVisibility() == 0) {
                this.T.startAnimation(this.a2);
            }
            if (this.f0.getVisibility() == 0) {
                this.f0.startAnimation(this.a2);
            }
            this.c3.setVisibility(8);
            if (this.e0.getVisibility() == 0) {
                this.e0.setVisibility(8);
            }
            if (this.S.getVisibility() == 0) {
                this.S.setVisibility(8);
            }
            if (this.i0.getVisibility() == 0) {
                this.i0.setVisibility(8);
            }
            if (this.T.getVisibility() == 0) {
                this.T.setVisibility(8);
            }
            if (this.f0.getVisibility() == 0) {
                this.f0.setVisibility(8);
            }
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CheckBox checkBox;
        boolean isChecked = ((CheckBox) compoundButton).isChecked();
        int id = compoundButton.getId();
        if (id == a7.f.V1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.W0;
            }
        } else if (id == a7.f.X1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.X0;
            }
        } else if (id == a7.f.Y1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.Y0;
            }
        } else if (id == a7.f.W1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.Z0;
            }
        } else if (id == a7.f.e2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.M0;
            }
        } else if (id == a7.f.g2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.N0;
            }
        } else if (id == a7.f.h2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.O0;
            }
        } else if (id == a7.f.f2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.P0;
            }
        } else if (id == a7.f.a2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.Q0;
            }
        } else if (id == a7.f.c2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.R0;
            }
        } else if (id == a7.f.d2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.S0;
            }
        } else if (id == a7.f.b2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.T0;
            }
        } else if (id != a7.f.Z1 || !isChecked) {
            return;
        } else {
            checkBox = this.U0;
        }
        this.E1 = checkBox.getText().toString();
    }

    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v42 */
    public void onClick(View view) {
        TextView textView;
        Resources resources;
        int i2;
        int i3;
        int i4;
        String str;
        long j2;
        int i5;
        int i6;
        ?? r4;
        StringBuilder sb;
        String str2;
        String str3;
        String str4;
        String str5;
        String valueOf;
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
        String str6;
        String str7;
        String str8;
        String str9;
        int i7;
        boolean z;
        long j3;
        int i8;
        String str10;
        ArrayList arrayList;
        int i9;
        String str11;
        String str12;
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2;
        String str13;
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes3;
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes4;
        ImageView imageView;
        int id = view.getId();
        if (id == a7.f.I5) {
            if (this.n3.equals("tv")) {
                boolean playerIsPrepared = this.f.getPlayerIsPrepared();
                H2();
                C2();
                if (!playerIsPrepared) {
                    K1(5000);
                    this.k.setVisibility(0);
                    this.k.requestFocus();
                    return;
                }
                K1(1000);
                this.f.start();
                this.f.g();
                this.k.setVisibility(8);
                this.l.setVisibility(0);
                this.l.requestFocus();
                I2();
                return;
            }
            boolean playerIsPrepared2 = this.f.getPlayerIsPrepared();
            H2();
            D2();
            if (playerIsPrepared2) {
                L1(1000);
                this.f.start();
                this.f.g();
                this.k.setVisibility(8);
                imageView = this.l;
                imageView.setVisibility(0);
            }
            L1(5000);
        } else {
            if (id != a7.f.H5) {
                if (id == a7.f.c7 || id == a7.f.E4) {
                    onBackPressed();
                } else if (id != a7.f.I4 && id != a7.f.J4) {
                    if (id == a7.f.x8) {
                        H2();
                        e2();
                        a4 = true;
                        this.f.U2();
                        this.f.a2(3000);
                        return;
                    }
                    if (id == a7.f.i6) {
                        H2();
                        a4 = false;
                        this.n0.startAnimation(this.V1);
                        this.n0.setVisibility(8);
                        D2();
                        L1(3000);
                        return;
                    }
                    if (id != a7.f.w7) {
                        if (id != a7.f.k4) {
                            if (id == a7.f.Z6 || id == a7.f.C4) {
                                H2();
                                e2();
                                G2();
                                return;
                            }
                            if (id == a7.f.n5) {
                                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes5 = this.f;
                                if (nSTIJKPlayerEpisodes5 == null || !nSTIJKPlayerEpisodes5.getPlayerIsPrepared()) {
                                    return;
                                }
                                H2();
                                e2();
                                this.f.seekTo(0);
                                this.f.start();
                                return;
                            }
                            if (id == a7.f.f8) {
                                H2();
                                e2();
                                P1();
                                B2();
                                return;
                            }
                            if (id == a7.f.B7) {
                                H2();
                                K1(5000);
                                I2();
                                if (this.n3.equals("tv") && (str13 = this.a3) != null && str13.equals("series") && this.f.getPlayerIsPrepared() && (nSTIJKPlayerEpisodes3 = this.f) != null && !nSTIJKPlayerEpisodes3.isPlaying()) {
                                    F2(10000);
                                }
                                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes6 = this.f;
                                if (nSTIJKPlayerEpisodes6 != null) {
                                    nSTIJKPlayerEpisodes6.l3();
                                    return;
                                }
                                return;
                            }
                            if (id == a7.f.q9) {
                                H2();
                                e2();
                                t2();
                                return;
                            }
                            if (id == a7.f.ma) {
                                ProgressBar progressBar = Y3;
                                if (progressBar == null || progressBar.getVisibility() != 0) {
                                    H2();
                                    e2();
                                    M2();
                                    return;
                                }
                                return;
                            }
                            if (id != a7.f.U8) {
                                if (id == a7.f.y7 || id == a7.f.S4) {
                                    H2();
                                    e2();
                                    if (this.q1.getVisibility() == 8) {
                                        this.q1.startAnimation(this.b2);
                                        this.q1.setVisibility(0);
                                        this.r1.requestFocus();
                                        this.l1.requestFocus();
                                        this.W0.setChecked(false);
                                        this.X0.setChecked(false);
                                        this.Y0.setChecked(false);
                                        this.Z0.setChecked(false);
                                        this.Q0.setChecked(false);
                                        this.R0.setChecked(false);
                                        this.S0.setChecked(false);
                                        this.T0.setChecked(false);
                                        this.U0.setChecked(false);
                                        this.M0.setChecked(false);
                                        this.N0.setChecked(false);
                                        this.O0.setChecked(false);
                                        this.P0.setChecked(false);
                                        this.k1.setText("");
                                        return;
                                    }
                                    return;
                                }
                                if (id == a7.f.x1) {
                                    this.C1 = this.c1.getText().toString();
                                    this.D1 = this.g1.getText().toString();
                                    i3 = 0;
                                    this.o1.setVisibility(0);
                                    this.J0.setVisibility(0);
                                    this.I0.setVisibility(8);
                                    this.K0.setVisibility(8);
                                    this.w1.setVisibility(8);
                                } else {
                                    if (id == a7.f.Jg) {
                                        this.C1 = this.d1.getText().toString();
                                        this.D1 = this.h1.getText().toString();
                                        this.o1.setVisibility(0);
                                        this.J0.setVisibility(8);
                                        this.w1.setVisibility(8);
                                        this.I0.setVisibility(0);
                                        this.k1.setVisibility(0);
                                        this.K0.setVisibility(8);
                                        this.V0.setVisibility(8);
                                        textView = this.a1;
                                        resources = getResources();
                                        i2 = a7.j.Q7;
                                        textView.setText(resources.getString(i2));
                                        return;
                                    }
                                    if (id != a7.f.X) {
                                        if (id == a7.f.k) {
                                            this.C1 = this.f1.getText().toString();
                                            this.D1 = this.j1.getText().toString();
                                            this.o1.setVisibility(0);
                                            this.J0.setVisibility(8);
                                            this.I0.setVisibility(8);
                                            this.K0.setVisibility(8);
                                            this.w1.setVisibility(8);
                                            this.V0.setVisibility(0);
                                            this.k1.setVisibility(0);
                                            textView = this.a1;
                                            resources = getResources();
                                            i2 = a7.j.Q7;
                                            textView.setText(resources.getString(i2));
                                            return;
                                        }
                                        if (id == a7.f.v2) {
                                            this.o1.setVisibility(0);
                                            this.J0.setVisibility(8);
                                            this.I0.setVisibility(8);
                                            this.K0.setVisibility(8);
                                            this.V0.setVisibility(8);
                                            this.w1.setVisibility(0);
                                            this.k1.setVisibility(4);
                                            this.v1.setVisibility(0);
                                            textView = this.a1;
                                            resources = getResources();
                                            i2 = a7.j.y0;
                                            textView.setText(resources.getString(i2));
                                            return;
                                        }
                                        if (id == a7.f.tm) {
                                            if (this.w1.getVisibility() == 0) {
                                                try {
                                                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getResources().getString(a7.j.z0))));
                                                } catch (ActivityNotFoundException e2) {
                                                    Toast.makeText(this, "No application can handle this request. Please install a webbrowser", 1).show();
                                                    e2.printStackTrace();
                                                }
                                                this.q1.setVisibility(8);
                                                return;
                                            }
                                            this.F1 = this.k1.getText().toString();
                                            M1();
                                            if (!this.Q0.isChecked() && !this.R0.isChecked() && !this.S0.isChecked() && !this.T0.isChecked() && !this.U0.isChecked() && !this.W0.isChecked() && !this.X0.isChecked() && !this.Y0.isChecked() && !this.Z0.isChecked() && !this.M0.isChecked() && !this.N0.isChecked() && !this.O0.isChecked() && !this.P0.isChecked() && this.k1.length() <= 0) {
                                                Toast.makeText(this.T1, "Please Add Report", 0).show();
                                                return;
                                            }
                                            u1();
                                            this.W0.setChecked(false);
                                            this.X0.setChecked(false);
                                            this.Y0.setChecked(false);
                                            this.Z0.setChecked(false);
                                            this.Q0.setChecked(false);
                                            this.R0.setChecked(false);
                                            this.S0.setChecked(false);
                                            this.T0.setChecked(false);
                                            this.U0.setChecked(false);
                                            this.M0.setChecked(false);
                                            this.N0.setChecked(false);
                                            this.O0.setChecked(false);
                                            this.P0.setChecked(false);
                                            this.k1.setText("");
                                            RelativeLayout relativeLayout = this.q1;
                                            if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                                                return;
                                            }
                                            this.q1.setVisibility(8);
                                            this.o1.setVisibility(8);
                                            this.o1.startAnimation(this.a2);
                                            this.q1.startAnimation(this.a2);
                                            return;
                                        }
                                        return;
                                    }
                                    this.C1 = this.e1.getText().toString();
                                    this.D1 = this.i1.getText().toString();
                                    i3 = 0;
                                    this.o1.setVisibility(0);
                                    this.J0.setVisibility(8);
                                    this.I0.setVisibility(8);
                                    this.w1.setVisibility(8);
                                    this.K0.setVisibility(0);
                                }
                                this.k1.setVisibility(i3);
                                this.V0.setVisibility(8);
                                textView = this.a1;
                                resources = getResources();
                                i2 = a7.j.Q7;
                                textView.setText(resources.getString(i2));
                                return;
                            }
                            String str14 = this.a3;
                            if (str14 == null || str14.equals("movies")) {
                                return;
                            }
                            H2();
                            e2();
                            i2();
                            SeekBar seekBar = this.m;
                            if (seekBar != null) {
                                seekBar.setProgress(0);
                            }
                            int d2 = x7.a.f().d();
                            if (!this.a3.equals("movies") && this.a3.equals("series")) {
                                List list = this.E2;
                                if (list == null || list.size() <= 1 || d2 > this.E2.size() - 1) {
                                    b4 = false;
                                    i4 = 0;
                                } else {
                                    this.W2 = ((GetEpisdoeDetailsCallback) this.E2.get(d2)).getTitle();
                                    this.Z2 = ((GetEpisdoeDetailsCallback) this.E2.get(d2)).getContainerExtension();
                                    this.X2 = ((GetEpisdoeDetailsCallback) this.E2.get(d2)).getId();
                                    this.v3 = ((GetEpisdoeDetailsCallback) this.E2.get(d2)).getMovieImage();
                                    this.u3 = this.W2;
                                    this.x3 = w.r0(((GetEpisdoeDetailsCallback) this.E2.get(d2)).getElapsed_time());
                                    this.w3 = String.valueOf(((GetEpisdoeDetailsCallback) this.E2.get(d2)).getSeasonNumber());
                                    this.y3 = ((GetEpisdoeDetailsCallback) this.E2.get(d2)).getSeasonNumber().intValue();
                                    i4 = (!((GetEpisdoeDetailsCallback) this.E2.get(d2)).getDurationSec().equals("") || (nSTIJKPlayerEpisodes2 = this.f) == null) ? w.q0(((GetEpisdoeDetailsCallback) this.E2.get(d2)).getDurationSec()) : nSTIJKPlayerEpisodes2.getDuration() / 1000;
                                    this.U2 = w.r0(this.X2);
                                    this.Q2 = w.q0(this.X2);
                                    if (SharepreferenceDBHandler.getCurrentAPPType(this.T1).equals("onestream_api")) {
                                        this.S2 = this.X2;
                                        this.e2 = ((GetEpisdoeDetailsCallback) this.E2.get(d2)).getLinks();
                                    }
                                    this.F2 = ((GetEpisdoeDetailsCallback) this.E2.get(d2)).getId();
                                    this.j0.setText(this.W2);
                                    b4 = true;
                                }
                            } else {
                                i4 = 0;
                            }
                            this.w2.clear();
                            this.w2.apply();
                            this.x2.clear();
                            this.x2.apply();
                            this.v2.clear();
                            this.v2.apply();
                            if (b4 && this.I2.booleanValue()) {
                                w2();
                                x7.a.f().x(this.F2);
                                int h2 = this.i2.h(this.F2, SharepreferenceDBHandler.getUserID(this.T1));
                                if (h2 == 0) {
                                    this.f.setProgress(false);
                                    NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes7 = this.f;
                                    nSTIJKPlayerEpisodes7.e = 0;
                                    nSTIJKPlayerEpisodes7.f = false;
                                    if (!this.z2.equals("m3u") || (str12 = this.a3) == null || str12.equals("recording")) {
                                        if (!this.z2.equals("onestream_api") || (str11 = this.a3) == null || str11.equals("recording")) {
                                            String str15 = this.a3;
                                            if (str15 == null || !str15.equals("recording")) {
                                                valueOf = String.valueOf(Uri.parse(this.A2 + this.Q2 + "." + this.Z2));
                                                this.t3 = valueOf;
                                                nSTIJKPlayerEpisodes = this.f;
                                                str6 = this.W2;
                                                int i10 = this.Q2;
                                                String str16 = this.Y2;
                                                ArrayList arrayList2 = this.D2;
                                                int i11 = this.U2;
                                                str7 = "nst";
                                                str8 = "";
                                                str9 = this.z2;
                                                i7 = i11;
                                                z = true;
                                                j3 = 0;
                                                i8 = i10;
                                                str10 = str16;
                                                arrayList = arrayList2;
                                                i9 = d2;
                                            } else {
                                                String str17 = this.A2;
                                                this.t3 = str17;
                                                this.f.Q2(str17, true, this.W2, 0L, 0, "", null, 0, 0, this.z2, "nst", "");
                                            }
                                        } else {
                                            valueOf = this.e2;
                                            this.t3 = valueOf;
                                            nSTIJKPlayerEpisodes = this.f;
                                            str6 = this.W2;
                                            String str18 = this.Y2;
                                            ArrayList arrayList3 = this.D2;
                                            int i12 = this.U2;
                                            String str19 = this.z2;
                                            str7 = "nst";
                                            str8 = this.S2;
                                            str9 = str19;
                                            z = true;
                                            j3 = 0;
                                            i8 = 0;
                                            str10 = str18;
                                            arrayList = arrayList3;
                                            i9 = d2;
                                            i7 = i12;
                                        }
                                        nSTIJKPlayerEpisodes.Q2(valueOf, z, str6, j3, i8, str10, arrayList, i9, i7, str9, str7, str8);
                                    } else {
                                        String str20 = this.e2;
                                        this.t3 = str20;
                                        this.f.Q2(str20, true, this.W2, 0L, 0, "", null, d2, 0, this.z2, "nst", "");
                                        x7.a.f().r("m3u");
                                    }
                                    this.f.start();
                                }
                                if (h2 > 0) {
                                    if (this.i2.a(this.F2) > 0) {
                                        try {
                                            j2 = this.g2.gettimeElapsed(this.F2).longValue();
                                        } catch (Exception unused) {
                                            j2 = 0;
                                        }
                                        if (i4 == 0) {
                                            i4 = w.r0(this.g2.getTotaltime(this.F2).toString());
                                            this.T2 = i4;
                                        }
                                        if (this.f != null) {
                                            x7.a.f().I(j2);
                                            this.f.setProgress(true);
                                            this.f.setCurrentPositionSeekbar((int) j2);
                                            try {
                                                i5 = Math.round(w.r0(String.valueOf(j2)) / 1000.0f);
                                            } catch (Exception unused2) {
                                                i4 = 0;
                                                i5 = 0;
                                            }
                                            try {
                                                i6 = Math.round((i5 / i4) * 100.0f);
                                            } catch (Exception unused3) {
                                                i6 = 0;
                                            }
                                            if (i6 >= 99) {
                                                r4 = 0;
                                                this.f.setCurrentPositionSeekbar(0);
                                            } else {
                                                r4 = 0;
                                            }
                                            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes8 = this.f;
                                            nSTIJKPlayerEpisodes8.e = r4;
                                            nSTIJKPlayerEpisodes8.f = r4;
                                            if (!this.z2.equals("m3u") || (str3 = this.a3) == null || str3.equals("recording")) {
                                                if (!this.z2.equals("onestream_api") || (str2 = this.a3) == null || str2.equals("recording")) {
                                                    String str21 = this.a3;
                                                    if (str21 == null || !str21.equals("recording")) {
                                                        sb = new StringBuilder();
                                                        sb.append(this.A2);
                                                        sb.append(this.Q2);
                                                        sb.append(".");
                                                        sb.append(this.Z2);
                                                        String valueOf2 = String.valueOf(Uri.parse(sb.toString()));
                                                        this.t3 = valueOf2;
                                                        this.f.Q2(valueOf2, true, this.W2, 0L, this.Q2, this.Y2, this.D2, d2, this.U2, this.z2, "nst", this.H2);
                                                        this.f.start();
                                                    }
                                                    String str22 = this.A2;
                                                    this.t3 = str22;
                                                    this.f.Q2(str22, true, this.W2, 0L, 0, "", null, 0, 0, this.z2, "nst", this.H2);
                                                    this.f.start();
                                                }
                                                String str23 = this.e2;
                                                this.t3 = str23;
                                                this.f.Q2(str23, true, this.W2, 0L, 0, "", null, d2, 0, this.z2, "nst", this.H2);
                                                x7.a.f().r("onestream_api");
                                                this.f.start();
                                            }
                                            String str24 = this.e2;
                                            this.t3 = str24;
                                            this.f.Q2(str24, true, this.W2, 0L, 0, "", null, d2, 0, this.z2, "nst", this.H2);
                                            x7.a.f().r("m3u");
                                            this.f.start();
                                        }
                                    } else {
                                        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes9 = this.f;
                                        if (nSTIJKPlayerEpisodes9 != null) {
                                            nSTIJKPlayerEpisodes9.setProgress(false);
                                            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes10 = this.f;
                                            nSTIJKPlayerEpisodes10.e = 0;
                                            nSTIJKPlayerEpisodes10.f = false;
                                            if (!this.z2.equals("m3u") || (str5 = this.a3) == null || str5.equals("recording")) {
                                                if (!this.z2.equals("onestream_api") || (str4 = this.a3) == null || str4.equals("recording")) {
                                                    String str25 = this.a3;
                                                    if (str25 == null || !str25.equals("recording")) {
                                                        sb = new StringBuilder();
                                                        sb.append(this.A2);
                                                        sb.append(this.Q2);
                                                        sb.append(".");
                                                        sb.append(this.Z2);
                                                        String valueOf22 = String.valueOf(Uri.parse(sb.toString()));
                                                        this.t3 = valueOf22;
                                                        this.f.Q2(valueOf22, true, this.W2, 0L, this.Q2, this.Y2, this.D2, d2, this.U2, this.z2, "nst", this.H2);
                                                        this.f.start();
                                                    }
                                                    String str222 = this.A2;
                                                    this.t3 = str222;
                                                    this.f.Q2(str222, true, this.W2, 0L, 0, "", null, 0, 0, this.z2, "nst", this.H2);
                                                    this.f.start();
                                                }
                                                String str232 = this.e2;
                                                this.t3 = str232;
                                                this.f.Q2(str232, true, this.W2, 0L, 0, "", null, d2, 0, this.z2, "nst", this.H2);
                                                x7.a.f().r("onestream_api");
                                                this.f.start();
                                            }
                                            String str242 = this.e2;
                                            this.t3 = str242;
                                            this.f.Q2(str242, true, this.W2, 0L, 0, "", null, d2, 0, this.z2, "nst", this.H2);
                                            x7.a.f().r("m3u");
                                            this.f.start();
                                        }
                                    }
                                }
                                String str26 = this.a3;
                                if ((str26 == null || !str26.equals("movies")) && (str = this.a3) != null && str.equals("series")) {
                                    x7.a.f().x(this.F2);
                                    EpisodesUsingSinglton.getInstance().setEpisodeList(this.E2);
                                    x7.a.f().H(((GetEpisdoeDetailsCallback) this.E2.get(d2)).getId());
                                    x7.a.f().G(w.q0(((GetEpisdoeDetailsCallback) this.E2.get(d2)).getId()));
                                    x7.a.f().v(this.E2);
                                }
                                x7.a.f().w(d2);
                            }
                            if (!this.a3.equals("movies") && this.a3.equals("series")) {
                                this.G2 = w.q0(((GetEpisdoeDetailsCallback) this.E2.get(d2)).getId());
                                SharedPreferences.Editor editor = this.t2;
                                if (editor != null) {
                                    editor.putString("currentlyPlayingVideo", String.valueOf(((GetEpisdoeDetailsCallback) this.E2.get(d2)).getId()));
                                    this.t2.apply();
                                }
                            }
                            SharedPreferences.Editor editor2 = this.u2;
                            if (editor2 != null) {
                                editor2.putString("currentlyPlayingVideoPosition", String.valueOf(d2));
                                this.u2.apply();
                                return;
                            }
                            return;
                        }
                        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes11 = this.f;
                        nSTIJKPlayerEpisodes11.seekTo(nSTIJKPlayerEpisodes11.getNewSeekPosition());
                        this.f.start();
                    }
                    H2();
                    e2();
                    return;
                }
                onBackPressed();
                return;
            }
            boolean equals = this.n3.equals("tv");
            H2();
            if (equals) {
                C2();
                this.f.pause();
                this.f.g();
                this.l.setVisibility(8);
                this.k.setVisibility(0);
                this.k.requestFocus();
                String str27 = this.a3;
                if (str27 == null || !str27.equals("series") || !this.f.getPlayerIsPrepared() || (nSTIJKPlayerEpisodes4 = this.f) == null || nSTIJKPlayerEpisodes4.isPlaying()) {
                    return;
                }
                I2();
                F2(10000);
                return;
            }
            D2();
            this.f.pause();
            this.f.g();
            this.l.setVisibility(8);
        }
        imageView = this.k;
        imageView.setVisibility(0);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        I1(configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0863 A[PHI: r2
      0x0863: PHI (r2v18 java.lang.String) = (r2v12 java.lang.String), (r2v13 java.lang.String) binds: [B:43:0x0861, B:59:0x0872] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r58) {
        /*
            Method dump skipped, instructions count: 2325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        TextView textView;
        super.onDestroy();
        try {
            if (this.S3 != null) {
                p0.a.b(this.T1).e(this.S3);
            }
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
            if (nSTIJKPlayerEpisodes != null && (textView = nSTIJKPlayerEpisodes.v) != null) {
                textView.performClick();
            }
        } catch (Exception e2) {
            Log.e("fsgd", "fdfh", e2);
        }
        try {
            w2();
        } catch (Exception unused) {
        }
        try {
            Thread thread = this.K1;
            if (thread != null && thread.isAlive()) {
                this.K1.interrupt();
            }
        } catch (Exception unused2) {
        }
        String str = this.a3;
        if (str == null || !str.equals("movies_stalker")) {
            return;
        }
        try {
            this.Q3.d(SharepreferenceDBHandler.getLoggedInMacAddress(this.T1), SharepreferenceDBHandler.getStalkerToken(this.T1), this.O3);
        } catch (Exception unused3) {
        }
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
        boolean z = keyEvent.getRepeatCount() == 0;
        String str = this.a3;
        if (str != null && str.equals("series") && this.n3.equals("tv") && i2 != 4) {
            I2();
            if (this.f.getPlayerIsPrepared() && (nSTIJKPlayerEpisodes = this.f) != null && !nSTIJKPlayerEpisodes.isPlaying()) {
                F2(10000);
            }
        }
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
                                                    H2();
                                                    this.f.g();
                                                    if (this.P.getVisibility() == 0 || this.O.getVisibility() == 0 || this.p0.getVisibility() == 0 || this.p0.getVisibility() == 0 || this.q1.getVisibility() == 0 || this.q1.getVisibility() == 0) {
                                                        return true;
                                                    }
                                                    if (this.c3.getVisibility() == 8) {
                                                        this.c3.startAnimation(this.Z1);
                                                        this.c3.setVisibility(0);
                                                        this.k.requestFocus();
                                                        this.l.requestFocus();
                                                    }
                                                    K1(5000);
                                                    return true;
                                                case 20:
                                                    H2();
                                                    this.f.g();
                                                    if (this.P.getVisibility() == 0 || this.O.getVisibility() == 0 || this.p0.getVisibility() == 0 || this.p0.getVisibility() == 0 || this.q1.getVisibility() == 0 || this.q1.getVisibility() == 0) {
                                                        return true;
                                                    }
                                                    if (this.c3.getVisibility() == 8) {
                                                        this.c3.startAnimation(this.Z1);
                                                        this.c3.setVisibility(0);
                                                        this.k.requestFocus();
                                                        this.l.requestFocus();
                                                    }
                                                    K1(5000);
                                                    return true;
                                                case 21:
                                                    H2();
                                                    this.f.g();
                                                    if (this.P.getVisibility() == 0 || this.O.getVisibility() == 0) {
                                                        return false;
                                                    }
                                                    if (this.p0.getVisibility() == 0 || this.p0.getVisibility() == 0 || this.q1.getVisibility() == 0 || this.q1.getVisibility() == 0) {
                                                        return true;
                                                    }
                                                    if (this.c3.getVisibility() == 8) {
                                                        this.c3.startAnimation(this.Z1);
                                                        this.c3.setVisibility(0);
                                                        if (!this.m.isFocused()) {
                                                            this.m.requestFocus();
                                                        }
                                                    }
                                                    if (this.m.isFocused()) {
                                                        I2();
                                                    } else {
                                                        K1(5000);
                                                    }
                                                    return true;
                                                case 22:
                                                    H2();
                                                    this.f.g();
                                                    if (this.P.getVisibility() == 0 || this.O.getVisibility() == 0) {
                                                        return false;
                                                    }
                                                    if (this.p0.getVisibility() == 0 || this.p0.getVisibility() == 0 || this.q1.getVisibility() == 0 || this.q1.getVisibility() == 0) {
                                                        return true;
                                                    }
                                                    if (this.c3.getVisibility() == 8) {
                                                        this.c3.startAnimation(this.Z1);
                                                        this.c3.setVisibility(0);
                                                        if (!this.m.isFocused()) {
                                                            this.m.requestFocus();
                                                        }
                                                    }
                                                    if (this.m.isFocused()) {
                                                        I2();
                                                    } else {
                                                        K1(5000);
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
                                H2();
                                if (this.c3.getVisibility() == 8) {
                                    this.c3.startAnimation(this.Z1);
                                    this.c3.setVisibility(0);
                                    if (!this.m.isFocused()) {
                                        this.m.requestFocus();
                                    }
                                }
                                K1(5000);
                                this.m.setProgress(this.m.getProgress() + 10);
                                this.f.H2(this.m.getProgress());
                            } catch (Exception unused) {
                            }
                            return true;
                        }
                        try {
                            H2();
                            if (this.c3.getVisibility() == 8) {
                                this.c3.startAnimation(this.Z1);
                                this.c3.setVisibility(0);
                                if (!this.m.isFocused()) {
                                    this.m.requestFocus();
                                }
                            }
                            K1(5000);
                            this.m.setProgress(this.m.getProgress() - 10);
                            this.f.H2(this.m.getProgress());
                        } catch (Exception unused2) {
                        }
                        return true;
                    }
                }
                if (this.q1.getVisibility() == 0 || this.q1.getVisibility() == 0) {
                    return true;
                }
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.f;
                if (nSTIJKPlayerEpisodes2 == null || !nSTIJKPlayerEpisodes2.getPlayerIsPrepared()) {
                    N2();
                } else if (this.P.getVisibility() == 8) {
                    (this.f.isPlaying() ? this.l : this.k).performClick();
                }
                return true;
            }
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes3 = this.f;
            if (nSTIJKPlayerEpisodes3 != null && nSTIJKPlayerEpisodes3.getPlayerIsPrepared()) {
                ((!z || this.f.isPlaying()) ? this.l : this.k).performClick();
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
        String str = this.a3;
        if (str == null || !str.equals("movies")) {
            String str2 = this.a3;
            if (str2 != null && str2.equals("series")) {
                P1();
            }
        } else {
            x2(0);
        }
        getIntent().getAction();
        try {
            o4.b bVar = this.s3;
            if (bVar != null) {
                bVar.c().e(this.A3, o4.e.class);
            }
        } catch (Exception unused) {
        }
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        try {
            super/*androidx.activity.ComponentActivity*/.onPictureInPictureModeChanged(z, configuration);
            if (z) {
                m7.a.p1 = true;
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
                if (nSTIJKPlayerEpisodes != null && nSTIJKPlayerEpisodes.h != null) {
                    nSTIJKPlayerEpisodes.setShowOrHideSubtitles(false);
                    this.f.h.setVisibility(8);
                }
                m mVar = new m();
                this.F3 = mVar;
                registerReceiver(mVar, new IntentFilter("media_control"));
                return;
            }
            unregisterReceiver(this.F3);
            this.G3 = false;
            this.F3 = null;
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.f;
            if (nSTIJKPlayerEpisodes2 != null && nSTIJKPlayerEpisodes2.h != null) {
                nSTIJKPlayerEpisodes2.setShowOrHideSubtitles(true);
                this.f.h.setVisibility(0);
                this.f.p2();
            }
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes3 = this.f;
            if (nSTIJKPlayerEpisodes3 != null) {
                nSTIJKPlayerEpisodes3.isPlaying();
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        Intent intent;
        AppOpsManager appOpsManager;
        super/*androidx.fragment.app.e*/.onResume();
        Context context = this.T1;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("auto_start", 0);
            this.L3 = sharedPreferences;
            boolean z = sharedPreferences.getBoolean("picinpic", m7.a.u0);
            this.M3 = z;
            if (z && this.n3.equals("mobile")) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    this.I3 = v.a();
                }
                if (i2 >= 26) {
                    try {
                        if (getPackageManager().hasSystemFeature("android.software.picture_in_picture") && (appOpsManager = (AppOpsManager) this.T1.getSystemService("appops")) != null && appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), this.T1.getPackageName()) == 0) {
                            this.H3 = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        String str = this.a3;
        if (str == null || !str.equals("series")) {
            String str2 = this.a3;
            if (str2 != null && str2.equals("movies") && (intent = getIntent()) != null && intent.getBooleanExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false)) {
                intent.putExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false);
                setIntent(intent);
                if (getIntent().getIntExtra("OPENED_STREAM_ID", 0) != this.Q2) {
                    this.C2 = VodAllCategoriesSingleton.getInstance().getvodList();
                    v2();
                }
            }
        } else {
            Intent intent2 = getIntent();
            if (intent2 != null && intent2.getBooleanExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false)) {
                intent2.putExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false);
                setIntent(intent2);
                if (getIntent().getIntExtra("OPENED_STREAM_ID", 0) != this.Q2) {
                    this.E2 = EpisodesUsingSinglton.getInstance().getEpisodeList();
                    v2();
                }
            }
        }
        w.m(this.T1);
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
        if (nSTIJKPlayerEpisodes != null) {
            nSTIJKPlayerEpisodes.p2();
            if (this.m3) {
                Z3 = false;
            }
        }
        o4.b bVar = this.s3;
        if (bVar != null) {
            bVar.c().a(this.A3, o4.e.class);
        }
    }

    public void onStop() {
        super.onStop();
        try {
            w2();
            if (this.n3.equals("mobile") && this.H3 && this.M3) {
                finishAndRemoveTask();
            }
        } catch (Exception unused) {
        }
    }

    public void onUserLeaveHint() {
        if (this.n3.equals("mobile") && this.H3 && this.M3 && !E.a(this)) {
            try {
                h2();
                this.G3 = true;
            } catch (Exception unused) {
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        if (z) {
            I1(getResources().getConfiguration());
        }
    }

    public final void p2(List list, String str) {
        String str2;
        int i2;
        String str3;
        String str4;
        int i3;
        long j2;
        int i4;
        int i5;
        int i6;
        String str5;
        String str6;
        SharedPreferences.Editor editor;
        if (list == null || list.size() <= 0) {
            return;
        }
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
        if (nSTIJKPlayerEpisodes != null && nSTIJKPlayerEpisodes.getPlayerIsPrepared()) {
            if (this.f.m.equals(str)) {
                return;
            }
        }
        H2();
        C2();
        K1(5000);
        int Z1 = Z1(list, str);
        String title = ((GetEpisdoeDetailsCallback) list.get(Z1)).getTitle();
        this.v3 = ((GetEpisdoeDetailsCallback) list.get(Z1)).getMovieImage();
        this.u3 = title;
        this.w3 = String.valueOf(((GetEpisdoeDetailsCallback) list.get(Z1)).getSeasonNumber());
        this.x3 = w.r0(((GetEpisdoeDetailsCallback) list.get(Z1)).getElapsed_time());
        this.y3 = ((GetEpisdoeDetailsCallback) list.get(Z1)).getSeasonNumber().intValue();
        w.S0(w7.k.a() + w7.k.i());
        int q0 = w.q0(((GetEpisdoeDetailsCallback) list.get(Z1)).getId());
        String id = ((GetEpisdoeDetailsCallback) list.get(Z1)).getId();
        String links = ((GetEpisdoeDetailsCallback) list.get(Z1)).getLinks();
        int i7 = this.T2;
        String containerExtension = ((GetEpisdoeDetailsCallback) list.get(Z1)).getContainerExtension();
        this.F2 = ((GetEpisdoeDetailsCallback) list.get(Z1)).getId();
        this.y1 = ((GetEpisdoeDetailsCallback) list.get(Z1)).getCategoryId();
        this.B1 = ((GetEpisdoeDetailsCallback) list.get(Z1)).getSeriesName();
        x7.a.f().w(Z1);
        int h2 = this.i2.h(this.F2, SharepreferenceDBHandler.getUserID(this.T1));
        SharedPreferences.Editor editor2 = this.t2;
        if (editor2 != null) {
            editor2.putString("currentlyPlayingVideo", String.valueOf(((GetEpisdoeDetailsCallback) list.get(Z1)).getId()));
            this.t2.apply();
        }
        String str7 = this.a3;
        if (str7 != null && str7.equals("series") && (editor = this.t2) != null) {
            editor.putString("currentlyPlayingVideo", String.valueOf(((GetEpisdoeDetailsCallback) list.get(Z1)).getId()));
            this.t2.apply();
        }
        SharedPreferences.Editor editor3 = this.u2;
        if (editor3 != null) {
            editor3.putString("currentlyPlayingVideoPosition", String.valueOf(Z1));
            this.u2.apply();
        }
        SimpleDateFormat simpleDateFormat = this.J2;
        if (R1(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.T1))), this.L2.format(this.K2)) >= w7.c.p() && (str5 = this.O2) != null && this.P2 != null && (!W3.equals(str5) || (this.O2 != null && (str6 = this.P2) != null && !X3.equals(str6)))) {
            this.I2 = Boolean.FALSE;
        }
        this.G2 = q0;
        if (h2 == 0 && this.I2.booleanValue()) {
            w2();
            this.f.setProgress(false);
            this.t3 = links;
            str2 = containerExtension;
            i2 = i7;
            str3 = links;
            str4 = title;
            this.f.Q2(links, true, title, 0L, 0, "", null, Z1, 0, this.z2, "nst", id);
            EpisodesUsingSinglton.getInstance().setEpisodeList(list);
            x7.a.f().x(this.F2);
            x7.a.f().G(q0);
            x7.a.f().v(list);
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = this.f;
            i3 = 0;
            nSTIJKPlayerEpisodes2.e = 0;
            nSTIJKPlayerEpisodes2.f = false;
            nSTIJKPlayerEpisodes2.start();
        } else {
            str2 = containerExtension;
            i2 = i7;
            str3 = links;
            str4 = title;
            i3 = 0;
        }
        if (h2 <= 0 || this.i2.a(this.F2) <= 0) {
            return;
        }
        try {
            j2 = this.g2.gettimeElapsed(this.F2).longValue();
        } catch (Exception unused) {
            j2 = 0;
        }
        if (i2 == 0) {
            i4 = w.r0(this.g2.getTotaltime(this.F2).toString());
            this.T2 = i4;
        } else {
            i4 = i2;
        }
        if (this.f == null || !this.I2.booleanValue()) {
            return;
        }
        w2();
        String.valueOf(Uri.parse(this.A2 + this.F2 + "." + str2));
        this.t3 = this.e2;
        this.f.setProgress(true);
        x7.a.f().I(j2);
        this.f.setCurrentPositionSeekbar((int) j2);
        try {
            i5 = Math.round(w.r0(String.valueOf(j2)) / 1000.0f);
        } catch (Exception unused2) {
            i5 = 0;
            i4 = 0;
        }
        try {
            i6 = Math.round((i5 / i4) * 100.0f);
        } catch (Exception unused3) {
            i6 = 0;
        }
        if (i6 >= 99) {
            this.f.setCurrentPositionSeekbar(i3);
        }
        EpisodesUsingSinglton.getInstance().setEpisodeList(list);
        x7.a.f().x(this.F2);
        this.f.Q2(str3, true, str4, 0L, 0, "", this.D2, Z1, 0, this.z2, "nst", id);
        this.f.start();
    }

    public void r2(String str, int i2, String str2, String str3, String str4, String str5) {
        if (this.f != null) {
            RelativeLayout relativeLayout = this.O;
            if (relativeLayout != null) {
                relativeLayout.startAnimation(this.a2);
                this.O.setVisibility(8);
            }
            this.W2 = str2;
            TextView textView = this.j0;
            if (textView != null) {
                textView.setText(str2);
            }
            SeekBar seekBar = this.m;
            if (seekBar != null) {
                seekBar.setProgress(0);
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.T1).equals("onestream_api")) {
                p2(this.E2, str4);
            } else {
                o2(this.E2, i2);
            }
        }
    }

    public void u(StalkerCreatePlayerLinkCallback stalkerCreatePlayerLinkCallback, View view, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, String str7, String str8) {
    }

    public void y2(Context context, ArrayList arrayList, int i2, long j2) {
        String num = ((LiveStreamsDBModel) arrayList.get(i2)).getNum();
        String name = ((LiveStreamsDBModel) arrayList.get(i2)).getName();
        String streamType = ((LiveStreamsDBModel) arrayList.get(i2)).getStreamType();
        String streamIdOneStream = SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api") ? ((LiveStreamsDBModel) arrayList.get(i2)).getStreamIdOneStream() : ((LiveStreamsDBModel) arrayList.get(i2)).getStreamId();
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
        this.y1 = ((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId();
        String links = ((LiveStreamsDBModel) arrayList.get(i2)).getUrl() == null ? ((LiveStreamsDBModel) arrayList.get(i2)).getLinks() : ((LiveStreamsDBModel) arrayList.get(i2)).getLinks() == null ? ((LiveStreamsDBModel) arrayList.get(i2)).getUrl() : "";
        PanelAvailableChannelsPojo panelAvailableChannelsPojo = new PanelAvailableChannelsPojo();
        panelAvailableChannelsPojo.setNum(Integer.valueOf(w.r0(num)));
        panelAvailableChannelsPojo.setName(name);
        panelAvailableChannelsPojo.setStreamType(streamType);
        panelAvailableChannelsPojo.setStreamId(streamIdOneStream);
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
        if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api")) {
            panelAvailableChannelsPojo.setUrl(links);
        }
        int i3 = this.T2;
        if (i3 != 0) {
            try {
                panelAvailableChannelsPojo.setMovieDuration(i3);
            } catch (Exception unused2) {
            }
            panelAvailableChannelsPojo.setRatingFromTen(valueOf);
            panelAvailableChannelsPojo.setRatingFromFive(valueOf2);
            this.h2.addAllAvailableChannel(panelAvailableChannelsPojo);
        }
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.f;
        if (nSTIJKPlayerEpisodes != null) {
            int duration = nSTIJKPlayerEpisodes.getDuration() / 1000;
            this.T2 = duration;
            j3 = duration;
        }
        panelAvailableChannelsPojo.setMovieDuration(j3);
        panelAvailableChannelsPojo.setRatingFromTen(valueOf);
        panelAvailableChannelsPojo.setRatingFromFive(valueOf2);
        this.h2.addAllAvailableChannel(panelAvailableChannelsPojo);
    }

    public class i implements y {
        public i() {
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0033 A[Catch: Exception -> 0x001c, TryCatch #0 {Exception -> 0x001c, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x0033, B:13:0x0021, B:16:0x002b, B:19:0x003c, B:21:0x0044, B:22:0x006a, B:24:0x008f, B:26:0x0095, B:27:0x00a0), top: B:2:0x0005 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(o4.e r10) {
            /*
                r9 = this;
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.w1(r0, r10)
                java.lang.String r10 = ""
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                android.content.Context r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.x1(r0)     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getType(r0)     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto L1f
                java.lang.String r1 = "local"
                boolean r1 = r0.equals(r1)     // Catch: java.lang.Exception -> L1c
                if (r1 != 0) goto L33
                goto L1f
            L1c:
                r10 = move-exception
                goto Lb7
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
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r10 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.z1(r10)     // Catch: java.lang.Exception -> L1c
                goto Ld1
            L3a:
                if (r0 == 0) goto L6a
                java.lang.String r1 = "series"
                boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto L6a
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L1c
                r10.<init>()     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                android.content.res.Resources r0 = r0.getResources()     // Catch: java.lang.Exception -> L1c
                int r1 = a7.j.J6     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Exception -> L1c
                r10.append(r0)     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = " - "
                r10.append(r0)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.A1(r0)     // Catch: java.lang.Exception -> L1c
                r10.append(r0)     // Catch: java.lang.Exception -> L1c
                java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> L1c
            L6a:
                r1 = r10
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r10 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.B1(r10)     // Catch: java.lang.Exception -> L1c
                java.lang.String r2 = ""
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r10 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r4 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.C1(r10)     // Catch: java.lang.Exception -> L1c
                java.lang.String r5 = "videos/mp4"
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r10 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                java.lang.String r6 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.D1(r10)     // Catch: java.lang.Exception -> L1c
                java.lang.String r7 = ""
                r8 = 0
                r3 = 0
                com.google.android.gms.cast.MediaInfo r10 = i7.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r0 = r0.f     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto Ld1
                int r0 = r0.getCurrentPosition()     // Catch: java.lang.Exception -> L1c
                if (r0 == 0) goto La0
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r1 = r0.f     // Catch: java.lang.Exception -> L1c
                int r1 = r1.getCurrentPosition()     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.F1(r0, r1)     // Catch: java.lang.Exception -> L1c
            La0:
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                int r0 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.E1(r0)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r1 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                o4.e r1 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.v1(r1)     // Catch: java.lang.Exception -> L1c
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r2 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this     // Catch: java.lang.Exception -> L1c
                android.content.Context r2 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.x1(r2)     // Catch: java.lang.Exception -> L1c
                r3 = 1
                i7.a.c(r0, r3, r10, r1, r2)     // Catch: java.lang.Exception -> L1c
                goto Ld1
            Lb7:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onApplicationConnected: "
                r0.append(r1)
                java.lang.String r10 = r10.getMessage()
                r0.append(r10)
                java.lang.String r10 = r0.toString()
                java.lang.String r0 = "honey"
                android.util.Log.e(r0, r10)
            Ld1:
                com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer r10 = com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.this
                r10.invalidateOptionsMenu()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer.i.a(o4.e):void");
        }

        private void b() {
            HoneyPlayer.this.invalidateOptionsMenu();
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
            HoneyPlayer.w1(HoneyPlayer.this, eVar);
            if (HoneyPlayer.v1(HoneyPlayer.this) != null) {
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = HoneyPlayer.this.f;
                if (nSTIJKPlayerEpisodes != null) {
                    nSTIJKPlayerEpisodes.p2();
                    HoneyPlayer.this.f.pause();
                }
                LinearLayout linearLayout = HoneyPlayer.this.y0;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                HoneyPlayer honeyPlayer = HoneyPlayer.this;
                if (honeyPlayer.z0 != null) {
                    if (HoneyPlayer.v1(honeyPlayer).q() == null || HoneyPlayer.v1(HoneyPlayer.this).q().J() == null) {
                        textView = HoneyPlayer.this.z0;
                        sb = new StringBuilder();
                        string = HoneyPlayer.this.getResources().getString(a7.j.v0);
                    } else {
                        textView = HoneyPlayer.this.z0;
                        sb = new StringBuilder();
                        sb.append(HoneyPlayer.this.getResources().getString(a7.j.w0));
                        sb.append(" ");
                        string = HoneyPlayer.v1(HoneyPlayer.this).q().J();
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
