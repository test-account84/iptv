package com.nst.iptvsmarterstvbox.view.activity;

import Q0.m;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.google.gson.JsonElement;
import com.nst.iptvsmarterstvbox.miscelleneious.ApiWorkerCombinedRequest;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.DownloadedDataModel;
import com.nst.iptvsmarterstvbox.model.EpisodesUsingSinglton;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.callback.BillingAddOrderCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingCheckGPACallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingGetDevicesCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingIsPurchasedCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingLoginClientCallback;
import com.nst.iptvsmarterstvbox.model.callback.BillingUpdateDevicesCallback;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.callback.LoginCallback;
import com.nst.iptvsmarterstvbox.model.callback.RegisterClientCallback;
import com.nst.iptvsmarterstvbox.model.callback.SeriesDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.DownloadedDBHandler;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.adapterpushnotification.DashboardSBPAnnouncementAdapter;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.AdsLastUpdateResponseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.readAnnouncementFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationinterface.FirebaseInterface;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter.FirebasePresenter;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.DashBoardListssingleton;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import com.nst.iptvsmarterstvbox.view.services.VideoDownloadService;
import de.blinkt.openvpn.LaunchVPN;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.OpenVPNService;
import de.blinkt.openvpn.core.h;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import m7.w;
import n7.c;
import p7.g0;
import p7.h0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NewDashboardActivity extends androidx.appcompat.app.b implements View.OnClickListener, z7.f, z7.i, z7.d, FirebaseInterface, c.b {
    public static PopupWindow Y1;
    public TextView A;
    public ImageView A0;
    public LinearLayout A1;
    public TextView B;
    public LinearLayout B1;
    public TextView C;
    public SharedPreferences C0;
    public LinearLayout C1;
    public ImageView D;
    public SharedPreferences.Editor D0;
    public LinearLayout D1;
    public ImageView E;
    public LiveStreamDBHandler E0;
    public LinearLayout E1;
    public ImageView F;
    public SharedPreferences F0;
    public LinearLayout F1;
    public FrameLayout G;
    public SharedPreferences G0;
    public ConstraintLayout G1;
    public ImageView H;
    public FirebasePresenter H1;
    public TextView I;
    public String I1;
    public ImageView J;
    public TextView K;
    public Handler K1;
    public LinearLayout L;
    public SharedPreferences L0;
    public Handler L1;
    public ImageView M;
    public long M0;
    public Handler M1;
    public ProgressBar N;
    public Button N0;
    public Runnable N1;
    public ImageView O;
    public Button O0;
    public Runnable O1;
    public ProgressBar P;
    public Runnable P1;
    public TextView Q;
    public DatabaseHandler Q0;
    public LinearLayout R;
    public String R0;
    public LinearLayout S;
    public MultiUserDBHandler S0;
    public TextView T;
    public n7.d T0;
    public ProgressBar U;
    public ArrayList U0;
    public DashboardSBPAnnouncementAdapter U1;
    public ImageView V;
    public J7.a V0;
    public long V1;
    public ProgressBar W;
    public u7.a W0;
    public TextView X;
    public n7.f X0;
    public LinearLayout Y;
    public String Y0;
    public LinearLayout Z;
    public String Z0;
    public DownloadedDBHandler d;
    public ArrayList e;
    public TextView e0;
    public ProgressDialog e1;
    public ImageView f;
    public ProgressBar f0;
    public TextView g;
    public ImageView g0;
    public String g1;
    public LinearLayout h;
    public ProgressBar h0;
    public String h1;
    public LinearLayout i;
    public TextView i0;
    public int i1;
    public LinearLayout j;
    public LinearLayout j0;
    public n7.b j1;
    public LinearLayout k;
    public LinearLayout k0;
    public ImageView l;
    public TextView l0;
    public LinearLayout m;
    public LinearLayout m0;
    public LinearLayout n;
    public ImageView n0;
    public LinearLayout o;
    public ProgressBar o0;
    public RecentWatchDBHandler o1;
    public LinearLayout p;
    public ProgressBar p0;
    public SeriesRecentWatchDatabase p1;
    public LinearLayout q;
    public ProgressBar q0;
    public TextView r;
    public TextView r0;
    public TextView s;
    public LinearLayout s0;
    public TextView t;
    public ImageView t0;
    public TextView u;
    public TextView u0;
    public LinearLayout u1;
    public TextView v;
    public ImageView v0;
    public ConstraintLayout v1;
    public TextView w;
    public TextView w0;
    public Button w1;
    public TextView x;
    public LinearLayout x0;
    public Button x1;
    public TextView y;
    public LinearLayout y0;
    public TextView y1;
    public TextView z;
    public TextView z0;
    public ImageView z1;
    public Context B0 = this;
    public String H0 = "";
    public String I0 = "";
    public String J0 = "";
    public DatabaseUpdatedStatusDBModel K0 = new DatabaseUpdatedStatusDBModel();
    public String P0 = "";
    public boolean a1 = true;
    public boolean b1 = false;
    public boolean c1 = false;
    public boolean d1 = false;
    public long f1 = 0;
    public Thread k1 = null;
    public boolean l1 = false;
    public boolean m1 = false;
    public boolean n1 = false;
    public String q1 = "";
    public String r1 = "";
    public String s1 = "";
    public int t1 = 0;
    public List J1 = new ArrayList();
    public long Q1 = 0;
    public boolean R1 = false;
    public String S1 = "";
    public int T1 = 0;
    public long W1 = 5000;
    public String X1 = "";

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            NewDashboardActivity.W1().dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            NewDashboardActivity.this.finish();
            m7.w.n0(NewDashboardActivity.e2(NewDashboardActivity.this));
            NewDashboardActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ List a;

        public c(List list) {
            this.a = list;
        }

        public void run() {
            int size = this.a.size();
            int i = m7.a.l1;
            if (size > i) {
                NewDashboardActivity.this.z0.setText((CharSequence) this.a.get(i));
                NewDashboardActivity.this.V1 = NewDashboardActivity.Y1(r0, (String) this.a.get(m7.a.l1));
                int i2 = m7.a.l1 + 1;
                m7.a.l1 = i2;
                if (i2 == this.a.size()) {
                    m7.a.l1 = 0;
                }
            } else {
                m7.a.l1 = 0;
                NewDashboardActivity.this.z0.setText((CharSequence) this.a.get(0));
                NewDashboardActivity.this.V1 = NewDashboardActivity.Y1(r0, (String) this.a.get(m7.a.l1));
            }
            NewDashboardActivity newDashboardActivity = NewDashboardActivity.this;
            newDashboardActivity.L1.postDelayed(newDashboardActivity.P1, newDashboardActivity.V1);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ List a;

        public d(List list) {
            this.a = list;
        }

        public void run() {
            if (this.a.size() > m7.a.m1) {
                O1.g.u(NewDashboardActivity.e2(NewDashboardActivity.this)).q((String) this.a.get(m7.a.m1)).l(NewDashboardActivity.this.A0);
                int i = m7.a.m1 + 1;
                m7.a.m1 = i;
                if (i == this.a.size()) {
                    m7.a.m1 = 0;
                }
            } else {
                m7.a.m1 = 0;
                O1.g.u(NewDashboardActivity.e2(NewDashboardActivity.this)).q((String) this.a.get(m7.a.m1)).l(NewDashboardActivity.this.A0);
            }
            NewDashboardActivity newDashboardActivity = NewDashboardActivity.this;
            newDashboardActivity.M1.postDelayed(newDashboardActivity.O1, 10000L);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ List a;

        public e(List list) {
            this.a = list;
        }

        public void run() {
            if (Listsingleton.b().c() == null || Listsingleton.b().c().size() <= 0) {
                NewDashboardActivity.this.w0.setText("");
                NewDashboardActivity.this.w0.setVisibility(8);
                return;
            }
            if (this.a.size() > m7.a.n1) {
                NewDashboardActivity.this.w0.setText(MyApplication.p().o((String) this.a.get(m7.a.n1)));
                NewDashboardActivity.this.w0.setVisibility(0);
                NewDashboardActivity.this.W1 = NewDashboardActivity.Y1(r0, (String) this.a.get(m7.a.n1));
                if (m7.a.n1 == this.a.size()) {
                    m7.a.n1 = 0;
                } else {
                    m7.a.n1++;
                }
            } else {
                m7.a.n1 = 0;
                NewDashboardActivity.this.w0.setText(MyApplication.p().o((String) this.a.get(m7.a.n1)));
                NewDashboardActivity.this.w0.setVisibility(0);
                NewDashboardActivity.this.W1 = NewDashboardActivity.Y1(r0, (String) this.a.get(m7.a.n1));
            }
            NewDashboardActivity newDashboardActivity = NewDashboardActivity.this;
            newDashboardActivity.K1.postDelayed(newDashboardActivity.N1, newDashboardActivity.W1);
        }
    }

    public class f implements OnBackInvokedCallback {
        public f() {
        }

        public void onBackInvoked() {
            if (Build.VERSION.SDK_INT >= 34) {
                if (NewDashboardActivity.x1(NewDashboardActivity.this) + 2000 > System.currentTimeMillis()) {
                    NewDashboardActivity.this.finishAffinity();
                    NewDashboardActivity.this.finish();
                } else {
                    try {
                        Toast.makeText(NewDashboardActivity.this.getBaseContext(), NewDashboardActivity.this.getResources().getString(a7.j.F5), 0).show();
                    } catch (Exception unused) {
                    }
                }
                NewDashboardActivity.y1(NewDashboardActivity.this, System.currentTimeMillis());
            }
        }
    }

    public class g extends Dialog implements View.OnClickListener {
        public Activity a;
        public Context c;
        public LiveStreamDBHandler d;
        public TextView e;
        public TextView f;
        public RelativeLayout g;
        public LinearLayout h;
        public LinearLayout i;
        public LinearLayout j;
        public LinearLayout k;
        public LinearLayout l;
        public LinearLayout m;
        public ShimmerRecyclerView n;
        public Animation o;
        public Animation p;
        public ImageView q;

        public class a implements View.OnFocusChangeListener {
            public View a;

            public a(View view) {
                this.a = view;
            }

            public final void a(float f) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
                ofFloat.setDuration(300L);
                ofFloat.start();
            }

            public final void b(float f) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
                ofFloat.setDuration(300L);
                ofFloat.start();
            }

            public void onFocusChange(View view, boolean z) {
                LinearLayout f;
                int i;
                TextView b;
                int i2;
                float f2 = z ? 1.05f : 1.0f;
                View view2 = this.a;
                if (view2 != null && view2.getTag() != null && this.a.getTag().equals("1")) {
                    f2 = z ? 1.02f : 1.0f;
                }
                a(f2);
                b(f2);
                if (z) {
                    View view3 = this.a;
                    if (view3 != null && view3.getTag() != null && this.a.getTag().equals("1")) {
                        g.a(g.this).setBackgroundResource(a7.e.J);
                        b = g.b(g.this);
                        i2 = -16777216;
                        b.setTextColor(i2);
                        return;
                    }
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("2")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("3")) {
                            View view6 = this.a;
                            if (view6 == null || view6.getTag() == null || !this.a.getTag().equals("4")) {
                                View view7 = this.a;
                                if (view7 == null || view7.getTag() == null || !this.a.getTag().equals("5")) {
                                    return;
                                } else {
                                    f = g.f(g.this);
                                }
                            } else {
                                f = g.e(g.this);
                            }
                        } else {
                            f = g.d(g.this);
                        }
                    } else {
                        f = g.c(g.this);
                    }
                    i = a7.e.J;
                    f.setBackgroundResource(i);
                }
                View view8 = this.a;
                if (view8 != null && view8.getTag() != null && this.a.getTag().equals("1")) {
                    g.a(g.this).setBackgroundResource(a7.e.I);
                    b = g.b(g.this);
                    i2 = -1;
                    b.setTextColor(i2);
                    return;
                }
                View view9 = this.a;
                if (view9 == null || view9.getTag() == null || !this.a.getTag().equals("2")) {
                    View view10 = this.a;
                    if (view10 == null || view10.getTag() == null || !this.a.getTag().equals("3")) {
                        View view11 = this.a;
                        if (view11 == null || view11.getTag() == null || !this.a.getTag().equals("4")) {
                            View view12 = this.a;
                            if (view12 == null || view12.getTag() == null || !this.a.getTag().equals("5")) {
                                return;
                            } else {
                                f = g.f(g.this);
                            }
                        } else {
                            f = g.e(g.this);
                        }
                    } else {
                        f = g.d(g.this);
                    }
                } else {
                    f = g.c(g.this);
                }
                i = a7.e.I;
                f.setBackgroundResource(i);
            }
        }

        public g(Activity activity, Context context, LiveStreamDBHandler liveStreamDBHandler) {
            super(activity);
            this.a = activity;
            this.c = context;
            this.d = liveStreamDBHandler;
        }

        public static /* synthetic */ LinearLayout a(g gVar) {
            return gVar.i;
        }

        public static /* synthetic */ TextView b(g gVar) {
            return gVar.e;
        }

        public static /* synthetic */ LinearLayout c(g gVar) {
            return gVar.j;
        }

        public static /* synthetic */ LinearLayout d(g gVar) {
            return gVar.k;
        }

        public static /* synthetic */ LinearLayout e(g gVar) {
            return gVar.l;
        }

        public static /* synthetic */ LinearLayout f(g gVar) {
            return gVar.m;
        }

        public void onClick(View view) {
            Intent intent;
            Intent intent2;
            NewDashboardActivity newDashboardActivity;
            Intent intent3;
            if (view.getId() == a7.f.O6) {
                if (m7.a.o.booleanValue()) {
                    newDashboardActivity = NewDashboardActivity.this;
                    intent3 = new Intent(this.c, AccountInfoActivity.class);
                } else if (!m7.a.s.booleanValue()) {
                    m7.w.n0(this.c);
                    NewDashboardActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
                } else {
                    newDashboardActivity = NewDashboardActivity.this;
                    intent3 = new Intent(this.c, AccountInfoActivity.class);
                }
            } else if (view.getId() == a7.f.Z9) {
                m7.a.X = Boolean.TRUE;
                newDashboardActivity = NewDashboardActivity.this;
                intent3 = new Intent(this.c, SettingsActivity.class);
            } else {
                if (view.getId() != a7.f.N6) {
                    if (view.getId() == a7.f.oa) {
                        NewDashboardActivity.V1(NewDashboardActivity.this);
                        return;
                    }
                    if (view.getId() == a7.f.T6) {
                        if (m7.a.o.booleanValue()) {
                            Boolean bool = Boolean.TRUE;
                            m7.a.b0 = bool;
                            m7.w.n0(this.c);
                            NewDashboardActivity.this.startActivity(new Intent(this.c, RoutingActivity.class));
                            NewDashboardActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
                            m7.a.c0 = bool;
                        } else {
                            if (m7.a.p.booleanValue() && m7.a.t.booleanValue() && m7.a.r.booleanValue()) {
                                m7.a.b0 = Boolean.TRUE;
                                m7.w.n0(this.c);
                                intent = new Intent(this.c, RoutingActivity.class);
                            } else {
                                if (m7.a.p.booleanValue() && m7.a.q.booleanValue()) {
                                    m7.a.b0 = Boolean.TRUE;
                                    m7.w.n0(this.c);
                                    intent = new Intent(this.c, RoutingActivity.class);
                                }
                                if (m7.a.q.booleanValue() && m7.a.r.booleanValue()) {
                                    m7.a.b0 = Boolean.TRUE;
                                    m7.w.n0(this.c);
                                    this.c.startActivity(new Intent(this.c, RoutingActivity.class));
                                    NewDashboardActivity.this.finish();
                                }
                                if (m7.a.p.booleanValue() && !m7.a.r.booleanValue()) {
                                    if (m7.a.p.booleanValue()) {
                                        intent2 = new Intent(this.c, LoginActivityOneStream.class);
                                    } else if (m7.a.q.booleanValue()) {
                                        intent2 = new Intent(this.c, LoginActivity.class);
                                    } else if (!m7.a.r.booleanValue()) {
                                        return;
                                    } else {
                                        intent2 = new Intent(this.c, LoginM3uActivity.class);
                                    }
                                    this.c.startActivity(intent2);
                                    return;
                                }
                                m7.a.b0 = Boolean.TRUE;
                                m7.w.n0(this.c);
                                this.c.startActivity(new Intent(this.c, RoutingActivity.class));
                            }
                            this.c.startActivity(intent);
                            NewDashboardActivity.this.finish();
                            if (m7.a.q.booleanValue()) {
                                m7.a.b0 = Boolean.TRUE;
                                m7.w.n0(this.c);
                                this.c.startActivity(new Intent(this.c, RoutingActivity.class));
                                NewDashboardActivity.this.finish();
                            }
                            if (m7.a.p.booleanValue()) {
                            }
                            m7.a.b0 = Boolean.TRUE;
                            m7.w.n0(this.c);
                            this.c.startActivity(new Intent(this.c, RoutingActivity.class));
                        }
                        NewDashboardActivity.this.finish();
                        return;
                    }
                    return;
                }
                newDashboardActivity = NewDashboardActivity.this;
                intent3 = new Intent(this.c, AccountInfoActivity.class);
            }
            newDashboardActivity.startActivity(intent3);
            NewDashboardActivity.this.overridePendingTransition(a7.b.f, a7.b.d);
        }

        public void onCreate(Bundle bundle) {
            LinearLayout linearLayout;
            Animation animation;
            Animation animation2;
            Animation animation3;
            Animation animation4;
            Animation animation5;
            super.onCreate(bundle);
            setContentView(NewDashboardActivity.z1(NewDashboardActivity.this).A().equals(m7.a.K0) ? a7.g.K1 : a7.g.J1);
            this.g = findViewById(a7.f.P6);
            this.n = findViewById(a7.f.fg);
            this.h = findViewById(a7.f.B6);
            this.i = findViewById(a7.f.O6);
            this.j = findViewById(a7.f.Z9);
            this.k = findViewById(a7.f.N6);
            this.l = findViewById(a7.f.oa);
            this.m = findViewById(a7.f.T6);
            this.f = findViewById(a7.f.Pb);
            this.q = findViewById(a7.f.Og);
            try {
                NewDashboardActivity.S1(NewDashboardActivity.this, this.c.getResources().getIdentifier("@drawable/box_" + (NewDashboardActivity.this.p2() + 1), (String) null, this.c.getPackageName()));
                this.q.setImageDrawable(E.b.getDrawable(this.c, NewDashboardActivity.R1(NewDashboardActivity.this)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.n.setHasFixedSize(true);
            this.n.setLayoutManager(new LinearLayoutManager(this.c));
            this.n.H1();
            Animation loadAnimation = AnimationUtils.loadAnimation(this.c, a7.b.a);
            this.o = loadAnimation;
            loadAnimation.setInterpolator(new LinearInterpolator());
            this.o.setRepeatCount(-1);
            this.o.setDuration(500L);
            this.p = AnimationUtils.loadAnimation(this.c, a7.b.f);
            LinearLayout linearLayout2 = this.j;
            if (linearLayout2 != null && (animation5 = this.o) != null) {
                linearLayout2.startAnimation(animation5);
            }
            LinearLayout linearLayout3 = this.k;
            if (linearLayout3 != null && (animation4 = this.o) != null) {
                linearLayout3.startAnimation(animation4);
            }
            LinearLayout linearLayout4 = this.l;
            if (linearLayout4 != null && (animation3 = this.o) != null) {
                linearLayout4.startAnimation(animation3);
            }
            LinearLayout linearLayout5 = this.m;
            if (linearLayout5 != null && (animation2 = this.o) != null) {
                linearLayout5.startAnimation(animation2);
            }
            ShimmerRecyclerView shimmerRecyclerView = this.n;
            if (shimmerRecyclerView != null) {
                shimmerRecyclerView.E1();
            }
            ShimmerRecyclerView shimmerRecyclerView2 = this.n;
            if (shimmerRecyclerView2 != null && (animation = this.p) != null) {
                shimmerRecyclerView2.startAnimation(animation);
            }
            if (m7.a.V0.booleanValue()) {
                List a2 = AnnouncementsSBPSingleton.b().a();
                if (a2 == null || a2.size() <= 0) {
                    this.n.setVisibility(8);
                    TextView textView = this.f;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                } else {
                    this.n.setHasFixedSize(true);
                    NewDashboardActivity newDashboardActivity = NewDashboardActivity.this;
                    NewDashboardActivity.U1(newDashboardActivity, new DashboardSBPAnnouncementAdapter(a2, newDashboardActivity));
                    this.n.setAdapter(NewDashboardActivity.T1(NewDashboardActivity.this));
                }
            } else {
                this.f.setVisibility(8);
            }
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.e = findViewById(a7.f.sh);
            if (m7.a.s.booleanValue()) {
                this.i.setVisibility(0);
                this.g.setVisibility(8);
                linearLayout = this.h;
            } else {
                this.h.setVisibility(8);
                this.i.setVisibility(8);
                linearLayout = this.g;
            }
            linearLayout.setVisibility(0);
            this.g.requestFocus();
            this.e.setText(this.c.getSharedPreferences("loginprefsmultiuser", 0).getString("name", ""));
            LinearLayout linearLayout6 = this.i;
            linearLayout6.setOnFocusChangeListener(new a(linearLayout6));
            LinearLayout linearLayout7 = this.j;
            linearLayout7.setOnFocusChangeListener(new a(linearLayout7));
            LinearLayout linearLayout8 = this.k;
            linearLayout8.setOnFocusChangeListener(new a(linearLayout8));
            LinearLayout linearLayout9 = this.l;
            linearLayout9.setOnFocusChangeListener(new a(linearLayout9));
            LinearLayout linearLayout10 = this.m;
            linearLayout10.setOnFocusChangeListener(new a(linearLayout10));
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ImageView imageView;
            if (i != 21) {
                return super.onKeyDown(i, keyEvent);
            }
            if (getCurrentFocus() == null || getCurrentFocus().getTag() == null) {
                return false;
            }
            if (SharepreferenceDBHandler.getSelectedLanguage(this.c).equalsIgnoreCase("Arabic")) {
                if (getCurrentFocus().getTag().equals("3")) {
                    dismiss();
                    if (NewDashboardActivity.this.D.getVisibility() != 0) {
                        if (NewDashboardActivity.this.j.getVisibility() != 0) {
                            if (NewDashboardActivity.this.i.getVisibility() != 0) {
                                if (NewDashboardActivity.this.h.getVisibility() != 0) {
                                    return false;
                                }
                                imageView = NewDashboardActivity.this.h;
                            }
                            imageView = NewDashboardActivity.this.i;
                        }
                        imageView = NewDashboardActivity.this.j;
                    }
                    imageView = NewDashboardActivity.this.D;
                } else {
                    if (!getCurrentFocus().getTag().equals("5")) {
                        return false;
                    }
                    dismiss();
                    if (NewDashboardActivity.this.j.getVisibility() != 0) {
                        if (NewDashboardActivity.this.i.getVisibility() != 0) {
                            if (NewDashboardActivity.this.h.getVisibility() != 0) {
                                return false;
                            }
                            imageView = NewDashboardActivity.this.h;
                        }
                        imageView = NewDashboardActivity.this.i;
                    }
                    imageView = NewDashboardActivity.this.j;
                }
            } else if (getCurrentFocus().getTag().equals("1")) {
                dismiss();
                if (NewDashboardActivity.this.D.getVisibility() != 0) {
                    if (NewDashboardActivity.this.j.getVisibility() != 0) {
                        if (NewDashboardActivity.this.i.getVisibility() != 0) {
                            if (NewDashboardActivity.this.h.getVisibility() != 0) {
                                return false;
                            }
                            imageView = NewDashboardActivity.this.h;
                        }
                        imageView = NewDashboardActivity.this.i;
                    }
                    imageView = NewDashboardActivity.this.j;
                }
                imageView = NewDashboardActivity.this.D;
            } else {
                if (!getCurrentFocus().getTag().equals("2") && !getCurrentFocus().getTag().equals("4") && !getCurrentFocus().getTag().equals("10")) {
                    return false;
                }
                dismiss();
                if (NewDashboardActivity.this.j.getVisibility() != 0) {
                    if (NewDashboardActivity.this.i.getVisibility() != 0) {
                        if (NewDashboardActivity.this.h.getVisibility() != 0) {
                            return false;
                        }
                        imageView = NewDashboardActivity.this.h;
                    }
                    imageView = NewDashboardActivity.this.i;
                }
                imageView = NewDashboardActivity.this.j;
            }
            imageView.requestFocus();
            return false;
        }
    }

    public class h extends AsyncTask {
        public final /* synthetic */ List a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NewDashboardActivity.A1(NewDashboardActivity.this).c(NewDashboardActivity.f2(NewDashboardActivity.this), NewDashboardActivity.g2(NewDashboardActivity.this));
            }
        }

        public h(Context context, List list) {
            this.a = list;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            if (NewDashboardActivity.d2(NewDashboardActivity.this) != null) {
                NewDashboardActivity.d2(NewDashboardActivity.this).makeEmptyLiveCategory();
            }
            publishProgress(new Integer[]{0});
            return NewDashboardActivity.d2(NewDashboardActivity.this) != null ? Boolean.valueOf(NewDashboardActivity.d2(NewDashboardActivity.this).addLiveCategories(this.a)) : Boolean.FALSE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (NewDashboardActivity.e2(NewDashboardActivity.this) == null || !bool.booleanValue()) {
                NewDashboardActivity.G1(NewDashboardActivity.this);
                return;
            }
            if (NewDashboardActivity.f2(NewDashboardActivity.this) == null || NewDashboardActivity.f2(NewDashboardActivity.this).isEmpty() || NewDashboardActivity.g2(NewDashboardActivity.this) == null || NewDashboardActivity.g2(NewDashboardActivity.this).isEmpty()) {
                return;
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(NewDashboardActivity.this.N, "progress", new int[]{100, 50});
            ofInt.setDuration(500L);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.start();
            new Handler().postDelayed(new a(), 500L);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onPreExecute() {
        }
    }

    public class i extends AsyncTask {
        public final /* synthetic */ List a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                if (NewDashboardActivity.this.R.isFocused()) {
                    NewDashboardActivity.this.h.requestFocus();
                }
                NewDashboardActivity.this.R.setVisibility(8);
                NewDashboardActivity.this.N.setVisibility(8);
                NewDashboardActivity.this.o0.setVisibility(8);
                NewDashboardActivity.this.p0.setVisibility(8);
                NewDashboardActivity.this.q0.setVisibility(8);
                NewDashboardActivity.this.S.setVisibility(0);
                NewDashboardActivity.this.T.setText(NewDashboardActivity.e2(NewDashboardActivity.this).getResources().getString(a7.j.S2) + " " + m7.w.R0(1000L));
                NewDashboardActivity.F1(NewDashboardActivity.this);
                if (NewDashboardActivity.I1(NewDashboardActivity.this)) {
                    NewDashboardActivity.J1(NewDashboardActivity.this, false);
                    NewDashboardActivity newDashboardActivity = NewDashboardActivity.this;
                    NewDashboardActivity.K1(newDashboardActivity, NewDashboardActivity.e2(newDashboardActivity).getResources().getString(a7.j.n8));
                } else if (NewDashboardActivity.L1(NewDashboardActivity.this)) {
                    NewDashboardActivity.M1(NewDashboardActivity.this, false);
                    NewDashboardActivity newDashboardActivity2 = NewDashboardActivity.this;
                    NewDashboardActivity.N1(newDashboardActivity2, NewDashboardActivity.e2(newDashboardActivity2).getResources().getString(a7.j.n8));
                }
            }
        }

        public i(Context context, List list) {
            this.a = list;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            ArrayList allFavouritesStreamIDs;
            if (NewDashboardActivity.d2(NewDashboardActivity.this) != null) {
                NewDashboardActivity.d2(NewDashboardActivity.this).makeEmptyLiveStreams();
            }
            publishProgress(new Integer[]{0});
            if (NewDashboardActivity.d2(NewDashboardActivity.this) == null) {
                return Boolean.FALSE;
            }
            try {
                if (NewDashboardActivity.d2(NewDashboardActivity.this).addAllAvailableChannel(this.a)) {
                    ArrayList arrayList = new ArrayList();
                    if (NewDashboardActivity.C1(NewDashboardActivity.this) != null && (allFavouritesStreamIDs = NewDashboardActivity.C1(NewDashboardActivity.this).getAllFavouritesStreamIDs("live")) != null && allFavouritesStreamIDs.size() > 0) {
                        ArrayList allLiveMoviesStreamIDs = NewDashboardActivity.d2(NewDashboardActivity.this).getAllLiveMoviesStreamIDs("live");
                        for (int i = 0; i < allFavouritesStreamIDs.size(); i++) {
                            int streamID = ((FavouriteDBModel) allFavouritesStreamIDs.get(i)).getStreamID();
                            if (allLiveMoviesStreamIDs != null && allLiveMoviesStreamIDs.size() > 0) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= allLiveMoviesStreamIDs.size()) {
                                        arrayList.add(String.valueOf(streamID));
                                        break;
                                    }
                                    if (((LiveStreamsDBModel) allLiveMoviesStreamIDs.get(i2)).getStreamId().equals(String.valueOf(streamID))) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                    NewDashboardActivity.d2(NewDashboardActivity.this).deleteChannelsHistoryDuplicate();
                    if (arrayList.size() > 0 && NewDashboardActivity.C1(NewDashboardActivity.this) != null) {
                        NewDashboardActivity.C1(NewDashboardActivity.this).deleteFavAfterUpdate(TextUtils.join(",", arrayList));
                    }
                }
            } catch (Exception unused) {
            }
            return Boolean.TRUE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (NewDashboardActivity.e2(NewDashboardActivity.this) == null || !bool.booleanValue()) {
                NewDashboardActivity.G1(NewDashboardActivity.this);
                return;
            }
            NewDashboardActivity.H1(NewDashboardActivity.this, false);
            if (NewDashboardActivity.d2(NewDashboardActivity.this) != null) {
                NewDashboardActivity.d2(NewDashboardActivity.this).updateImportStatus("live", "1");
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(NewDashboardActivity.this.N, "progress", new int[]{50, 0});
            ofInt.setDuration(1000L);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.start();
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 1000L);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onPreExecute() {
        }
    }

    public class j extends AsyncTask {
        public final /* synthetic */ List a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                if (NewDashboardActivity.this.j0.isFocused()) {
                    NewDashboardActivity.this.j.requestFocus();
                }
                NewDashboardActivity.this.j0.setVisibility(8);
                NewDashboardActivity.this.f0.setVisibility(8);
                NewDashboardActivity.this.k0.setVisibility(0);
                NewDashboardActivity.this.l0.setText(NewDashboardActivity.e2(NewDashboardActivity.this).getResources().getString(a7.j.S2) + " " + m7.w.R0(1000L));
                NewDashboardActivity.F1(NewDashboardActivity.this);
            }
        }

        public j(Context context, List list) {
            this.a = list;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            ArrayList allSeriesContinueWatchingSeriesIDs;
            ArrayList allFavouritesStreamIDs;
            if (NewDashboardActivity.d2(NewDashboardActivity.this) != null) {
                NewDashboardActivity.d2(NewDashboardActivity.this).makeEmptySeriesStreams();
            }
            publishProgress(new Integer[]{0});
            if (NewDashboardActivity.d2(NewDashboardActivity.this) == null) {
                return Boolean.FALSE;
            }
            try {
                if (NewDashboardActivity.d2(NewDashboardActivity.this).addAllSeriesStreams(this.a)) {
                    ArrayList arrayList = new ArrayList();
                    if (NewDashboardActivity.C1(NewDashboardActivity.this) != null && (allFavouritesStreamIDs = NewDashboardActivity.C1(NewDashboardActivity.this).getAllFavouritesStreamIDs("series")) != null && allFavouritesStreamIDs.size() > 0) {
                        ArrayList allSeriesIDs = NewDashboardActivity.d2(NewDashboardActivity.this).getAllSeriesIDs();
                        for (int i = 0; i < allFavouritesStreamIDs.size(); i++) {
                            int streamID = ((FavouriteDBModel) allFavouritesStreamIDs.get(i)).getStreamID();
                            if (allSeriesIDs != null && allSeriesIDs.size() > 0) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= allSeriesIDs.size()) {
                                        arrayList.add(String.valueOf(streamID));
                                        break;
                                    }
                                    if (((SeriesDBModel) allSeriesIDs.get(i2)).getseriesID() == streamID) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0 && NewDashboardActivity.C1(NewDashboardActivity.this) != null) {
                        NewDashboardActivity.C1(NewDashboardActivity.this).deleteFavAfterUpdate(TextUtils.join(",", arrayList));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (NewDashboardActivity.D1(NewDashboardActivity.this) != null && (allSeriesContinueWatchingSeriesIDs = NewDashboardActivity.D1(NewDashboardActivity.this).getAllSeriesContinueWatchingSeriesIDs()) != null && allSeriesContinueWatchingSeriesIDs.size() > 0) {
                        ArrayList allSeriesIDs2 = NewDashboardActivity.d2(NewDashboardActivity.this).getAllSeriesIDs();
                        for (int i3 = 0; i3 < allSeriesContinueWatchingSeriesIDs.size(); i3++) {
                            String seriesId = ((GetEpisdoeDetailsCallback) allSeriesContinueWatchingSeriesIDs.get(i3)).getSeriesId();
                            if (allSeriesIDs2 != null && allSeriesIDs2.size() > 0) {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= allSeriesIDs2.size()) {
                                        arrayList2.add(String.valueOf(seriesId));
                                        break;
                                    }
                                    if (String.valueOf(((SeriesDBModel) allSeriesIDs2.get(i4)).getseriesID()).equals(seriesId)) {
                                        break;
                                    }
                                    i4++;
                                }
                            }
                        }
                    }
                    if (arrayList2.size() > 0 && NewDashboardActivity.D1(NewDashboardActivity.this) != null) {
                        NewDashboardActivity.D1(NewDashboardActivity.this).deleteContinueWatchingAfterUpdate(TextUtils.join(",", arrayList2));
                    }
                }
            } catch (Exception unused) {
            }
            return Boolean.TRUE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (NewDashboardActivity.e2(NewDashboardActivity.this) == null || !bool.booleanValue()) {
                NewDashboardActivity.B1(NewDashboardActivity.this);
                return;
            }
            NewDashboardActivity.E1(NewDashboardActivity.this, false);
            if (NewDashboardActivity.d2(NewDashboardActivity.this) != null) {
                NewDashboardActivity.d2(NewDashboardActivity.this).updateImportStatus("series", "1");
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(NewDashboardActivity.this.f0, "progress", new int[]{50, 0});
            ofInt.setDuration(1000L);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.start();
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 1000L);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onPreExecute() {
        }
    }

    public class k extends AsyncTask {
        public final /* synthetic */ List a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NewDashboardActivity.A1(NewDashboardActivity.this).d(NewDashboardActivity.f2(NewDashboardActivity.this), NewDashboardActivity.g2(NewDashboardActivity.this));
            }
        }

        public k(Context context, List list) {
            this.a = list;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            if (NewDashboardActivity.d2(NewDashboardActivity.this) != null) {
                NewDashboardActivity.d2(NewDashboardActivity.this).makeEmptySeriesCategories();
            }
            publishProgress(new Integer[]{0});
            return NewDashboardActivity.d2(NewDashboardActivity.this) != null ? Boolean.valueOf(NewDashboardActivity.d2(NewDashboardActivity.this).addSeriesCategories(this.a)) : Boolean.FALSE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (NewDashboardActivity.e2(NewDashboardActivity.this) == null || !bool.booleanValue()) {
                NewDashboardActivity.B1(NewDashboardActivity.this);
                return;
            }
            if (NewDashboardActivity.f2(NewDashboardActivity.this) == null || NewDashboardActivity.f2(NewDashboardActivity.this).isEmpty() || NewDashboardActivity.g2(NewDashboardActivity.this) == null || NewDashboardActivity.g2(NewDashboardActivity.this).isEmpty()) {
                return;
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(NewDashboardActivity.this.f0, "progress", new int[]{100, 50});
            ofInt.setDuration(500L);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.start();
            new Handler().postDelayed(new a(), 500L);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onPreExecute() {
        }
    }

    public class l extends AsyncTask {
        public final /* synthetic */ List a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NewDashboardActivity.A1(NewDashboardActivity.this).g(NewDashboardActivity.f2(NewDashboardActivity.this), NewDashboardActivity.g2(NewDashboardActivity.this));
            }
        }

        public l(Context context, List list) {
            this.a = list;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            if (NewDashboardActivity.d2(NewDashboardActivity.this) != null) {
                NewDashboardActivity.d2(NewDashboardActivity.this).makeEmptyMovieCategory();
            }
            publishProgress(new Integer[]{0});
            return NewDashboardActivity.d2(NewDashboardActivity.this) != null ? Boolean.valueOf(NewDashboardActivity.d2(NewDashboardActivity.this).addMovieCategories(this.a)) : Boolean.FALSE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (NewDashboardActivity.e2(NewDashboardActivity.this) == null || !bool.booleanValue()) {
                NewDashboardActivity.O1(NewDashboardActivity.this);
                return;
            }
            if (NewDashboardActivity.f2(NewDashboardActivity.this) == null || NewDashboardActivity.f2(NewDashboardActivity.this).isEmpty() || NewDashboardActivity.g2(NewDashboardActivity.this) == null || NewDashboardActivity.g2(NewDashboardActivity.this).isEmpty()) {
                return;
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(NewDashboardActivity.this.U, "progress", new int[]{100, 50});
            ofInt.setDuration(500L);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.start();
            new Handler().postDelayed(new a(), 500L);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onPreExecute() {
        }
    }

    public class m extends AsyncTask {
        public final /* synthetic */ List a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                if (NewDashboardActivity.this.Y.isFocused()) {
                    NewDashboardActivity.this.i.requestFocus();
                }
                NewDashboardActivity.this.Y.setVisibility(8);
                NewDashboardActivity.this.U.setVisibility(8);
                NewDashboardActivity.this.Z.setVisibility(0);
                NewDashboardActivity.this.e0.setText(NewDashboardActivity.e2(NewDashboardActivity.this).getResources().getString(a7.j.S2) + " " + m7.w.R0(1000L));
                NewDashboardActivity.F1(NewDashboardActivity.this);
                if (NewDashboardActivity.L1(NewDashboardActivity.this)) {
                    NewDashboardActivity.M1(NewDashboardActivity.this, false);
                    NewDashboardActivity newDashboardActivity = NewDashboardActivity.this;
                    NewDashboardActivity.N1(newDashboardActivity, NewDashboardActivity.e2(newDashboardActivity).getResources().getString(a7.j.n8));
                }
            }
        }

        public m(Context context, List list) {
            this.a = list;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            ArrayList allMoviesContinueWatchingStreamIDs;
            ArrayList allFavouritesStreamIDs;
            if (NewDashboardActivity.d2(NewDashboardActivity.this) != null) {
                NewDashboardActivity.d2(NewDashboardActivity.this).makeEmptyVODStreams();
            }
            publishProgress(new Integer[]{0});
            if (NewDashboardActivity.d2(NewDashboardActivity.this) == null) {
                return Boolean.FALSE;
            }
            try {
                if (NewDashboardActivity.d2(NewDashboardActivity.this).addAllAvailableMovies(this.a)) {
                    ArrayList arrayList = new ArrayList();
                    if (NewDashboardActivity.C1(NewDashboardActivity.this) != null && (allFavouritesStreamIDs = NewDashboardActivity.C1(NewDashboardActivity.this).getAllFavouritesStreamIDs("vod")) != null && allFavouritesStreamIDs.size() > 0) {
                        ArrayList allLiveMoviesStreamIDs = NewDashboardActivity.d2(NewDashboardActivity.this).getAllLiveMoviesStreamIDs("movie");
                        for (int i = 0; i < allFavouritesStreamIDs.size(); i++) {
                            int streamID = ((FavouriteDBModel) allFavouritesStreamIDs.get(i)).getStreamID();
                            if (allLiveMoviesStreamIDs != null && allLiveMoviesStreamIDs.size() > 0) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= allLiveMoviesStreamIDs.size()) {
                                        arrayList.add(String.valueOf(streamID));
                                        break;
                                    }
                                    if (((LiveStreamsDBModel) allLiveMoviesStreamIDs.get(i2)).getStreamId().equals(String.valueOf(streamID))) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0 && NewDashboardActivity.C1(NewDashboardActivity.this) != null) {
                        NewDashboardActivity.C1(NewDashboardActivity.this).deleteFavAfterUpdate(TextUtils.join(",", arrayList));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (NewDashboardActivity.P1(NewDashboardActivity.this) != null && (allMoviesContinueWatchingStreamIDs = NewDashboardActivity.P1(NewDashboardActivity.this).getAllMoviesContinueWatchingStreamIDs()) != null && allMoviesContinueWatchingStreamIDs.size() > 0) {
                        ArrayList allLiveMoviesStreamIDs2 = NewDashboardActivity.d2(NewDashboardActivity.this).getAllLiveMoviesStreamIDs("movie");
                        for (int i3 = 0; i3 < allMoviesContinueWatchingStreamIDs.size(); i3++) {
                            String streamId = ((LiveStreamsDBModel) allMoviesContinueWatchingStreamIDs.get(i3)).getStreamId();
                            if (allLiveMoviesStreamIDs2 != null && allLiveMoviesStreamIDs2.size() > 0) {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= allLiveMoviesStreamIDs2.size()) {
                                        arrayList2.add(String.valueOf(streamId));
                                        break;
                                    }
                                    if (((LiveStreamsDBModel) allLiveMoviesStreamIDs2.get(i4)).getStreamId().equals(String.valueOf(streamId))) {
                                        break;
                                    }
                                    i4++;
                                }
                            }
                        }
                    }
                    if (arrayList2.size() > 0 && NewDashboardActivity.P1(NewDashboardActivity.this) != null) {
                        NewDashboardActivity.P1(NewDashboardActivity.this).deleteContinueWatchingAfterUpdate(TextUtils.join(",", arrayList2));
                    }
                }
            } catch (Exception unused) {
            }
            return Boolean.TRUE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (NewDashboardActivity.e2(NewDashboardActivity.this) == null || !bool.booleanValue()) {
                NewDashboardActivity.O1(NewDashboardActivity.this);
                return;
            }
            NewDashboardActivity.Q1(NewDashboardActivity.this, false);
            if (NewDashboardActivity.d2(NewDashboardActivity.this) != null) {
                NewDashboardActivity.d2(NewDashboardActivity.this).updateImportStatus("movies", "1");
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(NewDashboardActivity.this.U, "progress", new int[]{50, 0});
            ofInt.setDuration(1000L);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.start();
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 1000L);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        public void onPreExecute() {
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        public void onClick(View view) {
            if (!G.k()) {
                NewDashboardActivity.c2(NewDashboardActivity.this);
                return;
            }
            NewDashboardActivity.this.n2();
            NewDashboardActivity newDashboardActivity = NewDashboardActivity.this;
            newDashboardActivity.M.setImageDrawable(newDashboardActivity.getResources().getDrawable(a7.e.N));
        }
    }

    public class o implements Runnable {
        public o() {
        }

        public void run() {
            ImageView imageView;
            Resources resources;
            int i;
            if (G.k()) {
                NewDashboardActivity newDashboardActivity = NewDashboardActivity.this;
                imageView = newDashboardActivity.M;
                resources = newDashboardActivity.getResources();
                i = a7.e.E;
            } else {
                NewDashboardActivity newDashboardActivity2 = NewDashboardActivity.this;
                imageView = newDashboardActivity2.M;
                resources = newDashboardActivity2.getResources();
                i = a7.e.N;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
        }
    }

    public class p implements ServiceConnection {
        public p() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            de.blinkt.openvpn.core.h A = h.a.A(iBinder);
            if (A != null) {
                try {
                    A.a(false);
                } catch (RemoteException e) {
                    G.r(e);
                }
            }
            NewDashboardActivity.this.unbindService(this);
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public class q implements Runnable {
        public q() {
        }

        public void run() {
            NewDashboardActivity.A1(NewDashboardActivity.this).d(NewDashboardActivity.f2(NewDashboardActivity.this), NewDashboardActivity.g2(NewDashboardActivity.this));
        }
    }

    public class r implements Runnable {
        public r() {
        }

        public void run() {
            NewDashboardActivity.A1(NewDashboardActivity.this).c(NewDashboardActivity.f2(NewDashboardActivity.this), NewDashboardActivity.g2(NewDashboardActivity.this));
        }
    }

    public class s implements Runnable {
        public s() {
        }

        public void run() {
            NewDashboardActivity.A1(NewDashboardActivity.this).g(NewDashboardActivity.f2(NewDashboardActivity.this), NewDashboardActivity.g2(NewDashboardActivity.this));
        }
    }

    public class t implements Runnable {
        public t() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = m7.w.R(NewDashboardActivity.e2(NewDashboardActivity.this));
                String B = m7.w.B(date);
                TextView textView = NewDashboardActivity.this.t;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = NewDashboardActivity.this.s;
                if (textView2 != null) {
                    textView2.setText(B);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class u implements DialogInterface.OnDismissListener {
        public u() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class v implements Runnable {
        public v() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    try {
                        try {
                            NewDashboardActivity.this.o2();
                            Thread.sleep(1000L);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }

    public class w extends Dialog implements View.OnClickListener {
        public Activity a;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public LinearLayout g;
        public LinearLayout h;

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
                            b = w.b(w.this);
                        }
                    } else {
                        b = w.a(w.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = w.b(w.this);
                        }
                    } else {
                        b = w.a(w.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public w(Activity activity) {
            super(activity);
            this.a = activity;
        }

        public static /* synthetic */ LinearLayout a(w wVar) {
            return wVar.g;
        }

        public static /* synthetic */ LinearLayout b(w wVar) {
            return wVar.h;
        }

        public void onClick(View view) {
            if (view.getId() == a7.f.u1) {
                try {
                    NewDashboardActivity newDashboardActivity = NewDashboardActivity.this;
                    NewDashboardActivity.X1(newDashboardActivity, newDashboardActivity.getResources().getString(a7.j.h1));
                } catch (Exception unused) {
                }
            } else if (view.getId() == a7.f.h1) {
                dismiss();
            }
            dismiss();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(NewDashboardActivity.z1(NewDashboardActivity.this).A().equals(m7.a.K0) ? a7.g.b2 : a7.g.a2);
            this.c = findViewById(a7.f.u1);
            this.d = findViewById(a7.f.h1);
            this.g = findViewById(a7.f.V8);
            this.h = findViewById(a7.f.Ia);
            this.f = findViewById(a7.f.fm);
            this.e = findViewById(a7.f.um);
            this.f.setText(NewDashboardActivity.this.getResources().getString(a7.j.X2));
            this.e.setText(NewDashboardActivity.this.getResources().getString(a7.j.W3));
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            TextView textView = this.c;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.d;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public class x extends AsyncTask {
        public Context a;
        public ProgressDialog b;
        public String c;

        public x(Context context, String str) {
            this.a = context;
            this.c = str;
        }

        public static /* synthetic */ void a(x xVar, DialogInterface dialogInterface) {
            xVar.c(dialogInterface);
        }

        /* JADX WARN: Removed duplicated region for block: B:66:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0124  */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Boolean doInBackground(java.lang.String... r15) {
            /*
                Method dump skipped, instructions count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity.x.doInBackground(java.lang.String[]):java.lang.Boolean");
        }

        public final /* synthetic */ void c(DialogInterface dialogInterface) {
            cancel(true);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            this.b.dismiss();
            if (bool.booleanValue()) {
                NewDashboardActivity newDashboardActivity = NewDashboardActivity.this;
                NewDashboardActivity.b2(newDashboardActivity, newDashboardActivity);
            } else {
                Toast.makeText(NewDashboardActivity.this.getApplicationContext(), "Downloading failed. Please try again.", 0).show();
                Log.e("DownloadTask", "Download failed or canceled.");
            }
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            this.b.setMessage("Downloaded " + numArr[0] + "%");
        }

        public void onCancelled() {
            super.onCancelled();
            this.b.dismiss();
            Log.e("DownloadTask", "Download canceled.");
        }

        public void onPreExecute() {
            super.onPreExecute();
            ProgressDialog progressDialog = new ProgressDialog(this.a);
            this.b = progressDialog;
            progressDialog.setMessage("Downloading 0%");
            this.b.setCancelable(false);
            this.b.setOnCancelListener(new h0(this));
            this.b.show();
        }
    }

    public class y implements View.OnFocusChangeListener {
        public final View a;

        public y(View view) {
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

        /* JADX WARN: Removed duplicated region for block: B:12:0x01a9  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x01e7  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x028a  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x02cd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFocusChange(android.view.View r12, boolean r13) {
            /*
                Method dump skipped, instructions count: 876
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity.y.onFocusChange(android.view.View, boolean):void");
        }
    }

    public static /* synthetic */ n7.f A1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.X0;
    }

    public static /* synthetic */ void B1(NewDashboardActivity newDashboardActivity) {
        newDashboardActivity.R2();
    }

    public static /* synthetic */ DatabaseHandler C1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.Q0;
    }

    public static /* synthetic */ SeriesRecentWatchDatabase D1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.p1;
    }

    private void D2(Activity activity) {
        Intent intent;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                intent = new Intent("android.intent.action.INSTALL_PACKAGE");
                intent.setDataAndType(FileProvider.f(activity, "com.nst.iptvsmarterstvbox.ApkProvider", new File(activity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "IPTVSmartersPro.apk")), "application/vnd.android.package-archive");
                intent.setFlags(1);
            } else {
                intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(activity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "IPTVSmartersPro.apk")), "application/vnd.android.package-archive");
                intent.setFlags(67108864);
            }
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ boolean E1(NewDashboardActivity newDashboardActivity, boolean z) {
        newDashboardActivity.d1 = z;
        return z;
    }

    public static /* synthetic */ void F1(NewDashboardActivity newDashboardActivity) {
        newDashboardActivity.x2();
    }

    private boolean F2() {
        return new File(this.B0.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "IPTVSmartersPro.apk").exists();
    }

    public static /* synthetic */ void G1(NewDashboardActivity newDashboardActivity) {
        newDashboardActivity.I2();
    }

    private boolean G2() {
        return new File(this.B0.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "IPTVSmartersPro.apk").delete();
    }

    public static /* synthetic */ boolean H1(NewDashboardActivity newDashboardActivity, boolean z) {
        newDashboardActivity.b1 = z;
        return z;
    }

    public static boolean H2(int i2, int i3, int i4) {
        return i2 >= i3 && i2 <= i4;
    }

    public static /* synthetic */ boolean I1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.m1;
    }

    public static /* synthetic */ boolean J1(NewDashboardActivity newDashboardActivity, boolean z) {
        newDashboardActivity.m1 = z;
        return z;
    }

    private void J2() {
        d dVar = new d(DashBoardListssingleton.b().a());
        this.O1 = dVar;
        dVar.run();
    }

    public static /* synthetic */ void K1(NewDashboardActivity newDashboardActivity, String str) {
        newDashboardActivity.B2(str);
    }

    public static /* synthetic */ boolean L1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.n1;
    }

    public static /* synthetic */ boolean M1(NewDashboardActivity newDashboardActivity, boolean z) {
        newDashboardActivity.n1 = z;
        return z;
    }

    public static /* synthetic */ void N1(NewDashboardActivity newDashboardActivity, String str) {
        newDashboardActivity.C2(str);
    }

    public static /* synthetic */ void O1(NewDashboardActivity newDashboardActivity) {
        newDashboardActivity.P2();
    }

    public static /* synthetic */ RecentWatchDBHandler P1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.o1;
    }

    public static /* synthetic */ boolean Q1(NewDashboardActivity newDashboardActivity, boolean z) {
        newDashboardActivity.c1 = z;
        return z;
    }

    public static /* synthetic */ int R1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.t1;
    }

    public static /* synthetic */ int S1(NewDashboardActivity newDashboardActivity, int i2) {
        newDashboardActivity.t1 = i2;
        return i2;
    }

    public static /* synthetic */ DashboardSBPAnnouncementAdapter T1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.U1;
    }

    public static /* synthetic */ DashboardSBPAnnouncementAdapter U1(NewDashboardActivity newDashboardActivity, DashboardSBPAnnouncementAdapter dashboardSBPAnnouncementAdapter) {
        newDashboardActivity.U1 = dashboardSBPAnnouncementAdapter;
        return dashboardSBPAnnouncementAdapter;
    }

    public static /* synthetic */ void V1(NewDashboardActivity newDashboardActivity) {
        newDashboardActivity.d3();
    }

    public static /* synthetic */ PopupWindow W1() {
        return Y1;
    }

    public static /* synthetic */ void X1(NewDashboardActivity newDashboardActivity, String str) {
        newDashboardActivity.A2(str);
    }

    public static /* synthetic */ int Y1(NewDashboardActivity newDashboardActivity, String str) {
        return newDashboardActivity.h2(str);
    }

    public static /* synthetic */ boolean Z1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.F2();
    }

    public static /* synthetic */ boolean a2(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.G2();
    }

    public static /* synthetic */ void b2(NewDashboardActivity newDashboardActivity, Activity activity) {
        newDashboardActivity.D2(activity);
    }

    public static /* synthetic */ void c2(NewDashboardActivity newDashboardActivity) {
        newDashboardActivity.v1();
    }

    public static /* synthetic */ LiveStreamDBHandler d2(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.E0;
    }

    public static /* synthetic */ Context e2(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.B0;
    }

    public static /* synthetic */ String f2(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.Y0;
    }

    public static /* synthetic */ String g2(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.Z0;
    }

    private void i2() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void k2() {
        if (m7.a.V0.booleanValue()) {
            if (this.W0.k() != null && this.W0.n() != null && this.W0.l() != 0) {
                String str = "";
                if (!this.W0.k().equals("") && !this.W0.n().equals("")) {
                    String j2 = this.W0.j();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                    Date date = new Date();
                    if (j2 != null) {
                        try {
                            if (j2.length() > 0) {
                                date.setTime(Long.parseLong(j2));
                                str = simpleDateFormat.format(date);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    long r2 = r2(simpleDateFormat, str, m7.w.q());
                    if (this.W0.m().booleanValue() && r2 >= 7) {
                        this.W0.P();
                        this.g1 = m7.w.I(this.B0);
                        this.h1 = m7.w.E();
                        w1();
                        this.j1.g(this.W0.k(), this.W0.n(), this.h1, this.g1, m7.w.o0(this.W0.k() + "*Njh0&$@ZH098GP-Vu6HilnbLo63-" + b7.b.b + "-"));
                    }
                    LinearLayout linearLayout = this.s0;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    TextView textView = this.r0;
                    if (textView != null) {
                        textView.setText(getResources().getString(a7.j.S3));
                    }
                    ImageView imageView = this.t0;
                    if (imageView != null) {
                        imageView.setImageResource(a7.e.a);
                    }
                }
            }
            LinearLayout linearLayout2 = this.s0;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            this.v0.setVisibility(0);
            this.u1.setVisibility(0);
            TextView textView2 = this.r0;
            if (textView2 != null) {
                textView2.setText(getResources().getString(a7.j.Z));
            }
            ImageView imageView2 = this.t0;
            if (imageView2 != null) {
                imageView2.setImageResource(a7.e.D0);
                return;
            }
            return;
        }
        this.u1.setVisibility(8);
        this.v0.setVisibility(8);
    }

    public static ProgressDialog l2(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        try {
            progressDialog.show();
        } catch (Exception unused) {
        }
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        progressDialog.setContentView(a7.g.e4);
        return progressDialog;
    }

    public static long r2(SimpleDateFormat simpleDateFormat, String str, String str2) {
        if (str2 != null) {
            try {
                if (((str2.length() > 0) & (str != null)) && str.length() > 0) {
                    return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    private boolean w2(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 33 && i2 >= 23) {
            return E.b.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") == 0 && E.b.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        return true;
    }

    public static /* synthetic */ long x1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.M0;
    }

    public static /* synthetic */ long y1(NewDashboardActivity newDashboardActivity, long j2) {
        newDashboardActivity.M0 = j2;
        return j2;
    }

    public static /* synthetic */ u7.a z1(NewDashboardActivity newDashboardActivity) {
        return newDashboardActivity.W0;
    }

    public void A(String str) {
        I2();
    }

    public void A0(String str) {
        R2();
    }

    public final void A2(String str) {
        ProgressDialog progressDialog = this.e1;
        if (progressDialog == null) {
            progressDialog = l2(this.B0);
            this.e1 = progressDialog;
        }
        progressDialog.show();
        if (this.B0 != null) {
            this.b1 = true;
            LiveStreamDBHandler liveStreamDBHandler = this.E0;
            if (liveStreamDBHandler != null) {
                liveStreamDBHandler.updateImportStatus("live", "3");
            }
            q2(str);
        }
    }

    public void B(List list) {
        if (list != null) {
            new j(this.B0, list).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else {
            R2();
        }
    }

    public void B0(RegisterClientCallback registerClientCallback) {
    }

    public final void B2(String str) {
        ProgressDialog progressDialog = this.e1;
        if (progressDialog == null) {
            progressDialog = l2(this.B0);
            this.e1 = progressDialog;
        }
        progressDialog.show();
        if (this.B0 != null) {
            this.c1 = true;
            LiveStreamDBHandler liveStreamDBHandler = this.E0;
            if (liveStreamDBHandler != null) {
                liveStreamDBHandler.updateImportStatus("movies", "3");
            }
            t2(str);
        }
    }

    public final void C2(String str) {
        ProgressDialog progressDialog = this.e1;
        if (progressDialog == null) {
            progressDialog = l2(this.B0);
            this.e1 = progressDialog;
        }
        progressDialog.show();
        if (this.B0 != null) {
            this.d1 = true;
            LiveStreamDBHandler liveStreamDBHandler = this.E0;
            if (liveStreamDBHandler != null) {
                liveStreamDBHandler.updateImportStatus("series", "3");
            }
            v2(str);
        }
    }

    public final void E2() {
        new w(this).show();
    }

    public final void I2() {
        this.b1 = false;
        x2();
        LiveStreamDBHandler liveStreamDBHandler = this.E0;
        if (liveStreamDBHandler != null) {
            liveStreamDBHandler.updateImportStatus("live", "2");
        }
        this.N.setVisibility(0);
        this.R.setVisibility(0);
        this.O.setImageResource(a7.e.p0);
        this.O.setVisibility(0);
        this.P.setVisibility(8);
        this.Q.setText(this.B0.getResources().getString(a7.j.o6));
        if (this.m1) {
            this.m1 = false;
            B2(this.B0.getResources().getString(a7.j.n8));
        } else if (this.n1) {
            this.n1 = false;
            C2(this.B0.getResources().getString(a7.j.n8));
        }
    }

    public void J(BillingIsPurchasedCallback billingIsPurchasedCallback) {
    }

    public void J0(List list) {
        String str;
        String str2;
        if (list != null) {
            new k(this.B0, list).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        }
        if (this.B0 == null || (str = this.Y0) == null || str.isEmpty() || (str2 = this.Z0) == null || str2.isEmpty()) {
            return;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f0, "progress", new int[]{100, 50});
        ofInt.setDuration(500L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.start();
        new Handler().postDelayed(new q(), 500L);
    }

    public final void K2() {
        Runnable runnable;
        List c2 = Listsingleton.b().c();
        this.w0.setSelected(true);
        Handler handler = this.K1;
        if (handler != null && (runnable = this.N1) != null) {
            handler.removeCallbacks(runnable);
        }
        e eVar = new e(c2);
        this.N1 = eVar;
        eVar.run();
    }

    public void L(List list) {
        if (list != null) {
            new i(this.B0, list).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else {
            I2();
        }
    }

    public void L0(BillingLoginClientCallback billingLoginClientCallback) {
        if (billingLoginClientCallback != null) {
            try {
                if (billingLoginClientCallback.getResult() == null || !billingLoginClientCallback.getResult().equals("success") || billingLoginClientCallback.getSc() == null) {
                    return;
                }
                if (!billingLoginClientCallback.getSc().equalsIgnoreCase(m7.w.o0("Vu6HilnbLo63*KJHGFkugu345*&^klih*" + b7.b.b)) || billingLoginClientCallback.getData() == null || billingLoginClientCallback.getMessage() == null || !billingLoginClientCallback.getMessage().equals("Max Connection Reached")) {
                    return;
                }
                this.W0.a();
                if (m7.a.o.booleanValue()) {
                    k2();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void L2() {
        List c2 = DashBoardListssingleton.b().c();
        this.z0.setSelected(true);
        c cVar = new c(c2);
        this.P1 = cVar;
        cVar.run();
    }

    public final void M2() {
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.s0.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.k0.setOnClickListener(this);
        this.z1.setOnClickListener(this);
        this.A1.setOnClickListener(this);
        this.B1.setOnClickListener(this);
        this.F1.setOnClickListener(this);
        this.C1.setOnClickListener(this);
        this.D1.setOnClickListener(this);
        this.E1.setOnClickListener(this);
        this.m0.setOnClickListener(this);
        this.n0.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.w1.setOnClickListener(this);
        this.x1.setOnClickListener(this);
    }

    public void N0(BillingUpdateDevicesCallback billingUpdateDevicesCallback) {
    }

    public final void N2() {
        ArrayList arrayList;
        DownloadedDBHandler downloadedDBHandler;
        int idAuto;
        try {
            this.d = new DownloadedDBHandler(this.B0);
            this.e = new ArrayList();
            ArrayList downloadedData = this.d.getDownloadedData();
            this.e = downloadedData;
            try {
                if (downloadedData.size() > 0) {
                    for (int i2 = 0; i2 < this.e.size(); i2++) {
                        Log.i("movieState", ((DownloadedDataModel) this.e.get(i2)).getMovieState());
                        if (((DownloadedDataModel) this.e.get(i2)).getMovieState().equals("Downloading")) {
                            z3.x.z(this.B0, VideoDownloadService.class, String.valueOf(((DownloadedDataModel) this.e.get(i2)).getMovieStreamID()), 1001, true);
                            arrayList = new ArrayList();
                            DownloadedDataModel downloadedDataModel = new DownloadedDataModel();
                            downloadedDataModel.setMovieState("Paused");
                            downloadedDataModel.setMoviePercentage(((DownloadedDataModel) this.e.get(i2)).getMoviePercentage());
                            arrayList.add(downloadedDataModel);
                            downloadedDBHandler = this.d;
                            idAuto = ((DownloadedDataModel) this.e.get(i2)).getIdAuto();
                        } else if (((DownloadedDataModel) this.e.get(i2)).getMovieState().equals("Waiting")) {
                            z3.x.z(this.B0, VideoDownloadService.class, String.valueOf(((DownloadedDataModel) this.e.get(i2)).getMovieStreamID()), 1001, true);
                            arrayList = new ArrayList();
                            DownloadedDataModel downloadedDataModel2 = new DownloadedDataModel();
                            downloadedDataModel2.setMovieState("Paused");
                            downloadedDataModel2.setMoviePercentage(((DownloadedDataModel) this.e.get(i2)).getMoviePercentage());
                            arrayList.add(downloadedDataModel2);
                            downloadedDBHandler = this.d;
                            idAuto = ((DownloadedDataModel) this.e.get(i2)).getIdAuto();
                        }
                        downloadedDBHandler.updateDownloadedData(arrayList, idAuto);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void O2() {
        if (Build.VERSION.SDK_INT < 33 || g0.a(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            return;
        }
        D.b.h(this, m7.w.s0(), 1);
    }

    public final void P2() {
        this.c1 = false;
        x2();
        LiveStreamDBHandler liveStreamDBHandler = this.E0;
        if (liveStreamDBHandler != null) {
            liveStreamDBHandler.updateImportStatus("movies", "2");
        }
        this.U.setVisibility(0);
        this.Y.setVisibility(0);
        this.V.setImageResource(a7.e.p0);
        this.V.setVisibility(0);
        this.W.setVisibility(8);
        this.X.setText(this.B0.getResources().getString(a7.j.o6));
        if (this.n1) {
            this.n1 = false;
            C2(this.B0.getResources().getString(a7.j.n8));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Q0(com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.getAnnouncementsFirebaseCallback r6) {
        /*
            r5 = this;
            java.lang.String r0 = "*"
            r1 = 0
            if (r6 == 0) goto Lb8
            java.lang.String r2 = r6.b()     // Catch: java.lang.Exception -> Ld3
            if (r2 == 0) goto Lb8
            java.lang.String r2 = r6.b()     // Catch: java.lang.Exception -> Ld3
            java.lang.String r3 = "success"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> Ld3
            if (r2 == 0) goto Lb8
            java.lang.String r2 = r6.c()     // Catch: java.lang.Exception -> Ld3
            if (r2 == 0) goto Lb8
            r6.c()     // Catch: java.lang.Exception -> Ld3
            java.util.Date r2 = new java.util.Date     // Catch: java.lang.Exception -> Ld3
            r2.<init>()     // Catch: java.lang.Exception -> Ld3
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch: java.lang.Exception -> Ld3
            java.lang.String r4 = "yyyy-MM"
            r3.<init>(r4)     // Catch: java.lang.Exception -> Ld3
            java.lang.String r2 = r3.format(r2)     // Catch: java.lang.Exception -> Ld3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld3
            r3.<init>()     // Catch: java.lang.Exception -> Ld3
            java.lang.String r4 = m7.a.S0     // Catch: java.lang.Exception -> Ld3
            r3.append(r4)     // Catch: java.lang.Exception -> Ld3
            r3.append(r0)     // Catch: java.lang.Exception -> Ld3
            java.lang.String r4 = "JNHGHG34534543HSDHSHSSH*&^klih"
            r3.append(r4)     // Catch: java.lang.Exception -> Ld3
            r3.append(r0)     // Catch: java.lang.Exception -> Ld3
            java.lang.String r4 = b7.b.b     // Catch: java.lang.Exception -> Ld3
            r3.append(r4)     // Catch: java.lang.Exception -> Ld3
            r3.append(r0)     // Catch: java.lang.Exception -> Ld3
            r3.append(r2)     // Catch: java.lang.Exception -> Ld3
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> Ld3
            m7.w.o0(r0)     // Catch: java.lang.Exception -> Ld3
            java.lang.Integer r0 = r6.d()     // Catch: java.lang.Exception -> Ld3
            if (r0 == 0) goto La6
            java.util.List r0 = r6.a()     // Catch: java.lang.Exception -> Ld3
            if (r0 == 0) goto La6
            java.util.List r0 = r6.a()     // Catch: java.lang.Exception -> Ld3
            int r0 = r0.size()     // Catch: java.lang.Exception -> Ld3
            if (r0 <= 0) goto La6
            com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton r0 = com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton.b()     // Catch: java.lang.Exception -> Ld3
            java.util.List r2 = r6.a()     // Catch: java.lang.Exception -> Ld3
            r0.c(r2)     // Catch: java.lang.Exception -> Ld3
            java.util.List r0 = r6.a()     // Catch: java.lang.Exception -> Ld3
            android.content.Context r2 = r5.B0     // Catch: java.lang.Exception -> Ld3
            com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setAnnouncementsList(r0, r2)     // Catch: java.lang.Exception -> Ld3
            r0 = 0
            r2 = 0
        L83:
            java.util.List r3 = r6.a()     // Catch: java.lang.Exception -> Ld3
            int r3 = r3.size()     // Catch: java.lang.Exception -> Ld3
            if (r0 >= r3) goto Lb9
            java.util.List r3 = r6.a()     // Catch: java.lang.Exception -> Ld3
            java.lang.Object r3 = r3.get(r0)     // Catch: java.lang.Exception -> Ld3
            com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.AnnouncementsData r3 = (com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.AnnouncementsData) r3     // Catch: java.lang.Exception -> Ld3
            java.lang.Integer r3 = r3.getSeen()     // Catch: java.lang.Exception -> Ld3
            int r3 = r3.intValue()     // Catch: java.lang.Exception -> Ld3
            if (r3 != 0) goto La3
            int r2 = r2 + 1
        La3:
            int r0 = r0 + 1
            goto L83
        La6:
            android.content.Context r6 = r5.B0     // Catch: java.lang.Exception -> Lb4
            r0 = 0
            com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setAnnouncementsList(r0, r6)     // Catch: java.lang.Exception -> Lb4
            com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton r6 = com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton.b()     // Catch: java.lang.Exception -> Lb4
            r6.c(r0)     // Catch: java.lang.Exception -> Lb4
            goto Lb8
        Lb4:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Exception -> Ld3
        Lb8:
            r2 = 0
        Lb9:
            if (r2 <= 0) goto Lcc
            android.widget.TextView r6 = r5.u0     // Catch: java.lang.Exception -> Ld3
            if (r6 == 0) goto Ld3
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> Ld3
            r6.setText(r0)     // Catch: java.lang.Exception -> Ld3
            android.widget.TextView r6 = r5.u0     // Catch: java.lang.Exception -> Ld3
            r6.setVisibility(r1)     // Catch: java.lang.Exception -> Ld3
            goto Ld3
        Lcc:
            android.widget.TextView r6 = r5.u0     // Catch: java.lang.Exception -> Ld3
            r0 = 8
            r6.setVisibility(r0)     // Catch: java.lang.Exception -> Ld3
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity.Q0(com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.getAnnouncementsFirebaseCallback):void");
    }

    public final void Q2() {
        startActivity(new Intent(this, NewEPGCategoriesActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void R0() {
        ConstraintLayout constraintLayout = this.v1;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
            LinearLayout linearLayout = this.h;
            if (linearLayout != null) {
                linearLayout.requestFocus();
            }
        }
    }

    public final void R2() {
        this.d1 = false;
        x2();
        LiveStreamDBHandler liveStreamDBHandler = this.E0;
        if (liveStreamDBHandler != null) {
            liveStreamDBHandler.updateImportStatus("series", "2");
        }
        this.f0.setVisibility(0);
        this.j0.setVisibility(0);
        this.g0.setImageResource(a7.e.p0);
        this.g0.setVisibility(0);
        this.h0.setVisibility(8);
        this.i0.setText(this.B0.getResources().getString(a7.j.o6));
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void S2(java.util.List r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L29
            int r1 = r4.size()     // Catch: java.lang.Exception -> L27
            if (r1 <= 0) goto L29
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Exception -> L27
            r1 = 0
        Le:
            boolean r2 = r4.hasNext()     // Catch: java.lang.Exception -> L27
            if (r2 == 0) goto L2a
            java.lang.Object r2 = r4.next()     // Catch: java.lang.Exception -> L27
            com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.AnnouncementsData r2 = (com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.AnnouncementsData) r2     // Catch: java.lang.Exception -> L27
            java.lang.Integer r2 = r2.getSeen()     // Catch: java.lang.Exception -> L27
            int r2 = r2.intValue()     // Catch: java.lang.Exception -> L27
            if (r2 != 0) goto Le
            int r1 = r1 + 1
            goto Le
        L27:
            r4 = move-exception
            goto L45
        L29:
            r1 = 0
        L2a:
            if (r1 <= 0) goto L3d
            android.widget.TextView r4 = r3.u0     // Catch: java.lang.Exception -> L27
            if (r4 == 0) goto L48
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L27
            r4.setText(r1)     // Catch: java.lang.Exception -> L27
            android.widget.TextView r4 = r3.u0     // Catch: java.lang.Exception -> L27
            r4.setVisibility(r0)     // Catch: java.lang.Exception -> L27
            goto L48
        L3d:
            android.widget.TextView r4 = r3.u0     // Catch: java.lang.Exception -> L27
            r0 = 8
            r4.setVisibility(r0)     // Catch: java.lang.Exception -> L27
            goto L48
        L45:
            r4.printStackTrace()
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity.S2(java.util.List):void");
    }

    public void T(List list) {
        if (list != null) {
            new m(this.B0, list).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else {
            P2();
        }
    }

    public void T2(boolean z, String str) {
        this.R1 = z;
        this.S1 = str;
    }

    public void U2() {
        LinearLayout linearLayout = this.h;
        if (linearLayout != null) {
            linearLayout.requestFocus();
        }
    }

    public void V2(boolean z, boolean z2) {
        if (z) {
            try {
                m7.a.e1 = SharepreferenceDBHandler.getPrefAdsStatus(this.B0);
                m7.a.f1 = SharepreferenceDBHandler.getViewableRate(this.B0);
                if (SharepreferenceDBHandler.getRewardedTextList(this.B0) == null || SharepreferenceDBHandler.getRewardedTextList(this.B0).size() <= 0) {
                    Listsingleton.b().f((List) null);
                    this.w0.setText("");
                    this.w0.setVisibility(8);
                } else {
                    m7.a.h1 = true;
                    Listsingleton.b().f((List) null);
                    Listsingleton.b().f(SharepreferenceDBHandler.getRewardedTextList(this.B0));
                    Listsingleton.b().e((List) null);
                    K2();
                }
                if (SharepreferenceDBHandler.getRewardedImageList(this.B0) == null || SharepreferenceDBHandler.getRewardedImageList(this.B0).size() <= 0) {
                    Listsingleton.b().d((List) null);
                } else {
                    m7.a.h1 = true;
                    Listsingleton.b().d((List) null);
                    Listsingleton.b().d(SharepreferenceDBHandler.getRewardedImageList(this.B0));
                }
            } catch (Exception unused) {
            }
        }
        if (!m7.a.o.booleanValue() && z2) {
            try {
                if (SharepreferenceDBHandler.getDashboardImageList(this.B0) == null || SharepreferenceDBHandler.getDashboardImageList(this.B0).size() <= 0) {
                    this.x0.setVisibility(8);
                    this.y0.setVisibility(8);
                } else {
                    m7.a.i1 = true;
                    DashBoardListssingleton.b().d((List) null);
                    DashBoardListssingleton.b().d(SharepreferenceDBHandler.getDashboardImageList(this.B0));
                    DashBoardListssingleton.b().e((ArrayList) null);
                    J2();
                    this.x0.setVisibility(0);
                    this.y0.setVisibility(0);
                }
                if (SharepreferenceDBHandler.getDashboardTextList(this.B0) == null || SharepreferenceDBHandler.getDashboardTextList(this.B0).size() <= 0) {
                    this.x0.setVisibility(8);
                    this.y0.setVisibility(8);
                } else {
                    m7.a.h1 = true;
                    DashBoardListssingleton.b().g((List) null);
                    DashBoardListssingleton.b().g(SharepreferenceDBHandler.getDashboardTextList(this.B0));
                    DashBoardListssingleton.b().f((List) null);
                    this.x0.setVisibility(0);
                    this.y0.setVisibility(0);
                    L2();
                }
            } catch (Exception unused2) {
            }
        }
        if (SharepreferenceDBHandler.getAnnouncementsList(this.B0) == null || SharepreferenceDBHandler.getAnnouncementsList(this.B0).size() <= 0) {
            S2(null);
            AnnouncementsSBPSingleton.b().c((List) null);
        } else {
            S2(SharepreferenceDBHandler.getAnnouncementsList(this.B0));
            AnnouncementsSBPSingleton.b().c(SharepreferenceDBHandler.getAnnouncementsList(this.B0));
        }
    }

    public void W2() {
        if (SharepreferenceDBHandler.getAnnouncementsList(this.B0) == null || SharepreferenceDBHandler.getAnnouncementsList(this.B0).size() <= 0) {
            S2(null);
            AnnouncementsSBPSingleton.b().c((List) null);
        } else {
            S2(SharepreferenceDBHandler.getAnnouncementsList(this.B0));
            AnnouncementsSBPSingleton.b().c(SharepreferenceDBHandler.getAnnouncementsList(this.B0));
        }
        DashboardSBPAnnouncementAdapter dashboardSBPAnnouncementAdapter = this.U1;
        if (dashboardSBPAnnouncementAdapter != null) {
            dashboardSBPAnnouncementAdapter.q0();
        }
    }

    public void X2() {
        if (!m7.a.V0.booleanValue() || SharepreferenceDBHandler.getUpdateVersionCode(this.B0) == null || SharepreferenceDBHandler.getUpdateVersionCode(this.B0).length() <= 0) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(SharepreferenceDBHandler.getUpdateVersionCode(this.B0));
            String updateVersionName = SharepreferenceDBHandler.getUpdateVersionName(this.B0);
            if (parseInt <= 108 || SharepreferenceDBHandler.getUpdateVersionUrl(this.B0) == null || SharepreferenceDBHandler.getUpdateVersionUrl(this.B0).length() <= 0) {
                return;
            }
            this.X1 = SharepreferenceDBHandler.getUpdateVersionUrl(this.B0);
            ConstraintLayout constraintLayout = this.v1;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
                if (updateVersionName == null || updateVersionName.length() <= 0) {
                    if (this.y1 != null) {
                        this.y1.setText(getResources().getString(a7.j.H) + " " + getResources().getString(a7.j.G) + " " + getResources().getString(a7.j.I));
                    }
                } else if (this.y1 != null) {
                    String str = getResources().getString(a7.j.H) + " " + getResources().getString(a7.j.G) + " " + getResources().getString(a7.j.I);
                    this.y1.setText(str + " " + updateVersionName);
                }
                Button button = this.w1;
                if (button != null) {
                    button.requestFocus();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void Y(String str) {
        R2();
    }

    public void Y2() {
        if (this.B0 != null) {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(a7.g.r2, findViewById(a7.f.We));
            PopupWindow popupWindow = new PopupWindow(this);
            Y1 = popupWindow;
            popupWindow.setContentView(inflate);
            Y1.setWidth(-1);
            Y1.setHeight(-1);
            Y1.setFocusable(true);
            Y1.setBackgroundDrawable(new BitmapDrawable());
            Y1.showAtLocation(inflate, 17, 0, 0);
            TextView findViewById = inflate.findViewById(a7.f.Ik);
            TextView findViewById2 = inflate.findViewById(a7.f.Ai);
            Button findViewById3 = inflate.findViewById(a7.f.L0);
            Button findViewById4 = inflate.findViewById(a7.f.o0);
            if (findViewById != null) {
                findViewById.setText(getResources().getString(a7.j.f3));
            }
            if (findViewById2 != null) {
                findViewById2.setText(getResources().getString(a7.j.e3));
            }
            if (findViewById3 != null) {
                findViewById3.setOnFocusChangeListener(new w.k(findViewById3, this));
            }
            if (findViewById4 != null) {
                findViewById4.setOnFocusChangeListener(new w.k(findViewById4, this));
            }
            findViewById4.setOnClickListener(new a());
            if (findViewById3 != null) {
                findViewById3.setOnClickListener(new b());
            }
        }
    }

    public final void Z2() {
        g gVar = new g(this, this.B0, this.E0);
        gVar.setOnDismissListener(new u());
        Window window = gVar.getWindow();
        if (window != null) {
            window.setGravity(5);
        }
        gVar.show();
    }

    public void a() {
    }

    public final void a3(boolean z) {
        String p2 = m7.w.p();
        String lastUpdateTime = SharepreferenceDBHandler.getLastUpdateTime(this.B0);
        int lastUpdate = SharepreferenceDBHandler.getLastUpdate(this.B0);
        if (SharepreferenceDBHandler.getLastUpdateTime(this.B0).length() == 0 || m7.w.D(lastUpdateTime, p2) >= lastUpdate) {
            c3();
        } else {
            V2(true, true);
        }
    }

    public void b() {
    }

    public void b3() {
        Intent intent = new Intent(this, ImportM3uActivity.class);
        intent.putExtra("M3U_LINE", this.R0);
        startActivity(intent);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void c(String str) {
    }

    public void c3() {
        Q0.u.f(this.B0).d("uniqueWorkName6", Q0.d.REPLACE, new m.a(ApiWorkerCombinedRequest.class).b());
    }

    public void d(String str) {
    }

    public final void d3() {
        if (m7.a.I0) {
            m7.a.I0 = false;
        }
        if ((m7.a.s.booleanValue() && SharepreferenceDBHandler.getCurrentAPPType(this.B0).equals("api")) || (m7.a.s.booleanValue() && SharepreferenceDBHandler.getCurrentAPPType(this.B0).equals("onestream_api"))) {
            N2();
        } else if ((!m7.a.s.booleanValue() || !SharepreferenceDBHandler.getCurrentAPPType(this.B0).equals("stalker_api")) && (!m7.a.s.booleanValue() || !m7.a.u.booleanValue() || !SharepreferenceDBHandler.getCurrentAPPType(this.B0).equals("m3u"))) {
            Y2();
            return;
        }
        m7.a.b0 = Boolean.TRUE;
        m7.w.n0(this.B0);
        finish();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void e(String str) {
    }

    public final void e3(ImportStatusModel importStatusModel, ImportStatusModel importStatusModel2, ImportStatusModel importStatusModel3) {
        long currentTimeMillis = (importStatusModel.getTime() == null || importStatusModel.getTime().equals("")) ? 0L : System.currentTimeMillis() - Long.parseLong(importStatusModel.getTime());
        long currentTimeMillis2 = (importStatusModel2.getTime() == null || importStatusModel2.getTime().equals("")) ? 0L : System.currentTimeMillis() - Long.parseLong(importStatusModel2.getTime());
        long currentTimeMillis3 = (importStatusModel3.getTime() == null || importStatusModel3.getTime().equals("")) ? 0L : System.currentTimeMillis() - Long.parseLong(importStatusModel3.getTime());
        if (currentTimeMillis == 0 || currentTimeMillis <= 0 || importStatusModel.getStatus() == null || !importStatusModel.getStatus().equals("1")) {
            this.S.setVisibility(8);
        } else {
            this.S.setVisibility(0);
            this.T.setText(this.B0.getResources().getString(a7.j.S2) + " " + m7.w.R0(currentTimeMillis));
        }
        if (currentTimeMillis2 == 0 || currentTimeMillis2 <= 0 || importStatusModel2.getStatus() == null || !importStatusModel2.getStatus().equals("1")) {
            this.Z.setVisibility(8);
        } else {
            this.Z.setVisibility(0);
            this.e0.setText(this.B0.getResources().getString(a7.j.S2) + " " + m7.w.R0(currentTimeMillis2));
        }
        if (currentTimeMillis3 == 0 || currentTimeMillis3 <= 0 || importStatusModel3.getStatus() == null || !importStatusModel3.getStatus().equals("1")) {
            this.k0.setVisibility(8);
            return;
        }
        this.k0.setVisibility(0);
        this.l0.setText(this.B0.getResources().getString(a7.j.S2) + " " + m7.w.R0(currentTimeMillis3));
    }

    public void f(String str) {
        this.X1 = str;
        if (this.v1 != null) {
            String updateVersionName = SharepreferenceDBHandler.getUpdateVersionName(this.B0);
            if (SharepreferenceDBHandler.getUpdateVersionUrl(this.B0) == null || SharepreferenceDBHandler.getUpdateVersionUrl(this.B0).length() <= 0) {
                return;
            }
            this.v1.setVisibility(0);
            if (this.y1 != null) {
                String str2 = getResources().getString(a7.j.H) + " " + getResources().getString(a7.j.G) + " " + getResources().getString(a7.j.I);
                this.y1.setText(str2 + " " + updateVersionName);
            }
            Button button = this.w1;
            if (button != null) {
                button.requestFocus();
            }
        }
    }

    public void g(BillingGetDevicesCallback billingGetDevicesCallback) {
    }

    public void h(AdsLastUpdateResponseCallback adsLastUpdateResponseCallback) {
        if (adsLastUpdateResponseCallback == null || !adsLastUpdateResponseCallback.b().equalsIgnoreCase("success") || adsLastUpdateResponseCallback.a() == null || adsLastUpdateResponseCallback.a().length() == 0 || SharepreferenceDBHandler.getLastUpdateTime(this.B0).length() == 0 || !SharepreferenceDBHandler.getLastUpdateTime(this.B0).equalsIgnoreCase(adsLastUpdateResponseCallback.a())) {
            return;
        }
        V2(true, true);
    }

    public void h0(ArrayList arrayList, String str) {
    }

    public final int h2(String str) {
        if (H2(str.length(), 0, 50)) {
            return 5000;
        }
        if (H2(str.length(), 50, 100)) {
            return 10000;
        }
        if (H2(str.length(), 100, 150)) {
            return 15000;
        }
        if (H2(str.length(), 150, 200)) {
            return 25000;
        }
        if (H2(str.length(), 200, 250)) {
            return 35000;
        }
        if (H2(str.length(), 250, 300)) {
            return 45000;
        }
        if (H2(str.length(), 300, 350)) {
            return 50000;
        }
        return H2(str.length(), 350, 500) ? 70000 : 100000;
    }

    public void i0(String str) {
        P2();
    }

    public boolean j2() {
        SharedPreferences sharedPreferences = getSharedPreferences("automation_channels", 0);
        this.L0 = sharedPreferences;
        return sharedPreferences.getString("automation_channels", "").equals("checked");
    }

    public void k0(readAnnouncementFirebaseCallback readannouncementfirebasecallback) {
    }

    public void l(String str) {
        P2();
    }

    public void l0(List list) {
        String str;
        String str2;
        if (list != null) {
            new l(this.B0, list).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        }
        if (this.B0 == null || (str = this.Y0) == null || str.isEmpty() || (str2 = this.Z0) == null || str2.isEmpty()) {
            return;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.U, "progress", new int[]{100, 50});
        ofInt.setDuration(500L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.start();
        new Handler().postDelayed(new s(), 500L);
    }

    public void m(LoginCallback loginCallback, String str) {
        TextView textView;
        String str2;
        if (loginCallback != null) {
            try {
                if (loginCallback.getUserLoginInfo() != null) {
                    int i2 = 1;
                    if (loginCallback.getUserLoginInfo().getAuth().intValue() == 1 && loginCallback.getUserLoginInfo().getStatus().equals("Active")) {
                        if (loginCallback.getUserLoginInfo().getExpDate() != null) {
                            String expDate = loginCallback.getUserLoginInfo().getExpDate();
                            String timezone = loginCallback.getServerInfo().getTimezone();
                            SharedPreferences.Editor editor = this.D0;
                            if (editor != null) {
                                editor.putString("expDate", expDate);
                                this.D0.putString("serverTimeZone", timezone);
                                this.D0.apply();
                            }
                            if (this.r == null) {
                                return;
                            }
                            if (expDate != null && !expDate.isEmpty()) {
                                try {
                                    i2 = Integer.parseInt(expDate);
                                } catch (NumberFormatException unused) {
                                }
                                String format = new SimpleDateFormat("MMMM d, yyyy").format(new Date(i2 * 1000));
                                this.r.setText(getResources().getString(a7.j.W1) + " " + format);
                                return;
                            }
                            textView = this.r;
                            str2 = getResources().getString(a7.j.W1) + " " + getResources().getString(a7.j.g8);
                        } else {
                            textView = this.r;
                            if (textView == null) {
                                return;
                            }
                            str2 = getResources().getString(a7.j.W1) + " " + getResources().getString(a7.j.g8);
                        }
                        textView.setText(str2);
                    }
                }
            } catch (Exception e2) {
                Log.e("honey", e2.getMessage());
            }
        }
    }

    public void m0(BillingCheckGPACallback billingCheckGPACallback) {
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2(boolean r15) {
        /*
            Method dump skipped, instructions count: 1061
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity.m2(boolean):void");
    }

    public void n(List list) {
        String str;
        String str2;
        if (list != null) {
            new h(this.B0, list).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        }
        if (this.B0 == null || (str = this.Y0) == null || str.isEmpty() || (str2 = this.Z0) == null || str2.isEmpty()) {
            return;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.N, "progress", new int[]{100, 50});
        ofInt.setDuration(500L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.start();
        new Handler().postDelayed(new r(), 500L);
    }

    public void n2() {
        Intent intent = new Intent(this, OpenVPNService.class);
        intent.setAction("de.blinkt.openvpn.START_SERVICE");
        bindService(intent, new p(), 1);
    }

    public void o2() {
        try {
            runOnUiThread(new t());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= 34) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
            return;
        }
        if (this.M0 + 2000 > System.currentTimeMillis()) {
            finishAffinity();
            finish();
        } else {
            try {
                Toast.makeText(getBaseContext(), getResources().getString(a7.j.F5), 0).show();
            } catch (Exception unused) {
            }
        }
        this.M0 = System.currentTimeMillis();
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0310, code lost:
    
        if ((java.lang.System.currentTimeMillis() - java.lang.Long.parseLong(r0.getTime())) > 60000) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x050c, code lost:
    
        if ((java.lang.System.currentTimeMillis() - java.lang.Long.parseLong(r0.getTime())) > 60000) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:534:0x0c8e, code lost:
    
        if ((java.lang.System.currentTimeMillis() - java.lang.Long.parseLong(r0.getTime())) > 60000) goto L516;
     */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x0d7b, code lost:
    
        if (r0.getStatus().equals("1") != false) goto L529;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r20) {
        /*
            Method dump skipped, instructions count: 5076
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity.onClick(android.view.View):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(64:0|1|(1:3)|4|(2:6|(1:8)(1:214))(2:215|(2:217|(1:219)(1:220))(2:221|(2:223|(1:225)(1:226))(2:227|(1:229)(1:230))))|9|10|(1:12)|13|(1:15)|16|(53:205|(2:207|(1:209))(2:210|(1:212)(1:213))|22|(2:200|201)|24|25|26|27|(1:196)(1:33)|34|(1:38)|39|(4:185|(3:187|(1:189)(1:194)|190)(1:195)|191|(1:193))(1:43)|44|(1:184)|48|(2:50|(1:52))|53|(1:55)(1:183)|56|57|(1:59)(3:178|(1:180)(1:182)|181)|60|(1:62)|63|(1:65)|66|(2:68|(1:70))(1:177)|71|(1:176)(1:77)|78|(1:80)|81|(3:83|(1:85)|86)(2:173|(1:175))|87|(1:89)(2:167|(1:169)(18:170|(1:172)|91|(1:93)|94|(5:96|(1:98)|99|(1:101)(1:165)|102)(1:166)|103|(1:105)(4:155|(3:157|(1:159)(1:161)|160)|162|(1:164))|106|(3:108|(4:110|(4:112|113|114|(3:122|123|(1:125)(1:116))(0))(3:132|133|134)|117|(1:119)(1:121))(1:137)|120)|138|(2:140|(1:142))|143|(1:145)|146|(1:148)|149|(2:151|152)(1:154)))|90|91|(0)|94|(0)(0)|103|(0)(0)|106|(0)|138|(0)|143|(0)|146|(0)|149|(0)(0))(1:20)|21|22|(0)|24|25|26|27|(2:29|196)(0)|34|(2:36|38)|39|(5:41|185|(0)(0)|191|(0))(0)|44|(2:46|184)(0)|48|(0)|53|(0)(0)|56|57|(0)(0)|60|(0)|63|(0)|66|(0)(0)|71|(2:73|176)(0)|78|(0)|81|(0)(0)|87|(0)(0)|90|91|(0)|94|(0)(0)|103|(0)(0)|106|(0)|138|(0)|143|(0)|146|(0)|149|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x04c6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x04c7, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x09c0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0a0e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0a87  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0ab4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0ac1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0af3  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0940  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x089e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x085c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x079e  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x049c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x07ed  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0802  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0898  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x08bc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x08d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r17) {
        /*
            Method dump skipped, instructions count: 2817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
        if (F2()) {
            G2();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01aa, code lost:
    
        if (com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getSelectedLanguage(r12.B0).equalsIgnoreCase("Arabic") != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0261, code lost:
    
        if (r12.Z.getVisibility() != 0) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0277, code lost:
    
        if (r12.k0.getVisibility() == 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0281, code lost:
    
        if (r12.S.getVisibility() == 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0298, code lost:
    
        if (r12.Z.getVisibility() != 0) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02ea, code lost:
    
        if (r12.S.getVisibility() == 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0302, code lost:
    
        if (r12.Z.getVisibility() == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x031a, code lost:
    
        if (r12.k0.getVisibility() == 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x033e, code lost:
    
        if (getCurrentFocus().getTag().equals("7") != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0454, code lost:
    
        if (getCurrentFocus().getTag().equals("3") != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0118, code lost:
    
        if (r12.Z.getVisibility() != 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0130, code lost:
    
        if (r12.S.getVisibility() == 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x013c, code lost:
    
        if (r12.k0.getVisibility() == 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0155, code lost:
    
        if (r12.Z.getVisibility() != 0) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02d1 A[PHI: r13
      0x02d1: PHI (r13v67 android.widget.Button) = (r13v64 android.widget.Button), (r13v66 android.widget.Button), (r13v93 android.widget.Button) binds: [B:188:0x0353, B:186:0x034e, B:162:0x02cf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0376 A[PHI: r13
      0x0376: PHI (r13v6 android.widget.Button) = (r13v3 android.widget.Button), (r13v5 android.widget.Button), (r13v61 android.widget.Button) binds: [B:248:0x0488, B:246:0x0482, B:198:0x0374] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062 A[PHI: r13
      0x0062: PHI (r13v173 android.widget.Button) = (r13v170 android.widget.Button), (r13v172 android.widget.Button), (r13v231 android.widget.Button) binds: [B:85:0x016a, B:83:0x0164, B:30:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018d A[PHI: r13
      0x018d: PHI (r13v100 android.widget.Button) = (r13v97 android.widget.Button), (r13v99 android.widget.Button), (r13v164 android.widget.Button) binds: [B:152:0x02ae, B:150:0x02a8, B:95:0x018b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 1178
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public void onPause() {
        m7.w.m(this.B0);
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Handler handler = this.L1;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            Handler handler2 = this.M1;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages((Object) null);
            }
            Handler handler3 = this.K1;
            if (handler3 != null) {
                handler3.removeCallbacksAndMessages((Object) null);
            }
            Thread thread = this.k1;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.k1.interrupt();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.e*/.onRequestPermissionsResult(i2, strArr, iArr);
        if (iArr.length <= 0 || iArr[0] != 0) {
            return;
        }
        Log.v("TAG", "Permission: " + strArr[0] + "was " + iArr[0]);
        if (Build.VERSION.SDK_INT >= 33) {
            return;
        }
        new x(this, "IPTVSmartersPro.apk").execute(new String[]{this.X1});
    }

    public void onResume() {
        ImageView imageView;
        try {
            this.e0.setSelected(true);
            this.l0.setSelected(true);
            this.T.setSelected(true);
            z2();
            if (this.L1 == null) {
                this.L1 = new Handler();
            }
            if (this.M1 == null) {
                this.M1 = new Handler();
            }
            if (this.K1 == null) {
                this.K1 = new Handler();
            }
            if (m7.a.o.booleanValue()) {
                k2();
            } else {
                this.v0.setVisibility(8);
            }
            m7.w.m(this.B0);
            m7.w.z0(this.B0);
            this.U0 = new ArrayList();
            if (!this.a1) {
                if (m7.a.V0.booleanValue()) {
                    a3(false);
                }
                if (!this.b1 && !this.c1 && !this.d1) {
                    m2(false);
                }
                J7.a aVar = new J7.a(this.B0);
                this.V0 = aVar;
                try {
                    this.U0 = aVar.j();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                ArrayList arrayList = this.U0;
                if (arrayList == null || arrayList.size() <= 0) {
                    imageView = this.M;
                } else if (G.g() == null) {
                    imageView = this.M;
                } else {
                    this.M.setVisibility(0);
                    u1();
                }
                imageView.setVisibility(8);
            }
            this.a1 = false;
            VodAllCategoriesSingleton.getInstance().setVodList((ArrayList) null);
            EpisodesUsingSinglton.getInstance().setEpisodeList((List) null);
            overridePendingTransition(a7.b.f, a7.b.d);
            Thread thread = this.k1;
            if (thread == null || !thread.isAlive()) {
                Thread thread2 = new Thread(new v());
                this.k1 = thread2;
                thread2.start();
            }
            SharepreferenceDBHandler.getSelectedLanguage(this.B0).equalsIgnoreCase("Arabic");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        super/*androidx.fragment.app.e*/.onResume();
    }

    public void onStart() {
        super.onStart();
        new IntentFilter("notification");
    }

    public void onStop() {
        Runnable runnable;
        Runnable runnable2;
        Runnable runnable3;
        super.onStop();
        Handler handler = this.L1;
        if (handler != null && (runnable3 = this.P1) != null) {
            handler.removeCallbacks(runnable3);
        }
        Handler handler2 = this.M1;
        if (handler2 != null && (runnable2 = this.O1) != null) {
            handler2.removeCallbacks(runnable2);
        }
        Handler handler3 = this.K1;
        if (handler3 == null || (runnable = this.N1) == null) {
            return;
        }
        handler3.removeCallbacks(runnable);
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        z2();
    }

    public void p0(String str) {
        I2();
    }

    public int p2() {
        Context context = this.B0;
        if (context == null) {
            return 0;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", 0);
        this.C0 = sharedPreferences;
        return sharedPreferences.getInt("avatar_post", 0);
    }

    public void q0(BillingAddOrderCallback billingAddOrderCallback) {
    }

    public final void q2(String str) {
        String str2 = this.Y0;
        if (str2 == null || this.Z0 == null || str2.isEmpty() || this.Z0.isEmpty() || this.Y0.equals("") || this.Z0.equals("")) {
            return;
        }
        this.O.setVisibility(8);
        this.P.setVisibility(0);
        this.Q.setText(str);
        this.X0.b(this.Y0, this.Z0);
    }

    public final void s2() {
        Context context = this.B0;
        if (context != null) {
            this.T0 = new n7.d(this, context);
            SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
            sharedPreferences.edit();
            String string = sharedPreferences.getString("username", "");
            String string2 = sharedPreferences.getString("password", "");
            try {
                if (this.T0 == null || string == null || string.isEmpty() || string.equals("") || string2 == null || string2.isEmpty() || string2.equals("")) {
                    return;
                }
                this.T0.g(string, string2);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void t2(String str) {
        String str2 = this.Y0;
        if (str2 == null || this.Z0 == null || str2.isEmpty() || this.Z0.isEmpty() || this.Y0.equals("") || this.Z0.equals("")) {
            return;
        }
        this.V.setVisibility(8);
        this.W.setVisibility(0);
        this.X.setText(str);
        this.X0.f(this.Y0, this.Z0);
    }

    public final void u1() {
        this.M.setOnClickListener(new n());
        new Handler().postDelayed(new o(), 100L);
    }

    public boolean u2() {
        ConstraintLayout constraintLayout = this.v1;
        return constraintLayout != null && constraintLayout.getVisibility() == 0;
    }

    public final void v1() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClass(this.B0, LaunchVPN.class);
        intent.putExtra("de.blinkt.openvpn.shortcutProfileUUID", G.g());
        intent.setFlags(268435456);
        intent.putExtra("de.blinkt.openvpn.showNoLogWindow", true);
        this.B0.startActivity(intent);
    }

    public final void v2(String str) {
        String str2 = this.Y0;
        if (str2 == null || this.Z0 == null || str2.isEmpty() || this.Z0.isEmpty() || this.Y0.equals("") || this.Z0.equals("")) {
            return;
        }
        this.g0.setVisibility(8);
        this.h0.setVisibility(0);
        this.i0.setText(str);
        this.X0.e(this.Y0, this.Z0);
    }

    public void w0(ArrayList arrayList, String str) {
    }

    public void w1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.i1 = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public final void x2() {
        if (this.b1 || this.c1 || this.d1) {
            return;
        }
        y2();
    }

    public void y(LoginCallback loginCallback, String str, ArrayList arrayList) {
    }

    public void y2() {
        try {
            ProgressDialog progressDialog = this.e1;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.e1.dismiss();
        } catch (Exception unused) {
        }
    }

    public void z(JsonElement jsonElement) {
    }

    public void z2() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
