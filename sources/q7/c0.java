package q7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class c0 extends RecyclerView.g {
    public int d;
    public Context e;
    public List f;
    public b g;

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ o7.a c;

        public a(int i, o7.a aVar) {
            this.a = i;
            this.c = aVar;
        }

        public void onClick(View view) {
            c0 c0Var = c0.this;
            c0Var.d = ((o7.a) c0.j0(c0Var).get(this.a)).c();
            if (c0.k0(c0.this) != null) {
                c0.k0(c0.this).a(this.a, this.c);
            }
        }
    }

    public interface b {
        void a(int i, o7.a aVar);
    }

    public class c implements View.OnFocusChangeListener {
        public final LinearLayout a;
        public final d b;
        public int c;

        public c(LinearLayout linearLayout, d dVar, int i) {
            this.a = linearLayout;
            this.b = dVar;
            this.c = i;
        }

        public void onFocusChange(View view, boolean z) {
            LinearLayout linearLayout;
            int i;
            if (z) {
                d dVar = this.b;
                if (dVar == null || (linearLayout = dVar.v) == null) {
                    return;
                } else {
                    i = a7.c.F;
                }
            } else {
                if (z) {
                    return;
                }
                linearLayout = this.b.v;
                i = a7.c.h;
            }
            linearLayout.setBackgroundResource(i);
        }
    }

    public class d extends RecyclerView.D {
        public TextView t;
        public TextView u;
        public LinearLayout v;

        public d(View view) {
            super(view);
            this.t = view.findViewById(a7.f.vb);
            this.u = view.findViewById(a7.f.k6);
            this.v = view.findViewById(a7.f.J1);
        }
    }

    public c0(Context context, List list) {
        this.e = context;
        this.f = list;
    }

    public static /* synthetic */ List j0(c0 c0Var) {
        return c0Var.f;
    }

    public static /* synthetic */ b k0(c0 c0Var) {
        return c0Var.g;
    }

    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void E(d dVar, int i) {
        o7.a aVar = (o7.a) this.f.get(i);
        dVar.u.setText(aVar.b());
        dVar.v.setOnClickListener(new a(i, aVar));
        LinearLayout linearLayout = dVar.v;
        linearLayout.setOnFocusChangeListener(new c(linearLayout, dVar, i));
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public d L(ViewGroup viewGroup, int i) {
        return new d(LayoutInflater.from(this.e).inflate(a7.g.u3, viewGroup, false));
    }

    public int n() {
        return this.f.size();
    }

    public void n0(b bVar) {
        this.g = bVar;
    }
}
