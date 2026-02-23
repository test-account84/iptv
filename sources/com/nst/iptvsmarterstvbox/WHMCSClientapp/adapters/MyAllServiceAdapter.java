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
import com.nst.iptvsmarterstvbox.WHMCSClientapp.activities.ShowserviceInformationActivity;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.ActiveServiceModelClass;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MyAllServiceAdapter extends RecyclerView.g {
    public Context d;
    public ArrayList e;

    public class 1 implements View.OnClickListener {
        public final /* synthetic */ ViewHolder a;

        public 1(ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        public void onClick(View view) {
            Intent intent = new Intent(MyAllServiceAdapter.this.d, ShowserviceInformationActivity.class);
            intent.putExtra("product", ((ActiveServiceModelClass) MyAllServiceAdapter.this.e.get(this.a.m())).d());
            intent.putExtra("status", ((ActiveServiceModelClass) MyAllServiceAdapter.this.e.get(this.a.m())).i());
            intent.putExtra("Registration_date", ((ActiveServiceModelClass) MyAllServiceAdapter.this.e.get(this.a.m())).h());
            intent.putExtra("next_due_date", ((ActiveServiceModelClass) MyAllServiceAdapter.this.e.get(this.a.m())).e());
            intent.putExtra("recurring_amount", ((ActiveServiceModelClass) MyAllServiceAdapter.this.e.get(this.a.m())).g());
            intent.putExtra("billing_cycle", ((ActiveServiceModelClass) MyAllServiceAdapter.this.e.get(this.a.m())).a());
            intent.putExtra("payment_method", ((ActiveServiceModelClass) MyAllServiceAdapter.this.e.get(this.a.m())).f());
            intent.putExtra("first_time_payment", ((ActiveServiceModelClass) MyAllServiceAdapter.this.e.get(this.a.m())).b());
            MyAllServiceAdapter.this.d.startActivity(intent);
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

    public class ViewHolder extends RecyclerView.D {
        public TextView t;
        public TextView u;
        public TextView v;
        public LinearLayout w;

        public ViewHolder(View view) {
            super(view);
            this.t = view.findViewById(f.fm);
            this.u = view.findViewById(f.Wk);
            this.v = view.findViewById(f.pk);
            this.w = view.findViewById(f.g9);
        }
    }

    public MyAllServiceAdapter(Context context, ArrayList arrayList) {
        this.d = context;
        this.e = arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fc  */
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters.MyAllServiceAdapter.ViewHolder r6, int r7) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters.MyAllServiceAdapter.E(com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters.MyAllServiceAdapter$ViewHolder, int):void");
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public ViewHolder L(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.d).inflate(g.O1, viewGroup, false));
    }

    public int n() {
        return this.e.size();
    }
}
