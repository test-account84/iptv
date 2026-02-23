package com.onesignal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class OSSubscriptionChangedInternalObserver {
    public static void a(OSSubscriptionState oSSubscriptionState) {
        if (F1.t0().c(new n1(F1.Z, (OSSubscriptionState) oSSubscriptionState.clone()))) {
            OSSubscriptionState oSSubscriptionState2 = (OSSubscriptionState) oSSubscriptionState.clone();
            F1.Z = oSSubscriptionState2;
            oSSubscriptionState2.f();
        }
    }

    public void changed(OSSubscriptionState oSSubscriptionState) {
        a(oSSubscriptionState);
    }
}
