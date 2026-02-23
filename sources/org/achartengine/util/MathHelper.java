package org.achartengine.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class MathHelper {
    private static final NumberFormat FORMAT = NumberFormat.getNumberInstance();
    public static final double NULL_VALUE = Double.MAX_VALUE;

    private MathHelper() {
    }

    private static double[] computeLabels(double d, double d2, int i) {
        boolean z;
        if (Math.abs(d - d2) < 1.0000000116860974E-7d) {
            return new double[]{d, d, 0.0d};
        }
        if (d > d2) {
            z = true;
            d = d2;
            d2 = d;
        } else {
            z = false;
        }
        double roundUp = roundUp(Math.abs(d - d2) / i);
        double ceil = Math.ceil(d / roundUp) * roundUp;
        double floor = Math.floor(d2 / roundUp) * roundUp;
        return z ? new double[]{floor, ceil, roundUp * (-1.0d)} : new double[]{ceil, floor, roundUp};
    }

    public static List getLabels(double d, double d2, int i) {
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            return arrayList;
        }
        FORMAT.setMaximumFractionDigits(5);
        double[] computeLabels = computeLabels(d, d2, i);
        int i2 = ((int) ((computeLabels[1] - computeLabels[0]) / computeLabels[2])) + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            double d3 = computeLabels[0] + (i3 * computeLabels[2]);
            try {
                NumberFormat numberFormat = FORMAT;
                d3 = numberFormat.parse(numberFormat.format(d3)).doubleValue();
            } catch (ParseException unused) {
            }
            arrayList.add(Double.valueOf(d3));
        }
        return arrayList;
    }

    public static double[] minmax(List list) {
        if (list.size() == 0) {
            return new double[2];
        }
        double doubleValue = ((Double) list.get(0)).doubleValue();
        int size = list.size();
        double d = doubleValue;
        for (int i = 1; i < size; i++) {
            double doubleValue2 = ((Double) list.get(i)).doubleValue();
            doubleValue = Math.min(doubleValue, doubleValue2);
            d = Math.max(d, doubleValue2);
        }
        return new double[]{doubleValue, d};
    }

    private static double roundUp(double d) {
        int floor = (int) Math.floor(Math.log10(d));
        double pow = d * Math.pow(10.0d, -floor);
        if (pow > 5.0d) {
            pow = 10.0d;
        } else if (pow > 2.0d) {
            pow = 5.0d;
        } else if (pow > 1.0d) {
            pow = 2.0d;
        }
        return pow * Math.pow(10.0d, floor);
    }
}
