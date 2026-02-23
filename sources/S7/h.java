package s7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.ArrayList;
import q7.K;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class h extends Fragment {
    public ImageView a;
    public TextView c;
    public View d;
    public TabLayout e;
    public View f;
    public ViewPager g;
    public RelativeLayout h;
    public Context i;
    public ArrayList j = new ArrayList();
    public Typeface k;
    public Typeface l;
    public String m;
    public String n;
    public b o;

    public interface b {
    }

    public static /* synthetic */ ViewPager x(h hVar) {
        return hVar.g;
    }

    private void z() {
        this.i = getContext();
        getActivity().getSharedPreferences("loginPrefs", 0);
        A();
    }

    public final void A() {
        TabLayout tabLayout;
        TabLayout.g z;
        Resources resources;
        int i;
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.i);
        if (currentAPPType.equals("m3u")) {
            tabLayout = this.e;
            z = tabLayout.z();
            resources = this.i.getResources();
            i = a7.j.x;
        } else {
            TabLayout tabLayout2 = this.e;
            tabLayout2.e(tabLayout2.z().o(getResources().getString(a7.j.h0)));
            TabLayout tabLayout3 = this.e;
            tabLayout3.e(tabLayout3.z().o(getResources().getString(a7.j.y8)));
            TabLayout tabLayout4 = this.e;
            tabLayout4.e(tabLayout4.z().o(getResources().getString(a7.j.O6)));
            tabLayout = this.e;
            z = tabLayout.z();
            resources = getResources();
            i = a7.j.Q5;
        }
        tabLayout.e(z.o(resources.getString(i)));
        TabLayout tabLayout5 = this.e;
        tabLayout5.e(tabLayout5.z().o(getResources().getString(a7.j.m8)));
        this.e.setTabGravity(0);
        K k = new K(getChildFragmentManager(), this.e.getTabCount(), getContext(), this.j, currentAPPType);
        this.g.setAdapter(k);
        this.e.setupWithViewPager(this.g);
        for (int i2 = 0; i2 < this.e.getTabCount(); i2++) {
            this.e.w(i2).m(k.q(i2));
        }
        View e = this.e.w(0).e();
        View e2 = this.e.w(1).e();
        k.u(e, this.k);
        k.v(e2, this.k);
        this.g.setCurrentItem(0);
        this.g.c(new TabLayout.h(this.e));
        this.e.d(new a(k));
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof b) {
            this.o = (b) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.m = getArguments().getString("param1");
            this.n = getArguments().getString("param2");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a7.g.T2, viewGroup, false);
        this.a = inflate.findViewById(a7.f.p5);
        this.c = inflate.findViewById(a7.f.mk);
        this.d = inflate.findViewById(a7.f.Nm);
        this.e = inflate.findViewById(a7.f.Pg);
        this.f = inflate.findViewById(a7.f.D6);
        this.g = inflate.findViewById(a7.f.Wb);
        this.h = inflate.findViewById(a7.f.Ke);
        z();
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        this.o = null;
    }

    public class a implements TabLayout.d {
        public final /* synthetic */ K a;

        public a(K k) {
            this.a = k;
        }

        public void a(TabLayout.g gVar) {
            h.x(h.this).setCurrentItem(gVar.g());
            int g = gVar.g();
            View e = gVar.e();
            if (g == 0) {
                this.a.r(e, h.this.k, g);
                return;
            }
            if (g == 1 || g == 2) {
                this.a.t(e, h.this.k, g);
            } else {
                if (g != 3) {
                    return;
                }
                this.a.s(e, h.this.k);
            }
        }

        public void b(TabLayout.g gVar) {
            int g = gVar.g();
            View e = gVar.e();
            if (g == 0) {
                this.a.x(e, h.this.l);
                return;
            }
            if (g == 1 || g == 2) {
                this.a.w(e, h.this.l);
            } else {
                if (g != 3) {
                    return;
                }
                this.a.y(e, h.this.l);
            }
        }

        public void c(TabLayout.g gVar) {
        }
    }
}
