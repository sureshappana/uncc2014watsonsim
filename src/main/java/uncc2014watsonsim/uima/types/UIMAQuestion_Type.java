
/* First created by JCasGen Mon Apr 28 12:44:39 EDT 2014 */
package uncc2014watsonsim.uima.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.TOP_Type;

/** 
 * Updated by JCasGen Tue Apr 29 17:51:30 EDT 2014
 * @generated */
public class UIMAQuestion_Type extends TOP_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (UIMAQuestion_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = UIMAQuestion_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new UIMAQuestion(addr, UIMAQuestion_Type.this);
  			   UIMAQuestion_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new UIMAQuestion(addr, UIMAQuestion_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = UIMAQuestion.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("uncc2014watsonsim.uima.types.UIMAQuestion");
 
  /** @generated */
  final Feature casFeat_query;
  /** @generated */
  final int     casFeatCode_query;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQuery(int addr) {
        if (featOkTst && casFeat_query == null)
      jcas.throwFeatMissing("query", "uncc2014watsonsim.uima.types.UIMAQuestion");
    return ll_cas.ll_getRefValue(addr, casFeatCode_query);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuery(int addr, int v) {
        if (featOkTst && casFeat_query == null)
      jcas.throwFeatMissing("query", "uncc2014watsonsim.uima.types.UIMAQuestion");
    ll_cas.ll_setRefValue(addr, casFeatCode_query, v);}
    
  
 
  /** @generated */
  final Feature casFeat_answerList;
  /** @generated */
  final int     casFeatCode_answerList;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAnswerList(int addr) {
        if (featOkTst && casFeat_answerList == null)
      jcas.throwFeatMissing("answerList", "uncc2014watsonsim.uima.types.UIMAQuestion");
    return ll_cas.ll_getRefValue(addr, casFeatCode_answerList);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnswerList(int addr, int v) {
        if (featOkTst && casFeat_answerList == null)
      jcas.throwFeatMissing("answerList", "uncc2014watsonsim.uima.types.UIMAQuestion");
    ll_cas.ll_setRefValue(addr, casFeatCode_answerList, v);}
    
  
 
  /** @generated */
  final Feature casFeat_category;
  /** @generated */
  final int     casFeatCode_category;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getCategory(int addr) {
        if (featOkTst && casFeat_category == null)
      jcas.throwFeatMissing("category", "uncc2014watsonsim.uima.types.UIMAQuestion");
    return ll_cas.ll_getStringValue(addr, casFeatCode_category);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCategory(int addr, String v) {
        if (featOkTst && casFeat_category == null)
      jcas.throwFeatMissing("category", "uncc2014watsonsim.uima.types.UIMAQuestion");
    ll_cas.ll_setStringValue(addr, casFeatCode_category, v);}
    
  
 
  /** @generated */
  final Feature casFeat_qtype;
  /** @generated */
  final int     casFeatCode_qtype;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getQtype(int addr) {
        if (featOkTst && casFeat_qtype == null)
      jcas.throwFeatMissing("qtype", "uncc2014watsonsim.uima.types.UIMAQuestion");
    return ll_cas.ll_getStringValue(addr, casFeatCode_qtype);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQtype(int addr, String v) {
        if (featOkTst && casFeat_qtype == null)
      jcas.throwFeatMissing("qtype", "uncc2014watsonsim.uima.types.UIMAQuestion");
    ll_cas.ll_setStringValue(addr, casFeatCode_qtype, v);}
    
  
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "uncc2014watsonsim.uima.types.UIMAQuestion");
    return ll_cas.ll_getIntValue(addr, casFeatCode_id);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setId(int addr, int v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "uncc2014watsonsim.uima.types.UIMAQuestion");
    ll_cas.ll_setIntValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_LAT;
  /** @generated */
  final int     casFeatCode_LAT;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getLAT(int addr) {
        if (featOkTst && casFeat_LAT == null)
      jcas.throwFeatMissing("LAT", "uncc2014watsonsim.uima.types.UIMAQuestion");
    return ll_cas.ll_getStringValue(addr, casFeatCode_LAT);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLAT(int addr, String v) {
        if (featOkTst && casFeat_LAT == null)
      jcas.throwFeatMissing("LAT", "uncc2014watsonsim.uima.types.UIMAQuestion");
    ll_cas.ll_setStringValue(addr, casFeatCode_LAT, v);}
    
  
 
  /** @generated */
  final Feature casFeat_FitbBlanks;
  /** @generated */
  final int     casFeatCode_FitbBlanks;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getFitbBlanks(int addr) {
        if (featOkTst && casFeat_FitbBlanks == null)
      jcas.throwFeatMissing("FitbBlanks", "uncc2014watsonsim.uima.types.UIMAQuestion");
    return ll_cas.ll_getRefValue(addr, casFeatCode_FitbBlanks);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFitbBlanks(int addr, int v) {
        if (featOkTst && casFeat_FitbBlanks == null)
      jcas.throwFeatMissing("FitbBlanks", "uncc2014watsonsim.uima.types.UIMAQuestion");
    ll_cas.ll_setRefValue(addr, casFeatCode_FitbBlanks, v);}
    
  
 
  /** @generated */
  final Feature casFeat_FitbSection1;
  /** @generated */
  final int     casFeatCode_FitbSection1;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getFitbSection1(int addr) {
        if (featOkTst && casFeat_FitbSection1 == null)
      jcas.throwFeatMissing("FitbSection1", "uncc2014watsonsim.uima.types.UIMAQuestion");
    return ll_cas.ll_getRefValue(addr, casFeatCode_FitbSection1);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFitbSection1(int addr, int v) {
        if (featOkTst && casFeat_FitbSection1 == null)
      jcas.throwFeatMissing("FitbSection1", "uncc2014watsonsim.uima.types.UIMAQuestion");
    ll_cas.ll_setRefValue(addr, casFeatCode_FitbSection1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_FitbSection2;
  /** @generated */
  final int     casFeatCode_FitbSection2;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getFitbSection2(int addr) {
        if (featOkTst && casFeat_FitbSection2 == null)
      jcas.throwFeatMissing("FitbSection2", "uncc2014watsonsim.uima.types.UIMAQuestion");
    return ll_cas.ll_getRefValue(addr, casFeatCode_FitbSection2);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFitbSection2(int addr, int v) {
        if (featOkTst && casFeat_FitbSection2 == null)
      jcas.throwFeatMissing("FitbSection2", "uncc2014watsonsim.uima.types.UIMAQuestion");
    ll_cas.ll_setRefValue(addr, casFeatCode_FitbSection2, v);}
    
  
 
  /** @generated */
  final Feature casFeat_queryParse;
  /** @generated */
  final int     casFeatCode_queryParse;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQueryParse(int addr) {
        if (featOkTst && casFeat_queryParse == null)
      jcas.throwFeatMissing("queryParse", "uncc2014watsonsim.uima.types.UIMAQuestion");
    return ll_cas.ll_getRefValue(addr, casFeatCode_queryParse);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQueryParse(int addr, int v) {
        if (featOkTst && casFeat_queryParse == null)
      jcas.throwFeatMissing("queryParse", "uncc2014watsonsim.uima.types.UIMAQuestion");
    ll_cas.ll_setRefValue(addr, casFeatCode_queryParse, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public String getQueryParse(int addr, int i) {
        if (featOkTst && casFeat_queryParse == null)
      jcas.throwFeatMissing("queryParse", "uncc2014watsonsim.uima.types.UIMAQuestion");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_queryParse), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_queryParse), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_queryParse), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setQueryParse(int addr, int i, String v) {
        if (featOkTst && casFeat_queryParse == null)
      jcas.throwFeatMissing("queryParse", "uncc2014watsonsim.uima.types.UIMAQuestion");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_queryParse), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_queryParse), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_queryParse), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public UIMAQuestion_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_query = jcas.getRequiredFeatureDE(casType, "query", "uncc2014watsonsim.uima.types.QueryString", featOkTst);
    casFeatCode_query  = (null == casFeat_query) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_query).getCode();

 
    casFeat_answerList = jcas.getRequiredFeatureDE(casType, "answerList", "uncc2014watsonsim.uima.types.searchResultList", featOkTst);
    casFeatCode_answerList  = (null == casFeat_answerList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_answerList).getCode();

 
    casFeat_category = jcas.getRequiredFeatureDE(casType, "category", "uima.cas.String", featOkTst);
    casFeatCode_category  = (null == casFeat_category) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_category).getCode();

 
    casFeat_qtype = jcas.getRequiredFeatureDE(casType, "qtype", "uima.cas.String", featOkTst);
    casFeatCode_qtype  = (null == casFeat_qtype) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_qtype).getCode();

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.Integer", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_LAT = jcas.getRequiredFeatureDE(casType, "LAT", "uima.cas.String", featOkTst);
    casFeatCode_LAT  = (null == casFeat_LAT) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_LAT).getCode();

 
    casFeat_FitbBlanks = jcas.getRequiredFeatureDE(casType, "FitbBlanks", "uima.tcas.Annotation", featOkTst);
    casFeatCode_FitbBlanks  = (null == casFeat_FitbBlanks) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_FitbBlanks).getCode();

 
    casFeat_FitbSection1 = jcas.getRequiredFeatureDE(casType, "FitbSection1", "uima.tcas.Annotation", featOkTst);
    casFeatCode_FitbSection1  = (null == casFeat_FitbSection1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_FitbSection1).getCode();

 
    casFeat_FitbSection2 = jcas.getRequiredFeatureDE(casType, "FitbSection2", "uima.tcas.Annotation", featOkTst);
    casFeatCode_FitbSection2  = (null == casFeat_FitbSection2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_FitbSection2).getCode();

 
    casFeat_queryParse = jcas.getRequiredFeatureDE(casType, "queryParse", "uima.cas.StringArray", featOkTst);
    casFeatCode_queryParse  = (null == casFeat_queryParse) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_queryParse).getCode();

  }
}



    