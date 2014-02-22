NaiveBayes
==========

Histogram Based Naive Bayes Implementation in java for Fischer Iris Data set

-src     : contains java implementation of histogram based naive bayes.
-data    : Fischer Iris Data set randomly selected for 10%, 30%, 50% training and test.
-scripts : to generate random data set, run it over all the cases and get the misclassificaiton error.

Results :

10% training sample case:
For the first 5 case  I used 3 bins for each feature, equally spaced between minimum and maximum.
For the next 5 case I used 4 bins each for each feature, equally spaced between minimum and maximum of the feature value.
Result was better in the case of 3 bins( Trial number 4) each which is expected as the training size is small.

30% case:
For the first 5 case  I used 4 bins for each feature, equally spaced between minimum and maximum.
For the next 5 case I used  5 bins each for each feature, equally spaced between minimum and maximum of the feature value.
Result was better in the case of 5 bins.( Trial number 7 ) as there was more training data to learn from and so the bins can be spaced out and hence more features to learn.

50% case:
For the first 5 case  I used 5 bins for each feature, equally spaced between minimum and maximum.
For the next 5 case with 6 bins each for each feature, equally spaced between minimum and maximum.
Result was better in the case of 6 bins( Trial number 9 ). Average classification error was better with #bins = 6.

