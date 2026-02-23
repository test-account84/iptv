package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CognitoUserAttributes {
    private Map userAttributes;

    public CognitoUserAttributes() {
        this(null);
    }

    public void addAttribute(String str, String str2) {
        this.userAttributes.put(str, str2);
    }

    public Map getAttributes() {
        return this.userAttributes;
    }

    public List getAttributesList() {
        ArrayList arrayList = new ArrayList();
        Map map = this.userAttributes;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                AttributeType attributeType = new AttributeType();
                attributeType.setName((String) entry.getKey());
                attributeType.setValue((String) entry.getValue());
                arrayList.add(attributeType);
            }
        }
        return arrayList;
    }

    public CognitoUserAttributes(List list) {
        this.userAttributes = new HashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AttributeType attributeType = (AttributeType) it.next();
                this.userAttributes.put(attributeType.getName(), attributeType.getValue());
            }
        }
    }
}
