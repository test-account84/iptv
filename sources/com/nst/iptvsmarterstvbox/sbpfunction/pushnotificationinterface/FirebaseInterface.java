package com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationinterface;

import com.google.gson.JsonElement;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.AdsLastUpdateResponseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.getAnnouncementsFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.readAnnouncementFirebaseCallback;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface FirebaseInterface {
    void Q0(getAnnouncementsFirebaseCallback getannouncementsfirebasecallback);

    void h(AdsLastUpdateResponseCallback adsLastUpdateResponseCallback);

    void k0(readAnnouncementFirebaseCallback readannouncementfirebasecallback);

    void z(JsonElement jsonElement);
}
