package com.amazonaws.services.s3.iterable;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class S3Objects implements Iterable {
    private String bucketName;
    private AmazonS3 s3;
    private String prefix = null;
    private Integer batchSize = null;

    public class S3ObjectIterator implements Iterator {
        private Iterator currentIterator;
        private ObjectListing currentListing;

        private S3ObjectIterator() {
            this.currentListing = null;
            this.currentIterator = null;
        }

        private void prepareCurrentListing() {
            ObjectListing listNextBatchOfObjects;
            while (true) {
                if (this.currentListing != null && (this.currentIterator.hasNext() || !this.currentListing.isTruncated())) {
                    return;
                }
                if (this.currentListing == null) {
                    ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
                    listObjectsRequest.setBucketName(S3Objects.this.getBucketName());
                    listObjectsRequest.setPrefix(S3Objects.this.getPrefix());
                    listObjectsRequest.setMaxKeys(S3Objects.this.getBatchSize());
                    listNextBatchOfObjects = S3Objects.this.getS3().listObjects(listObjectsRequest);
                } else {
                    listNextBatchOfObjects = S3Objects.this.getS3().listNextBatchOfObjects(this.currentListing);
                }
                this.currentListing = listNextBatchOfObjects;
                this.currentIterator = this.currentListing.getObjectSummaries().iterator();
            }
        }

        public boolean hasNext() {
            prepareCurrentListing();
            return this.currentIterator.hasNext();
        }

        public S3ObjectSummary next() {
            prepareCurrentListing();
            return (S3ObjectSummary) this.currentIterator.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ S3ObjectIterator(S3Objects s3Objects, 1 r2) {
            this();
        }
    }

    private S3Objects(AmazonS3 amazonS3, String str) {
        this.s3 = amazonS3;
        this.bucketName = str;
    }

    public static S3Objects inBucket(AmazonS3 amazonS3, String str) {
        return new S3Objects(amazonS3, str);
    }

    public static S3Objects withPrefix(AmazonS3 amazonS3, String str, String str2) {
        S3Objects s3Objects = new S3Objects(amazonS3, str);
        s3Objects.prefix = str2;
        return s3Objects;
    }

    public Integer getBatchSize() {
        return this.batchSize;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public AmazonS3 getS3() {
        return this.s3;
    }

    public Iterator iterator() {
        return new S3ObjectIterator(this, null);
    }

    public S3Objects withBatchSize(int i) {
        this.batchSize = Integer.valueOf(i);
        return this;
    }
}
