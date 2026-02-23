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
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
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
import b4.o;
import com.google.android.exoplayer2.ui.PlayerView;
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
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerMultiActivity;
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
import p3.B;
import p3.u;
import q7.T;
import q7.Z;
import q7.m0;
import q7.t;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTEXOPlayerSkyActivity extends androidx.appcompat.app.b implements SurfaceHolder.Callback, View.OnClickListener, z7.j, z7.g, CompoundButton.OnCheckedChangeListener {
    public static SharedPreferences r6 = null;
    public static SharedPreferences s6 = null;
    public static boolean t6 = false;
    public static String u6;
    public static String v6;
    public static final int[] w6 = {0, 1, 2, 3, 4, 5};
    public static ProgressBar x6;
    public ArrayList A0;
    public LinearLayout A1;
    public AsyncTask A2;
    public LinearLayout A3;
    public List A4;
    public CheckBox A5;
    public ArrayList B0;
    public LinearLayout B1;
    public AsyncTask B2;
    public LinearLayout B3;
    public n7.e B4;
    public CheckBox B5;
    public ArrayList C0;
    public String C1;
    public boolean C2;
    public LinearLayout C3;
    public int C4;
    public CheckBox C5;
    public ArrayList D0;
    public int D1;
    public int D2;
    public LinearLayout D3;
    public PictureInPictureParams.Builder D4;
    public CheckBox D5;
    public int E;
    public ArrayList E0;
    public boolean E2;
    public LinearLayout E3;
    public BroadcastReceiver E4;
    public CheckBox E5;
    public int F2;
    public LinearLayout F3;
    public String F4;
    public RelativeLayout F5;
    public ArrayList G0;
    public DatabaseHandler G1;
    public int G2;
    public LinearLayout G3;
    public String G4;
    public CheckBox G5;
    public String H;
    public ArrayList H0;
    public SharedPreferences.Editor H1;
    public SharedPreferences H2;
    public LinearLayout H3;
    public String H4;
    public CheckBox H5;
    public String I;
    public SharedPreferences I0;
    public SharedPreferences.Editor I1;
    public SharedPreferences.Editor I2;
    public LinearLayout I3;
    public boolean I4;
    public CheckBox I5;
    public String J;
    public SharedPreferences.Editor J0;
    public TextView J1;
    public Boolean J2;
    public LinearLayout J3;
    public String J4;
    public CheckBox J5;
    public RelativeLayout K;
    public ArrayList K0;
    public String K1;
    public Boolean K2;
    public LinearLayout K3;
    public SharedPreferences K4;
    public LinearLayout K5;
    public ListView L;
    public ArrayList L0;
    public TextView L1;
    public Boolean L2;
    public RelativeLayout L3;
    public boolean L4;
    public LinearLayout L5;
    public ListView M;
    public RecyclerView M0;
    public Handler M1;
    public Boolean M2;
    public RelativeLayout M3;
    public MultiUserDBHandler M4;
    public LinearLayout M5;
    public ArrayList N;
    public ProgressBar N0;
    public Handler N1;
    public Boolean N2;
    public TextView N3;
    public String N4;
    public LinearLayout N5;
    public ArrayList O;
    public Toolbar O0;
    public Handler O1;
    public Boolean O2;
    public TextView O3;
    public Thread O4;
    public LinearLayout O5;
    public ArrayList P;
    public SearchView P0;
    public Handler P1;
    public u7.a P2;
    public TextView P3;
    public I1 P4;
    public ImageView P5;
    public TextView Q0;
    public Handler Q1;
    public Handler Q2;
    public TextView Q3;
    public o.a Q4;
    public RelativeLayout Q5;
    public LinearLayout R0;
    public LinearLayout R1;
    public o4.y R2;
    public TextView R3;
    public Z3.m R4;
    public LinearLayout R5;
    public String S;
    public AppBarLayout S0;
    public SharedPreferences.Editor S1;
    public o4.e S2;
    public TextView S3;
    public m.d S4;
    public LinearLayout S5;
    public SharedPreferences.Editor T1;
    public o4.b T2;
    public TextView T3;
    public Uri T4;
    public LinearLayout T5;
    public LiveStreamDBHandler U;
    public SharedPreferences.Editor U1;
    public o4.f U2;
    public TextView U3;
    public int U4;
    public LinearLayout U5;
    public SharedPreferences V;
    public TextView V1;
    public Handler V2;
    public TextView V3;
    public int V4;
    public LinearLayout V5;
    public T W;
    public String W0;
    public ArrayList W2;
    public TextView W3;
    public boolean W4;
    public RelativeLayout W5;
    public SharedPreferences X;
    public int X2;
    public TextView X3;
    public boolean X4;
    public EditText X5;
    public SharedPreferences Y;
    public RelativeLayout Y0;
    public LinearLayout Y1;
    public String Y2;
    public TextView Y3;
    public GestureDetector Y4;
    public String Y5;
    public SharedPreferences Z;
    public RelativeLayout Z0;
    public TextView Z1;
    public String Z2;
    public RecyclerView Z3;
    public AudioManager Z4;
    public String Z5;
    public LinearLayout a1;
    public Boolean a3;
    public MediaRouteButton a4;
    public float a5;
    public String a6;
    public LinearLayout b1;
    public Boolean b2;
    public ImageView b3;
    public Animation b4;
    public int b5;
    public String b6;
    public RelativeLayout c1;
    public Boolean c2;
    public ImageView c3;
    public Animation c4;
    public int c5;
    public String c6;
    public Context d;
    public RelativeLayout d1;
    public Menu d2;
    public ImageView d3;
    public Animation d4;
    public Handler d5;
    public String d6;
    public String e;
    public SharedPreferences e0;
    public RelativeLayout e1;
    public MenuItem e2;
    public ImageView e3;
    public Animation e4;
    public Runnable e5;
    public String e6;
    public View f;
    public SharedPreferences f0;
    public RelativeLayout f1;
    public DateFormat f2;
    public ImageView f3;
    public Animation f4;
    public Handler f5;
    public String f6;
    public View g;
    public SharedPreferences g0;
    public String g2;
    public ImageView g3;
    public Animation g4;
    public Runnable g5;
    public String g6;
    public ImageView h;
    public SharedPreferences h0;
    public String h2;
    public ImageView h3;
    public Animation h4;
    public boolean h5;
    public String h6;
    public ImageView i;
    public SharedPreferences i0;
    public TextView i1;
    public String i2;
    public ImageView i3;
    public Animation i4;
    public SharedPreferences i5;
    public List i6;
    public View j;
    public SimpleDateFormat j0;
    public TextView j1;
    public SimpleDateFormat j2;
    public ImageView j3;
    public Animation j4;
    public RelativeLayout j5;
    public JsonArray j6;
    public String k;
    public String k0;
    public TextView k1;
    public PlayerView k2;
    public ImageView k3;
    public String k4;
    public RelativeLayout k5;
    public String k6;
    public View l;
    public RelativeLayout l0;
    public TextView l1;
    public Date l2;
    public ImageView l3;
    public q7.N l4;
    public RelativeLayout l5;
    public Thread l6;
    public View m;
    public String m1;
    public String m2;
    public ImageView m3;
    public q7.O m4;
    public TextView m5;
    public BroadcastReceiver m6;
    public TextView n0;
    public TextView n1;
    public Boolean n2;
    public ImageView n3;
    public LinearLayoutManager n4;
    public TextView n5;
    public ArrayList n6;
    public LinearLayout o;
    public AppCompatImageView o0;
    public TextView o1;
    public androidx.appcompat.app.a o2;
    public ImageView o3;
    public String o4;
    public TextView o5;
    public NSTIJKPlayerSky.w o6;
    public TextView p;
    public AppCompatImageView p0;
    public TextView p1;
    public String p2;
    public SeekBar p3;
    public String p4;
    public TextView p5;
    public final SeekBar.OnSeekBarChangeListener p6;
    public ImageView q;
    public ArrayList q0;
    public TextView q1;
    public Boolean q2;
    public SeekBar q3;
    public int q4;
    public TextView q5;
    public final SeekBar.OnSeekBarChangeListener q6;
    public TextView r;
    public ArrayList r0;
    public TextView r1;
    public D7.b r2;
    public LinearLayout r3;
    public Animation r4;
    public TextView r5;
    public TextView s;
    public ArrayList s0;
    public TextView s1;
    public String s2;
    public LinearLayout s3;
    public Animation s4;
    public TextView s5;
    public TextView t;
    public ArrayList t0;
    public TextView t1;
    public int t2;
    public LinearLayout t3;
    public boolean t4;
    public TextView t5;
    public TextView u;
    public ArrayList u0;
    public TextView u1;
    public String u2;
    public LinearLayout u3;
    public boolean u4;
    public TextView u5;
    public LinearLayout v;
    public ArrayList v0;
    public LinearLayout v1;
    public int v2;
    public LinearLayout v3;
    public n7.g v4;
    public TextView v5;
    public ProgressBar w;
    public ArrayList w0;
    public String w1;
    public String w2;
    public LinearLayout w3;
    public String w4;
    public CheckBox w5;
    public ProgressBar x;
    public ArrayList x0;
    public LinearLayout x1;
    public String x2;
    public LinearLayout x3;
    public String x4;
    public CheckBox x5;
    public LinearLayout y;
    public ArrayList y0;
    public LinearLayout y1;
    public Boolean y2;
    public LinearLayout y3;
    public int y4;
    public CheckBox y5;
    public LinearLayout z;
    public ArrayList z0;
    public LinearLayout z1;
    public AsyncTask z2;
    public LinearLayout z3;
    public int z4;
    public CheckBox z5;
    public boolean n = false;
    public boolean A = true;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public String F = "";
    public String G = "";
    public boolean Q = true;
    public long R = 2500;
    public boolean T = true;
    public int m0 = 0;
    public ArrayList F0 = new ArrayList();
    public boolean T0 = true;
    public boolean U0 = false;
    public boolean V0 = false;
    public boolean X0 = true;
    public String g1 = "";
    public String h1 = "";
    public String E1 = "";
    public String F1 = "";
    public int W1 = 0;
    public StringBuilder X1 = new StringBuilder();
    public int a2 = -1;

    public class A implements SeekBar.OnSeekBarChangeListener {
        public A() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView V2;
            Resources resources;
            int i2;
            NSTEXOPlayerSkyActivity.U2(NSTEXOPlayerSkyActivity.this, i);
            int T2 = (int) ((NSTEXOPlayerSkyActivity.T2(NSTEXOPlayerSkyActivity.this) / 255.0f) * 100.0f);
            if (T2 < 20) {
                V2 = NSTEXOPlayerSkyActivity.V2(NSTEXOPlayerSkyActivity.this);
                resources = NSTEXOPlayerSkyActivity.this.getResources();
                i2 = a7.e.i0;
            } else if (T2 < 30) {
                V2 = NSTEXOPlayerSkyActivity.V2(NSTEXOPlayerSkyActivity.this);
                resources = NSTEXOPlayerSkyActivity.this.getResources();
                i2 = a7.e.j0;
            } else if (T2 < 40) {
                V2 = NSTEXOPlayerSkyActivity.V2(NSTEXOPlayerSkyActivity.this);
                resources = NSTEXOPlayerSkyActivity.this.getResources();
                i2 = a7.e.k0;
            } else if (T2 < 50) {
                V2 = NSTEXOPlayerSkyActivity.V2(NSTEXOPlayerSkyActivity.this);
                resources = NSTEXOPlayerSkyActivity.this.getResources();
                i2 = a7.e.l0;
            } else if (T2 < 60) {
                V2 = NSTEXOPlayerSkyActivity.V2(NSTEXOPlayerSkyActivity.this);
                resources = NSTEXOPlayerSkyActivity.this.getResources();
                i2 = a7.e.m0;
            } else if (T2 < 70) {
                V2 = NSTEXOPlayerSkyActivity.V2(NSTEXOPlayerSkyActivity.this);
                resources = NSTEXOPlayerSkyActivity.this.getResources();
                i2 = a7.e.n0;
            } else {
                V2 = NSTEXOPlayerSkyActivity.V2(NSTEXOPlayerSkyActivity.this);
                resources = NSTEXOPlayerSkyActivity.this.getResources();
                i2 = a7.e.o0;
            }
            V2.setBackground(resources.getDrawable(i2));
            WindowManager.LayoutParams attributes = NSTEXOPlayerSkyActivity.this.getWindow().getAttributes();
            attributes.screenBrightness = NSTEXOPlayerSkyActivity.T2(NSTEXOPlayerSkyActivity.this) / 255.0f;
            NSTEXOPlayerSkyActivity.W2(NSTEXOPlayerSkyActivity.this).R((int) NSTEXOPlayerSkyActivity.T2(NSTEXOPlayerSkyActivity.this));
            NSTEXOPlayerSkyActivity.this.getWindow().setAttributes(attributes);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            NSTEXOPlayerSkyActivity.this.L4();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            NSTEXOPlayerSkyActivity.this.L4();
            NSTEXOPlayerSkyActivity.this.p3(3000);
        }
    }

    public class B implements SeekBar.OnSeekBarChangeListener {
        public B() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView Z2;
            Resources resources;
            int i2;
            if (NSTEXOPlayerSkyActivity.X2(NSTEXOPlayerSkyActivity.this) != null) {
                try {
                    NSTEXOPlayerSkyActivity.X2(NSTEXOPlayerSkyActivity.this).setStreamVolume(3, i, 0);
                    int streamVolume = (int) ((NSTEXOPlayerSkyActivity.X2(NSTEXOPlayerSkyActivity.this).getStreamVolume(3) / NSTEXOPlayerSkyActivity.Y2(NSTEXOPlayerSkyActivity.this)) * 100.0f);
                    if (streamVolume == 0 || streamVolume < 0) {
                        Z2 = NSTEXOPlayerSkyActivity.Z2(NSTEXOPlayerSkyActivity.this);
                        resources = NSTEXOPlayerSkyActivity.this.getResources();
                        i2 = a7.e.w0;
                    } else if (streamVolume < 40) {
                        Z2 = NSTEXOPlayerSkyActivity.Z2(NSTEXOPlayerSkyActivity.this);
                        resources = NSTEXOPlayerSkyActivity.this.getResources();
                        i2 = a7.e.t0;
                    } else if (streamVolume < 80) {
                        Z2 = NSTEXOPlayerSkyActivity.Z2(NSTEXOPlayerSkyActivity.this);
                        resources = NSTEXOPlayerSkyActivity.this.getResources();
                        i2 = a7.e.u0;
                    } else if (streamVolume < 100) {
                        Z2 = NSTEXOPlayerSkyActivity.Z2(NSTEXOPlayerSkyActivity.this);
                        resources = NSTEXOPlayerSkyActivity.this.getResources();
                        i2 = a7.e.v0;
                    } else {
                        Z2 = NSTEXOPlayerSkyActivity.Z2(NSTEXOPlayerSkyActivity.this);
                        resources = NSTEXOPlayerSkyActivity.this.getResources();
                        i2 = a7.e.v0;
                    }
                    Z2.setBackground(resources.getDrawable(i2));
                } catch (Exception unused) {
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            NSTEXOPlayerSkyActivity.this.L4();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            NSTEXOPlayerSkyActivity.this.L4();
            NSTEXOPlayerSkyActivity.this.p3(3000);
        }
    }

    public class C implements Callback {
        public C() {
        }

        public void onFailure(Call call, Throwable th) {
            Log.e("onFailure", th.getMessage().toString());
        }

        public void onResponse(Call call, Response response) {
            Toast makeText;
            NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity;
            String message;
            if (response == null) {
                makeText = Toast.makeText(NSTEXOPlayerSkyActivity.this, "Something went Wrong Report not Submitted", 0);
            } else {
                if (response.body() == null || !response.isSuccessful()) {
                    if (response.message() != null && !response.message().equals("")) {
                        nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                        message = response.message();
                    }
                    makeText = Toast.makeText(NSTEXOPlayerSkyActivity.this, "Something went Wrong Report not Submitted", 0);
                } else if (((ClientFeedbackCallback) response.body()).a() == null || !((ClientFeedbackCallback) response.body()).a().equalsIgnoreCase("success")) {
                    nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                    message = "Something went Wrong";
                } else {
                    nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                    message = "Reported Successfully";
                }
                makeText = Toast.makeText(nSTEXOPlayerSkyActivity, message, 0);
            }
            makeText.show();
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
            NSTEXOPlayerSkyActivity.a3(NSTEXOPlayerSkyActivity.this, this.a, this.c, this.d);
            NSTEXOPlayerSkyActivity.d2(NSTEXOPlayerSkyActivity.this, this.e, view, this.f, this.g, this.h);
            this.i.dismiss();
        }
    }

    public class E implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AdapterView e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;
        public final /* synthetic */ ArrayList h;
        public final /* synthetic */ Dialog i;

        public E(String str, String str2, String str3, AdapterView adapterView, int i, long j, ArrayList arrayList, Dialog dialog) {
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
            NSTEXOPlayerSkyActivity.a3(NSTEXOPlayerSkyActivity.this, this.a, this.c, this.d);
            NSTEXOPlayerSkyActivity.d2(NSTEXOPlayerSkyActivity.this, this.e, view, this.f, this.g, this.h);
            this.i.dismiss();
        }
    }

    public class F implements View.OnClickListener {
        public F() {
        }

        public void onClick(View view) {
            NSTEXOPlayerSkyActivity.this.C3(true);
        }
    }

    public class G implements View.OnClickListener {
        public G() {
        }

        public void onClick(View view) {
        }
    }

    public class H extends BroadcastReceiver {
        public H() {
        }

        public void onReceive(Context context, Intent intent) {
            MyApplication.E("onReceive CLOSE_TARGET_ACTIVITY : ");
            if ("pip_mode_switch_user".equals(intent.getAction())) {
                NSTEXOPlayerSkyActivity.this.finish();
            }
        }
    }

    public class I implements View.OnClickListener {
        public I() {
        }

        public void onClick(View view) {
            m7.w.j(NSTEXOPlayerSkyActivity.this.d);
        }
    }

    public class J implements Runnable {
        public J() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    NSTEXOPlayerSkyActivity.this.y3();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class K extends AsyncTask {
        public K() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return Boolean.valueOf(NSTEXOPlayerSkyActivity.T1(NSTEXOPlayerSkyActivity.this));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this) != null) {
                NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this).setEPGHandler(NSTEXOPlayerSkyActivity.this.P1);
                NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this).setContext(NSTEXOPlayerSkyActivity.this.d);
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public class L implements Runnable {
        public L() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (SharepreferenceDBHandler.getMaintanceModeState(NSTEXOPlayerSkyActivity.this.d)) {
                        NSTEXOPlayerSkyActivity.this.d.startActivity(new Intent(NSTEXOPlayerSkyActivity.this.d, MaintanencePannelActivity.class));
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
                com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity r6 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.this     // Catch: java.lang.Exception -> L5c
                java.lang.String r6 = r6.n3()     // Catch: java.lang.Exception -> L5c
                return r6
            L47:
                com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity r6 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.this     // Catch: java.lang.Exception -> L5c
                java.lang.String r6 = r6.F3()     // Catch: java.lang.Exception -> L5c
                return r6
            L4e:
                com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity r6 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.this     // Catch: java.lang.Exception -> L5c
                java.lang.String r6 = r6.i3()     // Catch: java.lang.Exception -> L5c
                return r6
            L55:
                com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity r6 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.this     // Catch: java.lang.Exception -> L5c
                java.lang.String r6 = r6.g3()     // Catch: java.lang.Exception -> L5c
                return r6
            L5c:
                java.lang.String r6 = "error"
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.M.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (NSTEXOPlayerSkyActivity.C1(NSTEXOPlayerSkyActivity.this) != null) {
                    if (!NSTEXOPlayerSkyActivity.D1(NSTEXOPlayerSkyActivity.this).booleanValue()) {
                        NSTEXOPlayerSkyActivity.E1(NSTEXOPlayerSkyActivity.this, Boolean.TRUE);
                        if (NSTEXOPlayerSkyActivity.C1(NSTEXOPlayerSkyActivity.this).size() != 0) {
                            if (NSTEXOPlayerSkyActivity.F1(NSTEXOPlayerSkyActivity.this) != null) {
                                NSTEXOPlayerSkyActivity.F1(NSTEXOPlayerSkyActivity.this).clear();
                                NSTEXOPlayerSkyActivity.F1(NSTEXOPlayerSkyActivity.this).addAll(NSTEXOPlayerSkyActivity.C1(NSTEXOPlayerSkyActivity.this));
                            }
                            if (SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyActivity.this.d).equals("stalker_api")) {
                                try {
                                    m7.w.N0(NSTEXOPlayerSkyActivity.this.d);
                                    String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTEXOPlayerSkyActivity.this.d);
                                    String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(NSTEXOPlayerSkyActivity.this.d);
                                    if (NSTEXOPlayerSkyActivity.C1(NSTEXOPlayerSkyActivity.this) != null && NSTEXOPlayerSkyActivity.C1(NSTEXOPlayerSkyActivity.this).size() > 0 && NSTEXOPlayerSkyActivity.G1(NSTEXOPlayerSkyActivity.this) < NSTEXOPlayerSkyActivity.C1(NSTEXOPlayerSkyActivity.this).size()) {
                                        NSTEXOPlayerSkyActivity.I1(NSTEXOPlayerSkyActivity.this).c(loggedInMacAddress, stalkerToken, ((LiveStreamsDBModel) NSTEXOPlayerSkyActivity.C1(NSTEXOPlayerSkyActivity.this).get(NSTEXOPlayerSkyActivity.G1(NSTEXOPlayerSkyActivity.this))).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "playFirstTime", 0, "", "");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                                NSTEXOPlayerSkyActivity.J1(nSTEXOPlayerSkyActivity, NSTEXOPlayerSkyActivity.C1(nSTEXOPlayerSkyActivity));
                            }
                        } else {
                            m7.a.Y = Boolean.FALSE;
                            NSTEXOPlayerSkyActivity.this.k4();
                            NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this).setVisibility(8);
                            NSTEXOPlayerSkyActivity.this.o.setVisibility(0);
                            NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity2 = NSTEXOPlayerSkyActivity.this;
                            nSTEXOPlayerSkyActivity2.p.setText(nSTEXOPlayerSkyActivity2.getResources().getString(a7.j.g4));
                        }
                    }
                    NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity3 = NSTEXOPlayerSkyActivity.this;
                    if (nSTEXOPlayerSkyActivity3.U0 && nSTEXOPlayerSkyActivity3.V0 && !nSTEXOPlayerSkyActivity3.W0.equals("")) {
                        NSTEXOPlayerSkyActivity.K1(NSTEXOPlayerSkyActivity.this, 0);
                        try {
                            NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity4 = NSTEXOPlayerSkyActivity.this;
                            NSTEXOPlayerSkyActivity.K1(nSTEXOPlayerSkyActivity4, nSTEXOPlayerSkyActivity4.I3(NSTEXOPlayerSkyActivity.C1(nSTEXOPlayerSkyActivity4), m7.w.r0(NSTEXOPlayerSkyActivity.this.W0)));
                        } catch (Exception | NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                        NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity5 = NSTEXOPlayerSkyActivity.this;
                        nSTEXOPlayerSkyActivity5.U0 = false;
                        nSTEXOPlayerSkyActivity5.V0 = false;
                    }
                    NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity6 = NSTEXOPlayerSkyActivity.this;
                    nSTEXOPlayerSkyActivity6.v4(NSTEXOPlayerSkyActivity.C1(nSTEXOPlayerSkyActivity6));
                }
                NSTEXOPlayerSkyActivity.L1(NSTEXOPlayerSkyActivity.this);
            } catch (Exception unused) {
            }
        }

        public void onPreExecute() {
            TextView textView;
            String string;
            TextView textView2;
            super.onPreExecute();
            try {
                NSTEXOPlayerSkyActivity.B1(NSTEXOPlayerSkyActivity.this);
                TextView textView3 = NSTEXOPlayerSkyActivity.this.Q0;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                if (nSTEXOPlayerSkyActivity.n0 != null) {
                    if (!nSTEXOPlayerSkyActivity.g1.equals("") && NSTEXOPlayerSkyActivity.this.g1.equals("0")) {
                        NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity2 = NSTEXOPlayerSkyActivity.this;
                        nSTEXOPlayerSkyActivity2.n0.setText(nSTEXOPlayerSkyActivity2.d.getResources().getString(a7.j.x));
                        textView2 = NSTEXOPlayerSkyActivity.this.n0;
                    } else if (!NSTEXOPlayerSkyActivity.this.g1.equals("") && NSTEXOPlayerSkyActivity.this.g1.equals("-1")) {
                        NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity3 = NSTEXOPlayerSkyActivity.this;
                        nSTEXOPlayerSkyActivity3.n0.setText(nSTEXOPlayerSkyActivity3.d.getResources().getString(a7.j.b2));
                        textView2 = NSTEXOPlayerSkyActivity.this.n0;
                    } else if (NSTEXOPlayerSkyActivity.this.g1.equals("") || !NSTEXOPlayerSkyActivity.this.g1.equals("-6")) {
                        if (NSTEXOPlayerSkyActivity.this.h1.equals("")) {
                            NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity4 = NSTEXOPlayerSkyActivity.this;
                            textView = nSTEXOPlayerSkyActivity4.n0;
                            string = nSTEXOPlayerSkyActivity4.getResources().getString(a7.j.b8);
                        } else {
                            NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity5 = NSTEXOPlayerSkyActivity.this;
                            textView = nSTEXOPlayerSkyActivity5.n0;
                            string = nSTEXOPlayerSkyActivity5.h1;
                        }
                        textView.setText(string);
                        textView2 = NSTEXOPlayerSkyActivity.this.n0;
                    } else {
                        NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity6 = NSTEXOPlayerSkyActivity.this;
                        nSTEXOPlayerSkyActivity6.n0.setText(nSTEXOPlayerSkyActivity6.d.getResources().getString(a7.j.U5));
                        textView2 = NSTEXOPlayerSkyActivity.this.n0;
                    }
                    textView2.setSelected(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class N extends AsyncTask {
        public N() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            try {
                return NSTEXOPlayerSkyActivity.O1(NSTEXOPlayerSkyActivity.this).equals("-1") ? NSTEXOPlayerSkyActivity.this.G3() : NSTEXOPlayerSkyActivity.O1(NSTEXOPlayerSkyActivity.this).equals("-6") ? NSTEXOPlayerSkyActivity.this.n3() : NSTEXOPlayerSkyActivity.this.k3();
            } catch (Exception unused) {
                return "error";
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (NSTEXOPlayerSkyActivity.P1(NSTEXOPlayerSkyActivity.this) != null) {
                    NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                    nSTEXOPlayerSkyActivity.w4(NSTEXOPlayerSkyActivity.P1(nSTEXOPlayerSkyActivity));
                }
                NSTEXOPlayerSkyActivity.Q1(NSTEXOPlayerSkyActivity.this);
            } catch (Exception unused) {
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            NSTEXOPlayerSkyActivity.M1(NSTEXOPlayerSkyActivity.this);
            LinearLayout linearLayout = NSTEXOPlayerSkyActivity.this.R0;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            if (NSTEXOPlayerSkyActivity.N1(NSTEXOPlayerSkyActivity.this) != null) {
                NSTEXOPlayerSkyActivity.N1(NSTEXOPlayerSkyActivity.this).setVisibility(8);
            }
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

        /* JADX WARN: Removed duplicated region for block: B:84:0x01b7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFocusChange(android.view.View r29, boolean r30) {
            /*
                Method dump skipped, instructions count: 1932
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.O.onFocusChange(android.view.View, boolean):void");
        }
    }

    public class P implements d4.p {
        public P() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Pair a(p1 p1Var) {
            String string = NSTEXOPlayerSkyActivity.this.getString(a7.j.M1);
            u.b cause = p1Var.getCause();
            if (cause instanceof u.b) {
                u.b bVar = cause;
                p3.t tVar = bVar.d;
                string = tVar == null ? bVar.getCause() instanceof B.c ? NSTEXOPlayerSkyActivity.this.getString(a7.j.R1) : bVar.c ? NSTEXOPlayerSkyActivity.this.getString(a7.j.P1, new Object[]{bVar.a}) : NSTEXOPlayerSkyActivity.this.getString(a7.j.O1, new Object[]{bVar.a}) : NSTEXOPlayerSkyActivity.this.getString(a7.j.N1, new Object[]{tVar.a});
            }
            return Pair.create(0, string);
        }

        public /* synthetic */ P(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, k kVar) {
            this();
        }
    }

    public class Q implements t1.d {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                if (nSTEXOPlayerSkyActivity.X4) {
                    return;
                }
                nSTEXOPlayerSkyActivity.U4++;
                m7.w.P0(nSTEXOPlayerSkyActivity.d, NSTEXOPlayerSkyActivity.this.d.getResources().getString(a7.j.g5) + " (" + NSTEXOPlayerSkyActivity.this.U4 + "/" + NSTEXOPlayerSkyActivity.Q2(NSTEXOPlayerSkyActivity.this) + ")");
                NSTEXOPlayerSkyActivity.this.r4();
                NSTEXOPlayerSkyActivity.A2(NSTEXOPlayerSkyActivity.this);
            }
        }

        public Q() {
        }

        private void C(String str) {
            NSTEXOPlayerSkyActivity.this.o.setVisibility(0);
            NSTEXOPlayerSkyActivity.this.p.setText(str);
        }

        private void o() {
            NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
            if (nSTEXOPlayerSkyActivity.U4 >= NSTEXOPlayerSkyActivity.Q2(nSTEXOPlayerSkyActivity)) {
                C(NSTEXOPlayerSkyActivity.this.d.getResources().getString(a7.j.b7));
                NSTEXOPlayerSkyActivity.this.r4();
                NSTEXOPlayerSkyActivity.this.W4 = false;
                NSTEXOPlayerSkyActivity.x6.setVisibility(8);
                return;
            }
            NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity2 = NSTEXOPlayerSkyActivity.this;
            if (nSTEXOPlayerSkyActivity2.X4) {
                return;
            }
            nSTEXOPlayerSkyActivity2.W4 = true;
            nSTEXOPlayerSkyActivity2.M1.postDelayed(new a(), 3000L);
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
                if (NSTEXOPlayerSkyActivity.w3()) {
                    return;
                }
                if (NSTEXOPlayerSkyActivity.O2(NSTEXOPlayerSkyActivity.this) != null && NSTEXOPlayerSkyActivity.O2(NSTEXOPlayerSkyActivity.this).getVisibility() == 0) {
                    NSTEXOPlayerSkyActivity.O2(NSTEXOPlayerSkyActivity.this).setVisibility(8);
                }
                NSTEXOPlayerSkyActivity.x6.setVisibility(0);
                return;
            }
            if (i == 4) {
                o();
                return;
            }
            if (i == 3) {
                if (NSTEXOPlayerSkyActivity.P2(NSTEXOPlayerSkyActivity.this).getVisibility() == 0) {
                    NSTEXOPlayerSkyActivity.O2(NSTEXOPlayerSkyActivity.this).setVisibility(0);
                }
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                nSTEXOPlayerSkyActivity.U4 = 0;
                nSTEXOPlayerSkyActivity.f.setVisibility(8);
                NSTEXOPlayerSkyActivity.this.g.setVisibility(0);
                if (NSTEXOPlayerSkyActivity.t6) {
                    NSTEXOPlayerSkyActivity.this.g.requestFocus();
                }
                NSTEXOPlayerSkyActivity.x6.setVisibility(8);
                LiveStreamDBHandler liveStreamDBHandler2 = NSTEXOPlayerSkyActivity.this.U;
                if (liveStreamDBHandler2 != null) {
                    liveStreamDBHandler2.deleteLiveRecentlyWatched(x7.a.f().g());
                    if (NSTEXOPlayerSkyActivity.u2(NSTEXOPlayerSkyActivity.this).equalsIgnoreCase("true")) {
                        liveStreamDBHandler = NSTEXOPlayerSkyActivity.this.U;
                        g = x7.a.f().g();
                        str = "radio_streams";
                    } else {
                        liveStreamDBHandler = NSTEXOPlayerSkyActivity.this.U;
                        g = x7.a.f().g();
                        str = "live";
                    }
                    liveStreamDBHandler.addLiveRecentlyWatched(g, str);
                    NSTEXOPlayerSkyActivity.this.U.deleteExtraLiveRecentlyWatched();
                }
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
            NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
            if (nSTEXOPlayerSkyActivity.X4) {
                return;
            }
            if (p1Var.a == 1002) {
                NSTEXOPlayerSkyActivity.A2(nSTEXOPlayerSkyActivity);
            } else if (!p1Var.toString().contains("com.google.android.exoplayer2.ext.ffmpeg.FfmpegDecoderException")) {
                o();
            } else {
                m7.w.P0(NSTEXOPlayerSkyActivity.this.d, "Audio track issue found. Please change the audio track to none.");
                NSTEXOPlayerSkyActivity.A2(NSTEXOPlayerSkyActivity.this);
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

        public /* synthetic */ Q(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, k kVar) {
            this();
        }
    }

    public class R extends GestureDetector.SimpleOnGestureListener {
        public boolean a;

        public R() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.a = true;
            return super.onDown(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            NSTEXOPlayerSkyActivity.this.O4();
            return true;
        }
    }

    public class S extends AsyncTask {
        public String a;

        public S(String str) {
            this.a = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HashMap doInBackground(String... strArr) {
            try {
                return NSTEXOPlayerSkyActivity.R1(NSTEXOPlayerSkyActivity.this, this.a);
            } catch (Exception unused) {
                return new HashMap();
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(HashMap hashMap) {
            super.onPostExecute(hashMap);
            NSTEXOPlayerSkyActivity.this.z3(hashMap);
        }

        public void onPreExecute() {
            super.onPreExecute();
            NSTEXOPlayerSkyActivity.this.A3();
        }

        public /* synthetic */ S(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str, k kVar) {
            this(str);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            NSTEXOPlayerSkyActivity.this.onBackPressed();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            try {
                NSTEXOPlayerSkyActivity.this.n2 = Boolean.TRUE;
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", NSTEXOPlayerSkyActivity.this.getPackageName(), (String) null));
                NSTEXOPlayerSkyActivity.this.startActivityForResult(intent, 101);
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                Toast.makeText(nSTEXOPlayerSkyActivity, nSTEXOPlayerSkyActivity.d.getResources().getString(a7.j.o2), 1).show();
            } catch (Exception unused) {
            }
            NSTEXOPlayerSkyActivity.A1(NSTEXOPlayerSkyActivity.this).dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            NSTEXOPlayerSkyActivity.A1(NSTEXOPlayerSkyActivity.this).dismiss();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = m7.w.R(NSTEXOPlayerSkyActivity.this.d);
                String A = m7.w.A(date);
                TextView textView = NSTEXOPlayerSkyActivity.this.L1;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = NSTEXOPlayerSkyActivity.this.J1;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            String cmd;
            n7.g I1;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            NSTEXOPlayerSkyActivity.V1(NSTEXOPlayerSkyActivity.this, i);
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyActivity.this.d).equals("stalker_api")) {
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                NSTEXOPlayerSkyActivity.X1(nSTEXOPlayerSkyActivity, NSTEXOPlayerSkyActivity.U1(nSTEXOPlayerSkyActivity), NSTEXOPlayerSkyActivity.this.P);
                return;
            }
            try {
                String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTEXOPlayerSkyActivity.this.d);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(NSTEXOPlayerSkyActivity.this.d);
                ArrayList g = NSTEXOPlayerSkyActivity.W1(NSTEXOPlayerSkyActivity.this).g();
                if (g != null && g.size() > 0) {
                    cmd = ((LiveStreamsDBModel) g.get(NSTEXOPlayerSkyActivity.U1(NSTEXOPlayerSkyActivity.this))).getCmd();
                    NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity2 = NSTEXOPlayerSkyActivity.this;
                    if (nSTEXOPlayerSkyActivity2.D1 == m7.w.q0(((LiveStreamsDBModel) g.get(NSTEXOPlayerSkyActivity.U1(nSTEXOPlayerSkyActivity2))).getStreamId())) {
                        NSTEXOPlayerSkyActivity.this.C3(true);
                        NSTEXOPlayerSkyActivity.this.onBackPressed();
                        return;
                    }
                    m7.w.N0(NSTEXOPlayerSkyActivity.this.d);
                    I1 = NSTEXOPlayerSkyActivity.I1(NSTEXOPlayerSkyActivity.this);
                    str = "";
                    str2 = "itv";
                    str3 = "";
                    str4 = "";
                    str5 = "";
                    str6 = "";
                    str7 = "";
                    str8 = "channel_click_from_player";
                    str9 = "";
                    I1.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, "");
                }
                if (NSTEXOPlayerSkyActivity.P1(NSTEXOPlayerSkyActivity.this) == null || NSTEXOPlayerSkyActivity.P1(NSTEXOPlayerSkyActivity.this).size() <= 0) {
                    return;
                }
                cmd = ((LiveStreamsDBModel) NSTEXOPlayerSkyActivity.P1(NSTEXOPlayerSkyActivity.this).get(NSTEXOPlayerSkyActivity.U1(NSTEXOPlayerSkyActivity.this))).getCmd();
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity3 = NSTEXOPlayerSkyActivity.this;
                if (nSTEXOPlayerSkyActivity3.D1 == m7.w.q0(((LiveStreamsDBModel) NSTEXOPlayerSkyActivity.P1(nSTEXOPlayerSkyActivity3).get(NSTEXOPlayerSkyActivity.U1(NSTEXOPlayerSkyActivity.this))).getStreamId())) {
                    NSTEXOPlayerSkyActivity.this.C3(true);
                    NSTEXOPlayerSkyActivity.this.onBackPressed();
                    return;
                }
                m7.w.N0(NSTEXOPlayerSkyActivity.this.d);
                I1 = NSTEXOPlayerSkyActivity.I1(NSTEXOPlayerSkyActivity.this);
                str = "";
                str2 = "itv";
                str3 = "";
                str4 = "";
                str5 = "";
                str6 = "";
                str7 = "";
                str8 = "channel_click_from_player";
                str9 = "";
                I1.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, "");
            } catch (Exception unused) {
            }
        }
    }

    public class f implements AdapterView.OnItemSelectedListener {
        public f() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            if (NSTEXOPlayerSkyActivity.Y1(NSTEXOPlayerSkyActivity.this) != null && NSTEXOPlayerSkyActivity.Y1(NSTEXOPlayerSkyActivity.this).getStatus().equals(AsyncTask.Status.RUNNING)) {
                NSTEXOPlayerSkyActivity.Y1(NSTEXOPlayerSkyActivity.this).cancel(true);
            }
            ArrayList e = NSTEXOPlayerSkyActivity.this.W.e();
            if (e != null && e.size() > 0) {
                String epgChannelId = ((LiveStreamsDBModel) e.get(i)).getEpgChannelId();
                NSTEXOPlayerSkyActivity.this.O1.removeCallbacksAndMessages((Object) null);
                if (SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyActivity.this.d).equals("stalker_api")) {
                    NSTEXOPlayerSkyActivity.this.R4(((LiveStreamsDBModel) e.get(i)).getStreamId());
                    return;
                } else {
                    NSTEXOPlayerSkyActivity.Z1(NSTEXOPlayerSkyActivity.this, new S(NSTEXOPlayerSkyActivity.this, epgChannelId, null).execute(new String[0]));
                    return;
                }
            }
            if (NSTEXOPlayerSkyActivity.a2(NSTEXOPlayerSkyActivity.this) == null || NSTEXOPlayerSkyActivity.a2(NSTEXOPlayerSkyActivity.this).size() <= 0) {
                return;
            }
            String epgChannelId2 = ((LiveStreamsDBModel) NSTEXOPlayerSkyActivity.a2(NSTEXOPlayerSkyActivity.this).get(i)).getEpgChannelId();
            NSTEXOPlayerSkyActivity.this.O1.removeCallbacksAndMessages((Object) null);
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyActivity.this.d).equals("stalker_api")) {
                NSTEXOPlayerSkyActivity.Z1(NSTEXOPlayerSkyActivity.this, new S(NSTEXOPlayerSkyActivity.this, epgChannelId2, null).execute(new String[0]));
            } else {
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                nSTEXOPlayerSkyActivity.R4(((LiveStreamsDBModel) NSTEXOPlayerSkyActivity.a2(nSTEXOPlayerSkyActivity).get(i)).getStreamId());
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class g implements AdapterView.OnItemClickListener {
        public final /* synthetic */ ArrayList a;

        public g(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (!m7.a.V0.booleanValue() || !m7.a.e1.equalsIgnoreCase("1")) {
                NSTEXOPlayerSkyActivity.this.o.setVisibility(8);
                NSTEXOPlayerSkyActivity.d2(NSTEXOPlayerSkyActivity.this, adapterView, view, i, j, this.a);
                return;
            }
            if (SharepreferenceDBHandler.getEventAdsView(NSTEXOPlayerSkyActivity.this) >= m7.a.f1) {
                if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
                    NSTEXOPlayerSkyActivity.d2(NSTEXOPlayerSkyActivity.this, adapterView, view, i, j, this.a);
                    return;
                } else {
                    SharepreferenceDBHandler.setEventAdsView(0, NSTEXOPlayerSkyActivity.this);
                    NSTEXOPlayerSkyActivity.c2(NSTEXOPlayerSkyActivity.this, null, null, null, adapterView, view, i, j, this.a);
                    return;
                }
            }
            if (SharepreferenceDBHandler.getEventAdsView(NSTEXOPlayerSkyActivity.this) != 0 || !SharepreferenceDBHandler.getFirstTimeAdsShow(NSTEXOPlayerSkyActivity.this)) {
                NSTEXOPlayerSkyActivity.d2(NSTEXOPlayerSkyActivity.this, adapterView, view, i, j, this.a);
            } else if (Listsingleton.b().a() != null && Listsingleton.b().a().size() > 0) {
                SharepreferenceDBHandler.setFirstTimeAdsShow(false, NSTEXOPlayerSkyActivity.this);
                NSTEXOPlayerSkyActivity.c2(NSTEXOPlayerSkyActivity.this, null, null, null, adapterView, view, i, j, this.a);
            }
            SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(NSTEXOPlayerSkyActivity.this) + 1, NSTEXOPlayerSkyActivity.this);
        }
    }

    public class h implements AdapterView.OnItemLongClickListener {

        public class a implements PopupMenu.OnMenuItemClickListener {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ int d;
            public final /* synthetic */ String e;
            public final /* synthetic */ String f;
            public final /* synthetic */ String g;

            public a(String str, String str2, String str3, int i, String str4, String str5, String str6) {
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = i;
                this.e = str4;
                this.f = str5;
                this.g = str6;
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
            
                r4 = r11.h.a;
                r4.E2 = true;
                r4.r4();
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
            
                if (com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.f2(r11.h.a).equals("m3u") == false) goto L20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
            
                r4 = r11.h.a;
                r5 = r4.H;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
            
                r4.S = r5;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
            
                r4 = new android.content.Intent(r11.h.a.d, com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity.class);
                r4.putExtra("url", r11.h.a.S);
                r4.putExtra("app_name", ((com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) r11.h.a.W2.get(r3)).getAppname());
                r4.putExtra("packagename", ((com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) r11.h.a.W2.get(r3)).getPackagename());
                r11.h.a.d.startActivity(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
            
                r4 = r11.h.a;
                r5 = m7.w.V(r4.d, r4.E, r4.k0, "live");
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onMenuItemClick(android.view.MenuItem r12) {
                /*
                    Method dump skipped, instructions count: 465
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.h.a.onMenuItemClick(android.view.MenuItem):boolean");
            }
        }

        public class b implements PopupMenu.OnDismissListener {
            public b() {
            }

            public void onDismiss(PopupMenu popupMenu) {
            }
        }

        public h() {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0258 A[Catch: Exception -> 0x0075, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0075, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:10:0x0019, B:11:0x0120, B:13:0x0146, B:14:0x015d, B:17:0x016f, B:19:0x017f, B:21:0x0185, B:22:0x018d, B:24:0x0234, B:27:0x0258, B:41:0x02b2, B:42:0x02b5, B:46:0x0191, B:47:0x019f, B:49:0x01ad, B:51:0x01c2, B:53:0x01ce, B:55:0x01de, B:56:0x01e7, B:57:0x01f0, B:58:0x01f9, B:60:0x0218, B:62:0x021e, B:63:0x0226, B:64:0x022a, B:65:0x0152, B:66:0x0078, B:68:0x0080, B:70:0x008c, B:29:0x0260, B:31:0x0266, B:34:0x026d, B:36:0x0277), top: B:2:0x0005, inners: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onItemLongClick(android.widget.AdapterView r21, android.view.View r22, int r23, long r24) {
            /*
                Method dump skipped, instructions count: 767
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.h.onItemLongClick(android.widget.AdapterView, android.view.View, int, long):boolean");
        }
    }

    public class i implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NSTEXOPlayerSkyActivity.this.Z1.setText("");
                NSTEXOPlayerSkyActivity.this.Y1.setVisibility(8);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                NSTEXOPlayerSkyActivity.this.Z1.setText("");
                NSTEXOPlayerSkyActivity.this.Y1.setVisibility(8);
            }
        }

        public i() {
        }

        public void run() {
            ArrayList channelDetails;
            Handler handler;
            Runnable bVar;
            boolean z;
            ArrayList allLiveStreasWithCategoryId;
            NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
            nSTEXOPlayerSkyActivity.W0 = nSTEXOPlayerSkyActivity.X1.toString();
            NSTEXOPlayerSkyActivity.this.Z1.setText("");
            NSTEXOPlayerSkyActivity.this.Y1.setVisibility(8);
            if (NSTEXOPlayerSkyActivity.u2(NSTEXOPlayerSkyActivity.this).equals("true")) {
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity2 = NSTEXOPlayerSkyActivity.this;
                channelDetails = nSTEXOPlayerSkyActivity2.U.getChannelDetails(nSTEXOPlayerSkyActivity2.W0, "radio_streams");
            } else {
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity3 = NSTEXOPlayerSkyActivity.this;
                channelDetails = nSTEXOPlayerSkyActivity3.U.getChannelDetails(nSTEXOPlayerSkyActivity3.W0, "live");
            }
            NSTEXOPlayerSkyActivity.this.X1.setLength(0);
            if (channelDetails == null || channelDetails.size() == 0) {
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity4 = NSTEXOPlayerSkyActivity.this;
                nSTEXOPlayerSkyActivity4.Z1.setText(nSTEXOPlayerSkyActivity4.d.getResources().getString(a7.j.g4));
                NSTEXOPlayerSkyActivity.this.Y1.setVisibility(0);
                handler = new Handler();
                bVar = new b();
            } else {
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity5 = NSTEXOPlayerSkyActivity.this;
                if (nSTEXOPlayerSkyActivity5.U.getParentalStatusCount(SharepreferenceDBHandler.getUserID(nSTEXOPlayerSkyActivity5.d)) <= 0 || NSTEXOPlayerSkyActivity.R2(NSTEXOPlayerSkyActivity.this) == null) {
                    z = false;
                } else {
                    NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity6 = NSTEXOPlayerSkyActivity.this;
                    z = NSTEXOPlayerSkyActivity.v2(nSTEXOPlayerSkyActivity6, channelDetails, NSTEXOPlayerSkyActivity.R2(nSTEXOPlayerSkyActivity6));
                }
                if (!z) {
                    NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity7 = NSTEXOPlayerSkyActivity.this;
                    nSTEXOPlayerSkyActivity7.U0 = true;
                    nSTEXOPlayerSkyActivity7.V0 = true;
                    nSTEXOPlayerSkyActivity7.g1 = "0";
                    nSTEXOPlayerSkyActivity7.h1 = nSTEXOPlayerSkyActivity7.d.getResources().getString(a7.j.x);
                    NSTEXOPlayerSkyActivity.z1(NSTEXOPlayerSkyActivity.this, 0);
                    String num = ((LiveStreamsDBModel) channelDetails.get(0)).getNum();
                    String streamId = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamId();
                    String name = ((LiveStreamsDBModel) channelDetails.get(0)).getName();
                    String epgChannelId = ((LiveStreamsDBModel) channelDetails.get(0)).getEpgChannelId();
                    String streamIcon = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIcon();
                    String url = ((LiveStreamsDBModel) channelDetails.get(0)).getUrl();
                    NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity8 = NSTEXOPlayerSkyActivity.this;
                    nSTEXOPlayerSkyActivity8.F1 = url;
                    NSTEXOPlayerSkyActivity.w2(nSTEXOPlayerSkyActivity8, m7.w.r0(nSTEXOPlayerSkyActivity8.W0));
                    NSTEXOPlayerSkyActivity.x2(NSTEXOPlayerSkyActivity.this, "0");
                    NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity9 = NSTEXOPlayerSkyActivity.this;
                    nSTEXOPlayerSkyActivity9.N4 = nSTEXOPlayerSkyActivity9.g1;
                    NSTEXOPlayerSkyActivity.y1(nSTEXOPlayerSkyActivity9).setTitle(NSTEXOPlayerSkyActivity.this.W0 + " - " + name);
                    NSTEXOPlayerSkyActivity.r2(NSTEXOPlayerSkyActivity.this, NSTEXOPlayerSkyActivity.this.W0 + " - " + name);
                    if (NSTEXOPlayerSkyActivity.u2(NSTEXOPlayerSkyActivity.this).equals("true")) {
                        NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity10 = NSTEXOPlayerSkyActivity.this;
                        allLiveStreasWithCategoryId = nSTEXOPlayerSkyActivity10.U.getAllLiveStreasWithCategoryId(nSTEXOPlayerSkyActivity10.g1, "radio_streams");
                    } else {
                        NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity11 = NSTEXOPlayerSkyActivity.this;
                        allLiveStreasWithCategoryId = nSTEXOPlayerSkyActivity11.U.getAllLiveStreasWithCategoryId(nSTEXOPlayerSkyActivity11.g1, "live");
                    }
                    if (allLiveStreasWithCategoryId != null) {
                        NSTEXOPlayerSkyActivity.a2(NSTEXOPlayerSkyActivity.this).clear();
                    }
                    NSTEXOPlayerSkyActivity.b2(NSTEXOPlayerSkyActivity.this, allLiveStreasWithCategoryId);
                    if (NSTEXOPlayerSkyActivity.a2(NSTEXOPlayerSkyActivity.this) != null && NSTEXOPlayerSkyActivity.a2(NSTEXOPlayerSkyActivity.this).size() > 0) {
                        int i = 0;
                        while (true) {
                            if (i < NSTEXOPlayerSkyActivity.a2(NSTEXOPlayerSkyActivity.this).size()) {
                                if (((LiveStreamsDBModel) NSTEXOPlayerSkyActivity.a2(NSTEXOPlayerSkyActivity.this).get(i)).getNum().equals(num)) {
                                    NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this).setCurrentWindowIndex(i);
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                    try {
                        if (streamIcon.equals("") || streamIcon.isEmpty()) {
                            NSTEXOPlayerSkyActivity.y2(NSTEXOPlayerSkyActivity.this).setImageDrawable(NSTEXOPlayerSkyActivity.this.d.getResources().getDrawable(a7.e.i1));
                        } else {
                            com.squareup.picasso.t.q(NSTEXOPlayerSkyActivity.this.d).l(streamIcon).j(a7.e.i1).d(a7.e.i1).k(80, 55).g(NSTEXOPlayerSkyActivity.y2(NSTEXOPlayerSkyActivity.this));
                        }
                    } catch (Exception unused) {
                        NSTEXOPlayerSkyActivity.y2(NSTEXOPlayerSkyActivity.this).setImageDrawable(NSTEXOPlayerSkyActivity.this.d.getResources().getDrawable(a7.e.i1));
                    }
                    NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this).E();
                    if (NSTEXOPlayerSkyActivity.i2(NSTEXOPlayerSkyActivity.this).booleanValue()) {
                        if (NSTEXOPlayerSkyActivity.f2(NSTEXOPlayerSkyActivity.this).equals("m3u")) {
                            NSTEXOPlayerSkyActivity.z2(NSTEXOPlayerSkyActivity.this, Uri.parse(url));
                            NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this).u(Boolean.valueOf(NSTEXOPlayerSkyActivity.t6));
                            NSTEXOPlayerSkyActivity.J2(NSTEXOPlayerSkyActivity.this, String.valueOf(Uri.parse(url)));
                            x7.a.f().A(NSTEXOPlayerSkyActivity.this.F1);
                        } else {
                            NSTEXOPlayerSkyActivity.z2(NSTEXOPlayerSkyActivity.this, Uri.parse(NSTEXOPlayerSkyActivity.this.e + m7.w.q0(streamId) + NSTEXOPlayerSkyActivity.this.k0));
                            NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this).u(Boolean.valueOf(NSTEXOPlayerSkyActivity.t6));
                            NSTEXOPlayerSkyActivity.J2(NSTEXOPlayerSkyActivity.this, String.valueOf(Uri.parse(NSTEXOPlayerSkyActivity.this.e + m7.w.q0(streamId) + ".m3u8")));
                            x7.a.f().A(streamId);
                        }
                        NSTEXOPlayerSkyActivity.A2(NSTEXOPlayerSkyActivity.this);
                        NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity12 = NSTEXOPlayerSkyActivity.this;
                        nSTEXOPlayerSkyActivity12.U4 = 0;
                        nSTEXOPlayerSkyActivity12.W4 = false;
                    }
                    NSTEXOPlayerSkyActivity.this.P1.removeCallbacksAndMessages((Object) null);
                    NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity13 = NSTEXOPlayerSkyActivity.this;
                    nSTEXOPlayerSkyActivity13.I = epgChannelId;
                    nSTEXOPlayerSkyActivity13.J = streamIcon;
                    NSTEXOPlayerSkyActivity.E2(nSTEXOPlayerSkyActivity13, streamIcon);
                    NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this).setCurrentEpgChannelID(NSTEXOPlayerSkyActivity.this.I);
                    NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this).setCurrentChannelLogo(NSTEXOPlayerSkyActivity.this.J);
                    NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity14 = NSTEXOPlayerSkyActivity.this;
                    nSTEXOPlayerSkyActivity14.Q4(nSTEXOPlayerSkyActivity14.J);
                    if (SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyActivity.this.d).equals("stalker_api")) {
                        NSTEXOPlayerSkyActivity.this.R4(streamId);
                    } else {
                        NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity15 = NSTEXOPlayerSkyActivity.this;
                        NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity16 = NSTEXOPlayerSkyActivity.this;
                        NSTEXOPlayerSkyActivity.Z1(nSTEXOPlayerSkyActivity15, new S(nSTEXOPlayerSkyActivity16, nSTEXOPlayerSkyActivity16.I, null).execute(new String[0]));
                    }
                    NSTEXOPlayerSkyActivity.this.O1.removeCallbacksAndMessages((Object) null);
                    NSTEXOPlayerSkyActivity.this.D1 = m7.w.q0(streamId);
                    if (NSTEXOPlayerSkyActivity.B2(NSTEXOPlayerSkyActivity.this) != null) {
                        NSTEXOPlayerSkyActivity.B2(NSTEXOPlayerSkyActivity.this).putString("currentlyPlayingVideo", streamId);
                        NSTEXOPlayerSkyActivity.B2(NSTEXOPlayerSkyActivity.this).putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", url);
                        NSTEXOPlayerSkyActivity.B2(NSTEXOPlayerSkyActivity.this).apply();
                    }
                    NSTEXOPlayerSkyActivity.this.W.notifyDataSetChanged();
                    channelDetails.clear();
                    return;
                }
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity17 = NSTEXOPlayerSkyActivity.this;
                nSTEXOPlayerSkyActivity17.Z1.setText(nSTEXOPlayerSkyActivity17.d.getResources().getString(a7.j.g4));
                NSTEXOPlayerSkyActivity.this.Y1.setVisibility(0);
                handler = new Handler();
                bVar = new a();
            }
            handler.postDelayed(bVar, 1000L);
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
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyActivity.this.d).equals("stalker_api")) {
                NSTEXOPlayerSkyActivity.D2(NSTEXOPlayerSkyActivity.this, this.a, this.c, this.d);
                return;
            }
            m7.w.N0(NSTEXOPlayerSkyActivity.this.d);
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTEXOPlayerSkyActivity.this.d);
            try {
                NSTEXOPlayerSkyActivity.I1(NSTEXOPlayerSkyActivity.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(NSTEXOPlayerSkyActivity.this.d), stalkerToken, ((LiveStreamsDBModel) NSTEXOPlayerSkyActivity.F1(NSTEXOPlayerSkyActivity.this).get(this.a)).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "zappingLeft", this.a, this.c, this.d);
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

        /* JADX WARN: Removed duplicated region for block: B:16:0x0040 A[Catch: Exception -> 0x016d, PHI: r0
          0x0040: PHI (r0v23 java.lang.String) = 
          (r0v16 java.lang.String)
          (r0v17 java.lang.String)
          (r0v18 java.lang.String)
          (r0v19 java.lang.String)
          (r0v24 java.lang.String)
         binds: [B:58:0x00f0, B:53:0x00c6, B:48:0x009d, B:43:0x0074, B:15:0x003e] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {Exception -> 0x016d, blocks: (B:10:0x0008, B:13:0x0032, B:16:0x0040, B:17:0x010b, B:19:0x0115, B:20:0x015e, B:22:0x011b, B:25:0x0123, B:27:0x0129, B:29:0x0135, B:30:0x013b, B:32:0x0141, B:34:0x0147, B:36:0x0153, B:37:0x0159, B:38:0x0047, B:39:0x004e, B:41:0x0068, B:44:0x0077, B:46:0x0091, B:49:0x00a0, B:51:0x00ba, B:54:0x00ca, B:56:0x00e4, B:59:0x00f4, B:61:0x0100, B:62:0x0106), top: B:9:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0047 A[Catch: Exception -> 0x016d, PHI: r0
          0x0047: PHI (r0v20 java.lang.String) = 
          (r0v16 java.lang.String)
          (r0v17 java.lang.String)
          (r0v18 java.lang.String)
          (r0v19 java.lang.String)
          (r0v24 java.lang.String)
         binds: [B:58:0x00f0, B:53:0x00c6, B:48:0x009d, B:43:0x0074, B:15:0x003e] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x016d, blocks: (B:10:0x0008, B:13:0x0032, B:16:0x0040, B:17:0x010b, B:19:0x0115, B:20:0x015e, B:22:0x011b, B:25:0x0123, B:27:0x0129, B:29:0x0135, B:30:0x013b, B:32:0x0141, B:34:0x0147, B:36:0x0153, B:37:0x0159, B:38:0x0047, B:39:0x004e, B:41:0x0068, B:44:0x0077, B:46:0x0091, B:49:0x00a0, B:51:0x00ba, B:54:0x00ca, B:56:0x00e4, B:59:0x00f4, B:61:0x0100, B:62:0x0106), top: B:9:0x0008 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r6) {
            /*
                Method dump skipped, instructions count: 369
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.l.onClick(android.view.View):void");
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
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.l.onCreate(android.os.Bundle):void");
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public m(int i, String str, String str2) {
            this.a = i;
            this.c = str;
            this.d = str2;
        }

        public void run() {
            if (!SharepreferenceDBHandler.getCurrentAPPType(NSTEXOPlayerSkyActivity.this.d).equals("stalker_api")) {
                NSTEXOPlayerSkyActivity.F2(NSTEXOPlayerSkyActivity.this, this.a, this.c, this.d);
                return;
            }
            m7.w.N0(NSTEXOPlayerSkyActivity.this.d);
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(NSTEXOPlayerSkyActivity.this.d);
            try {
                NSTEXOPlayerSkyActivity.I1(NSTEXOPlayerSkyActivity.this).c(SharepreferenceDBHandler.getLoggedInMacAddress(NSTEXOPlayerSkyActivity.this.d), stalkerToken, ((LiveStreamsDBModel) NSTEXOPlayerSkyActivity.F1(NSTEXOPlayerSkyActivity.this).get(this.a)).getCmd(), "", (View) null, "itv", 0, 0, "", "", "", "", "", "zappingRight", this.a, this.c, this.d);
            } catch (Exception unused) {
            }
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public void run() {
            NSTEXOPlayerSkyActivity.this.P3();
        }
    }

    public class o implements Runnable {
        public o() {
        }

        public void run() {
            NSTEXOPlayerSkyActivity.G2(NSTEXOPlayerSkyActivity.this);
        }
    }

    public class p extends BroadcastReceiver {
        public p() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"media_control".equals(intent.getAction())) {
                return;
            }
            int intExtra = intent.getIntExtra("control_type", 0);
            if (intExtra == 1) {
                NSTEXOPlayerSkyActivity.H2(NSTEXOPlayerSkyActivity.this);
                if (Build.VERSION.SDK_INT >= 26) {
                    NSTEXOPlayerSkyActivity.this.S4(a7.e.x0, "pause", 2, 2);
                    return;
                }
                return;
            }
            if (intExtra != 2) {
                return;
            }
            NSTEXOPlayerSkyActivity.H1(NSTEXOPlayerSkyActivity.this);
            if (Build.VERSION.SDK_INT >= 26) {
                NSTEXOPlayerSkyActivity.this.S4(a7.e.r0, "play", 1, 1);
            }
        }
    }

    public class q extends NSTIJKPlayerSky.w {
        public q() {
        }

        public void a() {
            NSTEXOPlayerSkyActivity.this.S4(a7.e.x0, "pause", 2, 2);
        }

        public void b() {
            NSTEXOPlayerSkyActivity.this.S4(a7.e.r0, "play", 1, 1);
        }
    }

    public class r implements DialogInterface.OnClickListener {
        public r() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class s implements DialogInterface.OnClickListener {
        public s() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            m7.w.n0(NSTEXOPlayerSkyActivity.this.d);
        }
    }

    public class t implements SearchView.m {
        public t() {
        }

        public boolean onQueryTextChange(String str) {
            NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
            if (nSTEXOPlayerSkyActivity.B) {
                nSTEXOPlayerSkyActivity.B = false;
                return false;
            }
            nSTEXOPlayerSkyActivity.Q0.setVisibility(8);
            T t = NSTEXOPlayerSkyActivity.this.W;
            if (t != null) {
                t.getFilter().filter(str);
            }
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NSTEXOPlayerSkyActivity.this.r4();
            m7.w.m0(NSTEXOPlayerSkyActivity.this.d);
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public v() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class w implements o4.f {
        public w() {
        }
    }

    public class x implements Runnable {
        public final /* synthetic */ LinearLayout a;

        public x(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        public void run() {
            this.a.setVisibility(8);
            if (NSTEXOPlayerSkyActivity.P2(NSTEXOPlayerSkyActivity.this).getVisibility() != 0 || NSTEXOPlayerSkyActivity.O2(NSTEXOPlayerSkyActivity.this) == null) {
                return;
            }
            NSTEXOPlayerSkyActivity.O2(NSTEXOPlayerSkyActivity.this).setVisibility(0);
        }
    }

    public class y implements View.OnTouchListener {
        public y() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return (NSTEXOPlayerSkyActivity.this.a1.getVisibility() == 0 || motionEvent == null || !NSTEXOPlayerSkyActivity.S2(NSTEXOPlayerSkyActivity.this).onTouchEvent(motionEvent)) ? false : true;
        }
    }

    public class z implements Runnable {
        public z() {
        }

        public void run() {
            NSTEXOPlayerSkyActivity.this.S3();
        }
    }

    public NSTEXOPlayerSkyActivity() {
        Boolean bool = Boolean.FALSE;
        this.b2 = bool;
        this.c2 = bool;
        this.g2 = "";
        this.m2 = "";
        this.n2 = bool;
        this.p2 = "";
        Boolean bool2 = Boolean.TRUE;
        this.q2 = bool2;
        this.r2 = null;
        this.t2 = -1;
        this.u2 = "";
        this.v2 = 0;
        this.w2 = "";
        this.x2 = "";
        this.y2 = bool2;
        this.z2 = null;
        this.A2 = null;
        this.B2 = null;
        this.C2 = false;
        this.D2 = 0;
        this.E2 = false;
        this.F2 = 4;
        this.G2 = w6[0];
        this.J2 = bool;
        this.K2 = bool;
        this.L2 = bool;
        this.M2 = bool;
        this.N2 = bool;
        this.O2 = bool;
        this.X2 = 0;
        this.Y2 = "0";
        this.Z2 = "0";
        this.a3 = bool2;
        this.k4 = "mobile";
        this.o4 = "0";
        this.p4 = "0";
        this.q4 = 0;
        this.t4 = false;
        this.u4 = false;
        this.w4 = "";
        this.x4 = "";
        this.y4 = 0;
        this.z4 = 0;
        this.C4 = 0;
        this.F4 = "";
        this.G4 = "";
        this.H4 = "";
        this.I4 = false;
        this.J4 = "false";
        this.L4 = m7.a.u0;
        this.N4 = "-10";
        this.O4 = null;
        this.U4 = 0;
        this.V4 = 5;
        this.W4 = false;
        this.X4 = false;
        this.a5 = -1.0f;
        this.Y5 = "";
        this.Z5 = "Live";
        this.a6 = "";
        this.d6 = "";
        this.e6 = "";
        this.f6 = "";
        this.h6 = "";
        this.l6 = null;
        this.m6 = new H();
        this.n6 = new ArrayList();
        this.o6 = new q();
        this.p6 = new A();
        this.q6 = new B();
    }

    public static /* synthetic */ androidx.appcompat.app.a A1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.o2;
    }

    public static /* synthetic */ void A2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        nSTEXOPlayerSkyActivity.X3();
    }

    public static /* synthetic */ void B1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        nSTEXOPlayerSkyActivity.G4();
    }

    public static /* synthetic */ SharedPreferences.Editor B2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.H1;
    }

    private void B3() {
        ImageView imageView = this.e3;
        imageView.setOnFocusChangeListener(new O(imageView));
        ImageView imageView2 = this.f3;
        imageView2.setOnFocusChangeListener(new O(imageView2));
        ImageView imageView3 = this.k3;
        imageView3.setOnFocusChangeListener(new O(imageView3));
        ImageView imageView4 = this.l3;
        imageView4.setOnFocusChangeListener(new O(imageView4));
        ImageView imageView5 = this.m3;
        imageView5.setOnFocusChangeListener(new O(imageView5));
        LinearLayout linearLayout = this.D3;
        linearLayout.setOnFocusChangeListener(new O(linearLayout));
        LinearLayout linearLayout2 = this.z3;
        linearLayout2.setOnFocusChangeListener(new O(linearLayout2));
        LinearLayout linearLayout3 = this.C3;
        linearLayout3.setOnFocusChangeListener(new O(linearLayout3));
        ImageView imageView6 = this.i3;
        imageView6.setOnFocusChangeListener(new O(imageView6));
        ImageView imageView7 = this.j3;
        imageView7.setOnFocusChangeListener(new O(imageView7));
        ImageView imageView8 = this.c3;
        imageView8.setOnFocusChangeListener(new O(imageView8));
        ImageView imageView9 = this.c3;
        imageView9.setOnFocusChangeListener(new O(imageView9));
        RelativeLayout relativeLayout = this.Q5;
        relativeLayout.setOnFocusChangeListener(new O(relativeLayout));
        ImageView imageView10 = this.P5;
        imageView10.setOnFocusChangeListener(new O(imageView10));
        LinearLayout linearLayout4 = this.R5;
        linearLayout4.setOnFocusChangeListener(new O(linearLayout4));
        LinearLayout linearLayout5 = this.S5;
        linearLayout5.setOnFocusChangeListener(new O(linearLayout5));
        CheckBox checkBox = this.w5;
        checkBox.setOnFocusChangeListener(new O(checkBox));
        CheckBox checkBox2 = this.x5;
        checkBox2.setOnFocusChangeListener(new O(checkBox2));
        CheckBox checkBox3 = this.y5;
        checkBox3.setOnFocusChangeListener(new O(checkBox3));
        CheckBox checkBox4 = this.z5;
        checkBox4.setOnFocusChangeListener(new O(checkBox4));
        LinearLayout linearLayout6 = this.T5;
        linearLayout6.setOnFocusChangeListener(new O(linearLayout6));
        CheckBox checkBox5 = this.A5;
        checkBox5.setOnFocusChangeListener(new O(checkBox5));
        CheckBox checkBox6 = this.B5;
        checkBox6.setOnFocusChangeListener(new O(checkBox6));
        CheckBox checkBox7 = this.C5;
        checkBox7.setOnFocusChangeListener(new O(checkBox7));
        CheckBox checkBox8 = this.D5;
        checkBox8.setOnFocusChangeListener(new O(checkBox8));
        CheckBox checkBox9 = this.E5;
        checkBox9.setOnFocusChangeListener(new O(checkBox9));
        LinearLayout linearLayout7 = this.U5;
        linearLayout7.setOnFocusChangeListener(new O(linearLayout7));
        LinearLayout linearLayout8 = this.V5;
        linearLayout8.setOnFocusChangeListener(new O(linearLayout8));
        CheckBox checkBox10 = this.G5;
        checkBox10.setOnFocusChangeListener(new O(checkBox10));
        CheckBox checkBox11 = this.H5;
        checkBox11.setOnFocusChangeListener(new O(checkBox11));
        CheckBox checkBox12 = this.I5;
        checkBox12.setOnFocusChangeListener(new O(checkBox12));
        CheckBox checkBox13 = this.J5;
        checkBox13.setOnFocusChangeListener(new O(checkBox13));
        EditText editText = this.X5;
        editText.setOnFocusChangeListener(new O(editText));
        TextView textView = this.m5;
        textView.setOnFocusChangeListener(new O(textView));
    }

    public static /* synthetic */ ArrayList C1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.y0;
    }

    public static /* synthetic */ String C2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.H4;
    }

    public static /* synthetic */ Boolean D1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.c2;
    }

    public static /* synthetic */ void D2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, int i2, String str, String str2) {
        nSTEXOPlayerSkyActivity.T4(i2, str, str2);
    }

    public static String D3(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    public static /* synthetic */ Boolean E1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, Boolean bool) {
        nSTEXOPlayerSkyActivity.c2 = bool;
        return bool;
    }

    public static /* synthetic */ String E2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str) {
        nSTEXOPlayerSkyActivity.H4 = str;
        return str;
    }

    public static /* synthetic */ ArrayList F1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.B0;
    }

    public static /* synthetic */ void F2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, int i2, String str, String str2) {
        nSTEXOPlayerSkyActivity.U4(i2, str, str2);
    }

    public static /* synthetic */ int G1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.W1;
    }

    public static /* synthetic */ void G2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        nSTEXOPlayerSkyActivity.O3();
    }

    public static /* synthetic */ void H1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        nSTEXOPlayerSkyActivity.pause();
    }

    public static /* synthetic */ void H2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        nSTEXOPlayerSkyActivity.o4();
    }

    public static /* synthetic */ n7.g I1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.v4;
    }

    public static /* synthetic */ String I2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.F4;
    }

    private void I4(Activity activity) {
        new l((NSTEXOPlayerSkyActivity) activity, activity).show();
    }

    public static /* synthetic */ void J1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, ArrayList arrayList) {
        nSTEXOPlayerSkyActivity.p4(arrayList);
    }

    public static /* synthetic */ String J2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str) {
        nSTEXOPlayerSkyActivity.F4 = str;
        return str;
    }

    private ArrayList J3() {
        ArrayList allPasswordStatus = this.U.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.d));
        this.H0 = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.F0.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.F0;
    }

    private void J4() {
        if (this.h5 || !com.nst.iptvsmarterstvbox.view.demo.b.b0(this.P4)) {
            return;
        }
        this.h5 = true;
        com.nst.iptvsmarterstvbox.view.demo.b.P(this.P4, new r7.m(this)).show(getSupportFragmentManager(), (String) null);
    }

    public static /* synthetic */ int K1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, int i2) {
        nSTEXOPlayerSkyActivity.D2 = i2;
        return i2;
    }

    public static /* synthetic */ LinearLayout K2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.x3;
    }

    public static /* synthetic */ void L1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        nSTEXOPlayerSkyActivity.R3();
    }

    public static /* synthetic */ LinearLayout L2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.A3;
    }

    private ArrayList L3(ArrayList arrayList, ArrayList arrayList2) {
        try {
            this.K0 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        this.K0.add(favouriteDBModel);
                        break;
                    }
                    if (favouriteDBModel.getCategoryID().equals((String) it2.next())) {
                        break;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return this.K0;
    }

    public static /* synthetic */ void M1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        nSTEXOPlayerSkyActivity.F4();
    }

    public static /* synthetic */ LinearLayout M2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.B3;
    }

    private ArrayList M3(ArrayList arrayList, ArrayList arrayList2) {
        this.L0 = new ArrayList();
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
                            this.L0.add(favouriteM3UModel);
                            break;
                        }
                        if (favouriteM3UModel.getCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    }
                }
            }
            return this.L0;
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ ListView N1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.M;
    }

    public static /* synthetic */ TextView N2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.m5;
    }

    public static /* synthetic */ String O1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.Z2;
    }

    public static /* synthetic */ LinearLayout O2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.t3;
    }

    private void O3() {
        if (this.w3.getVisibility() == 0) {
            this.w3.startAnimation(this.h4);
            if (this.r3.getVisibility() == 0) {
                this.r3.startAnimation(this.h4);
            }
            if (this.g3.getVisibility() == 0) {
                this.g3.startAnimation(this.h4);
            }
            if (this.t3.getVisibility() == 0) {
                this.t3.startAnimation(this.h4);
            }
            if (this.h3.getVisibility() == 0) {
                this.h3.startAnimation(this.h4);
            }
            if (this.s3.getVisibility() == 0) {
                this.s3.startAnimation(this.h4);
            }
            this.w3.setVisibility(8);
            if (this.r3.getVisibility() == 0) {
                this.r3.setVisibility(8);
            }
            if (this.g3.getVisibility() == 0) {
                this.g3.setVisibility(8);
            }
            if (this.t3.getVisibility() == 0) {
                this.t3.setVisibility(8);
            }
            if (this.h3.getVisibility() == 0) {
                this.h3.setVisibility(8);
            }
            if (this.s3.getVisibility() == 0) {
                this.s3.setVisibility(8);
            }
        }
    }

    public static /* synthetic */ ArrayList P1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.z0;
    }

    public static /* synthetic */ LinearLayout P2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.w3;
    }

    private void P4() {
        LinearLayout linearLayout = this.z;
        if (linearLayout != null) {
            linearLayout.setClickable(true);
            this.z.setOnTouchListener(new y());
        }
    }

    public static /* synthetic */ void Q1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        nSTEXOPlayerSkyActivity.Q3();
    }

    public static /* synthetic */ int Q2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.V4;
    }

    public static /* synthetic */ HashMap R1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str) {
        return nSTEXOPlayerSkyActivity.A4(str);
    }

    public static /* synthetic */ ArrayList R2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.F0;
    }

    private void R3() {
        ProgressBar progressBar = this.x;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public static /* synthetic */ LinearLayout S1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.G3;
    }

    public static /* synthetic */ GestureDetector S2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.Y4;
    }

    public static /* synthetic */ boolean T1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.W3();
    }

    public static /* synthetic */ float T2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.a5;
    }

    public static /* synthetic */ int U1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.z4;
    }

    public static /* synthetic */ float U2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, float f2) {
        nSTEXOPlayerSkyActivity.a5 = f2;
        return f2;
    }

    private void U3() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int V1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, int i2) {
        nSTEXOPlayerSkyActivity.z4 = i2;
        return i2;
    }

    public static /* synthetic */ TextView V2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.N3;
    }

    public static /* synthetic */ q7.O W1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.m4;
    }

    public static /* synthetic */ u7.a W2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.P2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean W3() {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.W3():boolean");
    }

    public static /* synthetic */ void X1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, int i2, ArrayList arrayList) {
        nSTEXOPlayerSkyActivity.n4(i2, arrayList);
    }

    public static /* synthetic */ AudioManager X2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.Z4;
    }

    public static /* synthetic */ AsyncTask Y1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.B2;
    }

    public static /* synthetic */ int Y2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.c5;
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Y3() {
        /*
            Method dump skipped, instructions count: 2622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.Y3():void");
    }

    public static /* synthetic */ AsyncTask Z1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, AsyncTask asyncTask) {
        nSTEXOPlayerSkyActivity.B2 = asyncTask;
        return asyncTask;
    }

    public static /* synthetic */ TextView Z2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.O3;
    }

    public static /* synthetic */ ArrayList a2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.x0;
    }

    public static /* synthetic */ void a3(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str, String str2, String str3) {
        nSTEXOPlayerSkyActivity.c4(str, str2, str3);
    }

    public static /* synthetic */ ArrayList b2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, ArrayList arrayList) {
        nSTEXOPlayerSkyActivity.x0 = arrayList;
        return arrayList;
    }

    public static /* synthetic */ void c2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str, String str2, String str3, AdapterView adapterView, View view, int i2, long j2, ArrayList arrayList) {
        nSTEXOPlayerSkyActivity.d4(str, str2, str3, adapterView, view, i2, j2, arrayList);
    }

    public static /* synthetic */ void d2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, AdapterView adapterView, View view, int i2, long j2, ArrayList arrayList) {
        nSTEXOPlayerSkyActivity.b4(adapterView, view, i2, j2, arrayList);
    }

    public static /* synthetic */ TextView e2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.W3;
    }

    private void e3(Configuration configuration) {
        PlayerView playerView;
        boolean z2;
        View decorView = getWindow().getDecorView();
        if (configuration.orientation == 2) {
            decorView.setSystemUiVisibility(5894);
            playerView = this.k2;
            z2 = false;
        } else {
            decorView.setSystemUiVisibility(256);
            playerView = this.k2;
            z2 = true;
        }
        playerView.setAdjustViewBounds(z2);
    }

    public static /* synthetic */ String f2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.h2;
    }

    public static /* synthetic */ List g2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.A4;
    }

    public static /* synthetic */ DatabaseHandler h2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.G1;
    }

    private void h4() {
        int currentWindowIndex = this.k2.getCurrentWindowIndex();
        if (currentWindowIndex == this.B0.size() - 1) {
            this.k2.setCurrentWindowIndex(0);
        } else {
            this.k2.setCurrentWindowIndex(currentWindowIndex + 1);
        }
    }

    public static /* synthetic */ Boolean i2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.q2;
    }

    public static /* synthetic */ void j2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str, String str2, String str3) {
        nSTEXOPlayerSkyActivity.d3(str, str2, str3);
    }

    public static /* synthetic */ int k2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, int i2) {
        nSTEXOPlayerSkyActivity.C4 = i2;
        return i2;
    }

    public static /* synthetic */ void l2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, int i2, String str) {
        nSTEXOPlayerSkyActivity.b3(i2, str);
    }

    private void l4() {
        this.e3.setOnClickListener(this);
        this.f3.setOnClickListener(this);
        this.y3.setOnClickListener(this);
        this.k3.setOnClickListener(this);
        this.K3.setOnClickListener(this);
        this.l3.setOnClickListener(this);
        this.D3.setOnClickListener(this);
        this.z3.setOnClickListener(this);
        this.C3.setOnClickListener(this);
        this.i3.setOnClickListener(this);
        this.j3.setOnClickListener(this);
        this.u3.setOnClickListener(this);
        this.d3.setOnClickListener(this);
        this.m3.setOnClickListener(this);
        this.P5.setOnClickListener(this);
        this.Q5.setOnClickListener(this);
        this.R5.setOnClickListener(this);
        this.S5.setOnClickListener(this);
        this.T5.setOnClickListener(this);
        this.U5.setOnClickListener(this);
        this.V5.setOnClickListener(this);
        this.n5.setOnClickListener(this);
        this.M5.setOnClickListener(this);
    }

    public static /* synthetic */ void m2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str, int i2, String str2, String str3, String str4) {
        nSTEXOPlayerSkyActivity.c3(str, i2, str2, str3, str4);
    }

    public static /* synthetic */ void n2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str, String str2) {
        nSTEXOPlayerSkyActivity.u4(str, str2);
    }

    public static /* synthetic */ void o2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, int i2, String str) {
        nSTEXOPlayerSkyActivity.s4(i2, str);
    }

    private void o3(int i2) {
        if (PlayerView.B0) {
            return;
        }
        o oVar = new o();
        this.g5 = oVar;
        this.f5.postDelayed(oVar, i2);
    }

    private void o4() {
        I1 i1;
        try {
            if (!this.q2.booleanValue() || (i1 = this.P4) == null) {
                return;
            }
            i1.play();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ String p2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.G4;
    }

    private void pause() {
        I1 i1;
        try {
            if (!this.q2.booleanValue() || (i1 = this.P4) == null) {
                return;
            }
            i1.pause();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void q2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str, int i2, String str2, String str3, String str4) {
        nSTEXOPlayerSkyActivity.t4(str, i2, str2, str3, str4);
    }

    public static /* synthetic */ String r2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str) {
        nSTEXOPlayerSkyActivity.G4 = str;
        return str;
    }

    public static /* synthetic */ SharedPreferences s2() {
        return s6;
    }

    public static /* synthetic */ SharedPreferences t2(SharedPreferences sharedPreferences) {
        s6 = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ void u1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, DialogInterface dialogInterface) {
        nSTEXOPlayerSkyActivity.a4(dialogInterface);
    }

    public static /* synthetic */ String u2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.J4;
    }

    private void v1() {
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.X = sharedPreferences;
        String str = "";
        this.b6 = sharedPreferences.getString("username", "");
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        String o0 = m7.w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
        if (this.a6.equalsIgnoreCase("")) {
            str = "UnCategories";
        } else {
            LiveStreamCategoryIdDBModel channelCatNameFromSelectedCatId = this.U.getChannelCatNameFromSelectedCatId(this.a6);
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
            jsonObject.addProperty("username", this.b6);
            jsonObject.addProperty("macaddress", this.c6);
            jsonObject.addProperty("section", this.Z5);
            jsonObject.addProperty("section_category", str);
            jsonObject.addProperty("report_title", this.e6);
            jsonObject.addProperty("report_sub_title", this.f6);
            jsonObject.addProperty("report_cases", this.k6);
            jsonObject.addProperty("report_custom_message", this.h6);
            jsonObject.addProperty("stream_name", this.d6);
            jsonObject.addProperty("stream_id", Integer.valueOf(this.D1));
            retrofitPost.clientsReportRequest(jsonObject).enqueue(new C());
        }
    }

    public static /* synthetic */ boolean v2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, ArrayList arrayList, ArrayList arrayList2) {
        return nSTEXOPlayerSkyActivity.K3(arrayList, arrayList2);
    }

    public static /* synthetic */ o4.e w1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.S2;
    }

    public static /* synthetic */ int w2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, int i2) {
        nSTEXOPlayerSkyActivity.X2 = i2;
        return i2;
    }

    public static boolean w3() {
        ProgressBar progressBar = x6;
        return progressBar != null && progressBar.getVisibility() == 0;
    }

    public static /* synthetic */ o4.e x1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, o4.e eVar) {
        nSTEXOPlayerSkyActivity.S2 = eVar;
        return eVar;
    }

    public static /* synthetic */ String x2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, String str) {
        nSTEXOPlayerSkyActivity.Y2 = str;
        return str;
    }

    public static long x3(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static /* synthetic */ PlayerView y1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.k2;
    }

    public static /* synthetic */ ImageView y2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity) {
        return nSTEXOPlayerSkyActivity.q;
    }

    private void y4() {
        this.R2 = new k();
    }

    public static /* synthetic */ int z1(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, int i2) {
        nSTEXOPlayerSkyActivity.m0 = i2;
        return i2;
    }

    public static /* synthetic */ Uri z2(NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity, Uri uri) {
        nSTEXOPlayerSkyActivity.T4 = uri;
        return uri;
    }

    private void z4() {
        String str;
        String str2;
        RecyclerView recyclerView;
        this.w3.startAnimation(this.h4);
        this.w3.setVisibility(8);
        this.M3.startAnimation(this.r4);
        this.M3.setVisibility(0);
        this.E3.setVisibility(8);
        this.Z3.setVisibility(8);
        this.M.setVisibility(8);
        if (this.l4 != null && (recyclerView = this.Z3) != null) {
            recyclerView.setAdapter((RecyclerView.g) null);
        }
        String str3 = this.N4;
        if ((str3 != null && str3.equals("-1")) || (((str = this.N4) != null && str.equals("0")) || ((str2 = this.N4) != null && str2.equals("-6")))) {
            String str4 = this.N4;
            this.Y2 = str4;
            this.Z2 = str4;
        }
        this.l4 = new q7.N(this.d, this.Y2, "player", this.J4, "");
        this.Z2 = this.Y2;
        this.Z3.setVisibility(0);
        j3();
        this.Z3.setAdapter(this.l4);
        this.Z3.setLayoutManager(this.n4);
    }

    public void A3() {
        try {
            f4();
            LinearLayout linearLayout = this.v1;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.x1;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            LinearLayout linearLayout3 = this.y1;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            LinearLayout linearLayout4 = this.z1;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            LinearLayout linearLayout5 = this.A1;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            LinearLayout linearLayout6 = this.B1;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
        } catch (Exception unused) {
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
    public final java.util.HashMap A4(java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.A4(java.lang.String):java.util.HashMap");
    }

    public final HashMap B4(StalkerShortEPGCallback stalkerShortEPGCallback) {
        int i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (this.U != null) {
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
                        arrayList.add(1, this.j0.format(valueOf) + " - " + this.j0.format(valueOf2));
                        arrayList.add(2, descr);
                    }
                    M2 = i2;
                }
                arrayList2.add(0, this.j0.format(valueOf) + " - " + this.j0.format(valueOf2));
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
                        arrayList.add(4, this.j0.format(valueOf3) + " - " + this.j0.format(valueOf4));
                        arrayList.add(5, descr2);
                    }
                    arrayList2.add(3, this.j0.format(valueOf3) + " - " + this.j0.format(valueOf4));
                    arrayList2.add(4, name2);
                    arrayList2.add(5, descr2);
                }
                if (2 < stalkerShortEPGCallback.getJs().size()) {
                    long intValue5 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getStartTimestamp().intValue();
                    long intValue6 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getStopTimestamp().intValue();
                    String name3 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getName();
                    String descr3 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(2)).getDescr();
                    arrayList2.add(6, this.j0.format(Long.valueOf(intValue5 * 1000)) + " - " + this.j0.format(Long.valueOf(intValue6 * 1000)));
                    arrayList2.add(7, name3);
                    arrayList2.add(8, descr3);
                }
                if (3 < stalkerShortEPGCallback.getJs().size()) {
                    long intValue7 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getStartTimestamp().intValue();
                    long intValue8 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getStopTimestamp().intValue();
                    String name4 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getName();
                    String descr4 = ((StalkerShortEPGPojo) stalkerShortEPGCallback.getJs().get(3)).getDescr();
                    arrayList2.add(9, this.j0.format(Long.valueOf(intValue7 * 1000)) + " - " + this.j0.format(Long.valueOf(intValue8 * 1000)));
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

    public void C3(boolean z2) {
        t6 = z2;
        String livePlayerAppName = SharepreferenceDBHandler.getLivePlayerAppName(this.d);
        if (!SharepreferenceDBHandler.getLivePlayerPkgName(this.d).equals("default_native") && !new ExternalPlayerDataBase(this.d).CheckPlayerExistense(livePlayerAppName)) {
            SharepreferenceDBHandler.setLivePlayer("default_native", "default", this.d);
        }
        String livePlayerPkgName = SharepreferenceDBHandler.getLivePlayerPkgName(this.d);
        if (!z2 || livePlayerPkgName == null || livePlayerPkgName.equalsIgnoreCase("default_native")) {
            PlayerView playerView = this.k2;
            if (playerView != null) {
                playerView.u(Boolean.valueOf(t6));
            }
            if (m7.a.Y.booleanValue()) {
                Toolbar toolbar = this.O0;
                if (toolbar != null) {
                    toolbar.setVisibility(8);
                }
                findViewById(a7.f.p).setOnClickListener((View.OnClickListener) null);
                this.a1.setVisibility(8);
                this.b1.setVisibility(8);
                this.c1.setVisibility(8);
                this.d1.setVisibility(8);
                this.e1.setVisibility(8);
                getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
                LinearLayout.LayoutParams layoutParams = this.f1.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.f1.setLayoutParams(layoutParams);
                getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
                this.Y0.setVisibility(8);
                I1 i1 = this.P4;
                ((i1 == null || !i1.isPlaying()) ? this.f : this.g).requestFocus();
                return;
            }
            return;
        }
        r4();
        this.E2 = true;
        SharedPreferences sharedPreferences = getSharedPreferences("currentlyPlayingVideoPosition", 0);
        this.f0 = sharedPreferences;
        int i2 = sharedPreferences.getInt("currentlyPlayingVideoPosition", 0);
        ArrayList e2 = this.W.e();
        this.W1 = i2;
        if (e2 == null || e2.size() <= 0 || this.W1 >= e2.size()) {
            ArrayList arrayList = this.x0;
            if (arrayList != null && arrayList.size() > 0 && this.W1 < this.x0.size()) {
                this.t2 = m7.w.r0(((LiveStreamsDBModel) this.x0.get(this.W1)).getStreamId());
                this.i2 = ((LiveStreamsDBModel) this.x0.get(this.W1)).getUrl();
                ((LiveStreamsDBModel) this.x0.get(this.W1)).getName();
            }
        } else {
            this.t2 = m7.w.r0(((LiveStreamsDBModel) e2.get(this.W1)).getStreamId());
            this.i2 = ((LiveStreamsDBModel) e2.get(this.W1)).getUrl();
        }
        this.E = this.t2;
        this.H = this.i2;
        t6 = false;
        PlayerView playerView2 = this.k2;
        if (playerView2 != null) {
            playerView2.u(Boolean.FALSE);
        }
        if (this.h2.equals("m3u")) {
            if (this.q2.booleanValue()) {
                String livePlayerAppName2 = SharepreferenceDBHandler.getLivePlayerAppName(this.d);
                Intent intent = new Intent(this.d, PlayExternalPlayerActivity.class);
                intent.putExtra("url", this.H);
                intent.putExtra("packagename", livePlayerPkgName);
                intent.putExtra("app_name", livePlayerAppName2);
                this.d.startActivity(intent);
                return;
            }
            return;
        }
        if (this.t2 == -1 || !this.q2.booleanValue()) {
            return;
        }
        String V = m7.w.V(this.d, this.t2, this.k0, "live");
        String livePlayerAppName3 = SharepreferenceDBHandler.getLivePlayerAppName(this.d);
        Intent intent2 = new Intent(this.d, PlayExternalPlayerActivity.class);
        intent2.putExtra("url", V);
        intent2.putExtra("packagename", livePlayerPkgName);
        intent2.putExtra("app_name", livePlayerAppName3);
        this.d.startActivity(intent2);
    }

    public void C4() {
        if (PlayerView.B0 || this.w3.getVisibility() != 8) {
            return;
        }
        this.w3.startAnimation(this.g4);
        this.w3.setVisibility(0);
    }

    public void D0(String str) {
    }

    public void D4() {
        if (PlayerView.B0 || this.w3.getVisibility() != 8) {
            return;
        }
        this.w3.startAnimation(this.g4);
        this.w3.setVisibility(0);
        if (this.r3.getVisibility() == 8) {
            this.r3.startAnimation(this.g4);
            this.r3.setVisibility(0);
        }
        if (this.g3.getVisibility() == 8) {
            this.g3.startAnimation(this.g4);
            this.g3.setVisibility(0);
        }
        if (this.t3.getVisibility() == 8) {
            this.t3.startAnimation(this.g4);
            this.t3.setVisibility(0);
        }
        if (this.h3.getVisibility() == 8) {
            this.h3.startAnimation(this.g4);
            this.h3.setVisibility(0);
        }
        if (this.s3.getVisibility() == 8) {
            this.s3.startAnimation(this.g4);
            this.s3.setVisibility(0);
        }
    }

    public void E3() {
        ArrayList arrayList;
        try {
            if (this.h2.equals("m3u")) {
                new ArrayList();
                LiveStreamDBHandler liveStreamDBHandler = this.U;
                if (liveStreamDBHandler == null) {
                    return;
                }
                ArrayList favouriteM3U = liveStreamDBHandler.getFavouriteM3U("live");
                arrayList = new ArrayList();
                ArrayList arrayList2 = this.F0;
                if (arrayList2 != null && arrayList2.size() > 0 && favouriteM3U != null && favouriteM3U.size() > 0) {
                    favouriteM3U = M3(favouriteM3U, this.F0);
                }
                if (favouriteM3U == null || favouriteM3U.size() <= 0) {
                    return;
                }
                Iterator it = favouriteM3U.iterator();
                while (it.hasNext()) {
                    FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                    ArrayList m3UFavouriteRow = this.U.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
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
                    this.N.clear();
                    this.N = this.U.getLiveFavStalker(str);
                    return;
                }
                new ArrayList();
                if (this.G1 == null) {
                    return;
                }
                ArrayList allFavourites = this.J4.equals("true") ? this.G1.getAllFavourites("radio_streams", SharepreferenceDBHandler.getUserID(this.d)) : this.G1.getAllFavourites("live", SharepreferenceDBHandler.getUserID(this.d));
                arrayList = new ArrayList();
                ArrayList arrayList3 = this.F0;
                if (arrayList3 != null && arrayList3.size() > 0 && allFavourites != null && allFavourites.size() > 0) {
                    allFavourites = L3(allFavourites, this.F0);
                }
                if (allFavourites == null || allFavourites.size() <= 0) {
                    return;
                }
                Iterator it2 = allFavourites.iterator();
                while (it2.hasNext()) {
                    FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it2.next();
                    LiveStreamsDBModel liveStreamFavouriteRow = new LiveStreamDBHandler(this.d).getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), String.valueOf(favouriteDBModel.getStreamID()), favouriteDBModel.getTimestamp(), this.Y5);
                    if (liveStreamFavouriteRow != null) {
                        arrayList.add(liveStreamFavouriteRow);
                    }
                }
                if (arrayList.size() == 0) {
                    return;
                }
            }
            this.N = arrayList;
        } catch (Exception unused) {
        }
    }

    public void E4() {
        ProgressBar progressBar;
        if (!PlayerView.B0 && t6 && this.w3.getVisibility() == 8) {
            Handler handler = this.P1;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            Q4(this.J);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                R4(String.valueOf(this.D1));
            } else {
                this.B2 = new S(this, this.I, null).execute(new String[0]);
            }
            this.w3.startAnimation(this.g4);
            this.w3.setVisibility(0);
            if (this.r3.getVisibility() == 8) {
                this.r3.startAnimation(this.g4);
                this.r3.setVisibility(0);
            }
            if (this.g3.getVisibility() == 8) {
                this.g3.startAnimation(this.g4);
                this.g3.setVisibility(0);
            }
            if (this.t3.getVisibility() == 8 && (progressBar = x6) != null && progressBar.getVisibility() != 0) {
                this.t3.startAnimation(this.g4);
                this.t3.setVisibility(0);
            }
            if (this.h3.getVisibility() == 8) {
                this.h3.startAnimation(this.g4);
                this.h3.setVisibility(0);
            }
            if (this.s3.getVisibility() == 8) {
                this.s3.startAnimation(this.g4);
                this.s3.setVisibility(0);
            }
        }
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public String F3() {
        AsyncTask asyncTask;
        try {
            this.D2 = 0;
            E3();
            ArrayList arrayList = this.x0;
            if (arrayList != null && this.v0 != null) {
                arrayList.clear();
                this.v0.clear();
            }
            ArrayList arrayList2 = this.N;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.N.clear();
            }
            ArrayList arrayList3 = this.z0;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            this.x0 = this.N;
            ArrayList arrayList4 = this.y0;
            if (arrayList4 != null) {
                arrayList4.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.P2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.P2.B();
            ArrayList ePGTesting = B2 ? this.U.getEPGTesting((String) null, format) : null;
            this.f0 = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.e0.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api") ? this.e0 : this.e0).getString("currentlyPlayingVideo", "");
            ArrayList arrayList5 = this.x0;
            if (arrayList5 == null || arrayList5.size() <= 0) {
                this.z0 = this.x0;
                return "get_fav";
            }
            for (int i2 = 0; i2 < this.x0.size(); i2++) {
                AsyncTask asyncTask2 = this.z2;
                if (asyncTask2 != null && asyncTask2.isCancelled()) {
                    return "get_fav";
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.x0.get(i2)).getUrl().equals(string)) {
                        this.D2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.D2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamId().equals(string)) {
                    this.D2 = i2;
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
                        if (i3 < ePGTesting.size() && ((asyncTask = this.z2) == null || !asyncTask.isCancelled())) {
                            if (((LiveStreamsDBModel) this.x0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
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
                this.y0.add(liveStreamsDBModel);
                this.z0 = this.y0;
            }
            return "get_fav";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "get_fav";
        }
    }

    public final void F4() {
        LinearLayout linearLayout = this.y;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
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
            this.q4 = 0;
            ArrayList arrayList = this.z0;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList arrayList2 = this.A0;
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
                arrayList3 = this.U.getLiveFavStalker(str3);
            } else {
                ArrayList arrayList4 = new ArrayList();
                if (this.G1 != null) {
                    if (this.J4.equals("true")) {
                        databaseHandler = this.G1;
                        str = "radio_streams";
                        userID = SharepreferenceDBHandler.getUserID(this.d);
                    } else {
                        databaseHandler = this.G1;
                        str = "live";
                        userID = SharepreferenceDBHandler.getUserID(this.d);
                    }
                    ArrayList allFavourites = databaseHandler.getAllFavourites(str, userID);
                    ArrayList arrayList5 = this.F0;
                    if (arrayList5 == null || arrayList5.size() <= 0 || allFavourites == null || allFavourites.size() <= 0) {
                        arrayList4 = allFavourites;
                    } else {
                        try {
                            Iterator it = allFavourites.iterator();
                            while (it.hasNext()) {
                                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
                                Iterator it2 = this.F0.iterator();
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
                                        str2 = this.Y5;
                                    } else {
                                        categoryID = favouriteDBModel2.getCategoryID();
                                        valueOf = String.valueOf(favouriteDBModel2.getStreamID());
                                        timestamp = favouriteDBModel2.getTimestamp();
                                        str2 = this.Y5;
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
                this.z0 = arrayList3;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.P2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.P2.B();
            ArrayList ePGTesting = B2 ? this.U.getEPGTesting((String) null, format) : null;
            this.f0 = getSharedPreferences("currentlyPlayingVideo", 0);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                sharedPreferences = this.e0;
                str4 = "LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U";
            } else {
                sharedPreferences = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api") ? this.e0 : this.e0;
            }
            String string = sharedPreferences.getString(str4, "");
            ArrayList arrayList6 = this.z0;
            if (arrayList6 != null && arrayList6.size() > 0) {
                for (int i2 = 0; i2 < this.z0.size() && ((asyncTask = this.z2) == null || !asyncTask.isCancelled()); i2++) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                        if (((LiveStreamsDBModel) this.z0.get(i2)).getUrl().equals(string)) {
                            this.q4 = i2;
                        }
                    } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                        if (((LiveStreamsDBModel) this.z0.get(i2)).getStreamIdOneStream().equals(string)) {
                            this.q4 = i2;
                        }
                    } else if (((LiveStreamsDBModel) this.z0.get(i2)).getStreamId().equals(string)) {
                        this.q4 = i2;
                    }
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.z0.get(i2)).getNum());
                    liveStreamsDBModel.setName(((LiveStreamsDBModel) this.z0.get(i2)).getName());
                    liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.z0.get(i2)).getStreamType());
                    liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.z0.get(i2)).getStreamId());
                    liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.z0.get(i2)).getStreamIdOneStream());
                    liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.z0.get(i2)).getStreamIcon());
                    liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.z0.get(i2)).getEpgChannelId());
                    liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.z0.get(i2)).getAdded());
                    liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.z0.get(i2)).getCategoryId());
                    liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.z0.get(i2)).getCustomSid());
                    liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.z0.get(i2)).getTvArchive());
                    liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.z0.get(i2)).getDirectSource());
                    liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.z0.get(i2)).getTvArchiveDuration());
                    liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.z0.get(i2)).getTypeName());
                    liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.z0.get(i2)).getCategoryName());
                    liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.z0.get(i2)).getSeriesNo());
                    liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.z0.get(i2)).getLive());
                    liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.z0.get(i2)).getContaiinerExtension());
                    liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.z0.get(i2)).getUrl());
                    if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < ePGTesting.size() && ((asyncTask2 = this.z2) == null || !asyncTask2.isCancelled())) {
                                if (((LiveStreamsDBModel) this.z0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
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
                    this.A0.add(liveStreamsDBModel);
                }
            }
            this.z0 = this.A0;
            return "get_fav";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "get_fav";
        }
    }

    public final void G4() {
        ProgressBar progressBar = this.x;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public void H(String str) {
    }

    public void H3() {
        if (this.O5.getVisibility() == 0) {
            this.R5.setNextFocusRightId(a7.f.ym);
            this.S5.setNextFocusRightId(a7.f.e2);
            this.T5.setNextFocusRightId(a7.f.a2);
            this.U5.setNextFocusRightId(a7.f.V1);
        }
    }

    public void H4() {
        if (this.w3.getVisibility() == 8) {
            this.v3.startAnimation(this.b4);
            this.v3.setVisibility(0);
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

    public final boolean K3(ArrayList arrayList, ArrayList arrayList2) {
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

    public final void K4() {
        ListView listView;
        try {
            if (m7.a.Y.booleanValue()) {
                findViewById(a7.f.p).setOnClickListener(this);
            }
            this.a1.setVisibility(0);
            this.b1.setVisibility(0);
            this.c1.setVisibility(0);
            this.d1.setVisibility(0);
            this.e1.setVisibility(0);
            this.Y0.setVisibility(0);
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            LinearLayout.LayoutParams layoutParams = this.f1.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = 0;
            this.f1.setLayoutParams(layoutParams);
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            t6 = false;
            if (this.U0) {
                if (!this.V0 || this.W0.equals("")) {
                    SharedPreferences sharedPreferences = getSharedPreferences("currentlyPlayingVideoPosition", 0);
                    this.f0 = sharedPreferences;
                    this.L.setSelection(sharedPreferences.getInt("currentlyPlayingVideoPosition", 0));
                    this.U0 = false;
                    this.V0 = false;
                } else {
                    String str = this.g1;
                    if (str != null && !str.equals("") && this.g1.equals("0")) {
                        f3();
                    }
                }
                listView = this.L;
                if (listView == null) {
                    return;
                }
            } else {
                listView = this.L;
                if (listView == null) {
                    return;
                }
            }
            listView.requestFocus();
        } catch (Exception e2) {
            Log.e("exection", "" + e2);
        }
    }

    public void L4() {
        Handler handler;
        if (PlayerView.B0 || (handler = this.f5) == null) {
            return;
        }
        handler.removeCallbacksAndMessages((Object) null);
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
    }

    public void M0(String str) {
        try {
            m7.w.X();
        } catch (Exception unused) {
        }
    }

    public void M4() {
        Handler handler = this.d5;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void N3() {
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

    /* JADX WARN: Removed duplicated region for block: B:8:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int N4() {
        /*
            r6 = this;
            int r0 = r6.F2
            r1 = 1
            int r0 = r0 + r1
            r6.F2 = r0
            java.lang.String r0 = "loginPrefs"
            r2 = 0
            android.content.SharedPreferences r0 = r6.getSharedPreferences(r0, r2)
            r6.H2 = r0
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r6.I2 = r0
            int r0 = r6.F2
            int[] r3 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.w6
            int r4 = r3.length
            int r0 = r0 % r4
            r6.F2 = r0
            r0 = r3[r0]
            r6.G2 = r0
            int r0 = a7.f.X6
            android.view.View r0 = r6.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            int r3 = a7.f.n
            android.view.View r3 = r6.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            com.google.android.exoplayer2.ui.PlayerView r4 = r6.k2
            int r5 = r6.G2
            r4.setResizeMode(r5)
            int r4 = r6.F2
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
            android.content.SharedPreferences$Editor r1 = r6.I2
            java.lang.String r3 = "aspect_ratio"
            int r4 = r6.F2
            r1.putInt(r3, r4)
            android.content.SharedPreferences$Editor r1 = r6.I2
            r1.apply()
            r0.setVisibility(r2)
            android.widget.LinearLayout r1 = r6.t3
            if (r1 == 0) goto L95
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L95
            android.widget.LinearLayout r1 = r6.t3
            r2 = 8
            r1.setVisibility(r2)
        L95:
            android.os.Handler r1 = r6.Q2
            r2 = 0
            r1.removeCallbacksAndMessages(r2)
            android.os.Handler r1 = r6.Q2
            com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity$x r2 = new com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity$x
            r2.<init>(r0)
            r3 = 3000(0xbb8, double:1.482E-320)
            r1.postDelayed(r2, r3)
            int r0 = r6.G2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.N4():int");
    }

    public void O4() {
        RelativeLayout relativeLayout;
        if (PlayerView.B0) {
            M4();
            if (this.v3.getVisibility() == 0) {
                S3();
                return;
            } else {
                H4();
                q3(3000);
                return;
            }
        }
        SeekBar seekBar = this.p3;
        if (seekBar != null) {
            seekBar.setProgress(this.Z4.getStreamVolume(3));
        }
        L4();
        if (this.L3.getVisibility() == 0) {
            this.L3.startAnimation(this.j4);
            relativeLayout = this.L3;
        } else {
            if (this.M3.getVisibility() != 0) {
                if (this.w3.getVisibility() == 0) {
                    P3();
                    return;
                } else {
                    E4();
                    p3(5000);
                    return;
                }
            }
            this.M3.startAnimation(this.s4);
            relativeLayout = this.M3;
        }
        relativeLayout.setVisibility(8);
    }

    public void P(String str) {
        try {
            this.B1.setVisibility(8);
            TextView textView = this.U3;
            if (textView != null) {
                textView.setText("");
            }
            TextView textView2 = this.V3;
            if (textView2 != null) {
                textView2.setText("");
            }
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
        if (PlayerView.B0 || this.w3.getVisibility() != 0) {
            return;
        }
        this.w3.startAnimation(this.h4);
        if (this.r3.getVisibility() == 0) {
            this.r3.startAnimation(this.h4);
        }
        if (this.g3.getVisibility() == 0) {
            this.g3.startAnimation(this.h4);
        }
        if (this.t3.getVisibility() == 0) {
            this.t3.startAnimation(this.h4);
        }
        if (this.h3.getVisibility() == 0) {
            this.h3.startAnimation(this.h4);
        }
        if (this.s3.getVisibility() == 0) {
            this.s3.startAnimation(this.h4);
        }
        this.w3.setVisibility(8);
        if (this.r3.getVisibility() == 0) {
            this.r3.setVisibility(8);
        }
        if (this.g3.getVisibility() == 0) {
            this.g3.setVisibility(8);
        }
        if (this.t3.getVisibility() == 0) {
            this.t3.setVisibility(8);
        }
        if (this.h3.getVisibility() == 0) {
            this.h3.setVisibility(8);
        }
        if (this.s3.getVisibility() == 0) {
            this.s3.setVisibility(8);
        }
    }

    public final void Q3() {
        LinearLayout linearLayout = this.y;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x002d A[Catch: Exception -> 0x0041, TryCatch #1 {Exception -> 0x0041, blocks: (B:19:0x0003, B:21:0x000b, B:23:0x000f, B:3:0x002d, B:5:0x0031), top: B:18:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Q4(java.lang.String r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.Q4(java.lang.String):void");
    }

    public void R4(String str) {
        A3();
        String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.d);
        String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.d);
        try {
            if (this.v4 == null) {
                this.v4 = new n7.g(this, this.d);
            }
            this.v4.e(loggedInMacAddress, stalkerToken, str);
        } catch (Exception unused) {
        }
    }

    public void S3() {
        if (this.v3.getVisibility() == 0) {
            this.v3.startAnimation(this.c4);
            this.v3.setVisibility(8);
        }
    }

    public void S4(int i2, String str, int i3, int i4) {
        try {
            if (this.k4.equals("mobile") && this.t4 && this.L4) {
                ArrayList arrayList = new ArrayList();
                PendingIntent broadcast = PendingIntent.getBroadcast(this, i4, new Intent("media_control").putExtra("control_type", i3), 67108864);
                Icon a2 = p7.p.a(this, i2);
                p7.u.a();
                arrayList.add(p7.t.a(a2, str, str, broadcast));
                p7.q.a(this.D4, arrayList);
                r7.h.a(this, p7.n.a(this.D4));
            }
        } catch (Exception unused) {
        }
    }

    public void T0(StalkerDeletePlayerLinkCallback stalkerDeletePlayerLinkCallback) {
    }

    public void T3() {
        LinearLayout linearLayout = this.F3;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void T4(int i2, String str, String str2) {
        Uri parse;
        try {
            ArrayList arrayList = this.B0;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                this.T4 = Uri.parse(str2);
                this.k2.u(Boolean.valueOf(t6));
                parse = Uri.parse(str2);
            } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                this.T4 = Uri.parse(this.x4);
                this.k2.u(Boolean.valueOf(t6));
                parse = Uri.parse(this.x4);
            } else {
                this.T4 = Uri.parse(this.e + m7.w.q0(((LiveStreamsDBModel) this.B0.get(i2)).getStreamId()) + this.k0);
                this.k2.u(Boolean.valueOf(t6));
                parse = Uri.parse(this.e + m7.w.q0(((LiveStreamsDBModel) this.B0.get(i2)).getStreamId()) + ".m3u8");
            }
            this.F4 = String.valueOf(parse);
            X3();
            this.U4 = 0;
            this.W4 = false;
            this.P1.removeCallbacksAndMessages((Object) null);
            this.I = ((LiveStreamsDBModel) this.B0.get(i2)).getEpgChannelId();
            String streamIcon = ((LiveStreamsDBModel) this.B0.get(i2)).getStreamIcon();
            this.J = streamIcon;
            this.H4 = streamIcon;
            this.k2.setCurrentEpgChannelID(this.I);
            this.k2.setCurrentChannelLogo(this.J);
            Q4(this.J);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                R4(((LiveStreamsDBModel) this.B0.get(i2)).getStreamId());
            } else {
                this.B2 = new S(this, this.I, null).execute(new String[0]);
            }
        } catch (Exception unused) {
        }
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    public final void U4(int i2, String str, String str2) {
        Uri parse;
        try {
            ArrayList arrayList = this.B0;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                this.T4 = Uri.parse(str2);
                this.k2.u(Boolean.valueOf(t6));
                parse = Uri.parse(str2);
            } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                this.T4 = Uri.parse(this.x4);
                this.k2.u(Boolean.valueOf(t6));
                parse = Uri.parse(this.x4);
            } else {
                this.T4 = Uri.parse(this.e + m7.w.q0(((LiveStreamsDBModel) this.B0.get(i2)).getStreamId()) + this.k0);
                this.k2.u(Boolean.valueOf(t6));
                parse = Uri.parse(this.e + m7.w.q0(((LiveStreamsDBModel) this.B0.get(i2)).getStreamId()) + ".m3u8");
            }
            this.F4 = String.valueOf(parse);
            X3();
            this.U4 = 0;
            this.W4 = false;
            this.P1.removeCallbacksAndMessages((Object) null);
            this.I = ((LiveStreamsDBModel) this.B0.get(i2)).getEpgChannelId();
            String streamIcon = ((LiveStreamsDBModel) this.B0.get(i2)).getStreamIcon();
            this.J = streamIcon;
            this.H4 = streamIcon;
            this.k2.setCurrentEpgChannelID(this.I);
            this.k2.setCurrentChannelLogo(this.J);
            Q4(this.J);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                R4(((LiveStreamsDBModel) this.B0.get(i2)).getStreamId());
            } else {
                this.B2 = new S(this, this.I, null).execute(new String[0]);
            }
        } catch (Exception unused) {
        }
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public final void V3() {
        try {
            this.B = true;
            this.O0.e();
            TextView textView = this.Q0;
            if (textView == null || this.C) {
                return;
            }
            textView.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    public void X(StalkerShortEPGCallback stalkerShortEPGCallback) {
        if (stalkerShortEPGCallback != null && stalkerShortEPGCallback.getJs() != null && stalkerShortEPGCallback.getJs().size() > 0) {
            HashMap hashMap = new HashMap();
            try {
                hashMap = B4(stalkerShortEPGCallback);
            } catch (Exception unused) {
            }
            z3(hashMap);
            return;
        }
        try {
            this.B1.setVisibility(8);
            TextView textView = this.U3;
            if (textView != null) {
                textView.setText("");
            }
            TextView textView2 = this.V3;
            if (textView2 != null) {
                textView2.setText("");
            }
            N3();
        } catch (Exception unused2) {
        }
    }

    public final void X3() {
        if (this.T4 != null) {
            r4();
            if (this.P4 == null) {
                G1 b2 = r7.b.b(this, false);
                B3.q qVar = new B3.q(this.Q4);
                Z3.m mVar = new Z3.m(this);
                this.R4 = mVar;
                mVar.m(this.S4);
                I1 a2 = new I1.a(this, b2).b(qVar).c(this.R4).a();
                this.P4 = a2;
                a2.B(new Q(this, null));
                this.P4.W(new d4.q(this.R4));
                this.P4.O(Q2.e.h, true);
                this.P4.o(true);
                this.k2.setPlayer(this.P4);
            }
            this.P4.h0(0, H0.d(this.T4));
            this.P4.prepare();
        }
    }

    public boolean Z3() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        if (i2 >= 33) {
            return true;
        }
        if (r7.i.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        Log.v("TAG", "Permission is revoked");
        D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 101);
        return false;
    }

    public final /* synthetic */ void a4(DialogInterface dialogInterface) {
        this.h5 = false;
    }

    public final void b3(int i2, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            List list = this.A4;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.A4.size(); i3++) {
                    sb.append(this.A4.get(i3));
                    sb.append(",");
                }
            }
            sb.append(i2);
            this.C4 = i2;
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.d);
            this.B4.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.d), stalkerToken, (t.o) null, sb.toString(), "added", str);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public final void b4(AdapterView adapterView, View view, int i2, long j2, ArrayList arrayList) {
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
        this.o.setVisibility(8);
        this.y4 = i2;
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
            m4(this.y4, this.O);
            return;
        }
        try {
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.d);
            String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.d);
            ArrayList e2 = this.W.e();
            if (e2 != null && e2.size() > 0) {
                cmd = ((LiveStreamsDBModel) e2.get(this.y4)).getCmd();
                if (this.D1 != m7.w.q0(((LiveStreamsDBModel) e2.get(this.y4)).getStreamId())) {
                    m7.w.N0(this.d);
                    gVar = this.v4;
                    str = "";
                    str2 = "itv";
                    str3 = "";
                    str4 = "";
                    str5 = "";
                    str6 = "";
                    str7 = "";
                    str8 = "channel_click";
                    str9 = "";
                    gVar.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, "");
                    return;
                }
                C3(true);
            }
            ArrayList arrayList2 = this.x0;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            cmd = ((LiveStreamsDBModel) this.x0.get(this.y4)).getCmd();
            if (this.D1 != m7.w.q0(((LiveStreamsDBModel) this.x0.get(this.y4)).getStreamId())) {
                m7.w.N0(this.d);
                gVar = this.v4;
                str = "";
                str2 = "itv";
                str3 = "";
                str4 = "";
                str5 = "";
                str6 = "";
                str7 = "";
                str8 = "channel_click";
                str9 = "";
                gVar.c(loggedInMacAddress, stalkerToken, cmd, str, (View) null, str2, 0, 0, str3, str4, str5, str6, str7, str8, 0, str9, "");
                return;
            }
            C3(true);
        } catch (Exception unused) {
        }
    }

    public void c(String str) {
    }

    public final void c3(String str, int i2, String str2, String str3, String str4) {
        if (this.d == null || this.W == null || this.G1 == null) {
            return;
        }
        FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
        favouriteDBModel.setCategoryID(str);
        favouriteDBModel.setStreamID(i2);
        favouriteDBModel.setNum(str3);
        favouriteDBModel.setName(str2);
        favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(this.d));
        this.G1.addToFavourite(favouriteDBModel, str4);
        this.W.notifyDataSetChanged();
        m7.w.P0(this.d, str2 + this.d.getResources().getString(a7.j.q));
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c4(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.c4(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2) {
        Context context;
        StringBuilder sb;
        try {
            m7.w.X();
            if (this.W == null || stalkerSetLiveFavCallback == null || stalkerSetLiveFavCallback.getJs() == null || !stalkerSetLiveFavCallback.getJs().equals(Boolean.TRUE)) {
                return;
            }
            this.A4 = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
            if (str.equals("added")) {
                int i2 = this.C4;
                if (i2 != 0) {
                    this.A4.add(Integer.valueOf(i2));
                }
                StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(this.A4);
                this.W.notifyDataSetChanged();
                context = this.d;
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.d.getResources().getString(a7.j.q));
            } else {
                int i3 = this.C4;
                if (i3 != 0) {
                    this.A4.remove(Integer.valueOf(i3));
                    StalkerLiveFavIdsSingleton.getInstance().setFavIdsList(this.A4);
                }
                this.W.notifyDataSetChanged();
                context = this.d;
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.d.getResources().getString(a7.j.c6));
            }
            m7.w.P0(context, sb.toString());
        } catch (Exception unused) {
        }
    }

    public final void d3(String str, String str2, String str3) {
        if (this.d == null || this.W == null || this.U == null) {
            return;
        }
        FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
        favouriteM3UModel.setUrl(str2);
        favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(this.d));
        favouriteM3UModel.setName(str3);
        favouriteM3UModel.setCategoryID(str);
        this.U.addToFavourite(favouriteM3UModel);
        this.W.notifyDataSetChanged();
        m7.w.P0(this.d, str3 + this.d.getResources().getString(a7.j.q));
    }

    public final void d4(String str, String str2, String str3, AdapterView adapterView, View view, int i2, long j2, ArrayList arrayList) {
        if (Listsingleton.b().a() == null || Listsingleton.b().a().size() <= 0) {
            c4(str, str2, str3);
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
        this.R1 = dialog.findViewById(a7.f.C7);
        findViewById2.setOnClickListener(new D(str, str2, str3, adapterView, i2, j2, arrayList, dialog));
        this.R1.setOnClickListener(new E(str, str2, str3, adapterView, i2, j2, arrayList, dialog));
        if (a2 != null) {
            try {
                if (a2.size() > 0) {
                    if (a2.size() > m7.a.k1) {
                        com.squareup.picasso.t.q(this.d).l((String) a2.get(m7.a.k1)).g(findViewById);
                        m7.a.k1++;
                    } else {
                        com.squareup.picasso.t.q(this.d).l((String) a2.get(0)).g(findViewById);
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

    public void e4(String str, String str2) {
        this.Z2 = str;
        j3();
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void f3() {
        v3();
        this.z2 = new M().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels"});
    }

    public final void f4() {
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

    public String g3() {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        try {
            this.D2 = 0;
            ArrayList arrayList = this.x0;
            if (arrayList != null && this.v0 != null) {
                arrayList.clear();
                this.v0.clear();
            }
            if (this.J4.equals("true")) {
                liveStreamDBHandler = this.U;
                str = "radio_streams";
            } else {
                liveStreamDBHandler = this.U;
                str = "live";
            }
            this.x0 = liveStreamDBHandler.getAllLiveStreasWithCategoryId("0", str);
            ArrayList arrayList2 = this.y0;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.P2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.P2.B();
            ArrayList ePGTesting = B2 ? this.U.getEPGTesting((String) null, format) : null;
            this.f0 = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.e0.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : this.e0.getString("currentlyPlayingVideo", "");
            ArrayList arrayList3 = this.x0;
            if (arrayList3 == null || arrayList3.size() <= 0) {
                return "all_channels";
            }
            for (int i2 = 0; i2 < this.x0.size(); i2++) {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.x0.get(i2)).getUrl().equals(string)) {
                        this.D2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.D2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamId().equals(string)) {
                    this.D2 = i2;
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
                this.y0.add(liveStreamsDBModel);
            }
            return "all_channels";
        } catch (Exception unused) {
            return "all_channels";
        }
    }

    public void g4() {
        if (this.k2 == null) {
            return;
        }
        p3(0);
        int i2 = Build.VERSION.SDK_INT;
        Rational rational = new Rational(this.k2.getWidth(), this.k2.getHeight());
        if (i2 >= 26) {
            try {
                try {
                    C3(false);
                    p7.n.a(p7.m.a(this.D4, rational));
                    r7.l.a(this, p7.n.a(this.D4));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                C3(false);
                p7.n.a(p7.m.a(this.D4, new Rational(this.k2.getWidth(), this.k2.getHeight())));
                r7.l.a(this, p7.n.a(this.D4));
            }
        }
    }

    public void h3() {
        v3();
        this.z2 = new M().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels_with_cat"});
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public String i3() {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        String str2;
        try {
            this.D2 = 0;
            ArrayList arrayList = this.x0;
            if (arrayList != null && this.v0 != null) {
                arrayList.clear();
                this.v0.clear();
            }
            if (this.J4.equals("true")) {
                liveStreamDBHandler = this.U;
                str = this.g1;
                str2 = "radio_streams";
            } else {
                liveStreamDBHandler = this.U;
                str = this.g1;
                str2 = "live";
            }
            this.C0 = liveStreamDBHandler.getAllLiveStreasWithCategoryId(str, str2);
            this.x0 = this.C0;
            ArrayList arrayList2 = this.y0;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.P2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.P2.B();
            ArrayList ePGTesting = B2 ? this.U.getEPGTesting((String) null, format) : null;
            this.f0 = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.e0.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : this.e0.getString("currentlyPlayingVideo", "");
            ArrayList arrayList3 = this.x0;
            if (arrayList3 == null || arrayList3.size() <= 0) {
                return "all_channels_with_cat";
            }
            for (int i2 = 0; i2 < this.x0.size(); i2++) {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.x0.get(i2)).getUrl().equals(string)) {
                        this.D2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.D2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamId().equals(string)) {
                    this.D2 = i2;
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
                            int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                            if (M2 != 0) {
                                M2 = 100 - M2;
                            }
                            liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                            liveStreamsDBModel.setEpgPercentage(M2);
                        } else {
                            i3++;
                        }
                    }
                }
                this.y0.add(liveStreamsDBModel);
            }
            return "all_channels_with_cat";
        } catch (Exception unused) {
            return "all_channels_with_cat";
        }
    }

    public void i4() {
        V3();
        this.C2 = false;
        this.D2 = 0;
        AsyncTask asyncTask = this.A2;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            ArrayList arrayList = this.s0;
            if (arrayList != null && arrayList.size() > 0) {
                this.m0 = this.m0 != this.s0.size() + (-1) ? this.m0 + 1 : 0;
                if (this.m0 != 0 || this.x0 == null) {
                    ArrayList arrayList2 = this.s0;
                    if (arrayList2 == null || arrayList2.size() <= 0 || this.m0 >= this.s0.size()) {
                        return;
                    }
                    String liveStreamCategoryID = ((LiveStreamCategoryIdDBModel) this.s0.get(this.m0)).getLiveStreamCategoryID();
                    String liveStreamCategoryName = ((LiveStreamCategoryIdDBModel) this.s0.get(this.m0)).getLiveStreamCategoryName();
                    this.g1 = liveStreamCategoryID;
                    this.h1 = liveStreamCategoryName;
                    if (liveStreamCategoryID != null && !liveStreamCategoryID.equals("") && this.g1.equals("-1")) {
                        l3();
                        return;
                    }
                    String str = this.g1;
                    if (str == null || str.equals("") || !this.g1.equals("-6")) {
                        h3();
                        return;
                    } else {
                        m3();
                        return;
                    }
                }
                this.g1 = "0";
                this.h1 = this.d.getResources().getString(a7.j.x);
            }
            f3();
        }
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public void j3() {
        v3();
        this.z2 = new N().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels_with_cat"});
    }

    public void j4() {
        LinearLayout linearLayout = this.F3;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.E3;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    public String k3() {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        String str2;
        try {
            this.q4 = 0;
            ArrayList arrayList = this.z0;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (this.J4.equals("true")) {
                liveStreamDBHandler = this.U;
                str = this.Z2;
                str2 = "radio_streams";
            } else {
                liveStreamDBHandler = this.U;
                str = this.Z2;
                str2 = "live";
            }
            this.z0 = liveStreamDBHandler.getAllLiveStreasWithCategoryId(str, str2);
            ArrayList arrayList2 = this.A0;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.P2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.P2.B();
            ArrayList ePGTesting = B2 ? this.U.getEPGTesting((String) null, format) : null;
            this.f0 = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.e0.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : this.e0.getString("currentlyPlayingVideo", "");
            ArrayList arrayList3 = this.z0;
            if (arrayList3 != null && arrayList3.size() > 0) {
                for (int i2 = 0; i2 < this.z0.size(); i2++) {
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                        if (((LiveStreamsDBModel) this.z0.get(i2)).getUrl().equals(string)) {
                            this.q4 = i2;
                        }
                    } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                        if (((LiveStreamsDBModel) this.z0.get(i2)).getStreamIdOneStream().equals(string)) {
                            this.q4 = i2;
                        }
                    } else if (((LiveStreamsDBModel) this.z0.get(i2)).getStreamId().equals(string)) {
                        this.q4 = i2;
                    }
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setNum(((LiveStreamsDBModel) this.z0.get(i2)).getNum());
                    liveStreamsDBModel.setName(((LiveStreamsDBModel) this.z0.get(i2)).getName());
                    liveStreamsDBModel.setStreamType(((LiveStreamsDBModel) this.z0.get(i2)).getStreamType());
                    liveStreamsDBModel.setStreamId(((LiveStreamsDBModel) this.z0.get(i2)).getStreamId());
                    liveStreamsDBModel.setStreamIdOneStream(((LiveStreamsDBModel) this.z0.get(i2)).getStreamIdOneStream());
                    liveStreamsDBModel.setStreamIcon(((LiveStreamsDBModel) this.z0.get(i2)).getStreamIcon());
                    liveStreamsDBModel.setEpgChannelId(((LiveStreamsDBModel) this.z0.get(i2)).getEpgChannelId());
                    liveStreamsDBModel.setAdded(((LiveStreamsDBModel) this.z0.get(i2)).getAdded());
                    liveStreamsDBModel.setCategoryId(((LiveStreamsDBModel) this.z0.get(i2)).getCategoryId());
                    liveStreamsDBModel.setCustomSid(((LiveStreamsDBModel) this.z0.get(i2)).getCustomSid());
                    liveStreamsDBModel.setTvArchive(((LiveStreamsDBModel) this.z0.get(i2)).getTvArchive());
                    liveStreamsDBModel.setDirectSource(((LiveStreamsDBModel) this.z0.get(i2)).getDirectSource());
                    liveStreamsDBModel.setTvArchiveDuration(((LiveStreamsDBModel) this.z0.get(i2)).getTvArchiveDuration());
                    liveStreamsDBModel.setTypeName(((LiveStreamsDBModel) this.z0.get(i2)).getTypeName());
                    liveStreamsDBModel.setCategoryName(((LiveStreamsDBModel) this.z0.get(i2)).getCategoryName());
                    liveStreamsDBModel.setSeriesNo(((LiveStreamsDBModel) this.z0.get(i2)).getSeriesNo());
                    liveStreamsDBModel.setLive(((LiveStreamsDBModel) this.z0.get(i2)).getLive());
                    liveStreamsDBModel.setContaiinerExtension(((LiveStreamsDBModel) this.z0.get(i2)).getContaiinerExtension());
                    liveStreamsDBModel.setUrl(((LiveStreamsDBModel) this.z0.get(i2)).getUrl());
                    liveStreamsDBModel.setCmd(((LiveStreamsDBModel) this.z0.get(i2)).getCmd());
                    if (B2 && ePGTesting != null && ePGTesting.size() > 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ePGTesting.size()) {
                                break;
                            }
                            if (((LiveStreamsDBModel) this.z0.get(i2)).getEpgChannelId().equals(((XMLTVProgrammePojo) ePGTesting.get(i3)).getChannel())) {
                                int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                                if (M2 != 0) {
                                    M2 = 100 - M2;
                                }
                                liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                                liveStreamsDBModel.setEpgPercentage(M2);
                            } else {
                                i3++;
                            }
                        }
                    }
                    this.A0.add(liveStreamsDBModel);
                }
            }
            this.z0 = this.A0;
            return "all_channels_with_cat";
        } catch (Exception unused) {
            return "all_channels_with_cat";
        }
    }

    public void k4() {
        m7.a.Y = Boolean.TRUE;
        this.D = true;
        this.o.setVisibility(0);
        this.p.setText(this.d.getResources().getString(a7.j.g4));
        this.B1.setVisibility(8);
        if (m7.a.B.booleanValue()) {
            findViewById(a7.f.Sm).setVisibility(8);
        }
    }

    public void l3() {
        v3();
        this.z2 = new M().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"get_fav"});
    }

    public void m3() {
        v3();
        this.z2 = new M().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"recently_watched"});
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x0591 A[Catch: Exception -> 0x001d, TryCatch #4 {Exception -> 0x001d, blocks: (B:3:0x0006, B:5:0x000b, B:7:0x0017, B:8:0x0021, B:11:0x0041, B:13:0x0047, B:16:0x007c, B:18:0x0090, B:20:0x00b9, B:21:0x00c1, B:23:0x0131, B:25:0x0139, B:27:0x0141, B:29:0x015b, B:31:0x0161, B:32:0x0169, B:40:0x01d6, B:42:0x01ff, B:43:0x021f, B:45:0x0233, B:46:0x0256, B:48:0x025a, B:49:0x0285, B:51:0x0289, B:52:0x0293, B:53:0x0295, B:56:0x020e, B:59:0x01c5, B:60:0x029a, B:62:0x02a0, B:64:0x02b0, B:66:0x02c2, B:68:0x02eb, B:69:0x02f3, B:71:0x036b, B:73:0x0373, B:75:0x037b, B:77:0x0395, B:79:0x039b, B:80:0x03a3, B:88:0x0410, B:90:0x0439, B:91:0x0459, B:93:0x046d, B:95:0x0479, B:96:0x0496, B:97:0x0585, B:158:0x0548, B:170:0x058d, B:172:0x0591, B:173:0x05bc, B:175:0x05c0, B:176:0x05ca, B:177:0x0448, B:183:0x05ce, B:185:0x05e6, B:187:0x060f, B:188:0x0617, B:190:0x068f, B:192:0x0697, B:194:0x069f, B:196:0x06b9, B:198:0x06bf, B:199:0x06c7, B:207:0x0734, B:209:0x075d, B:210:0x077d, B:212:0x0791, B:214:0x079d, B:215:0x07ba, B:216:0x081d, B:217:0x07bd, B:218:0x0825, B:220:0x0829, B:221:0x0854, B:223:0x0858, B:224:0x0862, B:225:0x076c, B:231:0x0866, B:233:0x086d, B:235:0x0873, B:237:0x08b2, B:239:0x08c6, B:241:0x08f3, B:242:0x08fb, B:244:0x0975, B:246:0x097d, B:248:0x0985, B:250:0x09a3, B:252:0x09a9, B:253:0x09b1, B:255:0x09dc, B:256:0x09ff, B:258:0x0a28, B:259:0x0a4a, B:261:0x0a53, B:262:0x0a80, B:264:0x0a84, B:265:0x0a8e, B:266:0x0a39, B:267:0x0a92, B:269:0x0aa8, B:271:0x0ad5, B:272:0x0add, B:274:0x0b5f, B:276:0x0b67, B:278:0x0b6f, B:280:0x0b8d, B:282:0x0b93, B:283:0x0b9b, B:285:0x0bc6, B:287:0x0bd2, B:288:0x0bef, B:289:0x0c58, B:290:0x0bf2, B:291:0x0c60, B:293:0x0c89, B:294:0x0cab, B:296:0x0cb4, B:297:0x0ce1, B:299:0x0ce5, B:300:0x0ced, B:301:0x0c9a, B:34:0x018b, B:36:0x0191, B:38:0x0197, B:58:0x01b3), top: B:2:0x0006, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x05c0 A[Catch: Exception -> 0x001d, TryCatch #4 {Exception -> 0x001d, blocks: (B:3:0x0006, B:5:0x000b, B:7:0x0017, B:8:0x0021, B:11:0x0041, B:13:0x0047, B:16:0x007c, B:18:0x0090, B:20:0x00b9, B:21:0x00c1, B:23:0x0131, B:25:0x0139, B:27:0x0141, B:29:0x015b, B:31:0x0161, B:32:0x0169, B:40:0x01d6, B:42:0x01ff, B:43:0x021f, B:45:0x0233, B:46:0x0256, B:48:0x025a, B:49:0x0285, B:51:0x0289, B:52:0x0293, B:53:0x0295, B:56:0x020e, B:59:0x01c5, B:60:0x029a, B:62:0x02a0, B:64:0x02b0, B:66:0x02c2, B:68:0x02eb, B:69:0x02f3, B:71:0x036b, B:73:0x0373, B:75:0x037b, B:77:0x0395, B:79:0x039b, B:80:0x03a3, B:88:0x0410, B:90:0x0439, B:91:0x0459, B:93:0x046d, B:95:0x0479, B:96:0x0496, B:97:0x0585, B:158:0x0548, B:170:0x058d, B:172:0x0591, B:173:0x05bc, B:175:0x05c0, B:176:0x05ca, B:177:0x0448, B:183:0x05ce, B:185:0x05e6, B:187:0x060f, B:188:0x0617, B:190:0x068f, B:192:0x0697, B:194:0x069f, B:196:0x06b9, B:198:0x06bf, B:199:0x06c7, B:207:0x0734, B:209:0x075d, B:210:0x077d, B:212:0x0791, B:214:0x079d, B:215:0x07ba, B:216:0x081d, B:217:0x07bd, B:218:0x0825, B:220:0x0829, B:221:0x0854, B:223:0x0858, B:224:0x0862, B:225:0x076c, B:231:0x0866, B:233:0x086d, B:235:0x0873, B:237:0x08b2, B:239:0x08c6, B:241:0x08f3, B:242:0x08fb, B:244:0x0975, B:246:0x097d, B:248:0x0985, B:250:0x09a3, B:252:0x09a9, B:253:0x09b1, B:255:0x09dc, B:256:0x09ff, B:258:0x0a28, B:259:0x0a4a, B:261:0x0a53, B:262:0x0a80, B:264:0x0a84, B:265:0x0a8e, B:266:0x0a39, B:267:0x0a92, B:269:0x0aa8, B:271:0x0ad5, B:272:0x0add, B:274:0x0b5f, B:276:0x0b67, B:278:0x0b6f, B:280:0x0b8d, B:282:0x0b93, B:283:0x0b9b, B:285:0x0bc6, B:287:0x0bd2, B:288:0x0bef, B:289:0x0c58, B:290:0x0bf2, B:291:0x0c60, B:293:0x0c89, B:294:0x0cab, B:296:0x0cb4, B:297:0x0ce1, B:299:0x0ce5, B:300:0x0ced, B:301:0x0c9a, B:34:0x018b, B:36:0x0191, B:38:0x0197, B:58:0x01b3), top: B:2:0x0006, inners: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4(int r20, java.util.ArrayList r21) {
        /*
            Method dump skipped, instructions count: 3340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.m4(int, java.util.ArrayList):void");
    }

    public String n3() {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        try {
            this.D2 = 0;
            ArrayList arrayList = this.z0;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList arrayList2 = this.x0;
            if (arrayList2 != null && this.v0 != null) {
                arrayList2.clear();
                this.v0.clear();
            }
            ArrayList arrayList3 = this.C0;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            if (this.J4.equalsIgnoreCase("true")) {
                liveStreamDBHandler = this.U;
                str = "radio_streams";
            } else {
                liveStreamDBHandler = this.U;
                str = "live";
            }
            this.C0 = liveStreamDBHandler.getAllRecentlyWatchedLiveStreams(str);
            this.x0 = this.C0;
            ArrayList arrayList4 = this.y0;
            if (arrayList4 != null) {
                arrayList4.clear();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(this.P2.C()));
            String format = simpleDateFormat.format(Long.valueOf(LocalDateTime.now().toDateTime().getMillis() + m7.w.S(this.d)));
            boolean B2 = this.P2.B();
            ArrayList ePGTesting = B2 ? this.U.getEPGTesting((String) null, format) : null;
            this.f0 = getSharedPreferences("currentlyPlayingVideo", 0);
            String string = SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.e0.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : this.e0.getString("currentlyPlayingVideo", "");
            ArrayList arrayList5 = this.x0;
            if (arrayList5 == null || arrayList5.size() <= 0) {
                return "all_channels_with_cat";
            }
            for (int i2 = 0; i2 < this.x0.size(); i2++) {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
                    if (((LiveStreamsDBModel) this.x0.get(i2)).getUrl().equals(string)) {
                        this.D2 = i2;
                    }
                } else if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                    if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamIdOneStream().equals(string)) {
                        this.D2 = i2;
                    }
                } else if (((LiveStreamsDBModel) this.x0.get(i2)).getStreamId().equals(string)) {
                    this.D2 = i2;
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
                            int M2 = m7.w.M(m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStart(), this.d), m7.w.x(((XMLTVProgrammePojo) ePGTesting.get(i3)).getStop(), this.d), this.d);
                            if (M2 != 0) {
                                M2 = 100 - M2;
                            }
                            liveStreamsDBModel.setProgramName(((XMLTVProgrammePojo) ePGTesting.get(i3)).getTitle());
                            liveStreamsDBModel.setEpgPercentage(M2);
                        } else {
                            i3++;
                        }
                    }
                }
                this.y0.add(liveStreamsDBModel);
            }
            this.z0 = this.y0;
            return "all_channels_with_cat";
        } catch (Exception unused) {
            return "all_channels_with_cat";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0820  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0df1  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0c81 A[Catch: Exception -> 0x0c43, TryCatch #20 {Exception -> 0x0c43, blocks: (B:450:0x0c1f, B:383:0x0c4a, B:385:0x0c81, B:386:0x0cb0, B:388:0x0cb4, B:389:0x0cbc, B:468:0x0ccb, B:311:0x0d21), top: B:302:0x0a36 }] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0cb4 A[Catch: Exception -> 0x0c43, TryCatch #20 {Exception -> 0x0c43, blocks: (B:450:0x0c1f, B:383:0x0c4a, B:385:0x0c81, B:386:0x0cb0, B:388:0x0cb4, B:389:0x0cbc, B:468:0x0ccb, B:311:0x0d21), top: B:302:0x0a36 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0f4c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0f73  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0f89  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0f9f  */
    /* JADX WARN: Type inference failed for: r10v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28, types: [int] */
    /* JADX WARN: Type inference failed for: r12v55 */
    /* JADX WARN: Type inference failed for: r12v56, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v57 */
    /* JADX WARN: Type inference failed for: r12v58 */
    /* JADX WARN: Type inference failed for: r12v59 */
    /* JADX WARN: Type inference failed for: r12v60 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v74 */
    /* JADX WARN: Type inference failed for: r12v75 */
    /* JADX WARN: Type inference failed for: r12v76 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n4(int r24, java.util.ArrayList r25) {
        /*
            Method dump skipped, instructions count: 4021
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.n4(int, java.util.ArrayList):void");
    }

    public void o0(String str) {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i2, i3, intent);
        if (i2 == 101) {
            try {
                if (Z3()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("downloadStatus", 0);
                    s6 = sharedPreferences;
                    String string = sharedPreferences.getString("downloadStatus", "");
                    m7.w wVar = new m7.w();
                    if (string.equals("processing")) {
                        wVar.L0(this);
                    } else {
                        wVar.O0(this, this.s2, this.k0, this.e, this.E, this.H, this.F);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onBackPressed() {
        RelativeLayout relativeLayout;
        try {
            L4();
            relativeLayout = this.M3;
        } catch (Exception unused) {
        }
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.M3.startAnimation(this.s4);
            this.M3.setVisibility(8);
            return;
        }
        if (this.L3.getVisibility() == 0) {
            this.L3.startAnimation(this.j4);
            this.L3.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout2 = this.Q5;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            this.Q5.setVisibility(8);
            this.O5.setVisibility(8);
            this.O5.startAnimation(this.h4);
            this.Q5.startAnimation(this.h4);
            this.G5.setChecked(false);
            this.H5.setChecked(false);
            this.I5.setChecked(false);
            this.J5.setChecked(false);
            this.A5.setChecked(false);
            this.B5.setChecked(false);
            this.C5.setChecked(false);
            this.D5.setChecked(false);
            this.E5.setChecked(false);
            this.w5.setChecked(false);
            this.x5.setChecked(false);
            this.y5.setChecked(false);
            this.z5.setChecked(false);
            this.X5.setText("");
            return;
        }
        if (t6) {
            if (this.w3.getVisibility() != 0) {
                Toolbar toolbar = this.O0;
                if (toolbar != null) {
                    toolbar.setVisibility(0);
                }
                K4();
                return;
            }
            this.w3.startAnimation(this.h4);
            if (this.r3.getVisibility() == 0) {
                this.r3.startAnimation(this.h4);
            }
            if (this.g3.getVisibility() == 0) {
                this.g3.startAnimation(this.h4);
            }
            if (this.t3.getVisibility() == 0) {
                this.t3.startAnimation(this.h4);
            }
            if (this.h3.getVisibility() == 0) {
                this.h3.startAnimation(this.h4);
            }
            if (this.s3.getVisibility() == 0) {
                this.s3.startAnimation(this.h4);
            }
            this.w3.setVisibility(8);
            if (this.r3.getVisibility() == 0) {
                this.r3.setVisibility(8);
            }
            if (this.g3.getVisibility() == 0) {
                this.g3.setVisibility(8);
            }
            if (this.t3.getVisibility() == 0) {
                this.t3.setVisibility(8);
            }
            if (this.h3.getVisibility() == 0) {
                this.h3.setVisibility(8);
            }
            if (this.s3.getVisibility() == 0) {
                this.s3.setVisibility(8);
                return;
            }
            return;
        }
        if (this.k4.equals("mobile") && this.t4 && this.L4) {
            try {
                g4();
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
                checkBox = this.G5;
            }
        } else if (compoundButton.getId() == a7.f.X1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.H5;
            }
        } else if (compoundButton.getId() == a7.f.Y1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.I5;
            }
        } else if (compoundButton.getId() == a7.f.W1) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.J5;
            }
        } else if (compoundButton.getId() == a7.f.e2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.w5;
            }
        } else if (compoundButton.getId() == a7.f.g2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.x5;
            }
        } else if (compoundButton.getId() == a7.f.h2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.y5;
            }
        } else if (compoundButton.getId() == a7.f.f2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.z5;
            }
        } else if (compoundButton.getId() == a7.f.a2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.A5;
            }
        } else if (compoundButton.getId() == a7.f.c2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.B5;
            }
        } else if (compoundButton.getId() == a7.f.d2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.C5;
            }
        } else if (compoundButton.getId() == a7.f.b2) {
            if (!isChecked) {
                return;
            } else {
                checkBox = this.D5;
            }
        } else if (compoundButton.getId() != a7.f.Z1 || !isChecked) {
            return;
        } else {
            checkBox = this.E5;
        }
        this.g6 = checkBox.getText().toString();
    }

    public void onClick(View view) {
        String str;
        String str2;
        x7.a f2;
        String valueOf;
        StringBuilder sb;
        x7.a f3;
        String valueOf2;
        String sb2;
        StringBuilder sb3;
        Exception exc;
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
            if (id == a7.f.I5) {
                if (!this.k4.equals("tv")) {
                    I1 i1 = this.P4;
                    if (i1 == null || i1.getPlaybackState() != 3) {
                        L4();
                        D4();
                        p3(5000);
                        imageView = this.e3;
                    } else {
                        L4();
                        D4();
                        p3(1000);
                        o4();
                        this.e3.setVisibility(8);
                        imageView = this.f3;
                    }
                    imageView.setVisibility(0);
                    return;
                }
                I1 i12 = this.P4;
                if (i12 == null || i12.getPlaybackState() != 3) {
                    L4();
                    C4();
                    o3(5000);
                    this.e3.setVisibility(0);
                    imageView2 = this.e3;
                } else {
                    L4();
                    C4();
                    o3(1000);
                    o4();
                    this.e3.setVisibility(8);
                    this.f3.setVisibility(0);
                    imageView2 = this.f3;
                }
                imageView2.requestFocus();
                return;
            }
            if (id == a7.f.H5) {
                try {
                    if (this.k4.equals("tv")) {
                        L4();
                        C4();
                        pause();
                        this.f3.setVisibility(8);
                        this.e3.setVisibility(0);
                        this.e3.requestFocus();
                    } else {
                        L4();
                        D4();
                        pause();
                        this.f3.setVisibility(8);
                        this.e3.setVisibility(0);
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
                                C3(true);
                                return;
                            } catch (Exception e3) {
                                sb3 = new StringBuilder();
                                sb3.append("exection ");
                                sb3.append(e3.getMessage());
                            }
                        } else if (id == a7.f.f1) {
                            try {
                                AppBarLayout appBarLayout = this.S0;
                                if (appBarLayout != null) {
                                    toggleView(appBarLayout);
                                    this.S0.requestFocusFromTouch();
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
                                    r3();
                                    return;
                                } catch (Exception e5) {
                                    exc = e5;
                                    sb3 = new StringBuilder();
                                }
                            } else {
                                if (id != a7.f.W0) {
                                    if (id == a7.f.Z6 || id == a7.f.C4) {
                                        L4();
                                        O3();
                                        J4();
                                        return;
                                    }
                                    if (id == a7.f.c7 || id == a7.f.E4) {
                                        onBackPressed();
                                    } else if (id != a7.f.I4 && id != a7.f.J4) {
                                        if (id == a7.f.x8) {
                                            L4();
                                            O3();
                                            PlayerView.B0 = true;
                                            this.k2.M();
                                            this.k2.p(3000);
                                            return;
                                        }
                                        if (id == a7.f.i6) {
                                            L4();
                                            PlayerView.B0 = false;
                                            this.v3.startAnimation(this.c4);
                                            this.v3.setVisibility(8);
                                            D4();
                                            p3(3000);
                                            return;
                                        }
                                        if (id == a7.f.w7) {
                                            L4();
                                            O3();
                                            return;
                                        }
                                        if (id == a7.f.v7) {
                                            L4();
                                            O3();
                                            z4();
                                            return;
                                        }
                                        if (id == a7.f.B7) {
                                            L4();
                                            o3(5000);
                                            N4();
                                            return;
                                        }
                                        if (id == a7.f.y7 || id == a7.f.S4) {
                                            L4();
                                            O3();
                                            if (this.Q5.getVisibility() == 8) {
                                                this.Q5.startAnimation(this.i4);
                                                this.Q5.setVisibility(0);
                                                this.R5.requestFocus();
                                                this.L5.requestFocus();
                                                this.G5.setChecked(false);
                                                this.H5.setChecked(false);
                                                this.I5.setChecked(false);
                                                this.J5.setChecked(false);
                                                this.A5.setChecked(false);
                                                this.B5.setChecked(false);
                                                this.C5.setChecked(false);
                                                this.D5.setChecked(false);
                                                this.E5.setChecked(false);
                                                this.w5.setChecked(false);
                                                this.x5.setChecked(false);
                                                this.y5.setChecked(false);
                                                this.z5.setChecked(false);
                                                this.X5.setText("");
                                                return;
                                            }
                                            return;
                                        }
                                        if (id == a7.f.x1) {
                                            this.e6 = this.o5.getText().toString();
                                            this.f6 = this.s5.getText().toString();
                                            i3 = 0;
                                            this.O5.setVisibility(0);
                                            this.k5.setVisibility(0);
                                            i4 = 8;
                                            this.j5.setVisibility(8);
                                            this.l5.setVisibility(8);
                                            this.W5.setVisibility(8);
                                        } else {
                                            if (id == a7.f.Jg) {
                                                this.e6 = this.p5.getText().toString();
                                                this.f6 = this.t5.getText().toString();
                                                this.O5.setVisibility(0);
                                                i4 = 8;
                                                this.k5.setVisibility(8);
                                                this.W5.setVisibility(8);
                                                this.j5.setVisibility(0);
                                                this.X5.setVisibility(0);
                                                this.l5.setVisibility(8);
                                                this.F5.setVisibility(i4);
                                                textView = this.n5;
                                                resources = getResources();
                                                i2 = a7.j.Q7;
                                                textView.setText(resources.getString(i2));
                                                return;
                                            }
                                            if (id == a7.f.X) {
                                                this.e6 = this.q5.getText().toString();
                                                this.f6 = this.u5.getText().toString();
                                                i3 = 0;
                                                this.O5.setVisibility(0);
                                                i4 = 8;
                                                this.k5.setVisibility(8);
                                                this.j5.setVisibility(8);
                                                this.W5.setVisibility(8);
                                                this.l5.setVisibility(0);
                                            } else {
                                                if (id == a7.f.k) {
                                                    this.e6 = this.r5.getText().toString();
                                                    this.f6 = this.v5.getText().toString();
                                                    this.O5.setVisibility(0);
                                                    this.k5.setVisibility(8);
                                                    this.j5.setVisibility(8);
                                                    this.l5.setVisibility(8);
                                                    this.W5.setVisibility(8);
                                                    this.F5.setVisibility(0);
                                                    this.X5.setVisibility(0);
                                                    textView = this.n5;
                                                    resources = getResources();
                                                    i2 = a7.j.Q7;
                                                    textView.setText(resources.getString(i2));
                                                    return;
                                                }
                                                if (id == a7.f.v2) {
                                                    this.O5.setVisibility(0);
                                                    this.k5.setVisibility(8);
                                                    this.j5.setVisibility(8);
                                                    this.l5.setVisibility(8);
                                                    this.F5.setVisibility(8);
                                                    this.W5.setVisibility(0);
                                                    this.X5.setVisibility(4);
                                                    this.V5.setVisibility(0);
                                                    textView = this.n5;
                                                    resources = getResources();
                                                    i2 = a7.j.y0;
                                                    textView.setText(resources.getString(i2));
                                                    return;
                                                }
                                                if (id != a7.f.tm) {
                                                    return;
                                                }
                                                if (this.W5.getVisibility() == 0) {
                                                    try {
                                                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getResources().getString(a7.j.z0))));
                                                    } catch (ActivityNotFoundException e6) {
                                                        Toast.makeText(this, "No application can handle this request. Please install a webbrowser", 1).show();
                                                        e6.printStackTrace();
                                                    }
                                                    this.Q5.setVisibility(8);
                                                    return;
                                                }
                                                this.h6 = this.X5.getText().toString();
                                                u3();
                                                if (this.A5.isChecked() || this.B5.isChecked() || this.C5.isChecked() || this.D5.isChecked() || this.E5.isChecked() || this.G5.isChecked() || this.H5.isChecked() || this.I5.isChecked() || this.J5.isChecked() || this.w5.isChecked() || this.x5.isChecked() || this.y5.isChecked() || this.z5.isChecked() || this.X5.length() > 0) {
                                                    v1();
                                                    this.G5.setChecked(false);
                                                    this.H5.setChecked(false);
                                                    this.I5.setChecked(false);
                                                    this.J5.setChecked(false);
                                                    this.A5.setChecked(false);
                                                    this.B5.setChecked(false);
                                                    this.C5.setChecked(false);
                                                    this.D5.setChecked(false);
                                                    this.E5.setChecked(false);
                                                    this.w5.setChecked(false);
                                                    this.x5.setChecked(false);
                                                    this.y5.setChecked(false);
                                                    this.z5.setChecked(false);
                                                    this.X5.setText("");
                                                    RelativeLayout relativeLayout = this.Q5;
                                                    if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                                                        return;
                                                    }
                                                    this.Q5.setVisibility(8);
                                                    this.O5.setVisibility(8);
                                                    this.O5.startAnimation(this.h4);
                                                    this.Q5.startAnimation(this.h4);
                                                    return;
                                                }
                                                makeText = Toast.makeText(this.d, "Please Add Report", 0);
                                            }
                                        }
                                        this.X5.setVisibility(i3);
                                        this.F5.setVisibility(i4);
                                        textView = this.n5;
                                        resources = getResources();
                                        i2 = a7.j.Q7;
                                        textView.setText(resources.getString(i2));
                                        return;
                                    }
                                    onBackPressed();
                                    return;
                                }
                                try {
                                    i4();
                                    return;
                                } catch (Exception e7) {
                                    exc = e7;
                                    sb3 = new StringBuilder();
                                }
                            }
                            sb3.append("exection ");
                            sb3.append(exc);
                        }
                        sb2 = sb3.toString();
                        Log.e("NSTIJPLAYER", sb2);
                        return;
                    }
                    try {
                        AsyncTask asyncTask = this.B2;
                        if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
                            this.B2.cancel(true);
                        }
                        L4();
                        D4();
                        p3(5000);
                        if (this.k2 != null) {
                            this.h.requestFocus();
                            this.M1.removeCallbacksAndMessages((Object) null);
                            this.U0 = true;
                            h4();
                            int currentWindowIndex = this.k2.getCurrentWindowIndex();
                            ArrayList arrayList = this.B0;
                            if (arrayList == null || arrayList.size() <= 1 || currentWindowIndex > this.B0.size() - 1 || currentWindowIndex <= -1) {
                                return;
                            }
                            String name = ((LiveStreamsDBModel) this.B0.get(currentWindowIndex)).getName();
                            String url = ((LiveStreamsDBModel) this.B0.get(currentWindowIndex)).getUrl();
                            this.F1 = url;
                            String num = ((LiveStreamsDBModel) this.B0.get(currentWindowIndex)).getNum();
                            this.X2 = m7.w.r0(((LiveStreamsDBModel) this.B0.get(currentWindowIndex)).getNum());
                            String streamIcon = ((LiveStreamsDBModel) this.B0.get(currentWindowIndex)).getStreamIcon();
                            try {
                                if (streamIcon.equals("") || streamIcon.isEmpty()) {
                                    this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                                } else {
                                    com.squareup.picasso.t.q(this.d).l(streamIcon).j(a7.e.i1).d(a7.e.i1).k(80, 55).g(this.q);
                                }
                            } catch (Exception unused) {
                                this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                            }
                            this.k2.setTitle(num + " - " + name);
                            this.G4 = num + " - " + name;
                            this.W1 = currentWindowIndex;
                            this.T1.clear();
                            this.T1.apply();
                            this.U1.clear();
                            this.U1.apply();
                            this.S1.clear();
                            this.S1.apply();
                            if (this.q2.booleanValue()) {
                                this.M1.postDelayed(new m(currentWindowIndex, name, url), SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api") ? 1000 : 200);
                            }
                            this.O1.removeCallbacksAndMessages((Object) null);
                            this.D1 = m7.w.q0(((LiveStreamsDBModel) this.B0.get(currentWindowIndex)).getStreamId());
                            if (this.h2.equals("m3u")) {
                                f3 = x7.a.f();
                                valueOf2 = this.F1;
                            } else {
                                f3 = x7.a.f();
                                valueOf2 = String.valueOf(this.D1);
                            }
                            f3.A(valueOf2);
                            SharedPreferences.Editor editor = this.H1;
                            if (editor != null) {
                                editor.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) this.B0.get(currentWindowIndex)).getStreamId()));
                                this.H1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", ((LiveStreamsDBModel) this.B0.get(currentWindowIndex)).getUrl());
                                this.H1.apply();
                            }
                            SharedPreferences.Editor editor2 = this.I1;
                            if (editor2 != null) {
                                editor2.putInt("currentlyPlayingVideoPosition", currentWindowIndex);
                                this.I1.apply();
                            }
                            if (this.D2 != 0) {
                                this.D2 = currentWindowIndex;
                            }
                            this.W.notifyDataSetChanged();
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
                    AsyncTask asyncTask2 = this.B2;
                    if (asyncTask2 != null && asyncTask2.getStatus().equals(AsyncTask.Status.RUNNING)) {
                        this.B2.cancel(true);
                    }
                    L4();
                    D4();
                    p3(5000);
                    if (this.k2 != null) {
                        this.i.requestFocus();
                        this.M1.removeCallbacksAndMessages((Object) null);
                        q4();
                        this.U0 = true;
                        int currentWindowIndex2 = this.k2.getCurrentWindowIndex();
                        ArrayList arrayList2 = this.B0;
                        if (arrayList2 == null || arrayList2.size() <= 1 || currentWindowIndex2 > this.B0.size() - 1 || currentWindowIndex2 <= -1) {
                            return;
                        }
                        String name2 = ((LiveStreamsDBModel) this.B0.get(currentWindowIndex2)).getName();
                        String num2 = ((LiveStreamsDBModel) this.B0.get(currentWindowIndex2)).getNum();
                        this.X2 = m7.w.r0(((LiveStreamsDBModel) this.B0.get(currentWindowIndex2)).getNum());
                        String url2 = ((LiveStreamsDBModel) this.B0.get(currentWindowIndex2)).getUrl();
                        this.F1 = url2;
                        String streamIcon2 = ((LiveStreamsDBModel) this.B0.get(currentWindowIndex2)).getStreamIcon();
                        try {
                            if (streamIcon2.equals("") || streamIcon2.isEmpty()) {
                                this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                            } else {
                                com.squareup.picasso.t.q(this.d).l(streamIcon2).j(a7.e.i1).d(a7.e.i1).k(80, 55).g(this.q);
                            }
                        } catch (Exception unused2) {
                            this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
                        }
                        this.k2.setTitle(num2 + " - " + name2);
                        this.G4 = num2 + " - " + name2;
                        this.W1 = currentWindowIndex2;
                        this.T1.clear();
                        this.T1.apply();
                        this.U1.clear();
                        this.U1.apply();
                        this.S1.clear();
                        this.S1.apply();
                        if (this.q2.booleanValue()) {
                            this.M1.postDelayed(new j(currentWindowIndex2, name2, url2), SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api") ? 1000 : 200);
                        }
                        this.O1.removeCallbacksAndMessages((Object) null);
                        this.D1 = m7.w.q0(((LiveStreamsDBModel) this.B0.get(currentWindowIndex2)).getStreamId());
                        if (this.h2.equals("m3u")) {
                            f2 = x7.a.f();
                            valueOf = this.F1;
                        } else {
                            f2 = x7.a.f();
                            valueOf = String.valueOf(this.D1);
                        }
                        f2.A(valueOf);
                        SharedPreferences.Editor editor3 = this.H1;
                        if (editor3 != null) {
                            editor3.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) this.B0.get(currentWindowIndex2)).getStreamId()));
                            this.H1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", ((LiveStreamsDBModel) this.B0.get(currentWindowIndex2)).getUrl());
                            this.H1.apply();
                        }
                        SharedPreferences.Editor editor4 = this.I1;
                        if (editor4 != null) {
                            editor4.putInt("currentlyPlayingVideoPosition", currentWindowIndex2);
                            this.I1.apply();
                        }
                        if (this.D2 != 0) {
                            this.D2 = currentWindowIndex2;
                        }
                        this.W.notifyDataSetChanged();
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
            this.I4 = true;
            if (this.D) {
                return;
            }
            pause();
            this.f3.setVisibility(8);
            this.e3.setVisibility(0);
            r4();
            if (this.h2.equals("m3u")) {
                if (this.q2.booleanValue()) {
                    Intent intent = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
                    intent.putExtra("url", this.F1);
                    x7.a.f().A(this.F1);
                    intent.putExtra("CHANNEL_NUM", this.X2);
                    this.d.startActivity(intent);
                    return;
                }
                return;
            }
            if (this.D1 == -1 || !this.q2.booleanValue()) {
                return;
            }
            String V = m7.w.V(this.d, this.D1, this.k0, "live");
            x7.a.f().A(String.valueOf(this.D1));
            Intent intent2 = new Intent(this.d, NSTIJKPlayerMultiActivity.class);
            intent2.putExtra("url", V);
            intent2.putExtra("CHANNEL_NUM", this.X2);
            this.d.startActivity(intent2);
            return;
        }
        makeText = Toast.makeText(this.d, "This feature has been disabled.", 1);
        makeText.show();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e3(configuration);
    }

    public void onCreate(Bundle bundle) {
        m.e eVar;
        m.d P2;
        this.d = this;
        U3();
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        this.Q4 = r7.b.d(this);
        SharedPreferences sharedPreferences = getSharedPreferences("auto_start", 0);
        this.i5 = sharedPreferences;
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
        this.S4 = P2;
        SharedPreferences sharedPreferences2 = this.d.getSharedPreferences("auto_start", 0);
        this.K4 = sharedPreferences2;
        boolean z3 = sharedPreferences2.getBoolean("picinpic", m7.a.u0);
        this.L4 = z3;
        if (z3 && Build.VERSION.SDK_INT >= 26) {
            this.D4 = p7.v.a();
        }
        setContentView(a7.g.B);
        this.b3 = findViewById(a7.f.Xa);
        this.p3 = findViewById(a7.f.Lf);
        this.q3 = findViewById(a7.f.Kf);
        this.r3 = findViewById(a7.f.j7);
        this.s3 = findViewById(a7.f.Ea);
        this.N3 = findViewById(a7.f.Mh);
        this.O3 = findViewById(a7.f.mm);
        this.t3 = findViewById(a7.f.h9);
        this.L3 = findViewById(a7.f.lf);
        this.M3 = findViewById(a7.f.ne);
        this.c3 = findViewById(a7.f.m5);
        this.u3 = findViewById(a7.f.x8);
        this.v3 = findViewById(a7.f.O9);
        this.d3 = findViewById(a7.f.i6);
        this.P3 = findViewById(a7.f.uk);
        this.Q3 = findViewById(a7.f.Ak);
        this.R3 = findViewById(a7.f.Ck);
        this.w3 = findViewById(a7.f.t9);
        this.e3 = findViewById(a7.f.I5);
        this.f3 = findViewById(a7.f.H5);
        this.g3 = findViewById(a7.f.Cl);
        this.h3 = findViewById(a7.f.El);
        this.x3 = findViewById(a7.f.b7);
        this.i3 = findViewById(a7.f.I4);
        this.j3 = findViewById(a7.f.J4);
        this.k3 = findViewById(a7.f.E4);
        this.y3 = findViewById(a7.f.c7);
        this.l3 = findViewById(a7.f.C4);
        this.z3 = findViewById(a7.f.B7);
        this.m3 = findViewById(a7.f.n5);
        this.A3 = findViewById(a7.f.Y6);
        this.B3 = findViewById(a7.f.L9);
        this.C3 = findViewById(a7.f.S8);
        this.D3 = findViewById(a7.f.v7);
        this.S3 = findViewById(a7.f.lj);
        this.T3 = findViewById(a7.f.ei);
        this.U3 = findViewById(a7.f.al);
        this.V3 = findViewById(a7.f.Pl);
        this.Z3 = findViewById(a7.f.Fd);
        this.E3 = findViewById(a7.f.i9);
        this.F3 = findViewById(a7.f.W8);
        this.G3 = findViewById(a7.f.r7);
        this.W3 = findViewById(a7.f.Vh);
        this.H3 = findViewById(a7.f.w7);
        this.a4 = findViewById(a7.f.K1);
        this.n3 = findViewById(a7.f.W5);
        this.I3 = findViewById(a7.f.g7);
        this.J3 = findViewById(a7.f.h7);
        this.X3 = findViewById(a7.f.ah);
        this.Y3 = findViewById(a7.f.Hk);
        this.o3 = findViewById(a7.f.F4);
        this.K3 = findViewById(a7.f.Z6);
        this.j5 = findViewById(a7.f.Hg);
        this.k5 = findViewById(a7.f.w1);
        this.l5 = findViewById(a7.f.Z);
        this.m5 = findViewById(a7.f.ym);
        this.w5 = findViewById(a7.f.e2);
        this.x5 = findViewById(a7.f.g2);
        this.y5 = findViewById(a7.f.h2);
        this.z5 = findViewById(a7.f.f2);
        this.A5 = findViewById(a7.f.a2);
        this.B5 = findViewById(a7.f.c2);
        this.C5 = findViewById(a7.f.d2);
        this.D5 = findViewById(a7.f.b2);
        this.E5 = findViewById(a7.f.Z1);
        this.F5 = findViewById(a7.f.j);
        this.G5 = findViewById(a7.f.V1);
        this.H5 = findViewById(a7.f.X1);
        this.I5 = findViewById(a7.f.Y1);
        this.J5 = findViewById(a7.f.W1);
        this.n5 = findViewById(a7.f.tm);
        this.K5 = findViewById(a7.f.z7);
        this.o5 = findViewById(a7.f.v1);
        this.p5 = findViewById(a7.f.Fg);
        this.q5 = findViewById(a7.f.a0);
        this.r5 = findViewById(a7.f.l);
        this.s5 = findViewById(a7.f.y1);
        this.t5 = findViewById(a7.f.Lg);
        this.u5 = findViewById(a7.f.b0);
        this.v5 = findViewById(a7.f.m);
        this.X5 = findViewById(a7.f.K3);
        this.L5 = findViewById(a7.f.X3);
        this.M5 = findViewById(a7.f.y7);
        this.N5 = findViewById(a7.f.xa);
        this.O5 = findViewById(a7.f.a);
        this.P5 = findViewById(a7.f.S4);
        this.Q5 = findViewById(a7.f.ee);
        this.R5 = findViewById(a7.f.x1);
        this.S5 = findViewById(a7.f.Jg);
        this.T5 = findViewById(a7.f.X);
        this.U5 = findViewById(a7.f.k);
        this.V5 = findViewById(a7.f.v2);
        this.W5 = findViewById(a7.f.u2);
        overridePendingTransition(a7.b.f, a7.b.d);
        if (m7.a.V0.booleanValue()) {
            this.N5.setVisibility(0);
        } else {
            this.N5.setVisibility(4);
        }
        this.P2 = new u7.a(this.d);
        try {
            this.U2 = new w();
            this.T2 = o4.b.e(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Y3();
        RelativeLayout relativeLayout = this.Z0;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new F());
        }
        this.F0 = J3();
        String str = this.g1;
        this.N4 = str;
        if (str == null || str.equals("") || !this.g1.equals("0")) {
            String str2 = this.g1;
            if (str2 == null || str2.equals("") || !this.g1.equals("-1")) {
                String str3 = this.g1;
                if (str3 == null || str3.equals("") || !this.g1.equals("-6")) {
                    h3();
                } else {
                    m3();
                }
            } else {
                l3();
            }
        } else {
            f3();
        }
        this.A2 = new K().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        H3();
        String I1 = FreeTrailActivity.I1();
        this.c6 = I1;
        if (I1.equals("") || this.c6.isEmpty()) {
            this.c6 = m7.w.I(this.d);
        }
        this.G5.setOnCheckedChangeListener(this);
        this.H5.setOnCheckedChangeListener(this);
        this.I5.setOnCheckedChangeListener(this);
        this.J5.setOnCheckedChangeListener(this);
        this.A5.setOnCheckedChangeListener(this);
        this.B5.setOnCheckedChangeListener(this);
        this.C5.setOnCheckedChangeListener(this);
        this.D5.setOnCheckedChangeListener(this);
        this.E5.setOnCheckedChangeListener(this);
        this.w5.setOnCheckedChangeListener(this);
        this.x5.setOnCheckedChangeListener(this);
        this.y5.setOnCheckedChangeListener(this);
        this.z5.setOnCheckedChangeListener(this);
        this.m5.setOnClickListener(new G());
        p0.a.b(this.d).c(this.m6, new IntentFilter("pip_mode_switch_user"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.O0.x(a7.h.r);
        this.d2 = menu;
        this.e2 = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("api")) {
            menu.getItem(2).getSubMenu().findItem(a7.f.gb).setVisible(false);
        }
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, this.d.getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.O0.getChildCount(); i2++) {
            if (this.O0.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.O0.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.m6 != null) {
                p0.a.b(this.d).e(this.m6);
            }
            v3();
            this.X4 = true;
            r4();
            o4.b.e(this.d).c().e(this.R2, o4.e.class);
        } catch (Exception unused) {
        }
        try {
            Thread thread = this.l6;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.l6.interrupt();
        } catch (Exception unused2) {
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        keyEvent.getRepeatCount();
        keyEvent.getAction();
        boolean z2 = t6;
        if (z2) {
            if (i2 == 20) {
                this.q2.booleanValue();
                return true;
            }
            if (i2 == 19) {
                this.q2.booleanValue();
                return true;
            }
        }
        if (i2 == 166) {
            if (z2) {
                this.q2.booleanValue();
            }
            return true;
        }
        if (i2 != 167) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (z2) {
            this.q2.booleanValue();
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        I1 i1;
        StringBuilder sb;
        keyEvent.getRepeatCount();
        if (i2 != 62) {
            if (i2 != 66) {
                if (i2 != 79) {
                    if (i2 == 82) {
                        Menu menu = this.d2;
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
                                if (t6 && !SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api") && !SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                                    this.Q1.removeCallbacksAndMessages((Object) null);
                                    int i3 = 7;
                                    if (i2 == 7) {
                                        this.X1.append(0);
                                    } else if (i2 == 8) {
                                        this.X1.append(1);
                                    } else {
                                        if (i2 == 9) {
                                            sb = this.X1;
                                            i3 = 2;
                                        } else if (i2 == 10) {
                                            sb = this.X1;
                                            i3 = 3;
                                        } else if (i2 == 11) {
                                            sb = this.X1;
                                            i3 = 4;
                                        } else if (i2 == 12) {
                                            sb = this.X1;
                                            i3 = 5;
                                        } else if (i2 == 13) {
                                            sb = this.X1;
                                            i3 = 6;
                                        } else if (i2 == 14) {
                                            sb = this.X1;
                                        } else if (i2 == 15) {
                                            this.X1.append(8);
                                        } else if (i2 == 16) {
                                            this.X1.append(9);
                                        }
                                        sb.append(i3);
                                    }
                                    this.Z1.setText(this.X1.toString());
                                    this.Y1.setVisibility(0);
                                    this.Q1.postDelayed(new i(), 3000L);
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
        try {
            if (this.q2.booleanValue() && (i1 = this.P4) != null) {
                if (i1 == null || !i1.isPlaying()) {
                    o4();
                } else {
                    pause();
                }
            }
        } catch (Exception unused) {
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
        V3();
        this.e2 = menuItem;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.d) != null) {
            new a.a(context, a7.k.a).setTitle(this.d.getResources().getString(a7.j.f3)).f(this.d.getResources().getString(a7.j.e3)).j(this.d.getResources().getString(a7.j.S8), new s()).g(this.d.getResources().getString(a7.j.d4), new r()).n();
        }
        if (itemId == a7.f.g) {
            SearchView b2 = P.w.b(menuItem);
            this.P0 = b2;
            b2.setQueryHint(this.d.getResources().getString(a7.j.A6));
            this.P0.setIconifiedByDefault(false);
            this.P0.setOnQueryTextListener(new t());
            return true;
        }
        if (itemId == a7.f.gb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.d.getResources().getString(a7.j.u0));
            aVar.f(this.d.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.d.getResources().getString(a7.j.S8), new u());
            aVar.g(this.d.getResources().getString(a7.j.d4), new v());
            aVar.n();
        }
        if (itemId == a7.f.mb) {
            I4(this);
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.O4;
            if (thread != null && thread.isAlive()) {
                this.O4.interrupt();
            }
        } catch (Exception unused) {
        }
        this.X4 = true;
        try {
            o4.b bVar = this.T2;
            if (bVar != null) {
                bVar.c().e(this.R2, o4.e.class);
            }
        } catch (Exception unused2) {
        }
    }

    public void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        try {
            super/*androidx.activity.ComponentActivity*/.onPictureInPictureModeChanged(z2, configuration);
            if (z2) {
                m7.a.p1 = true;
                PlayerView playerView = this.k2;
                if (playerView != null && playerView.a != null) {
                    playerView.setShowOrHideSubtitles("gone");
                    this.k2.a.setVisibility(8);
                }
                p pVar = new p();
                this.E4 = pVar;
                registerReceiver(pVar, new IntentFilter("media_control"));
                return;
            }
            t6 = true;
            unregisterReceiver(this.E4);
            this.u4 = false;
            this.E4 = null;
            PlayerView playerView2 = this.k2;
            if (playerView2 == null || playerView2.a == null) {
                return;
            }
            playerView2.setShowOrHideSubtitles("visible");
            this.k2.a.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 101) {
            return;
        }
        try {
            if (iArr.length > 0 && iArr[0] == 0) {
                Z3();
            } else if (Build.VERSION.SDK_INT >= 23 && !r7.j.a(this, strArr[0])) {
                a.a aVar = new a.a(this, a7.k.a);
                View inflate = LayoutInflater.from(this).inflate(a7.g.W3, (ViewGroup) null);
                Button findViewById = inflate.findViewById(a7.f.c1);
                Button findViewById2 = inflate.findViewById(a7.f.U0);
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
                findViewById.setOnClickListener(new b());
                findViewById2.setOnClickListener(new c());
                aVar.setView(inflate);
                this.o2 = aVar.create();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.o2.getWindow();
                Objects.requireNonNull(window);
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                this.o2.show();
                this.o2.getWindow().setAttributes(layoutParams);
                this.o2.setCancelable(false);
                this.o2.show();
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        AppOpsManager appOpsManager;
        U3();
        super/*androidx.fragment.app.e*/.onResume();
        this.X4 = false;
        Thread thread = this.O4;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new J());
            this.O4 = thread2;
            thread2.start();
        }
        Context context = this.d;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("auto_start", 0);
            this.K4 = sharedPreferences;
            boolean z2 = sharedPreferences.getBoolean("picinpic", m7.a.u0);
            this.L4 = z2;
            if (z2 && this.k4.equals("mobile")) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    this.D4 = p7.v.a();
                }
                if (i2 >= 26) {
                    try {
                        if (getPackageManager().hasSystemFeature("android.software.picture_in_picture") && (appOpsManager = (AppOpsManager) this.d.getSystemService("appops")) != null && appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), this.d.getPackageName()) == 0) {
                            this.t4 = true;
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
            this.f0 = getSharedPreferences("currentlyPlayingVideo", 0);
            if (!String.valueOf(getIntent().getIntExtra("OPENED_STREAM_ID", 0)).equals(SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u") ? this.e0.getString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", "") : this.e0.getString("currentlyPlayingVideo", ""))) {
                this.x2 = getIntent().getStringExtra("OPENED_CAT_ID");
                this.h1 = getIntent().getStringExtra("OPENED_CAT_NAME");
                this.v2 = getIntent().getIntExtra("OPENED_STREAM_ID", 0);
                this.W1 = getIntent().getIntExtra("VIDEO_NUM", 0);
                this.g1 = this.x2;
                this.i2 = getIntent().getStringExtra("VIDEO_URL");
                this.c2 = Boolean.FALSE;
                String str = this.g1;
                if (str == null || str.equals("") || !this.g1.equals("0")) {
                    String str2 = this.g1;
                    if (str2 == null || str2.equals("") || !this.g1.equals("-1")) {
                        String str3 = this.g1;
                        if (str3 == null || str3.equals("") || !this.g1.equals("-6")) {
                            h3();
                        } else {
                            m3();
                        }
                    } else {
                        l3();
                    }
                } else {
                    f3();
                }
            }
        }
        m7.w.m(this.d);
        try {
            o4.b bVar = this.T2;
            if (bVar != null) {
                bVar.c().a(this.R2, o4.e.class);
            }
        } catch (Exception unused2) {
        }
        V3();
        if (!this.E2) {
            if (this.P4 == null) {
                X3();
                return;
            }
            return;
        }
        this.E2 = false;
        ArrayList arrayList = this.x0;
        if (arrayList == null || arrayList.size() == 0) {
            m7.a.Y = Boolean.FALSE;
            k4();
        } else {
            p4(this.x0);
        }
        T t2 = this.W;
        if (t2 != null) {
            t2.notifyDataSetChanged();
        }
    }

    public void onStart() {
        super.onStart();
        try {
            o4.b.e(this.d).c().a(this.R2, o4.e.class);
        } catch (Exception unused) {
        }
    }

    public void onStop() {
        super.onStop();
        try {
            this.X4 = true;
            r4();
            if (this.k4.equals("mobile") && !this.I4 && this.t4 && this.L4) {
                finishAndRemoveTask();
            }
        } catch (Exception unused) {
        }
    }

    public void onUserLeaveHint() {
        if (this.k4.equals("mobile") && this.t4 && this.L4 && !this.I4 && !r7.k.a(this)) {
            try {
                g4();
                this.u4 = true;
            } catch (Exception unused) {
            }
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super/*android.app.Activity*/.onWindowFocusChanged(z2);
        U3();
        if (z2) {
            e3(getResources().getConfiguration());
        }
    }

    public void p3(int i2) {
        if (PlayerView.B0) {
            return;
        }
        n nVar = new n();
        this.g5 = nVar;
        this.f5.postDelayed(nVar, i2);
    }

    public final void p4(ArrayList arrayList) {
        x7.a f2;
        String valueOf;
        String str;
        String str2;
        SharedPreferences.Editor editor;
        String streamId;
        if (arrayList == null || arrayList.size() <= 0 || this.W1 >= arrayList.size()) {
            return;
        }
        int r0 = m7.w.r0(((LiveStreamsDBModel) arrayList.get(this.W1)).getNum());
        this.X2 = r0;
        if (!((LiveStreamsDBModel) arrayList.get(this.W1)).getCategoryId().equals("")) {
            this.Y2 = ((LiveStreamsDBModel) arrayList.get(this.W1)).getCategoryId();
        }
        int i2 = this.W1;
        this.D2 = i2;
        String name = ((LiveStreamsDBModel) arrayList.get(i2)).getName();
        int q0 = m7.w.q0(((LiveStreamsDBModel) arrayList.get(this.W1)).getStreamId());
        String streamIdOneStream = ((LiveStreamsDBModel) arrayList.get(this.W1)).getStreamIdOneStream();
        String epgChannelId = ((LiveStreamsDBModel) arrayList.get(this.W1)).getEpgChannelId();
        String streamIcon = ((LiveStreamsDBModel) arrayList.get(this.W1)).getStreamIcon();
        ((LiveStreamsDBModel) arrayList.get(this.W1)).getNum();
        this.i2 = ((LiveStreamsDBModel) arrayList.get(this.W1)).getUrl();
        String S0 = m7.w.S0(w7.k.a() + w7.k.i());
        this.d6 = ((LiveStreamsDBModel) arrayList.get(this.W1)).getName();
        this.a6 = ((LiveStreamsDBModel) arrayList.get(this.W1)).getCategoryId();
        try {
            if (streamIcon.equals("") || streamIcon.isEmpty()) {
                this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
            } else {
                com.squareup.picasso.t.q(this.d).l(streamIcon).j(a7.e.i1).d(a7.e.i1).g(this.q);
            }
        } catch (Exception unused) {
            this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
        }
        this.k2.setCurrentWindowIndex(this.W1);
        if (this.H1 != null) {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                editor = this.H1;
                streamId = ((LiveStreamsDBModel) arrayList.get(this.W1)).getStreamIdOneStream();
            } else {
                editor = this.H1;
                streamId = ((LiveStreamsDBModel) arrayList.get(this.W1)).getStreamId();
            }
            editor.putString("currentlyPlayingVideo", String.valueOf(streamId));
            this.H1.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", String.valueOf(((LiveStreamsDBModel) arrayList.get(this.W1)).getUrl()));
            this.H1.apply();
        }
        SharedPreferences.Editor editor2 = this.I1;
        if (editor2 != null) {
            editor2.putInt("currentlyPlayingVideoPosition", this.W1);
            this.I1.apply();
        }
        SimpleDateFormat simpleDateFormat = this.j2;
        if (x3(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.d))), this.f2.format(this.l2)) >= w7.c.p() && (str = this.w1) != null && this.m1 != null && (!u6.equals(str) || (this.w1 != null && (str2 = this.m1) != null && !v6.equals(str2)))) {
            this.q2 = Boolean.FALSE;
            this.k2.setVisibility(8);
            this.o.setVisibility(0);
            this.p.setText(S0 + this.k + this.K1);
        }
        this.D1 = q0;
        this.E1 = streamIdOneStream;
        this.C1 = epgChannelId;
        this.F1 = this.i2;
        if (this.h2.equals("m3u")) {
            f2 = x7.a.f();
            valueOf = this.F1;
        } else if (this.h2.equals("onestream_api")) {
            f2 = x7.a.f();
            valueOf = this.E1;
        } else {
            f2 = x7.a.f();
            valueOf = String.valueOf(this.D1);
        }
        f2.A(valueOf);
        this.k2.setTitle(r0 + " - " + name);
        this.G4 = r0 + " - " + name;
        this.k2.E();
        if (!t6) {
            if (this.k2.getFullScreenValue().booleanValue()) {
                t6 = this.k2.getFullScreenValue().booleanValue();
            } else {
                t6 = false;
            }
        }
        if (!m7.a.V0.booleanValue() || !m7.a.e1.equalsIgnoreCase("1")) {
            c4(name, epgChannelId, streamIcon);
        } else if (SharepreferenceDBHandler.getEventAdsView(this) < m7.a.f1) {
            c4(name, epgChannelId, streamIcon);
            SharepreferenceDBHandler.setEventAdsView(SharepreferenceDBHandler.getEventAdsView(this) + 1, this);
        } else {
            SharepreferenceDBHandler.setEventAdsView(0, this);
            d4(name, epgChannelId, streamIcon, null, null, 0, 0L, null);
        }
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    public void q3(int i2) {
        z zVar = new z();
        this.e5 = zVar;
        this.d5.postDelayed(zVar, i2);
    }

    public final void q4() {
        int currentWindowIndex = this.k2.getCurrentWindowIndex();
        if (currentWindowIndex == 0) {
            this.k2.setCurrentWindowIndex(this.B0.size() - 1);
        } else {
            this.k2.setCurrentWindowIndex(currentWindowIndex - 1);
        }
    }

    public void r3() {
        V3();
        this.C2 = false;
        this.D2 = 0;
        AsyncTask asyncTask = this.A2;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            ArrayList arrayList = this.s0;
            if (arrayList != null && arrayList.size() > 0) {
                int i2 = this.m0;
                if (i2 == 0) {
                    i2 = this.s0.size();
                }
                this.m0 = i2 - 1;
                if (this.m0 != 0 || this.x0 == null) {
                    ArrayList arrayList2 = this.s0;
                    if (arrayList2 == null || arrayList2.size() <= 0 || this.m0 >= this.s0.size()) {
                        return;
                    }
                    String liveStreamCategoryID = ((LiveStreamCategoryIdDBModel) this.s0.get(this.m0)).getLiveStreamCategoryID();
                    String liveStreamCategoryName = ((LiveStreamCategoryIdDBModel) this.s0.get(this.m0)).getLiveStreamCategoryName();
                    this.g1 = liveStreamCategoryID;
                    this.h1 = liveStreamCategoryName;
                    if (liveStreamCategoryID != null && !liveStreamCategoryID.equals("") && this.g1.equals("-1")) {
                        l3();
                        return;
                    }
                    String str = this.g1;
                    if (str == null || str.equals("") || !this.g1.equals("-6")) {
                        h3();
                        return;
                    } else {
                        m3();
                        return;
                    }
                }
                if (this.g1.equals("0")) {
                    return;
                }
                this.g1 = "0";
                this.h1 = this.d.getResources().getString(a7.j.x);
            }
            f3();
        }
    }

    public void r4() {
        try {
            I1 i1 = this.P4;
            if (i1 != null) {
                i1.release();
                this.P4 = null;
                this.R4 = null;
            }
        } catch (Exception unused) {
        }
    }

    public String s3(String str) {
        ArrayList arrayList = this.s0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = this.s0.iterator();
            while (it.hasNext()) {
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) it.next();
                if (liveStreamCategoryIdDBModel.getLiveStreamCategoryID() != null && !liveStreamCategoryIdDBModel.getLiveStreamCategoryID().isEmpty() && liveStreamCategoryIdDBModel.getLiveStreamCategoryID().equalsIgnoreCase(str)) {
                    this.h1 = liveStreamCategoryIdDBModel.getLiveStreamCategoryName();
                }
            }
        }
        return this.h1;
    }

    public final void s4(int i2, String str) {
        try {
            List list = this.A4;
            if (list == null) {
                m7.w.X();
                return;
            }
            list.remove(Integer.valueOf(i2));
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < this.A4.size(); i3++) {
                sb.append(this.A4.get(i3));
                sb.append(",");
            }
            this.A4.add(Integer.valueOf(i2));
            String substring = sb.toString().contains(",") ? sb.substring(0, sb.lastIndexOf(",")) : sb.toString();
            this.C4 = i2;
            this.B4.c(SharepreferenceDBHandler.getLoggedInMacAddress(this.d), SharepreferenceDBHandler.getStalkerToken(this.d), (t.o) null, substring, "removed", str);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public void t3(int i2, String str, String str2) {
        RecyclerView recyclerView = this.Z3;
        if (recyclerView != null) {
            recyclerView.m1(i2);
        }
    }

    public final void t4(String str, int i2, String str2, String str3, String str4) {
        DatabaseHandler databaseHandler;
        Context context = this.d;
        if (context == null || this.W == null || (databaseHandler = this.G1) == null) {
            return;
        }
        databaseHandler.deleteFavourite(i2, str, str3, str2, SharepreferenceDBHandler.getUserID(context), str4);
        this.W.notifyDataSetChanged();
        m7.w.P0(this.d, str2 + this.d.getResources().getString(a7.j.c6));
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
            this.w4 = cmd;
            String[] split = cmd.split("ffmpeg ", 0);
            if (split.length == 2) {
                this.x4 = split[1];
            }
            if (str6.equals("playFirstTime")) {
                p4(this.y0);
                if (this.U0 && this.V0 && !this.W0.equals("")) {
                    this.D2 = 0;
                    try {
                        this.D2 = I3(this.y0, m7.w.r0(this.W0));
                    } catch (NumberFormatException | Exception unused) {
                    }
                    this.U0 = false;
                    this.V0 = false;
                }
                v4(this.y0);
                return;
            }
            if (str6.equals("channel_click")) {
                m4(this.y4, this.O);
                return;
            }
            if (str6.equals("channel_click_from_player")) {
                n4(this.z4, this.P);
            } else if (str6.equals("zappingRight")) {
                U4(i4, str7, str8);
            } else if (str6.equals("zappingLeft")) {
                T4(i4, str7, str8);
            }
        } catch (Exception unused2) {
        }
    }

    public void u3() {
        this.i6 = new ArrayList();
        this.j6 = new JsonArray();
        if (this.A5.isChecked()) {
            this.i6.add(this.A5.getText().toString());
            this.j6.add(this.A5.getText().toString());
        }
        if (this.B5.isChecked()) {
            this.i6.add(this.B5.getText().toString());
            this.j6.add(this.B5.getText().toString());
        }
        if (this.C5.isChecked()) {
            this.i6.add(this.C5.getText().toString());
            this.j6.add(this.C5.getText().toString());
        }
        if (this.D5.isChecked()) {
            this.i6.add(this.D5.getText().toString());
            this.j6.add(this.D5.getText().toString());
        }
        if (this.E5.isChecked()) {
            this.i6.add(this.E5.getText().toString());
            this.j6.add(this.E5.getText().toString());
        }
        if (this.w5.isChecked()) {
            this.i6.add(this.w5.getText().toString());
            this.j6.add(this.w5.getText().toString());
        }
        if (this.x5.isChecked()) {
            this.i6.add(this.x5.getText().toString());
            this.j6.add(this.x5.getText().toString());
        }
        if (this.y5.isChecked()) {
            this.i6.add(this.y5.getText().toString());
            this.j6.add(this.y5.getText().toString());
        }
        if (this.z5.isChecked()) {
            this.i6.add(this.z5.getText().toString());
            this.j6.add(this.z5.getText().toString());
        }
        if (this.G5.isChecked()) {
            this.i6.add(this.G5.getText().toString());
            this.j6.add(this.G5.getText().toString());
        }
        if (this.H5.isChecked()) {
            this.i6.add(this.H5.getText().toString());
            this.j6.add(this.H5.getText().toString());
        }
        if (this.I5.isChecked()) {
            this.i6.add(this.I5.getText().toString());
            this.j6.add(this.I5.getText().toString());
        }
        if (this.J5.isChecked()) {
            this.i6.add(this.J5.getText().toString());
            this.j6.add(this.J5.getText().toString());
        }
        this.k6 = new Gson().toJson(this.j6);
        Log.e("TAG", this.j6 + "");
    }

    public final void u4(String str, String str2) {
        LiveStreamDBHandler liveStreamDBHandler;
        Context context = this.d;
        if (context == null || this.W == null || (liveStreamDBHandler = this.U) == null) {
            return;
        }
        liveStreamDBHandler.deleteFavourite(str, SharepreferenceDBHandler.getUserID(context));
        this.W.notifyDataSetChanged();
        m7.w.P0(this.d, str2 + this.d.getResources().getString(a7.j.c6));
    }

    public void v0(String str) {
    }

    public final void v3() {
        AsyncTask asyncTask = this.z2;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            SharepreferenceDBHandler.setAsyncTaskStatus(0, this.d);
        } else {
            SharepreferenceDBHandler.setAsyncTaskStatus(1, this.d);
            this.z2.cancel(true);
        }
    }

    public void v4(ArrayList arrayList) {
        LiveStreamDBHandler liveStreamDBHandler;
        String str;
        String str2;
        try {
            this.O = arrayList;
            if (arrayList == null) {
                this.N = new ArrayList();
                T t2 = new T(this, this.N, this.J4);
                this.W = t2;
                ListView listView = this.L;
                if (listView != null) {
                    listView.setAdapter(t2);
                    return;
                }
                return;
            }
            this.C = false;
            this.Q0.setVisibility(8);
            if (arrayList.size() == 0) {
                if (this.C2) {
                    TextView textView = this.Q0;
                    if (textView != null) {
                        this.C = true;
                        textView.setFocusable(true);
                        this.Q0.requestFocus();
                        this.Q0.setVisibility(0);
                    }
                } else {
                    this.C2 = true;
                    ArrayList arrayList2 = this.x0;
                    if (arrayList2 != null && this.v0 != null) {
                        arrayList2.clear();
                        this.v0.clear();
                    }
                    if (this.J4.equals("true")) {
                        liveStreamDBHandler = this.U;
                        str = this.g1;
                        str2 = "radio_streams";
                    } else {
                        liveStreamDBHandler = this.U;
                        str = this.g1;
                        str2 = "live";
                    }
                    this.x0 = liveStreamDBHandler.getAllLiveStreasWithCategoryId(str, str2);
                    ArrayList arrayList3 = this.x0;
                    if (arrayList3 == null || arrayList3.size() <= 0) {
                        TextView textView2 = this.Q0;
                        if (textView2 != null) {
                            this.C = true;
                            textView2.setFocusable(true);
                            this.Q0.requestFocus();
                            this.Q0.setVisibility(0);
                        }
                    } else {
                        v4(this.x0);
                    }
                }
            }
            Log.e("honey", "if part");
            T t3 = new T(this, arrayList, this.J4);
            this.W = t3;
            t3.g(this.Q0);
            ListView listView2 = this.L;
            if (listView2 != null) {
                listView2.setAdapter(this.W);
                int i2 = this.D2;
                if (i2 != 0) {
                    this.L.setSelection(i2);
                }
                if (this.a3.booleanValue()) {
                    this.L.requestFocus();
                    this.a3 = Boolean.FALSE;
                }
                this.L.setOnItemSelectedListener(new f());
                this.L.setOnItemClickListener(new g(arrayList));
                this.L.setOnItemLongClickListener(new h());
            }
        } catch (Exception unused) {
        }
    }

    public void w4(ArrayList arrayList) {
        try {
            this.P = arrayList;
            if (arrayList == null || arrayList.size() <= 0) {
                LinearLayout linearLayout = this.R0;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                ListView listView = this.M;
                if (listView != null) {
                    listView.setVisibility(8);
                    return;
                }
                return;
            }
            ListView listView2 = this.M;
            if (listView2 != null) {
                listView2.setVisibility(0);
            }
            this.C = false;
            q7.O o2 = new q7.O(this, arrayList);
            this.m4 = o2;
            ListView listView3 = this.M;
            if (listView3 != null) {
                listView3.setAdapter(o2);
                this.M.setSelection(this.q4);
                this.M.setOnItemClickListener(new e());
            }
        } catch (Exception unused) {
        }
    }

    public void x4(String str) {
        TextView textView = this.T3;
        if (textView != null) {
            textView.setText(str);
            this.T3.setSelected(true);
        }
    }

    public void y0(String str) {
    }

    public void y3() {
        runOnUiThread(new d());
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
    public void z3(java.util.HashMap r12) {
        /*
            Method dump skipped, instructions count: 846
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity.z3(java.util.HashMap):void");
    }

    public class k implements o4.y {
        public k() {
        }

        private void a(o4.e eVar) {
            NSTEXOPlayerSkyActivity.x1(NSTEXOPlayerSkyActivity.this, eVar);
            try {
                n4.m mVar = new n4.m(1);
                mVar.M("com.google.android.gms.cast.metadata.TITLE", NSTEXOPlayerSkyActivity.p2(NSTEXOPlayerSkyActivity.this));
                mVar.c(new x4.a(Uri.parse(NSTEXOPlayerSkyActivity.C2(NSTEXOPlayerSkyActivity.this))));
                NSTEXOPlayerSkyActivity nSTEXOPlayerSkyActivity = NSTEXOPlayerSkyActivity.this;
                i7.a.b(nSTEXOPlayerSkyActivity.V2, NSTEXOPlayerSkyActivity.w1(nSTEXOPlayerSkyActivity).r(), NSTEXOPlayerSkyActivity.I2(NSTEXOPlayerSkyActivity.this), mVar, NSTEXOPlayerSkyActivity.this.d);
            } catch (Exception unused) {
            }
            NSTEXOPlayerSkyActivity.this.invalidateOptionsMenu();
        }

        private void b() {
            NSTEXOPlayerSkyActivity.this.invalidateOptionsMenu();
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
            TextView e2;
            StringBuilder sb;
            String string;
            NSTEXOPlayerSkyActivity.x1(NSTEXOPlayerSkyActivity.this, eVar);
            if (NSTEXOPlayerSkyActivity.w1(NSTEXOPlayerSkyActivity.this) != null) {
                if (NSTEXOPlayerSkyActivity.y1(NSTEXOPlayerSkyActivity.this) != null) {
                    NSTEXOPlayerSkyActivity.H1(NSTEXOPlayerSkyActivity.this);
                }
                if (NSTEXOPlayerSkyActivity.S1(NSTEXOPlayerSkyActivity.this) != null) {
                    NSTEXOPlayerSkyActivity.S1(NSTEXOPlayerSkyActivity.this).setVisibility(0);
                }
                if (NSTEXOPlayerSkyActivity.e2(NSTEXOPlayerSkyActivity.this) != null) {
                    if (NSTEXOPlayerSkyActivity.w1(NSTEXOPlayerSkyActivity.this).q() == null || NSTEXOPlayerSkyActivity.w1(NSTEXOPlayerSkyActivity.this).q().J() == null) {
                        e2 = NSTEXOPlayerSkyActivity.e2(NSTEXOPlayerSkyActivity.this);
                        sb = new StringBuilder();
                        string = NSTEXOPlayerSkyActivity.this.getResources().getString(a7.j.v0);
                    } else {
                        e2 = NSTEXOPlayerSkyActivity.e2(NSTEXOPlayerSkyActivity.this);
                        sb = new StringBuilder();
                        sb.append(NSTEXOPlayerSkyActivity.this.getResources().getString(a7.j.w0));
                        sb.append(" ");
                        string = NSTEXOPlayerSkyActivity.w1(NSTEXOPlayerSkyActivity.this).q().J();
                    }
                    sb.append(string);
                    sb.append("...");
                    e2.setText(sb.toString());
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
