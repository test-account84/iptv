package com.nst.iptvsmarterstvbox.view.ijkplayer.activities;

import a7.f;
import a7.g;
import a7.j;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEPG;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.preference.IjkListPreference;
import com.squareup.picasso.t;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import m7.w;
import org.joda.time.LocalDateTime;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import w7.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerEPGActivity extends androidx.appcompat.app.b implements SurfaceHolder.Callback, View.OnClickListener {
    public static String A2 = null;
    public static boolean B2 = false;
    public static ProgressBar C2;
    public static SharedPreferences x2;
    public static SharedPreferences y2;
    public static String z2;
    public TextView A0;
    public TextView A1;
    public RelativeLayout B;
    public TextView B0;
    public TextView B1;
    public ArrayList C;
    public Handler C0;
    public TextView C1;
    public ArrayList D;
    public Handler D0;
    public FrameLayout D1;
    public Handler E0;
    public SeekBar E1;
    public Handler F0;
    public SeekBar F1;
    public SharedPreferences.Editor G0;
    public LinearLayout G1;
    public LiveStreamDBHandler H;
    public SharedPreferences.Editor H0;
    public LinearLayout H1;
    public SharedPreferences I;
    public SharedPreferences.Editor I0;
    public LinearLayout I1;
    public SharedPreferences J;
    public LinearLayout J1;
    public SharedPreferences K;
    public LinearLayout K1;
    public SharedPreferences L;
    public LinearLayout L0;
    public LinearLayout L1;
    public SharedPreferences M;
    public TextView M0;
    public LinearLayout M1;
    public SharedPreferences N;
    public LinearLayout N1;
    public SharedPreferences O;
    public Boolean O0;
    public LinearLayout O1;
    public SimpleDateFormat P;
    public Menu P0;
    public LinearLayout P1;
    public String Q;
    public DateFormat Q0;
    public LinearLayout Q1;
    public String R;
    public String R0;
    public LinearLayout R1;
    public NSTIJKPlayerEPG S0;
    public LinearLayout S1;
    public ArrayList T;
    public String T0;
    public LinearLayout T1;
    public ArrayList U;
    public Boolean U0;
    public LinearLayout U1;
    public ArrayList V;
    public String V0;
    public RelativeLayout V1;
    public ArrayList W;
    public int W0;
    public RelativeLayout W1;
    public ArrayList X;
    public String X0;
    public ImageView X1;
    public ArrayList Y;
    public SharedPreferences Y0;
    public ImageView Y1;
    public ArrayList Z;
    public String Z0;
    public ImageView Z1;
    public String a1;
    public ImageView a2;
    public String b1;
    public ImageView b2;
    public Long c1;
    public ImageView c2;
    public String d1;
    public ImageView d2;
    public String e;
    public ArrayList e0;
    public String e1;
    public ImageView e2;
    public View f;
    public ArrayList f0;
    public Boolean f1;
    public ImageView f2;
    public View g;
    public ArrayList g0;
    public SharedPreferences g1;
    public ImageView g2;
    public ImageView h;
    public ArrayList h0;
    public Date h1;
    public ImageView h2;
    public View i;
    public Boolean i1;
    public Animation i2;
    public ImageView j;
    public ArrayList j0;
    public Boolean j1;
    public Animation j2;
    public View k;
    public ArrayList k0;
    public Boolean k1;
    public Animation k2;
    public ProgressBar l0;
    public Boolean l1;
    public Animation l2;
    public LinearLayout m;
    public TextView m0;
    public Boolean m1;
    public Animation m2;
    public TextView n;
    public TextView n0;
    public Boolean n1;
    public Animation n2;
    public TextView o;
    public u7.a o1;
    public Animation o2;
    public SeekBar p;
    public Handler p1;
    public Animation p2;
    public ImageView q;
    public t2.a q1;
    public Animation q2;
    public TextView r;
    public SimpleDateFormat r1;
    public String r2;
    public TextView s;
    public String s0;
    public String s1;
    public String s2;
    public TextView t;
    public RadioGroup t1;
    public String t2;
    public TextView u;
    public RadioGroup u1;
    public int u2;
    public LinearLayout v;
    public RadioGroup v1;
    public Animation v2;
    public ProgressBar w;
    public int w0;
    public TextView w1;
    public Animation w2;
    public ProgressBar x;
    public DatabaseHandler x0;
    public TextView x1;
    public SharedPreferences.Editor y0;
    public TextView y1;
    public SharedPreferences.Editor z0;
    public TextView z1;
    public Context d = this;
    public boolean l = false;
    public boolean y = true;
    public boolean z = false;
    public boolean A = false;
    public boolean E = true;
    public long F = 2500;
    public boolean G = true;
    public int S = 0;
    public ArrayList i0 = new ArrayList();
    public boolean o0 = true;
    public boolean p0 = false;
    public boolean q0 = false;
    public boolean r0 = false;
    public boolean t0 = true;
    public String u0 = "";
    public String v0 = "";
    public int J0 = 0;
    public StringBuilder K0 = new StringBuilder();
    public int N0 = -1;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;

        public a(String str, String str2) {
            this.a = str;
            this.c = str2;
        }

        public void run() {
            NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity = NSTIJKPlayerEPGActivity.this;
            nSTIJKPlayerEPGActivity.Z0 = this.a;
            nSTIJKPlayerEPGActivity.a1 = this.c;
            NSTIJKPlayerEPGActivity.u1(nSTIJKPlayerEPGActivity).setCurrentEpgChannelID(NSTIJKPlayerEPGActivity.this.Z0);
            NSTIJKPlayerEPGActivity.u1(NSTIJKPlayerEPGActivity.this).setCurrentChannelLogo(NSTIJKPlayerEPGActivity.this.a1);
            NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity2 = NSTIJKPlayerEPGActivity.this;
            nSTIJKPlayerEPGActivity2.k2(nSTIJKPlayerEPGActivity2.Z0, nSTIJKPlayerEPGActivity2.a1);
        }
    }

    public class b implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NSTIJKPlayerEPGActivity.this.M0.setText("");
                NSTIJKPlayerEPGActivity.this.L0.setVisibility(8);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                NSTIJKPlayerEPGActivity.this.M0.setText("");
                NSTIJKPlayerEPGActivity.this.L0.setVisibility(8);
            }
        }

        public b() {
        }

        public void run() {
            Handler handler;
            Runnable bVar;
            boolean z;
            NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity = NSTIJKPlayerEPGActivity.this;
            nSTIJKPlayerEPGActivity.s0 = nSTIJKPlayerEPGActivity.K0.toString();
            NSTIJKPlayerEPGActivity.this.M0.setText("");
            NSTIJKPlayerEPGActivity.this.L0.setVisibility(8);
            NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity2 = NSTIJKPlayerEPGActivity.this;
            ArrayList channelDetails = nSTIJKPlayerEPGActivity2.H.getChannelDetails(nSTIJKPlayerEPGActivity2.s0, "live");
            NSTIJKPlayerEPGActivity.this.K0.setLength(0);
            if (channelDetails == null || channelDetails.size() == 0) {
                NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity3 = NSTIJKPlayerEPGActivity.this;
                nSTIJKPlayerEPGActivity3.M0.setText(nSTIJKPlayerEPGActivity3.d.getResources().getString(j.g4));
                NSTIJKPlayerEPGActivity.this.L0.setVisibility(0);
                handler = new Handler();
                bVar = new b();
            } else {
                NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity4 = NSTIJKPlayerEPGActivity.this;
                if (nSTIJKPlayerEPGActivity4.H.getParentalStatusCount(SharepreferenceDBHandler.getUserID(nSTIJKPlayerEPGActivity4.d)) <= 0 || NSTIJKPlayerEPGActivity.v1(NSTIJKPlayerEPGActivity.this) == null) {
                    z = false;
                } else {
                    NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity5 = NSTIJKPlayerEPGActivity.this;
                    z = NSTIJKPlayerEPGActivity.x1(nSTIJKPlayerEPGActivity5, channelDetails, NSTIJKPlayerEPGActivity.v1(nSTIJKPlayerEPGActivity5));
                }
                if (!z) {
                    NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity6 = NSTIJKPlayerEPGActivity.this;
                    nSTIJKPlayerEPGActivity6.q0 = true;
                    nSTIJKPlayerEPGActivity6.r0 = true;
                    nSTIJKPlayerEPGActivity6.u0 = "0";
                    String streamId = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamId();
                    String name = ((LiveStreamsDBModel) channelDetails.get(0)).getName();
                    String epgChannelId = ((LiveStreamsDBModel) channelDetails.get(0)).getEpgChannelId();
                    String streamIcon = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIcon();
                    String url = ((LiveStreamsDBModel) channelDetails.get(0)).getUrl();
                    NSTIJKPlayerEPGActivity.u1(NSTIJKPlayerEPGActivity.this).setTitle(NSTIJKPlayerEPGActivity.this.s0 + " - " + name);
                    NSTIJKPlayerEPGActivity.u1(NSTIJKPlayerEPGActivity.this).s1();
                    if (NSTIJKPlayerEPGActivity.y1(NSTIJKPlayerEPGActivity.this).equals("m3u")) {
                        NSTIJKPlayerEPGActivity.u1(NSTIJKPlayerEPGActivity.this).w1(Uri.parse(url), NSTIJKPlayerEPGActivity.this.p0, name);
                    } else {
                        NSTIJKPlayerEPGActivity.u1(NSTIJKPlayerEPGActivity.this).w1(Uri.parse(NSTIJKPlayerEPGActivity.this.e + w.q0(streamId) + NSTIJKPlayerEPGActivity.this.Q), NSTIJKPlayerEPGActivity.this.p0, name);
                    }
                    NSTIJKPlayerEPGActivity.u1(NSTIJKPlayerEPGActivity.this).H = 0;
                    NSTIJKPlayerEPGActivity.u1(NSTIJKPlayerEPGActivity.this).J = false;
                    NSTIJKPlayerEPGActivity.u1(NSTIJKPlayerEPGActivity.this).start();
                    NSTIJKPlayerEPGActivity.this.E0.removeCallbacksAndMessages((Object) null);
                    NSTIJKPlayerEPGActivity.z1(NSTIJKPlayerEPGActivity.this);
                    NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity7 = NSTIJKPlayerEPGActivity.this;
                    nSTIJKPlayerEPGActivity7.Z0 = epgChannelId;
                    nSTIJKPlayerEPGActivity7.a1 = streamIcon;
                    NSTIJKPlayerEPGActivity.u1(nSTIJKPlayerEPGActivity7).setCurrentEpgChannelID(NSTIJKPlayerEPGActivity.this.Z0);
                    NSTIJKPlayerEPGActivity.u1(NSTIJKPlayerEPGActivity.this).setCurrentChannelLogo(NSTIJKPlayerEPGActivity.this.a1);
                    NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity8 = NSTIJKPlayerEPGActivity.this;
                    nSTIJKPlayerEPGActivity8.k2(nSTIJKPlayerEPGActivity8.Z0, nSTIJKPlayerEPGActivity8.a1);
                    NSTIJKPlayerEPGActivity.this.w0 = w.q0(streamId);
                    if (NSTIJKPlayerEPGActivity.A1(NSTIJKPlayerEPGActivity.this) != null) {
                        NSTIJKPlayerEPGActivity.A1(NSTIJKPlayerEPGActivity.this).putString("currentlyPlayingVideo", streamId);
                        NSTIJKPlayerEPGActivity.A1(NSTIJKPlayerEPGActivity.this).apply();
                    }
                    channelDetails.clear();
                    return;
                }
                NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity9 = NSTIJKPlayerEPGActivity.this;
                nSTIJKPlayerEPGActivity9.M0.setText(nSTIJKPlayerEPGActivity9.d.getResources().getString(j.g4));
                NSTIJKPlayerEPGActivity.this.L0.setVisibility(0);
                handler = new Handler();
                bVar = new a();
            }
            handler.postDelayed(bVar, 1000L);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            NSTIJKPlayerEPGActivity.this.X1();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            NSTIJKPlayerEPGActivity.w1(NSTIJKPlayerEPGActivity.this);
        }
    }

    public class e implements View.OnFocusChangeListener {
        public final View a;

        public e(View view) {
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
            LinearLayout D1;
            View view5;
            View view6;
            View view7;
            LinearLayout D12;
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
                                view.setBackground(NSTIJKPlayerEPGActivity.this.getResources().getDrawable(a7.e.Q0));
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
                                    return;
                                }
                                view.setBackground(NSTIJKPlayerEPGActivity.this.getResources().getDrawable(a7.e.P0));
                                b(f);
                                c(f);
                                D12 = NSTIJKPlayerEPGActivity.D1(NSTIJKPlayerEPGActivity.this);
                            }
                        }
                        view.setBackground(NSTIJKPlayerEPGActivity.this.getResources().getDrawable(a7.e.P0));
                        b(f);
                        c(f);
                        return;
                    }
                    view.setBackground(NSTIJKPlayerEPGActivity.this.getResources().getDrawable(a7.e.P0));
                    b(f);
                    c(f);
                    D12 = NSTIJKPlayerEPGActivity.C1(NSTIJKPlayerEPGActivity.this);
                } else {
                    view.setBackground(NSTIJKPlayerEPGActivity.this.getResources().getDrawable(a7.e.P0));
                    b(f);
                    c(f);
                    D12 = NSTIJKPlayerEPGActivity.B1(NSTIJKPlayerEPGActivity.this);
                }
                D12.setVisibility(0);
                return;
            }
            if (z) {
                return;
            }
            f = z ? 1.08f : 1.0f;
            View view15 = this.a;
            if (view15 == null || view15.getTag() == null || !this.a.getTag().equals("1")) {
                View view16 = this.a;
                if (view16 == null || view16.getTag() == null || !this.a.getTag().equals("2")) {
                    View view17 = this.a;
                    if (view17 == null || view17.getTag() == null || !this.a.getTag().equals("3")) {
                        View view18 = this.a;
                        if ((view18 != null && view18.getTag() != null && this.a.getTag().equals("4")) || (((view2 = this.a) != null && view2.getTag() != null && this.a.getTag().equals("5")) || (((view3 = this.a) != null && view3.getTag() != null && this.a.getTag().equals("6")) || ((view4 = this.a) != null && view4.getTag() != null && this.a.getTag().equals("7"))))) {
                            view.setBackground((Drawable) null);
                            return;
                        }
                        View view19 = this.a;
                        if (view19 != null && view19.getTag() != null && this.a.getTag().equals("8")) {
                            return;
                        }
                        View view20 = this.a;
                        if (view20 == null || view20.getTag() == null || !this.a.getTag().equals("9")) {
                            View view21 = this.a;
                            if (view21 == null || view21.getTag() == null || !this.a.getTag().equals("10")) {
                                return;
                            }
                            view.setBackground(NSTIJKPlayerEPGActivity.this.getResources().getDrawable(a7.e.N0));
                            b(f);
                            c(f);
                            a(z);
                            D1 = NSTIJKPlayerEPGActivity.D1(NSTIJKPlayerEPGActivity.this);
                        }
                    }
                    view.setBackground(NSTIJKPlayerEPGActivity.this.getResources().getDrawable(a7.e.N0));
                    b(f);
                    c(f);
                    a(z);
                    return;
                }
                view.setBackground(NSTIJKPlayerEPGActivity.this.getResources().getDrawable(a7.e.N0));
                b(f);
                c(f);
                a(z);
                D1 = NSTIJKPlayerEPGActivity.C1(NSTIJKPlayerEPGActivity.this);
            } else {
                view.setBackground(NSTIJKPlayerEPGActivity.this.getResources().getDrawable(a7.e.N0));
                b(f);
                c(f);
                a(z);
                D1 = NSTIJKPlayerEPGActivity.B1(NSTIJKPlayerEPGActivity.this);
            }
            D1.setVisibility(8);
        }
    }

    public NSTIJKPlayerEPGActivity() {
        Boolean bool = Boolean.FALSE;
        this.O0 = bool;
        this.R0 = "";
        this.U0 = bool;
        this.V0 = "";
        this.W0 = 0;
        this.f1 = Boolean.TRUE;
        this.i1 = bool;
        this.j1 = bool;
        this.k1 = bool;
        this.l1 = bool;
        this.m1 = bool;
        this.n1 = bool;
        this.r2 = "mobile";
        this.s2 = "0";
        this.t2 = "0";
        this.u2 = 0;
    }

    public static /* synthetic */ SharedPreferences.Editor A1(NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity) {
        return nSTIJKPlayerEPGActivity.y0;
    }

    public static /* synthetic */ LinearLayout B1(NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity) {
        return nSTIJKPlayerEPGActivity.M1;
    }

    public static /* synthetic */ LinearLayout C1(NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity) {
        return nSTIJKPlayerEPGActivity.O1;
    }

    public static /* synthetic */ LinearLayout D1(NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity) {
        return nSTIJKPlayerEPGActivity.P1;
    }

    private void H1(int i) {
        if (B2) {
            return;
        }
        this.S0.a1 = new d();
        NSTIJKPlayerEPG nSTIJKPlayerEPG = this.S0;
        nSTIJKPlayerEPG.Z0.postDelayed(nSTIJKPlayerEPG.a1, i);
    }

    public static boolean J1() {
        ProgressBar progressBar = C2;
        return progressBar != null && progressBar.getVisibility() == 0;
    }

    public static long K1(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private void L1() {
        ImageView imageView = this.Z1;
        imageView.setOnFocusChangeListener(new e(imageView));
        ImageView imageView2 = this.a2;
        imageView2.setOnFocusChangeListener(new e(imageView2));
        ImageView imageView3 = this.f2;
        imageView3.setOnFocusChangeListener(new e(imageView3));
        ImageView imageView4 = this.g2;
        imageView4.setOnFocusChangeListener(new e(imageView4));
        ImageView imageView5 = this.h2;
        imageView5.setOnFocusChangeListener(new e(imageView5));
        LinearLayout linearLayout = this.R1;
        linearLayout.setOnFocusChangeListener(new e(linearLayout));
        LinearLayout linearLayout2 = this.U1;
        linearLayout2.setOnFocusChangeListener(new e(linearLayout2));
        LinearLayout linearLayout3 = this.Q1;
        linearLayout3.setOnFocusChangeListener(new e(linearLayout3));
        ImageView imageView6 = this.d2;
        imageView6.setOnFocusChangeListener(new e(imageView6));
        ImageView imageView7 = this.e2;
        imageView7.setOnFocusChangeListener(new e(imageView7));
        ImageView imageView8 = this.X1;
        imageView8.setOnFocusChangeListener(new e(imageView8));
        ImageView imageView9 = this.X1;
        imageView9.setOnFocusChangeListener(new e(imageView9));
    }

    public static String N1(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    private ArrayList Q1() {
        ArrayList allPasswordStatus = this.H.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.d));
        this.k0 = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.i0.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.i0;
    }

    private boolean U1(ArrayList arrayList, ArrayList arrayList2) {
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
    }

    private void V1() {
        this.w.setProgress(0);
        this.r.setText(this.d.getResources().getString(j.N4));
        this.s.setText("");
        this.t.setText(this.d.getResources().getString(j.c4));
        this.u.setText("");
    }

    private void W1() {
        if (this.L1.getVisibility() == 0) {
            this.L1.startAnimation(this.o2);
            if (this.G1.getVisibility() == 0) {
                this.G1.startAnimation(this.o2);
            }
            if (this.I1.getVisibility() == 0) {
                this.I1.startAnimation(this.o2);
            }
            if (this.H1.getVisibility() == 0) {
                this.H1.startAnimation(this.o2);
            }
            this.L1.setVisibility(8);
            if (this.G1.getVisibility() == 0) {
                this.G1.setVisibility(8);
            }
            if (this.I1.getVisibility() == 0) {
                this.I1.setVisibility(8);
            }
            if (this.H1.getVisibility() == 0) {
                this.H1.setVisibility(8);
            }
        }
    }

    private void Y1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    private void a2() {
        this.w.setProgress(0);
        this.r.setText(this.d.getResources().getString(j.M4));
        this.s.setText("");
        this.t.setText(this.d.getResources().getString(j.b4));
        this.u.setText("");
    }

    private void c2() {
        this.Z1.setOnClickListener(this);
        this.a2.setOnClickListener(this);
        this.N1.setOnClickListener(this);
        this.f2.setOnClickListener(this);
        this.T1.setOnClickListener(this);
        this.g2.setOnClickListener(this);
        this.R1.setOnClickListener(this);
        this.U1.setOnClickListener(this);
        this.Q1.setOnClickListener(this);
        this.d2.setOnClickListener(this);
        this.e2.setOnClickListener(this);
        this.J1.setOnClickListener(this);
        this.Y1.setOnClickListener(this);
        this.h2.setOnClickListener(this);
    }

    private void e2() {
        try {
            NSTIJKPlayerEPG nSTIJKPlayerEPG = this.S0;
            if (nSTIJKPlayerEPG != null) {
                if (nSTIJKPlayerEPG.n1()) {
                    this.S0.g1();
                } else {
                    this.S0.E1();
                    this.S0.q1(true);
                    this.S0.B1();
                }
                IjkMediaPlayer.native_profileEnd();
            }
        } catch (Exception unused) {
        }
    }

    private void h2() {
        if (this.V1.getVisibility() == 8) {
            this.V1.startAnimation(this.p2);
            this.V1.setVisibility(0);
            this.e2.requestFocus();
        }
    }

    private void j2() {
        i2();
        if (this.L1.getVisibility() == 0) {
            W1();
        } else {
            f2();
            H1(5000);
        }
    }

    public static /* synthetic */ NSTIJKPlayerEPG u1(NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity) {
        return nSTIJKPlayerEPGActivity.S0;
    }

    public static /* synthetic */ ArrayList v1(NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity) {
        return nSTIJKPlayerEPGActivity.i0;
    }

    public static /* synthetic */ void w1(NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity) {
        nSTIJKPlayerEPGActivity.W1();
    }

    public static /* synthetic */ boolean x1(NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity, ArrayList arrayList, ArrayList arrayList2) {
        return nSTIJKPlayerEPGActivity.U1(arrayList, arrayList2);
    }

    public static /* synthetic */ String y1(NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity) {
        return nSTIJKPlayerEPGActivity.R;
    }

    public static /* synthetic */ void z1(NSTIJKPlayerEPGActivity nSTIJKPlayerEPGActivity) {
        nSTIJKPlayerEPGActivity.a2();
    }

    public void E1() {
        int parentalStatusCount = this.H.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.d));
        ArrayList allLiveStreasWithSkyId = this.H.getAllLiveStreasWithSkyId("0", "live");
        this.C = allLiveStreasWithSkyId;
        if (parentalStatusCount <= 0 || allLiveStreasWithSkyId == null) {
            this.Z = allLiveStreasWithSkyId;
            return;
        }
        ArrayList arrayList = this.i0;
        if (arrayList != null) {
            this.Y = T1(allLiveStreasWithSkyId, arrayList);
        }
        this.Z = this.Y;
    }

    public void F1(String str) {
        LiveStreamDBHandler liveStreamDBHandler = this.H;
        if (liveStreamDBHandler != null) {
            this.f0 = liveStreamDBHandler.getAllLiveStreasWithSkyId(str, "live");
        }
        this.Z = this.f0;
    }

    public void G1() {
        this.D = new ArrayList();
        O1();
        this.Z = this.D;
    }

    public void I1(int i) {
        if (B2) {
            return;
        }
        this.S0.a1 = new c();
        NSTIJKPlayerEPG nSTIJKPlayerEPG = this.S0;
        nSTIJKPlayerEPG.Z0.postDelayed(nSTIJKPlayerEPG.a1, i);
    }

    public void M1() {
        if (this.S0 != null) {
            Y1();
        }
        NSTIJKPlayerEPG nSTIJKPlayerEPG = this.S0;
        ((nSTIJKPlayerEPG == null || !nSTIJKPlayerEPG.isPlaying()) ? this.f : this.g).requestFocus();
    }

    public void O1() {
        ArrayList arrayList;
        if (this.R.equals("m3u")) {
            LiveStreamDBHandler liveStreamDBHandler = this.H;
            if (liveStreamDBHandler == null) {
                return;
            }
            ArrayList favouriteM3U = liveStreamDBHandler.getFavouriteM3U("live");
            arrayList = new ArrayList();
            Iterator it = favouriteM3U.iterator();
            while (it.hasNext()) {
                FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                ArrayList m3UFavouriteRow = this.H.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
                if (m3UFavouriteRow != null && m3UFavouriteRow.size() > 0) {
                    arrayList.add((LiveStreamsDBModel) m3UFavouriteRow.get(0));
                }
            }
            if (arrayList.size() == 0) {
                return;
            }
        } else {
            DatabaseHandler databaseHandler = this.x0;
            if (databaseHandler == null) {
                return;
            }
            ArrayList allFavourites = databaseHandler.getAllFavourites("live", SharepreferenceDBHandler.getUserID(this.d));
            arrayList = new ArrayList();
            Iterator it2 = allFavourites.iterator();
            while (it2.hasNext()) {
                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it2.next();
                LiveStreamsDBModel liveStreamFavouriteRow = new LiveStreamDBHandler(this.d).getLiveStreamFavouriteRow(favouriteDBModel.getCategoryID(), String.valueOf(favouriteDBModel.getStreamID()), favouriteDBModel.getTimestamp(), "");
                if (liveStreamFavouriteRow != null) {
                    arrayList.add(liveStreamFavouriteRow);
                }
            }
            if (arrayList.size() == 0) {
                return;
            }
        }
        this.D = arrayList;
    }

    public int P1(ArrayList arrayList, int i) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (w.r0(((LiveStreamsDBModel) arrayList.get(i2)).getNum()) == i) {
                return i2;
            }
        }
        return 0;
    }

    public int R1(long j, long j2, Context context) {
        if (context != null) {
            long millis = LocalDateTime.now().toDateTime().getMillis();
            Long l = this.c1;
            if (l != null) {
                millis += l.longValue();
            }
            if (j < j2 && millis < j2) {
                if (millis <= j) {
                    return 100;
                }
                return (int) (((j2 - millis) * 100) / (j2 - j));
            }
        }
        return 0;
    }

    public long S1(Context context) {
        if (context == null) {
            return 0L;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", 0);
        y2 = sharedPreferences;
        if (sharedPreferences != null) {
            return w.J(sharedPreferences.getString("selectedEPGShift", m7.a.C0));
        }
        return 0L;
    }

    public final ArrayList T1(ArrayList arrayList, ArrayList arrayList2) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    this.X.add(liveStreamsDBModel);
                    break;
                }
                if (liveStreamsDBModel.getCategoryId().equals((String) it2.next())) {
                    break;
                }
            }
        }
        return this.X;
    }

    public void X1() {
        if (B2 || this.L1.getVisibility() != 0) {
            return;
        }
        this.L1.startAnimation(this.o2);
        if (this.G1.getVisibility() == 0) {
            this.G1.startAnimation(this.o2);
        }
        if (this.I1.getVisibility() == 0) {
            this.I1.startAnimation(this.o2);
        }
        if (this.H1.getVisibility() == 0) {
            this.H1.startAnimation(this.o2);
        }
        this.L1.setVisibility(8);
        if (this.G1.getVisibility() == 0) {
            this.G1.setVisibility(8);
        }
        if (this.I1.getVisibility() == 0) {
            this.I1.setVisibility(8);
        }
        if (this.H1.getVisibility() == 0) {
            this.H1.setVisibility(8);
        }
    }

    public boolean Z1(long j, long j2, Context context) {
        if (context != null) {
            long millis = LocalDateTime.now().toDateTime().getMillis();
            Long l = this.c1;
            if (l != null) {
                millis += l.longValue();
            }
            if (j <= millis && j2 >= millis) {
                return true;
            }
        }
        return false;
    }

    public void b2() {
        this.m.setVisibility(0);
        this.n.setText(this.d.getResources().getString(j.g4));
        if (m7.a.B.booleanValue()) {
            findViewById(f.Sm).setVisibility(8);
        }
    }

    public final void d2(ArrayList arrayList, int i) {
        NSTIJKPlayerEPG nSTIJKPlayerEPG;
        Uri parse;
        String str;
        String str2;
        if (arrayList == null || arrayList.size() <= 0 || this.J0 >= arrayList.size()) {
            return;
        }
        if (this.J0 == 0) {
            this.J0 = P1(arrayList, i);
        }
        String name = ((LiveStreamsDBModel) arrayList.get(this.J0)).getName();
        String num = ((LiveStreamsDBModel) arrayList.get(this.J0)).getNum();
        int q0 = w.q0(((LiveStreamsDBModel) arrayList.get(this.J0)).getStreamId());
        String url = ((LiveStreamsDBModel) arrayList.get(this.J0)).getUrl();
        String S0 = w.S0(k.a() + k.i());
        String epgChannelId = ((LiveStreamsDBModel) arrayList.get(this.J0)).getEpgChannelId();
        String streamIcon = ((LiveStreamsDBModel) arrayList.get(this.J0)).getStreamIcon();
        try {
            if (streamIcon.equals("") || streamIcon.isEmpty()) {
                this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
            } else {
                t.q(this.d).l(streamIcon).j(a7.e.i1).d(a7.e.i1).g(this.q);
            }
        } catch (Exception unused) {
            this.q.setImageDrawable(this.d.getResources().getDrawable(a7.e.i1));
        }
        SharedPreferences.Editor editor = this.y0;
        if (editor != null) {
            editor.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) arrayList.get(this.J0)).getStreamId()));
            this.y0.putString("LOGIN_PREF_CURRENTLY_PLAYING_VIDEO_M3U", String.valueOf(((LiveStreamsDBModel) arrayList.get(this.J0)).getUrl()));
            this.y0.apply();
        }
        SharedPreferences.Editor editor2 = this.z0;
        if (editor2 != null) {
            editor2.putInt("currentlyPlayingVideoPosition", this.J0);
            this.z0.apply();
        }
        this.w0 = q0;
        this.S0.setTitle(num + " - " + name);
        this.S0.setCurrentWindowIndex(this.J0);
        SimpleDateFormat simpleDateFormat = this.r1;
        if (K1(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.d))), this.Q0.format(this.h1)) >= w7.c.p() && (str = this.T0) != null && this.X0 != null && (!A2.equals(str) || (this.T0 != null && (str2 = this.X0) != null && !z2.equals(str2)))) {
            this.f1 = Boolean.FALSE;
            this.q1.b(f.G).e();
            this.q1.b(f.K).c(S0 + this.e1 + this.b1);
        }
        try {
            if (this.f1.booleanValue()) {
                if (this.R.equals("m3u")) {
                    nSTIJKPlayerEPG = this.S0;
                    parse = Uri.parse(url);
                } else {
                    nSTIJKPlayerEPG = this.S0;
                    parse = Uri.parse(this.e + q0 + this.Q);
                }
                nSTIJKPlayerEPG.w1(parse, this.p0, name);
                NSTIJKPlayerEPG nSTIJKPlayerEPG2 = this.S0;
                nSTIJKPlayerEPG2.H = 0;
                nSTIJKPlayerEPG2.J = false;
                this.E0.removeCallbacksAndMessages((Object) null);
                a2();
                this.E0.postDelayed(new a(epgChannelId, streamIcon), 300L);
            }
        } catch (Exception unused2) {
        }
    }

    public void f2() {
        if (B2 || this.L1.getVisibility() != 8) {
            return;
        }
        this.L1.startAnimation(this.n2);
        this.L1.setVisibility(0);
    }

    public void g2() {
        if (B2 || this.L1.getVisibility() != 8) {
            return;
        }
        this.L1.startAnimation(this.n2);
        this.L1.setVisibility(0);
        if (this.G1.getVisibility() == 8) {
            this.G1.startAnimation(this.n2);
            this.G1.setVisibility(0);
        }
        if (this.I1.getVisibility() == 8) {
            this.I1.startAnimation(this.n2);
            this.I1.setVisibility(0);
        }
        if (this.H1.getVisibility() == 8) {
            this.H1.startAnimation(this.n2);
            this.H1.setVisibility(0);
        }
    }

    public void i2() {
        Handler handler;
        if (B2 || (handler = this.S0.Z0) == null) {
            return;
        }
        handler.removeCallbacksAndMessages((Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x0032 A[Catch: Exception -> 0x0044, TRY_LEAVE, TryCatch #0 {Exception -> 0x0044, blocks: (B:42:0x000e, B:44:0x0014, B:3:0x0032), top: B:41:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void k2(java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerEPGActivity.k2(java.lang.String, java.lang.String):void");
    }

    public void onBackPressed() {
        RelativeLayout relativeLayout;
        try {
            i2();
            relativeLayout = this.W1;
        } catch (Exception unused) {
        }
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.W1.startAnimation(this.w2);
            this.W1.setVisibility(8);
            return;
        }
        if (this.V1.getVisibility() == 0) {
            this.V1.startAnimation(this.q2);
            this.V1.setVisibility(8);
            return;
        }
        if (this.p0 && this.L1.getVisibility() == 0) {
            this.L1.startAnimation(this.o2);
            if (this.G1.getVisibility() == 0) {
                this.G1.startAnimation(this.o2);
            }
            if (!this.s1.equals("true") && this.b2.getVisibility() == 0) {
                this.b2.startAnimation(this.o2);
            }
            if (this.I1.getVisibility() == 0) {
                this.I1.startAnimation(this.o2);
            }
            if (!this.s1.equals("true") && this.c2.getVisibility() == 0) {
                this.c2.startAnimation(this.o2);
            }
            if (this.H1.getVisibility() == 0) {
                this.H1.startAnimation(this.o2);
            }
            this.L1.setVisibility(8);
            if (this.G1.getVisibility() == 0) {
                this.G1.setVisibility(8);
            }
            if (!this.s1.equals("true") && this.b2.getVisibility() == 0) {
                this.b2.setVisibility(8);
            }
            if (this.I1.getVisibility() == 0) {
                this.I1.setVisibility(8);
            }
            if (!this.s1.equals("true") && this.c2.getVisibility() == 0) {
                this.c2.setVisibility(8);
            }
            if (this.H1.getVisibility() == 0) {
                this.H1.setVisibility(8);
                return;
            }
            return;
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        String str;
        String str2;
        ImageView imageView;
        ImageView imageView2;
        int id = view.getId();
        if (id == f.I5) {
            try {
                if (!this.r2.equals("tv")) {
                    if (this.S0.getPlayerIsPrepared()) {
                        i2();
                        g2();
                        I1(1000);
                        this.S0.start();
                        this.Z1.setVisibility(8);
                        imageView = this.a2;
                    } else {
                        i2();
                        g2();
                        I1(5000);
                        imageView = this.Z1;
                    }
                    imageView.setVisibility(0);
                    return;
                }
                if (this.S0.getPlayerIsPrepared()) {
                    i2();
                    f2();
                    H1(1000);
                    this.S0.start();
                    this.Z1.setVisibility(8);
                    this.a2.setVisibility(0);
                    imageView2 = this.a2;
                } else {
                    i2();
                    f2();
                    H1(5000);
                    this.Z1.setVisibility(0);
                    imageView2 = this.Z1;
                }
                imageView2.requestFocus();
                return;
            } catch (Exception e2) {
                str = "exection " + e2;
                str2 = "NSTIJPLAYER";
            }
        } else {
            if (id != f.H5) {
                if (id == f.Z6 || id == f.C4) {
                    i2();
                    W1();
                    h2();
                    return;
                }
                if (id == f.c7 || id == f.E4) {
                    onBackPressed();
                } else if (id != f.I4 && id != f.J4) {
                    if (id == f.x8) {
                        i2();
                        W1();
                        B2 = true;
                        this.S0.y1();
                        this.S0.b1(3000);
                        return;
                    }
                    if (id == f.i6) {
                        i2();
                        B2 = false;
                        this.K1.startAnimation(this.j2);
                        this.K1.setVisibility(8);
                        g2();
                        I1(3000);
                        return;
                    }
                    if (id == f.v7) {
                        i2();
                        W1();
                        return;
                    } else {
                        if (id == f.B7) {
                            i2();
                            H1(5000);
                            NSTIJKPlayerEPG nSTIJKPlayerEPG = this.S0;
                            if (nSTIJKPlayerEPG != null) {
                                nSTIJKPlayerEPG.H1();
                                return;
                            }
                            return;
                        }
                        if (id != f.S8) {
                            return;
                        }
                        onBackPressed();
                    }
                }
                onBackPressed();
                return;
            }
            try {
                if (this.r2.equals("tv")) {
                    i2();
                    f2();
                    this.S0.pause();
                    this.a2.setVisibility(8);
                    this.Z1.setVisibility(0);
                    this.Z1.requestFocus();
                } else {
                    i2();
                    g2();
                    this.S0.pause();
                    this.a2.setVisibility(8);
                    this.Z1.setVisibility(0);
                }
                return;
            } catch (Exception e3) {
                str = "exection " + e3;
                str2 = "NSTIJPLAYERACTIVTY";
            }
        }
        Log.e(str2, str);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        int i;
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        this.d = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        this.o1 = new u7.a(this.d);
        this.g1 = this.d.getSharedPreferences("loginPrefs", 0);
        this.q1 = new t2.a(this);
        this.p1 = new Handler();
        if (this.o1.A().equals(m7.a.K0)) {
            this.r2 = "tv";
            i = g.X2;
        } else {
            this.r2 = "mobile";
            i = g.W2;
        }
        setContentView(i);
        this.t1 = findViewById(f.Kg);
        this.u1 = findViewById(f.Y);
        this.v1 = findViewById(f.Gm);
        this.w1 = findViewById(f.Wl);
        this.D1 = findViewById(f.W3);
        this.E1 = findViewById(f.Lf);
        this.F1 = findViewById(f.Kf);
        this.G1 = findViewById(f.j7);
        this.H1 = findViewById(f.Ea);
        this.I1 = findViewById(f.h9);
        this.V1 = findViewById(f.lf);
        this.W1 = findViewById(f.ne);
        this.X1 = findViewById(f.m5);
        this.J1 = findViewById(f.x8);
        this.K1 = findViewById(f.O9);
        this.Y1 = findViewById(f.i6);
        this.z1 = findViewById(f.uk);
        this.A1 = findViewById(f.Ak);
        this.B1 = findViewById(f.Ck);
        this.L1 = findViewById(f.t9);
        this.Z1 = findViewById(f.I5);
        this.a2 = findViewById(f.H5);
        this.b2 = findViewById(f.Cl);
        this.c2 = findViewById(f.El);
        this.M1 = findViewById(f.b7);
        this.d2 = findViewById(f.I4);
        this.e2 = findViewById(f.J4);
        this.f2 = findViewById(f.E4);
        this.N1 = findViewById(f.c7);
        this.g2 = findViewById(f.C4);
        this.U1 = findViewById(f.B7);
        this.h2 = findViewById(f.n5);
        this.O1 = findViewById(f.Y6);
        this.P1 = findViewById(f.L9);
        this.Q1 = findViewById(f.S8);
        this.R1 = findViewById(f.v7);
        this.C1 = findViewById(f.lj);
        this.S1 = findViewById(f.W8);
        this.T1 = findViewById(f.Z6);
        this.x1 = findViewById(f.Mh);
        overridePendingTransition(a7.b.f, a7.b.d);
        this.i2 = AnimationUtils.loadAnimation(this.d, a7.b.q);
        this.j2 = AnimationUtils.loadAnimation(this.d, a7.b.r);
        this.n2 = AnimationUtils.loadAnimation(this.d, a7.b.h);
        this.o2 = AnimationUtils.loadAnimation(this.d, a7.b.i);
        this.q2 = AnimationUtils.loadAnimation(this.d, a7.b.o);
        this.p2 = AnimationUtils.loadAnimation(this.d, a7.b.n);
        this.l2 = AnimationUtils.loadAnimation(this.d, a7.b.s);
        this.m2 = AnimationUtils.loadAnimation(this.d, a7.b.t);
        this.k2 = AnimationUtils.loadAnimation(this.d, a7.b.p);
        this.v2 = AnimationUtils.loadAnimation(this.d, a7.b.j);
        this.w2 = AnimationUtils.loadAnimation(this.d, a7.b.k);
        this.I = getSharedPreferences("loginPrefs", 0);
        y2 = this.d.getSharedPreferences("loginPrefs", 0);
        this.J = this.d.getSharedPreferences("allowedFormat", 0);
        SharedPreferences sharedPreferences = getSharedPreferences("currentlyPlayingVideo", 0);
        this.K = sharedPreferences;
        this.y0 = sharedPreferences.edit();
        SharedPreferences sharedPreferences2 = getSharedPreferences("currentlyPlayingVideoPosition", 0);
        this.L = sharedPreferences2;
        this.z0 = sharedPreferences2.edit();
        this.Y0 = this.d.getSharedPreferences("openedVideo", 0);
        this.M = this.d.getSharedPreferences("currentSubtitleTrack", 0);
        this.N = this.d.getSharedPreferences("currentAudioTrack", 0);
        this.O = this.d.getSharedPreferences("currentVideoTrack", 0);
        this.H0 = this.N.edit();
        this.I0 = this.O.edit();
        this.G0 = this.M.edit();
        this.H0.clear();
        this.H0.apply();
        this.I0.clear();
        this.I0.apply();
        this.G0.clear();
        this.G0.apply();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) {
            this.R = "m3u";
        } else {
            this.R = "api";
        }
        String string = this.I.getString("username", "");
        String string2 = this.I.getString("password", "");
        String string3 = this.I.getString("serverUrl", "");
        String string4 = this.I.getString("serverProtocol", "");
        String string5 = this.I.getString("serverPortHttps", "");
        String string6 = this.I.getString("serverPort", "");
        String string7 = this.I.getString("serverPortRtmp", "");
        if (string4 != null) {
            switch (string4) {
                case "http":
                    if (string3 != null && !string3.startsWith("http://")) {
                        sb2 = new StringBuilder();
                        sb2.append("http://");
                        sb2.append(string3);
                        string3 = sb2.toString();
                    }
                    string5 = string6;
                    break;
                case "rmtp":
                    if (string3 != null && !string3.startsWith("rmtp://")) {
                        string3 = "rmtp://" + string3;
                    }
                    string5 = string7;
                    break;
                case "https":
                    if (string3 != null && !string3.startsWith("https://")) {
                        string3 = "https://" + string3;
                        break;
                    }
                    break;
                default:
                    if (string3 != null && !string3.startsWith("http://") && !string3.startsWith("https://")) {
                        sb2 = new StringBuilder();
                        sb2.append("http://");
                        sb2.append(string3);
                        string3 = sb2.toString();
                    }
                    string5 = string6;
                    break;
            }
        } else {
            string5 = "";
        }
        String string8 = this.J.getString("allowedFormat", "");
        this.Q = string8;
        if (string8 == null || string8.isEmpty() || this.Q.equals("") || !this.Q.equals("default")) {
            String str2 = this.Q;
            if (str2 == null || str2.isEmpty() || this.Q.equals("") || !this.Q.equals("ts")) {
                String str3 = this.Q;
                str = (str3 == null || str3.isEmpty() || this.Q.equals("") || !this.Q.equals("m3u8")) ? ".ts" : ".m3u8";
                this.Q = "";
            }
            this.Q = str;
        } else {
            this.Q = "";
        }
        int intExtra = getIntent().getIntExtra("OPENED_STREAM_ID", 0);
        this.d1 = getIntent().getStringExtra("VIDEO_URL");
        this.W0 = getIntent().getIntExtra("VIDEO_NUM", 0);
        getIntent().getStringExtra("STREAM_TYPE");
        String stringExtra = getIntent().getStringExtra("VIDEO_TITLE");
        String stringExtra2 = getIntent().getStringExtra("OPENED_CAT_ID");
        String stringExtra3 = getIntent().getStringExtra("EPG_CHANNEL_ID");
        this.s1 = getIntent().getStringExtra("MultiPlayer");
        String stringExtra4 = getIntent().getStringExtra("EPG_CHANNEL_LOGO");
        SharedPreferences.Editor edit = this.Y0.edit();
        edit.putInt("openedVideoID", intExtra);
        edit.putString("LOGIN_PREF_OPENED_VIDEO_URL_M3U", this.d1);
        edit.putString("name", stringExtra);
        edit.putInt("num", this.W0);
        edit.putString("epgChannelId", stringExtra3);
        edit.putString("channelLogo", stringExtra4);
        edit.apply();
        if (this.Q.equals("")) {
            sb = new StringBuilder();
            sb.append(string3);
            sb.append(":");
            sb.append(string5);
            sb.append("/");
        } else {
            sb = new StringBuilder();
            sb.append(string3);
            sb.append(":");
            sb.append(string5);
            sb.append("/live/");
        }
        sb.append(string);
        sb.append("/");
        sb.append(string2);
        sb.append("/");
        this.R0 = sb.toString();
        this.e = w.G(this.R0);
        this.H = new LiveStreamDBHandler(this);
        this.x0 = new DatabaseHandler(this.d);
        this.C0 = new Handler();
        this.D0 = new Handler();
        this.E0 = new Handler();
        this.F0 = new Handler();
        NSTIJKPlayerEPG findViewById = findViewById(f.Im);
        this.S0 = findViewById;
        findViewById.setLiveStreamDBHandler(this.H);
        L1();
        c2();
        this.j = findViewById(f.Cl);
        String str4 = this.s1;
        if (str4 == null || !str4.equals("true")) {
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setOnClickListener(this);
            }
        } else {
            ImageView imageView2 = this.j;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        this.h = findViewById(f.El);
        this.i = findViewById(f.S8);
        String str5 = this.s1;
        if (str5 == null || !str5.equals("true")) {
            ImageView imageView3 = this.h;
            if (imageView3 != null) {
                imageView3.setOnClickListener(this);
            }
            View view = this.i;
            if (view != null) {
                view.setOnClickListener(this);
            }
        } else {
            ImageView imageView4 = this.h;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        }
        NSTIJKPlayerEPG nSTIJKPlayerEPG = this.S0;
        nSTIJKPlayerEPG.u1(this, nSTIJKPlayerEPG, this.v1, this.u1, this.t1, this.B1, this.z1, this.A1, this.w1, this.F1, this.E1, this.L1, this.n2, this.o2, this.b2, this.c2, this.G1, this.H1, this.x1, this.I1, this.k2, this.l2, this.y1, this.V1, this.q2, this.K1, this.i2, this.j2, this.W1, this.w2, this.s1, this.D1);
        this.w = findViewById(f.Nc);
        this.v = findViewById(f.S9);
        this.q = findViewById(f.P4);
        this.r = findViewById(f.ti);
        this.s = findViewById(f.vi);
        this.t = findViewById(f.qk);
        this.u = findViewById(f.rk);
        C2 = findViewById(f.A);
        this.l0 = findViewById(f.ec);
        this.m0 = findViewById(f.sk);
        this.n0 = findViewById(f.wk);
        this.A0 = findViewById(f.E2);
        this.B0 = findViewById(f.gh);
        this.L0 = findViewById(f.u7);
        this.M0 = findViewById(f.o);
        this.p = findViewById(f.Pm);
        this.m = findViewById(f.G);
        this.n = findViewById(f.K);
        this.o = findViewById(f.rm);
        this.x = findViewById(f.dc);
        try {
            IjkMediaPlayer.loadLibrariesOnce(null);
            IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        } catch (UnsatisfiedLinkError | Exception unused) {
        }
        this.b1 = w.S0(com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.b.f() + IjkListPreference.V());
        SharedPreferences sharedPreferences3 = this.d.getSharedPreferences("timeFormat", 0);
        x2 = sharedPreferences3;
        String string9 = sharedPreferences3.getString("timeFormat", m7.a.E0);
        Locale locale = Locale.US;
        this.P = new SimpleDateFormat(string9, locale);
        this.e1 = w.S0(IjkListPreference.W() + IjkListPreference.U());
        findViewById(f.S8).setOnClickListener(this);
        this.p0 = true;
        View findViewById2 = findViewById(f.I5);
        this.f = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        this.X0 = w.S0(w7.d.d());
        View findViewById3 = findViewById(f.H5);
        this.g = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this);
        }
        A2 = N1(this.d);
        z2 = getApplicationContext().getPackageName();
        View findViewById4 = findViewById(f.f1);
        this.k = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(this);
        }
        this.r1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.Q0 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.T0 = w.S0(w7.a.a());
        this.h1 = new Date();
        this.B = findViewById(f.pb);
        this.T = new ArrayList();
        this.U = new ArrayList();
        this.V = new ArrayList();
        this.W = new ArrayList();
        this.X = new ArrayList();
        this.Y = new ArrayList();
        this.Z = new ArrayList();
        this.e0 = new ArrayList();
        this.f0 = new ArrayList();
        this.g0 = new ArrayList();
        this.h0 = new ArrayList();
        this.j0 = this.H.getAllliveCategories();
        LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
        LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel2 = new LiveStreamCategoryIdDBModel();
        LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel3 = new LiveStreamCategoryIdDBModel();
        liveStreamCategoryIdDBModel.setLiveStreamCategoryID("0");
        liveStreamCategoryIdDBModel.setLiveStreamCategoryName(this.d.getResources().getString(j.x));
        liveStreamCategoryIdDBModel2.setLiveStreamCategoryID("-1");
        liveStreamCategoryIdDBModel2.setLiveStreamCategoryName(this.d.getResources().getString(j.b2));
        int uncatCount = this.H.getUncatCount("-2", "live");
        this.N0 = uncatCount;
        if (uncatCount != 0 && uncatCount > 0) {
            liveStreamCategoryIdDBModel3.setLiveStreamCategoryID("-2");
            liveStreamCategoryIdDBModel3.setLiveStreamCategoryName(this.d.getResources().getString(j.b8));
            ArrayList arrayList = this.j0;
            arrayList.add(arrayList.size(), liveStreamCategoryIdDBModel3);
        }
        this.H.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.d));
        this.i0 = Q1();
        stringExtra2.hashCode();
        if (stringExtra2.equals("0")) {
            this.u0 = "0";
        } else if (stringExtra2.equals("-1")) {
            this.u0 = "-1";
        } else {
            this.u0 = stringExtra2;
        }
        this.S0.setEPGHandler(this.E0);
        this.S0.setContext(this.d);
        this.c1 = Long.valueOf(S1(this.d));
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.S0 != null) {
                e2();
            }
        } catch (Exception unused) {
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        View view;
        StringBuilder sb;
        boolean z = keyEvent.getRepeatCount() == 0;
        if (i != 62) {
            if (i != 66) {
                if (i != 79) {
                    if (i == 82) {
                        Menu menu = this.P0;
                        if (menu != null) {
                            menu.performIdentifierAction(f.P2, 0);
                        }
                        return true;
                    }
                    if (i != 85) {
                        if (i != 86) {
                            if (i == 126) {
                                if (z && !this.S0.isPlaying()) {
                                    this.S0.start();
                                    this.g.requestFocus();
                                }
                                return true;
                            }
                            if (i != 127) {
                                switch (i) {
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
                                        String str = this.s1;
                                        if (str != null && str.equals("false") && this.p0 && !SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("stalker_api")) {
                                            this.F0.removeCallbacksAndMessages((Object) null);
                                            int i2 = 7;
                                            if (i == 7) {
                                                this.K0.append(0);
                                            } else if (i == 8) {
                                                this.K0.append(1);
                                            } else {
                                                if (i == 9) {
                                                    sb = this.K0;
                                                    i2 = 2;
                                                } else if (i == 10) {
                                                    sb = this.K0;
                                                    i2 = 3;
                                                } else if (i == 11) {
                                                    sb = this.K0;
                                                    i2 = 4;
                                                } else if (i == 12) {
                                                    sb = this.K0;
                                                    i2 = 5;
                                                } else if (i == 13) {
                                                    sb = this.K0;
                                                    i2 = 6;
                                                } else if (i == 14) {
                                                    sb = this.K0;
                                                } else if (i == 15) {
                                                    this.K0.append(8);
                                                } else if (i == 16) {
                                                    this.K0.append(9);
                                                }
                                                sb.append(i2);
                                            }
                                            this.M0.setText(this.K0.toString());
                                            this.L0.setVisibility(0);
                                            this.F0.postDelayed(new b(), 3000L);
                                        }
                                        return true;
                                    default:
                                        switch (i) {
                                            case 19:
                                            case 20:
                                            case 21:
                                            case 22:
                                                i2();
                                                H1(5000);
                                                return true;
                                            case 23:
                                                break;
                                            default:
                                                return super/*android.app.Activity*/.onKeyUp(i, keyEvent);
                                        }
                                }
                            }
                        }
                        if (z && this.S0.isPlaying()) {
                            this.S0.pause();
                            this.f.requestFocus();
                        }
                        return true;
                    }
                }
            }
            if (!this.p0) {
                return true;
            }
            NSTIJKPlayerEPG nSTIJKPlayerEPG = this.S0;
            if (nSTIJKPlayerEPG == null || !nSTIJKPlayerEPG.getPlayerIsPrepared()) {
                j2();
            } else if (this.V1.getVisibility() == 8) {
                j2();
                (this.S0.isPlaying() ? this.a2 : this.Z1).requestFocus();
            }
            return true;
        }
        if (!z || this.S0.isPlaying()) {
            this.S0.pause();
            view = this.f;
        } else {
            this.S0.start();
            view = this.g;
        }
        view.requestFocus();
        return true;
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            r3 = this;
            super/*androidx.fragment.app.e*/.onResume()
            com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerEPG r0 = r3.S0
            if (r0 == 0) goto La
            r3.Y1()
        La:
            java.lang.String r0 = r3.u0
            java.lang.String r1 = ""
            if (r0 == 0) goto L39
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L39
            java.lang.String r0 = r3.u0
            java.lang.String r2 = "0"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L39
            r3.E1()
            java.util.ArrayList r0 = r3.Z
            if (r0 == 0) goto L35
            int r0 = r0.size()
            if (r0 == 0) goto L35
        L2d:
            java.util.ArrayList r0 = r3.Z
            int r1 = r3.W0
            r3.d2(r0, r1)
            goto L6b
        L35:
            r3.b2()
            goto L6b
        L39:
            java.lang.String r0 = r3.u0
            if (r0 == 0) goto L5b
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5b
            java.lang.String r0 = r3.u0
            java.lang.String r1 = "-1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5b
            r3.G1()
            java.util.ArrayList r0 = r3.Z
            if (r0 == 0) goto L35
            int r0 = r0.size()
            if (r0 == 0) goto L35
            goto L2d
        L5b:
            java.lang.String r0 = r3.u0
            r3.F1(r0)
            java.util.ArrayList r0 = r3.Z
            if (r0 == 0) goto L35
            int r0 = r0.size()
            if (r0 == 0) goto L35
            goto L2d
        L6b:
            r3.M1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerEPGActivity.onResume():void");
    }

    public void onStop() {
        super.onStop();
        try {
            NSTIJKPlayerEPG nSTIJKPlayerEPG = this.S0;
            if (nSTIJKPlayerEPG != null) {
                nSTIJKPlayerEPG.h1(Boolean.valueOf(this.p0));
                e2();
            }
        } catch (Exception unused) {
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public void toggleView(View view) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
        } else if (view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }
}
