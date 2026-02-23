package s7;

import a7.k;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.pojo.XMLTVProgrammePojo;
import com.nst.iptvsmarterstvbox.view.activity.NewDashboardActivity;
import com.nst.iptvsmarterstvbox.view.activity.SettingsActivity;
import d.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import m7.w;
import q7.a0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class i extends Fragment implements z7.b {
    public RecyclerView a;
    public TextView c;
    public TextView d;
    public RecyclerView.o e;
    public a0 f;
    public ArrayList g = new ArrayList();
    public Toolbar h;
    public Context i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;

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
            w.n0(i.this.i);
        }
    }

    public static i z(String str, ArrayList arrayList, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Bundle bundle = new Bundle();
        bundle.putString("ACTIVE_LIVE_STREAM_CATEGORY_ID", str);
        bundle.putString("ACTIVE_LIVE_STREAM_ID", str2);
        bundle.putString("ACTIVE_LIVE_STREAM_NUM", str3);
        bundle.putString("ACTIVE_LIVE_STREAM_NAME", str4);
        bundle.putString("ACTIVE_LIVE_STREAM_ICON", str5);
        bundle.putString("ACTIVE_LIVE_STREAM_CHANNEL_ID", str6);
        bundle.putString("ACTIVE_LIVE_STREAM_CHANNEL_DURATION", str7);
        bundle.putString("ACTIVE_LIVE_STREAM_CHANNEL_URL", str8);
        bundle.putSerializable("LIVE_STREAMS_EPG", arrayList);
        i iVar = new i();
        iVar.setArguments(bundle);
        return iVar;
    }

    public void A() {
        String str;
        this.j = getArguments().getString("ACTIVE_LIVE_STREAM_CATEGORY_ID");
        this.k = getArguments().getString("ACTIVE_LIVE_STREAM_ID");
        this.l = getArguments().getString("ACTIVE_LIVE_STREAM_NUM");
        this.m = getArguments().getString("ACTIVE_LIVE_STREAM_NAME");
        this.n = getArguments().getString("ACTIVE_LIVE_STREAM_ICON");
        this.o = getArguments().getString("ACTIVE_LIVE_STREAM_CHANNEL_ID");
        this.p = getArguments().getString("ACTIVE_LIVE_STREAM_CHANNEL_DURATION");
        this.q = getArguments().getString("ACTIVE_LIVE_STREAM_CHANNEL_URL");
        ArrayList serializable = getArguments().getSerializable("LIVE_STREAMS_EPG");
        if (this.j == null || serializable == null) {
            return;
        }
        ArrayList arrayList = serializable;
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            String start = ((XMLTVProgrammePojo) arrayList.get(i)).getStart();
            String[] split = start.split("\\s+");
            try {
                Long.parseLong(((XMLTVProgrammePojo) arrayList.get(i)).getStartTimeStamp());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            try {
                Long.parseLong(((XMLTVProgrammePojo) arrayList.get(i)).getEndTimeStamp());
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            ((XMLTVProgrammePojo) arrayList.get(i)).getStop();
            start.split("\\s+");
            ((XMLTVProgrammePojo) arrayList.get(i)).getTitle();
            ((XMLTVProgrammePojo) arrayList.get(i)).getDesc();
            try {
                str = new SimpleDateFormat("dd MMM yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(split[0]));
            } catch (ParseException e3) {
                e3.printStackTrace();
                str = "";
            }
            if (str != null && str.equals(this.j)) {
                arrayList2.add(arrayList.get(i));
            }
        }
        a0 a0Var = new a0(arrayList2, 0, false, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, getContext());
        this.f = a0Var;
        this.a.setAdapter(a0Var);
        x(1);
    }

    public final void B() {
        this.h = getActivity().findViewById(a7.f.kh);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.i == null || this.h == null) {
            return;
        }
        TypedValue typedValue = new TypedValue();
        if (this.i.getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, this.i.getResources().getDisplayMetrics());
        }
        for (int i = 0; i < this.h.getChildCount(); i++) {
            if (this.h.getChildAt(i) instanceof ActionMenuView) {
                ((a.a) this.h.getChildAt(i).getLayoutParams()).a = 16;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a7.g.L2, viewGroup, false);
        this.a = inflate.findViewById(a7.f.ub);
        this.c = inflate.findViewById(a7.f.sk);
        this.d = inflate.findViewById(a7.f.wk);
        D.b.d(getActivity());
        setHasOptionsMenu(true);
        B();
        A();
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this.i, NewDashboardActivity.class));
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this.i, SettingsActivity.class));
        }
        if (itemId != a7.f.f || (context = this.i) == null) {
            return false;
        }
        new a.a(context, k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new b()).g(getResources().getString(a7.j.d4), new a()).n();
        return false;
    }

    public final void x(int i) {
        Context context = getContext();
        this.i = context;
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || context == null) {
            return;
        }
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.e = linearLayoutManager;
        this.a.setLayoutManager(linearLayoutManager);
        this.a.u1(i);
        this.a.setItemAnimator(new androidx.recyclerview.widget.c());
    }
}
