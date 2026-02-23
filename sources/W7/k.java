package w7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class k {
    public Context a;
    public ViewGroup b;
    public TableLayout c;

    public static class b {
        public TextView a;
        public TextView b;

        public b() {
        }

        public void a(String str) {
            TextView textView = this.a;
            if (textView != null) {
                textView.setText(str);
            }
        }

        public void b(String str) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(str);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public k(Context context) {
        this(context, a7.g.H4);
    }

    public static String a() {
        return "V";
    }

    public static String i() {
        return "GhlIGFwcCB5b3UgYXJlIHVzaW5nIGlzIG5vdCBvcmlnaW5hbC4=";
    }

    public View b(int i, String str, String str2) {
        ViewGroup inflate = LayoutInflater.from(this.a).inflate(i, this.c, false);
        k(inflate, str, str2);
        this.c.addView(inflate);
        return inflate;
    }

    public View c(int i, String str) {
        return d(this.a.getString(i), str);
    }

    public View d(String str, String str2) {
        return b(a7.g.I4, str, str2);
    }

    public View e(int i) {
        return f(this.a.getString(i));
    }

    public View f(String str) {
        return b(a7.g.J4, str, null);
    }

    public a.a g() {
        a.a aVar = new a.a(this.a);
        aVar.setView(h());
        return aVar;
    }

    public ViewGroup h() {
        return this.b;
    }

    public b j(View view) {
        b bVar = (b) view.getTag();
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(null);
        bVar2.a = view.findViewById(a7.f.vb);
        bVar2.b = view.findViewById(a7.f.Em);
        view.setTag(bVar2);
        return bVar2;
    }

    public void k(View view, String str, String str2) {
        b j = j(view);
        j.a(str);
        j.b(str2);
    }

    public void l(View view, String str) {
        j(view).b(str);
    }

    public k(Context context, int i) {
        this.a = context;
        ViewGroup inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        this.b = inflate;
        this.c = inflate.findViewById(a7.f.Qg);
    }

    public k(Context context, TableLayout tableLayout) {
        this.a = context;
        this.b = tableLayout;
        this.c = tableLayout;
    }
}
