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
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.ParentalControlActivitity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import d.a;
import m7.w;
import q7.J;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b extends Fragment {
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
            ProgressBar progressBar = b.this.f;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            if (b.x(b.this) != null) {
                b.x(b.this).dismiss();
            }
            b bVar = b.this;
            if (bVar.e == null || b.z(bVar) == null) {
                return true;
            }
            b.this.e.setVisibility(8);
            J z = b.z(b.this);
            b bVar2 = b.this;
            z.t0(str, bVar2.e, b.x(bVar2));
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
            w.m0(b.this.q);
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

    public static /* synthetic */ ProgressDialog x(b bVar) {
        return bVar.j;
    }

    public static /* synthetic */ J z(b bVar) {
        return bVar.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00f8 A[PHI: r0 r1
      0x00f8: PHI (r0v17 java.util.ArrayList) = (r0v11 java.util.ArrayList), (r0v19 java.util.ArrayList) binds: [B:59:0x0127, B:26:0x00f6] A[DONT_GENERATE, DONT_INLINE]
      0x00f8: PHI (r1v20 com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel) = 
      (r1v10 com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel)
      (r1v26 com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel)
     binds: [B:59:0x0127, B:26:0x00f6] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A() {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.b.A():void");
    }

    public final void B() {
        setHasOptionsMenu(true);
        this.l = getActivity().findViewById(a7.f.kh);
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
