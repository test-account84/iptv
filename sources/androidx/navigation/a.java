package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.navigation.s;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends s {
    public Context a;
    public Activity b;

    public static class a extends k {
        public Intent k;
        public String l;

        public a(s sVar) {
            super(sVar);
        }

        public final ComponentName A() {
            Intent intent = this.k;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        public final String B() {
            return this.l;
        }

        public final Intent D() {
            return this.k;
        }

        public final a E(String str) {
            if (this.k == null) {
                this.k = new Intent();
            }
            this.k.setAction(str);
            return this;
        }

        public final a F(ComponentName componentName) {
            if (this.k == null) {
                this.k = new Intent();
            }
            this.k.setComponent(componentName);
            return this;
        }

        public final a H(Uri uri) {
            if (this.k == null) {
                this.k = new Intent();
            }
            this.k.setData(uri);
            return this;
        }

        public final a I(String str) {
            this.l = str;
            return this;
        }

        public final a J(String str) {
            if (this.k == null) {
                this.k = new Intent();
            }
            this.k.setPackage(str);
            return this;
        }

        public void p(Context context, AttributeSet attributeSet) {
            super.p(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, v.a);
            String string = obtainAttributes.getString(v.f);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            J(string);
            String string2 = obtainAttributes.getString(v.b);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                F(new ComponentName(context, string2));
            }
            E(obtainAttributes.getString(v.c));
            String string3 = obtainAttributes.getString(v.d);
            if (string3 != null) {
                H(Uri.parse(string3));
            }
            I(obtainAttributes.getString(v.e));
            obtainAttributes.recycle();
        }

        public String toString() {
            String z;
            ComponentName A = A();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (A == null) {
                z = z();
                if (z != null) {
                    sb.append(" action=");
                }
                return sb.toString();
            }
            sb.append(" class=");
            z = A.getClassName();
            sb.append(z);
            return sb.toString();
        }

        public boolean y() {
            return false;
        }

        public final String z() {
            Intent intent = this.k;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }
    }

    public a(Context context) {
        this.a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.b = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    public boolean e() {
        Activity activity = this.b;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a a() {
        return new a(this);
    }

    public final Context g() {
        return this.a;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public k b(a aVar, Bundle bundle, p pVar, s.a aVar2) {
        Intent intent;
        int intExtra;
        if (aVar.D() == null) {
            throw new IllegalStateException("Destination " + aVar.i() + " does not have an Intent set.");
        }
        Intent intent2 = new Intent(aVar.D());
        if (bundle != null) {
            intent2.putExtras(bundle);
            String B = aVar.B();
            if (!TextUtils.isEmpty(B)) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(B);
                while (matcher.find()) {
                    String group = matcher.group(1);
                    if (!bundle.containsKey(group)) {
                        throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + B);
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        if (!(this.a instanceof Activity)) {
            intent2.addFlags(268435456);
        }
        if (pVar != null && pVar.g()) {
            intent2.addFlags(536870912);
        }
        Activity activity = this.b;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
        }
        intent2.putExtra("android-support-navigation:ActivityNavigator:current", aVar.i());
        Resources resources = g().getResources();
        if (pVar != null) {
            int c = pVar.c();
            int d = pVar.d();
            if ((c <= 0 || !resources.getResourceTypeName(c).equals("animator")) && (d <= 0 || !resources.getResourceTypeName(d).equals("animator"))) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", c);
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", d);
            } else {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(c) + " and popExit resource " + resources.getResourceName(d) + "when launching " + aVar);
            }
        }
        this.a.startActivity(intent2);
        if (pVar == null || this.b == null) {
            return null;
        }
        int a2 = pVar.a();
        int b = pVar.b();
        if ((a2 <= 0 || !resources.getResourceTypeName(a2).equals("animator")) && (b <= 0 || !resources.getResourceTypeName(b).equals("animator"))) {
            if (a2 < 0 && b < 0) {
                return null;
            }
            this.b.overridePendingTransition(Math.max(a2, 0), Math.max(b, 0));
            return null;
        }
        Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(a2) + " and exit resource " + resources.getResourceName(b) + "when launching " + aVar);
        return null;
    }
}
