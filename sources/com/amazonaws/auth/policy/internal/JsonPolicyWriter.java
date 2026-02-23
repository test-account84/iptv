package com.amazonaws.auth.policy.internal;

import com.amazonaws.auth.policy.Action;
import com.amazonaws.auth.policy.Condition;
import com.amazonaws.auth.policy.Policy;
import com.amazonaws.auth.policy.Principal;
import com.amazonaws.auth.policy.Resource;
import com.amazonaws.auth.policy.Statement;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class JsonPolicyWriter {
    private static final Log log = LogFactory.getLog("com.amazonaws.auth.policy");
    private AwsJsonWriter jsonWriter;
    private final Writer writer;

    public static class ConditionsByKey {
        private Map conditionsByKey = new HashMap();

        public void addValuesToKey(String str, List list) {
            List conditionsByKey = getConditionsByKey(str);
            if (conditionsByKey == null) {
                this.conditionsByKey.put(str, new ArrayList(list));
            } else {
                conditionsByKey.addAll(list);
            }
        }

        public boolean containsKey(String str) {
            return this.conditionsByKey.containsKey(str);
        }

        public List getConditionsByKey(String str) {
            return (List) this.conditionsByKey.get(str);
        }

        public Set keySet() {
            return this.conditionsByKey.keySet();
        }

        public void setConditionsByKey(Map map) {
            this.conditionsByKey = map;
        }

        public Map getConditionsByKey() {
            return this.conditionsByKey;
        }
    }

    public JsonPolicyWriter() {
        this.jsonWriter = null;
        StringWriter stringWriter = new StringWriter();
        this.writer = stringWriter;
        this.jsonWriter = JsonUtils.getJsonWriter(stringWriter);
    }

    private Map groupConditionsByTypeAndKey(List list) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Condition condition = (Condition) it.next();
            String type = condition.getType();
            String conditionKey = condition.getConditionKey();
            if (!hashMap.containsKey(type)) {
                hashMap.put(type, new ConditionsByKey());
            }
            ((ConditionsByKey) hashMap.get(type)).addValuesToKey(conditionKey, condition.getValues());
        }
        return hashMap;
    }

    private Map groupPrincipalByScheme(List list) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Principal principal = (Principal) it.next();
            String provider = principal.getProvider();
            if (!hashMap.containsKey(provider)) {
                hashMap.put(provider, new ArrayList());
            }
            ((List) hashMap.get(provider)).add(principal.getId());
        }
        return hashMap;
    }

    private boolean isNotNull(Object obj) {
        return obj != null;
    }

    private String jsonStringOf(Policy policy) throws IOException {
        this.jsonWriter.beginObject();
        writeJsonKeyValue("Version", policy.getVersion());
        if (isNotNull(policy.getId())) {
            writeJsonKeyValue("Id", policy.getId());
        }
        writeJsonArrayStart("Statement");
        for (Statement statement : policy.getStatements()) {
            this.jsonWriter.beginObject();
            if (isNotNull(statement.getId())) {
                writeJsonKeyValue("Sid", statement.getId());
            }
            writeJsonKeyValue("Effect", statement.getEffect().toString());
            List principals = statement.getPrincipals();
            if (isNotNull(principals) && !principals.isEmpty()) {
                writePrincipals(principals);
            }
            List actions = statement.getActions();
            if (isNotNull(actions) && !actions.isEmpty()) {
                writeActions(actions);
            }
            List resources = statement.getResources();
            if (isNotNull(resources) && !resources.isEmpty()) {
                writeResources(resources);
            }
            List conditions = statement.getConditions();
            if (isNotNull(conditions) && !conditions.isEmpty()) {
                writeConditions(conditions);
            }
            this.jsonWriter.endObject();
        }
        writeJsonArrayEnd();
        this.jsonWriter.endObject();
        this.jsonWriter.flush();
        return this.writer.toString();
    }

    private void writeActions(List list) throws IOException {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Action) it.next()).getActionName());
        }
        writeJsonArray("Action", arrayList);
    }

    private void writeConditions(List list) throws IOException {
        Map groupConditionsByTypeAndKey = groupConditionsByTypeAndKey(list);
        writeJsonObjectStart("Condition");
        for (Map.Entry entry : groupConditionsByTypeAndKey.entrySet()) {
            ConditionsByKey conditionsByKey = (ConditionsByKey) groupConditionsByTypeAndKey.get(entry.getKey());
            writeJsonObjectStart((String) entry.getKey());
            for (String str : conditionsByKey.keySet()) {
                writeJsonArray(str, conditionsByKey.getConditionsByKey(str));
            }
            writeJsonObjectEnd();
        }
        writeJsonObjectEnd();
    }

    private void writeJsonArray(String str, List list) throws IOException {
        writeJsonArrayStart(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.jsonWriter.value((String) it.next());
        }
        writeJsonArrayEnd();
    }

    private void writeJsonArrayEnd() throws IOException {
        this.jsonWriter.endArray();
    }

    private void writeJsonArrayStart(String str) throws IOException {
        this.jsonWriter.name(str);
        this.jsonWriter.beginArray();
    }

    private void writeJsonKeyValue(String str, String str2) throws IOException {
        this.jsonWriter.name(str);
        this.jsonWriter.value(str2);
    }

    private void writeJsonObjectEnd() throws IOException {
        this.jsonWriter.endObject();
    }

    private void writeJsonObjectStart(String str) throws IOException {
        this.jsonWriter.name(str);
        this.jsonWriter.beginObject();
    }

    private void writePrincipals(List list) throws IOException {
        if (list.size() == 1) {
            Principal principal = (Principal) list.get(0);
            Principal principal2 = Principal.All;
            if (principal.equals(principal2)) {
                writeJsonKeyValue("Principal", principal2.getId());
                return;
            }
        }
        writeJsonObjectStart("Principal");
        Map groupPrincipalByScheme = groupPrincipalByScheme(list);
        for (Map.Entry entry : groupPrincipalByScheme.entrySet()) {
            List list2 = (List) groupPrincipalByScheme.get(entry.getKey());
            int size = list2.size();
            String str = (String) entry.getKey();
            if (size == 1) {
                writeJsonKeyValue(str, (String) list2.get(0));
            } else {
                writeJsonArray(str, list2);
            }
        }
        writeJsonObjectEnd();
    }

    private void writeResources(List list) throws IOException {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Resource) it.next()).getId());
        }
        writeJsonArray("Resource", arrayList);
    }

    public String writePolicyToString(Policy policy) {
        try {
            if (!isNotNull(policy)) {
                throw new IllegalArgumentException("Policy cannot be null");
            }
            try {
                return jsonStringOf(policy);
            } catch (Exception e) {
                throw new IllegalArgumentException("Unable to serialize policy to JSON string: " + e.getMessage(), e);
            }
        } finally {
            try {
                this.writer.close();
            } catch (Exception unused) {
            }
        }
    }
}
