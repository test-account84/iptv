package com.amazonaws.amplify.generated.graphql;

import S8.b;
import S8.d;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import v1.c;
import v1.e;
import v1.f;
import v1.g;
import v1.k;
import v1.l;
import v1.m;
import v1.n;
import v1.o;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class UpdateSmartersNewMutation implements e {
    public static final String OPERATION_DEFINITION = "mutation UpdateSmartersNew($input: UpdateSmartersNewInput!, $condition: ModelSmartersNewConditionInput) {\n  updateSmartersNew(input: $input, condition: $condition) {\n    __typename\n    id\n    config1\n    config2\n    config3\n    config4\n    config5\n    config6\n    config7\n    config8\n    config9\n    config10\n    config11\n    config12\n    config13\n    config14\n    config15\n    config16\n    config17\n    config18\n    config19\n    config20\n    config21\n    config22\n    config23\n    config24\n    config25\n    config26\n    config27\n    config28\n    config29\n    config30\n    config31\n    config32\n    config33\n    config34\n    config35\n    createdAt\n    updatedAt\n  }\n}";
    private static final g OPERATION_NAME = new 1();
    public static final String QUERY_DOCUMENT = "mutation UpdateSmartersNew($input: UpdateSmartersNewInput!, $condition: ModelSmartersNewConditionInput) {\n  updateSmartersNew(input: $input, condition: $condition) {\n    __typename\n    id\n    config1\n    config2\n    config3\n    config4\n    config5\n    config6\n    config7\n    config8\n    config9\n    config10\n    config11\n    config12\n    config13\n    config14\n    config15\n    config16\n    config17\n    config18\n    config19\n    config20\n    config21\n    config22\n    config23\n    config24\n    config25\n    config26\n    config27\n    config28\n    config29\n    config30\n    config31\n    config32\n    config33\n    config34\n    config35\n    createdAt\n    updatedAt\n  }\n}";
    private final Variables variables;

    public class 1 implements g {
        public String name() {
            return "UpdateSmartersNew";
        }
    }

    public static class Data implements f.a {
        static final k[] $responseFields = {k.f("updateSmartersNew", "updateSmartersNew", new x1.f(2).b("input", new x1.f(2).b("kind", "Variable").b("variableName", "input").a()).b("condition", new x1.f(2).b("kind", "Variable").b("variableName", "condition").a()).a(), true, Collections.emptyList())};
        private volatile int $hashCode;
        private volatile boolean $hashCodeMemoized;
        private volatile String $toString;
        final UpdateSmartersNew updateSmartersNew;

        public class 1 implements m {
            public 1() {
            }

            public void marshal(o oVar) {
                k kVar = Data.$responseFields[0];
                UpdateSmartersNew updateSmartersNew = Data.this.updateSmartersNew;
                oVar.d(kVar, updateSmartersNew != null ? updateSmartersNew.marshaller() : null);
            }
        }

        public static final class Mapper implements l {
            final UpdateSmartersNew.Mapper updateSmartersNewFieldMapper = new UpdateSmartersNew.Mapper();

            public class 1 implements n.c {
                public 1() {
                }

                public UpdateSmartersNew read(n nVar) {
                    return Mapper.this.updateSmartersNewFieldMapper.map(nVar);
                }
            }

            public Data map(n nVar) {
                return new Data((UpdateSmartersNew) nVar.b(Data.$responseFields[0], new 1()));
            }
        }

        public Data(UpdateSmartersNew updateSmartersNew) {
            this.updateSmartersNew = updateSmartersNew;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            UpdateSmartersNew updateSmartersNew = this.updateSmartersNew;
            UpdateSmartersNew updateSmartersNew2 = ((Data) obj).updateSmartersNew;
            return updateSmartersNew == null ? updateSmartersNew2 == null : updateSmartersNew.equals(updateSmartersNew2);
        }

        public int hashCode() {
            if (!this.$hashCodeMemoized) {
                UpdateSmartersNew updateSmartersNew = this.updateSmartersNew;
                this.$hashCode = (updateSmartersNew == null ? 0 : updateSmartersNew.hashCode()) ^ 1000003;
                this.$hashCodeMemoized = true;
            }
            return this.$hashCode;
        }

        public m marshaller() {
            return new 1();
        }

        public String toString() {
            if (this.$toString == null) {
                this.$toString = "Data{updateSmartersNew=" + this.updateSmartersNew + "}";
            }
            return this.$toString;
        }

        public UpdateSmartersNew updateSmartersNew() {
            return this.updateSmartersNew;
        }
    }

    public static class UpdateSmartersNew {
        static final k[] $responseFields;
        private volatile int $hashCode;
        private volatile boolean $hashCodeMemoized;
        private volatile String $toString;
        final String __typename;
        final String config1;
        final String config10;
        final String config11;
        final String config12;
        final String config13;
        final String config14;
        final String config15;
        final String config16;
        final String config17;
        final String config18;
        final String config19;
        final String config2;
        final String config20;
        final String config21;
        final String config22;
        final String config23;
        final String config24;
        final String config25;
        final String config26;
        final String config27;
        final String config28;
        final String config29;
        final String config3;
        final String config30;
        final String config31;
        final String config32;
        final String config33;
        final String config34;
        final String config35;
        final String config4;
        final String config5;
        final String config6;
        final String config7;
        final String config8;
        final String config9;
        final String createdAt;
        final String id;
        final String updatedAt;

        public class 1 implements m {
            public 1() {
            }

            public void marshal(o oVar) {
                k[] kVarArr = UpdateSmartersNew.$responseFields;
                oVar.b(kVarArr[0], UpdateSmartersNew.this.__typename);
                oVar.c((k.a) kVarArr[1], UpdateSmartersNew.this.id);
                oVar.b(kVarArr[2], UpdateSmartersNew.this.config1);
                oVar.b(kVarArr[3], UpdateSmartersNew.this.config2);
                oVar.b(kVarArr[4], UpdateSmartersNew.this.config3);
                oVar.b(kVarArr[5], UpdateSmartersNew.this.config4);
                oVar.b(kVarArr[6], UpdateSmartersNew.this.config5);
                oVar.b(kVarArr[7], UpdateSmartersNew.this.config6);
                oVar.b(kVarArr[8], UpdateSmartersNew.this.config7);
                oVar.b(kVarArr[9], UpdateSmartersNew.this.config8);
                oVar.b(kVarArr[10], UpdateSmartersNew.this.config9);
                oVar.b(kVarArr[11], UpdateSmartersNew.this.config10);
                oVar.b(kVarArr[12], UpdateSmartersNew.this.config11);
                oVar.b(kVarArr[13], UpdateSmartersNew.this.config12);
                oVar.b(kVarArr[14], UpdateSmartersNew.this.config13);
                oVar.b(kVarArr[15], UpdateSmartersNew.this.config14);
                oVar.b(kVarArr[16], UpdateSmartersNew.this.config15);
                oVar.b(kVarArr[17], UpdateSmartersNew.this.config16);
                oVar.b(kVarArr[18], UpdateSmartersNew.this.config17);
                oVar.b(kVarArr[19], UpdateSmartersNew.this.config18);
                oVar.b(kVarArr[20], UpdateSmartersNew.this.config19);
                oVar.b(kVarArr[21], UpdateSmartersNew.this.config20);
                oVar.b(kVarArr[22], UpdateSmartersNew.this.config21);
                oVar.b(kVarArr[23], UpdateSmartersNew.this.config22);
                oVar.b(kVarArr[24], UpdateSmartersNew.this.config23);
                oVar.b(kVarArr[25], UpdateSmartersNew.this.config24);
                oVar.b(kVarArr[26], UpdateSmartersNew.this.config25);
                oVar.b(kVarArr[27], UpdateSmartersNew.this.config26);
                oVar.b(kVarArr[28], UpdateSmartersNew.this.config27);
                oVar.b(kVarArr[29], UpdateSmartersNew.this.config28);
                oVar.b(kVarArr[30], UpdateSmartersNew.this.config29);
                oVar.b(kVarArr[31], UpdateSmartersNew.this.config30);
                oVar.b(kVarArr[32], UpdateSmartersNew.this.config31);
                oVar.b(kVarArr[33], UpdateSmartersNew.this.config32);
                oVar.b(kVarArr[34], UpdateSmartersNew.this.config33);
                oVar.b(kVarArr[35], UpdateSmartersNew.this.config34);
                oVar.b(kVarArr[36], UpdateSmartersNew.this.config35);
                oVar.c((k.a) kVarArr[37], UpdateSmartersNew.this.createdAt);
                oVar.c((k.a) kVarArr[38], UpdateSmartersNew.this.updatedAt);
            }
        }

        public static final class Mapper implements l {
            public UpdateSmartersNew map(n nVar) {
                k[] kVarArr = UpdateSmartersNew.$responseFields;
                return new UpdateSmartersNew(nVar.c(kVarArr[0]), (String) nVar.d((k.a) kVarArr[1]), nVar.c(kVarArr[2]), nVar.c(kVarArr[3]), nVar.c(kVarArr[4]), nVar.c(kVarArr[5]), nVar.c(kVarArr[6]), nVar.c(kVarArr[7]), nVar.c(kVarArr[8]), nVar.c(kVarArr[9]), nVar.c(kVarArr[10]), nVar.c(kVarArr[11]), nVar.c(kVarArr[12]), nVar.c(kVarArr[13]), nVar.c(kVarArr[14]), nVar.c(kVarArr[15]), nVar.c(kVarArr[16]), nVar.c(kVarArr[17]), nVar.c(kVarArr[18]), nVar.c(kVarArr[19]), nVar.c(kVarArr[20]), nVar.c(kVarArr[21]), nVar.c(kVarArr[22]), nVar.c(kVarArr[23]), nVar.c(kVarArr[24]), nVar.c(kVarArr[25]), nVar.c(kVarArr[26]), nVar.c(kVarArr[27]), nVar.c(kVarArr[28]), nVar.c(kVarArr[29]), nVar.c(kVarArr[30]), nVar.c(kVarArr[31]), nVar.c(kVarArr[32]), nVar.c(kVarArr[33]), nVar.c(kVarArr[34]), nVar.c(kVarArr[35]), nVar.c(kVarArr[36]), (String) nVar.d((k.a) kVarArr[37]), (String) nVar.d((k.a) kVarArr[38]));
            }
        }

        static {
            k g = k.g("__typename", "__typename", null, false, Collections.emptyList());
            k.a d = k.d("id", "id", null, false, b.ID, Collections.emptyList());
            k g2 = k.g("config1", "config1", null, false, Collections.emptyList());
            k g3 = k.g("config2", "config2", null, false, Collections.emptyList());
            k g4 = k.g("config3", "config3", null, false, Collections.emptyList());
            k g5 = k.g("config4", "config4", null, false, Collections.emptyList());
            k g6 = k.g("config5", "config5", null, false, Collections.emptyList());
            k g7 = k.g("config6", "config6", null, false, Collections.emptyList());
            k g8 = k.g("config7", "config7", null, false, Collections.emptyList());
            k g9 = k.g("config8", "config8", null, false, Collections.emptyList());
            k g10 = k.g("config9", "config9", null, false, Collections.emptyList());
            k g11 = k.g("config10", "config10", null, false, Collections.emptyList());
            k g12 = k.g("config11", "config11", null, false, Collections.emptyList());
            k g13 = k.g("config12", "config12", null, false, Collections.emptyList());
            k g14 = k.g("config13", "config13", null, false, Collections.emptyList());
            k g15 = k.g("config14", "config14", null, false, Collections.emptyList());
            k g16 = k.g("config15", "config15", null, false, Collections.emptyList());
            k g17 = k.g("config16", "config16", null, false, Collections.emptyList());
            k g18 = k.g("config17", "config17", null, false, Collections.emptyList());
            k g19 = k.g("config18", "config18", null, false, Collections.emptyList());
            k g20 = k.g("config19", "config19", null, false, Collections.emptyList());
            k g21 = k.g("config20", "config20", null, false, Collections.emptyList());
            k g22 = k.g("config21", "config21", null, false, Collections.emptyList());
            k g23 = k.g("config22", "config22", null, false, Collections.emptyList());
            k g24 = k.g("config23", "config23", null, false, Collections.emptyList());
            k g25 = k.g("config24", "config24", null, false, Collections.emptyList());
            k g26 = k.g("config25", "config25", null, false, Collections.emptyList());
            k g27 = k.g("config26", "config26", null, false, Collections.emptyList());
            k g28 = k.g("config27", "config27", null, false, Collections.emptyList());
            k g29 = k.g("config28", "config28", null, false, Collections.emptyList());
            k g30 = k.g("config29", "config29", null, false, Collections.emptyList());
            k g31 = k.g("config30", "config30", null, false, Collections.emptyList());
            k g32 = k.g("config31", "config31", null, false, Collections.emptyList());
            k g33 = k.g("config32", "config32", null, false, Collections.emptyList());
            k g34 = k.g("config33", "config33", null, false, Collections.emptyList());
            k g35 = k.g("config34", "config34", null, false, Collections.emptyList());
            k g36 = k.g("config35", "config35", null, false, Collections.emptyList());
            b bVar = b.AWSDATETIME;
            $responseFields = new k[]{g, d, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16, g17, g18, g19, g20, g21, g22, g23, g24, g25, g26, g27, g28, g29, g30, g31, g32, g33, g34, g35, g36, k.d("createdAt", "createdAt", null, false, bVar, Collections.emptyList()), k.d("updatedAt", "updatedAt", null, false, bVar, Collections.emptyList())};
        }

        public UpdateSmartersNew(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39) {
            this.__typename = (String) x1.g.c(str, "__typename == null");
            this.id = (String) x1.g.c(str2, "id == null");
            this.config1 = (String) x1.g.c(str3, "config1 == null");
            this.config2 = (String) x1.g.c(str4, "config2 == null");
            this.config3 = (String) x1.g.c(str5, "config3 == null");
            this.config4 = (String) x1.g.c(str6, "config4 == null");
            this.config5 = (String) x1.g.c(str7, "config5 == null");
            this.config6 = (String) x1.g.c(str8, "config6 == null");
            this.config7 = (String) x1.g.c(str9, "config7 == null");
            this.config8 = (String) x1.g.c(str10, "config8 == null");
            this.config9 = (String) x1.g.c(str11, "config9 == null");
            this.config10 = (String) x1.g.c(str12, "config10 == null");
            this.config11 = (String) x1.g.c(str13, "config11 == null");
            this.config12 = (String) x1.g.c(str14, "config12 == null");
            this.config13 = (String) x1.g.c(str15, "config13 == null");
            this.config14 = (String) x1.g.c(str16, "config14 == null");
            this.config15 = (String) x1.g.c(str17, "config15 == null");
            this.config16 = (String) x1.g.c(str18, "config16 == null");
            this.config17 = (String) x1.g.c(str19, "config17 == null");
            this.config18 = (String) x1.g.c(str20, "config18 == null");
            this.config19 = (String) x1.g.c(str21, "config19 == null");
            this.config20 = (String) x1.g.c(str22, "config20 == null");
            this.config21 = (String) x1.g.c(str23, "config21 == null");
            this.config22 = (String) x1.g.c(str24, "config22 == null");
            this.config23 = (String) x1.g.c(str25, "config23 == null");
            this.config24 = (String) x1.g.c(str26, "config24 == null");
            this.config25 = (String) x1.g.c(str27, "config25 == null");
            this.config26 = (String) x1.g.c(str28, "config26 == null");
            this.config27 = (String) x1.g.c(str29, "config27 == null");
            this.config28 = (String) x1.g.c(str30, "config28 == null");
            this.config29 = (String) x1.g.c(str31, "config29 == null");
            this.config30 = (String) x1.g.c(str32, "config30 == null");
            this.config31 = (String) x1.g.c(str33, "config31 == null");
            this.config32 = (String) x1.g.c(str34, "config32 == null");
            this.config33 = (String) x1.g.c(str35, "config33 == null");
            this.config34 = (String) x1.g.c(str36, "config34 == null");
            this.config35 = (String) x1.g.c(str37, "config35 == null");
            this.createdAt = (String) x1.g.c(str38, "createdAt == null");
            this.updatedAt = (String) x1.g.c(str39, "updatedAt == null");
        }

        public String __typename() {
            return this.__typename;
        }

        public String config1() {
            return this.config1;
        }

        public String config10() {
            return this.config10;
        }

        public String config11() {
            return this.config11;
        }

        public String config12() {
            return this.config12;
        }

        public String config13() {
            return this.config13;
        }

        public String config14() {
            return this.config14;
        }

        public String config15() {
            return this.config15;
        }

        public String config16() {
            return this.config16;
        }

        public String config17() {
            return this.config17;
        }

        public String config18() {
            return this.config18;
        }

        public String config19() {
            return this.config19;
        }

        public String config2() {
            return this.config2;
        }

        public String config20() {
            return this.config20;
        }

        public String config21() {
            return this.config21;
        }

        public String config22() {
            return this.config22;
        }

        public String config23() {
            return this.config23;
        }

        public String config24() {
            return this.config24;
        }

        public String config25() {
            return this.config25;
        }

        public String config26() {
            return this.config26;
        }

        public String config27() {
            return this.config27;
        }

        public String config28() {
            return this.config28;
        }

        public String config29() {
            return this.config29;
        }

        public String config3() {
            return this.config3;
        }

        public String config30() {
            return this.config30;
        }

        public String config31() {
            return this.config31;
        }

        public String config32() {
            return this.config32;
        }

        public String config33() {
            return this.config33;
        }

        public String config34() {
            return this.config34;
        }

        public String config35() {
            return this.config35;
        }

        public String config4() {
            return this.config4;
        }

        public String config5() {
            return this.config5;
        }

        public String config6() {
            return this.config6;
        }

        public String config7() {
            return this.config7;
        }

        public String config8() {
            return this.config8;
        }

        public String config9() {
            return this.config9;
        }

        public String createdAt() {
            return this.createdAt;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UpdateSmartersNew)) {
                return false;
            }
            UpdateSmartersNew updateSmartersNew = (UpdateSmartersNew) obj;
            return this.__typename.equals(updateSmartersNew.__typename) && this.id.equals(updateSmartersNew.id) && this.config1.equals(updateSmartersNew.config1) && this.config2.equals(updateSmartersNew.config2) && this.config3.equals(updateSmartersNew.config3) && this.config4.equals(updateSmartersNew.config4) && this.config5.equals(updateSmartersNew.config5) && this.config6.equals(updateSmartersNew.config6) && this.config7.equals(updateSmartersNew.config7) && this.config8.equals(updateSmartersNew.config8) && this.config9.equals(updateSmartersNew.config9) && this.config10.equals(updateSmartersNew.config10) && this.config11.equals(updateSmartersNew.config11) && this.config12.equals(updateSmartersNew.config12) && this.config13.equals(updateSmartersNew.config13) && this.config14.equals(updateSmartersNew.config14) && this.config15.equals(updateSmartersNew.config15) && this.config16.equals(updateSmartersNew.config16) && this.config17.equals(updateSmartersNew.config17) && this.config18.equals(updateSmartersNew.config18) && this.config19.equals(updateSmartersNew.config19) && this.config20.equals(updateSmartersNew.config20) && this.config21.equals(updateSmartersNew.config21) && this.config22.equals(updateSmartersNew.config22) && this.config23.equals(updateSmartersNew.config23) && this.config24.equals(updateSmartersNew.config24) && this.config25.equals(updateSmartersNew.config25) && this.config26.equals(updateSmartersNew.config26) && this.config27.equals(updateSmartersNew.config27) && this.config28.equals(updateSmartersNew.config28) && this.config29.equals(updateSmartersNew.config29) && this.config30.equals(updateSmartersNew.config30) && this.config31.equals(updateSmartersNew.config31) && this.config32.equals(updateSmartersNew.config32) && this.config33.equals(updateSmartersNew.config33) && this.config34.equals(updateSmartersNew.config34) && this.config35.equals(updateSmartersNew.config35) && this.createdAt.equals(updateSmartersNew.createdAt) && this.updatedAt.equals(updateSmartersNew.updatedAt);
        }

        public int hashCode() {
            if (!this.$hashCodeMemoized) {
                this.$hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.__typename.hashCode() ^ 1000003) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.config1.hashCode()) * 1000003) ^ this.config2.hashCode()) * 1000003) ^ this.config3.hashCode()) * 1000003) ^ this.config4.hashCode()) * 1000003) ^ this.config5.hashCode()) * 1000003) ^ this.config6.hashCode()) * 1000003) ^ this.config7.hashCode()) * 1000003) ^ this.config8.hashCode()) * 1000003) ^ this.config9.hashCode()) * 1000003) ^ this.config10.hashCode()) * 1000003) ^ this.config11.hashCode()) * 1000003) ^ this.config12.hashCode()) * 1000003) ^ this.config13.hashCode()) * 1000003) ^ this.config14.hashCode()) * 1000003) ^ this.config15.hashCode()) * 1000003) ^ this.config16.hashCode()) * 1000003) ^ this.config17.hashCode()) * 1000003) ^ this.config18.hashCode()) * 1000003) ^ this.config19.hashCode()) * 1000003) ^ this.config20.hashCode()) * 1000003) ^ this.config21.hashCode()) * 1000003) ^ this.config22.hashCode()) * 1000003) ^ this.config23.hashCode()) * 1000003) ^ this.config24.hashCode()) * 1000003) ^ this.config25.hashCode()) * 1000003) ^ this.config26.hashCode()) * 1000003) ^ this.config27.hashCode()) * 1000003) ^ this.config28.hashCode()) * 1000003) ^ this.config29.hashCode()) * 1000003) ^ this.config30.hashCode()) * 1000003) ^ this.config31.hashCode()) * 1000003) ^ this.config32.hashCode()) * 1000003) ^ this.config33.hashCode()) * 1000003) ^ this.config34.hashCode()) * 1000003) ^ this.config35.hashCode()) * 1000003) ^ this.createdAt.hashCode()) * 1000003) ^ this.updatedAt.hashCode();
                this.$hashCodeMemoized = true;
            }
            return this.$hashCode;
        }

        public String id() {
            return this.id;
        }

        public m marshaller() {
            return new 1();
        }

        public String toString() {
            if (this.$toString == null) {
                this.$toString = "UpdateSmartersNew{__typename=" + this.__typename + ", id=" + this.id + ", config1=" + this.config1 + ", config2=" + this.config2 + ", config3=" + this.config3 + ", config4=" + this.config4 + ", config5=" + this.config5 + ", config6=" + this.config6 + ", config7=" + this.config7 + ", config8=" + this.config8 + ", config9=" + this.config9 + ", config10=" + this.config10 + ", config11=" + this.config11 + ", config12=" + this.config12 + ", config13=" + this.config13 + ", config14=" + this.config14 + ", config15=" + this.config15 + ", config16=" + this.config16 + ", config17=" + this.config17 + ", config18=" + this.config18 + ", config19=" + this.config19 + ", config20=" + this.config20 + ", config21=" + this.config21 + ", config22=" + this.config22 + ", config23=" + this.config23 + ", config24=" + this.config24 + ", config25=" + this.config25 + ", config26=" + this.config26 + ", config27=" + this.config27 + ", config28=" + this.config28 + ", config29=" + this.config29 + ", config30=" + this.config30 + ", config31=" + this.config31 + ", config32=" + this.config32 + ", config33=" + this.config33 + ", config34=" + this.config34 + ", config35=" + this.config35 + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + "}";
            }
            return this.$toString;
        }

        public String updatedAt() {
            return this.updatedAt;
        }
    }

    public static final class Variables extends f.b {
        private final d condition;
        private final S8.g input;
        private final transient Map valueMap;

        public class 1 implements c {
            public 1() {
            }

            public void marshal(v1.d dVar) throws IOException {
                Variables.access$000(Variables.this);
                throw null;
            }
        }

        public Variables(S8.g gVar, d dVar) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.valueMap = linkedHashMap;
            linkedHashMap.put("input", gVar);
            linkedHashMap.put("condition", dVar);
        }

        public static /* synthetic */ S8.g access$000(Variables variables) {
            variables.getClass();
            return null;
        }

        public static /* synthetic */ d access$100(Variables variables) {
            variables.getClass();
            return null;
        }

        public d condition() {
            return null;
        }

        public S8.g input() {
            return null;
        }

        public c marshaller() {
            return new 1();
        }

        public Map valueMap() {
            return Collections.unmodifiableMap(this.valueMap);
        }
    }

    public UpdateSmartersNewMutation(S8.g gVar, d dVar) {
        x1.g.c(gVar, "input == null");
        this.variables = new Variables(gVar, dVar);
    }

    public static Builder builder() {
        return new Builder();
    }

    public g name() {
        return OPERATION_NAME;
    }

    public String operationId() {
        return "beb36238c3748ab2d5cc21cc6d83c9ba82d1ea9116704b885767157ff79b80a7";
    }

    public String queryDocument() {
        return "mutation UpdateSmartersNew($input: UpdateSmartersNewInput!, $condition: ModelSmartersNewConditionInput) {\n  updateSmartersNew(input: $input, condition: $condition) {\n    __typename\n    id\n    config1\n    config2\n    config3\n    config4\n    config5\n    config6\n    config7\n    config8\n    config9\n    config10\n    config11\n    config12\n    config13\n    config14\n    config15\n    config16\n    config17\n    config18\n    config19\n    config20\n    config21\n    config22\n    config23\n    config24\n    config25\n    config26\n    config27\n    config28\n    config29\n    config30\n    config31\n    config32\n    config33\n    config34\n    config35\n    createdAt\n    updatedAt\n  }\n}";
    }

    public l responseFieldMapper() {
        return new Data.Mapper();
    }

    public Variables variables() {
        return this.variables;
    }

    public Data wrapData(Data data) {
        return data;
    }

    public static final class Builder {
        private d condition;
        private S8.g input;

        public UpdateSmartersNewMutation build() {
            x1.g.c(null, "input == null");
            return new UpdateSmartersNewMutation(null, null);
        }

        public Builder condition(d dVar) {
            return this;
        }

        public Builder input(S8.g gVar) {
            return this;
        }
    }
}
