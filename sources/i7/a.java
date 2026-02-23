package I7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.vpn.activities.ProfileActivity;
import com.squareup.picasso.t;
import de.blinkt.openvpn.LaunchVPN;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a extends RecyclerView.g {
    public Context d;
    public ArrayList e;
    public J7.a f;
    public ProfileActivity g;
    public PopupWindow h;
    public String i = "";

    public class b implements View.OnLongClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ k c;
        public final /* synthetic */ String d;

        public b(int i, k kVar, String str) {
            this.a = i;
            this.c = kVar;
            this.d = str;
        }

        public boolean onLongClick(View view) {
            a aVar = a.this;
            a.k0(aVar, ((L7.a) a.j0(aVar).get(this.a)).j(), this.c, this.d, a.j0(a.this), this.a);
            return true;
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;

        public c(int i, String str) {
            this.a = i;
            this.c = str;
        }

        public void onClick(View view) {
            Intent intent;
            if (!((L7.a) a.j0(a.this).get(this.a)).j().equals("1")) {
                intent = new Intent(a.l0(a.this), LaunchVPN.class);
            } else {
                if (((L7.a) a.j0(a.this).get(this.a)).i().equals("") || ((L7.a) a.j0(a.this).get(this.a)).h().equals("")) {
                    a aVar = a.this;
                    a.m0(aVar, this.c, a.j0(aVar), this.a);
                    return;
                }
                intent = new Intent(a.l0(a.this), LaunchVPN.class);
            }
            intent.putExtra("vpnProfile", (Serializable) a.j0(a.this).get(this.a));
            a.l0(a.this).startActivity(intent);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            a.n0(a.this).dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            a.n0(a.this).dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ L7.a a;
        public final /* synthetic */ String[] c;
        public final /* synthetic */ String[] d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ EditText f;

        public f(L7.a aVar, String[] strArr, String[] strArr2, EditText editText, EditText editText2) {
            this.a = aVar;
            this.c = strArr;
            this.d = strArr2;
            this.e = editText;
            this.f = editText2;
        }

        public final boolean a() {
            Context l0;
            Resources resources;
            int i;
            this.c[0] = String.valueOf(this.e.getText());
            this.d[0] = String.valueOf(this.f.getText());
            String str = this.c[0];
            if (str == null || !str.equals("")) {
                String str2 = this.d[0];
                if (str2 == null || !str2.equals("")) {
                    String str3 = this.c[0];
                    return (str3 == null || this.d[0] == null || str3.equals("") || this.d[0].equals("")) ? false : true;
                }
                l0 = a.l0(a.this);
                resources = a.l0(a.this).getResources();
                i = a7.j.v1;
            } else {
                l0 = a.l0(a.this);
                resources = a.l0(a.this).getResources();
                i = a7.j.A1;
            }
            Toast.makeText(l0, resources.getString(i), 1).show();
            return false;
        }

        public void onClick(View view) {
            if (a()) {
                this.a.v(this.c[0]);
                this.a.u(this.d[0]);
                a.p0(a.this).o(this.a);
                a.n0(a.this).dismiss();
                Intent intent = new Intent(a.l0(a.this), LaunchVPN.class);
                intent.putExtra("vpnProfile", this.a);
                a.l0(a.this).startActivity(intent);
            }
        }
    }

    public class g implements PopupMenu.OnMenuItemClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ int c;

        public g(String str, ArrayList arrayList, int i) {
            this.a = str;
            this.b = arrayList;
            this.c = i;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() == a7.f.O2) {
                a.m0(a.this, this.a, this.b, this.c);
                return false;
            }
            if (menuItem.getItemId() != a7.f.H2) {
                return false;
            }
            a.q0(a.this, this.a, this.b, this.c);
            return false;
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            a.n0(a.this).dismiss();
        }
    }

    public class i implements View.OnClickListener {
        public final /* synthetic */ File a;
        public final /* synthetic */ L7.a c;

        public i(File file, L7.a aVar) {
            this.a = file;
            this.c = aVar;
        }

        public void onClick(View view) {
            if (this.a.exists()) {
                this.a.delete();
            }
            a.p0(a.this).i(this.c.c());
            a.l0(a.this).N1();
            a.n0(a.this).dismiss();
        }
    }

    public class j implements View.OnFocusChangeListener {
        public final View a;

        public j(View view) {
            this.a = view;
        }

        public final void a(boolean z) {
            if (z) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{z ? 0.6f : 0.5f});
                ofFloat.setDuration(150L);
                ofFloat.start();
            }
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void c(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            int i;
            if (z) {
                f = z ? 1.05f : 1.0f;
                b(f);
                c(f);
                Log.e("id is", "" + this.a.getTag());
                view2 = this.a;
                i = a7.e.s2;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.05f : 1.0f;
                b(f);
                c(f);
                a(z);
                view2 = this.a;
                i = a7.e.r2;
            }
            view2.setBackgroundResource(i);
        }
    }

    public class k extends RecyclerView.D {
        public TextView t;
        public ImageView u;
        public RelativeLayout v;

        public k(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Zk);
            this.u = view.findViewById(a7.f.V5);
            this.v = view.findViewById(a7.f.Re);
        }
    }

    public a(Context context, ArrayList arrayList, ProfileActivity profileActivity) {
        this.d = context;
        this.e = arrayList;
        this.f = new J7.a(context);
        this.g = profileActivity;
    }

    public static /* synthetic */ ArrayList j0(a aVar) {
        return aVar.e;
    }

    public static /* synthetic */ void k0(a aVar, String str, k kVar, String str2, ArrayList arrayList, int i2) {
        aVar.t0(str, kVar, str2, arrayList, i2);
    }

    public static /* synthetic */ Context l0(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ void m0(a aVar, String str, ArrayList arrayList, int i2) {
        aVar.x0(str, arrayList, i2);
    }

    public static /* synthetic */ PopupWindow n0(a aVar) {
        return aVar.h;
    }

    public static /* synthetic */ J7.a p0(a aVar) {
        return aVar.f;
    }

    public static /* synthetic */ void q0(a aVar, String str, ArrayList arrayList, int i2) {
        aVar.z0(str, arrayList, i2);
    }

    public int n() {
        return this.e.size();
    }

    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void E(k kVar, int i2) {
        String str;
        try {
            str = ((L7.a) this.e.get(i2)).e().substring(0, 1).toUpperCase() + ((L7.a) this.e.get(i2)).e().substring(1);
        } catch (Exception unused) {
            str = "";
        }
        kVar.t.setText(str);
        try {
            if (((L7.a) this.e.get(i2)).b().equals("")) {
                kVar.u.setImageResource(a7.e.L0);
            } else {
                t.q(this.d).l(((L7.a) this.e.get(i2)).b()).h(kVar.u, new a(kVar));
            }
        } catch (Exception unused2) {
            kVar.u.setImageResource(a7.e.L0);
        }
        kVar.v.setOnLongClickListener(new b(i2, kVar, str));
        kVar.v.setOnClickListener(new c(i2, str));
        RelativeLayout relativeLayout = kVar.v;
        relativeLayout.setOnFocusChangeListener(new j(relativeLayout));
        if (i2 == 0) {
            kVar.v.requestFocus();
            kVar.v.requestFocusFromTouch();
        }
    }

    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public k L(ViewGroup viewGroup, int i2) {
        return new k(LayoutInflater.from(this.d).inflate(a7.g.q2, viewGroup, false));
    }

    public final void t0(String str, k kVar, String str2, ArrayList arrayList, int i2) {
        if (this.d != null) {
            PopupMenu popupMenu = new PopupMenu(this.d, kVar.v);
            popupMenu.inflate(a7.h.f);
            popupMenu.getMenu().getItem(0).setVisible(false);
            if (str.equals("1")) {
                popupMenu.getMenu().getItem(1).setVisible(true);
            } else {
                popupMenu.getMenu().getItem(1).setVisible(false);
            }
            popupMenu.setOnMenuItemClickListener(new g(str2, arrayList, i2));
            popupMenu.show();
        }
    }

    public final void x0(String str, ArrayList arrayList, int i2) {
        L7.a aVar = (L7.a) arrayList.get(i2);
        new L7.a();
        try {
            View inflate = ((LayoutInflater) this.d.getSystemService("layout_inflater")).inflate(a7.g.f3, this.d.findViewById(a7.f.Sd));
            PopupWindow popupWindow = new PopupWindow(this.d);
            this.h = popupWindow;
            popupWindow.setContentView(inflate);
            this.h.setWidth(-1);
            this.h.setHeight(-1);
            this.h.setFocusable(true);
            this.h.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.C0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            if (findViewById != null) {
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this.d));
            }
            if (findViewById2 != null) {
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this.d));
            }
            EditText findViewById3 = inflate.findViewById(a7.f.pm);
            EditText findViewById4 = inflate.findViewById(a7.f.om);
            TextView findViewById5 = inflate.findViewById(a7.f.b3);
            ImageView findViewById6 = inflate.findViewById(a7.f.N4);
            findViewById3.setText(aVar.i());
            findViewById4.setText(aVar.h());
            findViewById5.setText(this.d.getResources().getString(a7.j.E8) + " " + str);
            if (this.d.getSharedPreferences("selected_language", 0).getString("selected_language", "English").equalsIgnoreCase("Arabic")) {
                findViewById3.setGravity(21);
                findViewById4.setGravity(21);
            }
            String[] strArr = {""};
            String[] strArr2 = {""};
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new d());
            }
            if (findViewById6 != null) {
                findViewById6.setOnClickListener(new e());
            }
            if (findViewById != null) {
                findViewById.setOnClickListener(new f(aVar, strArr, strArr2, findViewById3, findViewById4));
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    public final void z0(String str, ArrayList arrayList, int i2) {
        try {
            L7.a aVar = (L7.a) arrayList.get(i2);
            File file = new File(aVar.d());
            View inflate = ((LayoutInflater) this.d.getSystemService("layout_inflater")).inflate(a7.g.r2, this.d.findViewById(a7.f.We));
            PopupWindow popupWindow = new PopupWindow(this.d);
            this.h = popupWindow;
            popupWindow.setContentView(inflate);
            this.h.setWidth(-1);
            this.h.setHeight(-1);
            this.h.setFocusable(true);
            this.h.showAtLocation(inflate, 17, 0, 0);
            inflate.findViewById(a7.f.Ai).setText("Are you Sure you want to Delete this Profile?");
            Button findViewById = inflate.findViewById(a7.f.L0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            if (findViewById != null) {
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this.d));
            }
            if (findViewById2 != null) {
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this.d));
            }
            findViewById.requestFocus();
            findViewById2.setOnClickListener(new h());
            findViewById.setOnClickListener(new i(file, aVar));
        } catch (Exception unused) {
        }
    }

    public class a implements com.squareup.picasso.e {
        public final /* synthetic */ k a;

        public a(k kVar) {
            this.a = kVar;
        }

        public void a() {
            this.a.u.setImageResource(a7.e.L0);
        }

        public void onSuccess() {
        }
    }
}
