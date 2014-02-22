#!/bin/sh -x

## Run for 10% case
for i in `seq 1 10`
do
    sort -R -t , iris.data   > 10/$i.dat
    head -15   10/$i.dat     > 10/$i"_"train.dat
    tail -135  10/$i.dat     > 10/$i"_"test.dat	
done

## Run for 30% case
for i in `seq 1 10`
do
    sort -R -t , iris.data   > 30/$i.dat
    head -45   30/$i.dat     > 30/$i"_"train.dat
    tail -105  30/$i.dat     > 30/$i"_"test.dat	
done

## Run for 50% case
for i in `seq 1 10`
do
    sort -R -t , iris.data   > 50/$i.dat
    head -75   50/$i.dat     > 50/$i"_"train.dat
    tail -75   50/$i.dat     > 50/$i"_"test.dat	
done
