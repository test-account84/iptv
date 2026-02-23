package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StandardErrorUnmarshaller extends AbstractErrorUnmarshaller {
    public StandardErrorUnmarshaller() {
    }

    public String getErrorPropertyPath(String str) {
        return "ErrorResponse/Error/" + str;
    }

    public String parseErrorCode(Node node) throws Exception {
        return XpathUtils.asString("ErrorResponse/Error/Code", node);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        AmazonServiceException.ErrorType errorType;
        String parseErrorCode = parseErrorCode(node);
        String asString = XpathUtils.asString("ErrorResponse/Error/Type", node);
        String asString2 = XpathUtils.asString("ErrorResponse/RequestId", node);
        AmazonServiceException newException = newException(XpathUtils.asString("ErrorResponse/Error/Message", node));
        newException.setErrorCode(parseErrorCode);
        newException.setRequestId(asString2);
        if (asString == null) {
            errorType = AmazonServiceException.ErrorType.Unknown;
        } else {
            if (!"Receiver".equalsIgnoreCase(asString)) {
                if ("Sender".equalsIgnoreCase(asString)) {
                    errorType = AmazonServiceException.ErrorType.Client;
                }
                return newException;
            }
            errorType = AmazonServiceException.ErrorType.Service;
        }
        newException.setErrorType(errorType);
        return newException;
    }

    public StandardErrorUnmarshaller(Class cls) {
        super(cls);
    }
}
