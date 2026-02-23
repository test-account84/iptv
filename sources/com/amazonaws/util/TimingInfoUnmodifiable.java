package com.amazonaws.util;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class TimingInfoUnmodifiable extends TimingInfo {
    public TimingInfoUnmodifiable(Long l, long j, Long l2) {
        super(l, j, l2);
    }

    public TimingInfo endTiming() {
        throw new UnsupportedOperationException();
    }

    public void setEndTime(long j) {
        throw new UnsupportedOperationException();
    }

    public void setEndTimeNano(long j) {
        throw new UnsupportedOperationException();
    }
}
