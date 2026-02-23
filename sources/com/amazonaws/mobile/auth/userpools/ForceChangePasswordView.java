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
public class ForceChangePasswordView extends LinearLayout {
    private static final String LOG_TAG = ForgotPasswordView.class.getSimpleName();
    private int backgroundColor;
    private BackgroundDrawable backgroundDrawable;
    private Button confirmButton;
    private String fontFamily;
    private FormView forceChangePassForm;
    private boolean fullScreenBackgroundColor;
    private EditText passwordEditText;
    private SplitBackgroundDrawable splitBackgroundDrawable;
    private Typeface typeFace;

    public ForceChangePasswordView(Context context) {
        this(context, null);
    }

    private void setupBackground() {
        ViewGroup parent;
        Drawable drawable;
        if (this.fullScreenBackgroundColor) {
            parent = getParent();
            drawable = this.backgroundDrawable;
        } else {
            this.splitBackgroundDrawable.setSplitPointDistanceFromTop(this.forceChangePassForm.getTop() + (this.forceChangePassForm.getMeasuredHeight() / 2));
            parent = getParent();
            drawable = this.splitBackgroundDrawable;
        }
        parent.setBackgroundDrawable(drawable);
    }

    private void setupConfirmButtonColor() {
        Button findViewById = findViewById(R.id.force_change_password_button);
        this.confirmButton = findViewById;
        findViewById.setBackgroundDrawable(DisplayUtils.getRoundedRectangleBackground(UserPoolFormConstants.FORM_BUTTON_CORNER_RADIUS, -12215809));
        LinearLayout.LayoutParams layoutParams = this.confirmButton.getLayoutParams();
        layoutParams.setMargins(this.forceChangePassForm.getFormShadowMargin(), layoutParams.topMargin, this.forceChangePassForm.getFormShadowMargin(), layoutParams.bottomMargin);
    }

    private void setupFontFamily() {
        if (this.typeFace != null) {
            Log.d(LOG_TAG, "Setup font in ForceChangePasswordView: " + this.fontFamily);
            this.passwordEditText.setTypeface(this.typeFace);
        }
    }

    public String getPassword() {
        return this.passwordEditText.getText().toString();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        FormView findViewById = findViewById(R.id.force_change_password_form);
        this.forceChangePassForm = findViewById;
        this.passwordEditText = findViewById.addFormField(getContext(), 129, getContext().getString(R.string.sign_in_password));
        setupConfirmButtonColor();
        setupFontFamily();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setupBackground();
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min((int) (View.MeasureSpec.getSize(i) * 0.85d), UserPoolFormConstants.MAX_FORM_WIDTH_IN_PIXELS), Integer.MIN_VALUE), i2);
    }

    public ForceChangePasswordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForceChangePasswordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ForgotPasswordView);
            obtainStyledAttributes.getInt(R.styleable.ForgotPasswordView_forgotPasswordViewBackgroundColor, -12303292);
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
