package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.s3.KeyWrapException;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsAccessor;
import com.amazonaws.services.s3.model.ExtraMaterialsDescription;
import com.amazonaws.services.s3.model.KMSEncryptionMaterials;
import com.amazonaws.services.s3.model.MaterialsDescriptionProvider;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class ContentCryptoMaterial {
    private final CipherLite cipherLite;
    private final byte[] encryptedCEK;
    private final Map kekMaterialsDescription;
    private final String keyWrappingAlgorithm;

    public ContentCryptoMaterial(Map map, byte[] bArr, String str, CipherLite cipherLite) {
        this.cipherLite = cipherLite;
        this.keyWrappingAlgorithm = str;
        this.encryptedCEK = (byte[]) bArr.clone();
        this.kekMaterialsDescription = map;
    }

    private static SecretKey cek(byte[] bArr, String str, EncryptionMaterials encryptionMaterials, Provider provider, ContentCryptoScheme contentCryptoScheme, AWSKMSClient aWSKMSClient) {
        PrivateKey symmetricKey;
        if (KMSSecuredCEK.isKMSKeyWrapped(str)) {
            return cekByKMS(bArr, str, encryptionMaterials, contentCryptoScheme, aWSKMSClient);
        }
        if (encryptionMaterials.getKeyPair() != null) {
            symmetricKey = encryptionMaterials.getKeyPair().getPrivate();
            if (symmetricKey == null) {
                throw new AmazonClientException("Key encrypting key not available");
            }
        } else {
            symmetricKey = encryptionMaterials.getSymmetricKey();
            if (symmetricKey == null) {
                throw new AmazonClientException("Key encrypting key not available");
            }
        }
        try {
            if (str != null) {
                Cipher cipher = provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
                cipher.init(4, symmetricKey);
                return cipher.unwrap(bArr, str, 3);
            }
            Cipher cipher2 = provider != null ? Cipher.getInstance(symmetricKey.getAlgorithm(), provider) : Cipher.getInstance(symmetricKey.getAlgorithm());
            cipher2.init(2, symmetricKey);
            return new SecretKeySpec(cipher2.doFinal(bArr), "AES");
        } catch (Exception e) {
            throw new AmazonClientException("Unable to decrypt symmetric key from object metadata", e);
        }
    }

    private static SecretKey cekByKMS(byte[] bArr, String str, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, AWSKMSClient aWSKMSClient) {
        return new SecretKeySpec(BinaryUtils.copyAllBytesFrom(aWSKMSClient.decrypt(new DecryptRequest().withEncryptionContext(encryptionMaterials.getMaterialsDescription()).withCiphertextBlob(ByteBuffer.wrap(bArr))).getPlaintext()), contentCryptoScheme.getKeyGeneratorAlgorithm());
    }

    private static String convertStreamToString(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StringUtils.UTF8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    inputStream.close();
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public static ContentCryptoMaterial create(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        return doCreate(secretKey, bArr, encryptionMaterials, contentCryptoScheme, s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
    }

    private static ContentCryptoMaterial doCreate(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, ContentCryptoScheme contentCryptoScheme, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        return wrap(secretKey, bArr, contentCryptoScheme, provider, secureCEK(secretKey, encryptionMaterials, s3CryptoScheme.getKeyWrapScheme(), s3CryptoScheme.getSecureRandom(), provider, aWSKMSClient, amazonWebServiceRequest));
    }

    public static ContentCryptoMaterial fromInstructionFile(Map map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, boolean z, AWSKMSClient aWSKMSClient) {
        return fromInstructionFile0(map, encryptionMaterialsAccessor, provider, null, ExtraMaterialsDescription.NONE, z, aWSKMSClient);
    }

    private static ContentCryptoMaterial fromInstructionFile0(Map map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        EncryptionMaterials encryptionMaterials;
        int parseInt;
        String str = (String) map.get("x-amz-key-v2");
        if (str == null && (str = (String) map.get("x-amz-key")) == null) {
            throw new AmazonClientException("Content encrypting key not found.");
        }
        byte[] decode = Base64.decode(str);
        byte[] decode2 = Base64.decode((String) map.get("x-amz-iv"));
        if (decode == null || decode2 == null) {
            throw new AmazonClientException("Necessary encryption info not found in the instruction file " + map);
        }
        String str2 = (String) map.get("x-amz-wrap-alg");
        boolean isKMSKeyWrapped = KMSSecuredCEK.isKMSKeyWrapped(str2);
        Map matdescFromJson = matdescFromJson((String) map.get("x-amz-matdesc"));
        Map mergeInto = (extraMaterialsDescription == null || isKMSKeyWrapped) ? matdescFromJson : extraMaterialsDescription.mergeInto(matdescFromJson);
        if (isKMSKeyWrapped) {
            encryptionMaterials = new KMSEncryptionMaterials((String) matdescFromJson.get("kms_cmk_id"));
            encryptionMaterials.addDescriptions(matdescFromJson);
        } else {
            encryptionMaterials = encryptionMaterialsAccessor == null ? null : encryptionMaterialsAccessor.getEncryptionMaterials(mergeInto);
            if (encryptionMaterials == null) {
                throw new AmazonClientException("Unable to retrieve the encryption materials that originally encrypted object corresponding to instruction file " + map);
            }
        }
        EncryptionMaterials encryptionMaterials2 = encryptionMaterials;
        String str3 = (String) map.get("x-amz-cek-alg");
        boolean z2 = jArr != null;
        ContentCryptoScheme fromCEKAlgo = ContentCryptoScheme.fromCEKAlgo(str3, z2);
        if (z2) {
            decode2 = fromCEKAlgo.adjustIV(decode2, jArr[0]);
        } else {
            int tagLengthInBits = fromCEKAlgo.getTagLengthInBits();
            if (tagLengthInBits > 0 && tagLengthInBits != (parseInt = Integer.parseInt((String) map.get("x-amz-tag-len")))) {
                throw new AmazonClientException("Unsupported tag length: " + parseInt + ", expected: " + tagLengthInBits);
            }
        }
        byte[] bArr = decode2;
        if (z && str2 == null) {
            throw newKeyWrapException();
        }
        return new ContentCryptoMaterial(mergeInto, decode, str2, fromCEKAlgo.createCipherLite(cek(decode, str2, encryptionMaterials2, provider, fromCEKAlgo, aWSKMSClient), bArr, 2, provider));
    }

    public static ContentCryptoMaterial fromObjectMetadata(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, boolean z, AWSKMSClient aWSKMSClient) {
        return fromObjectMetadata0(objectMetadata, encryptionMaterialsAccessor, provider, null, ExtraMaterialsDescription.NONE, z, aWSKMSClient);
    }

    private static ContentCryptoMaterial fromObjectMetadata0(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        EncryptionMaterials encryptionMaterials;
        int parseInt;
        Map userMetadata = objectMetadata.getUserMetadata();
        String str = (String) userMetadata.get("x-amz-key-v2");
        if (str == null && (str = (String) userMetadata.get("x-amz-key")) == null) {
            throw new AmazonClientException("Content encrypting key not found.");
        }
        byte[] decode = Base64.decode(str);
        byte[] decode2 = Base64.decode((String) userMetadata.get("x-amz-iv"));
        if (decode == null || decode2 == null) {
            throw new AmazonClientException("Content encrypting key or IV not found.");
        }
        String str2 = (String) userMetadata.get("x-amz-matdesc");
        String str3 = (String) userMetadata.get("x-amz-wrap-alg");
        boolean isKMSKeyWrapped = KMSSecuredCEK.isKMSKeyWrapped(str3);
        Map matdescFromJson = matdescFromJson(str2);
        Map mergeInto = (isKMSKeyWrapped || extraMaterialsDescription == null) ? matdescFromJson : extraMaterialsDescription.mergeInto(matdescFromJson);
        if (isKMSKeyWrapped) {
            encryptionMaterials = new KMSEncryptionMaterials((String) matdescFromJson.get("kms_cmk_id"));
            encryptionMaterials.addDescriptions(matdescFromJson);
        } else {
            encryptionMaterials = encryptionMaterialsAccessor == null ? null : encryptionMaterialsAccessor.getEncryptionMaterials(mergeInto);
            if (encryptionMaterials == null) {
                throw new AmazonClientException("Unable to retrieve the client encryption materials");
            }
        }
        EncryptionMaterials encryptionMaterials2 = encryptionMaterials;
        String str4 = (String) userMetadata.get("x-amz-cek-alg");
        boolean z2 = jArr != null;
        ContentCryptoScheme fromCEKAlgo = ContentCryptoScheme.fromCEKAlgo(str4, z2);
        if (z2) {
            decode2 = fromCEKAlgo.adjustIV(decode2, jArr[0]);
        } else {
            int tagLengthInBits = fromCEKAlgo.getTagLengthInBits();
            if (tagLengthInBits > 0 && tagLengthInBits != (parseInt = Integer.parseInt((String) userMetadata.get("x-amz-tag-len")))) {
                throw new AmazonClientException("Unsupported tag length: " + parseInt + ", expected: " + tagLengthInBits);
            }
        }
        byte[] bArr = decode2;
        if (z && str3 == null) {
            throw newKeyWrapException();
        }
        return new ContentCryptoMaterial(mergeInto, decode, str3, fromCEKAlgo.createCipherLite(cek(decode, str3, encryptionMaterials2, provider, fromCEKAlgo, aWSKMSClient), bArr, 2, provider));
    }

    private String kekMaterialDescAsJson() {
        Map kEKMaterialsDescription = getKEKMaterialsDescription();
        if (kEKMaterialsDescription == null) {
            kEKMaterialsDescription = Collections.emptyMap();
        }
        return JsonUtils.mapToString(kEKMaterialsDescription);
    }

    private static Map matdescFromJson(String str) {
        Map jsonToMap = JsonUtils.jsonToMap(str);
        if (jsonToMap == null) {
            return null;
        }
        return Collections.unmodifiableMap(jsonToMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map mergeMaterialDescriptions(EncryptionMaterials encryptionMaterials, AmazonWebServiceRequest amazonWebServiceRequest) {
        Map materialsDescription;
        Map materialsDescription2 = encryptionMaterials.getMaterialsDescription();
        if (!(amazonWebServiceRequest instanceof MaterialsDescriptionProvider) || (materialsDescription = ((MaterialsDescriptionProvider) amazonWebServiceRequest).getMaterialsDescription()) == null) {
            return materialsDescription2;
        }
        TreeMap treeMap = new TreeMap(materialsDescription2);
        treeMap.putAll(materialsDescription);
        return treeMap;
    }

    private static KeyWrapException newKeyWrapException() {
        return new KeyWrapException("Missing key-wrap for the content-encrypting-key");
    }

    public static String parseInstructionFile(S3Object s3Object) {
        try {
            return convertStreamToString(s3Object.getObjectContent());
        } catch (Exception e) {
            throw new AmazonClientException("Error parsing JSON instruction file", e);
        }
    }

    private static SecuredCEK secureCEK(SecretKey secretKey, EncryptionMaterials encryptionMaterials, S3KeyWrapScheme s3KeyWrapScheme, SecureRandom secureRandom, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        if (encryptionMaterials.isKMSEnabled()) {
            Map mergeMaterialDescriptions = mergeMaterialDescriptions(encryptionMaterials, amazonWebServiceRequest);
            EncryptRequest withPlaintext = new EncryptRequest().withEncryptionContext(mergeMaterialDescriptions).withKeyId(encryptionMaterials.getCustomerMasterKeyId()).withPlaintext(ByteBuffer.wrap(secretKey.getEncoded()));
            withPlaintext.withGeneralProgressListener(amazonWebServiceRequest.getGeneralProgressListener()).withRequestMetricCollector(amazonWebServiceRequest.getRequestMetricCollector());
            return new KMSSecuredCEK(BinaryUtils.copyAllBytesFrom(aWSKMSClient.encrypt(withPlaintext).getCiphertextBlob()), mergeMaterialDescriptions);
        }
        Map materialsDescription = encryptionMaterials.getMaterialsDescription();
        PublicKey publicKey = encryptionMaterials.getKeyPair() != null ? encryptionMaterials.getKeyPair().getPublic() : encryptionMaterials.getSymmetricKey();
        String keyWrapAlgorithm = s3KeyWrapScheme.getKeyWrapAlgorithm(publicKey, provider);
        try {
            if (keyWrapAlgorithm != null) {
                Cipher cipher = provider == null ? Cipher.getInstance(keyWrapAlgorithm) : Cipher.getInstance(keyWrapAlgorithm, provider);
                cipher.init(3, publicKey, secureRandom);
                return new SecuredCEK(cipher.wrap(secretKey), keyWrapAlgorithm, materialsDescription);
            }
            byte[] encoded = secretKey.getEncoded();
            String algorithm = publicKey.getAlgorithm();
            Cipher cipher2 = provider != null ? Cipher.getInstance(algorithm, provider) : Cipher.getInstance(algorithm);
            cipher2.init(1, publicKey);
            return new SecuredCEK(cipher2.doFinal(encoded), null, materialsDescription);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to encrypt symmetric key", e);
        }
    }

    private String toJsonStringEO() {
        HashMap hashMap = new HashMap();
        hashMap.put("x-amz-key", Base64.encodeAsString(getEncryptedCEK()));
        hashMap.put("x-amz-iv", Base64.encodeAsString(this.cipherLite.getIV()));
        hashMap.put("x-amz-matdesc", kekMaterialDescAsJson());
        return JsonUtils.mapToString(hashMap);
    }

    private ObjectMetadata toObjectMetadata(ObjectMetadata objectMetadata) {
        objectMetadata.addUserMetadata("x-amz-key-v2", Base64.encodeAsString(getEncryptedCEK()));
        objectMetadata.addUserMetadata("x-amz-iv", Base64.encodeAsString(this.cipherLite.getIV()));
        objectMetadata.addUserMetadata("x-amz-matdesc", kekMaterialDescAsJson());
        ContentCryptoScheme contentCryptoScheme = getContentCryptoScheme();
        objectMetadata.addUserMetadata("x-amz-cek-alg", contentCryptoScheme.getCipherAlgorithm());
        int tagLengthInBits = contentCryptoScheme.getTagLengthInBits();
        if (tagLengthInBits > 0) {
            objectMetadata.addUserMetadata("x-amz-tag-len", String.valueOf(tagLengthInBits));
        }
        String keyWrappingAlgorithm = getKeyWrappingAlgorithm();
        if (keyWrappingAlgorithm != null) {
            objectMetadata.addUserMetadata("x-amz-wrap-alg", keyWrappingAlgorithm);
        }
        return objectMetadata;
    }

    private ObjectMetadata toObjectMetadataEO(ObjectMetadata objectMetadata) {
        objectMetadata.addUserMetadata("x-amz-key", Base64.encodeAsString(getEncryptedCEK()));
        objectMetadata.addUserMetadata("x-amz-iv", Base64.encodeAsString(this.cipherLite.getIV()));
        objectMetadata.addUserMetadata("x-amz-matdesc", kekMaterialDescAsJson());
        return objectMetadata;
    }

    private boolean usesKMSKey() {
        return KMSSecuredCEK.isKMSKeyWrapped(this.keyWrappingAlgorithm);
    }

    public static ContentCryptoMaterial wrap(SecretKey secretKey, byte[] bArr, ContentCryptoScheme contentCryptoScheme, Provider provider, SecuredCEK securedCEK) {
        return new ContentCryptoMaterial(securedCEK.getMaterialDescription(), securedCEK.getEncrypted(), securedCEK.getKeyWrapAlgorithm(), contentCryptoScheme.createCipherLite(secretKey, bArr, 1, provider));
    }

    public CipherLite getCipherLite() {
        return this.cipherLite;
    }

    public ContentCryptoScheme getContentCryptoScheme() {
        return this.cipherLite.getContentCryptoScheme();
    }

    public byte[] getEncryptedCEK() {
        return (byte[]) this.encryptedCEK.clone();
    }

    public Map getKEKMaterialsDescription() {
        return this.kekMaterialsDescription;
    }

    public String getKeyWrappingAlgorithm() {
        return this.keyWrappingAlgorithm;
    }

    public ContentCryptoMaterial recreate(EncryptionMaterials encryptionMaterials, EncryptionMaterialsAccessor encryptionMaterialsAccessor, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        if (!usesKMSKey() && encryptionMaterials.getMaterialsDescription().equals(this.kekMaterialsDescription)) {
            throw new SecurityException("Material description of the new KEK must differ from the current one");
        }
        ContentCryptoMaterial create = create(cek(this.encryptedCEK, this.keyWrappingAlgorithm, usesKMSKey() ? new KMSEncryptionMaterials((String) this.kekMaterialsDescription.get("kms_cmk_id")) : encryptionMaterialsAccessor.getEncryptionMaterials(this.kekMaterialsDescription), provider, getContentCryptoScheme(), aWSKMSClient), this.cipherLite.getIV(), encryptionMaterials, getContentCryptoScheme(), s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
        if (Arrays.equals(create.encryptedCEK, this.encryptedCEK)) {
            throw new SecurityException("The new KEK must differ from the original");
        }
        return create;
    }

    public String toJsonString() {
        HashMap hashMap = new HashMap();
        hashMap.put("x-amz-key-v2", Base64.encodeAsString(getEncryptedCEK()));
        hashMap.put("x-amz-iv", Base64.encodeAsString(this.cipherLite.getIV()));
        hashMap.put("x-amz-matdesc", kekMaterialDescAsJson());
        ContentCryptoScheme contentCryptoScheme = getContentCryptoScheme();
        hashMap.put("x-amz-cek-alg", contentCryptoScheme.getCipherAlgorithm());
        int tagLengthInBits = contentCryptoScheme.getTagLengthInBits();
        if (tagLengthInBits > 0) {
            hashMap.put("x-amz-tag-len", String.valueOf(tagLengthInBits));
        }
        String keyWrappingAlgorithm = getKeyWrappingAlgorithm();
        if (keyWrappingAlgorithm != null) {
            hashMap.put("x-amz-wrap-alg", keyWrappingAlgorithm);
        }
        return JsonUtils.mapToString(hashMap);
    }

    public static ContentCryptoMaterial create(SecretKey secretKey, byte[] bArr, EncryptionMaterials encryptionMaterials, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        return doCreate(secretKey, bArr, encryptionMaterials, s3CryptoScheme.getContentCryptoScheme(), s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
    }

    public static ContentCryptoMaterial fromInstructionFile(Map map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        return fromInstructionFile0(map, encryptionMaterialsAccessor, provider, jArr, extraMaterialsDescription, z, aWSKMSClient);
    }

    public static ContentCryptoMaterial fromObjectMetadata(ObjectMetadata objectMetadata, EncryptionMaterialsAccessor encryptionMaterialsAccessor, Provider provider, long[] jArr, ExtraMaterialsDescription extraMaterialsDescription, boolean z, AWSKMSClient aWSKMSClient) {
        return fromObjectMetadata0(objectMetadata, encryptionMaterialsAccessor, provider, jArr, extraMaterialsDescription, z, aWSKMSClient);
    }

    public ContentCryptoMaterial recreate(Map map, EncryptionMaterialsAccessor encryptionMaterialsAccessor, S3CryptoScheme s3CryptoScheme, Provider provider, AWSKMSClient aWSKMSClient, AmazonWebServiceRequest amazonWebServiceRequest) {
        if (!usesKMSKey() && map.equals(this.kekMaterialsDescription)) {
            throw new SecurityException("Material description of the new KEK must differ from the current one");
        }
        EncryptionMaterials kMSEncryptionMaterials = usesKMSKey() ? new KMSEncryptionMaterials((String) this.kekMaterialsDescription.get("kms_cmk_id")) : encryptionMaterialsAccessor.getEncryptionMaterials(this.kekMaterialsDescription);
        EncryptionMaterials encryptionMaterials = encryptionMaterialsAccessor.getEncryptionMaterials(map);
        if (encryptionMaterials != null) {
            ContentCryptoMaterial create = create(cek(this.encryptedCEK, this.keyWrappingAlgorithm, kMSEncryptionMaterials, provider, getContentCryptoScheme(), aWSKMSClient), this.cipherLite.getIV(), encryptionMaterials, getContentCryptoScheme(), s3CryptoScheme, provider, aWSKMSClient, amazonWebServiceRequest);
            if (Arrays.equals(create.encryptedCEK, this.encryptedCEK)) {
                throw new SecurityException("The new KEK must differ from the original");
            }
            return create;
        }
        throw new AmazonClientException("No material available with the description " + map + " from the encryption material provider");
    }

    public String toJsonString(CryptoMode cryptoMode) {
        return (cryptoMode != CryptoMode.EncryptionOnly || usesKMSKey()) ? toJsonString() : toJsonStringEO();
    }

    public ObjectMetadata toObjectMetadata(ObjectMetadata objectMetadata, CryptoMode cryptoMode) {
        return (cryptoMode != CryptoMode.EncryptionOnly || usesKMSKey()) ? toObjectMetadata(objectMetadata) : toObjectMetadataEO(objectMetadata);
    }
}
