package com.amazonaws.auth.policy.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.policy.Action;
import com.amazonaws.auth.policy.Condition;
import com.amazonaws.auth.policy.Policy;
import com.amazonaws.auth.policy.Principal;
import com.amazonaws.auth.policy.Resource;
import com.amazonaws.auth.policy.Statement;
import com.amazonaws.util.json.AwsJsonReader;
import com.amazonaws.util.json.JsonUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class JsonPolicyReader {
    private static final String PRINCIPAL_SCHEMA_SERVICE = "Service";
    private static final String PRINCIPAL_SCHEMA_USER = "AWS";
    private static final String PRINICIPAL_SCHEMA_FEDERATED = "Federated";
    private AwsJsonReader reader;

    public static class NamedAction implements Action {
        private final String actionName;

        public NamedAction(String str) {
            this.actionName = str;
        }

        public String getActionName() {
            return this.actionName;
        }
    }

    private List actionsOf(AwsJsonReader awsJsonReader) throws IOException {
        LinkedList linkedList = new LinkedList();
        if (awsJsonReader.isContainer()) {
            awsJsonReader.beginArray();
            while (awsJsonReader.hasNext()) {
                linkedList.add(new NamedAction(awsJsonReader.nextString()));
            }
            awsJsonReader.endArray();
        } else {
            linkedList.add(new NamedAction(awsJsonReader.nextString()));
        }
        return linkedList;
    }

    private List conditionsOf(AwsJsonReader awsJsonReader) throws IOException {
        LinkedList linkedList = new LinkedList();
        awsJsonReader.beginObject();
        while (awsJsonReader.hasNext()) {
            convertConditionRecord(linkedList, awsJsonReader.nextName(), awsJsonReader);
        }
        awsJsonReader.endObject();
        return linkedList;
    }

    private void convertConditionRecord(List list, String str, AwsJsonReader awsJsonReader) throws IOException {
        awsJsonReader.beginObject();
        while (awsJsonReader.hasNext()) {
            String nextName = awsJsonReader.nextName();
            List linkedList = new LinkedList();
            if (awsJsonReader.isContainer()) {
                awsJsonReader.beginArray();
                while (awsJsonReader.hasNext()) {
                    linkedList.add(awsJsonReader.nextString());
                }
                awsJsonReader.endArray();
            } else {
                linkedList.add(awsJsonReader.nextString());
            }
            list.add(new Condition().withType(str).withConditionKey(nextName).withValues(linkedList));
        }
        awsJsonReader.endObject();
    }

    private Principal createPrincipal(String str, String str2) {
        if (str.equalsIgnoreCase("AWS")) {
            return new Principal(str2);
        }
        if (str.equalsIgnoreCase("Service")) {
            return new Principal(str, str2);
        }
        if (str.equalsIgnoreCase("Federated")) {
            return Principal.WebIdentityProviders.fromString(str2) != null ? new Principal(Principal.WebIdentityProviders.fromString(str2)) : new Principal("Federated", str2);
        }
        throw new AmazonClientException("Schema " + str + " is not a valid value for the principal.");
    }

    private List principalOf(AwsJsonReader awsJsonReader) throws IOException {
        LinkedList linkedList = new LinkedList();
        if (awsJsonReader.isContainer()) {
            awsJsonReader.beginObject();
            while (awsJsonReader.hasNext()) {
                String nextName = awsJsonReader.nextName();
                if (awsJsonReader.isContainer()) {
                    awsJsonReader.beginArray();
                    while (awsJsonReader.hasNext()) {
                        linkedList.add(createPrincipal(nextName, awsJsonReader.nextString()));
                    }
                    awsJsonReader.endArray();
                } else {
                    linkedList.add(createPrincipal(nextName, awsJsonReader.nextString()));
                }
            }
            awsJsonReader.endObject();
        } else {
            String nextString = awsJsonReader.nextString();
            if (!"*".equals(nextString)) {
                throw new IllegalArgumentException("Invalid principals: " + nextString);
            }
            linkedList.add(Principal.All);
        }
        return linkedList;
    }

    private List resourcesOf(AwsJsonReader awsJsonReader) throws IOException {
        LinkedList linkedList = new LinkedList();
        if (awsJsonReader.isContainer()) {
            awsJsonReader.beginArray();
            while (awsJsonReader.hasNext()) {
                linkedList.add(new Resource(awsJsonReader.nextString()));
            }
            awsJsonReader.endArray();
        } else {
            linkedList.add(new Resource(awsJsonReader.nextString()));
        }
        return linkedList;
    }

    private Statement statementOf(AwsJsonReader awsJsonReader) throws IOException {
        Statement statement = new Statement(null);
        awsJsonReader.beginObject();
        while (awsJsonReader.hasNext()) {
            String nextName = awsJsonReader.nextName();
            if ("Effect".equals(nextName)) {
                statement.setEffect(Statement.Effect.valueOf(awsJsonReader.nextString()));
            } else if ("Sid".equals(nextName)) {
                statement.setId(awsJsonReader.nextString());
            } else if ("Action".equals(nextName)) {
                statement.setActions(actionsOf(awsJsonReader));
            } else if ("Resource".equals(nextName)) {
                statement.setResources(resourcesOf(awsJsonReader));
            } else if ("Principal".equals(nextName)) {
                statement.setPrincipals((Collection) principalOf(awsJsonReader));
            } else if ("Condition".equals(nextName)) {
                statement.setConditions(conditionsOf(awsJsonReader));
            } else {
                awsJsonReader.skipValue();
            }
        }
        awsJsonReader.endObject();
        if (statement.getEffect() == null) {
            return null;
        }
        return statement;
    }

    public Policy createPolicyFromJsonString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("JSON string cannot be null");
        }
        this.reader = JsonUtils.getJsonReader(new StringReader(str));
        Policy policy = new Policy();
        LinkedList linkedList = new LinkedList();
        try {
            try {
                this.reader.beginObject();
                while (this.reader.hasNext()) {
                    String nextName = this.reader.nextName();
                    if ("Id".equals(nextName)) {
                        policy.setId(this.reader.nextString());
                    } else if ("Statement".equals(nextName)) {
                        this.reader.beginArray();
                        while (this.reader.hasNext()) {
                            linkedList.add(statementOf(this.reader));
                        }
                        this.reader.endArray();
                    } else {
                        this.reader.skipValue();
                    }
                }
                this.reader.endObject();
                try {
                    this.reader.close();
                } catch (IOException unused) {
                }
                policy.setStatements(linkedList);
                return policy;
            } catch (Exception e) {
                throw new IllegalArgumentException("Unable to generate policy object fron JSON string " + e.getMessage(), e);
            }
        } catch (Throwable th) {
            try {
                this.reader.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }
}
