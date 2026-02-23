package com.amazonaws.auth.policy.conditions;

import com.amazonaws.auth.policy.Condition;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BooleanCondition extends Condition {
    public BooleanCondition(String str, boolean z) {
        this.type = "Bool";
        this.conditionKey = str;
        this.values = Arrays.asList(new String[]{Boolean.toString(z)});
    }
}
