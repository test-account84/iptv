package com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters;

import a7.b;
import a7.e;
import a7.f;
import a7.g;
import a7.j;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.activities.BuyNowActivity;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.InvoicesModelClass;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UnpaidAdapter extends RecyclerView.g {
    public Context d;
    public List e;

    public class 1 implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;

        public 1(String str, String str2) {
            this.a = str;
            this.c = str2;
        }

        public void onClick(View view) {
            Intent intent = new Intent(UnpaidAdapter.this.d, BuyNowActivity.class);
            intent.setAction("Invoice_action");
            intent.putExtra("invoice_id", this.a);
            intent.putExtra("status", this.c);
            UnpaidAdapter.this.d.startActivity(intent);
        }
    }

    public class 2 implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;

        public 2(String str, String str2) {
            this.a = str;
            this.c = str2;
        }

        public void onClick(View view) {
            Intent intent = new Intent(UnpaidAdapter.this.d, BuyNowActivity.class);
            intent.setAction("Invoice_action");
            intent.putExtra("invoice_id", this.a);
            intent.putExtra("status", this.c);
            UnpaidAdapter.this.d.startActivity(intent);
        }
    }

    public class ViewHolder extends RecyclerView.D {
        public CardView A;
        public TextView B;
        public TextView C;
        public TextView D;
        public TextView E;
        public final int t;
        public Animation u;
        public Animation v;
        public ImageView w;
        public LinearLayout x;
        public RelativeLayout y;
        public LinearLayout z;

        public ViewHolder(View view) {
            super(view);
            this.t = 200;
            this.w = view.findViewById(f.B4);
            this.C = view.findViewById(f.Fj);
            this.D = view.findViewById(f.Gj);
            this.E = view.findViewById(f.Hj);
            this.x = view.findViewById(f.n6);
            this.z = view.findViewById(f.g8);
            this.y = view.findViewById(f.gf);
            this.A = view.findViewById(f.F1);
            this.B = view.findViewById(f.Ij);
            this.u = AnimationUtils.loadAnimation(UnpaidAdapter.this.d, b.m);
            this.v = AnimationUtils.loadAnimation(UnpaidAdapter.this.d, b.l);
        }
    }

    public class focusChange implements View.OnFocusChangeListener {
        public final View a;

        public focusChange(View view) {
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
                f = z ? 1.01f : 1.0f;
                b(f);
                c(f);
                Log.e("id is", "" + this.a.getTag());
                view2 = this.a;
                i = e.o2;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.01f : 1.0f;
                b(f);
                c(f);
                a(z);
                view2 = this.a;
                i = e.y2;
            }
            view2.setBackgroundResource(i);
        }
    }

    public UnpaidAdapter(Context context, List list) {
        this.d = context;
        this.e = list;
    }

    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void E(ViewHolder viewHolder, int i) {
        List list = this.e;
        if (list != null && !list.isEmpty() && this.e.size() > 0) {
            String a = ((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).a();
            if (a == null || a.isEmpty() || a.equalsIgnoreCase("")) {
                viewHolder.D.setText(j.b);
            } else {
                viewHolder.C.setText(a);
            }
            String b = ((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).b();
            if (b == null || b.isEmpty() || b.equalsIgnoreCase("")) {
                viewHolder.D.setText(j.b);
            } else {
                viewHolder.D.setText(b);
            }
        }
        String e = ((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).e();
        if (e == null || e.equalsIgnoreCase("") || e.isEmpty()) {
            viewHolder.E.setText(j.b);
        } else {
            viewHolder.E.setText(ClientSharepreferenceHandler.d(this.d) + e + ClientSharepreferenceHandler.e(this.d));
        }
        String c = ((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).c();
        if (c == null || c.isEmpty() || c.equalsIgnoreCase("")) {
            viewHolder.B.setText(this.d.getResources().getString(j.L3));
        } else {
            viewHolder.B.setText("#" + c);
        }
        String c2 = ((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).c();
        String d = ((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).d();
        viewHolder.x.setOnClickListener(new 1(c2, d));
        viewHolder.A.setOnClickListener(new 2(c2, d));
        CardView cardView = viewHolder.A;
        cardView.setOnFocusChangeListener(new focusChange(cardView));
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public ViewHolder L(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.d).inflate(g.V3, viewGroup, false));
    }

    public int n() {
        return this.e.size();
    }
}
