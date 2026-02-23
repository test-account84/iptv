package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.securitytoken.model.IDPRejectedClaimException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class IDPRejectedClaimExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public IDPRejectedClaimExceptionUnmarshaller() {
        super(IDPRejectedClaimException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("IDPRejectedClaim")) {
            return null;
        }
        return (IDPRejectedClaimException) super.unmarshall(node);
    }
}
