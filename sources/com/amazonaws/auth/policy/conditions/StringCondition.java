package com.amazonaws.auth.policy.conditions;

import com.amazonaws.auth.policy.Condition;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StringCondition extends Condition {

    public enum StringComparisonType {
        StringEquals,
        StringEqualsIgnoreCase,
        StringLike,
        StringNotEquals,
        StringNotEqualsIgnoreCase,
        StringNotLike
    }

    public StringCondition(StringComparisonType stringComparisonType, String str, String str2) {
        this.type = stringComparisonType.toString();
        this.conditionKey = str;
        this.values = Arrays.asList(new String[]{str2});
    }
}
