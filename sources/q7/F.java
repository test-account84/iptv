package q7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.pojo.TMDBCastsPojo;
import com.nst.iptvsmarterstvbox.view.activity.ViewDetailsCastActivity;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class f extends RecyclerView.g {
    public Context d;
    public List e;
    public String f;

    public class b implements View.OnClickListener {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            String str;
            try {
                str = ((TMDBCastsPojo) f.k0(f.this).get(this.a)).getId().toString();
            } catch (Exception unused) {
                str = "0";
            }
            if (str.equals("0")) {
                return;
            }
            f.l0(f.this, str, ((TMDBCastsPojo) f.k0(f.this).get(this.a)).getName(), ((TMDBCastsPojo) f.k0(f.this).get(this.a)).getProfilePath());
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            String str;
            try {
                str = ((TMDBCastsPojo) f.k0(f.this).get(this.a)).getId().toString();
            } catch (Exception unused) {
                str = "0";
            }
            if (str.equals("0")) {
                return;
            }
            f.l0(f.this, str, ((TMDBCastsPojo) f.k0(f.this).get(this.a)).getName(), ((TMDBCastsPojo) f.k0(f.this).get(this.a)).getProfilePath());
        }
    }

    public static class d extends RecyclerView.D {
        public RelativeLayout t;
        public ImageView u;
        public TextView v;

        public d(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Ge);
            this.u = view.findViewById(a7.f.B5);
            this.v = view.findViewById(a7.f.Uh);
            J(false);
        }
    }

    public class e implements View.OnFocusChangeListener {
        public final View a;

        public e(View view) {
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
                f = z ? 1.1f : 1.0f;
                Log.e("id is", "" + this.a.getTag());
                if (this.a.getTag() != null && this.a.getTag().equals("1")) {
                    b(f);
                    view2 = this.a;
                    i = a7.e.h;
                } else {
                    if (this.a.getTag() == null || !this.a.getTag().equals("2")) {
                        return;
                    }
                    b(f);
                    view2 = this.a;
                    i = a7.e.k1;
                }
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(z);
                if ((this.a.getTag() == null || !this.a.getTag().equals("1")) && (this.a.getTag() == null || !this.a.getTag().equals("2"))) {
                    return;
                }
                b(f);
                c(f);
                view2 = this.a;
                i = a7.e.o;
            }
            view2.setBackgroundResource(i);
        }
    }

    public f(List list, Context context, boolean z, String str) {
        this.e = list;
        this.d = context;
        this.f = str;
    }

    public static /* synthetic */ Context j0(f fVar) {
        return fVar.d;
    }

    public static /* synthetic */ List k0(f fVar) {
        return fVar.e;
    }

    public static /* synthetic */ void l0(f fVar, String str, String str2, String str3) {
        fVar.p0(str, str2, str3);
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void E(d dVar, int i) {
        if (this.d != null) {
            String str = "https://image.tmdb.org/t/p/w500/" + ((TMDBCastsPojo) this.e.get(i)).getProfilePath();
            dVar.u.setImageDrawable((Drawable) null);
            if (str.equals("")) {
                dVar.u.setImageDrawable(this.d.getResources().getDrawable(a7.e.B1, (Resources.Theme) null));
            } else {
                com.squareup.picasso.t.q(this.d).l(str).h(dVar.u, new a(dVar));
            }
            dVar.v.setText(((TMDBCastsPojo) this.e.get(i)).getName());
            dVar.v.setVisibility(0);
            dVar.u.setOnClickListener(new b(i));
            dVar.t.setOnClickListener(new c(i));
            RelativeLayout relativeLayout = dVar.t;
            relativeLayout.setOnFocusChangeListener(new e(relativeLayout));
        }
    }

    public int n() {
        return this.e.size();
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public d L(ViewGroup viewGroup, int i) {
        LayoutInflater from;
        int i2;
        if (new u7.a(this.d).A().equals(m7.a.K0)) {
            from = LayoutInflater.from(viewGroup.getContext());
            i2 = a7.g.T1;
        } else {
            from = LayoutInflater.from(viewGroup.getContext());
            i2 = a7.g.S1;
        }
        return new d(from.inflate(i2, viewGroup, false));
    }

    public final void p0(String str, String str2, String str3) {
        if (this.d == null) {
            Log.e("Null hai context", ">>>>>>>>>>>True its Null");
            return;
        }
        Intent intent = new Intent(this.d, ViewDetailsCastActivity.class);
        intent.putExtra("castID", str);
        intent.putExtra("castName", str2);
        intent.putExtra("profilePath", str3);
        intent.putExtra("streamBackdrop", this.f);
        this.d.startActivity(intent);
    }

    public class a implements com.squareup.picasso.e {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        public void a() {
            this.a.u.setImageDrawable(f.j0(f.this).getResources().getDrawable(a7.e.B1, (Resources.Theme) null));
        }

        public void onSuccess() {
        }
    }
}
