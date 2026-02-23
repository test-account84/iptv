package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.RestoreObjectRequest;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RequestXmlFactory {

    public static class 1 implements Comparator {
        public int compare(PartETag partETag, PartETag partETag2) {
            if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                return -1;
            }
            return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
        }
    }

    public static byte[] convertToXmlByteArray(RestoreObjectRequest restoreObjectRequest) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("RestoreRequest");
        xmlWriter.start("Days").value(Integer.toString(restoreObjectRequest.getExpirationInDays())).end();
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public static byte[] convertToXmlByteArray(List list) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("CompleteMultipartUpload");
        if (list != null) {
            Collections.sort(list, new 1());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PartETag partETag = (PartETag) it.next();
                xmlWriter.start("Part");
                xmlWriter.start("PartNumber").value(Integer.toString(partETag.getPartNumber())).end();
                xmlWriter.start("ETag").value(partETag.getETag()).end();
                xmlWriter.end();
            }
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }
}
