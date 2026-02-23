package org.achartengine.model;

import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class TimeSeries extends XYSeries {
    public TimeSeries(String str) {
        super(str);
    }

    public synchronized void add(Date date, double d) {
        super.add(date.getTime(), d);
    }

    public double getPadding(double d) {
        return 1.0d;
    }
}
