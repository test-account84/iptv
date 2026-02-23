package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpConnection;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class IdleConnectionHandler {
    private final Log log = LogFactory.getLog(getClass());
    private final Map connectionToTimes = new HashMap();

    public static class TimeValues {
        private final long timeAdded;
        private final long timeExpires;

        public TimeValues(long j, long j2, TimeUnit timeUnit) {
            this.timeAdded = j;
            this.timeExpires = j2 > 0 ? j + timeUnit.toMillis(j2) : Long.MAX_VALUE;
        }

        public static /* synthetic */ long access$000(TimeValues timeValues) {
            return timeValues.timeExpires;
        }

        public static /* synthetic */ long access$100(TimeValues timeValues) {
            return timeValues.timeAdded;
        }
    }

    public void add(HttpConnection httpConnection, long j, TimeUnit timeUnit) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Adding connection at: " + currentTimeMillis);
        }
        this.connectionToTimes.put(httpConnection, new TimeValues(currentTimeMillis, j, timeUnit));
    }

    public void closeExpiredConnections() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Checking for expired connections, now: " + currentTimeMillis);
        }
        for (Map.Entry entry : this.connectionToTimes.entrySet()) {
            HttpConnection httpConnection = (HttpConnection) entry.getKey();
            TimeValues timeValues = (TimeValues) entry.getValue();
            if (TimeValues.access$000(timeValues) <= currentTimeMillis) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Closing connection, expired @: " + TimeValues.access$000(timeValues));
                }
                try {
                    httpConnection.close();
                } catch (IOException e) {
                    this.log.debug("I/O error closing connection", e);
                }
            }
        }
    }

    public void closeIdleConnections(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (this.log.isDebugEnabled()) {
            this.log.debug("Checking for connections, idle timeout: " + currentTimeMillis);
        }
        for (Map.Entry entry : this.connectionToTimes.entrySet()) {
            HttpConnection httpConnection = (HttpConnection) entry.getKey();
            long access$100 = TimeValues.access$100((TimeValues) entry.getValue());
            if (access$100 <= currentTimeMillis) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Closing idle connection, connection time: " + access$100);
                }
                try {
                    httpConnection.close();
                } catch (IOException e) {
                    this.log.debug("I/O error closing connection", e);
                }
            }
        }
    }

    public boolean remove(HttpConnection httpConnection) {
        TimeValues timeValues = (TimeValues) this.connectionToTimes.remove(httpConnection);
        if (timeValues != null) {
            return System.currentTimeMillis() <= TimeValues.access$000(timeValues);
        }
        this.log.warn("Removing a connection that never existed!");
        return true;
    }

    public void removeAll() {
        this.connectionToTimes.clear();
    }
}
