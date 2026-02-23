package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.securitytoken.model.InvalidAuthorizationMessageException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InvalidAuthorizationMessageExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidAuthorizationMessageExceptionUnmarshaller() {
        super(InvalidAuthorizationMessageException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("InvalidAuthorizationMessageException")) {
            return null;
        }
        return (InvalidAuthorizationMessageException) super.unmarshall(node);
    }
}
