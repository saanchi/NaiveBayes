#!/bin/sh -x

## Run for 10% case
echo "10% case"
echo  Trial"\t"WidthF1"\t"WidthF2"\t"WidthF3"\t"WidthF4"\t"      Error"\t   "ProbC1"\t"ProbC2"\t  "ProbC3
for i in `seq 1 5`
do
    val=`java -jar naivebayes.jar 10/$i"_train.dat" 10/$i"_test.dat" 3 "Iris-Setosa" "Iris-Versicolor" "Iris-Virginica" 4 3 4.3 7.9 3 2.0 4.4 3 1.0 6.9 3 0.1 2.5`
    echo $i"\t"1.2"\t"0.73"\t"2.96"\t"0.8"\t"$val
done

for i in `seq 6 10`
do
    val=`java -jar naivebayes.jar 10/$i"_train.dat" 10/$i"_test.dat" 3 "Iris-Setosa" "Iris-Versicolor" "Iris-Virginica" 4 4 4.3 7.9 4 2.0 4.4 4 1.0 6.9 4 0.1 2.5`
    echo $i"\t"0.9"\t"0.55"\t"1.48"\t"0.6"\t"$val
done

## Run for 30% case

echo "30% case"
echo  Trial"\t"WidthF1"\t"WidthF2"\t"WidthF3"\t"WidthF4"\t"      Error"\t   "ProbC1"\t"ProbC2"\t  "ProbC3
for i in `seq 1 5`
do
    val=`java -jar naivebayes.jar 30/$i"_train.dat" 30/$i"_test.dat" 3 "Iris-Setosa" "Iris-Versicolor" "Iris-Virginica" 4 4 4.3 7.9 4 2.0 4.4 4 1.0 6.9 4 0.1 2.5`
    echo $i"\t"0.9"\t"0.55"\t"1.48"\t"0.6"\t"$val
done

for i in `seq 6 10`
do
    val=`java -jar naivebayes.jar 30/$i"_train.dat" 30/$i"_test.dat" 3 "Iris-Setosa" "Iris-Versicolor" "Iris-Virginica" 4 5 4.3 7.9 5 2.0 4.4 5 1.0 6.9 5 0.1 2.5`
    echo $i"\t"0.72"\t"0.48"\t"1.36"\t"0.48"\t"$val
done


## Run for 50% case

echo "50% case"
echo  Trial"\t"WidthF1"\t"WidthF2"\t"WidthF3"\t"WidthF4"\t"      Error"\t   "ProbC1"\t"ProbC2"\t  "ProbC3
for i in `seq 1 5`
do
    val=`java -jar naivebayes.jar 50/$i"_train.dat" 50/$i"_test.dat" 3 "Iris-Setosa" "Iris-Versicolor" "Iris-Virginica" 4 5 4.3 7.9 5 2.0 4.4 5 1.0 6.9 5 0.1 2.5`
    echo $i"\t"0.72"\t"0.48"\t"1.36"\t"0.48"\t"$val
done

for i in `seq 6 10`
do
    val=`java -jar naivebayes.jar 50/$i"_train.dat" 50/$i"_test.dat" 3 "Iris-Setosa" "Iris-Versicolor" "Iris-Virginica" 4 6 4.3 7.9 6 2.0 4.4 6 1.0 6.9 6 0.1 2.5`
    echo $i"\t"0.6"\t"0.36"\t"0.98"\t"0.4"\t"$val
done





