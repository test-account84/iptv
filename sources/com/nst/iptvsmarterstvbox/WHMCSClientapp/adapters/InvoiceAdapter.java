package com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.activities.BuyNowActivity;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.InvoicesModelClass;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InvoiceAdapter extends RecyclerView.g {
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
            Intent intent = new Intent(InvoiceAdapter.j0(InvoiceAdapter.this), BuyNowActivity.class);
            intent.setAction("Invoice_action");
            intent.putExtra("invoice_id", this.a);
            intent.putExtra("status", this.c);
            InvoiceAdapter.j0(InvoiceAdapter.this).startActivity(intent);
        }
    }

    public class ViewHolder extends RecyclerView.D {
        public LinearLayout t;
        public CardView u;
        public TextView v;
        public TextView w;
        public TextView x;

        public ViewHolder(View view) {
            super(view);
            this.v = view.findViewById(f.Fj);
            this.w = view.findViewById(f.Gj);
            this.x = view.findViewById(f.Hj);
            this.t = view.findViewById(f.n6);
            this.u = view.findViewById(f.F1);
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
                i = e.s2;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.01f : 1.0f;
                b(f);
                c(f);
                a(z);
                view2 = this.a;
                i = e.r2;
            }
            view2.setBackgroundResource(i);
        }
    }

    public static /* synthetic */ Context j0(InvoiceAdapter invoiceAdapter) {
        return invoiceAdapter.d;
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void E(ViewHolder viewHolder, int i) {
        String a = ((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).a();
        if (a == null || a.equalsIgnoreCase("")) {
            viewHolder.v.setText(j.b);
        } else {
            viewHolder.v.setText(a);
        }
        String b = ((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).b();
        if (b == null || b.equalsIgnoreCase("")) {
            viewHolder.w.setText(j.b);
        } else {
            viewHolder.w.setText(b);
        }
        String e = ((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).e();
        if (e == null || e.equalsIgnoreCase("")) {
            viewHolder.x.setText(j.b);
        } else {
            viewHolder.x.setText(ClientSharepreferenceHandler.d(this.d) + e + ClientSharepreferenceHandler.e(this.d));
        }
        viewHolder.t.setOnClickListener(new 1(((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).c(), ((InvoicesModelClass.Invoices.Invoice) this.e.get(i)).d()));
        CardView cardView = viewHolder.u;
        cardView.setOnFocusChangeListener(new focusChange(cardView));
    }

    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public ViewHolder L(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.d).inflate(g.V3, viewGroup, false));
    }

    public int n() {
        return this.e.size();
    }
}
