package com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters;

import a7.e;
import a7.f;
import a7.g;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.TickedMessageModelClass;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TicketMessageAdapter extends RecyclerView.g {
    public Context d;
    public List e;

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
            View view2;
            int i;
            if (z) {
                b(1.0f);
                c(1.0f);
                Log.e("id is", "" + this.a.getTag());
                view2 = this.a;
                i = e.o2;
            } else {
                if (z) {
                    return;
                }
                float f = z ? 1.01f : 1.0f;
                b(f);
                c(f);
                a(z);
                view2 = this.a;
                i = e.y2;
            }
            view2.setBackgroundResource(i);
        }
    }

    public class ViewHolder extends RecyclerView.D {
        public TextView t;
        public TextView u;
        public TextView v;
        public ImageView w;
        public ImageView x;
        public CardView y;
        public LinearLayout z;

        public ViewHolder(View view) {
            super(view);
            this.t = view.findViewById(f.zi);
            this.u = view.findViewById(f.ck);
            this.v = view.findViewById(f.fm);
            this.w = view.findViewById(f.y4);
            this.x = view.findViewById(f.R4);
            this.z = view.findViewById(f.g9);
            this.y = view.findViewById(f.H1);
        }
    }

    public TicketMessageAdapter(Context context, List list) {
        this.d = context;
        this.e = list;
    }

    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void E(ViewHolder viewHolder, int i) {
        LinearLayout linearLayout;
        String str;
        String d = ((TickedMessageModelClass.Replies.Reply) this.e.get(i)).d();
        if (d == null || d.equalsIgnoreCase("")) {
            viewHolder.x.setVisibility(8);
            viewHolder.w.setVisibility(0);
            viewHolder.v.setText(((TickedMessageModelClass.Replies.Reply) this.e.get(i)).a());
            viewHolder.u.setText(((TickedMessageModelClass.Replies.Reply) this.e.get(i)).c());
            viewHolder.t.setText(((TickedMessageModelClass.Replies.Reply) this.e.get(i)).b());
            linearLayout = viewHolder.z;
            str = "#a5b0c2";
        } else {
            viewHolder.x.setVisibility(0);
            viewHolder.w.setVisibility(8);
            viewHolder.v.setText(d);
            viewHolder.u.setText(((TickedMessageModelClass.Replies.Reply) this.e.get(i)).c());
            viewHolder.t.setText(((TickedMessageModelClass.Replies.Reply) this.e.get(i)).b());
            linearLayout = viewHolder.z;
            str = "#eceef2";
        }
        linearLayout.setBackgroundColor(Color.parseColor(str));
        viewHolder.y.setCardBackgroundColor(Color.parseColor(str));
        LinearLayout linearLayout2 = viewHolder.z;
        linearLayout2.setOnFocusChangeListener(new OnFocusChangeAccountListener(linearLayout2));
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public ViewHolder L(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.d).inflate(g.L4, viewGroup, false));
    }

    public int n() {
        return this.e.size();
    }
}
