package s7;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.ParentalControlActivitity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import m7.w;
import q7.J;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class d extends Fragment {
    public String a;
    public String c;
    public RecyclerView d;
    public TextView e;
    public ProgressBar f;
    public ParentalControlActivitity g;
    public J h;
    public RecyclerView.o i;
    public ProgressDialog j;
    public Typeface k;
    public Toolbar l;
    public SearchView m;
    public LiveStreamDBHandler n;
    public Context q;
    public f r;
    public DatabaseUpdatedStatusDBModel o = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel p = new DatabaseUpdatedStatusDBModel();
    public int s = -1;

    public class a implements SearchView.m {
        public a() {
        }

        public boolean onQueryTextChange(String str) {
            ProgressBar progressBar = d.this.f;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            if (d.x(d.this) != null) {
                d.x(d.this).dismiss();
            }
            d dVar = d.this;
            if (dVar.e == null || d.z(dVar) == null) {
                return true;
            }
            d.this.e.setVisibility(8);
            J z = d.z(d.this);
            d dVar2 = d.this;
            z.t0(str, dVar2.e, d.x(dVar2));
            return true;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(d.this.q);
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public interface f {
    }

    private void A() {
        RecyclerView recyclerView;
        this.q = getContext();
        this.n = new LiveStreamDBHandler(this.q);
        this.k = Typeface.createFromAsset(getActivity().getAssets(), "fonts/open_sans.ttf");
        this.g = this.q;
        this.d.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.i = linearLayoutManager;
        this.d.setLayoutManager(linearLayoutManager);
        ArrayList allliveCategoriesForParental = new LiveStreamDBHandler(this.q).getAllliveCategoriesForParental("radio_streams");
        HashMap hashMap = new HashMap();
        if (allliveCategoriesForParental != null) {
            Iterator it = allliveCategoriesForParental.iterator();
            while (it.hasNext()) {
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) it.next();
                hashMap.put(liveStreamCategoryIdDBModel.getLiveStreamCategoryID(), liveStreamCategoryIdDBModel.getLiveStreamCategoryName());
            }
        }
        ProgressBar progressBar = this.f;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
        if (allliveCategoriesForParental != null && allliveCategoriesForParental.size() > 0 && (recyclerView = this.d) != null && this.e != null) {
            recyclerView.setVisibility(0);
            this.e.setVisibility(8);
            J j = new J(allliveCategoriesForParental, getContext(), this.g, this.k);
            this.h = j;
            this.d.setAdapter(j);
            return;
        }
        RecyclerView recyclerView2 = this.d;
        if (recyclerView2 == null || this.e == null) {
            return;
        }
        recyclerView2.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setText(getResources().getString(a7.j.w4));
    }

    private void B() {
        setHasOptionsMenu(true);
        this.l = getActivity().findViewById(a7.f.kh);
    }

    public static /* synthetic */ ProgressDialog x(d dVar) {
        return dVar.j;
    }

    public static /* synthetic */ J z(d dVar) {
        return dVar.h;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof f) {
            this.r = (f) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.a = getArguments().getString("param1");
            this.c = getArguments().getString("param2");
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (menu != null) {
            menu.clear();
        }
        this.l.x(a7.h.r);
        TypedValue typedValue = new TypedValue();
        if (this.q.getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, this.q.getResources().getDisplayMetrics());
        }
        for (int i = 0; i < this.l.getChildCount(); i++) {
            if (this.l.getChildAt(i) instanceof ActionMenuView) {
                ((a.a) this.l.getChildAt(i).getLayoutParams()).a = 16;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(false);
        View inflate = layoutInflater.inflate(a7.g.Q2, viewGroup, false);
        this.d = inflate.findViewById(a7.f.ub);
        this.e = inflate.findViewById(a7.f.Q2);
        this.f = inflate.findViewById(a7.f.ec);
        A();
        B();
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        setHasOptionsMenu(false);
        this.r = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        Intent intent;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            intent = new Intent(this.q, NewDashboardActivity.class);
        } else {
            if (itemId != a7.f.Mb) {
                if (itemId == a7.f.g) {
                    SearchView b2 = P.w.b(menuItem);
                    this.m = b2;
                    b2.setQueryHint(getResources().getString(a7.j.D6));
                    this.m.setIconifiedByDefault(false);
                    this.m.setOnQueryTextListener(new a());
                    return true;
                }
                if (itemId == a7.f.gb) {
                    a.a aVar = new a.a(this.q);
                    aVar.setTitle(this.q.getResources().getString(a7.j.u0));
                    aVar.f(this.q.getResources().getString(a7.j.T0));
                    aVar.d(a7.e.s1);
                    aVar.j(this.q.getResources().getString(a7.j.S8), new b());
                    aVar.g(this.q.getResources().getString(a7.j.d4), new c());
                    aVar.n();
                    return true;
                }
                if (itemId != a7.f.ib) {
                    if (itemId == a7.f.f && (context = this.q) != null) {
                        w.n0(context);
                    }
                    return false;
                }
                a.a aVar2 = new a.a(this.q);
                aVar2.setTitle(this.q.getResources().getString(a7.j.u0));
                aVar2.f(this.q.getResources().getString(a7.j.T0));
                aVar2.d(a7.e.s1);
                aVar2.j(this.q.getResources().getString(a7.j.S8), new d());
                aVar2.g(this.q.getResources().getString(a7.j.d4), new e());
                aVar2.n();
                return true;
            }
            intent = new Intent(this.q, SettingsActivity.class);
        }
        startActivity(intent);
        return false;
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
