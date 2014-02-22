package edu.ufl.ml;

import java.util.HashMap;
import java.util.Iterator;

public class Label {

	String labelName;
	double classProb;
	private HashMap<Integer, Feature> labelFeatureMap;
	
	public Label( String labelName ){
		this.labelName = labelName;
		this.labelFeatureMap = new HashMap<Integer, Feature>();
		this.classProb       = 0.0;
	}
	
	public HashMap<Integer, Feature> getLabelFeatureMap(){
		return labelFeatureMap;
	}
	
	public void setClassProbability( double prob ){
		this.classProb = prob;
	}
	
	public double getClassProbability(){
		return classProb;
	}
	
	public void setLabelFeatureMap( int i, Feature feature ){
		labelFeatureMap.put( i, feature);
		//print();
	}

	public void print(){
		Iterator<Integer> itr = labelFeatureMap.keySet().iterator();
		while( itr.hasNext()){
			int id = itr.next();
			Feature feature = labelFeatureMap.get(id);
			//System.out.println(" feature id " + id  );
			feature.print();
			System.out.println();
			
		}
	}
	// Get the probability
	// Receives the feature values
	public float getFeatureProbability(String arr[]){
		float prob     = 0.0f;
		float sum      = 0.0f;
		float binValue = 0.0f;
		// Iterate over the feature values.
		// Iterate till length -1 because last one is the label value
		// Feature number is i;
		for( int i=0; i<arr.length-1; i++ ){
			float featureValue = Float.parseFloat(arr[i]);
			// Get the feature object from the map. 
			Feature feature = labelFeatureMap.get(i);
			int binIndex = feature.getBinIndex(featureValue);
			// Iterate over the whole row to get the sum over all the bins
			// And get the count in the relevant bin bucket
			for( int j=0; j< feature.nBins; j++){
				sum = sum + feature.binValues[j];
			}
			binValue = feature.binValues[binIndex];
		}
		return binValue/sum;
	}
	
	// Find the bin in which feature value lies
	// Increase the count of that bin. 
	public void train( int featureId, float featureValue ){
		Feature feature = labelFeatureMap.get(featureId);
		int binIndex = feature.getBinIndex(featureValue);
		//System.out.println( " Label " + labelName + " feature id " + featureId + " bin " + binIndex );
		//Increase the count of the bin value in the feature table
		feature.binValues[binIndex]++;
	}
	
}
