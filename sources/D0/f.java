package d0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class f {
    public final b a;

    public static class a extends b {
        public final TextView a;
        public final d b;
        public boolean c = true;

        public a(TextView textView) {
            this.a = textView;
            this.b = new d(textView);
        }

        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.c ? h(inputFilterArr) : f(inputFilterArr);
        }

        public boolean b() {
            return this.c;
        }

        public void c(boolean z) {
            if (z) {
                l();
            }
        }

        public void d(boolean z) {
            this.c = z;
            l();
            k();
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            return this.c ? m(transformationMethod) : j(transformationMethod);
        }

        public final InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.b;
            return inputFilterArr2;
        }

        public final SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof d) {
                    sparseArray.put(i, inputFilter);
                }
            }
            return sparseArray;
        }

        public final InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray g = g(inputFilterArr);
            if (g.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - g.size()];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (g.indexOfKey(i2) < 0) {
                    inputFilterArr2[i] = inputFilterArr[i2];
                    i++;
                }
            }
            return inputFilterArr2;
        }

        public void i(boolean z) {
            this.c = z;
        }

        public final TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        public final void k() {
            this.a.setFilters(a(this.a.getFilters()));
        }

        public void l() {
            this.a.setTransformationMethod(e(this.a.getTransformationMethod()));
        }

        public final TransformationMethod m(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? transformationMethod : transformationMethod instanceof PasswordTransformationMethod ? transformationMethod : new h(transformationMethod);
        }
    }

    public static class b {
        public abstract InputFilter[] a(InputFilter[] inputFilterArr);

        public abstract boolean b();

        public abstract void c(boolean z);

        public abstract void d(boolean z);

        public abstract TransformationMethod e(TransformationMethod transformationMethod);
    }

    public static class c extends b {
        public final a a;

        public c(TextView textView) {
            this.a = new a(textView);
        }

        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.a.a(inputFilterArr);
        }

        public boolean b() {
            return this.a.b();
        }

        public void c(boolean z) {
            if (f()) {
                return;
            }
            this.a.c(z);
        }

        public void d(boolean z) {
            if (f()) {
                this.a.i(z);
            } else {
                this.a.d(z);
            }
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.a.e(transformationMethod);
        }

        public final boolean f() {
            return !androidx.emoji2.text.e.h();
        }
    }

    public f(TextView textView, boolean z) {
        O.h.g(textView, "textView cannot be null");
        this.a = !z ? new c(textView) : new a(textView);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.a.a(inputFilterArr);
    }

    public boolean b() {
        return this.a.b();
    }

    public void c(boolean z) {
        this.a.c(z);
    }

    public void d(boolean z) {
        this.a.d(z);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.a.e(transformationMethod);
    }
}
