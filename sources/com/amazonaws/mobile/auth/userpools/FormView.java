package com.amazonaws.mobile.auth.userpools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.amazonaws.mobile.auth.core.signin.ui.DisplayUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class FormView extends LinearLayout {
    private final Drawable[] backgroundDrawables;
    private static final int FORM_CORNER_RADIUS = DisplayUtils.dp(8);
    private static final int FIELD_LEFT_RIGHT_MARGIN = DisplayUtils.dp(20);

    public static class Divider extends View {
        final Paint paint;

        public Divider(Context context) {
            super(context);
            this.paint = new Paint();
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.paint.setColor(-3355444);
            canvas.drawRect(getMeasuredWidth() * 0.1f, 0.0f, getMeasuredWidth() * 0.9f, getMeasuredHeight(), this.paint);
        }
    }

    public FormView(Context context) {
        this(context, null);
    }

    private EditText addField(Context context, int i, String str) {
        int i2;
        if (getChildCount() == 0) {
            i2 = getFormShadowMargin();
        } else {
            LinearLayout.LayoutParams layoutParams = getChildAt(getChildCount() - 1).getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, 0);
            addView(new Divider(context), -1, DisplayUtils.dp(1));
            i2 = 0;
        }
        FormEditText formEditText = new FormEditText(context, i, str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        int i3 = FIELD_LEFT_RIGHT_MARGIN;
        layoutParams2.setMargins(i3, i2, i3, getFormShadowMargin());
        addView(formEditText, layoutParams2);
        return formEditText.getEditTextView();
    }

    private ShapeDrawable createRoundedRectShape(int i, int i2, int i3) {
        ShapeDrawable roundedRectangleBackground = DisplayUtils.getRoundedRectangleBackground(i, i2);
        if (i3 < 100) {
            roundedRectangleBackground.setAlpha(i3);
        }
        roundedRectangleBackground.getPaint().setColor(i2);
        return roundedRectangleBackground;
    }

    private Drawable getFormBackground() {
        LayerDrawable layerDrawable = new LayerDrawable(this.backgroundDrawables);
        for (int i = 0; i < this.backgroundDrawables.length; i++) {
            layerDrawable.setLayerInset(i, DisplayUtils.dp(i), DisplayUtils.dp(i), DisplayUtils.dp(i), DisplayUtils.dp(i));
        }
        return layerDrawable;
    }

    public EditText addFormField(Context context, int i, String str) {
        return addField(context, i, str);
    }

    public int getFormShadowMargin() {
        return DisplayUtils.dp(this.backgroundDrawables.length - 1);
    }

    public FormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FormView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z = (context.getResources().getConfiguration().uiMode & 48) == 32;
        int i2 = FORM_CORNER_RADIUS;
        this.backgroundDrawables = new Drawable[]{createRoundedRectShape(i2, -12303292, 10), createRoundedRectShape(i2, -12303292, 20), createRoundedRectShape(i2, -12303292, 30), createRoundedRectShape(i2, -12303292, 50), createRoundedRectShape(i2, -12303292, 80), createRoundedRectShape(i2, z ? -16777216 : -1, 100)};
        setOrientation(1);
        setBackgroundDrawable(getFormBackground());
    }
}
