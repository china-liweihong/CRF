package iitb.Model;
/**
 * This can be used as a wrapper around a FeatureTypes class that wants to
 * generate a feature for each label. 
 */
public class  FeatureTypesSegmentLength extends FeatureTypes {
    int segLen;
    public FeatureTypesSegmentLength(Model m) {
	super(m);
    }
    public  boolean startScanFeaturesAt(iitb.CRF.DataSequence data, int prevPos, int pos) {
	segLen = pos-prevPos;
	return true;
    }
    public boolean hasNext() {
	return segLen > 0;
    }
    public  void next(iitb.Model.FeatureImpl f) {
    	f.val = 1;
    	f.ystart = -1;
    	if (featureCollectMode())
			f.strId.init(segLen, 0, "Length." + segLen);
		else
			f.strId.init(segLen);
		segLen = 0;
    }
};
	
