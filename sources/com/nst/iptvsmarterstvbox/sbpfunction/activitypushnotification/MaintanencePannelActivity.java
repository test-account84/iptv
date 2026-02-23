package com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification;

import a7.c;
import a7.e;
import a7.f;
import a7.g;
import a7.j;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import com.google.gson.JsonObject;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.webrequest.RetrofitPost;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.SBPAdvertisementsMaintanceCallBack;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AdvertisementListSingleton;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import m7.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MaintanencePannelActivity extends b {
    public TextView d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public LinearLayout h;
    public long i;
    public int j;

    public class 1 implements View.OnFocusChangeListener {
        public 1() {
        }

        public void onFocusChange(View view, boolean z) {
            LinearLayout y1;
            Resources resources;
            int i;
            TextView x1 = MaintanencePannelActivity.x1(MaintanencePannelActivity.this);
            if (z) {
                x1.setTextColor(MaintanencePannelActivity.this.getResources().getColor(c.G));
                y1 = MaintanencePannelActivity.y1(MaintanencePannelActivity.this);
                resources = MaintanencePannelActivity.this.getResources();
                i = e.F;
            } else {
                x1.setTextColor(MaintanencePannelActivity.this.getResources().getColor(c.a));
                y1 = MaintanencePannelActivity.y1(MaintanencePannelActivity.this);
                resources = MaintanencePannelActivity.this.getResources();
                i = e.y;
            }
            y1.setBackground(resources.getDrawable(i));
        }
    }

    public class 2 implements Callback {
        public 2() {
        }

        public void onFailure(Call call, Throwable th) {
            MaintanencePannelActivity.z1(MaintanencePannelActivity.this).setVisibility(8);
            MaintanencePannelActivity maintanencePannelActivity = MaintanencePannelActivity.this;
            Toast.makeText(maintanencePannelActivity, maintanencePannelActivity.getResources().getString(j.e7), 0).show();
        }

        public void onResponse(Call call, Response response) {
            MaintanencePannelActivity.z1(MaintanencePannelActivity.this).setVisibility(8);
            if (response.isSuccessful() && response.body() != null && ((SBPAdvertisementsMaintanceCallBack) response.body()).d() != null && ((SBPAdvertisementsMaintanceCallBack) response.body()).e() != null && ((SBPAdvertisementsMaintanceCallBack) response.body()).d().equals("success")) {
                if (((SBPAdvertisementsMaintanceCallBack) response.body()).b() == null || !((SBPAdvertisementsMaintanceCallBack) response.body()).b().equalsIgnoreCase("on")) {
                    SharepreferenceDBHandler.setMaintanceModeState(false, MaintanencePannelActivity.this.getApplicationContext());
                    MaintanencePannelActivity.this.finish();
                } else {
                    SharepreferenceDBHandler.setMaintanceModeState(true, MaintanencePannelActivity.this.getApplicationContext());
                }
                String a = ((SBPAdvertisementsMaintanceCallBack) response.body()).a();
                String c = ((SBPAdvertisementsMaintanceCallBack) response.body()).c();
                if (a != null) {
                    SharepreferenceDBHandler.setMaintanceModeFooterMessage(a, MaintanencePannelActivity.this.getApplicationContext());
                }
                if (c != null) {
                    SharepreferenceDBHandler.setMaintanceModeMessage(c, MaintanencePannelActivity.this.getApplicationContext());
                }
            }
            AdvertisementListSingleton.b().a().clear();
        }
    }

    public static /* synthetic */ void u1(MaintanencePannelActivity maintanencePannelActivity, View view) {
        maintanencePannelActivity.A1(view);
    }

    public static /* synthetic */ TextView x1(MaintanencePannelActivity maintanencePannelActivity) {
        return maintanencePannelActivity.g;
    }

    public static /* synthetic */ LinearLayout y1(MaintanencePannelActivity maintanencePannelActivity) {
        return maintanencePannelActivity.e;
    }

    public static /* synthetic */ LinearLayout z1(MaintanencePannelActivity maintanencePannelActivity) {
        return maintanencePannelActivity.h;
    }

    public final /* synthetic */ void A1(View view) {
        try {
            this.h.setVisibility(0);
            w1();
        } catch (Exception unused) {
            Toast.makeText(this, "Something went Wrong", 0).show();
        }
    }

    public void onBackPressed() {
        Log.e("honey", "onBackPressed: ");
        if (this.i + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finishAffinity();
            finish();
        } else {
            try {
                Toast.makeText(getBaseContext(), getResources().getString(j.F5), 0).show();
            } catch (Exception unused) {
            }
        }
        this.i = System.currentTimeMillis();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.X);
        this.d = findViewById(f.db);
        this.e = findViewById(f.ii);
        this.f = findViewById(f.Um);
        this.g = findViewById(f.sm);
        this.h = findViewById(f.A9);
        if (!SharepreferenceDBHandler.getMaintanceModeMessage(getApplicationContext()).equalsIgnoreCase("")) {
            this.d.setText(SharepreferenceDBHandler.getMaintanceModeMessage(getApplicationContext()));
        }
        if (!SharepreferenceDBHandler.getMaintanceModeFooterMessage(getApplicationContext()).equalsIgnoreCase("")) {
            this.f.setText(SharepreferenceDBHandler.getMaintanceModeFooterMessage(getApplicationContext()));
        }
        this.e.setOnFocusChangeListener(new 1());
        this.e.setOnClickListener(new a(this));
    }

    public void v1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.j = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    public final void w1() {
        Retrofit P = w.P(this);
        if (P != null) {
            RetrofitPost retrofitPost = (RetrofitPost) P.create(RetrofitPost.class);
            String format = new SimpleDateFormat("yyyy-MM").format(new Date());
            v1();
            String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("a", m7.a.S0);
            jsonObject.addProperty("s", m7.a.T0);
            jsonObject.addProperty("r", b7.b.b);
            jsonObject.addProperty("d", format);
            jsonObject.addProperty("sc", o0);
            jsonObject.addProperty("action", m7.a.c1);
            retrofitPost.getSBPAdvertisementsMaintance(jsonObject).enqueue(new 2());
        }
    }
}
