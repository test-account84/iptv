package com.nst.iptvsmarterstvbox.view.demo;

import O2.G1;
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
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
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
import b4.o;
import com.google.android.exoplayer2.ui.PlayerView;
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
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerMultiActivity;
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
import p3.B;
import p3.u;
import q7.Z;
import q7.m0;
import q7.t;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTEXOPlayerSkyTvActivity extends androidx.appcompat.app.b implements SurfaceHolder.Callback, View.OnClickListener, z7.j, z7.g, CompoundButton.OnCheckedChangeListener {
    public static SharedPreferences J5 = null;
    public static SharedPreferences K5 = null;
    public static boolean L5 = false;
    public static String M5;
    public static String N5;
    public static final int[] O5 = {0, 1, 2, 3, 4, 5};
    public static ProgressBar P5;
    public ArrayList A0;
    public TextView A1;
    public Boolean A2;
    public LinearLayout A3;
    public boolean A4;
    public String A5;
    public ArrayList B0;
    public String B1;
    public Boolean B2;
    public LinearLayout B3;
    public SharedPreferences B4;
    public String B5;
    public SharedPreferences C0;
    public TextView C1;
    public Boolean C2;
    public Animation C3;
    public String C4;
    public List C5;
    public int D;
    public SharedPreferences.Editor D0;
    public Handler D1;
    public Boolean D2;
    public Animation D3;
    public String D4;
    public JsonArray D5;
    public String E;
    public ArrayList E0;
    public Handler E1;
    public Boolean E2;
    public Animation E3;
    public RelativeLayout E4;
    public String E5;
    public String F;
    public ArrayList F0;
    public Handler F1;
    public u7.a F2;
    public Animation F3;
    public RelativeLayout F4;
    public String F5;
    public String G;
    public RecyclerView G0;
    public Handler G1;
    public Handler G2;
    public Animation G3;
    public RelativeLayout G4;
    public int G5;
    public RelativeLayout H;
    public ProgressBar H0;
    public Handler H1;
    public Handler H2;
    public Animation H3;
    public TextView H4;
    public Thread H5;
    public ListView I;
    public Toolbar I0;
    public Handler I1;
    public ArrayList I2;
    public Animation I3;
    public CheckBox I4;
    public ArrayList I5;
    public ListView J;
    public SearchView J0;
    public SharedPreferences.Editor J1;
    public int J2;
    public Animation J3;
    public CheckBox J4;
    public TextView K0;
    public SharedPreferences.Editor K1;
    public String K2;
    public Animation K3;
    public CheckBox K4;
    public ArrayList L;
    public LinearLayout L0;
    public SharedPreferences.Editor L1;
    public String L2;
    public String L3;
    public CheckBox L4;
    public ArrayList M;
    public LinearLayout M0;
    public TextView M1;
    public Boolean M2;
    public q7.N M3;
    public CheckBox M4;
    public AppBarLayout N0;
    public SeekBar N2;
    public q7.N N3;
    public CheckBox N4;
    public SeekBar O2;
    public q7.O O3;
    public CheckBox O4;
    public String P;
    public LinearLayout P1;
    public LinearLayout P2;
    public q7.P P3;
    public CheckBox P4;
    public TextView Q1;
    public LinearLayout Q2;
    public LinearLayoutManager Q3;
    public CheckBox Q4;
    public LiveStreamDBHandler R;
    public String R0;
    public LinearLayout R2;
    public LinearLayoutManager R3;
    public RelativeLayout R4;
    public SharedPreferences S;
    public Boolean S1;
    public LinearLayout S2;
    public int S3;
    public CheckBox S4;
    public SharedPreferences T;
    public RelativeLayout T0;
    public Boolean T1;
    public LinearLayout T2;
    public Animation T3;
    public CheckBox T4;
    public SharedPreferences U;
    public LinearLayout U0;
    public Menu U1;
    public LinearLayout U2;
    public Animation U3;
    public CheckBox U4;
    public SharedPreferences V;
    public RelativeLayout V0;
    public MenuItem V1;
    public LinearLayout V2;
    public String V3;
    public CheckBox V4;
    public SharedPreferences W;
    public RelativeLayout W0;
    public DateFormat W1;
    public LinearLayout W2;
    public String W3;
    public TextView W4;
    public SharedPreferences X;
    public RelativeLayout X0;
    public String X1;
    public RelativeLayout X2;
    public String X3;
    public LinearLayout X4;
    public SharedPreferences Y;
    public String Y1;
    public RelativeLayout Y2;
    public String Y3;
    public TextView Y4;
    public SharedPreferences Z;
    public String Z1;
    public RelativeLayout Z2;
    public int Z3;
    public TextView Z4;
    public TextView a1;
    public SimpleDateFormat a2;
    public ImageView a3;
    public n7.g a4;
    public TextView a5;
    public TextView b1;
    public PlayerView b2;
    public ImageView b3;
    public String b4;
    public TextView b5;
    public TextView c1;
    public Date c2;
    public ImageView c3;
    public String c4;
    public TextView c5;
    public TextView d1;
    public String d2;
    public ImageView d3;
    public int d4;
    public TextView d5;
    public SharedPreferences e0;
    public String e1;
    public Boolean e2;
    public ImageView e3;
    public int e4;
    public TextView e5;
    public Context f;
    public SimpleDateFormat f0;
    public TextView f1;
    public androidx.appcompat.app.a f2;
    public ImageView f3;
    public List f4;
    public TextView f5;
    public String g;
    public String g0;
    public TextView g1;
    public String g2;
    public ImageView g3;
    public n7.e g4;
    public EditText g5;
    public View h;
    public RelativeLayout h0;
    public TextView h1;
    public Boolean h2;
    public TextView h3;
    public int h4;
    public LinearLayout h5;
    public View i;
    public TextView i1;
    public D7.b i2;
    public TextView i3;
    public boolean i4;
    public LinearLayout i5;
    public View j;
    public TextView j0;
    public TextView j1;
    public String j2;
    public TextView j3;
    public boolean j4;
    public LinearLayout j5;
    public String k;
    public ArrayList k0;
    public TextView k1;
    public int k2;
    public TextView k3;
    public MultiUserDBHandler k4;
    public LinearLayout k5;
    public View l;
    public ArrayList l0;
    public TextView l1;
    public int l2;
    public LinearLayout l3;
    public Thread l4;
    public ImageView l5;
    public View m;
    public ArrayList m0;
    public TextView m1;
    public String m2;
    public LinearLayout m3;
    public Boolean m4;
    public RelativeLayout m5;
    public ArrayList n0;
    public LinearLayout n1;
    public Boolean n2;
    public LinearLayout n3;
    public boolean n4;
    public LinearLayout n5;
    public LinearLayout o;
    public ArrayList o0;
    public String o1;
    public AsyncTask o2;
    public LinearLayout o3;
    public String o4;
    public LinearLayout o5;
    public TextView p;
    public ArrayList p0;
    public LinearLayout p1;
    public AsyncTask p2;
    public LinearLayout p3;
    public String p4;
    public LinearLayout p5;
    public ImageView q;
    public ArrayList q0;
    public LinearLayout q1;
    public AsyncTask q2;
    public LinearLayout q3;
    public int q4;
    public LinearLayout q5;
    public TextView r;
    public ArrayList r0;
    public LinearLayout r1;
    public ProgressDialog r2;
    public LinearLayout r3;
    public I1 r4;
    public LinearLayout r5;
    public TextView s;
    public ArrayList s0;
    public LinearLayout s1;
    public boolean s2;
    public LinearLayout s3;
    public o.a s4;
    public RelativeLayout s5;
    public TextView t;
    public ArrayList t0;
    public LinearLayout t1;
    public int t2;
    public LinearLayout t3;
    public Z3.m t4;
    public String t5;
    public TextView u;
    public ArrayList u0;
    public String u1;
    public boolean u2;
    public RecyclerView u3;
    public m.d u4;
    public String u5;
    public LinearLayout v;
    public ArrayList v0;
    public int v2;
    public RecyclerView v3;
    public Uri v4;
    public String v5;
    public ProgressBar w;
    public ArrayList w0;
    public int w2;
    public EditText w3;
    public int w4;
    public String w5;
    public LinearLayout x;
    public ArrayList x0;
    public DatabaseHandler x1;
    public SharedPreferences x2;
    public LinearLayout x3;
    public int x4;
    public String x5;
    public LinearLayout y;
    public ArrayList y0;
    public SharedPreferences.Editor y1;
    public SharedPreferences.Editor y2;
    public LinearLayout y3;
    public boolean y4;
    public String y5;
    public SharedPreferences.Editor z1;
    public Boolean z2;
    public RelativeLayout z3;
    public boolean z4;
    public String z5;
    public String d = "";
    public String e = "";
    public boolean n = false;
    public boolean z = true;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public ArrayList K = new ArrayList();
    public boolean N = true;
    public long O = 2500;
    public boolean Q = true;
    public int i0 = 0;
    public ArrayList z0 = new ArrayList();
    public boolean O0 = true;
    public boolean P0 = false;
    public boolean Q0 = false;
    public boolean S0 = true;
    public String Y0 = "";
    public String Z0 = "";
    public int v1 = -1;
    public String w1 = "";
    public int N1 = 0;
    public StringBuilder O1 = new StringBuilder();
    public int R1 = -1;

    public class A implements Runnable {
        public final /* synthetic */ LinearLayout a;

        public A(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        public void run() {
            LinearLayout linearLayout;
            this.a.setVisibility(8);
            if (NSTEXOPlayerSkyTvActivity.this.S2.getVisibility() != 0 || (linearLayout = NSTEXOPlayerSkyTvActivity.this.R2) == null) {
                return;
            }
            linearLayout.setVisibility(0);
        }
    }

    public class B implements Callback {
        public B() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("onFailure", th.getMessage().toString());
        }

        public void onResponse(Call call, Response response) {
            Toast makeText;
            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity;
            String message;
            if (response == null) {
                makeText = Toast.makeText(NSTEXOPlayerSkyTvActivity.this, "Something went Wrong Report not Submitted", 0);
            } else {
                if (response.body() == null || !response.isSuccessful()) {
                    if (response.message() != null && !response.message().equals("")) {
                        nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                        message = response.message();
                    }
                    makeText = Toast.makeText(NSTEXOPlayerSkyTvActivity.this, "Something went Wrong Report not Submitted", 0);
                } else if (((ClientFeedbackCallback) response.body()).a() == null || !((ClientFeedbackCallback) response.body()).a().equalsIgnoreCase("success")) {
                    nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                    message = "Something went Wrong";
                } else {
                    nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                    message = "Reported Successfully";
                }
                makeText = Toast.makeText(nSTEXOPlayerSkyTvActivity, message, 0);
            }
            makeText.show();
        }
    }

    public class C implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AdapterView e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;
        public final /* synthetic */ ArrayList h;
        public final /* synthetic */ Dialog i;

        public C(String str, String str2, String str3, AdapterView adapterView, int i, long j, ArrayList arrayList, Dialog dialog) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = adapterView;
            this.f = i;
            this.g = j;
            this.h = arrayList;
            this.i = dialog;
        }

        public void onClick(View view) {
            if (m7.a.b) {
                NSTEXOPlayerSkyTvActivity.b3(NSTEXOPlayerSkyTvActivity.this, this.a, this.c, this.d);
            }
            NSTEXOPlayerSkyTvActivity.t2(NSTEXOPlayerSkyTvActivity.this, this.e, view, this.f, this.g, this.h);
            this.i.dismiss();
        }
    }

    public class D implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AdapterView e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;
        public final /* synthetic */ ArrayList h;
        public final /* synthetic */ Dialog i;

        public D(String str, String str2, String str3, AdapterView adapterView, int i, long j, ArrayList arrayList, Dialog dialog) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = adapterView;
            this.f = i;
            this.g = j;
            this.h = arrayList;
            this.i = dialog;
        }

        public void onClick(View view) {
            if (m7.a.b) {
                NSTEXOPlayerSkyTvActivity.b3(NSTEXOPlayerSkyTvActivity.this, this.a, this.c, this.d);
            }
            NSTEXOPlayerSkyTvActivity.t2(NSTEXOPlayerSkyTvActivity.this, this.e, view, this.f, this.g, this.h);
            this.i.dismiss();
        }
    }

    public class E implements View.OnClickListener {
        public E() {
        }

        public void onClick(View view) {
            try {
                NSTEXOPlayerSkyTvActivity.this.e2 = Boolean.TRUE;
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", NSTEXOPlayerSkyTvActivity.this.getPackageName(), (String) null));
                NSTEXOPlayerSkyTvActivity.this.startActivityForResult(intent, 101);
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                Toast.makeText(nSTEXOPlayerSkyTvActivity, nSTEXOPlayerSkyTvActivity.f.getResources().getString(a7.j.o2), 1).show();
            } catch (Exception unused) {
            }
            NSTEXOPlayerSkyTvActivity.Y2(NSTEXOPlayerSkyTvActivity.this).dismiss();
        }
    }

    public class F implements View.OnClickListener {
        public F() {
        }

        public void onClick(View view) {
            NSTEXOPlayerSkyTvActivity.Y2(NSTEXOPlayerSkyTvActivity.this).dismiss();
        }
    }

    public class G implements Runnable {

        public class a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ String c;

            public a(String str, String str2) {
                this.a = str;
                this.c = str2;
            }

            public void run() {
                try {
                    TextView textView = NSTEXOPlayerSkyTvActivity.this.C1;
                    if (textView != null) {
                        textView.setText(this.a);
                    }
                    TextView textView2 = NSTEXOPlayerSkyTvActivity.this.A1;
                    if (textView2 != null) {
                        textView2.setText(this.c);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public G() {
        }

        public void run() {
            String date = Calendar.getInstance().getTime().toString();
            NSTEXOPlayerSkyTvActivity.this.runOnUiThread(new a(m7.w.R(NSTEXOPlayerSkyTvActivity.this.f), m7.w.A(date)));
        }
    }

    public class H implements AdapterView.OnItemClickListener {
        public H() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String cmd;
            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity;
            n7.g U1;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            NSTEXOPlayerSkyTvActivity.l2(NSTEXOPlayerSkyTvActivity.this, i);
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("stalker_api")) {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity2 = NSTEXOPlayerSkyTvActivity.this;
                NSTEXOPlayerSkyTvActivity.n2(nSTEXOPlayerSkyTvActivity2, NSTEXOPlayerSkyTvActivity.k2(nSTEXOPlayerSkyTvActivity2), NSTEXOPlayerSkyTvActivity.this.M);
                return;
            }
            try {
                String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTEXOPlayerSkyTvActivity.this.f);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(NSTEXOPlayerSkyTvActivity.this.f);
                ArrayList g = NSTEXOPlayerSkyTvActivity.m2(NSTEXOPlayerSkyTvActivity.this).g();
                if (g != null && g.size() > 0) {
                    cmd = ((LiveStreamsDBModel) g.get(NSTEXOPlayerSkyTvActivity.k2(NSTEXOPlayerSkyTvActivity.this))).getCmd();
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity3 = NSTEXOPlayerSkyTvActivity.this;
                    if (nSTEXOPlayerSkyTvActivity3.v1 == m7.w.q0(((LiveStreamsDBModel) g.get(NSTEXOPlayerSkyTvActivity.k2(nSTEXOPlayerSkyTvActivity3))).getStreamId())) {
                        nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                        nSTEXOPlayerSkyTvActivity.C3();
                        return;
                    }
                    m7.w.N0(NSTEXOPlayerSkyTvActivity.this.f);
                    U1 = NSTEXOPlayerSkyTvActivity.U1(NSTEXOPlayerSkyTvActivity.this);
                    str = "";
                    str2 = "itv";
                    str3 = "";
                    str4 = "";
                    str5 = "";
                    str6 = "";
                    str7 = "";
                    str8 = "channel_click_from_player";
                    str9 = "";
                    str10 = "";
                    U1.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, str10);
                }
                if (NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this) == null || NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).size() <= 0) {
                    return;
                }
                cmd = ((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(NSTEXOPlayerSkyTvActivity.k2(NSTEXOPlayerSkyTvActivity.this))).getCmd();
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity4 = NSTEXOPlayerSkyTvActivity.this;
                if (nSTEXOPlayerSkyTvActivity4.v1 == m7.w.q0(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(nSTEXOPlayerSkyTvActivity4).get(NSTEXOPlayerSkyTvActivity.k2(NSTEXOPlayerSkyTvActivity.this))).getStreamId())) {
                    nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                    nSTEXOPlayerSkyTvActivity.C3();
                    return;
                }
                m7.w.N0(NSTEXOPlayerSkyTvActivity.this.f);
                U1 = NSTEXOPlayerSkyTvActivity.U1(NSTEXOPlayerSkyTvActivity.this);
                str = "";
                str2 = "itv";
                str3 = "";
                str4 = "";
                str5 = "";
                str6 = "";
                str7 = "";
                str8 = "channel_click_from_player";
                str9 = "";
                str10 = "";
                U1.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, str10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class I implements Runnable {
        public I() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    NSTEXOPlayerSkyTvActivity.this.y3();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class J implements View.OnFocusChangeListener {
        public View a;

        public J(View view) {
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
            view.setBackground(NSTEXOPlayerSkyTvActivity.this.getResources().getDrawable(a7.e.L));
        }
    }

    public class K extends AsyncTask {
        public K() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return Boolean.valueOf(NSTEXOPlayerSkyTvActivity.this.T3());
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", true);
            NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
            if (NSTEXOPlayerSkyTvActivity.A1(NSTEXOPlayerSkyTvActivity.this) != null) {
                NSTEXOPlayerSkyTvActivity.A1(NSTEXOPlayerSkyTvActivity.this).setEPGHandler(NSTEXOPlayerSkyTvActivity.this.G1);
                NSTEXOPlayerSkyTvActivity.A1(NSTEXOPlayerSkyTvActivity.this).setContext(NSTEXOPlayerSkyTvActivity.this.f);
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                NSTEXOPlayerSkyTvActivity.g2(nSTEXOPlayerSkyTvActivity, NSTEXOPlayerSkyTvActivity.w3(nSTEXOPlayerSkyTvActivity.f));
                if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                    return;
                }
            } else if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).isShowing()) {
                return;
            }
            NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).show();
        }
    }

    public class L implements Runnable {
        public L() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (SharepreferenceDBHandler.getMaintanceModeState(NSTEXOPlayerSkyTvActivity.this.f)) {
                        NSTEXOPlayerSkyTvActivity.this.f.startActivity(new Intent(NSTEXOPlayerSkyTvActivity.this.f, MaintanencePannelActivity.class));
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

    public class M extends AsyncTask {
        public M() {
        }

        public String a() {
            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity;
            LiveStreamDBHandler liveStreamDBHandler;
            String str;
            String string;
            SharedPreferences I1;
            String str2;
            try {
                NSTEXOPlayerSkyTvActivity.B1(NSTEXOPlayerSkyTvActivity.this, 0);
                if (NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this) != null && NSTEXOPlayerSkyTvActivity.E1(NSTEXOPlayerSkyTvActivity.this) != null) {
                    NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).clear();
                    NSTEXOPlayerSkyTvActivity.E1(NSTEXOPlayerSkyTvActivity.this).clear();
                }
                if (NSTEXOPlayerSkyTvActivity.F1(NSTEXOPlayerSkyTvActivity.this).equals("true")) {
                    nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                    liveStreamDBHandler = nSTEXOPlayerSkyTvActivity.R;
                    str = "radio_streams";
                } else {
                    nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                    liveStreamDBHandler = nSTEXOPlayerSkyTvActivity.R;
                    str = "live";
                }
                NSTEXOPlayerSkyTvActivity.D1(nSTEXOPlayerSkyTvActivity, liveStreamDBHandler.getAllLiveStreasWithCategoryId("0", str));
                if (NSTEXOPlayerSkyTvActivity.Z2(NSTEXOPlayerSkyTvActivity.this) != null) {
                    NSTEXOPlayerSkyTvActivity.Z2(NSTEXOPlayerSkyTvActivity.this).clear();
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(NSTEXOPlayerSkyTvActivity.G1(NSTEXOPlayerSkyTvActivity.this).C()));
                String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(NSTEXOPlayerSkyTvActivity.this.f)));
                boolean B = NSTEXOPlayerSkyTvActivity.G1(NSTEXOPlayerSkyTvActivity.this).B();
                ArrayList ePGTesting = B ? NSTEXOPlayerSkyTvActivity.this.R.getEPGTesting((String) null, format) : null;
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity2 = NSTEXOPlayerSkyTvActivity.this;
                NSTEXOPlayerSkyTvActivity.H1(nSTEXOPlayerSkyTvActivity2, nSTEXOPlayerSkyTvActivity2.getSharedPreferences("currentlyPlayingVideo", 0));
                if (SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("m3u")) {
                    I1 = NSTEXOPlayerSkyTvActivity.I1(NSTEXOPlayerSkyTvActivity.this);
                    str2 = "LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U";
                } else {
                    if (!SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("onestream_api")) {
                        string = NSTEXOPlayerSkyTvActivity.I1(SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("onestream_api") ? NSTEXOPlayerSkyTvActivity.this : NSTEXOPlayerSkyTvActivity.this).getString("currentlyPlayingVideo", "");
                        if (NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this) == null && NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).size() > 0) {
                            for (int i = 0; i < NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).size(); i++) {
                                if (NSTEXOPlayerSkyTvActivity.J1(NSTEXOPlayerSkyTvActivity.this) != null && NSTEXOPlayerSkyTvActivity.J1(NSTEXOPlayerSkyTvActivity.this).isCancelled()) {
                                    return "all_channels";
                                }
                                if (SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("m3u") && ((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getUrl().equals(string)) {
                                    NSTEXOPlayerSkyTvActivity.B1(NSTEXOPlayerSkyTvActivity.this, i);
                                }
                                if (SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("onestream_api")) {
                                    if (((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamIdOneStream().equals(string)) {
                                        NSTEXOPlayerSkyTvActivity.B1(NSTEXOPlayerSkyTvActivity.this, i);
                                    }
                                } else if (((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamId().equals(string)) {
                                    NSTEXOPlayerSkyTvActivity.B1(NSTEXOPlayerSkyTvActivity.this, i);
                                }
                                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                                liveStreamsDBModel.setNum(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getNum());
                                liveStreamsDBModel.setName(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getName());
                                liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamType());
                                liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamId());
                                liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamIcon());
                                liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getEpgChannelId());
                                liveStreamsDBModel.setAdded(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getAdded());
                                liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getCategoryId());
                                liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getCustomSid());
                                liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getTvArchive());
                                liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getDirectSource());
                                liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getTvArchiveDuration());
                                liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getTypeName());
                                liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getCategoryName());
                                liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getSeriesNo());
                                liveStreamsDBModel.setLive(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getLive());
                                liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getContaiinerExtension());
                                liveStreamsDBModel.setUrl(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getUrl());
                                liveStreamsDBModel.setCmd(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getCmd());
                                if (B && ePGTesting != null && ePGTesting.size() > 0) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= ePGTesting.size() || (NSTEXOPlayerSkyTvActivity.J1(NSTEXOPlayerSkyTvActivity.this) != null && NSTEXOPlayerSkyTvActivity.J1(NSTEXOPlayerSkyTvActivity.this).isCancelled())) {
                                            break;
                                        }
                                        if (((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i2)).getChannel())) {
                                            int M = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i2)).getStart(), NSTEXOPlayerSkyTvActivity.this.f), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i2)).getStop(), NSTEXOPlayerSkyTvActivity.this.f), NSTEXOPlayerSkyTvActivity.this.f);
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
                                NSTEXOPlayerSkyTvActivity.Z2(NSTEXOPlayerSkyTvActivity.this).add(liveStreamsDBModel);
                            }
                            return "all_channels";
                        }
                    }
                    I1 = NSTEXOPlayerSkyTvActivity.I1(NSTEXOPlayerSkyTvActivity.this);
                    str2 = "LOGIN_PREF_CURRENTLY_PLAYING_VIDEO";
                }
                string = I1.getString(str2, "");
                return NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this) == null ? "all_channels" : "all_channels";
            } catch (Exception unused) {
                return "all_channels";
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0037  */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r0 = 0
                r6 = r6[r0]     // Catch: java.lang.Exception -> L17
                int r1 = r6.hashCode()     // Catch: java.lang.Exception -> L17
                r2 = 2
                r3 = 1
                r4 = 3
                switch(r1) {
                    case -74797390: goto L2d;
                    case 47612238: goto L23;
                    case 301138327: goto L19;
                    case 613425326: goto Le;
                    default: goto Ld;
                }     // Catch: java.lang.Exception -> L17
            Ld:
                goto L37
            Le:
                java.lang.String r1 = "all_channels"
                boolean r6 = r6.equals(r1)     // Catch: java.lang.Exception -> L17
                if (r6 == 0) goto L37
                goto L38
            L17:
                r6 = move-exception
                goto L5c
            L19:
                java.lang.String r0 = "recently_watched"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L17
                if (r6 == 0) goto L37
                r0 = 3
                goto L38
            L23:
                java.lang.String r0 = "all_channels_with_cat"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L17
                if (r6 == 0) goto L37
                r0 = 1
                goto L38
            L2d:
                java.lang.String r0 = "get_fav"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L17
                if (r6 == 0) goto L37
                r0 = 2
                goto L38
            L37:
                r0 = -1
            L38:
                if (r0 == 0) goto L57
                if (r0 == r3) goto L50
                if (r0 == r2) goto L49
                if (r0 == r4) goto L42
                r6 = 0
                return r6
            L42:
                com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r6 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L17
                java.lang.String r6 = r6.m3()     // Catch: java.lang.Exception -> L17
                return r6
            L49:
                com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r6 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L17
                java.lang.String r6 = r6.F3()     // Catch: java.lang.Exception -> L17
                return r6
            L50:
                com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r6 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L17
                java.lang.String r6 = r6.i3()     // Catch: java.lang.Exception -> L17
                return r6
            L57:
                java.lang.String r6 = r5.a()     // Catch: java.lang.Exception -> L17
                return r6
            L5c:
                r6.printStackTrace()
                java.lang.String r6 = "error"
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.M.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (NSTEXOPlayerSkyTvActivity.Z2(NSTEXOPlayerSkyTvActivity.this) != null) {
                    if (!NSTEXOPlayerSkyTvActivity.x1(NSTEXOPlayerSkyTvActivity.this).booleanValue()) {
                        NSTEXOPlayerSkyTvActivity.y1(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
                        if (NSTEXOPlayerSkyTvActivity.Z2(NSTEXOPlayerSkyTvActivity.this).size() == 0) {
                            m7.a.Y = Boolean.FALSE;
                            NSTEXOPlayerSkyTvActivity.this.f4();
                            NSTEXOPlayerSkyTvActivity.A1(NSTEXOPlayerSkyTvActivity.this).setVisibility(8);
                            NSTEXOPlayerSkyTvActivity.this.o.setVisibility(0);
                            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                            nSTEXOPlayerSkyTvActivity.p.setText(nSTEXOPlayerSkyTvActivity.getResources().getString(a7.j.g4));
                        } else if (NSTEXOPlayerSkyTvActivity.z1(NSTEXOPlayerSkyTvActivity.this) != null) {
                            NSTEXOPlayerSkyTvActivity.z1(NSTEXOPlayerSkyTvActivity.this).clear();
                            NSTEXOPlayerSkyTvActivity.z1(NSTEXOPlayerSkyTvActivity.this).addAll(NSTEXOPlayerSkyTvActivity.Z2(NSTEXOPlayerSkyTvActivity.this));
                        }
                    }
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity2 = NSTEXOPlayerSkyTvActivity.this;
                    if (nSTEXOPlayerSkyTvActivity2.P0 && nSTEXOPlayerSkyTvActivity2.Q0 && !nSTEXOPlayerSkyTvActivity2.R0.equals("")) {
                        NSTEXOPlayerSkyTvActivity.B1(NSTEXOPlayerSkyTvActivity.this, 0);
                        try {
                            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity3 = NSTEXOPlayerSkyTvActivity.this;
                            NSTEXOPlayerSkyTvActivity.B1(nSTEXOPlayerSkyTvActivity3, nSTEXOPlayerSkyTvActivity3.I3(NSTEXOPlayerSkyTvActivity.Z2(nSTEXOPlayerSkyTvActivity3), m7.w.r0(NSTEXOPlayerSkyTvActivity.this.R0)));
                        } catch (Exception | NumberFormatException e) {
                            e.printStackTrace();
                        }
                        NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity4 = NSTEXOPlayerSkyTvActivity.this;
                        nSTEXOPlayerSkyTvActivity4.P0 = false;
                        nSTEXOPlayerSkyTvActivity4.Q0 = false;
                    }
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity5 = NSTEXOPlayerSkyTvActivity.this;
                    nSTEXOPlayerSkyTvActivity5.t4(NSTEXOPlayerSkyTvActivity.Z2(nSTEXOPlayerSkyTvActivity5));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            try {
                TextView textView = NSTEXOPlayerSkyTvActivity.this.K0;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                TextView textView2 = nSTEXOPlayerSkyTvActivity.j0;
                if (textView2 != null) {
                    textView2.setText(nSTEXOPlayerSkyTvActivity.Z0);
                    NSTEXOPlayerSkyTvActivity.this.j0.setSelected(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class N extends AsyncTask {
        public N() {
        }

        public String a() {
            LiveStreamDBHandler liveStreamDBHandler;
            String F2;
            String str;
            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity;
            try {
                NSTEXOPlayerSkyTvActivity.a2(NSTEXOPlayerSkyTvActivity.this, 0);
                if (NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this) != null) {
                    NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).clear();
                }
                if (NSTEXOPlayerSkyTvActivity.F1(NSTEXOPlayerSkyTvActivity.this).equals("true")) {
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity2 = NSTEXOPlayerSkyTvActivity.this;
                    liveStreamDBHandler = nSTEXOPlayerSkyTvActivity2.R;
                    F2 = NSTEXOPlayerSkyTvActivity.F2(nSTEXOPlayerSkyTvActivity2);
                    str = "radio_streams";
                } else {
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity3 = NSTEXOPlayerSkyTvActivity.this;
                    liveStreamDBHandler = nSTEXOPlayerSkyTvActivity3.R;
                    F2 = NSTEXOPlayerSkyTvActivity.F2(nSTEXOPlayerSkyTvActivity3);
                    str = "live";
                }
                NSTEXOPlayerSkyTvActivity.Q1(NSTEXOPlayerSkyTvActivity.this, liveStreamDBHandler.getAllLiveStreasWithCategoryId(F2, str));
                if (NSTEXOPlayerSkyTvActivity.b2(NSTEXOPlayerSkyTvActivity.this) != null) {
                    NSTEXOPlayerSkyTvActivity.b2(NSTEXOPlayerSkyTvActivity.this).clear();
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(NSTEXOPlayerSkyTvActivity.G1(NSTEXOPlayerSkyTvActivity.this).C()));
                String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(NSTEXOPlayerSkyTvActivity.this.f)));
                boolean B = NSTEXOPlayerSkyTvActivity.G1(NSTEXOPlayerSkyTvActivity.this).B();
                ArrayList ePGTesting = B ? NSTEXOPlayerSkyTvActivity.this.R.getEPGTesting((String) null, format) : null;
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity4 = NSTEXOPlayerSkyTvActivity.this;
                NSTEXOPlayerSkyTvActivity.H1(nSTEXOPlayerSkyTvActivity4, nSTEXOPlayerSkyTvActivity4.getSharedPreferences("currentlyPlayingVideo", 0));
                String string = SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("m3u") ? NSTEXOPlayerSkyTvActivity.I1(NSTEXOPlayerSkyTvActivity.this).getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : NSTEXOPlayerSkyTvActivity.I1(SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("onestream_api") ? NSTEXOPlayerSkyTvActivity.this : NSTEXOPlayerSkyTvActivity.this).getString("currentlyPlayingVideo", "");
                if (NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this) != null && NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).size() > 0) {
                    for (int i = 0; i < NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).size() && (NSTEXOPlayerSkyTvActivity.J1(NSTEXOPlayerSkyTvActivity.this) == null || !NSTEXOPlayerSkyTvActivity.J1(NSTEXOPlayerSkyTvActivity.this).isCancelled()); i++) {
                        if (SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("m3u")) {
                            if (((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getUrl().equals(string)) {
                                NSTEXOPlayerSkyTvActivity.a2(NSTEXOPlayerSkyTvActivity.this, i);
                                nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                                NSTEXOPlayerSkyTvActivity.T1(nSTEXOPlayerSkyTvActivity, NSTEXOPlayerSkyTvActivity.Z1(nSTEXOPlayerSkyTvActivity));
                            }
                        } else if (SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("onestream_api")) {
                            if (((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamIdOneStream().equals(string)) {
                                NSTEXOPlayerSkyTvActivity.a2(NSTEXOPlayerSkyTvActivity.this, i);
                                nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                                NSTEXOPlayerSkyTvActivity.T1(nSTEXOPlayerSkyTvActivity, NSTEXOPlayerSkyTvActivity.Z1(nSTEXOPlayerSkyTvActivity));
                            }
                        } else if (((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamId().equals(string)) {
                            NSTEXOPlayerSkyTvActivity.a2(NSTEXOPlayerSkyTvActivity.this, i);
                            nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                            NSTEXOPlayerSkyTvActivity.T1(nSTEXOPlayerSkyTvActivity, NSTEXOPlayerSkyTvActivity.Z1(nSTEXOPlayerSkyTvActivity));
                        }
                        LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                        liveStreamsDBModel.setNum(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getNum());
                        liveStreamsDBModel.setName(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getName());
                        liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamType());
                        liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamId());
                        liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamIdOneStream());
                        liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getStreamIcon());
                        liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getEpgChannelId());
                        liveStreamsDBModel.setAdded(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getAdded());
                        liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getCategoryId());
                        liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getCustomSid());
                        liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getTvArchive());
                        liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getDirectSource());
                        liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getTvArchiveDuration());
                        liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getTypeName());
                        liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getCategoryName());
                        liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getSeriesNo());
                        liveStreamsDBModel.setLive(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getLive());
                        liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getContaiinerExtension());
                        liveStreamsDBModel.setUrl(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getUrl());
                        liveStreamsDBModel.setCmd(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getCmd());
                        if (B && ePGTesting != null && ePGTesting.size() > 0) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < ePGTesting.size() && (NSTEXOPlayerSkyTvActivity.J1(NSTEXOPlayerSkyTvActivity.this) == null || !NSTEXOPlayerSkyTvActivity.J1(NSTEXOPlayerSkyTvActivity.this).isCancelled())) {
                                    if (((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i2)).getChannel())) {
                                        int M = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i2)).getStart(), NSTEXOPlayerSkyTvActivity.this.f), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i2)).getStop(), NSTEXOPlayerSkyTvActivity.this.f), NSTEXOPlayerSkyTvActivity.this.f);
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
                        NSTEXOPlayerSkyTvActivity.b2(NSTEXOPlayerSkyTvActivity.this).add(liveStreamsDBModel);
                    }
                }
                NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).clear();
                NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).addAll(NSTEXOPlayerSkyTvActivity.b2(NSTEXOPlayerSkyTvActivity.this));
                return "all_channels_with_cat";
            } catch (Exception unused) {
                return "all_channels_with_cat";
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            try {
                return NSTEXOPlayerSkyTvActivity.F2(NSTEXOPlayerSkyTvActivity.this).equals("-1") ? SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("m3u") ? NSTEXOPlayerSkyTvActivity.this.F3() : NSTEXOPlayerSkyTvActivity.this.G3() : NSTEXOPlayerSkyTvActivity.F2(NSTEXOPlayerSkyTvActivity.this).equals("-6") ? NSTEXOPlayerSkyTvActivity.this.m3() : a();
            } catch (Exception unused) {
                return "error";
            }
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this) != null) {
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                    nSTEXOPlayerSkyTvActivity.u4(NSTEXOPlayerSkyTvActivity.P1(nSTEXOPlayerSkyTvActivity));
                    if (!NSTEXOPlayerSkyTvActivity.x1(NSTEXOPlayerSkyTvActivity.this).booleanValue()) {
                        NSTEXOPlayerSkyTvActivity.y1(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
                        if (NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this) == null || NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).size() == 0) {
                            m7.a.Y = Boolean.FALSE;
                            NSTEXOPlayerSkyTvActivity.this.f4();
                        } else if (!NSTEXOPlayerSkyTvActivity.R1(NSTEXOPlayerSkyTvActivity.this).equals("true") && !NSTEXOPlayerSkyTvActivity.G1(NSTEXOPlayerSkyTvActivity.this).i()) {
                            LinearLayout linearLayout = NSTEXOPlayerSkyTvActivity.this.A3;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(0);
                            }
                        } else if (SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("stalker_api")) {
                            try {
                                m7.w.N0(NSTEXOPlayerSkyTvActivity.this.f);
                                String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTEXOPlayerSkyTvActivity.this.f);
                                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(NSTEXOPlayerSkyTvActivity.this.f);
                                if (NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this) != null && NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).size() > 0 && NSTEXOPlayerSkyTvActivity.S1(NSTEXOPlayerSkyTvActivity.this) < NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).size()) {
                                    NSTEXOPlayerSkyTvActivity.U1(NSTEXOPlayerSkyTvActivity.this).c(loggedInMacAddress, stalkerToken, ((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(NSTEXOPlayerSkyTvActivity.S1(NSTEXOPlayerSkyTvActivity.this))).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "playFirstTime", 0, "", "");
                                }
                            } catch (Exception unused) {
                            }
                        } else {
                            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity2 = NSTEXOPlayerSkyTvActivity.this;
                            NSTEXOPlayerSkyTvActivity.V1(nSTEXOPlayerSkyTvActivity2, NSTEXOPlayerSkyTvActivity.P1(nSTEXOPlayerSkyTvActivity2));
                        }
                    }
                }
                NSTEXOPlayerSkyTvActivity.this.S3();
                NSTEXOPlayerSkyTvActivity.W1(NSTEXOPlayerSkyTvActivity.this);
                NSTEXOPlayerSkyTvActivity.X1(NSTEXOPlayerSkyTvActivity.this);
                NSTEXOPlayerSkyTvActivity.Y1(NSTEXOPlayerSkyTvActivity.this);
            } catch (Exception unused2) {
                NSTEXOPlayerSkyTvActivity.this.S3();
            }
        }

        public void onPreExecute() {
            LinearLayout linearLayout;
            super.onPreExecute();
            try {
                RelativeLayout relativeLayout = NSTEXOPlayerSkyTvActivity.this.Z2;
                if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                    NSTEXOPlayerSkyTvActivity.L1(NSTEXOPlayerSkyTvActivity.this, "");
                } else {
                    NSTEXOPlayerSkyTvActivity.L1(NSTEXOPlayerSkyTvActivity.this, "player");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            NSTEXOPlayerSkyTvActivity.M1(NSTEXOPlayerSkyTvActivity.this);
            if (NSTEXOPlayerSkyTvActivity.K1(NSTEXOPlayerSkyTvActivity.this).equals("player")) {
                if (NSTEXOPlayerSkyTvActivity.N1(NSTEXOPlayerSkyTvActivity.this) != null) {
                    NSTEXOPlayerSkyTvActivity.N1(NSTEXOPlayerSkyTvActivity.this).setVisibility(8);
                }
                linearLayout = NSTEXOPlayerSkyTvActivity.this.M0;
                if (linearLayout == null) {
                    return;
                }
            } else {
                if (NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this) != null) {
                    NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this).setVisibility(8);
                }
                linearLayout = NSTEXOPlayerSkyTvActivity.this.L0;
                if (linearLayout == null) {
                    return;
                }
            }
            linearLayout.setVisibility(8);
        }
    }

    public class O implements View.OnFocusChangeListener {
        public final View a;

        public O(View view) {
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

        /* JADX WARN: Removed duplicated region for block: B:110:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00eb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFocusChange(android.view.View r26, boolean r27) {
            /*
                Method dump skipped, instructions count: 2197
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.O.onFocusChange(android.view.View, boolean):void");
        }
    }

    public class P implements d4.p {
        public P() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Pair a(p1 p1Var) {
            String string = NSTEXOPlayerSkyTvActivity.this.getString(a7.j.M1);
            u.b cause = p1Var.getCause();
            if (cause instanceof u.b) {
                u.b bVar = cause;
                p3.t tVar = bVar.d;
                string = tVar == null ? bVar.getCause() instanceof B.c ? NSTEXOPlayerSkyTvActivity.this.getString(a7.j.R1) : bVar.c ? NSTEXOPlayerSkyTvActivity.this.getString(a7.j.P1, new Object[]{bVar.a}) : NSTEXOPlayerSkyTvActivity.this.getString(a7.j.O1, new Object[]{bVar.a}) : NSTEXOPlayerSkyTvActivity.this.getString(a7.j.N1, new Object[]{tVar.a});
            }
            return Pair.create(0, string);
        }

        public /* synthetic */ P(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, k kVar) {
            this();
        }
    }

    public class Q implements t1.d {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                if (nSTEXOPlayerSkyTvActivity.z4) {
                    return;
                }
                nSTEXOPlayerSkyTvActivity.w4++;
                m7.w.P0(nSTEXOPlayerSkyTvActivity.f, NSTEXOPlayerSkyTvActivity.this.f.getResources().getString(a7.j.g5) + " (" + NSTEXOPlayerSkyTvActivity.this.w4 + "/" + NSTEXOPlayerSkyTvActivity.a3(NSTEXOPlayerSkyTvActivity.this) + ")");
                NSTEXOPlayerSkyTvActivity.this.o4();
                NSTEXOPlayerSkyTvActivity.R2(NSTEXOPlayerSkyTvActivity.this);
            }
        }

        public Q() {
        }

        private void C(String str) {
            NSTEXOPlayerSkyTvActivity.this.o.setVisibility(0);
            NSTEXOPlayerSkyTvActivity.this.p.setText(str);
        }

        private void o() {
            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
            if (nSTEXOPlayerSkyTvActivity.w4 >= NSTEXOPlayerSkyTvActivity.a3(nSTEXOPlayerSkyTvActivity)) {
                C(NSTEXOPlayerSkyTvActivity.this.f.getResources().getString(a7.j.b7));
                NSTEXOPlayerSkyTvActivity.this.o4();
                NSTEXOPlayerSkyTvActivity.this.y4 = false;
                NSTEXOPlayerSkyTvActivity.P5.setVisibility(8);
                return;
            }
            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity2 = NSTEXOPlayerSkyTvActivity.this;
            if (nSTEXOPlayerSkyTvActivity2.z4) {
                return;
            }
            nSTEXOPlayerSkyTvActivity2.y4 = true;
            nSTEXOPlayerSkyTvActivity2.D1.postDelayed(new a(), 3000L);
        }

        public /* synthetic */ void A(Q2.e eVar) {
            v1.a(this, eVar);
        }

        public /* synthetic */ void B(boolean z) {
            v1.j(this, z);
        }

        public void E(int i) {
            LiveStreamDBHandler liveStreamDBHandler;
            String g;
            String str;
            if (i == 2) {
                if (NSTEXOPlayerSkyTvActivity.t3()) {
                    return;
                }
                LinearLayout linearLayout = NSTEXOPlayerSkyTvActivity.this.R2;
                if (linearLayout != null && linearLayout.getVisibility() == 0) {
                    NSTEXOPlayerSkyTvActivity.this.R2.setVisibility(8);
                }
                NSTEXOPlayerSkyTvActivity.P5.setVisibility(0);
                return;
            }
            if (i == 4) {
                o();
                return;
            }
            if (i == 3) {
                if (NSTEXOPlayerSkyTvActivity.this.S2.getVisibility() == 0) {
                    NSTEXOPlayerSkyTvActivity.this.R2.setVisibility(0);
                }
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                nSTEXOPlayerSkyTvActivity.w4 = 0;
                nSTEXOPlayerSkyTvActivity.h.setVisibility(8);
                NSTEXOPlayerSkyTvActivity.this.i.setVisibility(0);
                if (NSTEXOPlayerSkyTvActivity.L5) {
                    NSTEXOPlayerSkyTvActivity.this.i.requestFocus();
                }
                NSTEXOPlayerSkyTvActivity.P5.setVisibility(8);
                LiveStreamDBHandler liveStreamDBHandler2 = NSTEXOPlayerSkyTvActivity.this.R;
                if (liveStreamDBHandler2 != null) {
                    liveStreamDBHandler2.deleteLiveRecentlyWatched(x7.a.f().g());
                    if (NSTEXOPlayerSkyTvActivity.F1(NSTEXOPlayerSkyTvActivity.this).equalsIgnoreCase("true")) {
                        liveStreamDBHandler = NSTEXOPlayerSkyTvActivity.this.R;
                        g = x7.a.f().g();
                        str = "radio_streams";
                    } else {
                        liveStreamDBHandler = NSTEXOPlayerSkyTvActivity.this.R;
                        g = x7.a.f().g();
                        str = "live";
                    }
                    liveStreamDBHandler.addLiveRecentlyWatched(g, str);
                    NSTEXOPlayerSkyTvActivity.this.R.deleteExtraLiveRecentlyWatched();
                }
                NSTEXOPlayerSkyTvActivity.this.g4(2);
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
            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
            if (nSTEXOPlayerSkyTvActivity.z4) {
                return;
            }
            if (p1Var.a == 1002) {
                NSTEXOPlayerSkyTvActivity.R2(nSTEXOPlayerSkyTvActivity);
            } else if (!p1Var.toString().contains("com.google.android.exoplayer2.ext.ffmpeg.FfmpegDecoderException")) {
                o();
            } else {
                m7.w.P0(NSTEXOPlayerSkyTvActivity.this.f, "Audio track issue found. Please change the audio track to none.");
                NSTEXOPlayerSkyTvActivity.R2(NSTEXOPlayerSkyTvActivity.this);
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

        public /* synthetic */ Q(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, k kVar) {
            this();
        }
    }

    public class R extends AsyncTask {
        public String a;

        public R(String str) {
            this.a = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HashMap doInBackground(String... strArr) {
            try {
                return NSTEXOPlayerSkyTvActivity.d2(NSTEXOPlayerSkyTvActivity.this, this.a);
            } catch (Exception unused) {
                return new HashMap();
            }
        }

        /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
            LL1ili1iI1iI.IIiLliI1l1li1: Can't find top splitter block for handler:B:253:0x013e
            	at ILlL1lil1i1i.LLll11I1I1lL.llLliLLIll1lI(Unknown Source:36)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(Unknown Source:67)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(Unknown Source:9)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:40)
            */
        /* JADX WARN: Removed duplicated region for block: B:251:0x03c4 A[Catch: Exception -> 0x0053, TRY_LEAVE, TryCatch #6 {Exception -> 0x0053, blocks: (B:3:0x000b, B:6:0x0019, B:8:0x0021, B:10:0x0027, B:12:0x0035, B:14:0x003b, B:16:0x0043, B:18:0x0049, B:20:0x004f, B:21:0x0056, B:23:0x005c, B:25:0x0062, B:27:0x006a, B:29:0x0070, B:30:0x0082, B:49:0x016b, B:51:0x0171, B:53:0x0179, B:77:0x01fb, B:79:0x0201, B:80:0x0204, B:82:0x020a, B:103:0x0289, B:105:0x028f, B:106:0x0292, B:108:0x0298, B:130:0x0318, B:132:0x031e, B:133:0x0321, B:135:0x0327, B:160:0x03ab, B:162:0x03b1, B:163:0x03b4, B:165:0x03ba, B:173:0x03a2, B:175:0x03a8, B:180:0x0377, B:182:0x037d, B:187:0x034c, B:189:0x0352, B:194:0x030f, B:196:0x0315, B:200:0x02e6, B:202:0x02ec, B:207:0x02bc, B:209:0x02c2, B:214:0x0280, B:216:0x0286, B:220:0x0256, B:222:0x025c, B:226:0x022d, B:228:0x0233, B:233:0x01f2, B:235:0x01f8, B:239:0x01c8, B:241:0x01ce, B:245:0x019f, B:247:0x01a5, B:248:0x03be, B:249:0x03c0, B:251:0x03c4, B:253:0x013e, B:257:0x010f, B:259:0x00e0, B:261:0x00b1, B:262:0x0146, B:263:0x014a, B:264:0x014e, B:265:0x0153, B:266:0x015f, B:125:0x02ef, B:127:0x02f5, B:129:0x02fb, B:190:0x0305, B:192:0x030b, B:40:0x00e7, B:42:0x00ed, B:256:0x00fb, B:84:0x020d, B:86:0x0213, B:88:0x0219, B:223:0x0223, B:225:0x0229, B:138:0x032c, B:140:0x0332, B:142:0x0338, B:184:0x0342, B:186:0x0348, B:146:0x0357, B:148:0x035d, B:150:0x0363, B:177:0x036d, B:179:0x0373, B:90:0x0236, B:92:0x023c, B:94:0x0242, B:217:0x024c, B:219:0x0252, B:71:0x01d2, B:73:0x01d8, B:75:0x01de, B:230:0x01e8, B:232:0x01ee, B:32:0x0089, B:34:0x008f, B:260:0x009d, B:97:0x0260, B:99:0x0266, B:101:0x026c, B:211:0x0276, B:213:0x027c, B:36:0x00c4, B:38:0x00ca, B:258:0x00d8, B:56:0x017f, B:58:0x0185, B:60:0x018b, B:242:0x0195, B:244:0x019b, B:44:0x0122, B:46:0x0128, B:254:0x0136, B:111:0x029c, B:113:0x02a2, B:115:0x02a8, B:204:0x02b2, B:206:0x02b8, B:64:0x01a8, B:66:0x01ae, B:68:0x01b4, B:236:0x01be, B:238:0x01c4, B:119:0x02c6, B:121:0x02cc, B:123:0x02d2, B:197:0x02dc, B:199:0x02e2, B:154:0x0382, B:156:0x0388, B:158:0x038e, B:170:0x0398, B:172:0x039e), top: B:2:0x000b, inners: #0, #1, #2, #3, #4, #5, #7, #8, #9, #10, #11, #12, #13, #14, #15, #16 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0171 A[Catch: Exception -> 0x0053, TryCatch #6 {Exception -> 0x0053, blocks: (B:3:0x000b, B:6:0x0019, B:8:0x0021, B:10:0x0027, B:12:0x0035, B:14:0x003b, B:16:0x0043, B:18:0x0049, B:20:0x004f, B:21:0x0056, B:23:0x005c, B:25:0x0062, B:27:0x006a, B:29:0x0070, B:30:0x0082, B:49:0x016b, B:51:0x0171, B:53:0x0179, B:77:0x01fb, B:79:0x0201, B:80:0x0204, B:82:0x020a, B:103:0x0289, B:105:0x028f, B:106:0x0292, B:108:0x0298, B:130:0x0318, B:132:0x031e, B:133:0x0321, B:135:0x0327, B:160:0x03ab, B:162:0x03b1, B:163:0x03b4, B:165:0x03ba, B:173:0x03a2, B:175:0x03a8, B:180:0x0377, B:182:0x037d, B:187:0x034c, B:189:0x0352, B:194:0x030f, B:196:0x0315, B:200:0x02e6, B:202:0x02ec, B:207:0x02bc, B:209:0x02c2, B:214:0x0280, B:216:0x0286, B:220:0x0256, B:222:0x025c, B:226:0x022d, B:228:0x0233, B:233:0x01f2, B:235:0x01f8, B:239:0x01c8, B:241:0x01ce, B:245:0x019f, B:247:0x01a5, B:248:0x03be, B:249:0x03c0, B:251:0x03c4, B:253:0x013e, B:257:0x010f, B:259:0x00e0, B:261:0x00b1, B:262:0x0146, B:263:0x014a, B:264:0x014e, B:265:0x0153, B:266:0x015f, B:125:0x02ef, B:127:0x02f5, B:129:0x02fb, B:190:0x0305, B:192:0x030b, B:40:0x00e7, B:42:0x00ed, B:256:0x00fb, B:84:0x020d, B:86:0x0213, B:88:0x0219, B:223:0x0223, B:225:0x0229, B:138:0x032c, B:140:0x0332, B:142:0x0338, B:184:0x0342, B:186:0x0348, B:146:0x0357, B:148:0x035d, B:150:0x0363, B:177:0x036d, B:179:0x0373, B:90:0x0236, B:92:0x023c, B:94:0x0242, B:217:0x024c, B:219:0x0252, B:71:0x01d2, B:73:0x01d8, B:75:0x01de, B:230:0x01e8, B:232:0x01ee, B:32:0x0089, B:34:0x008f, B:260:0x009d, B:97:0x0260, B:99:0x0266, B:101:0x026c, B:211:0x0276, B:213:0x027c, B:36:0x00c4, B:38:0x00ca, B:258:0x00d8, B:56:0x017f, B:58:0x0185, B:60:0x018b, B:242:0x0195, B:244:0x019b, B:44:0x0122, B:46:0x0128, B:254:0x0136, B:111:0x029c, B:113:0x02a2, B:115:0x02a8, B:204:0x02b2, B:206:0x02b8, B:64:0x01a8, B:66:0x01ae, B:68:0x01b4, B:236:0x01be, B:238:0x01c4, B:119:0x02c6, B:121:0x02cc, B:123:0x02d2, B:197:0x02dc, B:199:0x02e2, B:154:0x0382, B:156:0x0388, B:158:0x038e, B:170:0x0398, B:172:0x039e), top: B:2:0x000b, inners: #0, #1, #2, #3, #4, #5, #7, #8, #9, #10, #11, #12, #13, #14, #15, #16 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:199:0x02ea -> B:123:0x02ef). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:200:0x02ec -> B:123:0x02ef). Please report as a decompilation issue!!! */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPostExecute(java.util.HashMap r12) {
            /*
                Method dump skipped, instructions count: 971
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.R.onPostExecute(java.util.HashMap):void");
        }

        public void onPreExecute() {
            super.onPreExecute();
            try {
                NSTEXOPlayerSkyTvActivity.c2(NSTEXOPlayerSkyTvActivity.this);
                LinearLayout linearLayout = NSTEXOPlayerSkyTvActivity.this.n1;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                LinearLayout linearLayout2 = NSTEXOPlayerSkyTvActivity.this.p1;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                LinearLayout linearLayout3 = NSTEXOPlayerSkyTvActivity.this.q1;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                LinearLayout linearLayout4 = NSTEXOPlayerSkyTvActivity.this.r1;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                LinearLayout linearLayout5 = NSTEXOPlayerSkyTvActivity.this.s1;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
                LinearLayout linearLayout6 = NSTEXOPlayerSkyTvActivity.this.t1;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ R(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str, k kVar) {
            this(str);
        }
    }

    public class S extends AsyncTask {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final String e;
        public final int f;
        public String g;

        public S(String str, int i, String str2, String str3, String str4, int i2, String str5) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = i2;
            this.g = str5;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                if (nSTEXOPlayerSkyTvActivity.f == null || NSTEXOPlayerSkyTvActivity.u2(nSTEXOPlayerSkyTvActivity) == null || NSTEXOPlayerSkyTvActivity.x2(NSTEXOPlayerSkyTvActivity.this) == null || NSTEXOPlayerSkyTvActivity.i2(NSTEXOPlayerSkyTvActivity.this) == null || NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this) == null) {
                    return null;
                }
                FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
                favouriteDBModel.setCategoryID(this.a);
                favouriteDBModel.setStreamID(this.b);
                favouriteDBModel.setStreamIDOneStream(this.g);
                favouriteDBModel.setNum(this.d);
                favouriteDBModel.setName(this.c);
                favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(NSTEXOPlayerSkyTvActivity.this.f));
                NSTEXOPlayerSkyTvActivity.x2(NSTEXOPlayerSkyTvActivity.this).addToFavourite(favouriteDBModel, this.e);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            try {
                View childAt = NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this).getChildAt(this.f - NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this).getFirstVisiblePosition());
                if (childAt != null) {
                    try {
                        childAt.findViewById(a7.f.g5).setVisibility(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                NSTEXOPlayerSkyTvActivity.i2(NSTEXOPlayerSkyTvActivity.this).x(1);
                NSTEXOPlayerSkyTvActivity.this.S3();
            } catch (Exception unused) {
                NSTEXOPlayerSkyTvActivity.this.S3();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                NSTEXOPlayerSkyTvActivity.g2(nSTEXOPlayerSkyTvActivity, NSTEXOPlayerSkyTvActivity.w3(nSTEXOPlayerSkyTvActivity.f));
                if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                    return;
                }
            } else if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).isShowing()) {
                return;
            }
            NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).show();
        }
    }

    public class T extends AsyncTask {
        public final String a;
        public final String b;
        public final String c;
        public final int d;

        public T(String str, String str2, String str3, int i) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                if (nSTEXOPlayerSkyTvActivity.f == null || NSTEXOPlayerSkyTvActivity.u2(nSTEXOPlayerSkyTvActivity) == null) {
                    return null;
                }
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity2 = NSTEXOPlayerSkyTvActivity.this;
                if (nSTEXOPlayerSkyTvActivity2.R == null || NSTEXOPlayerSkyTvActivity.i2(nSTEXOPlayerSkyTvActivity2) == null || NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this) == null) {
                    return null;
                }
                FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
                favouriteM3UModel.setUrl(this.b);
                favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(NSTEXOPlayerSkyTvActivity.this.f));
                favouriteM3UModel.setName(this.c);
                favouriteM3UModel.setCategoryID(this.a);
                NSTEXOPlayerSkyTvActivity.this.R.addToFavourite(favouriteM3UModel);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            try {
                View childAt = NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this).getChildAt(this.d - NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this).getFirstVisiblePosition());
                if (childAt != null) {
                    try {
                        childAt.findViewById(a7.f.g5).setVisibility(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                NSTEXOPlayerSkyTvActivity.i2(NSTEXOPlayerSkyTvActivity.this).x(1);
                NSTEXOPlayerSkyTvActivity.this.S3();
            } catch (Exception unused) {
                NSTEXOPlayerSkyTvActivity.this.S3();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                NSTEXOPlayerSkyTvActivity.g2(nSTEXOPlayerSkyTvActivity, NSTEXOPlayerSkyTvActivity.w3(nSTEXOPlayerSkyTvActivity.f));
                if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                    return;
                }
            } else if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).isShowing()) {
                return;
            }
            NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).show();
        }
    }

    public class U extends AsyncTask {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final int e;

        public U(String str, int i, String str2, String str3, int i2) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = i2;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                if (nSTEXOPlayerSkyTvActivity.f == null || NSTEXOPlayerSkyTvActivity.u2(nSTEXOPlayerSkyTvActivity) == null || NSTEXOPlayerSkyTvActivity.x2(NSTEXOPlayerSkyTvActivity.this) == null || NSTEXOPlayerSkyTvActivity.i2(NSTEXOPlayerSkyTvActivity.this) == null || NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this) == null) {
                    return null;
                }
                NSTEXOPlayerSkyTvActivity.x2(NSTEXOPlayerSkyTvActivity.this).deleteFavourite(this.b, this.a, this.d, this.c, SharepreferenceDBHandler.getUserID(NSTEXOPlayerSkyTvActivity.this.f), NSTEXOPlayerSkyTvActivity.this.d);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            try {
                View childAt = NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this).getChildAt(this.e - NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this).getFirstVisiblePosition());
                if (childAt != null) {
                    try {
                        childAt.findViewById(a7.f.g5).setVisibility(4);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                NSTEXOPlayerSkyTvActivity.i2(NSTEXOPlayerSkyTvActivity.this).x(1);
                NSTEXOPlayerSkyTvActivity.this.S3();
            } catch (Exception unused) {
                NSTEXOPlayerSkyTvActivity.this.S3();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                NSTEXOPlayerSkyTvActivity.g2(nSTEXOPlayerSkyTvActivity, NSTEXOPlayerSkyTvActivity.w3(nSTEXOPlayerSkyTvActivity.f));
                if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                    return;
                }
            } else if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).isShowing()) {
                return;
            }
            NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).show();
        }
    }

    public class V extends AsyncTask {
        public final String a;
        public final int b;

        public V(String str, int i) {
            this.a = str;
            this.b = i;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                if (nSTEXOPlayerSkyTvActivity.f == null || NSTEXOPlayerSkyTvActivity.u2(nSTEXOPlayerSkyTvActivity) == null) {
                    return null;
                }
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity2 = NSTEXOPlayerSkyTvActivity.this;
                if (nSTEXOPlayerSkyTvActivity2.R == null || NSTEXOPlayerSkyTvActivity.i2(nSTEXOPlayerSkyTvActivity2) == null || NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this) == null) {
                    return null;
                }
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity3 = NSTEXOPlayerSkyTvActivity.this;
                nSTEXOPlayerSkyTvActivity3.R.deleteFavourite(this.a, SharepreferenceDBHandler.getUserID(nSTEXOPlayerSkyTvActivity3.f));
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            try {
                View childAt = NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this).getChildAt(this.b - NSTEXOPlayerSkyTvActivity.O1(NSTEXOPlayerSkyTvActivity.this).getFirstVisiblePosition());
                if (childAt != null) {
                    try {
                        childAt.findViewById(a7.f.g5).setVisibility(4);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                NSTEXOPlayerSkyTvActivity.i2(NSTEXOPlayerSkyTvActivity.this).x(1);
                NSTEXOPlayerSkyTvActivity.this.S3();
            } catch (Exception unused) {
                NSTEXOPlayerSkyTvActivity.this.S3();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                NSTEXOPlayerSkyTvActivity.g2(nSTEXOPlayerSkyTvActivity, NSTEXOPlayerSkyTvActivity.w3(nSTEXOPlayerSkyTvActivity.f));
                if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                    return;
                }
            } else if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).isShowing()) {
                return;
            }
            NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).show();
        }
    }

    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            try {
                if (NSTEXOPlayerSkyTvActivity.o2(NSTEXOPlayerSkyTvActivity.this) != null && NSTEXOPlayerSkyTvActivity.o2(NSTEXOPlayerSkyTvActivity.this).getStatus().equals(AsyncTask.Status.RUNNING)) {
                    NSTEXOPlayerSkyTvActivity.o2(NSTEXOPlayerSkyTvActivity.this).cancel(true);
                }
                ArrayList g = NSTEXOPlayerSkyTvActivity.u2(NSTEXOPlayerSkyTvActivity.this).g();
                if (g == null || g.size() <= 0) {
                    if (NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this) == null || NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).size() <= 0) {
                        return;
                    }
                    String epgChannelId = ((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(NSTEXOPlayerSkyTvActivity.this).get(i)).getEpgChannelId();
                    NSTEXOPlayerSkyTvActivity.this.F1.removeCallbacksAndMessages((Object) null);
                    if (!SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("stalker_api")) {
                        NSTEXOPlayerSkyTvActivity.p2(NSTEXOPlayerSkyTvActivity.this, new R(NSTEXOPlayerSkyTvActivity.this, epgChannelId, null).execute(new String[0]));
                        return;
                    } else {
                        NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                        nSTEXOPlayerSkyTvActivity.J4(((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.P1(nSTEXOPlayerSkyTvActivity).get(i)).getStreamId());
                        return;
                    }
                }
                String epgChannelId2 = ((LiveStreamsDBModel) g.get(i)).getEpgChannelId();
                NSTEXOPlayerSkyTvActivity.this.x5 = ((LiveStreamsDBModel) g.get(i)).getName();
                NSTEXOPlayerSkyTvActivity.this.u5 = ((LiveStreamsDBModel) g.get(i)).getCategoryId();
                NSTEXOPlayerSkyTvActivity.this.F1.removeCallbacksAndMessages((Object) null);
                if (SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("stalker_api")) {
                    NSTEXOPlayerSkyTvActivity.this.J4(((LiveStreamsDBModel) g.get(i)).getStreamId());
                } else {
                    NSTEXOPlayerSkyTvActivity.p2(NSTEXOPlayerSkyTvActivity.this, new R(NSTEXOPlayerSkyTvActivity.this, epgChannelId2, null).execute(new String[0]));
                }
            } catch (Exception e) {
                e.printStackTrace();
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

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            NSTEXOPlayerSkyTvActivity.q2(NSTEXOPlayerSkyTvActivity.this, i);
            LinearLayout linearLayout = NSTEXOPlayerSkyTvActivity.this.A3;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            if (m7.a.V0.booleanValue() && m7.a.e1.equalsIgnoreCase("1")) {
                m7.a.b = false;
                if (SharepreferenceDBHandler.getEventAdsView(NSTEXOPlayerSkyTvActivity.this) < m7.a.f1) {
                    if (SharepreferenceDBHandler.getEventAdsView(NSTEXOPlayerSkyTvActivity.this) == 0 && SharepreferenceDBHandler.getFirstTimeAdsShow(NSTEXOPlayerSkyTvActivity.this)) {
                        SharepreferenceDBHandler.setFirstTimeAdsShow(false, NSTEXOPlayerSkyTvActivity.this);
                        NSTEXOPlayerSkyTvActivity.r2(NSTEXOPlayerSkyTvActivity.this, "");
                        NSTEXOPlayerSkyTvActivity.s2(NSTEXOPlayerSkyTvActivity.this, "", "", "", adapterView, view, i, j, this.a);
                    } else if (Listsingleton.b().a() != null && Listsingleton.b().a().size() > 0) {
                        NSTEXOPlayerSkyTvActivity.t2(NSTEXOPlayerSkyTvActivity.this, adapterView, view, i, j, this.a);
                    }
                    SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(NSTEXOPlayerSkyTvActivity.this) + 1, NSTEXOPlayerSkyTvActivity.this);
                    return;
                }
                if (Listsingleton.b().a() != null && Listsingleton.b().a().size() > 0) {
                    SharepreferenceDBHandler.setEventAdsView(0, NSTEXOPlayerSkyTvActivity.this);
                    NSTEXOPlayerSkyTvActivity.r2(NSTEXOPlayerSkyTvActivity.this, "");
                    NSTEXOPlayerSkyTvActivity.s2(NSTEXOPlayerSkyTvActivity.this, "", "", "", adapterView, view, i, j, this.a);
                    return;
                }
            } else {
                NSTEXOPlayerSkyTvActivity.this.o.setVisibility(8);
            }
            NSTEXOPlayerSkyTvActivity.t2(NSTEXOPlayerSkyTvActivity.this, adapterView, view, i, j, this.a);
        }
    }

    public class c implements AdapterView.OnItemLongClickListener {

        public class a implements PopupMenu.OnMenuItemClickListener {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ int c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;
            public final /* synthetic */ String f;

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

                /* JADX WARN: Removed duplicated region for block: B:18:0x006d A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:10:0x0008, B:12:0x0014, B:14:0x002f, B:15:0x0039, B:16:0x005b, B:18:0x006d, B:19:0x007b, B:20:0x00ab, B:22:0x007f, B:24:0x0091, B:25:0x009c, B:26:0x0040, B:28:0x0050), top: B:9:0x0008 }] */
                /* JADX WARN: Removed duplicated region for block: B:22:0x007f A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:10:0x0008, B:12:0x0014, B:14:0x002f, B:15:0x0039, B:16:0x005b, B:18:0x006d, B:19:0x007b, B:20:0x00ab, B:22:0x007f, B:24:0x0091, B:25:0x009c, B:26:0x0040, B:28:0x0050), top: B:9:0x0008 }] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onClick(android.view.View r2) {
                    /*
                        r1 = this;
                        int r2 = r2.getId()
                        int r0 = a7.f.u1
                        if (r2 != r0) goto Ld1
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.f2(r2)     // Catch: java.lang.Exception -> L3d
                        if (r2 != 0) goto L40
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.content.Context r0 = r2.f     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r0 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.w3(r0)     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.g2(r2, r0)     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.f2(r2)     // Catch: java.lang.Exception -> L3d
                        if (r2 == 0) goto L5b
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.f2(r2)     // Catch: java.lang.Exception -> L3d
                    L39:
                        r2.show()     // Catch: java.lang.Exception -> L3d
                        goto L5b
                    L3d:
                        r2 = move-exception
                        goto Lcd
                    L40:
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.f2(r2)     // Catch: java.lang.Exception -> L3d
                        boolean r2 = r2.isShowing()     // Catch: java.lang.Exception -> L3d
                        if (r2 != 0) goto L5b
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        android.app.ProgressDialog r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.f2(r2)     // Catch: java.lang.Exception -> L3d
                        goto L39
                    L5b:
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.v2(r2)     // Catch: java.lang.Exception -> L3d
                        java.lang.String r0 = "m3u"
                        boolean r2 = r2.equals(r0)     // Catch: java.lang.Exception -> L3d
                        if (r2 == 0) goto L7f
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler r0 = r2.R     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = r2.E     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L3d
                    L7b:
                        r0.deleteLiveRecentlyWatched(r2)     // Catch: java.lang.Exception -> L3d
                        goto Lab
                    L7f:
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.v2(r2)     // Catch: java.lang.Exception -> L3d
                        java.lang.String r0 = "onestream_api"
                        boolean r2 = r2.equals(r0)     // Catch: java.lang.Exception -> L3d
                        if (r2 == 0) goto L9c
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler r0 = r2.R     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = r2.d     // Catch: java.lang.Exception -> L3d
                        goto L7b
                    L9c:
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler r0 = r2.R     // Catch: java.lang.Exception -> L3d
                        int r2 = r2.D     // Catch: java.lang.Exception -> L3d
                        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L3d
                        goto L7b
                    Lab:
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        java.lang.String r0 = "-6"
                        r2.b4(r0)     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        q7.N r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.i2(r2)     // Catch: java.lang.Exception -> L3d
                        r2.w()     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c$a r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$c r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.this     // Catch: java.lang.Exception -> L3d
                        com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L3d
                        r2.S3()     // Catch: java.lang.Exception -> L3d
                        goto Ld8
                    Lcd:
                        r2.printStackTrace()
                        goto Ld8
                    Ld1:
                        int r0 = a7.f.h1
                        if (r2 != r0) goto Ld8
                        r1.dismiss()
                    Ld8:
                        r1.dismiss()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.a.onClick(android.view.View):void");
                }

                public void onCreate(Bundle bundle) {
                    try {
                        super.onCreate(bundle);
                        setContentView(NSTEXOPlayerSkyTvActivity.G1(NSTEXOPlayerSkyTvActivity.this).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
                        this.c = findViewById(a7.f.u1);
                        this.d = findViewById(a7.f.h1);
                        this.f = findViewById(a7.f.V8);
                        this.g = findViewById(a7.f.Ia);
                        TextView findViewById = findViewById(a7.f.um);
                        this.e = findViewById;
                        findViewById.setText(NSTEXOPlayerSkyTvActivity.this.f.getResources().getString(a7.j.Y8));
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

            public a(String str, String str2, int i, String str3, String str4, String str5) {
                this.a = str;
                this.b = str2;
                this.c = i;
                this.d = str3;
                this.e = str4;
                this.f = str5;
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
            
                r4 = r11.g.a;
                r4.u2 = true;
                r4.o4();
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
            
                if (com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.v2(r11.g.a).equals("m3u") == false) goto L20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
            
                r4 = r11.g.a;
                r5 = r4.E;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
            
                r4.P = r5;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
            
                r4 = new android.content.Intent(r11.g.a.f, com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity.class);
                r4.putExtra("url", r11.g.a.P);
                r4.putExtra("app_name", ((com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) r11.g.a.I2.get(r3)).getAppname());
                r4.putExtra("packagename", ((com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) r11.g.a.I2.get(r3)).getPackagename());
                r11.g.a.f.startActivity(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
            
                r4 = r11.g.a;
                r5 = m7.w.V(r4.f, r4.D, r4.g0, "live");
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onMenuItemClick(android.view.MenuItem r12) {
                /*
                    Method dump skipped, instructions count: 547
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.a.onMenuItemClick(android.view.MenuItem):boolean");
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

        /* JADX WARN: Removed duplicated region for block: B:26:0x025f A[Catch: Exception -> 0x02e7, TRY_LEAVE, TryCatch #1 {Exception -> 0x02e7, blocks: (B:3:0x0005, B:5:0x000d, B:8:0x001b, B:10:0x0021, B:11:0x0123, B:13:0x0149, B:14:0x0160, B:17:0x0172, B:19:0x0182, B:21:0x0188, B:22:0x0190, B:24:0x023d, B:26:0x025f, B:40:0x0298, B:41:0x029b, B:45:0x0194, B:46:0x01a4, B:48:0x01b2, B:50:0x01c7, B:52:0x01d3, B:54:0x01e3, B:55:0x01ec, B:56:0x01f5, B:57:0x01fe, B:59:0x0221, B:61:0x0227, B:62:0x022f, B:63:0x0233, B:64:0x0155, B:65:0x007d, B:67:0x0085, B:69:0x0091, B:28:0x0267, B:30:0x026d, B:33:0x0274, B:35:0x027e), top: B:2:0x0005, inners: #0 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onItemLongClick(android.widget.AdapterView r21, android.view.View r22, int r23, long r24) {
            /*
                Method dump skipped, instructions count: 745
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.c.onItemLongClick(android.widget.AdapterView, android.view.View, int, long):boolean");
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.K2(NSTEXOPlayerSkyTvActivity.this);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", false);
            NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", false);
            NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", false);
            NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", false);
            NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", false);
            NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class j implements Runnable {
        public j() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", false);
            NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        public void onClick(View view) {
            NSTEXOPlayerSkyTvActivity.this.C3();
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
            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity;
            if (view.getId() == a7.f.u1) {
                try {
                    if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) == null) {
                        NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity2 = NSTEXOPlayerSkyTvActivity.this;
                        NSTEXOPlayerSkyTvActivity.g2(nSTEXOPlayerSkyTvActivity2, NSTEXOPlayerSkyTvActivity.w3(nSTEXOPlayerSkyTvActivity2.f));
                        if (NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this) != null) {
                            nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                            NSTEXOPlayerSkyTvActivity.f2(nSTEXOPlayerSkyTvActivity).show();
                        }
                        NSTEXOPlayerSkyTvActivity.this.R.deleteALLLiveRecentlyWatched();
                        NSTEXOPlayerSkyTvActivity.this.b4("-6");
                        NSTEXOPlayerSkyTvActivity.i2(NSTEXOPlayerSkyTvActivity.this).w();
                        NSTEXOPlayerSkyTvActivity.this.S3();
                    } else {
                        if (!NSTEXOPlayerSkyTvActivity.f2(NSTEXOPlayerSkyTvActivity.this).isShowing()) {
                            nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                            NSTEXOPlayerSkyTvActivity.f2(nSTEXOPlayerSkyTvActivity).show();
                        }
                        NSTEXOPlayerSkyTvActivity.this.R.deleteALLLiveRecentlyWatched();
                        NSTEXOPlayerSkyTvActivity.this.b4("-6");
                        NSTEXOPlayerSkyTvActivity.i2(NSTEXOPlayerSkyTvActivity.this).w();
                        NSTEXOPlayerSkyTvActivity.this.S3();
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
                setContentView(NSTEXOPlayerSkyTvActivity.G1(NSTEXOPlayerSkyTvActivity.this).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
                this.c = findViewById(a7.f.u1);
                this.d = findViewById(a7.f.h1);
                this.f = findViewById(a7.f.V8);
                this.g = findViewById(a7.f.Ia);
                TextView findViewById = findViewById(a7.f.um);
                this.e = findViewById;
                findViewById.setText(NSTEXOPlayerSkyTvActivity.this.getResources().getString(a7.j.V8));
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
        public m() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", false);
            NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class n implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", false);
                NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                NSTEXOPlayerSkyTvActivity.this.Q1.setText("");
                NSTEXOPlayerSkyTvActivity.this.P1.setVisibility(8);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                NSTEXOPlayerSkyTvActivity.this.Q1.setText("");
                NSTEXOPlayerSkyTvActivity.this.P1.setVisibility(8);
            }
        }

        public n() {
        }

        public void run() {
            ArrayList channelDetails;
            Handler handler;
            Runnable cVar;
            boolean z;
            ArrayList allLiveStreasWithCategoryId;
            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
            nSTEXOPlayerSkyTvActivity.R0 = nSTEXOPlayerSkyTvActivity.O1.toString();
            NSTEXOPlayerSkyTvActivity.this.Q1.setText("");
            NSTEXOPlayerSkyTvActivity.this.P1.setVisibility(8);
            if (NSTEXOPlayerSkyTvActivity.F1(NSTEXOPlayerSkyTvActivity.this).equals("true")) {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity2 = NSTEXOPlayerSkyTvActivity.this;
                channelDetails = nSTEXOPlayerSkyTvActivity2.R.getChannelDetails(nSTEXOPlayerSkyTvActivity2.R0, "radio_streams");
            } else {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity3 = NSTEXOPlayerSkyTvActivity.this;
                channelDetails = nSTEXOPlayerSkyTvActivity3.R.getChannelDetails(nSTEXOPlayerSkyTvActivity3.R0, "live");
            }
            NSTEXOPlayerSkyTvActivity.this.O1.setLength(0);
            if (channelDetails == null || channelDetails.size() == 0) {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity4 = NSTEXOPlayerSkyTvActivity.this;
                nSTEXOPlayerSkyTvActivity4.Q1.setText(nSTEXOPlayerSkyTvActivity4.f.getResources().getString(a7.j.g4));
                NSTEXOPlayerSkyTvActivity.this.P1.setVisibility(0);
                handler = new Handler();
                cVar = new c();
            } else {
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity5 = NSTEXOPlayerSkyTvActivity.this;
                if (nSTEXOPlayerSkyTvActivity5.R.getParentalStatusCount(SharepreferenceDBHandler.getUserID(nSTEXOPlayerSkyTvActivity5.f)) <= 0 || NSTEXOPlayerSkyTvActivity.w1(NSTEXOPlayerSkyTvActivity.this) == null) {
                    z = false;
                } else {
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity6 = NSTEXOPlayerSkyTvActivity.this;
                    z = NSTEXOPlayerSkyTvActivity.L2(nSTEXOPlayerSkyTvActivity6, channelDetails, NSTEXOPlayerSkyTvActivity.w1(nSTEXOPlayerSkyTvActivity6));
                }
                if (!z) {
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity7 = NSTEXOPlayerSkyTvActivity.this;
                    nSTEXOPlayerSkyTvActivity7.P0 = true;
                    nSTEXOPlayerSkyTvActivity7.Q0 = true;
                    nSTEXOPlayerSkyTvActivity7.Y0 = "0";
                    nSTEXOPlayerSkyTvActivity7.Z0 = nSTEXOPlayerSkyTvActivity7.f.getResources().getString(a7.j.x);
                    NSTEXOPlayerSkyTvActivity.M2(NSTEXOPlayerSkyTvActivity.this, 0);
                    String num = ((LiveStreamsDBModel) channelDetails.get(0)).getNum();
                    String streamId = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamId();
                    String name = ((LiveStreamsDBModel) channelDetails.get(0)).getName();
                    String epgChannelId = ((LiveStreamsDBModel) channelDetails.get(0)).getEpgChannelId();
                    String streamIcon = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIcon();
                    String url = ((LiveStreamsDBModel) channelDetails.get(0)).getUrl();
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity8 = NSTEXOPlayerSkyTvActivity.this;
                    nSTEXOPlayerSkyTvActivity8.w1 = url;
                    NSTEXOPlayerSkyTvActivity.N2(nSTEXOPlayerSkyTvActivity8, m7.w.r0(nSTEXOPlayerSkyTvActivity8.R0));
                    NSTEXOPlayerSkyTvActivity.O2(NSTEXOPlayerSkyTvActivity.this, "0");
                    NSTEXOPlayerSkyTvActivity.A1(NSTEXOPlayerSkyTvActivity.this).setTitle(NSTEXOPlayerSkyTvActivity.this.R0 + " - " + name);
                    if (NSTEXOPlayerSkyTvActivity.F1(NSTEXOPlayerSkyTvActivity.this).equals("true")) {
                        NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity9 = NSTEXOPlayerSkyTvActivity.this;
                        allLiveStreasWithCategoryId = nSTEXOPlayerSkyTvActivity9.R.getAllLiveStreasWithCategoryId(nSTEXOPlayerSkyTvActivity9.Y0, "radio_streams");
                    } else {
                        NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity10 = NSTEXOPlayerSkyTvActivity.this;
                        allLiveStreasWithCategoryId = nSTEXOPlayerSkyTvActivity10.R.getAllLiveStreasWithCategoryId(nSTEXOPlayerSkyTvActivity10.Y0, "live");
                    }
                    if (allLiveStreasWithCategoryId != null) {
                        NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).clear();
                    }
                    NSTEXOPlayerSkyTvActivity.D1(NSTEXOPlayerSkyTvActivity.this, allLiveStreasWithCategoryId);
                    if (NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this) != null && NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).size() > 0) {
                        int i = 0;
                        while (true) {
                            if (i < NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).size()) {
                                if (((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.C1(NSTEXOPlayerSkyTvActivity.this).get(i)).getNum().equals(num)) {
                                    NSTEXOPlayerSkyTvActivity.A1(NSTEXOPlayerSkyTvActivity.this).setCurrentWindowIndex(i);
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                    try {
                        if (streamIcon.equals("") || streamIcon.isEmpty()) {
                            NSTEXOPlayerSkyTvActivity.P2(NSTEXOPlayerSkyTvActivity.this).setImageDrawable(NSTEXOPlayerSkyTvActivity.this.f.getResources().getDrawable(a7.e.i1));
                        } else {
                            com.squareup.picasso.t.q(NSTEXOPlayerSkyTvActivity.this.f).l(streamIcon).j(a7.e.i1).d(a7.e.i1).k(80, 55).g(NSTEXOPlayerSkyTvActivity.P2(NSTEXOPlayerSkyTvActivity.this));
                        }
                    } catch (Exception unused) {
                        NSTEXOPlayerSkyTvActivity.P2(NSTEXOPlayerSkyTvActivity.this).setImageDrawable(NSTEXOPlayerSkyTvActivity.this.f.getResources().getDrawable(a7.e.i1));
                    }
                    NSTEXOPlayerSkyTvActivity.A1(NSTEXOPlayerSkyTvActivity.this).E();
                    if (NSTEXOPlayerSkyTvActivity.y2(NSTEXOPlayerSkyTvActivity.this).booleanValue()) {
                        if (NSTEXOPlayerSkyTvActivity.v2(NSTEXOPlayerSkyTvActivity.this).equals("m3u")) {
                            NSTEXOPlayerSkyTvActivity.Q2(NSTEXOPlayerSkyTvActivity.this, Uri.parse(url));
                            NSTEXOPlayerSkyTvActivity.A1(NSTEXOPlayerSkyTvActivity.this).u(Boolean.valueOf(NSTEXOPlayerSkyTvActivity.L5));
                            x7.a.f().A(NSTEXOPlayerSkyTvActivity.this.w1);
                        } else {
                            NSTEXOPlayerSkyTvActivity.Q2(NSTEXOPlayerSkyTvActivity.this, Uri.parse(url));
                            NSTEXOPlayerSkyTvActivity.A1(NSTEXOPlayerSkyTvActivity.this).u(Boolean.valueOf(NSTEXOPlayerSkyTvActivity.L5));
                            x7.a.f().A(streamId);
                        }
                        NSTEXOPlayerSkyTvActivity.R2(NSTEXOPlayerSkyTvActivity.this);
                        NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity11 = NSTEXOPlayerSkyTvActivity.this;
                        nSTEXOPlayerSkyTvActivity11.w4 = 0;
                        nSTEXOPlayerSkyTvActivity11.y4 = false;
                        NSTEXOPlayerSkyTvActivity.j2(nSTEXOPlayerSkyTvActivity11, Boolean.FALSE);
                        NSTEXOPlayerSkyTvActivity.this.I1.removeCallbacksAndMessages((Object) null);
                        NSTEXOPlayerSkyTvActivity.this.I1.postDelayed(new a(), 5000L);
                        NSTEXOPlayerSkyTvActivity.this.F4();
                        NSTEXOPlayerSkyTvActivity.this.z4();
                        NSTEXOPlayerSkyTvActivity.S2(NSTEXOPlayerSkyTvActivity.this, 5000);
                    }
                    NSTEXOPlayerSkyTvActivity.this.G1.removeCallbacksAndMessages((Object) null);
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity12 = NSTEXOPlayerSkyTvActivity.this;
                    nSTEXOPlayerSkyTvActivity12.F = epgChannelId;
                    nSTEXOPlayerSkyTvActivity12.G = streamIcon;
                    NSTEXOPlayerSkyTvActivity.A1(nSTEXOPlayerSkyTvActivity12).setCurrentEpgChannelID(NSTEXOPlayerSkyTvActivity.this.F);
                    NSTEXOPlayerSkyTvActivity.A1(NSTEXOPlayerSkyTvActivity.this).setCurrentChannelLogo(NSTEXOPlayerSkyTvActivity.this.G);
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity13 = NSTEXOPlayerSkyTvActivity.this;
                    nSTEXOPlayerSkyTvActivity13.I4(nSTEXOPlayerSkyTvActivity13.G);
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity14 = NSTEXOPlayerSkyTvActivity.this;
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity15 = NSTEXOPlayerSkyTvActivity.this;
                    NSTEXOPlayerSkyTvActivity.p2(nSTEXOPlayerSkyTvActivity14, new R(nSTEXOPlayerSkyTvActivity15, nSTEXOPlayerSkyTvActivity15.F, null).execute(new String[0]));
                    NSTEXOPlayerSkyTvActivity.this.F1.removeCallbacksAndMessages((Object) null);
                    NSTEXOPlayerSkyTvActivity.this.v1 = m7.w.q0(streamId);
                    if (NSTEXOPlayerSkyTvActivity.T2(NSTEXOPlayerSkyTvActivity.this) != null) {
                        NSTEXOPlayerSkyTvActivity.T2(NSTEXOPlayerSkyTvActivity.this).putString("currentlyPlayingVideo", streamId);
                        NSTEXOPlayerSkyTvActivity.T2(NSTEXOPlayerSkyTvActivity.this).putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", url);
                        NSTEXOPlayerSkyTvActivity.T2(NSTEXOPlayerSkyTvActivity.this).apply();
                    }
                    channelDetails.clear();
                    return;
                }
                NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity16 = NSTEXOPlayerSkyTvActivity.this;
                nSTEXOPlayerSkyTvActivity16.Q1.setText(nSTEXOPlayerSkyTvActivity16.f.getResources().getString(a7.j.g4));
                NSTEXOPlayerSkyTvActivity.this.P1.setVisibility(0);
                handler = new Handler();
                cVar = new b();
            }
            handler.postDelayed(cVar, 1000L);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", false);
            NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class p implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public p(int i, String str, String str2) {
            this.a = i;
            this.c = str;
            this.d = str2;
        }

        public void run() {
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("stalker_api")) {
                NSTEXOPlayerSkyTvActivity.U2(NSTEXOPlayerSkyTvActivity.this, this.a, this.c, this.d);
                return;
            }
            m7.w.N0(NSTEXOPlayerSkyTvActivity.this.f);
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTEXOPlayerSkyTvActivity.this.f);
            try {
                NSTEXOPlayerSkyTvActivity.U1(NSTEXOPlayerSkyTvActivity.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(NSTEXOPlayerSkyTvActivity.this.f), stalkerToken, ((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.z1(NSTEXOPlayerSkyTvActivity.this).get(this.a)).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "zappingLeft", this.a, this.c, this.d);
            } catch (Exception unused) {
            }
        }
    }

    public class q implements Runnable {
        public q() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.h2(NSTEXOPlayerSkyTvActivity.this, "", false);
            NSTEXOPlayerSkyTvActivity.j2(NSTEXOPlayerSkyTvActivity.this, Boolean.TRUE);
        }
    }

    public class r implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public r(int i, String str, String str2) {
            this.a = i;
            this.c = str;
            this.d = str2;
        }

        public void run() {
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyTvActivity.this.f).equals("stalker_api")) {
                NSTEXOPlayerSkyTvActivity.V2(NSTEXOPlayerSkyTvActivity.this, this.a, this.c, this.d);
                return;
            }
            m7.w.N0(NSTEXOPlayerSkyTvActivity.this.f);
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTEXOPlayerSkyTvActivity.this.f);
            try {
                NSTEXOPlayerSkyTvActivity.U1(NSTEXOPlayerSkyTvActivity.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(NSTEXOPlayerSkyTvActivity.this.f), stalkerToken, ((LiveStreamsDBModel) NSTEXOPlayerSkyTvActivity.z1(NSTEXOPlayerSkyTvActivity.this).get(this.a)).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "zappingRight", this.a, this.c, this.d);
            } catch (Exception unused) {
            }
        }
    }

    public class s implements TextWatcher {
        public s() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity;
            boolean z;
            if (charSequence == null || charSequence.toString().length() <= 0) {
                nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                z = false;
            } else {
                nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                z = true;
            }
            NSTEXOPlayerSkyTvActivity.X2(nSTEXOPlayerSkyTvActivity, z);
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
                com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L34
                boolean r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.W2(r2)     // Catch: java.lang.Exception -> L34
                if (r2 == 0) goto L34
            L14:
                com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L34
                q7.N r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.i2(r2)     // Catch: java.lang.Exception -> L34
                if (r2 == 0) goto L34
                com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.this     // Catch: java.lang.Exception -> L34
                q7.N r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.i2(r2)     // Catch: java.lang.Exception -> L34
                android.widget.Filter r2 = r2.getFilter()     // Catch: java.lang.Exception -> L34
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L34
                r2.filter(r1)     // Catch: java.lang.Exception -> L34
                java.lang.String r1 = "honey"
                java.lang.String r2 = "onTextChanged: notify"
                android.util.Log.e(r1, r2)     // Catch: java.lang.Exception -> L34
            L34:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.s.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }
    }

    public class t implements Runnable {
        public t() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.this.P3();
        }
    }

    public class u implements Runnable {
        public u() {
        }

        public void run() {
            NSTEXOPlayerSkyTvActivity.K2(NSTEXOPlayerSkyTvActivity.this);
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public v() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
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
                    NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity = NSTEXOPlayerSkyTvActivity.this;
                    nSTEXOPlayerSkyTvActivity.b4(NSTEXOPlayerSkyTvActivity.F2(nSTEXOPlayerSkyTvActivity));
                    dismiss();
                } catch (Exception unused) {
                }
            } else if (view.getId() == a7.f.h1) {
                dismiss();
            }
            dismiss();
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x00cb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onCreate(android.os.Bundle r13) {
            /*
                Method dump skipped, instructions count: 282
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.x.onCreate(android.os.Bundle):void");
        }
    }

    public class y implements DialogInterface.OnClickListener {
        public y() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            m7.w.n0(NSTEXOPlayerSkyTvActivity.this.f);
        }
    }

    public class z implements SearchView.m {
        public z() {
        }

        public boolean onQueryTextChange(String str) {
            if (NSTEXOPlayerSkyTvActivity.u2(NSTEXOPlayerSkyTvActivity.this) == null) {
                return false;
            }
            NSTEXOPlayerSkyTvActivity.u2(NSTEXOPlayerSkyTvActivity.this).getFilter().filter(str);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public NSTEXOPlayerSkyTvActivity() {
        Boolean bool = Boolean.FALSE;
        this.S1 = bool;
        this.T1 = bool;
        this.X1 = "";
        this.d2 = "";
        this.e2 = bool;
        this.g2 = "";
        Boolean bool2 = Boolean.TRUE;
        this.h2 = bool2;
        this.i2 = null;
        this.k2 = -1;
        this.l2 = 0;
        this.m2 = "";
        this.n2 = bool2;
        this.o2 = null;
        this.p2 = null;
        this.q2 = null;
        this.s2 = false;
        this.t2 = 0;
        this.u2 = false;
        this.v2 = 4;
        this.w2 = O5[0];
        this.z2 = bool;
        this.A2 = bool;
        this.B2 = bool;
        this.C2 = bool;
        this.D2 = bool;
        this.E2 = bool;
        this.J2 = 0;
        this.K2 = "0";
        this.L2 = "0";
        this.M2 = bool2;
        this.L3 = "mobile";
        this.S3 = 0;
        this.V3 = "";
        this.W3 = "false";
        this.X3 = "false";
        this.Y3 = "-10";
        this.Z3 = 0;
        this.b4 = "";
        this.c4 = "";
        this.d4 = 0;
        this.e4 = 0;
        this.h4 = 0;
        this.i4 = false;
        this.j4 = true;
        this.l4 = null;
        this.m4 = bool;
        this.n4 = false;
        this.o4 = "";
        this.p4 = "";
        this.q4 = 0;
        this.w4 = 0;
        this.x4 = 5;
        this.y4 = false;
        this.z4 = false;
        this.C4 = "";
        this.D4 = "";
        this.t5 = "Live";
        this.u5 = "";
        this.x5 = "";
        this.y5 = "";
        this.z5 = "";
        this.B5 = "";
        this.F5 = "";
        this.G5 = 0;
        this.H5 = null;
        this.I5 = new ArrayList();
    }

    public static /* synthetic */ PlayerView A1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.b2;
    }

    public static /* synthetic */ int A2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2) {
        nSTEXOPlayerSkyTvActivity.h4 = i2;
        return i2;
    }

    public static /* synthetic */ int B1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2) {
        nSTEXOPlayerSkyTvActivity.t2 = i2;
        return i2;
    }

    public static /* synthetic */ int B2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2) {
        nSTEXOPlayerSkyTvActivity.q4 = i2;
        return i2;
    }

    private void B3() {
        ImageView imageView = this.a3;
        imageView.setOnFocusChangeListener(new O(imageView));
        ImageView imageView2 = this.b3;
        imageView2.setOnFocusChangeListener(new O(imageView2));
        ImageView imageView3 = this.e3;
        imageView3.setOnFocusChangeListener(new O(imageView3));
        ImageView imageView4 = this.f3;
        imageView4.setOnFocusChangeListener(new O(imageView4));
        LinearLayout linearLayout = this.m3;
        linearLayout.setOnFocusChangeListener(new O(linearLayout));
        LinearLayout linearLayout2 = this.n3;
        linearLayout2.setOnFocusChangeListener(new O(linearLayout2));
        LinearLayout linearLayout3 = this.o3;
        linearLayout3.setOnFocusChangeListener(new O(linearLayout3));
        LinearLayout linearLayout4 = this.V2;
        linearLayout4.setOnFocusChangeListener(new O(linearLayout4));
        LinearLayout linearLayout5 = this.l3;
        linearLayout5.setOnFocusChangeListener(new O(linearLayout5));
        ImageView imageView5 = this.c3;
        imageView5.setOnFocusChangeListener(new O(imageView5));
        ImageView imageView6 = this.d3;
        imageView6.setOnFocusChangeListener(new O(imageView6));
        RelativeLayout relativeLayout = this.z3;
        relativeLayout.setOnFocusChangeListener(new O(relativeLayout));
        ImageView imageView7 = this.l5;
        imageView7.setOnFocusChangeListener(new O(imageView7));
        RelativeLayout relativeLayout2 = this.m5;
        relativeLayout2.setOnFocusChangeListener(new O(relativeLayout2));
        ImageView imageView8 = this.l5;
        imageView8.setOnFocusChangeListener(new O(imageView8));
        LinearLayout linearLayout6 = this.n5;
        linearLayout6.setOnFocusChangeListener(new O(linearLayout6));
        LinearLayout linearLayout7 = this.o5;
        linearLayout7.setOnFocusChangeListener(new O(linearLayout7));
        CheckBox checkBox = this.I4;
        checkBox.setOnFocusChangeListener(new O(checkBox));
        CheckBox checkBox2 = this.J4;
        checkBox2.setOnFocusChangeListener(new O(checkBox2));
        CheckBox checkBox3 = this.K4;
        checkBox3.setOnFocusChangeListener(new O(checkBox3));
        CheckBox checkBox4 = this.L4;
        checkBox4.setOnFocusChangeListener(new O(checkBox4));
        LinearLayout linearLayout8 = this.p5;
        linearLayout8.setOnFocusChangeListener(new O(linearLayout8));
        CheckBox checkBox5 = this.M4;
        checkBox5.setOnFocusChangeListener(new O(checkBox5));
        CheckBox checkBox6 = this.N4;
        checkBox6.setOnFocusChangeListener(new O(checkBox6));
        CheckBox checkBox7 = this.O4;
        checkBox7.setOnFocusChangeListener(new O(checkBox7));
        CheckBox checkBox8 = this.P4;
        checkBox8.setOnFocusChangeListener(new O(checkBox8));
        CheckBox checkBox9 = this.Q4;
        checkBox9.setOnFocusChangeListener(new O(checkBox9));
        LinearLayout linearLayout9 = this.q5;
        linearLayout9.setOnFocusChangeListener(new O(linearLayout9));
        LinearLayout linearLayout10 = this.r5;
        linearLayout10.setOnFocusChangeListener(new O(linearLayout10));
        CheckBox checkBox10 = this.S4;
        checkBox10.setOnFocusChangeListener(new O(checkBox10));
        CheckBox checkBox11 = this.T4;
        checkBox11.setOnFocusChangeListener(new O(checkBox11));
        CheckBox checkBox12 = this.U4;
        checkBox12.setOnFocusChangeListener(new O(checkBox12));
        CheckBox checkBox13 = this.V4;
        checkBox13.setOnFocusChangeListener(new O(checkBox13));
        EditText editText = this.g5;
        editText.setOnFocusChangeListener(new O(editText));
        TextView textView = this.H4;
        textView.setOnFocusChangeListener(new O(textView));
    }

    private void B4() {
        LinearLayout linearLayout;
        if (this.V3.equals("player")) {
            linearLayout = this.y;
            if (linearLayout == null) {
                return;
            }
        } else {
            linearLayout = this.x;
            if (linearLayout == null) {
                return;
            }
        }
        linearLayout.setVisibility(0);
    }

    public static /* synthetic */ ArrayList C1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.r0;
    }

    public static /* synthetic */ void C2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2, String str) {
        nSTEXOPlayerSkyTvActivity.c3(i2, str);
    }

    private void C4(Activity activity) {
        new x((NSTEXOPlayerSkyTvActivity) activity, activity).show();
    }

    public static /* synthetic */ ArrayList D1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, ArrayList arrayList) {
        nSTEXOPlayerSkyTvActivity.r0 = arrayList;
        return arrayList;
    }

    public static /* synthetic */ void D2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str, int i2, String str2, String str3, String str4, int i3, String str5) {
        nSTEXOPlayerSkyTvActivity.d3(str, i2, str2, str3, str4, i3, str5);
    }

    public static String D3(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    private void D4() {
        if (this.A4 || !com.nst.iptvsmarterstvbox.view.demo.b.b0(this.r4)) {
            return;
        }
        this.A4 = true;
        com.nst.iptvsmarterstvbox.view.demo.b.P(this.r4, new r7.p(this)).show(getSupportFragmentManager(), (String) null);
    }

    public static /* synthetic */ ArrayList E1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.p0;
    }

    public static /* synthetic */ void E2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str, String str2, int i2) {
        nSTEXOPlayerSkyTvActivity.r4(str, str2, i2);
    }

    private void E4() {
        float f2;
        ProgressDialog progressDialog;
        try {
            if (m7.a.Y.booleanValue()) {
                findViewById(a7.f.p).setOnClickListener(this);
            }
            this.U0.setVisibility(0);
            this.V0.setVisibility(0);
            this.W0.setVisibility(0);
            try {
                f2 = TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
            } catch (Exception unused) {
                f2 = 8.0f;
            }
            int i2 = (int) f2;
            this.T0.setPadding(i2, i2, i2, i2);
            RelativeLayout relativeLayout = this.Y2;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            LinearLayout.LayoutParams layoutParams = this.X0.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = 0;
            this.X0.setLayoutParams(layoutParams);
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            L5 = false;
            ListView listView = this.I;
            if (listView != null) {
                listView.requestFocus();
            }
            if (this.m4.booleanValue()) {
                return;
            }
            ProgressDialog progressDialog2 = this.r2;
            if (progressDialog2 == null) {
                progressDialog = w3(this.f);
                this.r2 = progressDialog;
                if (progressDialog != null) {
                    progressDialog.show();
                }
            } else if (!progressDialog2.isShowing()) {
                progressDialog = this.r2;
                progressDialog.show();
            }
            this.I1.removeCallbacksAndMessages((Object) null);
            v4("", false);
            this.m4 = Boolean.TRUE;
        } catch (Exception e2) {
            Log.e("exection", "" + e2);
        }
    }

    public static /* synthetic */ String F1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.X3;
    }

    public static /* synthetic */ String F2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.L2;
    }

    public static /* synthetic */ u7.a G1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.F2;
    }

    public static /* synthetic */ void G2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str, int i2, String str2, String str3, int i3) {
        nSTEXOPlayerSkyTvActivity.q4(str, i2, str2, str3, i3);
    }

    public static /* synthetic */ SharedPreferences H1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, SharedPreferences sharedPreferences) {
        nSTEXOPlayerSkyTvActivity.X = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ void H2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2, String str) {
        nSTEXOPlayerSkyTvActivity.p4(i2, str);
    }

    private void H4() {
        F4();
        if (this.S2.getVisibility() == 0) {
            O3();
        } else {
            z4();
            n3(5000);
        }
    }

    public static /* synthetic */ SharedPreferences I1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.W;
    }

    public static /* synthetic */ SharedPreferences I2() {
        return K5;
    }

    public static /* synthetic */ AsyncTask J1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.o2;
    }

    public static /* synthetic */ SharedPreferences J2(SharedPreferences sharedPreferences) {
        K5 = sharedPreferences;
        return sharedPreferences;
    }

    private ArrayList J3() {
        ArrayList allPasswordStatus = this.R.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.f));
        this.B0 = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.z0.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.z0;
    }

    public static /* synthetic */ String K1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.V3;
    }

    public static /* synthetic */ void K2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        nSTEXOPlayerSkyTvActivity.O3();
    }

    private boolean K3(ArrayList arrayList, ArrayList arrayList2) {
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

    private void K4(int i2, String str, String str2) {
        PlayerView playerView;
        boolean z2;
        try {
            ArrayList arrayList = this.v0;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            if (this.Y1.equals("m3u")) {
                this.v4 = Uri.parse(str2);
                playerView = this.b2;
                z2 = L5;
            } else if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
                this.v4 = Uri.parse(this.c4);
                playerView = this.b2;
                z2 = L5;
            } else {
                this.v4 = Uri.parse(this.g + m7.w.q0(((LiveStreamsDBModel) this.v0.get(i2)).getStreamId()) + this.g0);
                playerView = this.b2;
                z2 = L5;
            }
            playerView.u(Boolean.valueOf(z2));
            U3();
            this.w4 = 0;
            this.y4 = false;
            this.G1.removeCallbacksAndMessages((Object) null);
            this.F = ((LiveStreamsDBModel) this.v0.get(i2)).getEpgChannelId();
            this.G = ((LiveStreamsDBModel) this.v0.get(i2)).getStreamIcon();
            this.b2.setCurrentEpgChannelID(this.F);
            this.b2.setCurrentChannelLogo(this.G);
            I4(this.G);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
                J4(((LiveStreamsDBModel) this.v0.get(i2)).getStreamId());
            } else {
                this.q2 = new R(this, this.F, null).execute(new String[0]);
            }
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ String L1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str) {
        nSTEXOPlayerSkyTvActivity.V3 = str;
        return str;
    }

    public static /* synthetic */ boolean L2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, ArrayList arrayList, ArrayList arrayList2) {
        return nSTEXOPlayerSkyTvActivity.K3(arrayList, arrayList2);
    }

    private ArrayList L3(ArrayList arrayList, ArrayList arrayList2) {
        try {
            this.E0 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        this.E0.add(favouriteDBModel);
                        break;
                    }
                    if (favouriteDBModel.getCategoryID().equals((String) it2.next())) {
                        break;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return this.E0;
    }

    private void L4(int i2, String str, String str2) {
        PlayerView playerView;
        boolean z2;
        try {
            ArrayList arrayList = this.v0;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            if (this.Y1.equals("m3u")) {
                this.v4 = Uri.parse(str2);
                playerView = this.b2;
                z2 = L5;
            } else if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
                this.v4 = Uri.parse(this.c4);
                playerView = this.b2;
                z2 = L5;
            } else {
                this.v4 = Uri.parse(this.g + m7.w.q0(((LiveStreamsDBModel) this.v0.get(i2)).getStreamId()) + this.g0);
                playerView = this.b2;
                z2 = L5;
            }
            playerView.u(Boolean.valueOf(z2));
            U3();
            this.w4 = 0;
            this.y4 = false;
            this.G1.removeCallbacksAndMessages((Object) null);
            this.F = ((LiveStreamsDBModel) this.v0.get(i2)).getEpgChannelId();
            this.G = ((LiveStreamsDBModel) this.v0.get(i2)).getStreamIcon();
            this.b2.setCurrentEpgChannelID(this.F);
            this.b2.setCurrentChannelLogo(this.G);
            I4(this.G);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
                J4(((LiveStreamsDBModel) this.v0.get(i2)).getStreamId());
            } else {
                this.q2 = new R(this, this.F, null).execute(new String[0]);
            }
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void M1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        nSTEXOPlayerSkyTvActivity.B4();
    }

    public static /* synthetic */ int M2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2) {
        nSTEXOPlayerSkyTvActivity.i0 = i2;
        return i2;
    }

    private ArrayList M3(ArrayList arrayList, ArrayList arrayList2) {
        this.F0 = new ArrayList();
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
                            this.F0.add(favouriteM3UModel);
                            break;
                        }
                        if (favouriteM3UModel.getCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    }
                }
            }
            return this.F0;
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ ListView N1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.J;
    }

    public static /* synthetic */ int N2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2) {
        nSTEXOPlayerSkyTvActivity.J2 = i2;
        return i2;
    }

    private void N3() {
        ProgressBar progressBar = this.w;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView = this.r;
        if (textView != null) {
            textView.setText(this.f.getResources().getString(a7.j.N4));
        }
        TextView textView2 = this.s;
        if (textView2 != null) {
            textView2.setText("");
        }
        TextView textView3 = this.t;
        if (textView3 != null) {
            textView3.setText(this.f.getResources().getString(a7.j.c4));
        }
        TextView textView4 = this.u;
        if (textView4 != null) {
            textView4.setText("");
        }
    }

    public static /* synthetic */ ListView O1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.I;
    }

    public static /* synthetic */ String O2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str) {
        nSTEXOPlayerSkyTvActivity.K2 = str;
        return str;
    }

    private void O3() {
        if (this.S2.getVisibility() == 0) {
            this.S2.startAnimation(this.I3);
            this.s3.startAnimation(this.I3);
            this.q3.startAnimation(this.I3);
            this.r3.startAnimation(this.I3);
            if (this.P2.getVisibility() == 0) {
                this.P2.startAnimation(this.I3);
            }
            if (this.R2.getVisibility() == 0) {
                this.R2.startAnimation(this.I3);
            }
            if (this.Q2.getVisibility() == 0) {
                this.Q2.startAnimation(this.I3);
            }
            this.S2.setVisibility(8);
            if (this.P2.getVisibility() == 0) {
                this.P2.setVisibility(8);
            }
            if (this.R2.getVisibility() == 0) {
                this.R2.setVisibility(8);
            }
            if (this.Q2.getVisibility() == 0) {
                this.Q2.setVisibility(8);
            }
            this.s3.setVisibility(8);
            this.q3.setVisibility(8);
            this.r3.setVisibility(8);
        }
    }

    public static /* synthetic */ ArrayList P1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.t0;
    }

    public static /* synthetic */ ImageView P2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.q;
    }

    public static /* synthetic */ ArrayList Q1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, ArrayList arrayList) {
        nSTEXOPlayerSkyTvActivity.t0 = arrayList;
        return arrayList;
    }

    public static /* synthetic */ Uri Q2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, Uri uri) {
        nSTEXOPlayerSkyTvActivity.v4 = uri;
        return uri;
    }

    private void Q3() {
        LinearLayout linearLayout = this.x;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.y;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    public static /* synthetic */ String R1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.W3;
    }

    public static /* synthetic */ void R2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        nSTEXOPlayerSkyTvActivity.U3();
    }

    public static /* synthetic */ int S1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.N1;
    }

    public static /* synthetic */ void S2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2) {
        nSTEXOPlayerSkyTvActivity.n3(i2);
    }

    public static /* synthetic */ int T1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2) {
        nSTEXOPlayerSkyTvActivity.N1 = i2;
        return i2;
    }

    public static /* synthetic */ SharedPreferences.Editor T2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.y1;
    }

    public static /* synthetic */ n7.g U1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.a4;
    }

    public static /* synthetic */ void U2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2, String str, String str2) {
        nSTEXOPlayerSkyTvActivity.K4(i2, str, str2);
    }

    private void U3() {
        if (this.v4 != null) {
            o4();
            if (this.r4 == null) {
                G1 b2 = r7.b.b(this, false);
                B3.q qVar = new B3.q(this.s4);
                Z3.m mVar = new Z3.m(this);
                this.t4 = mVar;
                mVar.m(this.u4);
                I1 a2 = new I1.a(this, b2).b(qVar).c(this.t4).a();
                this.r4 = a2;
                a2.B(new Q(this, null));
                this.r4.W(new d4.q(this.t4));
                this.r4.O(Q2.e.h, true);
                this.r4.o(true);
                this.b2.setPlayer(this.r4);
            }
            this.r4.h0(0, H0.d(this.v4));
            this.r4.prepare();
        }
    }

    public static /* synthetic */ void V1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, ArrayList arrayList) {
        nSTEXOPlayerSkyTvActivity.m4(arrayList);
    }

    public static /* synthetic */ void V2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2, String str, String str2) {
        nSTEXOPlayerSkyTvActivity.L4(i2, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x01a4 A[PHI: r3
      0x01a4: PHI (r3v17 java.lang.String) = (r3v6 java.lang.String), (r3v7 java.lang.String), (r3v8 java.lang.String) binds: [B:7:0x01a2, B:129:0x01b3, B:131:0x01c2] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void V3() {
        /*
            Method dump skipped, instructions count: 2150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.V3():void");
    }

    public static /* synthetic */ void W1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        nSTEXOPlayerSkyTvActivity.Q3();
    }

    public static /* synthetic */ boolean W2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.n4;
    }

    public static /* synthetic */ void X1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        nSTEXOPlayerSkyTvActivity.v3();
    }

    public static /* synthetic */ boolean X2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, boolean z2) {
        nSTEXOPlayerSkyTvActivity.n4 = z2;
        return z2;
    }

    private /* synthetic */ void X3(DialogInterface dialogInterface) {
        this.A4 = false;
    }

    public static /* synthetic */ void Y1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        nSTEXOPlayerSkyTvActivity.u3();
    }

    public static /* synthetic */ androidx.appcompat.app.a Y2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.f2;
    }

    private void Y3(AdapterView adapterView, View view, int i2, long j2, ArrayList arrayList) {
        String cmd;
        n7.g gVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        this.o.setVisibility(8);
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
            i4(this.d4, this.L);
            return;
        }
        try {
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.f);
            String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.f);
            ArrayList g2 = this.O3.g();
            if (g2 != null && g2.size() > 0) {
                cmd = ((LiveStreamsDBModel) g2.get(this.d4)).getCmd();
                if (this.v1 != m7.w.q0(((LiveStreamsDBModel) g2.get(this.d4)).getStreamId())) {
                    m7.w.N0(this.f);
                    gVar = this.a4;
                    str = "";
                    str2 = "itv";
                    str3 = "";
                    str4 = "";
                    str5 = "";
                    str6 = "";
                    str7 = "";
                    str8 = "channel_click";
                    str9 = "";
                    str10 = "";
                    gVar.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, str10);
                    return;
                }
                C3();
            }
            ArrayList arrayList2 = this.t0;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            cmd = ((LiveStreamsDBModel) this.t0.get(this.d4)).getCmd();
            if (this.v1 != m7.w.q0(((LiveStreamsDBModel) this.t0.get(this.d4)).getStreamId())) {
                m7.w.N0(this.f);
                gVar = this.a4;
                str = "";
                str2 = "itv";
                str3 = "";
                str4 = "";
                str5 = "";
                str6 = "";
                str7 = "";
                str8 = "channel_click";
                str9 = "";
                str10 = "";
                gVar.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, str10);
                return;
            }
            C3();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ int Z1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.S3;
    }

    public static /* synthetic */ ArrayList Z2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.s0;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Z3(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.Z3(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static /* synthetic */ int a2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2) {
        nSTEXOPlayerSkyTvActivity.S3 = i2;
        return i2;
    }

    public static /* synthetic */ int a3(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.x4;
    }

    private void a4(String str, String str2, String str3, AdapterView adapterView, View view, int i2, long j2, ArrayList arrayList) {
        if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
            Z3(str, str2, str3);
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
        this.t3 = dialog.findViewById(a7.f.C7);
        findViewById2.setOnClickListener(new C(str, str2, str3, adapterView, i2, j2, arrayList, dialog));
        this.t3.setOnClickListener(new D(str, str2, str3, adapterView, i2, j2, arrayList, dialog));
        findViewById2.setOnFocusChangeListener(new J(findViewById2));
        findViewById2.setNextFocusUpId(a7.f.W4);
        findViewById2.setNextFocusDownId(a7.f.W4);
        findViewById2.setNextFocusRightId(a7.f.W4);
        findViewById2.setNextFocusLeftId(a7.f.W4);
        findViewById2.requestFocus();
        if (a2 != null) {
            try {
                if (a2.size() > 0) {
                    if (a2.size() > m7.a.k1) {
                        com.squareup.picasso.t.q(this.f).l((String) a2.get(m7.a.k1)).g(findViewById);
                        m7.a.k1++;
                    } else {
                        com.squareup.picasso.t.q(this.f).l((String) a2.get(0)).g(findViewById);
                        m7.a.k1 = 1;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(a7.c.z);
    }

    public static /* synthetic */ ArrayList b2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.u0;
    }

    public static /* synthetic */ void b3(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str, String str2, String str3) {
        nSTEXOPlayerSkyTvActivity.Z3(str, str2, str3);
    }

    public static /* synthetic */ void c2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        nSTEXOPlayerSkyTvActivity.c4();
    }

    private void c3(int i2, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            List favIdsList = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
            this.f4 = favIdsList;
            if (favIdsList != null && favIdsList.size() > 0) {
                for (int i3 = 0; i3 < this.f4.size(); i3++) {
                    sb.append(this.f4.get(i3));
                    sb.append(",");
                }
            }
            sb.append(i2);
            this.h4 = i2;
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.f);
            this.g4.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.f), stalkerToken, (t.o) null, sb.toString(), "added", str);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    private void c4() {
        ProgressBar progressBar = this.w;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView = this.r;
        if (textView != null) {
            textView.setText(this.f.getResources().getString(a7.j.M4));
        }
        TextView textView2 = this.s;
        if (textView2 != null) {
            textView2.setText("");
        }
        TextView textView3 = this.t;
        if (textView3 != null) {
            textView3.setText(this.f.getResources().getString(a7.j.b4));
        }
        TextView textView4 = this.u;
        if (textView4 != null) {
            textView4.setText("");
        }
    }

    public static /* synthetic */ HashMap d2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str) {
        return nSTEXOPlayerSkyTvActivity.x4(str);
    }

    private void d4() {
        int currentWindowIndex = this.b2.getCurrentWindowIndex();
        if (currentWindowIndex == this.v0.size() - 1) {
            this.b2.setCurrentWindowIndex(0);
        } else {
            this.b2.setCurrentWindowIndex(currentWindowIndex + 1);
        }
    }

    public static /* synthetic */ void e2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        nSTEXOPlayerSkyTvActivity.N3();
    }

    public static /* synthetic */ ProgressDialog f2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.r2;
    }

    private void f3(Configuration configuration) {
        PlayerView playerView;
        boolean z2;
        View decorView = getWindow().getDecorView();
        if (configuration.orientation == 2) {
            decorView.setSystemUiVisibility(5894);
            playerView = this.b2;
            z2 = false;
        } else {
            decorView.setSystemUiVisibility(256);
            playerView = this.b2;
            z2 = true;
        }
        playerView.setAdjustViewBounds(z2);
    }

    public static /* synthetic */ ProgressDialog g2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, ProgressDialog progressDialog) {
        nSTEXOPlayerSkyTvActivity.r2 = progressDialog;
        return progressDialog;
    }

    public static /* synthetic */ void h2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str, boolean z2) {
        nSTEXOPlayerSkyTvActivity.v4(str, z2);
    }

    private void h4() {
        this.a3.setOnClickListener(this);
        this.b3.setOnClickListener(this);
        this.U2.setOnClickListener(this);
        this.e3.setOnClickListener(this);
        this.B3.setOnClickListener(this);
        this.f3.setOnClickListener(this);
        this.m3.setOnClickListener(this);
        this.n3.setOnClickListener(this);
        this.o3.setOnClickListener(this);
        this.V2.setOnClickListener(this);
        this.l3.setOnClickListener(this);
        this.c3.setOnClickListener(this);
        this.d3.setOnClickListener(this);
        this.z3.setOnClickListener(this);
        this.l5.setOnClickListener(this);
        this.m5.setOnClickListener(this);
        this.n5.setOnClickListener(this);
        this.o5.setOnClickListener(this);
        this.p5.setOnClickListener(this);
        this.q5.setOnClickListener(this);
        this.r5.setOnClickListener(this);
        this.W4.setOnClickListener(this);
        this.i5.setOnClickListener(this);
    }

    public static /* synthetic */ q7.N i2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.M3;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x047a A[Catch: Exception -> 0x0276, TryCatch #8 {Exception -> 0x0276, blocks: (B:105:0x0232, B:107:0x0244, B:109:0x026d, B:110:0x0279, B:112:0x02c1, B:114:0x02c9, B:116:0x02d1, B:118:0x02eb, B:120:0x02f1, B:121:0x02f9, B:129:0x034e, B:131:0x0377, B:132:0x0397, B:196:0x045d, B:134:0x0476, B:136:0x047a, B:137:0x04a5, B:139:0x04a9, B:140:0x04b1, B:206:0x0386, B:209:0x033d, B:123:0x0303, B:125:0x0309, B:127:0x030f, B:208:0x032b), top: B:104:0x0232, outer: #2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04a9 A[Catch: Exception -> 0x0276, TryCatch #8 {Exception -> 0x0276, blocks: (B:105:0x0232, B:107:0x0244, B:109:0x026d, B:110:0x0279, B:112:0x02c1, B:114:0x02c9, B:116:0x02d1, B:118:0x02eb, B:120:0x02f1, B:121:0x02f9, B:129:0x034e, B:131:0x0377, B:132:0x0397, B:196:0x045d, B:134:0x0476, B:136:0x047a, B:137:0x04a5, B:139:0x04a9, B:140:0x04b1, B:206:0x0386, B:209:0x033d, B:123:0x0303, B:125:0x0309, B:127:0x030f, B:208:0x032b), top: B:104:0x0232, outer: #2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0a91 A[Catch: Exception -> 0x0c9d, TryCatch #2 {Exception -> 0x0c9d, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x0016, B:8:0x001c, B:11:0x004e, B:13:0x0054, B:15:0x0087, B:17:0x0099, B:19:0x00c2, B:20:0x00ca, B:22:0x0112, B:24:0x011a, B:26:0x0122, B:28:0x013c, B:30:0x0142, B:31:0x014a, B:39:0x019f, B:41:0x01df, B:42:0x01f8, B:44:0x01fc, B:45:0x0212, B:47:0x0216, B:48:0x021e, B:49:0x0220, B:54:0x018e, B:55:0x0225, B:57:0x022a, B:59:0x04d5, B:61:0x04eb, B:63:0x0514, B:64:0x051c, B:66:0x056c, B:68:0x0574, B:70:0x057c, B:72:0x0596, B:74:0x059c, B:75:0x05a4, B:83:0x05f9, B:85:0x0620, B:86:0x0640, B:88:0x0654, B:90:0x0660, B:91:0x0662, B:92:0x068e, B:93:0x0669, B:94:0x06a1, B:96:0x06a5, B:97:0x06ce, B:99:0x06d2, B:100:0x062f, B:103:0x05e8, B:213:0x04b8, B:215:0x06dc, B:217:0x06e8, B:219:0x06ee, B:221:0x072f, B:223:0x0743, B:225:0x0770, B:226:0x0778, B:228:0x07c6, B:230:0x07ce, B:232:0x07d6, B:234:0x07f4, B:236:0x07fa, B:237:0x0802, B:239:0x0811, B:240:0x082a, B:242:0x085f, B:243:0x0877, B:245:0x087b, B:246:0x0885, B:248:0x088d, B:250:0x08a1, B:252:0x08ce, B:253:0x08d6, B:255:0x0924, B:257:0x092c, B:259:0x0934, B:261:0x0956, B:262:0x095e, B:326:0x0a43, B:264:0x0a5c, B:266:0x0a91, B:267:0x0ac0, B:269:0x0ac4, B:270:0x0acc, B:341:0x0ad0, B:343:0x0ae6, B:345:0x0b13, B:346:0x0b1b, B:348:0x0b71, B:350:0x0b79, B:352:0x0b81, B:354:0x0b9f, B:356:0x0ba5, B:357:0x0bad, B:359:0x0bbc, B:361:0x0bca, B:362:0x0bcc, B:363:0x0bfa, B:364:0x0c10, B:366:0x0c37, B:367:0x0c59, B:369:0x0c62, B:370:0x0c8f, B:372:0x0c93, B:373:0x0c48, B:374:0x0bd3, B:33:0x0154, B:35:0x015a, B:37:0x0160, B:53:0x017c, B:77:0x05ae, B:79:0x05b4, B:81:0x05ba, B:102:0x05d6, B:105:0x0232, B:107:0x0244, B:109:0x026d, B:110:0x0279, B:112:0x02c1, B:114:0x02c9, B:116:0x02d1, B:118:0x02eb, B:120:0x02f1, B:121:0x02f9, B:129:0x034e, B:131:0x0377, B:132:0x0397, B:196:0x045d, B:134:0x0476, B:136:0x047a, B:137:0x04a5, B:139:0x04a9, B:140:0x04b1, B:206:0x0386, B:209:0x033d), top: B:2:0x0006, inners: #0, #7, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0ac4 A[Catch: Exception -> 0x0c9d, TryCatch #2 {Exception -> 0x0c9d, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x0016, B:8:0x001c, B:11:0x004e, B:13:0x0054, B:15:0x0087, B:17:0x0099, B:19:0x00c2, B:20:0x00ca, B:22:0x0112, B:24:0x011a, B:26:0x0122, B:28:0x013c, B:30:0x0142, B:31:0x014a, B:39:0x019f, B:41:0x01df, B:42:0x01f8, B:44:0x01fc, B:45:0x0212, B:47:0x0216, B:48:0x021e, B:49:0x0220, B:54:0x018e, B:55:0x0225, B:57:0x022a, B:59:0x04d5, B:61:0x04eb, B:63:0x0514, B:64:0x051c, B:66:0x056c, B:68:0x0574, B:70:0x057c, B:72:0x0596, B:74:0x059c, B:75:0x05a4, B:83:0x05f9, B:85:0x0620, B:86:0x0640, B:88:0x0654, B:90:0x0660, B:91:0x0662, B:92:0x068e, B:93:0x0669, B:94:0x06a1, B:96:0x06a5, B:97:0x06ce, B:99:0x06d2, B:100:0x062f, B:103:0x05e8, B:213:0x04b8, B:215:0x06dc, B:217:0x06e8, B:219:0x06ee, B:221:0x072f, B:223:0x0743, B:225:0x0770, B:226:0x0778, B:228:0x07c6, B:230:0x07ce, B:232:0x07d6, B:234:0x07f4, B:236:0x07fa, B:237:0x0802, B:239:0x0811, B:240:0x082a, B:242:0x085f, B:243:0x0877, B:245:0x087b, B:246:0x0885, B:248:0x088d, B:250:0x08a1, B:252:0x08ce, B:253:0x08d6, B:255:0x0924, B:257:0x092c, B:259:0x0934, B:261:0x0956, B:262:0x095e, B:326:0x0a43, B:264:0x0a5c, B:266:0x0a91, B:267:0x0ac0, B:269:0x0ac4, B:270:0x0acc, B:341:0x0ad0, B:343:0x0ae6, B:345:0x0b13, B:346:0x0b1b, B:348:0x0b71, B:350:0x0b79, B:352:0x0b81, B:354:0x0b9f, B:356:0x0ba5, B:357:0x0bad, B:359:0x0bbc, B:361:0x0bca, B:362:0x0bcc, B:363:0x0bfa, B:364:0x0c10, B:366:0x0c37, B:367:0x0c59, B:369:0x0c62, B:370:0x0c8f, B:372:0x0c93, B:373:0x0c48, B:374:0x0bd3, B:33:0x0154, B:35:0x015a, B:37:0x0160, B:53:0x017c, B:77:0x05ae, B:79:0x05b4, B:81:0x05ba, B:102:0x05d6, B:105:0x0232, B:107:0x0244, B:109:0x026d, B:110:0x0279, B:112:0x02c1, B:114:0x02c9, B:116:0x02d1, B:118:0x02eb, B:120:0x02f1, B:121:0x02f9, B:129:0x034e, B:131:0x0377, B:132:0x0397, B:196:0x045d, B:134:0x0476, B:136:0x047a, B:137:0x04a5, B:139:0x04a9, B:140:0x04b1, B:206:0x0386, B:209:0x033d), top: B:2:0x0006, inners: #0, #7, #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i4(int r24, java.util.ArrayList r25) {
        /*
            Method dump skipped, instructions count: 3230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.i4(int, java.util.ArrayList):void");
    }

    public static /* synthetic */ Boolean j2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, Boolean bool) {
        nSTEXOPlayerSkyTvActivity.m4 = bool;
        return bool;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:135|136|(1:204)(14:142|(2:143|(2:145|(2:148|149)(1:147))(2:202|203))|150|(4:(3:154|(2:157|158)(1:156)|152)|200|201|159)(2:201|159)|51|(0)(0)|62|(0)|71|(0)|79|(0)|87|88)|161|162|(1:198)(6:166|167|168|169|(14:171|(2:172|(2:174|(2:176|177)(1:192))(2:193|194))|178|(4:(3:182|(2:184|185)(1:189)|180)|190|191|186)(2:191|186)|51|(0)(0)|62|(0)|71|(0)|79|(0)|87|88)|187)|195|187) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:386|387|(1:460)(9:393|(2:394|(2:396|(2:399|400)(1:398))(2:457|458))|401|402|(5:(3:406|(2:409|410)(1:408)|404)|453|454|411|412)(3:454|411|412)|51|(2:53|(2:54|(1:61)(2:56|(2:59|60)(1:58))))(0)|62|(2:71|(2:79|(2:87|88)(2:85|86))(2:77|78))(2:68|69))|413|414|(1:450)(6:418|419|420|421|(14:423|(2:424|(2:426|(2:428|429)(1:444))(2:445|446))|430|(4:(3:434|(2:436|437)(1:441)|432)|442|443|438)(2:443|438)|51|(0)(0)|62|(1:64)|71|(1:73)|79|(1:81)|87|88)|439)|447|439) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0be4 A[Catch: Exception -> 0x0ba5, TryCatch #16 {Exception -> 0x0ba5, blocks: (B:439:0x0b8b, B:378:0x0baf, B:380:0x0be4, B:381:0x0c13, B:383:0x0c17, B:384:0x0c1f, B:463:0x0c2f), top: B:361:0x09bd }] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0c17 A[Catch: Exception -> 0x0ba5, TryCatch #16 {Exception -> 0x0ba5, blocks: (B:439:0x0b8b, B:378:0x0baf, B:380:0x0be4, B:381:0x0c13, B:383:0x0c17, B:384:0x0c1f, B:463:0x0c2f), top: B:361:0x09bd }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0ea6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0ecf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0ee6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0efc  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v34 */
    /* JADX WARN: Type inference failed for: r14v35, types: [int] */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j4(int r26, java.util.ArrayList r27) {
        /*
            Method dump skipped, instructions count: 3858
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.j4(int, java.util.ArrayList):void");
    }

    public static /* synthetic */ int k2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.e4;
    }

    private void k4() {
        EditText editText = this.w3;
        if (editText != null) {
            editText.addTextChangedListener(new s());
        }
    }

    public static /* synthetic */ int l2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2) {
        nSTEXOPlayerSkyTvActivity.e4 = i2;
        return i2;
    }

    private void l4() {
        I1 i1;
        try {
            if (!this.h2.booleanValue() || (i1 = this.r4) == null) {
                return;
            }
            i1.play();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ q7.P m2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.P3;
    }

    private void m4(ArrayList arrayList) {
        x7.a f2;
        String valueOf;
        String str;
        String str2;
        SharedPreferences.Editor editor;
        String valueOf2;
        if (arrayList == null || arrayList.size() <= 0 || this.N1 >= arrayList.size()) {
            return;
        }
        int r0 = m7.w.r0(((LiveStreamsDBModel) arrayList.get(this.N1)).getNum());
        this.J2 = r0;
        this.K2 = ((LiveStreamsDBModel) arrayList.get(this.N1)).getCategoryId();
        int i2 = this.N1;
        this.t2 = i2;
        String name = ((LiveStreamsDBModel) arrayList.get(i2)).getName();
        String streamIdOneStream = ((LiveStreamsDBModel) arrayList.get(this.N1)).getStreamIdOneStream();
        int q0 = m7.w.q0(((LiveStreamsDBModel) arrayList.get(this.N1)).getStreamId());
        String epgChannelId = ((LiveStreamsDBModel) arrayList.get(this.N1)).getEpgChannelId();
        String streamIcon = ((LiveStreamsDBModel) arrayList.get(this.N1)).getStreamIcon();
        ((LiveStreamsDBModel) arrayList.get(this.N1)).getNum();
        ((LiveStreamsDBModel) arrayList.get(this.N1)).getStreamIdOneStream();
        this.Z1 = ((LiveStreamsDBModel) arrayList.get(this.N1)).getUrl();
        String S0 = m7.w.S0(w7.k.a() + w7.k.i());
        this.x5 = ((LiveStreamsDBModel) arrayList.get(this.N1)).getName();
        this.u5 = ((LiveStreamsDBModel) arrayList.get(this.N1)).getCategoryId();
        try {
            if (streamIcon.equals("") || streamIcon.isEmpty()) {
                this.q.setImageDrawable(this.f.getResources().getDrawable(a7.e.i1));
            } else {
                com.squareup.picasso.t.q(this.f).l(streamIcon).j(a7.e.i1).d(a7.e.i1).g(this.q);
            }
        } catch (Exception unused) {
            this.q.setImageDrawable(this.f.getResources().getDrawable(a7.e.i1));
        }
        this.b2.setCurrentWindowIndex(this.N1);
        if (this.y1 != null) {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api")) {
                editor = this.y1;
                valueOf2 = ((LiveStreamsDBModel) arrayList.get(this.N1)).getStreamIdOneStream();
            } else {
                editor = this.y1;
                valueOf2 = String.valueOf(((LiveStreamsDBModel) arrayList.get(this.N1)).getStreamId());
            }
            editor.putString("currentlyPlayingVideo", valueOf2);
            this.y1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", String.valueOf(((LiveStreamsDBModel) arrayList.get(this.N1)).getUrl()));
            this.y1.apply();
        }
        SharedPreferences.Editor editor2 = this.z1;
        if (editor2 != null) {
            editor2.putInt("currentlyPlayingVideoPosition", this.N1);
            this.z1.apply();
        }
        SimpleDateFormat simpleDateFormat = this.a2;
        if (x3(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.f))), this.W1.format(this.c2)) >= w7.c.p() && (str = this.o1) != null && this.e1 != null && (!M5.equals(str) || (this.o1 != null && (str2 = this.e1) != null && !N5.equals(str2)))) {
            this.h2 = Boolean.FALSE;
            this.b2.setVisibility(8);
            this.o.setVisibility(0);
            this.p.setText(S0 + this.k + this.B1);
        }
        this.v1 = q0;
        this.u1 = epgChannelId;
        this.C4 = streamIdOneStream;
        this.w1 = this.Z1;
        if (this.Y1.equals("m3u")) {
            f2 = x7.a.f();
            valueOf = this.w1;
        } else if (this.Y1.equals("onestream_api")) {
            f2 = x7.a.f();
            valueOf = this.C4;
        } else {
            f2 = x7.a.f();
            valueOf = String.valueOf(this.v1);
        }
        f2.A(valueOf);
        this.b2.setTitle(r0 + " - " + name);
        this.b2.E();
        if (!L5) {
            if (this.b2.getFullScreenValue().booleanValue()) {
                L5 = this.b2.getFullScreenValue().booleanValue();
            } else {
                L5 = false;
            }
        }
        if (!m7.a.V0.booleanValue() || !m7.a.e1.equalsIgnoreCase("1")) {
            Z3(name, epgChannelId, streamIcon);
            return;
        }
        m7.a.b = true;
        if (SharepreferenceDBHandler.getEventAdsView(this) < m7.a.f1) {
            Z3(name, epgChannelId, streamIcon);
            SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(this) + 1, this);
        } else {
            SharepreferenceDBHandler.setEventAdsView(0, this);
            a4(name, epgChannelId, streamIcon, null, null, 0, 0L, null);
        }
    }

    public static /* synthetic */ void n2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2, ArrayList arrayList) {
        nSTEXOPlayerSkyTvActivity.j4(i2, arrayList);
    }

    private void n3(int i2) {
        this.b2.v = new u();
        PlayerView playerView = this.b2;
        playerView.u.postDelayed(playerView.v, i2);
    }

    private void n4() {
        int currentWindowIndex = this.b2.getCurrentWindowIndex();
        if (currentWindowIndex == 0) {
            this.b2.setCurrentWindowIndex(this.v0.size() - 1);
        } else {
            this.b2.setCurrentWindowIndex(currentWindowIndex - 1);
        }
    }

    public static /* synthetic */ AsyncTask o2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.q2;
    }

    public static /* synthetic */ AsyncTask p2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, AsyncTask asyncTask) {
        nSTEXOPlayerSkyTvActivity.q2 = asyncTask;
        return asyncTask;
    }

    private void p4(int i2, String str) {
        try {
            List favIdsList = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
            this.f4 = favIdsList;
            if (favIdsList == null) {
                m7.w.X();
                return;
            }
            favIdsList.remove(Integer.valueOf(i2));
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < this.f4.size(); i3++) {
                sb.append(this.f4.get(i3));
                sb.append(",");
            }
            this.f4.add(Integer.valueOf(i2));
            String substring = sb.toString().contains(",") ? sb.substring(0, sb.lastIndexOf(",")) : sb.toString();
            this.h4 = i2;
            this.g4.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.f), SharepreferenceDBHandler.getStalkerToken(this.f), (t.o) null, substring, "removed", str);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    private void pause() {
        I1 i1;
        try {
            if (!this.h2.booleanValue() || (i1 = this.r4) == null) {
                return;
            }
            i1.pause();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int q2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, int i2) {
        nSTEXOPlayerSkyTvActivity.d4 = i2;
        return i2;
    }

    public static /* synthetic */ String r2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str) {
        nSTEXOPlayerSkyTvActivity.Z1 = str;
        return str;
    }

    public static /* synthetic */ void s2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str, String str2, String str3, AdapterView adapterView, View view, int i2, long j2, ArrayList arrayList) {
        nSTEXOPlayerSkyTvActivity.a4(str, str2, str3, adapterView, view, i2, j2, arrayList);
    }

    private void s3() {
        AsyncTask asyncTask = this.o2;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            SharepreferenceDBHandler.setAsyncTaskStatus(0, this.f);
        } else {
            SharepreferenceDBHandler.setAsyncTaskStatus(1, this.f);
            this.o2.cancel(true);
        }
    }

    public static /* synthetic */ void t2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, AdapterView adapterView, View view, int i2, long j2, ArrayList arrayList) {
        nSTEXOPlayerSkyTvActivity.Y3(adapterView, view, i2, j2, arrayList);
    }

    public static boolean t3() {
        ProgressBar progressBar = P5;
        return progressBar != null && progressBar.getVisibility() == 0;
    }

    public static /* synthetic */ void u1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, DialogInterface dialogInterface) {
        nSTEXOPlayerSkyTvActivity.X3(dialogInterface);
    }

    public static /* synthetic */ q7.O u2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.O3;
    }

    private void u3() {
        EditText editText = this.w3;
        if (editText != null) {
            editText.setText("");
            this.w3.clearFocus();
        }
    }

    private void v1() {
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.T = sharedPreferences;
        String str = "";
        this.v5 = sharedPreferences.getString("username", "");
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        String o0 = m7.w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
        if (this.u5.equalsIgnoreCase("")) {
            str = "UnCategories";
        } else {
            LiveStreamCategoryIdDBModel channelCatNameFromSelectedCatId = this.R.getChannelCatNameFromSelectedCatId(this.u5);
            if (channelCatNameFromSelectedCatId != null) {
                str = channelCatNameFromSelectedCatId.getLiveStreamCategoryName();
            }
        }
        Retrofit E0 = m7.w.E0(this.f);
        if (E0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) E0.create(RetrofitPost.class);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", m7.a.S0);
            jsonObject.addProperty("s", m7.a.T0);
            jsonObject.addProperty("r", b7.b.b);
            jsonObject.addProperty("d", format);
            jsonObject.addProperty("sc", o0);
            jsonObject.addProperty("action", "addreport");
            jsonObject.addProperty("username", this.v5);
            jsonObject.addProperty("macaddress", this.w5);
            jsonObject.addProperty("section", this.t5);
            jsonObject.addProperty("section_category", str);
            jsonObject.addProperty("report_title", this.y5);
            jsonObject.addProperty("report_sub_title", this.z5);
            jsonObject.addProperty("report_cases", this.E5);
            jsonObject.addProperty("report_custom_message", this.B5);
            jsonObject.addProperty("stream_name", this.x5);
            jsonObject.addProperty("stream_id", Integer.valueOf(this.v1));
            retrofitPost.clientsReportRequest(jsonObject).enqueue(new B());
        }
    }

    public static /* synthetic */ String v2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.Y1;
    }

    public static /* synthetic */ ArrayList w1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.z0;
    }

    public static /* synthetic */ List w2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.f4;
    }

    public static ProgressDialog w3(Context context) {
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

    private void w4() {
        try {
            new l(this).show();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ Boolean x1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.T1;
    }

    public static /* synthetic */ DatabaseHandler x2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.x1;
    }

    public static long x3(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
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
    private java.util.HashMap x4(java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.x4(java.lang.String):java.util.HashMap");
    }

    public static /* synthetic */ Boolean y1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, Boolean bool) {
        nSTEXOPlayerSkyTvActivity.T1 = bool;
        return bool;
    }

    public static /* synthetic */ Boolean y2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.h2;
    }

    private HashMap y4(StalkerShortEPGCallback stalkerShortEPGCallback) {
        int i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (this.R != null) {
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
                int M2 = m7.w.M(j2, j3, this.f);
                if (M2 != 0) {
                    int i3 = 100 - M2;
                    if (i3 == 0 || name == null || name.equals("")) {
                        i2 = i3;
                    } else {
                        arrayList4.add(0, String.valueOf(i3));
                        StringBuilder sb = new StringBuilder();
                        i2 = i3;
                        sb.append(this.f.getResources().getString(a7.j.L4));
                        sb.append(" ");
                        sb.append(name);
                        arrayList.add(0, sb.toString());
                        arrayList.add(1, this.f0.format(valueOf) + " - " + this.f0.format(valueOf2));
                        arrayList.add(2, descr);
                    }
                    M2 = i2;
                }
                arrayList2.add(0, this.f0.format(valueOf) + " - " + this.f0.format(valueOf2));
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
                        arrayList.add(3, this.f.getResources().getString(a7.j.a4) + " " + name2);
                        arrayList.add(4, this.f0.format(valueOf3) + " - " + this.f0.format(valueOf4));
                        arrayList.add(5, descr2);
                    }
                    arrayList2.add(3, this.f0.format(valueOf3) + " - " + this.f0.format(valueOf4));
                    arrayList2.add(4, name2);
                    arrayList2.add(5, descr2);
                }
                if (2 < stalkerShortEPGCallback.getJs().size()) {
                    long intValue5 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getStartTimestamp().intValue();
                    long intValue6 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getStopTimestamp().intValue();
                    String name3 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getName();
                    String descr3 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getDescr();
                    arrayList2.add(6, this.f0.format(Long.valueOf(intValue5 * 1000)) + " - " + this.f0.format(Long.valueOf(intValue6 * 1000)));
                    arrayList2.add(7, name3);
                    arrayList2.add(8, descr3);
                }
                if (3 < stalkerShortEPGCallback.getJs().size()) {
                    long intValue7 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getStartTimestamp().intValue();
                    long intValue8 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getStopTimestamp().intValue();
                    String name4 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getName();
                    String descr4 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getDescr();
                    arrayList2.add(9, this.f0.format(Long.valueOf(intValue7 * 1000)) + " - " + this.f0.format(Long.valueOf(intValue8 * 1000)));
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

    public static /* synthetic */ ArrayList z1(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity) {
        return nSTEXOPlayerSkyTvActivity.v0;
    }

    public static /* synthetic */ void z2(NSTEXOPlayerSkyTvActivity nSTEXOPlayerSkyTvActivity, String str, String str2, String str3, int i2) {
        nSTEXOPlayerSkyTvActivity.e3(str, str2, str3, i2);
    }

    public void A3() {
        try {
            c4();
            LinearLayout linearLayout = this.n1;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.p1;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            LinearLayout linearLayout3 = this.q1;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            LinearLayout linearLayout4 = this.r1;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            LinearLayout linearLayout5 = this.s1;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            LinearLayout linearLayout6 = this.t1;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
        } catch (Exception unused) {
        }
    }

    public void A4() {
        if (this.S2.getVisibility() == 8) {
            this.S2.startAnimation(this.H3);
            this.S2.setVisibility(0);
            if (this.P2.getVisibility() == 8) {
                this.P2.startAnimation(this.H3);
                this.P2.setVisibility(0);
            }
            if (this.R2.getVisibility() == 8) {
                this.R2.startAnimation(this.H3);
                this.R2.setVisibility(0);
            }
            if (this.Q2.getVisibility() == 8) {
                this.Q2.startAnimation(this.H3);
                this.Q2.setVisibility(0);
            }
        }
    }

    public void C3() {
        RelativeLayout relativeLayout = this.T0;
        if (relativeLayout != null) {
            relativeLayout.setPadding(0, 0, 0, 0);
        }
        L5 = true;
        F4();
        z4();
        n3(5000);
        String livePlayerAppName = SharepreferenceDBHandler.getLivePlayerAppName(this.f);
        if (!SharepreferenceDBHandler.getLivePlayerPkgName(this.f).equals("default_native") && !new ExternalPlayerDataBase(this.f).CheckPlayerExistense(livePlayerAppName)) {
            SharepreferenceDBHandler.setLivePlayer("default_native", "default", this.f);
        }
        String livePlayerPkgName = SharepreferenceDBHandler.getLivePlayerPkgName(this.f);
        if (livePlayerPkgName == null || livePlayerPkgName.equalsIgnoreCase("default_native")) {
            if (m7.a.Y.booleanValue()) {
                LinearLayout linearLayout = this.p3;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                findViewById(a7.f.p).setOnClickListener((View.OnClickListener) null);
                this.U0.setVisibility(8);
                this.V0.setVisibility(8);
                this.W0.setVisibility(8);
                getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
                LinearLayout.LayoutParams layoutParams = this.X0.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.X0.setLayoutParams(layoutParams);
                getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
                I1 i1 = this.r4;
                ((i1 == null || !i1.isPlaying()) ? this.h : this.i).requestFocus();
                return;
            }
            return;
        }
        o4();
        this.u2 = true;
        SharedPreferences sharedPreferences = getSharedPreferences("currentlyPlayingVideoPosition", 0);
        this.X = sharedPreferences;
        int i2 = sharedPreferences.getInt("currentlyPlayingVideoPosition", 0);
        ArrayList g2 = this.O3.g();
        this.N1 = i2;
        if (g2 == null || g2.size() <= 0 || this.N1 >= g2.size()) {
            ArrayList arrayList = this.t0;
            if (arrayList != null && arrayList.size() > 0 && this.N1 < this.t0.size()) {
                this.k2 = m7.w.r0(((LiveStreamsDBModel) this.t0.get(this.N1)).getStreamId());
                this.Z1 = ((LiveStreamsDBModel) this.t0.get(this.N1)).getUrl();
                ((LiveStreamsDBModel) this.t0.get(this.N1)).getName();
            }
        } else {
            this.k2 = m7.w.r0(((LiveStreamsDBModel) g2.get(this.N1)).getStreamId());
            this.Z1 = ((LiveStreamsDBModel) g2.get(this.N1)).getUrl();
        }
        this.D = this.k2;
        this.E = this.Z1;
        L5 = false;
        PlayerView playerView = this.b2;
        if (playerView != null) {
            playerView.u(Boolean.FALSE);
        }
        if (this.Y1.equals("m3u")) {
            if (this.h2.booleanValue()) {
                String livePlayerAppName2 = SharepreferenceDBHandler.getLivePlayerAppName(this.f);
                Intent intent = new Intent(this.f, PlayExternalPlayerActivity.class);
                intent.putExtra("url", this.E);
                intent.putExtra("packagename", livePlayerPkgName);
                intent.putExtra("app_name", livePlayerAppName2);
                this.f.startActivity(intent);
                return;
            }
            return;
        }
        if (this.k2 == -1 || !this.h2.booleanValue()) {
            return;
        }
        String V2 = m7.w.V(this.f, this.k2, this.g0, "live");
        String livePlayerAppName3 = SharepreferenceDBHandler.getLivePlayerAppName(this.f);
        Intent intent2 = new Intent(this.f, PlayExternalPlayerActivity.class);
        intent2.putExtra("url", V2);
        intent2.putExtra("packagename", livePlayerPkgName);
        intent2.putExtra("app_name", livePlayerAppName3);
        this.f.startActivity(intent2);
    }

    public void D0(String str) {
    }

    public void E3() {
        ArrayList arrayList;
        LiveStreamsDBModel liveStreamFavouriteRow;
        try {
            if (this.Y1.equals("m3u")) {
                new ArrayList();
                LiveStreamDBHandler liveStreamDBHandler = this.R;
                if (liveStreamDBHandler == null) {
                    return;
                }
                ArrayList favouriteM3U = liveStreamDBHandler.getFavouriteM3U("live");
                arrayList = new ArrayList();
                ArrayList arrayList2 = this.z0;
                if (arrayList2 != null && arrayList2.size() > 0 && favouriteM3U != null && favouriteM3U.size() > 0) {
                    favouriteM3U = M3(favouriteM3U, this.z0);
                }
                if (favouriteM3U == null || favouriteM3U.size() <= 0) {
                    return;
                }
                Iterator it = favouriteM3U.iterator();
                while (it.hasNext()) {
                    FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                    ArrayList m3UFavouriteRow = this.R.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
                    if (m3UFavouriteRow != null && m3UFavouriteRow.size() > 0) {
                        arrayList.add((LiveStreamsDBModel) m3UFavouriteRow.get(0));
                    }
                }
            } else {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
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
                    this.K.clear();
                    this.K = this.R.getLiveFavStalker(str);
                    return;
                }
                new ArrayList();
                if (this.x1 == null) {
                    return;
                }
                ArrayList allFavourites = this.X3.equals("true") ? this.x1.getAllFavourites("radio_streams", SharepreferenceDBHandler.getUserID(this.f)) : this.x1.getAllFavourites("live", SharepreferenceDBHandler.getUserID(this.f));
                arrayList = new ArrayList();
                ArrayList arrayList3 = this.z0;
                if (arrayList3 != null && arrayList3.size() > 0 && allFavourites != null && allFavourites.size() > 0) {
                    allFavourites = L3(allFavourites, this.z0);
                }
                if (allFavourites == null || allFavourites.size() <= 0) {
                    return;
                }
                Iterator it2 = allFavourites.iterator();
                while (it2.hasNext()) {
                    FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it2.next();
                    LiveStreamDBHandler liveStreamDBHandler2 = new LiveStreamDBHandler(this.f);
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api")) {
                        liveStreamFavouriteRow = liveStreamDBHandler2.getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), favouriteDBModel.getStreamIDOneStream(), favouriteDBModel.getTimestamp(), this.F5);
                        if (liveStreamFavouriteRow != null) {
                            arrayList.add(liveStreamFavouriteRow);
                        }
                    } else {
                        liveStreamFavouriteRow = liveStreamDBHandler2.getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), String.valueOf(favouriteDBModel.getStreamID()), favouriteDBModel.getTimestamp(), this.F5);
                        if (liveStreamFavouriteRow != null) {
                            arrayList.add(liveStreamFavouriteRow);
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    return;
                }
            }
            this.K = arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public String F3() {
        AsyncTask asyncTask;
        try {
            this.t2 = 0;
            ArrayList arrayList = this.r0;
            if (arrayList != null && this.p0 != null) {
                arrayList.clear();
                this.p0.clear();
            }
            ArrayList arrayList2 = this.K;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.K.clear();
            }
            E3();
            ArrayList arrayList3 = this.t0;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            this.r0 = this.K;
            ArrayList arrayList4 = this.s0;
            if (arrayList4 != null) {
                arrayList4.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.F2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.f)));
            boolean B2 = this.F2.B();
            ArrayList ePGTesting = B2 ? this.R.getEPGTesting((String) null, format) : null;
            this.X = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u") ? this.W.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api") ? this.W : this.W).getString("currentlyPlayingVideo", "");
            ArrayList arrayList5 = this.r0;
            if (arrayList5 == null || arrayList5.size() <= 0) {
                this.t0 = this.r0;
                return "get_fav";
            }
            for (int i2 = 0; i2 < this.r0.size(); i2++) {
                AsyncTask asyncTask2 = this.o2;
                if (asyncTask2 != null && asyncTask2.isCancelled()) {
                    return "get_fav";
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.r0.get(i2)).getUrl().equals(string)) {
                        this.t2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.r0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.t2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.r0.get(i2)).getStreamId().equals(string)) {
                    this.t2 = i2;
                }
                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.r0.get(i2)).getNum());
                liveStreamsDBModel.setName(((LiveStreamsDBModel) this.r0.get(i2)).getName());
                liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.r0.get(i2)).getStreamType());
                liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.r0.get(i2)).getStreamId());
                liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.r0.get(i2)).getStreamIdOneStream());
                liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.r0.get(i2)).getStreamIcon());
                liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.r0.get(i2)).getEpgChannelId());
                liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.r0.get(i2)).getAdded());
                liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.r0.get(i2)).getCategoryId());
                liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.r0.get(i2)).getCustomSid());
                liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.r0.get(i2)).getTvArchive());
                liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.r0.get(i2)).getDirectSource());
                liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.r0.get(i2)).getTvArchiveDuration());
                liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.r0.get(i2)).getTypeName());
                liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.r0.get(i2)).getCategoryName());
                liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.r0.get(i2)).getSeriesNo());
                liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.r0.get(i2)).getLive());
                liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.r0.get(i2)).getContaiinerExtension());
                liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.r0.get(i2)).getUrl());
                if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < ePGTesting.size() && ((asyncTask = this.o2) == null || !asyncTask.isCancelled())) {
                            if (((LiveStreamsDBModel) this.r0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                                int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.f), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.f), this.f);
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
                this.s0.add(liveStreamsDBModel);
                this.t0 = this.s0;
            }
            return "get_fav";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_fav";
        }
    }

    public void F4() {
        Handler handler = this.b2.u;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    public String G3() {
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
            this.S3 = 0;
            ArrayList arrayList = this.t0;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList arrayList2 = new ArrayList();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
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
                arrayList2 = this.R.getLiveFavStalker(str3);
            } else {
                ArrayList arrayList3 = new ArrayList();
                if (this.x1 != null) {
                    if (this.X3.equals("true")) {
                        databaseHandler = this.x1;
                        str = "radio_streams";
                        userID = SharepreferenceDBHandler.getUserID(this.f);
                    } else {
                        databaseHandler = this.x1;
                        str = "live";
                        userID = SharepreferenceDBHandler.getUserID(this.f);
                    }
                    ArrayList allFavourites = databaseHandler.getAllFavourites(str, userID);
                    ArrayList arrayList4 = this.z0;
                    if (arrayList4 == null || arrayList4.size() <= 0 || allFavourites == null || allFavourites.size() <= 0) {
                        arrayList3 = allFavourites;
                    } else {
                        try {
                            Iterator it = allFavourites.iterator();
                            while (it.hasNext()) {
                                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
                                Iterator it2 = this.z0.iterator();
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
                                    LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.f);
                                    if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api")) {
                                        categoryID = favouriteDBModel2.getCategoryID();
                                        valueOf = String.valueOf(favouriteDBModel2.getStreamIDOneStream());
                                        timestamp = favouriteDBModel2.getTimestamp();
                                        str2 = this.F5;
                                    } else {
                                        categoryID = favouriteDBModel2.getCategoryID();
                                        valueOf = String.valueOf(favouriteDBModel2.getStreamID());
                                        timestamp = favouriteDBModel2.getTimestamp();
                                        str2 = this.F5;
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
                this.t0 = arrayList2;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.F2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.f)));
            boolean B2 = this.F2.B();
            ArrayList ePGTesting = B2 ? this.R.getEPGTesting((String) null, format) : null;
            this.X = getSharedPreferences("currentlyPlayingVideo", 0);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u")) {
                sharedPreferences = this.W;
                str4 = "LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U";
            } else {
                sharedPreferences = SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api") ? this.W : this.W;
            }
            String string = sharedPreferences.getString(str4, "");
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = this.t0;
            if (arrayList6 != null && arrayList6.size() > 0) {
                for (int i2 = 0; i2 < this.t0.size() && ((asyncTask = this.o2) == null || !asyncTask.isCancelled()); i2++) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u")) {
                        if (((LiveStreamsDBModel) this.t0.get(i2)).getUrl().equals(string)) {
                            this.S3 = i2;
                        }
                    } else if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api")) {
                        if (((LiveStreamsDBModel) this.t0.get(i2)).getStreamIdOneStream().equals(string)) {
                            this.S3 = i2;
                        }
                    } else if (((LiveStreamsDBModel) this.t0.get(i2)).getStreamId().equals(string)) {
                        this.S3 = i2;
                    }
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.t0.get(i2)).getNum());
                    liveStreamsDBModel.setName(((LiveStreamsDBModel) this.t0.get(i2)).getName());
                    liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.t0.get(i2)).getStreamType());
                    liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.t0.get(i2)).getStreamId());
                    liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.t0.get(i2)).getStreamIdOneStream());
                    liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.t0.get(i2)).getStreamIcon());
                    liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.t0.get(i2)).getEpgChannelId());
                    liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.t0.get(i2)).getAdded());
                    liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.t0.get(i2)).getCategoryId());
                    liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.t0.get(i2)).getCustomSid());
                    liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.t0.get(i2)).getTvArchive());
                    liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.t0.get(i2)).getDirectSource());
                    liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.t0.get(i2)).getTvArchiveDuration());
                    liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.t0.get(i2)).getTypeName());
                    liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.t0.get(i2)).getCategoryName());
                    liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.t0.get(i2)).getSeriesNo());
                    liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.t0.get(i2)).getLive());
                    liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.t0.get(i2)).getContaiinerExtension());
                    liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.t0.get(i2)).getUrl());
                    if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < ePGTesting.size() && ((asyncTask2 = this.o2) == null || !asyncTask2.isCancelled())) {
                                if (((LiveStreamsDBModel) this.t0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                                    int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.f), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.f), this.f);
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
            ArrayList arrayList7 = this.t0;
            if (arrayList7 == null) {
                return "get_fav";
            }
            arrayList7.clear();
            this.t0.addAll(arrayList5);
            return "get_fav";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "get_fav";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int G4() {
        /*
            r6 = this;
            int r0 = r6.v2
            r1 = 1
            int r0 = r0 + r1
            r6.v2 = r0
            java.lang.String r0 = "loginPrefs"
            r2 = 0
            android.content.SharedPreferences r0 = r6.getSharedPreferences(r0, r2)
            r6.x2 = r0
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r6.y2 = r0
            int r0 = r6.v2
            int[] r3 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.O5
            int r4 = r3.length
            int r0 = r0 % r4
            r6.v2 = r0
            r0 = r3[r0]
            r6.w2 = r0
            int r0 = a7.f.X6
            android.view.View r0 = r6.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            int r3 = a7.f.n
            android.view.View r3 = r6.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            com.google.android.exoplayer2.ui.PlayerView r4 = r6.b2
            int r5 = r6.w2
            r4.setResizeMode(r5)
            int r4 = r6.v2
            if (r4 != 0) goto L4a
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.j2
        L42:
            java.lang.String r1 = r1.getString(r4)
        L46:
            r3.setText(r1)
            goto L73
        L4a:
            if (r4 != r1) goto L53
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.i2
            goto L42
        L53:
            r1 = 2
            if (r4 != r1) goto L5d
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.Q8
            goto L42
        L5d:
            r1 = 3
            if (r4 != r1) goto L67
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.j3
            goto L42
        L67:
            r1 = 4
            if (r4 != r1) goto L6d
            java.lang.String r1 = "16:9"
            goto L46
        L6d:
            r1 = 5
            if (r4 != r1) goto L73
            java.lang.String r1 = "4:3"
            goto L46
        L73:
            android.content.SharedPreferences$Editor r1 = r6.y2
            java.lang.String r3 = "aspect_ratio"
            int r4 = r6.v2
            r1.putInt(r3, r4)
            android.content.SharedPreferences$Editor r1 = r6.y2
            r1.apply()
            r0.setVisibility(r2)
            android.widget.LinearLayout r1 = r6.R2
            if (r1 == 0) goto L95
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L95
            android.widget.LinearLayout r1 = r6.R2
            r2 = 8
            r1.setVisibility(r2)
        L95:
            android.os.Handler r1 = r6.G2
            r2 = 0
            r1.removeCallbacksAndMessages(r2)
            android.os.Handler r1 = r6.G2
            com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$A r2 = new com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity$A
            r2.<init>(r0)
            r3 = 3000(0xbb8, double:1.482E-320)
            r1.postDelayed(r2, r3)
            int r0 = r6.w2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.G4():int");
    }

    public void H(String str) {
        if (this.W3.equals("false")) {
            s4();
            return;
        }
        String str2 = this.Y0;
        this.K2 = str2;
        q7.N n2 = new q7.N(this.f, str2, "", this.X3, this.W3);
        this.M3 = n2;
        this.L2 = this.K2;
        this.u3.setAdapter(n2);
        this.u3.setLayoutManager(this.Q3);
        j3(true);
    }

    public void H3() {
        if (this.k5.getVisibility() == 0) {
            this.n5.setNextFocusRightId(a7.f.K3);
            this.o5.setNextFocusRightId(a7.f.e2);
            this.p5.setNextFocusRightId(a7.f.a2);
            this.q5.setNextFocusRightId(a7.f.V1);
        }
    }

    public int I3(ArrayList arrayList, int i2) {
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

    /* JADX WARN: Removed duplicated region for block: B:3:0x002f A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:17:0x0003, B:19:0x000b, B:21:0x000f, B:3:0x002f, B:5:0x0033), top: B:16:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void I4(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L2f
            java.lang.String r1 = ""
            boolean r1 = r4.equals(r1)     // Catch: java.lang.Exception -> L2d
            if (r1 != 0) goto L2f
            android.widget.ImageView r1 = r3.q     // Catch: java.lang.Exception -> L2d
            if (r1 == 0) goto L56
            android.content.Context r1 = r3.f     // Catch: java.lang.Exception -> L2d
            com.squareup.picasso.t r1 = com.squareup.picasso.t.q(r1)     // Catch: java.lang.Exception -> L2d
            com.squareup.picasso.x r4 = r1.l(r4)     // Catch: java.lang.Exception -> L2d
            r1 = 80
            r2 = 55
            com.squareup.picasso.x r4 = r4.k(r1, r2)     // Catch: java.lang.Exception -> L2d
            int r1 = a7.e.i1     // Catch: java.lang.Exception -> L2d
            com.squareup.picasso.x r4 = r4.j(r1)     // Catch: java.lang.Exception -> L2d
            android.widget.ImageView r1 = r3.q     // Catch: java.lang.Exception -> L2d
            r4.g(r1)     // Catch: java.lang.Exception -> L2d
            goto L56
        L2d:
            goto L43
        L2f:
            android.widget.ImageView r4 = r3.q     // Catch: java.lang.Exception -> L2d
            if (r4 == 0) goto L56
            android.content.Context r1 = r3.f     // Catch: java.lang.Exception -> L2d
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Exception -> L2d
            int r2 = a7.e.i1     // Catch: java.lang.Exception -> L2d
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2, r0)     // Catch: java.lang.Exception -> L2d
            r4.setImageDrawable(r1)     // Catch: java.lang.Exception -> L2d
            goto L56
        L43:
            android.widget.ImageView r4 = r3.q
            if (r4 == 0) goto L56
            android.content.Context r1 = r3.f
            android.content.res.Resources r1 = r1.getResources()
            int r2 = a7.e.i1
            android.graphics.drawable.Drawable r0 = r1.getDrawable(r2, r0)
            r4.setImageDrawable(r0)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.I4(java.lang.String):void");
    }

    public void J4(String str) {
        A3();
        String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.f);
        String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.f);
        try {
            if (this.a4 == null) {
                this.a4 = new n7.g(this, this.f);
            }
            this.a4.e(loggedInMacAddress, stalkerToken, str);
        } catch (Exception unused) {
        }
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
        try {
            StalkerLiveFavIdsSingleton.getInstance().setFavIdsList((List) null);
            this.g4.i(this.o4, this.p4);
        } catch (Exception unused) {
        }
    }

    public void M0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public void P(String str) {
        try {
            this.t1.setVisibility(8);
            N3();
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
        if (this.S2.getVisibility() == 0) {
            this.S2.startAnimation(this.I3);
            if (this.P2.getVisibility() == 0) {
                this.P2.startAnimation(this.I3);
            }
            if (this.R2.getVisibility() == 0) {
                this.R2.startAnimation(this.I3);
            }
            if (this.Q2.getVisibility() == 0) {
                this.Q2.startAnimation(this.I3);
            }
            this.S2.setVisibility(8);
            if (this.P2.getVisibility() == 0) {
                this.P2.setVisibility(8);
            }
            if (this.R2.getVisibility() == 0) {
                this.R2.setVisibility(8);
            }
            if (this.Q2.getVisibility() == 0) {
                this.Q2.setVisibility(8);
            }
            this.s3.setVisibility(8);
            this.q3.setVisibility(8);
            this.j5.setVisibility(4);
            this.r3.setVisibility(8);
        }
    }

    public void R3() {
        LinearLayout linearLayout = this.x3;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.y3;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    public void S3() {
        try {
            ProgressDialog progressDialog = this.r2;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.r2.dismiss();
        } catch (Exception unused) {
        }
    }

    public void T0(StalkerDeletePlayerLinkCallback stalkerDeletePlayerLinkCallback) {
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean T3() {
        /*
            Method dump skipped, instructions count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.T3():boolean");
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
        if (stalkerLiveFavIdsCallback != null && stalkerLiveFavIdsCallback.getJs() != null && stalkerLiveFavIdsCallback.getJs().size() > 0) {
            StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(stalkerLiveFavIdsCallback.getJs());
        }
        this.f4 = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
        if (this.W3.equals("false")) {
            s4();
            return;
        }
        String str = this.Y0;
        this.K2 = str;
        q7.N n2 = new q7.N(this.f, str, "", this.X3, this.W3);
        this.M3 = n2;
        this.L2 = this.K2;
        this.u3.setAdapter(n2);
        this.u3.setLayoutManager(this.Q3);
        j3(true);
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public boolean W3() {
        if (Build.VERSION.SDK_INT < 23) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        if (r7.o.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        Log.v("TAG", "Permission is revoked");
        D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 101);
        return false;
    }

    public void X(StalkerShortEPGCallback stalkerShortEPGCallback) {
        if (stalkerShortEPGCallback == null || stalkerShortEPGCallback.getJs() == null || stalkerShortEPGCallback.getJs().size() <= 0) {
            try {
                this.t1.setVisibility(8);
                N3();
            } catch (Exception unused) {
            }
        } else {
            HashMap hashMap = new HashMap();
            try {
                hashMap = y4(stalkerShortEPGCallback);
            } catch (Exception unused2) {
            }
            z3(hashMap);
        }
    }

    public void b4(String str) {
        this.L2 = str;
        try {
            SearchView searchView = this.J0;
            if (searchView != null && this.V1 != null) {
                searchView.d0("", false);
                this.V1.collapseActionView();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.U1 != null) {
                if (this.L2.equals("-6")) {
                    this.U1.getItem(2).getSubMenu().findItem(a7.f.Db).setVisible(true);
                } else {
                    this.U1.getItem(2).getSubMenu().findItem(a7.f.Db).setVisible(false);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        j3(true);
    }

    public void c(String str) {
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2) {
        Context context;
        StringBuilder sb;
        try {
            m7.w.X();
            if (this.I == null || this.O3 == null || stalkerSetLiveFavCallback == null || stalkerSetLiveFavCallback.getJs() == null || !stalkerSetLiveFavCallback.getJs().equals(Boolean.TRUE)) {
                return;
            }
            this.f4 = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
            if (str.equals("added")) {
                int i2 = this.h4;
                if (i2 != 0) {
                    this.f4.add(Integer.valueOf(i2));
                }
                StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(this.f4);
                try {
                    ListView listView = this.I;
                    View childAt = listView.getChildAt(this.q4 - listView.getFirstVisiblePosition());
                    if (childAt != null) {
                        try {
                            childAt.findViewById(a7.f.g5).setVisibility(0);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.M3.x(1);
                } catch (Exception unused) {
                }
                context = this.f;
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.f.getResources().getString(a7.j.q));
            } else {
                int i3 = this.h4;
                if (i3 != 0) {
                    this.f4.remove(Integer.valueOf(i3));
                    StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(this.f4);
                }
                try {
                    ListView listView2 = this.I;
                    View childAt2 = listView2.getChildAt(this.q4 - listView2.getFirstVisiblePosition());
                    if (childAt2 != null) {
                        try {
                            childAt2.findViewById(a7.f.g5).setVisibility(4);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    this.M3.x(1);
                } catch (Exception unused2) {
                }
                context = this.f;
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.f.getResources().getString(a7.j.c6));
            }
            m7.w.P0(context, sb.toString());
        } catch (Exception unused3) {
        }
    }

    public final void d3(String str, int i2, String str2, String str3, String str4, int i3, String str5) {
        new S(str, i2, str2, str3, str4, i3, str5).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
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

    public final void e3(String str, String str2, String str3, int i2) {
        new T(str, str2, str3, i2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public void e4() {
        LinearLayout linearLayout = this.x3;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        if (this.x3 != null) {
            this.y3.setVisibility(0);
        }
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void f4() {
        m7.a.Y = Boolean.TRUE;
        this.C = true;
        this.o.setVisibility(0);
        this.p.setText(this.f.getResources().getString(a7.j.g4));
        this.t1.setVisibility(8);
        if (m7.a.B.booleanValue()) {
            findViewById(a7.f.Sm).setVisibility(8);
        }
    }

    public void g3() {
        s3();
        this.o2 = new M().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels"});
    }

    public void g4(int i2) {
        try {
            q7.N n2 = this.M3;
            if (n2 != null) {
                n2.x(i2);
            }
        } catch (Exception unused) {
        }
    }

    public void h3() {
        s3();
        this.o2 = new M().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels_with_cat"});
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public String i3() {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        String str2;
        String string;
        AsyncTask asyncTask;
        try {
            this.t2 = 0;
            ArrayList arrayList = this.r0;
            if (arrayList != null && this.p0 != null) {
                arrayList.clear();
                this.p0.clear();
            }
            if (this.X3.equals("true")) {
                liveStreamDBHandler = this.R;
                str = this.Y0;
                str2 = "radio_streams";
            } else {
                liveStreamDBHandler = this.R;
                str = this.Y0;
                str2 = "live";
            }
            this.w0 = liveStreamDBHandler.getAllLiveStreasWithCategoryId(str, str2);
            this.r0 = this.w0;
            ArrayList arrayList2 = this.s0;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.F2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.f)));
            boolean B2 = this.F2.B();
            ArrayList ePGTesting = B2 ? this.R.getEPGTesting((String) null, format) : null;
            this.X = getSharedPreferences("currentlyPlayingVideo", 0);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u")) {
                string = this.W.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "");
            } else {
                SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api");
                string = this.W.getString("currentlyPlayingVideo", "");
            }
            ArrayList arrayList3 = this.r0;
            if (arrayList3 == null || arrayList3.size() <= 0) {
                return "all_channels_with_cat";
            }
            for (int i2 = 0; i2 < this.r0.size(); i2++) {
                AsyncTask asyncTask2 = this.o2;
                if (asyncTask2 != null && asyncTask2.isCancelled()) {
                    return "all_channels_with_cat";
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u") && ((LiveStreamsDBModel) this.r0.get(i2)).getUrl().equals(string)) {
                    this.t2 = i2;
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.r0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.t2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.r0.get(i2)).getStreamId().equals(string)) {
                    this.t2 = i2;
                }
                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.r0.get(i2)).getNum());
                liveStreamsDBModel.setName(((LiveStreamsDBModel) this.r0.get(i2)).getName());
                liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.r0.get(i2)).getStreamType());
                liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.r0.get(i2)).getStreamId());
                liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.r0.get(i2)).getStreamIcon());
                liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.r0.get(i2)).getEpgChannelId());
                liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.r0.get(i2)).getAdded());
                liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.r0.get(i2)).getCategoryId());
                liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.r0.get(i2)).getCustomSid());
                liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.r0.get(i2)).getTvArchive());
                liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.r0.get(i2)).getDirectSource());
                liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.r0.get(i2)).getTvArchiveDuration());
                liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.r0.get(i2)).getTypeName());
                liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.r0.get(i2)).getCategoryName());
                liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.r0.get(i2)).getSeriesNo());
                liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.r0.get(i2)).getLive());
                liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.r0.get(i2)).getContaiinerExtension());
                liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.r0.get(i2)).getUrl());
                liveStreamsDBModel.setCmd(((LiveStreamsDBModel) this.r0.get(i2)).getCmd());
                if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ePGTesting.size() || ((asyncTask = this.o2) != null && asyncTask.isCancelled())) {
                            break;
                        }
                        if (((LiveStreamsDBModel) this.r0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                            int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.f), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.f), this.f);
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
                this.s0.add(liveStreamsDBModel);
            }
            return "all_channels_with_cat";
        } catch (Exception unused) {
            return "all_channels_with_cat";
        }
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public void j3(boolean z2) {
        ProgressDialog progressDialog;
        s3();
        if (z2) {
            ProgressDialog progressDialog2 = this.r2;
            if (progressDialog2 == null) {
                progressDialog = w3(this.f);
                this.r2 = progressDialog;
                if (progressDialog != null) {
                    progressDialog.show();
                }
            } else if (!progressDialog2.isShowing()) {
                progressDialog = this.r2;
                progressDialog.show();
            }
        }
        this.o2 = new N().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels_with_cat"});
    }

    public void k3() {
        s3();
        this.o2 = new M().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"get_fav"});
    }

    public void l3() {
        s3();
        this.o2 = new M().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"recently_watched"});
    }

    public String m3() {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        String string;
        AsyncTask asyncTask;
        AsyncTask asyncTask2;
        try {
            this.S3 = 0;
            ArrayList arrayList = this.t0;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (this.X3.equalsIgnoreCase("true")) {
                liveStreamDBHandler = this.R;
                str = "radio_streams";
            } else {
                liveStreamDBHandler = this.R;
                str = "live";
            }
            this.t0 = liveStreamDBHandler.getAllRecentlyWatchedLiveStreams(str);
            ArrayList arrayList2 = this.u0;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.F2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.f)));
            boolean B2 = this.F2.B();
            ArrayList ePGTesting = B2 ? this.R.getEPGTesting((String) null, format) : null;
            this.X = getSharedPreferences("currentlyPlayingVideo", 0);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u")) {
                string = this.W.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "");
            } else {
                SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api");
                string = this.W.getString("currentlyPlayingVideo", "");
            }
            ArrayList arrayList3 = this.t0;
            if (arrayList3 != null && arrayList3.size() > 0) {
                for (int i2 = 0; i2 < this.t0.size() && ((asyncTask = this.o2) == null || !asyncTask.isCancelled()); i2++) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("m3u")) {
                        if (((LiveStreamsDBModel) this.t0.get(i2)).getUrl().equals(string)) {
                            this.S3 = i2;
                            this.N1 = i2;
                        }
                    } else if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("onestream_api")) {
                        if (((LiveStreamsDBModel) this.r0.get(i2)).getStreamIdOneStream().equals(string)) {
                            this.t2 = i2;
                        }
                    } else if (((LiveStreamsDBModel) this.t0.get(i2)).getStreamId().equals(string)) {
                        this.S3 = i2;
                        this.N1 = i2;
                    }
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.t0.get(i2)).getNum());
                    liveStreamsDBModel.setName(((LiveStreamsDBModel) this.t0.get(i2)).getName());
                    liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.t0.get(i2)).getStreamType());
                    liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.t0.get(i2)).getStreamId());
                    liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.t0.get(i2)).getStreamIcon());
                    liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.t0.get(i2)).getEpgChannelId());
                    liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.t0.get(i2)).getAdded());
                    liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.t0.get(i2)).getCategoryId());
                    liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.t0.get(i2)).getCustomSid());
                    liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.t0.get(i2)).getTvArchive());
                    liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.t0.get(i2)).getDirectSource());
                    liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.t0.get(i2)).getTvArchiveDuration());
                    liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.t0.get(i2)).getTypeName());
                    liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.t0.get(i2)).getCategoryName());
                    liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.t0.get(i2)).getSeriesNo());
                    liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.t0.get(i2)).getLive());
                    liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.t0.get(i2)).getContaiinerExtension());
                    liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.t0.get(i2)).getUrl());
                    liveStreamsDBModel.setCmd(((LiveStreamsDBModel) this.t0.get(i2)).getCmd());
                    if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < ePGTesting.size() && ((asyncTask2 = this.o2) == null || !asyncTask2.isCancelled())) {
                                if (((LiveStreamsDBModel) this.t0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                                    int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.f), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.f), this.f);
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
                    this.u0.add(liveStreamsDBModel);
                }
            }
            this.t0 = this.u0;
            return "all_channels_with_cat";
        } catch (Exception unused) {
            return "all_channels_with_cat";
        }
    }

    public void o0(String str) {
    }

    public void o3(int i2) {
        this.b2.v = new t();
        PlayerView playerView = this.b2;
        playerView.u.postDelayed(playerView.v, i2);
    }

    public void o4() {
        try {
            I1 i1 = this.r4;
            if (i1 != null) {
                i1.release();
                this.r4 = null;
                this.t4 = null;
            }
        } catch (Exception unused) {
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i2, i3, intent);
        if (i2 == 101) {
            try {
                if (W3()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("downloadStatus", 0);
                    K5 = sharedPreferences;
                    String string = sharedPreferences.getString("downloadStatus", "");
                    m7.w wVar = new m7.w();
                    if (string.equals("processing")) {
                        wVar.L0(this);
                    } else {
                        wVar.O0(this, this.j2, this.g0, this.g, this.D, this.E, this.d);
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
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.onBackPressed():void");
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        CheckBox checkBox;
        boolean isChecked = ((CheckBox) compoundButton).isChecked();
        int id = compoundButton.getId();
        if (id == a7.f.V1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.S4;
            }
        } else if (id == a7.f.X1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.T4;
            }
        } else if (id == a7.f.Y1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.U4;
            }
        } else if (id == a7.f.W1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.V4;
            }
        } else if (id == a7.f.e2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.I4;
            }
        } else if (id == a7.f.g2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.J4;
            }
        } else if (id == a7.f.h2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.K4;
            }
        } else if (id == a7.f.f2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.L4;
            }
        } else if (id == a7.f.a2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.M4;
            }
        } else if (id == a7.f.c2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.N4;
            }
        } else if (id == a7.f.d2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.O4;
            }
        } else if (id == a7.f.b2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.P4;
            }
        } else if (id != a7.f.Z1 || !isChecked) {
            return;
        } else {
            checkBox = this.Q4;
        }
        this.A5 = checkBox.getText().toString();
    }

    public void onClick(View view) {
        String str;
        String str2;
        x7.a f2;
        String valueOf;
        x7.a f3;
        String valueOf2;
        Toast makeText;
        TextView textView;
        Resources resources;
        int i2;
        int i3;
        int i4;
        ImageView imageView;
        ImageView imageView2;
        int id = view.getId();
        if (id != a7.f.S8) {
            if (id != a7.f.I5) {
                if (id == a7.f.H5) {
                    try {
                        if (this.L3.equals("tv")) {
                            F4();
                            z4();
                            pause();
                            this.b3.setVisibility(8);
                            this.a3.setVisibility(0);
                            this.a3.requestFocus();
                        } else {
                            F4();
                            A4();
                            pause();
                            this.b3.setVisibility(8);
                            this.a3.setVisibility(0);
                        }
                        return;
                    } catch (Exception e2) {
                        str = "exection " + e2;
                        str2 = "NSTIJPLAYERACTIVTY";
                    }
                } else if (id == a7.f.x9) {
                    try {
                        AsyncTask asyncTask = this.q2;
                        if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
                            this.q2.cancel(true);
                        }
                        this.m4 = Boolean.FALSE;
                        this.I1.removeCallbacksAndMessages((Object) null);
                        this.I1.postDelayed(new o(), 5000L);
                        F4();
                        A4();
                        n3(5000);
                        if (this.b2 != null) {
                            this.D1.removeCallbacksAndMessages((Object) null);
                            n4();
                            this.P0 = true;
                            int currentWindowIndex = this.b2.getCurrentWindowIndex();
                            ArrayList arrayList = this.v0;
                            if (arrayList == null || arrayList.size() <= 1 || currentWindowIndex > this.v0.size() - 1 || currentWindowIndex <= -1) {
                                return;
                            }
                            String name = ((LiveStreamsDBModel) this.v0.get(currentWindowIndex)).getName();
                            String num = ((LiveStreamsDBModel) this.v0.get(currentWindowIndex)).getNum();
                            this.J2 = m7.w.r0(((LiveStreamsDBModel) this.v0.get(currentWindowIndex)).getNum());
                            String url = ((LiveStreamsDBModel) this.v0.get(currentWindowIndex)).getUrl();
                            this.w1 = url;
                            String streamIcon = ((LiveStreamsDBModel) this.v0.get(currentWindowIndex)).getStreamIcon();
                            try {
                                if (streamIcon.equals("") || streamIcon.isEmpty()) {
                                    this.q.setImageDrawable(this.f.getResources().getDrawable(a7.e.i1));
                                } else {
                                    com.squareup.picasso.t.q(this.f).l(streamIcon).j(a7.e.i1).d(a7.e.i1).k(80, 55).g(this.q);
                                }
                            } catch (Exception unused) {
                                this.q.setImageDrawable(this.f.getResources().getDrawable(a7.e.i1));
                            }
                            this.b2.setTitle(num + " - " + name);
                            this.N1 = currentWindowIndex;
                            this.K1.clear();
                            this.K1.apply();
                            this.L1.clear();
                            this.L1.apply();
                            this.J1.clear();
                            this.J1.apply();
                            if (this.h2.booleanValue()) {
                                this.D1.postDelayed(new p(currentWindowIndex, name, url), SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api") ? 1000 : 200);
                            }
                            this.F1.removeCallbacksAndMessages((Object) null);
                            this.v1 = m7.w.q0(((LiveStreamsDBModel) this.v0.get(currentWindowIndex)).getStreamId());
                            if (this.Y1.equals("m3u")) {
                                f2 = x7.a.f();
                                valueOf = this.w1;
                            } else {
                                f2 = x7.a.f();
                                valueOf = String.valueOf(this.v1);
                            }
                            f2.A(valueOf);
                            SharedPreferences.Editor editor = this.y1;
                            if (editor != null) {
                                editor.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) this.v0.get(currentWindowIndex)).getStreamId()));
                                this.y1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", ((LiveStreamsDBModel) this.v0.get(currentWindowIndex)).getUrl());
                                this.y1.apply();
                            }
                            SharedPreferences.Editor editor2 = this.z1;
                            if (editor2 != null) {
                                editor2.putInt("currentlyPlayingVideoPosition", currentWindowIndex);
                                this.z1.apply();
                            }
                            if (this.t2 != 0) {
                                this.t2 = currentWindowIndex;
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        str = "exection " + e3;
                        str2 = "NSTIJPLAYERskyACTIVTY";
                    }
                } else {
                    if (id == a7.f.T8) {
                        try {
                            AsyncTask asyncTask2 = this.q2;
                            if (asyncTask2 != null && asyncTask2.getStatus().equals(AsyncTask.Status.RUNNING)) {
                                this.q2.cancel(true);
                            }
                            this.m4 = Boolean.FALSE;
                            this.I1.removeCallbacksAndMessages((Object) null);
                            this.I1.postDelayed(new q(), 5000L);
                            F4();
                            A4();
                            n3(5000);
                            if (this.b2 != null) {
                                this.D1.removeCallbacksAndMessages((Object) null);
                                this.P0 = true;
                                d4();
                                int currentWindowIndex2 = this.b2.getCurrentWindowIndex();
                                ArrayList arrayList2 = this.v0;
                                if (arrayList2 == null || arrayList2.size() <= 1 || currentWindowIndex2 > this.v0.size() - 1 || currentWindowIndex2 <= -1) {
                                    return;
                                }
                                String name2 = ((LiveStreamsDBModel) this.v0.get(currentWindowIndex2)).getName();
                                String url2 = ((LiveStreamsDBModel) this.v0.get(currentWindowIndex2)).getUrl();
                                this.w1 = url2;
                                String num2 = ((LiveStreamsDBModel) this.v0.get(currentWindowIndex2)).getNum();
                                this.J2 = m7.w.r0(((LiveStreamsDBModel) this.v0.get(currentWindowIndex2)).getNum());
                                String streamIcon2 = ((LiveStreamsDBModel) this.v0.get(currentWindowIndex2)).getStreamIcon();
                                try {
                                    if (streamIcon2.equals("") || streamIcon2.isEmpty()) {
                                        this.q.setImageDrawable(this.f.getResources().getDrawable(a7.e.i1));
                                    } else {
                                        com.squareup.picasso.t.q(this.f).l(streamIcon2).j(a7.e.i1).d(a7.e.i1).k(80, 55).g(this.q);
                                    }
                                } catch (Exception unused2) {
                                    this.q.setImageDrawable(this.f.getResources().getDrawable(a7.e.i1));
                                }
                                this.b2.setTitle(num2 + " - " + name2);
                                this.N1 = currentWindowIndex2;
                                this.K1.clear();
                                this.K1.apply();
                                this.L1.clear();
                                this.L1.apply();
                                this.J1.clear();
                                this.J1.apply();
                                if (this.h2.booleanValue()) {
                                    this.D1.postDelayed(new r(currentWindowIndex2, name2, url2), SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api") ? 1000 : 200);
                                }
                                this.F1.removeCallbacksAndMessages((Object) null);
                                this.v1 = m7.w.q0(((LiveStreamsDBModel) this.v0.get(currentWindowIndex2)).getStreamId());
                                if (this.Y1.equals("m3u")) {
                                    f3 = x7.a.f();
                                    valueOf2 = this.w1;
                                } else {
                                    f3 = x7.a.f();
                                    valueOf2 = String.valueOf(this.v1);
                                }
                                f3.A(valueOf2);
                                SharedPreferences.Editor editor3 = this.y1;
                                if (editor3 != null) {
                                    editor3.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) this.v0.get(currentWindowIndex2)).getStreamId()));
                                    this.y1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", ((LiveStreamsDBModel) this.v0.get(currentWindowIndex2)).getUrl());
                                    this.y1.apply();
                                }
                                SharedPreferences.Editor editor4 = this.z1;
                                if (editor4 != null) {
                                    editor4.putInt("currentlyPlayingVideoPosition", currentWindowIndex2);
                                    this.z1.apply();
                                }
                                if (this.t2 != 0) {
                                    this.t2 = currentWindowIndex2;
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception e4) {
                            str = "exection " + e4;
                        }
                    } else {
                        if (id == a7.f.x3 || id == a7.f.w3 || id == a7.f.z3 || id == a7.f.Qm) {
                            return;
                        }
                        if (id != a7.f.p) {
                            if (id == a7.f.Z6 || id == a7.f.C4) {
                                F4();
                                O3();
                                D4();
                                return;
                            }
                            if (id == a7.f.c7 || id == a7.f.E4) {
                                onBackPressed();
                            } else if (id != a7.f.I4 && id != a7.f.J4) {
                                if (id == a7.f.v7) {
                                    F4();
                                    O3();
                                    v4("player", true);
                                    return;
                                }
                                if (id == a7.f.B7) {
                                    F4();
                                    n3(5000);
                                    G4();
                                    return;
                                }
                                if (id != a7.f.if) {
                                    if (id == a7.f.y7 || id == a7.f.S4) {
                                        F4();
                                        O3();
                                        if (this.m5.getVisibility() == 8) {
                                            this.m5.startAnimation(this.J3);
                                            this.m5.setVisibility(0);
                                            this.n5.requestFocus();
                                            this.h5.requestFocus();
                                            this.S4.setChecked(false);
                                            this.T4.setChecked(false);
                                            this.U4.setChecked(false);
                                            this.V4.setChecked(false);
                                            this.M4.setChecked(false);
                                            this.N4.setChecked(false);
                                            this.O4.setChecked(false);
                                            this.P4.setChecked(false);
                                            this.Q4.setChecked(false);
                                            this.I4.setChecked(false);
                                            this.J4.setChecked(false);
                                            this.K4.setChecked(false);
                                            this.L4.setChecked(false);
                                            this.g5.setText("");
                                            return;
                                        }
                                        return;
                                    }
                                    if (id == a7.f.x1) {
                                        this.y5 = this.Y4.getText().toString();
                                        this.z5 = this.c5.getText().toString();
                                        i3 = 0;
                                        this.k5.setVisibility(0);
                                        this.F4.setVisibility(0);
                                        i4 = 8;
                                        this.E4.setVisibility(8);
                                        this.G4.setVisibility(8);
                                        this.s5.setVisibility(8);
                                    } else {
                                        if (id == a7.f.Jg) {
                                            this.y5 = this.Z4.getText().toString();
                                            this.z5 = this.d5.getText().toString();
                                            this.k5.setVisibility(0);
                                            i4 = 8;
                                            this.F4.setVisibility(8);
                                            this.s5.setVisibility(8);
                                            this.E4.setVisibility(0);
                                            this.g5.setVisibility(0);
                                            this.G4.setVisibility(8);
                                            this.R4.setVisibility(i4);
                                            textView = this.W4;
                                            resources = getResources();
                                            i2 = a7.j.Q7;
                                            textView.setText(resources.getString(i2));
                                            return;
                                        }
                                        if (id == a7.f.X) {
                                            this.y5 = this.a5.getText().toString();
                                            this.z5 = this.e5.getText().toString();
                                            i3 = 0;
                                            this.k5.setVisibility(0);
                                            i4 = 8;
                                            this.F4.setVisibility(8);
                                            this.E4.setVisibility(8);
                                            this.s5.setVisibility(8);
                                            this.G4.setVisibility(0);
                                        } else {
                                            if (id == a7.f.k) {
                                                this.y5 = this.b5.getText().toString();
                                                this.z5 = this.f5.getText().toString();
                                                this.k5.setVisibility(0);
                                                this.F4.setVisibility(8);
                                                this.E4.setVisibility(8);
                                                this.G4.setVisibility(8);
                                                this.s5.setVisibility(8);
                                                this.R4.setVisibility(0);
                                                this.g5.setVisibility(0);
                                                textView = this.W4;
                                                resources = getResources();
                                                i2 = a7.j.Q7;
                                                textView.setText(resources.getString(i2));
                                                return;
                                            }
                                            if (id == a7.f.v2) {
                                                this.k5.setVisibility(0);
                                                this.F4.setVisibility(8);
                                                this.E4.setVisibility(8);
                                                this.G4.setVisibility(8);
                                                this.R4.setVisibility(8);
                                                this.s5.setVisibility(0);
                                                this.g5.setVisibility(4);
                                                this.r5.setVisibility(0);
                                                textView = this.W4;
                                                resources = getResources();
                                                i2 = a7.j.y0;
                                                textView.setText(resources.getString(i2));
                                                return;
                                            }
                                            if (id != a7.f.tm) {
                                                return;
                                            }
                                            if (this.s5.getVisibility() == 0) {
                                                try {
                                                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getResources().getString(a7.j.z0))));
                                                } catch (ActivityNotFoundException e5) {
                                                    Toast.makeText(this, "No application can handle this request. Please install a webbrowser", 1).show();
                                                    e5.printStackTrace();
                                                }
                                                this.m5.setVisibility(8);
                                                return;
                                            }
                                            this.B5 = this.g5.getText().toString();
                                            r3();
                                            if (this.M4.isChecked() || this.N4.isChecked() || this.O4.isChecked() || this.P4.isChecked() || this.Q4.isChecked() || this.S4.isChecked() || this.T4.isChecked() || this.U4.isChecked() || this.V4.isChecked() || this.I4.isChecked() || this.J4.isChecked() || this.K4.isChecked() || this.L4.isChecked() || this.g5.length() > 0) {
                                                v1();
                                                this.S4.setChecked(false);
                                                this.T4.setChecked(false);
                                                this.U4.setChecked(false);
                                                this.V4.setChecked(false);
                                                this.M4.setChecked(false);
                                                this.N4.setChecked(false);
                                                this.O4.setChecked(false);
                                                this.P4.setChecked(false);
                                                this.Q4.setChecked(false);
                                                this.I4.setChecked(false);
                                                this.J4.setChecked(false);
                                                this.K4.setChecked(false);
                                                this.L4.setChecked(false);
                                                this.g5.setText("");
                                                RelativeLayout relativeLayout = this.m5;
                                                if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                                                    return;
                                                }
                                                this.m5.setVisibility(8);
                                                this.k5.setVisibility(8);
                                                this.k5.startAnimation(this.I3);
                                                this.m5.startAnimation(this.I3);
                                                return;
                                            }
                                            makeText = Toast.makeText(this.f, "Please Add Report", 0);
                                        }
                                    }
                                    this.g5.setVisibility(i3);
                                    this.R4.setVisibility(i4);
                                    textView = this.W4;
                                    resources = getResources();
                                    i2 = a7.j.Q7;
                                    textView.setText(resources.getString(i2));
                                    return;
                                }
                                imageView = this.w3;
                            }
                            onBackPressed();
                            return;
                        }
                        try {
                            C3();
                            return;
                        } catch (Exception e6) {
                            str = "exection " + e6.getMessage();
                        }
                    }
                    str2 = "NSTIJPLAYER";
                }
                Log.e(str2, str);
                return;
            }
            if (!this.L3.equals("tv")) {
                I1 i1 = this.r4;
                if (i1 == null || i1.getPlaybackState() != 3) {
                    F4();
                    A4();
                    o3(5000);
                    imageView2 = this.a3;
                } else {
                    F4();
                    A4();
                    o3(1000);
                    l4();
                    this.a3.setVisibility(8);
                    imageView2 = this.b3;
                }
                imageView2.setVisibility(0);
                return;
            }
            I1 i12 = this.r4;
            if (i12 == null || i12.getPlaybackState() != 3) {
                F4();
                z4();
                n3(5000);
                this.a3.setVisibility(0);
                imageView = this.a3;
            } else {
                F4();
                z4();
                n3(1000);
                l4();
                this.a3.setVisibility(8);
                this.b3.setVisibility(0);
                imageView = this.b3;
            }
            imageView.requestFocus();
            return;
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
            this.i4 = true;
            if (this.C) {
                return;
            }
            o4();
            if (this.Y1.equals("m3u")) {
                if (this.h2.booleanValue()) {
                    Intent intent = new Intent(this.f, NSTIJKPlayerMultiActivity.class);
                    intent.putExtra("url", this.w1);
                    x7.a.f().A(this.w1);
                    intent.putExtra("CHANNEL_NUM", this.J2);
                    this.f.startActivity(intent);
                    return;
                }
                return;
            }
            if (this.v1 == -1 || !this.h2.booleanValue()) {
                return;
            }
            String V2 = m7.w.V(this.f, this.v1, this.g0, "live");
            x7.a.f().A(String.valueOf(this.v1));
            Intent intent2 = new Intent(this.f, NSTIJKPlayerMultiActivity.class);
            intent2.putExtra("url", V2);
            intent2.putExtra("CHANNEL_NUM", this.J2);
            this.f.startActivity(intent2);
            return;
        }
        makeText = Toast.makeText(this.f, "This feature has been disabled.", 1);
        makeText.show();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f3(configuration);
    }

    public void onCreate(Bundle bundle) {
        m.e eVar;
        m.d P2;
        SharedPreferences.Editor editor;
        String valueOf;
        this.f = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        this.s4 = r7.b.d(this);
        SharedPreferences sharedPreferences = getSharedPreferences("auto_start", 0);
        this.B4 = sharedPreferences;
        boolean z2 = sharedPreferences.getBoolean("subtitle_active", true);
        if (bundle != null) {
            P2 = (m.d) bundle.getParcelable("track_selector_parameters");
        } else {
            if (z2) {
                eVar = new m.e(this);
            } else {
                eVar = new m.e(this);
                eVar = eVar.R(1);
            }
            P2 = eVar.P();
        }
        this.u4 = P2;
        setContentView(a7.g.C);
        this.N2 = findViewById(a7.f.Lf);
        this.O2 = findViewById(a7.f.Kf);
        this.P2 = findViewById(a7.f.j7);
        this.Q2 = findViewById(a7.f.Ea);
        this.h3 = findViewById(a7.f.Mh);
        this.i3 = findViewById(a7.f.mm);
        this.R2 = findViewById(a7.f.h9);
        this.X2 = findViewById(a7.f.lf);
        this.Y2 = findViewById(a7.f.ne);
        this.Z2 = findViewById(a7.f.oe);
        this.S2 = findViewById(a7.f.t9);
        this.a3 = findViewById(a7.f.I5);
        this.b3 = findViewById(a7.f.H5);
        this.T2 = findViewById(a7.f.b7);
        this.c3 = findViewById(a7.f.I4);
        this.d3 = findViewById(a7.f.J4);
        this.e3 = findViewById(a7.f.E4);
        this.U2 = findViewById(a7.f.c7);
        this.f3 = findViewById(a7.f.C4);
        this.V2 = findViewById(a7.f.B7);
        this.W2 = findViewById(a7.f.Y6);
        this.l3 = findViewById(a7.f.S8);
        this.m3 = findViewById(a7.f.v7);
        this.n3 = findViewById(a7.f.x9);
        this.o3 = findViewById(a7.f.T8);
        this.j3 = findViewById(a7.f.lj);
        this.p3 = findViewById(a7.f.va);
        this.q3 = findViewById(a7.f.ya);
        this.r3 = findViewById(a7.f.wa);
        this.s3 = findViewById(a7.f.i7);
        this.t3 = findViewById(a7.f.C7);
        this.u3 = findViewById(a7.f.Fd);
        this.v3 = findViewById(a7.f.Gd);
        this.w3 = findViewById(a7.f.m3);
        this.x3 = findViewById(a7.f.W8);
        this.y3 = findViewById(a7.f.X8);
        this.z3 = findViewById(a7.f.if);
        this.A3 = findViewById(a7.f.x7);
        this.g3 = findViewById(a7.f.W5);
        this.k3 = findViewById(a7.f.ah);
        this.B3 = findViewById(a7.f.Z6);
        this.E4 = findViewById(a7.f.Hg);
        this.F4 = findViewById(a7.f.w1);
        this.G4 = findViewById(a7.f.Z);
        this.H4 = findViewById(a7.f.ym);
        this.I4 = findViewById(a7.f.e2);
        this.J4 = findViewById(a7.f.g2);
        this.K4 = findViewById(a7.f.h2);
        this.L4 = findViewById(a7.f.f2);
        this.M4 = findViewById(a7.f.a2);
        this.N4 = findViewById(a7.f.c2);
        this.O4 = findViewById(a7.f.d2);
        this.P4 = findViewById(a7.f.b2);
        this.Q4 = findViewById(a7.f.Z1);
        this.R4 = findViewById(a7.f.j);
        this.S4 = findViewById(a7.f.V1);
        this.T4 = findViewById(a7.f.X1);
        this.U4 = findViewById(a7.f.Y1);
        this.V4 = findViewById(a7.f.W1);
        this.W4 = findViewById(a7.f.tm);
        this.X4 = findViewById(a7.f.z7);
        this.Y4 = findViewById(a7.f.v1);
        this.Z4 = findViewById(a7.f.Fg);
        this.a5 = findViewById(a7.f.a0);
        this.b5 = findViewById(a7.f.l);
        this.c5 = findViewById(a7.f.y1);
        this.d5 = findViewById(a7.f.Lg);
        this.e5 = findViewById(a7.f.b0);
        this.f5 = findViewById(a7.f.m);
        this.g5 = findViewById(a7.f.K3);
        this.h5 = findViewById(a7.f.X3);
        this.i5 = findViewById(a7.f.y7);
        this.j5 = findViewById(a7.f.xa);
        this.k5 = findViewById(a7.f.a);
        this.l5 = findViewById(a7.f.S4);
        this.m5 = findViewById(a7.f.ee);
        this.n5 = findViewById(a7.f.x1);
        this.o5 = findViewById(a7.f.Jg);
        this.p5 = findViewById(a7.f.X);
        this.q5 = findViewById(a7.f.k);
        this.r5 = findViewById(a7.f.v2);
        this.s5 = findViewById(a7.f.u2);
        if (!m7.a.V0.booleanValue()) {
            this.j5.setVisibility(4);
        }
        overridePendingTransition(a7.b.f, a7.b.d);
        V3();
        RelativeLayout relativeLayout = this.T0;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new k());
        }
        this.z0 = J3();
        if (this.y1 != null) {
            if (this.Y1.equals("onestream_api")) {
                editor = this.y1;
                valueOf = this.e;
            } else {
                editor = this.y1;
                valueOf = String.valueOf(this.l2);
            }
            editor.putString("currentlyPlayingVideo", valueOf);
            this.y1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "0");
            this.y1.apply();
        }
        this.R.deleteExtraLiveRecentlyWatched();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
            try {
                this.p4 = SharepreferenceDBHandler.getStalkerToken(this.f);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.f);
                this.o4 = loggedInMacAddress;
                this.g4.f(loggedInMacAddress, this.p4, 0);
            } catch (Exception unused) {
            }
        } else if (this.W3.equals("false")) {
            s4();
        } else {
            String str = this.Y0;
            this.K2 = str;
            q7.N n2 = new q7.N(this.f, str, "", this.X3, this.W3);
            this.M3 = n2;
            this.L2 = this.K2;
            this.u3.setAdapter(n2);
            this.u3.setLayoutManager(this.Q3);
            j3(true);
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
            m7.w.Z(this.f);
        }
        H3();
        String I1 = FreeTrailActivity.I1();
        this.w5 = I1;
        if (I1.equals("") || this.w5.isEmpty()) {
            this.w5 = m7.w.I(this.f);
        }
        this.S4.setOnCheckedChangeListener(this);
        this.T4.setOnCheckedChangeListener(this);
        this.U4.setOnCheckedChangeListener(this);
        this.V4.setOnCheckedChangeListener(this);
        this.M4.setOnCheckedChangeListener(this);
        this.N4.setOnCheckedChangeListener(this);
        this.O4.setOnCheckedChangeListener(this);
        this.P4.setOnCheckedChangeListener(this);
        this.Q4.setOnCheckedChangeListener(this);
        this.I4.setOnCheckedChangeListener(this);
        this.J4.setOnCheckedChangeListener(this);
        this.K4.setOnCheckedChangeListener(this);
        this.L4.setOnCheckedChangeListener(this);
        this.H4.setOnClickListener(new w());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.I0.x(a7.h.r);
        this.U1 = menu;
        this.V1 = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("api")) {
            menu.getItem(2).getSubMenu().findItem(a7.f.gb).setVisible(false);
        }
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, this.f.getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.I0.getChildCount(); i2++) {
            if (this.I0.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.I0.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            s3();
            o4();
        } catch (Exception unused) {
        }
        try {
            Thread thread = this.H5;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.H5.interrupt();
        } catch (Exception unused2) {
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        keyEvent.getRepeatCount();
        keyEvent.getAction();
        if (L5 && this.s3.getVisibility() == 8 && this.X2.getVisibility() == 8 && this.Z2.getVisibility() == 8 && this.m5.getVisibility() == 8) {
            if (i2 == 20) {
                if (this.h2.booleanValue()) {
                    findViewById(a7.f.x9).performClick();
                }
                return true;
            }
            if (i2 == 19) {
                if (this.h2.booleanValue()) {
                    findViewById(a7.f.T8).performClick();
                }
                return true;
            }
        }
        if (i2 == 166) {
            if (L5 && this.h2.booleanValue()) {
                findViewById(a7.f.T8).performClick();
            }
            return true;
        }
        if (i2 != 167) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (L5 && this.h2.booleanValue()) {
            findViewById(a7.f.x9).performClick();
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        StringBuilder sb;
        boolean z2 = keyEvent.getRepeatCount() == 0;
        if (i2 != 62) {
            if (i2 != 66) {
                if (i2 != 79) {
                    if (i2 == 82) {
                        Menu menu = this.U1;
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
                                if (L5 && !SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
                                    this.H1.removeCallbacksAndMessages((Object) null);
                                    int i3 = 7;
                                    if (i2 == 7) {
                                        this.O1.append(0);
                                    } else if (i2 == 8) {
                                        this.O1.append(1);
                                    } else {
                                        if (i2 == 9) {
                                            sb = this.O1;
                                            i3 = 2;
                                        } else if (i2 == 10) {
                                            this.O1.append(3);
                                        } else if (i2 == 11) {
                                            sb = this.O1;
                                            i3 = 4;
                                        } else if (i2 == 12) {
                                            sb = this.O1;
                                            i3 = 5;
                                        } else if (i2 == 13) {
                                            sb = this.O1;
                                            i3 = 6;
                                        } else if (i2 == 14) {
                                            sb = this.O1;
                                        } else if (i2 == 15) {
                                            this.O1.append(8);
                                        } else if (i2 == 16) {
                                            this.O1.append(9);
                                        }
                                        sb.append(i3);
                                    }
                                    this.Q1.setText(this.O1.toString());
                                    this.P1.setVisibility(0);
                                    this.H1.postDelayed(new n(), 3000L);
                                }
                                return true;
                            default:
                                switch (i2) {
                                    case 19:
                                        F4();
                                        n3(5000);
                                        this.m5.getVisibility();
                                        return true;
                                    case 20:
                                        F4();
                                        n3(5000);
                                        this.m5.getVisibility();
                                        return true;
                                    case 21:
                                        F4();
                                        n3(5000);
                                        if (this.m5.getVisibility() != 0 && L5 && this.S2.getVisibility() == 8 && this.Z2.getVisibility() == 8) {
                                            v4("player", true);
                                        }
                                        return true;
                                    case 22:
                                        F4();
                                        n3(5000);
                                        this.m5.getVisibility();
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
            if (L5 && this.m5.getVisibility() == 8) {
                I1 i1 = this.r4;
                if (i1 == null || i1.getPlaybackState() != 3) {
                    H4();
                } else if (this.X2.getVisibility() == 8) {
                    H4();
                    (this.r4.isPlaying() ? this.b3 : this.a3).requestFocus();
                }
            }
            return true;
        }
        if (this.h2.booleanValue()) {
            I1 i12 = this.r4;
            ((i12 == null || !z2 || i12.isPlaying()) ? this.b3 : this.a3).performClick();
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.V1 = menuItem;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.f) != null) {
            new a.a(context, a7.k.a).setTitle(this.f.getResources().getString(a7.j.f3)).f(this.f.getResources().getString(a7.j.e3)).j(this.f.getResources().getString(a7.j.S8), new y()).g(this.f.getResources().getString(a7.j.d4), new v()).n();
        }
        if (itemId == a7.f.g) {
            try {
                SearchView actionView = menuItem.getActionView();
                this.J0 = actionView;
                if (actionView != null) {
                    actionView.setQueryHint(getResources().getString(a7.j.A6));
                    this.J0.setIconifiedByDefault(false);
                    ImageView findViewById = this.J0.findViewById(a7.f.Uf);
                    this.J0.findViewById(a7.f.Vf).setImageResource(a7.e.m1);
                    findViewById.setImageResource(a7.e.m1);
                    findViewById.setPadding(15, 15, 15, 15);
                    findViewById.setBackground((Drawable) null);
                    this.J0.setOnQueryTextListener(new z());
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (itemId == a7.f.gb) {
            m7.w.A0(this.f);
        }
        if (itemId == a7.f.mb) {
            C4(this);
        }
        if (itemId == a7.f.Db) {
            w4();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        Handler handler;
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.l4;
            if (thread != null && thread.isAlive()) {
                this.l4.interrupt();
            }
        } catch (Exception unused) {
        }
        try {
            if (this.m4.booleanValue() || (handler = this.I1) == null) {
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
                W3();
            } else if (Build.VERSION.SDK_INT >= 23 && !r7.n.a(this, strArr[0])) {
                a.a aVar = new a.a(this, a7.k.a);
                View inflate = LayoutInflater.from(this).inflate(a7.g.W3, (ViewGroup) null);
                Button findViewById = inflate.findViewById(a7.f.c1);
                Button findViewById2 = inflate.findViewById(a7.f.U0);
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
                findViewById.setOnClickListener(new E());
                findViewById2.setOnClickListener(new F());
                aVar.setView(inflate);
                this.f2 = aVar.create();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.f2.getWindow();
                Objects.requireNonNull(window);
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                this.f2.show();
                this.f2.getWindow().setAttributes(layoutParams);
                this.f2.setCancelable(false);
                this.f2.show();
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.l4;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new I());
            this.l4 = thread2;
            thread2.start();
        }
        m7.w.m(this.f);
        if (this.u2) {
            this.u2 = false;
            E4();
        } else if (this.r4 == null) {
            U3();
        }
    }

    public void onStop() {
        super.onStop();
        try {
            o4();
        } catch (Exception unused) {
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super/*android.app.Activity*/.onWindowFocusChanged(z2);
        if (z2) {
            f3(getResources().getConfiguration());
        }
    }

    public String p3(String str) {
        ArrayList arrayList = this.m0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = this.m0.iterator();
            while (it.hasNext()) {
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) it.next();
                if (liveStreamCategoryIdDBModel.getLiveStreamCategoryID() != null && !liveStreamCategoryIdDBModel.getLiveStreamCategoryID().isEmpty() && liveStreamCategoryIdDBModel.getLiveStreamCategoryID().equalsIgnoreCase(str)) {
                    this.Z0 = liveStreamCategoryIdDBModel.getLiveStreamCategoryName();
                }
            }
        }
        return this.Z0;
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    public void q3(int i2, String str, String str2) {
    }

    public final void q4(String str, int i2, String str2, String str3, int i3) {
        new U(str, i2, str2, str3, i3).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public void r3() {
        this.C5 = new ArrayList();
        this.D5 = new JsonArray();
        if (this.M4.isChecked()) {
            this.C5.add(this.M4.getText().toString());
            this.D5.add(this.M4.getText().toString());
        }
        if (this.N4.isChecked()) {
            this.C5.add(this.N4.getText().toString());
            this.D5.add(this.N4.getText().toString());
        }
        if (this.O4.isChecked()) {
            this.C5.add(this.O4.getText().toString());
            this.D5.add(this.O4.getText().toString());
        }
        if (this.P4.isChecked()) {
            this.C5.add(this.P4.getText().toString());
            this.D5.add(this.P4.getText().toString());
        }
        if (this.Q4.isChecked()) {
            this.C5.add(this.Q4.getText().toString());
            this.D5.add(this.Q4.getText().toString());
        }
        if (this.I4.isChecked()) {
            this.C5.add(this.I4.getText().toString());
            this.D5.add(this.I4.getText().toString());
        }
        if (this.J4.isChecked()) {
            this.C5.add(this.J4.getText().toString());
            this.D5.add(this.J4.getText().toString());
        }
        if (this.K4.isChecked()) {
            this.C5.add(this.K4.getText().toString());
            this.D5.add(this.K4.getText().toString());
        }
        if (this.L4.isChecked()) {
            this.C5.add(this.L4.getText().toString());
            this.D5.add(this.L4.getText().toString());
        }
        if (this.S4.isChecked()) {
            this.C5.add(this.S4.getText().toString());
            this.D5.add(this.S4.getText().toString());
        }
        if (this.T4.isChecked()) {
            this.C5.add(this.T4.getText().toString());
            this.D5.add(this.T4.getText().toString());
        }
        if (this.U4.isChecked()) {
            this.C5.add(this.U4.getText().toString());
            this.D5.add(this.U4.getText().toString());
        }
        if (this.V4.isChecked()) {
            this.C5.add(this.V4.getText().toString());
            this.D5.add(this.V4.getText().toString());
        }
        this.E5 = new Gson().toJson(this.D5);
        Log.e("TAG", this.D5 + "");
    }

    public final void r4(String str, String str2, int i2) {
        new V(str, i2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public void s4() {
        this.p2 = new K().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public void t4(ArrayList arrayList) {
        TextView textView;
        try {
            if (arrayList == null) {
                this.K = new ArrayList();
                return;
            }
            this.B = false;
            this.K0.setVisibility(8);
            if (arrayList.size() == 0) {
                if (this.s2) {
                    TextView textView2 = this.K0;
                    if (textView2 == null) {
                        return;
                    }
                    this.B = true;
                    textView2.setFocusable(true);
                    this.K0.requestFocus();
                    textView = this.K0;
                } else {
                    this.s2 = true;
                    ArrayList arrayList2 = this.r0;
                    if (arrayList2 != null && this.p0 != null) {
                        arrayList2.clear();
                        this.p0.clear();
                    }
                    this.r0 = this.X3.equals("true") ? this.R.getAllLiveStreasWithCategoryId(this.Y0, "radio_streams") : this.R.getAllLiveStreasWithCategoryId(this.Y0, "live");
                    ArrayList arrayList3 = this.r0;
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        t4(this.r0);
                        return;
                    }
                    TextView textView3 = this.K0;
                    if (textView3 == null) {
                        return;
                    }
                    this.B = true;
                    textView3.setFocusable(true);
                    this.K0.requestFocus();
                    textView = this.K0;
                }
                textView.setVisibility(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
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
            this.b4 = cmd;
            String[] split = cmd.split("ffmpeg ", 0);
            if (split.length == 2) {
                this.c4 = split[1];
            }
            if (str6.equals("playFirstTime")) {
                m4(this.t0);
                if (this.P0 && this.Q0 && !this.R0.equals("")) {
                    this.t2 = 0;
                    try {
                        this.t2 = I3(this.t0, m7.w.r0(this.R0));
                    } catch (NumberFormatException | Exception unused) {
                    }
                    this.P0 = false;
                    this.Q0 = false;
                }
                u4(this.t0);
                return;
            }
            if (str6.equals("channel_click")) {
                i4(this.d4, this.L);
                return;
            }
            if (str6.equals("channel_click_from_player")) {
                j4(this.e4, this.M);
            } else if (str6.equals("zappingRight")) {
                L4(i4, str7, str8);
            } else if (str6.equals("zappingLeft")) {
                K4(i4, str7, str8);
            }
        } catch (Exception unused2) {
        }
    }

    public void u4(ArrayList arrayList) {
        ListView listView;
        try {
            if (this.V3.equals("player")) {
                this.M = arrayList;
                if (arrayList != null && arrayList.size() > 0) {
                    ListView listView2 = this.J;
                    if (listView2 != null) {
                        listView2.setVisibility(0);
                    }
                    this.B = false;
                    if (this.J != null) {
                        q7.P p2 = new q7.P(this, arrayList);
                        this.P3 = p2;
                        this.J.setAdapter(p2);
                        this.J.setSelection(this.S3);
                        this.J.requestFocus();
                        this.J.setOnItemClickListener(new H());
                        return;
                    }
                    return;
                }
                LinearLayout linearLayout = this.L0;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                LinearLayout linearLayout2 = this.M0;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                listView = this.J;
                if (listView == null) {
                    return;
                }
            } else {
                this.L = arrayList;
                if (arrayList != null && arrayList.size() > 0) {
                    ListView listView3 = this.I;
                    if (listView3 != null) {
                        listView3.setVisibility(0);
                    }
                    this.B = false;
                    if (this.I != null) {
                        q7.O o2 = new q7.O(this, arrayList);
                        this.O3 = o2;
                        this.I.setAdapter(o2);
                        this.I.setSelection(this.S3);
                        if (!L5) {
                            this.I.requestFocus();
                        }
                        this.I.setOnItemSelectedListener(new a());
                        this.I.setOnItemClickListener(new b(arrayList));
                        this.I.setOnItemLongClickListener(new c());
                        return;
                    }
                    return;
                }
                LinearLayout linearLayout3 = this.L0;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                LinearLayout linearLayout4 = this.M0;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                listView = this.I;
                if (listView == null) {
                    return;
                }
            }
            listView.setVisibility(8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void v0(String str) {
        try {
            StalkerLiveFavIdsSingleton.getInstance().setFavIdsList((List) null);
            this.g4.i(this.o4, this.p4);
        } catch (Exception unused) {
        }
    }

    public final void v3() {
        try {
            SearchView searchView = this.J0;
            if (searchView == null || this.V1 == null) {
                return;
            }
            searchView.d0("", false);
            this.V1.collapseActionView();
        } catch (Exception unused) {
        }
    }

    public final void v4(String str, boolean z2) {
        String str2;
        String str3;
        RecyclerView recyclerView;
        LinearLayoutManager linearLayoutManager;
        if (z2 && this.S2.getVisibility() == 0) {
            this.S2.startAnimation(this.I3);
            this.S2.setVisibility(8);
        }
        this.V3 = str;
        if (str.equals("player")) {
            this.Z2.startAnimation(this.T3);
            this.Z2.setVisibility(0);
        }
        String str4 = this.Y3;
        if ((str4 != null && str4.equals("-1")) || (((str2 = this.Y3) != null && str2.equals("0")) || ((str3 = this.Y3) != null && str3.equals("-6")))) {
            String str5 = this.Y3;
            this.K2 = str5;
            this.L2 = str5;
        }
        if (this.V3.equals("player")) {
            q7.N n2 = new q7.N(this.f, this.K2, this.V3, this.X3, this.W3);
            this.N3 = n2;
            this.L2 = this.K2;
            this.v3.setAdapter(n2);
            recyclerView = this.v3;
            linearLayoutManager = this.R3;
        } else {
            q7.N n3 = new q7.N(this.f, this.K2, this.V3, this.X3, this.W3);
            this.M3 = n3;
            this.L2 = this.K2;
            this.u3.setAdapter(n3);
            recyclerView = this.u3;
            linearLayoutManager = this.Q3;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        j3(z2);
    }

    public void y0(String str) {
    }

    public void y3() {
        new Handler(Looper.getMainLooper()).post(new G());
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
    public void z3(java.util.HashMap r12) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.z3(java.util.HashMap):void");
    }

    public void z4() {
        View view;
        if (this.X2.getVisibility() == 8 && this.S2.getVisibility() == 8) {
            this.G1.removeCallbacksAndMessages((Object) null);
            I4(this.G);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.f).equals("stalker_api")) {
                J4(String.valueOf(this.v1));
            } else {
                this.q2 = new R(this, this.F, null).execute(new String[0]);
            }
            this.F1.removeCallbacksAndMessages((Object) null);
            this.S2.startAnimation(this.H3);
            this.s3.startAnimation(this.H3);
            this.q3.startAnimation(this.H3);
            Boolean bool = m7.a.V0;
            if (bool.booleanValue()) {
                this.j5.startAnimation(this.H3);
            }
            this.r3.startAnimation(this.H3);
            this.s3.setVisibility(0);
            this.q3.setVisibility(0);
            if (bool.booleanValue()) {
                this.j5.setVisibility(0);
            } else {
                this.j5.setVisibility(4);
            }
            this.r3.setVisibility(0);
            this.S2.setVisibility(0);
            try {
                View view2 = this.i;
                if (view2 == null || view2.getVisibility() != 0) {
                    View view3 = this.h;
                    if (view3 == null || view3.getVisibility() != 0) {
                        return;
                    } else {
                        view = this.h;
                    }
                } else {
                    view = this.i;
                }
                view.requestFocus();
            } catch (Exception unused) {
            }
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
