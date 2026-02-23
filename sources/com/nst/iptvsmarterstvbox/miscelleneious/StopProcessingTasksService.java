package com.nst.iptvsmarterstvbox.miscelleneious;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.IBinder;
import com.nst.iptvsmarterstvbox.model.database.EPGSourcesModel;
import com.nst.iptvsmarterstvbox.model.database.ImportStatusModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StopProcessingTasksService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        MyApplication.E("StopProcessingTasksService Service Destroyed ");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        MyApplication.E("StopProcessingTasksService Service Started ");
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        MyApplication.E("onTaskRemoved AppConst.PIP_MODE: " + m7.a.p1);
        if (m7.a.p1) {
            m7.a.p1 = false;
            return;
        }
        try {
            if (m7.a.V0.booleanValue() && MyApplication.p().c != null) {
                p0.a.b(this).e(MyApplication.p().c);
            }
            MyApplication.p().I();
            if (Build.VERSION.SDK_INT >= 33) {
                SharedPreferences.Editor edit = getSharedPreferences("downloadStatus", 0).edit();
                edit.putString("downloadStatus", "stopped");
                edit.apply();
                NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancelAll();
                }
            }
            LiveStreamDBHandler liveStreamDBHandler = new LiveStreamDBHandler(getApplicationContext());
            if (m7.a.I0) {
                String str = "0";
                ArrayList activeEPGSource = liveStreamDBHandler.getActiveEPGSource();
                if (activeEPGSource != null && activeEPGSource.size() > 0) {
                    str = String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto());
                }
                try {
                    if (liveStreamDBHandler.getEPGCountWithSourceRef(str) != 0) {
                        liveStreamDBHandler.updateImportStatus("epg", "1", str);
                    } else {
                        liveStreamDBHandler.updateImportStatus("epg", "2", str);
                    }
                } catch (Exception unused) {
                }
            }
            ArrayList arrayList = liveStreamDBHandler.getdateDBStatus();
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (((ImportStatusModel) arrayList.get(i)).getType() == null || !((ImportStatusModel) arrayList.get(i)).getType().equals("live")) {
                        if (((ImportStatusModel) arrayList.get(i)).getType() == null || !((ImportStatusModel) arrayList.get(i)).getType().equals("movies")) {
                            if (((ImportStatusModel) arrayList.get(i)).getType() != null && ((ImportStatusModel) arrayList.get(i)).getType().equals("series") && ((ImportStatusModel) arrayList.get(i)).getStatus().equals("3")) {
                                liveStreamDBHandler.updateImportStatus("series", "2");
                            }
                        } else if (((ImportStatusModel) arrayList.get(i)).getStatus().equals("3")) {
                            liveStreamDBHandler.updateImportStatus("movies", "2");
                        }
                    } else if (((ImportStatusModel) arrayList.get(i)).getStatus().equals("3")) {
                        try {
                            liveStreamDBHandler.updateImportStatus("live", "2");
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        } catch (Exception unused3) {
        }
        stopSelf();
    }
}
