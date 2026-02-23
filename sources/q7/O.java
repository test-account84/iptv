package q7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class o extends RecyclerView.g {
    public Context d;
    public List e;
    public PackageManager f;
    public b g;

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            o oVar = o.this;
            oVar.g.s0(view, ((ApplicationInfo) o.j0(oVar).get(this.a)).loadLabel(o.this.f).toString(), ((ApplicationInfo) o.j0(o.this).get(this.a)).packageName);
        }
    }

    public interface b {
        void s0(View view, String str, String str2);
    }

    public class c extends RecyclerView.D {
        public TextView t;
        public TextView u;
        public ImageView v;
        public LinearLayout w;

        public c(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Gk);
            this.u = view.findViewById(a7.f.Dh);
            this.v = view.findViewById(a7.f.z4);
            this.w = view.findViewById(a7.f.g9);
        }
    }

    public o(Context context, List list, b bVar) {
        this.d = context;
        this.e = list;
        this.f = context.getPackageManager();
        this.g = bVar;
    }

    public static /* synthetic */ List j0(o oVar) {
        return oVar.e;
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void E(c cVar, int i) {
        cVar.u.setText(((ApplicationInfo) this.e.get(i)).loadLabel(this.f));
        cVar.t.setText(((ApplicationInfo) this.e.get(i)).packageName);
        cVar.v.setImageDrawable(((ApplicationInfo) this.e.get(i)).loadIcon(this.f));
        cVar.w.setOnClickListener(new a(i));
    }

    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public c L(ViewGroup viewGroup, int i) {
        LayoutInflater from;
        int i2;
        if (new u7.a(this.d).A().equals(m7.a.K0)) {
            from = LayoutInflater.from(this.d);
            i2 = a7.g.f2;
        } else {
            from = LayoutInflater.from(this.d);
            i2 = a7.g.e2;
        }
        return new c(from.inflate(i2, viewGroup, false));
    }

    public int n() {
        return this.e.size();
    }
}
