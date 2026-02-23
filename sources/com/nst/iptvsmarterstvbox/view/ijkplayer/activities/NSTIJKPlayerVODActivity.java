package com.nst.iptvsmarterstvbox.view.ijkplayer.activities;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.AppCompatImageView;
import com.nst.iptvsmarterstvbox.model.EpisodesUsingSinglton;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.PlayerSelectedSinglton;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerVOD;
import d4.k0;
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
import p7.z0;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerVODActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public static String j1 = null;
    public static boolean k1 = true;
    public static boolean l1 = true;
    public static String m1;
    public DateFormat A;
    public LinearLayout A0;
    public LiveStreamDBHandler B;
    public TextView B0;
    public ArrayList C;
    public SharedPreferences C0;
    public SharedPreferences.Editor D0;
    public SharedPreferences E;
    public SharedPreferences F;
    public String F0;
    public SharedPreferences G;
    public String G0;
    public SharedPreferences H;
    public RecentWatchDBHandler H0;
    public SharedPreferences I;
    public String I0;
    public SharedPreferences J;
    public ImageView J0;
    public SharedPreferences K;
    public TextView K0;
    public SharedPreferences L;
    public Button L0;
    public SharedPreferences M;
    public Button M0;
    public String N;
    public androidx.appcompat.app.a N0;
    public AppCompatImageView O;
    public AppCompatImageView P;
    public NSTIJKPlayerVOD P0;
    public ArrayList Q;
    public SharedPreferences Q0;
    public ArrayList R;
    public Button R0;
    public Spinner S0;
    public SharedPreferences T0;
    public RelativeLayout U;
    public SharedPreferences.Editor U0;
    public int V;
    public RelativeLayout V0;
    public SharedPreferences.Editor W;
    public List W0;
    public SharedPreferences.Editor X;
    public TextView Y;
    public TextView Z;
    public t2.a d;
    public Context e;
    public TextView e0;
    public SeriesRecentWatchDatabase e1;
    public String f;
    public TextView f0;
    public TextView g0;
    public u7.a g1;
    public View h;
    public String h0;
    public View i;
    public Handler i0;
    public z0 i1;
    public View j;
    public Handler j0;
    public View k;
    public PopupWindow k0;
    public View l;
    public SharedPreferences.Editor l0;
    public View m;
    public SharedPreferences.Editor m0;
    public View n;
    public SharedPreferences.Editor n0;
    public View o;
    public String o0;
    public View p;
    public View q;
    public View r;
    public SimpleDateFormat s;
    public SharedPreferences.Editor s0;
    public LinearLayout t;
    public String t0;
    public TextView u;
    public TextView v;
    public View v0;
    public SeekBar w;
    public View w0;
    public Date x;
    public Handler x0;
    public LinearLayout y;
    public Handler y0;
    public ProgressBar z;
    public boolean g = false;
    public ArrayList D = new ArrayList();
    public boolean S = false;
    public boolean T = false;
    public String p0 = "";
    public String q0 = "";
    public String r0 = "";
    public int u0 = 0;
    public int z0 = 0;
    public int E0 = -1;
    public Boolean O0 = Boolean.TRUE;
    public String X0 = "";
    public String Y0 = "";
    public String Z0 = "";
    public String a1 = "";
    public String b1 = "";
    public String c1 = "";
    public int d1 = 0;
    public int f1 = 4;
    public String h1 = "";

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        public void onDismiss() {
            NSTIJKPlayerVODActivity.B1(NSTIJKPlayerVODActivity.this);
        }
    }

    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            String obj = NSTIJKPlayerVODActivity.this.S0.getItemAtPosition(i).toString();
            NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity = NSTIJKPlayerVODActivity.this;
            NSTIJKPlayerVODActivity.D1(nSTIJKPlayerVODActivity, nSTIJKPlayerVODActivity.getSharedPreferences("pref.using_sub_font_size", 0));
            NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity2 = NSTIJKPlayerVODActivity.this;
            NSTIJKPlayerVODActivity.F1(nSTIJKPlayerVODActivity2, NSTIJKPlayerVODActivity.C1(nSTIJKPlayerVODActivity2).edit());
            if (NSTIJKPlayerVODActivity.E1(NSTIJKPlayerVODActivity.this) != null) {
                NSTIJKPlayerVODActivity.E1(NSTIJKPlayerVODActivity.this).putString("pref.using_sub_font_size", obj);
                NSTIJKPlayerVODActivity.E1(NSTIJKPlayerVODActivity.this).apply();
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this) != null) {
                NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).I1();
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            NSTIJKPlayerVODActivity.this.N0.setCancelable(true);
            NSTIJKPlayerVODActivity.this.onBackPressed();
            NSTIJKPlayerVODActivity.this.onBackPressed();
            NSTIJKPlayerVODActivity.this.N0.dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ NSTIJKPlayerVODActivity e;
        public final /* synthetic */ int f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ int i;

        public e(ArrayList arrayList, int i, String str, NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity, int i2, String str2, String str3, int i3) {
            this.a = arrayList;
            this.c = i;
            this.d = str;
            this.e = nSTIJKPlayerVODActivity;
            this.f = i2;
            this.g = str2;
            this.h = str3;
            this.i = i3;
        }

        public void onClick(View view) {
            String name = ((LiveStreamsDBModel) this.a.get(this.c)).getName();
            new LiveStreamsDBModel();
            ArrayList K1 = NSTIJKPlayerVODActivity.w1(NSTIJKPlayerVODActivity.this).equals("m3u") ? NSTIJKPlayerVODActivity.K1(NSTIJKPlayerVODActivity.this, String.valueOf(Uri.parse(this.d)), SharepreferenceDBHandler.getUserID(this.e)) : NSTIJKPlayerVODActivity.L1(NSTIJKPlayerVODActivity.this, this.f, SharepreferenceDBHandler.getUserID(this.e));
            long j = 0;
            if (K1 != null) {
                try {
                    if (K1.size() > 0) {
                        j = ((LiveStreamsDBModel) K1.get(0)).getMovieElapsedTime();
                    }
                } catch (Exception unused) {
                }
            }
            long j2 = j;
            if (NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this) != null && NSTIJKPlayerVODActivity.M1(NSTIJKPlayerVODActivity.this).booleanValue()) {
                NSTIJKPlayerVODActivity.N1(NSTIJKPlayerVODActivity.this);
                String valueOf = String.valueOf(Uri.parse(NSTIJKPlayerVODActivity.this.f + this.f + "." + this.g));
                NSTIJKPlayerVOD v1 = NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this);
                NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity = NSTIJKPlayerVODActivity.this;
                v1.d2(valueOf, nSTIJKPlayerVODActivity.S, name, 0L, this.f, this.h, NSTIJKPlayerVODActivity.O1(nSTIJKPlayerVODActivity), this.c, this.i, NSTIJKPlayerVODActivity.w1(NSTIJKPlayerVODActivity.this), "nst");
                x7.a.f().G(this.f);
                x7.a.f().t(this.a);
                x7.a.f().w(this.c);
                NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).setCurrentPositionSeekbar((int) j2);
                NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).setProgress(true);
                if (NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this) != null) {
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).I = 0;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).K = false;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).S0 = true;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).z0 = false;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).start();
                }
            }
            NSTIJKPlayerVODActivity.this.N0.dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ ArrayList h;

        public f(int i, String str, String str2, String str3, int i2, int i3, ArrayList arrayList) {
            this.a = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = i2;
            this.g = i3;
            this.h = arrayList;
        }

        public void onClick(View view) {
            NSTIJKPlayerVODActivity.N1(NSTIJKPlayerVODActivity.this);
            String valueOf = String.valueOf(Uri.parse(NSTIJKPlayerVODActivity.this.f + this.a + "." + this.c));
            NSTIJKPlayerVOD v1 = NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this);
            NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity = NSTIJKPlayerVODActivity.this;
            v1.d2(valueOf, nSTIJKPlayerVODActivity.S, this.d, 0L, this.a, this.e, NSTIJKPlayerVODActivity.O1(nSTIJKPlayerVODActivity), this.f, this.g, NSTIJKPlayerVODActivity.w1(NSTIJKPlayerVODActivity.this), "nst");
            if (NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this) != null) {
                x7.a.f().G(this.a);
                x7.a.f().t(this.h);
                x7.a.f().w(this.f);
                if (NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this) != null) {
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).N0 = true;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).I0 = true;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).L0 = 0L;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).S0 = true;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).z0 = false;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).I = 0;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).K = false;
                    NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).start();
                }
            }
            NSTIJKPlayerVODActivity.this.N0.dismiss();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            NSTIJKPlayerVODActivity.this.c2();
            if (m7.a.B.booleanValue()) {
                NSTIJKPlayerVODActivity.this.findViewById(a7.f.Sm).setVisibility(0);
            }
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ int a;

        public h(int i) {
            this.a = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0113  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 444
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerVODActivity.h.run():void");
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ int a;

        public i(int i) {
            this.a = i;
        }

        public void run() {
            String valueOf;
            NSTIJKPlayerVOD v1;
            boolean z;
            String str;
            int i;
            String str2;
            ArrayList O1;
            int i2;
            int Q1;
            String w1;
            String str3;
            long j;
            NSTIJKPlayerVODActivity.N1(NSTIJKPlayerVODActivity.this);
            if (!NSTIJKPlayerVODActivity.w1(NSTIJKPlayerVODActivity.this).equals("m3u") || NSTIJKPlayerVODActivity.this.X0.equals("recording")) {
                if (NSTIJKPlayerVODActivity.this.X0.equals("recording")) {
                    v1 = NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this);
                    NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity = NSTIJKPlayerVODActivity.this;
                    valueOf = nSTIJKPlayerVODActivity.f;
                    z = nSTIJKPlayerVODActivity.S;
                    str = nSTIJKPlayerVODActivity.Z0;
                    w1 = NSTIJKPlayerVODActivity.w1(nSTIJKPlayerVODActivity);
                    str3 = "nst";
                    j = 0;
                    i = 0;
                    str2 = "";
                    O1 = null;
                    i2 = 0;
                    Q1 = 0;
                } else {
                    valueOf = String.valueOf(Uri.parse(NSTIJKPlayerVODActivity.this.f + NSTIJKPlayerVODActivity.this.d1 + "." + NSTIJKPlayerVODActivity.this.c1));
                    v1 = NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this);
                    NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity2 = NSTIJKPlayerVODActivity.this;
                    z = nSTIJKPlayerVODActivity2.S;
                    str = nSTIJKPlayerVODActivity2.Z0;
                    i = nSTIJKPlayerVODActivity2.d1;
                    str2 = nSTIJKPlayerVODActivity2.b1;
                    O1 = NSTIJKPlayerVODActivity.O1(nSTIJKPlayerVODActivity2);
                    i2 = this.a;
                    Q1 = NSTIJKPlayerVODActivity.Q1(NSTIJKPlayerVODActivity.this);
                    w1 = NSTIJKPlayerVODActivity.w1(NSTIJKPlayerVODActivity.this);
                    str3 = "nst";
                    j = 0;
                }
                v1.d2(valueOf, z, str, j, i, str2, O1, i2, Q1, w1, str3);
            } else {
                NSTIJKPlayerVOD v12 = NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this);
                String P1 = NSTIJKPlayerVODActivity.P1(NSTIJKPlayerVODActivity.this);
                NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity3 = NSTIJKPlayerVODActivity.this;
                v12.d2(P1, nSTIJKPlayerVODActivity3.S, nSTIJKPlayerVODActivity3.Z0, 0L, 0, "", null, this.a, 0, NSTIJKPlayerVODActivity.w1(nSTIJKPlayerVODActivity3), "nst");
                x7.a.f().r("m3u");
            }
            NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).I = 0;
            NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).K = false;
            NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).S0 = false;
            NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).setProgress(false);
            NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).start();
            if (NSTIJKPlayerVODActivity.this.X0.equals("movies")) {
                x7.a.f().G(w.q0(((LiveStreamsDBModel) NSTIJKPlayerVODActivity.R1(NSTIJKPlayerVODActivity.this).get(this.a)).getStreamId()));
                x7.a.f().t(NSTIJKPlayerVODActivity.R1(NSTIJKPlayerVODActivity.this));
            } else if (NSTIJKPlayerVODActivity.this.X0.equals("series")) {
                x7.a.f().x(NSTIJKPlayerVODActivity.x1(NSTIJKPlayerVODActivity.this));
                EpisodesUsingSinglton.getInstance().setEpisodeList(NSTIJKPlayerVODActivity.y1(NSTIJKPlayerVODActivity.this));
                x7.a.f().G(w.q0(((GetEpisdoeDetailsCallback) NSTIJKPlayerVODActivity.y1(NSTIJKPlayerVODActivity.this).get(this.a)).getId()));
                x7.a.f().v(NSTIJKPlayerVODActivity.y1(NSTIJKPlayerVODActivity.this));
            }
            x7.a.f().w(this.a);
            NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).setProgress(false);
        }
    }

    public class j implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NSTIJKPlayerVODActivity.A1(NSTIJKPlayerVODActivity.this, 0);
                NSTIJKPlayerVODActivity.this.A0.setVisibility(8);
            }
        }

        public j() {
        }

        public void run() {
            NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).seekTo(NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).getCurrentPosition() + NSTIJKPlayerVODActivity.z1(NSTIJKPlayerVODActivity.this));
            NSTIJKPlayerVODActivity.this.x0.removeCallbacksAndMessages((Object) null);
            NSTIJKPlayerVODActivity.this.x0.postDelayed(new a(), 3000L);
        }
    }

    public class k implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                NSTIJKPlayerVODActivity.A1(NSTIJKPlayerVODActivity.this, 0);
                NSTIJKPlayerVODActivity.this.A0.setVisibility(8);
            }
        }

        public k() {
        }

        public void run() {
            NSTIJKPlayerVOD v1;
            int i;
            if (NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).getCurrentPosition() + NSTIJKPlayerVODActivity.z1(NSTIJKPlayerVODActivity.this) > 0) {
                v1 = NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this);
                i = NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this).getCurrentPosition() + NSTIJKPlayerVODActivity.z1(NSTIJKPlayerVODActivity.this);
            } else {
                v1 = NSTIJKPlayerVODActivity.v1(NSTIJKPlayerVODActivity.this);
                i = 0;
            }
            v1.seekTo(i);
            NSTIJKPlayerVODActivity.this.x0.removeCallbacksAndMessages((Object) null);
            NSTIJKPlayerVODActivity.this.x0.postDelayed(new a(), 3000L);
        }
    }

    public class l implements View.OnFocusChangeListener {
        public final View a;

        public l(View view) {
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
            float f2;
            if (!z) {
                if (z) {
                    return;
                }
                if (this.a.getTag().equals("15")) {
                    f2 = z ? 1.04f : 1.0f;
                    b(f2);
                    c(f2);
                } else {
                    f = z ? 1.02f : 1.0f;
                    b(f);
                    c(f);
                }
                a(z);
                View view2 = this.a;
                if (view2 != null && view2.getTag() != null && this.a.getTag().equals("1") && NSTIJKPlayerVODActivity.G1(NSTIJKPlayerVODActivity.this) != null) {
                    NSTIJKPlayerVODActivity.G1(NSTIJKPlayerVODActivity.this).setBackgroundResource(a7.e.o);
                }
                View view3 = this.a;
                if (view3 != null && view3.getTag() != null && this.a.getTag().equals("9")) {
                    NSTIJKPlayerVODActivity.H1(NSTIJKPlayerVODActivity.this).setBackgroundResource(a7.e.o);
                }
                View view4 = this.a;
                if (view4 != null && view4.getTag() != null && this.a.getTag().equals("8")) {
                    NSTIJKPlayerVODActivity.I1(NSTIJKPlayerVODActivity.this).setBackgroundResource(a7.e.o);
                }
                View view5 = this.a;
                if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("15")) {
                    return;
                }
                NSTIJKPlayerVODActivity.J1(NSTIJKPlayerVODActivity.this).setImageDrawable(NSTIJKPlayerVODActivity.this.getResources().getDrawable(a7.e.B0));
                return;
            }
            Log.e("id is", "" + this.a.getTag());
            View view6 = this.a;
            if (view6 != null && view6.getTag() != null && this.a.getTag().equals("2")) {
                view.setBackground(NSTIJKPlayerVODActivity.this.getResources().getDrawable(a7.e.I1));
                return;
            }
            View view7 = this.a;
            if (view7 == null || !view7.getTag().equals("15")) {
                f = z ? 1.02f : 1.0f;
                b(f);
                c(f);
            } else {
                f2 = z ? 1.04f : 1.0f;
                b(f2);
                c(f2);
            }
            View view8 = this.a;
            if (view8 != null && view8.getTag() != null && this.a.getTag().equals("1") && NSTIJKPlayerVODActivity.G1(NSTIJKPlayerVODActivity.this) != null) {
                NSTIJKPlayerVODActivity.G1(NSTIJKPlayerVODActivity.this).setBackgroundResource(a7.e.h);
            }
            View view9 = this.a;
            if (view9 != null && view9.getTag() != null && this.a.getTag().equals("9")) {
                NSTIJKPlayerVODActivity.H1(NSTIJKPlayerVODActivity.this).setBackgroundResource(a7.e.h);
            }
            View view10 = this.a;
            if (view10 != null && view10.getTag() != null && this.a.getTag().equals("8")) {
                NSTIJKPlayerVODActivity.I1(NSTIJKPlayerVODActivity.this).setBackgroundResource(a7.e.k1);
            }
            View view11 = this.a;
            if (view11 == null || view11.getTag() == null || !this.a.getTag().equals("15")) {
                return;
            }
            NSTIJKPlayerVODActivity.J1(NSTIJKPlayerVODActivity.this).setImageDrawable(NSTIJKPlayerVODActivity.this.getResources().getDrawable(a7.e.C0));
            NSTIJKPlayerVODActivity.H1(NSTIJKPlayerVODActivity.this).setBackgroundResource(a7.e.o);
            NSTIJKPlayerVODActivity.I1(NSTIJKPlayerVODActivity.this).setBackgroundResource(a7.e.o);
        }
    }

    public static /* synthetic */ int A1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity, int i2) {
        nSTIJKPlayerVODActivity.z0 = i2;
        return i2;
    }

    public static /* synthetic */ void B1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        nSTIJKPlayerVODActivity.b2();
    }

    public static /* synthetic */ SharedPreferences C1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.T0;
    }

    public static /* synthetic */ SharedPreferences D1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity, SharedPreferences sharedPreferences) {
        nSTIJKPlayerVODActivity.T0 = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences.Editor E1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.U0;
    }

    public static /* synthetic */ SharedPreferences.Editor F1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity, SharedPreferences.Editor editor) {
        nSTIJKPlayerVODActivity.U0 = editor;
        return editor;
    }

    public static /* synthetic */ Button G1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.R0;
    }

    public static /* synthetic */ Button H1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.L0;
    }

    public static /* synthetic */ Button I1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.M0;
    }

    public static /* synthetic */ ImageView J1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.J0;
    }

    public static /* synthetic */ ArrayList K1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity, String str, int i2) {
        return nSTIJKPlayerVODActivity.Z1(str, i2);
    }

    public static /* synthetic */ ArrayList L1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity, int i2, int i3) {
        return nSTIJKPlayerVODActivity.Y1(i2, i3);
    }

    public static /* synthetic */ Boolean M1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.O0;
    }

    public static /* synthetic */ void N1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        nSTIJKPlayerVODActivity.o2();
    }

    public static /* synthetic */ ArrayList O1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.R;
    }

    public static /* synthetic */ String P1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.G0;
    }

    public static /* synthetic */ int Q1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.u0;
    }

    public static /* synthetic */ ArrayList R1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.Q;
    }

    public static long T1(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String V1(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    private ArrayList Y1(int i2, int i3) {
        return this.H0.getStreamStatus(String.valueOf(i2), i3);
    }

    public static String a2(String str) {
        Matcher matcher = Pattern.compile("(?:youtube(?:-nocookie)?\\.com\\/(?:[^\\/\\n\\s]+\\/\\S+\\/|(?:v|e(?:mbed)?)\\/|\\S*?[?&]v=)|youtu\\.be\\/)([a-zA-Z0-9_-]{11})", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private void b2() {
        try {
            NSTIJKPlayerVOD nSTIJKPlayerVOD = this.P0;
            if (nSTIJKPlayerVOD != null) {
                nSTIJKPlayerVOD.setSystemUiVisibility(4871);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:110:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0725  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0273 A[PHI: r22
      0x0273: PHI (r22v4 java.lang.String) = 
      (r22v3 java.lang.String)
      (r22v3 java.lang.String)
      (r22v3 java.lang.String)
      (r22v3 java.lang.String)
      (r22v3 java.lang.String)
      (r22v5 java.lang.String)
     binds: [B:216:0x0297, B:218:0x029d, B:220:0x02a5, B:222:0x02af, B:214:0x0292, B:175:0x0271] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x014f A[PHI: r18
      0x014f: PHI (r18v6 java.lang.String) = (r18v1 java.lang.String), (r18v2 java.lang.String), (r18v3 java.lang.String), (r18v7 java.lang.String) binds: [B:244:0x0173, B:241:0x0166, B:238:0x0159, B:6:0x014d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d2() {
        /*
            Method dump skipped, instructions count: 2258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerVODActivity.d2():void");
    }

    private void f2() {
        int d2;
        d2 = x7.a.f().d();
        String str = this.X0;
        str.hashCode();
        switch (str) {
            case "movies":
                if (d2 == this.Q.size() - 1) {
                    x7.a.f().w(0);
                    return;
                }
                break;
            case "series":
                if (d2 == this.W0.size() - 1) {
                    x7.a.f().w(0);
                    return;
                }
                break;
            case "recording":
                if (d2 == this.C.size() - 1) {
                    x7.a.f().w(0);
                    return;
                }
                break;
        }
        x7.a.f().w(d2 + 1);
    }

    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    private void i2(ArrayList arrayList, int i2) {
        boolean z;
        ?? r13;
        String valueOf;
        NSTIJKPlayerVOD nSTIJKPlayerVOD;
        boolean z2;
        String str;
        long j2;
        int i3;
        ArrayList arrayList2;
        int i4;
        int i5;
        String str2;
        String str3;
        String str4;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int W1 = W1(arrayList, i2);
        String name = ((LiveStreamsDBModel) arrayList.get(W1)).getName();
        String num = ((LiveStreamsDBModel) arrayList.get(W1)).getNum();
        String S0 = w.S0(y7.a.a() + y7.a.b());
        String streamType = ((LiveStreamsDBModel) arrayList.get(W1)).getStreamType();
        int q0 = w.q0(((LiveStreamsDBModel) arrayList.get(W1)).getStreamId());
        String contaiinerExtension = ((LiveStreamsDBModel) arrayList.get(W1)).getContaiinerExtension();
        x7.a.f().w(W1);
        if (this.X0.equals("movies")) {
            this.G0 = ((LiveStreamsDBModel) arrayList.get(W1)).getUrl();
            SharedPreferences.Editor editor = this.W;
            if (editor != null) {
                editor.putString("currentlyPlayingVideo", String.valueOf(((LiveStreamsDBModel) this.Q.get(W1)).getStreamId()));
                this.W.apply();
            }
        }
        SharedPreferences.Editor editor2 = this.X;
        if (editor2 != null) {
            editor2.putString("currentlyPlayingVideoPosition", String.valueOf(W1));
            this.X.apply();
        }
        SimpleDateFormat simpleDateFormat = this.s;
        if (T1(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.e))), this.A.format(this.x)) >= w7.c.p() && (str3 = this.t0) != null && this.I0 != null && (!m1.equals(str3) || (this.t0 != null && (str4 = this.I0) != null && !j1.equals(str4)))) {
            this.O0 = Boolean.FALSE;
            this.d.b(a7.f.G).e();
            this.d.b(a7.f.K).c(S0 + this.h0 + this.o0);
        }
        this.V = q0;
        int r0 = w.r0(num);
        this.P0.setTitle(r0 + " - " + name);
        this.d.b(a7.f.O).c(r0 + " - " + name);
        if (this.P0.getFullScreenValue().booleanValue()) {
            this.S = this.P0.getFullScreenValue().booleanValue();
        } else {
            this.S = false;
        }
        this.P0.W1();
        NSTIJKPlayerVOD nSTIJKPlayerVOD2 = this.P0;
        nSTIJKPlayerVOD2.I = 0;
        nSTIJKPlayerVOD2.K = false;
        nSTIJKPlayerVOD2.I0 = true;
        int t2 = this.F0.equals("m3u") ? t2(String.valueOf(Uri.parse(this.G0)), SharepreferenceDBHandler.getUserID(this.e)) : s2(q0, SharepreferenceDBHandler.getUserID(this.e));
        this.Q0 = this.e.getSharedPreferences("loginPrefs", 0);
        if (!k1) {
            t2 = 0;
        }
        if (t2 == 0) {
            if (this.O0.booleanValue()) {
                o2();
                if (this.F0.equals("m3u")) {
                    nSTIJKPlayerVOD = this.P0;
                    valueOf = this.G0;
                    z2 = this.S;
                    str = "nst";
                    j2 = 0;
                    i3 = 0;
                    streamType = "";
                    arrayList2 = null;
                    i4 = 0;
                    i5 = 0;
                    str2 = this.F0;
                } else {
                    valueOf = String.valueOf(Uri.parse(this.f + q0 + "." + contaiinerExtension));
                    nSTIJKPlayerVOD = this.P0;
                    z2 = this.S;
                    str = "nst";
                    j2 = 0;
                    i3 = q0;
                    arrayList2 = this.R;
                    i4 = W1;
                    i5 = r0;
                    str2 = this.F0;
                }
                nSTIJKPlayerVOD.d2(valueOf, z2, name, j2, i3, streamType, arrayList2, i4, i5, str2, str);
                x7.a.f().G(q0);
                x7.a.f().t(arrayList);
                x7.a.f().w(W1);
                NSTIJKPlayerVOD nSTIJKPlayerVOD3 = this.P0;
                if (nSTIJKPlayerVOD3 != null) {
                    nSTIJKPlayerVOD3.I = 0;
                    nSTIJKPlayerVOD3.K = false;
                    nSTIJKPlayerVOD3.S0 = true;
                    nSTIJKPlayerVOD3.z0 = false;
                    nSTIJKPlayerVOD3.start();
                }
                c2();
            }
        } else if (t2 > 0) {
            if (isFinishing() || !this.O0.booleanValue()) {
                z = true;
                r13 = 0;
            } else {
                this.C0 = getSharedPreferences("currentSeekTime", 0);
                c2();
                z = true;
                r13 = 0;
                h2(this, q0, contaiinerExtension, name, r0, streamType, arrayList, W1, this.G0);
            }
            NSTIJKPlayerVOD nSTIJKPlayerVOD4 = this.P0;
            if (nSTIJKPlayerVOD4 != null) {
                nSTIJKPlayerVOD4.I = r13;
                nSTIJKPlayerVOD4.K = r13;
                nSTIJKPlayerVOD4.S0 = z;
                nSTIJKPlayerVOD4.z0 = r13;
                nSTIJKPlayerVOD4.start();
            }
        }
        c2();
    }

    private void j2(ArrayList arrayList, int i2) {
        String str;
        String str2;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        String name = ((File) arrayList.get(i2)).getName();
        String S0 = w.S0(w7.k.a() + w7.k.i());
        SimpleDateFormat simpleDateFormat = this.s;
        if (T1(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.e))), this.A.format(this.x)) >= w7.c.p() && (str = this.t0) != null && this.I0 != null && (!m1.equals(str) || (this.t0 != null && (str2 = this.I0) != null && !j1.equals(str2)))) {
            this.O0 = Boolean.FALSE;
            this.d.b(a7.f.G).e();
            this.d.b(a7.f.K).c(S0 + this.h0 + this.o0);
        }
        if (this.O0.booleanValue()) {
            x7.a.f().w(i2);
            this.P0.setTitle(name);
            if (this.P0.getFullScreenValue().booleanValue()) {
                this.S = this.P0.getFullScreenValue().booleanValue();
            } else {
                this.S = false;
            }
            this.P0.W1();
            o2();
            this.P0.d2(this.f, this.S, name, 0L, 0, "", null, 0, 0, this.F0, "nst");
            NSTIJKPlayerVOD nSTIJKPlayerVOD = this.P0;
            if (nSTIJKPlayerVOD != null) {
                nSTIJKPlayerVOD.I = 0;
                nSTIJKPlayerVOD.K = false;
                nSTIJKPlayerVOD.S0 = true;
                nSTIJKPlayerVOD.z0 = false;
                nSTIJKPlayerVOD.start();
            }
        }
        c2();
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0303  */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k2(java.util.List r32, int r33) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerVODActivity.k2(java.util.List, int):void");
    }

    private void n2() {
        int d2;
        d2 = x7.a.f().d();
        String str = this.X0;
        str.hashCode();
        switch (str) {
            case "movies":
                if (d2 == 0) {
                    x7.a.f().w(this.Q.size() - 1);
                    return;
                }
                break;
            case "series":
                if (d2 == 0) {
                    x7.a.f().w(this.W0.size() - 1);
                    return;
                }
                break;
            case "recording":
                if (d2 == 0) {
                    x7.a.f().w(this.C.size() - 1);
                    return;
                }
                break;
        }
        x7.a.f().w(d2 - 1);
    }

    private void o2() {
        try {
            if (this.P0 != null) {
                this.C0 = this.e.getSharedPreferences("currentSeekTime", 0);
                long currentPosition = this.P0.getCurrentPosition();
                SharedPreferences sharedPreferences = this.e.getSharedPreferences("currentSeekTime", 0);
                this.C0 = sharedPreferences;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                this.D0 = edit;
                edit.putString("currentSeekTime", String.valueOf(currentPosition));
                this.D0.apply();
                NSTIJKPlayerVOD nSTIJKPlayerVOD = this.P0;
                if (nSTIJKPlayerVOD != null && currentPosition != -1 && currentPosition != 0) {
                    nSTIJKPlayerVOD.setCurrentPositionSeekbar(nSTIJKPlayerVOD.getCurrentPosition());
                    this.P0.setProgress(true);
                    this.P0.V1(true);
                }
                if (this.X0.equals("movies")) {
                    if (!this.F0.equals("m3u") && this.P0 != null && x7.a.f().k() != -1 && currentPosition != -1 && currentPosition != 0) {
                        if (x7.a.f().h() == x7.a.f().k()) {
                            u2(x7.a.f().k(), 0L);
                            x7.a.f().C(0);
                        } else {
                            u2(x7.a.f().k(), currentPosition);
                        }
                    }
                } else if (this.X0.equals("series") && ((this.P0 == null || x7.a.f().a() == null || !this.F0.equals("m3u")) && x7.a.f() != null && x7.a.f().e() != null && currentPosition != -1 && currentPosition != 0)) {
                    if (x7.a.f().h() == Integer.parseInt(x7.a.f().e())) {
                        this.i1.j(x7.a.f().e(), 0L);
                        x7.a.f().C(0);
                    } else {
                        this.i1.j(x7.a.f().e(), currentPosition);
                    }
                }
            }
            NSTIJKPlayerVOD nSTIJKPlayerVOD2 = this.P0;
            if (nSTIJKPlayerVOD2 != null) {
                if (nSTIJKPlayerVOD2.N1()) {
                    this.P0.D1();
                } else {
                    this.P0.n2();
                    this.P0.T1(true);
                    this.P0.m2();
                }
                IjkMediaPlayer.native_profileEnd();
            }
        } catch (Exception unused) {
        }
    }

    private int s2(int i2, int i3) {
        return this.H0.isStreamAvailable(String.valueOf(i2), i3);
    }

    private int t2(String str, int i2) {
        return this.B.isStreamAvailable(str, i2);
    }

    public static /* synthetic */ NSTIJKPlayerVOD v1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.P0;
    }

    public static /* synthetic */ String w1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.F0;
    }

    public static /* synthetic */ String x1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.h1;
    }

    public static /* synthetic */ List y1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.W0;
    }

    public static /* synthetic */ int z1(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity) {
        return nSTIJKPlayerVODActivity.z0;
    }

    public void S1() {
        File[] O = w.O(this.e);
        for (File file : O) {
            if (file.toString().endsWith(".ts")) {
                Arrays.asList(new File[]{file});
            }
        }
        if (O.length > 0) {
            for (File file2 : O) {
                if (file2.toString().endsWith(".ts")) {
                    this.D.addAll(Arrays.asList(new File[]{file2}));
                }
            }
            Collections.reverse(this.D);
            this.C = this.D;
        }
    }

    public void U1() {
        TextView textView;
        this.P0.I1();
        NSTIJKPlayerVOD nSTIJKPlayerVOD = this.P0;
        if (nSTIJKPlayerVOD != null && (textView = nSTIJKPlayerVOD.f0) != null) {
            textView.setVisibility(0);
        }
        this.U.setVisibility(8);
        this.P0.E1(Boolean.valueOf(this.S));
        r2();
        p2();
        if (!"android.intent.action.VIEW".equals(getIntent().getAction())) {
            String str = this.X0;
            if (str == null || str.equals("")) {
                return;
            }
            if (!this.X0.equals("devicedata") && !this.X0.equals("loadurl")) {
                return;
            }
        }
        d2();
    }

    public int W1(ArrayList arrayList, int i2) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (w.r0(((LiveStreamsDBModel) arrayList.get(i3)).getNum()) == i2) {
                return i3;
            }
        }
        return 0;
    }

    public int X1(List list, int i2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (w.r0(((GetEpisdoeDetailsCallback) list.get(i3)).getId()) == i2) {
                return i3;
            }
        }
        return 0;
    }

    public final ArrayList Z1(String str, int i2) {
        return this.B.getStreamStatus(str, i2);
    }

    public void c2() {
        findViewById(a7.f.P).setVisibility(8);
        findViewById(a7.f.o2).setVisibility(8);
        findViewById(a7.f.S9).setVisibility(8);
        if (m7.a.B.booleanValue()) {
            findViewById(a7.f.Sm).setVisibility(0);
        }
    }

    public void e2() {
        r2();
        q2();
        p2();
    }

    public void g2() {
        c2();
        this.t.setVisibility(0);
        this.u.setText(getResources().getString(a7.j.g4));
        if (m7.a.B.booleanValue()) {
            findViewById(a7.f.Sm).setVisibility(8);
        }
    }

    public final void h2(NSTIJKPlayerVODActivity nSTIJKPlayerVODActivity, int i2, String str, String str2, int i3, String str3, ArrayList arrayList, int i4, String str4) {
        String name = ((LiveStreamsDBModel) arrayList.get(i4)).getName();
        a.a aVar = new a.a(this, a7.k.f);
        aVar.h(new c());
        View inflate = LayoutInflater.from(this).inflate(a7.g.q3, (ViewGroup) null);
        this.K0 = inflate.findViewById(a7.f.jk);
        this.L0 = inflate.findViewById(a7.f.A0);
        ImageView findViewById = inflate.findViewById(a7.f.N4);
        this.J0 = findViewById;
        findViewById.setOnClickListener(new d());
        this.M0 = inflate.findViewById(a7.f.K0);
        TextView textView = this.K0;
        if (textView != null) {
            textView.setText(i3 + "-" + str2);
        }
        Button button = this.L0;
        if (button != null) {
            button.setOnFocusChangeListener(new l(button));
        }
        Button button2 = this.M0;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new l(button2));
        }
        ImageView imageView = this.J0;
        if (imageView != null) {
            imageView.setOnFocusChangeListener(new l(imageView));
        }
        this.L0.requestFocus();
        this.L0.setOnClickListener(new e(arrayList, i4, str4, nSTIJKPlayerVODActivity, i2, str, str3, i3));
        this.M0.setOnClickListener(new f(i2, str, name, str3, i4, i3, arrayList));
        aVar.setView(inflate);
        this.N0 = aVar.create();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.N0.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.N0.show();
        this.N0.getWindow().setAttributes(layoutParams);
        this.N0.setCancelable(false);
        this.N0.show();
    }

    public final void l2() {
        this.i.setVisibility(8);
        this.h.setVisibility(0);
        if (m7.a.B.booleanValue()) {
            findViewById(a7.f.Sm).setVisibility(0);
        }
    }

    public final void m2() {
        this.h.setVisibility(8);
        this.i.setVisibility(0);
        if (m7.a.B.booleanValue()) {
            findViewById(a7.f.Sm).setVisibility(0);
        }
    }

    public void onBackPressed() {
        if (findViewById(a7.f.P).getVisibility() == 0) {
            c2();
            return;
        }
        String str = this.Y0;
        if (str != null && !str.equals("")) {
            this.P0.n2();
            this.P0.T1(true);
            this.P0.m2();
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r18) {
        /*
            Method dump skipped, instructions count: 2346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerVODActivity.onClick(android.view.View):void");
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        this.e = getApplicationContext();
        PlayerSelectedSinglton.getInstance().setPlayerType("vod");
        try {
            IjkMediaPlayer.loadLibrariesOnce(null);
            IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        } catch (UnsatisfiedLinkError | Exception unused) {
        }
        this.X0 = getIntent().getStringExtra("type");
        Intent intent = getIntent();
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            intent.getData();
            intent.getType();
            this.Y0 = intent.getDataString();
            setContentView(a7.g.U3);
        }
        String str = this.X0;
        if (str != null && !str.equals("") && (this.X0.equals("devicedata") || this.X0.equals("loadurl"))) {
            setRequestedOrientation(new u7.a(this.e).A().equals(m7.a.K0) ? 0 : 4);
        }
        String str2 = this.X0;
        if (str2 != null && !str2.equals("")) {
            setContentView((this.X0.equals("devicedata") || this.X0.equals("loadurl")) ? a7.g.U3 : a7.g.T3);
        }
        d2();
        w.I0(this.e);
    }

    public void onDestroy() {
        Button button;
        super.onDestroy();
        try {
            NSTIJKPlayerVOD nSTIJKPlayerVOD = this.P0;
            if (nSTIJKPlayerVOD != null && (button = nSTIJKPlayerVOD.r1) != null) {
                button.performClick();
            }
        } catch (Exception e2) {
            Log.e("fsgd", "fdfh", e2);
        }
        try {
            o2();
        } catch (Exception unused) {
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        String str;
        int i3;
        String str2;
        keyEvent.getRepeatCount();
        keyEvent.getAction();
        RelativeLayout relativeLayout = this.V0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (i2 == 19) {
            str = this.Y0;
            if ((str == null && !str.equals("")) || this.X0.equals("devicedata") || this.X0.equals("ofd") || this.X0.equals("loadurl") || this.X0.equals("catch_up")) {
                return false;
            }
            e2();
            i3 = a7.f.B3;
        } else if (i2 == 20) {
            str2 = this.Y0;
            if ((str2 == null && !str2.equals("")) || this.X0.equals("devicedata") || this.X0.equals("ofd") || this.X0.equals("loadurl") || this.X0.equals("catch_up")) {
                return false;
            }
            e2();
            i3 = a7.f.E3;
        } else if (i2 == 89) {
            e2();
            i3 = a7.f.F3;
        } else {
            if (i2 != 90) {
                if (i2 != 166) {
                    if (i2 != 167) {
                        if (i2 != 274) {
                            if (i2 != 275) {
                                return super.onKeyDown(i2, keyEvent);
                            }
                            e2();
                            i3 = a7.f.F3;
                        }
                    }
                    str2 = this.Y0;
                    if (str2 == null) {
                    }
                    e2();
                    i3 = a7.f.E3;
                }
                str = this.Y0;
                if (str == null) {
                }
                e2();
                i3 = a7.f.B3;
            }
            e2();
            i3 = a7.f.y3;
        }
        findViewById(i3).performClick();
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008a, code lost:
    
        if (r5.X0.equals("loadurl") == false) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyUp(int r6, android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerVODActivity.onKeyUp(int, android.view.KeyEvent):boolean");
    }

    public void onPause() {
        NSTIJKPlayerVOD nSTIJKPlayerVOD;
        super/*androidx.fragment.app.e*/.onPause();
        String action = getIntent().getAction();
        if (k0.a <= 23) {
            o2();
        }
        if (!"android.intent.action.VIEW".equals(action) || (nSTIJKPlayerVOD = this.P0) == null) {
            return;
        }
        if (nSTIJKPlayerVOD.N1()) {
            this.P0.D1();
        } else {
            this.P0.pause();
        }
        IjkMediaPlayer.native_profileEnd();
    }

    public void onRestart() {
        super/*android.app.Activity*/.onRestart();
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.e);
        NSTIJKPlayerVOD nSTIJKPlayerVOD = this.P0;
        if (nSTIJKPlayerVOD != null) {
            nSTIJKPlayerVOD.I1();
            if (this.g) {
                k1 = false;
                this.g = false;
                ArrayList arrayList = this.Q;
                if (arrayList == null || arrayList.size() == 0) {
                    g2();
                } else {
                    i2(this.Q, this.u0);
                }
            }
            U1();
        }
    }

    public void onStop() {
        Button button;
        super.onStop();
        try {
            NSTIJKPlayerVOD nSTIJKPlayerVOD = this.P0;
            if (nSTIJKPlayerVOD != null && (button = nSTIJKPlayerVOD.r1) != null) {
                button.performClick();
                this.g = false;
            }
        } catch (Exception e2) {
            Log.e("fsgd", "fdfh", e2);
        }
        try {
            o2();
        } catch (Exception unused) {
        }
    }

    public final void p2() {
        this.j0.postDelayed(new g(), 7000L);
    }

    public void q2() {
        findViewById(a7.f.P).setVisibility(0);
        findViewById(a7.f.o2).setVisibility(0);
        findViewById(a7.f.S9).setVisibility(0);
        if (m7.a.B.booleanValue()) {
            findViewById(a7.f.Sm).setVisibility(0);
        }
    }

    public final void r2() {
        Handler handler = this.j0;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void toggleView(View view) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
        } else if (view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    public final void u1(Context context) {
        if (this.P0 != null) {
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a7.g.F4, findViewById(a7.f.Kg));
            PopupWindow popupWindow = new PopupWindow(context);
            this.k0 = popupWindow;
            popupWindow.setContentView(inflate);
            this.k0.setWidth(-1);
            this.k0.setHeight(-1);
            this.k0.setFocusable(true);
            this.k0.setOnDismissListener(new a());
            inflate.findViewById(a7.f.sf);
            RadioGroup findViewById = inflate.findViewById(a7.f.Kg);
            RadioGroup findViewById2 = inflate.findViewById(a7.f.Y);
            RadioGroup findViewById3 = inflate.findViewById(a7.f.Gm);
            this.e0 = inflate.findViewById(a7.f.uk);
            this.f0 = inflate.findViewById(a7.f.Ak);
            this.g0 = inflate.findViewById(a7.f.Ck);
            Spinner findViewById4 = inflate.findViewById(a7.f.Ig);
            this.S0 = findViewById4;
            try {
                ArrayAdapter adapter = findViewById4.getAdapter();
                SharedPreferences sharedPreferences = context.getSharedPreferences("pref.using_sub_font_size", 0);
                this.T0 = sharedPreferences;
                this.S0.setSelection(adapter.getPosition(sharedPreferences.getString("pref.using_sub_font_size", m7.a.x0)));
            } catch (Exception unused) {
            }
            Spinner spinner = this.S0;
            if (spinner != null) {
                spinner.setOnItemSelectedListener(new b());
            }
            NSTIJKPlayerVOD nSTIJKPlayerVOD = this.P0;
            if (nSTIJKPlayerVOD != null) {
                nSTIJKPlayerVOD.k2(findViewById3, findViewById2, findViewById, this.k0, this.g0, this.e0, this.f0);
            }
            this.k0.showAtLocation(inflate, 1, 0, 0);
        }
    }

    public final void u2(int i2, long j2) {
        RecentWatchDBHandler recentWatchDBHandler = this.H0;
        if (recentWatchDBHandler != null) {
            recentWatchDBHandler.updateResumePlayerStatus(String.valueOf(i2), "movie", false, j2);
        }
    }
}
