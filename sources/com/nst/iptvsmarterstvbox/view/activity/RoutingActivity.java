package com.nst.iptvsmarterstvbox.view.activity;

import P.x0;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import g7.a;
import j$.util.Objects;
import java.util.Map;
import m7.w;
import p7.k0;
import p7.l0;
import p7.m0;
import p7.n0;
import p7.o0;
import p7.p0;
import p7.q0;
import p7.r0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RoutingActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public static u7.a P;
    public TextView A;
    public ImageView B;
    public RelativeLayout C;
    public ImageView D;
    public TextView E;
    public ImageView F;
    public Dialog H;
    public long I;
    public RelativeLayout J;
    public RelativeLayout K;
    public RelativeLayout L;
    public TextView M;
    public androidx.appcompat.app.a N;
    public RelativeLayout d;
    public ImageView e;
    public TextView f;
    public ImageView g;
    public RelativeLayout h;
    public ImageView i;
    public TextView j;
    public ImageView k;
    public RelativeLayout l;
    public ImageView m;
    public TextView n;
    public ImageView o;
    public RelativeLayout p;
    public ImageView q;
    public TextView r;
    public ImageView s;
    public RelativeLayout t;
    public ImageView u;
    public TextView v;
    public ImageView w;
    public TextView x;
    public RelativeLayout y;
    public ImageView z;
    public Context G = this;
    public final androidx.activity.result.c O = registerForActivityResult(new b.b(), new p0(this));

    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            ((InputMethodManager) textView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            return true;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://www.iptvsmarters.com/terms-and-conditions/"));
                RoutingActivity.this.startActivity(intent);
            } catch (Exception unused) {
                Toast.makeText(RoutingActivity.this.getApplicationContext(), "Your Device Not Supported !!", 1).show();
            }
        }
    }

    public class c extends WebViewClient {
        public c() {
        }

        public void onPageFinished(WebView webView, String str) {
            RoutingActivity.x1(RoutingActivity.this).setVisibility(0);
            RoutingActivity.y1(RoutingActivity.this).setVisibility(0);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SuppressLint({"ApplySharedPref"})
        public void onClick(View view) {
            RoutingActivity.this.getSharedPreferences("Accept_clicked", 0).edit().putString("Accept_clicked", "true").apply();
            RoutingActivity.z1(RoutingActivity.this).dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @SuppressLint({"ApplySharedPref"})
        public void onClick(View view) {
            RoutingActivity.this.finishAffinity();
        }
    }

    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class g implements a.g {
        public final /* synthetic */ String[] a;

        public g(String[] strArr) {
            this.a = strArr;
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", RoutingActivity.this.getPackageName(), (String) null));
                RoutingActivity.this.startActivityForResult(intent, 101);
                Toast.makeText(RoutingActivity.A1(RoutingActivity.this), RoutingActivity.A1(RoutingActivity.this).getResources().getString(a7.j.o2), 1).show();
            } catch (Exception unused) {
            }
            RoutingActivity.B1(RoutingActivity.this).dismiss();
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            RoutingActivity.B1(RoutingActivity.this).dismiss();
        }
    }

    public class j implements View.OnClickListener {
        public final /* synthetic */ EditText a;

        public j(EditText editText) {
            this.a = editText;
        }

        public void onClick(View view) {
            Context applicationContext;
            Resources resources;
            int i;
            Intent intent;
            String trim = this.a.getText().toString().trim();
            String substring = trim.substring(trim.lastIndexOf("/") + 1);
            if (TextUtils.isEmpty(trim)) {
                applicationContext = RoutingActivity.this.getApplicationContext();
                resources = RoutingActivity.this.getResources();
                i = a7.j.q5;
            } else if (!trim.contains("https") && (!trim.contains("http") || !trim.contains("//") || !trim.contains(".") || !trim.contains("/") || !trim.contains(":") || !substring.contains("."))) {
                applicationContext = RoutingActivity.this.getApplicationContext();
                resources = RoutingActivity.this.getResources();
                i = a7.j.n5;
            } else {
                if (!trim.endsWith(".com") && (trim.startsWith("https") || trim.startsWith("http"))) {
                    if (RoutingActivity.A1(RoutingActivity.this) != null) {
                        RoutingActivity.D1(new u7.a(RoutingActivity.A1(RoutingActivity.this)));
                        if (RoutingActivity.C1().x() == 3) {
                            RoutingActivity.C1().U(RoutingActivity.A1(RoutingActivity.this).getResources().getString(a7.j.p2));
                            intent = new Intent(RoutingActivity.A1(RoutingActivity.this), HoneyPlayer.class);
                        } else {
                            intent = new Intent(RoutingActivity.A1(RoutingActivity.this), HoneyPlayer.class);
                        }
                        intent.putExtra("type", "loadurl");
                        intent.putExtra("VIDEO_NUM", 0);
                        intent.putExtra("VIDEO_PATH", trim);
                        RoutingActivity.A1(RoutingActivity.this).startActivity(intent);
                        return;
                    }
                    return;
                }
                applicationContext = RoutingActivity.this.getApplicationContext();
                resources = RoutingActivity.this.getResources();
                i = a7.j.b0;
            }
            Toast.makeText(applicationContext, resources.getString(i), 1).show();
        }
    }

    public class k implements View.OnFocusChangeListener {
        public final View a;

        public k(View view) {
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
            RelativeLayout y1;
            int i;
            ImageView imageView;
            int i2;
            RelativeLayout y12;
            ImageView imageView2;
            int i3;
            if (!z) {
                if (z) {
                    return;
                }
                float f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("rl_login_with_m3u")) {
                    View view3 = this.a;
                    if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("rl_login_with_xtream_codes_api")) {
                        View view4 = this.a;
                        if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("rl_play_onestream")) {
                            View view5 = this.a;
                            if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("rl_login_with_stalker")) {
                                View view6 = this.a;
                                if (view6 == null || view6.getTag() == null || !this.a.getTag().equals("rl_play_from_device")) {
                                    View view7 = this.a;
                                    if (view7 == null || view7.getTag() == null || !this.a.getTag().equals("rl_play_single_stream")) {
                                        View view8 = this.a;
                                        if (view8 != null && view8.getTag() != null && this.a.getTag().equals("rl_list_users")) {
                                            RoutingActivity.this.t.setBackgroundResource(a7.e.Z0);
                                            RoutingActivity routingActivity = RoutingActivity.this;
                                            routingActivity.v.setTextColor(RoutingActivity.A1(routingActivity).getResources().getColor(a7.c.f));
                                            imageView2 = RoutingActivity.this.w;
                                            i3 = a7.e.x1;
                                            imageView2.setImageResource(i3);
                                            return;
                                        }
                                        View view9 = this.a;
                                        if (view9 == null || view9.getTag() == null || !this.a.getTag().equals("rl_accept")) {
                                            View view10 = this.a;
                                            if (view10 == null || view10.getTag() == null || !this.a.getTag().equals("rl_cancel")) {
                                                View view11 = this.a;
                                                if (view11 == null || view11.getTag() == null || !this.a.getTag().equals("rl_play")) {
                                                    return;
                                                }
                                                RoutingActivity.E1(RoutingActivity.this).setBackgroundResource(a7.e.d1);
                                                RoutingActivity.F1(RoutingActivity.this).setTextColor(RoutingActivity.A1(RoutingActivity.this).getResources().getColor(a7.c.f));
                                                return;
                                            }
                                            y12 = RoutingActivity.y1(RoutingActivity.this);
                                        } else {
                                            y12 = RoutingActivity.x1(RoutingActivity.this);
                                        }
                                        y12.setBackgroundResource(a7.e.o);
                                        return;
                                    }
                                    RoutingActivity.this.p.setBackgroundResource(a7.e.G);
                                    RoutingActivity routingActivity2 = RoutingActivity.this;
                                    routingActivity2.r.setTextColor(RoutingActivity.A1(routingActivity2).getResources().getColor(a7.c.f));
                                    imageView2 = RoutingActivity.this.s;
                                } else {
                                    RoutingActivity.this.l.setBackgroundResource(a7.e.G);
                                    RoutingActivity routingActivity3 = RoutingActivity.this;
                                    routingActivity3.n.setTextColor(RoutingActivity.A1(routingActivity3).getResources().getColor(a7.c.f));
                                    imageView2 = RoutingActivity.this.o;
                                }
                            } else {
                                RoutingActivity.this.y.setBackgroundResource(a7.e.G);
                                RoutingActivity routingActivity4 = RoutingActivity.this;
                                routingActivity4.A.setTextColor(RoutingActivity.A1(routingActivity4).getResources().getColor(a7.c.f));
                                imageView2 = RoutingActivity.this.B;
                            }
                        } else {
                            RoutingActivity.this.C.setBackgroundResource(a7.e.G);
                            RoutingActivity routingActivity5 = RoutingActivity.this;
                            routingActivity5.E.setTextColor(RoutingActivity.A1(routingActivity5).getResources().getColor(a7.c.f));
                            imageView2 = RoutingActivity.this.F;
                        }
                    } else {
                        RoutingActivity.this.h.setBackgroundResource(a7.e.G);
                        RoutingActivity routingActivity6 = RoutingActivity.this;
                        routingActivity6.j.setTextColor(RoutingActivity.A1(routingActivity6).getResources().getColor(a7.c.f));
                        imageView2 = RoutingActivity.this.k;
                    }
                } else {
                    RoutingActivity.this.d.setBackgroundResource(a7.e.G);
                    RoutingActivity routingActivity7 = RoutingActivity.this;
                    routingActivity7.f.setTextColor(RoutingActivity.A1(routingActivity7).getResources().getColor(a7.c.f));
                    imageView2 = RoutingActivity.this.g;
                }
                i3 = a7.e.m;
                imageView2.setImageResource(i3);
                return;
            }
            try {
                View view12 = this.a;
                if (view12 == null || view12.getTag() == null || !this.a.getTag().equals("rl_login_with_m3u")) {
                    View view13 = this.a;
                    if (view13 == null || view13.getTag() == null || !this.a.getTag().equals("rl_login_with_xtream_codes_api")) {
                        View view14 = this.a;
                        if (view14 == null || view14.getTag() == null || !this.a.getTag().equals("rl_play_onestream")) {
                            View view15 = this.a;
                            if (view15 == null || view15.getTag() == null || !this.a.getTag().equals("rl_login_with_stalker")) {
                                View view16 = this.a;
                                if (view16 == null || view16.getTag() == null || !this.a.getTag().equals("rl_play_from_device")) {
                                    View view17 = this.a;
                                    if (view17 == null || view17.getTag() == null || !this.a.getTag().equals("rl_play_single_stream")) {
                                        View view18 = this.a;
                                        if (view18 == null || view18.getTag() == null || !this.a.getTag().equals("rl_list_users")) {
                                            View view19 = this.a;
                                            if (view19 == null || view19.getTag() == null || !this.a.getTag().equals("rl_accept")) {
                                                View view20 = this.a;
                                                if (view20 == null || view20.getTag() == null || !this.a.getTag().equals("rl_cancel")) {
                                                    View view21 = this.a;
                                                    if (view21 == null || view21.getTag() == null || !this.a.getTag().equals("rl_play")) {
                                                        return;
                                                    }
                                                    RoutingActivity.E1(RoutingActivity.this).setBackgroundResource(a7.e.c1);
                                                    RoutingActivity.F1(RoutingActivity.this).setTextColor(RoutingActivity.A1(RoutingActivity.this).getResources().getColor(a7.c.G));
                                                    return;
                                                }
                                                y1 = RoutingActivity.y1(RoutingActivity.this);
                                                i = a7.e.F;
                                            } else {
                                                y1 = RoutingActivity.x1(RoutingActivity.this);
                                                i = a7.e.F;
                                            }
                                            y1.setBackgroundResource(i);
                                            return;
                                        }
                                        RoutingActivity.this.t.setBackgroundResource(a7.e.Y0);
                                        RoutingActivity routingActivity8 = RoutingActivity.this;
                                        routingActivity8.v.setTextColor(RoutingActivity.A1(routingActivity8).getResources().getColor(a7.c.G));
                                        imageView = RoutingActivity.this.w;
                                        i2 = a7.e.O2;
                                    } else {
                                        RoutingActivity.this.p.setBackgroundResource(a7.e.F);
                                        RoutingActivity routingActivity9 = RoutingActivity.this;
                                        routingActivity9.r.setTextColor(RoutingActivity.A1(routingActivity9).getResources().getColor(a7.c.G));
                                        imageView = RoutingActivity.this.s;
                                        i2 = a7.e.O2;
                                    }
                                } else {
                                    RoutingActivity.this.l.setBackgroundResource(a7.e.F);
                                    RoutingActivity routingActivity10 = RoutingActivity.this;
                                    routingActivity10.n.setTextColor(RoutingActivity.A1(routingActivity10).getResources().getColor(a7.c.G));
                                    imageView = RoutingActivity.this.o;
                                    i2 = a7.e.O2;
                                }
                            } else {
                                RoutingActivity.this.y.setBackgroundResource(a7.e.F);
                                RoutingActivity routingActivity11 = RoutingActivity.this;
                                routingActivity11.A.setTextColor(RoutingActivity.A1(routingActivity11).getResources().getColor(a7.c.G));
                                imageView = RoutingActivity.this.B;
                                i2 = a7.e.O2;
                            }
                        } else {
                            RoutingActivity.this.C.setBackgroundResource(a7.e.F);
                            RoutingActivity routingActivity12 = RoutingActivity.this;
                            routingActivity12.E.setTextColor(RoutingActivity.A1(routingActivity12).getResources().getColor(a7.c.G));
                            imageView = RoutingActivity.this.F;
                            i2 = a7.e.O2;
                        }
                    } else {
                        RoutingActivity.this.h.setBackgroundResource(a7.e.F);
                        RoutingActivity routingActivity13 = RoutingActivity.this;
                        routingActivity13.j.setTextColor(RoutingActivity.A1(routingActivity13).getResources().getColor(a7.c.G));
                        imageView = RoutingActivity.this.k;
                        i2 = a7.e.O2;
                    }
                } else {
                    RoutingActivity.this.d.setBackgroundResource(a7.e.F);
                    RoutingActivity routingActivity14 = RoutingActivity.this;
                    routingActivity14.f.setTextColor(RoutingActivity.A1(routingActivity14).getResources().getColor(a7.c.G));
                    imageView = RoutingActivity.this.g;
                    i2 = a7.e.O2;
                }
                imageView.setImageResource(i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class l implements View.OnFocusChangeListener {
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
            if (z) {
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
            }
        }
    }

    public static /* synthetic */ Context A1(RoutingActivity routingActivity) {
        return routingActivity.G;
    }

    public static /* synthetic */ androidx.appcompat.app.a B1(RoutingActivity routingActivity) {
        return routingActivity.N;
    }

    public static /* synthetic */ u7.a C1() {
        return P;
    }

    public static /* synthetic */ u7.a D1(u7.a aVar) {
        P = aVar;
        return aVar;
    }

    public static /* synthetic */ RelativeLayout E1(RoutingActivity routingActivity) {
        return routingActivity.L;
    }

    public static /* synthetic */ TextView F1(RoutingActivity routingActivity) {
        return routingActivity.M;
    }

    public static void N1(Context context) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            } else {
                O1(context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            O1(context);
        }
    }

    public static void O1(Context context) {
        try {
            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                throw new UnsupportedOperationException("Unable to open general application settings.");
            }
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void u1(RoutingActivity routingActivity, Map map) {
        routingActivity.K1(map);
    }

    public static /* synthetic */ void v1(RoutingActivity routingActivity, View view) {
        routingActivity.L1(view);
    }

    public static /* synthetic */ void w1(RoutingActivity routingActivity, View view) {
        routingActivity.M1(view);
    }

    public static /* synthetic */ RelativeLayout x1(RoutingActivity routingActivity) {
        return routingActivity.J;
    }

    public static /* synthetic */ RelativeLayout y1(RoutingActivity routingActivity) {
        return routingActivity.K;
    }

    public static /* synthetic */ Dialog z1(RoutingActivity routingActivity) {
        return routingActivity.H;
    }

    public final void G1() {
        Dialog dialog;
        int i2;
        this.H = new Dialog(this, a7.k.h);
        if (P.A().equals(m7.a.K0)) {
            dialog = this.H;
            i2 = a7.g.i1;
        } else {
            dialog = this.H;
            i2 = a7.g.h1;
        }
        dialog.setContentView(i2);
        this.H.setCancelable(false);
        Window window = this.H.getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                l0.a(window, false);
                WindowInsetsController a2 = x0.a(window);
                if (a2 != null) {
                    m0.a(a2, 2);
                    n0.a(a2, P.p0.a());
                }
            } else {
                window.getDecorView().setSystemUiVisibility(1792);
            }
            window.setLayout(-1, -1);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            window.setAttributes(attributes);
            this.H.setCanceledOnTouchOutside(false);
            this.J = this.H.findViewById(a7.f.Md);
            this.K = this.H.findViewById(a7.f.Zd);
            RelativeLayout relativeLayout = this.J;
            relativeLayout.setOnFocusChangeListener(new k(relativeLayout));
            RelativeLayout relativeLayout2 = this.K;
            relativeLayout2.setOnFocusChangeListener(new k(relativeLayout2));
            WebView findViewById = this.H.findViewById(a7.f.Vm);
            findViewById.getSettings().setJavaScriptEnabled(true);
            findViewById.loadUrl("file:///android_asset/terms.html");
            findViewById.setWebViewClient(new c());
            this.J.setOnClickListener(new d());
            this.K.setOnClickListener(new e());
            this.H.setOnDismissListener(new f());
            this.H.show();
        }
    }

    public void H1() {
        findViewById(a7.f.cb).setSystemUiVisibility(4871);
    }

    public void I1() {
        RelativeLayout relativeLayout = this.d;
        relativeLayout.setOnFocusChangeListener(new k(relativeLayout));
        RelativeLayout relativeLayout2 = this.C;
        relativeLayout2.setOnFocusChangeListener(new k(relativeLayout2));
        RelativeLayout relativeLayout3 = this.h;
        relativeLayout3.setOnFocusChangeListener(new k(relativeLayout3));
        RelativeLayout relativeLayout4 = this.l;
        relativeLayout4.setOnFocusChangeListener(new k(relativeLayout4));
        RelativeLayout relativeLayout5 = this.p;
        relativeLayout5.setOnFocusChangeListener(new k(relativeLayout5));
        RelativeLayout relativeLayout6 = this.t;
        relativeLayout6.setOnFocusChangeListener(new k(relativeLayout6));
        RelativeLayout relativeLayout7 = this.y;
        relativeLayout7.setOnFocusChangeListener(new k(relativeLayout7));
    }

    public boolean J1() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        if (i2 >= 33) {
            if (E.b.checkSelfPermission(this, "android.permission.READ_MEDIA_VIDEO") == 0 && E.b.checkSelfPermission(this, "android.permission.READ_MEDIA_AUDIO") == 0) {
                return true;
            }
            this.O.a(new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"});
            return false;
        }
        if (o0.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            Log.v("TAG", "Permission is granted");
            return true;
        }
        Log.v("TAG", "Permission is revoked");
        D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 101);
        return false;
    }

    public final /* synthetic */ void K1(Map map) {
        boolean z;
        boolean booleanValue;
        String str;
        boolean z2 = false;
        if (map != null) {
            try {
                z = (map.get("android.permission.READ_MEDIA_VIDEO") == null || !(map.get("android.permission.READ_MEDIA_VIDEO") instanceof Boolean)) ? false : ((Boolean) map.get("android.permission.READ_MEDIA_VIDEO")).booleanValue();
                try {
                    if (map.get("android.permission.READ_MEDIA_AUDIO") == null || !(map.get("android.permission.READ_MEDIA_AUDIO") instanceof Boolean)) {
                        z2 = z;
                        booleanValue = false;
                        z = z2;
                        z2 = booleanValue;
                    } else {
                        booleanValue = ((Boolean) map.get("android.permission.READ_MEDIA_AUDIO")).booleanValue();
                        z2 = z;
                        z = z2;
                        z2 = booleanValue;
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                z = false;
            }
        } else {
            booleanValue = false;
            z = z2;
            z2 = booleanValue;
        }
        if (z && z2) {
            RelativeLayout relativeLayout = this.l;
            if (relativeLayout != null) {
                relativeLayout.performClick();
                return;
            }
            return;
        }
        if (!k0.a(this, "android.permission.READ_MEDIA_VIDEO") || !k0.a(this, "android.permission.READ_MEDIA_AUDIO")) {
            if (!k0.a(this, "android.permission.READ_MEDIA_VIDEO")) {
                str = k0.a(this, "android.permission.READ_MEDIA_AUDIO") ? "Photos and Videos" : "Music and Audio \n Photos and Videos";
            }
            Q1(str);
            return;
        }
        Q1("Music and Audio");
    }

    public final /* synthetic */ void L1(View view) {
        try {
            N1(this.G);
            this.N.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final /* synthetic */ void M1(View view) {
        this.N.dismiss();
    }

    public void P1() {
        g7.a aVar = new g7.a(this.G, new g(new String[]{""}));
        if (Build.VERSION.SDK_INT >= 30) {
            aVar.x("");
        } else {
            aVar.w("");
        }
    }

    public final void Q1(String str) {
        a.a aVar = new a.a(this.G, a7.k.a);
        View inflate = LayoutInflater.from(this.G).inflate(a7.g.t2, (ViewGroup) null);
        inflate.findViewById(a7.f.i2);
        Button findViewById = inflate.findViewById(a7.f.i1);
        Button findViewById2 = inflate.findViewById(a7.f.e1);
        if (!new u7.a(this.G).A().equalsIgnoreCase(m7.a.K0)) {
            findViewById2.setFocusable(false);
            findViewById2.setFocusableInTouchMode(false);
            findViewById.setFocusable(false);
            findViewById.setFocusableInTouchMode(false);
        }
        inflate.findViewById(a7.f.gm);
        findViewById.setOnClickListener(new q0(this));
        findViewById2.setOnClickListener(new r0(this));
        findViewById.setOnFocusChangeListener(new l(findViewById));
        findViewById2.setOnFocusChangeListener(new l(findViewById2));
        aVar.setView(inflate);
        this.N = aVar.create();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        androidx.appcompat.app.a aVar2 = this.N;
        if (aVar2 != null && aVar2.getWindow() != null) {
            layoutParams.copyFrom(this.N.getWindow().getAttributes());
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.N.show();
            this.N.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            this.N.getWindow().setAttributes(layoutParams);
            this.N.setCancelable(true);
        }
        findViewById.requestFocus();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0007. Please report as an issue. */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i2, i3, intent);
        if (i2 != 101) {
            switch (i2) {
            }
        } else {
            J1();
        }
    }

    public void onBackPressed() {
        if (this.I + 2000 > System.currentTimeMillis()) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
            finishAffinity();
            finish();
        } else {
            try {
                Toast.makeText(getBaseContext(), getResources().getString(a7.j.F5), 0).show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.I = System.currentTimeMillis();
    }

    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        if (id == a7.f.Ye) {
            try {
                if (P.A().equals(m7.a.K0)) {
                    if (!J1()) {
                        return;
                    } else {
                        P1();
                    }
                } else {
                    if (!J1()) {
                        return;
                    }
                    Intent intent2 = new Intent(this, Local_media_Activity.class);
                    overridePendingTransition(a7.b.f, a7.b.d);
                    startActivity(intent2);
                    finish();
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (id == a7.f.Ce) {
            SharepreferenceDBHandler.setCurrentAPPType("m3u", this.G);
            intent = new Intent(this, LoginM3uActivity.class);
        } else if (id == a7.f.Ee) {
            SharepreferenceDBHandler.setCurrentAPPType("api", this.G);
            intent = new Intent(this, LoginActivity.class);
        } else {
            if (id == a7.f.De) {
                Toast.makeText(getApplicationContext(), "Coming Soon", 0).show();
                return;
            }
            if (id != a7.f.Ze) {
                if (id == a7.f.af) {
                    single_stream_click(view);
                    return;
                } else {
                    if (id == a7.f.Ae) {
                        on_click_list(view);
                        return;
                    }
                    return;
                }
            }
            SharepreferenceDBHandler.setCurrentAPPType("onestream_api", this.G);
            intent = new Intent(this, LoginActivityOneStream.class);
        }
        startActivity(intent);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onCreate(Bundle bundle) {
        this.G = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.G);
        P = aVar;
        String A = aVar.A();
        setContentView(m7.a.o.booleanValue() ? A.equals(m7.a.K0) ? a7.g.B0 : a7.g.A0 : A.equals(m7.a.K0) ? a7.g.C0 : a7.g.z0);
        this.d = findViewById(a7.f.Ce);
        this.e = findViewById(a7.f.u5);
        this.f = findViewById(a7.f.Uj);
        this.g = findViewById(a7.f.v5);
        this.h = findViewById(a7.f.Ee);
        this.i = findViewById(a7.f.y5);
        this.j = findViewById(a7.f.Wj);
        this.k = findViewById(a7.f.z5);
        this.l = findViewById(a7.f.Ye);
        this.m = findViewById(a7.f.J5);
        this.n = findViewById(a7.f.Qk);
        this.o = findViewById(a7.f.K5);
        this.p = findViewById(a7.f.af);
        this.q = findViewById(a7.f.O5);
        this.r = findViewById(a7.f.Sk);
        this.s = findViewById(a7.f.P5);
        this.t = findViewById(a7.f.Ae);
        this.u = findViewById(a7.f.q5);
        this.v = findViewById(a7.f.Sj);
        this.w = findViewById(a7.f.r5);
        this.x = findViewById(a7.f.Qj);
        this.y = findViewById(a7.f.De);
        this.z = findViewById(a7.f.w5);
        this.A = findViewById(a7.f.Vj);
        this.B = findViewById(a7.f.x5);
        this.C = findViewById(a7.f.Ze);
        this.D = findViewById(a7.f.M5);
        this.E = findViewById(a7.f.Rk);
        this.F = findViewById(a7.f.N5);
        this.l.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.t.setOnClickListener(this);
        if (!m7.a.o.booleanValue()) {
            if (m7.a.t.booleanValue() && m7.a.p.booleanValue() && m7.a.r.booleanValue()) {
                this.d.setVisibility(0);
            } else if (m7.a.t.booleanValue() && m7.a.p.booleanValue()) {
                this.d.setVisibility(8);
            } else {
                if (m7.a.t.booleanValue() && m7.a.r.booleanValue()) {
                    this.d.setVisibility(0);
                } else if (m7.a.p.booleanValue() && m7.a.r.booleanValue()) {
                    this.d.setVisibility(0);
                    this.h.setVisibility(8);
                    this.C.setVisibility(0);
                } else if (m7.a.t.booleanValue()) {
                    this.d.setVisibility(8);
                }
                this.h.setVisibility(0);
                this.C.setVisibility(8);
            }
            this.h.setVisibility(0);
            this.C.setVisibility(0);
        } else if (!getSharedPreferences("Accept_clicked", 0).getString("Accept_clicked", "").equals("true")) {
            G1();
        }
        this.v.setSelected(true);
        H1();
        I1();
        try {
            this.x.setOnClickListener(new b());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.e*/.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 101) {
            return;
        }
        try {
            if (iArr.length > 0 && iArr[0] == 0) {
                I1();
            } else if (Build.VERSION.SDK_INT < 23 || k0.a(this, strArr[0])) {
                Toast.makeText(this, this.G.getResources().getString(a7.j.m), 0).show();
            } else {
                a.a aVar = new a.a(this, a7.k.a);
                View inflate = LayoutInflater.from(this).inflate(a7.g.X3, (ViewGroup) null);
                Button findViewById = inflate.findViewById(a7.f.c1);
                Button findViewById2 = inflate.findViewById(a7.f.U0);
                findViewById.setOnFocusChangeListener(new l(findViewById));
                findViewById2.setOnFocusChangeListener(new l(findViewById2));
                findViewById.requestFocus();
                findViewById.setOnClickListener(new h());
                findViewById2.setOnClickListener(new i());
                aVar.setView(inflate);
                this.N = aVar.create();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.N.getWindow();
                Objects.requireNonNull(window);
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -2;
                layoutParams.height = -2;
                this.N.show();
                this.N.getWindow().setAttributes(layoutParams);
                this.N.setCancelable(false);
                this.N.show();
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.z0(this.G);
        overridePendingTransition(a7.b.f, a7.b.d);
        H1();
    }

    public void on_click_list(View view) {
        startActivity(new Intent(this, MultiUserActivity.class));
    }

    public void single_stream_click(View view) {
        try {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(P.A().equals(m7.a.K0) ? a7.g.B4 : a7.g.A4, (ViewGroup) null);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
            popupWindow.showAtLocation(inflate, 16, 0, 0);
            popupWindow.setTouchable(true);
            popupWindow.setFocusable(true);
            EditText findViewById = inflate.findViewById(a7.f.g3);
            this.L = inflate.findViewById(a7.f.Xe);
            this.M = inflate.findViewById(a7.f.Pk);
            RelativeLayout relativeLayout = this.L;
            relativeLayout.setOnFocusChangeListener(new k(relativeLayout));
            TextView textView = this.M;
            textView.setOnFocusChangeListener(new k(textView));
            this.L.setOnClickListener(new j(findViewById));
            findViewById.setOnEditorActionListener(new a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
