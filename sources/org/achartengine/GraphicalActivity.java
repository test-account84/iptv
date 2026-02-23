package org.achartengine;

import android.app.Activity;
import android.os.Bundle;
import org.achartengine.chart.AbstractChart;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class GraphicalActivity extends Activity {
    private AbstractChart mChart;
    private GraphicalView mView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        this.mChart = (AbstractChart) extras.getSerializable("chart");
        this.mView = new GraphicalView(this, this.mChart);
        String string = extras.getString("title");
        if (string == null) {
            requestWindowFeature(1);
        } else if (string.length() > 0) {
            setTitle(string);
        }
        setContentView(this.mView);
    }
}
