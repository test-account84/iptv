package com.nst.iptvsmarterstvbox;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.LoginActivity;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import d.a;
import java.util.Calendar;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class SubtitleActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public Toolbar d;
    public AppBarLayout e;
    public Button f;
    public Button g;
    public RadioGroup h;
    public RadioButton i;
    public ToggleButton j;
    public RadioButton k;
    public RadioButton l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public Context q;
    public SharedPreferences r;
    public SharedPreferences.Editor s;
    public LiveStreamDBHandler t;
    public u7.a y;
    public String p = "";
    public DatabaseUpdatedStatusDBModel u = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel v = new DatabaseUpdatedStatusDBModel();
    public String w = "";
    public String x = "";
    public Thread z = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(SubtitleActivity.u1(SubtitleActivity.this));
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(SubtitleActivity.u1(SubtitleActivity.this));
                String A = w.A(date);
                TextView textView = SubtitleActivity.this.n;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = SubtitleActivity.this.m;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class c implements RadioGroup.OnCheckedChangeListener {
        public c() {
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(SubtitleActivity.u1(SubtitleActivity.this));
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(SubtitleActivity.u1(SubtitleActivity.this));
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class j implements Runnable {
        public j() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    SubtitleActivity.this.w1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class k implements View.OnFocusChangeListener {
        public final View a;

        public k(View view) {
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
                        this.a.setBackground(SubtitleActivity.this.getResources().getDrawable(a7.e.K1));
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

    public static /* synthetic */ Context u1(SubtitleActivity subtitleActivity) {
        return subtitleActivity.q;
    }

    private void v1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void x1() {
        Button button = this.f;
        if (button != null) {
            button.setOnFocusChangeListener(new k(button));
            this.f.requestFocus();
            this.f.requestFocusFromTouch();
        }
        Button button2 = this.g;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new k(button2));
        }
        RadioButton radioButton = this.i;
        if (radioButton != null) {
            radioButton.setOnFocusChangeListener(new k(radioButton));
        }
        RadioButton radioButton2 = this.k;
        if (radioButton2 != null) {
            radioButton2.setOnFocusChangeListener(new k(radioButton2));
        }
        RadioButton radioButton3 = this.l;
        if (radioButton3 != null) {
            radioButton3.setOnFocusChangeListener(new k(radioButton3));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void y1() {
        /*
            r5 = this;
            r5.q = r5
            com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler r0 = new com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler
            android.content.Context r1 = r5.q
            r0.<init>(r1)
            r5.t = r0
            java.lang.String r0 = "allowedFormatsubtitle"
            r1 = 0
            android.content.SharedPreferences r2 = r5.getSharedPreferences(r0, r1)
            r5.r = r2
            java.lang.String r3 = ""
            java.lang.String r0 = r2.getString(r0, r3)
            android.content.SharedPreferences r2 = r5.r
            java.lang.String r4 = "opensubtitle"
            java.lang.String r2 = r2.getString(r4, r3)
            java.lang.String r3 = "enabledsubtitle"
            boolean r2 = r2.equals(r3)
            r3 = 1
            if (r2 == 0) goto L3f
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            m7.a.f = r2
            android.widget.RadioButton r2 = r5.i
            r2.setVisibility(r1)
            android.widget.RadioButton r2 = r5.k
            r2.setVisibility(r1)
            android.widget.ToggleButton r1 = r5.j
            r1.setChecked(r3)
            goto L54
        L3f:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            m7.a.f = r2
            android.widget.RadioButton r2 = r5.i
            r4 = 8
            r2.setVisibility(r4)
            android.widget.RadioButton r2 = r5.k
            r2.setVisibility(r4)
            android.widget.ToggleButton r2 = r5.j
            r2.setChecked(r1)
        L54:
            java.lang.String r1 = "default"
            boolean r2 = r0.equals(r1)
            java.lang.String r4 = "vip"
            if (r2 == 0) goto L88
            boolean r2 = r0.equals(r4)
            if (r2 == 0) goto L88
            android.widget.ToggleButton r2 = r5.j
            r2.setChecked(r3)
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L7a
        L6f:
            android.widget.RadioButton r0 = r5.i
            r0.setChecked(r3)
            android.widget.RadioButton r0 = r5.i
        L76:
            r0.requestFocus()
            goto La7
        L7a:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L6f
        L80:
            android.widget.RadioButton r0 = r5.k
            r0.setChecked(r3)
            android.widget.RadioButton r0 = r5.k
            goto L76
        L88:
            boolean r2 = r0.equals(r1)
            if (r2 != 0) goto L94
            boolean r2 = r0.equals(r4)
            if (r2 == 0) goto La7
        L94:
            android.widget.ToggleButton r2 = r5.j
            r2.setChecked(r3)
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto La0
            goto L6f
        La0:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L6f
            goto L80
        La7:
            android.widget.RadioGroup r0 = r5.h
            com.nst.iptvsmarterstvbox.SubtitleActivity$c r1 = new com.nst.iptvsmarterstvbox.SubtitleActivity$c
            r1.<init>()
            r0.setOnCheckedChangeListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.SubtitleActivity.y1():void");
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        SharedPreferences.Editor editor;
        String str;
        if (view.getId() == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
            return;
        }
        if (view.getId() == a7.f.D0) {
            RadioButton findViewById = findViewById(this.h.getCheckedRadioButtonId());
            SharedPreferences sharedPreferences = getSharedPreferences("allowedFormatsubtitle", 0);
            this.r = sharedPreferences;
            this.s = sharedPreferences.edit();
            if (this.p.equals("true")) {
                m7.a.f = Boolean.TRUE;
                this.s.putString("opensubtitle", "enabledsubtitle");
            } else {
                m7.a.f = Boolean.FALSE;
                this.s.putString("opensubtitle", "disabledsubtitle");
            }
            if (this.s == null) {
                Toast.makeText(this, getResources().getString(a7.j.j5), 0).show();
                return;
            }
            if (findViewById.getText().toString().equals("VIP Server")) {
                m7.a.f = Boolean.TRUE;
                this.s.putString("opensubtitle", "enabledsubtitle");
                editor = this.s;
                str = "vip";
            } else if (findViewById.getText().toString().equals("DEFAULT SERVER")) {
                m7.a.f = Boolean.TRUE;
                this.s.putString("opensubtitle", "enabledsubtitle");
                editor = this.s;
                str = "default";
            } else {
                this.s.putString("opensubtitle", "disabledsubtitle");
                m7.a.f = Boolean.FALSE;
                this.s.commit();
                Toast.makeText(this, getResources().getString(a7.j.k5), 0).show();
            }
            editor.putString("allowedFormatsubtitle", str);
            this.s.commit();
            Toast.makeText(this, getResources().getString(a7.j.k5), 0).show();
        } else if (view.getId() != a7.f.S0) {
            return;
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        this.q = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.q);
        this.y = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? a7.g.d1 : a7.g.e1);
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.D0);
        this.g = findViewById(a7.f.S0);
        this.h = findViewById(a7.f.Kd);
        this.i = findViewById(a7.f.od);
        this.j = findViewById(a7.f.jh);
        this.k = findViewById(a7.f.ud);
        this.l = findViewById(a7.f.id);
        this.m = findViewById(a7.f.E2);
        this.n = findViewById(a7.f.gh);
        this.o = findViewById(a7.f.Xa);
        x1();
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        v1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        y1();
        Thread thread = this.z;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new j());
            this.z = thread2;
            thread2.start();
        }
        this.o.setOnClickListener(new a());
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
        if (itemId == a7.f.e && (context = this.q) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new e()).g(getResources().getString(a7.j.d4), new d()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.q.getResources().getString(a7.j.u0));
            aVar.f(this.q.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.q.getResources().getString(a7.j.S8), new f());
            aVar.g(this.q.getResources().getString(a7.j.d4), new g());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.q.getResources().getString(a7.j.u0));
            aVar2.f(this.q.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.q.getResources().getString(a7.j.S8), new h());
            aVar2.g(this.q.getResources().getString(a7.j.d4), new i());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.z;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.z.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.z;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new j());
            this.z = thread2;
            thread2.start();
        }
        w.m(this.q);
        w.z0(this.q);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.r = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.r.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        }
    }

    public void onToggleClick(View view) {
        if (this.j.isChecked()) {
            this.i.setVisibility(0);
            this.k.setVisibility(0);
            this.p = "true";
        } else {
            this.p = "false";
            this.i.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public void w1() {
        runOnUiThread(new b());
    }
}
