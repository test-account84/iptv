package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ab extends bk {
    private final bi component;
    private final bo loggableException;
    private final bj method;
    private final long timestamp;

    public ab(long j, bi biVar, bj bjVar, bo boVar) {
        this.timestamp = j;
        if (biVar == null) {
            throw new NullPointerException("Null component");
        }
        this.component = biVar;
        if (bjVar == null) {
            throw new NullPointerException("Null method");
        }
        this.method = bjVar;
        this.loggableException = boVar;
    }

    public bi component() {
        return this.component;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bk) {
            bk bkVar = (bk) obj;
            if (this.timestamp == bkVar.timestamp() && this.component.equals(bkVar.component()) && this.method.equals(bkVar.method())) {
                bo boVar = this.loggableException;
                bo loggableException = bkVar.loggableException();
                if (boVar != null ? boVar.equals(loggableException) : loggableException == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.timestamp;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.component.hashCode()) * 1000003) ^ this.method.hashCode()) * 1000003;
        bo boVar = this.loggableException;
        return (boVar == null ? 0 : boVar.hashCode()) ^ hashCode;
    }

    public bo loggableException() {
        return this.loggableException;
    }

    public bj method() {
        return this.method;
    }

    public long timestamp() {
        return this.timestamp;
    }

    public String toString() {
        return "InstrumentationData{timestamp=" + this.timestamp + ", component=" + String.valueOf(this.component) + ", method=" + String.valueOf(this.method) + ", loggableException=" + String.valueOf(this.loggableException) + "}";
    }
}
