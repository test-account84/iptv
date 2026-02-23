package F7;

import a7.k;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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
import q7.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class e {
    public String b;
    public Context c;
    public g g;
    public q7.h h;
    public j i;
    public Button j;
    public Button k;
    public ListViewMaxHeight m;
    public AlertDialog.Builder n;
    public AlertDialog o;
    public File p;
    public boolean a = true;
    public String d = "";
    public List e = null;
    public List f = null;
    public HashMap l = new HashMap();

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            e.a(e.this).setVisibility(0);
            e.f(e.this, new File((String) e.j(e.this).get(i)));
            if (e.c(e.this) != null && e.c(e.this).isFile()) {
                e eVar = e.this;
                e.l(eVar, e.c(eVar).getName());
                if (!e.k(e.this).endsWith(".zip") && !e.k(e.this).endsWith(".ovpn")) {
                    Toast.makeText(e.p(e.this), "Please select .zip or .ovpn File", 0).show();
                    return;
                } else {
                    if (e.n(e.this) != null) {
                        e.n(e.this).a(e.c(e.this).getPath());
                        e.o(e.this).dismiss();
                        return;
                    }
                    return;
                }
            }
            e eVar2 = e.this;
            e.l(eVar2, e.c(eVar2).getName());
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            if (e.k(e.this).equals("!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#")) {
                e eVar3 = e.this;
                e.s(eVar3, e.c(eVar3));
                return;
            }
            arrayList.add(e.c(e.this).getParent() + "/!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#");
            if (e.c(e.this).list() != null) {
                int i2 = 0;
                while (true) {
                    String[] list = e.c(e.this).list();
                    Objects.requireNonNull(list);
                    if (i2 >= list.length) {
                        break;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(e.c(e.this).getPath());
                    sb.append("/");
                    String[] list2 = e.c(e.this).list();
                    Objects.requireNonNull(list2);
                    sb.append(list2[i2]);
                    arrayList.add(sb.toString());
                    i2++;
                }
            }
            e.j(e.this).clear();
            e.j(e.this).addAll(arrayList);
            e.q(e.this).notifyDataSetChanged();
            e.r(e.this).setSelection(0);
            if (e.r(e.this) != null) {
                e.r(e.this).requestFocus();
            }
        }
    }

    public class b implements DialogInterface.OnShowListener {

        public class a implements View.OnClickListener {
            public a() {
            }

            public void onClick(View view) {
                e.o(e.this).dismiss();
            }
        }

        public class b implements View.OnClickListener {
            public b() {
            }

            public void onClick(View view) {
                if (e.j(e.this) == null || e.j(e.this).get(0) == null) {
                    return;
                }
                e.s(e.this, new File((String) e.j(e.this).get(0)));
            }
        }

        public b() {
        }

        public void onShow(DialogInterface dialogInterface) {
            e eVar = e.this;
            e.e(eVar, e.o(eVar).getButton(-2));
            e eVar2 = e.this;
            e.b(eVar2, e.o(eVar2).getButton(-3));
            if (e.c(e.this) == null || e.c(e.this).getParent() == null || e.c(e.this).getParent().equals("/storage/emulated/0")) {
                e.a(e.this).setVisibility(4);
            } else {
                e.a(e.this).setVisibility(0);
            }
            e.d(e.this).setTag("1");
            e.a(e.this).setTag("3");
            Button d = e.d(e.this);
            e eVar3 = e.this;
            d.setOnFocusChangeListener(eVar3.new h(e.d(eVar3)));
            e.d(e.this).setTextColor(e.p(e.this).getResources().getColor(a7.c.G));
            ViewGroup.MarginLayoutParams layoutParams = e.d(e.this).getLayoutParams();
            ViewGroup.MarginLayoutParams layoutParams2 = e.a(e.this).getLayoutParams();
            layoutParams.setMargins(0, 0, 50, 0);
            String A = new u7.a(e.p(e.this)).A();
            if (A.equals(m7.a.K0)) {
                e.d(e.this).setTextSize(16.0f);
                e.d(e.this).setBackground(e.p(e.this).getResources().getDrawable(a7.e.o));
                layoutParams.width = 230;
                layoutParams.height = 90;
            } else {
                e.d(e.this).setTextSize(14.0f);
                e.d(e.this).setBackground(e.p(e.this).getResources().getDrawable(a7.e.h));
                layoutParams.width = 255;
                layoutParams.height = 135;
            }
            e.d(e.this).setOnClickListener(new a());
            e.a(e.this).setOnClickListener(new b());
            Button a2 = e.a(e.this);
            e eVar4 = e.this;
            a2.setOnFocusChangeListener(eVar4.new h(e.a(eVar4)));
            e.a(e.this).setTextColor(e.p(e.this).getResources().getColor(a7.c.G));
            if (A.equals(m7.a.K0)) {
                e.a(e.this).setTextSize(16.0f);
                e.a(e.this).setBackground(e.p(e.this).getResources().getDrawable(a7.e.o));
                layoutParams2.width = 230;
                layoutParams2.height = 90;
                return;
            }
            e.a(e.this).setTextSize(14.0f);
            e.a(e.this).setBackground(e.p(e.this).getResources().getDrawable(a7.e.k1));
            layoutParams2.width = 255;
            layoutParams2.height = 135;
        }
    }

    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            e eVar;
            StringBuilder sb;
            String str;
            String sb2;
            if (((String) e.j(e.this).get(i)).equals("Internal Storage")) {
                eVar = e.this;
                sb2 = "/emulated/0";
            } else {
                if (e.j(e.this).get(i) != null && i == 0 && ((String) e.j(e.this).get(i)).equals("..")) {
                    e.a(e.this).performClick();
                    e.h(e.this);
                }
                if (e.g(e.this) == null) {
                    eVar = e.this;
                    sb = new StringBuilder();
                } else if (e.g(e.this).get(e.j(e.this).get(i)) == null || ((String) e.g(e.this).get(e.j(e.this).get(i))).equals("")) {
                    eVar = e.this;
                    sb = new StringBuilder();
                } else {
                    eVar = e.this;
                    sb = new StringBuilder();
                    sb.append("/");
                    sb.append((String) e.g(e.this).get(e.j(e.this).get(i)));
                    sb.append("/Android/data/");
                    str = "com.nst.iptvsmarterstvbox";
                    sb.append(str);
                    sb2 = sb.toString();
                }
                sb.append("/");
                str = (String) e.j(e.this).get(i);
                sb.append(str);
                sb2 = sb.toString();
            }
            e.m(eVar, sb2);
            e.h(e.this);
        }
    }

    public class d implements DialogInterface.OnShowListener {

        public class a implements View.OnClickListener {
            public a() {
            }

            public void onClick(View view) {
                e eVar;
                File file;
                if (e.k(e.this).equals(e.i(e.this))) {
                    return;
                }
                if (!e.k(e.this).equals("/storage/emulated/0")) {
                    e.l(e.this, new File(e.k(e.this)).getParent());
                    String[] split = e.k(e.this).split("/");
                    if (split.length >= 3) {
                        if (Pattern.compile("^\\(?(.{4})\\)?[- ]?(.{4})$").matcher(split[2]).matches()) {
                            if (e.k(e.this).equals("/storage/" + split[2] + "/Android/data")) {
                                e.l(e.this, "/storage/" + split[2]);
                                eVar = e.this;
                                file = new File(e.k(e.this));
                            }
                        }
                        if (new File(e.k(e.this)).getParent().equals("/storage/" + split[2] + "/Android/data")) {
                            e.l(e.this, "/storage/" + split[2] + "/Android/data/com.nst.iptvsmarterstvbox");
                        }
                    }
                    e.h(e.this);
                }
                e.l(e.this, "/storage/emulated");
                eVar = e.this;
                file = new File(e.k(e.this));
                e.l(eVar, file.getParent());
                e.h(e.this);
            }
        }

        public d() {
        }

        public void onShow(DialogInterface dialogInterface) {
            Button d;
            Resources resources;
            int i;
            int i2;
            e eVar = e.this;
            e.e(eVar, e.o(eVar).getButton(-2));
            e eVar2 = e.this;
            e.b(eVar2, e.o(eVar2).getButton(-3));
            if (e.k(e.this).equals(e.i(e.this))) {
                e.a(e.this).setVisibility(4);
            } else {
                e.a(e.this).setVisibility(0);
            }
            e.d(e.this).setTag("1");
            e.a(e.this).setTag("3");
            Button d2 = e.d(e.this);
            e eVar3 = e.this;
            d2.setOnFocusChangeListener(eVar3.new h(e.d(eVar3)));
            e.d(e.this).setTextColor(e.p(e.this).getResources().getColor(a7.c.G));
            ViewGroup.MarginLayoutParams layoutParams = e.d(e.this).getLayoutParams();
            ViewGroup.MarginLayoutParams layoutParams2 = e.a(e.this).getLayoutParams();
            layoutParams.setMargins(0, 0, 50, 0);
            String A = new u7.a(e.p(e.this)).A();
            if (A.equals(m7.a.K0)) {
                e.d(e.this).setTextSize(16.0f);
                d = e.d(e.this);
                resources = e.p(e.this).getResources();
                i = a7.e.o;
            } else {
                e.d(e.this).setTextSize(14.0f);
                d = e.d(e.this);
                resources = e.p(e.this).getResources();
                i = a7.e.h;
            }
            d.setBackground(resources.getDrawable(i));
            layoutParams.width = 255;
            layoutParams.height = 135;
            Button a2 = e.a(e.this);
            e eVar4 = e.this;
            a2.setOnFocusChangeListener(eVar4.new h(e.a(eVar4)));
            e.a(e.this).setTextColor(e.p(e.this).getResources().getColor(a7.c.G));
            if (A.equals(m7.a.K0)) {
                e.a(e.this).setTextSize(16.0f);
                e.a(e.this).setBackground(e.p(e.this).getResources().getDrawable(a7.e.o));
                layoutParams2.width = 230;
                i2 = 90;
            } else {
                e.a(e.this).setTextSize(14.0f);
                e.a(e.this).setBackground(e.p(e.this).getResources().getDrawable(a7.e.k1));
                layoutParams2.width = 250;
                i2 = 110;
            }
            layoutParams2.height = i2;
            e.a(e.this).setOnClickListener(new a());
        }
    }

    public class e implements DialogInterface.OnKeyListener {
        public e() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            e eVar;
            File file;
            if (i != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            if (e.k(e.this).equals(e.i(e.this))) {
                e.o(e.this).dismiss();
                return true;
            }
            if (!e.k(e.this).equals("/storage/emulated/0")) {
                e.l(e.this, new File(e.k(e.this)).getParent());
                String[] split = e.k(e.this).split("/");
                if (split.length >= 3) {
                    if (Pattern.compile("^\\(?(.{4})\\)?[- ]?(.{4})$").matcher(split[2]).matches()) {
                        if (e.k(e.this).equals("/storage/" + split[2] + "/Android/data")) {
                            e.l(e.this, "/storage/" + split[2]);
                            eVar = e.this;
                            file = new File(e.k(e.this));
                        }
                    }
                    if (new File(e.k(e.this)).getParent().equals("/storage/" + split[2] + "/Android/data")) {
                        e.l(e.this, "/storage/" + split[2] + "/Android/data/com.nst.iptvsmarterstvbox");
                    }
                }
                e.h(e.this);
                return true;
            }
            e.l(e.this, "/storage/emulated");
            eVar = e.this;
            file = new File(e.k(e.this));
            e.l(eVar, file.getParent());
            e.h(e.this);
            return true;
        }
    }

    public class f implements Comparator {
        public f() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public interface g {
        void a(String str);
    }

    public class h implements View.OnFocusChangeListener {
        public final View a;

        public h(View view) {
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
                    r1 = z ? 1.12f : 1.0f;
                    a(r1);
                    b(r1);
                    View view3 = this.a;
                    if (view3 != null && view3.getTag() != null && this.a.getTag().equals("1") && e.d(e.this) != null) {
                        e.d(e.this).setBackgroundResource(a7.e.h);
                    }
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("3") || e.a(e.this) == null) {
                        return;
                    }
                    e.a(e.this).setBackgroundResource(a7.e.p);
                    return;
                }
                if (z) {
                    r1 = 1.18f;
                }
            } else {
                if (z) {
                    return;
                }
                View view5 = this.a;
                if (view5 != null && view5.getTag() != null && this.a.getTag().equals("1") && e.d(e.this) != null) {
                    e.d(e.this).setBackgroundResource(a7.e.o);
                }
                View view6 = this.a;
                if (view6 != null && view6.getTag() != null && this.a.getTag().equals("3") && e.a(e.this) != null) {
                    e.a(e.this).setBackgroundResource(a7.e.o);
                }
            }
            a(r1);
            b(r1);
        }
    }

    public e(Context context, g gVar) {
        this.b = "";
        this.g = null;
        this.c = context;
        int length = context.getExternalFilesDirs("external").length;
        this.b = "/storage";
        this.g = gVar;
        try {
            this.b = new File(this.b).getCanonicalPath();
        } catch (IOException unused) {
        }
    }

    public static /* synthetic */ Button a(e eVar) {
        return eVar.k;
    }

    public static /* synthetic */ Button b(e eVar, Button button) {
        eVar.k = button;
        return button;
    }

    public static /* synthetic */ File c(e eVar) {
        return eVar.p;
    }

    public static /* synthetic */ Button d(e eVar) {
        return eVar.j;
    }

    public static /* synthetic */ Button e(e eVar, Button button) {
        eVar.j = button;
        return button;
    }

    public static /* synthetic */ File f(e eVar, File file) {
        eVar.p = file;
        return file;
    }

    public static /* synthetic */ HashMap g(e eVar) {
        return eVar.l;
    }

    public static /* synthetic */ void h(e eVar) {
        eVar.A();
    }

    public static /* synthetic */ String i(e eVar) {
        return eVar.b;
    }

    public static /* synthetic */ List j(e eVar) {
        return eVar.f;
    }

    public static /* synthetic */ String k(e eVar) {
        return eVar.d;
    }

    public static /* synthetic */ String l(e eVar, String str) {
        eVar.d = str;
        return str;
    }

    public static /* synthetic */ String m(e eVar, Object obj) {
        String str = eVar.d + obj;
        eVar.d = str;
        return str;
    }

    public static /* synthetic */ g n(e eVar) {
        return eVar.g;
    }

    public static /* synthetic */ AlertDialog o(e eVar) {
        return eVar.o;
    }

    public static /* synthetic */ Context p(e eVar) {
        return eVar.c;
    }

    public static /* synthetic */ j q(e eVar) {
        return eVar.i;
    }

    public static /* synthetic */ ListViewMaxHeight r(e eVar) {
        return eVar.m;
    }

    public static /* synthetic */ void s(e eVar, File file) {
        eVar.t(file);
    }

    public static int w(float f2, Context context) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void A() {
        TextView findViewById;
        try {
            if (!this.d.endsWith(".zip") && !this.d.endsWith(".ovpn")) {
                if (this.d.equals(this.b)) {
                    z(y(this.d));
                } else {
                    this.f.clear();
                    this.f.add("..");
                    this.f.addAll(y(this.d));
                }
                AlertDialog alertDialog = this.o;
                if (alertDialog != null && (findViewById = alertDialog.findViewById(16908299)) != null) {
                    findViewById.setText(this.d);
                }
                if (this.d.equals(this.b)) {
                    this.k.setVisibility(4);
                } else {
                    this.k.setVisibility(0);
                }
                this.h.notifyDataSetChanged();
                this.m.setSelection(0);
                ListViewMaxHeight listViewMaxHeight = this.m;
                if (listViewMaxHeight != null) {
                    listViewMaxHeight.requestFocus();
                    return;
                }
                return;
            }
            g gVar = this.g;
            if (gVar != null) {
                gVar.a(this.d);
                this.o.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public final void t(File file) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            if (file.getParent() != null) {
                String parent = file.getParent();
                if (parent.equals("/storage/emulated/0")) {
                    this.k.setVisibility(4);
                } else {
                    arrayList.add(new File(parent).getParent() + "/!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#");
                    this.k.setVisibility(0);
                }
                File file2 = new File(file.getParent());
                if (file2.list() != null) {
                    int i = 0;
                    while (true) {
                        String[] list = file2.list();
                        Objects.requireNonNull(list);
                        if (i >= list.length) {
                            break;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(file.getParent());
                        sb.append("/");
                        String[] list2 = file2.list();
                        Objects.requireNonNull(list2);
                        sb.append(list2[i]);
                        arrayList.add(sb.toString());
                        i++;
                    }
                }
            }
            this.f.clear();
            this.f.addAll(arrayList);
            this.i.notifyDataSetChanged();
            this.m.setSelection(0);
            ListViewMaxHeight listViewMaxHeight = this.m;
            if (listViewMaxHeight != null) {
                listViewMaxHeight.requestFocus();
            }
        } catch (Exception unused) {
        }
    }

    public void u(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            str = this.b;
        }
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            this.d = canonicalPath;
            this.e = y(canonicalPath);
            this.f = y("");
            z(this.e);
            AlertDialog.Builder x = x(canonicalPath, this.f);
            this.n = x;
            x.setNegativeButton(this.c.getResources().getString(a7.j.U6), (DialogInterface.OnClickListener) null);
            this.n.setNeutralButton(this.c.getResources().getString(a7.j.T6), (DialogInterface.OnClickListener) null);
            q7.h hVar = new q7.h(this.c, this.f);
            this.h = hVar;
            ListViewMaxHeight listViewMaxHeight = this.m;
            if (listViewMaxHeight != null) {
                listViewMaxHeight.setAdapter(hVar);
                this.m.setOnItemClickListener(new c());
            }
            AlertDialog create = this.n.create();
            this.o = create;
            create.setOnShowListener(new d());
            this.o.setOnKeyListener(new e());
            this.o.show();
            if (this.o.getWindow() != null) {
                this.o.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
                this.o.getWindow().setLayout(w(650.0f, this.c), -2);
            }
        } catch (IOException unused) {
        }
    }

    public void v(String str) {
        try {
            File absoluteFile = Environment.getExternalStoragePublicDirectory("").getAbsoluteFile();
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.clear();
            if (absoluteFile.list() != null) {
                int i = 0;
                while (true) {
                    String[] list = absoluteFile.list();
                    Objects.requireNonNull(list);
                    if (i >= list.length) {
                        break;
                    }
                    String[] list2 = absoluteFile.list();
                    Objects.requireNonNull(list2);
                    this.f.add(new File(Environment.getExternalStoragePublicDirectory(list2[i]).toString()).getPath());
                    i++;
                }
            }
            AlertDialog.Builder x = x("", this.f);
            this.n = x;
            x.setNegativeButton(this.c.getResources().getString(a7.j.U6), (DialogInterface.OnClickListener) null);
            this.n.setNeutralButton(this.c.getResources().getString(a7.j.T6), (DialogInterface.OnClickListener) null);
            j jVar = new j(this.c, this.f, "vpn");
            this.i = jVar;
            ListViewMaxHeight listViewMaxHeight = this.m;
            if (listViewMaxHeight != null) {
                listViewMaxHeight.setAdapter(jVar);
                this.m.setOnItemClickListener(new a());
            }
            AlertDialog create = this.n.create();
            this.o = create;
            create.setOnShowListener(new b());
            this.o.show();
            if (this.o.getWindow() != null) {
                this.o.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
                this.o.getWindow().setLayout(w(650.0f, this.c), -2);
            }
        } catch (Exception unused) {
        }
    }

    public final AlertDialog.Builder x(String str, List list) {
        this.n = new AlertDialog.Builder(this.c, k.a);
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.c);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText("Choose Certificate Zip File or ovpn File");
        Drawable drawable = this.c.getResources().getDrawable(a7.e.z);
        drawable.setBounds(0, 0, 80, 80);
        textView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setTextSize(22.0f);
        textView.setTextColor(this.c.getResources().getColor(17170444));
        textView.setPadding(50, 50, 0, 0);
        textView.setTypeface((Typeface) null, 1);
        linearLayout.addView(textView);
        this.n.setCustomTitle(linearLayout);
        View inflate = ((LayoutInflater) this.c.getSystemService("layout_inflater")).inflate(a7.g.u2, (ViewGroup) null);
        this.n.setView(inflate);
        this.m = inflate.findViewById(a7.f.Za);
        this.n.setCancelable(true);
        return this.n;
    }

    public final List y(String str) {
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
                if ((file2.isFile() && file2.getName().endsWith(".zip")) || file2.getName().endsWith(".ovpn")) {
                    arrayList.add(file2.getName());
                }
            }
            Collections.sort(arrayList, new f());
            return arrayList;
        }
        return arrayList;
    }

    public final void z(List list) {
        this.f.clear();
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!str.equals("self")) {
                if (str.equals("emulated")) {
                    z = true;
                } else if (Pattern.compile("^\\(?(.{4})\\)?[- ]?(.{4})$").matcher(str).matches()) {
                    this.l.put("SD Card", str);
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
}
