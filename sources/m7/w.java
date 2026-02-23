package m7;

import P.W;
import P.m0;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.drawable.ColorDrawable;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import com.facebook.ads.InterstitialAd;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.database.EPGSourcesModel;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.MaintanencePannelActivity;
import com.nst.iptvsmarterstvbox.view.activity.APPInPurchaseActivity;
import com.nst.iptvsmarterstvbox.view.activity.CheckAppupdateActivity;
import com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeries;
import com.nst.iptvsmarterstvbox.view.activity.ExoPlayerMoviesSeriesActivity;
import com.nst.iptvsmarterstvbox.view.activity.HoneyPlayer;
import com.nst.iptvsmarterstvbox.view.activity.ImportM3uActivity;
import com.nst.iptvsmarterstvbox.view.activity.ImportOneStreamActivity;
import com.nst.iptvsmarterstvbox.view.activity.LoginActivity;
import com.nst.iptvsmarterstvbox.view.activity.LoginActivityOneStream;
import com.nst.iptvsmarterstvbox.view.activity.LoginM3uActivity;
import com.nst.iptvsmarterstvbox.view.activity.MultiUserActivity;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity;
import com.nst.iptvsmarterstvbox.view.activity.RateUsActivity;
import com.nst.iptvsmarterstvbox.view.activity.RecordingActivity;
import com.nst.iptvsmarterstvbox.view.activity.RoutingActivity;
import com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories;
import com.nst.iptvsmarterstvbox.view.demo.ExoDownloadedPlayerTwo;
import com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyActivity;
import com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerEPGActivity;
import com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyActivity;
import g7.e;
import j$.util.DesugarTimeZone;
import java.io.File;
import java.io.Serializable;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import k.J;
import k.L;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.joda.time.LocalDateTime;
import q7.Q;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import t1.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class w {
    public static PopupWindow i = null;
    public static SharedPreferences j = null;
    public static SharedPreferences k = null;
    public static u7.a l = null;
    public static AsyncTask m = null;
    public static AsyncTask n = null;
    public static AsyncTask o = null;
    public static AsyncTask p = null;
    public static boolean q = false;
    public static AsyncTask r;
    public static String[] s = {"android.permission.POST_NOTIFICATIONS"};
    public static String[] t = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
    public static Dialog u;
    public SharedPreferences a;
    public int b = 0;
    public boolean c = false;
    public int d = 10;
    public int[] e = {1};
    public String f = "";
    public ArrayList g = new ArrayList();
    public String h;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.k().dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ Activity a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                w.k().dismiss();
            }
        }

        public b(Activity activity) {
            this.a = activity;
        }

        public void onClick(View view) {
            w.this.a = PreferenceManager.getDefaultSharedPreferences(this.a);
            SharedPreferences.Editor edit = w.this.a.edit();
            edit.putBoolean("CANCELLED", true);
            edit.apply();
            MyApplication.p().I();
            w.this.U0(this.a, "stopped");
            Activity activity = this.a;
            Toast.makeText(activity, activity.getResources().getString(a7.j.f1), 0).show();
            new Handler().postDelayed(new a(), 500L);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            w.k().dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public String a = "";
        public boolean c = true;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ SharedPreferences f;

        public class a implements e.j {
            public a() {
            }

            public void a(String str) {
                d.a(d.this, str);
                d.this.e.setText(str);
                SharedPreferences.Editor edit = d.this.f.edit();
                edit.putString("recordingDir", str);
                edit.apply();
                Toast.makeText(d.this.d, "Chosen directory: " + str, 1).show();
            }
        }

        public d(Activity activity, EditText editText, SharedPreferences sharedPreferences) {
            this.d = activity;
            this.e = editText;
            this.f = sharedPreferences;
        }

        public static /* synthetic */ String a(d dVar, String str) {
            dVar.a = str;
            return str;
        }

        public void onClick(View view) {
            g7.e eVar = new g7.e(this.d, new a());
            eVar.K(this.c);
            if (Build.VERSION.SDK_INT >= 30) {
                eVar.E("");
            } else {
                eVar.D("");
            }
            this.c = !this.c;
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ Activity e;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                w.k().dismiss();
            }
        }

        public e(EditText editText, EditText editText2, EditText editText3, Activity activity) {
            this.a = editText;
            this.c = editText2;
            this.d = editText3;
            this.e = activity;
        }

        public final boolean a() {
            Activity activity;
            Resources resources;
            int i;
            if (this.c.getText().toString().trim().length() == 0) {
                activity = this.e;
                resources = activity.getResources();
                i = a7.j.y2;
            } else if (this.a.getText().toString().trim().length() == 0) {
                activity = this.e;
                resources = activity.getResources();
                i = a7.j.x2;
            } else {
                if (this.a.getText().toString().trim().length() == 0) {
                    return true;
                }
                try {
                    w.r0(this.a.getText().toString());
                    return true;
                } catch (NumberFormatException unused) {
                    activity = this.e;
                    resources = activity.getResources();
                    i = a7.j.p1;
                }
            }
            Toast.makeText(activity, resources.getString(i), 1).show();
            return false;
        }

        public void onClick(View view) {
            int i;
            if (a()) {
                try {
                    i = w.r0(this.a.getText().toString());
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                MyApplication.p().H(w.this.h, i, this.c.getText().toString(), true, this.d.getText().toString());
                new Handler().postDelayed(new a(), 500L);
            }
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ InterstitialAd a;

        public f(InterstitialAd interstitialAd) {
            this.a = interstitialAd;
        }

        public void run() {
            if (this.a.isAdLoaded()) {
                this.a.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            w.k().dismiss();
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ File a;
        public final /* synthetic */ RecordingActivity c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ Q e;
        public final /* synthetic */ TextView f;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                w.k().dismiss();
            }
        }

        public h(File file, RecordingActivity recordingActivity, ArrayList arrayList, Q q, TextView textView) {
            this.a = file;
            this.c = recordingActivity;
            this.d = arrayList;
            this.e = q;
            this.f = textView;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r8) {
            /*
                r7 = this;
                r8 = 1
                r0 = 0
                java.io.File r1 = r7.a
                boolean r1 = r1.exists()
                if (r1 == 0) goto L84
                java.io.File r1 = r7.a
                boolean r1 = r1.delete()
                if (r1 == 0) goto L84
                com.nst.iptvsmarterstvbox.view.activity.RecordingActivity r1 = r7.c
                android.content.res.Resources r2 = r1.getResources()
                int r3 = a7.j.X5
                java.lang.String r2 = r2.getString(r3)
                android.widget.Toast r1 = android.widget.Toast.makeText(r1, r2, r0)
                r1.show()
                com.nst.iptvsmarterstvbox.view.activity.RecordingActivity r1 = r7.c
                java.io.File[] r1 = m7.w.O(r1)
                if (r1 == 0) goto L66
                int r2 = r1.length
                if (r2 <= 0) goto L66
                java.util.ArrayList r2 = r7.d
                r2.clear()
                int r2 = r1.length
                r3 = 0
            L37:
                if (r3 >= r2) goto L56
                r4 = r1[r3]
                java.lang.String r5 = r4.toString()
                java.lang.String r6 = ".ts"
                boolean r5 = r5.endsWith(r6)
                if (r5 == 0) goto L54
                java.io.File[] r5 = new java.io.File[r8]
                r5[r0] = r4
                java.util.List r4 = java.util.Arrays.asList(r5)
                java.util.ArrayList r5 = r7.d
                r5.addAll(r4)
            L54:
                int r3 = r3 + r8
                goto L37
            L56:
                java.util.ArrayList r8 = r7.d
                if (r8 == 0) goto L66
                int r8 = r8.size()
                if (r8 <= 0) goto L66
                q7.Q r8 = r7.e
                r8.w()
                goto L75
            L66:
                java.util.ArrayList r8 = r7.d
                r8.clear()
                q7.Q r8 = r7.e
                r8.w()
                android.widget.TextView r8 = r7.f
                r8.setVisibility(r0)
            L75:
                android.os.Handler r8 = new android.os.Handler
                r8.<init>()
                m7.w$h$a r0 = new m7.w$h$a
                r0.<init>()
                r1 = 500(0x1f4, double:2.47E-321)
                r8.postDelayed(r0, r1)
            L84:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m7.w.h.onClick(android.view.View):void");
        }
    }

    public static class j extends Dialog implements View.OnClickListener {
        public final Context a;
        public final u7.a c;
        public Activity d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public LinearLayout i;
        public LinearLayout j;

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
                            b = j.b(j.this);
                        }
                    } else {
                        b = j.a(j.this);
                    }
                    i = a7.e.p;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                            return;
                        } else {
                            b = j.b(j.this);
                        }
                    } else {
                        b = j.a(j.this);
                    }
                    i = a7.e.o;
                }
                b.setBackgroundResource(i);
            }
        }

        public j(Activity activity, Context context, u7.a aVar) {
            super(activity);
            this.d = activity;
            this.a = context;
            this.c = aVar;
        }

        public static /* synthetic */ LinearLayout a(j jVar) {
            return jVar.i;
        }

        public static /* synthetic */ LinearLayout b(j jVar) {
            return jVar.j;
        }

        public void onClick(View view) {
            if (view.getId() == a7.f.u1) {
                try {
                    this.a.startActivity(new Intent(this.a, APPInPurchaseActivity.class));
                } catch (Exception unused) {
                }
            } else if (view.getId() == a7.f.h1) {
                dismiss();
            }
            dismiss();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(this.c.A().equals(m7.a.K0) ? a7.g.d2 : a7.g.c2);
            this.e = findViewById(a7.f.u1);
            this.f = findViewById(a7.f.h1);
            this.i = findViewById(a7.f.V8);
            this.j = findViewById(a7.f.Ia);
            this.h = findViewById(a7.f.fm);
            this.g = findViewById(a7.f.um);
            this.h.setText(this.a.getResources().getString(a7.j.c2));
            this.g.setText(this.a.getResources().getString(a7.j.h8));
            this.e.setText(this.a.getResources().getString(a7.j.I5));
            this.f.setText(this.a.getResources().getString(a7.j.c0));
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            TextView textView = this.e;
            textView.setOnFocusChangeListener(new a(textView));
            TextView textView2 = this.f;
            textView2.setOnFocusChangeListener(new a(textView2));
        }
    }

    public static class k implements View.OnFocusChangeListener {
        public View a;
        public Activity b;
        public Context c;

        public k(View view, Activity activity) {
            this.a = view;
            this.b = activity;
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
            int i;
            if (this.b != null) {
                if (z) {
                    float f = z ? 1.12f : 1.0f;
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                            View view4 = this.a;
                            if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("3")) {
                                view.setBackground(this.b.getResources().getDrawable(a7.e.I1));
                                return;
                            } else {
                                a(f);
                                b(f);
                                i = a7.e.p;
                            }
                        } else {
                            a(f);
                            b(f);
                            i = a7.e.k1;
                        }
                    } else {
                        a(f);
                        b(f);
                        i = a7.e.h;
                    }
                } else {
                    if (z) {
                        return;
                    }
                    a(1.0f);
                    b(1.0f);
                    View view5 = this.a;
                    if (view5 != null && view5.getTag() != null && this.a.getTag().equals("1")) {
                        view.setBackgroundResource(a7.e.o);
                    }
                    View view6 = this.a;
                    if (view6 != null && view6.getTag() != null && this.a.getTag().equals("2")) {
                        view.setBackgroundResource(a7.e.o);
                    }
                    View view7 = this.a;
                    if (view7 == null || view7.getTag() == null || !this.a.getTag().equals("3")) {
                        return;
                    } else {
                        i = a7.e.o;
                    }
                }
                view.setBackgroundResource(i);
            }
        }

        public k(View view, Context context) {
            this.a = view;
            this.c = context;
        }

        public k(View view, CheckAppupdateActivity checkAppupdateActivity) {
            this.a = view;
            this.b = checkAppupdateActivity;
        }

        public k(View view, MultiUserActivity multiUserActivity) {
            this.a = view;
            this.b = multiUserActivity;
        }

        public k(View view, NewDashboardActivity newDashboardActivity) {
            this.a = view;
            this.b = newDashboardActivity;
        }

        public k(View view, RateUsActivity rateUsActivity) {
            this.a = view;
            this.b = rateUsActivity;
        }

        public k(View view, RecordingActivity recordingActivity) {
            this.a = view;
            this.b = recordingActivity;
        }

        public k(View view, VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
            this.a = view;
            this.b = vodActivityNewFlowSubCategories;
        }

        public k(View view, NSTIJKPlayerSkyActivity nSTIJKPlayerSkyActivity) {
            this.a = view;
            this.b = nSTIJKPlayerSkyActivity;
        }
    }

    public static String A(String str) {
        try {
            return new SimpleDateFormat(" MMMM dd,yyyy").format(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US).parse(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void A0(Context context) {
        a.a aVar = new a.a(context);
        aVar.setTitle(context.getResources().getString(a7.j.u0));
        aVar.f(context.getResources().getString(a7.j.T0));
        aVar.d(a7.e.s1);
        aVar.j(context.getResources().getString(a7.j.S8), new s(context));
        aVar.g(context.getResources().getString(a7.j.d4), new t());
        aVar.n();
    }

    public static String B(String str) {
        try {
            return new SimpleDateFormat(" MMM dd,yyyy").format(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US).parse(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Retrofit B0(Context context) {
        if (context != null) {
            try {
                String lowerCase = context.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "").toLowerCase();
                Log.e("URl from Back", ">>>>>>>>" + lowerCase);
                if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
                    lowerCase = "http://" + lowerCase;
                }
                if (!lowerCase.endsWith("/")) {
                    lowerCase = lowerCase + "/";
                }
                m7.a.Z = lowerCase;
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return new Retrofit.Builder().baseUrl(lowerCase).client(builder.connectTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).readTimeout(60L, timeUnit).followRedirects(true).build()).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (NullPointerException | IllegalArgumentException | Exception unused) {
            }
        }
        return null;
    }

    public static long C(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static Retrofit C0(Context context) {
        if (context != null) {
            try {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return new Retrofit.Builder().baseUrl("https://users.iptvsmarters.com/").client(builder.connectTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).readTimeout(60L, timeUnit).followRedirects(false).build()).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (NullPointerException | IllegalArgumentException | Exception unused) {
            }
        }
        return null;
    }

    public static long D(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (str != null) {
            try {
                if (str.length() > 0 && str2 != null && str2.length() > 0) {
                    Date parse = simpleDateFormat.parse(str2);
                    Date parse2 = simpleDateFormat.parse(str);
                    long convert = (parse == null || parse2 == null) ? 0L : TimeUnit.HOURS.convert(parse.getTime() - parse2.getTime(), TimeUnit.MILLISECONDS);
                    if (convert > 0) {
                        return convert;
                    }
                    return -1L;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1L;
    }

    public static Retrofit D0(Context context) {
        if (context != null) {
            try {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return new Retrofit.Builder().baseUrl(m7.a.R0).client(builder.connectTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).readTimeout(60L, timeUnit).addInterceptor(new p()).followRedirects(true).build()).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (NullPointerException | IllegalArgumentException | Exception unused) {
            }
        }
        return null;
    }

    public static String E() {
        return Build.MANUFACTURER + " " + Build.PRODUCT;
    }

    public static Retrofit E0(Context context) {
        if (context != null) {
            try {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return new Retrofit.Builder().baseUrl(m7.a.R0).client(builder.connectTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).readTimeout(60L, timeUnit).addInterceptor(new u()).followRedirects(true).build()).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (NullPointerException | IllegalArgumentException | Exception unused) {
            }
        }
        return null;
    }

    public static String F(Context context) {
        try {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            if (str2.toLowerCase().startsWith(str.toLowerCase())) {
                return str2;
            }
            return str + "" + str2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return context.getSharedPreferences("loginPrefs", 0).getString("username", "");
        }
    }

    public static Retrofit F0(Context context) {
        if (context != null) {
            try {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return new Retrofit.Builder().baseUrl(m7.a.R0).client(builder.connectTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).readTimeout(60L, timeUnit).addInterceptor(new r()).followRedirects(false).build()).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (NullPointerException | IllegalArgumentException | Exception unused) {
            }
        }
        return null;
    }

    public static String G(String str) {
        return str.replaceAll(" ", "%20");
    }

    public static Retrofit G0(Context context) {
        if (context != null) {
            try {
                String lowerCase = context.getSharedPreferences("loginPrefsserverurl", 0).getString(m7.a.L, "").toLowerCase();
                Log.e("URl from Back", ">>>>>>>>" + lowerCase);
                if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
                    lowerCase = "http://" + lowerCase;
                }
                if (!lowerCase.endsWith("/")) {
                    lowerCase = lowerCase + "/";
                }
                if (lowerCase.contains("/c/")) {
                    lowerCase = lowerCase.replace("/c/", "/");
                }
                m7.a.Z = lowerCase;
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return new Retrofit.Builder().baseUrl(lowerCase).client(builder.connectTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).readTimeout(60L, timeUnit).followRedirects(true).build()).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (NullPointerException | IllegalArgumentException | Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int H(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3121:
                if (str.equals("ar")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3201:
                if (str.equals("de")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3241:
                if (str.equals("en")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3246:
                if (str.equals("es")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3276:
                if (str.equals("fr")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3325:
                if (str.equals("he")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3338:
                if (str.equals("hr")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3341:
                if (str.equals("hu")) {
                    c2 = 7;
                    break;
                }
                break;
            case 3365:
                if (str.equals("in")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 3371:
                if (str.equals("it")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 3428:
                if (str.equals("ko")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 3494:
                if (str.equals("ms")) {
                    c2 = 11;
                    break;
                }
                break;
            case 3518:
                if (str.equals("nl")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 3580:
                if (str.equals("pl")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 3588:
                if (str.equals("pt")) {
                    c2 = 14;
                    break;
                }
                break;
            case 3645:
                if (str.equals("ro")) {
                    c2 = 15;
                    break;
                }
                break;
            case 3678:
                if (str.equals("sq")) {
                    c2 = 16;
                    break;
                }
                break;
            case 3683:
                if (str.equals("sv")) {
                    c2 = 17;
                    break;
                }
                break;
            case 3710:
                if (str.equals("tr")) {
                    c2 = 18;
                    break;
                }
                break;
            case 3734:
                if (str.equals("uk")) {
                    c2 = 19;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 6;
            case 1:
                return 8;
            case 2:
            default:
                return 0;
            case 3:
                return 5;
            case 4:
                return 7;
            case 5:
                return 14;
            case 6:
                return 4;
            case 7:
                return 11;
            case '\b':
                return 18;
            case '\t':
                return 9;
            case '\n':
                return 13;
            case 11:
                return 16;
            case '\f':
                return 17;
            case '\r':
                return 1;
            case 14:
                return 2;
            case 15:
                return 10;
            case 16:
                return 12;
            case 17:
                return 19;
            case 18:
                return 3;
            case 19:
                return 15;
        }
    }

    public static Retrofit H0(Context context) {
        if (context != null) {
            try {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return new Retrofit.Builder().baseUrl("http://api.themoviedb.org/3/").client(builder.connectTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).readTimeout(60L, timeUnit).followRedirects(false).build()).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (NullPointerException | IllegalArgumentException | Exception unused) {
            }
        }
        return null;
    }

    public static String I(Context context) {
        String string;
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        if (string != null && !string.equals("")) {
            return string;
        }
        for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress == null) {
                    try {
                        return ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
                    } catch (Exception unused2) {
                        return "";
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (byte b2 : hardwareAddress) {
                    sb.append(String.format("%02X:", new Object[]{Byte.valueOf(b2)}));
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
        }
        return "";
    }

    public static void I0(Context context) {
        if (context != null) {
            try {
                if (new u7.a(context).A().equals(m7.a.K0) || i(context).booleanValue()) {
                    return;
                }
                InterstitialAd interstitialAd = new InterstitialAd(context, "269613774129228_269615270795745");
                interstitialAd.loadAd();
                new Handler().postDelayed(new f(interstitialAd), 2000L);
            } catch (Exception unused) {
            }
        }
    }

    public static int J(String str) {
        int i2;
        int i3 = 0;
        if (str == null) {
            return 0;
        }
        try {
            if (str.isEmpty()) {
                return 0;
            }
            if (str.contains("+")) {
                i2 = r0(str.split("\\+")[1]);
            } else {
                if (!str.contains("-")) {
                    return 0;
                }
                i2 = -r0(str.split("\\-")[1]);
            }
            i3 = i2 * 3600000;
            return i3;
        } catch (Exception unused) {
            return i3;
        }
    }

    public static void J0(Context context, String str) {
        String str2 = "en";
        if (!str.equals("English")) {
            if (str.equals("Polish")) {
                str2 = "pl";
            } else if (str.equals("Portuguese")) {
                str2 = "pt";
            } else if (str.equals("Turkish")) {
                str2 = "tr";
            } else if (str.equals("Croatian")) {
                str2 = "hr";
            } else if (str.equals("Spanish")) {
                str2 = "es";
            } else if (str.equals("Arabic")) {
                str2 = "ar";
            } else if (str.equals("French")) {
                str2 = "fr";
            } else if (str.equals("German")) {
                str2 = "de";
            } else if (str.equals("Italian")) {
                str2 = "it";
            } else if (str.equals("Romanian")) {
                str2 = "ro";
            } else if (str.equals("Hungary")) {
                str2 = "hu";
            } else if (str.equals("Albanian")) {
                str2 = "sq";
            } else if (str.equals("Korean")) {
                str2 = "ko";
            } else if (str.equals("Hebrew")) {
                str2 = "he";
            } else if (str.equals("Ukrainian")) {
                str2 = "uk";
            } else if (str.equals("Malay")) {
                str2 = "ms";
            } else if (str.equals("Dutch")) {
                str2 = "nl";
            } else if (str.equals("Indonesian")) {
                str2 = "in";
            } else if (str.equals("Swedish")) {
                str2 = "sv";
            }
        }
        if (context != null) {
            Resources resources = context.getResources();
            Resources resources2 = context.getApplicationContext().getResources();
            Locale locale = new Locale(str2);
            Locale.setDefault(locale);
            Configuration configuration = new Configuration();
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            resources2.updateConfiguration(configuration, resources.getDisplayMetrics());
            Configuration configuration2 = resources.getConfiguration();
            configuration2.setLocale(locale);
            context.getApplicationContext().createConfigurationContext(configuration2);
            context.createConfigurationContext(configuration2);
        }
    }

    public static String K(String str, Context context) {
        try {
            String string = context.getSharedPreferences("timeFormat", 0).getString("timeFormat", m7.a.E0);
            u7.a aVar = new u7.a(context);
            Locale locale = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(string, locale);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(aVar.C()));
            String format = simpleDateFormat2.format(new Date(Long.parseLong(String.valueOf(Long.valueOf(simpleDateFormat.parse(str).getTime())))));
            Log.e("TimeZone", TimeZone.getDefault().getID());
            return format;
        } catch (Exception unused) {
            return "00-00-0000 00:00";
        }
    }

    public static int L(Context context) {
        return (int) ((r1.widthPixels / context.getResources().getDisplayMetrics().density) / 180.0f);
    }

    public static int M(long j2, long j3, Context context) {
        if (context != null) {
            try {
                long millis = LocalDateTime.now().toDateTime().getMillis() + S(context);
                if (j2 < j3 && millis < j3) {
                    if (millis <= j2) {
                        return 100;
                    }
                    return (int) (((j3 - millis) * 100) / (j3 - j2));
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static void M0(Activity activity) {
        try {
            Dialog dialog = new Dialog(activity);
            u = dialog;
            dialog.setContentView(a7.g.D4);
            u.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            u.getWindow().setGravity(17);
            u.setCancelable(false);
            u.show();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int N(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1382:
                if (str.equals("+1")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1383:
                if (str.equals("+2")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1384:
                if (str.equals("+3")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1385:
                if (str.equals("+4")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1386:
                if (str.equals("+5")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1387:
                if (str.equals("+6")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1388:
                if (str.equals("+7")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1389:
                if (str.equals("+8")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1390:
                if (str.equals("+9")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1444:
                if (str.equals("-1")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1445:
                if (str.equals("-2")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1446:
                if (str.equals("-3")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1447:
                if (str.equals("-4")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 1448:
                if (str.equals("-5")) {
                    c2 = 14;
                    break;
                }
                break;
            case 1449:
                if (str.equals("-6")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1450:
                if (str.equals("-7")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1451:
                if (str.equals("-8")) {
                    c2 = 17;
                    break;
                }
                break;
            case 1452:
                if (str.equals("-9")) {
                    c2 = 18;
                    break;
                }
                break;
            case 42890:
                if (str.equals("+10")) {
                    c2 = 19;
                    break;
                }
                break;
            case 42891:
                if (str.equals("+11")) {
                    c2 = 20;
                    break;
                }
                break;
            case 42892:
                if (str.equals("+12")) {
                    c2 = 21;
                    break;
                }
                break;
            case 44812:
                if (str.equals("-10")) {
                    c2 = 22;
                    break;
                }
                break;
            case 44813:
                if (str.equals("-11")) {
                    c2 = 23;
                    break;
                }
                break;
            case 44814:
                if (str.equals("-12")) {
                    c2 = 24;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            default:
                return 12;
            case 1:
                return 13;
            case 2:
                return 14;
            case 3:
                return 15;
            case 4:
                return 16;
            case 5:
                return 17;
            case 6:
                return 18;
            case 7:
                return 19;
            case '\b':
                return 20;
            case '\t':
                return 21;
            case '\n':
                return 11;
            case 11:
                return 10;
            case '\f':
                return 9;
            case '\r':
                return 8;
            case 14:
                return 7;
            case 15:
                return 6;
            case 16:
                return 5;
            case 17:
                return 4;
            case 18:
                return 3;
            case 19:
                return 22;
            case 20:
                return 23;
            case 21:
                return 24;
            case 22:
                return 2;
            case 23:
                return 1;
            case 24:
                return 0;
        }
    }

    public static void N0(Context context) {
        try {
            Dialog dialog = new Dialog(context);
            u = dialog;
            dialog.setContentView(a7.g.D4);
            u.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            u.getWindow().setGravity(17);
            u.setCancelable(false);
            u.show();
        } catch (Exception unused) {
        }
    }

    public static File[] O(Context context) {
        if (context != null) {
            return new File(context.getSharedPreferences("recordingDir", 0).getString("recordingDir", String.valueOf(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "IPTVSmarters")))).listFiles();
        }
        return null;
    }

    public static Retrofit P(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return new Retrofit.Builder().baseUrl(m7.a.R0).client(builder.connectTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).readTimeout(60L, timeUnit).addInterceptor(new o()).followRedirects(false).build()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static void P0(Context context, String str) {
        if (context == null || str == "" || str.isEmpty()) {
            return;
        }
        Toast.makeText(context, str, 0).show();
    }

    public static Retrofit Q(Context context) {
        if (context != null) {
            try {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return new Retrofit.Builder().baseUrl(m7.a.R0).client(builder.connectTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).readTimeout(60L, timeUnit).addInterceptor(new q()).followRedirects(true).build()).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            } catch (NullPointerException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public static void Q0(Context context, String str) {
        if (context == null || str == "" || str.isEmpty()) {
            return;
        }
        Toast.makeText(context, str, 1).show();
    }

    public static String R(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(context.getSharedPreferences("timeFormat", 0).getString("timeFormat", m7.a.E0), Locale.US).format(new Date());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String R0(long j2) {
        int i2 = 0;
        try {
            TimeUnit timeUnit = TimeUnit.DAYS;
            List asList = Arrays.asList(new Long[]{Long.valueOf(timeUnit.toMillis(365L)), Long.valueOf(timeUnit.toMillis(30L)), Long.valueOf(timeUnit.toMillis(1L)), Long.valueOf(TimeUnit.HOURS.toMillis(1L)), Long.valueOf(TimeUnit.MINUTES.toMillis(1L)), Long.valueOf(TimeUnit.SECONDS.toMillis(1L))});
            List asList2 = Arrays.asList(new String[]{"year", "month", "day", "hour", "min", "sec"});
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                if (i2 >= asList.size()) {
                    break;
                }
                long longValue = j2 / ((Long) asList.get(i2)).longValue();
                if (longValue > 0) {
                    stringBuffer.append(longValue);
                    stringBuffer.append(" ");
                    stringBuffer.append((String) asList2.get(i2));
                    stringBuffer.append(longValue != 1 ? "s" : "");
                    stringBuffer.append(" ago");
                } else {
                    i2++;
                }
            }
            return "".equals(stringBuffer.toString()) ? "0 sec ago" : stringBuffer.toString();
        } catch (Exception unused) {
            return "0 sec ago";
        }
    }

    public static long S(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", 0);
            j = sharedPreferences;
            if (sharedPreferences != null) {
                return J(sharedPreferences.getString("selectedEPGShift", m7.a.C0));
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String S0(String str) {
        return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0098. Please report as an issue. */
    public static String T(Context context, int i2, String str, String str2) {
        String str3;
        StringBuilder sb;
        String str4;
        SharedPreferences sharedPreferences = context.getSharedPreferences("allowedFormat", 0);
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("loginPrefs", 0);
        String string = sharedPreferences2.getString("username", "");
        String string2 = sharedPreferences2.getString("password", "");
        String string3 = sharedPreferences.getString("allowedFormat", "");
        String string4 = sharedPreferences2.getString("serverUrl", "");
        String string5 = sharedPreferences2.getString("serverProtocol", "");
        String string6 = sharedPreferences2.getString("serverPortHttps", "");
        String string7 = sharedPreferences2.getString("serverPort", "");
        String string8 = sharedPreferences2.getString("serverPortRtmp", "");
        if (string3 != null && string3.equals("default")) {
            string3 = "ts";
        }
        if (string5 == null) {
            return null;
        }
        char c2 = 65535;
        switch (string5.hashCode()) {
            case 3213448:
                str3 = string6;
                if (string5.equals("http")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3504631:
                str3 = string6;
                if (string5.equals("rmtp")) {
                    c2 = 1;
                    break;
                }
                break;
            case 99617003:
                str3 = string6;
                if (string5.equals("https")) {
                    c2 = 2;
                    break;
                }
                break;
            default:
                str3 = string6;
                break;
        }
        switch (c2) {
            case 0:
                if (string4 != null && !string4.startsWith("http://")) {
                    string4 = "http://" + string4;
                }
                sb = new StringBuilder();
                sb.append(string4);
                sb.append(":");
                sb.append(string7);
                break;
            case 1:
                if (string4 != null && !string4.startsWith("rmtp://")) {
                    string4 = "rmtp://" + string4;
                }
                sb = new StringBuilder();
                sb.append(string4);
                sb.append(":");
                str4 = string8;
                sb.append(str4);
                break;
            case 2:
                if (string4 != null && !string4.startsWith("https://")) {
                    string4 = "https://" + string4;
                }
                sb = new StringBuilder();
                sb.append(string4);
                sb.append(":");
                str4 = str3;
                sb.append(str4);
                break;
            default:
                if (string4 != null && !string4.startsWith("http://") && !string4.startsWith("https://")) {
                    string4 = "http://" + string4;
                }
                sb = new StringBuilder();
                sb.append(string4);
                sb.append(":");
                sb.append(string7);
                break;
        }
        sb.append("/timeshift/");
        sb.append(string);
        sb.append("/");
        sb.append(string2);
        sb.append("/");
        sb.append(str2);
        sb.append("/");
        sb.append(str);
        sb.append("/");
        sb.append(i2);
        sb.append(".");
        sb.append(string3);
        return G(sb.toString());
    }

    public static String T0(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String U(android.content.Context r18, int r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.w.U(android.content.Context, int, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:5:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String V(android.content.Context r18, int r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.w.V(android.content.Context, int, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String V0(String str) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US).parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String W(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.w.W(android.content.Context):java.lang.String");
    }

    public static void X() {
        try {
            Dialog dialog = u;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            u.dismiss();
        } catch (Exception unused) {
        }
    }

    public static void Y(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void Z(Context context) {
        LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(context);
        u7.a aVar = new u7.a(context);
        ArrayList activeEPGSource = liveStreamDBHandler.getActiveEPGSource();
        String valueOf = (activeEPGSource == null || activeEPGSource.size() <= 0) ? "0" : String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto());
        if (valueOf.equals("0")) {
            return;
        }
        ImportStatusModel importStatusModel = liveStreamDBHandler.getdateDBStatus("epg", valueOf);
        if (importStatusModel.getStatus() == null && importStatusModel.getTime() == null && importStatusModel.getType() == null) {
            importStatusModel = new ImportStatusModel();
            importStatusModel.setType("epg");
            importStatusModel.setStatus("0");
            importStatusModel.setDate("");
            importStatusModel.setTime("");
            importStatusModel.setSourceRef(valueOf);
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, importStatusModel);
            liveStreamDBHandler.importDataStatusArrayList(arrayList, SharepreferenceDBHandler.getCurrentAPPType(context));
        }
        if ((importStatusModel.getStatus() == null || !importStatusModel.getStatus().equals("2")) && (importStatusModel.getStatus() == null || !importStatusModel.getStatus().equals("0"))) {
            if (importStatusModel.getStatus() == null || !importStatusModel.getStatus().equals("1")) {
                if (importStatusModel.getStatus() != null) {
                    importStatusModel.getStatus().equals("3");
                    return;
                }
                return;
            } else {
                long C = C(new SimpleDateFormat("dd/MM/yyyy", Locale.US), importStatusModel.getDate(), q());
                if (!n(context) || C < aVar.h()) {
                    return;
                }
            }
        }
        a0(liveStreamDBHandler, valueOf, context);
    }

    public static /* synthetic */ Response a(Interceptor.Chain chain) {
        return j0(chain);
    }

    public static void a0(LiveStreamDBHandler liveStreamDBHandler, String str, Context context) {
        if (m7.a.I0) {
            m7.a.I0 = false;
        }
        liveStreamDBHandler.updateImportStatus("epg", "3");
        new l(r0(str), context, liveStreamDBHandler).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static /* synthetic */ Response b(Interceptor.Chain chain) {
        return l0(chain);
    }

    public static boolean b0(long j2, long j3, Context context) {
        if (context != null) {
            try {
                long millis = LocalDateTime.now().toDateTime().getMillis() + S(context);
                if (j2 <= millis && j3 >= millis) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static /* synthetic */ WindowInsets c(View view, WindowInsets windowInsets) {
        return e0(view, windowInsets);
    }

    public static String c0(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    public static /* synthetic */ Response d(Interceptor.Chain chain) {
        return f0(chain);
    }

    public static String d0(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static /* synthetic */ void e(DialogInterface dialogInterface, int i2) {
        i0(dialogInterface, i2);
    }

    public static /* synthetic */ WindowInsets e0(View view, WindowInsets windowInsets) {
        Insets a2 = m0.a(windowInsets, n.a());
        view.setPadding(0, J.a(a2), 0, L.a(a2));
        return windowInsets;
    }

    public static /* synthetic */ Response f(Interceptor.Chain chain) {
        return g0(chain);
    }

    public static /* synthetic */ Response f0(Interceptor.Chain chain) {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", "IPTVSmartersPlayer").build());
    }

    public static /* synthetic */ void g(Context context, DialogInterface dialogInterface, int i2) {
        h0(context, dialogInterface, i2);
    }

    public static /* synthetic */ Response g0(Interceptor.Chain chain) {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", "IPTVSmartersPlayer").build());
    }

    public static /* synthetic */ Response h(Interceptor.Chain chain) {
        return k0(chain);
    }

    public static /* synthetic */ void h0(Context context, DialogInterface dialogInterface, int i2) {
        if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api")) {
            if (context != null) {
                context.startActivity(new Intent(context, ImportOneStreamActivity.class));
            }
        } else if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("m3u")) {
            m0(context);
        }
        dialogInterface.dismiss();
    }

    public static Boolean i(Context context) {
        return context != null ? Boolean.valueOf(new t1.c(context, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk8jH+eNvdwbyf+4Rt4DcLFubCulWdwmVUattc8fbm1bcWLxsEdBl38RJx6ldeNfJkOTfU3If4R3+5bDEopvk8ymDUXlHVsQR8CiH8zS9Q34ax7WHXXvqhzMkzCAO5V91KWfkf+Pk+ec4bPPSZHsTDIa3ASTqTJWUfymB3xEOKiPc0PJeIzGIm/bWuyV9UWaShs32MzObNDYXQZ+g8ktftNeXoHsoxvmanNhY8cjGcvMAL8j0bHC4iTb2H/CTLIW1IUZ2D8ps+DpU+ZTh8DH8DVIdRaS6FgDjaItuJOLm2PA0a6UJgpukdW2NWEZH2tRwFtDH3D19N883sv8RCPK6AwIDAQAB", "12141350975697687473", new i()).p("com.nst.smartersplayer.billing")) : Boolean.FALSE;
    }

    public static /* synthetic */ void i0(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
    }

    public static void j(Context context) {
        context.startActivity(new Intent(context, NewDashboardActivity.class));
    }

    public static /* synthetic */ Response j0(Interceptor.Chain chain) {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", "IPTVSmartersPlayer").build());
    }

    public static /* synthetic */ PopupWindow k() {
        return i;
    }

    public static /* synthetic */ Response k0(Interceptor.Chain chain) {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", "IPTVSmartersPlayer").build());
    }

    public static boolean l(String str, Context context) {
        if (context != null) {
            try {
                context.getPackageManager().getPackageInfo(str, 1);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static /* synthetic */ Response l0(Interceptor.Chain chain) {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", "IPTVSmartersPlayer").build());
    }

    public static void m(Context context) {
        if (context != null) {
            String string = context.getSharedPreferences("selected_language", 0).getString("selected_language", "");
            if (string.equals("")) {
                return;
            }
            J0(context, string);
        }
    }

    public static void m0(Context context) {
        if (context != null && m7.a.u.booleanValue() && SharepreferenceDBHandler.getCurrentAPPType(context).equals("m3u")) {
            context.startActivity(new Intent(context, ImportM3uActivity.class));
        }
    }

    public static boolean n(Context context) {
        return context.getSharedPreferences("automation_epg", 0).getString("automation_epg", "").equals("checked");
    }

    public static void n0(Context context) {
        ActivityManager activityManager;
        if (context != null) {
            m7.a.b0.booleanValue();
            if (m7.a.p1 && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(10);
                if (!runningTasks.isEmpty()) {
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        if (m.a(runningTaskInfo) != null) {
                            String className = m.a(runningTaskInfo).getClassName();
                            MyApplication.E("topActivity : " + className);
                            if (className.equals(NSTIJKPlayerSkyActivity.class.getName()) || className.equals(NSTEXOPlayerSkyActivity.class.getName()) || className.equals(HoneyPlayer.class.getName()) || className.equals(ExoDownloadedPlayerTwo.class.getName()) || className.equals(ExoPlayerMoviesSeries.class.getName())) {
                                p0.a.b(context).d(new Intent("pip_mode_switch_user"));
                            }
                        }
                    }
                }
            }
            MyApplication.p().I();
            m7.a.b0 = Boolean.FALSE;
            Intent intent = m7.a.t.booleanValue() ? new Intent(context, MultiUserActivity.class) : (m7.a.u.booleanValue() && m7.a.v.booleanValue()) ? new Intent(context, RoutingActivity.class) : m7.a.r.booleanValue() ? new Intent(context, LoginM3uActivity.class) : m7.a.p.booleanValue() ? new Intent(context, LoginActivityOneStream.class) : new Intent(context, LoginActivity.class);
            SharedPreferences sharedPreferences = context.getSharedPreferences("loginPrefs", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString("selectedEPGShift", "");
            edit.clear();
            edit.apply();
            edit.putString("selectedEPGShift", string);
            edit.apply();
            SharedPreferences.Editor edit2 = context.getSharedPreferences("sharedprefremberme", 0).edit();
            edit2.clear();
            edit2.apply();
            if (m7.a.u.booleanValue() && m7.a.v.booleanValue()) {
                SharedPreferences.Editor edit3 = context.getSharedPreferences("sharedprefremberme", 0).edit();
                edit3.putBoolean("savelogin", false);
                edit3.apply();
                if (SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("m3u")) {
                    SharedPreferences.Editor edit4 = context.getSharedPreferences("sharedprefremberme", 0).edit();
                    edit4.clear();
                    edit4.apply();
                }
            }
            if (m7.a.s.booleanValue() && !(m7.a.u.booleanValue() && m7.a.v.booleanValue())) {
                context.startActivity(intent);
            } else {
                context.startActivity(intent);
                ((Activity) context).finish();
            }
        }
    }

    public static boolean o(Context context) {
        w4.h q2 = w4.h.q();
        int i2 = q2.i(context);
        if (i2 == 0) {
            return true;
        }
        q2.m(i2);
        return false;
    }

    public static String o0(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String p() {
        return V0(Calendar.getInstance().getTime().toString());
    }

    public static String p0(String str) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US).parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String q() {
        return p0(Calendar.getInstance().getTime().toString());
    }

    public static int q0(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static void r(Context context) {
        try {
            s(context.getCacheDir());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int r0(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static boolean s(File file) {
        if (file == null || !file.isDirectory()) {
            if (file == null || !file.isFile()) {
                return false;
            }
            return file.delete();
        }
        for (String str : file.list()) {
            if (!s(new File(file, str))) {
                return false;
            }
        }
        return file.delete();
    }

    public static String[] s0() {
        return Build.VERSION.SDK_INT >= 33 ? s : t;
    }

    public static void t(File file) {
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    t(file2);
                }
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    public static void t0(Context context, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        l = new u7.a(context);
        Intent intent = new Intent(context, NSTIJKPlayerEPGActivity.class);
        intent.putExtra("MultiPlayer", "true");
        intent.putExtra("OPENED_STREAM_ID", i2);
        intent.putExtra("ONESTREAM_STREAM_ID", str8);
        intent.putExtra("STREAM_TYPE", str);
        intent.putExtra("VIDEO_NUM", !str2.equals("") ? r0(str2) : -1);
        intent.putExtra("VIDEO_TITLE", str3);
        intent.putExtra("EPG_CHANNEL_ID", str4);
        intent.putExtra("EPG_CHANNEL_LOGO", str5);
        intent.putExtra("OPENED_CAT_ID", str6);
        intent.putExtra("VIDEO_URL", str7);
        context.startActivity(intent);
    }

    public static long u(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static void u0(Context context, String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intent intent;
        if (context != null) {
            try {
                String catchUpPlayerAppName = SharepreferenceDBHandler.getCatchUpPlayerAppName(context);
                if (!SharepreferenceDBHandler.getCatchUpPlayerAppName(context).equals("default") && !new ExternalPlayerDataBase(context).CheckPlayerExistense(catchUpPlayerAppName)) {
                    SharepreferenceDBHandler.setCatchUpPlayer("default", "default", context);
                }
                l = new u7.a(context);
                String catchUpPlayerPkgName = SharepreferenceDBHandler.getCatchUpPlayerPkgName(context);
                if (!catchUpPlayerPkgName.equals("default")) {
                    String T = T(context, i2, str6, str8);
                    String catchUpPlayerAppName2 = SharepreferenceDBHandler.getCatchUpPlayerAppName(context);
                    Intent intent2 = new Intent(context, PlayExternalPlayerActivity.class);
                    if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api")) {
                        intent2.putExtra("url", str9);
                    } else {
                        intent2.putExtra("url", T);
                    }
                    intent2.putExtra("packagename", catchUpPlayerPkgName);
                    intent2.putExtra("app_name", catchUpPlayerAppName2);
                    context.startActivity(intent2);
                    return;
                }
                if (l.x() == 3) {
                    l.U(context.getResources().getString(a7.j.p2));
                    intent = new Intent(context, HoneyPlayer.class);
                } else {
                    intent = new Intent(context, HoneyPlayer.class);
                }
                m7.a.i = Boolean.TRUE;
                intent.putExtra("OPENED_STREAM_ID", i2);
                intent.putExtra("type", "catch_up");
                intent.putExtra("VIDEO_NUM", r0(str2));
                intent.putExtra("VIDEO_TITLE", str3);
                intent.putExtra("STREAM_START_TIME", str6);
                intent.putExtra("VIDEO_URL", str9);
                intent.putExtra("STREAM_STOP_TIME", str8);
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public static int v(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static void v0(Context context, String str, int i2, String str2, String str3, String str4, String str5, List list, String str6, String str7, String str8) {
        String str9;
        String str10;
        String str11;
        String str12;
        Intent intent;
        String str13;
        String str14;
        String str15;
        String str16;
        Intent intent2;
        if (context != null) {
            String seriesPlayerPkgName = SharepreferenceDBHandler.getSeriesPlayerPkgName(context);
            String str17 = "VIDEO_TITLE";
            String str18 = "type";
            if (seriesPlayerPkgName.equals("default_native")) {
                l = new u7.a(context);
                String str19 = SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("m3u") ? "series_m3u" : "series";
                if (l.x() == 3) {
                    l.U(context.getResources().getString(a7.j.p2));
                    intent2 = new Intent(context, ExoPlayerMoviesSeries.class);
                    intent2.putExtra("type", str19);
                    intent2.putExtra("OPENED_STREAM_ID", i2);
                    intent2.putExtra("STREAM_TYPE", str2);
                    int r0 = r0(str4);
                    intent2.putExtra("tmdb_id", str8);
                    intent2.putExtra("VIDEO_NUM", r0);
                    intent2.putExtra("VIDEO_TITLE", str5);
                    str16 = str3;
                    str14 = "CONTAINER_EXTENSION";
                    intent2.putExtra(str14, str16);
                    intent2.putExtra("EPISODES", (Serializable) list);
                    str18 = "type";
                    str13 = "STREAM_TYPE";
                    str15 = "VIDEO_URL";
                    intent2.putExtra(str15, str6);
                } else {
                    str13 = "STREAM_TYPE";
                    str14 = "CONTAINER_EXTENSION";
                    str15 = "VIDEO_URL";
                    str16 = str3;
                    intent2 = new Intent(context, ExoPlayerMoviesSeries.class);
                    intent2.putExtra("tmdb_id", str8);
                }
                intent2.putExtra(str18, str19);
                intent2.putExtra("ONESTREAM_STREAM_ID", str7);
                intent2.putExtra("tmdb_id", str8);
                intent2.putExtra("OPENED_STREAM_ID", i2);
                intent2.putExtra(str13, str2);
                intent2.putExtra("VIDEO_NUM", r0(str4));
                intent2.putExtra("VIDEO_TITLE", str5);
                intent2.putExtra(str14, str16);
                intent2.putExtra("EPISODES", (Serializable) list);
                intent2.putExtra(str15, str6);
                context.startActivity(intent2);
                return;
            }
            if (!seriesPlayerPkgName.equals("default")) {
                String U = (SharepreferenceDBHandler.getCurrentAPPType(context).equals("m3u") || SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("stalker_api") || SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api")) ? str6 : U(context, i2, str3, "series");
                String seriesPlayerAppName = SharepreferenceDBHandler.getSeriesPlayerAppName(context);
                Intent intent3 = new Intent(context, PlayExternalPlayerActivity.class);
                intent3.putExtra("url", U);
                intent3.putExtra("packagename", seriesPlayerPkgName);
                intent3.putExtra("app_name", seriesPlayerAppName);
                context.startActivity(intent3);
                return;
            }
            l = new u7.a(context);
            String str20 = SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("m3u") ? "series_m3u" : SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("stalker_api") ? "movies_stalker" : "series";
            if (l.x() == 3) {
                l.U(context.getResources().getString(a7.j.p2));
                Intent intent4 = new Intent(context, HoneyPlayer.class);
                intent4.putExtra("type", str20);
                intent4.putExtra("OPENED_STREAM_ID", i2);
                intent4.putExtra("ONESTREAM_STREAM_ID", str7);
                intent4.putExtra("STREAM_TYPE", str2);
                int r02 = r0(str4);
                intent4.putExtra("tmdb_id", str8);
                intent4.putExtra("VIDEO_NUM", r02);
                str17 = "VIDEO_TITLE";
                str10 = str5;
                intent4.putExtra(str17, str10);
                intent4.putExtra("CONTAINER_EXTENSION", str3);
                intent4.putExtra("EPISODES", (Serializable) list);
                str12 = "EPISODES";
                intent4.putExtra("VIDEO_URL", str6);
                intent = intent4;
                str11 = "VIDEO_URL";
                str9 = str3;
            } else {
                str9 = str3;
                str10 = str5;
                str11 = "VIDEO_URL";
                str12 = "EPISODES";
                intent = new Intent(context, HoneyPlayer.class);
            }
            intent.putExtra("type", str20);
            intent.putExtra("OPENED_STREAM_ID", i2);
            intent.putExtra("STREAM_TYPE", str2);
            int r03 = r0(str4);
            intent.putExtra("ONESTREAM_STREAM_ID", str7);
            intent.putExtra("VIDEO_NUM", r03);
            intent.putExtra(str17, str10);
            intent.putExtra("tmdb_id", str8);
            intent.putExtra("CONTAINER_EXTENSION", str9);
            intent.putExtra(str12, (Serializable) list);
            intent.putExtra(str11, str6);
            context.startActivity(intent);
        }
    }

    public static void w(Activity activity, View view) {
        if (activity != null && Build.VERSION.SDK_INT >= 35) {
            Window window = activity.getWindow();
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
            W.b(window, false);
            view.setOnApplyWindowInsetsListener(new v());
        }
    }

    public static void w0(Context context, String str, int i2, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, String str9) {
        Intent intent;
        if (context != null) {
            String str10 = SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("m3u") ? "movies_m3u" : SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("stalker_api") ? "movies_stalker" : "movies";
            String vODPlayerAppName = SharepreferenceDBHandler.getVODPlayerAppName(context);
            String vODPlayerPkgName = SharepreferenceDBHandler.getVODPlayerPkgName(context);
            if (!vODPlayerPkgName.equals("default_native")) {
                if (!vODPlayerPkgName.equals("default")) {
                    String str11 = str6;
                    if (!SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("m3u") && !SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("stalker_api") && !SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("onestream_api")) {
                        str11 = U(context, i2, str3, "movie");
                    }
                    Intent intent2 = new Intent(context, PlayExternalPlayerActivity.class);
                    intent2.putExtra("url", str11);
                    intent2.putExtra("packagename", vODPlayerPkgName);
                    intent2.putExtra("app_name", vODPlayerAppName);
                    context.startActivity(intent2);
                    return;
                }
                u7.a aVar = new u7.a(context);
                l = aVar;
                Intent intent3 = aVar.x() == 3 ? new Intent(context, ExoPlayerMoviesSeriesActivity.class) : new Intent(context, HoneyPlayer.class);
                if (SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("m3u")) {
                    intent3.putExtra("cat_id", str9);
                }
                intent3.putExtra("type", str10);
                intent3.putExtra("OPENED_STREAM_ID", i2);
                intent3.putExtra("ONESTREAM_STREAM_ID", str7);
                intent3.putExtra("STREAM_TYPE", str2);
                intent3.putExtra("STREAM_TOTAL_DURATION", i3);
                int r0 = r0(str4);
                intent3.putExtra("tmdb_id", str8);
                intent3.putExtra("VIDEO_NUM", r0);
                intent3.putExtra("VIDEO_TITLE", str5);
                intent3.putExtra("CONTAINER_EXTENSION", str3);
                intent3.putExtra("VIDEO_URL", str6);
                context.startActivity(intent3);
                return;
            }
            l = new u7.a(context);
            Log.i("playerISHere", "playerIS:" + str);
            if (l.x() == 3) {
                intent = new Intent(context, ExoPlayerMoviesSeriesActivity.class);
                intent.putExtra("tmdb_id", str8);
            } else {
                Log.i("herePlayer", "honey");
                intent = new Intent(context, ExoPlayerMoviesSeries.class);
                Log.i("calledExoMovieSeries", "calledd");
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("m3u")) {
                intent.putExtra("cat_id", str9);
            }
            intent.putExtra("type", str10);
            intent.putExtra("OPENED_STREAM_ID", i2);
            intent.putExtra("STREAM_TYPE", str2);
            intent.putExtra("STREAM_TOTAL_DURATION", i3);
            int r02 = r0(str4);
            intent.putExtra("VIDEO_NUM", r02);
            intent.putExtra("VIDEO_TITLE", str5);
            intent.putExtra("ONESTREAM_STREAM_ID", str7);
            intent.putExtra("tmdb_id", str8);
            intent.putExtra("cat_id", str3);
            intent.putExtra("VIDEO_URL", str6);
            context.startActivity(intent);
            Log.i("DataforPlay", "type:" + str10 + "\nOPENED_STREAM_ID" + i2 + "\nSTREAM_TYPE" + str2 + "\nSTREAM_TOTAL_DURATION" + i3 + "\nindex" + r02 + "\nVIDEO_NUM" + r02 + "\nVIDEO_TITLE" + str5 + "\nCONTAINER_EXTENSION" + str3 + "\nVIDEO_URL" + str6);
        }
    }

    public static long x(String str, Context context) {
        if (str == null) {
            return 0L;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(new u7.a(context).C()));
            return simpleDateFormat.parse(str.substring(0, 14)).getTime();
        } catch (NumberFormatException e2) {
            Log.e("XMLTVReader", "Exception", e2);
            return 0L;
        } catch (Exception e3) {
            Log.e("XMLTVReader", "Exception", e3);
            return 0L;
        }
    }

    public static void x0(Context context, String str, int i2, String str2, int i3, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (context != null) {
            l = new u7.a(context);
            String livePlayerPkgName = SharepreferenceDBHandler.getLivePlayerPkgName(context);
            Intent intent = (livePlayerPkgName == null || !livePlayerPkgName.equalsIgnoreCase("default")) ? new Intent(context, NSTEXOPlayerSkyActivity.class) : new Intent(context, NSTIJKPlayerSkyActivity.class);
            intent.putExtra("OPENED_STREAM_ID", i2);
            intent.putExtra("STREAM_TYPE", str2);
            intent.putExtra("VIDEO_NUM", i3);
            intent.putExtra("VIDEO_TITLE", str3);
            intent.putExtra("EPG_CHANNEL_ID", str4);
            intent.putExtra("EPG_CHANNEL_LOGO", str5);
            intent.putExtra("OPENED_CAT_ID", str6);
            intent.putExtra("VIDEO_URL", str7);
            intent.putExtra("OPENED_CAT_NAME", str8);
            context.startActivity(intent);
        }
    }

    public static void y(Context context) {
        String S0 = S0(w7.a.a());
        String packageName = context.getApplicationContext().getPackageName();
        String c0 = c0(context);
        String S02 = S0(w7.d.d());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US);
        if (u(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(context))), simpleDateFormat.format(new Date())) < w7.c.p() || S0 == null || S02 == null) {
            return;
        }
        if (c0.equals(S0) && packageName.equals(S02)) {
            return;
        }
        Toast.makeText(context, S0(w7.k.a() + w7.k.i()) + S0(com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.c.i() + com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.c.h()) + S0(com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.b.f() + com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.b.h()), 1).show();
        ((Activity) context).finishAffinity();
    }

    public static void y0(Context context, String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intent intent;
        if (context != null) {
            String ePGPlayerAppName = SharepreferenceDBHandler.getEPGPlayerAppName(context);
            if (!SharepreferenceDBHandler.getEPGPlayerPKGName(context).equals("default") && !new ExternalPlayerDataBase(context).CheckPlayerExistense(ePGPlayerAppName)) {
                SharepreferenceDBHandler.setEPGPlayer("default", "default", context);
            }
            String ePGPlayerPKGName = SharepreferenceDBHandler.getEPGPlayerPKGName(context);
            String str10 = "";
            if (ePGPlayerPKGName.equals("default")) {
                u7.a aVar = new u7.a(context);
                l = aVar;
                if (aVar.x() == 3) {
                    l.U(context.getResources().getString(a7.j.p2));
                    intent = new Intent(context, NSTIJKPlayerEPGActivity.class);
                } else {
                    intent = new Intent(context, NSTIJKPlayerEPGActivity.class);
                }
                intent.putExtra("MultiPlayer", "false");
                intent.putExtra("OPENED_STREAM_ID", i2);
                intent.putExtra("ONESTREAM_STREAM_ID", str9);
                intent.putExtra("STREAM_TYPE", str2);
                intent.putExtra("VIDEO_NUM", !str3.equals("") ? r0(str3) : -1);
                intent.putExtra("VIDEO_TITLE", str4);
                intent.putExtra("EPG_CHANNEL_ID", str5);
                intent.putExtra("EPG_CHANNEL_LOGO", str6);
                intent.putExtra("OPENED_CAT_ID", str7);
                intent.putExtra("VIDEO_URL", str8);
                context.startActivity(intent);
                return;
            }
            String string = context.getSharedPreferences("allowedFormat", 0).getString("allowedFormat", "");
            if (string == null || string.isEmpty() || string.equals("") || !string.equals("default")) {
                if (string != null && !string.isEmpty() && !string.equals("") && string.equals("ts")) {
                    str10 = ".ts";
                } else if (string != null && !string.isEmpty() && !string.equals("") && string.equals("m3u8")) {
                    str10 = ".m3u8";
                }
            }
            String V = SharepreferenceDBHandler.getCurrentAPPType(context).equalsIgnoreCase("m3u") ? str8 : V(context, i2, str10, "live");
            String ePGPlayerAppName2 = SharepreferenceDBHandler.getEPGPlayerAppName(context);
            Intent intent2 = new Intent(context, PlayExternalPlayerActivity.class);
            intent2.putExtra("url", V);
            intent2.putExtra("packagename", ePGPlayerPKGName);
            intent2.putExtra("app_name", ePGPlayerAppName2);
            context.startActivity(intent2);
        }
    }

    public static Retrofit z(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return new Retrofit.Builder().baseUrl("http://51.158.145.183/").client(builder.connectTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).readTimeout(60L, timeUnit).followRedirects(false).build()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static void z0(Context context) {
        if (SharepreferenceDBHandler.getMaintanceModeState(context)) {
            context.startActivity(new Intent(context, MaintanencePannelActivity.class));
        } else {
            Log.e("Hrh", "no rediret");
        }
    }

    public void K0(RecordingActivity recordingActivity, File file, Q q2, ArrayList arrayList, TextView textView) {
        if (recordingActivity != null) {
            RelativeLayout findViewById = recordingActivity.findViewById(a7.f.We);
            LayoutInflater layoutInflater = (LayoutInflater) recordingActivity.getSystemService("layout_inflater");
            u7.a aVar = new u7.a(recordingActivity);
            l = aVar;
            View inflate = layoutInflater.inflate(aVar.A().equals(m7.a.K0) ? a7.g.s2 : a7.g.r2, findViewById);
            PopupWindow popupWindow = new PopupWindow(recordingActivity);
            i = popupWindow;
            popupWindow.setContentView(inflate);
            i.setWidth(-1);
            i.setHeight(-1);
            i.setFocusable(true);
            i.showAtLocation(inflate, 17, 0, 0);
            Button findViewById2 = inflate.findViewById(a7.f.L0);
            Button findViewById3 = inflate.findViewById(a7.f.o0);
            if (findViewById2 != null) {
                findViewById2.setOnFocusChangeListener(new k((View) findViewById2, recordingActivity));
                findViewById2.requestFocus();
                findViewById2.requestFocusFromTouch();
            }
            if (findViewById3 != null) {
                findViewById3.setOnFocusChangeListener(new k((View) findViewById3, recordingActivity));
            }
            findViewById3.setOnClickListener(new g());
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new h(file, recordingActivity, arrayList, q2, textView));
            }
        }
    }

    public void L0(Activity activity) {
        if (activity != null) {
            RelativeLayout findViewById = activity.findViewById(a7.f.We);
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
            u7.a aVar = new u7.a(activity);
            l = aVar;
            View inflate = layoutInflater.inflate(aVar.A().equals(m7.a.K0) ? a7.g.x2 : a7.g.w2, findViewById);
            PopupWindow popupWindow = new PopupWindow(activity);
            i = popupWindow;
            popupWindow.setContentView(inflate);
            i.setWidth(-1);
            i.setHeight(-1);
            i.setFocusable(true);
            i.showAtLocation(inflate, 17, 0, 0);
            Button findViewById2 = inflate.findViewById(a7.f.L0);
            Button findViewById3 = inflate.findViewById(a7.f.o0);
            if (findViewById2 != null) {
                findViewById2.setOnFocusChangeListener(new k((View) findViewById2, activity));
            }
            if (findViewById3 != null) {
                findViewById3.setOnFocusChangeListener(new k((View) findViewById3, activity));
            }
            findViewById3.setOnClickListener(new a());
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new b(activity));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void O0(android.app.Activity r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.w.O0(android.app.Activity, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String):void");
    }

    public void U0(Context context, String str) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("downloadStatus", 0);
            k = sharedPreferences;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("downloadStatus", str);
            edit.apply();
        }
    }

    public static class l extends AsyncTask {
        public final Context a;
        public final LiveStreamDBHandler b;
        public ArrayList c;
        public B7.d d;
        public String e;

        public l(int i, Context context, LiveStreamDBHandler liveStreamDBHandler) {
            this.e = "0";
            this.e = String.valueOf(i);
            this.a = context;
            this.b = liveStreamDBHandler;
        }

        public static /* synthetic */ LiveStreamDBHandler a(l lVar) {
            return lVar.b;
        }

        public static /* synthetic */ ArrayList b(l lVar) {
            return lVar.c;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            LiveStreamDBHandler liveStreamDBHandler;
            if (!this.e.equals("0") && (liveStreamDBHandler = this.b) != null) {
                liveStreamDBHandler.makeEmptyEPGWithSourceRef(this.e);
            }
            B7.d dVar = new B7.d();
            this.d = dVar;
            dVar.a(this.a);
            ArrayList b = this.d.b();
            this.c = b;
            if (b != null && b.size() > 0) {
                return Boolean.TRUE;
            }
            LiveStreamDBHandler liveStreamDBHandler2 = this.b;
            if (liveStreamDBHandler2 == null || liveStreamDBHandler2.getEPGCountWithSourceRef(this.e) == 0) {
                return Boolean.FALSE;
            }
            this.b.updateImportStatus("epg", "1", this.e);
            return Boolean.TRUE;
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            LiveStreamDBHandler liveStreamDBHandler;
            String str;
            try {
                if (bool.booleanValue()) {
                    m7.a.I0 = false;
                    ArrayList arrayList = this.c;
                    if (arrayList == null || arrayList.size() <= 0) {
                        return;
                    }
                    try {
                        w.r = new a(this.a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    } catch (Exception unused) {
                        liveStreamDBHandler = this.b;
                        str = "0";
                    }
                } else {
                    liveStreamDBHandler = this.b;
                    str = "2";
                }
                liveStreamDBHandler.updateImportStatus("epg", str, this.e);
            } catch (Exception unused2) {
            }
        }

        public class a extends AsyncTask {
            public volatile boolean a = true;
            public Context b;

            public a(Context context) {
                this.b = context;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(String... strArr) {
                publishProgress(new Integer[]{0});
                if (l.a(l.this) != null) {
                    l.a(l.this).addEPGTesting2(l.b(l.this));
                    l.b(l.this).clear();
                    l.a(l.this).updateImportStatus("epg", "1", l.this.e);
                }
                return Boolean.TRUE;
            }

            public void onCancelled() {
                this.a = false;
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onProgressUpdate(Integer... numArr) {
            }

            public void onPreExecute() {
            }
        }

        public void onPreExecute() {
        }
    }

    public class i implements c.c {
        public void a() {
        }

        public void c() {
        }

        public void b(int i, Throwable th) {
        }
    }
}
