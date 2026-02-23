package com.nst.iptvsmarterstvbox.model.database;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PlayerResumeDBModel {
    private String eventType;
    private int idAuto;
    private long streamDuration;
    private boolean streamFinish;
    private String streamId;
    private long timeElapsed;

    public PlayerResumeDBModel() {
    }

    public String getEventType() {
        return this.eventType;
    }

    public int getIdAuto() {
        return this.idAuto;
    }

    public long getStreamDuration() {
        return this.streamDuration;
    }

    public String getStreamId() {
        return this.streamId;
    }

    public long getTimeElapsed() {
        return this.timeElapsed;
    }

    public boolean isStreamFinish() {
        return this.streamFinish;
    }

    public void setEventType(String str) {
        this.eventType = str;
    }

    public void setIdAuto(int i) {
        this.idAuto = i;
    }

    public void setStreamDuration(long j) {
        this.streamDuration = j;
    }

    public void setStreamFinish(boolean z) {
        this.streamFinish = z;
    }

    public void setStreamId(String str) {
        this.streamId = str;
    }

    public void setTimeElapsed(long j) {
        this.timeElapsed = j;
    }

    public PlayerResumeDBModel(String str, String str2, boolean z, long j, long j2) {
        this.eventType = str;
        this.streamId = str2;
        this.streamFinish = z;
        this.timeElapsed = j;
        this.streamDuration = j2;
    }
}
