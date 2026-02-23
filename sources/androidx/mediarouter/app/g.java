package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import t0.j;
import u0.K;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends u {
    public final L a;
    public final c c;
    public Context d;
    public K e;
    public List f;
    public ImageButton g;
    public d h;
    public RecyclerView i;
    public boolean j;
    public L.h k;
    public long l;
    public long m;
    public final Handler n;

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            g.this.updateRoutes((List) message.obj);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            g.this.dismiss();
        }
    }

    public final class c extends L.a {
        public c() {
        }

        public void onRouteAdded(L l, L.h hVar) {
            g.this.refreshRoutes();
        }

        public void onRouteChanged(L l, L.h hVar) {
            g.this.refreshRoutes();
        }

        public void onRouteRemoved(L l, L.h hVar) {
            g.this.refreshRoutes();
        }

        public void onRouteSelected(L l, L.h hVar) {
            g.this.dismiss();
        }
    }

    public final class d extends RecyclerView.g {
        public final ArrayList d = new ArrayList();
        public final LayoutInflater e;
        public final Drawable f;
        public final Drawable g;
        public final Drawable h;
        public final Drawable i;

        public class a extends RecyclerView.D {
            public TextView t;

            public a(View view) {
                super(view);
                this.t = view.findViewById(t0.f.P);
            }

            public void P(b bVar) {
                this.t.setText(bVar.a().toString());
            }
        }

        public class b {
            public final Object a;
            public final int b;

            public b(Object obj) {
                int i;
                this.a = obj;
                if (obj instanceof String) {
                    i = 1;
                } else {
                    if (!(obj instanceof L.h)) {
                        this.b = 0;
                        Log.w("RecyclerAdapter", "Wrong type of data passed to Item constructor");
                        return;
                    }
                    i = 2;
                }
                this.b = i;
            }

            public Object a() {
                return this.a;
            }

            public int b() {
                return this.b;
            }
        }

        public class c extends RecyclerView.D {
            public final View t;
            public final ImageView u;
            public final ProgressBar v;
            public final TextView w;

            public class a implements View.OnClickListener {
                public final /* synthetic */ L.h a;

                public a(L.h hVar) {
                    this.a = hVar;
                }

                public void onClick(View view) {
                    g gVar = g.this;
                    L.h hVar = this.a;
                    gVar.k = hVar;
                    hVar.I();
                    c.this.u.setVisibility(4);
                    c.this.v.setVisibility(0);
                }
            }

            public c(View view) {
                super(view);
                this.t = view;
                this.u = view.findViewById(t0.f.R);
                ProgressBar findViewById = view.findViewById(t0.f.T);
                this.v = findViewById;
                this.w = view.findViewById(t0.f.S);
                i.t(g.this.d, findViewById);
            }

            public void P(b bVar) {
                L.h hVar = (L.h) bVar.a();
                this.t.setVisibility(0);
                this.v.setVisibility(4);
                this.t.setOnClickListener(new a(hVar));
                this.w.setText(hVar.m());
                this.u.setImageDrawable(d.this.k0(hVar));
            }
        }

        public d() {
            this.e = LayoutInflater.from(g.this.d);
            this.f = i.g(g.this.d);
            this.g = i.q(g.this.d);
            this.h = i.m(g.this.d);
            this.i = i.n(g.this.d);
            m0();
        }

        public void E(RecyclerView.D d, int i) {
            int p = p(i);
            b l0 = l0(i);
            if (p == 1) {
                ((a) d).P(l0);
            } else if (p != 2) {
                Log.w("RecyclerAdapter", "Cannot bind item to ViewHolder because of wrong view type");
            } else {
                ((c) d).P(l0);
            }
        }

        public RecyclerView.D L(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new a(this.e.inflate(t0.i.k, viewGroup, false));
            }
            if (i == 2) {
                return new c(this.e.inflate(t0.i.l, viewGroup, false));
            }
            Log.w("RecyclerAdapter", "Cannot create ViewHolder because of wrong view type");
            return null;
        }

        public final Drawable j0(L.h hVar) {
            int f = hVar.f();
            return f != 1 ? f != 2 ? hVar.y() ? this.i : this.f : this.h : this.g;
        }

        public Drawable k0(L.h hVar) {
            Uri j = hVar.j();
            if (j != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(g.this.d.getContentResolver().openInputStream(j), (String) null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException e) {
                    Log.w("RecyclerAdapter", "Failed to load " + j, e);
                }
            }
            return j0(hVar);
        }

        public b l0(int i) {
            return (b) this.d.get(i);
        }

        public void m0() {
            this.d.clear();
            this.d.add(new b(g.this.d.getString(j.e)));
            Iterator it = g.this.f.iterator();
            while (it.hasNext()) {
                this.d.add(new b((L.h) it.next()));
            }
            w();
        }

        public int n() {
            return this.d.size();
        }

        public int p(int i) {
            return ((b) this.d.get(i)).b();
        }
    }

    public static final class e implements Comparator {
        public static final e a = new e();

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(L.h hVar, L.h hVar2) {
            return hVar.m().compareToIgnoreCase(hVar2.m());
        }
    }

    public g(Context context) {
        this(context, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = true;
        this.a.b(this.e, this.c, 1);
        refreshRoutes();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t0.i.j);
        i.s(this.d, this);
        this.f = new ArrayList();
        ImageButton findViewById = findViewById(t0.f.O);
        this.g = findViewById;
        findViewById.setOnClickListener(new b());
        this.h = new d();
        RecyclerView findViewById2 = findViewById(t0.f.Q);
        this.i = findViewById2;
        findViewById2.setAdapter(this.h);
        this.i.setLayoutManager(new LinearLayoutManager(this.d));
        updateLayout();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.j = false;
        this.a.s(this.c);
        this.n.removeMessages(1);
    }

    public boolean onFilterRoute(L.h hVar) {
        return !hVar.w() && hVar.x() && hVar.E(this.e);
    }

    public void onFilterRoutes(List list) {
        int size = list.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            if (!onFilterRoute((L.h) list.get(i))) {
                list.remove(i);
            }
            size = i;
        }
    }

    public void refreshRoutes() {
        if (this.k == null && this.j) {
            ArrayList arrayList = new ArrayList(this.a.m());
            onFilterRoutes(arrayList);
            Collections.sort(arrayList, e.a);
            if (SystemClock.uptimeMillis() - this.m >= this.l) {
                updateRoutes(arrayList);
                return;
            }
            this.n.removeMessages(1);
            Handler handler = this.n;
            handler.sendMessageAtTime(handler.obtainMessage(1, arrayList), this.m + this.l);
        }
    }

    public void setRouteSelector(K k) {
        if (k == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.e.equals(k)) {
            return;
        }
        this.e = k;
        if (this.j) {
            this.a.s(this.c);
            this.a.b(k, this.c, 1);
        }
        refreshRoutes();
    }

    public void updateLayout() {
        getWindow().setLayout(f.c(this.d), f.a(this.d));
    }

    public void updateRoutes(List list) {
        this.m = SystemClock.uptimeMillis();
        this.f.clear();
        this.f.addAll(list);
        this.h.m0();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public g(Context context, int i) {
        Context b2 = i.b(context, i, false);
        super(b2, i.c(b2));
        this.e = K.c;
        this.n = new a();
        Context context2 = getContext();
        this.a = L.j(context2);
        this.c = new c();
        this.d = context2;
        this.l = context2.getResources().getInteger(t0.g.e);
    }
}
