package com.nst.iptvsmarterstvbox.view.ijkplayer.activities;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ActionMenuView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.activities.FreeTrailActivity;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.StalkerLiveFavIdsSingleton;
import com.nst.iptvsmarterstvbox.model.callback.StalkerCreatePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerDeletePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAdCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetSeriesCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVODByCatCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerLiveFavIdsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerProfilesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerSetLiveFavCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerShortEPGCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerTokenCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerShortEPGPojo;
import com.nst.iptvsmarterstvbox.model.pojo.XMLTVProgrammePojo;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.MaintanencePannelActivity;
import com.nst.iptvsmarterstvbox.sbpfunction.callbackclientreport.ClientFeedbackCallback;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSkyTv;
import d.a;
import j$.util.DesugarTimeZone;
import j$.util.Objects;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import m7.w;
import org.joda.time.LocalDateTime;
import org.json.JSONObject;
import q7.P;
import q7.Z;
import q7.m0;
import q7.t;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerSkyTvActivity extends androidx.appcompat.app.b implements SurfaceHolder.Callback, View.OnClickListener, z7.j, z7.g, CompoundButton.OnCheckedChangeListener {
    public static SharedPreferences E5 = null;
    public static SharedPreferences F5 = null;
    public static boolean G5 = false;
    public static String H5;
    public static String I5;
    public static final int[] J5 = {0, 1, 2, 3, 4, 5};
    public static ProgressBar K5;
    public LinearLayout A;
    public ArrayList A0;
    public LinearLayout A1;
    public Boolean A2;
    public LinearLayout A3;
    public CheckBox A4;
    public boolean A5;
    public TextView B;
    public ArrayList B0;
    public LinearLayout B1;
    public AsyncTask B2;
    public LinearLayout B3;
    public CheckBox B4;
    public int B5;
    public ImageView C;
    public ArrayList C0;
    public LinearLayout C1;
    public AsyncTask C2;
    public LinearLayout C3;
    public CheckBox C4;
    public ArrayList C5;
    public TextView D;
    public ArrayList D0;
    public LinearLayout D1;
    public AsyncTask D2;
    public LinearLayout D3;
    public CheckBox D4;
    public boolean D5;
    public TextView E;
    public ArrayList E0;
    public LinearLayout E1;
    public ProgressDialog E2;
    public LinearLayout E3;
    public CheckBox E4;
    public TextView F;
    public ArrayList F0;
    public String F1;
    public boolean F2;
    public LinearLayout F3;
    public CheckBox F4;
    public TextView G;
    public ArrayList G0;
    public int G2;
    public LinearLayout G3;
    public CheckBox G4;
    public LinearLayout H;
    public ArrayList H0;
    public boolean H2;
    public RelativeLayout H3;
    public CheckBox H4;
    public ProgressBar I;
    public ArrayList I0;
    public int I2;
    public RelativeLayout I3;
    public RelativeLayout I4;
    public LinearLayout J;
    public DatabaseHandler J1;
    public int J2;
    public RelativeLayout J3;
    public CheckBox J4;
    public LinearLayout K;
    public ArrayList K0;
    public SharedPreferences.Editor K1;
    public SharedPreferences K2;
    public RelativeLayout K3;
    public CheckBox K4;
    public ArrayList L0;
    public SharedPreferences.Editor L1;
    public Boolean L2;
    public RecyclerView L3;
    public CheckBox L4;
    public SharedPreferences M0;
    public TextView M1;
    public Boolean M2;
    public RecyclerView M3;
    public CheckBox M4;
    public SharedPreferences.Editor N0;
    public String N1;
    public Boolean N2;
    public EditText N3;
    public TextView N4;
    public ArrayList O0;
    public TextView O1;
    public Boolean O2;
    public ImageView O3;
    public TextView O4;
    public int P;
    public ArrayList P0;
    public Handler P1;
    public Boolean P2;
    public ImageView P3;
    public TextView P4;
    public String Q;
    public ArrayList Q0;
    public Handler Q1;
    public Boolean Q2;
    public ImageView Q3;
    public TextView Q4;
    public String R;
    public RecyclerView R0;
    public Handler R1;
    public u7.a R2;
    public ImageView R3;
    public TextView R4;
    public String S;
    public ProgressBar S0;
    public Handler S1;
    public Handler S2;
    public ImageView S3;
    public TextView S4;
    public String T;
    public Toolbar T0;
    public Handler T1;
    public Handler T2;
    public ImageView T3;
    public TextView T4;
    public RelativeLayout U;
    public SearchView U0;
    public Handler U1;
    public ArrayList U2;
    public ImageView U3;
    public TextView U4;
    public ListView V;
    public TextView V0;
    public SharedPreferences.Editor V1;
    public int V2;
    public Animation V3;
    public EditText V4;
    public ListView W;
    public LinearLayout W0;
    public SharedPreferences.Editor W1;
    public String W2;
    public Animation W3;
    public LinearLayout W4;
    public LinearLayout X0;
    public SharedPreferences.Editor X1;
    public String X2;
    public Animation X3;
    public LinearLayout X4;
    public AppBarLayout Y0;
    public TextView Y1;
    public Boolean Y2;
    public Animation Y3;
    public LinearLayout Y4;
    public RadioGroup Z2;
    public Animation Z3;
    public LinearLayout Z4;
    public RadioGroup a3;
    public Animation a4;
    public ImageView a5;
    public LinearLayout b2;
    public RadioGroup b3;
    public Animation b4;
    public RelativeLayout b5;
    public String c1;
    public TextView c2;
    public TextView c3;
    public Animation c4;
    public LinearLayout c5;
    public Context d;
    public TextView d3;
    public Animation d4;
    public LinearLayout d5;
    public ArrayList e;
    public String e0;
    public RelativeLayout e1;
    public Boolean e2;
    public TextView e3;
    public String e4;
    public LinearLayout e5;
    public ArrayList f;
    public LinearLayout f1;
    public Boolean f2;
    public TextView f3;
    public q7.N f4;
    public LinearLayout f5;
    public n7.g g;
    public LiveStreamDBHandler g0;
    public RelativeLayout g1;
    public Menu g2;
    public TextView g3;
    public q7.N g4;
    public LinearLayout g5;
    public SharedPreferences h0;
    public RelativeLayout h1;
    public MenuItem h2;
    public TextView h3;
    public q7.O h4;
    public RelativeLayout h5;
    public SharedPreferences i0;
    public RelativeLayout i1;
    public DateFormat i2;
    public TextView i3;
    public P i4;
    public String i5;
    public SharedPreferences j0;
    public String j2;
    public TextView j3;
    public LinearLayoutManager j4;
    public String j5;
    public SharedPreferences k0;
    public String k2;
    public FrameLayout k3;
    public LinearLayoutManager k4;
    public String k5;
    public List l;
    public SharedPreferences l0;
    public TextView l1;
    public String l2;
    public SeekBar l3;
    public int l4;
    public String l5;
    public n7.e m;
    public SharedPreferences m0;
    public TextView m1;
    public SimpleDateFormat m2;
    public SeekBar m3;
    public Animation m4;
    public String m5;
    public SharedPreferences n0;
    public TextView n1;
    public NSTIJKPlayerSkyTv n2;
    public LinearLayout n3;
    public Animation n4;
    public String n5;
    public SharedPreferences o0;
    public TextView o1;
    public Date o2;
    public LinearLayout o3;
    public String o4;
    public String o5;
    public SharedPreferences p0;
    public String p1;
    public String p2;
    public LinearLayout p3;
    public String p4;
    public String p5;
    public SimpleDateFormat q0;
    public TextView q1;
    public Boolean q2;
    public LinearLayout q3;
    public String q4;
    public String q5;
    public String r;
    public String r0;
    public TextView r1;
    public androidx.appcompat.app.a r2;
    public LinearLayout r3;
    public String r4;
    public List r5;
    public View s;
    public RelativeLayout s0;
    public TextView s1;
    public String s2;
    public LinearLayout s3;
    public String s4;
    public JsonArray s5;
    public View t;
    public TextView t1;
    public Boolean t2;
    public LinearLayout t3;
    public int t4;
    public String t5;
    public LinearLayout u;
    public TextView u0;
    public TextView u1;
    public D7.b u2;
    public LinearLayout u3;
    public RelativeLayout u4;
    public Thread u5;
    public View v;
    public ArrayList v0;
    public TextView v1;
    public String v2;
    public LinearLayout v3;
    public RelativeLayout v4;
    public boolean v5;
    public String w;
    public ArrayList w0;
    public TextView w1;
    public int w2;
    public LinearLayout w3;
    public RelativeLayout w4;
    public boolean w5;
    public View x;
    public ArrayList x0;
    public TextView x1;
    public int x2;
    public LinearLayout x3;
    public TextView x4;
    public MultiUserDBHandler x5;
    public View y;
    public ArrayList y0;
    public LinearLayout y1;
    public String y2;
    public LinearLayout y3;
    public TextView y4;
    public Thread y5;
    public ArrayList z0;
    public String z1;
    public String z2;
    public LinearLayout z3;
    public CheckBox z4;
    public Boolean z5;
    public String h = "";
    public String i = "";
    public int j = 0;
    public int k = 0;
    public String n = "";
    public String o = "";
    public int p = 0;
    public int q = 0;
    public boolean z = false;
    public boolean L = true;
    public boolean M = false;
    public boolean N = false;
    public boolean O = false;
    public ArrayList X = new ArrayList();
    public boolean Y = true;
    public long Z = 2500;
    public boolean f0 = true;
    public int t0 = 0;
    public ArrayList J0 = new ArrayList();
    public boolean Z0 = true;
    public boolean a1 = false;
    public boolean b1 = false;
    public boolean d1 = true;
    public String j1 = "";
    public String k1 = "";
    public int G1 = -1;
    public String H1 = "";
    public String I1 = "";
    public int Z1 = 0;
    public StringBuilder a2 = new StringBuilder();
    public int d2 = -1;

    public class A implements View.OnClickListener {
        public A() {
        }

        public void onClick(View view) {
            try {
                NSTIJKPlayerSkyTvActivity.this.q2 = Boolean.TRUE;
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", NSTIJKPlayerSkyTvActivity.this.getPackageName(), (String) null));
                NSTIJKPlayerSkyTvActivity.this.startActivityForResult(intent, 101);
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                Toast.makeText(nSTIJKPlayerSkyTvActivity, nSTIJKPlayerSkyTvActivity.d.getResources().getString(a7.j.o2), 1).show();
            } catch (Exception unused) {
            }
            NSTIJKPlayerSkyTvActivity.U2(NSTIJKPlayerSkyTvActivity.this).dismiss();
        }
    }

    public class B implements View.OnClickListener {
        public B() {
        }

        public void onClick(View view) {
            NSTIJKPlayerSkyTvActivity.U2(NSTIJKPlayerSkyTvActivity.this).dismiss();
        }
    }

    public class C implements Runnable {
        public C() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = m7.w.R(NSTIJKPlayerSkyTvActivity.this.d);
                String A = m7.w.A(date);
                TextView textView = NSTIJKPlayerSkyTvActivity.this.O1;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = NSTIJKPlayerSkyTvActivity.this.M1;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class D implements AdapterView.OnItemClickListener {
        public D() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String cmd;
            n7.g T1;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            NSTIJKPlayerSkyTvActivity.l2(NSTIJKPlayerSkyTvActivity.this, i);
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("stalker_api")) {
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                NSTIJKPlayerSkyTvActivity.n2(nSTIJKPlayerSkyTvActivity, NSTIJKPlayerSkyTvActivity.k2(nSTIJKPlayerSkyTvActivity), NSTIJKPlayerSkyTvActivity.this.f);
                return;
            }
            try {
                String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTIJKPlayerSkyTvActivity.this.d);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(NSTIJKPlayerSkyTvActivity.this.d);
                ArrayList g = NSTIJKPlayerSkyTvActivity.m2(NSTIJKPlayerSkyTvActivity.this).g();
                if (g != null && g.size() > 0) {
                    cmd = ((LiveStreamsDBModel) g.get(NSTIJKPlayerSkyTvActivity.k2(NSTIJKPlayerSkyTvActivity.this))).getCmd();
                    NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity2 = NSTIJKPlayerSkyTvActivity.this;
                    if (nSTIJKPlayerSkyTvActivity2.G1 != m7.w.q0(((LiveStreamsDBModel) g.get(NSTIJKPlayerSkyTvActivity.k2(nSTIJKPlayerSkyTvActivity2))).getStreamId())) {
                        m7.w.N0(NSTIJKPlayerSkyTvActivity.this.d);
                        T1 = NSTIJKPlayerSkyTvActivity.T1(NSTIJKPlayerSkyTvActivity.this);
                        str = "";
                        str2 = "itv";
                        str3 = "";
                        str4 = "";
                        str5 = "";
                        str6 = "";
                        str7 = "";
                        str8 = "channel_click_from_player";
                        str9 = "";
                        T1.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, "");
                        return;
                    }
                    NSTIJKPlayerSkyTvActivity.this.A3();
                }
                if (NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this) == null || NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).size() <= 0) {
                    return;
                }
                cmd = ((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(NSTIJKPlayerSkyTvActivity.k2(NSTIJKPlayerSkyTvActivity.this))).getCmd();
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity3 = NSTIJKPlayerSkyTvActivity.this;
                if (nSTIJKPlayerSkyTvActivity3.G1 != m7.w.q0(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(nSTIJKPlayerSkyTvActivity3).get(NSTIJKPlayerSkyTvActivity.k2(NSTIJKPlayerSkyTvActivity.this))).getStreamId())) {
                    m7.w.N0(NSTIJKPlayerSkyTvActivity.this.d);
                    T1 = NSTIJKPlayerSkyTvActivity.T1(NSTIJKPlayerSkyTvActivity.this);
                    str = "";
                    str2 = "itv";
                    str3 = "";
                    str4 = "";
                    str5 = "";
                    str6 = "";
                    str7 = "";
                    str8 = "channel_click_from_player";
                    str9 = "";
                    T1.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, "");
                    return;
                }
                NSTIJKPlayerSkyTvActivity.this.A3();
            } catch (Exception unused) {
            }
        }
    }

    public class E implements Runnable {
        public E() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    NSTIJKPlayerSkyTvActivity.this.w3();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class F extends AsyncTask {
        public F() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return Boolean.valueOf(NSTIJKPlayerSkyTvActivity.this.S3());
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            NSTIJKPlayerSkyTvActivity.i2(NSTIJKPlayerSkyTvActivity.this, "", true);
            NSTIJKPlayerSkyTvActivity.j2(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
            if (NSTIJKPlayerSkyTvActivity.z1(NSTIJKPlayerSkyTvActivity.this) != null) {
                NSTIJKPlayerSkyTvActivity.z1(NSTIJKPlayerSkyTvActivity.this).setEPGHandler(NSTIJKPlayerSkyTvActivity.this.S1);
                NSTIJKPlayerSkyTvActivity.z1(NSTIJKPlayerSkyTvActivity.this).setContext(NSTIJKPlayerSkyTvActivity.this.d);
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                NSTIJKPlayerSkyTvActivity.g2(nSTIJKPlayerSkyTvActivity, NSTIJKPlayerSkyTvActivity.u3(nSTIJKPlayerSkyTvActivity.d));
                if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                    return;
                }
            } else if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).isShowing()) {
                return;
            }
            NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).show();
        }
    }

    public class G implements Runnable {
        public G() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (SharepreferenceDBHandler.getMaintanceModeState(NSTIJKPlayerSkyTvActivity.this.d)) {
                        NSTIJKPlayerSkyTvActivity.this.d.startActivity(new Intent(NSTIJKPlayerSkyTvActivity.this.d, MaintanencePannelActivity.class));
                    }
                    Thread.sleep(10000L);
                } catch (Exception e) {
                    Log.e("honey", "exc2: " + e.getMessage());
                } catch (InterruptedException e2) {
                    Log.e("honey", "exc2: " + e2.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class H extends AsyncTask {
        public H() {
        }

        public String a() {
            NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity;
            LiveStreamDBHandler liveStreamDBHandler;
            String str;
            SharedPreferences G1;
            String str2;
            try {
                NSTIJKPlayerSkyTvActivity.A1(NSTIJKPlayerSkyTvActivity.this, 0);
                if (NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this) != null && NSTIJKPlayerSkyTvActivity.D1(NSTIJKPlayerSkyTvActivity.this) != null) {
                    NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).clear();
                    NSTIJKPlayerSkyTvActivity.D1(NSTIJKPlayerSkyTvActivity.this).clear();
                }
                if (NSTIJKPlayerSkyTvActivity.E1(NSTIJKPlayerSkyTvActivity.this).equals("true")) {
                    nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                    liveStreamDBHandler = nSTIJKPlayerSkyTvActivity.g0;
                    str = "radio_streams";
                } else {
                    nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                    liveStreamDBHandler = nSTIJKPlayerSkyTvActivity.g0;
                    str = "live";
                }
                NSTIJKPlayerSkyTvActivity.C1(nSTIJKPlayerSkyTvActivity, liveStreamDBHandler.getAllLiveStreasWithCategoryId("0", str));
                if (NSTIJKPlayerSkyTvActivity.Z2(NSTIJKPlayerSkyTvActivity.this) != null) {
                    NSTIJKPlayerSkyTvActivity.Z2(NSTIJKPlayerSkyTvActivity.this).clear();
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(NSTIJKPlayerSkyTvActivity.F1(NSTIJKPlayerSkyTvActivity.this).C()));
                String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(NSTIJKPlayerSkyTvActivity.this.d)));
                boolean B = NSTIJKPlayerSkyTvActivity.F1(NSTIJKPlayerSkyTvActivity.this).B();
                ArrayList ePGTesting = B ? NSTIJKPlayerSkyTvActivity.this.g0.getEPGTesting((String) null, format) : null;
                if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("m3u")) {
                    G1 = NSTIJKPlayerSkyTvActivity.G1(NSTIJKPlayerSkyTvActivity.this);
                    str2 = "LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U";
                } else if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("onestream_api")) {
                    G1 = NSTIJKPlayerSkyTvActivity.G1(NSTIJKPlayerSkyTvActivity.this);
                    str2 = "LOGIN_PREF_CURRENTLY_PLAYING_VIDEO";
                } else {
                    G1 = NSTIJKPlayerSkyTvActivity.G1(NSTIJKPlayerSkyTvActivity.this);
                    str2 = "currentlyPlayingVideo";
                }
                String string = G1.getString(str2, "");
                if (NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this) == null || NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).size() <= 0) {
                    return "all_channels";
                }
                for (int i = 0; i < NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).size(); i++) {
                    if (NSTIJKPlayerSkyTvActivity.H1(NSTIJKPlayerSkyTvActivity.this) != null && NSTIJKPlayerSkyTvActivity.H1(NSTIJKPlayerSkyTvActivity.this).isCancelled()) {
                        return "all_channels";
                    }
                    if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("m3u")) {
                        if (((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getUrl().equals(string)) {
                            NSTIJKPlayerSkyTvActivity.A1(NSTIJKPlayerSkyTvActivity.this, i);
                        }
                    } else if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("onestream_api")) {
                        if (((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamIdOneStream().equals(string)) {
                            NSTIJKPlayerSkyTvActivity.A1(NSTIJKPlayerSkyTvActivity.this, i);
                        }
                    } else if (((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamId().equals(string)) {
                        NSTIJKPlayerSkyTvActivity.A1(NSTIJKPlayerSkyTvActivity.this, i);
                    }
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setNum(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getNum());
                    liveStreamsDBModel.setName(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getName());
                    liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamType());
                    liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamId());
                    liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamIdOneStream());
                    liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamIcon());
                    liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getEpgChannelId());
                    liveStreamsDBModel.setAdded(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getAdded());
                    liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getCategoryId());
                    liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getCustomSid());
                    liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getTvArchive());
                    liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getDirectSource());
                    liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getTvArchiveDuration());
                    liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getTypeName());
                    liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getCategoryName());
                    liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getSeriesNo());
                    liveStreamsDBModel.setLive(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getLive());
                    liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getContaiinerExtension());
                    liveStreamsDBModel.setUrl(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getUrl());
                    if (B && ePGTesting != null && ePGTesting.size() > 0) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= ePGTesting.size() || (NSTIJKPlayerSkyTvActivity.H1(NSTIJKPlayerSkyTvActivity.this) != null && NSTIJKPlayerSkyTvActivity.H1(NSTIJKPlayerSkyTvActivity.this).isCancelled())) {
                                break;
                            }
                            if (((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.B1(NSTIJKPlayerSkyTvActivity.this).get(i)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i2)).getChannel())) {
                                int M = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i2)).getStart(), NSTIJKPlayerSkyTvActivity.this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i2)).getStop(), NSTIJKPlayerSkyTvActivity.this.d), NSTIJKPlayerSkyTvActivity.this.d);
                                if (M != 0) {
                                    M = 100 - M;
                                }
                                liveStreamsDBModel.setEpgPercentage(M);
                                liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i2)).getTitle());
                            } else {
                                i2++;
                            }
                        }
                    }
                    NSTIJKPlayerSkyTvActivity.Z2(NSTIJKPlayerSkyTvActivity.this).add(liveStreamsDBModel);
                }
                return "all_channels";
            } catch (Exception unused) {
                return "all_channels";
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0035  */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r0 = 0
                r6 = r6[r0]     // Catch: java.lang.Exception -> L5a
                int r1 = r6.hashCode()     // Catch: java.lang.Exception -> L5a
                r2 = 2
                r3 = 1
                r4 = 3
                switch(r1) {
                    case -74797390: goto L2b;
                    case 47612238: goto L21;
                    case 301138327: goto L17;
                    case 613425326: goto Le;
                    default: goto Ld;
                }     // Catch: java.lang.Exception -> L5a
            Ld:
                goto L35
            Le:
                java.lang.String r1 = "all_channels"
                boolean r6 = r6.equals(r1)     // Catch: java.lang.Exception -> L5a
                if (r6 == 0) goto L35
                goto L36
            L17:
                java.lang.String r0 = "recently_watched"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L5a
                if (r6 == 0) goto L35
                r0 = 3
                goto L36
            L21:
                java.lang.String r0 = "all_channels_with_cat"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L5a
                if (r6 == 0) goto L35
                r0 = 1
                goto L36
            L2b:
                java.lang.String r0 = "get_fav"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L5a
                if (r6 == 0) goto L35
                r0 = 2
                goto L36
            L35:
                r0 = -1
            L36:
                if (r0 == 0) goto L55
                if (r0 == r3) goto L4e
                if (r0 == r2) goto L47
                if (r0 == r4) goto L40
                r6 = 0
                return r6
            L40:
                com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r6 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L5a
                java.lang.String r6 = r6.k3()     // Catch: java.lang.Exception -> L5a
                return r6
            L47:
                com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r6 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L5a
                java.lang.String r6 = r6.D3()     // Catch: java.lang.Exception -> L5a
                return r6
            L4e:
                com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r6 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L5a
                java.lang.String r6 = r6.g3()     // Catch: java.lang.Exception -> L5a
                return r6
            L55:
                java.lang.String r6 = r5.a()     // Catch: java.lang.Exception -> L5a
                return r6
            L5a:
                java.lang.String r6 = "error"
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.H.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (NSTIJKPlayerSkyTvActivity.Z2(NSTIJKPlayerSkyTvActivity.this) != null) {
                    if (!NSTIJKPlayerSkyTvActivity.w1(NSTIJKPlayerSkyTvActivity.this).booleanValue()) {
                        NSTIJKPlayerSkyTvActivity.x1(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
                        if (NSTIJKPlayerSkyTvActivity.Z2(NSTIJKPlayerSkyTvActivity.this).size() == 0) {
                            m7.a.Y = Boolean.FALSE;
                            NSTIJKPlayerSkyTvActivity.this.Z3();
                            NSTIJKPlayerSkyTvActivity.z1(NSTIJKPlayerSkyTvActivity.this).setVisibility(8);
                        } else if (NSTIJKPlayerSkyTvActivity.y1(NSTIJKPlayerSkyTvActivity.this) != null) {
                            NSTIJKPlayerSkyTvActivity.y1(NSTIJKPlayerSkyTvActivity.this).clear();
                            NSTIJKPlayerSkyTvActivity.y1(NSTIJKPlayerSkyTvActivity.this).addAll(NSTIJKPlayerSkyTvActivity.Z2(NSTIJKPlayerSkyTvActivity.this));
                        }
                    }
                    NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                    if (nSTIJKPlayerSkyTvActivity.a1 && nSTIJKPlayerSkyTvActivity.b1 && !nSTIJKPlayerSkyTvActivity.c1.equals("")) {
                        NSTIJKPlayerSkyTvActivity.A1(NSTIJKPlayerSkyTvActivity.this, 0);
                        try {
                            NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity2 = NSTIJKPlayerSkyTvActivity.this;
                            NSTIJKPlayerSkyTvActivity.A1(nSTIJKPlayerSkyTvActivity2, nSTIJKPlayerSkyTvActivity2.G3(NSTIJKPlayerSkyTvActivity.Z2(nSTIJKPlayerSkyTvActivity2), m7.w.r0(NSTIJKPlayerSkyTvActivity.this.c1)));
                        } catch (NumberFormatException | Exception e) {
                            e.printStackTrace();
                        }
                        NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity3 = NSTIJKPlayerSkyTvActivity.this;
                        nSTIJKPlayerSkyTvActivity3.a1 = false;
                        nSTIJKPlayerSkyTvActivity3.b1 = false;
                    }
                    NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity4 = NSTIJKPlayerSkyTvActivity.this;
                    nSTIJKPlayerSkyTvActivity4.n4(NSTIJKPlayerSkyTvActivity.Z2(nSTIJKPlayerSkyTvActivity4));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            try {
                TextView textView = NSTIJKPlayerSkyTvActivity.this.V0;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                TextView textView2 = nSTIJKPlayerSkyTvActivity.u0;
                if (textView2 != null) {
                    textView2.setText(nSTIJKPlayerSkyTvActivity.k1);
                    NSTIJKPlayerSkyTvActivity.this.u0.setSelected(true);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class I extends AsyncTask {
        public I() {
        }

        public String a() {
            LiveStreamDBHandler liveStreamDBHandler;
            String E2;
            String str;
            NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity;
            int Z1;
            try {
                NSTIJKPlayerSkyTvActivity.a2(NSTIJKPlayerSkyTvActivity.this, 0);
                if (NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this) != null) {
                    NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).clear();
                }
                if (NSTIJKPlayerSkyTvActivity.E1(NSTIJKPlayerSkyTvActivity.this).equals("true")) {
                    NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity2 = NSTIJKPlayerSkyTvActivity.this;
                    liveStreamDBHandler = nSTIJKPlayerSkyTvActivity2.g0;
                    E2 = NSTIJKPlayerSkyTvActivity.E2(nSTIJKPlayerSkyTvActivity2);
                    str = "radio_streams";
                } else {
                    NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity3 = NSTIJKPlayerSkyTvActivity.this;
                    liveStreamDBHandler = nSTIJKPlayerSkyTvActivity3.g0;
                    E2 = NSTIJKPlayerSkyTvActivity.E2(nSTIJKPlayerSkyTvActivity3);
                    str = "live";
                }
                NSTIJKPlayerSkyTvActivity.P1(NSTIJKPlayerSkyTvActivity.this, liveStreamDBHandler.getAllLiveStreasWithCategoryId(E2, str));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(NSTIJKPlayerSkyTvActivity.F1(NSTIJKPlayerSkyTvActivity.this).C()));
                String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(NSTIJKPlayerSkyTvActivity.this.d)));
                boolean B = NSTIJKPlayerSkyTvActivity.F1(NSTIJKPlayerSkyTvActivity.this).B();
                ArrayList ePGTesting = B ? NSTIJKPlayerSkyTvActivity.this.g0.getEPGTesting((String) null, format) : null;
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity4 = NSTIJKPlayerSkyTvActivity.this;
                NSTIJKPlayerSkyTvActivity.b2(nSTIJKPlayerSkyTvActivity4, nSTIJKPlayerSkyTvActivity4.getSharedPreferences("currentlyPlayingVideo", 0));
                String string = SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("m3u") ? NSTIJKPlayerSkyTvActivity.G1(NSTIJKPlayerSkyTvActivity.this).getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("onestream_api") ? NSTIJKPlayerSkyTvActivity.G1(NSTIJKPlayerSkyTvActivity.this) : NSTIJKPlayerSkyTvActivity.G1(NSTIJKPlayerSkyTvActivity.this)).getString("currentlyPlayingVideo", "");
                ArrayList arrayList = new ArrayList();
                if (NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this) != null && NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).size() > 0) {
                    for (int i = 0; i < NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).size() && (NSTIJKPlayerSkyTvActivity.H1(NSTIJKPlayerSkyTvActivity.this) == null || !NSTIJKPlayerSkyTvActivity.H1(NSTIJKPlayerSkyTvActivity.this).isCancelled()); i++) {
                        if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("m3u")) {
                            if (((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getUrl().equals(string)) {
                                NSTIJKPlayerSkyTvActivity.a2(NSTIJKPlayerSkyTvActivity.this, i);
                                nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                                Z1 = NSTIJKPlayerSkyTvActivity.Z1(nSTIJKPlayerSkyTvActivity);
                                NSTIJKPlayerSkyTvActivity.S1(nSTIJKPlayerSkyTvActivity, Z1);
                            }
                        } else if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("onestream_api")) {
                            if (((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamIdOneStream().equals(string)) {
                                NSTIJKPlayerSkyTvActivity.a2(NSTIJKPlayerSkyTvActivity.this, i);
                                nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                                Z1 = NSTIJKPlayerSkyTvActivity.Z1(nSTIJKPlayerSkyTvActivity);
                                NSTIJKPlayerSkyTvActivity.S1(nSTIJKPlayerSkyTvActivity, Z1);
                            }
                        } else if (((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamId().equals(string)) {
                            NSTIJKPlayerSkyTvActivity.a2(NSTIJKPlayerSkyTvActivity.this, i);
                            nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                            Z1 = NSTIJKPlayerSkyTvActivity.Z1(nSTIJKPlayerSkyTvActivity);
                            NSTIJKPlayerSkyTvActivity.S1(nSTIJKPlayerSkyTvActivity, Z1);
                        }
                        LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                        liveStreamsDBModel.setNum(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getNum());
                        liveStreamsDBModel.setName(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getName());
                        liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamType());
                        liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamId());
                        liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamIdOneStream());
                        liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getStreamIcon());
                        liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getEpgChannelId());
                        liveStreamsDBModel.setAdded(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getAdded());
                        liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getCategoryId());
                        liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getCustomSid());
                        liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getTvArchive());
                        liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getDirectSource());
                        liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getTvArchiveDuration());
                        liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getTypeName());
                        liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getCategoryName());
                        liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getSeriesNo());
                        liveStreamsDBModel.setLive(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getLive());
                        liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getContaiinerExtension());
                        liveStreamsDBModel.setUrl(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getUrl());
                        if (B && ePGTesting != null && ePGTesting.size() > 0) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < ePGTesting.size() && (NSTIJKPlayerSkyTvActivity.H1(NSTIJKPlayerSkyTvActivity.this) == null || !NSTIJKPlayerSkyTvActivity.H1(NSTIJKPlayerSkyTvActivity.this).isCancelled())) {
                                    if (((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i2)).getChannel())) {
                                        int M = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i2)).getStart(), NSTIJKPlayerSkyTvActivity.this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i2)).getStop(), NSTIJKPlayerSkyTvActivity.this.d), NSTIJKPlayerSkyTvActivity.this.d);
                                        if (M != 0) {
                                            M = 100 - M;
                                        }
                                        liveStreamsDBModel.setEpgPercentage(M);
                                        liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i2)).getTitle());
                                    } else {
                                        i2++;
                                    }
                                }
                            }
                        }
                        arrayList.add(liveStreamsDBModel);
                    }
                }
                if (NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this) == null) {
                    return "all_channels_with_cat";
                }
                NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).clear();
                NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).addAll(arrayList);
                return "all_channels_with_cat";
            } catch (Exception e) {
                e.printStackTrace();
                return "all_channels_with_cat";
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            try {
                return NSTIJKPlayerSkyTvActivity.E2(NSTIJKPlayerSkyTvActivity.this).equals("-1") ? SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("m3u") ? NSTIJKPlayerSkyTvActivity.this.D3() : NSTIJKPlayerSkyTvActivity.this.E3() : NSTIJKPlayerSkyTvActivity.E2(NSTIJKPlayerSkyTvActivity.this).equals("-6") ? NSTIJKPlayerSkyTvActivity.this.k3() : a();
            } catch (Exception unused) {
                return "error";
            }
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this) != null) {
                    NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                    nSTIJKPlayerSkyTvActivity.o4(NSTIJKPlayerSkyTvActivity.O1(nSTIJKPlayerSkyTvActivity));
                    if (!NSTIJKPlayerSkyTvActivity.w1(NSTIJKPlayerSkyTvActivity.this).booleanValue()) {
                        NSTIJKPlayerSkyTvActivity.x1(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
                        if (NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this) == null || NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).size() == 0) {
                            m7.a.Y = Boolean.FALSE;
                            NSTIJKPlayerSkyTvActivity.this.Z3();
                        } else if (NSTIJKPlayerSkyTvActivity.Q1(NSTIJKPlayerSkyTvActivity.this).equals("true") || NSTIJKPlayerSkyTvActivity.F1(NSTIJKPlayerSkyTvActivity.this).i()) {
                            if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("stalker_api")) {
                                try {
                                    m7.w.N0(NSTIJKPlayerSkyTvActivity.this.d);
                                    String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTIJKPlayerSkyTvActivity.this.d);
                                    String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(NSTIJKPlayerSkyTvActivity.this.d);
                                    if (NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this) != null && NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).size() > 0 && NSTIJKPlayerSkyTvActivity.R1(NSTIJKPlayerSkyTvActivity.this) < NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).size()) {
                                        NSTIJKPlayerSkyTvActivity.T1(NSTIJKPlayerSkyTvActivity.this).c(loggedInMacAddress, stalkerToken, ((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(NSTIJKPlayerSkyTvActivity.R1(NSTIJKPlayerSkyTvActivity.this))).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "playFirstTime", 0, "", "");
                                    }
                                } catch (Exception unused) {
                                }
                            } else {
                                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity2 = NSTIJKPlayerSkyTvActivity.this;
                                NSTIJKPlayerSkyTvActivity.U1(nSTIJKPlayerSkyTvActivity2, NSTIJKPlayerSkyTvActivity.O1(nSTIJKPlayerSkyTvActivity2));
                            }
                        } else if (NSTIJKPlayerSkyTvActivity.V1(NSTIJKPlayerSkyTvActivity.this) != null) {
                            NSTIJKPlayerSkyTvActivity.V1(NSTIJKPlayerSkyTvActivity.this).setVisibility(0);
                        }
                    }
                }
                NSTIJKPlayerSkyTvActivity.this.R3();
                NSTIJKPlayerSkyTvActivity.W1(NSTIJKPlayerSkyTvActivity.this);
                NSTIJKPlayerSkyTvActivity.X1(NSTIJKPlayerSkyTvActivity.this);
                NSTIJKPlayerSkyTvActivity.Y1(NSTIJKPlayerSkyTvActivity.this);
            } catch (Exception unused2) {
                NSTIJKPlayerSkyTvActivity.this.R3();
            }
        }

        public void onPreExecute() {
            LinearLayout linearLayout;
            super.onPreExecute();
            try {
                if (NSTIJKPlayerSkyTvActivity.I1(NSTIJKPlayerSkyTvActivity.this) == null || NSTIJKPlayerSkyTvActivity.I1(NSTIJKPlayerSkyTvActivity.this).getVisibility() != 0) {
                    NSTIJKPlayerSkyTvActivity.K1(NSTIJKPlayerSkyTvActivity.this, "");
                } else {
                    NSTIJKPlayerSkyTvActivity.K1(NSTIJKPlayerSkyTvActivity.this, "player");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            NSTIJKPlayerSkyTvActivity.L1(NSTIJKPlayerSkyTvActivity.this);
            if (NSTIJKPlayerSkyTvActivity.J1(NSTIJKPlayerSkyTvActivity.this).equals("player")) {
                if (NSTIJKPlayerSkyTvActivity.M1(NSTIJKPlayerSkyTvActivity.this) != null) {
                    NSTIJKPlayerSkyTvActivity.M1(NSTIJKPlayerSkyTvActivity.this).setVisibility(8);
                }
                linearLayout = NSTIJKPlayerSkyTvActivity.this.X0;
                if (linearLayout == null) {
                    return;
                }
            } else {
                if (NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this) != null) {
                    NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this).setVisibility(8);
                }
                linearLayout = NSTIJKPlayerSkyTvActivity.this.W0;
                if (linearLayout == null) {
                    return;
                }
            }
            linearLayout.setVisibility(8);
        }
    }

    public class J implements View.OnFocusChangeListener {
        public final View a;

        public J(View view) {
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

        /* JADX WARN: Removed duplicated region for block: B:110:0x0214  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00ef  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFocusChange(android.view.View r26, boolean r27) {
            /*
                Method dump skipped, instructions count: 2217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.J.onFocusChange(android.view.View, boolean):void");
        }
    }

    public class K extends AsyncTask {
        public String a;

        public K(String str) {
            this.a = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HashMap doInBackground(String... strArr) {
            try {
                return NSTIJKPlayerSkyTvActivity.d2(NSTIJKPlayerSkyTvActivity.this, this.a);
            } catch (Exception unused) {
                return new HashMap();
            }
        }

        /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
            LL1ili1iI1iI.IIiLliI1l1li1: Can't find top splitter block for handler:B:252:0x013a
            	at ILlL1lil1i1i.LLll11I1I1lL.llLliLLIll1lI(Unknown Source:36)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(Unknown Source:67)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(Unknown Source:9)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:40)
            */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(java.util.HashMap r12) {
            /*
                Method dump skipped, instructions count: 954
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.K.onPostExecute(java.util.HashMap):void");
        }

        public void onPreExecute() {
            super.onPreExecute();
            try {
                NSTIJKPlayerSkyTvActivity.c2(NSTIJKPlayerSkyTvActivity.this);
                LinearLayout linearLayout = NSTIJKPlayerSkyTvActivity.this.y1;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                LinearLayout linearLayout2 = NSTIJKPlayerSkyTvActivity.this.A1;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                LinearLayout linearLayout3 = NSTIJKPlayerSkyTvActivity.this.B1;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                LinearLayout linearLayout4 = NSTIJKPlayerSkyTvActivity.this.C1;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                LinearLayout linearLayout5 = NSTIJKPlayerSkyTvActivity.this.D1;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
                LinearLayout linearLayout6 = NSTIJKPlayerSkyTvActivity.this.E1;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public /* synthetic */ K(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, String str, k kVar) {
            this(str);
        }
    }

    public class L extends AsyncTask {
        public final String a;
        public final int b;
        public String c;
        public final String d;
        public final String e;
        public final String f;
        public final int g;

        public L(String str, int i, String str2, String str3, String str4, int i2, String str5) {
            this.a = str;
            this.b = i;
            this.c = str5;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = i2;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                if (nSTIJKPlayerSkyTvActivity.d == null || NSTIJKPlayerSkyTvActivity.t2(nSTIJKPlayerSkyTvActivity) == null || NSTIJKPlayerSkyTvActivity.A2(NSTIJKPlayerSkyTvActivity.this) == null || NSTIJKPlayerSkyTvActivity.h2(NSTIJKPlayerSkyTvActivity.this) == null || NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this) == null) {
                    return null;
                }
                FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
                favouriteDBModel.setCategoryID(this.a);
                favouriteDBModel.setStreamID(this.b);
                favouriteDBModel.setStreamIDOneStream(this.c);
                favouriteDBModel.setNum(this.e);
                favouriteDBModel.setName(this.d);
                favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(NSTIJKPlayerSkyTvActivity.this.d));
                NSTIJKPlayerSkyTvActivity.A2(NSTIJKPlayerSkyTvActivity.this).addToFavourite(favouriteDBModel, this.f);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            try {
                View childAt = NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this).getChildAt(this.g - NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this).getFirstVisiblePosition());
                if (childAt != null) {
                    try {
                        childAt.findViewById(a7.f.g5).setVisibility(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                NSTIJKPlayerSkyTvActivity.h2(NSTIJKPlayerSkyTvActivity.this).x(1);
                NSTIJKPlayerSkyTvActivity.this.R3();
            } catch (Exception unused) {
                NSTIJKPlayerSkyTvActivity.this.R3();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                NSTIJKPlayerSkyTvActivity.g2(nSTIJKPlayerSkyTvActivity, NSTIJKPlayerSkyTvActivity.u3(nSTIJKPlayerSkyTvActivity.d));
                if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                    return;
                }
            } else if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).isShowing()) {
                return;
            }
            NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).show();
        }
    }

    public class M extends AsyncTask {
        public final String a;
        public final String b;
        public final String c;
        public final int d;

        public M(String str, String str2, String str3, int i) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                if (nSTIJKPlayerSkyTvActivity.d == null || NSTIJKPlayerSkyTvActivity.t2(nSTIJKPlayerSkyTvActivity) == null) {
                    return null;
                }
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity2 = NSTIJKPlayerSkyTvActivity.this;
                if (nSTIJKPlayerSkyTvActivity2.g0 == null || NSTIJKPlayerSkyTvActivity.h2(nSTIJKPlayerSkyTvActivity2) == null || NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this) == null) {
                    return null;
                }
                FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
                favouriteM3UModel.setUrl(this.b);
                favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(NSTIJKPlayerSkyTvActivity.this.d));
                favouriteM3UModel.setName(this.c);
                favouriteM3UModel.setCategoryID(this.a);
                NSTIJKPlayerSkyTvActivity.this.g0.addToFavourite(favouriteM3UModel);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            try {
                View childAt = NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this).getChildAt(this.d - NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this).getFirstVisiblePosition());
                if (childAt != null) {
                    try {
                        childAt.findViewById(a7.f.g5).setVisibility(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                NSTIJKPlayerSkyTvActivity.h2(NSTIJKPlayerSkyTvActivity.this).x(1);
                NSTIJKPlayerSkyTvActivity.this.R3();
            } catch (Exception unused) {
                NSTIJKPlayerSkyTvActivity.this.R3();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                NSTIJKPlayerSkyTvActivity.g2(nSTIJKPlayerSkyTvActivity, NSTIJKPlayerSkyTvActivity.u3(nSTIJKPlayerSkyTvActivity.d));
                if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                    return;
                }
            } else if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).isShowing()) {
                return;
            }
            NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).show();
        }
    }

    public class N extends AsyncTask {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final int e;

        public N(String str, int i, String str2, String str3, int i2) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = i2;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                if (nSTIJKPlayerSkyTvActivity.d == null || NSTIJKPlayerSkyTvActivity.t2(nSTIJKPlayerSkyTvActivity) == null || NSTIJKPlayerSkyTvActivity.A2(NSTIJKPlayerSkyTvActivity.this) == null || NSTIJKPlayerSkyTvActivity.h2(NSTIJKPlayerSkyTvActivity.this) == null || NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this) == null) {
                    return null;
                }
                NSTIJKPlayerSkyTvActivity.A2(NSTIJKPlayerSkyTvActivity.this).deleteFavourite(this.b, this.a, this.d, this.c, SharepreferenceDBHandler.getUserID(NSTIJKPlayerSkyTvActivity.this.d), NSTIJKPlayerSkyTvActivity.this.Q);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            try {
                View childAt = NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this).getChildAt(this.e - NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this).getFirstVisiblePosition());
                if (childAt != null) {
                    try {
                        childAt.findViewById(a7.f.g5).setVisibility(4);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                NSTIJKPlayerSkyTvActivity.h2(NSTIJKPlayerSkyTvActivity.this).x(1);
                NSTIJKPlayerSkyTvActivity.this.R3();
            } catch (Exception unused) {
                NSTIJKPlayerSkyTvActivity.this.R3();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                NSTIJKPlayerSkyTvActivity.g2(nSTIJKPlayerSkyTvActivity, NSTIJKPlayerSkyTvActivity.u3(nSTIJKPlayerSkyTvActivity.d));
                if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                    return;
                }
            } else if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).isShowing()) {
                return;
            }
            NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).show();
        }
    }

    public class O extends AsyncTask {
        public final String a;
        public final int b;

        public O(String str, int i) {
            this.a = str;
            this.b = i;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                if (nSTIJKPlayerSkyTvActivity.d == null || NSTIJKPlayerSkyTvActivity.t2(nSTIJKPlayerSkyTvActivity) == null) {
                    return null;
                }
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity2 = NSTIJKPlayerSkyTvActivity.this;
                if (nSTIJKPlayerSkyTvActivity2.g0 == null || NSTIJKPlayerSkyTvActivity.h2(nSTIJKPlayerSkyTvActivity2) == null || NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this) == null) {
                    return null;
                }
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity3 = NSTIJKPlayerSkyTvActivity.this;
                nSTIJKPlayerSkyTvActivity3.g0.deleteFavourite(this.a, SharepreferenceDBHandler.getUserID(nSTIJKPlayerSkyTvActivity3.d));
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            try {
                View childAt = NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this).getChildAt(this.b - NSTIJKPlayerSkyTvActivity.N1(NSTIJKPlayerSkyTvActivity.this).getFirstVisiblePosition());
                if (childAt != null) {
                    try {
                        childAt.findViewById(a7.f.g5).setVisibility(4);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                NSTIJKPlayerSkyTvActivity.h2(NSTIJKPlayerSkyTvActivity.this).x(1);
                NSTIJKPlayerSkyTvActivity.this.R3();
            } catch (Exception unused) {
                NSTIJKPlayerSkyTvActivity.this.R3();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                NSTIJKPlayerSkyTvActivity.g2(nSTIJKPlayerSkyTvActivity, NSTIJKPlayerSkyTvActivity.u3(nSTIJKPlayerSkyTvActivity.d));
                if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                    return;
                }
            } else if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).isShowing()) {
                return;
            }
            NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).show();
        }
    }

    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            try {
                if (NSTIJKPlayerSkyTvActivity.o2(NSTIJKPlayerSkyTvActivity.this) != null && NSTIJKPlayerSkyTvActivity.o2(NSTIJKPlayerSkyTvActivity.this).getStatus().equals(AsyncTask.Status.RUNNING)) {
                    NSTIJKPlayerSkyTvActivity.o2(NSTIJKPlayerSkyTvActivity.this).cancel(true);
                }
                ArrayList g = NSTIJKPlayerSkyTvActivity.t2(NSTIJKPlayerSkyTvActivity.this).g();
                if (g != null && g.size() > 0) {
                    String epgChannelId = ((LiveStreamsDBModel) g.get(i)).getEpgChannelId();
                    NSTIJKPlayerSkyTvActivity.this.R1.removeCallbacksAndMessages((Object) null);
                    if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("stalker_api")) {
                        NSTIJKPlayerSkyTvActivity.this.C4(((LiveStreamsDBModel) g.get(i)).getStreamId());
                        return;
                    } else {
                        NSTIJKPlayerSkyTvActivity.p2(NSTIJKPlayerSkyTvActivity.this, new K(NSTIJKPlayerSkyTvActivity.this, epgChannelId, null).execute(new String[0]));
                        return;
                    }
                }
                if (NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this) == null || NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).size() <= 0) {
                    return;
                }
                String epgChannelId2 = ((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(NSTIJKPlayerSkyTvActivity.this).get(i)).getEpgChannelId();
                NSTIJKPlayerSkyTvActivity.this.R1.removeCallbacksAndMessages((Object) null);
                if (!SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("stalker_api")) {
                    NSTIJKPlayerSkyTvActivity.p2(NSTIJKPlayerSkyTvActivity.this, new K(NSTIJKPlayerSkyTvActivity.this, epgChannelId2, null).execute(new String[0]));
                } else {
                    NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                    nSTIJKPlayerSkyTvActivity.C4(((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.O1(nSTIJKPlayerSkyTvActivity).get(i)).getStreamId());
                }
            } catch (Exception unused) {
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public final /* synthetic */ ArrayList a;

        public b(ArrayList arrayList) {
            this.a = arrayList;
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x0696 A[Catch: Exception -> 0x11b8, TryCatch #2 {Exception -> 0x11b8, blocks: (B:5:0x0017, B:7:0x001f, B:9:0x0031, B:10:0x003b, B:13:0x005f, B:15:0x0065, B:18:0x00a0, B:20:0x00b4, B:22:0x00ef, B:23:0x0103, B:25:0x0155, B:27:0x015f, B:29:0x0169, B:31:0x018f, B:32:0x0199, B:40:0x021c, B:42:0x0257, B:43:0x027d, B:45:0x029f, B:47:0x02ad, B:48:0x02c5, B:49:0x02e0, B:50:0x02cd, B:51:0x02fa, B:53:0x0302, B:54:0x0322, B:56:0x032a, B:57:0x033c, B:58:0x033e, B:61:0x0267, B:64:0x0205, B:65:0x0347, B:67:0x034e, B:69:0x035a, B:71:0x036e, B:73:0x03a9, B:74:0x03bd, B:76:0x040f, B:78:0x0419, B:80:0x0423, B:82:0x0449, B:83:0x0453, B:91:0x04df, B:162:0x05fa, B:93:0x062d, B:95:0x0635, B:97:0x0641, B:98:0x0653, B:99:0x066e, B:100:0x0657, B:101:0x068e, B:103:0x0696, B:104:0x06a8, B:172:0x04c8, B:173:0x06ac, B:175:0x06c2, B:177:0x06fd, B:178:0x0711, B:180:0x076b, B:182:0x0775, B:184:0x077f, B:186:0x07a5, B:187:0x07af, B:195:0x083b, B:197:0x08a0, B:198:0x08fb, B:200:0x0903, B:202:0x090f, B:203:0x091f, B:204:0x0938, B:205:0x0923, B:206:0x0958, B:208:0x0960, B:209:0x0972, B:212:0x0824, B:213:0x0976, B:215:0x097e, B:217:0x098a, B:219:0x09db, B:221:0x09f3, B:223:0x0a36, B:224:0x0a4a, B:226:0x0aac, B:228:0x0ab6, B:230:0x0ac0, B:232:0x0aee, B:233:0x0af8, B:235:0x0b36, B:236:0x0b6f, B:238:0x0baa, B:239:0x0bd0, B:241:0x0be0, B:242:0x0c06, B:244:0x0c0e, B:245:0x0c20, B:246:0x0bba, B:247:0x0c24, B:249:0x0c30, B:251:0x0c48, B:253:0x0caf, B:254:0x0cc3, B:256:0x0d25, B:258:0x0d2f, B:260:0x0d39, B:262:0x0d67, B:263:0x0d71, B:265:0x0daf, B:266:0x0e16, B:268:0x0e69, B:270:0x0e75, B:271:0x0e8d, B:272:0x0eae, B:273:0x0e91, B:274:0x0ed4, B:276:0x0edc, B:277:0x0eee, B:278:0x0ef2, B:280:0x0f0c, B:282:0x0f4f, B:283:0x0f63, B:285:0x0fcf, B:287:0x0fd9, B:289:0x0fe3, B:291:0x1011, B:292:0x101b, B:294:0x1059, B:295:0x10c0, B:297:0x10fb, B:298:0x1121, B:300:0x1131, B:302:0x113d, B:303:0x1153, B:304:0x1172, B:305:0x115b, B:306:0x1198, B:308:0x11a0, B:309:0x11b4, B:310:0x110b, B:85:0x0482, B:87:0x0488, B:89:0x048e, B:171:0x04b0, B:34:0x01bf, B:36:0x01c5, B:38:0x01cb, B:63:0x01ed, B:189:0x07de, B:191:0x07e4, B:193:0x07ea, B:211:0x080c), top: B:4:0x0017, inners: #1, #4, #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0635 A[Catch: Exception -> 0x11b8, TryCatch #2 {Exception -> 0x11b8, blocks: (B:5:0x0017, B:7:0x001f, B:9:0x0031, B:10:0x003b, B:13:0x005f, B:15:0x0065, B:18:0x00a0, B:20:0x00b4, B:22:0x00ef, B:23:0x0103, B:25:0x0155, B:27:0x015f, B:29:0x0169, B:31:0x018f, B:32:0x0199, B:40:0x021c, B:42:0x0257, B:43:0x027d, B:45:0x029f, B:47:0x02ad, B:48:0x02c5, B:49:0x02e0, B:50:0x02cd, B:51:0x02fa, B:53:0x0302, B:54:0x0322, B:56:0x032a, B:57:0x033c, B:58:0x033e, B:61:0x0267, B:64:0x0205, B:65:0x0347, B:67:0x034e, B:69:0x035a, B:71:0x036e, B:73:0x03a9, B:74:0x03bd, B:76:0x040f, B:78:0x0419, B:80:0x0423, B:82:0x0449, B:83:0x0453, B:91:0x04df, B:162:0x05fa, B:93:0x062d, B:95:0x0635, B:97:0x0641, B:98:0x0653, B:99:0x066e, B:100:0x0657, B:101:0x068e, B:103:0x0696, B:104:0x06a8, B:172:0x04c8, B:173:0x06ac, B:175:0x06c2, B:177:0x06fd, B:178:0x0711, B:180:0x076b, B:182:0x0775, B:184:0x077f, B:186:0x07a5, B:187:0x07af, B:195:0x083b, B:197:0x08a0, B:198:0x08fb, B:200:0x0903, B:202:0x090f, B:203:0x091f, B:204:0x0938, B:205:0x0923, B:206:0x0958, B:208:0x0960, B:209:0x0972, B:212:0x0824, B:213:0x0976, B:215:0x097e, B:217:0x098a, B:219:0x09db, B:221:0x09f3, B:223:0x0a36, B:224:0x0a4a, B:226:0x0aac, B:228:0x0ab6, B:230:0x0ac0, B:232:0x0aee, B:233:0x0af8, B:235:0x0b36, B:236:0x0b6f, B:238:0x0baa, B:239:0x0bd0, B:241:0x0be0, B:242:0x0c06, B:244:0x0c0e, B:245:0x0c20, B:246:0x0bba, B:247:0x0c24, B:249:0x0c30, B:251:0x0c48, B:253:0x0caf, B:254:0x0cc3, B:256:0x0d25, B:258:0x0d2f, B:260:0x0d39, B:262:0x0d67, B:263:0x0d71, B:265:0x0daf, B:266:0x0e16, B:268:0x0e69, B:270:0x0e75, B:271:0x0e8d, B:272:0x0eae, B:273:0x0e91, B:274:0x0ed4, B:276:0x0edc, B:277:0x0eee, B:278:0x0ef2, B:280:0x0f0c, B:282:0x0f4f, B:283:0x0f63, B:285:0x0fcf, B:287:0x0fd9, B:289:0x0fe3, B:291:0x1011, B:292:0x101b, B:294:0x1059, B:295:0x10c0, B:297:0x10fb, B:298:0x1121, B:300:0x1131, B:302:0x113d, B:303:0x1153, B:304:0x1172, B:305:0x115b, B:306:0x1198, B:308:0x11a0, B:309:0x11b4, B:310:0x110b, B:85:0x0482, B:87:0x0488, B:89:0x048e, B:171:0x04b0, B:34:0x01bf, B:36:0x01c5, B:38:0x01cb, B:63:0x01ed, B:189:0x07de, B:191:0x07e4, B:193:0x07ea, B:211:0x080c), top: B:4:0x0017, inners: #1, #4, #5 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onItemClick(android.widget.AdapterView r18, android.view.View r19, int r20, long r21) {
            /*
                Method dump skipped, instructions count: 4537
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.b.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
        }
    }

    public class c implements AdapterView.OnItemLongClickListener {

        public class a implements PopupMenu.OnMenuItemClickListener {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ int c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;
            public final /* synthetic */ ArrayList f;
            public final /* synthetic */ String g;

            public class a extends Dialog implements View.OnClickListener {
                public Activity a;
                public TextView c;
                public TextView d;
                public TextView e;
                public LinearLayout f;
                public LinearLayout g;

                public class a implements View.OnFocusChangeListener {
                    public View a;

                    public a(View view) {
                        this.a = view;
                    }

                    public void onFocusChange(View view, boolean z) {
                        LinearLayout b;
                        int i;
                        if (z) {
                            View view2 = this.a;
                            if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                                View view3 = this.a;
                                if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                                    return;
                                } else {
                                    b = a.b(a.this);
                                }
                            } else {
                                b = a.a(a.this);
                            }
                            i = a7.e.p;
                        } else {
                            View view4 = this.a;
                            if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                                View view5 = this.a;
                                if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                                    return;
                                } else {
                                    b = a.b(a.this);
                                }
                            } else {
                                b = a.a(a.this);
                            }
                            i = a7.e.o;
                        }
                        b.setBackgroundResource(i);
                    }
                }

                public a(Activity activity) {
                    super(activity);
                    this.a = activity;
                }

                public static /* synthetic */ LinearLayout a(a aVar) {
                    return aVar.f;
                }

                public static /* synthetic */ LinearLayout b(a aVar) {
                    return aVar.g;
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x006d A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:10:0x0008, B:12:0x0014, B:14:0x002f, B:15:0x0039, B:16:0x005b, B:18:0x006d, B:19:0x007b, B:20:0x00ad, B:22:0x007f, B:24:0x0093, B:25:0x009e, B:26:0x0040, B:28:0x0050), top: B:9:0x0008 }] */
                /* JADX WARN: Removed duplicated region for block: B:22:0x007f A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:10:0x0008, B:12:0x0014, B:14:0x002f, B:15:0x0039, B:16:0x005b, B:18:0x006d, B:19:0x007b, B:20:0x00ad, B:22:0x007f, B:24:0x0093, B:25:0x009e, B:26:0x0040, B:28:0x0050), top: B:9:0x0008 }] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onClick(android.view.View r2) {
                    /*
                        r1 = this;
                        int r2 = r2.getId()
                        int r0 = a7.f.u1
                        if (r2 != r0) goto Ld3
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.f2(r2)     // Catch: java.lang.Exception -> L3d
                        if (r2 != 0) goto L40
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.content.Context r0 = r2.d     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r0 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.u3(r0)     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.g2(r2, r0)     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.f2(r2)     // Catch: java.lang.Exception -> L3d
                        if (r2 == 0) goto L5b
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.f2(r2)     // Catch: java.lang.Exception -> L3d
                    L39:
                        r2.show()     // Catch: java.lang.Exception -> L3d
                        goto L5b
                    L3d:
                        r2 = move-exception
                        goto Lcf
                    L40:
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.f2(r2)     // Catch: java.lang.Exception -> L3d
                        boolean r2 = r2.isShowing()     // Catch: java.lang.Exception -> L3d
                        if (r2 != 0) goto L5b
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.f2(r2)     // Catch: java.lang.Exception -> L3d
                        goto L39
                    L5b:
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.q2(r2)     // Catch: java.lang.Exception -> L3d
                        java.lang.String r0 = "m3u"
                        boolean r2 = r2.equals(r0)     // Catch: java.lang.Exception -> L3d
                        if (r2 == 0) goto L7f
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler r0 = r2.g0     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = r2.R     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L3d
                    L7b:
                        r0.deleteLiveRecentlyWatched(r2)     // Catch: java.lang.Exception -> L3d
                        goto Lad
                    L7f:
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.content.Context r2 = r2.d     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r2)     // Catch: java.lang.Exception -> L3d
                        java.lang.String r0 = "onestream_api"
                        boolean r2 = r2.equals(r0)     // Catch: java.lang.Exception -> L3d
                        if (r2 == 0) goto L9e
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler r0 = r2.g0     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = r2.Q     // Catch: java.lang.Exception -> L3d
                        goto L7b
                    L9e:
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler r0 = r2.g0     // Catch: java.lang.Exception -> L3d
                        int r2 = r2.P     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L3d
                        goto L7b
                    Lad:
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        java.lang.String r0 = "-6"
                        r2.V3(r0)     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        q7.N r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.h2(r2)     // Catch: java.lang.Exception -> L3d
                        r2.w()     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        r2.R3()     // Catch: java.lang.Exception -> L3d
                        goto Lda
                    Lcf:
                        r2.printStackTrace()
                        goto Lda
                    Ld3:
                        int r0 = a7.f.h1
                        if (r2 != r0) goto Lda
                        r1.dismiss()
                    Lda:
                        r1.dismiss()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.a.onClick(android.view.View):void");
                }

                public void onCreate(Bundle bundle) {
                    try {
                        super.onCreate(bundle);
                        setContentView(NSTIJKPlayerSkyTvActivity.F1(NSTIJKPlayerSkyTvActivity.this).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
                        this.c = findViewById(a7.f.u1);
                        this.d = findViewById(a7.f.h1);
                        this.f = findViewById(a7.f.V8);
                        this.g = findViewById(a7.f.Ia);
                        TextView findViewById = findViewById(a7.f.um);
                        this.e = findViewById;
                        findViewById.setText(NSTIJKPlayerSkyTvActivity.this.d.getResources().getString(a7.j.Y8));
                        this.c.setOnClickListener(this);
                        this.d.setOnClickListener(this);
                        TextView textView = this.c;
                        textView.setOnFocusChangeListener(new a(textView));
                        TextView textView2 = this.d;
                        textView2.setOnFocusChangeListener(new a(textView2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            public a(String str, String str2, int i, String str3, String str4, ArrayList arrayList, String str5) {
                this.a = str;
                this.b = str2;
                this.c = i;
                this.d = str3;
                this.e = str4;
                this.f = arrayList;
                this.g = str5;
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
            
                r4 = r11.h.a;
                r4.H2 = true;
                r4.i4();
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
            
                if (com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.q2(r11.h.a).equals("m3u") == false) goto L20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
            
                r4 = r11.h.a;
                r5 = r4.R;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
            
                r4.e0 = r5;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
            
                r4 = new android.content.Intent(r11.h.a.d, com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity.class);
                r4.putExtra("url", r11.h.a.e0);
                r4.putExtra("app_name", ((com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) r11.h.a.U2.get(r3)).getAppname());
                r4.putExtra("packagename", ((com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) r11.h.a.U2.get(r3)).getPackagename());
                r11.h.a.d.startActivity(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
            
                if (com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.q2(r11.h.a).equals("onestream_api") == false) goto L23;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
            
                r4 = r11.h.a;
                r5 = r4.R;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
            
                r4 = r11.h.a;
                r5 = m7.w.V(r4.d, r4.P, r4.r0, "live");
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onMenuItemClick(android.view.MenuItem r12) {
                /*
                    Method dump skipped, instructions count: 562
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.a.onMenuItemClick(android.view.MenuItem):boolean");
            }
        }

        public class b implements PopupMenu.OnDismissListener {
            public b() {
            }

            public void onDismiss(PopupMenu popupMenu) {
            }
        }

        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0270 A[Catch: Exception -> 0x007d, TRY_LEAVE, TryCatch #0 {Exception -> 0x007d, blocks: (B:3:0x0005, B:5:0x000d, B:8:0x001b, B:10:0x0021, B:11:0x0117, B:13:0x013d, B:14:0x0154, B:17:0x0166, B:19:0x0181, B:21:0x0187, B:22:0x0190, B:23:0x019d, B:24:0x01a6, B:25:0x0248, B:27:0x0270, B:41:0x02a9, B:42:0x02ac, B:46:0x0194, B:47:0x01af, B:49:0x01bd, B:51:0x01d2, B:53:0x01de, B:55:0x01ee, B:56:0x01f8, B:57:0x0201, B:58:0x020a, B:60:0x022a, B:62:0x0230, B:63:0x0239, B:64:0x023d, B:65:0x0149, B:66:0x0080, B:68:0x0088, B:70:0x0094, B:29:0x0278, B:31:0x027e, B:34:0x0285, B:36:0x028f), top: B:2:0x0005, inners: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onItemLongClick(android.widget.AdapterView r20, android.view.View r21, int r22, long r23) {
            /*
                Method dump skipped, instructions count: 765
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.c.onItemLongClick(android.widget.AdapterView, android.view.View, int, long):boolean");
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.M2(NSTIJKPlayerSkyTvActivity.this);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.i2(NSTIJKPlayerSkyTvActivity.this, "", false);
            NSTIJKPlayerSkyTvActivity.j2(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.i2(NSTIJKPlayerSkyTvActivity.this, "", false);
            NSTIJKPlayerSkyTvActivity.j2(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.i2(NSTIJKPlayerSkyTvActivity.this, "", false);
            NSTIJKPlayerSkyTvActivity.j2(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.i2(NSTIJKPlayerSkyTvActivity.this, "", false);
            NSTIJKPlayerSkyTvActivity.j2(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.i2(NSTIJKPlayerSkyTvActivity.this, "", false);
            NSTIJKPlayerSkyTvActivity.j2(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class j implements Runnable {
        public j() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.i2(NSTIJKPlayerSkyTvActivity.this, "", false);
            NSTIJKPlayerSkyTvActivity.j2(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        public void onClick(View view) {
            NSTIJKPlayerSkyTvActivity.this.A3();
        }
    }

    public class l extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public TextView e;
        public LinearLayout f;
        public LinearLayout g;

        public class a implements View.OnFocusChangeListener {
            public View a;

            public a(View view) {
                this.a = view;
            }

            public void onFocusChange(View view, boolean z) {
                LinearLayout b;
                int i;
                if (z) {
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = l.b(l.this);
                        }
                    } else {
                        b = l.a(l.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = l.b(l.this);
                        }
                    } else {
                        b = l.a(l.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public l(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(l lVar) {
            return lVar.f;
        }

        public static /* synthetic */ LinearLayout b(l lVar) {
            return lVar.g;
        }

        public void onClick(View view) {
            NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity;
            if (view.getId() == a7.f.u1) {
                try {
                    if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) == null) {
                        NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity2 = NSTIJKPlayerSkyTvActivity.this;
                        NSTIJKPlayerSkyTvActivity.g2(nSTIJKPlayerSkyTvActivity2, NSTIJKPlayerSkyTvActivity.u3(nSTIJKPlayerSkyTvActivity2.d));
                        if (NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this) != null) {
                            nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                            NSTIJKPlayerSkyTvActivity.f2(nSTIJKPlayerSkyTvActivity).show();
                        }
                        NSTIJKPlayerSkyTvActivity.this.g0.deleteALLLiveRecentlyWatched();
                        NSTIJKPlayerSkyTvActivity.this.V3("-6");
                        NSTIJKPlayerSkyTvActivity.h2(NSTIJKPlayerSkyTvActivity.this).w();
                        NSTIJKPlayerSkyTvActivity.this.R3();
                    } else {
                        if (!NSTIJKPlayerSkyTvActivity.f2(NSTIJKPlayerSkyTvActivity.this).isShowing()) {
                            nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                            NSTIJKPlayerSkyTvActivity.f2(nSTIJKPlayerSkyTvActivity).show();
                        }
                        NSTIJKPlayerSkyTvActivity.this.g0.deleteALLLiveRecentlyWatched();
                        NSTIJKPlayerSkyTvActivity.this.V3("-6");
                        NSTIJKPlayerSkyTvActivity.h2(NSTIJKPlayerSkyTvActivity.this).w();
                        NSTIJKPlayerSkyTvActivity.this.R3();
                    }
                } catch (Exception unused) {
                }
            } else if (view.getId() == a7.f.h1) {
                dismiss();
            }
            dismiss();
        }

        public void onCreate(Bundle bundle) {
            try {
                super.onCreate(bundle);
                setContentView(NSTIJKPlayerSkyTvActivity.F1(NSTIJKPlayerSkyTvActivity.this).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
                this.c = findViewById(a7.f.u1);
                this.d = findViewById(a7.f.h1);
                this.f = findViewById(a7.f.V8);
                this.g = findViewById(a7.f.Ia);
                TextView findViewById = findViewById(a7.f.um);
                this.e = findViewById;
                findViewById.setText(NSTIJKPlayerSkyTvActivity.this.getResources().getString(a7.j.V8));
                this.c.setOnClickListener(this);
                this.d.setOnClickListener(this);
                TextView textView = this.c;
                textView.setOnFocusChangeListener(new a(textView));
                TextView textView2 = this.d;
                textView2.setOnFocusChangeListener(new a(textView2));
            } catch (Exception unused) {
            }
        }
    }

    public class m implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NSTIJKPlayerSkyTvActivity.i2(NSTIJKPlayerSkyTvActivity.this, "", false);
                NSTIJKPlayerSkyTvActivity.j2(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                NSTIJKPlayerSkyTvActivity.this.c2.setText("");
                NSTIJKPlayerSkyTvActivity.this.b2.setVisibility(8);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                NSTIJKPlayerSkyTvActivity.this.c2.setText("");
                NSTIJKPlayerSkyTvActivity.this.b2.setVisibility(8);
            }
        }

        public m() {
        }

        /* JADX WARN: Removed duplicated region for block: B:121:0x03c6  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x03f6  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x040b  */
        /* JADX WARN: Removed duplicated region for block: B:135:0x03fb  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x03cd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1224
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.m.run():void");
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.i2(NSTIJKPlayerSkyTvActivity.this, "", false);
            NSTIJKPlayerSkyTvActivity.j2(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class o implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public o(int i, String str, String str2) {
            this.a = i;
            this.c = str;
            this.d = str2;
        }

        public void run() {
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("stalker_api")) {
                NSTIJKPlayerSkyTvActivity.Q2(NSTIJKPlayerSkyTvActivity.this, this.a, this.c, this.d);
                return;
            }
            m7.w.N0(NSTIJKPlayerSkyTvActivity.this.d);
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTIJKPlayerSkyTvActivity.this.d);
            try {
                NSTIJKPlayerSkyTvActivity.T1(NSTIJKPlayerSkyTvActivity.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(NSTIJKPlayerSkyTvActivity.this.d), stalkerToken, ((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.y1(NSTIJKPlayerSkyTvActivity.this).get(this.a)).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "zappingLeft", this.a, this.c, this.d);
            } catch (Exception unused) {
            }
        }
    }

    public class p implements Runnable {
        public p() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.i2(NSTIJKPlayerSkyTvActivity.this, "", false);
            NSTIJKPlayerSkyTvActivity.j2(NSTIJKPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class q implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public q(int i, String str, String str2) {
            this.a = i;
            this.c = str;
            this.d = str2;
        }

        public void run() {
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyTvActivity.this.d).equals("stalker_api")) {
                NSTIJKPlayerSkyTvActivity.R2(NSTIJKPlayerSkyTvActivity.this, this.a, this.c, this.d);
                return;
            }
            m7.w.N0(NSTIJKPlayerSkyTvActivity.this.d);
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTIJKPlayerSkyTvActivity.this.d);
            try {
                NSTIJKPlayerSkyTvActivity.T1(NSTIJKPlayerSkyTvActivity.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(NSTIJKPlayerSkyTvActivity.this.d), stalkerToken, ((LiveStreamsDBModel) NSTIJKPlayerSkyTvActivity.y1(NSTIJKPlayerSkyTvActivity.this).get(this.a)).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "zappingRight", this.a, this.c, this.d);
            } catch (Exception unused) {
            }
        }
    }

    public class r implements TextWatcher {
        public r() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity;
            boolean z;
            if (charSequence == null || charSequence.toString().length() <= 0) {
                nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                z = false;
            } else {
                nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                z = true;
            }
            NSTIJKPlayerSkyTvActivity.T2(nSTIJKPlayerSkyTvActivity, z);
        }

        /* JADX WARN: Removed duplicated region for block: B:2:0x000c A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:15:0x0002, B:4:0x0014, B:6:0x001c, B:2:0x000c), top: B:14:0x0002 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onTextChanged(java.lang.CharSequence r1, int r2, int r3, int r4) {
            /*
                r0 = this;
                if (r1 == 0) goto Lc
                java.lang.String r2 = r1.toString()     // Catch: java.lang.Exception -> L34
                int r2 = r2.length()     // Catch: java.lang.Exception -> L34
                if (r2 > 0) goto L14
            Lc:
                com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L34
                boolean r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.S2(r2)     // Catch: java.lang.Exception -> L34
                if (r2 == 0) goto L34
            L14:
                com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L34
                q7.N r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.h2(r2)     // Catch: java.lang.Exception -> L34
                if (r2 == 0) goto L34
                com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L34
                q7.N r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.h2(r2)     // Catch: java.lang.Exception -> L34
                android.widget.Filter r2 = r2.getFilter()     // Catch: java.lang.Exception -> L34
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L34
                r2.filter(r1)     // Catch: java.lang.Exception -> L34
                java.lang.String r1 = "honey"
                java.lang.String r2 = "onTextChanged: notify"
                android.util.Log.e(r1, r2)     // Catch: java.lang.Exception -> L34
            L34:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.r.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }
    }

    public class s implements Runnable {
        public s() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.this.N3();
        }
    }

    public class t implements Runnable {
        public t() {
        }

        public void run() {
            NSTIJKPlayerSkyTvActivity.M2(NSTIJKPlayerSkyTvActivity.this);
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public v() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            m7.w.n0(NSTIJKPlayerSkyTvActivity.this.d);
        }
    }

    public class w implements View.OnClickListener {
        public w() {
        }

        public void onClick(View view) {
        }
    }

    public class x extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public LinearLayout e;
        public LinearLayout f;
        public RadioGroup g;
        public final /* synthetic */ Activity h;

        public class a implements View.OnFocusChangeListener {
            public View a;

            public a(View view) {
                this.a = view;
            }

            public void onFocusChange(View view, boolean z) {
                LinearLayout b;
                int i;
                if (z) {
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = x.b(x.this);
                        }
                    } else {
                        b = x.a(x.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = x.b(x.this);
                        }
                    } else {
                        b = x.a(x.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(Activity activity, Activity activity2) {
            super(activity);
            this.h = activity2;
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(x xVar) {
            return xVar.e;
        }

        public static /* synthetic */ LinearLayout b(x xVar) {
            return xVar.f;
        }

        public void onClick(View view) {
            if (view.getId() == a7.f.u1) {
                try {
                    String charSequence = findViewById(this.g.getCheckedRadioButtonId()).getText().toString();
                    SharepreferenceDBHandler.setLiveSubCatSort(charSequence.equals(this.h.getResources().getString(a7.j.i7)) ? "1" : charSequence.equals(this.h.getResources().getString(a7.j.f7)) ? "2" : charSequence.equals(this.h.getResources().getString(a7.j.k7)) ? "3" : charSequence.equals(this.h.getResources().getString(a7.j.g7)) ? "4" : charSequence.equals(this.h.getResources().getString(a7.j.h7)) ? "5" : "0", this.h);
                    NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                    nSTIJKPlayerSkyTvActivity.V3(NSTIJKPlayerSkyTvActivity.E2(nSTIJKPlayerSkyTvActivity));
                    dismiss();
                } catch (Exception unused) {
                }
            } else if (view.getId() == a7.f.h1) {
                dismiss();
            }
            dismiss();
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x00ce  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onCreate(android.os.Bundle r13) {
            /*
                Method dump skipped, instructions count: 290
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.x.onCreate(android.os.Bundle):void");
        }
    }

    public class y implements SearchView.m {
        public y() {
        }

        public boolean onQueryTextChange(String str) {
            if (NSTIJKPlayerSkyTvActivity.t2(NSTIJKPlayerSkyTvActivity.this) == null) {
                return false;
            }
            NSTIJKPlayerSkyTvActivity.t2(NSTIJKPlayerSkyTvActivity.this).getFilter().filter(str);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class z implements Callback {
        public z() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("onFailure", th.getMessage().toString());
        }

        public void onResponse(Call call, Response response) {
            Toast makeText;
            NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity;
            String message;
            if (response == null) {
                makeText = Toast.makeText(NSTIJKPlayerSkyTvActivity.this, "Something went Wrong Report not Submited", 0);
            } else {
                if (response.body() == null || !response.isSuccessful()) {
                    if (response.message() != null && !response.message().equals("")) {
                        nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                        message = response.message();
                    }
                    makeText = Toast.makeText(NSTIJKPlayerSkyTvActivity.this, "Something went Wrong Report not Submited", 0);
                } else if (((ClientFeedbackCallback) response.body()).a() == null || !((ClientFeedbackCallback) response.body()).a().equalsIgnoreCase("success")) {
                    nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                    message = "Something went Wrong";
                } else {
                    nSTIJKPlayerSkyTvActivity = NSTIJKPlayerSkyTvActivity.this;
                    message = "Reported Successfully";
                }
                makeText = Toast.makeText(nSTIJKPlayerSkyTvActivity, message, 0);
            }
            makeText.show();
        }
    }

    public NSTIJKPlayerSkyTvActivity() {
        Boolean bool = Boolean.FALSE;
        this.e2 = bool;
        this.f2 = bool;
        this.j2 = "";
        this.p2 = "";
        this.q2 = bool;
        this.s2 = "";
        Boolean bool2 = Boolean.TRUE;
        this.t2 = bool2;
        this.u2 = null;
        this.w2 = -1;
        this.x2 = 0;
        this.y2 = "";
        this.z2 = "";
        this.A2 = bool2;
        this.B2 = null;
        this.C2 = null;
        this.D2 = null;
        this.F2 = false;
        this.G2 = 0;
        this.H2 = false;
        this.I2 = 4;
        this.J2 = J5[0];
        this.L2 = bool;
        this.M2 = bool;
        this.N2 = bool;
        this.O2 = bool;
        this.P2 = bool;
        this.Q2 = bool;
        this.V2 = 0;
        this.W2 = "0";
        this.X2 = "0";
        this.Y2 = bool2;
        this.e4 = "mobile";
        this.l4 = 0;
        this.o4 = "";
        this.p4 = "false";
        this.q4 = "false";
        this.r4 = "";
        this.s4 = "-10";
        this.t4 = 0;
        this.i5 = "Live";
        this.j5 = "";
        this.m5 = "";
        this.n5 = "";
        this.o5 = "";
        this.q5 = "";
        this.u5 = null;
        this.v5 = false;
        this.w5 = true;
        this.y5 = null;
        this.z5 = bool;
        this.A5 = false;
        this.B5 = 0;
        this.C5 = new ArrayList();
        this.D5 = false;
    }

    public static /* synthetic */ int A1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2) {
        nSTIJKPlayerSkyTvActivity.G2 = i2;
        return i2;
    }

    public static /* synthetic */ DatabaseHandler A2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.J1;
    }

    private void A4() {
        z4();
        if (this.q3.getVisibility() == 0) {
            M3();
        } else {
            t4();
            l3(5000);
        }
    }

    public static /* synthetic */ ArrayList B1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.C0;
    }

    public static /* synthetic */ void B2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, String str, String str2, String str3, int i2) {
        nSTIJKPlayerSkyTvActivity.c3(str, str2, str3, i2);
    }

    public static String B3(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    public static /* synthetic */ ArrayList C1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, ArrayList arrayList) {
        nSTIJKPlayerSkyTvActivity.C0 = arrayList;
        return arrayList;
    }

    public static /* synthetic */ int C2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2) {
        nSTIJKPlayerSkyTvActivity.p = i2;
        return i2;
    }

    public static /* synthetic */ ArrayList D1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.A0;
    }

    public static /* synthetic */ int D2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2) {
        nSTIJKPlayerSkyTvActivity.q = i2;
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x018a A[Catch: Exception -> 0x01a9, TryCatch #2 {Exception -> 0x01a9, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000c, B:10:0x0018, B:11:0x001e, B:12:0x013f, B:14:0x018a, B:17:0x019a, B:19:0x0025, B:21:0x0031, B:22:0x0039, B:23:0x0040, B:83:0x0109, B:86:0x00ff, B:25:0x0111), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x019a A[Catch: Exception -> 0x01a9, TRY_LEAVE, TryCatch #2 {Exception -> 0x01a9, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000c, B:10:0x0018, B:11:0x001e, B:12:0x013f, B:14:0x018a, B:17:0x019a, B:19:0x0025, B:21:0x0031, B:22:0x0039, B:23:0x0040, B:83:0x0109, B:86:0x00ff, B:25:0x0111), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void D4(int r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.D4(int, java.lang.String, java.lang.String):void");
    }

    public static /* synthetic */ String E1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.q4;
    }

    public static /* synthetic */ String E2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.X2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x017f A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000c, B:10:0x001c, B:11:0x0022, B:12:0x0134, B:14:0x017f, B:17:0x018f, B:19:0x0029, B:21:0x0035, B:22:0x003d, B:23:0x0044, B:83:0x00fe, B:25:0x0106), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x018f A[Catch: Exception -> 0x019e, TRY_LEAVE, TryCatch #0 {Exception -> 0x019e, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000c, B:10:0x001c, B:11:0x0022, B:12:0x0134, B:14:0x017f, B:17:0x018f, B:19:0x0029, B:21:0x0035, B:22:0x003d, B:23:0x0044, B:83:0x00fe, B:25:0x0106), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void E4(int r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.E4(int, java.lang.String, java.lang.String):void");
    }

    public static /* synthetic */ u7.a F1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.R2;
    }

    public static /* synthetic */ void F2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2, String str) {
        nSTIJKPlayerSkyTvActivity.a3(i2, str);
    }

    public static /* synthetic */ SharedPreferences G1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.l0;
    }

    public static /* synthetic */ void G2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, String str, int i2, String str2, String str3, String str4, int i3, String str5) {
        nSTIJKPlayerSkyTvActivity.b3(str, i2, str2, str3, str4, i3, str5);
    }

    public static /* synthetic */ AsyncTask H1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.B2;
    }

    public static /* synthetic */ void H2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, String str, String str2, int i2) {
        nSTIJKPlayerSkyTvActivity.l4(str, str2, i2);
    }

    private ArrayList H3() {
        ArrayList allPasswordStatus = this.g0.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.d));
        this.L0 = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.J0.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.J0;
    }

    public static /* synthetic */ RelativeLayout I1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.K3;
    }

    public static /* synthetic */ void I2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2, String str) {
        nSTIJKPlayerSkyTvActivity.j4(i2, str);
    }

    private boolean I3(ArrayList arrayList, ArrayList arrayList2) {
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    if (liveStreamsDBModel.getCategoryId().equals((String) it2.next())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ String J1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.o4;
    }

    public static /* synthetic */ void J2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, String str, int i2, String str2, String str3, int i3, String str4) {
        nSTIJKPlayerSkyTvActivity.k4(str, i2, str2, str3, i3, str4);
    }

    private ArrayList J3(ArrayList arrayList, ArrayList arrayList2) {
        this.O0 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    this.O0.add(favouriteDBModel);
                    break;
                }
                String str = (String) it2.next();
                if (favouriteDBModel.getCategoryID() == null || !favouriteDBModel.getCategoryID().equals(str)) {
                }
            }
        }
        return this.O0;
    }

    public static /* synthetic */ String K1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, String str) {
        nSTIJKPlayerSkyTvActivity.o4 = str;
        return str;
    }

    public static /* synthetic */ SharedPreferences K2() {
        return F5;
    }

    private ArrayList K3(ArrayList arrayList, ArrayList arrayList2) {
        this.P0 = new ArrayList();
        if (arrayList == null) {
            return null;
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                if (arrayList2 != null) {
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            this.P0.add(favouriteM3UModel);
                            break;
                        }
                        if (favouriteM3UModel.getCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    }
                }
            }
            return this.P0;
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ void L1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        nSTIJKPlayerSkyTvActivity.v4();
    }

    public static /* synthetic */ SharedPreferences L2(SharedPreferences sharedPreferences) {
        F5 = sharedPreferences;
        return sharedPreferences;
    }

    private void L3() {
        ProgressBar progressBar = this.I;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(this.d.getResources().getString(a7.j.N4));
        }
        TextView textView2 = this.E;
        if (textView2 != null) {
            textView2.setText("");
        }
        TextView textView3 = this.F;
        if (textView3 != null) {
            textView3.setText(this.d.getResources().getString(a7.j.c4));
        }
        TextView textView4 = this.G;
        if (textView4 != null) {
            textView4.setText("");
        }
    }

    public static /* synthetic */ ListView M1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.W;
    }

    public static /* synthetic */ void M2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        nSTIJKPlayerSkyTvActivity.M3();
    }

    private void M3() {
        if (this.q3.getVisibility() == 0) {
            this.q3.startAnimation(this.b4);
            this.C3.startAnimation(this.b4);
            this.A3.startAnimation(this.b4);
            if (m7.a.V0.booleanValue()) {
                this.Y4.startAnimation(this.b4);
            }
            this.B3.startAnimation(this.b4);
            if (this.n3.getVisibility() == 0) {
                this.n3.startAnimation(this.b4);
            }
            if (this.p3.getVisibility() == 0) {
                this.p3.startAnimation(this.b4);
            }
            if (this.o3.getVisibility() == 0) {
                this.o3.startAnimation(this.b4);
            }
            this.q3.setVisibility(8);
            if (this.n3.getVisibility() == 0) {
                this.n3.setVisibility(8);
            }
            if (this.p3.getVisibility() == 0) {
                this.p3.setVisibility(8);
            }
            if (this.o3.getVisibility() == 0) {
                this.o3.setVisibility(8);
            }
            this.C3.setVisibility(8);
            this.A3.setVisibility(8);
            this.Y4.setVisibility(8);
            this.B3.setVisibility(8);
        }
    }

    public static /* synthetic */ ListView N1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.V;
    }

    public static /* synthetic */ boolean N2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, ArrayList arrayList, ArrayList arrayList2) {
        return nSTIJKPlayerSkyTvActivity.I3(arrayList, arrayList2);
    }

    public static /* synthetic */ ArrayList O1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.E0;
    }

    public static /* synthetic */ int O2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2) {
        nSTIJKPlayerSkyTvActivity.t0 = i2;
        return i2;
    }

    private void O3() {
        LinearLayout linearLayout = this.J;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.K;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    public static /* synthetic */ ArrayList P1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, ArrayList arrayList) {
        nSTIJKPlayerSkyTvActivity.E0 = arrayList;
        return arrayList;
    }

    public static /* synthetic */ void P2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2) {
        nSTIJKPlayerSkyTvActivity.l3(i2);
    }

    public static /* synthetic */ String Q1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.p4;
    }

    public static /* synthetic */ void Q2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2, String str, String str2) {
        nSTIJKPlayerSkyTvActivity.D4(i2, str, str2);
    }

    public static /* synthetic */ int R1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.Z1;
    }

    public static /* synthetic */ void R2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2, String str, String str2) {
        nSTIJKPlayerSkyTvActivity.E4(i2, str, str2);
    }

    public static /* synthetic */ int S1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2) {
        nSTIJKPlayerSkyTvActivity.Z1 = i2;
        return i2;
    }

    public static /* synthetic */ boolean S2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.A5;
    }

    public static /* synthetic */ n7.g T1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.g;
    }

    public static /* synthetic */ boolean T2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, boolean z2) {
        nSTIJKPlayerSkyTvActivity.A5 = z2;
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x01aa A[PHI: r4
      0x01aa: PHI (r4v16 java.lang.String) = (r4v6 java.lang.String), (r4v7 java.lang.String), (r4v8 java.lang.String) binds: [B:7:0x01a8, B:134:0x01b9, B:136:0x01c8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void T3() {
        /*
            Method dump skipped, instructions count: 2228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.T3():void");
    }

    public static /* synthetic */ void U1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, ArrayList arrayList) {
        nSTIJKPlayerSkyTvActivity.g4(arrayList);
    }

    public static /* synthetic */ androidx.appcompat.app.a U2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.r2;
    }

    public static /* synthetic */ LinearLayout V1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.F3;
    }

    public static /* synthetic */ LinearLayout V2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.r3;
    }

    public static /* synthetic */ void W1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        nSTIJKPlayerSkyTvActivity.O3();
    }

    public static /* synthetic */ LinearLayout W2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.u3;
    }

    private void W3() {
        ProgressBar progressBar = this.I;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(this.d.getResources().getString(a7.j.M4));
        }
        TextView textView2 = this.E;
        if (textView2 != null) {
            textView2.setText("");
        }
        TextView textView3 = this.F;
        if (textView3 != null) {
            textView3.setText(this.d.getResources().getString(a7.j.b4));
        }
        TextView textView4 = this.G;
        if (textView4 != null) {
            textView4.setText("");
        }
    }

    public static /* synthetic */ void X1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        nSTIJKPlayerSkyTvActivity.t3();
    }

    public static /* synthetic */ TextView X2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.x4;
    }

    private void X3() {
        int currentWindowIndex = this.n2.getCurrentWindowIndex();
        if (currentWindowIndex == this.F0.size() - 1) {
            this.n2.setCurrentWindowIndex(0);
        } else {
            this.n2.setCurrentWindowIndex(currentWindowIndex + 1);
        }
    }

    public static /* synthetic */ void Y1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        nSTIJKPlayerSkyTvActivity.s3();
    }

    public static /* synthetic */ LinearLayout Y2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.u;
    }

    public static /* synthetic */ int Z1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.l4;
    }

    public static /* synthetic */ ArrayList Z2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.D0;
    }

    public static /* synthetic */ int a2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2) {
        nSTIJKPlayerSkyTvActivity.l4 = i2;
        return i2;
    }

    private void a3(int i2, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            List favIdsList = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
            this.l = favIdsList;
            if (favIdsList != null && favIdsList.size() > 0) {
                for (int i3 = 0; i3 < this.l.size(); i3++) {
                    sb.append(this.l.get(i3));
                    sb.append(",");
                }
            }
            sb.append(i2);
            this.p = i2;
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.d);
            this.m.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.d), stalkerToken, (t.o) null, sb.toString(), "added", str);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public static /* synthetic */ SharedPreferences b2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, SharedPreferences sharedPreferences) {
        nSTIJKPlayerSkyTvActivity.m0 = sharedPreferences;
        return sharedPreferences;
    }

    private void b3(String str, int i2, String str2, String str3, String str4, int i3, String str5) {
        new L(str, i2, str2, str3, str4, i3, str5).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public static /* synthetic */ void c2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        nSTIJKPlayerSkyTvActivity.W3();
    }

    private void c3(String str, String str2, String str3, int i2) {
        new M(str, str2, str3, i2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    private void c4() {
        this.O3.setOnClickListener(this);
        this.P3.setOnClickListener(this);
        this.s3.setOnClickListener(this);
        this.S3.setOnClickListener(this);
        this.G3.setOnClickListener(this);
        this.T3.setOnClickListener(this);
        this.w3.setOnClickListener(this);
        this.x3.setOnClickListener(this);
        this.y3.setOnClickListener(this);
        this.t3.setOnClickListener(this);
        this.v3.setOnClickListener(this);
        this.Q3.setOnClickListener(this);
        this.R3.setOnClickListener(this);
        this.H3.setOnClickListener(this);
        this.a5.setOnClickListener(this);
        this.b5.setOnClickListener(this);
        this.c5.setOnClickListener(this);
        this.d5.setOnClickListener(this);
        this.e5.setOnClickListener(this);
        this.f5.setOnClickListener(this);
        this.g5.setOnClickListener(this);
        this.y4.setOnClickListener(this);
        this.X4.setOnClickListener(this);
    }

    public static /* synthetic */ HashMap d2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, String str) {
        return nSTIJKPlayerSkyTvActivity.r4(str);
    }

    private void d3(Configuration configuration) {
        NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv;
        boolean z2;
        View decorView = getWindow().getDecorView();
        if (configuration.orientation == 2) {
            decorView.setSystemUiVisibility(5894);
            nSTIJKPlayerSkyTv = this.n2;
            z2 = false;
        } else {
            decorView.setSystemUiVisibility(256);
            nSTIJKPlayerSkyTv = this.n2;
            z2 = true;
        }
        nSTIJKPlayerSkyTv.setAdjustViewBounds(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0456 A[Catch: Exception -> 0x0bff, TryCatch #1 {Exception -> 0x0bff, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x0016, B:8:0x001c, B:11:0x003c, B:13:0x0042, B:16:0x0075, B:18:0x0087, B:20:0x00b0, B:21:0x00b8, B:23:0x0100, B:25:0x0108, B:27:0x0110, B:29:0x012a, B:31:0x0130, B:32:0x0138, B:40:0x018d, B:42:0x01cd, B:43:0x01ec, B:45:0x01f0, B:46:0x0206, B:48:0x020a, B:49:0x0212, B:54:0x017c, B:55:0x0219, B:57:0x021e, B:59:0x0226, B:61:0x0238, B:63:0x0261, B:64:0x0269, B:66:0x02b1, B:68:0x02b9, B:70:0x02c1, B:72:0x02df, B:73:0x02e7, B:81:0x0345, B:150:0x0433, B:83:0x0452, B:85:0x0456, B:87:0x045e, B:88:0x046a, B:89:0x047f, B:90:0x046e, B:91:0x0497, B:93:0x049b, B:161:0x0334, B:162:0x04a5, B:164:0x04b7, B:166:0x04e0, B:167:0x04e8, B:169:0x0538, B:171:0x0540, B:173:0x0548, B:175:0x0562, B:177:0x0568, B:178:0x0570, B:186:0x05c5, B:188:0x05ee, B:189:0x060e, B:191:0x0622, B:193:0x062e, B:194:0x063e, B:195:0x0679, B:196:0x0646, B:197:0x0683, B:199:0x0687, B:200:0x06b0, B:202:0x06b4, B:203:0x05fd, B:206:0x05b4, B:207:0x06be, B:209:0x06c2, B:211:0x06c8, B:213:0x0705, B:215:0x0719, B:217:0x0746, B:218:0x074e, B:220:0x079c, B:222:0x07a4, B:224:0x07ac, B:226:0x07ca, B:228:0x07d0, B:229:0x07d8, B:231:0x07e7, B:232:0x0808, B:234:0x083d, B:235:0x0855, B:237:0x0859, B:238:0x0863, B:240:0x086b, B:242:0x087f, B:244:0x08ac, B:245:0x08b4, B:247:0x0902, B:249:0x090a, B:251:0x0912, B:253:0x0934, B:254:0x093c, B:256:0x094b, B:257:0x0992, B:259:0x09c7, B:261:0x09cf, B:262:0x09dd, B:263:0x09f4, B:264:0x09e1, B:265:0x0a0e, B:267:0x0a12, B:268:0x0a1c, B:270:0x0a30, B:272:0x0a5d, B:273:0x0a65, B:275:0x0abb, B:277:0x0ac3, B:279:0x0acb, B:281:0x0ae9, B:283:0x0aef, B:284:0x0af7, B:286:0x0b06, B:288:0x0b14, B:289:0x0b26, B:290:0x0b65, B:291:0x0b72, B:293:0x0b99, B:294:0x0bbb, B:296:0x0bc4, B:297:0x0bf1, B:299:0x0bf5, B:300:0x0baa, B:301:0x0b2e, B:34:0x0142, B:36:0x0148, B:38:0x014e, B:53:0x016a, B:180:0x057a, B:182:0x0580, B:184:0x0586, B:205:0x05a2, B:75:0x02fa, B:77:0x0300, B:79:0x0306, B:160:0x0322), top: B:2:0x0006, inners: #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x049b A[Catch: Exception -> 0x0bff, TryCatch #1 {Exception -> 0x0bff, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x0016, B:8:0x001c, B:11:0x003c, B:13:0x0042, B:16:0x0075, B:18:0x0087, B:20:0x00b0, B:21:0x00b8, B:23:0x0100, B:25:0x0108, B:27:0x0110, B:29:0x012a, B:31:0x0130, B:32:0x0138, B:40:0x018d, B:42:0x01cd, B:43:0x01ec, B:45:0x01f0, B:46:0x0206, B:48:0x020a, B:49:0x0212, B:54:0x017c, B:55:0x0219, B:57:0x021e, B:59:0x0226, B:61:0x0238, B:63:0x0261, B:64:0x0269, B:66:0x02b1, B:68:0x02b9, B:70:0x02c1, B:72:0x02df, B:73:0x02e7, B:81:0x0345, B:150:0x0433, B:83:0x0452, B:85:0x0456, B:87:0x045e, B:88:0x046a, B:89:0x047f, B:90:0x046e, B:91:0x0497, B:93:0x049b, B:161:0x0334, B:162:0x04a5, B:164:0x04b7, B:166:0x04e0, B:167:0x04e8, B:169:0x0538, B:171:0x0540, B:173:0x0548, B:175:0x0562, B:177:0x0568, B:178:0x0570, B:186:0x05c5, B:188:0x05ee, B:189:0x060e, B:191:0x0622, B:193:0x062e, B:194:0x063e, B:195:0x0679, B:196:0x0646, B:197:0x0683, B:199:0x0687, B:200:0x06b0, B:202:0x06b4, B:203:0x05fd, B:206:0x05b4, B:207:0x06be, B:209:0x06c2, B:211:0x06c8, B:213:0x0705, B:215:0x0719, B:217:0x0746, B:218:0x074e, B:220:0x079c, B:222:0x07a4, B:224:0x07ac, B:226:0x07ca, B:228:0x07d0, B:229:0x07d8, B:231:0x07e7, B:232:0x0808, B:234:0x083d, B:235:0x0855, B:237:0x0859, B:238:0x0863, B:240:0x086b, B:242:0x087f, B:244:0x08ac, B:245:0x08b4, B:247:0x0902, B:249:0x090a, B:251:0x0912, B:253:0x0934, B:254:0x093c, B:256:0x094b, B:257:0x0992, B:259:0x09c7, B:261:0x09cf, B:262:0x09dd, B:263:0x09f4, B:264:0x09e1, B:265:0x0a0e, B:267:0x0a12, B:268:0x0a1c, B:270:0x0a30, B:272:0x0a5d, B:273:0x0a65, B:275:0x0abb, B:277:0x0ac3, B:279:0x0acb, B:281:0x0ae9, B:283:0x0aef, B:284:0x0af7, B:286:0x0b06, B:288:0x0b14, B:289:0x0b26, B:290:0x0b65, B:291:0x0b72, B:293:0x0b99, B:294:0x0bbb, B:296:0x0bc4, B:297:0x0bf1, B:299:0x0bf5, B:300:0x0baa, B:301:0x0b2e, B:34:0x0142, B:36:0x0148, B:38:0x014e, B:53:0x016a, B:180:0x057a, B:182:0x0580, B:184:0x0586, B:205:0x05a2, B:75:0x02fa, B:77:0x0300, B:79:0x0306, B:160:0x0322), top: B:2:0x0006, inners: #2, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d4(int r18, java.util.ArrayList r19) {
        /*
            Method dump skipped, instructions count: 3072
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.d4(int, java.util.ArrayList):void");
    }

    public static /* synthetic */ void e2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        nSTIJKPlayerSkyTvActivity.L3();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:373|374|(1:440)(9:380|(2:381|(2:383|(2:386|387)(1:385))(2:437|438))|388|389|(5:(3:393|(2:396|397)(1:395)|391)|433|434|398|399)(3:434|398|399)|51|(2:53|(2:54|(1:61)(2:56|(2:59|60)(1:58))))(0)|62|(2:71|(2:79|(2:87|88)(2:85|86))(2:77|78))(2:68|69))|400|401|(2:430|425)(3:405|(5:407|(2:408|(2:410|(2:412|413)(1:427))(2:428|429))|414|(1:(2:416|(1:423)(2:418|(2:420|421)(1:422))))(0)|424)(0)|425)|51|(0)(0)|62|(1:64)|71|(1:73)|79|(1:81)|87|88) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:132|133)|(1:201)(14:139|(2:140|(2:142|(2:145|146)(1:144))(2:199|200))|147|(4:(3:151|(2:154|155)(1:153)|149)|197|198|156)(2:198|156)|51|(0)(0)|62|(0)|71|(0)|79|(0)|87|88)|157|158|(1:194)(6:162|163|164|165|(14:167|(2:168|(2:170|(2:172|173)(1:188))(2:189|190))|174|(4:(3:178|(2:180|181)(1:185)|176)|186|187|182)(2:187|182)|51|(0)(0)|62|(0)|71|(0)|79|(0)|87|88)|183)|191|183) */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0bfc A[Catch: Exception -> 0x0bc2, TryCatch #15 {Exception -> 0x0bc2, blocks: (B:425:0x0ba0, B:361:0x0bc7, B:363:0x0bfc, B:365:0x0c04, B:366:0x0c14, B:367:0x0c2d, B:368:0x0c18, B:369:0x0c47, B:371:0x0c4b, B:372:0x0c53, B:443:0x0c5e, B:302:0x0caa, B:305:0x0d08, B:307:0x0d10, B:309:0x0d18, B:311:0x0d36, B:313:0x0d3c, B:316:0x0d85, B:318:0x0d93, B:319:0x0da9, B:320:0x0de8, B:323:0x0e1c, B:336:0x0dad), top: B:293:0x09ab }] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0c4b A[Catch: Exception -> 0x0bc2, TryCatch #15 {Exception -> 0x0bc2, blocks: (B:425:0x0ba0, B:361:0x0bc7, B:363:0x0bfc, B:365:0x0c04, B:366:0x0c14, B:367:0x0c2d, B:368:0x0c18, B:369:0x0c47, B:371:0x0c4b, B:372:0x0c53, B:443:0x0c5e, B:302:0x0caa, B:305:0x0d08, B:307:0x0d10, B:309:0x0d18, B:311:0x0d36, B:313:0x0d3c, B:316:0x0d85, B:318:0x0d93, B:319:0x0da9, B:320:0x0de8, B:323:0x0e1c, B:336:0x0dad), top: B:293:0x09ab }] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0b9e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0e9d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0ec4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0eda  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0ef0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e4(int r27, java.util.ArrayList r28) {
        /*
            Method dump skipped, instructions count: 3846
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.e4(int, java.util.ArrayList):void");
    }

    public static /* synthetic */ ProgressDialog f2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.E2;
    }

    private void f4() {
        EditText editText = this.N3;
        if (editText != null) {
            editText.addTextChangedListener(new r());
        }
    }

    public static /* synthetic */ ProgressDialog g2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, ProgressDialog progressDialog) {
        nSTIJKPlayerSkyTvActivity.E2 = progressDialog;
        return progressDialog;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x039a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g4(java.util.ArrayList r15) {
        /*
            Method dump skipped, instructions count: 942
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.g4(java.util.ArrayList):void");
    }

    public static /* synthetic */ q7.N h2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.f4;
    }

    private void h4() {
        int currentWindowIndex = this.n2.getCurrentWindowIndex();
        if (currentWindowIndex == 0) {
            this.n2.setCurrentWindowIndex(this.F0.size() - 1);
        } else {
            this.n2.setCurrentWindowIndex(currentWindowIndex - 1);
        }
    }

    public static /* synthetic */ void i2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, String str, boolean z2) {
        nSTIJKPlayerSkyTvActivity.p4(str, z2);
    }

    public static /* synthetic */ Boolean j2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, Boolean bool) {
        nSTIJKPlayerSkyTvActivity.z5 = bool;
        return bool;
    }

    private void j4(int i2, String str) {
        try {
            List favIdsList = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
            this.l = favIdsList;
            if (favIdsList == null) {
                m7.w.X();
                return;
            }
            favIdsList.remove(Integer.valueOf(i2));
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                sb.append(this.l.get(i3));
                sb.append(",");
            }
            this.l.add(Integer.valueOf(i2));
            String substring = sb.toString().contains(",") ? sb.substring(0, sb.lastIndexOf(",")) : sb.toString();
            this.p = i2;
            this.m.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.d), SharepreferenceDBHandler.getStalkerToken(this.d), (t.o) null, substring, "removed", str);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public static /* synthetic */ int k2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.k;
    }

    public static /* synthetic */ int l2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2) {
        nSTIJKPlayerSkyTvActivity.k = i2;
        return i2;
    }

    private void l3(int i2) {
        this.n2.a1 = new t();
        NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = this.n2;
        nSTIJKPlayerSkyTv.Z0.postDelayed(nSTIJKPlayerSkyTv.a1, i2);
    }

    private void l4(String str, String str2, int i2) {
        new O(str, i2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public static /* synthetic */ P m2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.i4;
    }

    public static /* synthetic */ void n2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2, ArrayList arrayList) {
        nSTIJKPlayerSkyTvActivity.e4(i2, arrayList);
    }

    public static /* synthetic */ AsyncTask o2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.D2;
    }

    public static /* synthetic */ AsyncTask p2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, AsyncTask asyncTask) {
        nSTIJKPlayerSkyTvActivity.D2 = asyncTask;
        return asyncTask;
    }

    private void p4(String str, boolean z2) {
        String str2;
        String str3;
        RecyclerView recyclerView;
        LinearLayoutManager linearLayoutManager;
        if (z2 && this.q3.getVisibility() == 0) {
            this.q3.startAnimation(this.b4);
            this.q3.setVisibility(8);
        }
        this.o4 = str;
        if (str.equals("player")) {
            this.K3.startAnimation(this.m4);
            this.K3.setVisibility(0);
        }
        String str4 = this.s4;
        if ((str4 != null && str4.equals("-1")) || (((str2 = this.s4) != null && str2.equals("0")) || ((str3 = this.s4) != null && str3.equals("-6")))) {
            String str5 = this.s4;
            this.W2 = str5;
            this.X2 = str5;
        }
        if (this.o4.equals("player")) {
            q7.N n2 = new q7.N(this.d, this.W2, this.o4, this.q4, this.p4);
            this.g4 = n2;
            this.X2 = this.W2;
            this.M3.setAdapter(n2);
            recyclerView = this.M3;
            linearLayoutManager = this.k4;
        } else {
            q7.N n3 = new q7.N(this.d, this.W2, this.o4, this.q4, this.p4);
            this.f4 = n3;
            this.X2 = this.W2;
            this.L3.setAdapter(n3);
            recyclerView = this.L3;
            linearLayoutManager = this.j4;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        h3(z2);
    }

    public static /* synthetic */ String q2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.k2;
    }

    private void q3() {
        AsyncTask asyncTask = this.B2;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            SharepreferenceDBHandler.setAsyncTaskStatus(0, this.d);
        } else {
            SharepreferenceDBHandler.setAsyncTaskStatus(1, this.d);
            this.B2.cancel(true);
        }
    }

    private void q4() {
        try {
            new l(this).show();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int r2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, int i2) {
        nSTIJKPlayerSkyTvActivity.V2 = i2;
        return i2;
    }

    public static boolean r3() {
        ProgressBar progressBar = K5;
        return progressBar != null && progressBar.getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0327 A[PHI: r3 r4
      0x0327: PHI (r3v1 java.util.ArrayList) = 
      (r3v0 java.util.ArrayList)
      (r3v0 java.util.ArrayList)
      (r3v0 java.util.ArrayList)
      (r3v0 java.util.ArrayList)
      (r3v0 java.util.ArrayList)
      (r3v2 java.util.ArrayList)
      (r3v2 java.util.ArrayList)
     binds: [B:2:0x0021, B:15:0x0060, B:17:0x0068, B:19:0x006c, B:21:0x0072, B:65:0x0327, B:29:0x0327] A[DONT_GENERATE, DONT_INLINE]
      0x0327: PHI (r4v1 java.util.ArrayList) = 
      (r4v0 java.util.ArrayList)
      (r4v0 java.util.ArrayList)
      (r4v0 java.util.ArrayList)
      (r4v0 java.util.ArrayList)
      (r4v0 java.util.ArrayList)
      (r4v2 java.util.ArrayList)
      (r4v2 java.util.ArrayList)
     binds: [B:2:0x0021, B:15:0x0060, B:17:0x0068, B:19:0x006c, B:21:0x0072, B:65:0x0327, B:29:0x0327] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.HashMap r4(java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.r4(java.lang.String):java.util.HashMap");
    }

    public static /* synthetic */ String s2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, String str) {
        nSTIJKPlayerSkyTvActivity.W2 = str;
        return str;
    }

    private void s3() {
        EditText editText = this.N3;
        if (editText != null) {
            editText.setText("");
            this.N3.clearFocus();
        }
    }

    private HashMap s4(StalkerShortEPGCallback stalkerShortEPGCallback) {
        int i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (this.g0 != null) {
            arrayList3.add(0, (stalkerShortEPGCallback == null || stalkerShortEPGCallback.getJs() == null || stalkerShortEPGCallback.getJs().size() <= 0) ? "not_installed" : "installed");
            if (stalkerShortEPGCallback != null && stalkerShortEPGCallback.getJs().size() > 0) {
                long intValue = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(0)).getStartTimestamp().intValue();
                long intValue2 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(0)).getStopTimestamp().intValue();
                long j2 = intValue * 1000;
                Long valueOf = Long.valueOf(j2);
                long j3 = intValue2 * 1000;
                Long valueOf2 = Long.valueOf(j3);
                String name = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(0)).getName();
                String descr = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(0)).getDescr();
                int M2 = m7.w.M(j2, j3, this.d);
                if (M2 != 0) {
                    int i3 = 100 - M2;
                    if (i3 == 0 || name == null || name.equals("")) {
                        i2 = i3;
                    } else {
                        arrayList4.add(0, String.valueOf(i3));
                        StringBuilder sb = new StringBuilder();
                        i2 = i3;
                        sb.append(this.d.getResources().getString(a7.j.L4));
                        sb.append(" ");
                        sb.append(name);
                        arrayList.add(0, sb.toString());
                        arrayList.add(1, this.q0.format(valueOf) + " - " + this.q0.format(valueOf2));
                        arrayList.add(2, descr);
                    }
                    M2 = i2;
                }
                arrayList2.add(0, this.q0.format(valueOf) + " - " + this.q0.format(valueOf2));
                arrayList2.add(1, name);
                arrayList2.add(2, descr);
                if (1 < stalkerShortEPGCallback.getJs().size()) {
                    long intValue3 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(1)).getStartTimestamp().intValue();
                    long intValue4 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(1)).getStopTimestamp().intValue();
                    String name2 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(1)).getName();
                    String descr2 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(1)).getDescr();
                    Long valueOf3 = Long.valueOf(intValue3 * 1000);
                    Long valueOf4 = Long.valueOf(intValue4 * 1000);
                    if (M2 != 0 && 100 - M2 != 0 && name != null && !name.equals("")) {
                        arrayList.add(3, this.d.getResources().getString(a7.j.a4) + " " + name2);
                        arrayList.add(4, this.q0.format(valueOf3) + " - " + this.q0.format(valueOf4));
                        arrayList.add(5, descr2);
                    }
                    arrayList2.add(3, this.q0.format(valueOf3) + " - " + this.q0.format(valueOf4));
                    arrayList2.add(4, name2);
                    arrayList2.add(5, descr2);
                }
                if (2 < stalkerShortEPGCallback.getJs().size()) {
                    long intValue5 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getStartTimestamp().intValue();
                    long intValue6 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getStopTimestamp().intValue();
                    String name3 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getName();
                    String descr3 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getDescr();
                    arrayList2.add(6, this.q0.format(Long.valueOf(intValue5 * 1000)) + " - " + this.q0.format(Long.valueOf(intValue6 * 1000)));
                    arrayList2.add(7, name3);
                    arrayList2.add(8, descr3);
                }
                if (3 < stalkerShortEPGCallback.getJs().size()) {
                    long intValue7 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getStartTimestamp().intValue();
                    long intValue8 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getStopTimestamp().intValue();
                    String name4 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getName();
                    String descr4 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getDescr();
                    arrayList2.add(9, this.q0.format(Long.valueOf(intValue7 * 1000)) + " - " + this.q0.format(Long.valueOf(intValue8 * 1000)));
                    arrayList2.add(10, name4);
                    arrayList2.add(11, descr4);
                }
            }
        }
        hashMap.put("0", arrayList);
        hashMap.put("1", arrayList2);
        hashMap.put("2", arrayList3);
        hashMap.put("3", arrayList4);
        return hashMap;
    }

    public static /* synthetic */ q7.O t2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.h4;
    }

    private void t3() {
        try {
            SearchView searchView = this.U0;
            if (searchView == null || this.h2 == null) {
                return;
            }
            searchView.d0("", false);
            this.h2.collapseActionView();
        } catch (Exception unused) {
        }
    }

    private void u1() {
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.i0 = sharedPreferences;
        String str = "";
        this.k5 = sharedPreferences.getString("username", "");
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        String o0 = m7.w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
        if (this.j5.equalsIgnoreCase("")) {
            str = "UnCategories";
        } else {
            LiveStreamCategoryIdDBModel channelCatNameFromSelectedCatId = this.g0.getChannelCatNameFromSelectedCatId(this.j5);
            if (channelCatNameFromSelectedCatId != null) {
                str = channelCatNameFromSelectedCatId.getLiveStreamCategoryName();
            }
        }
        Retrofit E0 = m7.w.E0(this.d);
        if (E0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) E0.create(RetrofitPost.class);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", m7.a.S0);
            jsonObject.addProperty("s", m7.a.T0);
            jsonObject.addProperty("r", b7.b.b);
            jsonObject.addProperty("d", format);
            jsonObject.addProperty("sc", o0);
            jsonObject.addProperty("action", "addreport");
            jsonObject.addProperty("username", this.k5);
            jsonObject.addProperty("macaddress", this.l5);
            jsonObject.addProperty("section", this.i5);
            jsonObject.addProperty("section_category", str);
            jsonObject.addProperty("report_title", this.n5);
            jsonObject.addProperty("report_sub_title", this.o5);
            jsonObject.addProperty("report_cases", this.t5);
            jsonObject.addProperty("report_custom_message", this.q5);
            jsonObject.addProperty("stream_name", this.m5);
            jsonObject.addProperty("stream_id", Integer.valueOf(this.G1));
            retrofitPost.clientsReportRequest(jsonObject).enqueue(new z());
        }
    }

    public static /* synthetic */ ImageView u2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.C;
    }

    public static ProgressDialog u3(Context context) {
        try {
            ProgressDialog progressDialog = new ProgressDialog(context);
            try {
                progressDialog.setMessage(context.getResources().getString(a7.j.t5));
                progressDialog.show();
            } catch (Exception unused) {
            }
            progressDialog.setCancelable(false);
            return progressDialog;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static /* synthetic */ ArrayList v1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.J0;
    }

    public static /* synthetic */ Boolean v2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.t2;
    }

    public static long v3(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private void v4() {
        LinearLayout linearLayout;
        if (this.o4.equals("player")) {
            linearLayout = this.K;
            if (linearLayout == null) {
                return;
            }
        } else {
            linearLayout = this.J;
            if (linearLayout == null) {
                return;
            }
        }
        linearLayout.setVisibility(0);
    }

    public static /* synthetic */ Boolean w1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.f2;
    }

    public static /* synthetic */ String w2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.i;
    }

    private void w4() {
        if (this.I3.getVisibility() == 8) {
            this.I3.startAnimation(this.c4);
            this.I3.setVisibility(0);
            this.R3.requestFocus();
        }
    }

    public static /* synthetic */ Boolean x1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity, Boolean bool) {
        nSTIJKPlayerSkyTvActivity.f2 = bool;
        return bool;
    }

    public static /* synthetic */ SharedPreferences.Editor x2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.K1;
    }

    private void x4(Activity activity) {
        new x((NSTIJKPlayerSkyTvActivity) activity, activity).show();
    }

    public static /* synthetic */ ArrayList y1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.F0;
    }

    public static /* synthetic */ SharedPreferences.Editor y2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.L1;
    }

    private void y4() {
        float f2;
        ProgressDialog progressDialog;
        try {
            if (m7.a.Y.booleanValue()) {
                findViewById(a7.f.p).setOnClickListener(this);
            }
            this.f1.setVisibility(0);
            this.g1.setVisibility(0);
            this.h1.setVisibility(0);
            try {
                f2 = TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
            } catch (Exception unused) {
                f2 = 8.0f;
            }
            int i2 = (int) f2;
            this.e1.setPadding(i2, i2, i2, i2);
            RelativeLayout relativeLayout = this.J3;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            LinearLayout.LayoutParams layoutParams = this.i1.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = 0;
            this.i1.setLayoutParams(layoutParams);
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            G5 = false;
            ListView listView = this.V;
            if (listView != null) {
                listView.requestFocus();
            }
            if (this.z5.booleanValue()) {
                return;
            }
            ProgressDialog progressDialog2 = this.E2;
            if (progressDialog2 == null) {
                progressDialog = u3(this.d);
                this.E2 = progressDialog;
                if (progressDialog != null) {
                    progressDialog.show();
                }
            } else if (!progressDialog2.isShowing()) {
                progressDialog = this.E2;
                progressDialog.show();
            }
            this.U1.removeCallbacksAndMessages((Object) null);
            p4("", false);
            this.z5 = Boolean.TRUE;
        } catch (Exception e2) {
            Log.e("exection", "" + e2);
        }
    }

    public static /* synthetic */ NSTIJKPlayerSkyTv z1(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.n2;
    }

    public static /* synthetic */ List z2(NSTIJKPlayerSkyTvActivity nSTIJKPlayerSkyTvActivity) {
        return nSTIJKPlayerSkyTvActivity.l;
    }

    private void z3() {
        ImageView imageView = this.O3;
        imageView.setOnFocusChangeListener(new J(imageView));
        ImageView imageView2 = this.P3;
        imageView2.setOnFocusChangeListener(new J(imageView2));
        ImageView imageView3 = this.S3;
        imageView3.setOnFocusChangeListener(new J(imageView3));
        ImageView imageView4 = this.T3;
        imageView4.setOnFocusChangeListener(new J(imageView4));
        LinearLayout linearLayout = this.w3;
        linearLayout.setOnFocusChangeListener(new J(linearLayout));
        LinearLayout linearLayout2 = this.x3;
        linearLayout2.setOnFocusChangeListener(new J(linearLayout2));
        LinearLayout linearLayout3 = this.y3;
        linearLayout3.setOnFocusChangeListener(new J(linearLayout3));
        LinearLayout linearLayout4 = this.t3;
        linearLayout4.setOnFocusChangeListener(new J(linearLayout4));
        LinearLayout linearLayout5 = this.v3;
        linearLayout5.setOnFocusChangeListener(new J(linearLayout5));
        ImageView imageView5 = this.Q3;
        imageView5.setOnFocusChangeListener(new J(imageView5));
        ImageView imageView6 = this.R3;
        imageView6.setOnFocusChangeListener(new J(imageView6));
        RelativeLayout relativeLayout = this.H3;
        relativeLayout.setOnFocusChangeListener(new J(relativeLayout));
        ImageView imageView7 = this.a5;
        imageView7.setOnFocusChangeListener(new J(imageView7));
        RelativeLayout relativeLayout2 = this.b5;
        relativeLayout2.setOnFocusChangeListener(new J(relativeLayout2));
        ImageView imageView8 = this.a5;
        imageView8.setOnFocusChangeListener(new J(imageView8));
        LinearLayout linearLayout6 = this.c5;
        linearLayout6.setOnFocusChangeListener(new J(linearLayout6));
        LinearLayout linearLayout7 = this.d5;
        linearLayout7.setOnFocusChangeListener(new J(linearLayout7));
        CheckBox checkBox = this.z4;
        checkBox.setOnFocusChangeListener(new J(checkBox));
        CheckBox checkBox2 = this.A4;
        checkBox2.setOnFocusChangeListener(new J(checkBox2));
        CheckBox checkBox3 = this.B4;
        checkBox3.setOnFocusChangeListener(new J(checkBox3));
        CheckBox checkBox4 = this.C4;
        checkBox4.setOnFocusChangeListener(new J(checkBox4));
        LinearLayout linearLayout8 = this.e5;
        linearLayout8.setOnFocusChangeListener(new J(linearLayout8));
        CheckBox checkBox5 = this.D4;
        checkBox5.setOnFocusChangeListener(new J(checkBox5));
        CheckBox checkBox6 = this.E4;
        checkBox6.setOnFocusChangeListener(new J(checkBox6));
        CheckBox checkBox7 = this.F4;
        checkBox7.setOnFocusChangeListener(new J(checkBox7));
        CheckBox checkBox8 = this.G4;
        checkBox8.setOnFocusChangeListener(new J(checkBox8));
        CheckBox checkBox9 = this.H4;
        checkBox9.setOnFocusChangeListener(new J(checkBox9));
        LinearLayout linearLayout9 = this.f5;
        linearLayout9.setOnFocusChangeListener(new J(linearLayout9));
        LinearLayout linearLayout10 = this.g5;
        linearLayout10.setOnFocusChangeListener(new J(linearLayout10));
        CheckBox checkBox10 = this.J4;
        checkBox10.setOnFocusChangeListener(new J(checkBox10));
        CheckBox checkBox11 = this.K4;
        checkBox11.setOnFocusChangeListener(new J(checkBox11));
        CheckBox checkBox12 = this.L4;
        checkBox12.setOnFocusChangeListener(new J(checkBox12));
        CheckBox checkBox13 = this.M4;
        checkBox13.setOnFocusChangeListener(new J(checkBox13));
        EditText editText = this.V4;
        editText.setOnFocusChangeListener(new J(editText));
        TextView textView = this.x4;
        textView.setOnFocusChangeListener(new J(textView));
    }

    public void A3() {
        RelativeLayout relativeLayout = this.e1;
        if (relativeLayout != null) {
            relativeLayout.setPadding(0, 0, 0, 0);
        }
        G5 = true;
        z4();
        t4();
        l3(5000);
        String livePlayerAppName = SharepreferenceDBHandler.getLivePlayerAppName(this.d);
        if (!SharepreferenceDBHandler.getLivePlayerPkgName(this.d).equals("default") && !new ExternalPlayerDataBase(this.d).CheckPlayerExistense(livePlayerAppName)) {
            SharepreferenceDBHandler.setLivePlayer("default", "default", this.d);
        }
        String livePlayerPkgName = SharepreferenceDBHandler.getLivePlayerPkgName(this.d);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api") || livePlayerPkgName == null || livePlayerPkgName.equalsIgnoreCase("default")) {
            if (m7.a.Y.booleanValue()) {
                LinearLayout linearLayout = this.z3;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                findViewById(a7.f.p).setOnClickListener((View.OnClickListener) null);
                this.f1.setVisibility(8);
                this.g1.setVisibility(8);
                this.h1.setVisibility(8);
                getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
                LinearLayout.LayoutParams layoutParams = this.i1.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.i1.setLayoutParams(layoutParams);
                getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
                NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = this.n2;
                ((nSTIJKPlayerSkyTv == null || !nSTIJKPlayerSkyTv.isPlaying()) ? this.s : this.t).requestFocus();
                return;
            }
            return;
        }
        i4();
        this.H2 = true;
        SharedPreferences sharedPreferences = getSharedPreferences("currentlyPlayingVideoPosition", 0);
        this.m0 = sharedPreferences;
        int i2 = sharedPreferences.getInt("currentlyPlayingVideoPosition", 0);
        ArrayList g2 = this.h4.g();
        this.Z1 = i2;
        if (g2 == null || g2.size() <= 0 || this.Z1 >= g2.size()) {
            ArrayList arrayList = this.E0;
            if (arrayList != null && arrayList.size() > 0 && this.Z1 < this.E0.size()) {
                this.w2 = m7.w.r0(((LiveStreamsDBModel) this.E0.get(this.Z1)).getStreamId());
                this.l2 = ((LiveStreamsDBModel) this.E0.get(this.Z1)).getUrl();
                ((LiveStreamsDBModel) this.E0.get(this.Z1)).getName();
            }
        } else {
            this.w2 = m7.w.r0(((LiveStreamsDBModel) g2.get(this.Z1)).getStreamId());
            this.l2 = ((LiveStreamsDBModel) g2.get(this.Z1)).getUrl();
        }
        this.P = this.w2;
        this.R = this.l2;
        G5 = false;
        NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv2 = this.n2;
        if (nSTIJKPlayerSkyTv2 != null) {
            nSTIJKPlayerSkyTv2.j1(Boolean.FALSE);
        }
        if (this.k2.equals("m3u")) {
            if (this.t2.booleanValue()) {
                String livePlayerAppName2 = SharepreferenceDBHandler.getLivePlayerAppName(this.d);
                Intent intent = new Intent(this.d, PlayExternalPlayerActivity.class);
                intent.putExtra("url", this.R);
                intent.putExtra("packagename", livePlayerPkgName);
                intent.putExtra("app_name", livePlayerAppName2);
                this.d.startActivity(intent);
                return;
            }
            return;
        }
        if (this.w2 == -1 || !this.t2.booleanValue()) {
            return;
        }
        String V = m7.w.V(this.d, this.w2, this.r0, "live");
        String livePlayerAppName3 = SharepreferenceDBHandler.getLivePlayerAppName(this.d);
        Intent intent2 = new Intent(this.d, PlayExternalPlayerActivity.class);
        intent2.putExtra("url", V);
        intent2.putExtra("packagename", livePlayerPkgName);
        intent2.putExtra("app_name", livePlayerAppName3);
        this.d.startActivity(intent2);
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x002f A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:17:0x0003, B:19:0x000b, B:21:0x000f, B:3:0x002f, B:5:0x0033), top: B:16:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void B4(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L2f
            java.lang.String r1 = ""
            boolean r1 = r4.equals(r1)     // Catch: java.lang.Exception -> L2d
            if (r1 != 0) goto L2f
            android.widget.ImageView r1 = r3.C     // Catch: java.lang.Exception -> L2d
            if (r1 == 0) goto L56
            android.content.Context r1 = r3.d     // Catch: java.lang.Exception -> L2d
            com.squareup.picasso.t r1 = com.squareup.picasso.t.q(r1)     // Catch: java.lang.Exception -> L2d
            com.squareup.picasso.x r4 = r1.l(r4)     // Catch: java.lang.Exception -> L2d
            r1 = 80
            r2 = 55
            com.squareup.picasso.x r4 = r4.k(r1, r2)     // Catch: java.lang.Exception -> L2d
            int r1 = a7.e.i1     // Catch: java.lang.Exception -> L2d
            com.squareup.picasso.x r4 = r4.j(r1)     // Catch: java.lang.Exception -> L2d
            android.widget.ImageView r1 = r3.C     // Catch: java.lang.Exception -> L2d
            r4.g(r1)     // Catch: java.lang.Exception -> L2d
            goto L56
        L2d:
            goto L43
        L2f:
            android.widget.ImageView r4 = r3.C     // Catch: java.lang.Exception -> L2d
            if (r4 == 0) goto L56
            android.content.Context r1 = r3.d     // Catch: java.lang.Exception -> L2d
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Exception -> L2d
            int r2 = a7.e.i1     // Catch: java.lang.Exception -> L2d
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2, r0)     // Catch: java.lang.Exception -> L2d
            r4.setImageDrawable(r1)     // Catch: java.lang.Exception -> L2d
            goto L56
        L43:
            android.widget.ImageView r4 = r3.C
            if (r4 == 0) goto L56
            android.content.Context r1 = r3.d
            android.content.res.Resources r1 = r1.getResources()
            int r2 = a7.e.i1
            android.graphics.drawable.Drawable r0 = r1.getDrawable(r2, r0)
            r4.setImageDrawable(r0)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.B4(java.lang.String):void");
    }

    public void C3() {
        ArrayList arrayList;
        LiveStreamsDBModel liveStreamFavouriteRow;
        try {
            if (this.k2.equals("m3u")) {
                new ArrayList();
                LiveStreamDBHandler liveStreamDBHandler = this.g0;
                if (liveStreamDBHandler == null) {
                    return;
                }
                ArrayList favouriteM3U = liveStreamDBHandler.getFavouriteM3U("live");
                arrayList = new ArrayList();
                ArrayList arrayList2 = this.J0;
                if (arrayList2 != null && arrayList2.size() > 0 && favouriteM3U != null && favouriteM3U.size() > 0) {
                    favouriteM3U = K3(favouriteM3U, this.J0);
                }
                if (favouriteM3U == null || favouriteM3U.size() <= 0) {
                    return;
                }
                Iterator it = favouriteM3U.iterator();
                while (it.hasNext()) {
                    FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                    ArrayList m3UFavouriteRow = this.g0.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
                    if (m3UFavouriteRow != null && m3UFavouriteRow.size() > 0) {
                        arrayList.add((LiveStreamsDBModel) m3UFavouriteRow.get(0));
                    }
                }
            } else {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                    List<Integer> favIdsList = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
                    String str = "";
                    if (favIdsList != null && favIdsList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (Integer num : favIdsList) {
                            if (sb.length() > 0) {
                                sb.append(',');
                            }
                            sb.append("'");
                            sb.append(num);
                            sb.append("'");
                        }
                        str = sb.toString();
                    }
                    this.X.clear();
                    this.X = this.g0.getLiveFavStalker(str);
                    return;
                }
                new ArrayList();
                if (this.J1 == null) {
                    return;
                }
                ArrayList allFavourites = this.q4.equals("true") ? this.J1.getAllFavourites("radio_streams", SharepreferenceDBHandler.getUserID(this.d)) : this.J1.getAllFavourites("live", SharepreferenceDBHandler.getUserID(this.d));
                arrayList = new ArrayList();
                ArrayList arrayList3 = this.J0;
                if (arrayList3 != null && arrayList3.size() > 0 && allFavourites != null && allFavourites.size() > 0) {
                    allFavourites = J3(allFavourites, this.J0);
                }
                if (allFavourites == null || allFavourites.size() <= 0) {
                    return;
                }
                Iterator it2 = allFavourites.iterator();
                while (it2.hasNext()) {
                    FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it2.next();
                    LiveStreamDBHandler liveStreamDBHandler2 = new LiveStreamDBHandler(this.d);
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                        liveStreamFavouriteRow = liveStreamDBHandler2.getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), favouriteDBModel.getStreamIDOneStream(), favouriteDBModel.getTimestamp(), this.r4);
                        if (liveStreamFavouriteRow != null) {
                            arrayList.add(liveStreamFavouriteRow);
                        }
                    } else {
                        liveStreamFavouriteRow = liveStreamDBHandler2.getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), String.valueOf(favouriteDBModel.getStreamID()), favouriteDBModel.getTimestamp(), this.r4);
                        if (liveStreamFavouriteRow != null) {
                            arrayList.add(liveStreamFavouriteRow);
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    return;
                }
            }
            this.X = arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void C4(String str) {
        y3();
        String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.d);
        String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.d);
        try {
            if (this.g == null) {
                this.g = new n7.g(this, this.d);
            }
            this.g.e(loggedInMacAddress, stalkerToken, str);
        } catch (Exception unused) {
        }
    }

    public void D0(String str) {
    }

    public String D3() {
        AsyncTask asyncTask;
        try {
            this.G2 = 0;
            ArrayList arrayList = this.C0;
            if (arrayList != null && this.A0 != null) {
                arrayList.clear();
                this.A0.clear();
            }
            ArrayList arrayList2 = this.X;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.X.clear();
            }
            C3();
            ArrayList arrayList3 = this.E0;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            this.C0 = this.X;
            ArrayList arrayList4 = this.D0;
            if (arrayList4 != null) {
                arrayList4.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.R2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.R2.B();
            ArrayList ePGTesting = B2 ? this.g0.getEPGTesting((String) null, format) : null;
            this.m0 = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.l0.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api") ? this.l0 : this.l0).getString("currentlyPlayingVideo", "");
            ArrayList arrayList5 = this.C0;
            if (arrayList5 == null || arrayList5.size() <= 0) {
                this.E0 = this.C0;
                return "get_fav";
            }
            for (int i2 = 0; i2 < this.C0.size(); i2++) {
                AsyncTask asyncTask2 = this.B2;
                if (asyncTask2 != null && asyncTask2.isCancelled()) {
                    return "get_fav";
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.C0.get(i2)).getUrl().equals(string)) {
                        this.G2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.C0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.G2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.C0.get(i2)).getStreamId().equals(string)) {
                    this.G2 = i2;
                }
                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.C0.get(i2)).getNum());
                liveStreamsDBModel.setName(((LiveStreamsDBModel) this.C0.get(i2)).getName());
                liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.C0.get(i2)).getStreamType());
                liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.C0.get(i2)).getStreamId());
                liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.C0.get(i2)).getStreamIdOneStream());
                liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.C0.get(i2)).getStreamIcon());
                liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.C0.get(i2)).getEpgChannelId());
                liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.C0.get(i2)).getAdded());
                liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.C0.get(i2)).getCategoryId());
                liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.C0.get(i2)).getCustomSid());
                liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.C0.get(i2)).getTvArchive());
                liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.C0.get(i2)).getDirectSource());
                liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.C0.get(i2)).getTvArchiveDuration());
                liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.C0.get(i2)).getTypeName());
                liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.C0.get(i2)).getCategoryName());
                liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.C0.get(i2)).getSeriesNo());
                liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.C0.get(i2)).getLive());
                liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.C0.get(i2)).getContaiinerExtension());
                liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.C0.get(i2)).getUrl());
                if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < ePGTesting.size() && ((asyncTask = this.B2) == null || !asyncTask.isCancelled())) {
                            if (((LiveStreamsDBModel) this.C0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                                int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                                if (M2 != 0) {
                                    M2 = 100 - M2;
                                }
                                liveStreamsDBModel.setEpgPercentage(M2);
                                liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                this.D0.add(liveStreamsDBModel);
                this.E0 = this.D0;
            }
            return "get_fav";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_fav";
        }
    }

    public String E3() {
        DatabaseHandler databaseHandler;
        String str;
        int userID;
        String categoryID;
        String valueOf;
        String timestamp;
        String str2;
        SharedPreferences sharedPreferences;
        AsyncTask asyncTask;
        AsyncTask asyncTask2;
        String str3;
        String str4 = "currentlyPlayingVideo";
        try {
            this.l4 = 0;
            ArrayList arrayList = this.E0;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList arrayList2 = new ArrayList();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                List<Integer> favIdsList = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
                if (favIdsList == null || favIdsList.size() <= 0) {
                    str3 = "";
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (Integer num : favIdsList) {
                        if (sb.length() > 0) {
                            sb.append(',');
                        }
                        sb.append("'");
                        sb.append(num);
                        sb.append("'");
                    }
                    str3 = sb.toString();
                }
                arrayList2.clear();
                arrayList2 = this.g0.getLiveFavStalker(str3);
            } else {
                ArrayList arrayList3 = new ArrayList();
                if (this.J1 != null) {
                    if (this.q4.equals("true")) {
                        databaseHandler = this.J1;
                        str = "radio_streams";
                        userID = SharepreferenceDBHandler.getUserID(this.d);
                    } else {
                        databaseHandler = this.J1;
                        str = "live";
                        userID = SharepreferenceDBHandler.getUserID(this.d);
                    }
                    ArrayList allFavourites = databaseHandler.getAllFavourites(str, userID);
                    ArrayList arrayList4 = this.J0;
                    if (arrayList4 == null || arrayList4.size() <= 0 || allFavourites == null || allFavourites.size() <= 0) {
                        arrayList3 = allFavourites;
                    } else {
                        try {
                            Iterator it = allFavourites.iterator();
                            while (it.hasNext()) {
                                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
                                Iterator it2 = this.J0.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        arrayList3.add(favouriteDBModel);
                                        break;
                                    }
                                    if (favouriteDBModel.getCategoryID().equals((String) it2.next())) {
                                        break;
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (arrayList3 != null) {
                        try {
                            if (arrayList3.size() > 0) {
                                Iterator it3 = arrayList3.iterator();
                                while (it3.hasNext()) {
                                    FavouriteDBModel favouriteDBModel2 = (FavouriteDBModel) it3.next();
                                    LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.d);
                                    if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                                        categoryID = favouriteDBModel2.getCategoryID();
                                        valueOf = String.valueOf(favouriteDBModel2.getStreamIDOneStream());
                                        timestamp = favouriteDBModel2.getTimestamp();
                                        str2 = this.r4;
                                    } else {
                                        categoryID = favouriteDBModel2.getCategoryID();
                                        valueOf = String.valueOf(favouriteDBModel2.getStreamID());
                                        timestamp = favouriteDBModel2.getTimestamp();
                                        str2 = this.r4;
                                    }
                                    LiveStreamsDBModel liveStreamFavouriteRow = liveStreamDBHandler.getLiveStreamFavouriteRow(categoryID, valueOf, timestamp, str2);
                                    if (liveStreamFavouriteRow != null) {
                                        arrayList2.add(liveStreamFavouriteRow);
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            if (arrayList2.size() != 0) {
                this.E0 = arrayList2;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.R2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.R2.B();
            ArrayList ePGTesting = B2 ? this.g0.getEPGTesting((String) null, format) : null;
            this.m0 = getSharedPreferences("currentlyPlayingVideo", 0);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                sharedPreferences = this.l0;
                str4 = "LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U";
            } else {
                sharedPreferences = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api") ? this.l0 : this.l0;
            }
            String string = sharedPreferences.getString(str4, "");
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = this.E0;
            if (arrayList6 != null && arrayList6.size() > 0) {
                for (int i2 = 0; i2 < this.E0.size() && ((asyncTask = this.B2) == null || !asyncTask.isCancelled()); i2++) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                        if (((LiveStreamsDBModel) this.E0.get(i2)).getUrl().equals(string)) {
                            this.l4 = i2;
                        }
                    } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                        if (((LiveStreamsDBModel) this.E0.get(i2)).getStreamIdOneStream().equals(string)) {
                            this.l4 = i2;
                        }
                    } else if (((LiveStreamsDBModel) this.E0.get(i2)).getStreamId().equals(string)) {
                        this.l4 = i2;
                    }
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.E0.get(i2)).getNum());
                    liveStreamsDBModel.setName(((LiveStreamsDBModel) this.E0.get(i2)).getName());
                    liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.E0.get(i2)).getStreamType());
                    liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.E0.get(i2)).getStreamId());
                    liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.E0.get(i2)).getStreamIdOneStream());
                    liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.E0.get(i2)).getStreamIcon());
                    liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.E0.get(i2)).getEpgChannelId());
                    liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.E0.get(i2)).getAdded());
                    liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.E0.get(i2)).getCategoryId());
                    liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.E0.get(i2)).getCustomSid());
                    liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.E0.get(i2)).getTvArchive());
                    liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.E0.get(i2)).getDirectSource());
                    liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.E0.get(i2)).getTvArchiveDuration());
                    liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.E0.get(i2)).getTypeName());
                    liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.E0.get(i2)).getCategoryName());
                    liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.E0.get(i2)).getSeriesNo());
                    liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.E0.get(i2)).getLive());
                    liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.E0.get(i2)).getContaiinerExtension());
                    liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.E0.get(i2)).getUrl());
                    if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < ePGTesting.size() && ((asyncTask2 = this.B2) == null || !asyncTask2.isCancelled())) {
                                if (((LiveStreamsDBModel) this.E0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                                    int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                                    if (M2 != 0) {
                                        M2 = 100 - M2;
                                    }
                                    liveStreamsDBModel.setEpgPercentage(M2);
                                    liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                    arrayList5.add(liveStreamsDBModel);
                }
            }
            ArrayList arrayList7 = this.E0;
            if (arrayList7 == null) {
                return "get_fav";
            }
            arrayList7.clear();
            this.E0.addAll(arrayList5);
            return "get_fav";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "get_fav";
        }
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void F3() {
        if (this.Z4.getVisibility() == 0) {
            this.c5.setNextFocusRightId(a7.f.K3);
            this.d5.setNextFocusRightId(a7.f.e2);
            this.e5.setNextFocusRightId(a7.f.a2);
            this.f5.setNextFocusRightId(a7.f.V1);
        }
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    public int G3(ArrayList arrayList, int i2) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            try {
                if (m7.w.r0(((LiveStreamsDBModel) arrayList.get(i3)).getNum()) == i2) {
                    return i3;
                }
            } catch (Exception unused) {
                return 0;
            }
        }
        return 0;
    }

    public void H(String str) {
        if (this.p4.equals("false")) {
            m4();
            return;
        }
        String str2 = this.j1;
        this.W2 = str2;
        q7.N n2 = new q7.N(this.d, str2, "", this.q4, this.p4);
        this.f4 = n2;
        this.X2 = this.W2;
        this.L3.setAdapter(n2);
        this.L3.setLayoutManager(this.j4);
        h3(true);
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
        try {
            StalkerLiveFavIdsSingleton.getInstance().setFavIdsList((List) null);
            this.m.i(this.o, this.n);
        } catch (Exception unused) {
        }
    }

    public void M0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public void N3() {
        if (this.q3.getVisibility() == 0) {
            this.q3.startAnimation(this.b4);
            if (this.n3.getVisibility() == 0) {
                this.n3.startAnimation(this.b4);
            }
            if (this.p3.getVisibility() == 0) {
                this.p3.startAnimation(this.b4);
            }
            if (this.o3.getVisibility() == 0) {
                this.o3.startAnimation(this.b4);
            }
            this.q3.setVisibility(8);
            if (this.n3.getVisibility() == 0) {
                this.n3.setVisibility(8);
            }
            if (this.p3.getVisibility() == 0) {
                this.p3.setVisibility(8);
            }
            if (this.o3.getVisibility() == 0) {
                this.o3.setVisibility(8);
            }
            this.C3.setVisibility(8);
            this.A3.setVisibility(8);
            this.Y4.setVisibility(8);
            this.B3.setVisibility(8);
        }
    }

    public void P(String str) {
        try {
            this.E1.setVisibility(8);
            L3();
        } catch (Exception unused) {
        }
    }

    public void P0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public void P3() {
        LinearLayout linearLayout = this.D3;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.E3;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    public void Q3() {
        LinearLayout linearLayout = this.W0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.X0;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    public void R3() {
        try {
            ProgressDialog progressDialog = this.E2;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.E2.dismiss();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean S3() {
        /*
            Method dump skipped, instructions count: 659
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.S3():boolean");
    }

    public void T0(StalkerDeletePlayerLinkCallback stalkerDeletePlayerLinkCallback) {
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
        if (stalkerLiveFavIdsCallback != null && stalkerLiveFavIdsCallback.getJs() != null && stalkerLiveFavIdsCallback.getJs().size() > 0) {
            StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(stalkerLiveFavIdsCallback.getJs());
        }
        this.l = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
        if (this.p4.equals("false")) {
            m4();
            return;
        }
        String str = this.j1;
        this.W2 = str;
        q7.N n2 = new q7.N(this.d, str, "", this.q4, this.p4);
        this.f4 = n2;
        this.X2 = this.W2;
        this.L3.setAdapter(n2);
        this.L3.setLayoutManager(this.j4);
        h3(true);
    }

    public boolean U3() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        if (i2 >= 33) {
            return true;
        }
        if (t7.g.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        Log.v("TAG", "Permission is revoked");
        D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 101);
        return false;
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public void V3(String str) {
        this.X2 = str;
        try {
            SearchView searchView = this.U0;
            if (searchView != null && this.h2 != null) {
                searchView.d0("", false);
                this.h2.collapseActionView();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.g2 != null) {
                if (this.X2.equals("-6")) {
                    this.g2.getItem(2).getSubMenu().findItem(a7.f.Db).setVisible(true);
                } else {
                    this.g2.getItem(2).getSubMenu().findItem(a7.f.Db).setVisible(false);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        h3(true);
    }

    public void X(StalkerShortEPGCallback stalkerShortEPGCallback) {
        if (stalkerShortEPGCallback == null || stalkerShortEPGCallback.getJs() == null || stalkerShortEPGCallback.getJs().size() <= 0) {
            try {
                this.E1.setVisibility(8);
                L3();
            } catch (Exception unused) {
            }
        } else {
            HashMap hashMap = new HashMap();
            try {
                hashMap = s4(stalkerShortEPGCallback);
            } catch (Exception unused2) {
            }
            x3(hashMap);
        }
    }

    public void Y3() {
        LinearLayout linearLayout = this.D3;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        if (this.D3 != null) {
            this.E3.setVisibility(0);
        }
    }

    public void Z3() {
        TextView textView;
        Resources resources;
        int i2;
        m7.a.Y = Boolean.TRUE;
        this.O = true;
        this.A.setVisibility(0);
        if (this.X2.equalsIgnoreCase("-1")) {
            textView = this.B;
            resources = this.d.getResources();
            i2 = a7.j.k4;
        } else {
            textView = this.B;
            resources = this.d.getResources();
            i2 = a7.j.g4;
        }
        textView.setText(resources.getString(i2));
        this.E1.setVisibility(8);
        if (m7.a.B.booleanValue()) {
            findViewById(a7.f.Sm).setVisibility(8);
        }
    }

    public void a4() {
        LinearLayout linearLayout = this.W0;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.X0;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
    }

    public void b4(int i2) {
        try {
            q7.N n2 = this.f4;
            if (n2 != null) {
                n2.x(i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str) {
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2) {
        Context context;
        StringBuilder sb;
        try {
            m7.w.X();
            if (this.V == null || this.h4 == null || stalkerSetLiveFavCallback == null || stalkerSetLiveFavCallback.getJs() == null || !stalkerSetLiveFavCallback.getJs().equals(Boolean.TRUE)) {
                return;
            }
            this.l = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
            if (str.equals("added")) {
                int i2 = this.p;
                if (i2 != 0) {
                    this.l.add(Integer.valueOf(i2));
                }
                StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(this.l);
                try {
                    ListView listView = this.V;
                    View childAt = listView.getChildAt(this.q - listView.getFirstVisiblePosition());
                    if (childAt != null) {
                        try {
                            childAt.findViewById(a7.f.g5).setVisibility(0);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.f4.x(1);
                } catch (Exception unused) {
                }
                context = this.d;
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.d.getResources().getString(a7.j.q));
            } else {
                int i3 = this.p;
                if (i3 != 0) {
                    this.l.remove(Integer.valueOf(i3));
                    StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(this.l);
                }
                try {
                    ListView listView2 = this.V;
                    View childAt2 = listView2.getChildAt(this.q - listView2.getFirstVisiblePosition());
                    if (childAt2 != null) {
                        try {
                            childAt2.findViewById(a7.f.g5).setVisibility(4);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    this.f4.x(1);
                } catch (Exception unused2) {
                }
                context = this.d;
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.d.getResources().getString(a7.j.c6));
            }
            m7.w.P0(context, sb.toString());
        } catch (Exception unused3) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        boolean z2 = keyEvent.getAction() == 0;
        if (keyCode == 82) {
            try {
                keyEvent = z2 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent);
                return keyEvent;
            } catch (Exception unused) {
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void e(String str) {
    }

    public void e0(String str) {
    }

    public void e3() {
        q3();
        this.B2 = new H().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels"});
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void f3() {
        q3();
        this.B2 = new H().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels_with_cat"});
    }

    public String g3() {
        AsyncTask asyncTask;
        try {
            this.G2 = 0;
            ArrayList arrayList = this.C0;
            if (arrayList != null && this.A0 != null) {
                arrayList.clear();
                this.A0.clear();
            }
            this.G0 = this.q4.equals("true") ? this.g0.getAllLiveStreasWithCategoryId(this.j1, "radio_streams") : this.g0.getAllLiveStreasWithCategoryId(this.j1, "live");
            this.C0 = this.G0;
            ArrayList arrayList2 = this.D0;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.R2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.R2.B();
            ArrayList ePGTesting = B2 ? this.g0.getEPGTesting((String) null, format) : null;
            this.m0 = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.l0.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api") ? this.l0 : this.l0).getString("currentlyPlayingVideo", "");
            ArrayList arrayList3 = this.C0;
            if (arrayList3 == null || arrayList3.size() <= 0) {
                return "all_channels_with_cat";
            }
            for (int i2 = 0; i2 < this.C0.size(); i2++) {
                AsyncTask asyncTask2 = this.B2;
                if (asyncTask2 != null && asyncTask2.isCancelled()) {
                    return "all_channels_with_cat";
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.C0.get(i2)).getUrl().equals(string)) {
                        this.G2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.C0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.G2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.C0.get(i2)).getStreamId().equals(string)) {
                    this.G2 = i2;
                }
                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.C0.get(i2)).getNum());
                liveStreamsDBModel.setName(((LiveStreamsDBModel) this.C0.get(i2)).getName());
                liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.C0.get(i2)).getStreamType());
                liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.C0.get(i2)).getStreamId());
                liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.C0.get(i2)).getStreamIdOneStream());
                liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.C0.get(i2)).getStreamIcon());
                liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.C0.get(i2)).getEpgChannelId());
                liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.C0.get(i2)).getAdded());
                liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.C0.get(i2)).getCategoryId());
                liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.C0.get(i2)).getCustomSid());
                liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.C0.get(i2)).getTvArchive());
                liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.C0.get(i2)).getDirectSource());
                liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.C0.get(i2)).getTvArchiveDuration());
                liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.C0.get(i2)).getTypeName());
                liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.C0.get(i2)).getCategoryName());
                liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.C0.get(i2)).getSeriesNo());
                liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.C0.get(i2)).getLive());
                liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.C0.get(i2)).getContaiinerExtension());
                liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.C0.get(i2)).getUrl());
                if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ePGTesting.size() || ((asyncTask = this.B2) != null && asyncTask.isCancelled())) {
                            break;
                        }
                        if (((LiveStreamsDBModel) this.C0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                            int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                            if (M2 != 0) {
                                M2 = 100 - M2;
                            }
                            liveStreamsDBModel.setEpgPercentage(M2);
                            liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                        } else {
                            i3++;
                        }
                    }
                }
                this.D0.add(liveStreamsDBModel);
            }
            return "all_channels_with_cat";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "all_channels_with_cat";
        }
    }

    public void h3(boolean z2) {
        ProgressDialog progressDialog;
        q3();
        if (z2) {
            ProgressDialog progressDialog2 = this.E2;
            if (progressDialog2 == null) {
                progressDialog = u3(this.d);
                this.E2 = progressDialog;
                if (progressDialog != null) {
                    progressDialog.show();
                }
            } else if (!progressDialog2.isShowing()) {
                progressDialog = this.E2;
                progressDialog.show();
            }
        }
        this.B2 = new I().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels_with_cat"});
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void i3() {
        q3();
        this.B2 = new H().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"get_fav"});
    }

    public void i4() {
        try {
            NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = this.n2;
            if (nSTIJKPlayerSkyTv != null) {
                if (nSTIJKPlayerSkyTv.o1()) {
                    this.n2.i1();
                } else {
                    this.n2.D1();
                    this.n2.r1(true);
                    this.n2.B1();
                }
                IjkMediaPlayer.native_profileEnd();
            }
        } catch (Exception unused) {
        }
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public void j3() {
        q3();
        this.B2 = new H().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"recently_watched"});
    }

    public String k3() {
        AsyncTask asyncTask;
        AsyncTask asyncTask2;
        try {
            this.l4 = 0;
            ArrayList arrayList = this.E0;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.E0 = this.q4.equalsIgnoreCase("true") ? this.g0.getAllRecentlyWatchedLiveStreams("radio_streams") : this.g0.getAllRecentlyWatchedLiveStreams("live");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.R2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.R2.B();
            ArrayList ePGTesting = B2 ? this.g0.getEPGTesting((String) null, format) : null;
            this.m0 = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.l0.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api") ? this.l0 : this.l0).getString("currentlyPlayingVideo", "");
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = this.E0;
            if (arrayList3 != null && arrayList3.size() > 0) {
                for (int i2 = 0; i2 < this.E0.size() && ((asyncTask = this.B2) == null || !asyncTask.isCancelled()); i2++) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                        if (((LiveStreamsDBModel) this.E0.get(i2)).getUrl().equals(string)) {
                            this.l4 = i2;
                            this.Z1 = i2;
                        }
                    } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                        if (((LiveStreamsDBModel) this.E0.get(i2)).getStreamIdOneStream().equals(string)) {
                            this.l4 = i2;
                            this.Z1 = i2;
                        }
                    } else if (((LiveStreamsDBModel) this.E0.get(i2)).getStreamId().equals(string)) {
                        this.l4 = i2;
                        this.Z1 = i2;
                    }
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.E0.get(i2)).getNum());
                    liveStreamsDBModel.setName(((LiveStreamsDBModel) this.E0.get(i2)).getName());
                    liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.E0.get(i2)).getStreamType());
                    liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.E0.get(i2)).getStreamId());
                    liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.E0.get(i2)).getStreamIdOneStream());
                    liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.E0.get(i2)).getStreamIcon());
                    liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.E0.get(i2)).getEpgChannelId());
                    liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.E0.get(i2)).getAdded());
                    liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.E0.get(i2)).getCategoryId());
                    liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.E0.get(i2)).getCustomSid());
                    liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.E0.get(i2)).getTvArchive());
                    liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.E0.get(i2)).getDirectSource());
                    liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.E0.get(i2)).getTvArchiveDuration());
                    liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.E0.get(i2)).getTypeName());
                    liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.E0.get(i2)).getCategoryName());
                    liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.E0.get(i2)).getSeriesNo());
                    liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.E0.get(i2)).getLive());
                    liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.E0.get(i2)).getContaiinerExtension());
                    liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.E0.get(i2)).getUrl());
                    if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < ePGTesting.size() && ((asyncTask2 = this.B2) == null || !asyncTask2.isCancelled())) {
                                if (((LiveStreamsDBModel) this.E0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                                    int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                                    if (M2 != 0) {
                                        M2 = 100 - M2;
                                    }
                                    liveStreamsDBModel.setEpgPercentage(M2);
                                    liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                    arrayList2.add(liveStreamsDBModel);
                }
            }
            this.E0 = arrayList2;
            return "all_channels_with_cat";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "all_channels_with_cat";
        }
    }

    public final void k4(String str, int i2, String str2, String str3, int i3, String str4) {
        new N(str, i2, str2, str3, i3).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public void m3(int i2) {
        this.n2.a1 = new s();
        NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = this.n2;
        nSTIJKPlayerSkyTv.Z0.postDelayed(nSTIJKPlayerSkyTv.a1, i2);
    }

    public void m4() {
        this.C2 = new F().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public String n3(String str) {
        ArrayList arrayList = this.x0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = this.x0.iterator();
            while (it.hasNext()) {
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) it.next();
                if (liveStreamCategoryIdDBModel.getLiveStreamCategoryID() != null && !liveStreamCategoryIdDBModel.getLiveStreamCategoryID().isEmpty() && liveStreamCategoryIdDBModel.getLiveStreamCategoryID().equalsIgnoreCase(str)) {
                    this.k1 = liveStreamCategoryIdDBModel.getLiveStreamCategoryName();
                }
            }
        }
        return this.k1;
    }

    public void n4(ArrayList arrayList) {
        TextView textView;
        if (arrayList != null) {
            try {
                this.N = false;
                this.V0.setVisibility(8);
                if (arrayList.size() == 0) {
                    if (this.F2) {
                        TextView textView2 = this.V0;
                        if (textView2 == null) {
                            return;
                        }
                        this.N = true;
                        textView2.setFocusable(true);
                        this.V0.requestFocus();
                        textView = this.V0;
                    } else {
                        this.F2 = true;
                        ArrayList arrayList2 = this.C0;
                        if (arrayList2 != null && this.A0 != null) {
                            arrayList2.clear();
                            this.A0.clear();
                        }
                        this.C0 = this.q4.equals("true") ? this.g0.getAllLiveStreasWithCategoryId(this.j1, "radio_streams") : this.g0.getAllLiveStreasWithCategoryId(this.j1, "live");
                        ArrayList arrayList3 = this.C0;
                        if (arrayList3 != null && arrayList3.size() > 0) {
                            n4(this.C0);
                            return;
                        }
                        TextView textView3 = this.V0;
                        if (textView3 == null) {
                            return;
                        }
                        this.N = true;
                        textView3.setFocusable(true);
                        this.V0.requestFocus();
                        textView = this.V0;
                    }
                    textView.setVisibility(0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void o0(String str) {
    }

    public void o3(int i2, String str, String str2) {
    }

    public void o4(ArrayList arrayList) {
        ListView listView;
        try {
            if (this.o4.equals("player")) {
                this.f = arrayList;
                if (arrayList != null && arrayList.size() > 0) {
                    ListView listView2 = this.W;
                    if (listView2 != null) {
                        listView2.setVisibility(0);
                    }
                    this.N = false;
                    if (this.W != null) {
                        P p2 = new P(this, arrayList);
                        this.i4 = p2;
                        this.W.setAdapter(p2);
                        this.h4.h(this.Q0);
                        this.W.setSelection(this.l4);
                        this.W.requestFocus();
                        this.W.setOnItemClickListener(new D());
                        return;
                    }
                    return;
                }
                LinearLayout linearLayout = this.W0;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                LinearLayout linearLayout2 = this.X0;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                listView = this.W;
                if (listView == null) {
                    return;
                }
            } else {
                this.e = arrayList;
                if (arrayList != null && arrayList.size() > 0) {
                    ListView listView3 = this.V;
                    if (listView3 != null) {
                        listView3.setVisibility(0);
                    }
                    this.N = false;
                    if (this.V != null) {
                        q7.O o2 = new q7.O(this, arrayList);
                        this.h4 = o2;
                        o2.i(null);
                        this.V.setAdapter(this.h4);
                        this.V.setSelection(this.l4);
                        if (!G5) {
                            this.V.requestFocus();
                        }
                        this.V.setOnItemSelectedListener(new a());
                        this.V.setOnItemClickListener(new b(arrayList));
                        this.V.setOnItemLongClickListener(new c());
                        return;
                    }
                    return;
                }
                LinearLayout linearLayout3 = this.W0;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                LinearLayout linearLayout4 = this.X0;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                listView = this.V;
                if (listView == null) {
                    return;
                }
            }
            listView.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i2, i3, intent);
        if (i2 == 101) {
            try {
                if (U3()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("downloadStatus", 0);
                    F5 = sharedPreferences;
                    String string = sharedPreferences.getString("downloadStatus", "");
                    m7.w wVar = new m7.w();
                    if (string.equals("processing")) {
                        wVar.L0(this);
                    } else {
                        wVar.O0(this, this.v2, this.r0, this.r, this.P, this.R, this.Q);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0115 A[Catch: Exception -> 0x0122, PHI: r0
      0x0115: PHI (r0v9 android.widget.LinearLayout) = (r0v8 android.widget.LinearLayout), (r0v26 android.widget.LinearLayout) binds: [B:50:0x011e, B:44:0x0113] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0122, blocks: (B:2:0x0000, B:4:0x0009, B:6:0x000f, B:9:0x001c, B:11:0x0024, B:13:0x0031, B:15:0x0036, B:17:0x003c, B:19:0x009d, B:21:0x00a1, B:23:0x00a9, B:25:0x00b8, B:26:0x00bf, B:28:0x00c7, B:29:0x00ce, B:31:0x00d6, B:32:0x00dd, B:34:0x00ea, B:35:0x00ef, B:37:0x00f7, B:38:0x00fc, B:40:0x0104, B:41:0x0109, B:43:0x0111, B:45:0x0115, B:46:0x0118, B:49:0x011c), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBackPressed() {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.onBackPressed():void");
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        CheckBox checkBox;
        boolean isChecked = ((CheckBox) compoundButton).isChecked();
        int id = compoundButton.getId();
        if (id == a7.f.V1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.J4;
            }
        } else if (id == a7.f.X1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.K4;
            }
        } else if (id == a7.f.Y1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.L4;
            }
        } else if (id == a7.f.W1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.M4;
            }
        } else if (id == a7.f.e2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.z4;
            }
        } else if (id == a7.f.g2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.A4;
            }
        } else if (id == a7.f.h2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.B4;
            }
        } else if (id == a7.f.f2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.C4;
            }
        } else if (id == a7.f.a2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.D4;
            }
        } else if (id == a7.f.c2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.E4;
            }
        } else if (id == a7.f.d2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.F4;
            }
        } else if (id == a7.f.b2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.G4;
            }
        } else if (id != a7.f.Z1 || !isChecked) {
            return;
        } else {
            checkBox = this.H4;
        }
        this.p5 = checkBox.getText().toString();
    }

    public void onClick(View view) {
        String str;
        String str2;
        x7.a f2;
        String valueOf;
        SharedPreferences.Editor editor;
        String valueOf2;
        x7.a f3;
        String valueOf3;
        TextView textView;
        Resources resources;
        int i2;
        int i3;
        int i4;
        ImageView imageView;
        ImageView imageView2;
        String V;
        Intent intent;
        String str3;
        Intent intent2;
        int id = view.getId();
        String str4 = "";
        if (id == a7.f.S8) {
            this.v5 = true;
            if (!this.O) {
                i4();
                if (!SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                    this.v5 = true;
                    if (!this.O) {
                        i4();
                        if (this.k2.equals("m3u")) {
                            if (this.t2.booleanValue()) {
                                intent2 = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
                                intent2.putExtra("url", this.I1);
                                x7.a.f().A(this.I1);
                                intent2.putExtra("CHANNEL_NUM", this.V2);
                                this.d.startActivity(intent2);
                            }
                        } else if (this.G1 != -1 && this.t2.booleanValue()) {
                            V = m7.w.V(this.d, this.G1, this.r0, "live");
                            x7.a.f().A(String.valueOf(this.G1));
                            intent = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
                            intent.putExtra("url", V);
                            intent.putExtra("CHANNEL_NUM", this.V2);
                            this.d.startActivity(intent);
                        }
                    }
                } else if (this.k2.equals("m3u")) {
                    if (this.t2.booleanValue()) {
                        intent2 = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
                        intent2.putExtra("url", this.I1);
                        x7.a.f().A(this.I1);
                        intent2.putExtra("CHANNEL_NUM", this.V2);
                        this.d.startActivity(intent2);
                    }
                } else if (this.k2.equals("onestream_api")) {
                    if (this.t2.booleanValue()) {
                        try {
                            JSONObject jSONObject = new JSONObject(this.l2);
                            String str5 = this.r0;
                            String str6 = "m3u8";
                            String str7 = "ts";
                            if (str5 == null || str5.isEmpty() || !this.r0.equals(".ts")) {
                                V = "";
                                str3 = V;
                            } else {
                                Iterator keys = jSONObject.keys();
                                while (true) {
                                    if (!keys.hasNext()) {
                                        str3 = "";
                                        break;
                                    } else if (((String) keys.next()).equals("ts")) {
                                        str3 = "ts";
                                        break;
                                    }
                                }
                                if (str3.equals("")) {
                                    while (true) {
                                        if (!keys.hasNext()) {
                                            break;
                                        } else if (((String) keys.next()).equals("m3u8")) {
                                            str3 = "m3u8";
                                            break;
                                        }
                                    }
                                }
                                V = jSONObject.getString(str3);
                            }
                            try {
                                String str8 = this.r0;
                                if (str8 != null && !str8.isEmpty() && this.r0.equals(".m3u8")) {
                                    Iterator keys2 = jSONObject.keys();
                                    while (true) {
                                        if (!keys2.hasNext()) {
                                            str6 = str3;
                                            break;
                                        } else if (((String) keys2.next()).equals("m3u8")) {
                                            break;
                                        }
                                    }
                                    if (str6.equals("")) {
                                        while (keys2.hasNext()) {
                                            if (((String) keys2.next()).equals("ts")) {
                                                break;
                                            }
                                        }
                                        str7 = str6;
                                        V = jSONObject.getString(str7);
                                    } else {
                                        str7 = str6;
                                        V = jSONObject.getString(str7);
                                    }
                                }
                            } catch (Exception unused) {
                                str4 = V;
                                V = str4;
                                x7.a.f().A(this.H1);
                                intent = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
                                intent.putExtra("url", V);
                                intent.putExtra("CHANNEL_NUM", this.V2);
                                this.d.startActivity(intent);
                                view.getId();
                            }
                        } catch (Exception unused2) {
                        }
                        x7.a.f().A(this.H1);
                        intent = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
                        intent.putExtra("url", V);
                        intent.putExtra("CHANNEL_NUM", this.V2);
                        this.d.startActivity(intent);
                    }
                } else if (this.G1 != -1 && this.t2.booleanValue()) {
                    V = m7.w.V(this.d, this.G1, this.r0, "live");
                    x7.a.f().A(String.valueOf(this.G1));
                    intent = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
                    intent.putExtra("url", V);
                    intent.putExtra("CHANNEL_NUM", this.V2);
                    this.d.startActivity(intent);
                }
            }
        } else if (id == a7.f.I5) {
            if (this.e4.equals("tv")) {
                boolean playerIsPrepared = this.n2.getPlayerIsPrepared();
                z4();
                t4();
                if (playerIsPrepared) {
                    l3(1000);
                    this.n2.start();
                    this.O3.setVisibility(8);
                    this.P3.setVisibility(0);
                    imageView = this.P3;
                } else {
                    l3(5000);
                    this.O3.setVisibility(0);
                    imageView = this.O3;
                }
                imageView.requestFocus();
            } else {
                boolean playerIsPrepared2 = this.n2.getPlayerIsPrepared();
                z4();
                u4();
                if (playerIsPrepared2) {
                    m3(1000);
                    this.n2.start();
                    this.O3.setVisibility(8);
                    imageView2 = this.P3;
                } else {
                    m3(5000);
                    imageView2 = this.O3;
                }
                imageView2.setVisibility(0);
            }
        } else if (id == a7.f.H5) {
            try {
                if (this.e4.equals("tv")) {
                    z4();
                    t4();
                    this.n2.pause();
                    this.P3.setVisibility(8);
                    this.O3.setVisibility(0);
                    this.O3.requestFocus();
                } else {
                    z4();
                    u4();
                    this.n2.pause();
                    this.P3.setVisibility(8);
                    this.O3.setVisibility(0);
                }
            } catch (Exception e2) {
                str = "exection " + e2;
                str2 = "NSTIJPLAYERACTIVTY";
            }
        } else if (id == a7.f.x9) {
            try {
                AsyncTask asyncTask = this.D2;
                if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
                    this.D2.cancel(true);
                }
                this.z5 = Boolean.FALSE;
                this.U1.removeCallbacksAndMessages((Object) null);
                this.U1.postDelayed(new n(), 5000L);
                z4();
                u4();
                l3(5000);
                if (this.n2 != null) {
                    this.P1.removeCallbacksAndMessages((Object) null);
                    h4();
                    this.a1 = true;
                    int currentWindowIndex = this.n2.getCurrentWindowIndex();
                    ArrayList arrayList = this.F0;
                    if (arrayList != null && arrayList.size() > 1 && currentWindowIndex <= this.F0.size() - 1 && currentWindowIndex > -1) {
                        String name = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getName();
                        String num = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getNum();
                        this.V2 = m7.w.r0(((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getNum());
                        String url = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getUrl();
                        this.I1 = url;
                        String streamIcon = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getStreamIcon();
                        this.j5 = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getCategoryId();
                        this.m5 = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getName();
                        try {
                            if (streamIcon.equals("") || streamIcon.isEmpty()) {
                                this.C.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                            } else {
                                com.squareup.picasso.t.q(this.d).l(streamIcon).j(a7.e.i1).d(a7.e.i1).k(80, 55).g(this.C);
                            }
                        } catch (Exception unused3) {
                            this.C.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                        }
                        this.n2.setTitle(num + " - " + name);
                        this.Z1 = currentWindowIndex;
                        this.W1.clear();
                        this.W1.apply();
                        this.X1.clear();
                        this.X1.apply();
                        this.V1.clear();
                        this.V1.apply();
                        if (this.t2.booleanValue()) {
                            this.P1.postDelayed(new o(currentWindowIndex, name, url), SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api") ? 1000 : 200);
                        }
                        this.R1.removeCallbacksAndMessages((Object) null);
                        this.G1 = m7.w.q0(((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getStreamId());
                        this.H1 = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getStreamIdOneStream();
                        if (this.k2.equals("m3u")) {
                            f2 = x7.a.f();
                            valueOf = this.I1;
                        } else if (this.k2.equals("onestream_api")) {
                            f2 = x7.a.f();
                            valueOf = this.H1;
                        } else {
                            f2 = x7.a.f();
                            valueOf = String.valueOf(this.G1);
                        }
                        f2.A(valueOf);
                        if (this.K1 != null) {
                            if (this.k2.equals("onestream_api")) {
                                editor = this.K1;
                                valueOf2 = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getStreamIdOneStream();
                            } else {
                                editor = this.K1;
                                valueOf2 = String.valueOf(((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getStreamId());
                            }
                            editor.putString("currentlyPlayingVideo", valueOf2);
                            this.K1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", ((LiveStreamsDBModel) this.F0.get(currentWindowIndex)).getUrl());
                            this.K1.apply();
                        }
                        SharedPreferences.Editor editor2 = this.L1;
                        if (editor2 != null) {
                            editor2.putInt("currentlyPlayingVideoPosition", currentWindowIndex);
                            this.L1.apply();
                        }
                        if (this.G2 != 0) {
                            this.G2 = currentWindowIndex;
                        }
                    }
                }
            } catch (Exception e3) {
                str = "exection " + e3;
                str2 = "NSTIJPLAYERskyACTIVTY";
            }
        } else {
            if (id == a7.f.T8) {
                try {
                    AsyncTask asyncTask2 = this.D2;
                    if (asyncTask2 != null && asyncTask2.getStatus().equals(AsyncTask.Status.RUNNING)) {
                        this.D2.cancel(true);
                    }
                    this.z5 = Boolean.FALSE;
                    this.U1.removeCallbacksAndMessages((Object) null);
                    this.U1.postDelayed(new p(), 5000L);
                    z4();
                    u4();
                    l3(5000);
                    if (this.n2 != null) {
                        this.P1.removeCallbacksAndMessages((Object) null);
                        this.a1 = true;
                        X3();
                        int currentWindowIndex2 = this.n2.getCurrentWindowIndex();
                        ArrayList arrayList2 = this.F0;
                        if (arrayList2 != null && arrayList2.size() > 1 && currentWindowIndex2 <= this.F0.size() - 1 && currentWindowIndex2 > -1) {
                            String name2 = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex2)).getName();
                            String url2 = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex2)).getUrl();
                            this.I1 = url2;
                            String num2 = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex2)).getNum();
                            this.V2 = m7.w.r0(((LiveStreamsDBModel) this.F0.get(currentWindowIndex2)).getNum());
                            String streamIcon2 = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex2)).getStreamIcon();
                            this.j5 = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex2)).getCategoryId();
                            this.m5 = ((LiveStreamsDBModel) this.F0.get(currentWindowIndex2)).getName();
                            try {
                                if (streamIcon2.equals("") || streamIcon2.isEmpty()) {
                                    this.C.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                                } else {
                                    com.squareup.picasso.t.q(this.d).l(streamIcon2).j(a7.e.i1).d(a7.e.i1).k(80, 55).g(this.C);
                                }
                            } catch (Exception unused4) {
                                this.C.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                            }
                            this.n2.setTitle(num2 + " - " + name2);
                            this.Z1 = currentWindowIndex2;
                            this.W1.clear();
                            this.W1.apply();
                            this.X1.clear();
                            this.X1.apply();
                            this.V1.clear();
                            this.V1.apply();
                            if (this.t2.booleanValue()) {
                                this.P1.postDelayed(new q(currentWindowIndex2, name2, url2), SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api") ? 1000 : 200);
                            }
                            this.R1.removeCallbacksAndMessages((Object) null);
                            this.G1 = m7.w.q0(((LiveStreamsDBModel) this.F0.get(currentWindowIndex2)).getStreamId());
                            if (this.k2.equals("m3u")) {
                                f3 = x7.a.f();
                                valueOf3 = this.I1;
                            } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                                f3 = x7.a.f();
                                valueOf3 = String.valueOf(this.H1);
                            } else {
                                f3 = x7.a.f();
                                valueOf3 = String.valueOf(this.G1);
                            }
                            f3.A(valueOf3);
                            SharedPreferences.Editor editor3 = this.K1;
                            if (editor3 != null) {
                                editor3.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) this.F0.get(currentWindowIndex2)).getStreamId()));
                                this.K1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", ((LiveStreamsDBModel) this.F0.get(currentWindowIndex2)).getUrl());
                                this.K1.apply();
                            }
                            SharedPreferences.Editor editor4 = this.L1;
                            if (editor4 != null) {
                                editor4.putInt("currentlyPlayingVideoPosition", currentWindowIndex2);
                                this.L1.apply();
                            }
                            if (this.G2 != 0) {
                                this.G2 = currentWindowIndex2;
                            }
                        }
                    }
                } catch (Exception e4) {
                    str = "exection " + e4;
                    str2 = "NSTIJPLAYER";
                    Log.e(str2, str);
                    view.getId();
                }
            } else if (id != a7.f.x3 && id != a7.f.w3 && id != a7.f.z3 && id != a7.f.Qm) {
                if (id == a7.f.p) {
                    try {
                        A3();
                    } catch (Exception e5) {
                        str = "exection " + e5.getMessage();
                        str2 = "NSTIJPLAYER";
                        Log.e(str2, str);
                        view.getId();
                    }
                } else if (id == a7.f.Z6 || id == a7.f.C4) {
                    z4();
                    M3();
                    w4();
                } else if (id == a7.f.c7 || id == a7.f.E4 || id == a7.f.I4 || id == a7.f.J4) {
                    onBackPressed();
                    onBackPressed();
                } else if (id == a7.f.v7) {
                    z4();
                    M3();
                    p4("player", true);
                } else if (id == a7.f.B7) {
                    z4();
                    l3(5000);
                    NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv = this.n2;
                    if (nSTIJKPlayerSkyTv != null) {
                        nSTIJKPlayerSkyTv.G1();
                    }
                } else if (id == a7.f.if) {
                    imageView = this.N3;
                    imageView.requestFocus();
                } else if (view.getId() == a7.f.y7 || view.getId() == a7.f.S4) {
                    z4();
                    M3();
                    if (this.b5.getVisibility() == 8) {
                        this.b5.startAnimation(this.c4);
                        this.b5.setVisibility(0);
                        this.c5.requestFocus();
                        this.W4.requestFocus();
                        this.J4.setChecked(false);
                        this.K4.setChecked(false);
                        this.L4.setChecked(false);
                        this.M4.setChecked(false);
                        this.D4.setChecked(false);
                        this.E4.setChecked(false);
                        this.F4.setChecked(false);
                        this.G4.setChecked(false);
                        this.H4.setChecked(false);
                        this.z4.setChecked(false);
                        this.A4.setChecked(false);
                        this.B4.setChecked(false);
                        this.C4.setChecked(false);
                        this.V4.setText("");
                    }
                } else {
                    if (view.getId() == a7.f.x1) {
                        this.n5 = this.N4.getText().toString();
                        this.o5 = this.R4.getText().toString();
                        i3 = 0;
                        this.Z4.setVisibility(0);
                        this.v4.setVisibility(0);
                        i4 = 8;
                        this.u4.setVisibility(8);
                        this.w4.setVisibility(8);
                        this.h5.setVisibility(8);
                    } else if (view.getId() == a7.f.Jg) {
                        this.n5 = this.O4.getText().toString();
                        this.o5 = this.S4.getText().toString();
                        this.Z4.setVisibility(0);
                        i4 = 8;
                        this.v4.setVisibility(8);
                        this.h5.setVisibility(8);
                        this.u4.setVisibility(0);
                        this.V4.setVisibility(0);
                        this.w4.setVisibility(8);
                        this.I4.setVisibility(i4);
                        textView = this.y4;
                        resources = getResources();
                        i2 = a7.j.Q7;
                        textView.setText(resources.getString(i2));
                    } else if (view.getId() == a7.f.X) {
                        this.n5 = this.P4.getText().toString();
                        this.o5 = this.T4.getText().toString();
                        i3 = 0;
                        this.Z4.setVisibility(0);
                        i4 = 8;
                        this.v4.setVisibility(8);
                        this.u4.setVisibility(8);
                        this.h5.setVisibility(8);
                        this.w4.setVisibility(0);
                    } else if (view.getId() == a7.f.k) {
                        this.n5 = this.Q4.getText().toString();
                        this.o5 = this.U4.getText().toString();
                        this.Z4.setVisibility(0);
                        this.v4.setVisibility(8);
                        this.u4.setVisibility(8);
                        this.w4.setVisibility(8);
                        this.h5.setVisibility(8);
                        this.I4.setVisibility(0);
                        this.V4.setVisibility(0);
                        textView = this.y4;
                        resources = getResources();
                        i2 = a7.j.Q7;
                        textView.setText(resources.getString(i2));
                    } else if (view.getId() == a7.f.v2) {
                        this.Z4.setVisibility(0);
                        this.v4.setVisibility(8);
                        this.u4.setVisibility(8);
                        this.w4.setVisibility(8);
                        this.I4.setVisibility(8);
                        this.h5.setVisibility(0);
                        this.V4.setVisibility(4);
                        this.g5.setVisibility(0);
                        textView = this.y4;
                        resources = getResources();
                        i2 = a7.j.y0;
                        textView.setText(resources.getString(i2));
                    } else if (view.getId() == a7.f.tm) {
                        if (this.h5.getVisibility() == 0) {
                            try {
                                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getResources().getString(a7.j.z0))));
                            } catch (ActivityNotFoundException e6) {
                                Toast.makeText(this, "No application can handle this request. Please install a webbrowser", 1).show();
                                e6.printStackTrace();
                            }
                            this.b5.setVisibility(8);
                        } else {
                            this.q5 = this.V4.getText().toString();
                            p3();
                            if (this.D4.isChecked() || this.E4.isChecked() || this.F4.isChecked() || this.G4.isChecked() || this.H4.isChecked() || this.J4.isChecked() || this.K4.isChecked() || this.L4.isChecked() || this.M4.isChecked() || this.z4.isChecked() || this.A4.isChecked() || this.B4.isChecked() || this.C4.isChecked() || this.V4.length() > 0) {
                                u1();
                                this.J4.setChecked(false);
                                this.K4.setChecked(false);
                                this.L4.setChecked(false);
                                this.M4.setChecked(false);
                                this.D4.setChecked(false);
                                this.E4.setChecked(false);
                                this.F4.setChecked(false);
                                this.G4.setChecked(false);
                                this.H4.setChecked(false);
                                this.z4.setChecked(false);
                                this.A4.setChecked(false);
                                this.B4.setChecked(false);
                                this.C4.setChecked(false);
                                this.V4.setText("");
                                RelativeLayout relativeLayout = this.b5;
                                if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
                                    this.b5.setVisibility(8);
                                    this.Z4.setVisibility(8);
                                    this.Z4.startAnimation(this.b4);
                                    this.b5.startAnimation(this.b4);
                                    return;
                                }
                            } else {
                                Toast.makeText(this.d, "Please Add Report", 0).show();
                            }
                        }
                    }
                    this.V4.setVisibility(i3);
                    this.I4.setVisibility(i4);
                    textView = this.y4;
                    resources = getResources();
                    i2 = a7.j.Q7;
                    textView.setText(resources.getString(i2));
                }
            }
            Log.e(str2, str);
        }
        view.getId();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d3(configuration);
    }

    public void onCreate(Bundle bundle) {
        SharedPreferences.Editor editor;
        String valueOf;
        this.d = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(a7.g.B1);
        this.u = findViewById(a7.f.z7);
        this.u4 = findViewById(a7.f.Hg);
        this.v4 = findViewById(a7.f.w1);
        this.w4 = findViewById(a7.f.Z);
        this.x4 = findViewById(a7.f.ym);
        this.z4 = findViewById(a7.f.e2);
        this.A4 = findViewById(a7.f.g2);
        this.B4 = findViewById(a7.f.h2);
        this.C4 = findViewById(a7.f.f2);
        this.D4 = findViewById(a7.f.a2);
        this.E4 = findViewById(a7.f.c2);
        this.F4 = findViewById(a7.f.d2);
        this.G4 = findViewById(a7.f.b2);
        this.H4 = findViewById(a7.f.Z1);
        this.I4 = findViewById(a7.f.j);
        this.J4 = findViewById(a7.f.V1);
        this.K4 = findViewById(a7.f.X1);
        this.L4 = findViewById(a7.f.Y1);
        this.M4 = findViewById(a7.f.W1);
        this.y4 = findViewById(a7.f.tm);
        this.N4 = findViewById(a7.f.v1);
        this.O4 = findViewById(a7.f.Fg);
        this.P4 = findViewById(a7.f.a0);
        this.Q4 = findViewById(a7.f.l);
        this.R4 = findViewById(a7.f.y1);
        this.S4 = findViewById(a7.f.Lg);
        this.T4 = findViewById(a7.f.b0);
        this.U4 = findViewById(a7.f.m);
        this.V4 = findViewById(a7.f.K3);
        this.W4 = findViewById(a7.f.X3);
        this.X4 = findViewById(a7.f.y7);
        this.Y4 = findViewById(a7.f.xa);
        this.Z4 = findViewById(a7.f.a);
        this.a5 = findViewById(a7.f.S4);
        this.b5 = findViewById(a7.f.ee);
        this.c5 = findViewById(a7.f.x1);
        this.d5 = findViewById(a7.f.Jg);
        this.e5 = findViewById(a7.f.X);
        this.f5 = findViewById(a7.f.k);
        this.g5 = findViewById(a7.f.v2);
        this.h5 = findViewById(a7.f.u2);
        this.Z2 = findViewById(a7.f.Kg);
        this.a3 = findViewById(a7.f.Y);
        this.b3 = findViewById(a7.f.Gm);
        this.c3 = findViewById(a7.f.Wl);
        this.k3 = findViewById(a7.f.W3);
        this.l3 = findViewById(a7.f.Lf);
        this.m3 = findViewById(a7.f.Kf);
        this.n3 = findViewById(a7.f.j7);
        this.o3 = findViewById(a7.f.Ea);
        this.d3 = findViewById(a7.f.Mh);
        this.e3 = findViewById(a7.f.mm);
        this.p3 = findViewById(a7.f.h9);
        this.I3 = findViewById(a7.f.lf);
        this.J3 = findViewById(a7.f.ne);
        this.K3 = findViewById(a7.f.oe);
        this.f3 = findViewById(a7.f.uk);
        this.g3 = findViewById(a7.f.Ak);
        this.h3 = findViewById(a7.f.Ck);
        this.q3 = findViewById(a7.f.t9);
        this.O3 = findViewById(a7.f.I5);
        this.P3 = findViewById(a7.f.H5);
        this.r3 = findViewById(a7.f.b7);
        this.Q3 = findViewById(a7.f.I4);
        this.R3 = findViewById(a7.f.J4);
        this.S3 = findViewById(a7.f.E4);
        this.s3 = findViewById(a7.f.c7);
        this.T3 = findViewById(a7.f.C4);
        this.t3 = findViewById(a7.f.B7);
        this.u3 = findViewById(a7.f.Y6);
        this.v3 = findViewById(a7.f.S8);
        this.w3 = findViewById(a7.f.v7);
        this.x3 = findViewById(a7.f.x9);
        this.y3 = findViewById(a7.f.T8);
        this.i3 = findViewById(a7.f.lj);
        this.z3 = findViewById(a7.f.va);
        this.A3 = findViewById(a7.f.ya);
        this.B3 = findViewById(a7.f.wa);
        this.C3 = findViewById(a7.f.i7);
        this.L3 = findViewById(a7.f.Fd);
        this.M3 = findViewById(a7.f.Gd);
        this.N3 = findViewById(a7.f.m3);
        this.D3 = findViewById(a7.f.W8);
        this.E3 = findViewById(a7.f.X8);
        this.H3 = findViewById(a7.f.if);
        this.F3 = findViewById(a7.f.x7);
        this.U3 = findViewById(a7.f.W5);
        this.j3 = findViewById(a7.f.ah);
        this.G3 = findViewById(a7.f.Z6);
        if (!m7.a.V0.booleanValue()) {
            this.Y4.setVisibility(4);
        }
        overridePendingTransition(a7.b.f, a7.b.d);
        T3();
        RelativeLayout relativeLayout = this.e1;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new k());
        }
        this.J0 = H3();
        if (this.K1 != null) {
            if (this.k2.equals("onestream_api")) {
                editor = this.K1;
                valueOf = this.y2;
            } else {
                editor = this.K1;
                valueOf = String.valueOf(this.x2);
            }
            editor.putString("currentlyPlayingVideo", valueOf);
            this.K1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "0");
            this.K1.apply();
        }
        this.g0.deleteExtraLiveRecentlyWatched();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
            try {
                this.n = SharepreferenceDBHandler.getStalkerToken(this.d);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.d);
                this.o = loggedInMacAddress;
                this.m.f(loggedInMacAddress, this.n, 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (this.p4.equals("false")) {
            m4();
        } else {
            String str = this.j1;
            this.W2 = str;
            this.s4 = str;
            q7.N n2 = new q7.N(this.d, str, "", this.q4, this.p4);
            this.g4 = n2;
            this.X2 = this.W2;
            this.M3.setAdapter(n2);
            this.M3.setLayoutManager(this.k4);
            h3(true);
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
            m7.w.Z(this.d);
        }
        F3();
        String I1 = FreeTrailActivity.I1();
        this.l5 = I1;
        if (I1.equals("") || this.l5.isEmpty()) {
            this.l5 = m7.w.I(this.d);
        }
        this.J4.setOnCheckedChangeListener(this);
        this.K4.setOnCheckedChangeListener(this);
        this.L4.setOnCheckedChangeListener(this);
        this.M4.setOnCheckedChangeListener(this);
        this.D4.setOnCheckedChangeListener(this);
        this.E4.setOnCheckedChangeListener(this);
        this.F4.setOnCheckedChangeListener(this);
        this.G4.setOnCheckedChangeListener(this);
        this.H4.setOnCheckedChangeListener(this);
        this.z4.setOnCheckedChangeListener(this);
        this.A4.setOnCheckedChangeListener(this);
        this.B4.setOnCheckedChangeListener(this);
        this.C4.setOnCheckedChangeListener(this);
        this.x4.setOnClickListener(new w());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.T0.x(a7.h.r);
        this.g2 = menu;
        this.h2 = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("api")) {
            menu.getItem(2).getSubMenu().findItem(a7.f.gb).setVisible(false);
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
            menu.getItem(2).getSubMenu().findItem(a7.f.gb).setVisible(true);
        }
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, this.d.getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.T0.getChildCount(); i2++) {
            if (this.T0.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.T0.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            q3();
            i4();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            Thread thread = this.u5;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.u5.interrupt();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        keyEvent.getRepeatCount();
        keyEvent.getAction();
        if (G5 && this.C3.getVisibility() == 8 && this.I3.getVisibility() == 8 && this.K3.getVisibility() == 8 && this.b5.getVisibility() == 8) {
            if (i2 == 20) {
                if (this.t2.booleanValue()) {
                    findViewById(a7.f.x9).performClick();
                }
                return true;
            }
            if (i2 == 19) {
                if (this.t2.booleanValue()) {
                    findViewById(a7.f.T8).performClick();
                }
                return true;
            }
        }
        if (i2 == 166) {
            if (G5 && this.t2.booleanValue()) {
                findViewById(a7.f.T8).performClick();
            }
            return true;
        }
        if (i2 != 167) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (G5 && this.t2.booleanValue()) {
            findViewById(a7.f.x9).performClick();
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv;
        StringBuilder sb;
        boolean z2 = keyEvent.getRepeatCount() == 0;
        if (i2 != 62) {
            if (i2 != 66) {
                if (i2 != 79) {
                    if (i2 == 82) {
                        Menu menu = this.g2;
                        if (menu != null) {
                            menu.performIdentifierAction(a7.f.P2, 0);
                        }
                        return true;
                    }
                    if (i2 != 85 && i2 != 86 && i2 != 126 && i2 != 127) {
                        switch (i2) {
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                                if (G5 && !SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                                    this.T1.removeCallbacksAndMessages((Object) null);
                                    int i3 = 7;
                                    if (i2 == 7) {
                                        this.a2.append(0);
                                    } else if (i2 == 8) {
                                        this.a2.append(1);
                                    } else {
                                        if (i2 == 9) {
                                            sb = this.a2;
                                            i3 = 2;
                                        } else if (i2 == 10) {
                                            sb = this.a2;
                                            i3 = 3;
                                        } else if (i2 == 11) {
                                            sb = this.a2;
                                            i3 = 4;
                                        } else if (i2 == 12) {
                                            sb = this.a2;
                                            i3 = 5;
                                        } else if (i2 == 13) {
                                            sb = this.a2;
                                            i3 = 6;
                                        } else if (i2 == 14) {
                                            sb = this.a2;
                                        } else if (i2 == 15) {
                                            this.a2.append(8);
                                        } else if (i2 == 16) {
                                            this.a2.append(9);
                                        }
                                        sb.append(i3);
                                    }
                                    this.c2.setText(this.a2.toString());
                                    this.b2.setVisibility(0);
                                    this.T1.postDelayed(new m(), 3000L);
                                }
                                return true;
                            default:
                                switch (i2) {
                                    case 19:
                                        z4();
                                        l3(5000);
                                        this.b5.getVisibility();
                                        return true;
                                    case 20:
                                        z4();
                                        l3(5000);
                                        this.b5.getVisibility();
                                        return true;
                                    case 21:
                                        z4();
                                        l3(5000);
                                        if (this.b5.getVisibility() != 0 && G5 && this.q3.getVisibility() == 8 && this.K3.getVisibility() == 8) {
                                            p4("player", true);
                                        }
                                        return true;
                                    case 22:
                                        z4();
                                        l3(5000);
                                        this.b5.getVisibility();
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
            if (G5 && this.b5.getVisibility() == 8) {
                NSTIJKPlayerSkyTv nSTIJKPlayerSkyTv2 = this.n2;
                if (nSTIJKPlayerSkyTv2 == null || !nSTIJKPlayerSkyTv2.getPlayerIsPrepared()) {
                    A4();
                } else if (this.I3.getVisibility() == 8) {
                    A4();
                    (this.n2.isPlaying() ? this.P3 : this.O3).requestFocus();
                }
            }
            return true;
        }
        if (this.t2.booleanValue() && (nSTIJKPlayerSkyTv = this.n2) != null && nSTIJKPlayerSkyTv.getPlayerIsPrepared()) {
            ((!z2 || this.n2.isPlaying()) ? this.P3 : this.O3).performClick();
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.h2 = menuItem;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.d) != null) {
            new a.a(context, a7.k.a).setTitle(this.d.getResources().getString(a7.j.f3)).f(this.d.getResources().getString(a7.j.e3)).j(this.d.getResources().getString(a7.j.S8), new v()).g(this.d.getResources().getString(a7.j.d4), new u()).n();
        }
        if (itemId == a7.f.g) {
            try {
                SearchView actionView = menuItem.getActionView();
                this.U0 = actionView;
                if (actionView != null) {
                    actionView.setQueryHint(getResources().getString(a7.j.A6));
                    this.U0.setIconifiedByDefault(false);
                    ImageView findViewById = this.U0.findViewById(a7.f.Uf);
                    this.U0.findViewById(a7.f.Vf).setImageResource(a7.e.m1);
                    findViewById.setImageResource(a7.e.m1);
                    findViewById.setPadding(15, 15, 15, 15);
                    findViewById.setBackground((Drawable) null);
                    this.U0.setOnQueryTextListener(new y());
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        if (itemId == a7.f.gb) {
            m7.w.A0(this.d);
        }
        if (itemId == a7.f.mb) {
            x4(this);
        }
        if (itemId == a7.f.Db) {
            q4();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        Handler handler;
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.y5;
            if (thread != null && thread.isAlive()) {
                this.y5.interrupt();
            }
        } catch (Exception unused) {
        }
        try {
            if (this.z5.booleanValue() || (handler = this.U1) == null) {
                return;
            }
            handler.removeCallbacksAndMessages((Object) null);
        } catch (Exception unused2) {
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.e*/.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 101) {
            return;
        }
        try {
            if (iArr.length > 0 && iArr[0] == 0) {
                U3();
            } else if (Build.VERSION.SDK_INT >= 23 && !t7.h.a(this, strArr[0])) {
                a.a aVar = new a.a(this, a7.k.a);
                View inflate = LayoutInflater.from(this).inflate(a7.g.W3, (ViewGroup) null);
                Button findViewById = inflate.findViewById(a7.f.c1);
                Button findViewById2 = inflate.findViewById(a7.f.U0);
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
                findViewById.setOnClickListener(new A());
                findViewById2.setOnClickListener(new B());
                aVar.setView(inflate);
                this.r2 = aVar.create();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.r2.getWindow();
                Objects.requireNonNull(window);
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                this.r2.show();
                this.r2.getWindow().setAttributes(layoutParams);
                this.r2.setCancelable(false);
                this.r2.show();
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.y5;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new E());
            this.y5 = thread2;
            thread2.start();
        }
        m7.w.m(this.d);
        if (this.H2) {
            this.H2 = false;
            y4();
        }
    }

    public void onStop() {
        super.onStop();
        try {
            i4();
        } catch (Exception unused) {
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super/*android.app.Activity*/.onWindowFocusChanged(z2);
        if (z2) {
            d3(getResources().getConfiguration());
        }
    }

    public void p3() {
        this.r5 = new ArrayList();
        this.s5 = new JsonArray();
        if (this.D4.isChecked()) {
            this.r5.add(this.D4.getText().toString());
            this.s5.add(this.D4.getText().toString());
        }
        if (this.E4.isChecked()) {
            this.r5.add(this.E4.getText().toString());
            this.s5.add(this.E4.getText().toString());
        }
        if (this.F4.isChecked()) {
            this.r5.add(this.F4.getText().toString());
            this.s5.add(this.F4.getText().toString());
        }
        if (this.G4.isChecked()) {
            this.r5.add(this.G4.getText().toString());
            this.s5.add(this.G4.getText().toString());
        }
        if (this.H4.isChecked()) {
            this.r5.add(this.H4.getText().toString());
            this.s5.add(this.H4.getText().toString());
        }
        if (this.z4.isChecked()) {
            this.r5.add(this.z4.getText().toString());
            this.s5.add(this.z4.getText().toString());
        }
        if (this.A4.isChecked()) {
            this.r5.add(this.A4.getText().toString());
            this.s5.add(this.A4.getText().toString());
        }
        if (this.B4.isChecked()) {
            this.r5.add(this.B4.getText().toString());
            this.s5.add(this.B4.getText().toString());
        }
        if (this.C4.isChecked()) {
            this.r5.add(this.C4.getText().toString());
            this.s5.add(this.C4.getText().toString());
        }
        if (this.J4.isChecked()) {
            this.r5.add(this.J4.getText().toString());
            this.s5.add(this.J4.getText().toString());
        }
        if (this.K4.isChecked()) {
            this.r5.add(this.K4.getText().toString());
            this.s5.add(this.K4.getText().toString());
        }
        if (this.L4.isChecked()) {
            this.r5.add(this.L4.getText().toString());
            this.s5.add(this.L4.getText().toString());
        }
        if (this.M4.isChecked()) {
            this.r5.add(this.M4.getText().toString());
            this.s5.add(this.M4.getText().toString());
        }
        this.t5 = new Gson().toJson(this.s5);
        Log.e("TAG", this.s5 + "");
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public void t4() {
        View view;
        if (this.I3.getVisibility() == 8 && this.q3.getVisibility() == 8) {
            this.S1.removeCallbacksAndMessages((Object) null);
            B4(this.T);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                C4(String.valueOf(this.G1));
            } else {
                this.D2 = new K(this, this.S, null).execute(new String[0]);
            }
            this.R1.removeCallbacksAndMessages((Object) null);
            this.q3.startAnimation(this.a4);
            this.C3.startAnimation(this.a4);
            this.A3.startAnimation(this.a4);
            Boolean bool = m7.a.V0;
            if (bool.booleanValue()) {
                this.Y4.startAnimation(this.a4);
            }
            this.B3.startAnimation(this.a4);
            this.C3.setVisibility(0);
            this.A3.setVisibility(0);
            if (bool.booleanValue()) {
                this.Y4.setVisibility(0);
            }
            this.B3.setVisibility(0);
            this.q3.setVisibility(0);
            try {
                View view2 = this.t;
                if (view2 == null || view2.getVisibility() != 0) {
                    View view3 = this.s;
                    if (view3 == null || view3.getVisibility() != 0) {
                        return;
                    } else {
                        view = this.s;
                    }
                } else {
                    view = this.t;
                }
                view.requestFocus();
            } catch (Exception unused) {
            }
        }
    }

    public void toggleView(View view) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
        } else if (view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    public void u(StalkerCreatePlayerLinkCallback stalkerCreatePlayerLinkCallback, View view, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, String str7, String str8) {
        try {
            m7.w.X();
            if (stalkerCreatePlayerLinkCallback == null || stalkerCreatePlayerLinkCallback.getJs() == null || stalkerCreatePlayerLinkCallback.getJs().getCmd() == null || stalkerCreatePlayerLinkCallback.getJs().getId() == null) {
                return;
            }
            String cmd = stalkerCreatePlayerLinkCallback.getJs().getCmd();
            this.h = cmd;
            String[] split = cmd.split("ffmpeg ", 0);
            if (split.length == 2) {
                this.i = split[1];
            }
            if (str6.equals("playFirstTime")) {
                g4(this.E0);
                if (this.a1 && this.b1 && !this.c1.equals("")) {
                    this.G2 = 0;
                    try {
                        this.G2 = G3(this.E0, m7.w.r0(this.c1));
                    } catch (NumberFormatException | Exception unused) {
                    }
                    this.a1 = false;
                    this.b1 = false;
                }
                o4(this.E0);
                return;
            }
            if (str6.equals("channel_click")) {
                d4(this.j, this.e);
                return;
            }
            if (str6.equals("channel_click_from_player")) {
                e4(this.k, this.f);
            } else if (str6.equals("zappingRight")) {
                E4(i4, str7, str8);
            } else if (str6.equals("zappingLeft")) {
                D4(i4, str7, str8);
            }
        } catch (Exception unused2) {
        }
    }

    public void u4() {
        if (this.q3.getVisibility() == 8) {
            this.q3.startAnimation(this.a4);
            this.q3.setVisibility(0);
            if (this.n3.getVisibility() == 8) {
                this.n3.startAnimation(this.a4);
                this.n3.setVisibility(0);
            }
            if (this.p3.getVisibility() == 8) {
                this.p3.startAnimation(this.a4);
                this.p3.setVisibility(0);
            }
            if (this.o3.getVisibility() == 8) {
                this.o3.startAnimation(this.a4);
                this.o3.setVisibility(0);
            }
        }
    }

    public void v0(String str) {
        try {
            StalkerLiveFavIdsSingleton.getInstance().setFavIdsList((List) null);
            this.m.i(this.o, this.n);
        } catch (Exception unused) {
        }
    }

    public void w3() {
        runOnUiThread(new C());
    }

    /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
        LL1ili1iI1iI.IIiLliI1l1li1: Can't find top splitter block for handler:B:255:0x0113
        	at ILlL1lil1i1i.LLll11I1I1lL.llLliLLIll1lI(Unknown Source:36)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(Unknown Source:67)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(Unknown Source:9)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:40)
        */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131 A[Catch: Exception -> 0x0329, TryCatch #5 {Exception -> 0x0329, blocks: (B:3:0x0008, B:6:0x0016, B:8:0x001e, B:10:0x0024, B:12:0x0032, B:14:0x0038, B:16:0x0040, B:18:0x0046, B:20:0x004a, B:21:0x004d, B:23:0x0053, B:25:0x0057, B:27:0x005f, B:29:0x0065, B:30:0x0075, B:53:0x012b, B:55:0x0131, B:57:0x0139, B:79:0x01a9, B:81:0x01ad, B:82:0x01b0, B:84:0x01b4, B:105:0x0221, B:107:0x0225, B:108:0x0228, B:110:0x022c, B:134:0x029a, B:136:0x029e, B:137:0x02a1, B:139:0x02a5, B:164:0x0317, B:166:0x031b, B:167:0x031e, B:169:0x0322, B:177:0x0310, B:179:0x0314, B:184:0x02eb, B:186:0x02ef, B:191:0x02c6, B:193:0x02ca, B:197:0x0293, B:199:0x0297, B:203:0x0270, B:205:0x0274, B:210:0x024c, B:212:0x0250, B:217:0x021a, B:219:0x021e, B:223:0x01f6, B:225:0x01fa, B:229:0x01d3, B:231:0x01d7, B:236:0x01a2, B:238:0x01a6, B:243:0x017e, B:245:0x0182, B:249:0x015b, B:251:0x015f, B:252:0x0326, B:255:0x0113, B:259:0x00ea, B:261:0x00c4, B:263:0x009b, B:264:0x0119, B:265:0x011f, B:266:0x0125, B:158:0x02f4, B:160:0x02fa, B:162:0x02fe, B:174:0x0308, B:176:0x030c, B:121:0x0254, B:123:0x025a, B:125:0x025e, B:200:0x0268, B:202:0x026c, B:113:0x0230, B:115:0x0236, B:117:0x023a, B:207:0x0244, B:209:0x0248, B:150:0x02cf, B:152:0x02d5, B:154:0x02d9, B:181:0x02e3, B:183:0x02e7, B:42:0x00c9, B:44:0x00cf, B:45:0x00d7, B:258:0x00db, B:92:0x01da, B:94:0x01e0, B:96:0x01e4, B:220:0x01ee, B:222:0x01f2, B:129:0x0277, B:131:0x027d, B:133:0x0281, B:194:0x028b, B:196:0x028f, B:86:0x01b7, B:88:0x01bd, B:90:0x01c1, B:226:0x01cb, B:228:0x01cf, B:48:0x00fb, B:50:0x0101, B:256:0x010d, B:66:0x0162, B:68:0x0168, B:70:0x016c, B:239:0x0176, B:241:0x017a, B:60:0x013f, B:62:0x0145, B:64:0x0149, B:246:0x0153, B:248:0x0157, B:32:0x007a, B:34:0x0080, B:35:0x0088, B:262:0x008c, B:99:0x01fe, B:101:0x0204, B:103:0x0208, B:214:0x0212, B:216:0x0216, B:142:0x02aa, B:144:0x02b0, B:146:0x02b4, B:188:0x02be, B:190:0x02c2, B:38:0x00ac, B:40:0x00b2, B:260:0x00be, B:73:0x0186, B:75:0x018c, B:77:0x0190, B:233:0x019a, B:235:0x019e), top: B:2:0x0008, inners: #0, #1, #2, #3, #4, #6, #7, #8, #9, #10, #11, #12, #13, #14, #15, #16 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:248:0x015d -> B:64:0x0162). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:249:0x015f -> B:64:0x0162). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void x3(java.util.HashMap r12) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.x3(java.util.HashMap):void");
    }

    public void y0(String str) {
    }

    public void y3() {
        try {
            W3();
            LinearLayout linearLayout = this.y1;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.A1;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            LinearLayout linearLayout3 = this.B1;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            LinearLayout linearLayout4 = this.C1;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            LinearLayout linearLayout5 = this.D1;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            LinearLayout linearLayout6 = this.E1;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
        } catch (Exception unused) {
        }
    }

    public void z4() {
        Handler handler = this.n2.Z0;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void I(m0.x xVar, int i2) {
    }

    public void O(Z.E e2, int i2) {
    }

    public void G(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, Z.E e2, int i2) {
    }

    public void V0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, m0.x xVar, int i2) {
    }
}
