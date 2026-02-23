package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.OpensubtitleActivity;
import com.nst.iptvsmarterstvbox.model.MultiUserDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import com.nst.iptvsmarterstvbox.sbpfunction.callbackclientreport.ClientFeedbackCallback;
import com.nst.iptvsmarterstvbox.vpn.activities.ProfileActivity;
import d.a;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import m7.w;
import p7.A0;
import p7.B0;
import p7.C0;
import p7.D0;
import p7.E0;
import p7.F0;
import p7.G0;
import p7.H0;
import p7.I0;
import p7.J0;
import p7.K0;
import p7.L0;
import p7.M0;
import p7.N0;
import p7.O0;
import p7.P0;
import p7.Q0;
import p7.R0;
import p7.S0;
import p7.T0;
import p7.U0;
import p7.V0;
import p7.W0;
import p7.X0;
import p7.Y0;
import p7.Z0;
import p7.a1;
import p7.b1;
import p7.c1;
import p7.d1;
import p7.e1;
import p7.f1;
import p7.g1;
import p7.h1;
import p7.i1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SettingsActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public static SharedPreferences Z0;
    public static u7.a a1;
    public static PopupWindow b1;
    public LinearLayout A;
    public SharedPreferences.Editor A0;
    public CardView B;
    public String B0;
    public CardView C;
    public String C0;
    public CardView D;
    public FrameLayout D0;
    public LinearLayout E;
    public LinearLayout E0;
    public LinearLayout F;
    public Spinner F0;
    public LinearLayout G;
    public Button G0;
    public ImageView H;
    public Button H0;
    public CardView I;
    public LinearLayout I0;
    public LinearLayout J;
    public LinearLayout J0;
    public CardView K;
    public CardView K0;
    public LinearLayout L;
    public ImageView L0;
    public ImageView M;
    public ImageView M0;
    public CardView N;
    public ImageView N0;
    public LinearLayout O;
    public FrameLayout O0;
    public ImageView P;
    public ImageView P0;
    public Context Q;
    public ImageView Q0;
    public SharedPreferences R;
    public ImageView R0;
    public LiveStreamDBHandler S;
    public ImageView S0;
    public FrameLayout T0;
    public FrameLayout U0;
    public PopupWindow V;
    public FrameLayout V0;
    public FrameLayout W0;
    public FrameLayout X0;
    public Button Y;
    public TextView Y0;
    public Button Z;
    public Toolbar d;
    public CardView e;
    public CardView e0;
    public LinearLayout f;
    public LinearLayout f0;
    public CardView g;
    public ImageView g0;
    public LinearLayout h;
    public ImageView h0;
    public CardView i;
    public ImageView i0;
    public LinearLayout j;
    public ImageView j0;
    public CardView k;
    public ImageView k0;
    public LinearLayout l;
    public ImageView l0;
    public CardView m;
    public ImageView m0;
    public LinearLayout n;
    public ImageView n0;
    public CardView o;
    public ImageView o0;
    public LinearLayout p;
    public ImageView p0;
    public CardView q;
    public ImageView q0;
    public LinearLayout r;
    public ImageView r0;
    public CardView s;
    public ImageView s0;
    public LinearLayout t;
    public ImageView t0;
    public CardView u;
    public TextView v;
    public EditText v0;
    public TextView w;
    public String w0;
    public ImageView x;
    public ProgressDialog x0;
    public LinearLayout y;
    public String y0;
    public CardView z;
    public String z0;
    public DatabaseUpdatedStatusDBModel T = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel U = new DatabaseUpdatedStatusDBModel();
    public String W = "";
    public String X = "";
    public Thread u0 = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            SettingsActivity.d2(SettingsActivity.this).dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ SettingsActivity c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ String[] e;

        public b(String str, SettingsActivity settingsActivity, EditText editText, String[] strArr) {
            this.a = str;
            this.c = settingsActivity;
            this.d = editText;
            this.e = strArr;
        }

        public final boolean a(String str) {
            this.e[0] = String.valueOf(this.d.getText());
            String str2 = this.e[0];
            return (str2 == null || str2.equals("") || this.e[0].isEmpty() || str == null || str.isEmpty() || str.equals("") || !this.e[0].equals(str)) ? false : true;
        }

        public final boolean b() {
            this.e[0] = String.valueOf(this.d.getText());
            String[] strArr = this.e;
            if (strArr == null || !strArr[0].equals("")) {
                String[] strArr2 = this.e;
                return (strArr2 == null || strArr2[0].equals("")) ? false : true;
            }
            Toast.makeText(this.c, SettingsActivity.this.getResources().getString(a7.j.v1), 1).show();
            return false;
        }

        public final void c(boolean z) {
            if (z) {
                SettingsActivity.d2(SettingsActivity.this).dismiss();
                d();
            } else {
                SettingsActivity settingsActivity = this.c;
                if (settingsActivity != null) {
                    Toast.makeText(settingsActivity, SettingsActivity.this.getResources().getString(a7.j.U4), 1).show();
                }
                this.d.getText().clear();
            }
        }

        public final void d() {
            SettingsActivity.this.startActivity(new Intent(SettingsActivity.this, ParentalControlActivitity.class));
        }

        public void onClick(View view) {
            if (b()) {
                c(a(this.a));
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            SettingsActivity.d2(SettingsActivity.this).dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ String[] a;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ String[] d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ Activity f;
        public final /* synthetic */ String g;

        public d(String[] strArr, EditText editText, String[] strArr2, EditText editText2, Activity activity, String str) {
            this.a = strArr;
            this.c = editText;
            this.d = strArr2;
            this.e = editText2;
            this.f = activity;
            this.g = str;
        }

        public final boolean a() {
            String[] strArr;
            this.a[0] = String.valueOf(this.c.getText());
            this.d[0] = String.valueOf(this.e.getText());
            String[] strArr2 = this.a;
            return (strArr2 == null || strArr2[0].equals("") || (strArr = this.d) == null || strArr[0].equals("") || !this.a[0].equals(this.d[0])) ? false : true;
        }

        public final boolean b() {
            String[] strArr;
            Activity activity;
            Resources resources;
            int i;
            this.a[0] = String.valueOf(this.c.getText());
            this.d[0] = String.valueOf(this.e.getText());
            String[] strArr2 = this.a;
            if (strArr2 == null || !strArr2[0].equals("")) {
                String[] strArr3 = this.a;
                if (strArr3 == null || strArr3[0].equals("") || (strArr = this.d) == null || !strArr[0].equals("")) {
                    String[] strArr4 = this.a;
                    return (strArr4 == null || this.d == null || strArr4[0].equals("") || this.d[0].equals("")) ? false : true;
                }
                activity = this.f;
                resources = SettingsActivity.this.getResources();
                i = a7.j.T4;
            } else {
                activity = this.f;
                resources = SettingsActivity.this.getResources();
                i = a7.j.v1;
            }
            Toast.makeText(activity, resources.getString(i), 1).show();
            return false;
        }

        public final void c(boolean z) {
            if (!z) {
                Activity activity = this.f;
                if (activity != null) {
                    Toast.makeText(activity, SettingsActivity.this.getResources().getString(a7.j.V4), 1).show();
                }
                this.c.getText().clear();
                this.e.getText().clear();
                return;
            }
            PasswordDBModel passwordDBModel = new PasswordDBModel();
            passwordDBModel.setUserPassword(String.valueOf(this.a[0]));
            passwordDBModel.setUserDetail(this.g);
            passwordDBModel.setUserId(SharepreferenceDBHandler.getUserID(this.f));
            if (SettingsActivity.e2(SettingsActivity.this) != null) {
                SettingsActivity.e2(SettingsActivity.this).addPassword(passwordDBModel);
                SettingsActivity.d2(SettingsActivity.this).dismiss();
                d();
            }
        }

        public final void d() {
            SettingsActivity.this.startActivity(new Intent(this.f, ParentalControlActivitity.class));
        }

        public void onClick(View view) {
            if (b()) {
                c(a());
            }
        }
    }

    public class e implements AdapterView.OnItemSelectedListener {
        public final /* synthetic */ TextView a;

        public e(TextView textView) {
            this.a = textView;
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            SettingsActivity.this.C0 = String.valueOf(adapterView.getItemAtPosition(i));
            this.a.setText(SettingsActivity.this.C0);
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            if (SettingsActivity.this.i2()) {
                SettingsActivity.this.Y2();
                SettingsActivity.this.g2();
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            SettingsActivity.f2().dismiss();
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            SettingsActivity.f2().dismiss();
        }
    }

    public class i implements Callback {
        public i() {
        }

        public void onFailure(Call call, Throwable th) {
            Toast.makeText(SettingsActivity.this, "Something went wrong", 1).show();
            SettingsActivity.this.Z2();
        }

        public void onResponse(Call call, Response response) {
            Toast makeText;
            if (response == null || response.body() == null || !response.isSuccessful() || ((ClientFeedbackCallback) response.body()).a() == null) {
                SettingsActivity.this.Z2();
                Toast.makeText(SettingsActivity.this, "Something went wrong", 0).show();
                return;
            }
            if (((ClientFeedbackCallback) response.body()).a().equalsIgnoreCase("success")) {
                SettingsActivity settingsActivity = SettingsActivity.this;
                makeText = Toast.makeText(settingsActivity, settingsActivity.getResources().getString(a7.j.d2), 0);
            } else if (!((ClientFeedbackCallback) response.body()).a().equalsIgnoreCase("error")) {
                return;
            } else {
                makeText = Toast.makeText(SettingsActivity.this, "Something went wrong", 0);
            }
            makeText.show();
            SettingsActivity.f2().dismiss();
            SettingsActivity.this.Z2();
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        public void onClick(View view) {
            w.j(SettingsActivity.this.Q);
        }
    }

    public class k implements View.OnFocusChangeListener {
        public View a;

        public k(View view) {
            this.a = view;
        }

        public void onFocusChange(View view, boolean z) {
            View view2;
            View view3;
            Resources resources;
            int i;
            View view4;
            View view5;
            if (z) {
                View view6 = this.a;
                if ((view6 == null || view6.getTag() == null || !this.a.getTag().equals("spinnerOne")) && ((view4 = this.a) == null || view4.getTag() == null || !this.a.getTag().equals("ll_feedback"))) {
                    View view7 = this.a;
                    if ((view7 == null || view7.getTag() == null || !this.a.getTag().equals("8")) && ((view5 = this.a) == null || view5.getTag() == null || !this.a.getTag().equals("9"))) {
                        return;
                    }
                    resources = SettingsActivity.this.getResources();
                    i = a7.e.h;
                } else {
                    resources = SettingsActivity.this.getResources();
                    i = a7.e.x2;
                }
            } else {
                View view8 = this.a;
                if ((view8 == null || view8.getTag() == null || !this.a.getTag().equals("spinnerOne")) && ((view2 = this.a) == null || view2.getTag() == null || !this.a.getTag().equals("ll_feedback"))) {
                    View view9 = this.a;
                    if ((view9 == null || view9.getTag() == null || !this.a.getTag().equals("8")) && ((view3 = this.a) == null || view3.getTag() == null || !this.a.getTag().equals("9"))) {
                        return;
                    }
                    resources = SettingsActivity.this.getResources();
                    i = a7.e.o;
                } else {
                    resources = SettingsActivity.this.getResources();
                    i = a7.e.w2;
                }
            }
            view.setBackground(resources.getDrawable(i));
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        public void onClick(View view) {
            SettingsActivity.this.onBackPressed();
        }
    }

    public class m implements Runnable {
        public m() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(SettingsActivity.this.Q);
                String A = w.A(date);
                TextView textView = SettingsActivity.this.w;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = SettingsActivity.this.v;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public n() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(SettingsActivity.this.Q);
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(SettingsActivity.this.Q);
        }
    }

    public class q implements DialogInterface.OnClickListener {
        public q() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class r implements DialogInterface.OnClickListener {
        public r() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class s implements DialogInterface.OnClickListener {
        public s() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class t implements Runnable {
        public t() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    SettingsActivity.this.k2();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class u implements View.OnFocusChangeListener {
        public final View a;

        public u(View view) {
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
            Object obj;
            float f;
            ImageView imageView;
            int i;
            View view2;
            View view3;
            if (z) {
                float f2 = z ? 1.12f : 1.0f;
                b(f2);
                c(f2);
                View view4 = this.a;
                if (view4 != null && view4.getTag() != null && this.a.getTag().equals("2")) {
                    SettingsActivity.this.h.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.m0.setImageResource(a7.e.X1);
                }
                View view5 = this.a;
                if (view5 != null && view5.getTag() != null && this.a.getTag().equals("3")) {
                    SettingsActivity.this.j.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.i0.setImageResource(a7.e.R1);
                }
                if (!SharepreferenceDBHandler.getCurrentAPPType(SettingsActivity.this.Q).equals("m3u") && (view3 = this.a) != null && view3.getTag() != null && this.a.getTag().equals("5")) {
                    SettingsActivity.this.l.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.j0.setImageResource(a7.e.h2);
                }
                View view6 = this.a;
                if (view6 != null && view6.getTag() != null && this.a.getTag().equals("6")) {
                    SettingsActivity.this.n.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.l0.setImageResource(a7.e.l2);
                }
                View view7 = this.a;
                if (view7 != null && view7.getTag() != null && this.a.getTag().equals("8")) {
                    SettingsActivity.this.Y.setBackgroundResource(a7.e.h);
                }
                View view8 = this.a;
                if (view8 != null && view8.getTag() != null && this.a.getTag().equals("9")) {
                    SettingsActivity.this.Z.setBackgroundResource(a7.e.k1);
                }
                View view9 = this.a;
                if (view9 != null && view9.getTag() != null && this.a.getTag().equals("10")) {
                    SettingsActivity.this.p.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.k0.setImageResource(a7.e.O1);
                }
                View view10 = this.a;
                if (view10 != null && view10.getTag() != null && this.a.getTag().equals("11")) {
                    SettingsActivity.this.r.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.h0.setImageResource(a7.e.d2);
                }
                View view11 = this.a;
                if (view11 != null && view11.getTag() != null && this.a.getTag().equals("12")) {
                    SettingsActivity.this.f.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.n0.setImageResource(a7.e.Z1);
                }
                View view12 = this.a;
                if (view12 != null && view12.getTag() != null && this.a.getTag().equals("13")) {
                    SettingsActivity.this.y.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.o0.setImageResource(a7.e.b2);
                }
                View view13 = this.a;
                if (view13 != null && view13.getTag() != null && this.a.getTag().equals("14")) {
                    SettingsActivity.this.E.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.t0.setImageResource(a7.e.B2);
                }
                View view14 = this.a;
                if (view14 != null && view14.getTag() != null && this.a.getTag().equals("15")) {
                    SettingsActivity.this.A.setBackgroundResource(a7.e.P1);
                }
                View view15 = this.a;
                if (view15 != null && view15.getTag() != null && this.a.getTag().equals("16")) {
                    SettingsActivity.this.J.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.p0.setImageResource(a7.e.T1);
                }
                View view16 = this.a;
                if (view16 != null && view16.getTag() != null && this.a.getTag().equals("17")) {
                    SettingsActivity.this.f0.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.s0.setImageResource(a7.e.n2);
                }
                View view17 = this.a;
                if (view17 != null && view17.getTag() != null && this.a.getTag().equals("27")) {
                    SettingsActivity.this.I0.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.L0.setImageResource(a7.e.Y);
                }
                View view18 = this.a;
                if (view18 != null && view18.getTag() != null && this.a.getTag().equals("18")) {
                    SettingsActivity.this.t.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.q0.setImageResource(a7.e.V1);
                }
                View view19 = this.a;
                if (view19 != null && view19.getTag() != null && this.a.getTag().equals("19")) {
                    SettingsActivity.this.F.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.r0.setImageResource(a7.e.f2);
                }
                View view20 = this.a;
                if (view20 != null && view20.getTag() != null && this.a.getTag().equals("115")) {
                    SettingsActivity.this.G.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.H.setImageResource(a7.e.f2);
                }
                View view21 = this.a;
                if (view21 != null && view21.getTag() != null && this.a.getTag().equals("20")) {
                    SettingsActivity.this.L.setBackgroundResource(a7.e.P1);
                    SettingsActivity.this.M.setImageResource(a7.e.j2);
                }
                View view22 = this.a;
                if (view22 == null || view22.getTag() == null || !this.a.getTag().equals("21")) {
                    return;
                }
                SettingsActivity.this.O.setBackgroundResource(a7.e.P1);
                imageView = SettingsActivity.this.P;
                i = a7.e.j;
            } else {
                if (z) {
                    return;
                }
                if (z) {
                    obj = "15";
                    f = 1.09f;
                } else {
                    obj = "15";
                    f = 1.0f;
                }
                b(f);
                c(f);
                a(z);
                View view23 = this.a;
                if (view23 != null && view23.getTag() != null && this.a.getTag().equals("2")) {
                    SettingsActivity.this.h.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.m0.setImageResource(a7.e.W1);
                }
                View view24 = this.a;
                if (view24 != null && view24.getTag() != null && this.a.getTag().equals("3")) {
                    SettingsActivity.this.j.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.i0.setImageResource(a7.e.Q1);
                }
                if (!SharepreferenceDBHandler.getCurrentAPPType(SettingsActivity.this.Q).equals("m3u") && (view2 = this.a) != null && view2.getTag() != null && this.a.getTag().equals("5")) {
                    SettingsActivity.this.l.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.j0.setImageResource(a7.e.g2);
                }
                View view25 = this.a;
                if (view25 != null && view25.getTag() != null && this.a.getTag().equals("27")) {
                    SettingsActivity.this.I0.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.L0.setImageResource(a7.e.X);
                }
                View view26 = this.a;
                if (view26 != null && view26.getTag() != null && this.a.getTag().equals("6")) {
                    SettingsActivity.this.n.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.l0.setImageResource(a7.e.k2);
                }
                View view27 = this.a;
                if (view27 != null && view27.getTag() != null && this.a.getTag().equals("8")) {
                    SettingsActivity.this.Y.setBackgroundResource(a7.e.o);
                }
                View view28 = this.a;
                if (view28 != null && view28.getTag() != null && this.a.getTag().equals("9")) {
                    SettingsActivity.this.Z.setBackgroundResource(a7.e.o);
                }
                View view29 = this.a;
                if (view29 != null && view29.getTag() != null && this.a.getTag().equals("10")) {
                    SettingsActivity.this.p.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.k0.setImageResource(a7.e.N1);
                }
                View view30 = this.a;
                if (view30 != null && view30.getTag() != null && this.a.getTag().equals("11")) {
                    SettingsActivity.this.r.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.h0.setImageResource(a7.e.c2);
                }
                View view31 = this.a;
                if (view31 != null && view31.getTag() != null && this.a.getTag().equals("12")) {
                    SettingsActivity.this.f.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.n0.setImageResource(a7.e.Y1);
                }
                View view32 = this.a;
                if (view32 != null && view32.getTag() != null && this.a.getTag().equals("13")) {
                    SettingsActivity.this.y.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.o0.setImageResource(a7.e.a2);
                }
                View view33 = this.a;
                if (view33 != null && view33.getTag() != null && this.a.getTag().equals("14")) {
                    SettingsActivity.this.E.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.t0.setImageResource(a7.e.Z);
                }
                View view34 = this.a;
                if (view34 != null && view34.getTag() != null && this.a.getTag().equals(obj)) {
                    SettingsActivity.this.A.setBackgroundResource(a7.e.z1);
                }
                View view35 = this.a;
                if (view35 != null && view35.getTag() != null && this.a.getTag().equals("16")) {
                    SettingsActivity.this.J.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.p0.setImageResource(a7.e.S1);
                }
                View view36 = this.a;
                if (view36 != null && view36.getTag() != null && this.a.getTag().equals("17")) {
                    SettingsActivity.this.f0.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.s0.setImageResource(a7.e.m2);
                }
                View view37 = this.a;
                if (view37 != null && view37.getTag() != null && this.a.getTag().equals("18")) {
                    SettingsActivity.this.t.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.q0.setImageResource(a7.e.U1);
                }
                View view38 = this.a;
                if (view38 != null && view38.getTag() != null && this.a.getTag().equals("19")) {
                    SettingsActivity.this.F.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.r0.setImageResource(a7.e.e2);
                }
                View view39 = this.a;
                if (view39 != null && view39.getTag() != null && this.a.getTag().equals("115")) {
                    SettingsActivity.this.G.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.H.setImageResource(a7.e.e2);
                }
                View view40 = this.a;
                if (view40 != null && view40.getTag() != null && this.a.getTag().equals("20")) {
                    SettingsActivity.this.L.setBackgroundResource(a7.e.z1);
                    SettingsActivity.this.M.setImageResource(a7.e.i2);
                }
                View view41 = this.a;
                if (view41 == null || view41.getTag() == null || !this.a.getTag().equals("21")) {
                    return;
                }
                SettingsActivity.this.O.setBackgroundResource(a7.e.z1);
                imageView = SettingsActivity.this.P;
                i = a7.e.i;
            }
            imageView.setImageResource(i);
        }
    }

    public static /* synthetic */ void A1(SettingsActivity settingsActivity, View view) {
        settingsActivity.S2(view);
    }

    public static /* synthetic */ void B1(SettingsActivity settingsActivity, View view) {
        settingsActivity.I2(view);
    }

    private /* synthetic */ void B2(View view) {
        startActivity(new Intent(this, ScreenTypeSettingsActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public static /* synthetic */ void C1(SettingsActivity settingsActivity, View view) {
        settingsActivity.U2(view);
    }

    public static /* synthetic */ void D1(SettingsActivity settingsActivity, View view) {
        settingsActivity.V2(view);
    }

    public static /* synthetic */ void E1(SettingsActivity settingsActivity, View view) {
        settingsActivity.p2(view);
    }

    public static /* synthetic */ void F1(SettingsActivity settingsActivity, View view) {
        settingsActivity.q2(view);
    }

    public static /* synthetic */ void G1(SettingsActivity settingsActivity, View view) {
        settingsActivity.T2(view);
    }

    public static /* synthetic */ void H1(SettingsActivity settingsActivity, View view) {
        settingsActivity.X2(view);
    }

    public static /* synthetic */ void I1(SettingsActivity settingsActivity, View view) {
        settingsActivity.W2(view);
    }

    public static /* synthetic */ void J1(SettingsActivity settingsActivity, View view) {
        settingsActivity.K2(view);
    }

    public static /* synthetic */ void K1(SettingsActivity settingsActivity, View view) {
        settingsActivity.r2(view);
    }

    public static /* synthetic */ void L1(SettingsActivity settingsActivity, View view) {
        settingsActivity.E2(view);
    }

    public static /* synthetic */ void M1(SettingsActivity settingsActivity, View view) {
        settingsActivity.R2(view);
    }

    private /* synthetic */ void M2(View view) {
        startActivity(new Intent(this, ScreenTypeSettingsActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public static /* synthetic */ void N1(SettingsActivity settingsActivity, View view) {
        settingsActivity.L2(view);
    }

    public static /* synthetic */ void O1(SettingsActivity settingsActivity, View view) {
        settingsActivity.D2(view);
    }

    public static /* synthetic */ void P1(SettingsActivity settingsActivity, View view) {
        settingsActivity.J2(view);
    }

    public static /* synthetic */ void Q1(SettingsActivity settingsActivity, View view) {
        settingsActivity.Q2(view);
    }

    public static /* synthetic */ void R1(SettingsActivity settingsActivity, View view) {
        settingsActivity.B2(view);
    }

    public static /* synthetic */ void S1(SettingsActivity settingsActivity, View view) {
        settingsActivity.G2(view);
    }

    private /* synthetic */ void S2(View view) {
        startActivity(new Intent(this, BackupAndRestoreActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public static /* synthetic */ void T1(SettingsActivity settingsActivity, View view) {
        settingsActivity.s2(view);
    }

    private /* synthetic */ void T2(View view) {
        startActivity(new Intent(this, BackupAndRestoreActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public static /* synthetic */ void U1(SettingsActivity settingsActivity, View view) {
        settingsActivity.w2(view);
    }

    public static /* synthetic */ void V1(SettingsActivity settingsActivity, View view) {
        settingsActivity.y2(view);
    }

    public static /* synthetic */ void W1(SettingsActivity settingsActivity, View view) {
        settingsActivity.C2(view);
    }

    public static /* synthetic */ void X1(SettingsActivity settingsActivity, View view) {
        settingsActivity.H2(view);
    }

    public static /* synthetic */ void Y1(SettingsActivity settingsActivity, View view) {
        settingsActivity.F2(view);
    }

    public static /* synthetic */ void Z1(SettingsActivity settingsActivity, View view) {
        settingsActivity.u2(view);
    }

    public static /* synthetic */ void a2(SettingsActivity settingsActivity, View view) {
        settingsActivity.N2(view);
    }

    public static /* synthetic */ void b2(SettingsActivity settingsActivity, View view) {
        settingsActivity.x2(view);
    }

    public static /* synthetic */ void c2(SettingsActivity settingsActivity, View view) {
        settingsActivity.M2(view);
    }

    public static /* synthetic */ PopupWindow d2(SettingsActivity settingsActivity) {
        return settingsActivity.V;
    }

    public static /* synthetic */ LiveStreamDBHandler e2(SettingsActivity settingsActivity) {
        return settingsActivity.S;
    }

    public static /* synthetic */ PopupWindow f2() {
        return b1;
    }

    private void h2() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void j2() {
        if (m7.a.o.booleanValue() && m7.a.V0.booleanValue() && (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals(""))) {
            d3(true);
        } else {
            d3(false);
        }
    }

    public static String l2() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
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
        } catch (Exception unused) {
        }
        return "";
    }

    private void o2() {
        this.Q = this;
        this.S = new LiveStreamDBHandler(this.Q);
        this.R = getSharedPreferences("loginPrefs", 0);
    }

    private /* synthetic */ void p2(View view) {
        Intent intent;
        if (!m7.a.o.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                intent = new Intent(this, AddedExternalPlayerActivity.class);
                startActivity(intent);
                overridePendingTransition(a7.b.f, a7.b.d);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (!m7.a.V0.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                intent = new Intent(this, AddedExternalPlayerActivity.class);
                startActivity(intent);
                overridePendingTransition(a7.b.f, a7.b.d);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
            try {
                new w.j(this, this.Q, a1).show();
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
            intent = new Intent(this, AddedExternalPlayerActivity.class);
            startActivity(intent);
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
    }

    private /* synthetic */ void q2(View view) {
        Intent intent;
        if (!m7.a.o.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                intent = new Intent(this, AddedExternalPlayerActivity.class);
                startActivity(intent);
                overridePendingTransition(a7.b.f, a7.b.d);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (!m7.a.V0.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                intent = new Intent(this, AddedExternalPlayerActivity.class);
                startActivity(intent);
                overridePendingTransition(a7.b.f, a7.b.d);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
            try {
                new w.j(this, this.Q, a1).show();
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
            intent = new Intent(this, AddedExternalPlayerActivity.class);
            startActivity(intent);
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
    }

    public static /* synthetic */ void u1(SettingsActivity settingsActivity, View view) {
        settingsActivity.P2(view);
    }

    public static /* synthetic */ void v1(SettingsActivity settingsActivity, View view) {
        settingsActivity.z2(view);
    }

    public static /* synthetic */ void w1(SettingsActivity settingsActivity, View view) {
        settingsActivity.O2(view);
    }

    public static /* synthetic */ void x1(SettingsActivity settingsActivity, View view) {
        settingsActivity.A2(view);
    }

    public static /* synthetic */ void y1(SettingsActivity settingsActivity, View view) {
        settingsActivity.v2(view);
    }

    public static /* synthetic */ void z1(SettingsActivity settingsActivity, View view) {
        settingsActivity.t2(view);
    }

    public final /* synthetic */ void A2(View view) {
        startActivity(new Intent(this, AutomationActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public final /* synthetic */ void C2(View view) {
        startActivity(new Intent(this, GeneralSettingsActivity.class));
    }

    public final /* synthetic */ void D2(View view) {
        startActivity(new Intent(this, GeneralSettingsActivity.class));
    }

    public final /* synthetic */ void E2(View view) {
        startActivity(new Intent(this, CheckAppupdateActivity.class));
    }

    public final /* synthetic */ void F2(View view) {
        startActivity(new Intent(this, CheckAppupdateActivity.class));
    }

    public final /* synthetic */ void G2(View view) {
        startActivity(new Intent(this, OpensubtitleActivity.class));
    }

    public final /* synthetic */ void H2(View view) {
        startActivity(new Intent(this, OpensubtitleActivity.class));
    }

    public final /* synthetic */ void I2(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("typeid", "settings");
        startActivity(intent);
    }

    public final /* synthetic */ void J2(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("typeid", "settings");
        startActivity(intent);
    }

    public final /* synthetic */ void K2(View view) {
        c3(this.Q);
    }

    public final /* synthetic */ void L2(View view) {
        c3(this.Q);
    }

    public final /* synthetic */ void N2(View view) {
        if (SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        } else {
            startActivity(new Intent(this, MultiSettingActivity.class));
        }
    }

    public final /* synthetic */ void O2(View view) {
        if (SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        } else {
            startActivity(new Intent(this, MultiSettingActivity.class));
        }
    }

    public final /* synthetic */ void P2(View view) {
        Intent intent;
        if (!m7.a.o.booleanValue()) {
            intent = new Intent(this, SpeedTestActivity.class);
        } else if (!m7.a.V0.booleanValue()) {
            intent = new Intent(this, SpeedTestActivity.class);
        } else {
            if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
                try {
                    new w.j(this, this.Q, a1).show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            intent = new Intent(this, SpeedTestActivity.class);
        }
        startActivity(intent);
    }

    public final /* synthetic */ void Q2(View view) {
        Intent intent;
        if (!m7.a.o.booleanValue()) {
            intent = new Intent(this, SpeedTestActivity.class);
        } else if (!m7.a.V0.booleanValue()) {
            intent = new Intent(this, SpeedTestActivity.class);
        } else {
            if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
                try {
                    new w.j(this, this.Q, a1).show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            intent = new Intent(this, SpeedTestActivity.class);
        }
        startActivity(intent);
    }

    public final /* synthetic */ void R2(View view) {
        Intent intent;
        ArrayList userDetails = new MultiUserDBHandler(this.Q).getUserDetails(SharepreferenceDBHandler.getUserID(this.Q));
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("m3u")) {
            intent = new Intent(this, ActivateOnTVActivity.class);
        } else {
            if (userDetails != null && userDetails.size() > 0 && ((MultiUserDBModel) userDetails.get(0)).getM3uType().equalsIgnoreCase("file")) {
                Toast.makeText(getApplicationContext(), "Coming Soon", 0).show();
                return;
            }
            intent = new Intent(this, ActivateOnTVActivity.class);
        }
        startActivity(intent);
    }

    public final /* synthetic */ void U2(View view) {
        Intent intent;
        if (!m7.a.o.booleanValue()) {
            intent = new Intent(this, PlayerSelectionActivity.class);
        } else if (!m7.a.V0.booleanValue()) {
            intent = new Intent(this, PlayerSelectionActivity.class);
        } else {
            if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
                try {
                    new w.j(this, this.Q, a1).show();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            intent = new Intent(this, PlayerSelectionActivity.class);
        }
        startActivity(intent);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public final /* synthetic */ void V2(View view) {
        Intent intent;
        if (!m7.a.o.booleanValue()) {
            intent = new Intent(this, PlayerSelectionActivity.class);
        } else if (!m7.a.V0.booleanValue()) {
            intent = new Intent(this, PlayerSelectionActivity.class);
        } else {
            if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
                try {
                    new w.j(this, this.Q, a1).show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            intent = new Intent(this, PlayerSelectionActivity.class);
        }
        startActivity(intent);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public final /* synthetic */ void W2(View view) {
        Intent intent;
        if (!m7.a.o.booleanValue()) {
            intent = new Intent(this, PlayerSettingsActivity.class);
        } else if (!m7.a.V0.booleanValue()) {
            intent = new Intent(this, PlayerSettingsActivity.class);
        } else {
            if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
                try {
                    new w.j(this, this.Q, a1).show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            intent = new Intent(this, PlayerSettingsActivity.class);
        }
        startActivity(intent);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public final /* synthetic */ void X2(View view) {
        Intent intent;
        if (!m7.a.o.booleanValue()) {
            intent = new Intent(this, PlayerSettingsActivity.class);
        } else if (!m7.a.V0.booleanValue()) {
            intent = new Intent(this, PlayerSettingsActivity.class);
        } else {
            if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
                try {
                    new w.j(this, this.Q, a1).show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            intent = new Intent(this, PlayerSettingsActivity.class);
        }
        startActivity(intent);
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void Y2() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.x0 = progressDialog;
        progressDialog.setMessage("Please wait.....");
        this.x0.show();
        this.x0.setCancelable(false);
    }

    public void Z2() {
        this.x0.dismiss();
    }

    public final void a3(SettingsActivity settingsActivity, int i2, String str, String str2, String str3) {
        View inflate = ((LayoutInflater) settingsActivity.getSystemService("layout_inflater")).inflate(a1.A().equals(m7.a.K0) ? a7.g.T4 : a7.g.S4, settingsActivity.findViewById(a7.f.We));
        PopupWindow popupWindow = new PopupWindow(settingsActivity);
        this.V = popupWindow;
        popupWindow.setContentView(inflate);
        this.V.setWidth(-1);
        this.V.setHeight(-1);
        this.V.setFocusable(true);
        this.V.showAtLocation(inflate, 17, 0, 0);
        this.Y = inflate.findViewById(a7.f.H0);
        this.Z = inflate.findViewById(a7.f.o0);
        Button button = this.Y;
        if (button != null) {
            button.setOnFocusChangeListener(new u(button));
        }
        Button button2 = this.Z;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new u(button2));
        }
        EditText findViewById = inflate.findViewById(a7.f.j3);
        findViewById.requestFocus();
        this.Z.setOnClickListener(new a());
        this.Y.setOnClickListener(new b(str3, settingsActivity, findViewById, new String[1]));
    }

    public void b3() {
        this.I.setOnClickListener(new A0(this));
        this.J.setOnClickListener(new C0(this));
        this.L.setOnClickListener(new O0(this));
        this.K.setOnClickListener(new U0(this));
        this.O.setOnClickListener(new V0(this));
        this.N.setOnClickListener(new X0(this));
        this.J0.setOnClickListener(new Y0(this));
        this.e.setOnClickListener(new Z0(this));
        this.y.setOnClickListener(new a1(this));
        this.g.setOnClickListener(new b1(this));
        this.h.setOnClickListener(new L0(this));
        this.i.setOnClickListener(new W0(this));
        this.j.setOnClickListener(new c1(this));
        this.k.setOnClickListener(new d1(this));
        this.l.setOnClickListener(new e1(this));
        this.m.setOnClickListener(new f1(this));
        this.n.setOnClickListener(new g1(this));
        this.o.setOnClickListener(new h1(this));
        this.p.setOnClickListener(new i1(this));
        this.q.setOnClickListener(new B0(this));
        this.r.setOnClickListener(new D0(this));
        this.u.setOnClickListener(new E0(this));
        this.A.setOnClickListener(new F0(this));
        this.z.setOnClickListener(new G0(this));
        this.E.setOnClickListener(new H0(this));
        this.B.setOnClickListener(new I0(this));
        this.f0.setOnClickListener(new J0(this));
        this.e0.setOnClickListener(new K0(this));
        this.I0.setOnClickListener(new M0(this));
        this.K0.setOnClickListener(new N0(this));
        this.s.setOnClickListener(new P0(this));
        this.t.setOnClickListener(new Q0(this));
        this.F.setOnClickListener(new R0(this));
        this.C.setOnClickListener(new S0(this));
        this.G.setOnClickListener(new T0(this));
    }

    public void c3(Context context) {
        if (context != null) {
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a7.g.J2, (ViewGroup) null);
            PopupWindow popupWindow = new PopupWindow(context);
            b1 = popupWindow;
            popupWindow.setContentView(inflate);
            b1.setWidth(-1);
            b1.setHeight(-1);
            b1.setFocusable(true);
            b1.setBackgroundDrawable(new BitmapDrawable());
            b1.showAtLocation(inflate, 17, 0, 0);
            this.E0 = inflate.findViewById(a7.f.i8);
            this.D0 = inflate.findViewById(a7.f.ha);
            this.F0 = inflate.findViewById(a7.f.Bg);
            this.G0 = inflate.findViewById(a7.f.Eg);
            this.H0 = inflate.findViewById(a7.f.o0);
            this.v0 = inflate.findViewById(a7.f.J3);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, a7.g.E4, new String[]{"Live", "Movies", "Series"});
            arrayAdapter.setDropDownViewResource(a7.g.E4);
            this.F0.setAdapter(arrayAdapter);
            this.F0.setSelection(0);
            this.F0.setOnItemSelectedListener(new e(findViewById(a7.f.Zg)));
            this.G0.setOnClickListener(new f());
            this.H0.setOnClickListener(new g());
            ImageView findViewById = inflate.findViewById(a7.f.T4);
            this.v0.requestFocus();
            if (findViewById != null) {
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
            }
            Spinner spinner = this.F0;
            if (spinner != null) {
                spinner.setOnFocusChangeListener(new w.k(spinner, this));
            }
            LinearLayout linearLayout = this.E0;
            if (linearLayout != null) {
                linearLayout.setOnFocusChangeListener(new w.k(linearLayout, this));
            }
            Button button = this.G0;
            if (button != null) {
                button.setOnFocusChangeListener(new w.k(button, this));
            }
            findViewById.setOnClickListener(new h());
            Spinner spinner2 = this.F0;
            spinner2.setOnFocusChangeListener(new k(spinner2));
            LinearLayout linearLayout2 = this.E0;
            linearLayout2.setOnFocusChangeListener(new k(linearLayout2));
            Button button2 = this.G0;
            button2.setOnFocusChangeListener(new k(button2));
            Button button3 = this.H0;
            button3.setOnFocusChangeListener(new k(button3));
            this.G0.setNextFocusRightId(a7.f.o0);
            this.H0.setNextFocusLeftId(a7.f.Eg);
            this.H0.setNextFocusUpId(a7.f.J3);
            this.G0.setNextFocusUpId(a7.f.J3);
            this.E0.setNextFocusDownId(a7.f.Eg);
        }
    }

    public final void d3(boolean z) {
        ImageView imageView;
        int i2;
        if (z) {
            imageView = this.M0;
            i2 = 0;
        } else {
            imageView = this.M0;
            i2 = 8;
        }
        imageView.setVisibility(i2);
        this.N0.setVisibility(i2);
        this.R0.setVisibility(i2);
        this.P0.setVisibility(i2);
        this.Q0.setVisibility(i2);
        this.S0.setVisibility(i2);
        this.T0.setVisibility(i2);
        this.O0.setVisibility(i2);
        this.U0.setVisibility(i2);
        this.V0.setVisibility(i2);
        this.W0.setVisibility(i2);
        this.X0.setVisibility(i2);
    }

    public final void e3(Activity activity, int i2, String str) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(a1.A().equals(m7.a.K0) ? a7.g.R4 : a7.g.Q4, activity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(activity);
            this.V = popupWindow;
            popupWindow.setContentView(inflate);
            this.V.setWidth(-1);
            this.V.setHeight(-1);
            this.V.setFocusable(true);
            this.V.showAtLocation(inflate, 17, 0, 0);
            this.Y = inflate.findViewById(a7.f.H0);
            this.Z = inflate.findViewById(a7.f.o0);
            Button button = this.Y;
            if (button != null) {
                button.setOnFocusChangeListener(new u(button));
            }
            Button button2 = this.Z;
            if (button2 != null) {
                button2.setOnFocusChangeListener(new u(button2));
            }
            EditText findViewById = inflate.findViewById(a7.f.Jk);
            EditText findViewById2 = inflate.findViewById(a7.f.ni);
            if (activity.getSharedPreferences("selected_language", 0).getString("selected_language", "English").equalsIgnoreCase("Arabic")) {
                findViewById.setGravity(21);
                findViewById2.setGravity(21);
            }
            this.Z.setOnClickListener(new c());
            this.Y.setOnClickListener(new d(new String[1], findViewById, new String[1], findViewById2, activity, str));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public void g2() {
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.R = sharedPreferences;
        this.y0 = sharedPreferences.getString("username", "");
        this.z0 = this.R.getString("password", "");
        this.A0 = this.R.edit();
        this.w0 = this.v0.getText().toString().trim();
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
        Retrofit E0 = w.E0(this.Q);
        if (E0 != null) {
            RetrofitPost retrofitPost = (RetrofitPost) E0.create(RetrofitPost.class);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", m7.a.S0);
            jsonObject.addProperty("s", m7.a.T0);
            jsonObject.addProperty("r", b7.b.b);
            jsonObject.addProperty("d", format);
            jsonObject.addProperty("sc", o0);
            jsonObject.addProperty("action", "addclientfeedback");
            jsonObject.addProperty("feedback", this.w0);
            jsonObject.addProperty("username", this.y0);
            jsonObject.addProperty("macaddress", this.B0);
            retrofitPost.clientsFeedbackRequest(jsonObject).enqueue(new i());
        }
    }

    public boolean i2() {
        if (this.v0.getText().toString().trim().length() != 0) {
            return true;
        }
        Toast.makeText(this, "Please enter feedback", 0).show();
        return false;
    }

    public void k2() {
        runOnUiThread(new m());
    }

    public void m2() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public final void n2() {
        this.I0 = findViewById(a7.f.j8);
        this.K0 = findViewById(a7.f.E1);
        this.L0 = findViewById(a7.f.h5);
        this.M0 = findViewById(a7.f.Pa);
        this.N0 = findViewById(a7.f.Ta);
        this.O0 = findViewById(a7.f.f4);
        this.P0 = findViewById(a7.f.Qa);
        this.Q0 = findViewById(a7.f.Ra);
        this.R0 = findViewById(a7.f.Oa);
        this.S0 = findViewById(a7.f.Sa);
        this.T0 = findViewById(a7.f.a4);
        this.U0 = findViewById(a7.f.c4);
        this.V0 = findViewById(a7.f.d4);
        this.W0 = findViewById(a7.f.Z3);
        this.X0 = findViewById(a7.f.e4);
        this.Y0 = findViewById(a7.f.Fm);
        this.e0 = findViewById(a7.f.D2);
        this.f0 = findViewById(a7.f.Fa);
        this.g0 = findViewById(a7.f.F4);
        this.h0 = findViewById(a7.f.k5);
        this.i0 = findViewById(a7.f.d5);
        this.j0 = findViewById(a7.f.e6);
        this.k0 = findViewById(a7.f.D4);
        this.l0 = findViewById(a7.f.g6);
        this.m0 = findViewById(a7.f.G5);
        this.n0 = findViewById(a7.f.R5);
        this.o0 = findViewById(a7.f.S5);
        this.p0 = findViewById(a7.f.e5);
        this.q0 = findViewById(a7.f.D5);
        this.r0 = findViewById(a7.f.c6);
        this.s0 = findViewById(a7.f.j6);
        this.t0 = findViewById(a7.f.t4);
        this.d = findViewById(a7.f.kh);
        this.J0 = findViewById(a7.f.bf);
        this.e = findViewById(a7.f.A2);
        this.f = findViewById(a7.f.u9);
        this.g = findViewById(a7.f.B2);
        this.h = findViewById(a7.f.Se);
        this.i = findViewById(a7.f.Te);
        this.j = findViewById(a7.f.le);
        this.k = findViewById(a7.f.me);
        this.l = findViewById(a7.f.of);
        this.m = findViewById(a7.f.pf);
        this.n = findViewById(a7.f.tf);
        this.o = findViewById(a7.f.uf);
        this.p = findViewById(a7.f.Td);
        this.q = findViewById(a7.f.Ud);
        this.r = findViewById(a7.f.qe);
        this.s = findViewById(a7.f.tb);
        this.t = findViewById(a7.f.sb);
        this.u = findViewById(a7.f.re);
        this.v = findViewById(a7.f.E2);
        this.w = findViewById(a7.f.gh);
        this.x = findViewById(a7.f.Xa);
        this.y = findViewById(a7.f.cf);
        this.z = findViewById(a7.f.C1);
        this.A = findViewById(a7.f.W6);
        this.B = findViewById(a7.f.B1);
        this.C = findViewById(a7.f.Ag);
        this.D = findViewById(a7.f.th);
        this.E = findViewById(a7.f.M6);
        this.F = findViewById(a7.f.zg);
        this.G = findViewById(a7.f.h);
        this.H = findViewById(a7.f.u4);
        this.I = findViewById(a7.f.z2);
        this.J = findViewById(a7.f.h8);
        this.K = findViewById(a7.f.I1);
        this.L = findViewById(a7.f.N9);
        this.M = findViewById(a7.f.a6);
        this.N = findViewById(a7.f.D1);
        this.O = findViewById(a7.f.e7);
        this.P = findViewById(a7.f.K4);
        b3();
    }

    public void onBackPressed() {
        finish();
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        }
    }

    public void onCreate(Bundle bundle) {
        this.Q = this;
        m2();
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.Q);
        a1 = aVar;
        String A = aVar.A();
        String l2 = l2();
        this.B0 = l2;
        if (l2.equals("") || this.B0.isEmpty()) {
            this.B0 = w.I(this.Q);
        }
        setContentView(SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("m3u") ? A.equals(m7.a.K0) ? a7.g.U0 : a7.g.T0 : A.equals(m7.a.K0) ? a7.g.V0 : a7.g.S0);
        n2();
        m7.a.c = false;
        m7.a.d = true;
        j2();
        SharepreferenceDBHandler.setTypeLogin("settings", this.Q);
        if (A.equals(m7.a.K0)) {
            this.D.setVisibility(4);
        }
        TextView textView = this.Y0;
        if (textView != null) {
            textView.setText("v5.0");
            this.Y0.setAlpha(0.4f);
        }
        CardView cardView = this.I;
        if (cardView != null) {
            cardView.setOnFocusChangeListener(new u(cardView));
        }
        CardView cardView2 = this.K;
        if (cardView2 != null) {
            cardView2.setOnFocusChangeListener(new u(cardView2));
        }
        CardView cardView3 = this.K0;
        if (cardView3 != null) {
            cardView3.setOnFocusChangeListener(new u(cardView3));
        }
        CardView cardView4 = this.N;
        if (cardView4 != null) {
            cardView4.setOnFocusChangeListener(new u(cardView4));
        }
        CardView cardView5 = this.s;
        if (cardView5 != null) {
            cardView5.setOnFocusChangeListener(new u(cardView5));
        }
        CardView cardView6 = this.C;
        if (cardView6 != null) {
            cardView6.setOnFocusChangeListener(new u(cardView6));
        }
        CardView cardView7 = this.D;
        if (cardView7 != null) {
            cardView7.setOnFocusChangeListener(new u(cardView7));
        }
        CardView cardView8 = this.e;
        if (cardView8 != null) {
            cardView8.setOnFocusChangeListener(new u(cardView8));
        }
        CardView cardView9 = this.i;
        if (cardView9 != null) {
            cardView9.setOnFocusChangeListener(new u(cardView9));
        }
        CardView cardView10 = this.k;
        if (cardView10 != null) {
            cardView10.setOnFocusChangeListener(new u(cardView10));
        }
        CardView cardView11 = this.m;
        if (cardView11 != null) {
            cardView11.setOnFocusChangeListener(new u(cardView11));
        }
        CardView cardView12 = this.o;
        if (cardView12 != null) {
            cardView12.setOnFocusChangeListener(new u(cardView12));
        }
        CardView cardView13 = this.q;
        if (cardView13 != null) {
            cardView13.setOnFocusChangeListener(new u(cardView13));
        }
        CardView cardView14 = this.u;
        if (cardView14 != null) {
            cardView14.setOnFocusChangeListener(new u(cardView14));
            if (A.equals(m7.a.K0)) {
                this.u.requestFocus();
                this.u.setFocusableInTouchMode(true);
            }
            this.u.requestFocus();
        }
        CardView cardView15 = this.e0;
        cardView15.setOnFocusChangeListener(new u(cardView15));
        CardView cardView16 = this.K0;
        cardView16.setOnFocusChangeListener(new u(cardView16));
        CardView cardView17 = this.g;
        if (cardView17 != null) {
            cardView17.setOnFocusChangeListener(new u(cardView17));
        }
        Boolean bool = m7.a.V0;
        if (bool.booleanValue()) {
            this.z.setVisibility(0);
        }
        CardView cardView18 = this.z;
        cardView18.setOnFocusChangeListener(new u(cardView18));
        CardView cardView19 = this.B;
        cardView19.setOnFocusChangeListener(new u(cardView19));
        if (bool.booleanValue()) {
            boolean isAppExistOnPlayStore = SharepreferenceDBHandler.getIsAppExistOnPlayStore(this.Q);
            if (!isAppExistOnPlayStore) {
                new m7.b(this).execute(new Void[0]);
            }
            if (isAppExistOnPlayStore) {
                this.B.setVisibility(0);
                this.z.setVisibility(0);
                CardView cardView20 = this.z;
                cardView20.setOnFocusChangeListener(new u(cardView20));
                CardView cardView21 = this.B;
                cardView21.setOnFocusChangeListener(new u(cardView21));
            }
        }
        this.x.setOnClickListener(new j());
        this.g0.setOnClickListener(new l());
        getWindow().setFlags(1024, 1024);
        h2();
        r1(findViewById(a7.f.kh));
        o2();
        Thread thread = this.u0;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new t());
            this.u0 = thread2;
            thread2.start();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.d.x(a7.h.v);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            if (this.d.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.d.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.e && (context = this.Q) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new o()).g(getResources().getString(a7.j.d4), new n()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.Q.getResources().getString(a7.j.u0));
            aVar.f(this.Q.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.Q.getResources().getString(a7.j.S8), new p());
            aVar.g(this.Q.getResources().getString(a7.j.d4), new q());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.Q.getResources().getString(a7.j.u0));
            aVar2.f(this.Q.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.Q.getResources().getString(a7.j.S8), new r());
            aVar2.g(this.Q.getResources().getString(a7.j.d4), new s());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.u0;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.u0.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        CardView cardView;
        m2();
        super/*androidx.fragment.app.e*/.onResume();
        j2();
        Thread thread = this.u0;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new t());
            this.u0 = thread2;
            thread2.start();
        }
        overridePendingTransition(a7.b.f, a7.b.d);
        w.m(this.Q);
        w.z0(this.Q);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.R = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.R.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            SharedPreferences sharedPreferences2 = getSharedPreferences("selectedPlayer", 0);
            this.R = sharedPreferences2;
            if (!sharedPreferences2.getString("selectedPlayer", getResources().getString(a7.j.t2)).equals(getResources().getString(a7.j.t2)) ? (cardView = this.g) != null : (cardView = this.g) != null) {
                cardView.setVisibility(0);
            }
        }
        SharedPreferences sharedPreferences3 = getSharedPreferences("timeFormat", 0);
        Z0 = sharedPreferences3;
        sharedPreferences3.getString("timeFormat", m7.a.E0);
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        m2();
    }

    public final /* synthetic */ void r2(View view) {
        String string;
        String str;
        String str2;
        if (!m7.a.o.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                string = getSharedPreferences("loginPrefs", 0).getString("username", "");
                LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.Q);
                this.S = liveStreamDBHandler;
                ArrayList allPassword = liveStreamDBHandler.getAllPassword(SharepreferenceDBHandler.getUserID(this.Q));
                if (allPassword != null) {
                    Iterator it = allPassword.iterator();
                    String str3 = "";
                    String str4 = str3;
                    while (it.hasNext()) {
                        PasswordDBModel passwordDBModel = (PasswordDBModel) it.next();
                        if (passwordDBModel.getUserDetail().equals(string) && !passwordDBModel.getUserPassword().isEmpty()) {
                            str3 = passwordDBModel.getUserDetail();
                            str4 = passwordDBModel.getUserPassword();
                        }
                    }
                    str = str3;
                    str2 = str4;
                } else {
                    str = "";
                    str2 = str;
                }
                if (str == null || str.equals("") || str.isEmpty()) {
                    if (string.isEmpty() || string.equals("")) {
                        return;
                    }
                    e3(this, 100, string);
                    return;
                }
                a3(this, 100, string, str, str2);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (!m7.a.V0.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                string = getSharedPreferences("loginPrefs", 0).getString("username", "");
                LiveStreamDBHandler liveStreamDBHandler2 = new LiveStreamDBHandler(this.Q);
                this.S = liveStreamDBHandler2;
                ArrayList allPassword2 = liveStreamDBHandler2.getAllPassword(SharepreferenceDBHandler.getUserID(this.Q));
                if (allPassword2 != null) {
                    Iterator it2 = allPassword2.iterator();
                    String str5 = "";
                    String str6 = str5;
                    while (it2.hasNext()) {
                        PasswordDBModel passwordDBModel2 = (PasswordDBModel) it2.next();
                        if (passwordDBModel2.getUserDetail().equals(string) && !passwordDBModel2.getUserPassword().isEmpty()) {
                            str5 = passwordDBModel2.getUserDetail();
                            str6 = passwordDBModel2.getUserPassword();
                        }
                    }
                    str = str5;
                    str2 = str6;
                } else {
                    str = "";
                    str2 = str;
                }
                if (str == null || str.equals("") || str.isEmpty()) {
                    if (string.isEmpty() || string.equals("")) {
                        return;
                    }
                    e3(this, 100, string);
                    return;
                }
                a3(this, 100, string, str, str2);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
            try {
                new w.j(this, this.Q, a1).show();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
            string = getSharedPreferences("loginPrefs", 0).getString("username", "");
            LiveStreamDBHandler liveStreamDBHandler3 = new LiveStreamDBHandler(this.Q);
            this.S = liveStreamDBHandler3;
            ArrayList allPassword3 = liveStreamDBHandler3.getAllPassword(SharepreferenceDBHandler.getUserID(this.Q));
            if (allPassword3 != null) {
                Iterator it3 = allPassword3.iterator();
                String str7 = "";
                String str8 = str7;
                while (it3.hasNext()) {
                    PasswordDBModel passwordDBModel3 = (PasswordDBModel) it3.next();
                    if (passwordDBModel3.getUserDetail().equals(string) && !passwordDBModel3.getUserPassword().isEmpty()) {
                        str7 = passwordDBModel3.getUserDetail();
                        str8 = passwordDBModel3.getUserPassword();
                    }
                }
                str = str7;
                str2 = str8;
            } else {
                str = "";
                str2 = str;
            }
            if (str == null || str.equals("") || str.isEmpty()) {
                if (string.isEmpty() || string.equals("")) {
                    return;
                }
                e3(this, 100, string);
                return;
            }
            a3(this, 100, string, str, str2);
            return;
        }
        Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
    }

    public final /* synthetic */ void s2(View view) {
        String string;
        String str;
        String str2;
        if (!m7.a.o.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                string = getSharedPreferences("loginPrefs", 0).getString("username", "");
                LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.Q);
                this.S = liveStreamDBHandler;
                ArrayList allPassword = liveStreamDBHandler.getAllPassword(SharepreferenceDBHandler.getUserID(this.Q));
                if (allPassword != null) {
                    Iterator it = allPassword.iterator();
                    String str3 = "";
                    String str4 = str3;
                    while (it.hasNext()) {
                        PasswordDBModel passwordDBModel = (PasswordDBModel) it.next();
                        if (passwordDBModel.getUserDetail().equals(string) && !passwordDBModel.getUserPassword().isEmpty()) {
                            str3 = passwordDBModel.getUserDetail();
                            str4 = passwordDBModel.getUserPassword();
                        }
                    }
                    str = str3;
                    str2 = str4;
                } else {
                    str = "";
                    str2 = str;
                }
                if (str == null || str.equals("") || str.isEmpty()) {
                    if (string.isEmpty() || string.equals("")) {
                        return;
                    }
                    e3(this, 100, string);
                    return;
                }
                a3(this, 100, string, str, str2);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (!m7.a.V0.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                string = getSharedPreferences("loginPrefs", 0).getString("username", "");
                LiveStreamDBHandler liveStreamDBHandler2 = new LiveStreamDBHandler(this.Q);
                this.S = liveStreamDBHandler2;
                ArrayList allPassword2 = liveStreamDBHandler2.getAllPassword(SharepreferenceDBHandler.getUserID(this.Q));
                if (allPassword2 != null) {
                    Iterator it2 = allPassword2.iterator();
                    String str5 = "";
                    String str6 = str5;
                    while (it2.hasNext()) {
                        PasswordDBModel passwordDBModel2 = (PasswordDBModel) it2.next();
                        if (passwordDBModel2.getUserDetail().equals(string) && !passwordDBModel2.getUserPassword().isEmpty()) {
                            str5 = passwordDBModel2.getUserDetail();
                            str6 = passwordDBModel2.getUserPassword();
                        }
                    }
                    str = str5;
                    str2 = str6;
                } else {
                    str = "";
                    str2 = str;
                }
                if (str == null || str.equals("") || str.isEmpty()) {
                    if (string.isEmpty() || string.equals("")) {
                        return;
                    }
                    e3(this, 100, string);
                    return;
                }
                a3(this, 100, string, str, str2);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
            try {
                new w.j(this, this.Q, a1).show();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
            string = getSharedPreferences("loginPrefs", 0).getString("username", "");
            LiveStreamDBHandler liveStreamDBHandler3 = new LiveStreamDBHandler(this.Q);
            this.S = liveStreamDBHandler3;
            ArrayList allPassword3 = liveStreamDBHandler3.getAllPassword(SharepreferenceDBHandler.getUserID(this.Q));
            if (allPassword3 != null) {
                Iterator it3 = allPassword3.iterator();
                String str7 = "";
                String str8 = str7;
                while (it3.hasNext()) {
                    PasswordDBModel passwordDBModel3 = (PasswordDBModel) it3.next();
                    if (passwordDBModel3.getUserDetail().equals(string) && !passwordDBModel3.getUserPassword().isEmpty()) {
                        str7 = passwordDBModel3.getUserDetail();
                        str8 = passwordDBModel3.getUserPassword();
                    }
                }
                str = str7;
                str2 = str8;
            } else {
                str = "";
                str2 = str;
            }
            if (str == null || str.equals("") || str.isEmpty()) {
                if (string.isEmpty() || string.equals("")) {
                    return;
                }
                e3(this, 100, string);
                return;
            }
            a3(this, 100, string, str, str2);
            return;
        }
        Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
    }

    public final /* synthetic */ void t2(View view) {
        if (SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        } else {
            startActivity(new Intent(this, EPGSettingsActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public final /* synthetic */ void u2(View view) {
        if (SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        } else {
            startActivity(new Intent(this, EPGSettingsActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public final /* synthetic */ void v2(View view) {
        Intent intent;
        if (!m7.a.o.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                intent = new Intent(this, StreamFormatActivity.class);
                startActivity(intent);
                overridePendingTransition(a7.b.f, a7.b.d);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (!m7.a.V0.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                intent = new Intent(this, StreamFormatActivity.class);
                startActivity(intent);
                overridePendingTransition(a7.b.f, a7.b.d);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
            try {
                new w.j(this, this.Q, a1).show();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
            intent = new Intent(this, StreamFormatActivity.class);
            startActivity(intent);
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
    }

    public final /* synthetic */ void w2(View view) {
        Intent intent;
        if (!m7.a.o.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                intent = new Intent(this, StreamFormatActivity.class);
                startActivity(intent);
                overridePendingTransition(a7.b.f, a7.b.d);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (!m7.a.V0.booleanValue()) {
            if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
                intent = new Intent(this, StreamFormatActivity.class);
                startActivity(intent);
                overridePendingTransition(a7.b.f, a7.b.d);
                return;
            }
            Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
        }
        if (a1.k() == null || a1.n() == null || a1.l() == 0 || a1.k().equals("") || a1.n().equals("")) {
            try {
                new w.j(this, this.Q, a1).show();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.Q).equals("stalker_api")) {
            intent = new Intent(this, StreamFormatActivity.class);
            startActivity(intent);
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        Toast.makeText(this.Q, "This feature has been disabled.", 1).show();
    }

    public final /* synthetic */ void x2(View view) {
        startActivity(new Intent(this, TimeFormatActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public final /* synthetic */ void y2(View view) {
        startActivity(new Intent(this, TimeFormatActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public final /* synthetic */ void z2(View view) {
        startActivity(new Intent(this, AutomationActivity.class));
        overridePendingTransition(a7.b.f, a7.b.d);
    }
}
