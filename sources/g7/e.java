package g7;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.view.utility.ListViewMaxHeight;
import j$.util.Objects;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e {
    public String b;
    public Context c;
    public j g;
    public q7.h h;
    public q7.j i;
    public Button j;
    public Button k;
    public Button l;
    public Button m;
    public Button n;
    public ListViewMaxHeight p;
    public ImageView q;
    public AlertDialog.Builder r;
    public AlertDialog s;
    public File t;
    public boolean a = true;
    public String d = "";
    public List e = null;
    public List f = null;
    public HashMap o = new HashMap();
    public String u = "";

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (e.a(e.this) != null) {
                e.a(e.this).a(e.b(e.this));
            }
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            e.p(e.this).setVisibility(0);
            e.r(e.this).setVisibility(0);
            e.u(e.this, new File((String) e.v(e.this).get(i)));
            if (e.t(e.this) == null || !e.t(e.this).isFile()) {
                e eVar = e.this;
                e.x(eVar, e.t(eVar).getName());
                e eVar2 = e.this;
                e.e(eVar2, e.t(eVar2).getPath());
                ArrayList arrayList = new ArrayList();
                arrayList.clear();
                if (e.w(e.this).equals("!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#")) {
                    e eVar3 = e.this;
                    e.B(eVar3, e.t(eVar3));
                    return;
                }
                arrayList.add(e.t(e.this).getParent() + "/!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#");
                if (e.t(e.this).list() != null) {
                    int i2 = 0;
                    while (true) {
                        String[] list = e.t(e.this).list();
                        Objects.requireNonNull(list);
                        if (i2 >= list.length) {
                            break;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(e.t(e.this).getPath());
                        sb.append("/");
                        String[] list2 = e.t(e.this).list();
                        Objects.requireNonNull(list2);
                        sb.append(list2[i2]);
                        if (new File(sb.toString()).isDirectory()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(e.t(e.this).getPath());
                            sb2.append("/");
                            String[] list3 = e.t(e.this).list();
                            Objects.requireNonNull(list3);
                            sb2.append(list3[i2]);
                            arrayList.add(sb2.toString());
                        }
                        i2++;
                    }
                }
                e.v(e.this).clear();
                e.v(e.this).addAll(arrayList);
                e.z(e.this).notifyDataSetChanged();
                e.A(e.this).setSelection(0);
                if (e.A(e.this) != null) {
                    e.A(e.this).requestFocus();
                }
            }
        }
    }

    public class c implements DialogInterface.OnShowListener {

        public class a implements View.OnClickListener {
            public a() {
            }

            public void onClick(View view) {
                e.f(e.this).dismiss();
            }
        }

        public class b implements View.OnClickListener {
            public b() {
            }

            public void onClick(View view) {
                if (e.v(e.this) == null || e.v(e.this).get(0) == null) {
                    return;
                }
                e.B(e.this, new File((String) e.v(e.this).get(0)));
            }
        }

        public c() {
        }

        public void onShow(DialogInterface dialogInterface) {
            e eVar = e.this;
            e.d(eVar, e.f(eVar).getButton(-2));
            e eVar2 = e.this;
            e.s(eVar2, e.f(eVar2).getButton(-1));
            e eVar3 = e.this;
            e.q(eVar3, e.f(eVar3).getButton(-3));
            if (e.t(e.this) == null || e.t(e.this).getParent() == null || e.t(e.this).getParent().equals("/storage/emulated/0")) {
                e.p(e.this).setVisibility(4);
                e.r(e.this).setVisibility(4);
            } else {
                e.p(e.this).setVisibility(0);
                e.r(e.this).setVisibility(0);
            }
            e.c(e.this).setTag("1");
            e.r(e.this).setTag("2");
            e.p(e.this).setTag("3");
            Button c = e.c(e.this);
            e eVar4 = e.this;
            c.setOnFocusChangeListener(eVar4.new k(e.c(eVar4)));
            e.c(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
            ViewGroup.MarginLayoutParams layoutParams = e.c(e.this).getLayoutParams();
            ViewGroup.MarginLayoutParams layoutParams2 = e.r(e.this).getLayoutParams();
            ViewGroup.MarginLayoutParams layoutParams3 = e.p(e.this).getLayoutParams();
            layoutParams.setMargins(0, 0, 50, 0);
            String A = new u7.a(e.g(e.this)).A();
            if (A.equals(m7.a.K0)) {
                e.c(e.this).setTextSize(16.0f);
                e.c(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.o));
                layoutParams.width = 230;
                layoutParams.height = 90;
            } else {
                e.c(e.this).setTextSize(14.0f);
                e.c(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.h));
                layoutParams.width = 255;
                layoutParams.height = 135;
            }
            e.c(e.this).setOnClickListener(new a());
            e.p(e.this).setOnClickListener(new b());
            Button r = e.r(e.this);
            e eVar5 = e.this;
            r.setOnFocusChangeListener(eVar5.new k(e.r(eVar5)));
            layoutParams2.setMargins(0, 0, 70, 0);
            if (A.equals(m7.a.K0)) {
                e.r(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
                e.r(e.this).setTextSize(16.0f);
                e.r(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.o));
                layoutParams2.width = 230;
                layoutParams2.height = 90;
            } else {
                e.r(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
                e.r(e.this).setTextSize(14.0f);
                e.r(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.k1));
                layoutParams2.width = 255;
                layoutParams2.height = 135;
            }
            Button p = e.p(e.this);
            e eVar6 = e.this;
            p.setOnFocusChangeListener(eVar6.new k(e.p(eVar6)));
            e.p(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
            if (A.equals(m7.a.K0)) {
                e.p(e.this).setTextSize(16.0f);
                e.p(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.o));
                layoutParams3.width = 230;
                layoutParams3.height = 90;
                return;
            }
            e.p(e.this).setTextSize(14.0f);
            e.p(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.k1));
            layoutParams3.width = 255;
            layoutParams3.height = 135;
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (e.a(e.this) != null) {
                e.a(e.this).a(e.w(e.this));
            }
        }
    }

    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            e eVar;
            StringBuilder sb;
            String str;
            String sb2;
            if (((String) e.v(e.this).get(i)).equals("Internal Storage")) {
                eVar = e.this;
                sb2 = "/emulated/0";
            } else {
                if (e.v(e.this).get(i) != null && i == 0 && ((String) e.v(e.this).get(i)).equals("..")) {
                    e.p(e.this).performClick();
                    e.i(e.this);
                }
                if (e.h(e.this) == null) {
                    eVar = e.this;
                    sb = new StringBuilder();
                } else if (e.h(e.this).get(e.v(e.this).get(i)) == null || ((String) e.h(e.this).get(e.v(e.this).get(i))).equals("")) {
                    eVar = e.this;
                    sb = new StringBuilder();
                } else {
                    eVar = e.this;
                    sb = new StringBuilder();
                    sb.append("/");
                    sb.append((String) e.h(e.this).get(e.v(e.this).get(i)));
                    sb.append("/Android/data/");
                    str = "com.nst.iptvsmarterstvbox";
                    sb.append(str);
                    sb2 = sb.toString();
                }
                sb.append("/");
                str = (String) e.v(e.this).get(i);
                sb.append(str);
                sb2 = sb.toString();
            }
            e.y(eVar, sb2);
            e.i(e.this);
        }
    }

    public class f implements DialogInterface.OnShowListener {

        public class a implements View.OnClickListener {
            public a() {
            }

            public void onClick(View view) {
                e eVar;
                File file;
                if (e.w(e.this).equals(e.j(e.this))) {
                    return;
                }
                if (!e.w(e.this).equals("/storage/emulated/0")) {
                    e.x(e.this, new File(e.w(e.this)).getParent());
                    String[] split = e.w(e.this).split("/");
                    if (split.length >= 3) {
                        if (Pattern.compile("^\\(?(.{4})\\)?[- ]?(.{4})$").matcher(split[2]).matches()) {
                            if (e.w(e.this).equals("/storage/" + split[2] + "/Android/data")) {
                                e.x(e.this, "/storage/" + split[2]);
                                eVar = e.this;
                                file = new File(e.w(e.this));
                            }
                        }
                        if (new File(e.w(e.this)).getParent().equals("/storage/" + split[2] + "/Android/data")) {
                            e.x(e.this, "/storage/" + split[2] + "/Android/data/com.nst.iptvsmarterstvbox");
                        }
                    }
                    e.i(e.this);
                }
                e.x(e.this, "/storage/emulated");
                eVar = e.this;
                file = new File(e.w(e.this));
                e.x(eVar, file.getParent());
                e.i(e.this);
            }
        }

        public f() {
        }

        public void onShow(DialogInterface dialogInterface) {
            e eVar = e.this;
            e.d(eVar, e.f(eVar).getButton(-2));
            e eVar2 = e.this;
            e.s(eVar2, e.f(eVar2).getButton(-1));
            e eVar3 = e.this;
            e.q(eVar3, e.f(eVar3).getButton(-3));
            if (e.w(e.this).equals(e.j(e.this))) {
                e.p(e.this).setVisibility(4);
                e.r(e.this).setVisibility(8);
            } else {
                e.p(e.this).setVisibility(0);
                e.r(e.this).setVisibility(0);
            }
            e.c(e.this).setTag("1");
            e.r(e.this).setTag("2");
            e.p(e.this).setTag("3");
            Button c = e.c(e.this);
            e eVar4 = e.this;
            c.setOnFocusChangeListener(eVar4.new k(e.c(eVar4)));
            e.c(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
            ViewGroup.MarginLayoutParams layoutParams = e.c(e.this).getLayoutParams();
            ViewGroup.MarginLayoutParams layoutParams2 = e.r(e.this).getLayoutParams();
            ViewGroup.MarginLayoutParams layoutParams3 = e.p(e.this).getLayoutParams();
            layoutParams.setMargins(0, 0, 50, 0);
            String A = new u7.a(e.g(e.this)).A();
            if (A.equals(m7.a.K0)) {
                e.c(e.this).setTextSize(16.0f);
                e.c(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.o));
                layoutParams.width = 230;
                layoutParams.height = 90;
            } else {
                e.c(e.this).setTextSize(14.0f);
                e.c(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.h));
                layoutParams.width = 250;
                layoutParams.height = 110;
            }
            Button r = e.r(e.this);
            e eVar5 = e.this;
            r.setOnFocusChangeListener(eVar5.new k(e.r(eVar5)));
            layoutParams2.setMargins(0, 0, 70, 0);
            if (A.equals(m7.a.K0)) {
                e.r(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
                e.r(e.this).setTextSize(16.0f);
                e.r(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.o));
                layoutParams2.width = 230;
                layoutParams2.height = 90;
            } else {
                e.r(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
                e.r(e.this).setTextSize(14.0f);
                e.r(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.k1));
                layoutParams2.width = 250;
                layoutParams2.height = 110;
            }
            Button p = e.p(e.this);
            e eVar6 = e.this;
            p.setOnFocusChangeListener(eVar6.new k(e.p(eVar6)));
            e.p(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
            if (A.equals(m7.a.K0)) {
                e.p(e.this).setTextSize(16.0f);
                e.p(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.o));
                layoutParams3.width = 230;
                layoutParams3.height = 90;
            } else {
                e.p(e.this).setTextSize(14.0f);
                e.p(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.k1));
                layoutParams3.width = 250;
                layoutParams3.height = 110;
            }
            e.p(e.this).setOnClickListener(new a());
        }
    }

    public class g implements DialogInterface.OnKeyListener {
        public g() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            e eVar;
            File file;
            if (i != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            if (e.w(e.this).equals(e.j(e.this))) {
                e.f(e.this).dismiss();
                return true;
            }
            if (!e.w(e.this).equals("/storage/emulated/0")) {
                e.x(e.this, new File(e.w(e.this)).getParent());
                String[] split = e.w(e.this).split("/");
                if (split.length >= 3) {
                    if (Pattern.compile("^\\(?(.{4})\\)?[- ]?(.{4})$").matcher(split[2]).matches()) {
                        if (e.w(e.this).equals("/storage/" + split[2] + "/Android/data")) {
                            e.x(e.this, "/storage/" + split[2]);
                            eVar = e.this;
                            file = new File(e.w(e.this));
                        }
                    }
                    if (new File(e.w(e.this)).getParent().equals("/storage/" + split[2] + "/Android/data")) {
                        e.x(e.this, "/storage/" + split[2] + "/Android/data/com.nst.iptvsmarterstvbox");
                    }
                }
                e.i(e.this);
                return true;
            }
            e.x(e.this, "/storage/emulated");
            eVar = e.this;
            file = new File(e.w(e.this));
            e.x(eVar, file.getParent());
            e.i(e.this);
            return true;
        }
    }

    public class h implements Comparator {
        public h() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public class i implements View.OnClickListener {

        public class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ EditText a;

            public a(EditText editText) {
                this.a = editText;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                Context g;
                StringBuilder sb;
                e eVar;
                File file;
                String obj = this.a.getText().toString();
                if (Build.VERSION.SDK_INT < 30) {
                    if (e.o(e.this, e.w(e.this) + "/" + obj)) {
                        e.y(e.this, "/" + obj);
                        e.i(e.this);
                        return;
                    }
                    g = e.g(e.this);
                    sb = new StringBuilder();
                    sb.append(e.g(e.this).getResources().getString(a7.j.Z1));
                    sb.append("'");
                } else if (e.b(e.this).equals("") || e.b(e.this).equals("/storage/emulated/0/!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#")) {
                    if (e.o(e.this, new File("/storage/emulated/0/" + obj).toString())) {
                        eVar = e.this;
                        file = new File("/storage/emulated/0/" + obj);
                        e.B(eVar, file);
                        return;
                    }
                    g = e.g(e.this);
                    sb = new StringBuilder();
                    sb.append(e.g(e.this).getResources().getString(a7.j.Z1));
                    sb.append(" '");
                } else if (e.b(e.this).contains("!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#")) {
                    e eVar2 = e.this;
                    e.e(eVar2, e.b(eVar2).replace("!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#", ""));
                    if (e.o(e.this, e.b(e.this) + "/" + obj)) {
                        eVar = e.this;
                        file = new File(e.b(e.this) + "/" + obj);
                        e.B(eVar, file);
                        return;
                    }
                    g = e.g(e.this);
                    sb = new StringBuilder();
                    sb.append(e.g(e.this).getResources().getString(a7.j.Z1));
                    sb.append(" '");
                } else {
                    if (e.o(e.this, e.b(e.this) + "/" + obj)) {
                        eVar = e.this;
                        file = new File(e.b(e.this) + "/" + obj);
                        e.B(eVar, file);
                        return;
                    }
                    g = e.g(e.this);
                    sb = new StringBuilder();
                    sb.append(e.g(e.this).getResources().getString(a7.j.Z1));
                    sb.append(" '");
                }
                sb.append(obj);
                sb.append("' ");
                sb.append(e.g(e.this).getResources().getString(a7.j.k2));
                Toast.makeText(g, sb.toString(), 0).show();
            }
        }

        public class b implements DialogInterface.OnShowListener {
            public final /* synthetic */ AlertDialog a;

            public b(AlertDialog alertDialog) {
                this.a = alertDialog;
            }

            public void onShow(DialogInterface dialogInterface) {
                e.l(e.this, this.a.getButton(-3));
                e.n(e.this, this.a.getButton(-1));
                e.k(e.this).setTag("4");
                e.m(e.this).setTag("5");
                Button k = e.k(e.this);
                e eVar = e.this;
                k.setOnFocusChangeListener(eVar.new k(e.k(eVar)));
                ViewGroup.MarginLayoutParams layoutParams = e.k(e.this).getLayoutParams();
                ViewGroup.MarginLayoutParams layoutParams2 = e.m(e.this).getLayoutParams();
                layoutParams.setMargins(70, 0, 0, 0);
                layoutParams2.setMargins(0, 0, 70, 0);
                String A = new u7.a(e.g(e.this)).A();
                if (A.equals(m7.a.K0)) {
                    e.k(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
                    e.k(e.this).setTextSize(16.0f);
                    e.k(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.o));
                    layoutParams.width = 230;
                    layoutParams.height = 70;
                } else {
                    e.k(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
                    e.k(e.this).setTextSize(14.0f);
                    e.k(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.h));
                    layoutParams.width = 250;
                    layoutParams.height = 110;
                }
                Button m = e.m(e.this);
                e eVar2 = e.this;
                m.setOnFocusChangeListener(eVar2.new k(e.m(eVar2)));
                e.m(e.this).setTextColor(e.g(e.this).getResources().getColor(a7.c.G));
                if (A.equals(m7.a.K0)) {
                    e.m(e.this).setTextSize(16.0f);
                    e.m(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.o));
                    layoutParams2.width = 230;
                    layoutParams2.height = 70;
                    return;
                }
                e.m(e.this).setTextSize(14.0f);
                e.m(e.this).setBackground(e.g(e.this).getResources().getDrawable(a7.e.k1));
                layoutParams2.width = 250;
                layoutParams2.height = 110;
            }
        }

        public i() {
        }

        public void onClick(View view) {
            EditText editText = new EditText(e.g(e.this));
            editText.setLayoutParams(new ViewGroup.LayoutParams(-1, 100));
            AlertDialog.Builder builder = new AlertDialog.Builder(e.g(e.this), a7.k.a);
            builder.setTitle(e.g(e.this).getResources().getString(a7.j.Z3)).setView(editText).setPositiveButton(e.g(e.this).getResources().getString(a7.j.V6), new a(editText)).setNeutralButton(e.g(e.this).getResources().getString(a7.j.U6), (DialogInterface.OnClickListener) null);
            AlertDialog create = builder.create();
            create.setOnShowListener(new b(create));
            create.show();
            if (create.getWindow() != null) {
                create.getWindow().setLayout(750, 350);
                create.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
            }
        }
    }

    public interface j {
        void a(String str);
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
            if (z) {
                View view2 = this.a;
                if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("6")) {
                    r4 = z ? 1.12f : 1.0f;
                    a(r4);
                    b(r4);
                    View view3 = this.a;
                    if (view3 != null && view3.getTag() != null && this.a.getTag().equals("1") && e.c(e.this) != null) {
                        e.c(e.this).setBackgroundResource(a7.e.h);
                    }
                    View view4 = this.a;
                    if (view4 != null && view4.getTag() != null && this.a.getTag().equals("2") && e.r(e.this) != null) {
                        e.r(e.this).setBackgroundResource(a7.e.k1);
                    }
                    View view5 = this.a;
                    if (view5 != null && view5.getTag() != null && this.a.getTag().equals("3") && e.p(e.this) != null) {
                        e.p(e.this).setBackgroundResource(a7.e.p);
                    }
                    View view6 = this.a;
                    if (view6 != null && view6.getTag() != null && this.a.getTag().equals("4") && e.k(e.this) != null) {
                        e.k(e.this).setBackgroundResource(a7.e.h);
                    }
                    View view7 = this.a;
                    if (view7 == null || view7.getTag() == null || !this.a.getTag().equals("5") || e.m(e.this) == null) {
                        return;
                    }
                    e.m(e.this).setBackgroundResource(a7.e.k1);
                    return;
                }
                if (z) {
                    r4 = 1.18f;
                }
            } else {
                if (z) {
                    return;
                }
                View view8 = this.a;
                if (view8 != null && view8.getTag() != null && this.a.getTag().equals("1") && e.c(e.this) != null) {
                    e.c(e.this).setBackgroundResource(a7.e.o);
                }
                View view9 = this.a;
                if (view9 != null && view9.getTag() != null && this.a.getTag().equals("2") && e.r(e.this) != null) {
                    e.r(e.this).setBackgroundResource(a7.e.o);
                }
                View view10 = this.a;
                if (view10 != null && view10.getTag() != null && this.a.getTag().equals("3") && e.p(e.this) != null) {
                    e.p(e.this).setBackgroundResource(a7.e.o);
                }
                View view11 = this.a;
                if (view11 != null && view11.getTag() != null && this.a.getTag().equals("4") && e.k(e.this) != null) {
                    e.k(e.this).setBackgroundResource(a7.e.o);
                }
                View view12 = this.a;
                if (view12 != null && view12.getTag() != null && this.a.getTag().equals("5") && e.m(e.this) != null) {
                    e.m(e.this).setBackgroundResource(a7.e.o);
                }
            }
            a(r4);
            b(r4);
        }
    }

    public e(Context context, j jVar) {
        this.b = "";
        this.g = null;
        this.c = context;
        int length = context.getExternalFilesDirs("external").length;
        this.b = "/storage";
        this.g = jVar;
        try {
            this.b = new File(this.b).getCanonicalPath();
        } catch (IOException unused) {
        }
    }

    public static /* synthetic */ ListViewMaxHeight A(e eVar) {
        return eVar.p;
    }

    public static /* synthetic */ void B(e eVar, File file) {
        eVar.C(file);
    }

    public static int F(float f2, Context context) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static /* synthetic */ j a(e eVar) {
        return eVar.g;
    }

    public static /* synthetic */ String b(e eVar) {
        return eVar.u;
    }

    public static /* synthetic */ Button c(e eVar) {
        return eVar.j;
    }

    public static /* synthetic */ Button d(e eVar, Button button) {
        eVar.j = button;
        return button;
    }

    public static /* synthetic */ String e(e eVar, String str) {
        eVar.u = str;
        return str;
    }

    public static /* synthetic */ AlertDialog f(e eVar) {
        return eVar.s;
    }

    public static /* synthetic */ Context g(e eVar) {
        return eVar.c;
    }

    public static /* synthetic */ HashMap h(e eVar) {
        return eVar.o;
    }

    public static /* synthetic */ void i(e eVar) {
        eVar.L();
    }

    public static /* synthetic */ String j(e eVar) {
        return eVar.b;
    }

    public static /* synthetic */ Button k(e eVar) {
        return eVar.n;
    }

    public static /* synthetic */ Button l(e eVar, Button button) {
        eVar.n = button;
        return button;
    }

    public static /* synthetic */ Button m(e eVar) {
        return eVar.m;
    }

    public static /* synthetic */ Button n(e eVar, Button button) {
        eVar.m = button;
        return button;
    }

    public static /* synthetic */ boolean o(e eVar, String str) {
        return eVar.H(str);
    }

    public static /* synthetic */ Button p(e eVar) {
        return eVar.l;
    }

    public static /* synthetic */ Button q(e eVar, Button button) {
        eVar.l = button;
        return button;
    }

    public static /* synthetic */ Button r(e eVar) {
        return eVar.k;
    }

    public static /* synthetic */ Button s(e eVar, Button button) {
        eVar.k = button;
        return button;
    }

    public static /* synthetic */ File t(e eVar) {
        return eVar.t;
    }

    public static /* synthetic */ File u(e eVar, File file) {
        eVar.t = file;
        return file;
    }

    public static /* synthetic */ List v(e eVar) {
        return eVar.f;
    }

    public static /* synthetic */ String w(e eVar) {
        return eVar.d;
    }

    public static /* synthetic */ String x(e eVar, String str) {
        eVar.d = str;
        return str;
    }

    public static /* synthetic */ String y(e eVar, Object obj) {
        String str = eVar.d + obj;
        eVar.d = str;
        return str;
    }

    public static /* synthetic */ q7.j z(e eVar) {
        return eVar.i;
    }

    public final void C(File file) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            if (file.getParent() != null) {
                String parent = file.getParent();
                if (parent.equals("/storage/emulated/0")) {
                    this.l.setVisibility(4);
                } else {
                    arrayList.add(new File(parent).getParent() + "/!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#");
                    this.l.setVisibility(0);
                }
                File file2 = new File(file.getParent());
                if (file2.list() != null) {
                    int i2 = 0;
                    while (true) {
                        String[] list = file2.list();
                        Objects.requireNonNull(list);
                        if (i2 >= list.length) {
                            break;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(file.getParent());
                        sb.append("/");
                        String[] list2 = file2.list();
                        Objects.requireNonNull(list2);
                        sb.append(list2[i2]);
                        if (new File(sb.toString()).isDirectory()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(file.getParent());
                            sb2.append("/");
                            String[] list3 = file2.list();
                            Objects.requireNonNull(list3);
                            sb2.append(list3[i2]);
                            arrayList.add(sb2.toString());
                        }
                        i2++;
                    }
                }
            }
            this.f.clear();
            this.f.addAll(arrayList);
            this.i.notifyDataSetChanged();
            this.p.setSelection(0);
            ListViewMaxHeight listViewMaxHeight = this.p;
            if (listViewMaxHeight != null) {
                listViewMaxHeight.requestFocus();
            }
        } catch (Exception unused) {
        }
    }

    public void D(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            str = this.b;
        }
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            this.d = canonicalPath;
            this.e = I(canonicalPath);
            this.f = I("");
            J(this.e);
            AlertDialog.Builder G = G(canonicalPath, this.f);
            this.r = G;
            G.setNegativeButton(this.c.getResources().getString(a7.j.U6), (DialogInterface.OnClickListener) null);
            this.r.setNeutralButton(this.c.getResources().getString(a7.j.T6), (DialogInterface.OnClickListener) null);
            this.r.setPositiveButton(this.c.getResources().getString(a7.j.V6), new d());
            q7.h hVar = new q7.h(this.c, this.f);
            this.h = hVar;
            ListViewMaxHeight listViewMaxHeight = this.p;
            if (listViewMaxHeight != null) {
                listViewMaxHeight.setAdapter(hVar);
                this.p.setOnItemClickListener(new e());
            }
            AlertDialog create = this.r.create();
            this.s = create;
            create.setOnShowListener(new f());
            this.s.setOnKeyListener(new g());
            this.s.show();
            if (this.s.getWindow() != null) {
                this.s.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
                this.s.getWindow().setLayout(F(650.0f, this.c), -2);
            }
        } catch (IOException unused) {
        }
    }

    public void E(String str) {
        try {
            this.u = "";
            File absoluteFile = Environment.getExternalStoragePublicDirectory("").getAbsoluteFile();
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.clear();
            if (absoluteFile.list() != null) {
                int i2 = 0;
                while (true) {
                    String[] list = absoluteFile.list();
                    Objects.requireNonNull(list);
                    if (i2 >= list.length) {
                        break;
                    }
                    String[] list2 = absoluteFile.list();
                    Objects.requireNonNull(list2);
                    File file = new File(Environment.getExternalStoragePublicDirectory(list2[i2]).toString());
                    if (file.isDirectory()) {
                        this.f.add(file.getPath());
                    }
                    i2++;
                }
            }
            AlertDialog.Builder G = G("", this.f);
            this.r = G;
            G.setNegativeButton(this.c.getResources().getString(a7.j.U6), (DialogInterface.OnClickListener) null);
            this.r.setNeutralButton(this.c.getResources().getString(a7.j.T6), (DialogInterface.OnClickListener) null);
            this.r.setPositiveButton(this.c.getResources().getString(a7.j.V6), new a());
            q7.j jVar = new q7.j(this.c, this.f, "recording");
            this.i = jVar;
            ListViewMaxHeight listViewMaxHeight = this.p;
            if (listViewMaxHeight != null) {
                listViewMaxHeight.setAdapter(jVar);
                this.p.setOnItemClickListener(new b());
            }
            AlertDialog create = this.r.create();
            this.s = create;
            create.setOnShowListener(new c());
            this.s.show();
            if (this.s.getWindow() != null) {
                this.s.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
                this.s.getWindow().setLayout(F(650.0f, this.c), -2);
            }
        } catch (Exception unused) {
        }
    }

    public final AlertDialog.Builder G(String str, List list) {
        this.r = new AlertDialog.Builder(this.c, a7.k.a);
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.c);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(this.c.getResources().getString(a7.j.m0));
        Drawable drawable = this.c.getResources().getDrawable(a7.e.z);
        drawable.setBounds(0, 0, 80, 80);
        textView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setTextSize(22.0f);
        textView.setTextColor(this.c.getResources().getColor(17170444));
        textView.setPadding(50, 50, 0, 0);
        textView.setTypeface((Typeface) null, 1);
        ImageView imageView = new ImageView(this.c);
        this.q = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.q.setPadding(20, 20, 0, 0);
        this.q.setTag("6");
        this.q.setId(a7.f.Xg);
        this.q.setFocusable(true);
        ImageView imageView2 = this.q;
        imageView2.setOnFocusChangeListener(new k(imageView2));
        if (Build.VERSION.SDK_INT <= 21) {
            this.q.setImageResource(a7.e.f);
        }
        this.q.setImageDrawable(this.c.getResources().getDrawable(a7.e.f, (Resources.Theme) null));
        this.q.getLayoutParams().gravity = 8388613;
        this.q.setOnClickListener(new i());
        linearLayout.addView(textView);
        linearLayout.addView(this.q);
        this.r.setCustomTitle(linearLayout);
        View inflate = ((LayoutInflater) this.c.getSystemService("layout_inflater")).inflate(a7.g.u2, (ViewGroup) null);
        this.r.setView(inflate);
        this.p = inflate.findViewById(a7.f.Za);
        this.r.setCancelable(false);
        return this.r;
    }

    public final boolean H(String str) {
        File file = new File(str);
        if (file.exists()) {
            return false;
        }
        return file.mkdir();
    }

    public final List I(String str) {
        File file;
        ArrayList arrayList = new ArrayList();
        try {
            file = new File(str);
        } catch (Exception unused) {
        }
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    arrayList.add(file2.getName());
                }
            }
            Collections.sort(arrayList, new h());
            return arrayList;
        }
        return arrayList;
    }

    public final void J(List list) {
        this.f.clear();
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!str.equals("self")) {
                if (str.equals("emulated")) {
                    z = true;
                } else if (Pattern.compile("^\\(?(.{4})\\)?[- ]?(.{4})$").matcher(str).matches()) {
                    this.o.put("SD Card", str);
                    this.f.add("SD Card");
                } else {
                    this.f.add(str);
                }
            }
        }
        if (z) {
            this.f.add(0, "Internal Storage");
        }
    }

    public void K(boolean z) {
        this.a = z;
    }

    public final void L() {
        TextView findViewById;
        try {
            if (this.d.equals(this.b)) {
                J(I(this.d));
            } else {
                this.f.clear();
                this.f.add("..");
                this.f.addAll(I(this.d));
            }
            AlertDialog alertDialog = this.s;
            if (alertDialog != null && (findViewById = alertDialog.findViewById(16908299)) != null) {
                findViewById.setText(this.d);
            }
            if (this.d.equals(this.b)) {
                this.l.setVisibility(4);
                this.k.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                this.k.setVisibility(0);
            }
            this.h.notifyDataSetChanged();
            this.p.setSelection(0);
            ListViewMaxHeight listViewMaxHeight = this.p;
            if (listViewMaxHeight != null) {
                listViewMaxHeight.requestFocus();
            }
        } catch (Exception unused) {
        }
    }
}
