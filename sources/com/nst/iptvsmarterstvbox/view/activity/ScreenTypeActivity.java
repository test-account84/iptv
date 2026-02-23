package com.nst.iptvsmarterstvbox.view.activity;

import a7.c;
import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ScreenTypeActivity extends b implements View.OnClickListener {
    public RadioGroup d;
    public RadioButton e;
    public RadioButton f;
    public TextView g;
    public TextView h;
    public LinearLayout i;
    public Context j;
    public u7.a k;

    public class a implements View.OnFocusChangeListener {
        public final View a;

        public a(View view) {
            this.a = view;
        }

        public void onFocusChange(View view, boolean z) {
            View view2;
            TextView textView;
            Resources resources;
            int i;
            View view3;
            int i2;
            if (!z) {
                if (z) {
                    return;
                }
                View view4 = this.a;
                if ((view4 != null && view4.getTag() != null && this.a.getTag().equals("1")) || ((view2 = this.a) != null && view2.getTag() != null && this.a.getTag().equals("2"))) {
                    view3 = this.a;
                    i2 = e.o;
                    view3.setBackgroundResource(i2);
                }
                View view5 = this.a;
                if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("3")) {
                    return;
                }
                this.a.setBackgroundResource(e.d1);
                ScreenTypeActivity screenTypeActivity = ScreenTypeActivity.this;
                textView = screenTypeActivity.g;
                resources = screenTypeActivity.j.getResources();
                i = c.f;
                textView.setTextColor(resources.getColor(i));
                return;
            }
            View view6 = this.a;
            if (view6 == null || view6.getTag() == null || !this.a.getTag().equals("1")) {
                View view7 = this.a;
                if (view7 == null || view7.getTag() == null || !this.a.getTag().equals("2")) {
                    View view8 = this.a;
                    if (view8 == null || view8.getTag() == null || !this.a.getTag().equals("3")) {
                        View view9 = this.a;
                        if (view9 == null || view9.getTag() == null) {
                            return;
                        }
                        this.a.setBackground(ScreenTypeActivity.this.getResources().getDrawable(e.K1));
                        return;
                    }
                    this.a.setBackgroundResource(e.c1);
                    ScreenTypeActivity screenTypeActivity2 = ScreenTypeActivity.this;
                    textView = screenTypeActivity2.g;
                    resources = screenTypeActivity2.j.getResources();
                    i = c.G;
                    textView.setTextColor(resources.getColor(i));
                    return;
                }
                view3 = this.a;
                i2 = e.k1;
            } else {
                view3 = this.a;
                i2 = e.h;
            }
            view3.setBackgroundResource(i2);
        }
    }

    private void u1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, c.k));
    }

    private void w1() {
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.i.setOnClickListener(this);
    }

    public void onBackPressed() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r3) {
        /*
            r2 = this;
            int r3 = r3.getId()
            int r0 = a7.f.pd
            if (r3 != r0) goto La
            goto L7a
        La:
            int r0 = a7.f.vd
            if (r3 != r0) goto Lf
            goto L7a
        Lf:
            int r0 = a7.f.Ia
            if (r3 != r0) goto L7a
            android.widget.RadioGroup r3 = r2.d
            int r3 = r3.getCheckedRadioButtonId()
            android.view.View r3 = r2.findViewById(r3)
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3
            java.lang.Object r0 = r3.getTag()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Mobile"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            u7.a r3 = r2.k
            java.lang.String r0 = m7.a.L0
        L33:
            r3.X(r0)
            goto L4c
        L37:
            java.lang.Object r3 = r3.getTag()
            java.lang.String r3 = r3.toString()
            java.lang.String r0 = "TV"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L4c
            u7.a r3 = r2.k
            java.lang.String r0 = m7.a.K0
            goto L33
        L4c:
            java.lang.Boolean r3 = m7.a.u
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L72
            java.lang.Boolean r3 = m7.a.v
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L5d
            goto L72
        L5d:
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<com.nst.iptvsmarterstvbox.view.activity.LoginActivity> r0 = com.nst.iptvsmarterstvbox.view.activity.LoginActivity.class
            r3.<init>(r2, r0)
        L64:
            r2.startActivity(r3)
            int r3 = a7.b.f
            int r0 = a7.b.d
            r2.overridePendingTransition(r3, r0)
            r2.finish()
            goto L7a
        L72:
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<com.nst.iptvsmarterstvbox.view.activity.RoutingActivity> r0 = com.nst.iptvsmarterstvbox.view.activity.RoutingActivity.class
            r3.<init>(r2, r0)
            goto L64
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ScreenTypeActivity.onClick(android.view.View):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(3:3|(1:5)(1:7)|6)|8|(1:10)(6:19|(1:21)|12|13|14|15)|11|12|13|14|15) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            r0 = 1
            r4.j = r4
            super/*androidx.fragment.app.e*/.onCreate(r5)
            r4.v1()
            int r5 = a7.g.o2
            r4.setContentView(r5)
            int r5 = a7.f.Jd
            android.view.View r5 = r4.findViewById(r5)
            android.widget.RadioGroup r5 = (android.widget.RadioGroup) r5
            r4.d = r5
            int r5 = a7.f.pd
            android.view.View r5 = r4.findViewById(r5)
            android.widget.RadioButton r5 = (android.widget.RadioButton) r5
            r4.e = r5
            int r5 = a7.f.vd
            android.view.View r5 = r4.findViewById(r5)
            android.widget.RadioButton r5 = (android.widget.RadioButton) r5
            r4.f = r5
            int r5 = a7.f.p1
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.g = r5
            int r5 = a7.f.Gi
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.h = r5
            int r5 = a7.f.Ia
            android.view.View r5 = r4.findViewById(r5)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            r4.i = r5
            u7.a r5 = new u7.a
            android.content.Context r1 = r4.j
            r5.<init>(r1)
            r4.k = r5
            java.lang.String r5 = r5.A()
            java.lang.String r1 = ""
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L7d
            android.content.Context r5 = r4.j
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            int r5 = r5.screenLayout
            r5 = r5 & 15
            r1 = 3
            if (r5 != r1) goto L78
            u7.a r5 = r4.k
            java.lang.String r1 = m7.a.K0
        L74:
            r5.X(r1)
            goto L7d
        L78:
            u7.a r5 = r4.k
            java.lang.String r1 = m7.a.L0
            goto L74
        L7d:
            u7.a r5 = r4.k
            java.lang.String r5 = r5.A()
            java.lang.String r1 = m7.a.L0
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L91
            android.widget.RadioButton r1 = r4.e
        L8d:
            r1.setChecked(r0)
            goto L9c
        L91:
            java.lang.String r1 = m7.a.K0
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L9c
            android.widget.RadioButton r1 = r4.f
            goto L8d
        L9c:
            android.content.res.Resources r1 = r4.getResources()     // Catch: java.lang.Exception -> Lb0
            int r2 = a7.j.P0     // Catch: java.lang.Exception -> Lb0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> Lb0
            r3 = 0
            r0[r3] = r5     // Catch: java.lang.Exception -> Lb0
            java.lang.String r5 = r1.getString(r2, r0)     // Catch: java.lang.Exception -> Lb0
            android.widget.TextView r0 = r4.h     // Catch: java.lang.Exception -> Lb0
            r0.setText(r5)     // Catch: java.lang.Exception -> Lb0
        Lb0:
            r4.w1()
            android.widget.RadioButton r5 = r4.e
            com.nst.iptvsmarterstvbox.view.activity.ScreenTypeActivity$a r0 = new com.nst.iptvsmarterstvbox.view.activity.ScreenTypeActivity$a
            r0.<init>(r5)
            r5.setOnFocusChangeListener(r0)
            android.widget.RadioButton r5 = r4.f
            com.nst.iptvsmarterstvbox.view.activity.ScreenTypeActivity$a r0 = new com.nst.iptvsmarterstvbox.view.activity.ScreenTypeActivity$a
            r0.<init>(r5)
            r5.setOnFocusChangeListener(r0)
            android.widget.LinearLayout r5 = r4.i
            com.nst.iptvsmarterstvbox.view.activity.ScreenTypeActivity$a r0 = new com.nst.iptvsmarterstvbox.view.activity.ScreenTypeActivity$a
            r0.<init>(r5)
            r5.setOnFocusChangeListener(r0)
            r4.u1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.ScreenTypeActivity.onCreate(android.os.Bundle):void");
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        v1();
    }

    public void v1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }
}
