package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import z0.c;
import z0.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SeekBarPreference extends Preference {
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public SeekBar J;
    public TextView K;
    public boolean L;
    public boolean M;
    public boolean N;
    public final SeekBar.OnSeekBarChangeListener O;
    public final View.OnKeyListener P;

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.N || !seekBarPreference.I) {
                    seekBarPreference.P(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.Q(i + seekBarPreference2.F);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.I = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.I = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.F != seekBarPreference.E) {
                seekBarPreference.P(seekBar);
            }
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.L && (i == 21 || i == 22)) || i == 23 || i == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.J;
            if (seekBar != null) {
                return seekBar.onKeyDown(i, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.h);
    }

    public Object C(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    public final void M(int i) {
        int i2 = this.F;
        if (i < i2) {
            i = i2;
        }
        if (i != this.G) {
            this.G = i;
            y();
        }
    }

    public final void N(int i) {
        if (i != this.H) {
            this.H = Math.min(this.G - this.F, Math.abs(i));
            y();
        }
    }

    public final void O(int i, boolean z) {
        int i2 = this.F;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.G;
        if (i > i3) {
            i = i3;
        }
        if (i != this.E) {
            this.E = i;
            Q(i);
            H(i);
            if (z) {
                y();
            }
        }
    }

    public void P(SeekBar seekBar) {
        int progress = this.F + seekBar.getProgress();
        if (progress != this.E) {
            if (a(Integer.valueOf(progress))) {
                O(progress, false);
            } else {
                seekBar.setProgress(this.E - this.F);
                Q(this.E);
            }
        }
    }

    public void Q(int i) {
        TextView textView = this.K;
        if (textView != null) {
            textView.setText(String.valueOf(i));
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.O = new a();
        this.P = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.C0, i, i2);
        this.F = obtainStyledAttributes.getInt(g.F0, 0);
        M(obtainStyledAttributes.getInt(g.D0, 100));
        N(obtainStyledAttributes.getInt(g.G0, 0));
        this.L = obtainStyledAttributes.getBoolean(g.E0, true);
        this.M = obtainStyledAttributes.getBoolean(g.H0, false);
        this.N = obtainStyledAttributes.getBoolean(g.I0, false);
        obtainStyledAttributes.recycle();
    }
}
