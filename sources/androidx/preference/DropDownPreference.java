package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import z0.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DropDownPreference extends ListPreference {
    public final Context P;
    public final ArrayAdapter Q;
    public Spinner R;
    public final AdapterView.OnItemSelectedListener S;

    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            if (i >= 0) {
                String charSequence = DropDownPreference.this.P()[i].toString();
                if (charSequence.equals(DropDownPreference.this.Q()) || !DropDownPreference.this.a(charSequence)) {
                    return;
                }
                DropDownPreference.this.S(charSequence);
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.c);
    }

    public void A() {
        this.R.performClick();
    }

    public ArrayAdapter T() {
        return new ArrayAdapter(this.P, 17367049);
    }

    public final void U() {
        this.Q.clear();
        if (N() != null) {
            for (CharSequence charSequence : N()) {
                this.Q.add(charSequence.toString());
            }
        }
    }

    public void y() {
        super.y();
        ArrayAdapter arrayAdapter = this.Q;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.S = new a();
        this.P = context;
        this.Q = T();
        U();
    }
}
