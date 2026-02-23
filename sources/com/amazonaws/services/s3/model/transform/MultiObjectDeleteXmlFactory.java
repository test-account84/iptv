package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MultiObjectDeleteXmlFactory {
    private void writeKeyVersion(XmlWriter xmlWriter, DeleteObjectsRequest.KeyVersion keyVersion) {
        xmlWriter.start("Object");
        xmlWriter.start("Key").value(keyVersion.getKey()).end();
        if (keyVersion.getVersion() != null) {
            xmlWriter.start("VersionId").value(keyVersion.getVersion()).end();
        }
        xmlWriter.end();
    }

    public byte[] convertToXmlByteArray(DeleteObjectsRequest deleteObjectsRequest) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("Delete");
        if (deleteObjectsRequest.getQuiet()) {
            xmlWriter.start("Quiet").value("true").end();
        }
        Iterator it = deleteObjectsRequest.getKeys().iterator();
        while (it.hasNext()) {
            writeKeyVersion(xmlWriter, (DeleteObjectsRequest.KeyVersion) it.next());
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }
}
