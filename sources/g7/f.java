package g7;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f {
    public String b;
    public Context c;
    public g g;
    public q7.h h;
    public q7.j i;
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
            f.a(f.this).setVisibility(0);
            f.f(f.this, new File((String) f.j(f.this).get(i)));
            if (f.c(f.this) != null && f.c(f.this).isFile()) {
                f fVar = f.this;
                f.l(fVar, f.c(fVar).getName());
                if (!f.k(f.this).endsWith(".m3u") && !f.k(f.this).endsWith(".m3u8")) {
                    Toast.makeText(f.p(f.this), "Please select .m3u File", 0).show();
                    return;
                } else {
                    if (f.n(f.this) != null) {
                        f.n(f.this).a(f.c(f.this).getPath());
                        f.o(f.this).dismiss();
                        return;
                    }
                    return;
                }
            }
            f fVar2 = f.this;
            f.l(fVar2, f.c(fVar2).getName());
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            if (f.k(f.this).equals("!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#")) {
                f fVar3 = f.this;
                f.s(fVar3, f.c(fVar3));
                return;
            }
            arrayList.add(f.c(f.this).getParent() + "/!c2@f3qc@!V#VEVSD3gg3VC43hh&*%#H2252B@rv3F#RCD5%$#$V#");
            if (f.c(f.this).list() != null) {
                int i2 = 0;
                while (true) {
                    String[] list = f.c(f.this).list();
                    Objects.requireNonNull(list);
                    if (i2 >= list.length) {
                        break;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(f.c(f.this).getPath());
                    sb.append("/");
                    String[] list2 = f.c(f.this).list();
                    Objects.requireNonNull(list2);
                    sb.append(list2[i2]);
                    arrayList.add(sb.toString());
                    i2++;
                }
            }
            f.j(f.this).clear();
            f.j(f.this).addAll(arrayList);
            f.q(f.this).notifyDataSetChanged();
            f.r(f.this).setSelection(0);
            if (f.r(f.this) != null) {
                f.r(f.this).requestFocus();
            }
        }
    }

    public class b implements DialogInterface.OnShowListener {

        public class a implements View.OnClickListener {
            public a() {
            }

            public void onClick(View view) {
                f.o(f.this).dismiss();
            }
        }

        public class b implements View.OnClickListener {
            public b() {
            }

            public void onClick(View view) {
                if (f.j(f.this) == null || f.j(f.this).get(0) == null) {
                    return;
                }
                f.s(f.this, new File((String) f.j(f.this).get(0)));
            }
        }

        public b() {
        }

        public void onShow(DialogInterface dialogInterface) {
            f fVar = f.this;
            f.e(fVar, f.o(fVar).getButton(-2));
            f fVar2 = f.this;
            f.b(fVar2, f.o(fVar2).getButton(-3));
            if (f.c(f.this) == null || f.c(f.this).getParent() == null || f.c(f.this).getParent().equals("/storage/emulated/0")) {
                f.a(f.this).setVisibility(4);
            } else {
                f.a(f.this).setVisibility(0);
            }
            f.d(f.this).setTag("1");
            f.a(f.this).setTag("3");
            Button d = f.d(f.this);
            f fVar3 = f.this;
            d.setOnFocusChangeListener(fVar3.new h(f.d(fVar3)));
            f.d(f.this).setTextColor(f.p(f.this).getResources().getColor(a7.c.G));
            ViewGroup.MarginLayoutParams layoutParams = f.d(f.this).getLayoutParams();
            ViewGroup.MarginLayoutParams layoutParams2 = f.a(f.this).getLayoutParams();
            layoutParams.setMargins(0, 0, 50, 0);
            String A = new u7.a(f.p(f.this)).A();
            if (A.equals(m7.a.K0)) {
                f.d(f.this).setTextSize(16.0f);
                f.d(f.this).setBackground(f.p(f.this).getResources().getDrawable(a7.e.o));
                layoutParams.width = 230;
                layoutParams.height = 90;
            } else {
                f.d(f.this).setTextSize(14.0f);
                f.d(f.this).setBackground(f.p(f.this).getResources().getDrawable(a7.e.h));
                layoutParams.width = 255;
                layoutParams.height = 135;
            }
            f.d(f.this).setOnClickListener(new a());
            f.a(f.this).setOnClickListener(new b());
            Button a2 = f.a(f.this);
            f fVar4 = f.this;
            a2.setOnFocusChangeListener(fVar4.new h(f.a(fVar4)));
            f.a(f.this).setTextColor(f.p(f.this).getResources().getColor(a7.c.G));
            if (A.equals(m7.a.K0)) {
                f.a(f.this).setTextSize(16.0f);
                f.a(f.this).setBackground(f.p(f.this).getResources().getDrawable(a7.e.o));
                layoutParams2.width = 230;
                layoutParams2.height = 90;
                return;
            }
            f.a(f.this).setTextSize(14.0f);
            f.a(f.this).setBackground(f.p(f.this).getResources().getDrawable(a7.e.k1));
            layoutParams2.width = 255;
            layoutParams2.height = 135;
        }
    }

    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            f fVar;
            StringBuilder sb;
            String str;
            String sb2;
            if (((String) f.j(f.this).get(i)).equals("Internal Storage")) {
                fVar = f.this;
                sb2 = "/emulated/0";
            } else {
                if (f.j(f.this).get(i) != null && i == 0 && ((String) f.j(f.this).get(i)).equals("..")) {
                    f.a(f.this).performClick();
                    f.h(f.this);
                }
                if (f.g(f.this) == null) {
                    fVar = f.this;
                    sb = new StringBuilder();
                } else if (f.g(f.this).get(f.j(f.this).get(i)) == null || ((String) f.g(f.this).get(f.j(f.this).get(i))).equals("")) {
                    fVar = f.this;
                    sb = new StringBuilder();
                } else {
                    fVar = f.this;
                    sb = new StringBuilder();
                    sb.append("/");
                    sb.append((String) f.g(f.this).get(f.j(f.this).get(i)));
                    sb.append("/Android/data/");
                    str = "com.nst.iptvsmarterstvbox";
                    sb.append(str);
                    sb2 = sb.toString();
                }
                sb.append("/");
                str = (String) f.j(f.this).get(i);
                sb.append(str);
                sb2 = sb.toString();
            }
            f.m(fVar, sb2);
            f.h(f.this);
        }
    }

    public class d implements DialogInterface.OnShowListener {

        public class a implements View.OnClickListener {
            public a() {
            }

            public void onClick(View view) {
                f fVar;
                File file;
                if (f.k(f.this).equals(f.i(f.this))) {
                    return;
                }
                if (!f.k(f.this).equals("/storage/emulated/0")) {
                    f.l(f.this, new File(f.k(f.this)).getParent());
                    String[] split = f.k(f.this).split("/");
                    if (split.length >= 3) {
                        if (Pattern.compile("^\\(?(.{4})\\)?[- ]?(.{4})$").matcher(split[2]).matches()) {
                            if (f.k(f.this).equals("/storage/" + split[2] + "/Android/data")) {
                                f.l(f.this, "/storage/" + split[2]);
                                fVar = f.this;
                                file = new File(f.k(f.this));
                            }
                        }
                        if (new File(f.k(f.this)).getParent().equals("/storage/" + split[2] + "/Android/data")) {
                            f.l(f.this, "/storage/" + split[2] + "/Android/data/com.nst.iptvsmarterstvbox");
                        }
                    }
                    f.h(f.this);
                }
                f.l(f.this, "/storage/emulated");
                fVar = f.this;
                file = new File(f.k(f.this));
                f.l(fVar, file.getParent());
                f.h(f.this);
            }
        }

        public d() {
        }

        public void onShow(DialogInterface dialogInterface) {
            f fVar = f.this;
            f.e(fVar, f.o(fVar).getButton(-2));
            f fVar2 = f.this;
            f.b(fVar2, f.o(fVar2).getButton(-3));
            if (f.k(f.this).equals(f.i(f.this))) {
                f.a(f.this).setVisibility(4);
            } else {
                f.a(f.this).setVisibility(0);
            }
            f.d(f.this).setTag("1");
            f.a(f.this).setTag("3");
            Button d = f.d(f.this);
            f fVar3 = f.this;
            d.setOnFocusChangeListener(fVar3.new h(f.d(fVar3)));
            f.d(f.this).setTextColor(f.p(f.this).getResources().getColor(a7.c.G));
            ViewGroup.MarginLayoutParams layoutParams = f.d(f.this).getLayoutParams();
            ViewGroup.MarginLayoutParams layoutParams2 = f.a(f.this).getLayoutParams();
            layoutParams.setMargins(0, 0, 50, 0);
            String A = new u7.a(f.p(f.this)).A();
            if (A.equals(m7.a.K0)) {
                f.d(f.this).setTextSize(16.0f);
                f.d(f.this).setBackground(f.p(f.this).getResources().getDrawable(a7.e.o));
                layoutParams.width = 230;
                layoutParams.height = 90;
            } else {
                f.d(f.this).setTextSize(14.0f);
                f.d(f.this).setBackground(f.p(f.this).getResources().getDrawable(a7.e.h));
                layoutParams.width = 255;
                layoutParams.height = 135;
            }
            Button a2 = f.a(f.this);
            f fVar4 = f.this;
            a2.setOnFocusChangeListener(fVar4.new h(f.a(fVar4)));
            f.a(f.this).setTextColor(f.p(f.this).getResources().getColor(a7.c.G));
            if (A.equals(m7.a.K0)) {
                f.a(f.this).setTextSize(16.0f);
                f.a(f.this).setBackground(f.p(f.this).getResources().getDrawable(a7.e.o));
                layoutParams2.width = 230;
                layoutParams2.height = 90;
            } else {
                f.a(f.this).setTextSize(14.0f);
                f.a(f.this).setBackground(f.p(f.this).getResources().getDrawable(a7.e.k1));
                layoutParams2.width = 255;
                layoutParams2.height = 135;
            }
            f.a(f.this).setOnClickListener(new a());
        }
    }

    public class e implements DialogInterface.OnKeyListener {
        public e() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            f fVar;
            File file;
            if (i != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            if (f.k(f.this).equals(f.i(f.this))) {
                f.o(f.this).dismiss();
                return true;
            }
            if (!f.k(f.this).equals("/storage/emulated/0")) {
                f.l(f.this, new File(f.k(f.this)).getParent());
                String[] split = f.k(f.this).split("/");
                if (split.length >= 3) {
                    if (Pattern.compile("^\\(?(.{4})\\)?[- ]?(.{4})$").matcher(split[2]).matches()) {
                        if (f.k(f.this).equals("/storage/" + split[2] + "/Android/data")) {
                            f.l(f.this, "/storage/" + split[2]);
                            fVar = f.this;
                            file = new File(f.k(f.this));
                        }
                    }
                    if (new File(f.k(f.this)).getParent().equals("/storage/" + split[2] + "/Android/data")) {
                        f.l(f.this, "/storage/" + split[2] + "/Android/data/com.nst.iptvsmarterstvbox");
                    }
                }
                f.h(f.this);
                return true;
            }
            f.l(f.this, "/storage/emulated");
            fVar = f.this;
            file = new File(f.k(f.this));
            f.l(fVar, file.getParent());
            f.h(f.this);
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
                    if (view3 != null && view3.getTag() != null && this.a.getTag().equals("1") && f.d(f.this) != null) {
                        f.d(f.this).setBackgroundResource(a7.e.h);
                    }
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("3") || f.a(f.this) == null) {
                        return;
                    }
                    f.a(f.this).setBackgroundResource(a7.e.p);
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
                if (view5 != null && view5.getTag() != null && this.a.getTag().equals("1") && f.d(f.this) != null) {
                    f.d(f.this).setBackgroundResource(a7.e.o);
                }
                View view6 = this.a;
                if (view6 != null && view6.getTag() != null && this.a.getTag().equals("3") && f.a(f.this) != null) {
                    f.a(f.this).setBackgroundResource(a7.e.o);
                }
            }
            a(r1);
            b(r1);
        }
    }

    public f(Context context, g gVar) {
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

    public static /* synthetic */ Button a(f fVar) {
        return fVar.k;
    }

    public static /* synthetic */ Button b(f fVar, Button button) {
        fVar.k = button;
        return button;
    }

    public static /* synthetic */ File c(f fVar) {
        return fVar.p;
    }

    public static /* synthetic */ Button d(f fVar) {
        return fVar.j;
    }

    public static /* synthetic */ Button e(f fVar, Button button) {
        fVar.j = button;
        return button;
    }

    public static /* synthetic */ File f(f fVar, File file) {
        fVar.p = file;
        return file;
    }

    public static /* synthetic */ HashMap g(f fVar) {
        return fVar.l;
    }

    public static /* synthetic */ void h(f fVar) {
        fVar.A();
    }

    public static /* synthetic */ String i(f fVar) {
        return fVar.b;
    }

    public static /* synthetic */ List j(f fVar) {
        return fVar.f;
    }

    public static /* synthetic */ String k(f fVar) {
        return fVar.d;
    }

    public static /* synthetic */ String l(f fVar, String str) {
        fVar.d = str;
        return str;
    }

    public static /* synthetic */ String m(f fVar, Object obj) {
        String str = fVar.d + obj;
        fVar.d = str;
        return str;
    }

    public static /* synthetic */ g n(f fVar) {
        return fVar.g;
    }

    public static /* synthetic */ AlertDialog o(f fVar) {
        return fVar.o;
    }

    public static /* synthetic */ Context p(f fVar) {
        return fVar.c;
    }

    public static /* synthetic */ q7.j q(f fVar) {
        return fVar.i;
    }

    public static /* synthetic */ ListViewMaxHeight r(f fVar) {
        return fVar.m;
    }

    public static /* synthetic */ void s(f fVar, File file) {
        fVar.t(file);
    }

    public static int w(float f2, Context context) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void A() {
        TextView findViewById;
        try {
            if (!this.d.endsWith(".m3u") && !this.d.endsWith(".m3u8")) {
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
            q7.j jVar = new q7.j(this.c, this.f, "m3u");
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
        this.n = new AlertDialog.Builder(this.c, a7.k.a);
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.c);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(this.c.getResources().getString(a7.j.l0));
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
            if (file.listFiles() != null) {
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        arrayList.add(file2.getName());
                    }
                    if ((file2.isFile() && file2.getName().endsWith(".m3u")) || (file2.isFile() && file2.getName().endsWith(".m3u8"))) {
                        arrayList.add(file2.getName());
                    }
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
