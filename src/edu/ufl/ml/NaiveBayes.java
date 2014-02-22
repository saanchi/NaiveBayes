package edu.ufl.ml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * Do the classification.
 * Build the model from the training data
 * Test it for the test data.
 */
public class NaiveBayes {
	
	String trainFile;
	String testFile;
	int nFeatures;
	HashMap<String, Integer> labelCount;
	HashMap<String, Label>   labelMap;
	HashMap<String, Double>  probMap;
	HashMap<String, Integer> errorMap;
	HashMap<String, Integer> testLabelMap;
	
	public NaiveBayes( String trainFile, String testFile, ArrayList<String> labelNames, int numBins[], float min[], float max[] ){
		this.testFile  = testFile;
		this.trainFile = trainFile;
		this.nFeatures = numBins.length;
		labelCount     = new HashMap<String, Integer>();
		labelMap       = new HashMap<String, Label>();
		probMap        = new HashMap<String, Double>();
		errorMap       = new HashMap<String, Integer>();
		testLabelMap   = new HashMap<String, Integer>();
		
		Iterator<String> itr = labelNames.iterator();
		while( itr.hasNext()){
			String labelName = itr.next();
			Label label = new Label(labelName);
			// initialize all the maps
			labelMap.put(labelName, label);
			probMap.put(labelName, new Double(0.0));
			errorMap.put(labelName, new Integer(0));
			testLabelMap.put(labelName, new Integer(0));
			labelCount.put(labelName, new Integer(0));
			labelName = null;
			label = null;
		}
		// Create features 
		for( int i=0; i< nFeatures; i++){
			// For each label create a feature object and push into the label feature map
			Iterator<String> itrLabel = labelNames.iterator();
			Label label     = null;
			Feature feature = null;
			HashMap<Integer,Feature> map = null;
			String labelName = null;
			while( itrLabel.hasNext()){
				labelName  = itrLabel.next();
				label      = labelMap.get(labelName);
				feature    = new Feature( numBins[i], min[i], max[i] );
				map        = label.getLabelFeatureMap();
				map.put(new Integer(i), feature);
				map       = null;
				feature   = null;
				labelName = null;
			}
		}
		//System.out.println("----------------------------------");
		Iterator<String> itrLabel = labelNames.iterator();
		while( itrLabel.hasNext()){
			String labelName = itrLabel.next();
			Label label      = labelMap.get(labelName);
			//label.print();
		}
		// LabelNames is not required anymore. Make it null. So do min, max and numBins
		
	} 
	
	/**
	 *  Read the training data file
	 *  Populate the matrix
	 * @throws IOException 
	 */
	public void train() throws IOException{
		float totSentences = 0;  // to get the size of training data
		BufferedReader br = new BufferedReader(new FileReader(trainFile));
		String currentLine = "";
		while ((currentLine = br.readLine()) != null) {
			totSentences++;
			// Extract the features and label
			String arr[] = currentLine.split(",");
			String labelName = arr[arr.length -1].toLowerCase().trim();      // Last will be the label name
			// Set the old integer object to null
			// Increase the count of the label
			int count =0;
			if( labelCount.containsKey(labelName)){
				count = labelCount.get(labelName);
				labelCount.put(labelName, ++count);
			}
			else{
				labelCount.put(labelName, 1);
			}
			// Get the label object
			Label label =  labelMap.get(labelName);
			for( int i=0; i< nFeatures; i++){
				// Get the feature value
				float featureValue = Float.parseFloat(arr[i]);
				// For each feature train the data
				label.train(i, featureValue);
			}
		}
		br.close();
		// Set the class probabilities
		Iterator<String> itrLabel = labelCount.keySet().iterator();
		while( itrLabel.hasNext()){
			String labelName = itrLabel.next();
			float count = labelCount.get(labelName);
			// Get the label object and set its probability
			Label label = labelMap.get(labelName);
			double prob = count/(float)totSentences;
			label.setClassProbability(prob);
			labelName = null;
		}
		// Print bin matrix
		for( int i=0; i< nFeatures; i++){
			// For each label create a feature object and push into the label feature map
			itrLabel = labelCount.keySet().iterator();
			Label label     = null;
			Feature feature = null;
			HashMap<Integer,Feature> map = null;
			String labelName = null;
			while( itrLabel.hasNext()){
				labelName  = itrLabel.next();
				label      = labelMap.get(labelName);
				map        = label.getLabelFeatureMap();
				feature	   = map.get(i);
				//feature.print();
				for(int j=0; j<feature.nBins; j++){
					System.out.print( feature.start[j] +"," );
				}
				System.out.println();
				for(int k=0; k<feature.nBins; k++){
					System.out.print( feature.binValues[k] + "," );
				}
				System.out.println();
				map       = null;
				feature   = null;
				labelName = null;
			}
		}
	}
	
	/**
	 * Run the test data over the trained model
	 * @throws IOException 
	 */
	public void test() throws IOException{
		BufferedReader br  = new BufferedReader(new FileReader(testFile));
		String currentLine = "";
		// For each row in the test file
		while ((currentLine = br.readLine()) != null) {
			// Extract the features and label
			String arr[] = currentLine.split(",");
			String trueLabelName = arr[arr.length -1].toLowerCase().trim();      // Last will be the label name
			// Increase the count
			int testCount = testLabelMap.get(trueLabelName);
			testLabelMap.put(trueLabelName, ++testCount);
			String maxValueLabelName = "";
			double maxValue = 0.0;
			// Iterate over all the labels.
			Iterator<String> itr = labelMap.keySet().iterator();
			
			while( itr.hasNext()){
				String currLabelName = itr.next();
				Label label = labelMap.get(currLabelName);
				// For each feature get the probability
				double prob = 1.0;
				for( int i=1; i<nFeatures; i++){
					prob = prob * label.getFeatureProbability(arr);
				}
				// Multiply the label probability
				prob = prob*label.getClassProbability();
				// if its max record it
				if( prob > maxValue ){
					maxValue = prob;
					maxValueLabelName = currLabelName;
				}
			}
			//System.out.println( " Label name is " + trueLabelName + " result label name is " + maxValueLabelName );
			// Verify with the passed value
			if( !maxValueLabelName.equalsIgnoreCase(trueLabelName)){
				int count = errorMap.get(trueLabelName);
				errorMap.put(trueLabelName, ++count);
			}
			trueLabelName = null;
		}
		
		br.close();
	}
	
	/**
	 * Runs through the error map and reports classification error
	 */
	public void result(){
		float totalCount       = 0.0f;
		float totalErrorCount  = 0.0f;
		Iterator<String> itr = testLabelMap.keySet().iterator();
		String str1 = "";
		while( itr.hasNext()){
			String labelName   = itr.next();
			float totCount     = testLabelMap.get(labelName);
			totalCount 		   = totalCount + totCount;
			float errorCount   = errorMap.get(labelName);
			totalErrorCount    = totalErrorCount + errorCount; 
			Label label        = labelMap.get(labelName);
			str1  = str1 + "\t" + (float)label.getClassProbability();
			//System.out.println( " labelcount " + totCount + " error count " + errorCount);
			//System.out.println(" Error for class " + labelName + " is " + (errorCount/totCount)*100);
		}
		System.out.println((totalErrorCount/totalCount)*100 +  str1  );
	}
	
	/*
	 *  Entry Point. 
	 *  Read the input arguments.
	 *  Initialize the classes and train the model using training file
	 *  Run the model over the test file.
	 *  Report errors and print results
	 */
	public static void main(String args[]) throws IOException{
		args = new String[19];
		args[0] = "/home/sanchit/Downloads/ml/hw1/50/9_train.dat";
		args[1] = "/home/sanchit/Downloads/ml/hw1/50/9_test.dat";
		args[2] = "3";
		args[3] = "Iris-Setosa";
		args[4] = "Iris-Versicolor";
		args[5] = "Iris-Virginica";
		args[6] = "4";
		args[7] = "6"; //bins for f1
		args[8] = "4.3";
		args[9] = "7.9";
		args[10] = "6";  // bins for f2
		args[11] = "2.0";
		args[12] = "4.4";
		args[13] = "6";  // bins for f3
		args[14] = "1.0";
		args[15] = "6.9";
		args[16] = "6"; // bins for f4
		args[17] = "0.1";
		args[18] = "2.5";
		/// Parse the argument
		String trainFile = args[0];
		String testFile  = args[1];
		ArrayList<String>  classes   = new ArrayList<String>();
		// Get the number of classes
		// And get all the class names 
		int  nClasses    = Integer.parseInt( args[2] );	
		for( int i=1; i<=nClasses; i++  ){
			classes.add(args[2+i].toLowerCase().trim());
		}
		// Get the number of features and number of bins
		// And min and max values of feature
		int index = 2+nClasses+1;
		int nFeatures    = Integer.parseInt(args[index]);
		int numBins[]    = new int[nFeatures];
		float min[]      = new float[nFeatures];
		float max[]      = new float[nFeatures];
		for( int i=0; i< nFeatures; i++){
			numBins[i] = Integer.parseInt( args[++index]);
			min[i]     = Float.parseFloat( args[++index]);
			max[i]     = Float.parseFloat( args[++index]);
		}
		NaiveBayes nb = new NaiveBayes(trainFile, testFile, classes, numBins, min, max);
		// Train the data
		nb.train();
		nb.test();
		nb.result();
	}
	
}
