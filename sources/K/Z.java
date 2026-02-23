package k;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class z {
    public TextView a;
    public TextClassifier b;

    public static final class a {
        public static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    public z(TextView textView) {
        this.a = (TextView) O.h.f(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.b;
        return textClassifier == null ? a.a(this.a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.b = textClassifier;
    }
}
