package com.amazonaws.mobile.auth.userpools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazonaws.mobile.auth.core.signin.ui.DisplayUtils;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class FormEditText extends LinearLayout {
    private static final int BIT_FOR_SHOWING_PASSWORD = 16;
    private static final int EDIT_TEXT_ID = 3842;
    private static final int TEXT_VIEW_ID = 3841;
    private LinearLayout editFieldLayout;
    private EditText editText;
    private boolean hasSetMinimumSize;
    private TextView showPasswordToggleTextView;
    private TextView textView;
    private static final int TEXT_VIEW_TOP_MARGIN = DisplayUtils.dp(5);
    private static final int EDIT_VIEW_BOTTOM_PADDING = DisplayUtils.dp(5);
    private static final int SHOW_PASSWORD_LEFT_RIGHT_MARGIN = DisplayUtils.dp(5);
    private static final int SHOW_PASSWORD_TOP_MARGIN = DisplayUtils.dp(-5);

    public class 1 implements View.OnClickListener {
        final /* synthetic */ String val$hideText;
        final /* synthetic */ String val$showText;

        public 1(String str, String str2) {
            this.val$showText = str;
            this.val$hideText = str2;
        }

        public void onClick(View view) {
            EditText access$100;
            int inputType;
            CharSequence text = FormEditText.access$000(FormEditText.this).getText();
            FormEditText.access$000(FormEditText.this).setText(text.equals(this.val$showText) ? this.val$hideText : this.val$showText);
            int selectionStart = FormEditText.access$100(FormEditText.this).getSelectionStart();
            int selectionEnd = FormEditText.access$100(FormEditText.this).getSelectionEnd();
            if (text.equals(this.val$showText)) {
                access$100 = FormEditText.access$100(FormEditText.this);
                inputType = FormEditText.access$100(FormEditText.this).getInputType() | 16;
            } else {
                access$100 = FormEditText.access$100(FormEditText.this);
                inputType = FormEditText.access$100(FormEditText.this).getInputType() & (-17);
            }
            access$100.setInputType(inputType);
            FormEditText.access$100(FormEditText.this).setSelection(selectionStart, selectionEnd);
        }
    }

    public class 2 implements TextWatcher {
        public 2() {
        }

        private void handleFloatingTextVisibility() {
            if (FormEditText.access$100(FormEditText.this).getText().length() != 0) {
                FormEditText.access$300(FormEditText.this).setVisibility(0);
                FormEditText.access$100(FormEditText.this).setPadding(0, DisplayUtils.dp(1), 0, DisplayUtils.dp(3) + FormEditText.access$400());
                if (FormEditText.access$000(FormEditText.this) != null) {
                    FormEditText.access$000(FormEditText.this).setVisibility(0);
                    return;
                }
                return;
            }
            if (FormEditText.access$200(FormEditText.this)) {
                FormEditText.access$300(FormEditText.this).setVisibility(8);
            }
            FormEditText.access$100(FormEditText.this).setPadding(0, DisplayUtils.dp(2), 0, DisplayUtils.dp(2) + FormEditText.access$400());
            if (FormEditText.access$000(FormEditText.this) != null) {
                FormEditText.access$000(FormEditText.this).setVisibility(8);
            }
        }

        public void afterTextChanged(Editable editable) {
            handleFloatingTextVisibility();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public FormEditText(Context context, int i, String str) {
        super(context);
        this.showPasswordToggleTextView = null;
        this.hasSetMinimumSize = false;
        setOrientation(1);
        setGravity(16);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setText(str.toUpperCase(Locale.getDefault()));
        this.textView.setId(toViewId(3841));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, TEXT_VIEW_TOP_MARGIN, 0, 0);
        addView(this.textView, layoutParams);
        this.textView.setVisibility(4);
        EditText editText = new EditText(context);
        this.editText = editText;
        editText.setSingleLine();
        this.editText.setInputType(i);
        this.editText.setBackgroundColor(0);
        this.editText.setPadding(0, DisplayUtils.dp(2), 0, DisplayUtils.dp(2) + EDIT_VIEW_BOTTOM_PADDING);
        this.editText.setId(toViewId(3842));
        this.editText.setHint(str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, 0);
        if ((i & 128) > 0) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.editFieldLayout = linearLayout;
            linearLayout.setOrientation(0);
            layoutParams2.gravity = 8388611;
            layoutParams2.weight = 1.0f;
            this.editFieldLayout.addView(this.editText, layoutParams2);
            this.showPasswordToggleTextView = new TextView(context);
            setupShowHidePassword();
            addView(this.editFieldLayout);
        } else {
            addView(this.editText, layoutParams2);
        }
        setupTextChangedListener();
    }

    public static /* synthetic */ TextView access$000(FormEditText formEditText) {
        return formEditText.showPasswordToggleTextView;
    }

    public static /* synthetic */ EditText access$100(FormEditText formEditText) {
        return formEditText.editText;
    }

    public static /* synthetic */ boolean access$200(FormEditText formEditText) {
        return formEditText.hasSetMinimumSize;
    }

    public static /* synthetic */ TextView access$300(FormEditText formEditText) {
        return formEditText.textView;
    }

    public static /* synthetic */ int access$400() {
        return EDIT_VIEW_BOTTOM_PADDING;
    }

    private void setupShowHidePassword() {
        String string = getResources().getString(R.string.sign_in_show_password);
        String string2 = getResources().getString(R.string.sign_in_hide_password);
        this.showPasswordToggleTextView.setText(string);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = SHOW_PASSWORD_LEFT_RIGHT_MARGIN;
        layoutParams.setMargins(i, SHOW_PASSWORD_TOP_MARGIN, i, 0);
        layoutParams.gravity = 8388629;
        this.editFieldLayout.addView(this.showPasswordToggleTextView, layoutParams);
        this.showPasswordToggleTextView.setVisibility(8);
        this.showPasswordToggleTextView.setOnClickListener(new 1(string, string2));
    }

    private void setupTextChangedListener() {
        this.editText.addTextChangedListener(new 2());
    }

    private int toViewId(int i) {
        return i;
    }

    public EditText getEditTextView() {
        return this.editText;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.hasSetMinimumSize) {
            return;
        }
        setMinimumHeight(this.textView.getMeasuredHeight() + TEXT_VIEW_TOP_MARGIN + this.editText.getMeasuredHeight());
        this.textView.setVisibility(8);
        this.hasSetMinimumSize = true;
    }
}
