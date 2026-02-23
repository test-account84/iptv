package com.nst.iptvsmarterstvbox.view.activity;

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
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import d.a;
import java.util.Calendar;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PlayerSettingsActivity extends androidx.appcompat.app.b implements View.OnClickListener {
    public SharedPreferences D;
    public SharedPreferences.Editor E;
    public SharedPreferences F;
    public SharedPreferences.Editor G;
    public SharedPreferences H;
    public SharedPreferences.Editor I;
    public androidx.appcompat.app.a J;
    public u7.a K;
    public Toolbar d;
    public AppBarLayout e;
    public Button f;
    public RadioGroup g;
    public RadioButton h;
    public RadioButton i;
    public RadioButton j;
    public Button k;
    public TextView l;
    public TextView m;
    public CheckBox n;
    public CheckBox o;
    public CheckBox p;
    public ImageView q;
    public TextView r;
    public FrameLayout s;
    public Context t;
    public SharedPreferences u;
    public SharedPreferences v;
    public SharedPreferences.Editor w;
    public SharedPreferences.Editor x;
    public LiveStreamDBHandler y;
    public DatabaseUpdatedStatusDBModel z = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel A = new DatabaseUpdatedStatusDBModel();
    public String B = "";
    public String C = "";
    public Thread L = null;

    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            w.j(PlayerSettingsActivity.u1(PlayerSettingsActivity.this));
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(PlayerSettingsActivity.u1(PlayerSettingsActivity.this));
                String A = w.A(date);
                TextView textView = PlayerSettingsActivity.this.m;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = PlayerSettingsActivity.this.l;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
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
            w.n0(PlayerSettingsActivity.u1(PlayerSettingsActivity.this));
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(PlayerSettingsActivity.u1(PlayerSettingsActivity.this));
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

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TextView textView;
            String str;
            switch (i) {
                case 0:
                    textView = PlayerSettingsActivity.this.r;
                    str = "1";
                    break;
                case 1:
                    textView = PlayerSettingsActivity.this.r;
                    str = "2";
                    break;
                case 2:
                    textView = PlayerSettingsActivity.this.r;
                    str = "3";
                    break;
                case 3:
                    textView = PlayerSettingsActivity.this.r;
                    str = "4";
                    break;
                case 4:
                    textView = PlayerSettingsActivity.this.r;
                    str = "5";
                    break;
                case 5:
                    textView = PlayerSettingsActivity.this.r;
                    str = "10";
                    break;
                case 6:
                    textView = PlayerSettingsActivity.this.r;
                    str = "20";
                    break;
                case 7:
                    textView = PlayerSettingsActivity.this.r;
                    str = "30";
                    break;
                case 8:
                    textView = PlayerSettingsActivity.this.r;
                    str = "40";
                    break;
                case 9:
                    textView = PlayerSettingsActivity.this.r;
                    str = "50";
                    break;
                case 10:
                    textView = PlayerSettingsActivity.this.r;
                    str = "100";
                    break;
                default:
                    return;
            }
            textView.setText(str);
            dialogInterface.cancel();
        }
    }

    public class k implements Runnable {
        public k() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    PlayerSettingsActivity.this.y1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public class l implements View.OnFocusChangeListener {
        public final View a;

        public l(View view) {
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
                        this.a.setBackground(PlayerSettingsActivity.this.getResources().getDrawable(a7.e.K1));
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

    private void A1() {
        RadioButton radioButton;
        this.t = this;
        this.y = new LiveStreamDBHandler(this.t);
        this.D = getSharedPreferences("pref.using_opensl_es", 0);
        this.F = getSharedPreferences("pref.using_opengl", 0);
        this.H = getSharedPreferences("pref.using_infbuf", 0);
        this.u = getSharedPreferences("pref.using_media_codec", 0);
        SharedPreferences sharedPreferences = getSharedPreferences("pref.using_buffer_size", 0);
        this.v = sharedPreferences;
        this.w = sharedPreferences.edit();
        String string = this.D.getString("pref.using_opensl_es", "");
        String string2 = this.F.getString("pref.using_opengl", "");
        String string3 = this.u.getString("pref.using_media_codec", m7.a.v0);
        String string4 = this.H.getString("pref.using_infbuf", "unchecked");
        int i2 = this.v.getInt("pref.using_buffer_size", m7.a.w0);
        if (string3.equals(getResources().getString(a7.j.U3)) || string3.equals("Native")) {
            this.i.setChecked(true);
            radioButton = this.i;
        } else if (string3.equals(getResources().getString(a7.j.p2)) || string3.equals("Hardware Decoder") || !(string3.equals(getResources().getString(a7.j.d7)) || string3.equals("Software Decoder"))) {
            this.h.setChecked(true);
            radioButton = this.h;
        } else {
            this.j.setChecked(true);
            radioButton = this.j;
        }
        radioButton.requestFocus();
        if (string.equals("checked")) {
            this.n.setChecked(true);
        }
        if (string2.equals("checked")) {
            this.o.setChecked(true);
        }
        if (string4.equals("checked")) {
            this.p.setChecked(true);
        }
        TextView textView = this.r;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
    }

    public static /* synthetic */ Context u1(PlayerSettingsActivity playerSettingsActivity) {
        return playerSettingsActivity.t;
    }

    private void x1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void z1() {
        Button button = this.f;
        if (button != null) {
            button.setOnFocusChangeListener(new l(button));
        }
        Button button2 = this.k;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new l(button2));
        }
        RadioButton radioButton = this.i;
        if (radioButton != null) {
            radioButton.setOnFocusChangeListener(new l(radioButton));
        }
        RadioButton radioButton2 = this.h;
        if (radioButton2 != null) {
            radioButton2.setOnFocusChangeListener(new l(radioButton2));
        }
        RadioButton radioButton3 = this.j;
        if (radioButton3 != null) {
            radioButton3.setOnFocusChangeListener(new l(radioButton3));
        }
        CheckBox checkBox = this.n;
        if (checkBox != null) {
            checkBox.setOnFocusChangeListener(new l(checkBox));
        }
        CheckBox checkBox2 = this.o;
        if (checkBox2 != null) {
            checkBox2.setOnFocusChangeListener(new l(checkBox2));
        }
        CheckBox checkBox3 = this.p;
        if (checkBox3 != null) {
            checkBox3.setOnFocusChangeListener(new l(checkBox3));
        }
        FrameLayout frameLayout = this.s;
        if (frameLayout != null) {
            frameLayout.setOnFocusChangeListener(new l(frameLayout));
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        SharedPreferences.Editor editor;
        String str;
        if (view.getId() == a7.f.D0) {
            this.D = getSharedPreferences("pref.using_opensl_es", 0);
            this.F = getSharedPreferences("pref.using_opengl", 0);
            this.H = getSharedPreferences("pref.using_infbuf", 0);
            w1(Integer.parseInt(this.r.getText().toString()));
            this.E = this.D.edit();
            this.G = this.F.edit();
            this.I = this.H.edit();
            if (this.n.isChecked()) {
                SharedPreferences.Editor editor2 = this.E;
                if (editor2 != null) {
                    editor2.putString("pref.using_opensl_es", "checked");
                }
            } else {
                SharedPreferences.Editor editor3 = this.E;
                if (editor3 != null) {
                    editor3.putString("pref.using_opensl_es", "");
                }
            }
            if (this.o.isChecked()) {
                SharedPreferences.Editor editor4 = this.G;
                if (editor4 != null) {
                    editor4.putString("pref.using_opengl", "checked");
                }
            } else {
                SharedPreferences.Editor editor5 = this.G;
                if (editor5 != null) {
                    editor5.putString("pref.using_opengl", "");
                }
            }
            if (this.p.isChecked()) {
                SharedPreferences.Editor editor6 = this.I;
                if (editor6 != null) {
                    editor6.putString("pref.using_infbuf", "checked");
                }
            } else {
                SharedPreferences.Editor editor7 = this.I;
                if (editor7 != null) {
                    editor7.putString("pref.using_infbuf", "unchecked");
                }
            }
            this.E.apply();
            this.G.apply();
            this.I.apply();
            int checkedRadioButtonId = this.g.getCheckedRadioButtonId();
            this.u = getSharedPreferences("pref.using_media_codec", 0);
            RadioButton findViewById = findViewById(checkedRadioButtonId);
            String valueOf = findViewById.getTag() != null ? String.valueOf(findViewById.getTag()) : "4";
            SharedPreferences.Editor edit = this.u.edit();
            this.x = edit;
            if (edit == null) {
                Toast.makeText(this, getResources().getString(a7.j.j5), 0).show();
                return;
            }
            if (valueOf.equals("3")) {
                editor = this.x;
                str = "Native";
            } else if (valueOf.equals("4")) {
                editor = this.x;
                str = "Hardware Decoder";
            } else {
                if (valueOf.equals("5")) {
                    editor = this.x;
                    str = "Software Decoder";
                }
                this.x.apply();
                Toast.makeText(this, getResources().getString(a7.j.k5), 0).show();
            }
            editor.putString("pref.using_media_codec", str);
            this.x.apply();
            Toast.makeText(this, getResources().getString(a7.j.k5), 0).show();
        } else if (view.getId() != a7.f.S0) {
            if (view.getId() == a7.f.Bj) {
                startActivity(new Intent(this, NewDashboardActivity.class));
                return;
            } else {
                if (view.getId() == a7.f.P3) {
                    v1();
                    return;
                }
                return;
            }
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        this.t = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.t);
        this.K = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? a7.g.q0 : a7.g.p0);
        w.Y(this);
        this.d = findViewById(a7.f.kh);
        this.e = findViewById(a7.f.W);
        this.f = findViewById(a7.f.D0);
        this.g = findViewById(a7.f.Kd);
        this.h = findViewById(a7.f.ld);
        this.i = findViewById(a7.f.qd);
        this.j = findViewById(a7.f.sd);
        this.k = findViewById(a7.f.S0);
        this.l = findViewById(a7.f.E2);
        this.m = findViewById(a7.f.gh);
        this.n = findViewById(a7.f.R1);
        this.o = findViewById(a7.f.Q1);
        this.p = findViewById(a7.f.P1);
        this.q = findViewById(a7.f.Xa);
        this.r = findViewById(a7.f.Oh);
        this.s = findViewById(a7.f.P3);
        this.k.setOnClickListener(this);
        this.f.setOnClickListener(this);
        z1();
        x1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        A1();
        Thread thread = this.L;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new k());
            this.L = thread2;
            thread2.start();
        }
        this.q.setOnClickListener(new b());
        this.s.setOnClickListener(this);
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
        if (itemId == a7.f.e && (context = this.t) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new e()).g(getResources().getString(a7.j.d4), new d()).n();
        }
        if (itemId == a7.f.fb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.t.getResources().getString(a7.j.u0));
            aVar.f(this.t.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.t.getResources().getString(a7.j.S8), new f());
            aVar.g(this.t.getResources().getString(a7.j.d4), new g());
            aVar.n();
        }
        if (itemId == a7.f.hb) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.t.getResources().getString(a7.j.u0));
            aVar2.f(this.t.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.t.getResources().getString(a7.j.S8), new h());
            aVar2.g(this.t.getResources().getString(a7.j.d4), new i());
            aVar2.n();
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.L;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.L.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        Thread thread = this.L;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new k());
            this.L = thread2;
            thread2.start();
        }
        w.m(this.t);
        w.z0(this.t);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.u = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.u.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v1() {
        /*
            r16 = this;
            r0 = r16
            r1 = 11
            java.lang.CharSequence[] r1 = new java.lang.CharSequence[r1]
            java.lang.String r2 = "1"
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "2"
            r4 = 1
            r1[r4] = r2
            java.lang.String r2 = "3"
            r5 = 2
            r1[r5] = r2
            java.lang.String r2 = "4"
            r6 = 3
            r1[r6] = r2
            java.lang.String r2 = "5"
            r7 = 4
            r1[r7] = r2
            java.lang.String r2 = "10"
            r8 = 5
            r1[r8] = r2
            java.lang.String r2 = "20"
            r9 = 6
            r1[r9] = r2
            java.lang.String r2 = "30"
            r10 = 7
            r1[r10] = r2
            java.lang.String r2 = "40"
            r11 = 8
            r1[r11] = r2
            java.lang.String r2 = "50"
            r12 = 9
            r1[r12] = r2
            java.lang.String r2 = "100"
            r13 = 10
            r1[r13] = r2
            androidx.appcompat.app.a$a r2 = new androidx.appcompat.app.a$a
            r2.<init>(r0)
            android.content.res.Resources r14 = r16.getResources()
            int r15 = a7.j.W
            java.lang.String r14 = r14.getString(r15)
            r2.setTitle(r14)
            android.content.SharedPreferences r14 = r0.v
            java.lang.String r15 = "pref.using_buffer_size"
            int r3 = m7.a.w0
            int r3 = r14.getInt(r15, r3)
            if (r3 != r4) goto L60
        L5e:
            r3 = 0
            goto L94
        L60:
            if (r3 != r5) goto L64
            r3 = 1
            goto L94
        L64:
            if (r3 != r6) goto L68
            r3 = 2
            goto L94
        L68:
            if (r3 != r7) goto L6c
            r3 = 3
            goto L94
        L6c:
            if (r3 != r8) goto L70
            r3 = 4
            goto L94
        L70:
            if (r3 != r13) goto L74
            r3 = 5
            goto L94
        L74:
            r4 = 20
            if (r3 != r4) goto L7a
            r3 = 6
            goto L94
        L7a:
            r4 = 30
            if (r3 != r4) goto L80
            r3 = 7
            goto L94
        L80:
            r4 = 40
            if (r3 != r4) goto L87
            r3 = 8
            goto L94
        L87:
            r4 = 50
            if (r3 != r4) goto L8e
            r3 = 9
            goto L94
        L8e:
            r4 = 100
            if (r3 != r4) goto L5e
            r3 = 10
        L94:
            com.nst.iptvsmarterstvbox.view.activity.PlayerSettingsActivity$j r4 = new com.nst.iptvsmarterstvbox.view.activity.PlayerSettingsActivity$j
            r4.<init>()
            r2.l(r1, r3, r4)
            androidx.appcompat.app.a r1 = r2.create()
            r0.J = r1
            com.nst.iptvsmarterstvbox.view.activity.PlayerSettingsActivity$a r2 = new com.nst.iptvsmarterstvbox.view.activity.PlayerSettingsActivity$a
            r2.<init>()
            r1.setOnDismissListener(r2)
            androidx.appcompat.app.a r1 = r0.J
            r1.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.PlayerSettingsActivity.v1():void");
    }

    public final void w1(int i2) {
        SharedPreferences.Editor editor = this.w;
        if (editor != null) {
            editor.putInt("pref.using_buffer_size", i2);
            this.w.apply();
        }
    }

    public void y1() {
        runOnUiThread(new c());
    }
}
