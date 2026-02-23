package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import o4.q;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class HelpTextView extends LinearLayout {
    TextView bodyTextView;
    TextView headerTextView;

    @Keep
    public HelpTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setTextAndVisibility(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(true != TextUtils.isEmpty(charSequence) ? 0 : 8);
    }

    @Keep
    public View asView() {
        return this;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        TextView findViewById = findViewById(q.H);
        findViewById.getClass();
        this.headerTextView = findViewById;
        TextView findViewById2 = findViewById(q.G);
        findViewById2.getClass();
        this.bodyTextView = findViewById2;
    }

    @Keep
    public void setText(CharSequence charSequence, CharSequence charSequence2) {
        setTextAndVisibility(this.headerTextView, charSequence);
        setTextAndVisibility(this.bodyTextView, charSequence2);
    }
}
