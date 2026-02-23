package k7;

import P.y;
import a7.j;
import a7.k;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.toolbox.NetworkImageView;
import i7.b;
import k7.a;
import n4.m;
import n4.p;
import p4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends RecyclerView.g implements a.a {
    public static final int j = a7.e.r0;
    public static final int k = a7.e.x0;
    public static final int l = a7.e.F0;
    public static final int m = a7.e.G0;
    public final i7.b d;
    public final Context e;
    public final f f;
    public View.OnClickListener g;
    public d h;
    public com.android.volley.toolbox.a i;

    public class a implements b.d {
        public a() {
        }

        public void a() {
            b.this.w();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            if (view.getTag(j.O5) != null) {
                Log.d("QueueListAdapter", String.valueOf(((p) view.getTag(j.O5)).K()));
            }
            b.j0(b.this, view);
        }
    }

    public class c implements View.OnTouchListener {
        public final /* synthetic */ g a;

        public c(g gVar) {
            this.a = gVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (y.a(motionEvent) != 0) {
                return false;
            }
            b.k0(b.this).k(this.a);
            return false;
        }
    }

    public interface d {
        void a(View view);
    }

    public interface e {
        void a();

        void b();
    }

    public interface f {
        void k(RecyclerView.D d);
    }

    public b(Context context, f fVar) {
        this.e = context.getApplicationContext();
        this.f = fVar;
        i7.b n = i7.b.n(context);
        this.d = n;
        n.z(new a());
        this.g = new b();
        c0(true);
    }

    public static /* synthetic */ void j0(b bVar, View view) {
        bVar.q0(view);
    }

    public static /* synthetic */ f k0(b bVar) {
        return bVar.f;
    }

    public static /* synthetic */ int l0() {
        return l;
    }

    public static /* synthetic */ int m0() {
        return m;
    }

    public void f(int i) {
        this.d.y(i);
    }

    public boolean h(int i, int i2) {
        if (i == i2) {
            return false;
        }
        this.d.u(i, i2);
        z(i, i2);
        return true;
    }

    public int n() {
        return i7.b.n(this.e).k();
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void E(g gVar, int i) {
        try {
            Log.d("QueueListAdapter", "[upcoming] onBindViewHolder() for position: " + i);
            p o = this.d.o(i);
            gVar.A.setTag(j.O5, o);
            g.P(gVar).setTag(j.O5, o);
            g.Q(gVar).setTag(j.O5, o);
            g.R(gVar).setTag(j.O5, o);
            gVar.A.setOnClickListener(this.g);
            g.P(gVar).setOnClickListener(this.g);
            g.Q(gVar).setOnClickListener(this.g);
            g.R(gVar).setOnClickListener(this.g);
            m Q = o.L().Q();
            gVar.C.setText(Q.J("com.google.android.gms.cast.metadata.TITLE"));
            gVar.D.setText(Q.J("com.google.android.gms.cast.metadata.SUBTITLE"));
            if (!Q.H().isEmpty()) {
                String uri = ((x4.a) Q.H().get(0)).H().toString();
                com.android.volley.toolbox.a a2 = l7.a.b(this.e).a();
                this.i = a2;
                a2.e(uri, com.android.volley.toolbox.a.i(gVar.z, 0, 0));
                gVar.z.i(uri, this.i);
            }
            gVar.B.setOnTouchListener(new c(gVar));
            if (o == this.d.l()) {
                g.S(gVar, 0);
                s0(g.P(gVar));
            } else if (o == this.d.s()) {
                g.S(gVar, 1);
            } else {
                g.S(gVar, 2);
                g.P(gVar).setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    public long o(int i) {
        return this.d.o(i).K();
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public g L(ViewGroup viewGroup, int i) {
        return new g(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.g4, viewGroup, false));
    }

    public final void q0(View view) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(view);
        }
    }

    public void r0(d dVar) {
        this.h = dVar;
    }

    public final void s0(ImageButton imageButton) {
        int i;
        o4.e c2 = o4.b.e(this.e).c().c();
        i r = c2 == null ? null : c2.r();
        if (r == null) {
            imageButton.setVisibility(8);
            return;
        }
        int n = r.n();
        if (n == 2) {
            i = k;
        } else {
            if (n != 3) {
                imageButton.setVisibility(8);
                return;
            }
            i = j;
        }
        imageButton.setImageResource(i);
    }

    public static class g extends RecyclerView.D implements e {
        public ViewGroup A;
        public ImageView B;
        public TextView C;
        public TextView D;
        public Context t;
        public final ImageButton u;
        public View v;
        public View w;
        public ImageButton x;
        public ImageButton y;
        public NetworkImageView z;

        public g(View view) {
            super(view);
            this.t = view.getContext();
            this.A = view.findViewById(a7.f.m2);
            this.B = view.findViewById(a7.f.N2);
            this.C = view.findViewById(a7.f.bh);
            this.D = view.findViewById(a7.f.ch);
            this.z = view.findViewById(a7.f.o4);
            this.u = view.findViewById(a7.f.xc);
            this.v = view.findViewById(a7.f.o2);
            this.w = view.findViewById(a7.f.t2);
            this.x = view.findViewById(a7.f.yc);
            this.y = view.findViewById(a7.f.Dg);
        }

        public static /* synthetic */ ImageButton P(g gVar) {
            return gVar.u;
        }

        public static /* synthetic */ ImageButton Q(g gVar) {
            return gVar.x;
        }

        public static /* synthetic */ ImageButton R(g gVar) {
            return gVar.y;
        }

        public static /* synthetic */ void S(g gVar, int i) {
            gVar.T(i);
        }

        public final void T(int i) {
            int i2 = a7.e.k;
            this.C.setTextAppearance(this.t, k.d);
            this.D.setTextAppearance(this.t, k.c);
            if (i == 0) {
                i2 = a7.e.k;
                this.v.setVisibility(0);
                this.u.setVisibility(0);
            } else {
                if (i == 1) {
                    this.v.setVisibility(0);
                    this.u.setVisibility(8);
                    this.w.setVisibility(0);
                    this.B.setImageResource(b.m0());
                    i2 = a7.e.l;
                    this.C.setTextAppearance(this.t, k.i);
                    TextView textView = this.C;
                    textView.setTextAppearance(textView.getContext(), k.e);
                    this.D.setTextAppearance(this.t, k.c);
                    this.A.setBackgroundResource(i2);
                }
                this.v.setVisibility(8);
                this.u.setVisibility(8);
            }
            this.w.setVisibility(8);
            this.B.setImageResource(b.l0());
            this.A.setBackgroundResource(i2);
        }

        public void a() {
            this.a.setBackgroundColor(0);
        }

        public void b() {
        }
    }
}
