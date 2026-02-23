package q7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.pojo.BillingDeviceInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class g extends RecyclerView.g {
    public final List d;
    public Context e;
    public String f;
    public int g;

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ c c;

        public a(int i, c cVar) {
            this.a = i;
            this.c = cVar;
        }

        public void onClick(View view) {
            g.j0(g.this, this.a);
            g.l0(g.this).F(((BillingDeviceInfo) g.k0(g.this).get(this.a)).getDevicename(), ((BillingDeviceInfo) g.k0(g.this).get(this.a)).getMac());
            g.this.w();
            this.c.v.setImageResource(a7.e.g0);
        }
    }

    public static class c extends RecyclerView.D {
        public TextView t;
        public RelativeLayout u;
        public ImageView v;

        public c(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Yh);
            this.u = view.findViewById(a7.f.nf);
            this.v = view.findViewById(a7.f.Q4);
        }
    }

    public g(Context context, List list) {
        this.f = "mobile";
        this.e = context;
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.addAll(list);
        if (new u7.a(context).A().equals(m7.a.K0)) {
            this.f = "tv";
        } else {
            this.f = "mobile";
        }
        this.g = -1;
    }

    public static /* synthetic */ int j0(g gVar, int i) {
        gVar.g = i;
        return i;
    }

    public static /* synthetic */ List k0(g gVar) {
        return gVar.d;
    }

    public static /* synthetic */ Context l0(g gVar) {
        return gVar.e;
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void E(c cVar, int i) {
        try {
            cVar.t.setText(((BillingDeviceInfo) this.d.get(i)).getDevicename());
            if (this.g == i) {
                cVar.v.setImageResource(a7.e.g0);
                cVar.u.requestFocus();
            } else {
                cVar.v.setImageResource(a7.e.Q);
            }
            RelativeLayout relativeLayout = cVar.u;
            relativeLayout.setOnFocusChangeListener(new b(relativeLayout, cVar, i));
            cVar.u.setOnClickListener(new a(i, cVar));
        } catch (Exception unused) {
        }
    }

    public int n() {
        List list = this.d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public c L(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.t3, viewGroup, false));
    }

    public class b implements View.OnFocusChangeListener {
        public final View a;
        public final c b;
        public int c;

        public b(View view, c cVar, int i) {
            this.a = view;
            this.b = cVar;
            this.c = i;
        }

        public void onFocusChange(View view, boolean z) {
        }
    }
}
