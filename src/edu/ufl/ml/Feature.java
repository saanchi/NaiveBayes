package edu.ufl.ml;

/*
 * Feature class. Contains attributes like bin width of the histogram,
 * min, max value of feature.
 */
public class Feature {
	int nBins;
	float binValues[];
	float start[];
    float end[];
	
	public Feature( int numBins, float min, float max ){
		float range    = max - min;
		float interval = range/numBins; 
		nBins	        = numBins; 
		binValues       = new float[numBins];
		start           = new float[numBins];
		end             = new float[numBins];
		// Initialize start and end of bin
		for( int i=0; i< numBins; i++){
			start[i] = (min*100000)/100000;
			end[i]   = min + interval;
			min      = (end[i]*100000)/100000;
			binValues[i] = 1;
		} 
	}
	
	//Given the feature value return the bin index
	// On error return -1
	public int getBinIndex( float featureValue ){
		//System.out.println(featureValue);
		double epsilon = 0.001;
		for( int i=0; i< nBins; i++){
			//System.out.println( " start " + start[i] + " end " + end[i]);
			if(( featureValue >= start[i] || Math.abs(featureValue - start[i]) < epsilon)  
					&& ( (featureValue <= end[i]) || Math.abs(featureValue -end[i]) < epsilon)){
				return i;
			}
		}
		return -1;
	}
	
	public void print(){
		for(int i=0; i<nBins; i++){
			System.out.print( start[i] +"," );
		}
		System.out.println();
		for(int i=0; i<nBins; i++){
			System.out.print( binValues[i] + "," );
		}
	}
	
}
