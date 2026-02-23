package s7;

import P.w;
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
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.ParentalControlActivitity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import d.a;
import q7.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class g extends Fragment {
    public String a;
    public String c;
    public RecyclerView d;
    public TextView e;
    public ProgressBar f;
    public ParentalControlActivitity g;
    public L h;
    public RecyclerView.o i;
    public ProgressDialog j;
    public Typeface k;
    public Toolbar l;
    public SearchView m;
    public LiveStreamDBHandler n;
    public DatabaseUpdatedStatusDBModel o = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel p = new DatabaseUpdatedStatusDBModel();
    public int q = -1;
    public Context r;
    public f s;

    public class a implements SearchView.m {
        public a() {
        }

        public boolean onQueryTextChange(String str) {
            if (g.x(g.this) != null) {
                g.x(g.this).setVisibility(4);
            }
            if (g.z(g.this) != null) {
                g.z(g.this).dismiss();
            }
            if (g.A(g.this) == null || g.B(g.this) == null) {
                return true;
            }
            g.A(g.this).setVisibility(8);
            g.B(g.this).t0(str, g.A(g.this), g.z(g.this));
            return true;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
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

    public static /* synthetic */ TextView A(g gVar) {
        return gVar.e;
    }

    public static /* synthetic */ L B(g gVar) {
        return gVar.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void D() {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.g.D():void");
    }

    private void E() {
        setHasOptionsMenu(true);
        this.l = getActivity().findViewById(a7.f.kh);
    }

    public static /* synthetic */ ProgressBar x(g gVar) {
        return gVar.f;
    }

    public static /* synthetic */ ProgressDialog z(g gVar) {
        return gVar.j;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof f) {
            this.s = (f) context;
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
        if (this.r.getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, this.r.getResources().getDisplayMetrics());
        }
        for (int i = 0; i < this.l.getChildCount(); i++) {
            if (this.l.getChildAt(i) instanceof ActionMenuView) {
                ((a.a) this.l.getChildAt(i).getLayoutParams()).a = 16;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(false);
        View inflate = layoutInflater.inflate(a7.g.S2, viewGroup, false);
        this.d = inflate.findViewById(a7.f.ub);
        this.e = inflate.findViewById(a7.f.Q2);
        this.f = inflate.findViewById(a7.f.ec);
        D();
        E();
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        this.s = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        Intent intent;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            intent = new Intent(this.r, NewDashboardActivity.class);
        } else {
            if (itemId != a7.f.Mb) {
                if (itemId == a7.f.g) {
                    SearchView b2 = w.b(menuItem);
                    this.m = b2;
                    b2.setQueryHint(getResources().getString(a7.j.z6));
                    this.m.setIconifiedByDefault(false);
                    this.m.setOnQueryTextListener(new a());
                    return true;
                }
                if (itemId == a7.f.gb) {
                    a.a aVar = new a.a(this.r);
                    aVar.d(a7.e.s1);
                    aVar.j(this.r.getResources().getString(a7.j.S8), new b());
                    aVar.g(this.r.getResources().getString(a7.j.d4), new c());
                    aVar.n();
                    return true;
                }
                if (itemId != a7.f.ib) {
                    if (itemId == a7.f.f && (context = this.r) != null) {
                        m7.w.n0(context);
                    }
                    return false;
                }
                a.a aVar2 = new a.a(this.r);
                aVar2.d(a7.e.s1);
                aVar2.j(this.r.getResources().getString(a7.j.S8), new d());
                aVar2.g(this.r.getResources().getString(a7.j.d4), new e());
                aVar2.n();
                return true;
            }
            intent = new Intent(this.r, SettingsActivity.class);
        }
        startActivity(intent);
        return false;
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
