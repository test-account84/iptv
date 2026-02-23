package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.DeleteObjectTaggingResult;
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.SetObjectTaggingResult;
import com.amazonaws.services.s3.model.VersionListing;
import com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Unmarshallers {

    public static final class AccessControlListUnmarshaller implements Unmarshaller {
        public AccessControlList unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseAccessControlListResponse(inputStream).getAccessControlList();
        }
    }

    public static final class BucketAccelerateConfigurationUnmarshaller implements Unmarshaller {
        public BucketAccelerateConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseAccelerateConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketCrossOriginConfigurationUnmarshaller implements Unmarshaller {
        public BucketCrossOriginConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseBucketCrossOriginConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketLifecycleConfigurationUnmarshaller implements Unmarshaller {
        public BucketLifecycleConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseBucketLifecycleConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketLocationUnmarshaller implements Unmarshaller {
        public String unmarshall(InputStream inputStream) throws Exception {
            String parseBucketLocationResponse = new XmlResponsesSaxParser().parseBucketLocationResponse(inputStream);
            return parseBucketLocationResponse == null ? "US" : parseBucketLocationResponse;
        }
    }

    public static final class BucketLoggingConfigurationnmarshaller implements Unmarshaller {
        public BucketLoggingConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseLoggingStatusResponse(inputStream).getBucketLoggingConfiguration();
        }
    }

    public static final class BucketReplicationConfigurationUnmarshaller implements Unmarshaller {
        public BucketReplicationConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseReplicationConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketTaggingConfigurationUnmarshaller implements Unmarshaller {
        public BucketTaggingConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseTaggingConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketVersioningConfigurationUnmarshaller implements Unmarshaller {
        public BucketVersioningConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseVersioningConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class BucketWebsiteConfigurationUnmarshaller implements Unmarshaller {
        public BucketWebsiteConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseWebsiteConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class CompleteMultipartUploadResultUnmarshaller implements Unmarshaller {
        public XmlResponsesSaxParser.CompleteMultipartUploadHandler unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseCompleteMultipartUploadResponse(inputStream);
        }
    }

    public static final class CopyObjectUnmarshaller implements Unmarshaller {
        public XmlResponsesSaxParser.CopyObjectResultHandler unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseCopyObjectResponse(inputStream);
        }
    }

    public static final class DeleteBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller {
        public DeleteBucketAnalyticsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new DeleteBucketAnalyticsConfigurationResult();
        }
    }

    public static final class DeleteBucketInventoryConfigurationUnmarshaller implements Unmarshaller {
        public DeleteBucketInventoryConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new DeleteBucketInventoryConfigurationResult();
        }
    }

    public static final class DeleteBucketMetricsConfigurationUnmarshaller implements Unmarshaller {
        public DeleteBucketMetricsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new DeleteBucketMetricsConfigurationResult();
        }
    }

    public static final class DeleteObjectTaggingResponseUnmarshaller implements Unmarshaller {
        public DeleteObjectTaggingResult unmarshall(InputStream inputStream) throws Exception {
            return new DeleteObjectTaggingResult();
        }
    }

    public static final class DeleteObjectsResultUnmarshaller implements Unmarshaller {
        public DeleteObjectsResponse unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseDeletedObjectsResult(inputStream).getDeleteObjectResult();
        }
    }

    public static final class GetBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller {
        public GetBucketAnalyticsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseGetBucketAnalyticsConfigurationResponse(inputStream).getResult();
        }
    }

    public static final class GetBucketInventoryConfigurationUnmarshaller implements Unmarshaller {
        public GetBucketInventoryConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseGetBucketInventoryConfigurationResponse(inputStream).getResult();
        }
    }

    public static final class GetBucketMetricsConfigurationUnmarshaller implements Unmarshaller {
        public GetBucketMetricsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseGetBucketMetricsConfigurationResponse(inputStream).getResult();
        }
    }

    public static final class GetObjectTaggingResponseUnmarshaller implements Unmarshaller {
        public GetObjectTaggingResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseObjectTaggingResponse(inputStream).getResult();
        }
    }

    public static final class InitiateMultipartUploadResultUnmarshaller implements Unmarshaller {
        public InitiateMultipartUploadResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseInitiateMultipartUploadResponse(inputStream).getInitiateMultipartUploadResult();
        }
    }

    public static final class InputStreamUnmarshaller implements Unmarshaller {
        public InputStream unmarshall(InputStream inputStream) throws Exception {
            return inputStream;
        }
    }

    public static final class ListBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller {
        public ListBucketAnalyticsConfigurationsResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListBucketAnalyticsConfigurationResponse(inputStream).getResult();
        }
    }

    public static final class ListBucketInventoryConfigurationsUnmarshaller implements Unmarshaller {
        public ListBucketInventoryConfigurationsResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseBucketListInventoryConfigurationsResponse(inputStream).getResult();
        }
    }

    public static final class ListBucketMetricsConfigurationsUnmarshaller implements Unmarshaller {
        public ListBucketMetricsConfigurationsResult unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListBucketMetricsConfigurationsResponse(inputStream).getResult();
        }
    }

    public static final class ListBucketsOwnerUnmarshaller implements Unmarshaller {
        public Owner unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListMyBucketsResponse(inputStream).getOwner();
        }
    }

    public static final class ListBucketsUnmarshaller implements Unmarshaller {
        public List unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListMyBucketsResponse(inputStream).getBuckets();
        }
    }

    public static final class ListMultipartUploadsResultUnmarshaller implements Unmarshaller {
        public MultipartUploadListing unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListMultipartUploadsResponse(inputStream).getListMultipartUploadsResult();
        }
    }

    public static final class ListObjectsUnmarshaller implements Unmarshaller {
        private final boolean shouldSDKDecodeResponse;

        public ListObjectsUnmarshaller(boolean z) {
            this.shouldSDKDecodeResponse = z;
        }

        public ObjectListing unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListBucketObjectsResponse(inputStream, this.shouldSDKDecodeResponse).getObjectListing();
        }
    }

    public static final class ListObjectsV2Unmarshaller implements Unmarshaller {
        private final boolean shouldSDKDecodeResponse;

        public ListObjectsV2Unmarshaller(boolean z) {
            this.shouldSDKDecodeResponse = z;
        }

        public ListObjectsV2Result unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListObjectsV2Response(inputStream, this.shouldSDKDecodeResponse).getResult();
        }
    }

    public static final class ListPartsResultUnmarshaller implements Unmarshaller {
        public PartListing unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListPartsResponse(inputStream).getListPartsResult();
        }
    }

    public static final class RequestPaymentConfigurationUnmarshaller implements Unmarshaller {
        public RequestPaymentConfiguration unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseRequestPaymentConfigurationResponse(inputStream).getConfiguration();
        }
    }

    public static final class SetBucketAnalyticsConfigurationUnmarshaller implements Unmarshaller {
        public SetBucketAnalyticsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new SetBucketAnalyticsConfigurationResult();
        }
    }

    public static final class SetBucketInventoryConfigurationUnmarshaller implements Unmarshaller {
        public SetBucketInventoryConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new SetBucketInventoryConfigurationResult();
        }
    }

    public static final class SetBucketMetricsConfigurationUnmarshaller implements Unmarshaller {
        public SetBucketMetricsConfigurationResult unmarshall(InputStream inputStream) throws Exception {
            return new SetBucketMetricsConfigurationResult();
        }
    }

    public static final class SetObjectTaggingResponseUnmarshaller implements Unmarshaller {
        public SetObjectTaggingResult unmarshall(InputStream inputStream) throws Exception {
            return new SetObjectTaggingResult();
        }
    }

    public static final class VersionListUnmarshaller implements Unmarshaller {
        private final boolean shouldSDKDecodeResponse;

        public VersionListUnmarshaller(boolean z) {
            this.shouldSDKDecodeResponse = z;
        }

        public VersionListing unmarshall(InputStream inputStream) throws Exception {
            return new XmlResponsesSaxParser().parseListVersionsResponse(inputStream, this.shouldSDKDecodeResponse).getListing();
        }
    }
}
