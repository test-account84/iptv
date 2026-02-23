package q7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.SearchActivity;
import com.nst.iptvsmarterstvbox.view.activity.SearchActivityLowerSDK;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class q extends RecyclerView.g {
    public ArrayList d;
    public Context e;
    public DatabaseHandler g;
    public Animation h;
    public String i;
    public SharedPreferences m;
    public o4.e n;
    public Handler p;
    public LiveStreamDBHandler r;
    public int x;
    public Boolean f = Boolean.FALSE;
    public String j = "";
    public boolean k = false;
    public int l = -1;
    public String o = "";
    public int s = -1;
    public String u = "";
    public String v = "";
    public int w = 0;
    public ArrayList q = new ArrayList();
    public ArrayList t = new ArrayList();

    public class e implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ k c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;

        public e(int i, k kVar, String str, int i2) {
            this.a = i;
            this.c = kVar;
            this.d = str;
            this.e = i2;
        }

        public void onClick(View view) {
            SearchActivityLowerSDK j0;
            String valueOf;
            SearchActivity j02;
            String valueOf2;
            q.l0(q.this, this.a);
            this.c.v.setBackground(q.j0(q.this).getResources().getDrawable(a7.e.t2));
            if (SharepreferenceDBHandler.getCurrentAPPType(q.j0(q.this)).equals("m3u")) {
                if (Build.VERSION.SDK_INT >= 23) {
                    j02 = (SearchActivity) q.j0(q.this);
                    valueOf2 = String.valueOf(this.d);
                    j02.f2(valueOf2);
                } else {
                    j0 = (SearchActivityLowerSDK) q.j0(q.this);
                    valueOf = String.valueOf(this.d);
                    j0.M(valueOf);
                }
            } else if (Build.VERSION.SDK_INT >= 23) {
                j02 = q.j0(q.this);
                valueOf2 = String.valueOf(this.e);
                j02.f2(valueOf2);
            } else {
                j0 = q.j0(q.this);
                valueOf = String.valueOf(this.e);
                j0.M(valueOf);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                q.j0(q.this).p1(q.k0(q.this));
            } else {
                q.j0(q.this).a(q.k0(q.this));
            }
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ k c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;

        public f(int i, k kVar, String str, int i2) {
            this.a = i;
            this.c = kVar;
            this.d = str;
            this.e = i2;
        }

        public void onClick(View view) {
            SearchActivity j0;
            String valueOf;
            q.l0(q.this, this.a);
            this.c.v.setBackground(q.j0(q.this).getResources().getDrawable(a7.e.t2));
            if (SharepreferenceDBHandler.getCurrentAPPType(q.j0(q.this)).equals("m3u")) {
                if (Build.VERSION.SDK_INT >= 23) {
                    j0 = (SearchActivity) q.j0(q.this);
                    valueOf = String.valueOf(this.d);
                    j0.f2(valueOf);
                }
                q.j0(q.this).M(String.valueOf(this.d));
            } else {
                if (Build.VERSION.SDK_INT >= 23) {
                    j0 = q.j0(q.this);
                    valueOf = String.valueOf(this.e);
                    j0.f2(valueOf);
                }
                q.j0(q.this).M(String.valueOf(this.d));
            }
            if (Build.VERSION.SDK_INT >= 23) {
                q.j0(q.this).p1(q.k0(q.this));
            } else {
                q.j0(q.this).M(String.valueOf(this.d));
            }
        }
    }

    public class g implements View.OnLongClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;

        public g(String str, String str2, String str3, int i) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = i;
        }

        public boolean onLongClick(View view) {
            return true;
        }
    }

    public class h implements View.OnLongClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;

        public h(String str, String str2, String str3, int i) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = i;
        }

        public boolean onLongClick(View view) {
            return true;
        }
    }

    public class i implements View.OnLongClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;

        public i(String str, String str2, String str3, int i) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = i;
        }

        public boolean onLongClick(View view) {
            return true;
        }
    }

    public class j implements View.OnFocusChangeListener {
        public int a;

        public j(int i) {
            this.a = i;
        }

        public void onFocusChange(View view, boolean z) {
            q.this.l = z ? this.a : -1;
        }
    }

    public static class k extends RecyclerView.D {
        public TextView t;
        public RelativeLayout u;
        public ImageView v;
        public CardView w;
        public TextView x;
        public ImageView y;
        public LinearLayout z;

        public k(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Fl);
            this.u = view.findViewById(a7.f.Ge);
            this.v = view.findViewById(a7.f.B5);
            this.w = view.findViewById(a7.f.J1);
            this.x = view.findViewById(a7.f.Ul);
            this.y = view.findViewById(a7.f.g5);
            this.z = view.findViewById(a7.f.O8);
        }
    }

    public q(Context context, ArrayList arrayList, int i2) {
        this.i = "mobile";
        this.x = 0;
        this.e = context;
        this.d = arrayList;
        this.g = new DatabaseHandler(context);
        this.h = AnimationUtils.loadAnimation(context, a7.b.a);
        this.r = new LiveStreamDBHandler(context);
        this.x = i2;
        if (new u7.a(context).A().equals(m7.a.K0)) {
            this.i = "tv";
        } else {
            this.i = "mobile";
        }
        this.p = new Handler(Looper.getMainLooper());
        if (this.i.equals("mobile")) {
            try {
                this.n = o4.b.e(context).c().c();
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ Context j0(q qVar) {
        return qVar.e;
    }

    public static /* synthetic */ int k0(q qVar) {
        return qVar.x;
    }

    public static /* synthetic */ int l0(q qVar, int i2) {
        qVar.x = i2;
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x013c A[Catch: Exception -> 0x025d, TryCatch #1 {Exception -> 0x025d, blocks: (B:3:0x0011, B:5:0x0015, B:7:0x001b, B:9:0x001f, B:11:0x0037, B:12:0x003a, B:14:0x0040, B:15:0x0046, B:67:0x004c, B:18:0x0067, B:20:0x006d, B:21:0x0070, B:23:0x0076, B:24:0x007c, B:26:0x0082, B:27:0x0088, B:29:0x008e, B:30:0x0097, B:34:0x012f, B:36:0x013c, B:38:0x014e, B:39:0x0175, B:41:0x01aa, B:43:0x01c9, B:45:0x01cd, B:46:0x01d5, B:47:0x020c, B:48:0x01d9, B:49:0x01e1, B:50:0x01e5, B:52:0x01e9, B:53:0x01f2, B:54:0x01fb, B:55:0x0154, B:56:0x015a, B:32:0x0102, B:33:0x00fc, B:62:0x00d0, B:72:0x0248, B:74:0x0258, B:60:0x00b3), top: B:2:0x0011, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01aa A[Catch: Exception -> 0x025d, TryCatch #1 {Exception -> 0x025d, blocks: (B:3:0x0011, B:5:0x0015, B:7:0x001b, B:9:0x001f, B:11:0x0037, B:12:0x003a, B:14:0x0040, B:15:0x0046, B:67:0x004c, B:18:0x0067, B:20:0x006d, B:21:0x0070, B:23:0x0076, B:24:0x007c, B:26:0x0082, B:27:0x0088, B:29:0x008e, B:30:0x0097, B:34:0x012f, B:36:0x013c, B:38:0x014e, B:39:0x0175, B:41:0x01aa, B:43:0x01c9, B:45:0x01cd, B:46:0x01d5, B:47:0x020c, B:48:0x01d9, B:49:0x01e1, B:50:0x01e5, B:52:0x01e9, B:53:0x01f2, B:54:0x01fb, B:55:0x0154, B:56:0x015a, B:32:0x0102, B:33:0x00fc, B:62:0x00d0, B:72:0x0248, B:74:0x0258, B:60:0x00b3), top: B:2:0x0011, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01fb A[Catch: Exception -> 0x025d, TryCatch #1 {Exception -> 0x025d, blocks: (B:3:0x0011, B:5:0x0015, B:7:0x001b, B:9:0x001f, B:11:0x0037, B:12:0x003a, B:14:0x0040, B:15:0x0046, B:67:0x004c, B:18:0x0067, B:20:0x006d, B:21:0x0070, B:23:0x0076, B:24:0x007c, B:26:0x0082, B:27:0x0088, B:29:0x008e, B:30:0x0097, B:34:0x012f, B:36:0x013c, B:38:0x014e, B:39:0x0175, B:41:0x01aa, B:43:0x01c9, B:45:0x01cd, B:46:0x01d5, B:47:0x020c, B:48:0x01d9, B:49:0x01e1, B:50:0x01e5, B:52:0x01e9, B:53:0x01f2, B:54:0x01fb, B:55:0x0154, B:56:0x015a, B:32:0x0102, B:33:0x00fc, B:62:0x00d0, B:72:0x0248, B:74:0x0258, B:60:0x00b3), top: B:2:0x0011, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015a A[Catch: Exception -> 0x025d, TryCatch #1 {Exception -> 0x025d, blocks: (B:3:0x0011, B:5:0x0015, B:7:0x001b, B:9:0x001f, B:11:0x0037, B:12:0x003a, B:14:0x0040, B:15:0x0046, B:67:0x004c, B:18:0x0067, B:20:0x006d, B:21:0x0070, B:23:0x0076, B:24:0x007c, B:26:0x0082, B:27:0x0088, B:29:0x008e, B:30:0x0097, B:34:0x012f, B:36:0x013c, B:38:0x014e, B:39:0x0175, B:41:0x01aa, B:43:0x01c9, B:45:0x01cd, B:46:0x01d5, B:47:0x020c, B:48:0x01d9, B:49:0x01e1, B:50:0x01e5, B:52:0x01e9, B:53:0x01f2, B:54:0x01fb, B:55:0x0154, B:56:0x015a, B:32:0x0102, B:33:0x00fc, B:62:0x00d0, B:72:0x0248, B:74:0x0258, B:60:0x00b3), top: B:2:0x0011, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(androidx.recyclerview.widget.RecyclerView.D r20, int r21) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.q.E(androidx.recyclerview.widget.RecyclerView$D, int):void");
    }

    public RecyclerView.D L(ViewGroup viewGroup, int i2) {
        LayoutInflater from;
        int i3;
        if (this.i.equals("tv")) {
            from = LayoutInflater.from(viewGroup.getContext());
            i3 = a7.g.w3;
        } else {
            from = LayoutInflater.from(viewGroup.getContext());
            i3 = a7.g.v3;
        }
        return new k(from.inflate(i3, viewGroup, false));
    }

    public int m0() {
        return this.l;
    }

    public int n() {
        ArrayList arrayList = this.d;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.d.size();
    }

    public int p(int i2) {
        return 0;
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
        }
    }

    public void n0(m7.c cVar) {
    }

    public class a implements com.squareup.picasso.e {
        public final /* synthetic */ k a;

        public a(k kVar) {
            this.a = kVar;
        }

        public void a() {
            com.squareup.picasso.t.q(q.j0(q.this)).l(String.valueOf(q.j0(q.this).getResources().getDrawable(a7.e.B1))).e().b().h(this.a.v, new a());
            this.a.t.setVisibility(0);
        }

        public class a implements com.squareup.picasso.e {
            public a() {
            }

            public void a() {
            }

            public void onSuccess() {
            }
        }

        public void onSuccess() {
        }
    }

    public class b implements com.squareup.picasso.e {
        public b() {
        }

        public void a() {
        }

        public void onSuccess() {
        }
    }

    public class c implements com.squareup.picasso.e {
        public c() {
        }

        public void a() {
        }

        public void onSuccess() {
        }
    }
}
