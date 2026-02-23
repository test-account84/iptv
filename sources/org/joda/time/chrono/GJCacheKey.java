package org.joda.time.chrono;

import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class GJCacheKey {
    private final Instant cutoverInstant;
    private final int minDaysInFirstWeek;
    private final DateTimeZone zone;

    public GJCacheKey(DateTimeZone dateTimeZone, Instant instant, int i) {
        this.zone = dateTimeZone;
        this.cutoverInstant = instant;
        this.minDaysInFirstWeek = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GJCacheKey)) {
            return false;
        }
        GJCacheKey gJCacheKey = (GJCacheKey) obj;
        Instant instant = this.cutoverInstant;
        if (instant == null) {
            if (gJCacheKey.cutoverInstant != null) {
                return false;
            }
        } else if (!instant.equals(gJCacheKey.cutoverInstant)) {
            return false;
        }
        if (this.minDaysInFirstWeek != gJCacheKey.minDaysInFirstWeek) {
            return false;
        }
        DateTimeZone dateTimeZone = this.zone;
        DateTimeZone dateTimeZone2 = gJCacheKey.zone;
        if (dateTimeZone == null) {
            if (dateTimeZone2 != null) {
                return false;
            }
        } else if (!dateTimeZone.equals(dateTimeZone2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Instant instant = this.cutoverInstant;
        int hashCode = ((((instant == null ? 0 : instant.hashCode()) + 31) * 31) + this.minDaysInFirstWeek) * 31;
        DateTimeZone dateTimeZone = this.zone;
        return hashCode + (dateTimeZone != null ? dateTimeZone.hashCode() : 0);
    }
}
