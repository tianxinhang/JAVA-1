/**
 * The class will store an array of all the nature features on the trail
 *
 * @author TIANXIN HANG
 * @version 2019.04.18
 */
public class Trail
{
    private NatureFeature[] features;

    /**
     * Default constructor for objects of class Trail
     */
    public Trail()
    {
        features = new NatureFeature[6];
        for(int i=0;i<=6;i++)
        {
            features[i]=new NatureFeature();
        }

    }

    /**
     * This is a mututor method which sets new value for all elements of Trail array
     */
    public void setNatureFeature()
    {
        int featurePosition[] = {0,0,0,0};// initialise each feature position in this array
        String featureType[] = {"Creek","Bridge","Fallen tree","Landslide"};
        int spacePenalty[] = {-2,4,-3,-5};
        features[4] = new NatureFeature(0,"k",0);
        // features[5].NatureFeature(0,"l",0); doesn't work !
        for(int i = 0; i <= 3; i++){
            features[i].setFeaturePosition(featurePosition[i]);
            features[i]. setFeatureType(featureType[i]);
            features[i].setSpacePenalty(spacePenalty[i]);
        }
    }

    /**
     * This is a mututor method which changes position of NatureFeature
     * @param An int to indicate index of NatureFeature 
     * @param An int to indicate position of NatureFeature 
     */
    public void setFeaturePosition(int i,int newPosition)
    {
        features[i].setFeaturePosition(newPosition);
    }

    /**
     * This is an accessor method which gets information of NatureFeature
     * @param An int to indicate index of NatureFeature 
     * @return The ith information of NatureFeature 
     */
    public NatureFeature getFeature(int i)
    {
        return features[i];
    }

    /**
     * This is an accessor method which gets position of NatureFeature
     * @param An int to indicate index of NatureFeature 
     * @return The ith position of NatureFeature 
     */
    public int getFeaturePosition(int i)
    {
        return features[i].getFeaturePosition();
    }

    /**
     * This is an accessor method which gets type of FeatureType
     * @param An int to indicate index of NatureFeature 
     * @return The ith type of FeatureType
     */
    public String getFeatureType(int i)
    {
        return features[i].getFeatureType();
    }

    /**
     * This is an accessor method which gets penalty of NatureFeature 
     * @param An int to indicate index of NatureFeature 
     * @return The ith penalty of NatureFeature 
     */
    public int getSpacePenalty(int i)
    {
        return features[i].getSpacePenalty();
    }
}
