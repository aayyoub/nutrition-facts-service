package io.nutritionfacts.service.domain.model;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum NutrientId {
  UNKNOWN("0"),
  ADJUSTED_PROTEIN("257"),
  ALANINE("513"),
  ALCOHOL("221"),
  ARGININE("511"),
  ASH("207"),
  ASPARTIC_ACID("514"),
  BETASITOSTEROL("641"),
  BETAINE("454"),
  CAFFEINE("262"),
  CALCIUM("301"),
  CAMPESTEROL("639"),
  CARBOHYDRATE("205"),
  CAROTENE_ALPHA("322"),
  CAROTENE_BETA("321"),
  CHOLESTEROL("601"),
  CHOLINE_TOTAL("421"),
  COPPER("312"),
  CRYPTOXANTHIN_BETA("334"),
  CYSTINE("507"),
  DIHYDROPHYLLOQUINONE("429"),
  ENERGY_KCAL("208"),
  ENERGY_KJ("268"),
  FIBER("291"),
  FLUORIDE("313"),
  FOLATE_DFE("435"),
  FOLATE_FOOD("432"),
  FOLATE_TOTAL("417"),
  FOLIC_ACID("431"),
  FRUCTOSE("212"),
  GALACTOSE("287"),
  GLUCOSE("211"),
  GLUTAMIC_ACID("515"),
  GLYCINE("516"),
  HISTIDINE("512"),
  HYDROXYPROLINE("521"),
  IRON("303"),
  ISOLEUCINE("503"),
  LACTOSE("213"),
  LEUCINE("504"),
  LUTEIN_AND_ZEAXANTHIN("338"),
  LYCOPENE("337"),
  LYSINE("505"),
  MAGNESIUM("304"),
  MALTOSE("214"),
  MANGANESE("315"),
  MENAQUINONE4("428"),
  METHIONINE("506"),
  NIACIN("406"),
  PANTOTHENIC_ACID("410"),
  PHENYLALANINE("508"),
  PHOSPHORUS("305"),
  PHYTOSTEROLS("636"),
  POTASSIUM("306"),
  PROLINE("517"),
  TOTAL_PROTEIN("203"),
  RETINOL("319"),
  RIBOFLAVIN("405"),
  SELENIUM("317"),
  SERINE("518"),
  SODIUM("307"),
  STARCH("209"),
  STIGMASTEROL("638"),
  SUCROSE("210"),
  TOTAL_SUGAR("269"),
  THEOBROMINE("263"),
  THIAMIN("404"),
  THREONINE("502"),
  TOCOPHEROL_BETA("341"),
  TOCOPHEROL_DELTA("343"),
  TOCOPHEROL_GAMMA("342"),
  TOCOTRIENOL_ALPHA("344"),
  TOCOTRIENOL_BETA("345"),
  TOCOTRIENOL_DELTA("347"),
  TOCOTRIENOL_GAMMA("346"),
  TOTAL_FAT("204"),
  TRYPTOPHAN("501"),
  TYROSINE("509"),
  VALINE("510"),
  VITAMIN_A_IU("318"),
  VITAMIN_A_RAE("320"),
  VITAMIN_B12("418"),
  VITAMIN_B12_ADDED("578"),
  VITAMIN_B6("415"),
  VITAMIN_C("401"),
  VITAMIN_D("324"),
  VITAMIN_D_D2_AND_D3("328"),
  VITAMIN_D2("325"),
  VITAMIN_D3("326"),
  VITAMIN_E("323"),
  VITAMIN_E_ADDED("573"),
  VITAMIN_K("430"),
  WATER("255"),
  ZINC("309"),
  FATTY_ACIDS_TOTAL_SATURATED("606"),
  F4_0("607"),
  F6_0("608"),
  F8_0("609"),
  F10_0("610"),
  F12_0("611"),
  F13_0("696"),
  F14_0("612"),
  F15_0("652"),
  F16_0("613"),
  F17_0("653"),
  F18_0("614"),
  F20_0("615"),
  F22_0("624"),
  F24_0("654"),
  FATTY_ACIDS_TOTAL_MONOUNSATURATED("645"),
  F14_1("625"),
  F15_1("697"),
  F16_1_UNDIFFERENTIATED("626"),
  F16_1_C("673"),
  F16_1_T("662"),
  F17_1("687"),
  F18_1_UNDIFFERENTIATED("617"),
  F18_1_C("674"),
  F18_1_T("663"),
  F18_1_11_T_18_1T_N_7("859"),
  F20_1("628"),
  F22_1_UNDIFFERENTIATED("630"),
  F22_1_C("676"),
  F22_1_T("664"),
  F24_1_C("671"),
  FATTY_ACIDS_TOTAL_POLYUNSATURATED("646"),
  F18_2_UNDIFFERENTIATED("618"),
  F18_2_N_6_C_C("675"),
  F18_2_CLAS("670"),
  F18_2_T_T("669"),
  F18_2_I("666"),
  F18_2_T_NOT_FURTHER_DEFINED("665"),
  F18_3_UNDIFFERENTIATED("619"),
  F18_3_N_3_C_C_C_ALA("851"),
  F18_3_N_6_C_C_C("685"),
  F18_3I("856"),
  F18_4("627"),
  F20_2_N_6_C_C("672"),
  F20_3_UNDIFFERENTIATED("689"),
  F20_3_N_3("852"),
  F20_3_N_6("853"),
  F20_4_UNDIFFERENTIATED("620"),
  F20_4_N_6("855"),
  F20_5_N_3_EPA("629"),
  F21_5("857"),
  F22_4("858"),
  F22_5_N_3_DPA("631"),
  F22_6_N_3_DHA("621"),
  FATTY_ACIDS_TOTAL_TRANS("605"),
  FATTY_ACIDS_TOTAL_TRANSMONOENOIC("693"),
  FATTY_ACIDS_TOTAL_TRANSPOLYENOIC("695");

  private final String value;

  NutrientId(String value) {
    this.value = value;
  }

  public static NutrientId of(String value) {
    return Arrays.stream(values())
        .filter(nutrientId -> nutrientId.value.equals(value))
        .findAny()
        .orElse(NutrientId.UNKNOWN);
  }
}