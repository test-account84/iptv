package q7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class p extends e {
    public b g;

    public class a implements View.OnClickListener {
        public final /* synthetic */ c a;

        public a(c cVar) {
            this.a = cVar;
        }

        public void onClick(View view) {
            if (p.l0(p.this) != null) {
                p.l0(p.this).a((e7.c) p.this.e.get(this.a.m()));
            }
        }
    }

    public interface b {
        void a(e7.c cVar);
    }

    public class c extends RecyclerView.D {
        public TextView t;

        public c(View view) {
            super(view);
            this.t = view.findViewById(a7.f.uj);
        }

        public static /* synthetic */ TextView P(c cVar) {
            return cVar.t;
        }
    }

    public p(Context context, ArrayList arrayList) {
        super(context, arrayList);
    }

    public static /* synthetic */ b l0(p pVar) {
        return pVar.g;
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void E(c cVar, int i) {
        c.P(cVar).setText(((e7.c) this.e.get(i)).c());
        ((RecyclerView.D) cVar).a.setOnClickListener(new a(cVar));
    }

    public int n() {
        return this.e.size();
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public c L(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(this.d).inflate(a7.g.b5, viewGroup, false));
    }

    public void p0(b bVar) {
        this.g = bVar;
    }
}
