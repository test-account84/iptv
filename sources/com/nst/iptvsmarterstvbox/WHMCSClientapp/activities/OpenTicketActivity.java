package com.nst.iptvsmarterstvbox.WHMCSClientapp.activities;

import a7.e;
import a7.f;
import a7.g;
import a7.j;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.Clientdatabase.ClientSharepreferenceHandler;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiService;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.interfaces.ApiclientRetrofit;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.DepartmentClass;
import com.nst.iptvsmarterstvbox.WHMCSClientapp.modelclassess.OpenDepartmentClass;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class OpenTicketActivity extends b implements View.OnClickListener {
    public EditText d;
    public TextView e;
    public Spinner f;
    public TextView g;
    public Spinner h;
    public TextView i;
    public EditText j;
    public Button k;
    public Button l;
    public TextView m;
    public TextView n;
    public String[] p;
    public HashMap q;
    public Context r;
    public String s;
    public String t;
    public List o = new ArrayList();
    public Thread u = null;

    public class 1 implements Callback {
        public 1() {
        }

        public void onFailure(Call call, Throwable th) {
            w.X();
            Toast.makeText(OpenTicketActivity.x1(OpenTicketActivity.this), "Network error occured! Please try again", 0).show();
        }

        public void onResponse(Call call, Response response) {
            w.X();
            if (response.body() == null || !((DepartmentClass) response.body()).b().equals("success")) {
                if (response.body() == null || !((DepartmentClass) response.body()).b().equals("error")) {
                    return;
                }
                Toast.makeText(OpenTicketActivity.this.getApplicationContext(), "Error", 0).show();
                return;
            }
            List a = ((DepartmentClass) response.body()).a().a();
            if (a != null) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    OpenTicketActivity.w1(OpenTicketActivity.this).add(((DepartmentClass.Departments.Department) it.next()).b());
                }
                OpenTicketActivity.this.p = new String[a.size()];
                OpenTicketActivity.this.q = new HashMap();
                for (int i = 0; i < a.size(); i++) {
                    OpenTicketActivity.this.q.put(Integer.valueOf(i), String.valueOf(((DepartmentClass.Departments.Department) a.get(i)).a()));
                    OpenTicketActivity.this.p[i] = String.valueOf(((DepartmentClass.Departments.Department) a.get(i)).b());
                }
                if (OpenTicketActivity.x1(OpenTicketActivity.this) == null || OpenTicketActivity.this.f == null) {
                    return;
                }
                OpenTicketActivity openTicketActivity = OpenTicketActivity.this;
                ArrayAdapter arrayAdapter = new ArrayAdapter(openTicketActivity, 17367043, openTicketActivity.p);
                arrayAdapter.setDropDownViewResource(17367049);
                OpenTicketActivity.this.f.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        }
    }

    public class 2 implements Callback {
        public 2() {
        }

        public void onFailure(Call call, Throwable th) {
            w.X();
            Toast.makeText(OpenTicketActivity.x1(OpenTicketActivity.this), "Network error occured! Please try again", 0).show();
        }

        public void onResponse(Call call, Response response) {
            w.X();
            if (!response.isSuccessful() || response.body() == null || !((OpenDepartmentClass) response.body()).a().equals("success")) {
                if (((OpenDepartmentClass) response.body()).a().equals("error")) {
                    Toast.makeText(OpenTicketActivity.this.getApplicationContext(), "Error", 0).show();
                }
            } else {
                Toast.makeText(OpenTicketActivity.this.getApplicationContext(), OpenTicketActivity.x1(OpenTicketActivity.this).getResources().getString(j.V7), 0).show();
                Intent intent = new Intent(OpenTicketActivity.this, MyTicketActivity.class);
                intent.setAction("updateticket");
                intent.setFlags(67108864);
                OpenTicketActivity.this.startActivity(intent);
                OpenTicketActivity.this.finish();
            }
        }
    }

    public class 3 implements Runnable {
        public 3() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(OpenTicketActivity.x1(OpenTicketActivity.this));
                String A = w.A(date);
                TextView textView = OpenTicketActivity.this.m;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = OpenTicketActivity.this.n;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class CountDownRunner implements Runnable {
        public CountDownRunner() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    OpenTicketActivity.this.y1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static class OnFocusChangeAccountListener implements View.OnFocusChangeListener {
        public final View a;
        public final Activity b;

        public OnFocusChangeAccountListener(View view, Activity activity) {
            this.a = view;
            this.b = activity;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            int i;
            if (this.b != null) {
                if (z) {
                    float f = z ? 1.03f : 1.0f;
                    View view2 = this.a;
                    if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                        View view3 = this.a;
                        if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                            View view4 = this.a;
                            if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("3")) {
                                view.setBackground(this.b.getResources().getDrawable(e.I1));
                                return;
                            } else {
                                a(f);
                                b(f);
                                i = e.p;
                            }
                        } else {
                            a(f);
                            b(f);
                            i = e.k1;
                        }
                    } else {
                        a(f);
                        b(f);
                        i = e.h;
                    }
                } else {
                    if (z) {
                        return;
                    }
                    a(1.0f);
                    b(1.0f);
                    View view5 = this.a;
                    if (view5 != null && view5.getTag() != null && this.a.getTag().equals("1")) {
                        view.setBackgroundResource(e.o);
                    }
                    View view6 = this.a;
                    if (view6 != null && view6.getTag() != null && this.a.getTag().equals("2")) {
                        view.setBackgroundResource(e.o);
                    }
                    View view7 = this.a;
                    if (view7 == null || view7.getTag() == null || !this.a.getTag().equals("3")) {
                        return;
                    } else {
                        i = e.o;
                    }
                }
                view.setBackgroundResource(i);
            }
        }
    }

    public static /* synthetic */ List w1(OpenTicketActivity openTicketActivity) {
        return openTicketActivity.o;
    }

    public static /* synthetic */ Context x1(OpenTicketActivity openTicketActivity) {
        return openTicketActivity.r;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == f.M0) {
            z1();
        } else if (id == f.o0) {
            onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.h0);
        this.d = findViewById(f.u3);
        this.e = findViewById(f.Bi);
        this.f = findViewById(f.og);
        this.g = findViewById(f.Xk);
        this.h = findViewById(f.rg);
        this.i = findViewById(f.ck);
        this.j = findViewById(f.h3);
        this.k = findViewById(f.M0);
        this.l = findViewById(f.o0);
        this.m = findViewById(f.gh);
        this.n = findViewById(f.E2);
        this.r = this;
        Button button = this.k;
        button.setOnFocusChangeListener(new OnFocusChangeAccountListener(button, this));
        Button button2 = this.l;
        button2.setOnFocusChangeListener(new OnFocusChangeAccountListener(button2, this));
        Thread thread = this.u;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.u = thread2;
            thread2.start();
        }
        u1();
    }

    public void onPause() {
        super.onPause();
        try {
            Thread thread = this.u;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.u.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super.onResume();
        Thread thread = this.u;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new CountDownRunner());
            this.u = thread2;
            thread2.start();
        }
    }

    public final void u1() {
        w.M0(this);
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).c("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "GetSupportDepartments", "no", ClientSharepreferenceHandler.a(this)).enqueue(new 1());
    }

    public final void v1(String str, String str2, String str3, int i) {
        w.M0(this);
        ((ApiService) ApiclientRetrofit.a().create(ApiService.class)).e("OUBQqC6334OcxjS", "61Ce6WTJP12wy1a", "OpenTicket", str, str3, i, str2).enqueue(new 2());
    }

    public void y1() {
        runOnUiThread(new 3());
    }

    public void z1() {
        Context applicationContext;
        Resources resources;
        int i;
        String str;
        int a = ClientSharepreferenceHandler.a(this.r);
        String trim = this.j.getText().toString().trim();
        this.s = this.f.getSelectedItem().toString();
        this.t = this.h.getSelectedItem().toString();
        String trim2 = this.d.getText().toString().trim();
        if (!trim2.isEmpty()) {
            String str2 = this.s;
            if (str2 == null || !str2.equalsIgnoreCase("")) {
                String str3 = this.t;
                if (str3 != null && str3.equalsIgnoreCase("")) {
                    applicationContext = this.r;
                    str = "Please select priority";
                } else if (trim == null || !trim.isEmpty()) {
                    v1(trim, trim2, (String) this.q.get(Integer.valueOf(this.f.getSelectedItemPosition())), a);
                    return;
                } else {
                    applicationContext = getApplicationContext();
                    resources = this.r.getResources();
                    i = j.s1;
                }
            } else {
                applicationContext = this.r;
                str = "Please select Department";
            }
            Toast.makeText(applicationContext, str, 0).show();
        }
        applicationContext = getApplicationContext();
        resources = this.r.getResources();
        i = j.z1;
        str = resources.getString(i);
        Toast.makeText(applicationContext, str, 0).show();
    }
}
