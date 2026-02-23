package com.amazonaws.auth.policy.conditions;

import com.amazonaws.auth.policy.Condition;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class IpAddressCondition extends Condition {

    public enum IpAddressComparisonType {
        IpAddress,
        NotIpAddress
    }

    public IpAddressCondition(IpAddressComparisonType ipAddressComparisonType, String str) {
        this.type = ipAddressComparisonType.toString();
        this.conditionKey = "aws:SourceIp";
        this.values = Arrays.asList(new String[]{str});
    }

    public IpAddressCondition(String str) {
        this(IpAddressComparisonType.IpAddress, str);
    }
}
