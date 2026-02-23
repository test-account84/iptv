package com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters;

import a7.e;
import a7.f;
import a7.g;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.activities.ViewTicketActivity;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.TicketModelClass;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TicketAdapter extends RecyclerView.g {
    public List d;
    public Context e;

    public class 1 implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ MyViewHolder c;

        public 1(int i, MyViewHolder myViewHolder) {
            this.a = i;
            this.c = myViewHolder;
        }

        public void onClick(View view) {
            Intent intent = new Intent(TicketAdapter.j0(TicketAdapter.this), ViewTicketActivity.class);
            intent.putExtra("Title", ((TicketModelClass.Tickets.Ticket) TicketAdapter.k0(TicketAdapter.this).get(this.a)).e() + "-" + ((TicketModelClass.Tickets.Ticket) TicketAdapter.k0(TicketAdapter.this).get(this.a)).d());
            intent.putExtra("ticketid", ((TicketModelClass.Tickets.Ticket) TicketAdapter.k0(TicketAdapter.this).get(this.c.m())).a());
            TicketAdapter.j0(TicketAdapter.this).startActivity(intent);
        }
    }

    public class MyViewHolder extends RecyclerView.D {
        public TextView t;
        public TextView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public LinearLayout y;

        public MyViewHolder(View view) {
            super(view);
            this.t = view.findViewById(f.Ci);
            this.u = view.findViewById(f.Rl);
            this.v = view.findViewById(f.Sl);
            this.w = view.findViewById(f.Lj);
            this.x = view.findViewById(f.Pj);
            this.y = view.findViewById(f.g9);
        }
    }

    public class OnFocusChangeAccountListener implements View.OnFocusChangeListener {
        public final View a;

        public OnFocusChangeAccountListener(View view) {
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
                f = z ? 1.04f : 1.0f;
                b(f);
                c(f);
                Log.e("id is", "" + this.a.getTag());
                view2 = this.a;
                i = e.s2;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.04f : 1.0f;
                b(f);
                c(f);
                a(z);
                view2 = this.a;
                i = e.r2;
            }
            view2.setBackgroundResource(i);
        }
    }

    public TicketAdapter(List list, Context context) {
        this.d = list;
        this.e = context;
    }

    public static /* synthetic */ Context j0(TicketAdapter ticketAdapter) {
        return ticketAdapter.e;
    }

    public static /* synthetic */ List k0(TicketAdapter ticketAdapter) {
        return ticketAdapter.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cb  */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters.TicketAdapter.MyViewHolder r6, int r7) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters.TicketAdapter.E(com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters.TicketAdapter$MyViewHolder, int):void");
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public MyViewHolder L(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(g.K4, viewGroup, false));
    }

    public int n() {
        return this.d.size();
    }
}
