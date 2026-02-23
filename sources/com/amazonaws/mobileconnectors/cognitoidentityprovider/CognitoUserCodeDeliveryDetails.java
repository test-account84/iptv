package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import com.amazonaws.services.cognitoidentityprovider.model.CodeDeliveryDetailsType;
import com.amazonaws.services.cognitoidentityprovider.model.MFAOptionType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CognitoUserCodeDeliveryDetails {
    private final String attributeName;
    private final String deliveryMedium;
    private final String destination;

    public CognitoUserCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        String str;
        if (codeDeliveryDetailsType != null) {
            this.destination = codeDeliveryDetailsType.getDestination();
            this.deliveryMedium = codeDeliveryDetailsType.getDeliveryMedium();
            str = codeDeliveryDetailsType.getAttributeName();
        } else {
            str = null;
            this.destination = null;
            this.deliveryMedium = null;
        }
        this.attributeName = str;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getDeliveryMedium() {
        return this.deliveryMedium;
    }

    public String getDestination() {
        return this.destination;
    }

    public CognitoUserCodeDeliveryDetails(MFAOptionType mFAOptionType) {
        this.destination = null;
        if (mFAOptionType != null) {
            this.deliveryMedium = mFAOptionType.getDeliveryMedium();
            this.attributeName = mFAOptionType.getAttributeName();
        } else {
            this.deliveryMedium = null;
            this.attributeName = null;
        }
    }

    public CognitoUserCodeDeliveryDetails(String str, String str2, String str3) {
        this.destination = str;
        this.deliveryMedium = str2;
        this.attributeName = str3;
    }
}
