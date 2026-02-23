package q7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.VodActivityLayout;
import com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSecondSubCategories;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class n0 extends RecyclerView.g {
    public List d;
    public Context e;
    public LiveStreamDBHandler f;
    public List g;
    public List h;
    public int i;
    public int j;

    public class a implements View.OnClickListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(c cVar, String str, String str2) {
            this.a = cVar;
            this.c = str;
            this.d = str2;
        }

        public void onClick(View view) {
            new VodActivityLayout().I1(this.a.w);
            ProgressBar progressBar = this.a.w;
            if (progressBar != null) {
                progressBar.getIndeterminateDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
                this.a.w.setVisibility(0);
            }
            Intent intent = n0.j0(n0.this).getAllMovieCategoriesHavingParentIdNotZero(this.c).size() > 0 ? new Intent(n0.k0(n0.this), VodActivityNewFlowSecondSubCategories.class) : new Intent(n0.k0(n0.this), VodActivityLayout.class);
            intent.putExtra("category_id", this.c);
            intent.putExtra("category_name", this.d);
            n0.k0(n0.this).startActivity(intent);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ TextView c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                n0 n0Var;
                List l0;
                if (!TextUtils.isEmpty(b.this.a)) {
                    if (!n0.l0(n0.this).isEmpty() || n0.l0(n0.this).isEmpty()) {
                        n0Var = n0.this;
                        l0 = n0.l0(n0Var);
                    }
                    if (n0.r0(n0.this) != null && n0.r0(n0.this).size() == 0) {
                        b.this.c.setVisibility(0);
                    }
                    n0 n0Var2 = n0.this;
                    n0.x0(n0Var2, n0.n0(n0Var2));
                    n0.this.w();
                }
                n0Var = n0.this;
                l0 = n0.q0(n0Var);
                n0.s0(n0Var, l0);
                if (n0.r0(n0.this) != null) {
                    b.this.c.setVisibility(0);
                }
                n0 n0Var22 = n0.this;
                n0.x0(n0Var22, n0.n0(n0Var22));
                n0.this.w();
            }
        }

        public b(String str, TextView textView) {
            this.a = str;
            this.c = textView;
        }

        public void run() {
            n0.m0(n0.this, new ArrayList());
            n0.p0(n0.this, this.a.length());
            if (n0.l0(n0.this) != null) {
                n0.l0(n0.this).clear();
            }
            if (TextUtils.isEmpty(this.a)) {
                n0.l0(n0.this).addAll(n0.q0(n0.this));
            } else {
                if ((n0.r0(n0.this) != null && n0.r0(n0.this).size() == 0) || n0.t0(n0.this) > n0.n0(n0.this)) {
                    n0 n0Var = n0.this;
                    n0.s0(n0Var, n0.q0(n0Var));
                }
                if (n0.r0(n0.this) != null) {
                    for (LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel : n0.r0(n0.this)) {
                        if (liveStreamCategoryIdDBModel.getLiveStreamCategoryName() != null && liveStreamCategoryIdDBModel.getLiveStreamCategoryName().toLowerCase().contains(this.a.toLowerCase())) {
                            n0.l0(n0.this).add(liveStreamCategoryIdDBModel);
                        }
                    }
                }
            }
            n0.k0(n0.this).runOnUiThread(new a());
        }
    }

    public static class c extends RecyclerView.D {
        public ImageView t;
        public TextView u;
        public ImageView v;
        public ProgressBar w;
        public RelativeLayout x;
        public RelativeLayout y;
        public TextView z;

        public c(View view) {
            super(view);
            this.t = view.findViewById(a7.f.h6);
            this.u = view.findViewById(a7.f.fk);
            this.v = view.findViewById(a7.f.i5);
            this.w = view.findViewById(a7.f.oc);
            this.x = view.findViewById(a7.f.ze);
            this.y = view.findViewById(a7.f.Re);
            this.z = view.findViewById(a7.f.Vl);
            J(false);
        }
    }

    public class d implements View.OnFocusChangeListener {
        public final View a;

        public d(View view) {
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
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                Log.e("id is", "" + this.a.getTag());
                view2 = this.a;
                i = a7.e.q2;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
                view2 = this.a;
                i = a7.e.p2;
            }
            view2.setBackgroundResource(i);
        }
    }

    public n0() {
    }

    public static /* synthetic */ LiveStreamDBHandler j0(n0 n0Var) {
        return n0Var.f;
    }

    public static /* synthetic */ Context k0(n0 n0Var) {
        return n0Var.e;
    }

    public static /* synthetic */ List l0(n0 n0Var) {
        return n0Var.g;
    }

    public static /* synthetic */ List m0(n0 n0Var, List list) {
        n0Var.g = list;
        return list;
    }

    public static /* synthetic */ int n0(n0 n0Var) {
        return n0Var.j;
    }

    public static /* synthetic */ int p0(n0 n0Var, int i) {
        n0Var.j = i;
        return i;
    }

    public static /* synthetic */ List q0(n0 n0Var) {
        return n0Var.h;
    }

    public static /* synthetic */ List r0(n0 n0Var) {
        return n0Var.d;
    }

    public static /* synthetic */ List s0(n0 n0Var, List list) {
        n0Var.d = list;
        return list;
    }

    public static /* synthetic */ int t0(n0 n0Var) {
        return n0Var.i;
    }

    public static /* synthetic */ int x0(n0 n0Var, int i) {
        n0Var.i = i;
        return i;
    }

    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public void E(c cVar, int i) {
        LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) this.d.get(i);
        String liveStreamCategoryName = liveStreamCategoryIdDBModel.getLiveStreamCategoryName();
        String liveStreamCategoryID = liveStreamCategoryIdDBModel.getLiveStreamCategoryID();
        Bundle bundle = new Bundle();
        bundle.putString("category_id", liveStreamCategoryID);
        bundle.putString("category_name", liveStreamCategoryName);
        if (liveStreamCategoryName != null && !liveStreamCategoryName.equals("") && !liveStreamCategoryName.isEmpty()) {
            cVar.u.setText(liveStreamCategoryName);
        }
        int subCatMovieCount = this.f.getSubCatMovieCount(liveStreamCategoryIdDBModel.getLiveStreamCategoryID(), "movie");
        if (subCatMovieCount == 0 || subCatMovieCount == -1) {
            cVar.z.setText("");
        } else {
            cVar.z.setText(String.valueOf(subCatMovieCount));
        }
        RelativeLayout relativeLayout = cVar.y;
        relativeLayout.setOnFocusChangeListener(new d(relativeLayout));
        cVar.y.setOnClickListener(new a(cVar, liveStreamCategoryID, liveStreamCategoryName));
        if (this.d.size() != 0) {
            cVar.y.setVisibility(0);
        }
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public c L(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.r3, viewGroup, false));
    }

    public void F0(ProgressBar progressBar) {
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public int n() {
        return this.d.size();
    }

    public void z0(String str, TextView textView) {
        new Thread(new b(str, textView)).start();
    }

    public n0(List list, Context context, LiveStreamDBHandler liveStreamDBHandler) {
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.addAll(list);
        this.h = list;
        this.d = list;
        this.e = context;
        this.f = liveStreamDBHandler;
    }
}
