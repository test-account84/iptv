package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import com.amazonaws.services.cognitoidentityprovider.model.MFAOptionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CognitoUserSettings {
    private Map userSettings;

    public CognitoUserSettings() {
        this(null);
    }

    public Map getSettings() {
        return this.userSettings;
    }

    public List getSettingsList() {
        ArrayList arrayList = new ArrayList();
        Map map = this.userSettings;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                MFAOptionType mFAOptionType = new MFAOptionType();
                mFAOptionType.setAttributeName((String) entry.getKey());
                mFAOptionType.setDeliveryMedium((String) entry.getValue());
                arrayList.add(mFAOptionType);
            }
        }
        return arrayList;
    }

    public void setSettings(String str, String str2) {
        this.userSettings.put(str, str2);
    }

    public CognitoUserSettings(List list) {
        this.userSettings = new HashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MFAOptionType mFAOptionType = (MFAOptionType) it.next();
                this.userSettings.put(mFAOptionType.getAttributeName().toString(), mFAOptionType.getDeliveryMedium().toString());
            }
        }
    }
}
