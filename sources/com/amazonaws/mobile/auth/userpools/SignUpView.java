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
import android.widget.TextView;
import com.amazonaws.mobile.auth.core.signin.ui.BackgroundDrawable;
import com.amazonaws.mobile.auth.core.signin.ui.DisplayUtils;
import com.amazonaws.mobile.auth.core.signin.ui.SplitBackgroundDrawable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SignUpView extends LinearLayout {
    private static final String LOG_TAG = "SignUpView";
    private int backgroundColor;
    private BackgroundDrawable backgroundDrawable;
    private EditText emailEditText;
    private String fontFamily;
    private boolean fullScreenBackgroundColor;
    private EditText givenNameEditText;
    private EditText passwordEditText;
    private EditText phoneEditText;
    private Button signUpButton;
    private FormView signUpForm;
    private TextView signUpMessage;
    private SplitBackgroundDrawable splitBackgroundDrawable;
    private Typeface typeFace;
    private EditText userNameEditText;

    public SignUpView(Context context) {
        this(context, null);
    }

    private void setupBackground() {
        ViewGroup parent;
        Drawable drawable;
        if (this.fullScreenBackgroundColor) {
            parent = getParent();
            drawable = this.backgroundDrawable;
        } else {
            this.splitBackgroundDrawable.setSplitPointDistanceFromTop(this.signUpForm.getTop() + (this.signUpForm.getMeasuredHeight() / 2));
            parent = getParent();
            drawable = this.splitBackgroundDrawable;
        }
        parent.setBackgroundDrawable(drawable);
    }

    private void setupFontFamily() {
        if (this.typeFace != null) {
            Log.d(LOG_TAG, "Setup font in SignUpView: " + this.fontFamily);
            this.userNameEditText.setTypeface(this.typeFace);
            this.passwordEditText.setTypeface(this.typeFace);
            this.givenNameEditText.setTypeface(this.typeFace);
            this.emailEditText.setTypeface(this.typeFace);
            this.phoneEditText.setTypeface(this.typeFace);
            this.signUpMessage.setTypeface(this.typeFace);
            this.signUpButton.setTypeface(this.typeFace);
        }
    }

    private void setupSignUpButtonBackground() {
        this.signUpButton.setBackgroundDrawable(DisplayUtils.getRoundedRectangleBackground(UserPoolFormConstants.FORM_BUTTON_CORNER_RADIUS, -12215809));
        LinearLayout.LayoutParams layoutParams = this.signUpButton.getLayoutParams();
        layoutParams.setMargins(this.signUpForm.getFormShadowMargin(), layoutParams.topMargin, this.signUpForm.getFormShadowMargin(), layoutParams.bottomMargin);
    }

    public String getEmail() {
        return this.emailEditText.getText().toString();
    }

    public String getGivenName() {
        return this.givenNameEditText.getText().toString();
    }

    public String getPassword() {
        return this.passwordEditText.getText().toString();
    }

    public String getPhone() {
        return this.phoneEditText.getText().toString();
    }

    public String getUserName() {
        return this.userNameEditText.getText().toString();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        FormView findViewById = findViewById(R.id.signup_form);
        this.signUpForm = findViewById;
        this.userNameEditText = findViewById.addFormField(getContext(), 97, getContext().getString(R.string.username_text));
        this.passwordEditText = this.signUpForm.addFormField(getContext(), 129, getContext().getString(R.string.sign_in_password));
        this.givenNameEditText = this.signUpForm.addFormField(getContext(), 97, getContext().getString(R.string.given_name_text));
        this.emailEditText = this.signUpForm.addFormField(getContext(), 33, getContext().getString(R.string.email_address_text));
        this.phoneEditText = this.signUpForm.addFormField(getContext(), 3, getContext().getString(R.string.phone_number_text));
        this.signUpMessage = findViewById(R.id.signup_message);
        this.signUpButton = findViewById(R.id.signup_button);
        setupSignUpButtonBackground();
        setupFontFamily();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setupBackground();
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min((int) (View.MeasureSpec.getSize(i) * 0.85d), UserPoolFormConstants.MAX_FORM_WIDTH_IN_PIXELS), Integer.MIN_VALUE), i2);
    }

    public void setPassword(String str) {
        this.passwordEditText.setText(str);
    }

    public SignUpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignUpView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SignUpView);
            obtainStyledAttributes.getInt(R.styleable.SignUpView_signUpViewBackgroundColor, -12303292);
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
