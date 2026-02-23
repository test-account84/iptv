package s7;

import a7.k;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import d.a;
import java.util.ArrayList;
import java.util.Iterator;
import m7.w;
import q7.d0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class j extends Fragment {
    public SharedPreferences.Editor A;
    public SharedPreferences B;
    public SharedPreferences.Editor C;
    public PopupWindow D;
    public ProgressBar a;
    public RecyclerView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public RecyclerView.o g;
    public SharedPreferences h;
    public d0 i;
    public Toolbar k;
    public SearchView l;
    public Context m;
    public String n;
    public LiveStreamDBHandler o;
    public ArrayList u;
    public ArrayList v;
    public ArrayList w;
    public ArrayList x;
    public ArrayList y;
    public SharedPreferences z;
    public ArrayList j = new ArrayList();
    public DatabaseUpdatedStatusDBModel p = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel q = new DatabaseUpdatedStatusDBModel();
    public LiveStreamsDBModel r = new LiveStreamsDBModel();
    public ArrayList s = new ArrayList();
    public ArrayList t = new ArrayList();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(j.this.m);
        }
    }

    public class c implements SearchView.m {
        public c() {
        }

        public boolean onQueryTextChange(String str) {
            j.x(j.this).setVisibility(8);
            if (j.z(j.this) == null || j.A(j.this) == null || j.A(j.this).getVisibility() == 0) {
                return false;
            }
            j.z(j.this).q0(str, j.x(j.this));
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(j.this.m);
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            j.B(j.this).dismiss();
        }
    }

    public class i implements View.OnClickListener {
        public final /* synthetic */ RadioGroup a;
        public final /* synthetic */ View c;

        public i(RadioGroup radioGroup, View view) {
            this.a = radioGroup;
            this.c = view;
        }

        public void onClick(View view) {
            SharedPreferences.Editor D;
            String str;
            RadioButton findViewById = this.c.findViewById(this.a.getCheckedRadioButtonId());
            if (findViewById.getText().toString().equals(j.this.getResources().getString(a7.j.i7))) {
                D = j.D(j.this);
                str = "1";
            } else if (findViewById.getText().toString().equals(j.this.getResources().getString(a7.j.f7))) {
                D = j.D(j.this);
                str = "2";
            } else if (findViewById.getText().toString().equals(j.this.getResources().getString(a7.j.k7))) {
                D = j.D(j.this);
                str = "3";
            } else {
                D = j.D(j.this);
                str = "0";
            }
            D.putString("sort", str);
            j.D(j.this).commit();
            j jVar = j.this;
            j.J(jVar, jVar.getActivity().getSharedPreferences("listgridview", 0));
            j jVar2 = j.this;
            j.L(jVar2, j.E(jVar2).edit());
            int i = j.E(j.this).getInt("livestream", 0);
            m7.a.M = i;
            if (i == 1) {
                j.P(j.this);
            } else {
                j.S(j.this);
            }
            j.B(j.this).dismiss();
        }
    }

    public static /* synthetic */ TextView A(j jVar) {
        return jVar.d;
    }

    public static /* synthetic */ PopupWindow B(j jVar) {
        return jVar.D;
    }

    public static /* synthetic */ SharedPreferences.Editor D(j jVar) {
        return jVar.C;
    }

    public static /* synthetic */ SharedPreferences E(j jVar) {
        return jVar.z;
    }

    public static /* synthetic */ SharedPreferences J(j jVar, SharedPreferences sharedPreferences) {
        jVar.z = sharedPreferences;
        return sharedPreferences;
    }

    public static /* synthetic */ SharedPreferences.Editor L(j jVar, SharedPreferences.Editor editor) {
        jVar.A = editor;
        return editor;
    }

    public static /* synthetic */ void P(j jVar) {
        jVar.X();
    }

    public static /* synthetic */ void S(j jVar) {
        jVar.Y();
    }

    private ArrayList T() {
        ArrayList allPasswordStatus = this.o.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.m));
        this.u = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.t.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.t;
    }

    private ArrayList W(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (liveStreamsDBModel.getCategoryId().equals((String) it2.next())) {
                            break;
                        }
                    } else {
                        ArrayList arrayList3 = this.v;
                        if (arrayList3 != null) {
                            arrayList3.add(liveStreamsDBModel);
                        }
                    }
                }
            }
        }
        return this.v;
    }

    private void X() {
        this.m = getContext();
        this.o = new LiveStreamDBHandler(this.m);
        RecyclerView recyclerView = this.c;
        if (recyclerView == null || this.m == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), w.L(this.m) + 1);
        this.g = gridLayoutManager;
        this.c.setLayoutManager(gridLayoutManager);
        this.c.setItemAnimator(new androidx.recyclerview.widget.c());
        SharedPreferences sharedPreferences = this.m.getSharedPreferences("loginPrefs", 0);
        this.h = sharedPreferences;
        sharedPreferences.getString("username", "");
        this.h.getString("password", "");
        c0();
    }

    private void Y() {
        this.m = getContext();
        this.o = new LiveStreamDBHandler(this.m);
        RecyclerView recyclerView = this.c;
        if (recyclerView == null || this.m == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.g = linearLayoutManager;
        this.c.setLayoutManager(linearLayoutManager);
        this.c.setItemAnimator(new androidx.recyclerview.widget.c());
        SharedPreferences sharedPreferences = this.m.getSharedPreferences("loginPrefs", 0);
        this.h = sharedPreferences;
        sharedPreferences.getString("username", "");
        this.h.getString("password", "");
        c0();
    }

    public static j Z(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("", str);
        j jVar = new j();
        jVar.setArguments(bundle);
        return jVar;
    }

    private void b0() {
        this.k = getActivity().findViewById(a7.f.kh);
    }

    private void c0() {
        try {
            a();
            if (this.m != null) {
                LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(this.m);
                this.u = new ArrayList();
                this.v = new ArrayList();
                this.w = new ArrayList();
                this.x = new ArrayList();
                this.y = new ArrayList();
                ArrayList allLiveStreamsArchive = liveStreamDBHandler.getAllLiveStreamsArchive(this.n);
                if (liveStreamDBHandler.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.m)) <= 0 || allLiveStreamsArchive == null) {
                    this.x = allLiveStreamsArchive;
                } else {
                    ArrayList T = T();
                    this.t = T;
                    if (T != null) {
                        this.w = W(allLiveStreamsArchive, T);
                    }
                    this.x = this.w;
                }
                ArrayList arrayList = this.x;
                if (arrayList != null && this.c != null && arrayList.size() != 0) {
                    b();
                    d0 d0Var = new d0(this.x, getContext());
                    this.i = d0Var;
                    this.c.setAdapter(d0Var);
                    this.i.w();
                    return;
                }
                b();
                TextView textView = this.d;
                if (textView != null) {
                    textView.setText(getResources().getString(a7.j.y4));
                    this.d.setVisibility(0);
                }
                this.f.setVisibility(0);
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    private void i0(Activity activity) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(a7.g.C4, activity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(activity);
            this.D = popupWindow;
            popupWindow.setContentView(inflate);
            this.D.setWidth(-1);
            this.D.setHeight(-1);
            this.D.setFocusable(true);
            this.D.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.H0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            RadioGroup findViewById3 = inflate.findViewById(a7.f.Kd);
            RadioButton findViewById4 = inflate.findViewById(a7.f.rd);
            RadioButton findViewById5 = inflate.findViewById(a7.f.md);
            RadioButton findViewById6 = inflate.findViewById(a7.f.fd);
            RadioButton findViewById7 = inflate.findViewById(a7.f.zd);
            String string = this.B.getString("sort", "");
            if (string.equals("1")) {
                findViewById5.setChecked(true);
            } else if (string.equals("2")) {
                findViewById6.setChecked(true);
            } else if (string.equals("3")) {
                findViewById7.setChecked(true);
            } else {
                findViewById4.setChecked(true);
            }
            findViewById2.setOnClickListener(new h());
            findViewById.setOnClickListener(new i(findViewById3, inflate));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public static /* synthetic */ TextView x(j jVar) {
        return jVar.e;
    }

    public static /* synthetic */ d0 z(j jVar) {
        return jVar.i;
    }

    public void a() {
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public void b() {
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.n = getArguments().getString("");
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.m == null || this.k == null) {
            return;
        }
        TypedValue typedValue = new TypedValue();
        if (this.m.getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, this.m.getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.k.getChildCount(); i2++) {
            if (this.k.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.k.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a7.g.N2, viewGroup, false);
        this.a = inflate.findViewById(a7.f.ec);
        this.c = inflate.findViewById(a7.f.ub);
        this.d = inflate.findViewById(a7.f.sk);
        this.e = inflate.findViewById(a7.f.wk);
        this.f = inflate.findViewById(a7.f.Pi);
        D.b.d(getActivity());
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("sort", 0);
        this.B = sharedPreferences;
        this.C = sharedPreferences.edit();
        if (this.B.getString("sort", "").equals("")) {
            this.C.putString("sort", "0");
            this.C.commit();
        }
        setHasOptionsMenu(true);
        b0();
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("listgridview", 0);
        this.z = sharedPreferences2;
        this.A = sharedPreferences2.edit();
        int i2 = this.z.getInt("livestream", 0);
        m7.a.M = i2;
        if (i2 == 1) {
            X();
        } else {
            Y();
        }
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this.m, NewDashboardActivity.class));
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this.m, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.m) != null) {
            new a.a(context, k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new b()).g(getResources().getString(a7.j.d4), new a()).n();
        }
        if (itemId == a7.f.g) {
            SearchView b2 = P.w.b(menuItem);
            this.l = b2;
            b2.setQueryHint(getResources().getString(a7.j.A6));
            this.l.setIconifiedByDefault(false);
            this.l.setOnQueryTextListener(new c());
            return true;
        }
        if (itemId == a7.f.gb) {
            a.a aVar = new a.a(this.m);
            aVar.setTitle(this.m.getResources().getString(a7.j.u0));
            aVar.f(this.m.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(getResources().getString(a7.j.S8), new d());
            aVar.g(getResources().getString(a7.j.d4), new e());
            aVar.n();
            return true;
        }
        if (itemId == a7.f.ib) {
            a.a aVar2 = new a.a(this.m);
            aVar2.setTitle(this.m.getResources().getString(a7.j.u0));
            aVar2.f(this.m.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.m.getResources().getString(a7.j.S8), new f());
            aVar2.g(this.m.getResources().getString(a7.j.d4), new g());
            aVar2.n();
            return true;
        }
        if (itemId == a7.f.q6) {
            this.A.putInt("livestream", 1);
            this.A.commit();
            X();
        }
        if (itemId == a7.f.u6) {
            this.A.putInt("livestream", 0);
            this.A.commit();
            Y();
        }
        if (itemId == a7.f.mb) {
            i0(getActivity());
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        this.k.x(a7.h.s);
        menu.findItem(a7.f.q6);
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
