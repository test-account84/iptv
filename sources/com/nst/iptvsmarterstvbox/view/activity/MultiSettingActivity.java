package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class MultiSettingActivity extends androidx.appcompat.app.b {
    public Button d;
    public Button e;
    public Button f;
    public CheckBox g;
    public ImageView h;
    public Context i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public ImageView o;
    public String p = "";
    public PopupWindow q;
    public u7.a r;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            MultiSettingActivity multiSettingActivity = MultiSettingActivity.this;
            MultiSettingActivity.u1(multiSettingActivity, multiSettingActivity.i);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            MultiSettingActivity.v1(MultiSettingActivity.this);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            MultiSettingActivity.this.onBackPressed();
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ Context a;

        public d(Context context) {
            this.a = context;
        }

        public void onClick(View view) {
            SharepreferenceDBHandler.setScreenTYPE("default", this.a);
            MultiSettingActivity multiSettingActivity = MultiSettingActivity.this;
            multiSettingActivity.h.setImageDrawable(multiSettingActivity.getResources().getDrawable(a7.e.K));
            MultiSettingActivity.w1(MultiSettingActivity.this).dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            MultiSettingActivity multiSettingActivity = MultiSettingActivity.this;
            multiSettingActivity.p = "screen1";
            multiSettingActivity.h.setImageDrawable(multiSettingActivity.getResources().getDrawable(a7.e.C1));
            MultiSettingActivity.w1(MultiSettingActivity.this).dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            MultiSettingActivity multiSettingActivity = MultiSettingActivity.this;
            multiSettingActivity.p = "screen2";
            multiSettingActivity.h.setImageDrawable(multiSettingActivity.getResources().getDrawable(a7.e.D1));
            MultiSettingActivity.w1(MultiSettingActivity.this).dismiss();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            MultiSettingActivity multiSettingActivity = MultiSettingActivity.this;
            multiSettingActivity.p = "screen3";
            multiSettingActivity.h.setImageDrawable(multiSettingActivity.getResources().getDrawable(a7.e.E1));
            MultiSettingActivity.w1(MultiSettingActivity.this).dismiss();
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            MultiSettingActivity multiSettingActivity = MultiSettingActivity.this;
            multiSettingActivity.p = "screen4";
            multiSettingActivity.h.setImageDrawable(multiSettingActivity.getResources().getDrawable(a7.e.F1));
            MultiSettingActivity.w1(MultiSettingActivity.this).dismiss();
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            MultiSettingActivity multiSettingActivity = MultiSettingActivity.this;
            multiSettingActivity.p = "screen5";
            multiSettingActivity.h.setImageDrawable(multiSettingActivity.getResources().getDrawable(a7.e.G1));
            MultiSettingActivity.w1(MultiSettingActivity.this).dismiss();
        }
    }

    public class j implements View.OnFocusChangeListener {
        public final View a;

        public j(View view) {
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
            int i;
            if (!z) {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
                if ((this.a.getTag() == null || !this.a.getTag().equals("1")) && ((this.a.getTag() == null || !this.a.getTag().equals("2")) && (this.a.getTag() == null || !this.a.getTag().equals("3")))) {
                    return;
                }
                this.a.setBackgroundResource(a7.e.o);
                return;
            }
            f = z ? 1.09f : 1.0f;
            if (this.a.getTag() != null && this.a.getTag().equals("1")) {
                view2 = this.a;
                i = a7.e.p;
            } else if (this.a.getTag() != null && this.a.getTag().equals("2")) {
                view2 = this.a;
                i = a7.e.h;
            } else {
                if (this.a.getTag() == null || !this.a.getTag().equals("3")) {
                    return;
                }
                view2 = this.a;
                i = a7.e.k1;
            }
            view2.setBackgroundResource(i);
            b(f);
            c(f);
        }
    }

    public static /* synthetic */ void u1(MultiSettingActivity multiSettingActivity, Context context) {
        multiSettingActivity.y1(context);
    }

    public static /* synthetic */ void v1(MultiSettingActivity multiSettingActivity) {
        multiSettingActivity.z1();
    }

    public static /* synthetic */ PopupWindow w1(MultiSettingActivity multiSettingActivity) {
        return multiSettingActivity.q;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void x1() {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.MultiSettingActivity.x1():void");
    }

    private void z1() {
        SharepreferenceDBHandler.setScreenTYPE(this.p, this.i);
        Boolean bool = this.g.isChecked() ? Boolean.TRUE : Boolean.FALSE;
        SharepreferenceDBHandler.setValueChecked(bool, this.i);
        SharepreferenceDBHandler.setShowPop(bool, this.i);
        Toast.makeText(this.i, getResources().getString(a7.j.k5), 0).show();
        onBackPressed();
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.i = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.i);
        this.r = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? a7.g.Z : a7.g.Y);
        w.Y(this);
        this.d = findViewById(a7.f.g1);
        this.e = findViewById(a7.f.Jf);
        this.f = findViewById(a7.f.g0);
        this.g = findViewById(a7.f.hg);
        this.h = findViewById(a7.f.Sf);
        x1();
    }

    public final void y1(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(new u7.a(context).A().equals(m7.a.K0) ? a7.g.q4 : a7.g.p4, findViewById(a7.f.Rf));
        this.j = inflate.findViewById(a7.f.F2);
        this.k = inflate.findViewById(a7.f.Mf);
        this.l = inflate.findViewById(a7.f.Nf);
        this.m = inflate.findViewById(a7.f.Of);
        this.n = inflate.findViewById(a7.f.Pf);
        this.o = inflate.findViewById(a7.f.Qf);
        PopupWindow popupWindow = new PopupWindow(context);
        this.q = popupWindow;
        popupWindow.setContentView(inflate);
        this.q.setWidth(-1);
        this.q.setHeight(-1);
        this.q.setFocusable(true);
        this.q.showAtLocation(inflate, 0, 0, 0);
        this.j.setOnClickListener(new d(context));
        this.k.setOnClickListener(new e());
        this.l.setOnClickListener(new f());
        this.m.setOnClickListener(new g());
        this.n.setOnClickListener(new h());
        this.o.setOnClickListener(new i());
    }
}
