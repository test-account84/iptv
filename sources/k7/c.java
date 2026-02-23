package k7;

import a7.g;
import a7.j;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import com.nst.iptvsmarterstvbox.miscelleneious.chromecastfeature.ExpandedControlsActivity;
import k7.b;
import n4.p;
import o4.e;
import org.json.JSONObject;
import p4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends Fragment implements b.f {
    public i7.b a;
    public f c;

    public class a implements b.d {
        public a() {
        }

        public void a(View view) {
            int id = view.getId();
            if (id == a7.f.m2) {
                Log.d("QueueListViewFragment", "onItemViewClicked() container " + view.getTag(j.O5));
                c.x(c.this, view);
                return;
            }
            if (id == a7.f.xc) {
                Log.d("QueueListViewFragment", "onItemViewClicked() play-pause " + view.getTag(j.O5));
                c.z(c.this, view);
                return;
            }
            if (id == a7.f.yc) {
                c.A(c.this).v(view, (p) view.getTag(j.O5));
            } else if (id == a7.f.Dg) {
                c.A(c.this).w(view, (p) view.getTag(j.O5));
            }
        }
    }

    public static /* synthetic */ i7.b A(c cVar) {
        return cVar.a;
    }

    private i B() {
        e c = o4.b.e(getContext()).c().c();
        if (c == null || !c.c()) {
            return null;
        }
        return c.r();
    }

    public static /* synthetic */ void x(c cVar, View view) {
        cVar.D(view);
    }

    public static /* synthetic */ void z(c cVar, View view) {
        cVar.E(view);
    }

    public final void D(View view) {
        i B = B();
        if (B == null) {
            return;
        }
        p pVar = (p) view.getTag(j.O5);
        if (this.a.t()) {
            Log.d("QueueListViewFragment", "Is detached: itemId = " + pVar.K());
            B.H(l7.b.a(this.a.p()), this.a.q(pVar.K()), 0, (JSONObject) null);
            return;
        }
        if (this.a.m() != pVar.K()) {
            B.F(pVar.K(), (JSONObject) null);
        } else if (o4.b.e(getContext().getApplicationContext()).c().c() != null) {
            startActivity(new Intent(getActivity(), ExpandedControlsActivity.class));
        }
    }

    public final void E(View view) {
        i B = B();
        if (B != null) {
            B.W();
        }
    }

    public void k(RecyclerView.D d) {
        this.c.H(d);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(g.U2, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView findViewById = getView().findViewById(a7.f.Dd);
        this.a = i7.b.n(getContext());
        b bVar = new b(getActivity(), this);
        findViewById.setHasFixedSize(true);
        findViewById.setAdapter(bVar);
        findViewById.setLayoutManager(new LinearLayoutManager(getActivity()));
        f fVar = new f(new k7.a(bVar));
        this.c = fVar;
        fVar.m(findViewById);
        bVar.r0(new a());
    }
}
