package com.google.ads.interactivemedia.v3.impl.data;

import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import com.google.ads.interactivemedia.v3.internal.atf;
import com.google.ads.interactivemedia.v3.internal.bjk;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class k {
    public static Application a(Context context) {
        Application applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        return null;
    }

    public static boolean b(Context context, TestingConfiguration testingConfiguration) {
        if (testingConfiguration != null && testingConfiguration.forceTvMode()) {
            return true;
        }
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String d(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (h(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (h(c)) {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String e(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (g(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (g(c)) {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static boolean f(CharSequence charSequence, CharSequence charSequence2) {
        int j;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence2.charAt(i);
            if (charAt != charAt2 && ((j = j(charAt)) >= 26 || j != j(charAt2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean h(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static final boolean i(bjk bjkVar) {
        atf atfVar = (atf) bjkVar.a().getAnnotation(atf.class);
        return atfVar != null && Arrays.asList(atfVar.b()).contains(bjkVar.b());
    }

    private static int j(char c) {
        return (char) ((c | ' ') - 97);
    }
}
