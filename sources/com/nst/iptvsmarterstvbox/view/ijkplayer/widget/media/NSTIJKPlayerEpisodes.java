package com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StrictMode;
import android.text.Html;
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
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.EpisodesUsingSinglton;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.callback.VodInfoCallback;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PlayerResumeDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.PanelAvailableChannelsPojo;
import com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import o1.a;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p7.z0;
import q7.c0;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerEpisodes extends FrameLayout implements MediaController.MediaPlayerControl, z7.n, View.OnClickListener {
    public static TextView s3;
    public static ProgressBar t3;
    public static List u3;
    public static SharedPreferences y3;
    public boolean A;
    public boolean A0;
    public SharedPreferences.Editor A1;
    public RelativeLayout A2;
    public int B;
    public int B0;
    public SharedPreferences.Editor B1;
    public Animation B2;
    public AlertDialog C;
    public Handler C0;
    public int C1;
    public LinearLayout C2;
    public String D;
    public Handler D0;
    public boolean D1;
    public LinearLayout D2;
    public String E;
    public int E0;
    public boolean E1;
    public Animation E2;
    public SharedPreferences F;
    public boolean F0;
    public SeriesRecentWatchDatabase F1;
    public Animation F2;
    public SharedPreferences.Editor G;
    public int G0;
    public int G1;
    public SharedPreferences G2;
    public SharedPreferences H;
    public int H0;
    public TextView H1;
    public RelativeLayout H2;
    public StringBuilder I;
    public SharedPreferences I0;
    public TextView I1;
    public boolean I2;
    public Formatter J;
    public Context J0;
    public LinearLayout J1;
    public boolean J2;
    public SharedPreferences.Editor K;
    public u7.a K0;
    public boolean K1;
    public int K2;
    public int L;
    public int L0;
    public TextView L1;
    public boolean L2;
    public String M;
    public int M0;
    public TextView M1;
    public IMediaPlayer.OnBufferingUpdateListener M2;
    public ArrayList N;
    public IMediaPlayer.OnVideoSizeChangedListener N0;
    public TextView N1;
    public IMediaPlayer.OnSeekCompleteListener N2;
    public n7.l O;
    public w7.c O0;
    public RadioGroup O1;
    public boolean O2;
    public LinearLayout P;
    public long P0;
    public RadioGroup P1;
    public IMediaPlayer.OnTimedTextListener P2;
    public LinearLayout Q;
    public long Q0;
    public RadioGroup Q1;
    public int Q2;
    public String R;
    public long R0;
    public SharedPreferences.Editor R1;
    public int R2;
    public M S;
    public IMediaPlayer.OnPreparedListener S0;
    public TextView S1;
    public List S2;
    public String T;
    public long T0;
    public TextView T1;
    public int T2;
    public long U;
    public Activity U0;
    public TextView U1;
    public int U2;
    public Uri V;
    public NSTIJKPlayerEpisodes V0;
    public ProgressBar V1;
    public boolean V2;
    public String W;
    public AudioManager W0;
    public LinearLayout W1;
    public Runnable W2;
    public int X0;
    public FrameLayout X1;
    public final SeekBar.OnSeekBarChangeListener X2;
    public float Y0;
    public androidx.appcompat.app.a Y1;
    public final SeekBar.OnSeekBarChangeListener Y2;
    public GestureDetector Z0;
    public SeekBar Z1;
    public final SeekBar.OnSeekBarChangeListener Z2;
    public TextView a;
    public int a1;
    public SeekBar a2;
    public Handler a3;
    public View b1;
    public LinearLayout b2;
    public boolean b3;
    public int c;
    public P c1;
    public Handler c2;
    public int c3;
    public boolean d;
    public Button d1;
    public Runnable d2;
    public int d3;
    public int e;
    public Map e0;
    public Boolean e1;
    public Handler e2;
    public IMediaPlayer.OnCompletionListener e3;
    public boolean f;
    public List f0;
    public Boolean f1;
    public Handler f2;
    public IMediaPlayer.OnInfoListener f3;
    public com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a g;
    public int g0;
    public Boolean g1;
    public boolean g2;
    public IMediaPlayer.OnErrorListener g3;
    public TextView h;
    public int h0;
    public Boolean h1;
    public Animation h2;
    public a.a h3;
    public boolean i;
    public a.b i0;
    public Boolean i1;
    public Animation i2;
    public int i3;
    public boolean j;
    public int j0;
    public Boolean j1;
    public final View.OnClickListener j2;
    public boolean j3;
    public boolean k;
    public int k0;
    public SeekBar k1;
    public TextView k2;
    public TextView k3;
    public int l;
    public int l0;
    public TextView l1;
    public TextView l2;
    public ProgressBar l3;
    public String m;
    public int m0;
    public TextView m1;
    public LinearLayout m2;
    public RecyclerView m3;
    public long n;
    public int n0;
    public SharedPreferences n1;
    public LinearLayout n2;
    public TextView n3;
    public boolean o;
    public IMediaPlayer.OnCompletionListener o0;
    public RecentWatchDBHandler o1;
    public int o2;
    public int o3;
    public boolean p;
    public IMediaPlayer.OnPreparedListener p0;
    public LiveStreamDBHandler p1;
    public TextView p2;
    public TextView p3;
    public boolean q;
    public int q0;
    public PlayerResumeDBHandler q1;
    public TextView q2;
    public View q3;
    public boolean r;
    public IMediaPlayer.OnErrorListener r0;
    public int r1;
    public LinearLayout r2;
    public z0 s;
    public IMediaPlayer.OnInfoListener s0;
    public String s1;
    public String s2;
    public RelativeLayout t;
    public int t0;
    public String t1;
    public String t2;
    public ImageView u;
    public boolean u0;
    public SharedPreferences u1;
    public TextView u2;
    public TextView v;
    public boolean v0;
    public SharedPreferences v1;
    public TextView v2;
    public Handler w;
    public boolean w0;
    public SharedPreferences w1;
    public FrameLayout w2;
    public Runnable x;
    public int x0;
    public SharedPreferences x1;
    public FrameLayout x2;
    public Handler y;
    public long y0;
    public SharedPreferences y1;
    public Animation y2;
    public Runnable z;
    public boolean z0;
    public SharedPreferences.Editor z1;
    public Animation z2;
    public static final int[] r3 = {0, 1, 2, 3, 4, 5};
    public static int v3 = 0;
    public static Handler w3 = new Handler();
    public static IMediaPlayer x3 = null;

    public class A implements p1.c {

        public class a implements Runnable {
            public final /* synthetic */ ArrayList a;

            public class a implements Runnable {
                public a() {
                }

                public void run() {
                    NSTIJKPlayerEpisodes.P1(NSTIJKPlayerEpisodes.this).setVisibility(0);
                    if (a.this.a.size() > 0) {
                        NSTIJKPlayerEpisodes.N1(NSTIJKPlayerEpisodes.this).setVisibility(8);
                        NSTIJKPlayerEpisodes.R1(NSTIJKPlayerEpisodes.this).setVisibility(8);
                    }
                    NSTIJKPlayerEpisodes.t3.setVisibility(8);
                }
            }

            public a(ArrayList arrayList) {
                this.a = arrayList;
            }

            public void run() {
                NSTIJKPlayerEpisodes.r0(NSTIJKPlayerEpisodes.this).runOnUiThread(new a());
            }
        }

        public A() {
        }

        public static /* synthetic */ void c(A a2, int i, o7.a aVar) {
            a2.f(i, aVar);
        }

        public static /* synthetic */ void d(A a2) {
            a2.e();
        }

        public void a(JSONObject jSONObject) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
            JSONArray jSONArray;
            String str;
            String str2;
            String str3;
            String str4;
            String str5 = "it";
            String str6 = "DUTCH";
            String str7 = "FRENCH";
            NSTIJKPlayerEpisodes.J1(NSTIJKPlayerEpisodes.this, true);
            NSTIJKPlayerEpisodes.L1(NSTIJKPlayerEpisodes.this, 0);
            NSTIJKPlayerEpisodes.N1(NSTIJKPlayerEpisodes.this).setVisibility(0);
            try {
                HashSet hashSet = new HashSet();
                try {
                    JSONObject jSONObject2 = new JSONObject(String.valueOf(jSONObject));
                    if (!jSONObject2.has("data") || jSONObject2.isNull("data")) {
                        Toast.makeText(NSTIJKPlayerEpisodes.Z(NSTIJKPlayerEpisodes.this), "No subtitle found.. ", 0).show();
                        nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    } else {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("data");
                        if (jSONArray2 != null && jSONArray2.length() > 0) {
                            int i = 0;
                            while (i < jSONArray2.length()) {
                                JSONObject jSONObject3 = jSONArray2.getJSONObject(i).getJSONObject("attributes");
                                String string = jSONObject3.getString("language");
                                Log.i("OutletName", jSONObject3.getString("language"));
                                String string2 = jSONObject3.getString("language");
                                if (string.equals("en")) {
                                    string2 = "English";
                                } else if (string.equals("ar")) {
                                    hashSet.add("ARABIC");
                                    string2 = "ARABIC";
                                } else if (string.equals("fr")) {
                                    hashSet.add(str7);
                                    string2 = str7;
                                } else if (string.equals("nl")) {
                                    hashSet.add(str6);
                                    string2 = str6;
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
                                } else if (string.equals(str5)) {
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
                                } else if (string.equals(str5)) {
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
                                String str8 = str5;
                                if (jSONArray != null) {
                                    int i3 = 0;
                                    while (i3 < jSONArray.length()) {
                                        JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                                        if (jSONObject4 != null) {
                                            str3 = str6;
                                            try {
                                                str4 = str7;
                                                try {
                                                    NSTIJKPlayerEpisodes.this.B = jSONObject4.getInt("file_id");
                                                } catch (Exception unused) {
                                                }
                                            } catch (Exception unused2) {
                                            }
                                            i3++;
                                            str6 = str3;
                                            str7 = str4;
                                        } else {
                                            str3 = str6;
                                        }
                                        str4 = str7;
                                        i3++;
                                        str6 = str3;
                                        str7 = str4;
                                    }
                                    str = str6;
                                    str2 = str7;
                                    o7.a aVar = new o7.a();
                                    aVar.e(string2);
                                    aVar.f(NSTIJKPlayerEpisodes.this.B);
                                    aVar.d(i2);
                                    aVar.g(NSTIJKPlayerEpisodes.this.B);
                                    NSTIJKPlayerEpisodes.O1(NSTIJKPlayerEpisodes.this).add(aVar);
                                } else {
                                    str = str6;
                                    str2 = str7;
                                }
                                i++;
                                str5 = str8;
                                str6 = str;
                                str7 = str2;
                            }
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            int i4 = -1;
                            for (int i5 = 0; i5 < NSTIJKPlayerEpisodes.O1(NSTIJKPlayerEpisodes.this).size(); i5++) {
                                if (arrayList.contains(((o7.a) NSTIJKPlayerEpisodes.O1(NSTIJKPlayerEpisodes.this).get(i5)).b())) {
                                    int i6 = 0;
                                    while (true) {
                                        if (i6 >= arrayList.size()) {
                                            break;
                                        }
                                        if (((String) arrayList.get(i6)).equals(((o7.a) NSTIJKPlayerEpisodes.O1(NSTIJKPlayerEpisodes.this).get(i6)).b())) {
                                            i4 = i6;
                                            break;
                                        }
                                        i6++;
                                    }
                                    if (((o7.a) NSTIJKPlayerEpisodes.O1(NSTIJKPlayerEpisodes.this).get(i5)).a() > ((Integer) arrayList2.get(i4)).intValue()) {
                                        arrayList3.remove(i4);
                                        arrayList3.add(i4, (o7.a) NSTIJKPlayerEpisodes.O1(NSTIJKPlayerEpisodes.this).get(i5));
                                    }
                                } else {
                                    arrayList.add(((o7.a) NSTIJKPlayerEpisodes.O1(NSTIJKPlayerEpisodes.this).get(i5)).b());
                                    arrayList2.add(Integer.valueOf(((o7.a) NSTIJKPlayerEpisodes.O1(NSTIJKPlayerEpisodes.this).get(i5)).a()));
                                    arrayList3.add((o7.a) NSTIJKPlayerEpisodes.O1(NSTIJKPlayerEpisodes.this).get(i5));
                                }
                            }
                            for (int i7 = 0; i7 < arrayList3.size(); i7++) {
                                Log.e("final", "language: " + ((o7.a) arrayList3.get(i7)).b());
                                Log.e("final", "count: " + ((o7.a) arrayList3.get(i7)).a());
                            }
                            c0 c0Var = new c0(NSTIJKPlayerEpisodes.Z(NSTIJKPlayerEpisodes.this), arrayList3);
                            NSTIJKPlayerEpisodes.P1(NSTIJKPlayerEpisodes.this).setLayoutManager(new LinearLayoutManager(NSTIJKPlayerEpisodes.Z(NSTIJKPlayerEpisodes.this)));
                            NSTIJKPlayerEpisodes.P1(NSTIJKPlayerEpisodes.this).setAdapter(c0Var);
                            NSTIJKPlayerEpisodes.P1(NSTIJKPlayerEpisodes.this).setVisibility(8);
                            new Handler().postDelayed(new a(arrayList3), 5000L);
                            c0Var.n0(new w7.i(this));
                            return;
                        }
                        Toast.makeText(NSTIJKPlayerEpisodes.Z(NSTIJKPlayerEpisodes.this), "No subtitle found.. ", 0).show();
                        nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    }
                    NSTIJKPlayerEpisodes.S1(nSTIJKPlayerEpisodes, "");
                } catch (JSONException e2) {
                    NSTIJKPlayerEpisodes.S1(NSTIJKPlayerEpisodes.this, String.valueOf(e2));
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                NSTIJKPlayerEpisodes.S1(NSTIJKPlayerEpisodes.this, "");
                e3.printStackTrace();
            }
        }

        public void b(m1.a aVar) {
            if (NSTIJKPlayerEpisodes.I1(NSTIJKPlayerEpisodes.this)) {
                return;
            }
            NSTIJKPlayerEpisodes.M1(NSTIJKPlayerEpisodes.this);
            if (NSTIJKPlayerEpisodes.K1(NSTIJKPlayerEpisodes.this) <= 5) {
                new Handler(Looper.getMainLooper()).postDelayed(new w7.h(this), 500L);
            } else {
                NSTIJKPlayerEpisodes.S1(NSTIJKPlayerEpisodes.this, String.valueOf(aVar));
            }
        }

        public final /* synthetic */ void e() {
            NSTIJKPlayerEpisodes.w1(NSTIJKPlayerEpisodes.this, false);
        }

        public final /* synthetic */ void f(int i, o7.a aVar) {
            try {
                NSTIJKPlayerEpisodes.this.B = aVar.c();
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                nSTIJKPlayerEpisodes.H = NSTIJKPlayerEpisodes.Z(nSTIJKPlayerEpisodes).getSharedPreferences("allowedFormatsubtitle", 0);
                String string = NSTIJKPlayerEpisodes.this.H.getString("allowedFormatsubtitle", "vip");
                NSTIJKPlayerEpisodes.t3.setVisibility(0);
                NSTIJKPlayerEpisodes.this.C.dismiss();
                if (string.equals("default")) {
                    Toast.makeText(NSTIJKPlayerEpisodes.Z(NSTIJKPlayerEpisodes.this), "Please wait..", 0).show();
                    NSTIJKPlayerEpisodes.this.h2(true);
                } else {
                    Toast.makeText(NSTIJKPlayerEpisodes.Z(NSTIJKPlayerEpisodes.this), "Please wait..", 0).show();
                    NSTIJKPlayerEpisodes.this.p3(true);
                }
            } catch (Exception e) {
                NSTIJKPlayerEpisodes.S1(NSTIJKPlayerEpisodes.this, String.valueOf(e));
                e.printStackTrace();
            }
        }
    }

    public class B implements Runnable {
        public B() {
        }

        public void run() {
            NSTIJKPlayerEpisodes.this.h2(false);
        }
    }

    public class C implements Runnable {
        public C() {
        }

        public void run() {
            NSTIJKPlayerEpisodes.this.p3(false);
        }
    }

    public class D implements DialogInterface.OnClickListener {
        public D() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes;
            String str;
            switch (i) {
                case 0:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "10";
                    break;
                case 1:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "12";
                    break;
                case 2:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "14";
                    break;
                case 3:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "16";
                    break;
                case 4:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "18";
                    break;
                case 5:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "20";
                    break;
                case 6:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "22";
                    break;
                case 7:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "24";
                    break;
                case 8:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "26";
                    break;
                case 9:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "28";
                    break;
                case 10:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "30";
                    break;
                case 11:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "32";
                    break;
                case 12:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "34";
                    break;
                case 13:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "36";
                    break;
                case 14:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "38";
                    break;
                case 15:
                    nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                    str = "40";
                    break;
                default:
                    return;
            }
            NSTIJKPlayerEpisodes.T1(nSTIJKPlayerEpisodes, str);
            NSTIJKPlayerEpisodes.U1(NSTIJKPlayerEpisodes.this).setText(str);
            dialogInterface.cancel();
        }
    }

    public class E implements DialogInterface.OnDismissListener {
        public E() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class F implements View.OnClickListener {
        public F() {
        }

        public void onClick(View view) {
            if (view.getId() == M8.c.b || view.getId() == a7.f.H7) {
                NSTIJKPlayerEpisodes.A(NSTIJKPlayerEpisodes.this);
            } else if (view.getId() == a7.f.A1) {
                NSTIJKPlayerEpisodes.this.m2();
            }
        }
    }

    public class G implements IMediaPlayer.OnBufferingUpdateListener {
        public G() {
        }

        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            NSTIJKPlayerEpisodes.B(NSTIJKPlayerEpisodes.this, i);
        }
    }

    public class H implements IMediaPlayer.OnSeekCompleteListener {
        public H() {
        }

        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerEpisodes.E(NSTIJKPlayerEpisodes.this, System.currentTimeMillis());
            NSTIJKPlayerEpisodes.o1(NSTIJKPlayerEpisodes.this).o(NSTIJKPlayerEpisodes.D(NSTIJKPlayerEpisodes.this) - NSTIJKPlayerEpisodes.J(NSTIJKPlayerEpisodes.this));
        }
    }

    public class I implements IMediaPlayer.OnTimedTextListener {
        public I() {
        }

        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            TextView textView;
            if (!NSTIJKPlayerEpisodes.L(NSTIJKPlayerEpisodes.this)) {
                NSTIJKPlayerEpisodes.T(NSTIJKPlayerEpisodes.this).setVisibility(8);
                NSTIJKPlayerEpisodes.c0(NSTIJKPlayerEpisodes.this).setVisibility(8);
                NSTIJKPlayerEpisodes.this.h.setVisibility(8);
                NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setVisibility(8);
                NSTIJKPlayerEpisodes.s3.setVisibility(8);
                NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setText("");
                NSTIJKPlayerEpisodes.s3.setText("");
                NSTIJKPlayerEpisodes.this.h.setText("");
                return;
            }
            if (ijkTimedText == null) {
                NSTIJKPlayerEpisodes.T(NSTIJKPlayerEpisodes.this).setVisibility(0);
                NSTIJKPlayerEpisodes.this.h.setVisibility(8);
                return;
            }
            if (!NSTIJKPlayerEpisodes.this.getShowOrHideSubtitles()) {
                NSTIJKPlayerEpisodes.T(NSTIJKPlayerEpisodes.this).setVisibility(8);
                NSTIJKPlayerEpisodes.c0(NSTIJKPlayerEpisodes.this).setVisibility(8);
                NSTIJKPlayerEpisodes.this.h.setVisibility(8);
                NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setVisibility(8);
                NSTIJKPlayerEpisodes.s3.setVisibility(8);
                Log.e("jaskirat", "subtitle gone 3");
                return;
            }
            String replace = ijkTimedText.getText().replace("{\\b1}", "").replace("{\\b0}", "").replace("{\\i1}", "").replace("{\\i0}", "").replace("{\\c}", "");
            StringBuilder sb = new StringBuilder();
            try {
                if (replace.contains("{")) {
                    for (String str : replace.split("\\{")) {
                        if (str.contains("}")) {
                            str = str.substring(str.lastIndexOf("}") + 1);
                        }
                        sb.append(str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            NSTIJKPlayerEpisodes.Y(NSTIJKPlayerEpisodes.Z(NSTIJKPlayerEpisodes.this).getSharedPreferences("pref.using_sub_font_size", 0));
            String string = NSTIJKPlayerEpisodes.X().getString("pref.using_sub_font_size", m7.a.x0);
            try {
                NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setTextSize(2, Float.parseFloat(string));
                NSTIJKPlayerEpisodes.s3.setTextSize(2, Float.parseFloat(string));
                NSTIJKPlayerEpisodes.this.h.setTextSize(2, Float.parseFloat(string));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (sb.length() > 0) {
                NSTIJKPlayerEpisodes.s3.setText(sb.toString());
                textView = NSTIJKPlayerEpisodes.this.h;
                replace = sb.toString();
            } else {
                NSTIJKPlayerEpisodes.this.h.setText(replace);
                textView = NSTIJKPlayerEpisodes.s3;
            }
            textView.setText(replace);
            NSTIJKPlayerEpisodes.this.h.setVisibility(0);
            NSTIJKPlayerEpisodes.c0(NSTIJKPlayerEpisodes.this).setVisibility(0);
            NSTIJKPlayerEpisodes.T(NSTIJKPlayerEpisodes.this).setVisibility(0);
            NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setVisibility(0);
            NSTIJKPlayerEpisodes.s3.setVisibility(0);
        }
    }

    public class J implements Runnable {
        public J() {
        }

        public void run() {
            try {
                long currentPosition = NSTIJKPlayerEpisodes.Q1().getCurrentPosition();
                if (NSTIJKPlayerEpisodes.i0() == null) {
                    NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setText("");
                    if (NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).getVisibility() == 0) {
                        NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setVisibility(8);
                    }
                } else if (NSTIJKPlayerEpisodes.j0() < NSTIJKPlayerEpisodes.i0().size()) {
                    w7.j jVar = (w7.j) NSTIJKPlayerEpisodes.i0().get(NSTIJKPlayerEpisodes.j0());
                    if (currentPosition >= jVar.b() && currentPosition <= jVar.a()) {
                        String string = NSTIJKPlayerEpisodes.X().getString("pref.using_sub_font_size", m7.a.x0);
                        String obj = Html.fromHtml(jVar.c()).toString();
                        NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setTextSize(2, Float.parseFloat(string));
                        NSTIJKPlayerEpisodes.s3.setTextSize(2, Float.parseFloat(string));
                        if (obj.length() > 0) {
                            if (NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).getVisibility() == 8) {
                                NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setVisibility(0);
                            }
                            NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setText(obj);
                        }
                    } else if (currentPosition > jVar.a()) {
                        NSTIJKPlayerEpisodes.k0();
                        if (NSTIJKPlayerEpisodes.j0() >= NSTIJKPlayerEpisodes.i0().size()) {
                            String string2 = NSTIJKPlayerEpisodes.X().getString("pref.using_sub_font_size", m7.a.x0);
                            NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setTextSize(2, Float.parseFloat(string2));
                            NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setText("");
                            if (NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).getVisibility() == 0) {
                                NSTIJKPlayerEpisodes.b0(NSTIJKPlayerEpisodes.this).setVisibility(8);
                            }
                            NSTIJKPlayerEpisodes.s3.setTextSize(2, Float.parseFloat(string2));
                        }
                    }
                }
            } catch (Exception unused) {
                NSTIJKPlayerEpisodes.this.V1.setVisibility(8);
            }
            NSTIJKPlayerEpisodes.this.V1.setVisibility(8);
            NSTIJKPlayerEpisodes.l0().postDelayed(this, 100L);
        }
    }

    public class K implements SeekBar.OnSeekBarChangeListener {
        public K() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView p0;
            Resources resources;
            int i2;
            NSTIJKPlayerEpisodes.n0(NSTIJKPlayerEpisodes.this, i);
            int m0 = (int) ((NSTIJKPlayerEpisodes.m0(NSTIJKPlayerEpisodes.this) / 255.0f) * 100.0f);
            if (m0 < 20) {
                p0 = NSTIJKPlayerEpisodes.p0(NSTIJKPlayerEpisodes.this);
                resources = NSTIJKPlayerEpisodes.this.getResources();
                i2 = a7.e.i0;
            } else if (m0 < 30) {
                p0 = NSTIJKPlayerEpisodes.p0(NSTIJKPlayerEpisodes.this);
                resources = NSTIJKPlayerEpisodes.this.getResources();
                i2 = a7.e.j0;
            } else if (m0 < 40) {
                p0 = NSTIJKPlayerEpisodes.p0(NSTIJKPlayerEpisodes.this);
                resources = NSTIJKPlayerEpisodes.this.getResources();
                i2 = a7.e.k0;
            } else if (m0 < 50) {
                p0 = NSTIJKPlayerEpisodes.p0(NSTIJKPlayerEpisodes.this);
                resources = NSTIJKPlayerEpisodes.this.getResources();
                i2 = a7.e.l0;
            } else if (m0 < 60) {
                p0 = NSTIJKPlayerEpisodes.p0(NSTIJKPlayerEpisodes.this);
                resources = NSTIJKPlayerEpisodes.this.getResources();
                i2 = a7.e.m0;
            } else if (m0 < 70) {
                p0 = NSTIJKPlayerEpisodes.p0(NSTIJKPlayerEpisodes.this);
                resources = NSTIJKPlayerEpisodes.this.getResources();
                i2 = a7.e.n0;
            } else {
                p0 = NSTIJKPlayerEpisodes.p0(NSTIJKPlayerEpisodes.this);
                resources = NSTIJKPlayerEpisodes.this.getResources();
                i2 = a7.e.o0;
            }
            p0.setBackground(resources.getDrawable(i2));
            WindowManager.LayoutParams attributes = NSTIJKPlayerEpisodes.r0(NSTIJKPlayerEpisodes.this).getWindow().getAttributes();
            attributes.screenBrightness = NSTIJKPlayerEpisodes.m0(NSTIJKPlayerEpisodes.this) / 255.0f;
            NSTIJKPlayerEpisodes.t0(NSTIJKPlayerEpisodes.this).R((int) NSTIJKPlayerEpisodes.m0(NSTIJKPlayerEpisodes.this));
            NSTIJKPlayerEpisodes.r0(NSTIJKPlayerEpisodes.this).getWindow().setAttributes(attributes);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerEpisodes.this.c3();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerEpisodes.this.c3();
            NSTIJKPlayerEpisodes.this.Z1(3000);
        }
    }

    public class L implements SeekBar.OnSeekBarChangeListener {
        public L() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView A0;
            Resources resources;
            int i2;
            if (NSTIJKPlayerEpisodes.x0(NSTIJKPlayerEpisodes.this) != null) {
                try {
                    NSTIJKPlayerEpisodes.x0(NSTIJKPlayerEpisodes.this).setStreamVolume(3, i, 0);
                    int streamVolume = (int) ((NSTIJKPlayerEpisodes.x0(NSTIJKPlayerEpisodes.this).getStreamVolume(3) / NSTIJKPlayerEpisodes.z0(NSTIJKPlayerEpisodes.this)) * 100.0f);
                    if (streamVolume == 0 || streamVolume < 0) {
                        A0 = NSTIJKPlayerEpisodes.A0(NSTIJKPlayerEpisodes.this);
                        resources = NSTIJKPlayerEpisodes.this.getResources();
                        i2 = a7.e.w0;
                    } else if (streamVolume < 40) {
                        A0 = NSTIJKPlayerEpisodes.A0(NSTIJKPlayerEpisodes.this);
                        resources = NSTIJKPlayerEpisodes.this.getResources();
                        i2 = a7.e.t0;
                    } else if (streamVolume < 80) {
                        A0 = NSTIJKPlayerEpisodes.A0(NSTIJKPlayerEpisodes.this);
                        resources = NSTIJKPlayerEpisodes.this.getResources();
                        i2 = a7.e.u0;
                    } else if (streamVolume < 100) {
                        A0 = NSTIJKPlayerEpisodes.A0(NSTIJKPlayerEpisodes.this);
                        resources = NSTIJKPlayerEpisodes.this.getResources();
                        i2 = a7.e.v0;
                    } else {
                        A0 = NSTIJKPlayerEpisodes.A0(NSTIJKPlayerEpisodes.this);
                        resources = NSTIJKPlayerEpisodes.this.getResources();
                        i2 = a7.e.v0;
                    }
                    A0.setBackground(resources.getDrawable(i2));
                } catch (Exception unused) {
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerEpisodes.this.c3();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerEpisodes.this.c3();
            NSTIJKPlayerEpisodes.this.Z1(3000);
        }
    }

    public static abstract class M {
        public abstract void a();

        public abstract void b();
    }

    public class N implements View.OnFocusChangeListener {
        public final View a;

        public N(View view) {
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
                if (view2 != null && view2.getTag() != null && this.a.getTag().equals("1") && NSTIJKPlayerEpisodes.V1(NSTIJKPlayerEpisodes.this) != null) {
                    NSTIJKPlayerEpisodes.V1(NSTIJKPlayerEpisodes.this).setBackgroundResource(a7.e.o);
                }
                a(1.0f);
                b(1.0f);
                return;
            }
            View view3 = this.a;
            if (view3 != null && view3.getTag() != null && this.a.getTag().equals("2")) {
                view.setBackground(NSTIJKPlayerEpisodes.this.getResources().getDrawable(a7.e.K1));
                return;
            }
            float f = z ? 1.12f : 1.0f;
            a(f);
            b(f);
            View view4 = this.a;
            if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1") || NSTIJKPlayerEpisodes.V1(NSTIJKPlayerEpisodes.this) == null) {
                return;
            }
            NSTIJKPlayerEpisodes.V1(NSTIJKPlayerEpisodes.this).setBackgroundResource(a7.e.h);
        }
    }

    public class O extends GestureDetector.SimpleOnGestureListener {
        public boolean a;

        public O() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this) == null) {
                return true;
            }
            if (motionEvent.getX() < NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).getWidth() / 2.0f) {
                NSTIJKPlayerEpisodes.W1(NSTIJKPlayerEpisodes.this);
                return true;
            }
            NSTIJKPlayerEpisodes.this.J2();
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
            NSTIJKPlayerEpisodes.this.m3();
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public class P {
        public final Activity a;
        public View b;

        public P(Activity activity) {
            this.a = activity;
        }

        public P a() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(8);
            }
            return this;
        }

        public P b(int i) {
            this.b = this.a.findViewById(i);
            return this;
        }

        public P c() {
            View view = this.b;
            if (view != null) {
                view.requestFocus();
            }
            return this;
        }

        public P d(CharSequence charSequence) {
            TextView textView = this.b;
            if (textView != null && (textView instanceof TextView)) {
                textView.setText(charSequence);
            }
            return this;
        }

        public P e() {
            View view = this.b;
            if (view != null) {
                view.setVisibility(0);
            }
            return this;
        }
    }

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        public String a(long j) {
            int i = (int) (j / 1000);
            int i2 = i % 60;
            int i3 = (i / 60) % 60;
            int i4 = i / 3600;
            return i4 > 0 ? String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)}) : String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z && NSTIJKPlayerEpisodes.Q1() != null) {
                NSTIJKPlayerEpisodes.B0(NSTIJKPlayerEpisodes.this).b(a7.f.G).a();
                NSTIJKPlayerEpisodes.F0(NSTIJKPlayerEpisodes.this, (int) (NSTIJKPlayerEpisodes.J0(r5).getDuration() * ((i * 1.0d) / 1000.0d)));
                a(NSTIJKPlayerEpisodes.D0(NSTIJKPlayerEpisodes.this));
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                nSTIJKPlayerEpisodes.q = true;
                nSTIJKPlayerEpisodes.a3.removeMessages(1);
                if (NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).isPlaying()) {
                    NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).pause();
                }
                NSTIJKPlayerEpisodes.this.c3();
                TextView K0 = NSTIJKPlayerEpisodes.K0(NSTIJKPlayerEpisodes.this);
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = NSTIJKPlayerEpisodes.this;
                K0.setText(nSTIJKPlayerEpisodes2.h3((int) NSTIJKPlayerEpisodes.D0(nSTIJKPlayerEpisodes2)));
                TextView L0 = NSTIJKPlayerEpisodes.L0(NSTIJKPlayerEpisodes.this);
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes3 = NSTIJKPlayerEpisodes.this;
                L0.setText(nSTIJKPlayerEpisodes3.h3(NSTIJKPlayerEpisodes.J0(nSTIJKPlayerEpisodes3).getDuration()));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            nSTIJKPlayerEpisodes.q = true;
            nSTIJKPlayerEpisodes.a3.removeMessages(1);
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = NSTIJKPlayerEpisodes.this;
            if (nSTIJKPlayerEpisodes2.A) {
                NSTIJKPlayerEpisodes.x0(nSTIJKPlayerEpisodes2).setStreamMute(3, true);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (NSTIJKPlayerEpisodes.Q1() == null) {
                return;
            }
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            if (!nSTIJKPlayerEpisodes.A) {
                NSTIJKPlayerEpisodes.J0(nSTIJKPlayerEpisodes).seekTo((int) (NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).getDuration() * ((seekBar.getProgress() * 1.0d) / 1000.0d)));
            }
            NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).start();
            NSTIJKPlayerEpisodes.this.c3();
            NSTIJKPlayerEpisodes.this.Z1(0);
            NSTIJKPlayerEpisodes.this.a3.removeMessages(1);
            NSTIJKPlayerEpisodes.x0(NSTIJKPlayerEpisodes.this).setStreamMute(3, false);
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = NSTIJKPlayerEpisodes.this;
            nSTIJKPlayerEpisodes2.q = false;
            nSTIJKPlayerEpisodes2.a3.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                NSTIJKPlayerEpisodes.N0(NSTIJKPlayerEpisodes.this);
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
                if (nSTIJKPlayerEpisodes.q || !NSTIJKPlayerEpisodes.Q0(nSTIJKPlayerEpisodes)) {
                    return;
                }
                NSTIJKPlayerEpisodes.this.a3.sendMessageDelayed(NSTIJKPlayerEpisodes.this.a3.obtainMessage(1), 300L);
                NSTIJKPlayerEpisodes.R0(NSTIJKPlayerEpisodes.this);
                return;
            }
            if (i == 2) {
                NSTIJKPlayerEpisodes.this.k2(false);
                return;
            }
            if (i == 3) {
                if (NSTIJKPlayerEpisodes.D0(NSTIJKPlayerEpisodes.this) >= 0) {
                    NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).seekTo((int) NSTIJKPlayerEpisodes.D0(NSTIJKPlayerEpisodes.this));
                    NSTIJKPlayerEpisodes.F0(NSTIJKPlayerEpisodes.this, -1L);
                    return;
                }
                return;
            }
            if (i != 4) {
                return;
            }
            NSTIJKPlayerEpisodes.B0(NSTIJKPlayerEpisodes.this).b(a7.f.U).a();
            NSTIJKPlayerEpisodes.B0(NSTIJKPlayerEpisodes.this).b(a7.f.v).a();
            NSTIJKPlayerEpisodes.B0(NSTIJKPlayerEpisodes.this).b(a7.f.y).a();
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent != null && NSTIJKPlayerEpisodes.S0(NSTIJKPlayerEpisodes.this).onTouchEvent(motionEvent);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ long a;

        public d(long j) {
            this.a = j;
        }

        public void run() {
            Activity r0;
            StringBuilder sb;
            Resources resources;
            int i;
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            nSTIJKPlayerEpisodes.e++;
            NSTIJKPlayerEpisodes.T0(nSTIJKPlayerEpisodes);
            if (NSTIJKPlayerEpisodes.W0(NSTIJKPlayerEpisodes.this).equals("dfo") || NSTIJKPlayerEpisodes.W0(NSTIJKPlayerEpisodes.this).equals("devicedata")) {
                r0 = NSTIJKPlayerEpisodes.r0(NSTIJKPlayerEpisodes.this);
                sb = new StringBuilder();
                resources = NSTIJKPlayerEpisodes.r0(NSTIJKPlayerEpisodes.this).getResources();
                i = a7.j.b0;
            } else {
                r0 = NSTIJKPlayerEpisodes.r0(NSTIJKPlayerEpisodes.this);
                sb = new StringBuilder();
                resources = NSTIJKPlayerEpisodes.r0(NSTIJKPlayerEpisodes.this).getResources();
                i = a7.j.g5;
            }
            sb.append(resources.getString(i));
            sb.append(" (");
            sb.append(NSTIJKPlayerEpisodes.this.e);
            sb.append("/");
            sb.append(NSTIJKPlayerEpisodes.Y0(NSTIJKPlayerEpisodes.this));
            sb.append(")");
            m7.w.P0(r0, sb.toString());
            NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).setProgress(true);
            if (this.a != 0) {
                NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).setCurrentPositionSeekbar((int) this.a);
            }
            NSTIJKPlayerEpisodes.this.x2();
            NSTIJKPlayerEpisodes.this.start();
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int a;

        public e(int i) {
            this.a = i;
        }

        public void run() {
            int i = this.a;
            if (i != 0) {
                NSTIJKPlayerEpisodes.Z0(NSTIJKPlayerEpisodes.this, i);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            NSTIJKPlayerEpisodes.this.m2();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            NSTIJKPlayerEpisodes.A(NSTIJKPlayerEpisodes.this);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            NSTIJKPlayerEpisodes.A(NSTIJKPlayerEpisodes.this);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            NSTIJKPlayerEpisodes.this.o2();
        }
    }

    public class j implements Runnable {
        public j() {
        }

        public void run() {
            NSTIJKPlayerEpisodes.this.n2();
        }
    }

    public class k implements IMediaPlayer.OnVideoSizeChangedListener {
        public k() {
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            NSTIJKPlayerEpisodes.k(NSTIJKPlayerEpisodes.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerEpisodes.o(NSTIJKPlayerEpisodes.this, iMediaPlayer.getVideoHeight());
            NSTIJKPlayerEpisodes.W(NSTIJKPlayerEpisodes.this, iMediaPlayer.getVideoSarNum());
            NSTIJKPlayerEpisodes.s0(NSTIJKPlayerEpisodes.this, iMediaPlayer.getVideoSarDen());
            if (NSTIJKPlayerEpisodes.h(NSTIJKPlayerEpisodes.this) == 0 || NSTIJKPlayerEpisodes.l(NSTIJKPlayerEpisodes.this) == 0) {
                return;
            }
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = nSTIJKPlayerEpisodes.g;
            if (aVar != null) {
                aVar.c(NSTIJKPlayerEpisodes.h(nSTIJKPlayerEpisodes), NSTIJKPlayerEpisodes.l(NSTIJKPlayerEpisodes.this));
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = NSTIJKPlayerEpisodes.this;
                nSTIJKPlayerEpisodes2.g.a(NSTIJKPlayerEpisodes.S(nSTIJKPlayerEpisodes2), NSTIJKPlayerEpisodes.q0(NSTIJKPlayerEpisodes.this));
            }
            NSTIJKPlayerEpisodes.this.requestLayout();
        }
    }

    public class l implements Runnable {
        public l() {
        }

        public void run() {
            TextView g1;
            String str;
            if (NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).getCurrentPosition() + NSTIJKPlayerEpisodes.a1(NSTIJKPlayerEpisodes.this) > 0) {
                NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).seekTo(NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).getCurrentPosition() + NSTIJKPlayerEpisodes.a1(NSTIJKPlayerEpisodes.this));
            } else {
                NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).seekTo(0);
            }
            NSTIJKPlayerEpisodes.b1(NSTIJKPlayerEpisodes.this, 0);
            NSTIJKPlayerEpisodes.e1(NSTIJKPlayerEpisodes.this).startAnimation(NSTIJKPlayerEpisodes.c1(NSTIJKPlayerEpisodes.this));
            NSTIJKPlayerEpisodes.e1(NSTIJKPlayerEpisodes.this).setVisibility(8);
            if (NSTIJKPlayerEpisodes.f1(NSTIJKPlayerEpisodes.this) == null || !NSTIJKPlayerEpisodes.f1(NSTIJKPlayerEpisodes.this).equals("catch_up")) {
                g1 = NSTIJKPlayerEpisodes.g1(NSTIJKPlayerEpisodes.this);
                str = "-10s";
            } else {
                g1 = NSTIJKPlayerEpisodes.g1(NSTIJKPlayerEpisodes.this);
                str = "-60s";
            }
            g1.setText(str);
            if (NSTIJKPlayerEpisodes.h1(NSTIJKPlayerEpisodes.this).getVisibility() == 8) {
                NSTIJKPlayerEpisodes.g1(NSTIJKPlayerEpisodes.this).startAnimation(NSTIJKPlayerEpisodes.c1(NSTIJKPlayerEpisodes.this));
                NSTIJKPlayerEpisodes.g1(NSTIJKPlayerEpisodes.this).setVisibility(8);
            }
            NSTIJKPlayerEpisodes.this.Z1(1000);
        }
    }

    public class m implements Runnable {
        public m() {
        }

        public void run() {
            NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).seekTo((int) (NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).getDuration() * ((NSTIJKPlayerEpisodes.i1(NSTIJKPlayerEpisodes.this).getProgress() * 1.0d) / 1000.0d)));
            NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).start();
            NSTIJKPlayerEpisodes.this.a3.removeMessages(1);
            NSTIJKPlayerEpisodes.x0(NSTIJKPlayerEpisodes.this).setStreamMute(3, false);
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            nSTIJKPlayerEpisodes.q = false;
            nSTIJKPlayerEpisodes.a3.sendEmptyMessageDelayed(1, 1000L);
            NSTIJKPlayerEpisodes.this.Z1(1000);
        }
    }

    public class n implements IMediaPlayer.OnCompletionListener {
        public n() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer r3) {
            /*
                r2 = this;
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                r3.b3()
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                r0 = 5
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.B1(r3, r0)
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.z(r3, r0)
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.n(r3)
                x7.a r3 = x7.a.f()
                r3.d()
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                java.lang.String r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.W0(r3)
                java.lang.String r0 = "dfo"
                boolean r3 = r3.equals(r0)
                if (r3 != 0) goto Lbc
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                java.lang.String r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.W0(r3)
                java.lang.String r0 = "devicedata"
                boolean r3 = r3.equals(r0)
                if (r3 == 0) goto L3a
                goto Lbc
            L3a:
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                android.app.Activity r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.r0(r3)
                java.lang.String r3 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getType(r3)
                java.lang.String r0 = "movies"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L5c
                x7.a r3 = x7.a.f()
                x7.a r0 = x7.a.f()
                int r0 = r0.k()
                r3.C(r0)
                goto Lbc
            L5c:
                java.lang.String r0 = "series"
                boolean r0 = r3.equals(r0)
                r1 = 5000(0x1388, float:7.006E-42)
                if (r0 == 0) goto Lab
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                android.app.Activity r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.r0(r3)
                if (r3 == 0) goto Lbc
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                android.app.Activity r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.r0(r3)
                boolean r3 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getisAutoPlayVideos(r3)
                if (r3 == 0) goto Lbc
                x7.a r3 = x7.a.f()
                x7.a r0 = x7.a.f()
                java.lang.String r0 = r0.e()
                int r0 = java.lang.Integer.parseInt(r0)
                r3.C(r0)
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                boolean r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.j1(r3)
                if (r3 != 0) goto L9b
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.A(r3)
                goto Lbc
            L9b:
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                r3.c3()
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                r3.T2()
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                r3.Z1(r1)
                goto Lbc
            Lab:
                java.lang.String r0 = "recording"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L9b
                java.lang.String r0 = "catch_up"
                boolean r3 = r3.equals(r0)
                if (r3 == 0) goto Lbc
                goto L9b
            Lbc:
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                tv.danmaku.ijk.media.player.IMediaPlayer$OnCompletionListener r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.k1(r3)
                if (r3 == 0) goto Ld1
                com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.this
                tv.danmaku.ijk.media.player.IMediaPlayer$OnCompletionListener r3 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.k1(r3)
                tv.danmaku.ijk.media.player.IMediaPlayer r0 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.Q1()
                r3.onCompletion(r0)
            Ld1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.n.onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer):void");
        }
    }

    public class o implements Runnable {
        public o() {
        }

        public void run() {
            TextView m1;
            String str;
            NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).seekTo(NSTIJKPlayerEpisodes.J0(NSTIJKPlayerEpisodes.this).getCurrentPosition() + NSTIJKPlayerEpisodes.a1(NSTIJKPlayerEpisodes.this));
            NSTIJKPlayerEpisodes.b1(NSTIJKPlayerEpisodes.this, 0);
            NSTIJKPlayerEpisodes.l1(NSTIJKPlayerEpisodes.this).startAnimation(NSTIJKPlayerEpisodes.c1(NSTIJKPlayerEpisodes.this));
            NSTIJKPlayerEpisodes.l1(NSTIJKPlayerEpisodes.this).setVisibility(8);
            if (NSTIJKPlayerEpisodes.f1(NSTIJKPlayerEpisodes.this) == null || !NSTIJKPlayerEpisodes.f1(NSTIJKPlayerEpisodes.this).equals("catch_up")) {
                m1 = NSTIJKPlayerEpisodes.m1(NSTIJKPlayerEpisodes.this);
                str = "+10s";
            } else {
                m1 = NSTIJKPlayerEpisodes.m1(NSTIJKPlayerEpisodes.this);
                str = "+60s";
            }
            m1.setText(str);
            if (NSTIJKPlayerEpisodes.h1(NSTIJKPlayerEpisodes.this).getVisibility() == 8) {
                NSTIJKPlayerEpisodes.m1(NSTIJKPlayerEpisodes.this).startAnimation(NSTIJKPlayerEpisodes.c1(NSTIJKPlayerEpisodes.this));
                NSTIJKPlayerEpisodes.m1(NSTIJKPlayerEpisodes.this).setVisibility(8);
            }
            NSTIJKPlayerEpisodes.this.Z1(1000);
        }
    }

    public class p implements IMediaPlayer.OnInfoListener {
        public p() {
        }

        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            String str;
            if (NSTIJKPlayerEpisodes.n1(NSTIJKPlayerEpisodes.this) != null) {
                NSTIJKPlayerEpisodes.n1(NSTIJKPlayerEpisodes.this).onInfo(iMediaPlayer, i, i2);
            }
            if (i == 3) {
                NSTIJKPlayerEpisodes.p1(NSTIJKPlayerEpisodes.this, 2);
                str = "MEDIA_INFO_VIDEO_RENDERING_START:";
            } else if (i == 10005) {
                NSTIJKPlayerEpisodes.p1(NSTIJKPlayerEpisodes.this, 1);
                str = "MEDIA_INFO_OPEN_INPUT:";
            } else if (i == 901) {
                str = "MEDIA_INFO_UNSUPPORTED_SUBTITLE:";
            } else {
                if (i != 902) {
                    if (i == 10001) {
                        NSTIJKPlayerEpisodes.q1(NSTIJKPlayerEpisodes.this, i2);
                        Log.d("jaskirat", "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                        com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = NSTIJKPlayerEpisodes.this.g;
                        if (aVar != null) {
                            aVar.setVideoRotation(i2);
                        }
                    } else if (i != 10002) {
                        switch (i) {
                            case 700:
                                str = "MEDIA_INFO_VIDEO_TRACK_LAGGING:";
                                break;
                            case 701:
                                NSTIJKPlayerEpisodes.p1(NSTIJKPlayerEpisodes.this, 1);
                                str = "MEDIA_INFO_BUFFERING_START:";
                                break;
                            case 702:
                                NSTIJKPlayerEpisodes.p1(NSTIJKPlayerEpisodes.this, 6);
                                str = "MEDIA_INFO_BUFFERING_END:";
                                break;
                            case 703:
                                str = "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2;
                                break;
                            default:
                                switch (i) {
                                    case 800:
                                        str = "MEDIA_INFO_BAD_INTERLEAVING:";
                                        break;
                                    case 801:
                                        str = "MEDIA_INFO_NOT_SEEKABLE:";
                                        break;
                                    case 802:
                                        str = "MEDIA_INFO_METADATA_UPDATE:";
                                        break;
                                }
                        }
                    } else {
                        str = "MEDIA_INFO_AUDIO_RENDERING_START:";
                    }
                    return true;
                }
                str = "MEDIA_INFO_SUBTITLE_TIMED_OUT:";
            }
            Log.d("jaskirat", str);
            return true;
        }
    }

    public class q implements IMediaPlayer.OnErrorListener {
        public q() {
        }

        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            Log.d(NSTIJKPlayerEpisodes.r1(NSTIJKPlayerEpisodes.this), "Error: " + i + "," + i2);
            NSTIJKPlayerEpisodes.B1(NSTIJKPlayerEpisodes.this, -1);
            NSTIJKPlayerEpisodes.z(NSTIJKPlayerEpisodes.this, -1);
            NSTIJKPlayerEpisodes.n(NSTIJKPlayerEpisodes.this);
            NSTIJKPlayerEpisodes.p1(NSTIJKPlayerEpisodes.this, -1);
            if (NSTIJKPlayerEpisodes.s1(NSTIJKPlayerEpisodes.this) != null) {
                NSTIJKPlayerEpisodes.s1(NSTIJKPlayerEpisodes.this).onError(NSTIJKPlayerEpisodes.Q1(), i, i2);
            }
            return true;
        }
    }

    public class r implements a.a {
        public r() {
        }

        public void a(a.b bVar, int i, int i2, int i3) {
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a = bVar.a();
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            if (a != nSTIJKPlayerEpisodes.g) {
                Log.e(NSTIJKPlayerEpisodes.r1(nSTIJKPlayerEpisodes), "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerEpisodes.u(nSTIJKPlayerEpisodes, i2);
            NSTIJKPlayerEpisodes.w(NSTIJKPlayerEpisodes.this, i3);
            boolean z = false;
            boolean z2 = NSTIJKPlayerEpisodes.x(NSTIJKPlayerEpisodes.this) == 3;
            if (!NSTIJKPlayerEpisodes.this.g.d() || (NSTIJKPlayerEpisodes.h(NSTIJKPlayerEpisodes.this) == i2 && NSTIJKPlayerEpisodes.l(NSTIJKPlayerEpisodes.this) == i3)) {
                z = true;
            }
            if (NSTIJKPlayerEpisodes.Q1() != null && z2 && z) {
                if (NSTIJKPlayerEpisodes.p(NSTIJKPlayerEpisodes.this) != 0) {
                    NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = NSTIJKPlayerEpisodes.this;
                    nSTIJKPlayerEpisodes2.seekTo(NSTIJKPlayerEpisodes.p(nSTIJKPlayerEpisodes2));
                }
                NSTIJKPlayerEpisodes.this.start();
            }
        }

        public void b(a.b bVar, int i, int i2) {
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a = bVar.a();
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            if (a != nSTIJKPlayerEpisodes.g) {
                Log.e(NSTIJKPlayerEpisodes.r1(nSTIJKPlayerEpisodes), "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            NSTIJKPlayerEpisodes.t1(nSTIJKPlayerEpisodes, bVar);
            if (NSTIJKPlayerEpisodes.Q1() != null) {
                NSTIJKPlayerEpisodes.u1(NSTIJKPlayerEpisodes.this, NSTIJKPlayerEpisodes.Q1(), bVar);
            } else {
                NSTIJKPlayerEpisodes.this.x2();
            }
        }

        public void c(a.b bVar) {
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a a = bVar.a();
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            if (a != nSTIJKPlayerEpisodes.g) {
                Log.e(NSTIJKPlayerEpisodes.r1(nSTIJKPlayerEpisodes), "onSurfaceDestroyed: unmatched render callback\n");
            } else {
                NSTIJKPlayerEpisodes.t1(nSTIJKPlayerEpisodes, null);
                NSTIJKPlayerEpisodes.this.D2();
            }
        }
    }

    public class s implements Runnable {
        public final /* synthetic */ LinearLayout a;

        public s(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        public void run() {
            this.a.setVisibility(8);
            if (NSTIJKPlayerEpisodes.h1(NSTIJKPlayerEpisodes.this).getVisibility() != 0 || NSTIJKPlayerEpisodes.v1(NSTIJKPlayerEpisodes.this) == null) {
                return;
            }
            NSTIJKPlayerEpisodes.v1(NSTIJKPlayerEpisodes.this).setVisibility(0);
        }
    }

    public class t implements View.OnClickListener {
        public t() {
        }

        public void onClick(View view) {
            NSTIJKPlayerEpisodes.t3 = new ProgressBar(NSTIJKPlayerEpisodes.Z(NSTIJKPlayerEpisodes.this), (AttributeSet) null, 16842872);
            NSTIJKPlayerEpisodes.w1(NSTIJKPlayerEpisodes.this, true);
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        public void onClick(View view) {
            NSTIJKPlayerEpisodes.x1(NSTIJKPlayerEpisodes.this);
        }
    }

    public class v implements IMediaPlayer.OnPreparedListener {
        public v() {
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            NSTIJKPlayerEpisodes.O0(NSTIJKPlayerEpisodes.this, System.currentTimeMillis());
            NSTIJKPlayerEpisodes.o1(NSTIJKPlayerEpisodes.this).n(NSTIJKPlayerEpisodes.M0(NSTIJKPlayerEpisodes.this) - NSTIJKPlayerEpisodes.d1(NSTIJKPlayerEpisodes.this));
            NSTIJKPlayerEpisodes.B1(NSTIJKPlayerEpisodes.this, 2);
            NSTIJKPlayerEpisodes.Q1().start();
            if (NSTIJKPlayerEpisodes.X1(NSTIJKPlayerEpisodes.this) != null) {
                NSTIJKPlayerEpisodes.X1(NSTIJKPlayerEpisodes.this).onPrepared(NSTIJKPlayerEpisodes.Q1());
            }
            NSTIJKPlayerEpisodes.n(NSTIJKPlayerEpisodes.this);
            NSTIJKPlayerEpisodes.k(NSTIJKPlayerEpisodes.this, iMediaPlayer.getVideoWidth());
            NSTIJKPlayerEpisodes.o(NSTIJKPlayerEpisodes.this, iMediaPlayer.getVideoHeight());
            int p = NSTIJKPlayerEpisodes.p(NSTIJKPlayerEpisodes.this);
            if (p != 0) {
                NSTIJKPlayerEpisodes.this.seekTo(p);
            }
            if (NSTIJKPlayerEpisodes.h(NSTIJKPlayerEpisodes.this) == 0 || NSTIJKPlayerEpisodes.l(NSTIJKPlayerEpisodes.this) == 0) {
                if (NSTIJKPlayerEpisodes.x(NSTIJKPlayerEpisodes.this) == 3) {
                    NSTIJKPlayerEpisodes.this.start();
                    return;
                }
                return;
            }
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = nSTIJKPlayerEpisodes.g;
            if (aVar != null) {
                aVar.c(NSTIJKPlayerEpisodes.h(nSTIJKPlayerEpisodes), NSTIJKPlayerEpisodes.l(NSTIJKPlayerEpisodes.this));
                NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes2 = NSTIJKPlayerEpisodes.this;
                nSTIJKPlayerEpisodes2.g.a(NSTIJKPlayerEpisodes.S(nSTIJKPlayerEpisodes2), NSTIJKPlayerEpisodes.q0(NSTIJKPlayerEpisodes.this));
                if (!NSTIJKPlayerEpisodes.this.g.d() || (NSTIJKPlayerEpisodes.r(NSTIJKPlayerEpisodes.this) == NSTIJKPlayerEpisodes.h(NSTIJKPlayerEpisodes.this) && NSTIJKPlayerEpisodes.v(NSTIJKPlayerEpisodes.this) == NSTIJKPlayerEpisodes.l(NSTIJKPlayerEpisodes.this))) {
                    if (NSTIJKPlayerEpisodes.x(NSTIJKPlayerEpisodes.this) == 3) {
                        NSTIJKPlayerEpisodes.this.start();
                    } else {
                        if (NSTIJKPlayerEpisodes.this.isPlaying()) {
                            return;
                        }
                        if (p == 0 && NSTIJKPlayerEpisodes.this.getCurrentPosition() <= 0) {
                            return;
                        }
                    }
                    NSTIJKPlayerEpisodes.n(NSTIJKPlayerEpisodes.this);
                }
            }
        }
    }

    public class w implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;

        public w(int i) {
            this.a = i;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            NSTIJKPlayerEpisodes.z1(nSTIJKPlayerEpisodes, NSTIJKPlayerEpisodes.A1(nSTIJKPlayerEpisodes).edit());
            if (i == 111 || i == 11111111) {
                NSTIJKPlayerEpisodes.y1(NSTIJKPlayerEpisodes.this).putInt("currentVideoTrack", -1);
                NSTIJKPlayerEpisodes.this.i2(this.a);
            } else {
                NSTIJKPlayerEpisodes.y1(NSTIJKPlayerEpisodes.this).putInt("currentVideoTrack", i);
                int currentPosition = (int) NSTIJKPlayerEpisodes.Q1().getCurrentPosition();
                NSTIJKPlayerEpisodes.this.K2(i);
                if (NSTIJKPlayerEpisodes.f1(NSTIJKPlayerEpisodes.this).equalsIgnoreCase("recording")) {
                    NSTIJKPlayerEpisodes.Q1().seekTo(Long.parseLong(String.valueOf(currentPosition)));
                }
            }
            NSTIJKPlayerEpisodes.y1(NSTIJKPlayerEpisodes.this).apply();
        }
    }

    public class x implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ int a;

        public x(int i) {
            this.a = i;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            NSTIJKPlayerEpisodes.D1(nSTIJKPlayerEpisodes, NSTIJKPlayerEpisodes.E1(nSTIJKPlayerEpisodes).edit());
            if (i == 1111 || i == 1111111) {
                NSTIJKPlayerEpisodes.C1(NSTIJKPlayerEpisodes.this).putInt("currentAudioTrack", -1);
                NSTIJKPlayerEpisodes.this.i2(this.a);
            } else {
                NSTIJKPlayerEpisodes.C1(NSTIJKPlayerEpisodes.this).putInt("currentAudioTrack", i);
                int currentPosition = (int) NSTIJKPlayerEpisodes.Q1().getCurrentPosition();
                NSTIJKPlayerEpisodes.this.K2(i);
                NSTIJKPlayerEpisodes.Q1().seekTo(Long.parseLong(String.valueOf(currentPosition)));
            }
            NSTIJKPlayerEpisodes.C1(NSTIJKPlayerEpisodes.this).apply();
        }
    }

    public class y implements RadioGroup.OnCheckedChangeListener {
        public y() {
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = NSTIJKPlayerEpisodes.this;
            NSTIJKPlayerEpisodes.G1(nSTIJKPlayerEpisodes, NSTIJKPlayerEpisodes.H1(nSTIJKPlayerEpisodes).edit());
            if (i == 11111 || i == 111111) {
                NSTIJKPlayerEpisodes.P(NSTIJKPlayerEpisodes.this, false);
                NSTIJKPlayerEpisodes.F1(NSTIJKPlayerEpisodes.this).putInt("currentSubtitleTrack", -1);
            } else {
                NSTIJKPlayerEpisodes.P(NSTIJKPlayerEpisodes.this, true);
                NSTIJKPlayerEpisodes.F1(NSTIJKPlayerEpisodes.this).putInt("currentSubtitleTrack", i);
                NSTIJKPlayerEpisodes.Q1().seekTo(Long.parseLong(String.valueOf((int) NSTIJKPlayerEpisodes.Q1().getCurrentPosition())));
            }
            NSTIJKPlayerEpisodes.F1(NSTIJKPlayerEpisodes.this).apply();
            w7.e.e(NSTIJKPlayerEpisodes.Q1(), i);
        }
    }

    public class z implements View.OnClickListener {
        public z() {
        }

        public void onClick(View view) {
            NSTIJKPlayerEpisodes.this.C.dismiss();
        }
    }

    public NSTIJKPlayerEpisodes(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.d = true;
        this.e = 0;
        this.f = false;
        this.i = true;
        this.j = false;
        this.k = false;
        this.m = "";
        this.o = false;
        this.p = false;
        this.r = false;
        this.B = 0;
        this.D = "https://hosting.iptvbillingsolution.com/The%20Lucy%20Show%20S01E02%20Lucy%20Digs%20Up%20a%20Date.SP.DVDRip.NonHI.cc.en.CBS.srt";
        this.E = "";
        this.T = "NSTIJKPlayerEpisodes";
        this.U = System.currentTimeMillis();
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = null;
        this.u0 = true;
        this.v0 = true;
        this.w0 = true;
        this.x0 = -1;
        this.y0 = -1L;
        this.A0 = false;
        this.B0 = 7000;
        this.E0 = 0;
        this.G0 = 0;
        this.H0 = 5;
        this.N0 = new k();
        this.P0 = 0L;
        this.Q0 = 0L;
        this.R0 = 0L;
        this.S0 = new v();
        this.T0 = 0L;
        this.Y0 = -1.0f;
        Boolean bool = Boolean.FALSE;
        this.e1 = bool;
        this.f1 = bool;
        this.g1 = bool;
        this.h1 = bool;
        this.i1 = bool;
        this.j1 = bool;
        this.D1 = false;
        this.E1 = false;
        this.G1 = 0;
        this.K1 = false;
        this.g2 = false;
        this.j2 = new F();
        this.o2 = 0;
        this.J2 = false;
        this.K2 = 5;
        this.L2 = false;
        this.M2 = new G();
        this.N2 = new H();
        this.O2 = true;
        this.P2 = new I();
        this.Q2 = 4;
        this.R2 = r3[0];
        this.S2 = new ArrayList();
        this.T2 = 0;
        this.U2 = 0;
        this.V2 = false;
        this.X2 = new K();
        this.Y2 = new L();
        this.Z2 = new a();
        this.a3 = new b(Looper.getMainLooper());
        this.e3 = new n();
        this.f3 = new p();
        this.g3 = new q();
        this.h3 = new r();
        this.i3 = 0;
        this.j3 = false;
        this.o3 = 0;
        s2(context);
    }

    public static /* synthetic */ void A(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        nSTIJKPlayerEpisodes.A2();
    }

    public static /* synthetic */ TextView A0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.q2;
    }

    public static /* synthetic */ SharedPreferences A1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.x1;
    }

    public static /* synthetic */ int B(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.q0 = i2;
        return i2;
    }

    public static /* synthetic */ P B0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.c1;
    }

    public static /* synthetic */ int B1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.g0 = i2;
        return i2;
    }

    private void B2() {
        if (this.G0 <= 5) {
            Toast.makeText(this.J0, "Api Error, reconnects in 3sec(" + this.G0 + "/5) ", 0).show();
        }
        this.G0++;
        new Handler().postDelayed(new C(), 3000L);
    }

    public static /* synthetic */ SharedPreferences.Editor C1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.A1;
    }

    public static /* synthetic */ long D(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.T0;
    }

    public static /* synthetic */ long D0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.y0;
    }

    public static /* synthetic */ SharedPreferences.Editor D1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, SharedPreferences.Editor editor) {
        nSTIJKPlayerEpisodes.A1 = editor;
        return editor;
    }

    public static /* synthetic */ long E(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, long j2) {
        nSTIJKPlayerEpisodes.T0 = j2;
        return j2;
    }

    public static /* synthetic */ SharedPreferences E1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.w1;
    }

    public static /* synthetic */ long F0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, long j2) {
        nSTIJKPlayerEpisodes.y0 = j2;
        return j2;
    }

    public static /* synthetic */ SharedPreferences.Editor F1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.z1;
    }

    public static /* synthetic */ SharedPreferences.Editor G1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, SharedPreferences.Editor editor) {
        nSTIJKPlayerEpisodes.z1 = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences H1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.v1;
    }

    public static /* synthetic */ boolean I1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.j3;
    }

    private void I2() {
        TextView textView;
        StringBuilder sb;
        c3();
        if (HoneyPlayer.a4 || d2() || this.V0 == null || this.w2.getVisibility() != 8) {
            return;
        }
        this.e2.removeCallbacksAndMessages((Object) null);
        String str = this.s2;
        if (str != null && !str.equals("")) {
            this.o2 -= 10000;
        }
        String str2 = this.t2;
        this.o2 = (str2 == null || !str2.equals("catch_up")) ? this.o2 - 10000 : this.o2 - 60000;
        if (this.o2 > 0) {
            textView = this.v2;
            sb = new StringBuilder();
            sb.append("+");
        } else {
            textView = this.v2;
            sb = new StringBuilder();
        }
        sb.append(this.o2 / 1000);
        sb.append("s");
        textView.setText(sb.toString());
        this.k2.setText("");
        this.k2.startAnimation(this.z2);
        this.k2.setVisibility(0);
        if (this.x2.getVisibility() == 8) {
            this.x2.startAnimation(this.y2);
            this.x2.setVisibility(0);
        } else {
            this.x2.startAnimation(this.z2);
        }
        this.e2.postDelayed(new l(), 1000L);
    }

    public static /* synthetic */ long J(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.R0;
    }

    public static /* synthetic */ NSTIJKPlayerEpisodes J0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.V0;
    }

    public static /* synthetic */ boolean J1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, boolean z2) {
        nSTIJKPlayerEpisodes.j3 = z2;
        return z2;
    }

    public static /* synthetic */ TextView K0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.l1;
    }

    public static /* synthetic */ int K1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.i3;
    }

    public static /* synthetic */ boolean L(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.O2;
    }

    public static /* synthetic */ TextView L0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.m1;
    }

    public static /* synthetic */ int L1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.i3 = i2;
        return i2;
    }

    public static /* synthetic */ long M0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.Q0;
    }

    public static /* synthetic */ int M1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        int i2 = nSTIJKPlayerEpisodes.i3;
        nSTIJKPlayerEpisodes.i3 = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int N0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.O2();
    }

    public static /* synthetic */ ProgressBar N1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.l3;
    }

    public static /* synthetic */ long O0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, long j2) {
        nSTIJKPlayerEpisodes.Q0 = j2;
        return j2;
    }

    public static /* synthetic */ List O1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.f0;
    }

    private int O2() {
        if (this.q) {
            return 0;
        }
        if (this.D1) {
            k2(true);
            this.D1 = false;
            return 0;
        }
        int currentPosition = this.V0.getCurrentPosition();
        int duration = this.V0.getDuration();
        SeekBar seekBar = this.k1;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 1000) / duration));
            }
            this.k1.setSecondaryProgress(this.V0.getBufferPercentage() * 10);
        }
        try {
            if (duration == 0) {
                this.l1.setText("Live");
                this.m1.setText("");
            } else {
                this.l1.setText(h3(currentPosition));
                this.m1.setText(h3(duration));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return currentPosition;
    }

    public static /* synthetic */ boolean P(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, boolean z2) {
        nSTIJKPlayerEpisodes.O2 = z2;
        return z2;
    }

    public static /* synthetic */ RecyclerView P1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.m3;
    }

    public static /* synthetic */ boolean Q0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.z0;
    }

    public static /* synthetic */ IMediaPlayer Q1() {
        return x3;
    }

    public static /* synthetic */ void R0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        nSTIJKPlayerEpisodes.o3();
    }

    public static /* synthetic */ TextView R1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.n3;
    }

    public static /* synthetic */ int S(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.L0;
    }

    public static /* synthetic */ GestureDetector S0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.Z0;
    }

    public static /* synthetic */ void S1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, String str) {
        nSTIJKPlayerEpisodes.w2(str);
    }

    public static /* synthetic */ TextView T(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.T1;
    }

    public static /* synthetic */ void T0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        nSTIJKPlayerEpisodes.l2();
    }

    public static /* synthetic */ void T1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, String str) {
        nSTIJKPlayerEpisodes.k3(str);
    }

    public static /* synthetic */ TextView U1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.S1;
    }

    public static /* synthetic */ Button V1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.d1;
    }

    public static /* synthetic */ int W(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.L0 = i2;
        return i2;
    }

    public static /* synthetic */ String W0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.t1;
    }

    public static /* synthetic */ void W1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        nSTIJKPlayerEpisodes.I2();
    }

    public static /* synthetic */ SharedPreferences X() {
        return y3;
    }

    public static /* synthetic */ IMediaPlayer.OnPreparedListener X1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.p0;
    }

    public static /* synthetic */ SharedPreferences Y(SharedPreferences sharedPreferences) {
        y3 = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ int Y0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.H0;
    }

    private void Y1() {
    }

    public static /* synthetic */ Context Z(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.J0;
    }

    public static /* synthetic */ void Z0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.e2(i2);
    }

    private void Z2(int i2) {
        LinearLayout linearLayout;
        this.c = i2;
        if (i2 == -1) {
            if (this.e >= this.H0) {
                l2();
                if (!this.t1.equals("dfo") && !this.t1.equals("devicedata")) {
                    V2(this.U0.getResources().getString(a7.j.b7));
                }
                e3();
                this.f = false;
                return;
            }
            long currentPosition = x3.getCurrentPosition();
            if (currentPosition != 0) {
                x7.a.f().I(currentPosition);
            }
            if (currentPosition != 0) {
                SharedPreferences sharedPreferences = this.U0.getSharedPreferences("currentSeekTime", 0);
                this.n1 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.K = edit;
                edit.putString("currentSeekTime", String.valueOf(currentPosition));
                this.K.apply();
            }
            this.f = true;
            this.C0.postDelayed(new d(currentPosition), 3000L);
            return;
        }
        if (i2 == 1) {
            if (HoneyPlayer.O1()) {
                return;
            }
            LinearLayout linearLayout2 = this.r2;
            if (linearLayout2 != null && linearLayout2.getVisibility() == 0) {
                this.r2.setVisibility(8);
            }
            this.c1.b(a7.f.A).e();
            return;
        }
        if (i2 == 3) {
            this.e = 0;
            this.c1.b(a7.f.I5).a();
            this.c1.b(a7.f.H5).e();
            HoneyPlayer honeyPlayer = this.U0;
            if (honeyPlayer instanceof HoneyPlayer) {
                honeyPlayer.S1();
            }
            if (this.F0) {
                this.c1.b(a7.f.H5).c();
            }
        } else {
            if (i2 == 6) {
                this.e = 0;
                this.c1.b(a7.f.G).a();
                this.c1.b(a7.f.Im).e();
                this.c1.b(a7.f.I5).a();
                this.c1.b(a7.f.H5).e();
                HoneyPlayer honeyPlayer2 = this.U0;
                if (honeyPlayer2 instanceof HoneyPlayer) {
                    honeyPlayer2.S1();
                }
                this.c1.b(a7.f.A).a();
                if (HoneyPlayer.a4 || d2() || this.b2.getVisibility() != 0 || (linearLayout = this.r2) == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                return;
            }
            if (i2 != 2) {
                if (i2 == 4) {
                    this.c1.b(a7.f.I5).e();
                    this.c1.b(a7.f.H5).a();
                    if (this.F0) {
                        this.c1.b(a7.f.I5).c();
                        return;
                    }
                    return;
                }
                return;
            }
            this.K1 = true;
            this.c1.b(a7.f.I5).a();
            this.c1.b(a7.f.H5).e();
            this.c1.b(a7.f.H5).c();
            HoneyPlayer honeyPlayer3 = this.U0;
            if (honeyPlayer3 instanceof HoneyPlayer) {
                honeyPlayer3.S1();
            }
            int d2 = w7.e.d(x3, 1);
            int d3 = w7.e.d(x3, 2);
            this.d3 = w7.e.d(x3, 3);
            SharedPreferences sharedPreferences2 = this.U0.getSharedPreferences("auto_start", 0);
            this.u1 = sharedPreferences2;
            this.b3 = sharedPreferences2.getBoolean("subtitle_active", true);
            SharedPreferences sharedPreferences3 = this.U0.getSharedPreferences("currentSubtitleTrack", 0);
            this.v1 = sharedPreferences3;
            this.c3 = sharedPreferences3.getInt("currentSubtitleTrack", -2);
            if (!this.b3) {
                this.O2 = false;
            }
            W2(this.O1, this.P1, this.Q1, this.N1, this.M1, this.L1, this.S1, this.T1, this.X1);
            SharedPreferences sharedPreferences4 = this.U0.getSharedPreferences("currentAudioTrack", 0);
            this.w1 = sharedPreferences4;
            int i3 = sharedPreferences4.getInt("currentAudioTrack", -2);
            if (i3 != -2 && i3 != d3) {
                if (i3 == -1) {
                    i2(d3);
                } else {
                    K2(i3);
                }
            }
            SharedPreferences sharedPreferences5 = this.U0.getSharedPreferences("currentVideoTrack", 0);
            this.x1 = sharedPreferences5;
            int i4 = sharedPreferences5.getInt("currentVideoTrack", -2);
            if (i4 != -2 && i4 != d2) {
                if (i4 == -1) {
                    i2(d2);
                } else {
                    K2(i4);
                }
            }
            String type = SharepreferenceDBHandler.getType(getContext());
            if (type.equals("movies") && !this.s1.equals("m3u")) {
                N2();
            } else if (type.equals("series") && !this.s1.equals("m3u")) {
                this.s.f();
                Activity activity = this.U0;
                if (activity != null && SharepreferenceDBHandler.getisAutoPlayVideos(activity)) {
                    X2();
                }
            }
            if (m7.a.q0) {
                m7.a.l0 = 0;
            }
            this.e = 0;
            O2();
            this.c1.b(a7.f.G).a();
            this.c1.b(a7.f.Im).e();
            this.c1.b(a7.f.I5).a();
            this.c1.b(a7.f.H5).e();
            HoneyPlayer honeyPlayer4 = this.U0;
            if (honeyPlayer4 instanceof HoneyPlayer) {
                honeyPlayer4.S1();
            }
        }
        this.c1.b(a7.f.A).a();
    }

    public static /* synthetic */ int a1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.o2;
    }

    public static /* synthetic */ TextView b0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.a;
    }

    public static /* synthetic */ int b1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.o2 = i2;
        return i2;
    }

    private void b2(IMediaPlayer iMediaPlayer, a.b bVar) {
        if (iMediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            bVar.b(iMediaPlayer);
        }
    }

    public static /* synthetic */ TextView c0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.L1;
    }

    public static /* synthetic */ Animation c1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.i2;
    }

    private String c2(String str) {
        return TextUtils.isEmpty(str) ? "und" : str;
    }

    public static /* synthetic */ long d1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.P0;
    }

    public static /* synthetic */ FrameLayout e1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.x2;
    }

    public static /* synthetic */ void f(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        nSTIJKPlayerEpisodes.v2();
    }

    public static /* synthetic */ String f1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.t2;
    }

    private int f3(int i2, int i3) {
        return this.o1.isStreamAvailable(String.valueOf(i2), i3);
    }

    public static /* synthetic */ TextView g1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.k2;
    }

    private void g2() {
        if (this.o3 <= 5) {
            Toast.makeText(this.J0, "Api Error, reconnects in 3sec(" + this.o3 + "/5) ", 0).show();
        }
        this.o3++;
        new Handler().postDelayed(new B(), 3000L);
    }

    private int g3(String str, int i2) {
        return this.o1.isStreamAvailable(String.valueOf(str), i2);
    }

    public static /* synthetic */ int h(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.j0;
    }

    public static /* synthetic */ LinearLayout h1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.b2;
    }

    public static /* synthetic */ List i0() {
        return u3;
    }

    public static /* synthetic */ SeekBar i1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.k1;
    }

    private void i3(boolean z2) {
        LayoutInflater from;
        int i2;
        this.j3 = false;
        this.i3 = 0;
        t3.setVisibility(0);
        this.D2.setVisibility(8);
        if (z2) {
            this.k3 = ((LayoutInflater) this.J0.getSystemService("layout_inflater")).inflate(a7.g.p2, findViewById(a7.f.ih)).findViewById(a7.f.Yg);
            t3.setVisibility(0);
            this.D2.setVisibility(8);
            if (getContext() != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), a7.k.a);
                if (this.K0.A().equals(m7.a.K0)) {
                    from = LayoutInflater.from(getContext());
                    i2 = a7.g.b3;
                } else {
                    from = LayoutInflater.from(getContext());
                    i2 = a7.g.a3;
                }
                View inflate = from.inflate(i2, (ViewGroup) null);
                this.l3 = inflate.findViewById(a7.f.Nc);
                this.m3 = inflate.findViewById(a7.f.Dd);
                TextView findViewById = inflate.findViewById(a7.f.X2);
                this.n3 = findViewById;
                findViewById.setVisibility(8);
                inflate.findViewById(a7.f.l2).setOnClickListener(new z());
                this.f0 = new ArrayList();
                this.l3.setVisibility(0);
                TextView findViewById2 = inflate.findViewById(a7.f.X2);
                this.n3 = findViewById2;
                findViewById2.setVisibility(8);
                this.f0 = new ArrayList();
                this.n3.setVisibility(8);
                builder.setView(inflate);
                this.C = builder.create();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(this.C.getWindow().getAttributes());
                layoutParams.width = -2;
                layoutParams.height = -2;
                new Rect();
                this.C.show();
                this.C.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                this.C.getWindow().setAttributes(layoutParams);
                this.C.setCancelable(true);
                this.C.show();
            }
        }
        OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = builder2.connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).build();
        Log.e("jaskirat", "tmdb_id" + this.R);
        j1.a.a("https://api.opensubtitles.com/api/v1/subtitles?tmdb_id=" + this.R).p("User-Agent", "Private Stream Plus v1.0.0").p("Accept", "application/json").p("Api-Key", "ZCyXegBRifdfqktSPAiyrtlpknf2RBrLsd").p("Content-Type", "application/json").p("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJrVzBLUlE1S3FiT08wZXpQS0NOazBOY1dWU1BvcmlONiIsImV4cCI6MTcwMDkwMTcwN30.VPitYBEcXa-iFREzVDtyDxJZlmSjDKeh0iWIUltJtFM").t("test").r(build).s(k1.e.LOW).q().o(new A());
    }

    public static /* synthetic */ int j0() {
        return v3;
    }

    public static /* synthetic */ boolean j1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.g2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void j3() {
        int i2;
        CharSequence[] charSequenceArr = {"10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40"};
        a.a aVar = new a.a(getContext());
        aVar.setTitle(getResources().getString(a7.j.R7));
        String string = y3.getString("pref.using_sub_font_size", m7.a.x0);
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
        aVar.l(charSequenceArr, i2, new D());
        try {
            androidx.appcompat.app.a create = aVar.create();
            this.Y1 = create;
            create.setOnDismissListener(new E());
            this.Y1.show();
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int k(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.j0 = i2;
        return i2;
    }

    public static /* synthetic */ int k0() {
        int i2 = v3;
        v3 = i2 + 1;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnCompletionListener k1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.o0;
    }

    private void k3(String str) {
        try {
            SharedPreferences sharedPreferences = this.U0.getSharedPreferences("pref.using_sub_font_size", 0);
            y3 = sharedPreferences;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            this.R1 = edit;
            if (edit != null) {
                edit.putString("pref.using_sub_font_size", str);
                this.R1.apply();
            }
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int l(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.k0;
    }

    public static /* synthetic */ Handler l0() {
        return w3;
    }

    public static /* synthetic */ FrameLayout l1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.w2;
    }

    public static /* synthetic */ float m0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.Y0;
    }

    public static /* synthetic */ TextView m1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.l2;
    }

    public static /* synthetic */ w7.b n(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        nSTIJKPlayerEpisodes.getClass();
        return null;
    }

    public static /* synthetic */ float n0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, float f2) {
        nSTIJKPlayerEpisodes.Y0 = f2;
        return f2;
    }

    public static /* synthetic */ IMediaPlayer.OnInfoListener n1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.s0;
    }

    private void n3() {
        View findViewById = this.U0.findViewById(a7.f.p);
        this.b1 = findViewById;
        findViewById.setClickable(true);
        this.b1.setOnTouchListener(new c());
    }

    public static /* synthetic */ int o(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.k0 = i2;
        return i2;
    }

    public static /* synthetic */ w7.c o1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.O0;
    }

    private void o3() {
        IMediaPlayer iMediaPlayer = x3;
        if (iMediaPlayer == null || !iMediaPlayer.isPlaying()) {
            this.c1.b(a7.f.H5).a();
            this.c1.b(a7.f.I5).e();
            M m2 = this.S;
            if (m2 != null) {
                m2.b();
                return;
            }
            return;
        }
        this.c1.b(a7.f.I5).a();
        this.c1.b(a7.f.H5).e();
        HoneyPlayer honeyPlayer = this.U0;
        if (honeyPlayer instanceof HoneyPlayer) {
            honeyPlayer.S1();
        }
        M m3 = this.S;
        if (m3 != null) {
            m3.a();
        }
    }

    public static /* synthetic */ int p(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.t0;
    }

    public static /* synthetic */ TextView p0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.p2;
    }

    public static /* synthetic */ void p1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.Z2(i2);
    }

    public static /* synthetic */ int q0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.M0;
    }

    public static /* synthetic */ int q1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.n0 = i2;
        return i2;
    }

    private void q2() {
        boolean p2 = this.K0.p();
        this.V2 = p2;
        if (p2) {
            v7.a.b(getContext());
            IMediaPlayer a2 = v7.a.a();
            x3 = a2;
            w7.c cVar = this.O0;
            if (cVar != null) {
                cVar.l(a2);
            }
        }
    }

    public static /* synthetic */ int r(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.l0;
    }

    public static /* synthetic */ Activity r0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.U0;
    }

    public static /* synthetic */ String r1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.T;
    }

    private void r2() {
        this.S2.clear();
        if (this.K0.s()) {
            this.S2.add(1);
        }
        if (this.K0.t()) {
            this.S2.add(2);
        }
        if (this.K0.r()) {
            this.S2.add(0);
        }
        if (this.S2.isEmpty()) {
            this.S2.add(1);
        }
        int intValue = ((Integer) this.S2.get(this.T2)).intValue();
        this.U2 = intValue;
        setRender(intValue);
    }

    public static /* synthetic */ int s0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.M0 = i2;
        return i2;
    }

    public static /* synthetic */ IMediaPlayer.OnErrorListener s1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.r0;
    }

    private void s2(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.J0 = applicationContext;
        this.K0 = new u7.a(applicationContext);
        this.O = new n7.l(this, this.J0);
        q2();
        r2();
        this.j0 = 0;
        this.k0 = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.g0 = 0;
        this.h0 = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref.using_sub_font_size", 0);
        y3 = sharedPreferences;
        String string = sharedPreferences.getString("pref.using_sub_font_size", m7.a.x0);
        this.h = new TextView(context);
        s3 = new TextView(context);
        try {
            TextView textView = this.a;
            if (textView != null) {
                textView.setTextSize(2, Float.parseFloat(string));
            }
            s3.setTextSize(2, Float.parseFloat(string));
            this.h.setTextSize(2, Float.parseFloat(string));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        s3.setTextColor(context.getResources().getColor(a7.c.G));
        s3.setGravity(17);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams.setMargins(0, 0, 0, 40);
        addView(s3, layoutParams);
        this.h.setTextColor(context.getResources().getColor(a7.c.G));
        this.h.setGravity(17);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams2.setMargins(0, 0, 0, 40);
        addView(this.h, layoutParams2);
    }

    public static /* synthetic */ u7.a t0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.K0;
    }

    public static /* synthetic */ a.b t1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, a.b bVar) {
        nSTIJKPlayerEpisodes.i0 = bVar;
        return bVar;
    }

    public static /* synthetic */ int u(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.l0 = i2;
        return i2;
    }

    public static /* synthetic */ void u1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, IMediaPlayer iMediaPlayer, a.b bVar) {
        nSTIJKPlayerEpisodes.b2(iMediaPlayer, bVar);
    }

    private boolean u2() {
        int i2;
        return (x3 == null || (i2 = this.g0) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public static /* synthetic */ int v(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.m0;
    }

    public static /* synthetic */ LinearLayout v1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.r2;
    }

    public static /* synthetic */ int w(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.m0 = i2;
        return i2;
    }

    public static /* synthetic */ void w1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, boolean z2) {
        nSTIJKPlayerEpisodes.i3(z2);
    }

    private void w2(String str) {
        this.n3.setVisibility(0);
        t3.setVisibility(8);
        this.l3.setVisibility(8);
        this.C.dismiss();
        this.k3.setText(str);
        this.n3.setText("No subtitles found");
    }

    public static /* synthetic */ int x(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.h0;
    }

    public static /* synthetic */ AudioManager x0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.W0;
    }

    public static /* synthetic */ void x1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        nSTIJKPlayerEpisodes.j3();
    }

    public static /* synthetic */ SharedPreferences.Editor y1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.B1;
    }

    public static /* synthetic */ int z(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, int i2) {
        nSTIJKPlayerEpisodes.h0 = i2;
        return i2;
    }

    public static /* synthetic */ int z0(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes) {
        return nSTIJKPlayerEpisodes.X0;
    }

    public static /* synthetic */ SharedPreferences.Editor z1(NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, SharedPreferences.Editor editor) {
        nSTIJKPlayerEpisodes.B1 = editor;
        return editor;
    }

    public static long z2(String str) {
        String[] split = str.split(":|,");
        return (Integer.parseInt(split[0]) * 3600000) + (Integer.parseInt(split[1]) * 60000) + (Integer.parseInt(split[2]) * 1000) + Integer.parseInt(split[3]);
    }

    public final void A2() {
        try {
            m2();
            LinearLayout findViewById = this.U0.findViewById(a7.f.U8);
            if (findViewById != null) {
                findViewById.performClick();
            }
        } catch (Exception unused) {
        }
    }

    public void C2(boolean z2) {
        try {
            b3();
            IMediaPlayer iMediaPlayer = x3;
            if (iMediaPlayer != null) {
                iMediaPlayer.reset();
                x3.release();
                x3 = null;
                this.g0 = 0;
                if (z2) {
                    this.h0 = 0;
                }
                ((AudioManager) this.J0.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
        } catch (Exception unused) {
        }
    }

    public void D2() {
        IMediaPlayer iMediaPlayer = x3;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    public void E0(String str) {
    }

    public void E2(boolean z2) {
        this.D1 = z2;
    }

    public int F2() {
        com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = this.g;
        if (aVar == null || aVar.getView() == null || this.g.getView().getHeight() == 0) {
            return 0;
        }
        return this.g.getView().getHeight();
    }

    public int G2() {
        com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar = this.g;
        if (aVar == null || aVar.getView() == null || this.g.getView().getWidth() == 0) {
            return 0;
        }
        return this.g.getView().getWidth();
    }

    public void H2(int i2) {
        if (x3 == null) {
            return;
        }
        this.y0 = (int) (this.V0.getDuration() * ((i2 * 1.0d) / 1000.0d));
        this.q = true;
        this.a3.removeMessages(1);
        if (this.V0.isPlaying()) {
            this.V0.pause();
        }
        c3();
        this.l1.setText(h3((int) this.y0));
        this.m1.setText(h3(this.V0.getDuration()));
        Handler handler = this.f2;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f2.postDelayed(new m(), 1000L);
        }
    }

    public void J2() {
        TextView textView;
        StringBuilder sb;
        c3();
        if (HoneyPlayer.a4 || d2() || this.V0 == null || this.x2.getVisibility() != 8) {
            return;
        }
        this.e2.removeCallbacksAndMessages((Object) null);
        String str = this.s2;
        if (str != null && !str.equals("")) {
            this.o2 += 10000;
        }
        String str2 = this.t2;
        if (str2 == null || !str2.equals("catch_up")) {
            this.o2 += 10000;
        } else {
            this.o2 += 60000;
        }
        if (this.o2 > 0) {
            textView = this.u2;
            sb = new StringBuilder();
            sb.append("+");
        } else {
            textView = this.u2;
            sb = new StringBuilder();
        }
        sb.append(this.o2 / 1000);
        sb.append("s");
        textView.setText(sb.toString());
        this.l2.setText("");
        this.l2.startAnimation(this.z2);
        this.l2.setVisibility(0);
        if (this.w2.getVisibility() == 8) {
            this.w2.startAnimation(this.y2);
            this.w2.setVisibility(0);
        } else {
            this.w2.startAnimation(this.z2);
        }
        this.e2.postDelayed(new o(), 1000L);
    }

    public void K(VodInfoCallback vodInfoCallback) {
    }

    public void K2(int i2) {
        w7.e.e(x3, i2);
    }

    public void L2(Activity activity, NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes, SeekBar seekBar, TextView textView, TextView textView2, RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, SeekBar seekBar2, SeekBar seekBar3, LinearLayout linearLayout, Animation animation, Animation animation2, TextView textView8, TextView textView9, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView10, LinearLayout linearLayout4, String str, String str2, TextView textView11, FrameLayout frameLayout, Animation animation3, Animation animation4, TextView textView12, FrameLayout frameLayout2, TextView textView13, RelativeLayout relativeLayout, LinearLayout linearLayout5, Animation animation5, LinearLayout linearLayout6, Animation animation6, Animation animation7, RelativeLayout relativeLayout2, ImageView imageView, TextView textView14, RelativeLayout relativeLayout3, TextView textView15, TextView textView16, LinearLayout linearLayout7, FrameLayout frameLayout3, TextView textView17, String str3, LinearLayout linearLayout8, LinearLayout linearLayout9, RecyclerView recyclerView, ProgressBar progressBar, TextView textView18, LinearLayout linearLayout10) {
        this.U0 = activity;
        this.V0 = nSTIJKPlayerEpisodes;
        this.C0 = new Handler();
        this.U1 = textView18;
        this.k1 = seekBar;
        this.l1 = textView;
        this.W1 = linearLayout10;
        this.m1 = textView2;
        this.D0 = new Handler();
        this.o1 = new RecentWatchDBHandler(activity);
        this.p1 = new LiveStreamDBHandler(activity);
        this.O1 = radioGroup;
        this.P1 = radioGroup2;
        this.Q1 = radioGroup3;
        this.N1 = textView3;
        this.M1 = textView4;
        this.L1 = textView5;
        this.S1 = textView6;
        this.T1 = textView7;
        this.Z1 = seekBar2;
        this.a2 = seekBar3;
        this.b2 = linearLayout;
        this.w = new Handler();
        this.c2 = new Handler();
        this.e2 = new Handler();
        this.y = new Handler();
        this.f2 = new Handler();
        this.h2 = animation;
        this.i2 = animation2;
        this.k2 = textView8;
        textView8.setOnClickListener(this);
        this.l2 = textView9;
        textView9.setOnClickListener(this);
        this.m2 = linearLayout2;
        this.n2 = linearLayout3;
        this.Z1.setOnSeekBarChangeListener(this.X2);
        this.a2.setOnSeekBarChangeListener(this.Y2);
        this.p2 = textView10;
        this.a = textView17;
        this.R = str3;
        this.Q = linearLayout8;
        this.V1 = progressBar;
        this.P = linearLayout9;
        seekBar2.setKeyProgressIncrement(1);
        float f2 = this.U0.getWindow().getAttributes().screenBrightness;
        this.Y0 = f2;
        if (f2 == -1.0f) {
            this.Y0 = this.K0 != null ? r3.o() : m7.a.J0;
        }
        seekBar2.setProgress((int) this.Y0);
        this.r2 = linearLayout4;
        this.s2 = str;
        this.t2 = str2;
        this.u2 = textView11;
        this.v2 = textView12;
        this.w2 = frameLayout;
        this.x2 = frameLayout2;
        this.y2 = animation3;
        this.z2 = animation4;
        this.q2 = textView13;
        this.A2 = relativeLayout;
        this.D2 = linearLayout5;
        this.B2 = animation5;
        this.C2 = linearLayout6;
        this.E2 = animation6;
        this.F2 = animation7;
        this.t = relativeLayout2;
        this.u = imageView;
        this.v = textView14;
        this.H2 = relativeLayout3;
        this.H1 = textView15;
        this.I1 = textView16;
        this.J1 = linearLayout7;
        this.c1 = new P(activity);
        this.X1 = frameLayout3;
    }

    public void M2(Context context, ArrayList arrayList, int i2) {
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
        String url = SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api") ? ((LiveStreamsDBModel) arrayList.get(i2)).getUrl() : "";
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
        if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api")) {
            panelAvailableChannelsPojo.setUrl(url);
        }
        this.o1.addAllAvailableChannel(panelAvailableChannelsPojo);
    }

    public void N2() {
        Context context = getContext();
        if (x7.a.f() != null) {
            int g3 = SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api") ? g3(x7.a.f().m(), SharepreferenceDBHandler.getUserID(context)) : f3(x7.a.f().k(), SharepreferenceDBHandler.getUserID(context));
            if (g3 <= 0 && g3 == 0 && !this.t1.equals("dfo") && !this.t1.equals("devicedata")) {
                P2(context, x7.a.f().c(), x7.a.f().d());
            }
        }
    }

    public final void P2(Context context, ArrayList arrayList, int i2) {
        M2(context, arrayList, i2);
    }

    public void Q2(String str, boolean z2, String str2, long j2, int i2, String str3, ArrayList arrayList, int i3, int i4, String str4, String str5, String str6) {
        this.t1 = str5;
        S2(Uri.parse(str), z2, str2, j2, i2, str3, arrayList, i3, i4, str4, str6);
    }

    public final void R2(Uri uri, Map map, boolean z2, String str, long j2, int i2, String str2, ArrayList arrayList, int i3, int i4, String str3, String str4) {
        this.V = uri;
        this.W = str;
        this.e0 = map;
        this.t0 = 0;
        this.F0 = z2;
        this.M = str2;
        this.n = j2;
        this.m = str4;
        this.l = i2;
        this.L = i4;
        this.N = arrayList;
        this.q1 = new PlayerResumeDBHandler(this.U0);
        this.o1 = new RecentWatchDBHandler(this.U0);
        this.F1 = new SeriesRecentWatchDatabase(this.U0);
        this.s = new z0(this.U0);
        this.p1 = new LiveStreamDBHandler(this.U0);
        this.r1 = SharepreferenceDBHandler.getUserID(this.U0);
        this.E0 = i3;
        this.s1 = str3;
        e3();
        x2();
        requestLayout();
        invalidate();
    }

    public void S2(Uri uri, boolean z2, String str, long j2, int i2, String str2, ArrayList arrayList, int i3, int i4, String str3, String str4) {
        R2(uri, null, z2, str, j2, i2, str2, arrayList, i3, i4, str3, str4);
    }

    public void T2() {
        if (HoneyPlayer.a4 || d2() || this.b2.getVisibility() != 8) {
            return;
        }
        g();
        this.b2.startAnimation(this.h2);
        this.b2.setVisibility(0);
        if (this.m2.getVisibility() == 8) {
            this.m2.startAnimation(this.h2);
            this.m2.setVisibility(0);
        }
        if (this.k2.getVisibility() == 8) {
            this.k2.startAnimation(this.h2);
            this.k2.setVisibility(0);
        }
        if (this.r2.getVisibility() == 8 && !HoneyPlayer.O1()) {
            this.r2.startAnimation(this.h2);
            this.r2.setVisibility(0);
        }
        if (this.l2.getVisibility() == 8) {
            this.l2.startAnimation(this.h2);
            this.l2.setVisibility(0);
        }
        if (this.n2.getVisibility() == 8) {
            this.n2.startAnimation(this.h2);
            this.n2.setVisibility(0);
        }
    }

    public void U2() {
        if (this.b2.getVisibility() == 8) {
            this.C2.startAnimation(this.E2);
            this.C2.setVisibility(0);
        }
    }

    public final void V2(String str) {
        this.c1.b(a7.f.Im).a();
        this.c1.b(a7.f.G).e();
        this.c1.b(a7.f.K).d(str);
    }

    public void W2(RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, FrameLayout frameLayout) {
        TextView textView6;
        int i2;
        int i3;
        ITrackInfo[] iTrackInfoArr;
        if (x3 == null) {
            return;
        }
        radioGroup.removeAllViews();
        radioGroup2.removeAllViews();
        radioGroup3.removeAllViews();
        try {
            SharedPreferences sharedPreferences = this.U0.getSharedPreferences("pref.using_sub_font_size", 0);
            y3 = sharedPreferences;
            textView4.setText(sharedPreferences.getString("pref.using_sub_font_size", m7.a.x0));
            textView5.setOnClickListener(new t());
            frameLayout.setOnClickListener(new u());
        } catch (Exception unused) {
        }
        Boolean bool = Boolean.FALSE;
        this.j1 = bool;
        this.i1 = bool;
        this.h1 = bool;
        this.f1 = bool;
        this.e1 = bool;
        this.g1 = bool;
        int d2 = w7.e.d(x3, 1);
        int d3 = w7.e.d(x3, 2);
        int d4 = w7.e.d(x3, 3);
        ITrackInfo[] trackInfo = x3.getTrackInfo();
        if (trackInfo == null || trackInfo.length <= 0) {
            textView6 = textView3;
            i2 = 0;
            textView.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            int length = trackInfo.length;
            int i4 = 0;
            int i5 = -1;
            while (i4 < length) {
                ITrackInfo iTrackInfo = trackInfo[i4];
                int i6 = i5 + 1;
                int trackType = iTrackInfo.getTrackType();
                int i7 = length;
                IMediaFormat format = iTrackInfo.getFormat();
                if (format != null && (format instanceof IjkMediaFormat)) {
                    iTrackInfoArr = trackInfo;
                    if (trackType == 1) {
                        Boolean bool2 = Boolean.TRUE;
                        this.h1 = bool2;
                        if (!this.e1.booleanValue()) {
                            this.e1 = bool2;
                            RadioButton radioButton = new RadioButton(this.U0);
                            radioButton.setText("Disable");
                            radioButton.setTextColor(getResources().getColor(a7.c.G));
                            radioButton.setTextSize(13.0f);
                            radioButton.setId(11111111);
                            radioButton.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.J0, a7.c.G)));
                            radioButton.setPadding(0, 0, 16, 0);
                            radioButton.setOnFocusChangeListener(new N(radioButton));
                            if (d2 == -1) {
                                radioButton.setChecked(true);
                                radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton.setTag("2");
                            radioGroup.addView(radioButton);
                        }
                        RadioButton radioButton2 = new RadioButton(this.U0);
                        iTrackInfo.getInfoInline();
                        radioButton2.setText(i6 + ", " + iTrackInfo.getInfoInline());
                        if (i6 == -1) {
                            radioButton2.setId(111);
                        } else {
                            radioButton2.setId(i6);
                        }
                        radioButton2.setTextColor(getResources().getColor(a7.c.G));
                        radioButton2.setTextSize(13.0f);
                        radioButton2.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.J0, a7.c.G)));
                        radioButton2.setPadding(0, 0, 16, 0);
                        radioButton2.setOnFocusChangeListener(new N(radioButton2));
                        if (i6 == d2) {
                            radioButton2.setChecked(true);
                            radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton2.setTag("2");
                        radioGroup.addView(radioButton2);
                        radioGroup.setOnCheckedChangeListener(new w(d2));
                        i4++;
                        i5 = i6;
                        length = i7;
                        trackInfo = iTrackInfoArr;
                    } else if (trackType == 2) {
                        Boolean bool3 = Boolean.TRUE;
                        this.i1 = bool3;
                        if (!this.f1.booleanValue()) {
                            this.f1 = bool3;
                            RadioButton radioButton3 = new RadioButton(this.U0);
                            radioButton3.setText("Disable");
                            radioButton3.setTextColor(getResources().getColor(a7.c.G));
                            radioButton3.setTextSize(13.0f);
                            radioButton3.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.J0, a7.c.G)));
                            radioButton3.setId(1111111);
                            radioButton3.setPadding(0, 0, 16, 0);
                            radioButton3.setOnFocusChangeListener(new N(radioButton3));
                            if (d3 == -1) {
                                radioButton3.setChecked(true);
                                radioGroup2.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton3.setTag("2");
                            radioGroup2.addView(radioButton3);
                        }
                        RadioButton radioButton4 = new RadioButton(this.U0);
                        radioButton4.setText(i6 + ", " + iTrackInfo.getInfoInline() + ", " + c2(iTrackInfo.getLanguage()));
                        radioButton4.setTextColor(getResources().getColor(a7.c.G));
                        radioButton4.setTextSize(13.0f);
                        radioButton4.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.J0, a7.c.G)));
                        if (i6 == -1) {
                            radioButton4.setId(1111);
                        } else {
                            radioButton4.setId(i6);
                        }
                        radioButton4.setPadding(0, 0, 16, 0);
                        radioButton4.setOnFocusChangeListener(new N(radioButton4));
                        if (i6 == d3) {
                            radioButton4.setChecked(true);
                            radioGroup2.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton4.setTag("2");
                        radioGroup2.addView(radioButton4);
                        radioGroup2.setOnCheckedChangeListener(new x(d3));
                    } else if (trackType == 3) {
                        Boolean bool4 = Boolean.TRUE;
                        this.j1 = bool4;
                        if (!this.g1.booleanValue()) {
                            this.g1 = bool4;
                            RadioButton radioButton5 = new RadioButton(this.U0);
                            radioButton5.setText("Disable");
                            radioButton5.setTextColor(getResources().getColor(a7.c.G));
                            radioButton5.setTextSize(13.0f);
                            radioButton5.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.J0, a7.c.G)));
                            radioButton5.setId(111111);
                            radioButton5.setPadding(0, 0, 16, 0);
                            radioButton5.setOnFocusChangeListener(new N(radioButton5));
                            if (!this.b3) {
                                this.a.setVisibility(8);
                                radioButton5.setChecked(true);
                            } else if (d4 == -1) {
                                radioButton5.setChecked(true);
                                radioGroup3.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                            }
                            radioButton5.setTag("2");
                            radioGroup3.addView(radioButton5);
                        }
                        RadioButton radioButton6 = new RadioButton(this.U0);
                        radioButton6.setText(i6 + ", " + iTrackInfo.getInfoInline());
                        radioButton6.setTextColor(getResources().getColor(a7.c.G));
                        radioButton6.setTextSize(13.0f);
                        radioButton6.setButtonTintList(ColorStateList.valueOf(E.b.getColor(this.J0, a7.c.G)));
                        if (i6 == -1) {
                            radioButton6.setId(11111);
                        } else {
                            radioButton6.setId(i6);
                        }
                        radioButton6.setPadding(0, 0, 16, 0);
                        radioButton6.setOnFocusChangeListener(new N(radioButton6));
                        if (i6 == d4) {
                            radioButton6.setChecked(true);
                            radioGroup3.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                        }
                        radioButton6.setTag("2");
                        radioGroup3.addView(radioButton6);
                        radioGroup3.setOnCheckedChangeListener(new y());
                    }
                } else {
                    iTrackInfoArr = trackInfo;
                }
                i4++;
                i5 = i6;
                length = i7;
                trackInfo = iTrackInfoArr;
            }
            if (this.h1.booleanValue()) {
                i2 = 0;
                i3 = 8;
                textView.setVisibility(8);
            } else {
                i2 = 0;
                textView.setVisibility(0);
                i3 = 8;
            }
            if (this.i1.booleanValue()) {
                textView2.setVisibility(i3);
            } else {
                textView2.setVisibility(i2);
            }
            if (this.j1.booleanValue()) {
                textView6 = textView3;
                textView5.setVisibility(i2);
            } else {
                textView5.setVisibility(i2);
                textView6 = textView3;
            }
        }
        textView6.setVisibility(i2);
    }

    public void X2() {
        try {
            SharedPreferences sharedPreferences = this.U0.getSharedPreferences("auto_start", 0);
            this.y1 = sharedPreferences;
            String string = sharedPreferences.getString("autoplay_seconds", m7.a.t0);
            int r0 = m7.w.r0(m7.a.t0);
            if (string != null && string.contains("s")) {
                r0 = m7.w.r0(string.split("s")[0]);
            }
            if (this.y != null) {
                this.z = new e(r0);
                b3();
                this.y.postDelayed(this.z, 1000L);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Y2() {
        this.V1.setVisibility(8);
        this.W2 = new J();
        this.V1.setVisibility(8);
        w3.post(this.W2);
    }

    public void Z1(int i2) {
        if (HoneyPlayer.a4) {
            return;
        }
        if (!d2()) {
            this.x = new j();
        }
        this.w.postDelayed(this.x, i2);
    }

    public void a() {
    }

    public void a2(int i2) {
        i iVar = new i();
        this.d2 = iVar;
        this.c2.postDelayed(iVar, i2);
    }

    public void a3() {
        v7.a.d(null);
    }

    public void b() {
    }

    public void b3() {
        Handler handler = this.y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void c3() {
        Handler handler;
        if (HoneyPlayer.a4 || (handler = this.w) == null) {
            return;
        }
        handler.removeCallbacksAndMessages((Object) null);
    }

    public boolean canPause() {
        return this.u0;
    }

    public boolean canSeekBackward() {
        return this.v0;
    }

    public boolean canSeekForward() {
        return this.w0;
    }

    public void d(String str) {
    }

    public boolean d2() {
        RelativeLayout relativeLayout = this.t;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public void d3() {
        Handler handler = this.c2;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void e2(int i2) {
        Handler handler;
        int i3;
        Activity activity;
        List episodeList;
        try {
            if (this.y != null) {
                int duration = getDuration() / 1000;
                if (duration - (getCurrentPosition() / 1000) < i2) {
                    this.L2 = true;
                    this.K2--;
                }
                if (duration <= 0 || (i3 = this.K2) >= i2 || i3 == 0 || !this.L2) {
                    int i4 = this.K2;
                    if (i4 != 0 && i4 != 1) {
                        b3();
                        handler = this.y;
                    }
                    b3();
                    A2();
                    return;
                }
                Log.e(this.T, "timeup: " + this.K2);
                TextView textView = this.H1;
                if (textView != null) {
                    textView.setText(String.valueOf(this.K2));
                }
                TextView textView2 = this.I1;
                if (textView2 != null && this.v != null && !textView2.isFocused() && !this.v.isFocused()) {
                    c3();
                    Z1(0);
                    this.I1.requestFocus();
                }
                if (this.t != null) {
                    try {
                        if (Build.VERSION.SDK_INT < 24 || (activity = this.U0) == null || !w7.f.a(activity)) {
                            this.J2 = false;
                        } else {
                            this.t.setVisibility(8);
                            this.J2 = true;
                        }
                    } catch (Exception unused) {
                    }
                }
                RelativeLayout relativeLayout = this.t;
                if (relativeLayout != null && relativeLayout.getVisibility() == 8 && !this.J2) {
                    this.t.setVisibility(0);
                    if (this.u != null && (episodeList = EpisodesUsingSinglton.getInstance().getEpisodeList()) != null && episodeList.size() > 0) {
                        if (this.E0 == episodeList.size() - 1) {
                            this.E0 = 0;
                        } else {
                            this.E0++;
                        }
                        if (episodeList.size() > 1 && this.E0 <= episodeList.size() - 1) {
                            try {
                                com.squareup.picasso.t.q(this.J0.getApplicationContext()).l(((GetEpisdoeDetailsCallback) episodeList.get(this.E0)).getMovieImage()).g(this.u);
                            } catch (Exception e2) {
                                Log.e(this.T, "honey: " + e2.getMessage());
                            }
                        }
                    }
                    this.v.setOnClickListener(new f());
                    this.I1.setOnClickListener(new g());
                    this.J1.setOnClickListener(new h());
                }
                b3();
                handler = this.y;
                handler.postDelayed(this.z, 1000L);
            }
        } catch (Exception unused2) {
        }
    }

    public void e3() {
        try {
            IMediaPlayer iMediaPlayer = x3;
            if (iMediaPlayer != null) {
                iMediaPlayer.stop();
                x3.release();
                x3 = null;
                w7.c cVar = this.O0;
                if (cVar != null) {
                    cVar.l(null);
                }
                this.g0 = 0;
                this.h0 = 0;
                ((AudioManager) this.J0.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0058 A[PHI: r3
      0x0058: PHI (r3v1 java.lang.String) = (r3v0 java.lang.String), (r3v7 java.lang.String) binds: [B:9:0x0034, B:14:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tv.danmaku.ijk.media.player.IMediaPlayer f2(int r10) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.f2(int):tv.danmaku.ijk.media.player.IMediaPlayer");
    }

    public void g() {
        if (!this.z0) {
            this.z0 = true;
        }
        o3();
        Handler handler = this.a3;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        if (x3 != null) {
            return this.q0;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (u2()) {
            return (int) x3.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentPositionSeekbar() {
        return this.C1;
    }

    public int getCurrentWindowIndex() {
        return this.E0;
    }

    public int getDuration() {
        if (u2()) {
            return (int) x3.getDuration();
        }
        return -1;
    }

    public Boolean getFullScreenValue() {
        return Boolean.valueOf(this.F0);
    }

    public int getNewSeekPosition() {
        return (int) this.y0;
    }

    public boolean getPlayerIsPrepared() {
        return this.K1;
    }

    public boolean getProgress() {
        return this.E1;
    }

    public boolean getShowOrHideSubtitles() {
        return this.i;
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = x3;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    public void h2(boolean z2) {
        String string;
        Log.e("calling:", "vipserbver");
        t3.setVisibility(0);
        TextView findViewById = ((LayoutInflater) this.J0.getSystemService("layout_inflater")).inflate(a7.g.p2, findViewById(a7.f.ih)).findViewById(a7.f.Yg);
        new o1.a().c(a.a.BASIC);
        com.squareup.okhttp.OkHttpClient okHttpClient = new com.squareup.okhttp.OkHttpClient();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        okHttpClient.setConnectTimeout(15L, timeUnit);
        okHttpClient.setReadTimeout(15L, timeUnit);
        MediaType parse = MediaType.parse("application/json");
        Log.e("comingfileid", String.valueOf(this.B));
        try {
            Response execute = okHttpClient.newCall(new Request.Builder().url("https://api.opensubtitles.com/api/v1/download").post(RequestBody.create(parse, "{\n  \"file_id\":" + this.B + "\n}")).addHeader("User-Agent", "IPTVSmartersPlayer").addHeader("Accept", "application/json").addHeader("Api-Key", "ZCyXegBRifdfqktSPAiyrtlpknf2RBrL").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJrVzBLUlE1S3FiT08wZXpQS0NOazBOY1dWU1BvcmlONiIsImV4cCI6MTcwMDkwMTcwN30.VPitYBEcXa-iFREzVDtyDxJZlmSjDKeh0iWIUltJtFM").build()).execute();
            if (execute.body() != null) {
                String string2 = execute.body().string();
                try {
                    JSONObject jSONObject = new JSONObject(string2);
                    Log.e("vipserverrespnse", string2);
                    try {
                        if (jSONObject.getString("link") != null) {
                            Log.e("vipserverrespnse", this.E);
                            if (!this.E.isEmpty()) {
                                Log.e("TAG1:", this.E);
                                u3 = y2(this.E);
                                Y2();
                                return;
                            } else {
                                Log.e("TAG1:", this.E);
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
                        if (this.o3 <= 5) {
                            g2();
                        } else {
                            findViewById.setText((jSONObject.getString("message") == null || jSONObject.getString("message").isEmpty()) ? String.valueOf(e2) : jSONObject.getString("message"));
                        }
                        Log.e("TAG2:", String.valueOf(e2));
                    }
                } catch (JSONException e3) {
                    if (this.o3 <= 5) {
                        g2();
                    } else {
                        findViewById.setText(String.valueOf(e3));
                    }
                    e3.printStackTrace();
                }
            }
        } catch (IOException e4) {
            if (this.o3 <= 5) {
                g2();
            } else {
                findViewById.setText(String.valueOf(e4));
            }
            Log.e("TAG4:", String.valueOf(e4));
            e4.printStackTrace();
        }
    }

    public String h3(int i2) {
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = (i3 / 60) % 60;
        int i6 = i3 / 3600;
        try {
            this.I.setLength(0);
            return i6 > 0 ? this.J.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)}).toString() : this.J.format("%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)}).toString();
        } catch (Exception unused) {
            return this.J.format("%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)}).toString();
        }
    }

    public void i2(int i2) {
        w7.e.b(x3, i2);
    }

    public boolean isPlaying() {
        IMediaPlayer iMediaPlayer;
        return u2() && (iMediaPlayer = x3) != null && iMediaPlayer.isPlaying();
    }

    public void j2() {
        v7.a.d(x3);
    }

    public void k2(boolean z2) {
    }

    public final void l2() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int l3() {
        /*
            r6 = this;
            int r0 = r6.Q2
            r1 = 1
            int r0 = r0 + r1
            r6.Q2 = r0
            android.app.Activity r0 = r6.U0
            java.lang.String r2 = "loginPrefs"
            r3 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r3)
            r6.F = r0
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r6.G = r0
            int r0 = r6.Q2
            int[] r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.r3
            int r4 = r2.length
            int r0 = r0 % r4
            r6.Q2 = r0
            r0 = r2[r0]
            r6.R2 = r0
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a r0 = r6.g
            if (r0 == 0) goto Lb1
            android.app.Activity r0 = r6.U0
            int r2 = a7.f.X6
            android.view.View r0 = r0.findViewById(r2)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            android.app.Activity r2 = r6.U0
            int r4 = a7.f.n
            android.view.View r2 = r2.findViewById(r4)
            android.widget.TextView r2 = (android.widget.TextView) r2
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a r4 = r6.g
            int r5 = r6.R2
            r4.setAspectRatio(r5)
            int r4 = r6.Q2
            if (r4 != 0) goto L54
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.j2
        L4c:
            java.lang.String r1 = r1.getString(r4)
        L50:
            r2.setText(r1)
            goto L7d
        L54:
            if (r4 != r1) goto L5d
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.i2
            goto L4c
        L5d:
            r1 = 2
            if (r4 != r1) goto L67
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.Q8
            goto L4c
        L67:
            r1 = 3
            if (r4 != r1) goto L71
            android.content.res.Resources r1 = r6.getResources()
            int r4 = a7.j.j3
            goto L4c
        L71:
            r1 = 4
            if (r4 != r1) goto L77
            java.lang.String r1 = "16:9"
            goto L50
        L77:
            r1 = 5
            if (r4 != r1) goto L7d
            java.lang.String r1 = "4:3"
            goto L50
        L7d:
            android.content.SharedPreferences$Editor r1 = r6.G
            java.lang.String r2 = "aspect_ratio"
            int r4 = r6.Q2
            r1.putInt(r2, r4)
            android.content.SharedPreferences$Editor r1 = r6.G
            r1.apply()
            r0.setVisibility(r3)
            android.widget.LinearLayout r1 = r6.r2
            if (r1 == 0) goto L9f
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L9f
            android.widget.LinearLayout r1 = r6.r2
            r2 = 8
            r1.setVisibility(r2)
        L9f:
            android.os.Handler r1 = r6.D0
            r2 = 0
            r1.removeCallbacksAndMessages(r2)
            android.os.Handler r1 = r6.D0
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes$s r2 = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes$s
            r2.<init>(r0)
            r3 = 3000(0xbb8, double:1.482E-320)
            r1.postDelayed(r2, r3)
        Lb1:
            int r0 = r6.R2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.l3():int");
    }

    public void m2() {
        Runnable runnable;
        Handler handler = this.y;
        if (handler != null && (runnable = this.z) != null) {
            handler.removeCallbacks(runnable);
        }
        this.g2 = true;
        this.t.setAnimation(this.i2);
        this.t.setVisibility(8);
    }

    public void m3() {
        this.V0.p2();
        RelativeLayout relativeLayout = this.H2;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            if (HoneyPlayer.a4) {
                if (d2()) {
                    return;
                }
                d3();
                if (this.C2.getVisibility() == 0) {
                    o2();
                    return;
                } else {
                    U2();
                    a2(3000);
                    return;
                }
            }
            if (this.D2.getVisibility() == 0) {
                this.D2.setVisibility(8);
            }
            if (d2()) {
                return;
            }
            SeekBar seekBar = this.a2;
            if (seekBar != null) {
                seekBar.setProgress(this.W0.getStreamVolume(3));
            }
            c3();
            if (this.A2.getVisibility() == 0) {
                this.A2.startAnimation(this.B2);
                this.A2.setVisibility(8);
            } else if (this.b2.getVisibility() == 0) {
                n2();
            } else {
                T2();
                Z1(5000);
            }
        }
    }

    public void n2() {
        this.V0.p2();
        this.a3.removeMessages(1);
        if (HoneyPlayer.a4 || this.b2.getVisibility() != 0) {
            return;
        }
        this.b2.startAnimation(this.i2);
        if (this.m2.getVisibility() == 0) {
            this.m2.startAnimation(this.i2);
        }
        if (this.k2.getVisibility() == 0) {
            this.k2.startAnimation(this.i2);
        }
        if (this.r2.getVisibility() == 0) {
            this.r2.startAnimation(this.i2);
        }
        if (this.l2.getVisibility() == 0) {
            this.l2.startAnimation(this.i2);
        }
        if (this.n2.getVisibility() == 0) {
            this.n2.startAnimation(this.i2);
        }
        this.b2.setVisibility(8);
        if (this.m2.getVisibility() == 0) {
            this.m2.setVisibility(8);
        }
        if (this.k2.getVisibility() == 0) {
            this.k2.setVisibility(8);
        }
        if (this.r2.getVisibility() == 0) {
            this.r2.setVisibility(8);
        }
        if (this.l2.getVisibility() == 0) {
            this.l2.setVisibility(8);
        }
        if (this.n2.getVisibility() == 0) {
            this.n2.setVisibility(8);
        }
    }

    public void o2() {
        this.V0.p2();
        if (this.C2.getVisibility() == 0) {
            this.C2.startAnimation(this.F2);
            this.C2.setVisibility(8);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.Cl) {
            I2();
        } else if (id == a7.f.El) {
            J2();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 != 5) {
        }
        u2();
        return super.onKeyDown(i2, keyEvent);
    }

    public void p2() {
        NSTIJKPlayerEpisodes nSTIJKPlayerEpisodes = this.V0;
        if (nSTIJKPlayerEpisodes != null) {
            nSTIJKPlayerEpisodes.setSystemUiVisibility(1799);
        }
    }

    public void p3(boolean z2) {
        if (z2) {
            t3.setVisibility(0);
            View inflate = ((LayoutInflater) this.J0.getSystemService("layout_inflater")).inflate(a7.g.p2, findViewById(a7.f.ih));
            this.q3 = inflate;
            this.p3 = inflate.findViewById(a7.f.Yg);
        }
        new o1.a().c(a.a.BASIC);
        com.squareup.okhttp.OkHttpClient okHttpClient = new com.squareup.okhttp.OkHttpClient();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        okHttpClient.setConnectTimeout(60L, timeUnit);
        okHttpClient.setReadTimeout(60L, timeUnit);
        MediaType parse = MediaType.parse("application/json");
        Log.e("comingfileid", String.valueOf(this.B));
        try {
            Response execute = okHttpClient.newCall(new Request.Builder().url("https://vip-api.opensubtitles.com/api/v1/download").post(RequestBody.create(parse, "{\n  \"file_id\":" + this.B + "\n}")).addHeader("User-Agent", "IPTVSmartersPlayer").addHeader("Accept", "application/json").addHeader("Api-Key", "ZCyXegBRifdfqktSPAiyrtlpknf2RBrLsd").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJrVzBLUlE1S3FiT08wZXpQS0NOazBOY1dWU1BvcmlONiIsImV4cCI6MTcwMDkwMTcwN30.VPitYBEcXa-iFREzVDtyDxJZlmSjDKeh0iWIUltJtFM").build()).execute();
            if (execute.body() != null) {
                String string = execute.body().string();
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Log.e("vipserverrespnse", string);
                    try {
                        this.E = jSONObject.getString("link");
                        new Thread(new w7.g(this)).start();
                    } catch (Exception e2) {
                        if (this.G0 <= 5) {
                            B2();
                        } else if (jSONObject.getString("message") == null || jSONObject.getString("message").isEmpty()) {
                            this.p3.setText(String.valueOf(e2));
                        } else {
                            this.p3.setText(jSONObject.getString("message"));
                        }
                    }
                } catch (JSONException e3) {
                    if (this.G0 < 5) {
                        B2();
                    } else {
                        this.p3.setText(String.valueOf(e3));
                    }
                    e3.printStackTrace();
                }
            }
        } catch (IOException e4) {
            Log.e("TAG3:", String.valueOf(e4));
            if (this.G0 < 5) {
                B2();
            } else {
                this.p3.setText(String.valueOf(e4));
            }
            e4.printStackTrace();
        }
    }

    public void pause() {
        IMediaPlayer iMediaPlayer;
        if (u2() && (iMediaPlayer = x3) != null && iMediaPlayer.isPlaying()) {
            x3.pause();
            this.g0 = 4;
        }
        this.h0 = 4;
    }

    public void seekTo(int i2) {
        if (u2()) {
            this.R0 = System.currentTimeMillis();
            x3.seekTo(i2);
            i2 = 0;
        }
        this.t0 = i2;
    }

    public void setAdjustViewBounds(boolean z2) {
        if (this.I2 == z2) {
            return;
        }
        this.I2 = z2;
        if (z2) {
            setBackground((Drawable) null);
        } else {
            setBackgroundColor(-16777216);
        }
        requestLayout();
    }

    public void setCurrentPositionSeekbar(int i2) {
        this.C1 = i2;
    }

    public void setCurrentWindowIndex(int i2) {
        this.E0 = i2;
    }

    public void setHudView(TableLayout tableLayout) {
        this.O0 = new w7.c(getContext(), tableLayout);
    }

    public void setMediaController(w7.b bVar) {
        Y1();
    }

    public void setMovieListener(M m2) {
        this.S = m2;
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.o0 = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.r0 = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.s0 = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.p0 = onPreparedListener;
    }

    public void setProgress(boolean z2) {
        this.E1 = z2;
    }

    public void setRender(int i2) {
        SurfaceView surfaceView;
        if (i2 == 0) {
            surfaceView = null;
        } else if (i2 == 1) {
            surfaceView = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.b(getContext());
        } else {
            if (i2 != 2) {
                Log.e(this.T, String.format(Locale.getDefault(), "invalid render %d\n", new Object[]{Integer.valueOf(i2)}));
                return;
            }
            surfaceView = new com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.c(getContext());
            if (x3 != null) {
                surfaceView.getSurfaceHolder().b(x3);
                surfaceView.c(x3.getVideoWidth(), x3.getVideoHeight());
                surfaceView.a(x3.getVideoSarNum(), x3.getVideoSarDen());
                surfaceView.setAspectRatio(this.R2);
            }
        }
        setRenderView(surfaceView);
    }

    public void setRenderView(com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.a aVar) {
        int i2;
        int i3;
        if (this.g != null) {
            IMediaPlayer iMediaPlayer = x3;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.g.getView();
            this.g.b(this.h3);
            this.g = null;
            removeView(view);
        }
        if (aVar == null) {
            return;
        }
        this.g = aVar;
        SharedPreferences sharedPreferences = this.J0.getSharedPreferences("loginPrefs", 0);
        this.F = sharedPreferences;
        int i4 = sharedPreferences.getInt("aspect_ratio", 4);
        this.Q2 = i4;
        aVar.setAspectRatio(i4);
        int i5 = this.j0;
        if (i5 > 0 && (i3 = this.k0) > 0) {
            aVar.c(i5, i3);
        }
        int i6 = this.L0;
        if (i6 > 0 && (i2 = this.M0) > 0) {
            aVar.a(i6, i2);
        }
        View view2 = this.g.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.g.e(this.h3);
        this.g.setVideoRotation(this.n0);
    }

    public void setShowOrHideSubtitles(boolean z2) {
        this.i = z2;
    }

    public void setSpeed(float f2) {
        try {
            ((IjkMediaPlayer) x3).setSpeed(f2);
            this.V0.p2();
        } catch (Exception unused) {
        }
    }

    public void start() {
        if (u2()) {
            x3.start();
            this.g0 = 3;
        }
        this.h0 = 3;
    }

    public boolean t2() {
        return this.V2;
    }

    public final /* synthetic */ void v2() {
        u3 = y2(this.E);
        Y2();
    }

    public void x2() {
        IMediaPlayer.OnErrorListener onErrorListener;
        if (this.V == null || this.i0 == null) {
            return;
        }
        C2(false);
        try {
            ((AudioManager) this.J0.getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 1);
        } catch (Exception unused) {
        }
        try {
            x3 = f2(this.K0.x());
            getContext();
            x3.setOnPreparedListener(this.S0);
            x3.setOnVideoSizeChangedListener(this.N0);
            x3.setOnCompletionListener(this.e3);
            x3.setOnErrorListener(this.g3);
            x3.setOnInfoListener(this.f3);
            x3.setOnBufferingUpdateListener(this.M2);
            x3.setOnSeekCompleteListener(this.N2);
            x3.setOnTimedTextListener(this.P2);
            this.q0 = 0;
            String scheme = this.V.getScheme();
            if (Build.VERSION.SDK_INT >= 23 && this.K0.F() && (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                x3.setDataSource(new w7.a(new File(this.E)));
            } else {
                x3.setDataSource(this.J0, this.V, this.e0);
            }
            b2(x3, this.i0);
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
            x3.setAudioStreamType(3);
            x3.setScreenOnWhilePlaying(true);
            this.P0 = System.currentTimeMillis();
            x3.prepareAsync();
            this.a1 = this.U0.getResources().getDisplayMetrics().widthPixels;
            AudioManager audioManager = (AudioManager) this.U0.getSystemService("audio");
            this.W0 = audioManager;
            this.X0 = audioManager.getStreamMaxVolume(3);
            int streamVolume = this.W0.getStreamVolume(3);
            this.a2.setMax(this.W0.getStreamMaxVolume(3));
            this.a2.setProgress(streamVolume);
            this.Z0 = new GestureDetector(this.U0, new O());
            this.g2 = false;
            n3();
            SeekBar seekBar = this.k1;
            if (seekBar != null) {
                seekBar.setMax(1000);
                this.k1.setKeyProgressIncrement(5);
                this.k1.setOnSeekBarChangeListener(this.Z2);
            }
            this.I = new StringBuilder();
            this.J = new Formatter(this.I, Locale.getDefault());
            w7.c cVar = this.O0;
            if (cVar != null) {
                cVar.l(x3);
            }
            this.g0 = 1;
        } catch (NullPointerException e2) {
            Log.w(this.T, "Unable to open content: " + this.V, e2);
            this.g0 = -1;
            this.h0 = -1;
            onErrorListener = this.g3;
            onErrorListener.onError(x3, 1, 0);
        } catch (IllegalArgumentException e3) {
            Log.w(this.T, "Unable to open content: " + this.V, e3);
            this.g0 = -1;
            this.h0 = -1;
            onErrorListener = this.g3;
            onErrorListener.onError(x3, 1, 0);
        } catch (IOException e4) {
            Log.w(this.T, "Unable to open content: " + this.V, e4);
            this.g0 = -1;
            this.h0 = -1;
            onErrorListener = this.g3;
            onErrorListener.onError(x3, 1, 0);
        } catch (Exception e5) {
            Log.w(this.T, "Unable to open content: " + this.V, e5);
            this.g0 = -1;
            this.h0 = -1;
            onErrorListener = this.g3;
            onErrorListener.onError(x3, 1, 0);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0069, code lost:
    
        com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.t3.setVisibility(8);
        r1.add(new w7.j(r7, r8, r10, r5.toString()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List y2(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r0 = ""
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = 8
            java.net.URL r4 = new java.net.URL     // Catch: java.io.IOException -> Lc8
            r4.<init>(r15)     // Catch: java.io.IOException -> Lc8
            java.net.URLConnection r15 = r4.openConnection()     // Catch: java.io.IOException -> Lc8
            java.net.HttpURLConnection r15 = (java.net.HttpURLConnection) r15     // Catch: java.io.IOException -> Lc8
            r15.connect()     // Catch: java.io.IOException -> Lc8
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.io.IOException -> Lc8
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.io.IOException -> Lc8
            java.io.InputStream r6 = r15.getInputStream()     // Catch: java.io.IOException -> Lc8
            r5.<init>(r6)     // Catch: java.io.IOException -> Lc8
            r4.<init>(r5)     // Catch: java.io.IOException -> Lc8
        L26:
            java.lang.String r5 = r4.readLine()     // Catch: java.io.IOException -> Lc8
            if (r5 == 0) goto Lca
            java.lang.String r6 = "\\uFEFF"
            java.lang.String r5 = r5.replaceAll(r6, r0)     // Catch: java.lang.Exception -> L67
            int r7 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Exception -> L67
            java.lang.String r5 = r4.readLine()     // Catch: java.lang.Exception -> L67
            java.lang.String r6 = " --> "
            java.lang.String[] r5 = r5.split(r6)     // Catch: java.lang.Exception -> L67
            r6 = r5[r2]     // Catch: java.lang.Exception -> L67
            long r8 = z2(r6)     // Catch: java.lang.Exception -> L67
            r6 = 1
            r5 = r5[r6]     // Catch: java.lang.Exception -> L67
            long r10 = z2(r5)     // Catch: java.lang.Exception -> L67
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L67
            r5.<init>()     // Catch: java.lang.Exception -> L67
        L52:
            java.lang.String r6 = r4.readLine()     // Catch: java.lang.Exception -> L67
            if (r6 == 0) goto L69
            boolean r12 = r6.isEmpty()     // Catch: java.lang.Exception -> L67
            if (r12 != 0) goto L69
            r5.append(r6)     // Catch: java.lang.Exception -> L67
            java.lang.String r6 = "\n"
            r5.append(r6)     // Catch: java.lang.Exception -> L67
            goto L52
        L67:
            r5 = move-exception
            goto La2
        L69:
            android.widget.ProgressBar r6 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.t3     // Catch: java.lang.Exception -> L7c
            r6.setVisibility(r3)     // Catch: java.lang.Exception -> L7c
            w7.j r13 = new w7.j     // Catch: java.lang.Exception -> L7c
            java.lang.String r12 = r5.toString()     // Catch: java.lang.Exception -> L7c
            r6 = r13
            r6.<init>(r7, r8, r10, r12)     // Catch: java.lang.Exception -> L7c
            r1.add(r13)     // Catch: java.lang.Exception -> L7c
            goto L26
        L7c:
            r5 = move-exception
            android.content.Context r6 = r14.getContext()     // Catch: java.lang.Exception -> L67
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L67
            r7.<init>()     // Catch: java.lang.Exception -> L67
            r7.append(r0)     // Catch: java.lang.Exception -> L67
            r7.append(r5)     // Catch: java.lang.Exception -> L67
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Exception -> L67
            android.widget.Toast r5 = android.widget.Toast.makeText(r6, r5, r2)     // Catch: java.lang.Exception -> L67
            r5.show()     // Catch: java.lang.Exception -> L67
            android.widget.ProgressBar r5 = r14.V1     // Catch: java.lang.Exception -> L67
            r5.setVisibility(r3)     // Catch: java.lang.Exception -> L67
            android.widget.ProgressBar r5 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.t3     // Catch: java.lang.Exception -> L67
            r5.setVisibility(r3)     // Catch: java.lang.Exception -> L67
            goto L26
        La2:
            android.widget.ProgressBar r6 = r14.V1     // Catch: java.io.IOException -> Lc8
            r6.setVisibility(r3)     // Catch: java.io.IOException -> Lc8
            android.widget.ProgressBar r6 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.t3     // Catch: java.io.IOException -> Lc8
            r6.setVisibility(r3)     // Catch: java.io.IOException -> Lc8
            android.content.Context r6 = r14.getContext()     // Catch: java.io.IOException -> Lc8
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lc8
            r7.<init>()     // Catch: java.io.IOException -> Lc8
            r7.append(r0)     // Catch: java.io.IOException -> Lc8
            r7.append(r5)     // Catch: java.io.IOException -> Lc8
            java.lang.String r5 = r7.toString()     // Catch: java.io.IOException -> Lc8
            android.widget.Toast r5 = android.widget.Toast.makeText(r6, r5, r2)     // Catch: java.io.IOException -> Lc8
            r5.show()     // Catch: java.io.IOException -> Lc8
            goto L26
        Lc8:
            r15 = move-exception
            goto Ld1
        Lca:
            r4.close()     // Catch: java.io.IOException -> Lc8
            r15.disconnect()     // Catch: java.io.IOException -> Lc8
            goto Lf8
        Ld1:
            android.widget.ProgressBar r4 = com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.t3
            r4.setVisibility(r3)
            android.widget.ProgressBar r4 = r14.V1
            r4.setVisibility(r3)
            android.content.Context r3 = r14.getContext()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r15)
            java.lang.String r0 = r4.toString()
            android.widget.Toast r0 = android.widget.Toast.makeText(r3, r0, r2)
            r0.show()
            r15.printStackTrace()
        Lf8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEpisodes.y2(java.lang.String):java.util.List");
    }
}
