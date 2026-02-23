package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LegacyErrorUnmarshaller implements Unmarshaller {
    private final Class exceptionClass;

    public LegacyErrorUnmarshaller() {
        this(AmazonServiceException.class);
    }

    public String getErrorPropertyPath(String str) {
        return "Response/Errors/Error/" + str;
    }

    public String parseErrorCode(Node node) throws Exception {
        return XpathUtils.asString("Response/Errors/Error/Code", node);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        AmazonServiceException.ErrorType errorType;
        String parseErrorCode = parseErrorCode(node);
        String asString = XpathUtils.asString("Response/Errors/Error/Message", node);
        String asString2 = XpathUtils.asString("Response/RequestID", node);
        String asString3 = XpathUtils.asString("Response/Errors/Error/Type", node);
        AmazonServiceException amazonServiceException = (AmazonServiceException) this.exceptionClass.getConstructor(new Class[]{String.class}).newInstance(new Object[]{asString});
        amazonServiceException.setErrorCode(parseErrorCode);
        amazonServiceException.setRequestId(asString2);
        if (asString3 == null) {
            errorType = AmazonServiceException.ErrorType.Unknown;
        } else {
            if (!"server".equalsIgnoreCase(asString3)) {
                if ("client".equalsIgnoreCase(asString3)) {
                    errorType = AmazonServiceException.ErrorType.Client;
                }
                return amazonServiceException;
            }
            errorType = AmazonServiceException.ErrorType.Service;
        }
        amazonServiceException.setErrorType(errorType);
        return amazonServiceException;
    }

    public LegacyErrorUnmarshaller(Class cls) {
        this.exceptionClass = cls;
    }
}
