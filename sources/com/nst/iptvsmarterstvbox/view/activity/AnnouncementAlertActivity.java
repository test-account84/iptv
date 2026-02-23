package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.g;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.JsonElement;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.AnnouncementsData;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.AdsLastUpdateResponseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.getAnnouncementsFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.readAnnouncementFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationinterface.FirebaseInterface;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter.FirebasePresenter;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AnnouncementAlertActivity extends Activity implements FirebaseInterface {
    public TextView a;
    public TextView c;
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public TextView h;
    public TextView i;
    public ImageView j;
    public AnnouncementAlertActivity k;
    public FirebasePresenter l;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            w.j(AnnouncementAlertActivity.this.k);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(AnnouncementAlertActivity.this.k);
                String A = w.A(date);
                TextView textView = AnnouncementAlertActivity.this.i;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = AnnouncementAlertActivity.this.h;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    AnnouncementAlertActivity.this.b();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Q0(getAnnouncementsFirebaseCallback getannouncementsfirebasecallback) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (getannouncementsfirebasecallback != null) {
            try {
                if (getannouncementsfirebasecallback.b() == null || !getannouncementsfirebasecallback.b().equals("success") || getannouncementsfirebasecallback.c() == null) {
                    return;
                }
                if (getannouncementsfirebasecallback.d() == null || getannouncementsfirebasecallback.a() == null || getannouncementsfirebasecallback.a().size() <= 0) {
                    try {
                        SharepreferenceDBHandler.setAnnouncementsList((List) null, this.k);
                        AnnouncementsSBPSingleton.b().c((List) null);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                for (int i = 0; i < SharepreferenceDBHandler.getAnnouncementsList(this.k).size(); i++) {
                    arrayList2.add(((AnnouncementsData) SharepreferenceDBHandler.getAnnouncementsList(this.k).get(i)).getId());
                }
                for (AnnouncementsData announcementsData : getannouncementsfirebasecallback.a()) {
                    if (arrayList2.contains(announcementsData.getId())) {
                        arrayList.add(announcementsData);
                    }
                }
                AnnouncementsSBPSingleton.b().c(arrayList);
                SharepreferenceDBHandler.setAnnouncementsList(arrayList, this.k);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a() {
        b7.b.b = String.valueOf(new Random().nextInt(8378600) + 10000);
    }

    public void b() {
        runOnUiThread(new b());
    }

    public void h(AdsLastUpdateResponseCallback adsLastUpdateResponseCallback) {
    }

    public void k0(readAnnouncementFirebaseCallback readannouncementfirebasecallback) {
        List a2;
        if (readannouncementfirebasecallback != null) {
            try {
                if (readannouncementfirebasecallback.a() == null || !readannouncementfirebasecallback.a().equals("success") || (a2 = AnnouncementsSBPSingleton.b().a()) == null || a2.size() <= 0) {
                    return;
                }
                for (int i = 0; i < a2.size(); i++) {
                    if (((AnnouncementsData) a2.get(i)).getId().equals(this.f)) {
                        AnnouncementsData announcementsData = (AnnouncementsData) a2.get(i);
                        announcementsData.setSeen(1);
                        a2.set(i, announcementsData);
                    }
                }
                AnnouncementsSBPSingleton.b().c(a2);
                SharepreferenceDBHandler.setAnnouncementsList(a2, this.k);
            } catch (Exception unused) {
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.g);
        this.k = this;
        this.h = findViewById(f.E2);
        this.i = findViewById(f.gh);
        this.j = findViewById(f.Xa);
        this.c = findViewById(f.zh);
        this.a = findViewById(f.Ah);
        this.l = new FirebasePresenter(this.k, this);
        Intent intent = getIntent();
        this.d = intent.getStringExtra("Title");
        this.e = intent.getStringExtra("Description");
        this.a.setText(this.d);
        this.c.setText(MyApplication.p().o(this.e));
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
        if (m7.a.V0.booleanValue()) {
            this.f = intent.getStringExtra("Id");
            String stringExtra = intent.getStringExtra("CheckSeen");
            this.g = stringExtra;
            if (!stringExtra.equals("1")) {
                String format = new SimpleDateFormat("yyyy-MM").format(new Date());
                if (b7.b.b.equals("")) {
                    a();
                }
                this.l.h(m7.a.S0, m7.a.T0, format, w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format), SharepreferenceDBHandler.getDeviceUUID(this), this.f);
            }
        }
        this.j.setOnClickListener(new a());
        new Thread(new c()).start();
    }

    public void onResume() {
        super.onResume();
        w.z0(this.k);
    }

    public void z(JsonElement jsonElement) {
    }
}
