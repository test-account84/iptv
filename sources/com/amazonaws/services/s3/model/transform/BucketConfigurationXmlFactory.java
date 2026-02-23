package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CORSRule;
import com.amazonaws.services.s3.model.CloudFunctionConfiguration;
import com.amazonaws.services.s3.model.Filter;
import com.amazonaws.services.s3.model.FilterRule;
import com.amazonaws.services.s3.model.LambdaConfiguration;
import com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazonaws.services.s3.model.QueueConfiguration;
import com.amazonaws.services.s3.model.RedirectRule;
import com.amazonaws.services.s3.model.ReplicationDestinationConfig;
import com.amazonaws.services.s3.model.ReplicationRule;
import com.amazonaws.services.s3.model.RoutingRule;
import com.amazonaws.services.s3.model.RoutingRuleCondition;
import com.amazonaws.services.s3.model.S3KeyFilter;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.TagSet;
import com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsPredicateVisitor;
import com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazonaws.services.s3.model.inventory.InventoryFilterPredicate;
import com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazonaws.services.s3.model.inventory.InventorySchedule;
import com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecyclePredicateVisitor;
import com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazonaws.services.s3.model.metrics.MetricsFilter;
import com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsPredicateVisitor;
import com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BucketConfigurationXmlFactory {

    public class AnalyticsPredicateVisitorImpl implements AnalyticsPredicateVisitor {
        private final XmlWriter xml;

        public AnalyticsPredicateVisitorImpl(XmlWriter xmlWriter) {
            this.xml = xmlWriter;
        }

        public void visit(AnalyticsAndOperator analyticsAndOperator) {
            this.xml.start("And");
            Iterator it = analyticsAndOperator.getOperands().iterator();
            while (it.hasNext()) {
                ((AnalyticsFilterPredicate) it.next()).accept(this);
            }
            this.xml.end();
        }

        public void visit(AnalyticsPrefixPredicate analyticsPrefixPredicate) {
            BucketConfigurationXmlFactory.access$000(BucketConfigurationXmlFactory.this, this.xml, analyticsPrefixPredicate.getPrefix());
        }

        public void visit(AnalyticsTagPredicate analyticsTagPredicate) {
            BucketConfigurationXmlFactory.access$100(BucketConfigurationXmlFactory.this, this.xml, analyticsTagPredicate.getTag());
        }
    }

    public class LifecyclePredicateVisitorImpl implements LifecyclePredicateVisitor {
        private final XmlWriter xml;

        public LifecyclePredicateVisitorImpl(XmlWriter xmlWriter) {
            this.xml = xmlWriter;
        }

        public void visit(LifecycleAndOperator lifecycleAndOperator) {
            this.xml.start("And");
            Iterator it = lifecycleAndOperator.getOperands().iterator();
            while (it.hasNext()) {
                ((LifecycleFilterPredicate) it.next()).accept(this);
            }
            this.xml.end();
        }

        public void visit(LifecyclePrefixPredicate lifecyclePrefixPredicate) {
            BucketConfigurationXmlFactory.access$000(BucketConfigurationXmlFactory.this, this.xml, lifecyclePrefixPredicate.getPrefix());
        }

        public void visit(LifecycleTagPredicate lifecycleTagPredicate) {
            BucketConfigurationXmlFactory.access$100(BucketConfigurationXmlFactory.this, this.xml, lifecycleTagPredicate.getTag());
        }
    }

    public class MetricsPredicateVisitorImpl implements MetricsPredicateVisitor {
        private final XmlWriter xml;

        public MetricsPredicateVisitorImpl(XmlWriter xmlWriter) {
            this.xml = xmlWriter;
        }

        public void visit(MetricsAndOperator metricsAndOperator) {
            this.xml.start("And");
            Iterator it = metricsAndOperator.getOperands().iterator();
            while (it.hasNext()) {
                ((MetricsFilterPredicate) it.next()).accept(this);
            }
            this.xml.end();
        }

        public void visit(MetricsPrefixPredicate metricsPrefixPredicate) {
            BucketConfigurationXmlFactory.access$000(BucketConfigurationXmlFactory.this, this.xml, metricsPrefixPredicate.getPrefix());
        }

        public void visit(MetricsTagPredicate metricsTagPredicate) {
            BucketConfigurationXmlFactory.access$100(BucketConfigurationXmlFactory.this, this.xml, metricsTagPredicate.getTag());
        }
    }

    public static /* synthetic */ void access$000(BucketConfigurationXmlFactory bucketConfigurationXmlFactory, XmlWriter xmlWriter, String str) {
        bucketConfigurationXmlFactory.writePrefix(xmlWriter, str);
    }

    public static /* synthetic */ void access$100(BucketConfigurationXmlFactory bucketConfigurationXmlFactory, XmlWriter xmlWriter, Tag tag) {
        bucketConfigurationXmlFactory.writeTag(xmlWriter, tag);
    }

    private void addEventsAndFilterCriteria(XmlWriter xmlWriter, NotificationConfiguration notificationConfiguration) {
        Iterator it = notificationConfiguration.getEvents().iterator();
        while (it.hasNext()) {
            xmlWriter.start("Event").value((String) it.next()).end();
        }
        Filter filter = notificationConfiguration.getFilter();
        if (filter != null) {
            validateFilter(filter);
            xmlWriter.start("Filter");
            if (filter.getS3KeyFilter() != null) {
                validateS3KeyFilter(filter.getS3KeyFilter());
                xmlWriter.start("S3Key");
                for (FilterRule filterRule : filter.getS3KeyFilter().getFilterRules()) {
                    xmlWriter.start("FilterRule");
                    xmlWriter.start("Name").value(filterRule.getName()).end();
                    xmlWriter.start("Value").value(filterRule.getValue()).end();
                    xmlWriter.end();
                }
                xmlWriter.end();
            }
            xmlWriter.end();
        }
    }

    private void addInventoryOptionalFields(XmlWriter xmlWriter, List list) {
        if (isNullOrEmpty(list)) {
            return;
        }
        xmlWriter.start("OptionalFields");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            xmlWriter.start("Field").value((String) it.next()).end();
        }
        xmlWriter.end();
    }

    private void addInventorySchedule(XmlWriter xmlWriter, InventorySchedule inventorySchedule) {
        if (inventorySchedule == null) {
            return;
        }
        xmlWriter.start("Schedule");
        addParameterIfNotNull(xmlWriter, "Frequency", inventorySchedule.getFrequency());
        xmlWriter.end();
    }

    private void addNoncurrentTransitions(XmlWriter xmlWriter, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BucketLifecycleConfiguration.NoncurrentVersionTransition noncurrentVersionTransition = (BucketLifecycleConfiguration.NoncurrentVersionTransition) it.next();
            if (noncurrentVersionTransition != null) {
                xmlWriter.start("NoncurrentVersionTransition");
                if (noncurrentVersionTransition.getDays() != -1) {
                    xmlWriter.start("NoncurrentDays");
                    xmlWriter.value(Integer.toString(noncurrentVersionTransition.getDays()));
                    xmlWriter.end();
                }
                xmlWriter.start("StorageClass");
                xmlWriter.value(noncurrentVersionTransition.getStorageClass().toString());
                xmlWriter.end();
                xmlWriter.end();
            }
        }
    }

    private void addParameterIfNotNull(XmlWriter xmlWriter, String str, String str2) {
        if (str2 != null) {
            xmlWriter.start(str).value(str2).end();
        }
    }

    private void addTransitions(XmlWriter xmlWriter, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BucketLifecycleConfiguration.Transition transition = (BucketLifecycleConfiguration.Transition) it.next();
            if (transition != null) {
                xmlWriter.start("Transition");
                if (transition.getDate() != null) {
                    xmlWriter.start("Date");
                    xmlWriter.value(ServiceUtils.formatIso8601Date(transition.getDate()));
                    xmlWriter.end();
                }
                if (transition.getDays() != -1) {
                    xmlWriter.start("Days");
                    xmlWriter.value(Integer.toString(transition.getDays()));
                    xmlWriter.end();
                }
                xmlWriter.start("StorageClass");
                xmlWriter.value(transition.getStorageClass().toString());
                xmlWriter.end();
                xmlWriter.end();
            }
        }
    }

    private boolean hasCurrentExpirationPolicy(BucketLifecycleConfiguration.Rule rule) {
        return (rule.getExpirationInDays() == -1 && rule.getExpirationDate() == null && !rule.isExpiredObjectDeleteMarker()) ? false : true;
    }

    private boolean hasTags(TagSet tagSet) {
        return (tagSet == null || tagSet.getAllTags() == null || tagSet.getAllTags().size() <= 0) ? false : true;
    }

    private boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    private void validateFilter(Filter filter) {
        if (filter.getS3KeyFilter() == null) {
            throw new AmazonClientException("Cannot have a Filter without any criteria");
        }
    }

    private void validateS3KeyFilter(S3KeyFilter s3KeyFilter) {
        if (isNullOrEmpty(s3KeyFilter.getFilterRules())) {
            throw new AmazonClientException("Cannot have an S3KeyFilter without any filter rules");
        }
    }

    private void writeAnalyticsExportDestination(XmlWriter xmlWriter, AnalyticsExportDestination analyticsExportDestination) {
        if (analyticsExportDestination == null) {
            return;
        }
        xmlWriter.start("Destination");
        if (analyticsExportDestination.getS3BucketDestination() != null) {
            xmlWriter.start("S3BucketDestination");
            AnalyticsS3BucketDestination s3BucketDestination = analyticsExportDestination.getS3BucketDestination();
            addParameterIfNotNull(xmlWriter, "Format", s3BucketDestination.getFormat());
            addParameterIfNotNull(xmlWriter, "BucketAccountId", s3BucketDestination.getBucketAccountId());
            addParameterIfNotNull(xmlWriter, "Bucket", s3BucketDestination.getBucketArn());
            addParameterIfNotNull(xmlWriter, "Prefix", s3BucketDestination.getPrefix());
            xmlWriter.end();
        }
        xmlWriter.end();
    }

    private void writeAnalyticsFilter(XmlWriter xmlWriter, AnalyticsFilter analyticsFilter) {
        if (analyticsFilter == null) {
            return;
        }
        xmlWriter.start("Filter");
        writeAnalyticsFilterPredicate(xmlWriter, analyticsFilter.getPredicate());
        xmlWriter.end();
    }

    private void writeAnalyticsFilterPredicate(XmlWriter xmlWriter, AnalyticsFilterPredicate analyticsFilterPredicate) {
        if (analyticsFilterPredicate == null) {
            return;
        }
        analyticsFilterPredicate.accept(new AnalyticsPredicateVisitorImpl(xmlWriter));
    }

    private void writeInventoryDestination(XmlWriter xmlWriter, InventoryDestination inventoryDestination) {
        if (inventoryDestination == null) {
            return;
        }
        xmlWriter.start("Destination");
        InventoryS3BucketDestination s3BucketDestination = inventoryDestination.getS3BucketDestination();
        if (s3BucketDestination != null) {
            xmlWriter.start("S3BucketDestination");
            addParameterIfNotNull(xmlWriter, "AccountId", s3BucketDestination.getAccountId());
            addParameterIfNotNull(xmlWriter, "Bucket", s3BucketDestination.getBucketArn());
            addParameterIfNotNull(xmlWriter, "Prefix", s3BucketDestination.getPrefix());
            addParameterIfNotNull(xmlWriter, "Format", s3BucketDestination.getFormat());
            xmlWriter.end();
        }
        xmlWriter.end();
    }

    private void writeInventoryFilter(XmlWriter xmlWriter, InventoryFilter inventoryFilter) {
        if (inventoryFilter == null) {
            return;
        }
        xmlWriter.start("Filter");
        writeInventoryFilterPredicate(xmlWriter, inventoryFilter.getPredicate());
        xmlWriter.end();
    }

    private void writeInventoryFilterPredicate(XmlWriter xmlWriter, InventoryFilterPredicate inventoryFilterPredicate) {
        if (inventoryFilterPredicate != null && (inventoryFilterPredicate instanceof InventoryPrefixPredicate)) {
            writePrefix(xmlWriter, ((InventoryPrefixPredicate) inventoryFilterPredicate).getPrefix());
        }
    }

    private void writeLifecycleFilter(XmlWriter xmlWriter, LifecycleFilter lifecycleFilter) {
        if (lifecycleFilter == null) {
            return;
        }
        xmlWriter.start("Filter");
        writeLifecycleFilterPredicate(xmlWriter, lifecycleFilter.getPredicate());
        xmlWriter.end();
    }

    private void writeLifecycleFilterPredicate(XmlWriter xmlWriter, LifecycleFilterPredicate lifecycleFilterPredicate) {
        if (lifecycleFilterPredicate == null) {
            return;
        }
        lifecycleFilterPredicate.accept(new LifecyclePredicateVisitorImpl(xmlWriter));
    }

    private void writeMetricsFilter(XmlWriter xmlWriter, MetricsFilter metricsFilter) {
        if (metricsFilter == null) {
            return;
        }
        xmlWriter.start("Filter");
        writeMetricsFilterPredicate(xmlWriter, metricsFilter.getPredicate());
        xmlWriter.end();
    }

    private void writeMetricsFilterPredicate(XmlWriter xmlWriter, MetricsFilterPredicate metricsFilterPredicate) {
        if (metricsFilterPredicate == null) {
            return;
        }
        metricsFilterPredicate.accept(new MetricsPredicateVisitorImpl(xmlWriter));
    }

    private void writePrefix(XmlWriter xmlWriter, BucketLifecycleConfiguration.Rule rule) {
        if (rule.getFilter() == null) {
            xmlWriter.start("Prefix").value(rule.getPrefix() == null ? "" : rule.getPrefix()).end();
        } else if (rule.getPrefix() != null) {
            throw new IllegalArgumentException("Prefix cannot be used with Filter. Use LifecyclePrefixPredicate to create a LifecycleFilter");
        }
    }

    private void writeRule(XmlWriter xmlWriter, BucketLifecycleConfiguration.Rule rule) {
        xmlWriter.start("Rule");
        if (rule.getId() != null) {
            xmlWriter.start("ID").value(rule.getId()).end();
        }
        writePrefix(xmlWriter, rule);
        xmlWriter.start("Status").value(rule.getStatus()).end();
        writeLifecycleFilter(xmlWriter, rule.getFilter());
        addTransitions(xmlWriter, rule.getTransitions());
        addNoncurrentTransitions(xmlWriter, rule.getNoncurrentVersionTransitions());
        if (hasCurrentExpirationPolicy(rule)) {
            xmlWriter.start("Expiration");
            if (rule.getExpirationInDays() != -1) {
                xmlWriter.start("Days").value("" + rule.getExpirationInDays()).end();
            }
            if (rule.getExpirationDate() != null) {
                xmlWriter.start("Date").value(ServiceUtils.formatIso8601Date(rule.getExpirationDate())).end();
            }
            if (rule.isExpiredObjectDeleteMarker()) {
                xmlWriter.start("ExpiredObjectDeleteMarker").value("true").end();
            }
            xmlWriter.end();
        }
        if (rule.getNoncurrentVersionExpirationInDays() != -1) {
            xmlWriter.start("NoncurrentVersionExpiration");
            xmlWriter.start("NoncurrentDays").value(Integer.toString(rule.getNoncurrentVersionExpirationInDays())).end();
            xmlWriter.end();
        }
        if (rule.getAbortIncompleteMultipartUpload() != null) {
            xmlWriter.start("AbortIncompleteMultipartUpload");
            xmlWriter.start("DaysAfterInitiation").value(Integer.toString(rule.getAbortIncompleteMultipartUpload().getDaysAfterInitiation())).end();
            xmlWriter.end();
        }
        xmlWriter.end();
    }

    private void writeStorageClassAnalysis(XmlWriter xmlWriter, StorageClassAnalysis storageClassAnalysis) {
        if (storageClassAnalysis == null) {
            return;
        }
        xmlWriter.start("StorageClassAnalysis");
        if (storageClassAnalysis.getDataExport() != null) {
            StorageClassAnalysisDataExport dataExport = storageClassAnalysis.getDataExport();
            xmlWriter.start("DataExport");
            addParameterIfNotNull(xmlWriter, "OutputSchemaVersion", dataExport.getOutputSchemaVersion());
            writeAnalyticsExportDestination(xmlWriter, dataExport.getDestination());
            xmlWriter.end();
        }
        xmlWriter.end();
    }

    private void writeTag(XmlWriter xmlWriter, Tag tag) {
        if (tag == null) {
            return;
        }
        xmlWriter.start("Tag");
        xmlWriter.start("Key").value(tag.getKey()).end();
        xmlWriter.start("Value").value(tag.getValue()).end();
        xmlWriter.end();
    }

    public byte[] convertToXmlByteArray(BucketAccelerateConfiguration bucketAccelerateConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("AccelerateConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        xmlWriter.start("Status").value(bucketAccelerateConfiguration.getStatus()).end();
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    private void writePrefix(XmlWriter xmlWriter, String str) {
        addParameterIfNotNull(xmlWriter, "Prefix", str);
    }

    private void writeRule(XmlWriter xmlWriter, CORSRule cORSRule) {
        xmlWriter.start("CORSRule");
        if (cORSRule.getId() != null) {
            xmlWriter.start("ID").value(cORSRule.getId()).end();
        }
        if (cORSRule.getAllowedOrigins() != null) {
            Iterator it = cORSRule.getAllowedOrigins().iterator();
            while (it.hasNext()) {
                xmlWriter.start("AllowedOrigin").value((String) it.next()).end();
            }
        }
        if (cORSRule.getAllowedMethods() != null) {
            Iterator it2 = cORSRule.getAllowedMethods().iterator();
            while (it2.hasNext()) {
                xmlWriter.start("AllowedMethod").value(((CORSRule.AllowedMethods) it2.next()).toString()).end();
            }
        }
        if (cORSRule.getMaxAgeSeconds() != 0) {
            xmlWriter.start("MaxAgeSeconds").value(Integer.toString(cORSRule.getMaxAgeSeconds())).end();
        }
        if (cORSRule.getExposedHeaders() != null) {
            Iterator it3 = cORSRule.getExposedHeaders().iterator();
            while (it3.hasNext()) {
                xmlWriter.start("ExposeHeader").value((String) it3.next()).end();
            }
        }
        if (cORSRule.getAllowedHeaders() != null) {
            Iterator it4 = cORSRule.getAllowedHeaders().iterator();
            while (it4.hasNext()) {
                xmlWriter.start("AllowedHeader").value((String) it4.next()).end();
            }
        }
        xmlWriter.end();
    }

    public byte[] convertToXmlByteArray(BucketCrossOriginConfiguration bucketCrossOriginConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("CORSConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        Iterator it = bucketCrossOriginConfiguration.getRules().iterator();
        while (it.hasNext()) {
            writeRule(xmlWriter, (CORSRule) it.next());
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    private void writeRule(XmlWriter xmlWriter, RoutingRule routingRule) {
        xmlWriter.start("RoutingRule");
        RoutingRuleCondition condition = routingRule.getCondition();
        if (condition != null) {
            xmlWriter.start("Condition");
            xmlWriter.start("KeyPrefixEquals");
            if (condition.getKeyPrefixEquals() != null) {
                xmlWriter.value(condition.getKeyPrefixEquals());
            }
            xmlWriter.end();
            if (condition.getHttpErrorCodeReturnedEquals() != null) {
                xmlWriter.start("HttpErrorCodeReturnedEquals ").value(condition.getHttpErrorCodeReturnedEquals()).end();
            }
            xmlWriter.end();
        }
        xmlWriter.start("Redirect");
        RedirectRule redirect = routingRule.getRedirect();
        if (redirect != null) {
            if (redirect.getprotocol() != null) {
                xmlWriter.start("Protocol").value(redirect.getprotocol()).end();
            }
            if (redirect.getHostName() != null) {
                xmlWriter.start("HostName").value(redirect.getHostName()).end();
            }
            if (redirect.getReplaceKeyPrefixWith() != null) {
                xmlWriter.start("ReplaceKeyPrefixWith").value(redirect.getReplaceKeyPrefixWith()).end();
            }
            if (redirect.getReplaceKeyWith() != null) {
                xmlWriter.start("ReplaceKeyWith").value(redirect.getReplaceKeyWith()).end();
            }
            if (redirect.getHttpRedirectCode() != null) {
                xmlWriter.start("HttpRedirectCode").value(redirect.getHttpRedirectCode()).end();
            }
        }
        xmlWriter.end();
        xmlWriter.end();
    }

    public byte[] convertToXmlByteArray(BucketLifecycleConfiguration bucketLifecycleConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("LifecycleConfiguration");
        Iterator it = bucketLifecycleConfiguration.getRules().iterator();
        while (it.hasNext()) {
            writeRule(xmlWriter, (BucketLifecycleConfiguration.Rule) it.next());
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    private void writeRule(XmlWriter xmlWriter, TagSet tagSet) {
        xmlWriter.start("TagSet");
        for (String str : tagSet.getAllTags().keySet()) {
            xmlWriter.start("Tag");
            xmlWriter.start("Key").value(str).end();
            xmlWriter.start("Value").value(tagSet.getTag(str)).end();
            xmlWriter.end();
        }
        xmlWriter.end();
    }

    public byte[] convertToXmlByteArray(BucketLoggingConfiguration bucketLoggingConfiguration) {
        bucketLoggingConfiguration.getLogFilePrefix();
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("BucketLoggingStatus", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        if (bucketLoggingConfiguration.isLoggingEnabled()) {
            xmlWriter.start("LoggingEnabled");
            xmlWriter.start("TargetBucket").value(bucketLoggingConfiguration.getDestinationBucketName()).end();
            xmlWriter.start("TargetPrefix").value(bucketLoggingConfiguration.getLogFilePrefix()).end();
            xmlWriter.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketNotificationConfiguration bucketNotificationConfiguration) {
        XmlWriter start;
        String topicARN;
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("NotificationConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        for (Map.Entry entry : bucketNotificationConfiguration.getConfigurations().entrySet()) {
            String str = (String) entry.getKey();
            NotificationConfiguration notificationConfiguration = (NotificationConfiguration) entry.getValue();
            if (notificationConfiguration instanceof BucketNotificationConfiguration.TopicConfiguration) {
                xmlWriter.start("TopicConfiguration");
                xmlWriter.start("Id").value(str).end();
                start = xmlWriter.start("Topic");
                topicARN = ((BucketNotificationConfiguration.TopicConfiguration) notificationConfiguration).getTopicARN();
            } else if (notificationConfiguration instanceof QueueConfiguration) {
                xmlWriter.start("QueueConfiguration");
                xmlWriter.start("Id").value(str).end();
                start = xmlWriter.start("Queue");
                topicARN = ((QueueConfiguration) notificationConfiguration).getQueueARN();
            } else if (notificationConfiguration instanceof CloudFunctionConfiguration) {
                xmlWriter.start("CloudFunctionConfiguration");
                xmlWriter.start("Id").value(str).end();
                CloudFunctionConfiguration cloudFunctionConfiguration = (CloudFunctionConfiguration) notificationConfiguration;
                xmlWriter.start("InvocationRole").value(cloudFunctionConfiguration.getInvocationRoleARN()).end();
                start = xmlWriter.start("CloudFunction");
                topicARN = cloudFunctionConfiguration.getCloudFunctionARN();
            } else if (notificationConfiguration instanceof LambdaConfiguration) {
                xmlWriter.start("CloudFunctionConfiguration");
                xmlWriter.start("Id").value(str).end();
                start = xmlWriter.start("CloudFunction");
                topicARN = ((LambdaConfiguration) notificationConfiguration).getFunctionARN();
            }
            start.value(topicARN).end();
            addEventsAndFilterCriteria(xmlWriter, notificationConfiguration);
            xmlWriter.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketReplicationConfiguration bucketReplicationConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("ReplicationConfiguration");
        Map rules = bucketReplicationConfiguration.getRules();
        xmlWriter.start("Role").value(bucketReplicationConfiguration.getRoleARN()).end();
        for (Map.Entry entry : rules.entrySet()) {
            String str = (String) entry.getKey();
            ReplicationRule replicationRule = (ReplicationRule) entry.getValue();
            xmlWriter.start("Rule");
            xmlWriter.start("ID").value(str).end();
            xmlWriter.start("Prefix").value(replicationRule.getPrefix()).end();
            xmlWriter.start("Status").value(replicationRule.getStatus()).end();
            ReplicationDestinationConfig destinationConfig = replicationRule.getDestinationConfig();
            xmlWriter.start("Destination");
            xmlWriter.start("Bucket").value(destinationConfig.getBucketARN()).end();
            if (destinationConfig.getStorageClass() != null) {
                xmlWriter.start("StorageClass").value(destinationConfig.getStorageClass()).end();
            }
            xmlWriter.end();
            xmlWriter.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketTaggingConfiguration bucketTaggingConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("Tagging");
        Iterator it = bucketTaggingConfiguration.getAllTagSets().iterator();
        while (it.hasNext()) {
            writeRule(xmlWriter, (TagSet) it.next());
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketVersioningConfiguration bucketVersioningConfiguration) {
        XmlWriter start;
        String str;
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("VersioningConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        xmlWriter.start("Status").value(bucketVersioningConfiguration.getStatus()).end();
        Boolean isMfaDeleteEnabled = bucketVersioningConfiguration.isMfaDeleteEnabled();
        if (isMfaDeleteEnabled != null) {
            if (isMfaDeleteEnabled.booleanValue()) {
                start = xmlWriter.start("MfaDelete");
                str = "Enabled";
            } else {
                start = xmlWriter.start("MfaDelete");
                str = "Disabled";
            }
            start.value(str).end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(BucketWebsiteConfiguration bucketWebsiteConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("WebsiteConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        if (bucketWebsiteConfiguration.getIndexDocumentSuffix() != null) {
            XmlWriter start = xmlWriter.start("IndexDocument");
            start.start("Suffix").value(bucketWebsiteConfiguration.getIndexDocumentSuffix()).end();
            start.end();
        }
        if (bucketWebsiteConfiguration.getErrorDocument() != null) {
            XmlWriter start2 = xmlWriter.start("ErrorDocument");
            start2.start("Key").value(bucketWebsiteConfiguration.getErrorDocument()).end();
            start2.end();
        }
        RedirectRule redirectAllRequestsTo = bucketWebsiteConfiguration.getRedirectAllRequestsTo();
        if (redirectAllRequestsTo != null) {
            XmlWriter start3 = xmlWriter.start("RedirectAllRequestsTo");
            if (redirectAllRequestsTo.getprotocol() != null) {
                xmlWriter.start("Protocol").value(redirectAllRequestsTo.getprotocol()).end();
            }
            if (redirectAllRequestsTo.getHostName() != null) {
                xmlWriter.start("HostName").value(redirectAllRequestsTo.getHostName()).end();
            }
            if (redirectAllRequestsTo.getReplaceKeyPrefixWith() != null) {
                xmlWriter.start("ReplaceKeyPrefixWith").value(redirectAllRequestsTo.getReplaceKeyPrefixWith()).end();
            }
            if (redirectAllRequestsTo.getReplaceKeyWith() != null) {
                xmlWriter.start("ReplaceKeyWith").value(redirectAllRequestsTo.getReplaceKeyWith()).end();
            }
            start3.end();
        }
        if (bucketWebsiteConfiguration.getRoutingRules() != null && bucketWebsiteConfiguration.getRoutingRules().size() > 0) {
            XmlWriter start4 = xmlWriter.start("RoutingRules");
            Iterator it = bucketWebsiteConfiguration.getRoutingRules().iterator();
            while (it.hasNext()) {
                writeRule(start4, (RoutingRule) it.next());
            }
            start4.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(AnalyticsConfiguration analyticsConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("AnalyticsConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        addParameterIfNotNull(xmlWriter, "Id", analyticsConfiguration.getId());
        writeAnalyticsFilter(xmlWriter, analyticsConfiguration.getFilter());
        writeStorageClassAnalysis(xmlWriter, analyticsConfiguration.getStorageClassAnalysis());
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(InventoryConfiguration inventoryConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("InventoryConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        xmlWriter.start("Id").value(inventoryConfiguration.getId()).end();
        xmlWriter.start("IsEnabled").value(String.valueOf(inventoryConfiguration.isEnabled())).end();
        xmlWriter.start("IncludedObjectVersions").value(inventoryConfiguration.getIncludedObjectVersions()).end();
        writeInventoryDestination(xmlWriter, inventoryConfiguration.getDestination());
        writeInventoryFilter(xmlWriter, inventoryConfiguration.getInventoryFilter());
        addInventorySchedule(xmlWriter, inventoryConfiguration.getSchedule());
        addInventoryOptionalFields(xmlWriter, inventoryConfiguration.getOptionalFields());
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public byte[] convertToXmlByteArray(MetricsConfiguration metricsConfiguration) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("MetricsConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        addParameterIfNotNull(xmlWriter, "Id", metricsConfiguration.getId());
        writeMetricsFilter(xmlWriter, metricsConfiguration.getFilter());
        xmlWriter.end();
        return xmlWriter.getBytes();
    }
}
