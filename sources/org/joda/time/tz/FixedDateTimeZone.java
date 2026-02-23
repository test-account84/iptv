package org.joda.time.tz;

import j$.util.DesugarTimeZone;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.joda.time.DateTimeZone;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class FixedDateTimeZone extends DateTimeZone {
    private static final long serialVersionUID = -3513011772763289092L;
    private final String iNameKey;
    private final int iStandardOffset;
    private final int iWallOffset;

    public FixedDateTimeZone(String str, String str2, int i, int i2) {
        super(str);
        this.iNameKey = str2;
        this.iWallOffset = i;
        this.iStandardOffset = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDateTimeZone)) {
            return false;
        }
        FixedDateTimeZone fixedDateTimeZone = (FixedDateTimeZone) obj;
        return getID().equals(fixedDateTimeZone.getID()) && this.iStandardOffset == fixedDateTimeZone.iStandardOffset && this.iWallOffset == fixedDateTimeZone.iWallOffset;
    }

    public String getNameKey(long j) {
        return this.iNameKey;
    }

    public int getOffset(long j) {
        return this.iWallOffset;
    }

    public int getOffsetFromLocal(long j) {
        return this.iWallOffset;
    }

    public int getStandardOffset(long j) {
        return this.iStandardOffset;
    }

    public int hashCode() {
        return getID().hashCode() + (this.iStandardOffset * 37) + (this.iWallOffset * 31);
    }

    public boolean isFixed() {
        return true;
    }

    public long nextTransition(long j) {
        return j;
    }

    public long previousTransition(long j) {
        return j;
    }

    public TimeZone toTimeZone() {
        String id = getID();
        if (id.length() != 6 || (!id.startsWith("+") && !id.startsWith("-"))) {
            return new SimpleTimeZone(this.iWallOffset, getID());
        }
        return DesugarTimeZone.getTimeZone("GMT" + getID());
    }
}
