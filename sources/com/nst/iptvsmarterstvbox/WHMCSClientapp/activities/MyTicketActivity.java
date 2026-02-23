package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.f;
import a7.g;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.adapters.TicketAdapter;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiService;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiclientRetrofit;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.TicketModelClass;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MyTicketActivity extends b {
    public RecyclerView d;
    public ImageView e;
    public TextView f;
    public LinearLayout g;
    public LinearLayout h;
    public SpinKitView i;
    public boolean j = false;
    public Context k;
    public RecyclerView.g l;

    public class 1 implements View.OnClickListener {
        public 1() {
        }

        public void onClick(View view) {
            MyTicketActivity.this.startActivity(new Intent(MyTicketActivity.this, OpenTicketActivity.class));
        }
    }

    public class 2 implements Callback {
        public 2() {
        }

        public void onFailure(Call call, Throwable th) {
            Toast.makeText(MyTicketActivity.this, "Network error occured! Please try again", 0).show();
            MyTicketActivity.this.y1(Boolean.FALSE);
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null && response.isSuccessful() && response.body() != null && ((TicketModelClass) response.body()).a().equalsIgnoreCase("success")) {
                MyTicketActivity.this.y1(Boolean.TRUE);
                if (((TicketModelClass) response.body()).b() != null) {
                    List a = ((TicketModelClass) response.body()).b().a();
                    MyTicketActivity myTicketActivity = MyTicketActivity.this;
                    myTicketActivity.d.setLayoutManager(new GridLayoutManager(myTicketActivity, 2));
                    if (a == null || a.size() <= 0) {
                        return;
                    }
                    MyTicketActivity myTicketActivity2 = MyTicketActivity.this;
                    MyTicketActivity.v1(myTicketActivity2, new TicketAdapter(a, MyTicketActivity.w1(myTicketActivity2)));
                    MyTicketActivity myTicketActivity3 = MyTicketActivity.this;
                    myTicketActivity3.d.setAdapter(MyTicketActivity.u1(myTicketActivity3));
                    MyTicketActivity.u1(MyTicketActivity.this).w();
                    return;
                }
            }
            MyTicketActivity.this.y1(Boolean.FALSE);
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
            if (!z) {
                if (z || !this.a.getTag().equals("7")) {
                    return;
                }
                f = z ? 1.25f : 1.0f;
                b(f);
                c(f);
                a(z);
                return;
            }
            Log.e("id is", "" + this.a.getTag());
            if (this.a.getTag().equals("7")) {
                f = z ? 1.25f : 1.0f;
                b(f);
                c(f);
            }
        }
    }

    public static /* synthetic */ RecyclerView.g u1(MyTicketActivity myTicketActivity) {
        return myTicketActivity.l;
    }

    public static /* synthetic */ RecyclerView.g v1(MyTicketActivity myTicketActivity, RecyclerView.g gVar) {
        myTicketActivity.l = gVar;
        return gVar;
    }

    public static /* synthetic */ Context w1(MyTicketActivity myTicketActivity) {
        return myTicketActivity.k;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.e0);
        this.d = findViewById(f.Cd);
        this.e = findViewById(f.f5);
        this.f = findViewById(f.Bk);
        this.g = findViewById(f.F9);
        this.h = findViewById(f.k8);
        this.i = findViewById(f.Mc);
        this.k = this;
        ImageView imageView = this.e;
        imageView.setOnFocusChangeListener(new OnFocusChangeAccountListener(imageView));
        String action = getIntent().getAction();
        if (action != null && action.equalsIgnoreCase("updateticket") && !this.j) {
            x1();
            this.j = true;
        }
        this.e.setOnClickListener(new 1());
    }

    public void onResume() {
        super.onResume();
        if (this.j) {
            return;
        }
        x1();
        this.j = true;
    }

    public final void x1() {
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).b("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "GetTickets", "no", ClientSharepreferenceHandler.a(this.k)).enqueue(new 2());
    }

    public void y1(Boolean bool) {
        (bool.booleanValue() ? this.d : this.f).setVisibility(0);
        this.i.setVisibility(8);
    }
}
