package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.Calendar;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AutomationActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public androidx.appcompat.app.a B;
    public u7.a C;
    public Toolbar d;
    public AppBarLayout e;
    public Button f;
    public Button g;
    public CheckBox h;
    public CheckBox i;
    public TextView j;
    public TextView k;
    public TextView l;
    public FrameLayout m;
    public TextView n;
    public FrameLayout o;
    public LinearLayout p;
    public ImageView q;
    public Context r;
    public SharedPreferences s;
    public SharedPreferences.Editor t;
    public SharedPreferences u;
    public SharedPreferences.Editor v;
    public LiveStreamDBHandler w;
    public DatabaseUpdatedStatusDBModel x = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel y = new DatabaseUpdatedStatusDBModel();
    public int z = m7.a.D0;
    public int A = m7.a.H0;
    public Thread D = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            AutomationActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            w.j(AutomationActivity.u1(AutomationActivity.this));
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            int parseInt = Integer.parseInt(AutomationActivity.this.l.getText().toString());
            int parseInt2 = Integer.parseInt(AutomationActivity.this.n.getText().toString());
            AutomationActivity.v1(AutomationActivity.this, parseInt);
            AutomationActivity.w1(AutomationActivity.this, parseInt2);
            AutomationActivity automationActivity = AutomationActivity.this;
            AutomationActivity.y1(automationActivity, automationActivity.getSharedPreferences("automation_channels", 0));
            AutomationActivity automationActivity2 = AutomationActivity.this;
            AutomationActivity.A1(automationActivity2, automationActivity2.getSharedPreferences("automation_epg", 0));
            AutomationActivity automationActivity3 = AutomationActivity.this;
            AutomationActivity.C1(automationActivity3, AutomationActivity.x1(automationActivity3).edit());
            AutomationActivity automationActivity4 = AutomationActivity.this;
            AutomationActivity.E1(automationActivity4, AutomationActivity.z1(automationActivity4).edit());
            if (AutomationActivity.this.h.isChecked()) {
                if (AutomationActivity.B1(AutomationActivity.this) != null) {
                    AutomationActivity.B1(AutomationActivity.this).putString("automation_channels", "checked");
                }
            } else if (AutomationActivity.B1(AutomationActivity.this) != null) {
                AutomationActivity.B1(AutomationActivity.this).putString("automation_channels", "unchecked");
            }
            if (AutomationActivity.this.i.isChecked()) {
                if (AutomationActivity.D1(AutomationActivity.this) != null) {
                    AutomationActivity.D1(AutomationActivity.this).putString("automation_epg", "checked");
                }
            } else if (AutomationActivity.D1(AutomationActivity.this) != null) {
                AutomationActivity.D1(AutomationActivity.this).putString("automation_epg", "unchecked");
            }
            AutomationActivity.B1(AutomationActivity.this).apply();
            AutomationActivity.D1(AutomationActivity.this).apply();
            AutomationActivity automationActivity5 = AutomationActivity.this;
            Toast.makeText(automationActivity5, automationActivity5.getResources().getString(a7.j.k5), 0).show();
            AutomationActivity.this.finish();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(AutomationActivity.u1(AutomationActivity.this));
                String A = w.A(date);
                TextView textView = AutomationActivity.this.k;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = AutomationActivity.this.j;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TextView textView;
            String str;
            switch (i) {
                case 0:
                    textView = AutomationActivity.this.n;
                    str = "1";
                    break;
                case 1:
                    textView = AutomationActivity.this.n;
                    str = "2";
                    break;
                case 2:
                    textView = AutomationActivity.this.n;
                    str = "3";
                    break;
                case 3:
                    textView = AutomationActivity.this.n;
                    str = "4";
                    break;
                case 4:
                    textView = AutomationActivity.this.n;
                    str = "5";
                    break;
                case 5:
                    textView = AutomationActivity.this.n;
                    str = "6";
                    break;
                case 6:
                    textView = AutomationActivity.this.n;
                    str = "7";
                    break;
                default:
                    return;
            }
            textView.setText(str);
            dialogInterface.cancel();
        }
    }

    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TextView textView;
            String str;
            switch (i) {
                case 0:
                    textView = AutomationActivity.this.l;
                    str = "1";
                    break;
                case 1:
                    textView = AutomationActivity.this.l;
                    str = "2";
                    break;
                case 2:
                    textView = AutomationActivity.this.l;
                    str = "3";
                    break;
                case 3:
                    textView = AutomationActivity.this.l;
                    str = "4";
                    break;
                case 4:
                    textView = AutomationActivity.this.l;
                    str = "5";
                    break;
                case 5:
                    textView = AutomationActivity.this.l;
                    str = "6";
                    break;
                case 6:
                    textView = AutomationActivity.this.l;
                    str = "7";
                    break;
                default:
                    return;
            }
            textView.setText(str);
            dialogInterface.cancel();
        }
    }

    public class h implements DialogInterface.OnDismissListener {
        public h() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    AutomationActivity.this.J1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class j implements View.OnFocusChangeListener {
        public final View a;

        public j(View view) {
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
            float f;
            View view2;
            View view3;
            int i;
            if (z) {
                f = z ? 1.05f : 1.0f;
                View view4 = this.a;
                if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                    View view5 = this.a;
                    if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                        View view6 = this.a;
                        if (view6 == null || view6.getTag() == null) {
                            return;
                        }
                        this.a.setBackground(AutomationActivity.this.getResources().getDrawable(a7.e.K1));
                        return;
                    }
                    a(f);
                    b(f);
                    view3 = this.a;
                    i = a7.e.k1;
                } else {
                    a(f);
                    b(f);
                    view3 = this.a;
                    i = a7.e.h;
                }
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                View view7 = this.a;
                if ((view7 == null || view7.getTag() == null || !this.a.getTag().equals("1")) && ((view2 = this.a) == null || view2.getTag() == null || !this.a.getTag().equals("2"))) {
                    return;
                }
                view3 = this.a;
                i = a7.e.o;
            }
            view3.setBackgroundResource(i);
        }
    }

    public static /* synthetic */ SharedPreferences A1(AutomationActivity automationActivity, SharedPreferences sharedPreferences) {
        automationActivity.u = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences.Editor B1(AutomationActivity automationActivity) {
        return automationActivity.t;
    }

    public static /* synthetic */ SharedPreferences.Editor C1(AutomationActivity automationActivity, SharedPreferences.Editor editor) {
        automationActivity.t = editor;
        return editor;
    }

    public static /* synthetic */ SharedPreferences.Editor D1(AutomationActivity automationActivity) {
        return automationActivity.v;
    }

    public static /* synthetic */ SharedPreferences.Editor E1(AutomationActivity automationActivity, SharedPreferences.Editor editor) {
        automationActivity.v = editor;
        return editor;
    }

    private void H1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void L1() {
        Button button = this.f;
        if (button != null) {
            button.setOnFocusChangeListener(new j(button));
        }
        Button button2 = this.g;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new j(button2));
        }
        CheckBox checkBox = this.h;
        if (checkBox != null) {
            checkBox.setOnFocusChangeListener(new j(checkBox));
        }
        CheckBox checkBox2 = this.i;
        if (checkBox2 != null) {
            checkBox2.setOnFocusChangeListener(new j(checkBox2));
        }
        FrameLayout frameLayout = this.m;
        if (frameLayout != null) {
            frameLayout.setOnFocusChangeListener(new j(frameLayout));
        }
        FrameLayout frameLayout2 = this.o;
        if (frameLayout2 != null) {
            frameLayout2.setOnFocusChangeListener(new j(frameLayout2));
        }
    }

    private void M1() {
        this.r = this;
        this.w = new LiveStreamDBHandler(this.r);
        this.s = getSharedPreferences("automation_channels", 0);
        this.u = getSharedPreferences("automation_epg", 0);
        String string = this.s.getString("automation_channels", "");
        this.z = this.s.getInt("automation_channels_days", m7.a.D0);
        String string2 = this.u.getString("automation_epg", "");
        this.A = this.u.getInt("automation_epg_days", m7.a.H0);
        this.t = this.s.edit();
        this.v = this.u.edit();
        this.m.setOnClickListener(this);
        this.o.setOnClickListener(this);
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(String.valueOf(this.z));
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setText(String.valueOf(this.A));
        }
        if (string.equalsIgnoreCase("checked")) {
            this.h.setChecked(true);
        } else if (string.equalsIgnoreCase("unchecked")) {
            this.h.setChecked(false);
        } else {
            this.t.putString("automation_channels", "checked");
            this.t.apply();
            this.h.setChecked(true);
        }
        if (!string2.equalsIgnoreCase("checked")) {
            if (string2.equalsIgnoreCase("unchecked")) {
                this.i.setChecked(false);
                return;
            } else {
                this.v.putString("automation_epg", "checked");
                this.v.apply();
            }
        }
        this.i.setChecked(true);
    }

    public static /* synthetic */ Context u1(AutomationActivity automationActivity) {
        return automationActivity.r;
    }

    public static /* synthetic */ void v1(AutomationActivity automationActivity, int i2) {
        automationActivity.I1(i2);
    }

    public static /* synthetic */ void w1(AutomationActivity automationActivity, int i2) {
        automationActivity.K1(i2);
    }

    public static /* synthetic */ SharedPreferences x1(AutomationActivity automationActivity) {
        return automationActivity.s;
    }

    public static /* synthetic */ SharedPreferences y1(AutomationActivity automationActivity, SharedPreferences sharedPreferences) {
        automationActivity.s = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences z1(AutomationActivity automationActivity) {
        return automationActivity.u;
    }

    public final void F1() {
        int i2 = 0;
        CharSequence[] charSequenceArr = {"1", "2", "3", "4", "5", "6", "7"};
        a.a aVar = new a.a(this);
        aVar.setTitle(getResources().getString(a7.j.N));
        int i3 = this.s.getInt("automation_channels_days", m7.a.D0);
        this.z = i3;
        switch (i3) {
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                i2 = 3;
                break;
            case 5:
                i2 = 4;
                break;
            case 6:
                i2 = 5;
                break;
            case 7:
                i2 = 6;
                break;
        }
        aVar.l(charSequenceArr, i2, new g());
        androidx.appcompat.app.a create = aVar.create();
        this.B = create;
        create.setOnDismissListener(new h());
        this.B.show();
    }

    public final void G1() {
        int i2 = 0;
        CharSequence[] charSequenceArr = {"1", "2", "3", "4", "5", "6", "7"};
        a.a aVar = new a.a(this);
        aVar.setTitle(getResources().getString(a7.j.N));
        int i3 = this.u.getInt("automation_epg_days", m7.a.H0);
        this.A = i3;
        switch (i3) {
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                i2 = 3;
                break;
            case 5:
                i2 = 4;
                break;
            case 6:
                i2 = 5;
                break;
            case 7:
                i2 = 6;
                break;
        }
        aVar.l(charSequenceArr, i2, new e());
        androidx.appcompat.app.a create = aVar.create();
        this.B = create;
        create.setOnDismissListener(new f());
        this.B.show();
    }

    public final void I1(int i2) {
        SharedPreferences.Editor editor = this.t;
        if (editor != null) {
            editor.putInt("automation_channels_days", i2);
            this.t.apply();
        }
    }

    public void J1() {
        runOnUiThread(new d());
    }

    public final void K1(int i2) {
        SharedPreferences.Editor editor = this.v;
        if (editor != null) {
            editor.putInt("automation_epg_days", i2);
            this.v.apply();
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        } else if (id == a7.f.N3) {
            F1();
        } else if (id == a7.f.O3) {
            G1();
        }
    }

    public void onCreate(Bundle bundle) {
        this.r = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.r);
        this.C = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? a7.g.l : a7.g.k);
        w.Y(this);
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.D0);
        this.g = findViewById(a7.f.S0);
        this.h = findViewById(a7.f.O1);
        this.i = findViewById(a7.f.N1);
        this.j = findViewById(a7.f.E2);
        this.k = findViewById(a7.f.gh);
        this.l = findViewById(a7.f.Gh);
        this.m = findViewById(a7.f.N3);
        this.n = findViewById(a7.f.Hh);
        this.o = findViewById(a7.f.O3);
        this.p = findViewById(a7.f.c8);
        this.q = findViewById(a7.f.Xa);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.r).equals("stalker_api")) {
            this.p.setVisibility(8);
        }
        L1();
        this.g.setOnClickListener(new a());
        H1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        this.q.setOnClickListener(new b());
        M1();
        this.f.setOnClickListener(new c());
        Thread thread = this.D;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new i());
            this.D = thread2;
            thread2.start();
        }
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.D;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.D.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.D;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new i());
            this.D = thread2;
            thread2.start();
        }
        w.z0(this.r);
        w.m(this.r);
    }

    public void onViewClicked(View view) {
        view.getId();
    }
}
