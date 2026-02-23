package com.amazonaws.mobile.auth.userpools;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.amazonaws.mobile.auth.core.signin.ui.BackgroundDrawable;
import com.amazonaws.mobile.auth.core.signin.ui.DisplayUtils;
import com.amazonaws.mobile.auth.core.signin.ui.SplitBackgroundDrawable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MFAView extends LinearLayout {
    private static final String LOG_TAG = "MFAView";
    private int backgroundColor;
    private BackgroundDrawable backgroundDrawable;
    private Button confirmButton;
    private String fontFamily;
    private boolean fullScreenBackgroundColor;
    private EditText mfaCodeEditText;
    private FormView mfaForm;
    private SplitBackgroundDrawable splitBackgroundDrawable;
    private Typeface typeFace;

    public MFAView(Context context) {
        this(context, null);
    }

    private void setupBackground() {
        ViewGroup parent;
        Drawable drawable;
        if (this.fullScreenBackgroundColor) {
            parent = getParent();
            drawable = this.backgroundDrawable;
        } else {
            this.splitBackgroundDrawable.setSplitPointDistanceFromTop(this.mfaForm.getTop() + (this.mfaForm.getMeasuredHeight() / 2));
            parent = getParent();
            drawable = this.splitBackgroundDrawable;
        }
        parent.setBackgroundDrawable(drawable);
    }

    private void setupFontFamily() {
        if (this.typeFace != null) {
            Log.d(LOG_TAG, "Setup font in MFAView: " + this.fontFamily);
            this.mfaCodeEditText.setTypeface(this.typeFace);
        }
    }

    private void setupVerifyButtonColor() {
        Button findViewById = findViewById(R.id.mfa_button);
        this.confirmButton = findViewById;
        findViewById.setBackgroundDrawable(DisplayUtils.getRoundedRectangleBackground(UserPoolFormConstants.FORM_BUTTON_CORNER_RADIUS, -12215809));
        LinearLayout.LayoutParams layoutParams = this.confirmButton.getLayoutParams();
        layoutParams.setMargins(this.mfaForm.getFormShadowMargin(), layoutParams.topMargin, this.mfaForm.getFormShadowMargin(), layoutParams.bottomMargin);
    }

    public String getMFACode() {
        return this.mfaCodeEditText.getText().toString();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        FormView findViewById = findViewById(R.id.mfa_form);
        this.mfaForm = findViewById;
        this.mfaCodeEditText = findViewById.addFormField(getContext(), 2, getContext().getString(R.string.forgot_password_input_code_hint));
        setupFontFamily();
        setupVerifyButtonColor();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setupBackground();
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min((int) (View.MeasureSpec.getSize(i) * 0.85d), UserPoolFormConstants.MAX_FORM_WIDTH_IN_PIXELS), Integer.MIN_VALUE), i2);
    }

    public MFAView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MFAView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MFAView);
            obtainStyledAttributes.getInt(R.styleable.MFAView_mfaViewBackgroundColor, -12303292);
            obtainStyledAttributes.recycle();
        }
        String fontFamily = CognitoUserPoolsSignInProvider.getFontFamily();
        this.fontFamily = fontFamily;
        this.typeFace = Typeface.create(fontFamily, 0);
        this.fullScreenBackgroundColor = CognitoUserPoolsSignInProvider.isBackgroundColorFullScreen();
        this.backgroundColor = CognitoUserPoolsSignInProvider.getBackgroundColor();
        if (this.fullScreenBackgroundColor) {
            this.backgroundDrawable = new BackgroundDrawable(this.backgroundColor);
        } else {
            this.splitBackgroundDrawable = new SplitBackgroundDrawable(0, this.backgroundColor);
        }
    }
}
