package com.amazonaws.auth.policy.conditions;

import com.amazonaws.auth.policy.Condition;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NumericCondition extends Condition {

    public enum NumericComparisonType {
        NumericEquals,
        NumericGreaterThan,
        NumericGreaterThanEquals,
        NumericLessThan,
        NumericLessThanEquals,
        NumericNotEquals
    }

    public NumericCondition(NumericComparisonType numericComparisonType, String str, String str2) {
        this.type = numericComparisonType.toString();
        this.conditionKey = str;
        this.values = Arrays.asList(new String[]{str2});
    }
}
