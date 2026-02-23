package com.nst.iptvsmarterstvbox.view.ijkplayer.activities;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.PendingIntent;
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
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Rational;
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
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.activities.FreeTrailActivity;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
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
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerSky;
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
import q7.N;
import q7.O;
import q7.T;
import q7.Z;
import q7.m0;
import q7.t;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerSkyActivity extends androidx.appcompat.app.b implements SurfaceHolder.Callback, View.OnClickListener, z7.j, z7.g, CompoundButton.OnCheckedChangeListener {
    public static SharedPreferences W5 = null;
    public static SharedPreferences X5 = null;
    public static boolean Y5 = false;
    public static String Z5;
    public static String a6;
    public static final int[] b6 = {0, 1, 2, 3, 4, 5};
    public static boolean c6 = false;
    public static ProgressBar d6;
    public ArrayList A0;
    public String A1;
    public int A2;
    public LinearLayout A3;
    public int A4;
    public LinearLayout A5;
    public ArrayList B0;
    public int B1;
    public boolean B2;
    public LinearLayout B3;
    public List B4;
    public LinearLayout B5;
    public ArrayList C0;
    public int C2;
    public ImageView C3;
    public n7.e C4;
    public LinearLayout C5;
    public int D;
    public int D2;
    public ImageView D3;
    public int D4;
    public LinearLayout D5;
    public ArrayList E0;
    public DatabaseHandler E1;
    public SharedPreferences E2;
    public ImageView E3;
    public PictureInPictureParams.Builder E4;
    public LinearLayout E5;
    public String F;
    public ArrayList F0;
    public SharedPreferences.Editor F1;
    public Boolean F2;
    public ImageView F3;
    public BroadcastReceiver F4;
    public RelativeLayout F5;
    public String G;
    public SharedPreferences G0;
    public SharedPreferences.Editor G1;
    public Boolean G2;
    public ImageView G3;
    public String G4;
    public String G5;
    public String H;
    public SharedPreferences.Editor H0;
    public TextView H1;
    public Boolean H2;
    public LinearLayout H3;
    public String H4;
    public String H5;
    public RelativeLayout I;
    public ArrayList I0;
    public String I1;
    public Boolean I2;
    public LinearLayout I3;
    public String I4;
    public String I5;
    public ListView J;
    public ArrayList J0;
    public TextView J1;
    public Boolean J2;
    public LinearLayout J3;
    public boolean J4;
    public String J5;
    public ListView K;
    public RecyclerView K0;
    public Handler K1;
    public Boolean K2;
    public TextView K3;
    public String K4;
    public String K5;
    public ProgressBar L0;
    public Handler L1;
    public u7.a L2;
    public TextView L3;
    public String L4;
    public String L5;
    public ArrayList M;
    public Toolbar M0;
    public Handler M1;
    public Handler M2;
    public TextView M3;
    public SharedPreferences M4;
    public String M5;
    public ArrayList N;
    public SearchView N0;
    public Handler N1;
    public o4.y N2;
    public TextView N3;
    public boolean N4;
    public String N5;
    public TextView O0;
    public Handler O1;
    public o4.e O2;
    public RecyclerView O3;
    public MultiUserDBHandler O4;
    public String O5;
    public LinearLayout P0;
    public SharedPreferences.Editor P1;
    public o4.b P2;
    public LinearLayout P3;
    public String P4;
    public List P5;
    public String Q;
    public AppBarLayout Q0;
    public SharedPreferences.Editor Q1;
    public o4.f Q2;
    public LinearLayout Q3;
    public Thread Q4;
    public JsonArray Q5;
    public SharedPreferences.Editor R1;
    public Handler R2;
    public LinearLayout R3;
    public RelativeLayout R4;
    public String R5;
    public LiveStreamDBHandler S;
    public TextView S1;
    public ArrayList S2;
    public LinearLayout S3;
    public RelativeLayout S4;
    public Thread S5;
    public SharedPreferences T;
    public ImageView T2;
    public TextView T3;
    public RelativeLayout T4;
    public BroadcastReceiver T5;
    public T U;
    public String U0;
    public int U2;
    public TextView U3;
    public TextView U4;
    public final ArrayList U5;
    public SharedPreferences V;
    public LinearLayout V1;
    public String V2;
    public TextView V3;
    public CheckBox V4;
    public NSTIJKPlayerSky.w V5;
    public SharedPreferences W;
    public RelativeLayout W0;
    public TextView W1;
    public String W2;
    public MediaRouteButton W3;
    public CheckBox W4;
    public SharedPreferences X;
    public RelativeLayout X0;
    public Boolean X2;
    public ImageView X3;
    public CheckBox X4;
    public SharedPreferences Y;
    public LinearLayout Y0;
    public Boolean Y1;
    public RadioGroup Y2;
    public ImageView Y3;
    public CheckBox Y4;
    public SharedPreferences Z;
    public LinearLayout Z0;
    public Boolean Z1;
    public RadioGroup Z2;
    public LinearLayout Z3;
    public CheckBox Z4;
    public RelativeLayout a1;
    public Menu a2;
    public RadioGroup a3;
    public LinearLayout a4;
    public CheckBox a5;
    public RelativeLayout b1;
    public MenuItem b2;
    public TextView b3;
    public LinearLayout b4;
    public CheckBox b5;
    public RelativeLayout c1;
    public DateFormat c2;
    public TextView c3;
    public Animation c4;
    public CheckBox c5;
    public Context d;
    public RelativeLayout d1;
    public String d2;
    public TextView d3;
    public Animation d4;
    public CheckBox d5;
    public String e;
    public SharedPreferences e0;
    public String e2;
    public TextView e3;
    public Animation e4;
    public RelativeLayout e5;
    public View f;
    public SharedPreferences f0;
    public String f2;
    public TextView f3;
    public Animation f4;
    public CheckBox f5;
    public View g;
    public SharedPreferences g0;
    public TextView g1;
    public SimpleDateFormat g2;
    public TextView g3;
    public Animation g4;
    public CheckBox g5;
    public ImageView h;
    public SimpleDateFormat h0;
    public TextView h1;
    public NSTIJKPlayerSky h2;
    public FrameLayout h3;
    public Animation h4;
    public CheckBox h5;
    public ImageView i;
    public String i0;
    public TextView i1;
    public Date i2;
    public SeekBar i3;
    public Animation i4;
    public CheckBox i5;
    public View j;
    public RelativeLayout j0;
    public TextView j1;
    public String j2;
    public SeekBar j3;
    public Animation j4;
    public TextView j5;
    public String k;
    public String k1;
    public Boolean k2;
    public LinearLayout k3;
    public Animation k4;
    public LinearLayout k5;
    public View l;
    public TextView l0;
    public TextView l1;
    public androidx.appcompat.app.a l2;
    public LinearLayout l3;
    public String l4;
    public TextView l5;
    public View m;
    public AppCompatImageView m0;
    public TextView m1;
    public String m2;
    public LinearLayout m3;
    public N m4;
    public TextView m5;
    public AppCompatImageView n0;
    public TextView n1;
    public Boolean n2;
    public LinearLayout n3;
    public O n4;
    public TextView n5;
    public LinearLayout o;
    public ArrayList o0;
    public TextView o1;
    public D7.b o2;
    public LinearLayout o3;
    public LinearLayoutManager o4;
    public TextView o5;
    public TextView p;
    public ArrayList p0;
    public TextView p1;
    public String p2;
    public RelativeLayout p3;
    public String p4;
    public TextView p5;
    public ImageView q;
    public ArrayList q0;
    public TextView q1;
    public int q2;
    public RelativeLayout q3;
    public String q4;
    public TextView q5;
    public TextView r;
    public ArrayList r0;
    public TextView r1;
    public String r2;
    public ImageView r3;
    public int r4;
    public TextView r5;
    public TextView s;
    public ArrayList s0;
    public TextView s1;
    public int s2;
    public ImageView s3;
    public Animation s4;
    public TextView s5;
    public TextView t;
    public ArrayList t0;
    public LinearLayout t1;
    public String t2;
    public ImageView t3;
    public Animation t4;
    public EditText t5;
    public TextView u;
    public ArrayList u0;
    public String u1;
    public String u2;
    public ImageView u3;
    public boolean u4;
    public LinearLayout u5;
    public LinearLayout v;
    public ArrayList v0;
    public LinearLayout v1;
    public Boolean v2;
    public ImageView v3;
    public boolean v4;
    public LinearLayout v5;
    public ProgressBar w;
    public ArrayList w0;
    public LinearLayout w1;
    public AsyncTask w2;
    public ImageView w3;
    public n7.g w4;
    public LinearLayout w5;
    public ProgressBar x;
    public ArrayList x0;
    public LinearLayout x1;
    public AsyncTask x2;
    public LinearLayout x3;
    public String x4;
    public LinearLayout x5;
    public LinearLayout y;
    public ArrayList y0;
    public LinearLayout y1;
    public AsyncTask y2;
    public LinearLayout y3;
    public String y4;
    public ImageView y5;
    public ArrayList z0;
    public LinearLayout z1;
    public boolean z2;
    public LinearLayout z3;
    public int z4;
    public RelativeLayout z5;
    public boolean n = false;
    public boolean z = true;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public String E = "";
    public ArrayList L = new ArrayList();
    public boolean O = true;
    public long P = 2500;
    public boolean R = true;
    public int k0 = 0;
    public ArrayList D0 = new ArrayList();
    public boolean R0 = true;
    public boolean S0 = false;
    public boolean T0 = false;
    public boolean V0 = true;
    public String e1 = "";
    public String f1 = "";
    public String C1 = "";
    public String D1 = "";
    public int T1 = 0;
    public StringBuilder U1 = new StringBuilder();
    public int X1 = -1;

    public class A implements View.OnClickListener {
        public A() {
        }

        public void onClick(View view) {
            NSTIJKPlayerSkyActivity.this.onBackPressed();
        }
    }

    public class B implements Runnable {
        public B() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    NSTIJKPlayerSkyActivity.this.c3();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class C extends AsyncTask {
        public C() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return Boolean.valueOf(NSTIJKPlayerSkyActivity.S1(NSTIJKPlayerSkyActivity.this));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (NSTIJKPlayerSkyActivity.x1(NSTIJKPlayerSkyActivity.this) != null) {
                NSTIJKPlayerSkyActivity.x1(NSTIJKPlayerSkyActivity.this).setEPGHandler(NSTIJKPlayerSkyActivity.this.N1);
                NSTIJKPlayerSkyActivity.x1(NSTIJKPlayerSkyActivity.this).setContext(NSTIJKPlayerSkyActivity.this.d);
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public class D implements Runnable {
        public D() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (SharepreferenceDBHandler.getMaintanceModeState(NSTIJKPlayerSkyActivity.this.d)) {
                        NSTIJKPlayerSkyActivity.this.d.startActivity(new Intent(NSTIJKPlayerSkyActivity.this.d, MaintanencePannelActivity.class));
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

    public class E extends AsyncTask {
        public E() {
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0035  */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r0 = 0
                r6 = r6[r0]     // Catch: java.lang.Exception -> L5c
                int r1 = r6.hashCode()     // Catch: java.lang.Exception -> L5c
                r2 = 2
                r3 = 1
                r4 = 3
                switch(r1) {
                    case -74797390: goto L2b;
                    case 47612238: goto L21;
                    case 301138327: goto L17;
                    case 613425326: goto Le;
                    default: goto Ld;
                }     // Catch: java.lang.Exception -> L5c
            Ld:
                goto L35
            Le:
                java.lang.String r1 = "all_channels"
                boolean r6 = r6.equals(r1)     // Catch: java.lang.Exception -> L5c
                if (r6 == 0) goto L35
                goto L36
            L17:
                java.lang.String r0 = "recently_watched"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L5c
                if (r6 == 0) goto L35
                r0 = 3
                goto L36
            L21:
                java.lang.String r0 = "all_channels_with_cat"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L5c
                if (r6 == 0) goto L35
                r0 = 1
                goto L36
            L2b:
                java.lang.String r0 = "get_fav"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L5c
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
                com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity r6 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.this     // Catch: java.lang.Exception -> L5c
                java.lang.String r6 = r6.S2()     // Catch: java.lang.Exception -> L5c
                return r6
            L47:
                com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity r6 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.this     // Catch: java.lang.Exception -> L5c
                java.lang.String r6 = r6.j3()     // Catch: java.lang.Exception -> L5c
                return r6
            L4e:
                com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity r6 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.this     // Catch: java.lang.Exception -> L5c
                java.lang.String r6 = r6.N2()     // Catch: java.lang.Exception -> L5c
                return r6
            L55:
                com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity r6 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.this     // Catch: java.lang.Exception -> L5c
                java.lang.String r6 = r6.L2()     // Catch: java.lang.Exception -> L5c
                return r6
            L5c:
                java.lang.String r6 = "error"
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.E.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (NSTIJKPlayerSkyActivity.B1(NSTIJKPlayerSkyActivity.this) != null) {
                    if (!NSTIJKPlayerSkyActivity.C1(NSTIJKPlayerSkyActivity.this).booleanValue()) {
                        NSTIJKPlayerSkyActivity.D1(NSTIJKPlayerSkyActivity.this, Boolean.TRUE);
                        if (NSTIJKPlayerSkyActivity.B1(NSTIJKPlayerSkyActivity.this).size() != 0) {
                            if (NSTIJKPlayerSkyActivity.E1(NSTIJKPlayerSkyActivity.this) != null) {
                                NSTIJKPlayerSkyActivity.E1(NSTIJKPlayerSkyActivity.this).clear();
                                NSTIJKPlayerSkyActivity.E1(NSTIJKPlayerSkyActivity.this).addAll(NSTIJKPlayerSkyActivity.B1(NSTIJKPlayerSkyActivity.this));
                            }
                            if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyActivity.this.d).equals("stalker_api")) {
                                try {
                                    m7.w.N0(NSTIJKPlayerSkyActivity.this.d);
                                    String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTIJKPlayerSkyActivity.this.d);
                                    String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(NSTIJKPlayerSkyActivity.this.d);
                                    if (NSTIJKPlayerSkyActivity.B1(NSTIJKPlayerSkyActivity.this) != null && NSTIJKPlayerSkyActivity.B1(NSTIJKPlayerSkyActivity.this).size() > 0 && NSTIJKPlayerSkyActivity.F1(NSTIJKPlayerSkyActivity.this) < NSTIJKPlayerSkyActivity.B1(NSTIJKPlayerSkyActivity.this).size()) {
                                        NSTIJKPlayerSkyActivity.G1(NSTIJKPlayerSkyActivity.this).c(loggedInMacAddress, stalkerToken, ((LiveStreamsDBModel) NSTIJKPlayerSkyActivity.B1(NSTIJKPlayerSkyActivity.this).get(NSTIJKPlayerSkyActivity.F1(NSTIJKPlayerSkyActivity.this))).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "playFirstTime", 0, "", "");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                                NSTIJKPlayerSkyActivity.H1(nSTIJKPlayerSkyActivity, NSTIJKPlayerSkyActivity.B1(nSTIJKPlayerSkyActivity));
                            }
                        } else {
                            m7.a.Y = Boolean.FALSE;
                            NSTIJKPlayerSkyActivity.this.I3();
                            NSTIJKPlayerSkyActivity.x1(NSTIJKPlayerSkyActivity.this).setVisibility(8);
                            NSTIJKPlayerSkyActivity.this.o.setVisibility(0);
                            NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity2 = NSTIJKPlayerSkyActivity.this;
                            nSTIJKPlayerSkyActivity2.p.setText(nSTIJKPlayerSkyActivity2.getResources().getString(a7.j.g4));
                        }
                    }
                    NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity3 = NSTIJKPlayerSkyActivity.this;
                    if (nSTIJKPlayerSkyActivity3.S0 && nSTIJKPlayerSkyActivity3.T0 && !nSTIJKPlayerSkyActivity3.U0.equals("")) {
                        NSTIJKPlayerSkyActivity.I1(NSTIJKPlayerSkyActivity.this, 0);
                        try {
                            NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity4 = NSTIJKPlayerSkyActivity.this;
                            NSTIJKPlayerSkyActivity.I1(nSTIJKPlayerSkyActivity4, nSTIJKPlayerSkyActivity4.m3(NSTIJKPlayerSkyActivity.B1(nSTIJKPlayerSkyActivity4), m7.w.r0(NSTIJKPlayerSkyActivity.this.U0)));
                        } catch (NumberFormatException | Exception e2) {
                            e2.printStackTrace();
                        }
                        NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity5 = NSTIJKPlayerSkyActivity.this;
                        nSTIJKPlayerSkyActivity5.S0 = false;
                        nSTIJKPlayerSkyActivity5.T0 = false;
                    }
                    NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity6 = NSTIJKPlayerSkyActivity.this;
                    nSTIJKPlayerSkyActivity6.S3(NSTIJKPlayerSkyActivity.B1(nSTIJKPlayerSkyActivity6));
                }
                NSTIJKPlayerSkyActivity.K1(NSTIJKPlayerSkyActivity.this);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        public void onPreExecute() {
            TextView textView;
            String string;
            TextView textView2;
            super.onPreExecute();
            try {
                NSTIJKPlayerSkyActivity.A1(NSTIJKPlayerSkyActivity.this);
                TextView textView3 = NSTIJKPlayerSkyActivity.this.O0;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                if (nSTIJKPlayerSkyActivity.l0 != null) {
                    if (!nSTIJKPlayerSkyActivity.e1.equals("") && NSTIJKPlayerSkyActivity.this.e1.equals("0")) {
                        NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity2 = NSTIJKPlayerSkyActivity.this;
                        nSTIJKPlayerSkyActivity2.l0.setText(nSTIJKPlayerSkyActivity2.d.getResources().getString(a7.j.x));
                        textView2 = NSTIJKPlayerSkyActivity.this.l0;
                    } else if (!NSTIJKPlayerSkyActivity.this.e1.equals("") && NSTIJKPlayerSkyActivity.this.e1.equals("-1")) {
                        NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity3 = NSTIJKPlayerSkyActivity.this;
                        nSTIJKPlayerSkyActivity3.l0.setText(nSTIJKPlayerSkyActivity3.d.getResources().getString(a7.j.b2));
                        textView2 = NSTIJKPlayerSkyActivity.this.l0;
                    } else if (NSTIJKPlayerSkyActivity.this.e1.equals("") || !NSTIJKPlayerSkyActivity.this.e1.equals("-6")) {
                        if (NSTIJKPlayerSkyActivity.this.f1.equals("")) {
                            NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity4 = NSTIJKPlayerSkyActivity.this;
                            textView = nSTIJKPlayerSkyActivity4.l0;
                            string = nSTIJKPlayerSkyActivity4.getResources().getString(a7.j.b8);
                        } else {
                            NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity5 = NSTIJKPlayerSkyActivity.this;
                            textView = nSTIJKPlayerSkyActivity5.l0;
                            string = nSTIJKPlayerSkyActivity5.f1;
                        }
                        textView.setText(string);
                        textView2 = NSTIJKPlayerSkyActivity.this.l0;
                    } else {
                        NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity6 = NSTIJKPlayerSkyActivity.this;
                        nSTIJKPlayerSkyActivity6.l0.setText(nSTIJKPlayerSkyActivity6.d.getResources().getString(a7.j.U5));
                        textView2 = NSTIJKPlayerSkyActivity.this.l0;
                    }
                    textView2.setSelected(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class F extends AsyncTask {
        public F() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            try {
                return NSTIJKPlayerSkyActivity.O1(NSTIJKPlayerSkyActivity.this).equals("-1") ? NSTIJKPlayerSkyActivity.this.k3() : NSTIJKPlayerSkyActivity.O1(NSTIJKPlayerSkyActivity.this).equals("-6") ? NSTIJKPlayerSkyActivity.this.S2() : NSTIJKPlayerSkyActivity.this.P2();
            } catch (Exception unused) {
                return "error";
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (NSTIJKPlayerSkyActivity.P1(NSTIJKPlayerSkyActivity.this) != null) {
                    NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                    nSTIJKPlayerSkyActivity.T3(NSTIJKPlayerSkyActivity.P1(nSTIJKPlayerSkyActivity));
                }
                NSTIJKPlayerSkyActivity.Q1(NSTIJKPlayerSkyActivity.this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            NSTIJKPlayerSkyActivity.M1(NSTIJKPlayerSkyActivity.this);
            LinearLayout linearLayout = NSTIJKPlayerSkyActivity.this.P0;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            if (NSTIJKPlayerSkyActivity.N1(NSTIJKPlayerSkyActivity.this) != null) {
                NSTIJKPlayerSkyActivity.N1(NSTIJKPlayerSkyActivity.this).setVisibility(8);
            }
        }
    }

    public class G implements View.OnFocusChangeListener {
        public final View a;

        public G(View view) {
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

        /* JADX WARN: Removed duplicated region for block: B:84:0x01b1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFocusChange(android.view.View r29, boolean r30) {
            /*
                Method dump skipped, instructions count: 1912
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.G.onFocusChange(android.view.View, boolean):void");
        }
    }

    public class H extends AsyncTask {
        public String a;

        public H(String str) {
            this.a = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HashMap doInBackground(String... strArr) {
            try {
                return NSTIJKPlayerSkyActivity.R1(NSTIJKPlayerSkyActivity.this, this.a);
            } catch (Exception unused) {
                return new HashMap();
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(HashMap hashMap) {
            super.onPostExecute(hashMap);
            NSTIJKPlayerSkyActivity.this.d3(hashMap);
        }

        public void onPreExecute() {
            super.onPreExecute();
            NSTIJKPlayerSkyActivity.this.e3();
        }

        public /* synthetic */ H(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, String str, k kVar) {
            this(str);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            try {
                NSTIJKPlayerSkyActivity.this.k2 = Boolean.TRUE;
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", NSTIJKPlayerSkyActivity.this.getPackageName(), (String) null));
                NSTIJKPlayerSkyActivity.this.startActivityForResult(intent, 101);
                NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                Toast.makeText(nSTIJKPlayerSkyActivity, nSTIJKPlayerSkyActivity.d.getResources().getString(a7.j.o2), 1).show();
            } catch (Exception unused) {
            }
            NSTIJKPlayerSkyActivity.z1(NSTIJKPlayerSkyActivity.this).dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            NSTIJKPlayerSkyActivity.z1(NSTIJKPlayerSkyActivity.this).dismiss();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = m7.w.R(NSTIJKPlayerSkyActivity.this.d);
                String A = m7.w.A(date);
                TextView textView = NSTIJKPlayerSkyActivity.this.J1;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = NSTIJKPlayerSkyActivity.this.H1;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String cmd;
            n7.g G1;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            NSTIJKPlayerSkyActivity.U1(NSTIJKPlayerSkyActivity.this, i);
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyActivity.this.d).equals("stalker_api")) {
                NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                NSTIJKPlayerSkyActivity.Y1(nSTIJKPlayerSkyActivity, NSTIJKPlayerSkyActivity.T1(nSTIJKPlayerSkyActivity), NSTIJKPlayerSkyActivity.this.N);
                return;
            }
            try {
                String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTIJKPlayerSkyActivity.this.d);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(NSTIJKPlayerSkyActivity.this.d);
                ArrayList g = NSTIJKPlayerSkyActivity.W1(NSTIJKPlayerSkyActivity.this).g();
                if (g != null && g.size() > 0) {
                    cmd = ((LiveStreamsDBModel) g.get(NSTIJKPlayerSkyActivity.T1(NSTIJKPlayerSkyActivity.this))).getCmd();
                    NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity2 = NSTIJKPlayerSkyActivity.this;
                    if (nSTIJKPlayerSkyActivity2.B1 == m7.w.q0(((LiveStreamsDBModel) g.get(NSTIJKPlayerSkyActivity.T1(nSTIJKPlayerSkyActivity2))).getStreamId())) {
                        NSTIJKPlayerSkyActivity.this.g3(true);
                        NSTIJKPlayerSkyActivity.this.onBackPressed();
                        return;
                    }
                    m7.w.N0(NSTIJKPlayerSkyActivity.this.d);
                    G1 = NSTIJKPlayerSkyActivity.G1(NSTIJKPlayerSkyActivity.this);
                    str = "";
                    str2 = "itv";
                    str3 = "";
                    str4 = "";
                    str5 = "";
                    str6 = "";
                    str7 = "";
                    str8 = "channel_click_from_player";
                    str9 = "";
                    G1.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, "");
                }
                if (NSTIJKPlayerSkyActivity.P1(NSTIJKPlayerSkyActivity.this) == null || NSTIJKPlayerSkyActivity.P1(NSTIJKPlayerSkyActivity.this).size() <= 0) {
                    return;
                }
                cmd = ((LiveStreamsDBModel) NSTIJKPlayerSkyActivity.P1(NSTIJKPlayerSkyActivity.this).get(NSTIJKPlayerSkyActivity.T1(NSTIJKPlayerSkyActivity.this))).getCmd();
                NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity3 = NSTIJKPlayerSkyActivity.this;
                if (nSTIJKPlayerSkyActivity3.B1 == m7.w.q0(((LiveStreamsDBModel) NSTIJKPlayerSkyActivity.P1(nSTIJKPlayerSkyActivity3).get(NSTIJKPlayerSkyActivity.T1(NSTIJKPlayerSkyActivity.this))).getStreamId())) {
                    NSTIJKPlayerSkyActivity.this.g3(true);
                    NSTIJKPlayerSkyActivity.this.onBackPressed();
                    return;
                }
                m7.w.N0(NSTIJKPlayerSkyActivity.this.d);
                G1 = NSTIJKPlayerSkyActivity.G1(NSTIJKPlayerSkyActivity.this);
                str = "";
                str2 = "itv";
                str3 = "";
                str4 = "";
                str5 = "";
                str6 = "";
                str7 = "";
                str8 = "channel_click_from_player";
                str9 = "";
                G1.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, "");
            } catch (Exception unused) {
            }
        }
    }

    public class e implements AdapterView.OnItemSelectedListener {
        public e() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            if (NSTIJKPlayerSkyActivity.Z1(NSTIJKPlayerSkyActivity.this) != null && NSTIJKPlayerSkyActivity.Z1(NSTIJKPlayerSkyActivity.this).getStatus().equals(AsyncTask.Status.RUNNING)) {
                NSTIJKPlayerSkyActivity.Z1(NSTIJKPlayerSkyActivity.this).cancel(true);
            }
            ArrayList e = NSTIJKPlayerSkyActivity.F2(NSTIJKPlayerSkyActivity.this).e();
            if (e != null && e.size() > 0) {
                String epgChannelId = ((LiveStreamsDBModel) e.get(i)).getEpgChannelId();
                NSTIJKPlayerSkyActivity.this.M1.removeCallbacksAndMessages((Object) null);
                if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyActivity.this.d).equals("stalker_api")) {
                    NSTIJKPlayerSkyActivity.this.k4(((LiveStreamsDBModel) e.get(i)).getStreamId());
                    return;
                } else {
                    NSTIJKPlayerSkyActivity.a2(NSTIJKPlayerSkyActivity.this, new H(NSTIJKPlayerSkyActivity.this, epgChannelId, null).execute(new String[0]));
                    return;
                }
            }
            if (NSTIJKPlayerSkyActivity.b2(NSTIJKPlayerSkyActivity.this) == null || NSTIJKPlayerSkyActivity.b2(NSTIJKPlayerSkyActivity.this).size() <= 0) {
                return;
            }
            String epgChannelId2 = ((LiveStreamsDBModel) NSTIJKPlayerSkyActivity.b2(NSTIJKPlayerSkyActivity.this).get(i)).getEpgChannelId();
            NSTIJKPlayerSkyActivity.this.M1.removeCallbacksAndMessages((Object) null);
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyActivity.this.d).equals("stalker_api")) {
                NSTIJKPlayerSkyActivity.a2(NSTIJKPlayerSkyActivity.this, new H(NSTIJKPlayerSkyActivity.this, epgChannelId2, null).execute(new String[0]));
            } else {
                NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                nSTIJKPlayerSkyActivity.k4(((LiveStreamsDBModel) NSTIJKPlayerSkyActivity.b2(nSTIJKPlayerSkyActivity).get(i)).getStreamId());
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class f implements AdapterView.OnItemClickListener {
        public f() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String cmd;
            NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity;
            n7.g G1;
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
            NSTIJKPlayerSkyActivity.e2(NSTIJKPlayerSkyActivity.this, i);
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyActivity.this.d).equals("stalker_api")) {
                NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity2 = NSTIJKPlayerSkyActivity.this;
                NSTIJKPlayerSkyActivity.f2(nSTIJKPlayerSkyActivity2, NSTIJKPlayerSkyActivity.d2(nSTIJKPlayerSkyActivity2), NSTIJKPlayerSkyActivity.this.M);
                return;
            }
            try {
                String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTIJKPlayerSkyActivity.this.d);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(NSTIJKPlayerSkyActivity.this.d);
                ArrayList e = NSTIJKPlayerSkyActivity.F2(NSTIJKPlayerSkyActivity.this).e();
                if (e != null && e.size() > 0) {
                    cmd = ((LiveStreamsDBModel) e.get(NSTIJKPlayerSkyActivity.d2(NSTIJKPlayerSkyActivity.this))).getCmd();
                    NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity3 = NSTIJKPlayerSkyActivity.this;
                    if (nSTIJKPlayerSkyActivity3.B1 == m7.w.q0(((LiveStreamsDBModel) e.get(NSTIJKPlayerSkyActivity.d2(nSTIJKPlayerSkyActivity3))).getStreamId())) {
                        nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                        nSTIJKPlayerSkyActivity.g3(true);
                        return;
                    }
                    m7.w.N0(NSTIJKPlayerSkyActivity.this.d);
                    G1 = NSTIJKPlayerSkyActivity.G1(NSTIJKPlayerSkyActivity.this);
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
                    G1.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, str10);
                }
                if (NSTIJKPlayerSkyActivity.b2(NSTIJKPlayerSkyActivity.this) == null || NSTIJKPlayerSkyActivity.b2(NSTIJKPlayerSkyActivity.this).size() <= 0) {
                    return;
                }
                cmd = ((LiveStreamsDBModel) NSTIJKPlayerSkyActivity.b2(NSTIJKPlayerSkyActivity.this).get(NSTIJKPlayerSkyActivity.d2(NSTIJKPlayerSkyActivity.this))).getCmd();
                NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity4 = NSTIJKPlayerSkyActivity.this;
                if (nSTIJKPlayerSkyActivity4.B1 == m7.w.q0(((LiveStreamsDBModel) NSTIJKPlayerSkyActivity.b2(nSTIJKPlayerSkyActivity4).get(NSTIJKPlayerSkyActivity.d2(NSTIJKPlayerSkyActivity.this))).getStreamId())) {
                    nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                    nSTIJKPlayerSkyActivity.g3(true);
                    return;
                }
                m7.w.N0(NSTIJKPlayerSkyActivity.this.d);
                G1 = NSTIJKPlayerSkyActivity.G1(NSTIJKPlayerSkyActivity.this);
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
                G1.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, str10);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class g implements AdapterView.OnItemLongClickListener {

        public class a implements PopupMenu.OnMenuItemClickListener {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;

            public a(String str, String str2, String str3, String str4, String str5) {
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
                this.e = str5;
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
            
                r5 = r12.f.a;
                r5.B2 = true;
                r5.O3();
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
            
                if (com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.g2(r12.f.a).equals("m3u") == false) goto L20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
            
                r5 = r12.f.a;
                r6 = r5.F;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
            
                r5.Q = r6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
            
                if (com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.g2(r12.f.a).equals("onestream_api") == false) goto L70;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x012b, code lost:
            
                r5 = r12.f.a;
                r6 = m7.w.V(r5.d, r5.D, r5.i0, "live");
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
            
                r6 = new org.json.JSONObject(r12.f.a.F);
                r5 = r12.f.a.i0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
            
                r7 = "m3u8";
                r8 = "ts";
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
            
                if (r5 == null) goto L46;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
            
                if (r5.isEmpty() != false) goto L46;
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0094, code lost:
            
                if (r12.f.a.i0.equals(".ts") == false) goto L46;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
            
                r5 = r6.keys();
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
            
                if (r5.hasNext() == false) goto L125;
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
            
                if (((java.lang.String) r5.next()).equals("ts") == false) goto L126;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00ac, code lost:
            
                r9 = "ts";
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00b6, code lost:
            
                if (r9.equals("") == false) goto L44;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00bc, code lost:
            
                if (r5.hasNext() == false) goto L128;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x00c8, code lost:
            
                if (((java.lang.String) r5.next()).equals("m3u8") == false) goto L129;
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00ca, code lost:
            
                r9 = "m3u8";
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x00cb, code lost:
            
                r5 = r6.getString(r9);
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x00d2, code lost:
            
                r10 = r12.f.a.i0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x00d8, code lost:
            
                if (r10 == null) goto L69;
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x00de, code lost:
            
                if (r10.isEmpty() != false) goto L69;
             */
            /* JADX WARN: Code restructure failed: missing block: B:58:0x00ec, code lost:
            
                if (r12.f.a.i0.equals(".m3u8") == false) goto L69;
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x00ee, code lost:
            
                r10 = r6.keys();
             */
            /* JADX WARN: Code restructure failed: missing block: B:61:0x00f6, code lost:
            
                if (r10.hasNext() == false) goto L131;
             */
            /* JADX WARN: Code restructure failed: missing block: B:63:0x0102, code lost:
            
                if (((java.lang.String) r10.next()).equals("m3u8") == false) goto L132;
             */
            /* JADX WARN: Code restructure failed: missing block: B:67:0x010a, code lost:
            
                if (r7.equals("") == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:69:0x0110, code lost:
            
                if (r10.hasNext() == false) goto L133;
             */
            /* JADX WARN: Code restructure failed: missing block: B:71:0x011c, code lost:
            
                if (((java.lang.String) r10.next()).equals("ts") == false) goto L135;
             */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x0120, code lost:
            
                r5 = r6.getString(r8);
             */
            /* JADX WARN: Code restructure failed: missing block: B:78:0x011f, code lost:
            
                r8 = r7;
             */
            /* JADX WARN: Code restructure failed: missing block: B:81:0x0105, code lost:
            
                r7 = r9;
             */
            /* JADX WARN: Code restructure failed: missing block: B:86:0x00b1, code lost:
            
                r9 = "";
             */
            /* JADX WARN: Code restructure failed: missing block: B:87:0x00d0, code lost:
            
                r5 = "";
                r9 = r5;
             */
            /* JADX WARN: Code restructure failed: missing block: B:88:0x00ae, code lost:
            
                r5 = "";
             */
            /* JADX WARN: Removed duplicated region for block: B:105:0x01ff  */
            /* JADX WARN: Removed duplicated region for block: B:93:0x019a  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onMenuItemClick(android.view.MenuItem r13) {
                /*
                    Method dump skipped, instructions count: 676
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.g.a.onMenuItemClick(android.view.MenuItem):boolean");
            }
        }

        public class b implements PopupMenu.OnDismissListener {
            public b() {
            }

            public void onDismiss(PopupMenu popupMenu) {
            }
        }

        public g() {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0262 A[Catch: Exception -> 0x007a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x007a, blocks: (B:3:0x0005, B:5:0x000d, B:8:0x001b, B:10:0x0021, B:11:0x0126, B:13:0x014c, B:14:0x0163, B:17:0x0175, B:19:0x0185, B:21:0x018b, B:22:0x0193, B:24:0x023e, B:27:0x0262, B:41:0x02bb, B:42:0x02be, B:46:0x0197, B:47:0x01a7, B:49:0x01b5, B:51:0x01c9, B:53:0x01d5, B:55:0x01e5, B:56:0x01ee, B:57:0x01f7, B:58:0x0200, B:60:0x0220, B:62:0x0226, B:63:0x022f, B:64:0x0233, B:65:0x0158, B:66:0x007d, B:68:0x0085, B:70:0x0091, B:29:0x026a, B:31:0x0270, B:34:0x0277, B:36:0x0281), top: B:2:0x0005, inners: #0 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onItemLongClick(android.widget.AdapterView r20, android.view.View r21, int r22, long r23) {
            /*
                Method dump skipped, instructions count: 779
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.g.onItemLongClick(android.widget.AdapterView, android.view.View, int, long):boolean");
        }
    }

    public class h implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NSTIJKPlayerSkyActivity.this.W1.setText("");
                NSTIJKPlayerSkyActivity.this.V1.setVisibility(8);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                NSTIJKPlayerSkyActivity.this.W1.setText("");
                NSTIJKPlayerSkyActivity.this.V1.setVisibility(8);
            }
        }

        public h() {
        }

        /* JADX WARN: Removed duplicated region for block: B:113:0x03f9  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x042b  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x03ff  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1212
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.h.run():void");
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public i(int i, String str, String str2) {
            this.a = i;
            this.c = str;
            this.d = str2;
        }

        public void run() {
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyActivity.this.d).equals("stalker_api")) {
                NSTIJKPlayerSkyActivity.C2(NSTIJKPlayerSkyActivity.this, this.a, this.c, this.d);
                return;
            }
            m7.w.N0(NSTIJKPlayerSkyActivity.this.d);
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTIJKPlayerSkyActivity.this.d);
            try {
                NSTIJKPlayerSkyActivity.G1(NSTIJKPlayerSkyActivity.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(NSTIJKPlayerSkyActivity.this.d), stalkerToken, ((LiveStreamsDBModel) NSTIJKPlayerSkyActivity.E1(NSTIJKPlayerSkyActivity.this).get(this.a)).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "zappingLeft", this.a, this.c, this.d);
            } catch (Exception unused) {
            }
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public j(int i, String str, String str2) {
            this.a = i;
            this.c = str;
            this.d = str2;
        }

        public void run() {
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerSkyActivity.this.d).equals("stalker_api")) {
                NSTIJKPlayerSkyActivity.D2(NSTIJKPlayerSkyActivity.this, this.a, this.c, this.d);
                return;
            }
            m7.w.N0(NSTIJKPlayerSkyActivity.this.d);
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTIJKPlayerSkyActivity.this.d);
            try {
                NSTIJKPlayerSkyActivity.G1(NSTIJKPlayerSkyActivity.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(NSTIJKPlayerSkyActivity.this.d), stalkerToken, ((LiveStreamsDBModel) NSTIJKPlayerSkyActivity.E1(NSTIJKPlayerSkyActivity.this).get(this.a)).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "zappingRight", this.a, this.c, this.d);
            } catch (Exception unused) {
            }
        }
    }

    public class l extends Dialog implements View.OnClickListener {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Activity activity, Activity activity2) {
            super(activity);
            this.h = activity2;
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(l lVar) {
            return lVar.e;
        }

        public static /* synthetic */ LinearLayout b(l lVar) {
            return lVar.f;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0040 A[Catch: Exception -> 0x0148, PHI: r0
          0x0040: PHI (r0v27 java.lang.String) = 
          (r0v20 java.lang.String)
          (r0v21 java.lang.String)
          (r0v22 java.lang.String)
          (r0v23 java.lang.String)
          (r0v28 java.lang.String)
         binds: [B:58:0x00cf, B:53:0x00ae, B:48:0x008d, B:43:0x006c, B:15:0x003e] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {Exception -> 0x0148, blocks: (B:10:0x0008, B:13:0x0032, B:16:0x0040, B:17:0x00ea, B:19:0x00f4, B:20:0x013d, B:22:0x00fa, B:25:0x0102, B:27:0x0108, B:29:0x0114, B:30:0x011a, B:32:0x0120, B:34:0x0126, B:36:0x0132, B:37:0x0138, B:38:0x0047, B:39:0x004e, B:41:0x0060, B:44:0x006f, B:46:0x0081, B:49:0x0090, B:51:0x00a2, B:54:0x00b1, B:56:0x00c3, B:59:0x00d3, B:61:0x00df, B:62:0x00e5), top: B:9:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0047 A[Catch: Exception -> 0x0148, PHI: r0
          0x0047: PHI (r0v24 java.lang.String) = 
          (r0v20 java.lang.String)
          (r0v21 java.lang.String)
          (r0v22 java.lang.String)
          (r0v23 java.lang.String)
          (r0v28 java.lang.String)
         binds: [B:58:0x00cf, B:53:0x00ae, B:48:0x008d, B:43:0x006c, B:15:0x003e] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0148, blocks: (B:10:0x0008, B:13:0x0032, B:16:0x0040, B:17:0x00ea, B:19:0x00f4, B:20:0x013d, B:22:0x00fa, B:25:0x0102, B:27:0x0108, B:29:0x0114, B:30:0x011a, B:32:0x0120, B:34:0x0126, B:36:0x0132, B:37:0x0138, B:38:0x0047, B:39:0x004e, B:41:0x0060, B:44:0x006f, B:46:0x0081, B:49:0x0090, B:51:0x00a2, B:54:0x00b1, B:56:0x00c3, B:59:0x00d3, B:61:0x00df, B:62:0x00e5), top: B:9:0x0008 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r5) {
            /*
                Method dump skipped, instructions count: 332
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.l.onClick(android.view.View):void");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:6:0x00eb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onCreate(android.os.Bundle r11) {
            /*
                Method dump skipped, instructions count: 376
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.l.onCreate(android.os.Bundle):void");
        }
    }

    public class m implements Runnable {
        public m() {
        }

        public void run() {
            NSTIJKPlayerSkyActivity.this.t3();
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public void run() {
            NSTIJKPlayerSkyActivity.E2(NSTIJKPlayerSkyActivity.this);
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
            if (intExtra == 1) {
                NSTIJKPlayerSkyActivity.x1(NSTIJKPlayerSkyActivity.this).start();
                if (Build.VERSION.SDK_INT >= 26) {
                    NSTIJKPlayerSkyActivity.this.l4(a7.e.x0, "pause", 2, 2);
                    return;
                }
                return;
            }
            if (intExtra != 2) {
                return;
            }
            NSTIJKPlayerSkyActivity.x1(NSTIJKPlayerSkyActivity.this).pause();
            if (Build.VERSION.SDK_INT >= 26) {
                NSTIJKPlayerSkyActivity.this.l4(a7.e.r0, "play", 1, 1);
            }
        }
    }

    public class p extends NSTIJKPlayerSky.w {
        public p() {
        }

        public void a() {
            NSTIJKPlayerSkyActivity.this.l4(a7.e.x0, "pause", 2, 2);
        }

        public void b() {
            NSTIJKPlayerSkyActivity.this.l4(a7.e.r0, "play", 1, 1);
        }
    }

    public class q implements DialogInterface.OnClickListener {
        public q() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class r implements DialogInterface.OnClickListener {
        public r() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            m7.w.n0(NSTIJKPlayerSkyActivity.this.d);
        }
    }

    public class s implements SearchView.m {
        public s() {
        }

        public boolean onQueryTextChange(String str) {
            NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
            if (nSTIJKPlayerSkyActivity.A) {
                nSTIJKPlayerSkyActivity.A = false;
                return false;
            }
            nSTIJKPlayerSkyActivity.O0.setVisibility(8);
            if (NSTIJKPlayerSkyActivity.F2(NSTIJKPlayerSkyActivity.this) != null) {
                NSTIJKPlayerSkyActivity.F2(NSTIJKPlayerSkyActivity.this).getFilter().filter(str);
            }
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class t implements DialogInterface.OnClickListener {
        public t() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NSTIJKPlayerSkyActivity.this.O3();
            m7.w.m0(NSTIJKPlayerSkyActivity.this.d);
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class v implements View.OnClickListener {
        public v() {
        }

        public void onClick(View view) {
            NSTIJKPlayerSkyActivity.this.g3(true);
        }
    }

    public class w implements Callback {
        public w() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("onFailure", th.getMessage().toString());
        }

        public void onResponse(Call call, Response response) {
            Toast makeText;
            NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity;
            String message;
            if (response == null) {
                makeText = Toast.makeText(NSTIJKPlayerSkyActivity.this, "Something went Wrong Report not Submitted", 0);
            } else {
                if (response.body() == null || !response.isSuccessful()) {
                    if (response.message() != null && !response.message().equals("")) {
                        nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                        message = response.message();
                    }
                    makeText = Toast.makeText(NSTIJKPlayerSkyActivity.this, "Something went Wrong Report not Submitted", 0);
                } else if (((ClientFeedbackCallback) response.body()).a() == null || !((ClientFeedbackCallback) response.body()).a().equalsIgnoreCase("success")) {
                    nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                    message = "Something went Wrong";
                } else {
                    nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                    message = "Reported Successfully";
                }
                makeText = Toast.makeText(nSTIJKPlayerSkyActivity, message, 0);
            }
            makeText.show();
        }
    }

    public class x implements View.OnClickListener {
        public x() {
        }

        public void onClick(View view) {
        }
    }

    public class y extends BroadcastReceiver {
        public y() {
        }

        public void onReceive(Context context, Intent intent) {
            MyApplication.E("onReceive CLOSE_TARGET_ACTIVITY : ");
            if ("pip_mode_switch_user".equals(intent.getAction())) {
                NSTIJKPlayerSkyActivity.this.finish();
            }
        }
    }

    public class z implements View.OnClickListener {
        public z() {
        }

        public void onClick(View view) {
            m7.w.j(NSTIJKPlayerSkyActivity.this.d);
        }
    }

    public NSTIJKPlayerSkyActivity() {
        Boolean bool = Boolean.FALSE;
        this.Y1 = bool;
        this.Z1 = bool;
        this.d2 = "";
        this.j2 = "";
        this.k2 = bool;
        this.m2 = "";
        Boolean bool2 = Boolean.TRUE;
        this.n2 = bool2;
        this.o2 = null;
        this.q2 = -1;
        this.r2 = "";
        this.s2 = 0;
        this.t2 = "";
        this.u2 = "";
        this.v2 = bool2;
        this.w2 = null;
        this.x2 = null;
        this.y2 = null;
        this.z2 = false;
        this.A2 = 0;
        this.B2 = false;
        this.C2 = 4;
        this.D2 = b6[0];
        this.F2 = bool;
        this.G2 = bool;
        this.H2 = bool;
        this.I2 = bool;
        this.J2 = bool;
        this.K2 = bool;
        this.U2 = 0;
        this.V2 = "0";
        this.W2 = "0";
        this.X2 = bool2;
        this.l4 = "mobile";
        this.p4 = "0";
        this.q4 = "0";
        this.r4 = 0;
        this.u4 = false;
        this.v4 = false;
        this.x4 = "";
        this.y4 = "";
        this.z4 = 0;
        this.A4 = 0;
        this.D4 = 0;
        this.G4 = "";
        this.H4 = "";
        this.I4 = "";
        this.J4 = false;
        this.K4 = "false";
        this.L4 = "";
        this.N4 = m7.a.u0;
        this.P4 = "-10";
        this.Q4 = null;
        this.G5 = "Live";
        this.H5 = "";
        this.K5 = "";
        this.L5 = "";
        this.M5 = "";
        this.O5 = "";
        this.S5 = null;
        this.T5 = new y();
        this.U5 = new ArrayList();
        this.V5 = new p();
    }

    public static /* synthetic */ void A1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        nSTIJKPlayerSkyActivity.d4();
    }

    public static /* synthetic */ ImageView A2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.q;
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A3() {
        /*
            Method dump skipped, instructions count: 2648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.A3():void");
    }

    public static /* synthetic */ ArrayList B1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.w0;
    }

    public static /* synthetic */ SharedPreferences.Editor B2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.F1;
    }

    public static /* synthetic */ Boolean C1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.Z1;
    }

    public static /* synthetic */ void C2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2, String str, String str2) {
        nSTIJKPlayerSkyActivity.m4(i2, str, str2);
    }

    public static /* synthetic */ Boolean D1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, Boolean bool) {
        nSTIJKPlayerSkyActivity.Z1 = bool;
        return bool;
    }

    public static /* synthetic */ void D2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2, String str, String str2) {
        nSTIJKPlayerSkyActivity.n4(i2, str, str2);
    }

    private void D3() {
        ProgressBar progressBar = this.w;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView = this.r;
        if (textView != null) {
            textView.setText(this.d.getResources().getString(a7.j.M4));
        }
        TextView textView2 = this.s;
        if (textView2 != null) {
            textView2.setText("");
        }
        TextView textView3 = this.t;
        if (textView3 != null) {
            textView3.setText(this.d.getResources().getString(a7.j.b4));
        }
        TextView textView4 = this.u;
        if (textView4 != null) {
            textView4.setText("");
        }
    }

    public static /* synthetic */ ArrayList E1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.z0;
    }

    public static /* synthetic */ void E2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        nSTIJKPlayerSkyActivity.s3();
    }

    public static /* synthetic */ int F1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.T1;
    }

    public static /* synthetic */ T F2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.U;
    }

    private void F3() {
        int currentWindowIndex = this.h2.getCurrentWindowIndex();
        if (currentWindowIndex == this.z0.size() - 1) {
            this.h2.setCurrentWindowIndex(0);
        } else {
            this.h2.setCurrentWindowIndex(currentWindowIndex + 1);
        }
    }

    public static /* synthetic */ n7.g G1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.w4;
    }

    private void G2(int i2, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            List list = this.B4;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.B4.size(); i3++) {
                    sb.append(this.B4.get(i3));
                    sb.append(",");
                }
            }
            sb.append(i2);
            this.D4 = i2;
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.d);
            this.C4.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.d), stalkerToken, (t.o) null, sb.toString(), "added", str);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public static /* synthetic */ void H1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, ArrayList arrayList) {
        nSTIJKPlayerSkyActivity.M3(arrayList);
    }

    public static /* synthetic */ int I1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2) {
        nSTIJKPlayerSkyActivity.A2 = i2;
        return i2;
    }

    private void I2(String str, String str2, String str3) {
        if (this.d == null || this.U == null || this.S == null) {
            return;
        }
        FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
        favouriteM3UModel.setUrl(str2);
        favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(this.d));
        favouriteM3UModel.setName(str3);
        favouriteM3UModel.setCategoryID(str);
        this.S.addToFavourite(favouriteM3UModel);
        this.U.notifyDataSetChanged();
        m7.w.P0(this.d, str3 + this.d.getResources().getString(a7.j.q));
    }

    public static /* synthetic */ String J1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.H4;
    }

    private void J2(Configuration configuration) {
        NSTIJKPlayerSky nSTIJKPlayerSky;
        boolean z2;
        View decorView = getWindow().getDecorView();
        if (configuration.orientation == 2) {
            decorView.setSystemUiVisibility(5894);
            nSTIJKPlayerSky = this.h2;
            z2 = false;
        } else {
            decorView.setSystemUiVisibility(256);
            nSTIJKPlayerSky = this.h2;
            z2 = true;
        }
        nSTIJKPlayerSky.setAdjustViewBounds(z2);
    }

    private void J3() {
        this.t3.setOnClickListener(this);
        this.u3.setOnClickListener(this);
        this.z3.setOnClickListener(this);
        this.E3.setOnClickListener(this);
        this.b4.setOnClickListener(this);
        this.F3.setOnClickListener(this);
        this.J3.setOnClickListener(this);
        this.A3.setOnClickListener(this);
        this.I3.setOnClickListener(this);
        this.C3.setOnClickListener(this);
        this.D3.setOnClickListener(this);
        this.n3.setOnClickListener(this);
        this.s3.setOnClickListener(this);
        this.y5.setOnClickListener(this);
        this.z5.setOnClickListener(this);
        this.A5.setOnClickListener(this);
        this.B5.setOnClickListener(this);
        this.C5.setOnClickListener(this);
        this.D5.setOnClickListener(this);
        this.E5.setOnClickListener(this);
        this.j5.setOnClickListener(this);
        this.v5.setOnClickListener(this);
        this.G3.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= 26) {
            this.h2.setMovieListener(this.V5);
        }
    }

    public static /* synthetic */ void K1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        nSTIJKPlayerSkyActivity.v3();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(2:278|279)|(1:347)(7:285|(2:286|(3:288|289|(2:292|293)(1:291))(2:344|345))|294|295|(4:(3:299|(2:302|303)(1:301)|297)|338|339|304)(2:339|304)|52|53)|305|306|(6:312|(2:313|(1:333)(2:315|(2:317|318)(1:332)))|319|(4:(3:323|(2:325|326)(1:329)|321)|330|331|327)(2:331|327)|52|53)|334) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:99|100|(1:162)(6:106|(2:107|(2:109|(2:112|113)(1:111))(2:160|161))|114|(4:(3:118|(2:121|122)(1:120)|116)|158|159|123)(2:159|123)|52|53)|125|126|(6:132|(2:133|(2:135|(2:137|138)(1:152))(2:153|154))|139|(4:(3:143|(2:145|146)(1:149)|141)|150|151|147)(2:151|147)|52|53)|155) */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0509, code lost:
    
        r9 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x052c, code lost:
    
        r3 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x0c79, code lost:
    
        r9 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0cfd A[Catch: Exception -> 0x001d, TryCatch #2 {Exception -> 0x001d, blocks: (B:3:0x0006, B:5:0x000b, B:7:0x0017, B:8:0x0021, B:11:0x0055, B:13:0x005b, B:15:0x008e, B:17:0x00a0, B:19:0x00e1, B:20:0x00e9, B:22:0x0159, B:24:0x0161, B:26:0x0169, B:28:0x0183, B:30:0x0189, B:31:0x0191, B:39:0x01e6, B:41:0x021e, B:42:0x023e, B:44:0x0252, B:45:0x027b, B:47:0x027f, B:48:0x02aa, B:50:0x02ae, B:51:0x02b8, B:52:0x02ba, B:55:0x022d, B:58:0x01d5, B:59:0x02bf, B:61:0x02c5, B:63:0x02d5, B:65:0x02e9, B:67:0x032a, B:68:0x0332, B:70:0x03a2, B:72:0x03aa, B:74:0x03b2, B:76:0x03d0, B:77:0x03d8, B:85:0x042d, B:155:0x052d, B:87:0x0556, B:89:0x055a, B:91:0x0562, B:92:0x0572, B:93:0x0587, B:94:0x0576, B:95:0x059f, B:97:0x05a3, B:98:0x05ad, B:169:0x05b1, B:171:0x05c8, B:173:0x0609, B:174:0x0611, B:176:0x0689, B:178:0x0691, B:180:0x0699, B:182:0x06b3, B:184:0x06b9, B:185:0x06c1, B:193:0x0716, B:195:0x0750, B:196:0x0770, B:198:0x0784, B:200:0x0790, B:201:0x07b1, B:202:0x0818, B:203:0x07b4, B:204:0x0822, B:206:0x0826, B:207:0x084f, B:209:0x0853, B:210:0x085d, B:211:0x075f, B:217:0x0861, B:219:0x0870, B:221:0x0876, B:223:0x08b7, B:225:0x08cb, B:227:0x08f8, B:228:0x0900, B:230:0x097a, B:232:0x0982, B:234:0x098a, B:236:0x09a8, B:238:0x09ae, B:239:0x09b6, B:241:0x09c5, B:242:0x09f0, B:244:0x0a2a, B:245:0x0a4c, B:247:0x0a55, B:248:0x0a82, B:250:0x0a86, B:251:0x0a90, B:252:0x0a3b, B:253:0x0a94, B:255:0x0aa0, B:257:0x0ab4, B:259:0x0afd, B:260:0x0b05, B:262:0x0b83, B:264:0x0b8b, B:266:0x0b93, B:268:0x0bb5, B:269:0x0bbd, B:334:0x0c9b, B:271:0x0cc6, B:273:0x0cfd, B:274:0x0d2a, B:276:0x0d2e, B:277:0x0d36, B:349:0x0d3a, B:351:0x0d52, B:353:0x0d7f, B:354:0x0d87, B:356:0x0e09, B:358:0x0e11, B:360:0x0e19, B:362:0x0e37, B:364:0x0e3d, B:365:0x0e45, B:367:0x0e54, B:369:0x0e60, B:370:0x0e83, B:371:0x0ef0, B:372:0x0e86, B:373:0x0efa, B:375:0x0f34, B:376:0x0f56, B:378:0x0f5f, B:379:0x0f8c, B:381:0x0f90, B:382:0x0f9a, B:383:0x0f45, B:33:0x019b, B:35:0x01a1, B:37:0x01a7, B:57:0x01c3), top: B:2:0x0006, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0d2e A[Catch: Exception -> 0x001d, TryCatch #2 {Exception -> 0x001d, blocks: (B:3:0x0006, B:5:0x000b, B:7:0x0017, B:8:0x0021, B:11:0x0055, B:13:0x005b, B:15:0x008e, B:17:0x00a0, B:19:0x00e1, B:20:0x00e9, B:22:0x0159, B:24:0x0161, B:26:0x0169, B:28:0x0183, B:30:0x0189, B:31:0x0191, B:39:0x01e6, B:41:0x021e, B:42:0x023e, B:44:0x0252, B:45:0x027b, B:47:0x027f, B:48:0x02aa, B:50:0x02ae, B:51:0x02b8, B:52:0x02ba, B:55:0x022d, B:58:0x01d5, B:59:0x02bf, B:61:0x02c5, B:63:0x02d5, B:65:0x02e9, B:67:0x032a, B:68:0x0332, B:70:0x03a2, B:72:0x03aa, B:74:0x03b2, B:76:0x03d0, B:77:0x03d8, B:85:0x042d, B:155:0x052d, B:87:0x0556, B:89:0x055a, B:91:0x0562, B:92:0x0572, B:93:0x0587, B:94:0x0576, B:95:0x059f, B:97:0x05a3, B:98:0x05ad, B:169:0x05b1, B:171:0x05c8, B:173:0x0609, B:174:0x0611, B:176:0x0689, B:178:0x0691, B:180:0x0699, B:182:0x06b3, B:184:0x06b9, B:185:0x06c1, B:193:0x0716, B:195:0x0750, B:196:0x0770, B:198:0x0784, B:200:0x0790, B:201:0x07b1, B:202:0x0818, B:203:0x07b4, B:204:0x0822, B:206:0x0826, B:207:0x084f, B:209:0x0853, B:210:0x085d, B:211:0x075f, B:217:0x0861, B:219:0x0870, B:221:0x0876, B:223:0x08b7, B:225:0x08cb, B:227:0x08f8, B:228:0x0900, B:230:0x097a, B:232:0x0982, B:234:0x098a, B:236:0x09a8, B:238:0x09ae, B:239:0x09b6, B:241:0x09c5, B:242:0x09f0, B:244:0x0a2a, B:245:0x0a4c, B:247:0x0a55, B:248:0x0a82, B:250:0x0a86, B:251:0x0a90, B:252:0x0a3b, B:253:0x0a94, B:255:0x0aa0, B:257:0x0ab4, B:259:0x0afd, B:260:0x0b05, B:262:0x0b83, B:264:0x0b8b, B:266:0x0b93, B:268:0x0bb5, B:269:0x0bbd, B:334:0x0c9b, B:271:0x0cc6, B:273:0x0cfd, B:274:0x0d2a, B:276:0x0d2e, B:277:0x0d36, B:349:0x0d3a, B:351:0x0d52, B:353:0x0d7f, B:354:0x0d87, B:356:0x0e09, B:358:0x0e11, B:360:0x0e19, B:362:0x0e37, B:364:0x0e3d, B:365:0x0e45, B:367:0x0e54, B:369:0x0e60, B:370:0x0e83, B:371:0x0ef0, B:372:0x0e86, B:373:0x0efa, B:375:0x0f34, B:376:0x0f56, B:378:0x0f5f, B:379:0x0f8c, B:381:0x0f90, B:382:0x0f9a, B:383:0x0f45, B:33:0x019b, B:35:0x01a1, B:37:0x01a7, B:57:0x01c3), top: B:2:0x0006, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x055a A[Catch: Exception -> 0x001d, TryCatch #2 {Exception -> 0x001d, blocks: (B:3:0x0006, B:5:0x000b, B:7:0x0017, B:8:0x0021, B:11:0x0055, B:13:0x005b, B:15:0x008e, B:17:0x00a0, B:19:0x00e1, B:20:0x00e9, B:22:0x0159, B:24:0x0161, B:26:0x0169, B:28:0x0183, B:30:0x0189, B:31:0x0191, B:39:0x01e6, B:41:0x021e, B:42:0x023e, B:44:0x0252, B:45:0x027b, B:47:0x027f, B:48:0x02aa, B:50:0x02ae, B:51:0x02b8, B:52:0x02ba, B:55:0x022d, B:58:0x01d5, B:59:0x02bf, B:61:0x02c5, B:63:0x02d5, B:65:0x02e9, B:67:0x032a, B:68:0x0332, B:70:0x03a2, B:72:0x03aa, B:74:0x03b2, B:76:0x03d0, B:77:0x03d8, B:85:0x042d, B:155:0x052d, B:87:0x0556, B:89:0x055a, B:91:0x0562, B:92:0x0572, B:93:0x0587, B:94:0x0576, B:95:0x059f, B:97:0x05a3, B:98:0x05ad, B:169:0x05b1, B:171:0x05c8, B:173:0x0609, B:174:0x0611, B:176:0x0689, B:178:0x0691, B:180:0x0699, B:182:0x06b3, B:184:0x06b9, B:185:0x06c1, B:193:0x0716, B:195:0x0750, B:196:0x0770, B:198:0x0784, B:200:0x0790, B:201:0x07b1, B:202:0x0818, B:203:0x07b4, B:204:0x0822, B:206:0x0826, B:207:0x084f, B:209:0x0853, B:210:0x085d, B:211:0x075f, B:217:0x0861, B:219:0x0870, B:221:0x0876, B:223:0x08b7, B:225:0x08cb, B:227:0x08f8, B:228:0x0900, B:230:0x097a, B:232:0x0982, B:234:0x098a, B:236:0x09a8, B:238:0x09ae, B:239:0x09b6, B:241:0x09c5, B:242:0x09f0, B:244:0x0a2a, B:245:0x0a4c, B:247:0x0a55, B:248:0x0a82, B:250:0x0a86, B:251:0x0a90, B:252:0x0a3b, B:253:0x0a94, B:255:0x0aa0, B:257:0x0ab4, B:259:0x0afd, B:260:0x0b05, B:262:0x0b83, B:264:0x0b8b, B:266:0x0b93, B:268:0x0bb5, B:269:0x0bbd, B:334:0x0c9b, B:271:0x0cc6, B:273:0x0cfd, B:274:0x0d2a, B:276:0x0d2e, B:277:0x0d36, B:349:0x0d3a, B:351:0x0d52, B:353:0x0d7f, B:354:0x0d87, B:356:0x0e09, B:358:0x0e11, B:360:0x0e19, B:362:0x0e37, B:364:0x0e3d, B:365:0x0e45, B:367:0x0e54, B:369:0x0e60, B:370:0x0e83, B:371:0x0ef0, B:372:0x0e86, B:373:0x0efa, B:375:0x0f34, B:376:0x0f56, B:378:0x0f5f, B:379:0x0f8c, B:381:0x0f90, B:382:0x0f9a, B:383:0x0f45, B:33:0x019b, B:35:0x01a1, B:37:0x01a7, B:57:0x01c3), top: B:2:0x0006, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x05a3 A[Catch: Exception -> 0x001d, TryCatch #2 {Exception -> 0x001d, blocks: (B:3:0x0006, B:5:0x000b, B:7:0x0017, B:8:0x0021, B:11:0x0055, B:13:0x005b, B:15:0x008e, B:17:0x00a0, B:19:0x00e1, B:20:0x00e9, B:22:0x0159, B:24:0x0161, B:26:0x0169, B:28:0x0183, B:30:0x0189, B:31:0x0191, B:39:0x01e6, B:41:0x021e, B:42:0x023e, B:44:0x0252, B:45:0x027b, B:47:0x027f, B:48:0x02aa, B:50:0x02ae, B:51:0x02b8, B:52:0x02ba, B:55:0x022d, B:58:0x01d5, B:59:0x02bf, B:61:0x02c5, B:63:0x02d5, B:65:0x02e9, B:67:0x032a, B:68:0x0332, B:70:0x03a2, B:72:0x03aa, B:74:0x03b2, B:76:0x03d0, B:77:0x03d8, B:85:0x042d, B:155:0x052d, B:87:0x0556, B:89:0x055a, B:91:0x0562, B:92:0x0572, B:93:0x0587, B:94:0x0576, B:95:0x059f, B:97:0x05a3, B:98:0x05ad, B:169:0x05b1, B:171:0x05c8, B:173:0x0609, B:174:0x0611, B:176:0x0689, B:178:0x0691, B:180:0x0699, B:182:0x06b3, B:184:0x06b9, B:185:0x06c1, B:193:0x0716, B:195:0x0750, B:196:0x0770, B:198:0x0784, B:200:0x0790, B:201:0x07b1, B:202:0x0818, B:203:0x07b4, B:204:0x0822, B:206:0x0826, B:207:0x084f, B:209:0x0853, B:210:0x085d, B:211:0x075f, B:217:0x0861, B:219:0x0870, B:221:0x0876, B:223:0x08b7, B:225:0x08cb, B:227:0x08f8, B:228:0x0900, B:230:0x097a, B:232:0x0982, B:234:0x098a, B:236:0x09a8, B:238:0x09ae, B:239:0x09b6, B:241:0x09c5, B:242:0x09f0, B:244:0x0a2a, B:245:0x0a4c, B:247:0x0a55, B:248:0x0a82, B:250:0x0a86, B:251:0x0a90, B:252:0x0a3b, B:253:0x0a94, B:255:0x0aa0, B:257:0x0ab4, B:259:0x0afd, B:260:0x0b05, B:262:0x0b83, B:264:0x0b8b, B:266:0x0b93, B:268:0x0bb5, B:269:0x0bbd, B:334:0x0c9b, B:271:0x0cc6, B:273:0x0cfd, B:274:0x0d2a, B:276:0x0d2e, B:277:0x0d36, B:349:0x0d3a, B:351:0x0d52, B:353:0x0d7f, B:354:0x0d87, B:356:0x0e09, B:358:0x0e11, B:360:0x0e19, B:362:0x0e37, B:364:0x0e3d, B:365:0x0e45, B:367:0x0e54, B:369:0x0e60, B:370:0x0e83, B:371:0x0ef0, B:372:0x0e86, B:373:0x0efa, B:375:0x0f34, B:376:0x0f56, B:378:0x0f5f, B:379:0x0f8c, B:381:0x0f90, B:382:0x0f9a, B:383:0x0f45, B:33:0x019b, B:35:0x01a1, B:37:0x01a7, B:57:0x01c3), top: B:2:0x0006, inners: #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void K3(int r25, java.util.ArrayList r26) {
        /*
            Method dump skipped, instructions count: 4025
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.K3(int, java.util.ArrayList):void");
    }

    public static /* synthetic */ String L1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, String str) {
        nSTIJKPlayerSkyActivity.H4 = str;
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:270:0x08b0  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0f49  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0d90 A[Catch: Exception -> 0x0d4f, TryCatch #15 {Exception -> 0x0d4f, blocks: (B:487:0x0d23, B:413:0x0d59, B:415:0x0d90, B:417:0x0d98, B:418:0x0dac, B:419:0x0dc5, B:420:0x0db0, B:421:0x0ddf, B:423:0x0de3, B:424:0x0deb, B:505:0x0dfb), top: B:396:0x0b1d }] */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0de3 A[Catch: Exception -> 0x0d4f, TryCatch #15 {Exception -> 0x0d4f, blocks: (B:487:0x0d23, B:413:0x0d59, B:415:0x0d90, B:417:0x0d98, B:418:0x0dac, B:419:0x0dc5, B:420:0x0db0, B:421:0x0ddf, B:423:0x0de3, B:424:0x0deb, B:505:0x0dfb), top: B:396:0x0b1d }] */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0af6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x10f4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x111d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x1133  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x1149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void L3(int r26, java.util.ArrayList r27) {
        /*
            Method dump skipped, instructions count: 4449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.L3(int, java.util.ArrayList):void");
    }

    public static /* synthetic */ void M1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        nSTIJKPlayerSkyActivity.c4();
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0406  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void M3(java.util.ArrayList r15) {
        /*
            Method dump skipped, instructions count: 1057
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.M3(java.util.ArrayList):void");
    }

    public static /* synthetic */ ListView N1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.K;
    }

    private void N3() {
        int currentWindowIndex = this.h2.getCurrentWindowIndex();
        if (currentWindowIndex == 0) {
            this.h2.setCurrentWindowIndex(this.z0.size() - 1);
        } else {
            this.h2.setCurrentWindowIndex(currentWindowIndex - 1);
        }
    }

    public static /* synthetic */ String O1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.W2;
    }

    public static /* synthetic */ ArrayList P1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.x0;
    }

    private void P3(int i2, String str) {
        try {
            List list = this.B4;
            if (list == null) {
                m7.w.X();
                return;
            }
            list.remove(Integer.valueOf(i2));
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < this.B4.size(); i3++) {
                sb.append(this.B4.get(i3));
                sb.append(",");
            }
            this.B4.add(Integer.valueOf(i2));
            String substring = sb.toString().contains(",") ? sb.substring(0, sb.lastIndexOf(",")) : sb.toString();
            this.D4 = i2;
            this.C4.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.d), SharepreferenceDBHandler.getStalkerToken(this.d), (t.o) null, substring, "removed", str);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public static /* synthetic */ void Q1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        nSTIJKPlayerSkyActivity.u3();
    }

    public static /* synthetic */ HashMap R1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, String str) {
        return nSTIJKPlayerSkyActivity.Y3(str);
    }

    private void R3(String str, String str2) {
        LiveStreamDBHandler liveStreamDBHandler;
        Context context = this.d;
        if (context == null || this.U == null || (liveStreamDBHandler = this.S) == null) {
            return;
        }
        liveStreamDBHandler.deleteFavourite(str, SharepreferenceDBHandler.getUserID(context));
        this.U.notifyDataSetChanged();
        m7.w.P0(this.d, str2 + this.d.getResources().getString(a7.j.c6));
    }

    public static /* synthetic */ boolean S1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.z3();
    }

    public static /* synthetic */ int T1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.A4;
    }

    private void T2(int i2) {
        if (c6) {
            return;
        }
        this.h2.a1 = new n();
        NSTIJKPlayerSky nSTIJKPlayerSky = this.h2;
        nSTIJKPlayerSky.Z0.postDelayed(nSTIJKPlayerSky.a1, i2);
    }

    public static /* synthetic */ int U1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2) {
        nSTIJKPlayerSkyActivity.A4 = i2;
        return i2;
    }

    public static /* synthetic */ String V1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.I4;
    }

    public static /* synthetic */ O W1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.n4;
    }

    private void W3() {
        this.N2 = new k();
    }

    public static /* synthetic */ String X1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, String str) {
        nSTIJKPlayerSkyActivity.I4 = str;
        return str;
    }

    private void X3() {
        String str;
        String str2;
        RecyclerView recyclerView;
        this.x3.startAnimation(this.i4);
        this.x3.setVisibility(8);
        this.q3.startAnimation(this.s4);
        this.q3.setVisibility(0);
        this.P3.setVisibility(0);
        this.O3.setVisibility(8);
        this.K.setVisibility(8);
        if (this.m4 != null && (recyclerView = this.O3) != null) {
            recyclerView.setAdapter((RecyclerView.g) null);
        }
        String str3 = this.P4;
        if ((str3 != null && str3.equals("-1")) || (((str = this.P4) != null && str.equals("0")) || ((str2 = this.P4) != null && str2.equals("-6")))) {
            String str4 = this.P4;
            this.V2 = str4;
            this.W2 = str4;
        }
        N n2 = this.m4;
        if (n2 == null) {
            this.m4 = new N(this.d, this.V2, "player", this.K4, "");
        } else {
            n2.B0(this.V2, "player", this.K4);
        }
        this.W2 = this.V2;
        this.O3.setVisibility(0);
        O2();
        this.O3.setAdapter(this.m4);
        this.O3.setLayoutManager(this.o4);
    }

    public static /* synthetic */ void Y1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2, ArrayList arrayList) {
        nSTIJKPlayerSkyActivity.L3(i2, arrayList);
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
    private java.util.HashMap Y3(java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.Y3(java.lang.String):java.util.HashMap");
    }

    public static /* synthetic */ AsyncTask Z1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.y2;
    }

    private void Z2() {
        AsyncTask asyncTask = this.w2;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            SharepreferenceDBHandler.setAsyncTaskStatus(0, this.d);
        } else {
            SharepreferenceDBHandler.setAsyncTaskStatus(1, this.d);
            this.w2.cancel(true);
        }
    }

    private HashMap Z3(StalkerShortEPGCallback stalkerShortEPGCallback) {
        int i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (this.S != null) {
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
                int M = m7.w.M(j2, j3, this.d);
                if (M != 0) {
                    int i3 = 100 - M;
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
                        arrayList.add(1, this.h0.format(valueOf) + " - " + this.h0.format(valueOf2));
                        arrayList.add(2, descr);
                    }
                    M = i2;
                }
                arrayList2.add(0, this.h0.format(valueOf) + " - " + this.h0.format(valueOf2));
                arrayList2.add(1, name);
                arrayList2.add(2, descr);
                if (1 < stalkerShortEPGCallback.getJs().size()) {
                    long intValue3 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(1)).getStartTimestamp().intValue();
                    long intValue4 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(1)).getStopTimestamp().intValue();
                    String name2 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(1)).getName();
                    String descr2 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(1)).getDescr();
                    Long valueOf3 = Long.valueOf(intValue3 * 1000);
                    Long valueOf4 = Long.valueOf(intValue4 * 1000);
                    if (M != 0 && 100 - M != 0 && name != null && !name.equals("")) {
                        arrayList.add(3, this.d.getResources().getString(a7.j.a4) + " " + name2);
                        arrayList.add(4, this.h0.format(valueOf3) + " - " + this.h0.format(valueOf4));
                        arrayList.add(5, descr2);
                    }
                    arrayList2.add(3, this.h0.format(valueOf3) + " - " + this.h0.format(valueOf4));
                    arrayList2.add(4, name2);
                    arrayList2.add(5, descr2);
                }
                if (2 < stalkerShortEPGCallback.getJs().size()) {
                    long intValue5 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getStartTimestamp().intValue();
                    long intValue6 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getStopTimestamp().intValue();
                    String name3 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getName();
                    String descr3 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getDescr();
                    arrayList2.add(6, this.h0.format(Long.valueOf(intValue5 * 1000)) + " - " + this.h0.format(Long.valueOf(intValue6 * 1000)));
                    arrayList2.add(7, name3);
                    arrayList2.add(8, descr3);
                }
                if (3 < stalkerShortEPGCallback.getJs().size()) {
                    long intValue7 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getStartTimestamp().intValue();
                    long intValue8 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getStopTimestamp().intValue();
                    String name4 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getName();
                    String descr4 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getDescr();
                    arrayList2.add(9, this.h0.format(Long.valueOf(intValue7 * 1000)) + " - " + this.h0.format(Long.valueOf(intValue8 * 1000)));
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

    public static /* synthetic */ AsyncTask a2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, AsyncTask asyncTask) {
        nSTIJKPlayerSkyActivity.y2 = asyncTask;
        return asyncTask;
    }

    public static boolean a3() {
        ProgressBar progressBar = d6;
        return progressBar != null && progressBar.getVisibility() == 0;
    }

    public static /* synthetic */ ArrayList b2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.v0;
    }

    public static long b3(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static /* synthetic */ ArrayList c2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, ArrayList arrayList) {
        nSTIJKPlayerSkyActivity.v0 = arrayList;
        return arrayList;
    }

    private void c4() {
        LinearLayout linearLayout = this.y;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    public static /* synthetic */ int d2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.z4;
    }

    private void d4() {
        ProgressBar progressBar = this.x;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public static /* synthetic */ int e2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2) {
        nSTIJKPlayerSkyActivity.z4 = i2;
        return i2;
    }

    private void e4() {
        if (this.p3.getVisibility() == 8) {
            this.p3.startAnimation(this.j4);
            this.p3.setVisibility(0);
            this.D3.requestFocus();
        }
    }

    public static /* synthetic */ void f2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2, ArrayList arrayList) {
        nSTIJKPlayerSkyActivity.K3(i2, arrayList);
    }

    private void f3() {
        ImageView imageView = this.t3;
        imageView.setOnFocusChangeListener(new G(imageView));
        ImageView imageView2 = this.u3;
        imageView2.setOnFocusChangeListener(new G(imageView2));
        ImageView imageView3 = this.E3;
        imageView3.setOnFocusChangeListener(new G(imageView3));
        ImageView imageView4 = this.F3;
        imageView4.setOnFocusChangeListener(new G(imageView4));
        ImageView imageView5 = this.G3;
        imageView5.setOnFocusChangeListener(new G(imageView5));
        LinearLayout linearLayout = this.J3;
        linearLayout.setOnFocusChangeListener(new G(linearLayout));
        LinearLayout linearLayout2 = this.A3;
        linearLayout2.setOnFocusChangeListener(new G(linearLayout2));
        LinearLayout linearLayout3 = this.I3;
        linearLayout3.setOnFocusChangeListener(new G(linearLayout3));
        ImageView imageView6 = this.C3;
        imageView6.setOnFocusChangeListener(new G(imageView6));
        ImageView imageView7 = this.D3;
        imageView7.setOnFocusChangeListener(new G(imageView7));
        ImageView imageView8 = this.r3;
        imageView8.setOnFocusChangeListener(new G(imageView8));
        ImageView imageView9 = this.r3;
        imageView9.setOnFocusChangeListener(new G(imageView9));
        RelativeLayout relativeLayout = this.z5;
        relativeLayout.setOnFocusChangeListener(new G(relativeLayout));
        ImageView imageView10 = this.y5;
        imageView10.setOnFocusChangeListener(new G(imageView10));
        LinearLayout linearLayout4 = this.A5;
        linearLayout4.setOnFocusChangeListener(new G(linearLayout4));
        LinearLayout linearLayout5 = this.B5;
        linearLayout5.setOnFocusChangeListener(new G(linearLayout5));
        CheckBox checkBox = this.V4;
        checkBox.setOnFocusChangeListener(new G(checkBox));
        CheckBox checkBox2 = this.W4;
        checkBox2.setOnFocusChangeListener(new G(checkBox2));
        CheckBox checkBox3 = this.X4;
        checkBox3.setOnFocusChangeListener(new G(checkBox3));
        CheckBox checkBox4 = this.Y4;
        checkBox4.setOnFocusChangeListener(new G(checkBox4));
        LinearLayout linearLayout6 = this.C5;
        linearLayout6.setOnFocusChangeListener(new G(linearLayout6));
        CheckBox checkBox5 = this.Z4;
        checkBox5.setOnFocusChangeListener(new G(checkBox5));
        CheckBox checkBox6 = this.a5;
        checkBox6.setOnFocusChangeListener(new G(checkBox6));
        CheckBox checkBox7 = this.b5;
        checkBox7.setOnFocusChangeListener(new G(checkBox7));
        CheckBox checkBox8 = this.c5;
        checkBox8.setOnFocusChangeListener(new G(checkBox8));
        CheckBox checkBox9 = this.d5;
        checkBox9.setOnFocusChangeListener(new G(checkBox9));
        LinearLayout linearLayout7 = this.D5;
        linearLayout7.setOnFocusChangeListener(new G(linearLayout7));
        CheckBox checkBox10 = this.f5;
        checkBox10.setOnFocusChangeListener(new G(checkBox10));
        CheckBox checkBox11 = this.g5;
        checkBox11.setOnFocusChangeListener(new G(checkBox11));
        CheckBox checkBox12 = this.h5;
        checkBox12.setOnFocusChangeListener(new G(checkBox12));
        CheckBox checkBox13 = this.i5;
        checkBox13.setOnFocusChangeListener(new G(checkBox13));
        EditText editText = this.t5;
        editText.setOnFocusChangeListener(new G(editText));
        TextView textView = this.U4;
        textView.setOnFocusChangeListener(new G(textView));
        LinearLayout linearLayout8 = this.E5;
        linearLayout8.setOnFocusChangeListener(new G(linearLayout8));
    }

    private void f4(Activity activity) {
        new l((NSTIJKPlayerSkyActivity) activity, activity).show();
    }

    public static /* synthetic */ String g2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.e2;
    }

    private void g4() {
        ListView listView;
        try {
            if (m7.a.Y.booleanValue()) {
                findViewById(a7.f.p).setOnClickListener(this);
            }
            this.Y0.setVisibility(0);
            this.Z0.setVisibility(0);
            this.a1.setVisibility(0);
            this.b1.setVisibility(0);
            this.c1.setVisibility(0);
            this.W0.setVisibility(0);
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            LinearLayout.LayoutParams layoutParams = this.d1.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = 0;
            this.d1.setLayoutParams(layoutParams);
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            Y5 = false;
            if (this.S0) {
                if (!this.T0 || this.U0.equals("")) {
                    SharedPreferences sharedPreferences = getSharedPreferences("currentlyPlayingVideoPosition", 0);
                    this.Z = sharedPreferences;
                    this.J.setSelection(sharedPreferences.getInt("currentlyPlayingVideoPosition", 0));
                    this.S0 = false;
                    this.T0 = false;
                } else {
                    String str = this.e1;
                    if (str != null && !str.equals("") && this.e1.equals("0")) {
                        K2();
                    }
                }
                listView = this.J;
                if (listView == null) {
                    return;
                }
            } else {
                listView = this.J;
                if (listView == null) {
                    return;
                }
            }
            listView.requestFocus();
        } catch (Exception e2) {
            Log.e("exection", "" + e2);
        }
    }

    public static /* synthetic */ List h2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.B4;
    }

    public static String h3(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    public static /* synthetic */ DatabaseHandler i2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.E1;
    }

    public static /* synthetic */ Boolean j2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.n2;
    }

    public static /* synthetic */ String k2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.G4;
    }

    public static /* synthetic */ void l2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, String str, String str2, String str3) {
        nSTIJKPlayerSkyActivity.I2(str, str2, str3);
    }

    public static /* synthetic */ String m2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, String str) {
        nSTIJKPlayerSkyActivity.G4 = str;
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x01d7 A[Catch: Exception -> 0x01f6, TryCatch #2 {Exception -> 0x01f6, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000c, B:10:0x001c, B:11:0x002b, B:12:0x0179, B:14:0x01d7, B:17:0x01e7, B:19:0x0033, B:21:0x003f, B:22:0x0053, B:83:0x010d, B:25:0x011e), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01e7 A[Catch: Exception -> 0x01f6, TRY_LEAVE, TryCatch #2 {Exception -> 0x01f6, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000c, B:10:0x001c, B:11:0x002b, B:12:0x0179, B:14:0x01d7, B:17:0x01e7, B:19:0x0033, B:21:0x003f, B:22:0x0053, B:83:0x010d, B:25:0x011e), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m4(int r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.m4(int, java.lang.String, java.lang.String):void");
    }

    public static /* synthetic */ int n2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2) {
        nSTIJKPlayerSkyActivity.D4 = i2;
        return i2;
    }

    private ArrayList n3() {
        ArrayList allPasswordStatus = this.S.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.d));
        this.F0 = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.D0.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.D0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x01d7 A[Catch: Exception -> 0x01f6, TryCatch #2 {Exception -> 0x01f6, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000c, B:10:0x001c, B:11:0x002b, B:12:0x0179, B:14:0x01d7, B:17:0x01e7, B:19:0x0033, B:21:0x003f, B:22:0x0053, B:83:0x010d, B:25:0x011e), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01e7 A[Catch: Exception -> 0x01f6, TRY_LEAVE, TryCatch #2 {Exception -> 0x01f6, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x000c, B:10:0x001c, B:11:0x002b, B:12:0x0179, B:14:0x01d7, B:17:0x01e7, B:19:0x0033, B:21:0x003f, B:22:0x0053, B:83:0x010d, B:25:0x011e), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n4(int r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.n4(int, java.lang.String, java.lang.String):void");
    }

    public static /* synthetic */ void o2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2, String str) {
        nSTIJKPlayerSkyActivity.G2(i2, str);
    }

    private boolean o3(ArrayList arrayList, ArrayList arrayList2) {
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
        } catch (Exception unused) {
            return false;
        }
    }

    public static /* synthetic */ void p2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, String str, int i2, String str2, String str3, String str4, String str5) {
        nSTIJKPlayerSkyActivity.H2(str, i2, str2, str3, str4, str5);
    }

    private ArrayList p3(ArrayList arrayList, ArrayList arrayList2) {
        try {
            this.I0 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        this.I0.add(favouriteDBModel);
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
        return this.I0;
    }

    public static /* synthetic */ void q2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, String str, String str2) {
        nSTIJKPlayerSkyActivity.R3(str, str2);
    }

    private ArrayList q3(ArrayList arrayList, ArrayList arrayList2) {
        this.J0 = new ArrayList();
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
                            this.J0.add(favouriteM3UModel);
                            break;
                        }
                        if (favouriteM3UModel.getCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    }
                }
            }
            return this.J0;
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ void r2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2, String str) {
        nSTIJKPlayerSkyActivity.P3(i2, str);
    }

    private void r3() {
        ProgressBar progressBar = this.w;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView = this.r;
        if (textView != null) {
            textView.setText(this.d.getResources().getString(a7.j.N4));
        }
        TextView textView2 = this.s;
        if (textView2 != null) {
            textView2.setText("");
        }
        TextView textView3 = this.t;
        if (textView3 != null) {
            textView3.setText(this.d.getResources().getString(a7.j.c4));
        }
        TextView textView4 = this.u;
        if (textView4 != null) {
            textView4.setText("");
        }
    }

    public static /* synthetic */ void s2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, String str, int i2, String str2, String str3) {
        nSTIJKPlayerSkyActivity.Q3(str, i2, str2, str3);
    }

    private void s3() {
        if (this.x3.getVisibility() == 0) {
            this.x3.startAnimation(this.i4);
            if (this.k3.getVisibility() == 0) {
                this.k3.startAnimation(this.i4);
            }
            if (this.v3.getVisibility() == 0) {
                this.v3.startAnimation(this.i4);
            }
            if (this.m3.getVisibility() == 0) {
                this.m3.startAnimation(this.i4);
            }
            if (this.w3.getVisibility() == 0) {
                this.w3.startAnimation(this.i4);
            }
            if (this.l3.getVisibility() == 0) {
                this.l3.startAnimation(this.i4);
            }
            this.x3.setVisibility(8);
            if (this.k3.getVisibility() == 0) {
                this.k3.setVisibility(8);
            }
            if (this.v3.getVisibility() == 0) {
                this.v3.setVisibility(8);
            }
            if (this.m3.getVisibility() == 0) {
                this.m3.setVisibility(8);
            }
            if (this.w3.getVisibility() == 0) {
                this.w3.setVisibility(8);
            }
            if (this.l3.getVisibility() == 0) {
                this.l3.setVisibility(8);
            }
        }
    }

    public static /* synthetic */ SharedPreferences t2() {
        return X5;
    }

    private void u1() {
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.V = sharedPreferences;
        String str = "";
        this.I5 = sharedPreferences.getString("username", "");
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        String o0 = m7.w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
        if (this.H5.equalsIgnoreCase("")) {
            str = "UnCategories";
        } else {
            LiveStreamCategoryIdDBModel channelCatNameFromSelectedCatId = this.S.getChannelCatNameFromSelectedCatId(this.H5);
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
            jsonObject.addProperty("username", this.I5);
            jsonObject.addProperty("macaddress", this.J5);
            jsonObject.addProperty("section", this.G5);
            jsonObject.addProperty("section_category", str);
            jsonObject.addProperty("report_title", this.L5);
            jsonObject.addProperty("report_sub_title", this.M5);
            jsonObject.addProperty("report_cases", this.R5);
            jsonObject.addProperty("report_custom_message", this.O5);
            jsonObject.addProperty("stream_name", this.K5);
            jsonObject.addProperty("stream_id", Integer.valueOf(this.B1));
            retrofitPost.clientsReportRequest(jsonObject).enqueue(new w());
        }
    }

    public static /* synthetic */ SharedPreferences u2(SharedPreferences sharedPreferences) {
        X5 = sharedPreferences;
        return sharedPreferences;
    }

    private void u3() {
        LinearLayout linearLayout = this.y;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public static /* synthetic */ o4.e v1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.O2;
    }

    public static /* synthetic */ String v2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.K4;
    }

    private void v3() {
        ProgressBar progressBar = this.x;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public static /* synthetic */ o4.e w1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, o4.e eVar) {
        nSTIJKPlayerSkyActivity.O2 = eVar;
        return eVar;
    }

    public static /* synthetic */ boolean w2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, ArrayList arrayList, ArrayList arrayList2) {
        return nSTIJKPlayerSkyActivity.o3(arrayList, arrayList2);
    }

    public static /* synthetic */ NSTIJKPlayerSky x1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.h2;
    }

    public static /* synthetic */ ArrayList x2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.D0;
    }

    private void x3() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int y1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2) {
        nSTIJKPlayerSkyActivity.k0 = i2;
        return i2;
    }

    public static /* synthetic */ int y2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, int i2) {
        nSTIJKPlayerSkyActivity.U2 = i2;
        return i2;
    }

    private void y3() {
        try {
            this.A = true;
            this.M0.e();
            TextView textView = this.O0;
            if (textView == null || this.B) {
                return;
            }
            textView.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ androidx.appcompat.app.a z1(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
        return nSTIJKPlayerSkyActivity.l2;
    }

    public static /* synthetic */ String z2(NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity, String str) {
        nSTIJKPlayerSkyActivity.V2 = str;
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean z3() {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.z3():boolean");
    }

    public boolean B3() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        if (i2 >= 33) {
            return true;
        }
        if (t7.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        Log.v("TAG", "Permission is revoked");
        D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 101);
        return false;
    }

    public void C3(String str, String str2) {
        this.W2 = str;
        O2();
    }

    public void D0(String str) {
    }

    public void E3() {
        if (this.h2 == null) {
            return;
        }
        U2(0);
        int i2 = Build.VERSION.SDK_INT;
        Rational rational = (this.h2.v1() == 0 || this.h2.u1() == 0) ? new Rational(this.h2.getWidth(), this.h2.getHeight()) : new Rational(this.h2.v1(), this.h2.u1());
        if (i2 >= 26) {
            try {
                try {
                    g3(false);
                    p7.n.a(p7.m.a(this.E4, rational));
                    t7.d.a(this, p7.n.a(this.E4));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                g3(false);
                p7.n.a(p7.m.a(this.E4, new Rational(this.h2.getWidth(), this.h2.getHeight())));
                t7.d.a(this, p7.n.a(this.E4));
            }
        }
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    public void G3() {
        y3();
        this.z2 = false;
        this.A2 = 0;
        AsyncTask asyncTask = this.x2;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            ArrayList arrayList = this.q0;
            if (arrayList != null && arrayList.size() > 0) {
                this.k0 = this.k0 != this.q0.size() + (-1) ? this.k0 + 1 : 0;
                if (this.k0 != 0 || this.v0 == null) {
                    ArrayList arrayList2 = this.q0;
                    if (arrayList2 == null || arrayList2.size() <= 0 || this.k0 >= this.q0.size()) {
                        return;
                    }
                    String liveStreamCategoryID = ((LiveStreamCategoryIdDBModel) this.q0.get(this.k0)).getLiveStreamCategoryID();
                    String liveStreamCategoryName = ((LiveStreamCategoryIdDBModel) this.q0.get(this.k0)).getLiveStreamCategoryName();
                    this.e1 = liveStreamCategoryID;
                    this.f1 = liveStreamCategoryName;
                    if (liveStreamCategoryID != null && !liveStreamCategoryID.equals("") && this.e1.equals("-1")) {
                        Q2();
                        return;
                    }
                    String str = this.e1;
                    if (str == null || str.equals("") || !this.e1.equals("-6")) {
                        M2();
                        return;
                    } else {
                        R2();
                        return;
                    }
                }
                this.e1 = "0";
                this.f1 = this.d.getResources().getString(a7.j.x);
            }
            K2();
        }
    }

    public void H(String str) {
    }

    public final void H2(String str, int i2, String str2, String str3, String str4, String str5) {
        if (this.d == null || this.U == null || this.E1 == null) {
            return;
        }
        FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
        favouriteDBModel.setCategoryID(str);
        favouriteDBModel.setStreamID(i2);
        favouriteDBModel.setStreamIDOneStream(str5);
        favouriteDBModel.setNum(str3);
        favouriteDBModel.setName(str2);
        favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(this.d));
        this.E1.addToFavourite(favouriteDBModel, str4);
        this.U.notifyDataSetChanged();
        m7.w.P0(this.d, str2 + this.d.getResources().getString(a7.j.q));
    }

    public void H3() {
        LinearLayout linearLayout = this.Q3;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.P3;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    public void I3() {
        m7.a.Y = Boolean.TRUE;
        this.C = true;
        this.o.setVisibility(0);
        this.p.setText(this.d.getResources().getString(a7.j.g4));
        this.z1.setVisibility(8);
        if (m7.a.B.booleanValue()) {
            findViewById(a7.f.Sm).setVisibility(8);
        }
    }

    public void K2() {
        Z2();
        this.w2 = new E().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels"});
    }

    public String L2() {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        String string;
        try {
            this.A2 = 0;
            ArrayList arrayList = this.v0;
            if (arrayList != null && this.t0 != null) {
                arrayList.clear();
                this.t0.clear();
            }
            if (this.K4.equals("true")) {
                liveStreamDBHandler = this.S;
                str = "radio_streams";
            } else {
                liveStreamDBHandler = this.S;
                str = "live";
            }
            this.v0 = liveStreamDBHandler.getAllLiveStreasWithCategoryId("0", str);
            ArrayList arrayList2 = this.w0;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.L2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.L2.B();
            ArrayList ePGTesting = B2 ? this.S.getEPGTesting((String) null, format) : null;
            this.Z = getSharedPreferences("currentlyPlayingVideo", 0);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                string = this.Y.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "");
            } else {
                SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api");
                string = this.Y.getString("currentlyPlayingVideo", "");
            }
            ArrayList arrayList3 = this.v0;
            if (arrayList3 == null || arrayList3.size() <= 0) {
                return "all_channels";
            }
            for (int i2 = 0; i2 < this.v0.size(); i2++) {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.v0.get(i2)).getUrl().equals(string)) {
                        this.A2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.v0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.A2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.v0.get(i2)).getStreamId().equals(string)) {
                    this.A2 = i2;
                }
                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.v0.get(i2)).getNum());
                liveStreamsDBModel.setName(((LiveStreamsDBModel) this.v0.get(i2)).getName());
                liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.v0.get(i2)).getStreamType());
                liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.v0.get(i2)).getStreamId());
                liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.v0.get(i2)).getStreamIdOneStream());
                liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.v0.get(i2)).getStreamIcon());
                liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.v0.get(i2)).getEpgChannelId());
                liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.v0.get(i2)).getAdded());
                liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.v0.get(i2)).getCategoryId());
                liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.v0.get(i2)).getCustomSid());
                liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.v0.get(i2)).getTvArchive());
                liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.v0.get(i2)).getDirectSource());
                liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.v0.get(i2)).getTvArchiveDuration());
                liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.v0.get(i2)).getTypeName());
                liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.v0.get(i2)).getCategoryName());
                liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.v0.get(i2)).getSeriesNo());
                liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.v0.get(i2)).getLive());
                liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.v0.get(i2)).getContaiinerExtension());
                liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.v0.get(i2)).getUrl());
                liveStreamsDBModel.setCmd(((LiveStreamsDBModel) this.v0.get(i2)).getCmd());
                if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ePGTesting.size()) {
                            break;
                        }
                        if (((LiveStreamsDBModel) this.v0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                            int M = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                            if (M != 0) {
                                M = 100 - M;
                            }
                            liveStreamsDBModel.setEpgPercentage(M);
                            liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                        } else {
                            i3++;
                        }
                    }
                }
                this.w0.add(liveStreamsDBModel);
            }
            return "all_channels";
        } catch (Exception unused) {
            return "all_channels";
        }
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
    }

    public void M0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public void M2() {
        Z2();
        this.w2 = new E().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels_with_cat"});
    }

    public String N2() {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        String str2;
        try {
            this.A2 = 0;
            ArrayList arrayList = this.v0;
            if (arrayList != null && this.t0 != null) {
                arrayList.clear();
                this.t0.clear();
            }
            if (this.K4.equals("true")) {
                liveStreamDBHandler = this.S;
                str = this.e1;
                str2 = "radio_streams";
            } else {
                liveStreamDBHandler = this.S;
                str = this.e1;
                str2 = "live";
            }
            this.A0 = liveStreamDBHandler.getAllLiveStreasWithCategoryId(str, str2);
            this.v0 = this.A0;
            ArrayList arrayList2 = this.w0;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.L2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.L2.B();
            ArrayList ePGTesting = B2 ? this.S.getEPGTesting((String) null, format) : null;
            this.Z = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.Y.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : this.Y.getString("currentlyPlayingVideo", "");
            ArrayList arrayList3 = this.v0;
            if (arrayList3 == null || arrayList3.size() <= 0) {
                return "all_channels_with_cat";
            }
            for (int i2 = 0; i2 < this.v0.size(); i2++) {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.v0.get(i2)).getUrl().equals(string)) {
                        this.A2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.v0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.A2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.v0.get(i2)).getStreamId().equals(string)) {
                    this.A2 = i2;
                }
                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.v0.get(i2)).getNum());
                liveStreamsDBModel.setName(((LiveStreamsDBModel) this.v0.get(i2)).getName());
                liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.v0.get(i2)).getStreamType());
                liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.v0.get(i2)).getStreamId());
                liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.v0.get(i2)).getStreamIdOneStream());
                liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.v0.get(i2)).getStreamIcon());
                liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.v0.get(i2)).getEpgChannelId());
                liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.v0.get(i2)).getAdded());
                liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.v0.get(i2)).getCategoryId());
                liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.v0.get(i2)).getCustomSid());
                liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.v0.get(i2)).getTvArchive());
                liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.v0.get(i2)).getDirectSource());
                liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.v0.get(i2)).getTvArchiveDuration());
                liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.v0.get(i2)).getTypeName());
                liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.v0.get(i2)).getCategoryName());
                liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.v0.get(i2)).getSeriesNo());
                liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.v0.get(i2)).getLive());
                liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.v0.get(i2)).getContaiinerExtension());
                liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.v0.get(i2)).getUrl());
                liveStreamsDBModel.setCmd(((LiveStreamsDBModel) this.v0.get(i2)).getCmd());
                if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ePGTesting.size()) {
                            break;
                        }
                        if (((LiveStreamsDBModel) this.v0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                            int M = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                            if (M != 0) {
                                M = 100 - M;
                            }
                            liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                            liveStreamsDBModel.setEpgPercentage(M);
                        } else {
                            i3++;
                        }
                    }
                }
                this.w0.add(liveStreamsDBModel);
            }
            return "all_channels_with_cat";
        } catch (Exception unused) {
            return "all_channels_with_cat";
        }
    }

    public void O2() {
        Z2();
        this.w2 = new F().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels_with_cat"});
    }

    public void O3() {
        try {
            NSTIJKPlayerSky nSTIJKPlayerSky = this.h2;
            if (nSTIJKPlayerSky != null) {
                if (nSTIJKPlayerSky.o1()) {
                    this.h2.h1();
                } else {
                    this.h2.H1();
                    this.h2.r1(true);
                    this.h2.E1();
                }
                IjkMediaPlayer.native_profileEnd();
            }
        } catch (Exception unused) {
        }
    }

    public void P(String str) {
        try {
            this.z1.setVisibility(8);
            TextView textView = this.M3;
            if (textView != null) {
                textView.setText("");
            }
            TextView textView2 = this.N3;
            if (textView2 != null) {
                textView2.setText("");
            }
            r3();
        } catch (Exception unused) {
        }
    }

    public void P0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public String P2() {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        String str2;
        try {
            this.r4 = 0;
            ArrayList arrayList = this.x0;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (this.K4.equals("true")) {
                liveStreamDBHandler = this.S;
                str = this.W2;
                str2 = "radio_streams";
            } else {
                liveStreamDBHandler = this.S;
                str = this.W2;
                str2 = "live";
            }
            this.x0 = liveStreamDBHandler.getAllLiveStreasWithCategoryId(str, str2);
            ArrayList arrayList2 = this.y0;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.L2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.L2.B();
            ArrayList ePGTesting = B2 ? this.S.getEPGTesting((String) null, format) : null;
            this.Z = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.Y.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api") ? this.Y : this.Y).getString("currentlyPlayingVideo", "");
            ArrayList arrayList3 = this.x0;
            if (arrayList3 != null && arrayList3.size() > 0) {
                for (int i2 = 0; i2 < this.x0.size(); i2++) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                        if (((LiveStreamsDBModel) this.x0.get(i2)).getUrl().equals(string)) {
                            this.r4 = i2;
                        }
                    } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                        if (((LiveStreamsDBModel) this.v0.get(i2)).getStreamIdOneStream().equals(string)) {
                            this.A2 = i2;
                        }
                    } else if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamId().equals(string)) {
                        this.r4 = i2;
                    }
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.x0.get(i2)).getNum());
                    liveStreamsDBModel.setName(((LiveStreamsDBModel) this.x0.get(i2)).getName());
                    liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.x0.get(i2)).getStreamType());
                    liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.x0.get(i2)).getStreamId());
                    liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.x0.get(i2)).getStreamIdOneStream());
                    liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.x0.get(i2)).getStreamIcon());
                    liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.x0.get(i2)).getEpgChannelId());
                    liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.x0.get(i2)).getAdded());
                    liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.x0.get(i2)).getCategoryId());
                    liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.x0.get(i2)).getCustomSid());
                    liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.x0.get(i2)).getTvArchive());
                    liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.x0.get(i2)).getDirectSource());
                    liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.x0.get(i2)).getTvArchiveDuration());
                    liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.x0.get(i2)).getTypeName());
                    liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.x0.get(i2)).getCategoryName());
                    liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.x0.get(i2)).getSeriesNo());
                    liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.x0.get(i2)).getLive());
                    liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.x0.get(i2)).getContaiinerExtension());
                    liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.x0.get(i2)).getUrl());
                    liveStreamsDBModel.setCmd(((LiveStreamsDBModel) this.x0.get(i2)).getCmd());
                    if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ePGTesting.size()) {
                                break;
                            }
                            if (((LiveStreamsDBModel) this.x0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                                int M = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                                if (M != 0) {
                                    M = 100 - M;
                                }
                                liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                                liveStreamsDBModel.setEpgPercentage(M);
                            } else {
                                i3++;
                            }
                        }
                    }
                    this.y0.add(liveStreamsDBModel);
                }
            }
            this.x0 = this.y0;
            return "all_channels_with_cat";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "all_channels_with_cat";
        }
    }

    public void Q2() {
        Z2();
        this.w2 = new E().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"get_fav"});
    }

    public final void Q3(String str, int i2, String str2, String str3) {
        DatabaseHandler databaseHandler;
        Context context = this.d;
        if (context == null || this.U == null || (databaseHandler = this.E1) == null) {
            return;
        }
        databaseHandler.deleteFavourite(i2, str, str3, str2, SharepreferenceDBHandler.getUserID(context), this.E);
        this.U.notifyDataSetChanged();
        m7.w.P0(this.d, str2 + this.d.getResources().getString(a7.j.c6));
    }

    public void R2() {
        Z2();
        this.w2 = new E().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"recently_watched"});
    }

    public String S2() {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        String string;
        try {
            this.A2 = 0;
            ArrayList arrayList = this.x0;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList arrayList2 = this.v0;
            if (arrayList2 != null && this.t0 != null) {
                arrayList2.clear();
                this.t0.clear();
            }
            ArrayList arrayList3 = this.A0;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            if (this.K4.equalsIgnoreCase("true")) {
                liveStreamDBHandler = this.S;
                str = "radio_streams";
            } else {
                liveStreamDBHandler = this.S;
                str = "live";
            }
            this.A0 = liveStreamDBHandler.getAllRecentlyWatchedLiveStreams(str);
            this.v0 = this.A0;
            ArrayList arrayList4 = this.w0;
            if (arrayList4 != null) {
                arrayList4.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.L2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.L2.B();
            ArrayList ePGTesting = B2 ? this.S.getEPGTesting((String) null, format) : null;
            this.Z = getSharedPreferences("currentlyPlayingVideo", 0);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                string = this.Y.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "");
            } else {
                SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api");
                string = this.Y.getString("currentlyPlayingVideo", "");
            }
            ArrayList arrayList5 = this.v0;
            if (arrayList5 == null || arrayList5.size() <= 0) {
                return "all_channels_with_cat";
            }
            for (int i2 = 0; i2 < this.v0.size(); i2++) {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.v0.get(i2)).getUrl().equals(string)) {
                        this.A2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.v0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.A2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.v0.get(i2)).getStreamId().equals(string)) {
                    this.A2 = i2;
                }
                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.v0.get(i2)).getNum());
                liveStreamsDBModel.setName(((LiveStreamsDBModel) this.v0.get(i2)).getName());
                liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.v0.get(i2)).getStreamType());
                liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.v0.get(i2)).getStreamId());
                liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.v0.get(i2)).getStreamIdOneStream());
                liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.v0.get(i2)).getStreamIcon());
                liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.v0.get(i2)).getEpgChannelId());
                liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.v0.get(i2)).getAdded());
                liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.v0.get(i2)).getCategoryId());
                liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.v0.get(i2)).getCustomSid());
                liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.v0.get(i2)).getTvArchive());
                liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.v0.get(i2)).getDirectSource());
                liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.v0.get(i2)).getTvArchiveDuration());
                liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.v0.get(i2)).getTypeName());
                liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.v0.get(i2)).getCategoryName());
                liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.v0.get(i2)).getSeriesNo());
                liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.v0.get(i2)).getLive());
                liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.v0.get(i2)).getContaiinerExtension());
                liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.v0.get(i2)).getUrl());
                liveStreamsDBModel.setCmd(((LiveStreamsDBModel) this.v0.get(i2)).getCmd());
                if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ePGTesting.size()) {
                            break;
                        }
                        if (((LiveStreamsDBModel) this.v0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                            int M = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                            if (M != 0) {
                                M = 100 - M;
                            }
                            liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                            liveStreamsDBModel.setEpgPercentage(M);
                        } else {
                            i3++;
                        }
                    }
                }
                this.w0.add(liveStreamsDBModel);
            }
            this.x0 = this.w0;
            return "all_channels_with_cat";
        } catch (Exception unused) {
            return "all_channels_with_cat";
        }
    }

    public void S3(ArrayList arrayList) {
        TextView textView;
        try {
            this.M = arrayList;
            if (arrayList != null) {
                this.B = false;
                this.O0.setVisibility(8);
                if (arrayList.size() == 0) {
                    if (this.z2) {
                        TextView textView2 = this.O0;
                        if (textView2 != null) {
                            this.B = true;
                            textView2.setFocusable(true);
                            this.O0.requestFocus();
                            textView = this.O0;
                            textView.setVisibility(0);
                        }
                    } else {
                        this.z2 = true;
                        ArrayList arrayList2 = this.v0;
                        if (arrayList2 != null && this.t0 != null) {
                            arrayList2.clear();
                            this.t0.clear();
                        }
                        this.v0 = this.K4.equals("true") ? this.S.getAllLiveStreasWithCategoryId(this.e1, "radio_streams") : this.S.getAllLiveStreasWithCategoryId(this.e1, "live");
                        ArrayList arrayList3 = this.v0;
                        if (arrayList3 == null || arrayList3.size() <= 0) {
                            TextView textView3 = this.O0;
                            if (textView3 != null) {
                                this.B = true;
                                textView3.setFocusable(true);
                                this.O0.requestFocus();
                                textView = this.O0;
                                textView.setVisibility(0);
                            }
                        } else {
                            S3(this.v0);
                        }
                    }
                }
                Log.e("honey", "if part");
            } else {
                arrayList = this.L;
            }
            V3(arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void T0(StalkerDeletePlayerLinkCallback stalkerDeletePlayerLinkCallback) {
    }

    public void T3(ArrayList arrayList) {
        try {
            this.N = arrayList;
            if (arrayList == null || arrayList.size() <= 0) {
                LinearLayout linearLayout = this.P0;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                ListView listView = this.K;
                if (listView != null) {
                    listView.setVisibility(8);
                    return;
                }
                return;
            }
            ListView listView2 = this.K;
            if (listView2 != null) {
                listView2.setVisibility(0);
            }
            this.B = false;
            O o2 = new O(this, arrayList);
            this.n4 = o2;
            ListView listView3 = this.K;
            if (listView3 != null) {
                listView3.setAdapter(o2);
                this.K.setSelection(this.r4);
                this.K.setOnItemClickListener(new d());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    public void U2(int i2) {
        if (c6) {
            return;
        }
        this.h2.a1 = new m();
        NSTIJKPlayerSky nSTIJKPlayerSky = this.h2;
        nSTIJKPlayerSky.Z0.postDelayed(nSTIJKPlayerSky.a1, i2);
    }

    public void U3(String str) {
        TextView textView = this.L3;
        if (textView != null) {
            textView.setText(str);
            this.L3.setSelected(true);
        }
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public void V2() {
        y3();
        this.z2 = false;
        this.A2 = 0;
        AsyncTask asyncTask = this.x2;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            ArrayList arrayList = this.q0;
            if (arrayList != null && arrayList.size() > 0) {
                int i2 = this.k0;
                if (i2 == 0) {
                    i2 = this.q0.size();
                }
                this.k0 = i2 - 1;
                if (this.k0 != 0 || this.v0 == null) {
                    ArrayList arrayList2 = this.q0;
                    if (arrayList2 == null || arrayList2.size() <= 0 || this.k0 >= this.q0.size()) {
                        return;
                    }
                    String liveStreamCategoryID = ((LiveStreamCategoryIdDBModel) this.q0.get(this.k0)).getLiveStreamCategoryID();
                    String liveStreamCategoryName = ((LiveStreamCategoryIdDBModel) this.q0.get(this.k0)).getLiveStreamCategoryName();
                    this.e1 = liveStreamCategoryID;
                    this.f1 = liveStreamCategoryName;
                    if (liveStreamCategoryID != null && !liveStreamCategoryID.equals("") && this.e1.equals("-1")) {
                        Q2();
                        return;
                    }
                    String str = this.e1;
                    if (str == null || str.equals("") || !this.e1.equals("-6")) {
                        M2();
                        return;
                    } else {
                        R2();
                        return;
                    }
                }
                if (this.e1.equals("0")) {
                    return;
                }
                this.e1 = "0";
                this.f1 = this.d.getResources().getString(a7.j.x);
            }
            K2();
        }
    }

    public final void V3(ArrayList arrayList) {
        T t2 = this.U;
        if (t2 != null) {
            t2.f(arrayList);
            return;
        }
        T t3 = new T(this, arrayList, this.K4);
        this.U = t3;
        t3.g(this.O0);
        ListView listView = this.J;
        if (listView != null) {
            listView.setAdapter(this.U);
            int i2 = this.A2;
            if (i2 != 0) {
                this.J.setSelection(i2);
            }
            if (this.X2.booleanValue()) {
                this.J.requestFocus();
                this.X2 = Boolean.FALSE;
            }
            this.J.setOnItemSelectedListener(new e());
            this.J.setOnItemClickListener(new f());
            this.J.setOnItemLongClickListener(new g());
        }
    }

    public String W2(String str) {
        ArrayList arrayList = this.q0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = this.q0.iterator();
            while (it.hasNext()) {
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) it.next();
                if (liveStreamCategoryIdDBModel.getLiveStreamCategoryID() != null && !liveStreamCategoryIdDBModel.getLiveStreamCategoryID().isEmpty() && liveStreamCategoryIdDBModel.getLiveStreamCategoryID().equalsIgnoreCase(str)) {
                    this.f1 = liveStreamCategoryIdDBModel.getLiveStreamCategoryName();
                }
            }
        }
        return this.f1;
    }

    public void X(StalkerShortEPGCallback stalkerShortEPGCallback) {
        if (stalkerShortEPGCallback != null && stalkerShortEPGCallback.getJs() != null && stalkerShortEPGCallback.getJs().size() > 0) {
            HashMap hashMap = new HashMap();
            try {
                hashMap = Z3(stalkerShortEPGCallback);
            } catch (Exception unused) {
            }
            d3(hashMap);
            return;
        }
        try {
            this.z1.setVisibility(8);
            TextView textView = this.M3;
            if (textView != null) {
                textView.setText("");
            }
            TextView textView2 = this.N3;
            if (textView2 != null) {
                textView2.setText("");
            }
            r3();
        } catch (Exception unused2) {
        }
    }

    public void X2(int i2, String str, String str2, boolean z2) {
        RecyclerView recyclerView;
        if (!z2 || (recyclerView = this.O3) == null) {
            return;
        }
        recyclerView.m1(i2);
    }

    public void Y2() {
        this.P5 = new ArrayList();
        this.Q5 = new JsonArray();
        if (this.Z4.isChecked()) {
            this.P5.add(this.Z4.getText().toString());
            this.Q5.add(this.Z4.getText().toString());
        }
        if (this.a5.isChecked()) {
            this.P5.add(this.a5.getText().toString());
            this.Q5.add(this.a5.getText().toString());
        }
        if (this.b5.isChecked()) {
            this.P5.add(this.b5.getText().toString());
            this.Q5.add(this.b5.getText().toString());
        }
        if (this.c5.isChecked()) {
            this.P5.add(this.c5.getText().toString());
            this.Q5.add(this.c5.getText().toString());
        }
        if (this.d5.isChecked()) {
            this.P5.add(this.d5.getText().toString());
            this.Q5.add(this.d5.getText().toString());
        }
        if (this.V4.isChecked()) {
            this.P5.add(this.V4.getText().toString());
            this.Q5.add(this.V4.getText().toString());
        }
        if (this.W4.isChecked()) {
            this.P5.add(this.W4.getText().toString());
            this.Q5.add(this.W4.getText().toString());
        }
        if (this.X4.isChecked()) {
            this.P5.add(this.X4.getText().toString());
            this.Q5.add(this.X4.getText().toString());
        }
        if (this.Y4.isChecked()) {
            this.P5.add(this.Y4.getText().toString());
            this.Q5.add(this.Y4.getText().toString());
        }
        if (this.f5.isChecked()) {
            this.P5.add(this.f5.getText().toString());
            this.Q5.add(this.f5.getText().toString());
        }
        if (this.g5.isChecked()) {
            this.P5.add(this.g5.getText().toString());
            this.Q5.add(this.g5.getText().toString());
        }
        if (this.h5.isChecked()) {
            this.P5.add(this.h5.getText().toString());
            this.Q5.add(this.h5.getText().toString());
        }
        if (this.i5.isChecked()) {
            this.P5.add(this.i5.getText().toString());
            this.Q5.add(this.i5.getText().toString());
        }
        this.R5 = new Gson().toJson(this.Q5);
        Log.e("TAG", this.Q5 + "");
    }

    public void a4() {
        if (c6 || this.x3.getVisibility() != 8) {
            return;
        }
        this.x3.startAnimation(this.h4);
        this.x3.setVisibility(0);
    }

    public void b4() {
        if (c6 || this.x3.getVisibility() != 8) {
            return;
        }
        this.x3.startAnimation(this.h4);
        this.x3.setVisibility(0);
        if (this.k3.getVisibility() == 8) {
            this.k3.startAnimation(this.h4);
            this.k3.setVisibility(0);
        }
        if (this.v3.getVisibility() == 8) {
            this.v3.startAnimation(this.h4);
            this.v3.setVisibility(0);
        }
        if (this.m3.getVisibility() == 8) {
            this.m3.startAnimation(this.h4);
            this.m3.setVisibility(0);
        }
        if (this.w3.getVisibility() == 8) {
            this.w3.startAnimation(this.h4);
            this.w3.setVisibility(0);
        }
        if (this.l3.getVisibility() == 8) {
            this.l3.startAnimation(this.h4);
            this.l3.setVisibility(0);
        }
    }

    public void c(String str) {
    }

    public void c3() {
        runOnUiThread(new c());
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2) {
        Context context;
        StringBuilder sb;
        try {
            m7.w.X();
            if (this.U == null || stalkerSetLiveFavCallback == null || stalkerSetLiveFavCallback.getJs() == null || !stalkerSetLiveFavCallback.getJs().equals(Boolean.TRUE)) {
                return;
            }
            this.B4 = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
            if (str.equals("added")) {
                int i2 = this.D4;
                if (i2 != 0) {
                    this.B4.add(Integer.valueOf(i2));
                }
                StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(this.B4);
                this.U.notifyDataSetChanged();
                context = this.d;
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.d.getResources().getString(a7.j.q));
            } else {
                int i3 = this.D4;
                if (i3 != 0) {
                    this.B4.remove(Integer.valueOf(i3));
                    StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(this.B4);
                }
                this.U.notifyDataSetChanged();
                context = this.d;
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.d.getResources().getString(a7.j.c6));
            }
            m7.w.P0(context, sb.toString());
        } catch (Exception unused) {
        }
    }

    /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
        LL1ili1iI1iI.IIiLliI1l1li1: Can't find top splitter block for handler:B:259:0x0113
        	at ILlL1lil1i1i.LLll11I1I1lL.llLliLLIll1lI(Unknown Source:36)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(Unknown Source:67)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(Unknown Source:9)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:40)
        */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131 A[Catch: Exception -> 0x034d, TryCatch #3 {Exception -> 0x034d, blocks: (B:3:0x0008, B:6:0x0016, B:8:0x001e, B:10:0x0024, B:12:0x0032, B:14:0x0038, B:16:0x0040, B:18:0x0046, B:20:0x004a, B:21:0x004d, B:23:0x0053, B:25:0x0057, B:27:0x005f, B:29:0x0065, B:30:0x0075, B:53:0x012b, B:55:0x0131, B:57:0x0139, B:85:0x01cd, B:87:0x01d1, B:88:0x01d4, B:90:0x01d8, B:111:0x0245, B:113:0x0249, B:114:0x024c, B:116:0x0250, B:138:0x02be, B:140:0x02c2, B:141:0x02c5, B:143:0x02c9, B:168:0x033b, B:170:0x033f, B:171:0x0342, B:173:0x0346, B:181:0x0334, B:183:0x0338, B:188:0x030f, B:190:0x0313, B:195:0x02ea, B:197:0x02ee, B:202:0x02b7, B:204:0x02bb, B:208:0x0294, B:210:0x0298, B:215:0x0270, B:217:0x0274, B:222:0x023e, B:224:0x0242, B:228:0x021a, B:230:0x021e, B:234:0x01f7, B:236:0x01fb, B:241:0x01c6, B:243:0x01ca, B:247:0x01a2, B:249:0x01a6, B:253:0x016d, B:255:0x0171, B:256:0x034a, B:259:0x0113, B:263:0x00ea, B:265:0x00c4, B:267:0x009b, B:268:0x0119, B:269:0x011f, B:270:0x0125, B:119:0x0254, B:121:0x025a, B:123:0x025e, B:212:0x0268, B:214:0x026c, B:154:0x02f3, B:156:0x02f9, B:158:0x02fd, B:185:0x0307, B:187:0x030b, B:60:0x013f, B:62:0x0145, B:64:0x0149, B:65:0x0152, B:67:0x0156, B:250:0x0165, B:252:0x0169, B:146:0x02ce, B:148:0x02d4, B:150:0x02d8, B:192:0x02e2, B:194:0x02e6, B:42:0x00c9, B:44:0x00cf, B:45:0x00d7, B:262:0x00db, B:133:0x029b, B:135:0x02a1, B:137:0x02a5, B:198:0x02af, B:200:0x02b3, B:92:0x01db, B:94:0x01e1, B:96:0x01e5, B:231:0x01ef, B:233:0x01f3, B:162:0x0318, B:164:0x031e, B:166:0x0322, B:178:0x032c, B:180:0x0330, B:127:0x0278, B:129:0x027e, B:131:0x0282, B:205:0x028c, B:207:0x0290, B:48:0x00fb, B:50:0x0101, B:260:0x010d, B:105:0x0222, B:107:0x0228, B:109:0x022c, B:219:0x0236, B:221:0x023a, B:32:0x007a, B:34:0x0080, B:35:0x0088, B:266:0x008c, B:98:0x01fe, B:100:0x0204, B:102:0x0208, B:225:0x0212, B:227:0x0216, B:79:0x01aa, B:81:0x01b0, B:83:0x01b4, B:238:0x01be, B:240:0x01c2, B:38:0x00ac, B:40:0x00b2, B:264:0x00be, B:69:0x0174, B:71:0x017a, B:73:0x017e, B:74:0x0187, B:76:0x018b, B:244:0x019a, B:246:0x019e), top: B:2:0x0008, inners: #0, #1, #2, #4, #5, #6, #7, #8, #9, #10, #11, #12, #13, #14, #15, #16 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:207:0x0296 -> B:131:0x029b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:208:0x0298 -> B:131:0x029b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d3(java.util.HashMap r12) {
        /*
            Method dump skipped, instructions count: 846
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.d3(java.util.HashMap):void");
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
        try {
            D3();
            LinearLayout linearLayout = this.t1;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.v1;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            LinearLayout linearLayout3 = this.w1;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            LinearLayout linearLayout4 = this.x1;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            LinearLayout linearLayout5 = this.y1;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            LinearLayout linearLayout6 = this.z1;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
        } catch (Exception unused) {
        }
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void g3(boolean z2) {
        String livePlayerAppName;
        String str;
        Intent intent;
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        Y5 = z2;
        String livePlayerAppName2 = SharepreferenceDBHandler.getLivePlayerAppName(this.d);
        if (!SharepreferenceDBHandler.getLivePlayerPkgName(this.d).equals("default") && !new ExternalPlayerDataBase(this.d).CheckPlayerExistense(livePlayerAppName2)) {
            SharepreferenceDBHandler.setLivePlayer("default", "default", this.d);
        }
        String livePlayerPkgName = SharepreferenceDBHandler.getLivePlayerPkgName(this.d);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api") || !z2 || livePlayerPkgName == null || livePlayerPkgName.equalsIgnoreCase("default")) {
            if (m7.a.Y.booleanValue()) {
                Toolbar toolbar = this.M0;
                if (toolbar != null) {
                    toolbar.setVisibility(8);
                }
                findViewById(a7.f.p).setOnClickListener((View.OnClickListener) null);
                this.Y0.setVisibility(8);
                this.Z0.setVisibility(8);
                this.a1.setVisibility(8);
                this.b1.setVisibility(8);
                this.c1.setVisibility(8);
                getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
                LinearLayout.LayoutParams layoutParams = this.d1.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.d1.setLayoutParams(layoutParams);
                getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
                this.W0.setVisibility(8);
                NSTIJKPlayerSky nSTIJKPlayerSky = this.h2;
                ((nSTIJKPlayerSky == null || !nSTIJKPlayerSky.isPlaying()) ? this.f : this.g).requestFocus();
                return;
            }
            return;
        }
        O3();
        this.B2 = true;
        SharedPreferences sharedPreferences = getSharedPreferences("currentlyPlayingVideoPosition", 0);
        this.Z = sharedPreferences;
        int i2 = sharedPreferences.getInt("currentlyPlayingVideoPosition", 0);
        ArrayList e2 = this.U.e();
        this.T1 = i2;
        if (e2 == null || e2.size() <= 0 || this.T1 >= e2.size()) {
            ArrayList arrayList = this.v0;
            if (arrayList != null && arrayList.size() > 0 && this.T1 < this.v0.size()) {
                this.q2 = m7.w.r0(((LiveStreamsDBModel) this.v0.get(this.T1)).getStreamId());
                this.r2 = ((LiveStreamsDBModel) this.v0.get(this.T1)).getStreamIdOneStream();
                this.f2 = ((LiveStreamsDBModel) this.v0.get(this.T1)).getUrl();
                ((LiveStreamsDBModel) this.v0.get(this.T1)).getName();
            }
        } else {
            this.q2 = m7.w.r0(((LiveStreamsDBModel) e2.get(this.T1)).getStreamId());
            this.r2 = ((LiveStreamsDBModel) e2.get(this.T1)).getStreamIdOneStream();
            this.f2 = ((LiveStreamsDBModel) e2.get(this.T1)).getUrl();
        }
        this.D = this.q2;
        this.E = this.r2;
        this.F = this.f2;
        Y5 = false;
        NSTIJKPlayerSky nSTIJKPlayerSky2 = this.h2;
        if (nSTIJKPlayerSky2 != null) {
            nSTIJKPlayerSky2.i1(Boolean.FALSE);
        }
        if (this.e2.equals("m3u")) {
            if (!this.n2.booleanValue()) {
                return;
            }
            livePlayerAppName = SharepreferenceDBHandler.getLivePlayerAppName(this.d);
            intent = new Intent(this.d, PlayExternalPlayerActivity.class);
            str = this.F;
        } else {
            if (!this.e2.equals("onestream_api")) {
                if (this.q2 == -1 || !this.n2.booleanValue()) {
                    return;
                }
                String V = m7.w.V(this.d, this.q2, this.i0, "live");
                String livePlayerAppName3 = SharepreferenceDBHandler.getLivePlayerAppName(this.d);
                Intent intent2 = new Intent(this.d, PlayExternalPlayerActivity.class);
                intent2.putExtra("url", V);
                intent2.putExtra("packagename", livePlayerPkgName);
                intent2.putExtra("app_name", livePlayerAppName3);
                this.d.startActivity(intent2);
                return;
            }
            livePlayerAppName = SharepreferenceDBHandler.getLivePlayerAppName(this.d);
            try {
                jSONObject = new JSONObject(this.Q);
                String str6 = this.i0;
                str2 = "m3u8";
                str3 = "ts";
                if (str6 == null || str6.isEmpty() || !this.i0.equals(".ts")) {
                    str = "";
                    str4 = str;
                } else {
                    Iterator keys = jSONObject.keys();
                    while (true) {
                        if (!keys.hasNext()) {
                            str4 = "";
                            break;
                        } else if (((String) keys.next()).equals("ts")) {
                            str4 = "ts";
                            break;
                        }
                    }
                    if (str4.equals("")) {
                        while (true) {
                            if (!keys.hasNext()) {
                                break;
                            } else if (((String) keys.next()).equals("m3u8")) {
                                str4 = "m3u8";
                                break;
                            }
                        }
                    }
                    str = jSONObject.getString(str4);
                }
            } catch (Exception unused) {
            }
            try {
                String str7 = this.i0;
                if (str7 != null && !str7.isEmpty() && this.i0.equals(".m3u8")) {
                    Iterator keys2 = jSONObject.keys();
                    while (true) {
                        if (!keys2.hasNext()) {
                            str2 = str4;
                            break;
                        } else if (((String) keys2.next()).equals("m3u8")) {
                            break;
                        }
                    }
                    if (str2.equals("")) {
                        while (keys2.hasNext()) {
                            if (((String) keys2.next()).equals("ts")) {
                                break;
                            }
                        }
                        str3 = str2;
                        str = jSONObject.getString(str3);
                    } else {
                        str3 = str2;
                        str = jSONObject.getString(str3);
                    }
                }
            } catch (Exception unused2) {
                str5 = str;
                str = str5;
                intent = new Intent(this.d, PlayExternalPlayerActivity.class);
                intent.putExtra("url", str);
                intent.putExtra("packagename", livePlayerPkgName);
                intent.putExtra("app_name", livePlayerAppName);
                this.d.startActivity(intent);
            }
            intent = new Intent(this.d, PlayExternalPlayerActivity.class);
        }
        intent.putExtra("url", str);
        intent.putExtra("packagename", livePlayerPkgName);
        intent.putExtra("app_name", livePlayerAppName);
        this.d.startActivity(intent);
    }

    public void h4() {
        Handler handler;
        if (c6 || (handler = this.h2.Z0) == null) {
            return;
        }
        handler.removeCallbacksAndMessages((Object) null);
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void i3() {
        ArrayList arrayList;
        String categoryID;
        String valueOf;
        String timestamp;
        String str;
        try {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                new ArrayList();
                LiveStreamDBHandler liveStreamDBHandler = this.S;
                if (liveStreamDBHandler == null) {
                    return;
                }
                ArrayList favouriteM3U = liveStreamDBHandler.getFavouriteM3U("live");
                arrayList = new ArrayList();
                ArrayList arrayList2 = this.D0;
                if (arrayList2 != null && arrayList2.size() > 0 && favouriteM3U != null && favouriteM3U.size() > 0) {
                    favouriteM3U = q3(favouriteM3U, this.D0);
                }
                if (favouriteM3U == null || favouriteM3U.size() <= 0) {
                    return;
                }
                Iterator it = favouriteM3U.iterator();
                while (it.hasNext()) {
                    FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                    ArrayList m3UFavouriteRow = this.S.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
                    if (m3UFavouriteRow != null && m3UFavouriteRow.size() > 0) {
                        arrayList.add((LiveStreamsDBModel) m3UFavouriteRow.get(0));
                    }
                }
                if (arrayList.size() == 0) {
                    return;
                }
            } else {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                    List<Integer> favIdsList = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
                    String str2 = "";
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
                        str2 = sb.toString();
                    }
                    this.L.clear();
                    this.L = this.S.getLiveFavStalker(str2);
                    return;
                }
                new ArrayList();
                if (this.E1 == null) {
                    return;
                }
                ArrayList allFavourites = this.K4.equals("true") ? this.E1.getAllFavourites("radio_streams", SharepreferenceDBHandler.getUserID(this.d)) : this.E1.getAllFavourites("live", SharepreferenceDBHandler.getUserID(this.d));
                arrayList = new ArrayList();
                ArrayList arrayList3 = this.D0;
                if (arrayList3 != null && arrayList3.size() > 0 && allFavourites != null && allFavourites.size() > 0) {
                    allFavourites = p3(allFavourites, this.D0);
                }
                if (allFavourites == null || allFavourites.size() <= 0) {
                    return;
                }
                Iterator it2 = allFavourites.iterator();
                while (it2.hasNext()) {
                    FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it2.next();
                    LiveStreamDBHandler liveStreamDBHandler2 = new LiveStreamDBHandler(this.d);
                    if (this.e2.equals("onestream_api")) {
                        categoryID = favouriteDBModel.getCategoryID();
                        valueOf = String.valueOf(favouriteDBModel.getStreamIDOneStream());
                        timestamp = favouriteDBModel.getTimestamp();
                        str = this.L4;
                    } else {
                        categoryID = favouriteDBModel.getCategoryID();
                        valueOf = String.valueOf(favouriteDBModel.getStreamID());
                        timestamp = favouriteDBModel.getTimestamp();
                        str = this.L4;
                    }
                    LiveStreamsDBModel liveStreamFavouriteRow = liveStreamDBHandler2.getLiveStreamFavouriteRow(categoryID, valueOf, timestamp, str);
                    if (liveStreamFavouriteRow != null) {
                        arrayList.add(liveStreamFavouriteRow);
                    }
                }
                if (arrayList.size() == 0) {
                    return;
                }
            }
            this.L = arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x002d A[Catch: Exception -> 0x0041, TryCatch #1 {Exception -> 0x0041, blocks: (B:19:0x0003, B:21:0x000b, B:23:0x000f, B:3:0x002d, B:5:0x0031), top: B:18:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i4(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L2d
            java.lang.String r1 = ""
            boolean r1 = r4.equals(r1)     // Catch: java.lang.Exception -> L41
            if (r1 != 0) goto L2d
            android.widget.ImageView r1 = r3.q     // Catch: java.lang.Exception -> L41
            if (r1 == 0) goto L54
            android.content.Context r1 = r3.d     // Catch: java.lang.Exception -> L41
            com.squareup.picasso.t r1 = com.squareup.picasso.t.q(r1)     // Catch: java.lang.Exception -> L41
            com.squareup.picasso.x r4 = r1.l(r4)     // Catch: java.lang.Exception -> L41
            r1 = 80
            r2 = 55
            com.squareup.picasso.x r4 = r4.k(r1, r2)     // Catch: java.lang.Exception -> L41
            int r1 = a7.e.i1     // Catch: java.lang.Exception -> L41
            com.squareup.picasso.x r4 = r4.j(r1)     // Catch: java.lang.Exception -> L41
            android.widget.ImageView r1 = r3.q     // Catch: java.lang.Exception -> L41
            r4.g(r1)     // Catch: java.lang.Exception -> L41
            goto L54
        L2d:
            android.widget.ImageView r4 = r3.q     // Catch: java.lang.Exception -> L41
            if (r4 == 0) goto L54
            android.content.Context r1 = r3.d     // Catch: java.lang.Exception -> L41
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Exception -> L41
            int r2 = a7.e.i1     // Catch: java.lang.Exception -> L41
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2, r0)     // Catch: java.lang.Exception -> L41
            r4.setImageDrawable(r1)     // Catch: java.lang.Exception -> L41
            goto L54
        L41:
            android.widget.ImageView r4 = r3.q     // Catch: java.lang.Exception -> L54
            if (r4 == 0) goto L54
            android.content.Context r1 = r3.d     // Catch: java.lang.Exception -> L54
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Exception -> L54
            int r2 = a7.e.i1     // Catch: java.lang.Exception -> L54
            android.graphics.drawable.Drawable r0 = r1.getDrawable(r2, r0)     // Catch: java.lang.Exception -> L54
            r4.setImageDrawable(r0)     // Catch: java.lang.Exception -> L54
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity.i4(java.lang.String):void");
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public String j3() {
        AsyncTask asyncTask;
        try {
            this.A2 = 0;
            ArrayList arrayList = this.v0;
            if (arrayList != null && this.t0 != null) {
                arrayList.clear();
                this.t0.clear();
            }
            ArrayList arrayList2 = this.L;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.L.clear();
            }
            i3();
            ArrayList arrayList3 = this.x0;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            this.v0 = this.L;
            ArrayList arrayList4 = this.w0;
            if (arrayList4 != null) {
                arrayList4.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.L2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.L2.B();
            ArrayList ePGTesting = B2 ? this.S.getEPGTesting((String) null, format) : null;
            this.Z = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.Y.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api") ? this.Y : this.Y).getString("currentlyPlayingVideo", "");
            ArrayList arrayList5 = this.v0;
            if (arrayList5 == null || arrayList5.size() <= 0) {
                this.x0 = this.v0;
                return "get_fav";
            }
            for (int i2 = 0; i2 < this.v0.size(); i2++) {
                AsyncTask asyncTask2 = this.w2;
                if (asyncTask2 != null && asyncTask2.isCancelled()) {
                    return "get_fav";
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.v0.get(i2)).getUrl().equals(string)) {
                        this.A2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.v0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.A2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.v0.get(i2)).getStreamId().equals(string)) {
                    this.A2 = i2;
                }
                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.v0.get(i2)).getNum());
                liveStreamsDBModel.setName(((LiveStreamsDBModel) this.v0.get(i2)).getName());
                liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.v0.get(i2)).getStreamType());
                liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.v0.get(i2)).getStreamId());
                liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.v0.get(i2)).getStreamIdOneStream());
                liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.v0.get(i2)).getStreamIcon());
                liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.v0.get(i2)).getEpgChannelId());
                liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.v0.get(i2)).getAdded());
                liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.v0.get(i2)).getCategoryId());
                liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.v0.get(i2)).getCustomSid());
                liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.v0.get(i2)).getTvArchive());
                liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.v0.get(i2)).getDirectSource());
                liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.v0.get(i2)).getTvArchiveDuration());
                liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.v0.get(i2)).getTypeName());
                liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.v0.get(i2)).getCategoryName());
                liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.v0.get(i2)).getSeriesNo());
                liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.v0.get(i2)).getLive());
                liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.v0.get(i2)).getContaiinerExtension());
                liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.v0.get(i2)).getUrl());
                if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < ePGTesting.size() && ((asyncTask = this.w2) == null || !asyncTask.isCancelled())) {
                            if (((LiveStreamsDBModel) this.v0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                                int M = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                                if (M != 0) {
                                    M = 100 - M;
                                }
                                liveStreamsDBModel.setEpgPercentage(M);
                                liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                this.w0.add(liveStreamsDBModel);
                this.x0 = this.w0;
            }
            return "get_fav";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_fav";
        }
    }

    public void j4(String str, String str2, LiveStreamDBHandler liveStreamDBHandler, Context context, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, String str3) {
        this.S = liveStreamDBHandler;
        this.d = context;
        this.w = progressBar;
        this.r = textView;
        this.s = textView2;
        this.t = textView3;
        this.u = textView4;
        this.q = imageView;
        this.t1 = linearLayout;
        this.v1 = linearLayout2;
        this.w1 = linearLayout3;
        this.x1 = linearLayout4;
        this.y1 = linearLayout5;
        this.z1 = linearLayout6;
        this.g1 = textView5;
        this.i1 = textView6;
        this.l1 = textView7;
        this.n1 = textView8;
        this.p1 = textView9;
        this.q1 = textView10;
        this.r1 = textView11;
        this.s1 = textView12;
        SharedPreferences sharedPreferences = context.getSharedPreferences("timeFormat", 0);
        W5 = sharedPreferences;
        this.h0 = new SimpleDateFormat(sharedPreferences.getString("timeFormat", m7.a.E0), Locale.US);
        i4(str2);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
            k4(str3);
        } else {
            this.y2 = new H(this, str, null).execute(new String[0]);
        }
    }

    public String k3() {
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
            this.r4 = 0;
            ArrayList arrayList = this.x0;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList arrayList2 = this.y0;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            ArrayList arrayList3 = new ArrayList();
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
                arrayList3 = this.S.getLiveFavStalker(str3);
            } else {
                ArrayList arrayList4 = new ArrayList();
                if (this.E1 != null) {
                    if (this.K4.equals("true")) {
                        databaseHandler = this.E1;
                        str = "radio_streams";
                        userID = SharepreferenceDBHandler.getUserID(this.d);
                    } else {
                        databaseHandler = this.E1;
                        str = "live";
                        userID = SharepreferenceDBHandler.getUserID(this.d);
                    }
                    ArrayList allFavourites = databaseHandler.getAllFavourites(str, userID);
                    ArrayList arrayList5 = this.D0;
                    if (arrayList5 == null || arrayList5.size() <= 0 || allFavourites == null || allFavourites.size() <= 0) {
                        arrayList4 = allFavourites;
                    } else {
                        try {
                            Iterator it = allFavourites.iterator();
                            while (it.hasNext()) {
                                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
                                Iterator it2 = this.D0.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        arrayList4.add(favouriteDBModel);
                                        break;
                                    }
                                    if (favouriteDBModel.getCategoryID().equals((String) it2.next())) {
                                        break;
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (arrayList4 != null) {
                        try {
                            if (arrayList4.size() > 0) {
                                Iterator it3 = arrayList4.iterator();
                                while (it3.hasNext()) {
                                    FavouriteDBModel favouriteDBModel2 = (FavouriteDBModel) it3.next();
                                    LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.d);
                                    if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                                        categoryID = favouriteDBModel2.getCategoryID();
                                        valueOf = String.valueOf(favouriteDBModel2.getStreamIDOneStream());
                                        timestamp = favouriteDBModel2.getTimestamp();
                                        str2 = this.L4;
                                    } else {
                                        categoryID = favouriteDBModel2.getCategoryID();
                                        valueOf = String.valueOf(favouriteDBModel2.getStreamID());
                                        timestamp = favouriteDBModel2.getTimestamp();
                                        str2 = this.L4;
                                    }
                                    LiveStreamsDBModel liveStreamFavouriteRow = liveStreamDBHandler.getLiveStreamFavouriteRow(categoryID, valueOf, timestamp, str2);
                                    if (liveStreamFavouriteRow != null) {
                                        arrayList3.add(liveStreamFavouriteRow);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if (arrayList3.size() != 0) {
                this.x0 = arrayList3;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.L2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.L2.B();
            ArrayList ePGTesting = B2 ? this.S.getEPGTesting((String) null, format) : null;
            this.Z = getSharedPreferences("currentlyPlayingVideo", 0);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                sharedPreferences = this.Y;
                str4 = "LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U";
            } else {
                sharedPreferences = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api") ? this.Y : this.Y;
            }
            String string = sharedPreferences.getString(str4, "");
            ArrayList arrayList6 = this.x0;
            if (arrayList6 != null && arrayList6.size() > 0) {
                for (int i2 = 0; i2 < this.x0.size() && ((asyncTask = this.w2) == null || !asyncTask.isCancelled()); i2++) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                        if (((LiveStreamsDBModel) this.x0.get(i2)).getUrl().equals(string)) {
                            this.r4 = i2;
                        }
                    } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                        if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamIdOneStream().equals(string)) {
                            this.r4 = i2;
                        }
                    } else if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamId().equals(string)) {
                        this.r4 = i2;
                    }
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.x0.get(i2)).getNum());
                    liveStreamsDBModel.setName(((LiveStreamsDBModel) this.x0.get(i2)).getName());
                    liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.x0.get(i2)).getStreamType());
                    liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.x0.get(i2)).getStreamId());
                    liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.x0.get(i2)).getStreamIdOneStream());
                    liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.x0.get(i2)).getStreamIcon());
                    liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.x0.get(i2)).getEpgChannelId());
                    liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.x0.get(i2)).getAdded());
                    liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.x0.get(i2)).getCategoryId());
                    liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.x0.get(i2)).getCustomSid());
                    liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.x0.get(i2)).getTvArchive());
                    liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.x0.get(i2)).getDirectSource());
                    liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.x0.get(i2)).getTvArchiveDuration());
                    liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.x0.get(i2)).getTypeName());
                    liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.x0.get(i2)).getCategoryName());
                    liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.x0.get(i2)).getSeriesNo());
                    liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.x0.get(i2)).getLive());
                    liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.x0.get(i2)).getContaiinerExtension());
                    liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.x0.get(i2)).getUrl());
                    if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < ePGTesting.size() && ((asyncTask2 = this.w2) == null || !asyncTask2.isCancelled())) {
                                if (((LiveStreamsDBModel) this.x0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                                    int M = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                                    if (M != 0) {
                                        M = 100 - M;
                                    }
                                    liveStreamsDBModel.setEpgPercentage(M);
                                    liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                    this.y0.add(liveStreamsDBModel);
                }
            }
            this.x0 = this.y0;
            return "get_fav";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "get_fav";
        }
    }

    public void k4(String str) {
        e3();
        String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.d);
        String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.d);
        try {
            if (this.w4 == null) {
                this.w4 = new n7.g(this, this.d);
            }
            this.w4.e(loggedInMacAddress, stalkerToken, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void l3() {
        if (this.x5.getVisibility() == 0) {
            this.A5.setNextFocusRightId(a7.f.ym);
            this.B5.setNextFocusRightId(a7.f.e2);
            this.C5.setNextFocusRightId(a7.f.a2);
            this.D5.setNextFocusRightId(a7.f.V1);
        }
    }

    public void l4(int i2, String str, int i3, int i4) {
        try {
            if (this.l4.equals("mobile") && this.u4 && this.N4) {
                ArrayList arrayList = new ArrayList();
                PendingIntent broadcast = PendingIntent.getBroadcast(this, i4, new Intent("media_control").putExtra("control_type", i3), 67108864);
                Icon a2 = p7.p.a(this, i2);
                p7.u.a();
                arrayList.add(p7.t.a(a2, str, str, broadcast));
                p7.q.a(this.E4, arrayList);
                t7.b.a(this, p7.n.a(this.E4));
            }
        } catch (Exception unused) {
        }
    }

    public int m3(ArrayList arrayList, int i2) {
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

    public void o0(String str) {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i2, i3, intent);
        if (i2 == 101) {
            try {
                if (B3()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("downloadStatus", 0);
                    X5 = sharedPreferences;
                    String string = sharedPreferences.getString("downloadStatus", "");
                    m7.w wVar = new m7.w();
                    if (string.equals("processing")) {
                        wVar.L0(this);
                    } else {
                        wVar.O0(this, this.p2, this.i0, this.e, this.D, this.F, this.E);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onBackPressed() {
        RelativeLayout relativeLayout;
        try {
            h4();
            relativeLayout = this.q3;
        } catch (Exception unused) {
        }
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.q3.startAnimation(this.t4);
            this.q3.setVisibility(8);
            return;
        }
        if (this.p3.getVisibility() == 0) {
            this.p3.startAnimation(this.k4);
            this.p3.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout2 = this.z5;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            this.z5.setVisibility(8);
            this.x5.setVisibility(8);
            this.x5.startAnimation(this.i4);
            this.z5.startAnimation(this.i4);
            this.f5.setChecked(false);
            this.g5.setChecked(false);
            this.h5.setChecked(false);
            this.i5.setChecked(false);
            this.Z4.setChecked(false);
            this.a5.setChecked(false);
            this.b5.setChecked(false);
            this.c5.setChecked(false);
            this.d5.setChecked(false);
            this.V4.setChecked(false);
            this.W4.setChecked(false);
            this.X4.setChecked(false);
            this.Y4.setChecked(false);
            this.t5.setText("");
            return;
        }
        if (Y5) {
            if (this.x3.getVisibility() != 0) {
                Toolbar toolbar = this.M0;
                if (toolbar != null) {
                    toolbar.setVisibility(0);
                }
                g4();
                return;
            }
            this.x3.startAnimation(this.i4);
            if (this.k3.getVisibility() == 0) {
                this.k3.startAnimation(this.i4);
            }
            if (this.v3.getVisibility() == 0) {
                this.v3.startAnimation(this.i4);
            }
            if (this.m3.getVisibility() == 0) {
                this.m3.startAnimation(this.i4);
            }
            if (this.w3.getVisibility() == 0) {
                this.w3.startAnimation(this.i4);
            }
            if (this.l3.getVisibility() == 0) {
                this.l3.startAnimation(this.i4);
            }
            this.x3.setVisibility(8);
            if (this.k3.getVisibility() == 0) {
                this.k3.setVisibility(8);
            }
            if (this.v3.getVisibility() == 0) {
                this.v3.setVisibility(8);
            }
            if (this.m3.getVisibility() == 0) {
                this.m3.setVisibility(8);
            }
            if (this.w3.getVisibility() == 0) {
                this.w3.setVisibility(8);
            }
            if (this.l3.getVisibility() == 0) {
                this.l3.setVisibility(8);
                return;
            }
            return;
        }
        if (this.l4.equals("mobile") && this.u4 && this.N4) {
            try {
                E3();
            } catch (Exception unused2) {
            }
        } else {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        }
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        CheckBox checkBox;
        boolean isChecked = ((CheckBox) compoundButton).isChecked();
        if (compoundButton.getId() == a7.f.V1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.f5;
            }
        } else if (compoundButton.getId() == a7.f.X1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.g5;
            }
        } else if (compoundButton.getId() == a7.f.Y1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.h5;
            }
        } else if (compoundButton.getId() == a7.f.W1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.i5;
            }
        } else if (compoundButton.getId() == a7.f.e2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.V4;
            }
        } else if (compoundButton.getId() == a7.f.g2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.W4;
            }
        } else if (compoundButton.getId() == a7.f.h2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.X4;
            }
        } else if (compoundButton.getId() == a7.f.f2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.Y4;
            }
        } else if (compoundButton.getId() == a7.f.a2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.Z4;
            }
        } else if (compoundButton.getId() == a7.f.c2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.a5;
            }
        } else if (compoundButton.getId() == a7.f.d2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.b5;
            }
        } else if (compoundButton.getId() == a7.f.b2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.c5;
            }
        } else if (compoundButton.getId() != a7.f.Z1 || !isChecked) {
            return;
        } else {
            checkBox = this.d5;
        }
        this.N5 = checkBox.getText().toString();
    }

    public void onClick(View view) {
        String str;
        String str2;
        x7.a f2;
        String valueOf;
        SharedPreferences.Editor editor;
        String valueOf2;
        StringBuilder sb;
        x7.a f3;
        String valueOf3;
        SharedPreferences.Editor editor2;
        String valueOf4;
        String sb2;
        StringBuilder sb3;
        Throwable th;
        Toast makeText;
        TextView textView;
        Resources resources;
        int i2;
        int i3;
        int i4;
        ImageView imageView;
        ImageView imageView2;
        String V;
        Intent intent;
        JSONObject jSONObject;
        String str3;
        String str4;
        String str5;
        int id = view.getId();
        String str6 = "";
        if (id != a7.f.S8) {
            if (id == a7.f.I5) {
                if (!this.l4.equals("tv")) {
                    boolean playerIsPrepared = this.h2.getPlayerIsPrepared();
                    h4();
                    b4();
                    if (playerIsPrepared) {
                        U2(1000);
                        this.h2.start();
                        this.t3.setVisibility(8);
                        imageView = this.u3;
                    } else {
                        U2(5000);
                        imageView = this.t3;
                    }
                    imageView.setVisibility(0);
                    return;
                }
                boolean playerIsPrepared2 = this.h2.getPlayerIsPrepared();
                h4();
                a4();
                if (playerIsPrepared2) {
                    T2(1000);
                    this.h2.start();
                    this.t3.setVisibility(8);
                    this.u3.setVisibility(0);
                    imageView2 = this.u3;
                } else {
                    T2(5000);
                    this.t3.setVisibility(0);
                    imageView2 = this.t3;
                }
                imageView2.requestFocus();
                return;
            }
            if (id == a7.f.H5) {
                try {
                    if (this.l4.equals("tv")) {
                        h4();
                        a4();
                        this.h2.pause();
                        this.u3.setVisibility(8);
                        this.t3.setVisibility(0);
                        this.t3.requestFocus();
                    } else {
                        h4();
                        b4();
                        this.h2.pause();
                        this.u3.setVisibility(8);
                        this.t3.setVisibility(0);
                    }
                    return;
                } catch (Exception e2) {
                    str = "exection " + e2;
                    str2 = "NSTIJPLAYERACTIVTY";
                }
            } else {
                if (id != a7.f.Cl) {
                    if (id != a7.f.El) {
                        if (id == a7.f.x3 || id == a7.f.w3 || id == a7.f.z3 || id == a7.f.Qm) {
                            return;
                        }
                        if (id == a7.f.p) {
                            try {
                                g3(true);
                                return;
                            } catch (Exception e3) {
                                sb3 = new StringBuilder();
                                sb3.append("exection ");
                                sb3.append(e3.getMessage());
                            }
                        } else if (id == a7.f.f1) {
                            try {
                                AppBarLayout appBarLayout = this.Q0;
                                if (appBarLayout != null) {
                                    toggleView(appBarLayout);
                                    this.Q0.requestFocusFromTouch();
                                    return;
                                }
                                return;
                            } catch (Exception e4) {
                                e = e4;
                                sb = new StringBuilder();
                            }
                        } else {
                            if (id == a7.f.V0) {
                                try {
                                    V2();
                                    return;
                                } catch (Exception e5) {
                                    th = e5;
                                    sb3 = new StringBuilder();
                                }
                            } else {
                                if (id != a7.f.W0) {
                                    if (id == a7.f.Z6 || id == a7.f.C4) {
                                        h4();
                                        s3();
                                        e4();
                                        return;
                                    }
                                    if (id == a7.f.c7 || id == a7.f.E4) {
                                        onBackPressed();
                                    } else if (id != a7.f.I4 && id != a7.f.J4) {
                                        if (id == a7.f.x8) {
                                            h4();
                                            s3();
                                            c6 = true;
                                            this.h2.B1();
                                            this.h2.c1(3000);
                                            return;
                                        }
                                        if (id == a7.f.i6) {
                                            h4();
                                            c6 = false;
                                            this.o3.startAnimation(this.d4);
                                            this.o3.setVisibility(8);
                                            b4();
                                            U2(3000);
                                            return;
                                        }
                                        if (id == a7.f.w7) {
                                            h4();
                                            s3();
                                            return;
                                        }
                                        if (id == a7.f.v7) {
                                            h4();
                                            s3();
                                            X3();
                                            return;
                                        }
                                        if (id == a7.f.B7) {
                                            h4();
                                            T2(5000);
                                            NSTIJKPlayerSky nSTIJKPlayerSky = this.h2;
                                            if (nSTIJKPlayerSky != null) {
                                                nSTIJKPlayerSky.K1();
                                                return;
                                            }
                                            return;
                                        }
                                        if (id == a7.f.y7 || id == a7.f.S4) {
                                            h4();
                                            s3();
                                            if (this.z5.getVisibility() == 8) {
                                                this.z5.startAnimation(this.j4);
                                                this.z5.setVisibility(0);
                                                this.A5.requestFocus();
                                                this.u5.requestFocus();
                                                this.f5.setChecked(false);
                                                this.g5.setChecked(false);
                                                this.h5.setChecked(false);
                                                this.i5.setChecked(false);
                                                this.Z4.setChecked(false);
                                                this.a5.setChecked(false);
                                                this.b5.setChecked(false);
                                                this.c5.setChecked(false);
                                                this.d5.setChecked(false);
                                                this.V4.setChecked(false);
                                                this.W4.setChecked(false);
                                                this.X4.setChecked(false);
                                                this.Y4.setChecked(false);
                                                this.t5.setText("");
                                                return;
                                            }
                                            return;
                                        }
                                        if (id == a7.f.x1) {
                                            this.L5 = this.l5.getText().toString();
                                            this.M5 = this.p5.getText().toString();
                                            i3 = 0;
                                            this.x5.setVisibility(0);
                                            this.S4.setVisibility(0);
                                            i4 = 8;
                                            this.R4.setVisibility(8);
                                            this.T4.setVisibility(8);
                                            this.F5.setVisibility(8);
                                        } else {
                                            if (id == a7.f.Jg) {
                                                this.L5 = this.m5.getText().toString();
                                                this.M5 = this.q5.getText().toString();
                                                this.x5.setVisibility(0);
                                                i4 = 8;
                                                this.S4.setVisibility(8);
                                                this.F5.setVisibility(8);
                                                this.R4.setVisibility(0);
                                                this.t5.setVisibility(0);
                                                this.T4.setVisibility(8);
                                                this.e5.setVisibility(i4);
                                                textView = this.j5;
                                                resources = getResources();
                                                i2 = a7.j.Q7;
                                                textView.setText(resources.getString(i2));
                                                return;
                                            }
                                            if (id == a7.f.X) {
                                                this.L5 = this.n5.getText().toString();
                                                this.M5 = this.r5.getText().toString();
                                                i3 = 0;
                                                this.x5.setVisibility(0);
                                                i4 = 8;
                                                this.S4.setVisibility(8);
                                                this.R4.setVisibility(8);
                                                this.F5.setVisibility(8);
                                                this.T4.setVisibility(0);
                                            } else {
                                                if (id == a7.f.k) {
                                                    this.L5 = this.o5.getText().toString();
                                                    this.M5 = this.s5.getText().toString();
                                                    this.x5.setVisibility(0);
                                                    this.S4.setVisibility(8);
                                                    this.R4.setVisibility(8);
                                                    this.T4.setVisibility(8);
                                                    this.F5.setVisibility(8);
                                                    this.e5.setVisibility(0);
                                                    this.t5.setVisibility(0);
                                                    textView = this.j5;
                                                    resources = getResources();
                                                    i2 = a7.j.Q7;
                                                    textView.setText(resources.getString(i2));
                                                    return;
                                                }
                                                if (id == a7.f.v2) {
                                                    this.x5.setVisibility(0);
                                                    this.S4.setVisibility(8);
                                                    this.R4.setVisibility(8);
                                                    this.T4.setVisibility(8);
                                                    this.e5.setVisibility(8);
                                                    this.F5.setVisibility(0);
                                                    this.t5.setVisibility(4);
                                                    this.E5.setVisibility(0);
                                                    textView = this.j5;
                                                    resources = getResources();
                                                    i2 = a7.j.y0;
                                                    textView.setText(resources.getString(i2));
                                                    return;
                                                }
                                                if (id != a7.f.tm) {
                                                    return;
                                                }
                                                if (this.F5.getVisibility() == 0) {
                                                    try {
                                                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getResources().getString(a7.j.z0))));
                                                    } catch (ActivityNotFoundException e6) {
                                                        Toast.makeText(this, "No application can handle this request. Please install a webbrowser", 1).show();
                                                        e6.printStackTrace();
                                                    }
                                                    this.z5.setVisibility(8);
                                                    return;
                                                }
                                                this.O5 = this.t5.getText().toString();
                                                Y2();
                                                if (this.Z4.isChecked() || this.a5.isChecked() || this.b5.isChecked() || this.c5.isChecked() || this.d5.isChecked() || this.f5.isChecked() || this.g5.isChecked() || this.h5.isChecked() || this.i5.isChecked() || this.V4.isChecked() || this.W4.isChecked() || this.X4.isChecked() || this.Y4.isChecked() || this.t5.length() > 0) {
                                                    u1();
                                                    this.f5.setChecked(false);
                                                    this.g5.setChecked(false);
                                                    this.h5.setChecked(false);
                                                    this.i5.setChecked(false);
                                                    this.Z4.setChecked(false);
                                                    this.a5.setChecked(false);
                                                    this.b5.setChecked(false);
                                                    this.c5.setChecked(false);
                                                    this.d5.setChecked(false);
                                                    this.V4.setChecked(false);
                                                    this.W4.setChecked(false);
                                                    this.X4.setChecked(false);
                                                    this.Y4.setChecked(false);
                                                    this.t5.setText("");
                                                    RelativeLayout relativeLayout = this.z5;
                                                    if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                                                        return;
                                                    }
                                                    this.z5.setVisibility(8);
                                                    this.x5.setVisibility(8);
                                                    this.x5.startAnimation(this.i4);
                                                    this.z5.startAnimation(this.i4);
                                                    return;
                                                }
                                                makeText = Toast.makeText(this.d, "Please Add Report", 0);
                                            }
                                        }
                                        this.t5.setVisibility(i3);
                                        this.e5.setVisibility(i4);
                                        textView = this.j5;
                                        resources = getResources();
                                        i2 = a7.j.Q7;
                                        textView.setText(resources.getString(i2));
                                        return;
                                    }
                                    onBackPressed();
                                    return;
                                }
                                try {
                                    G3();
                                    return;
                                } catch (Exception e7) {
                                    th = e7;
                                    th.printStackTrace();
                                    sb3 = new StringBuilder();
                                }
                            }
                            sb3.append("exection ");
                            sb3.append(th);
                        }
                        sb2 = sb3.toString();
                        Log.e("NSTIJPLAYER", sb2);
                        return;
                    }
                    try {
                        AsyncTask asyncTask = this.y2;
                        if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
                            this.y2.cancel(true);
                        }
                        h4();
                        b4();
                        U2(5000);
                        if (this.h2 != null) {
                            this.h.requestFocus();
                            this.K1.removeCallbacksAndMessages((Object) null);
                            this.S0 = true;
                            F3();
                            int currentWindowIndex = this.h2.getCurrentWindowIndex();
                            ArrayList arrayList = this.z0;
                            if (arrayList == null || arrayList.size() <= 1 || currentWindowIndex > this.z0.size() - 1 || currentWindowIndex <= -1) {
                                return;
                            }
                            String name = ((LiveStreamsDBModel) this.z0.get(currentWindowIndex)).getName();
                            String url = ((LiveStreamsDBModel) this.z0.get(currentWindowIndex)).getUrl();
                            this.D1 = url;
                            String num = ((LiveStreamsDBModel) this.z0.get(currentWindowIndex)).getNum();
                            this.U2 = m7.w.r0(((LiveStreamsDBModel) this.z0.get(currentWindowIndex)).getNum());
                            String streamIcon = ((LiveStreamsDBModel) this.z0.get(currentWindowIndex)).getStreamIcon();
                            try {
                                if (streamIcon.equals("") || streamIcon.isEmpty()) {
                                    this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                                } else {
                                    com.squareup.picasso.t.q(this.d).l(streamIcon).j(a7.e.i1).d(a7.e.i1).k(80, 55).g(this.q);
                                }
                            } catch (Exception unused) {
                                this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                            }
                            this.h2.setTitle(num + " - " + name);
                            this.H4 = num + " - " + name;
                            this.T1 = currentWindowIndex;
                            this.Q1.clear();
                            this.Q1.apply();
                            this.R1.clear();
                            this.R1.apply();
                            this.P1.clear();
                            this.P1.apply();
                            if (this.n2.booleanValue()) {
                                this.K1.postDelayed(new j(currentWindowIndex, name, url), SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api") ? 1000 : 200);
                            }
                            this.M1.removeCallbacksAndMessages((Object) null);
                            this.B1 = m7.w.q0(((LiveStreamsDBModel) this.z0.get(currentWindowIndex)).getStreamId());
                            if (this.e2.equals("m3u")) {
                                f3 = x7.a.f();
                                valueOf3 = this.D1;
                            } else if (this.e2.equals("onestream_api")) {
                                f3 = x7.a.f();
                                valueOf3 = this.C1;
                            } else {
                                f3 = x7.a.f();
                                valueOf3 = String.valueOf(this.B1);
                            }
                            f3.A(valueOf3);
                            if (this.F1 != null) {
                                if (this.e2.equals("onestream_api")) {
                                    editor2 = this.F1;
                                    valueOf4 = String.valueOf(((LiveStreamsDBModel) this.z0.get(currentWindowIndex)).getStreamIdOneStream());
                                } else {
                                    editor2 = this.F1;
                                    valueOf4 = String.valueOf(((LiveStreamsDBModel) this.z0.get(currentWindowIndex)).getStreamId());
                                }
                                editor2.putString("currentlyPlayingVideo", valueOf4);
                                this.F1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", ((LiveStreamsDBModel) this.z0.get(currentWindowIndex)).getUrl());
                                this.F1.apply();
                            }
                            SharedPreferences.Editor editor3 = this.G1;
                            if (editor3 != null) {
                                editor3.putInt("currentlyPlayingVideoPosition", currentWindowIndex);
                                this.G1.apply();
                            }
                            if (this.A2 != 0) {
                                this.A2 = currentWindowIndex;
                            }
                            this.U.notifyDataSetChanged();
                            return;
                        }
                        return;
                    } catch (Exception e8) {
                        e = e8;
                        sb = new StringBuilder();
                    }
                    sb.append("exection ");
                    sb.append(e);
                    sb2 = sb.toString();
                    Log.e("NSTIJPLAYER", sb2);
                    return;
                }
                try {
                    AsyncTask asyncTask2 = this.y2;
                    if (asyncTask2 != null && asyncTask2.getStatus().equals(AsyncTask.Status.RUNNING)) {
                        this.y2.cancel(true);
                    }
                    h4();
                    b4();
                    U2(5000);
                    if (this.h2 != null) {
                        this.i.requestFocus();
                        this.K1.removeCallbacksAndMessages((Object) null);
                        N3();
                        this.S0 = true;
                        int currentWindowIndex2 = this.h2.getCurrentWindowIndex();
                        ArrayList arrayList2 = this.z0;
                        if (arrayList2 == null || arrayList2.size() <= 1 || currentWindowIndex2 > this.z0.size() - 1 || currentWindowIndex2 <= -1) {
                            return;
                        }
                        String name2 = ((LiveStreamsDBModel) this.z0.get(currentWindowIndex2)).getName();
                        String num2 = ((LiveStreamsDBModel) this.z0.get(currentWindowIndex2)).getNum();
                        this.U2 = m7.w.r0(((LiveStreamsDBModel) this.z0.get(currentWindowIndex2)).getNum());
                        String url2 = ((LiveStreamsDBModel) this.z0.get(currentWindowIndex2)).getUrl();
                        this.D1 = url2;
                        String streamIcon2 = ((LiveStreamsDBModel) this.z0.get(currentWindowIndex2)).getStreamIcon();
                        try {
                            if (streamIcon2.equals("") || streamIcon2.isEmpty()) {
                                this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                            } else {
                                com.squareup.picasso.t.q(this.d).l(streamIcon2).j(a7.e.i1).d(a7.e.i1).k(80, 55).g(this.q);
                            }
                        } catch (Exception unused2) {
                            this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                        }
                        this.h2.setTitle(num2 + " - " + name2);
                        this.H4 = num2 + " - " + name2;
                        this.T1 = currentWindowIndex2;
                        this.Q1.clear();
                        this.Q1.apply();
                        this.R1.clear();
                        this.R1.apply();
                        this.P1.clear();
                        this.P1.apply();
                        if (this.n2.booleanValue()) {
                            this.K1.postDelayed(new i(currentWindowIndex2, name2, url2), SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api") ? 1000 : 200);
                        }
                        this.M1.removeCallbacksAndMessages((Object) null);
                        this.B1 = m7.w.q0(((LiveStreamsDBModel) this.z0.get(currentWindowIndex2)).getStreamId());
                        if (this.e2.equals("m3u")) {
                            f2 = x7.a.f();
                            valueOf = this.D1;
                        } else if (this.e2.equals("onestream_api")) {
                            f2 = x7.a.f();
                            valueOf = this.C1;
                        } else {
                            f2 = x7.a.f();
                            valueOf = String.valueOf(this.B1);
                        }
                        f2.A(valueOf);
                        if (this.F1 != null) {
                            if (this.e2.equals("onestream_api")) {
                                editor = this.F1;
                                valueOf2 = String.valueOf(((LiveStreamsDBModel) this.z0.get(currentWindowIndex2)).getStreamIdOneStream());
                            } else {
                                editor = this.F1;
                                valueOf2 = String.valueOf(((LiveStreamsDBModel) this.z0.get(currentWindowIndex2)).getStreamId());
                            }
                            editor.putString("currentlyPlayingVideo", valueOf2);
                            this.F1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", ((LiveStreamsDBModel) this.z0.get(currentWindowIndex2)).getUrl());
                            this.F1.apply();
                        }
                        SharedPreferences.Editor editor4 = this.G1;
                        if (editor4 != null) {
                            editor4.putInt("currentlyPlayingVideoPosition", currentWindowIndex2);
                            this.G1.apply();
                        }
                        if (this.A2 != 0) {
                            this.A2 = currentWindowIndex2;
                        }
                        this.U.notifyDataSetChanged();
                        return;
                    }
                    return;
                } catch (Exception e9) {
                    str = "exection " + e9;
                    str2 = "NSTIJPLAYERskyACTIVTY";
                }
            }
            Log.e(str2, str);
            return;
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
            this.J4 = true;
            if (this.C) {
                return;
            }
            O3();
            if (this.e2.equals("m3u")) {
                if (this.n2.booleanValue()) {
                    Intent intent2 = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
                    intent2.putExtra("url", this.D1);
                    x7.a.f().A(this.D1);
                    intent2.putExtra("CHANNEL_NUM", this.U2);
                    this.d.startActivity(intent2);
                    return;
                }
                return;
            }
            if (this.e2.equals("onestream_api")) {
                if (!this.n2.booleanValue()) {
                    return;
                }
                try {
                    jSONObject = new JSONObject(this.Q);
                    String str7 = this.i0;
                    str3 = "m3u8";
                    str4 = "ts";
                    if (str7 == null || str7.isEmpty() || !this.i0.equals(".ts")) {
                        V = "";
                        str5 = V;
                    } else {
                        Iterator keys = jSONObject.keys();
                        while (true) {
                            if (!keys.hasNext()) {
                                str5 = "";
                                break;
                            } else if (((String) keys.next()).equals("ts")) {
                                str5 = "ts";
                                break;
                            }
                        }
                        if (str5.equals("")) {
                            while (true) {
                                if (!keys.hasNext()) {
                                    break;
                                } else if (((String) keys.next()).equals("m3u8")) {
                                    str5 = "m3u8";
                                    break;
                                }
                            }
                        }
                        V = jSONObject.getString(str5);
                    }
                } catch (Exception unused3) {
                }
                try {
                    String str8 = this.i0;
                    if (str8 != null && !str8.isEmpty() && this.i0.equals(".m3u8")) {
                        Iterator keys2 = jSONObject.keys();
                        while (true) {
                            if (!keys2.hasNext()) {
                                str3 = str5;
                                break;
                            } else if (((String) keys2.next()).equals("m3u8")) {
                                break;
                            }
                        }
                        if (str3.equals("")) {
                            while (keys2.hasNext()) {
                                if (((String) keys2.next()).equals("ts")) {
                                    break;
                                }
                            }
                            str4 = str3;
                            V = jSONObject.getString(str4);
                        } else {
                            str4 = str3;
                            V = jSONObject.getString(str4);
                        }
                    }
                } catch (Exception unused4) {
                    str6 = V;
                    V = str6;
                    x7.a.f().A(this.C1);
                    intent = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
                    intent.putExtra("url", V);
                    intent.putExtra("CHANNEL_NUM", this.U2);
                    this.d.startActivity(intent);
                    return;
                }
                x7.a.f().A(this.C1);
                intent = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
            } else {
                if (this.B1 == -1 || !this.n2.booleanValue()) {
                    return;
                }
                V = m7.w.V(this.d, this.B1, this.i0, "live");
                x7.a.f().A(String.valueOf(this.B1));
                intent = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
            }
            intent.putExtra("url", V);
            intent.putExtra("CHANNEL_NUM", this.U2);
            this.d.startActivity(intent);
            return;
        }
        makeText = Toast.makeText(this.d, "This feature has been disabled.", 1);
        makeText.show();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        J2(configuration);
    }

    public void onCreate(Bundle bundle) {
        this.d = this;
        x3();
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("auto_start", 0);
        this.M4 = sharedPreferences;
        boolean z2 = sharedPreferences.getBoolean("picinpic", m7.a.u0);
        this.N4 = z2;
        if (z2 && Build.VERSION.SDK_INT >= 26) {
            this.E4 = p7.v.a();
        }
        setContentView(a7.g.A1);
        this.Y2 = findViewById(a7.f.Kg);
        this.Z2 = findViewById(a7.f.Y);
        this.a3 = findViewById(a7.f.Gm);
        this.b3 = findViewById(a7.f.Wl);
        this.h3 = findViewById(a7.f.W3);
        this.i3 = findViewById(a7.f.Lf);
        this.j3 = findViewById(a7.f.Kf);
        this.k3 = findViewById(a7.f.j7);
        this.l3 = findViewById(a7.f.Ea);
        this.c3 = findViewById(a7.f.Mh);
        this.d3 = findViewById(a7.f.mm);
        this.m3 = findViewById(a7.f.h9);
        this.p3 = findViewById(a7.f.lf);
        this.q3 = findViewById(a7.f.ne);
        this.r3 = findViewById(a7.f.m5);
        this.n3 = findViewById(a7.f.x8);
        this.o3 = findViewById(a7.f.O9);
        this.s3 = findViewById(a7.f.i6);
        this.e3 = findViewById(a7.f.uk);
        this.f3 = findViewById(a7.f.Ak);
        this.g3 = findViewById(a7.f.Ck);
        this.x3 = findViewById(a7.f.t9);
        this.t3 = findViewById(a7.f.I5);
        this.u3 = findViewById(a7.f.H5);
        this.v3 = findViewById(a7.f.Cl);
        this.w3 = findViewById(a7.f.El);
        this.y3 = findViewById(a7.f.b7);
        this.C3 = findViewById(a7.f.I4);
        this.D3 = findViewById(a7.f.J4);
        this.E3 = findViewById(a7.f.E4);
        this.z3 = findViewById(a7.f.c7);
        this.F3 = findViewById(a7.f.C4);
        this.A3 = findViewById(a7.f.B7);
        this.G3 = findViewById(a7.f.n5);
        this.B3 = findViewById(a7.f.Y6);
        this.H3 = findViewById(a7.f.L9);
        this.I3 = findViewById(a7.f.S8);
        this.J3 = findViewById(a7.f.v7);
        this.K3 = findViewById(a7.f.lj);
        this.L3 = findViewById(a7.f.ei);
        this.M3 = findViewById(a7.f.al);
        this.N3 = findViewById(a7.f.Pl);
        this.O3 = findViewById(a7.f.Fd);
        this.P3 = findViewById(a7.f.i9);
        this.Q3 = findViewById(a7.f.W8);
        this.R3 = findViewById(a7.f.r7);
        this.T3 = findViewById(a7.f.Vh);
        this.S3 = findViewById(a7.f.w7);
        this.W3 = findViewById(a7.f.K1);
        this.X3 = findViewById(a7.f.W5);
        this.Z3 = findViewById(a7.f.g7);
        this.a4 = findViewById(a7.f.h7);
        this.U3 = findViewById(a7.f.ah);
        this.V3 = findViewById(a7.f.Hk);
        this.Y3 = findViewById(a7.f.F4);
        this.b4 = findViewById(a7.f.Z6);
        this.R4 = findViewById(a7.f.Hg);
        this.S4 = findViewById(a7.f.w1);
        this.T4 = findViewById(a7.f.Z);
        this.U4 = findViewById(a7.f.ym);
        this.V4 = findViewById(a7.f.e2);
        this.W4 = findViewById(a7.f.g2);
        this.X4 = findViewById(a7.f.h2);
        this.Y4 = findViewById(a7.f.f2);
        this.Z4 = findViewById(a7.f.a2);
        this.a5 = findViewById(a7.f.c2);
        this.b5 = findViewById(a7.f.d2);
        this.c5 = findViewById(a7.f.b2);
        this.d5 = findViewById(a7.f.Z1);
        this.e5 = findViewById(a7.f.j);
        this.f5 = findViewById(a7.f.V1);
        this.g5 = findViewById(a7.f.X1);
        this.h5 = findViewById(a7.f.Y1);
        this.i5 = findViewById(a7.f.W1);
        this.j5 = findViewById(a7.f.tm);
        this.k5 = findViewById(a7.f.z7);
        this.l5 = findViewById(a7.f.v1);
        this.m5 = findViewById(a7.f.Fg);
        this.n5 = findViewById(a7.f.a0);
        this.o5 = findViewById(a7.f.l);
        this.p5 = findViewById(a7.f.y1);
        this.q5 = findViewById(a7.f.Lg);
        this.r5 = findViewById(a7.f.b0);
        this.s5 = findViewById(a7.f.m);
        this.t5 = findViewById(a7.f.K3);
        this.u5 = findViewById(a7.f.X3);
        this.v5 = findViewById(a7.f.y7);
        this.w5 = findViewById(a7.f.xa);
        this.x5 = findViewById(a7.f.a);
        this.y5 = findViewById(a7.f.S4);
        this.z5 = findViewById(a7.f.ee);
        this.A5 = findViewById(a7.f.x1);
        this.B5 = findViewById(a7.f.Jg);
        this.C5 = findViewById(a7.f.X);
        this.D5 = findViewById(a7.f.k);
        this.E5 = findViewById(a7.f.v2);
        this.F5 = findViewById(a7.f.u2);
        this.T2 = findViewById(a7.f.Xa);
        overridePendingTransition(a7.b.f, a7.b.d);
        if (m7.a.V0.booleanValue()) {
            this.w5.setVisibility(0);
        } else {
            this.w5.setVisibility(4);
        }
        this.L2 = new u7.a(this.d);
        try {
            this.Q2 = new t7.f();
            this.P2 = o4.b.e(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        A3();
        RelativeLayout relativeLayout = this.X0;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new v());
        }
        this.D0 = n3();
        String str = this.e1;
        this.P4 = str;
        if (str == null || str.equals("") || !this.e1.equals("0")) {
            String str2 = this.e1;
            if (str2 == null || str2.equals("") || !this.e1.equals("-1")) {
                String str3 = this.e1;
                if (str3 == null || str3.equals("") || !this.e1.equals("-6")) {
                    M2();
                } else {
                    R2();
                }
            } else {
                Q2();
            }
        } else {
            K2();
        }
        this.x2 = new C().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        l3();
        String I1 = FreeTrailActivity.I1();
        this.J5 = I1;
        if (I1.equals("") || this.J5.isEmpty()) {
            this.J5 = m7.w.I(this.d);
        }
        this.f5.setOnCheckedChangeListener(this);
        this.g5.setOnCheckedChangeListener(this);
        this.h5.setOnCheckedChangeListener(this);
        this.i5.setOnCheckedChangeListener(this);
        this.Z4.setOnCheckedChangeListener(this);
        this.a5.setOnCheckedChangeListener(this);
        this.b5.setOnCheckedChangeListener(this);
        this.c5.setOnCheckedChangeListener(this);
        this.d5.setOnCheckedChangeListener(this);
        this.V4.setOnCheckedChangeListener(this);
        this.W4.setOnCheckedChangeListener(this);
        this.X4.setOnCheckedChangeListener(this);
        this.Y4.setOnCheckedChangeListener(this);
        this.U4.setOnClickListener(new x());
        p0.a.b(this.d).c(this.T5, new IntentFilter("pip_mode_switch_user"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.M0.x(a7.h.r);
        this.a2 = menu;
        this.b2 = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("api")) {
            menu.getItem(2).getSubMenu().findItem(a7.f.gb).setVisible(false);
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
            menu.getItem(2).getSubMenu().findItem(a7.f.gb).setVisible(false);
        }
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, this.d.getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.M0.getChildCount(); i2++) {
            if (this.M0.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.M0.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.T5 != null) {
                p0.a.b(this.d).e(this.T5);
            }
            Z2();
            O3();
            o4.b.e(this.d).c().e(this.N2, o4.e.class);
        } catch (Exception unused) {
        }
        try {
            Thread thread = this.S5;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.S5.interrupt();
        } catch (Exception unused2) {
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        keyEvent.getRepeatCount();
        keyEvent.getAction();
        boolean z2 = Y5;
        if (z2) {
            if (i2 == 20) {
                this.n2.booleanValue();
                return true;
            }
            if (i2 == 19) {
                this.n2.booleanValue();
                return true;
            }
        }
        if (i2 == 166) {
            if (z2) {
                this.n2.booleanValue();
            }
            return true;
        }
        if (i2 != 167) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (z2) {
            this.n2.booleanValue();
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        NSTIJKPlayerSky nSTIJKPlayerSky;
        StringBuilder sb;
        boolean z2 = keyEvent.getRepeatCount() == 0;
        if (i2 != 62) {
            if (i2 != 66) {
                if (i2 != 79) {
                    if (i2 == 82) {
                        Menu menu = this.a2;
                        if (menu != null) {
                            menu.performIdentifierAction(a7.f.P2, 0);
                        }
                    } else if (i2 != 85 && i2 != 86 && i2 != 126 && i2 != 127) {
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
                                if (Y5 && !SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                                    this.O1.removeCallbacksAndMessages((Object) null);
                                    int i3 = 7;
                                    if (i2 == 7) {
                                        this.U1.append(0);
                                    } else if (i2 == 8) {
                                        this.U1.append(1);
                                    } else {
                                        if (i2 == 9) {
                                            sb = this.U1;
                                            i3 = 2;
                                        } else if (i2 == 10) {
                                            sb = this.U1;
                                            i3 = 3;
                                        } else if (i2 == 11) {
                                            sb = this.U1;
                                            i3 = 4;
                                        } else if (i2 == 12) {
                                            sb = this.U1;
                                            i3 = 5;
                                        } else if (i2 == 13) {
                                            sb = this.U1;
                                            i3 = 6;
                                        } else if (i2 == 14) {
                                            sb = this.U1;
                                        } else if (i2 == 15) {
                                            this.U1.append(8);
                                        } else if (i2 == 16) {
                                            this.U1.append(9);
                                        }
                                        sb.append(i3);
                                    }
                                    this.W1.setText(this.U1.toString());
                                    this.V1.setVisibility(0);
                                    this.O1.postDelayed(new h(), 3000L);
                                }
                                return true;
                            default:
                                switch (i2) {
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
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
            return true;
        }
        if (this.n2.booleanValue() && (nSTIJKPlayerSky = this.h2) != null && nSTIJKPlayerSky.getPlayerIsPrepared()) {
            ((!z2 || this.h2.isPlaying()) ? this.u3 : this.t3).performClick();
        }
        return true;
    }

    public void onNewIntent(Intent intent) {
        super/*androidx.fragment.app.e*/.onNewIntent(intent);
        intent.putExtra("BUNDLE_KEY_NEW_INTENT_CALLED", true);
        setIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        y3();
        this.b2 = menuItem;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.d) != null) {
            new a.a(context, a7.k.a).setTitle(this.d.getResources().getString(a7.j.f3)).f(this.d.getResources().getString(a7.j.e3)).j(this.d.getResources().getString(a7.j.S8), new r()).g(this.d.getResources().getString(a7.j.d4), new q()).n();
        }
        if (itemId == a7.f.g) {
            SearchView b2 = P.w.b(menuItem);
            this.N0 = b2;
            b2.setQueryHint(this.d.getResources().getString(a7.j.A6));
            this.N0.setIconifiedByDefault(false);
            this.N0.setOnQueryTextListener(new s());
            return true;
        }
        if (itemId == a7.f.gb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.d.getResources().getString(a7.j.u0));
            aVar.f(this.d.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.d.getResources().getString(a7.j.S8), new t());
            aVar.g(this.d.getResources().getString(a7.j.d4), new u());
            aVar.n();
        }
        if (itemId == a7.f.mb) {
            f4(this);
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.Q4;
            if (thread != null && thread.isAlive()) {
                this.Q4.interrupt();
            }
        } catch (Exception unused) {
        }
        try {
            o4.b bVar = this.P2;
            if (bVar != null) {
                bVar.c().e(this.N2, o4.e.class);
            }
        } catch (Exception unused2) {
        }
    }

    public void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        try {
            super/*androidx.activity.ComponentActivity*/.onPictureInPictureModeChanged(z2, configuration);
            if (z2) {
                m7.a.p1 = true;
                NSTIJKPlayerSky nSTIJKPlayerSky = this.h2;
                if (nSTIJKPlayerSky != null && nSTIJKPlayerSky.W != null) {
                    nSTIJKPlayerSky.setShowOrHideSubtitles("gone");
                    this.h2.W.setVisibility(8);
                }
                o oVar = new o();
                this.F4 = oVar;
                registerReceiver(oVar, new IntentFilter("media_control"));
                return;
            }
            Y5 = true;
            unregisterReceiver(this.F4);
            this.v4 = false;
            this.F4 = null;
            NSTIJKPlayerSky nSTIJKPlayerSky2 = this.h2;
            if (nSTIJKPlayerSky2 != null && nSTIJKPlayerSky2.W != null) {
                nSTIJKPlayerSky2.setShowOrHideSubtitles("visible");
                this.h2.W.setVisibility(0);
            }
            NSTIJKPlayerSky nSTIJKPlayerSky3 = this.h2;
            if (nSTIJKPlayerSky3 != null) {
                nSTIJKPlayerSky3.isPlaying();
            }
        } catch (Exception unused) {
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 101) {
            return;
        }
        try {
            if (iArr.length > 0 && iArr[0] == 0) {
                B3();
            } else if (Build.VERSION.SDK_INT >= 23 && !t7.e.a(this, strArr[0])) {
                a.a aVar = new a.a(this, a7.k.a);
                View inflate = LayoutInflater.from(this).inflate(a7.g.W3, (ViewGroup) null);
                Button findViewById = inflate.findViewById(a7.f.c1);
                Button findViewById2 = inflate.findViewById(a7.f.U0);
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
                findViewById.setOnClickListener(new a());
                findViewById2.setOnClickListener(new b());
                aVar.setView(inflate);
                this.l2 = aVar.create();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.l2.getWindow();
                Objects.requireNonNull(window);
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                this.l2.show();
                this.l2.getWindow().setAttributes(layoutParams);
                this.l2.setCancelable(false);
                this.l2.show();
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        AppOpsManager appOpsManager;
        x3();
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.Q4;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new B());
            this.Q4 = thread2;
            thread2.start();
        }
        Context context = this.d;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("auto_start", 0);
            this.M4 = sharedPreferences;
            boolean z2 = sharedPreferences.getBoolean("picinpic", m7.a.u0);
            this.N4 = z2;
            if (z2 && this.l4.equals("mobile")) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    this.E4 = p7.v.a();
                }
                if (i2 >= 26) {
                    try {
                        if (getPackageManager().hasSystemFeature("android.software.picture_in_picture") && (appOpsManager = (AppOpsManager) this.d.getSystemService("appops")) != null && appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), this.d.getPackageName()) == 0) {
                            this.u4 = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false)) {
            intent.putExtra("BUNDLE_KEY_NEW_INTENT_CALLED", false);
            setIntent(intent);
            this.Z = getSharedPreferences("currentlyPlayingVideo", 0);
            if (!String.valueOf(getIntent().getIntExtra("OPENED_STREAM_ID", 0)).equals(SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.Y.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : this.Y.getString("currentlyPlayingVideo", ""))) {
                this.u2 = getIntent().getStringExtra("OPENED_CAT_ID");
                this.f1 = getIntent().getStringExtra("OPENED_CAT_NAME");
                this.s2 = getIntent().getIntExtra("OPENED_STREAM_ID", 0);
                this.T1 = getIntent().getIntExtra("VIDEO_NUM", 0);
                this.e1 = this.u2;
                this.f2 = getIntent().getStringExtra("VIDEO_URL");
                this.Z1 = Boolean.FALSE;
                String str = this.e1;
                if (str == null || str.equals("") || !this.e1.equals("0")) {
                    String str2 = this.e1;
                    if (str2 == null || str2.equals("") || !this.e1.equals("-1")) {
                        String str3 = this.e1;
                        if (str3 == null || str3.equals("") || !this.e1.equals("-6")) {
                            M2();
                        } else {
                            R2();
                        }
                    } else {
                        Q2();
                    }
                } else {
                    K2();
                }
            }
        }
        m7.w.m(this.d);
        o4.b bVar = this.P2;
        if (bVar != null) {
            bVar.c().a(this.N2, o4.e.class);
        }
        y3();
        if (this.B2) {
            this.B2 = false;
            ArrayList arrayList = this.v0;
            if (arrayList == null || arrayList.size() == 0) {
                m7.a.Y = Boolean.FALSE;
                I3();
            } else {
                M3(this.v0);
            }
            T t2 = this.U;
            if (t2 != null) {
                t2.notifyDataSetChanged();
            }
        }
    }

    public void onStart() {
        super.onStart();
        try {
            o4.b.e(this.d).c().a(this.N2, o4.e.class);
        } catch (Exception unused) {
        }
    }

    public void onStop() {
        super.onStop();
        try {
            O3();
            if (this.l4.equals("mobile") && !this.J4 && this.u4 && this.N4) {
                finishAndRemoveTask();
            }
        } catch (Exception unused) {
        }
    }

    public void onUserLeaveHint() {
        if (this.l4.equals("mobile") && this.u4 && this.N4 && !this.J4 && !t7.c.a(this)) {
            try {
                E3();
                this.v4 = true;
            } catch (Exception unused) {
            }
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super/*android.app.Activity*/.onWindowFocusChanged(z2);
        x3();
        if (z2) {
            J2(getResources().getConfiguration());
        }
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public void t3() {
        if (c6 || this.x3.getVisibility() != 0) {
            return;
        }
        this.x3.startAnimation(this.i4);
        if (this.k3.getVisibility() == 0) {
            this.k3.startAnimation(this.i4);
        }
        if (this.v3.getVisibility() == 0) {
            this.v3.startAnimation(this.i4);
        }
        if (this.m3.getVisibility() == 0) {
            this.m3.startAnimation(this.i4);
        }
        if (this.w3.getVisibility() == 0) {
            this.w3.startAnimation(this.i4);
        }
        if (this.l3.getVisibility() == 0) {
            this.l3.startAnimation(this.i4);
        }
        this.x3.setVisibility(8);
        if (this.k3.getVisibility() == 0) {
            this.k3.setVisibility(8);
        }
        if (this.v3.getVisibility() == 0) {
            this.v3.setVisibility(8);
        }
        if (this.m3.getVisibility() == 0) {
            this.m3.setVisibility(8);
        }
        if (this.w3.getVisibility() == 0) {
            this.w3.setVisibility(8);
        }
        if (this.l3.getVisibility() == 0) {
            this.l3.setVisibility(8);
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
            this.x4 = cmd;
            String[] split = cmd.split("ffmpeg ", 0);
            if (split.length == 2) {
                this.y4 = split[1];
            }
            if (str6.equals("playFirstTime")) {
                M3(this.w0);
                if (this.S0 && this.T0 && !this.U0.equals("")) {
                    this.A2 = 0;
                    try {
                        this.A2 = m3(this.w0, m7.w.r0(this.U0));
                    } catch (NumberFormatException | Exception unused) {
                    }
                    this.S0 = false;
                    this.T0 = false;
                    return;
                }
                return;
            }
            if (str6.equals("channel_click")) {
                K3(this.z4, this.M);
                return;
            }
            if (str6.equals("channel_click_from_player")) {
                L3(this.A4, this.N);
            } else if (str6.equals("zappingRight")) {
                n4(i4, str7, str8);
            } else if (str6.equals("zappingLeft")) {
                m4(i4, str7, str8);
            }
        } catch (Exception unused2) {
        }
    }

    public void v0(String str) {
    }

    public void w3() {
        LinearLayout linearLayout = this.Q3;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void y0(String str) {
    }

    public class k implements o4.y {
        public k() {
        }

        private void a(o4.e eVar) {
            NSTIJKPlayerSkyActivity.w1(NSTIJKPlayerSkyActivity.this, eVar);
            try {
                n4.m mVar = new n4.m(1);
                mVar.M("com.google.android.gms.cast.metadata.TITLE", NSTIJKPlayerSkyActivity.J1(NSTIJKPlayerSkyActivity.this));
                mVar.c(new x4.a(Uri.parse(NSTIJKPlayerSkyActivity.V1(NSTIJKPlayerSkyActivity.this))));
                NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                i7.a.b(nSTIJKPlayerSkyActivity.R2, NSTIJKPlayerSkyActivity.v1(nSTIJKPlayerSkyActivity).r(), NSTIJKPlayerSkyActivity.k2(NSTIJKPlayerSkyActivity.this), mVar, NSTIJKPlayerSkyActivity.this.d);
            } catch (Exception unused) {
            }
            NSTIJKPlayerSkyActivity.this.invalidateOptionsMenu();
        }

        private void b() {
            NSTIJKPlayerSkyActivity.this.invalidateOptionsMenu();
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
            NSTIJKPlayerSkyActivity.w1(NSTIJKPlayerSkyActivity.this, eVar);
            if (NSTIJKPlayerSkyActivity.v1(NSTIJKPlayerSkyActivity.this) != null) {
                if (NSTIJKPlayerSkyActivity.x1(NSTIJKPlayerSkyActivity.this) != null) {
                    NSTIJKPlayerSkyActivity.x1(NSTIJKPlayerSkyActivity.this).pause();
                }
                LinearLayout linearLayout = NSTIJKPlayerSkyActivity.this.R3;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity = NSTIJKPlayerSkyActivity.this;
                if (nSTIJKPlayerSkyActivity.T3 != null) {
                    if (NSTIJKPlayerSkyActivity.v1(nSTIJKPlayerSkyActivity).q() == null || NSTIJKPlayerSkyActivity.v1(NSTIJKPlayerSkyActivity.this).q().J() == null) {
                        textView = NSTIJKPlayerSkyActivity.this.T3;
                        sb = new StringBuilder();
                        string = NSTIJKPlayerSkyActivity.this.getResources().getString(a7.j.v0);
                    } else {
                        textView = NSTIJKPlayerSkyActivity.this.T3;
                        sb = new StringBuilder();
                        sb.append(NSTIJKPlayerSkyActivity.this.getResources().getString(a7.j.w0));
                        sb.append(" ");
                        string = NSTIJKPlayerSkyActivity.v1(NSTIJKPlayerSkyActivity.this).q().J();
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

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onSessionResuming(o4.e eVar, String str) {
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void onSessionSuspended(o4.e eVar, int i) {
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
