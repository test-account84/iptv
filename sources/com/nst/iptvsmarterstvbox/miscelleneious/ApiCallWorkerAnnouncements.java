package com.nst.iptvsmarterstvbox.miscelleneious;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.getAnnouncementsFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter.FirebasePresenter;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import m7.w;
import y5.b;
import y5.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ApiCallWorkerAnnouncements extends ListenableWorker {
    public Context g;
    public FirebasePresenter h;

    public class a implements FirebasePresenter.OnAnnouncementReceived {
        public final /* synthetic */ e a;

        public a(e eVar) {
            this.a = eVar;
        }

        public void a(getAnnouncementsFirebaseCallback getannouncementsfirebasecallback) {
            Log.e("jaskirat", "success");
            if (getannouncementsfirebasecallback != null) {
                try {
                    if (getannouncementsfirebasecallback.b() != null && getannouncementsfirebasecallback.b().equals("success") && getannouncementsfirebasecallback.c() != null) {
                        if (getannouncementsfirebasecallback.d() == null || getannouncementsfirebasecallback.a() == null || getannouncementsfirebasecallback.a().size() <= 0) {
                            SharepreferenceDBHandler.setAnnouncementsList(null, ApiCallWorkerAnnouncements.s(ApiCallWorkerAnnouncements.this));
                            AnnouncementsSBPSingleton.b().c(null);
                        } else {
                            AnnouncementsSBPSingleton.b().c(getannouncementsfirebasecallback.a());
                            SharepreferenceDBHandler.setAnnouncementsList(getannouncementsfirebasecallback.a(), ApiCallWorkerAnnouncements.s(ApiCallWorkerAnnouncements.this));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Intent intent = new Intent("notification");
            intent.putExtra("noti_announcements", "announcements");
            p0.a.b(ApiCallWorkerAnnouncements.s(ApiCallWorkerAnnouncements.this)).d(intent);
            this.a.v(ListenableWorker.a.c());
        }

        public void b() {
            this.a.v(ListenableWorker.a.a());
        }
    }

    public ApiCallWorkerAnnouncements(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.g = context;
    }

    public static /* synthetic */ Context s(ApiCallWorkerAnnouncements apiCallWorkerAnnouncements) {
        return apiCallWorkerAnnouncements.g;
    }

    public b p() {
        e x = e.x();
        this.h = new FirebasePresenter(this.g, new a(x));
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        if (b7.b.b.equals("")) {
            r();
        }
        this.h.i(m7.a.S0, m7.a.T0, format, w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format), SharepreferenceDBHandler.getDeviceUUID(this.g));
        Log.e("jaskirat", "final exit");
        return x;
    }

    public void r() {
        b7.b.b = String.valueOf(new Random().nextInt(8378600) + 10000);
    }
}
