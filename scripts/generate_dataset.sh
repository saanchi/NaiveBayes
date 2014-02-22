#!/bin/sh -x

## Generate 10-90 split
## 10 sets of it
sort  -R  -t , iris.data > 10/1.dat 
head -15   10/1.dat      > 10/1_train.dat
tail -135  10/1.dat      > 10/1_test.dat

sort  -R  -t , iris.data > 10/2.dat 
head -15 2.dat  > 10/2_train.dat
tail -135       > 10/2_test.dat

sort  -R  -t , iris.data > 10/3.dat 
head -15 3.dat  > 10/3_train.dat
tail -135       > 10/3_test.dat

sort  -R  -t , iris.data > 10/4.dat 
head -15 4.dat  > 10/4_train.dat
tail -135       > 10/4_test.dat

sort  -R  -t , iris.data > 10/5.dat 
head -15 5.dat  > 10/5_train.dat
tail -135       > 10/5_test.dat

sort  -R  -t , iris.data > 10/6.dat 
head -15 6.dat  > 10/6_train.dat
tail -135       > 10/6_test.dat

sort  -R  -t , iris.data > 10/7.dat 
head -15 7.dat  > 10/7_train.dat
tail -135       > 10/7_test.dat

sort  -R  -t , iris.data > 10/8.dat 
head -15 8.dat  > 10/8_train.dat
tail -135       > 10/8_test.dat

sort  -R  -t , iris.data > 10/9.dat 
head -15 9.dat  > 10/9_train.dat
tail -135       > 10/9_test.dat

sort  -R  -t , iris.data > 10/10.dat 
head -15 10.dat  > 10/10_train.dat
tail -135        > 10/10_test.dat

## Generate 30-70 split
## 10 sets of it

sort  -R  -t , iris.data  > 30/1.dat
head -45   30/1.dat  >   30/1_train.dat
tail -105  30/1.dat  >   30/1_test.dat

sort  -R  -t , iris.data  > 30/2.dat
head -45   30/2.dat   >   30/2_train.dat
tail -105  30/2.dat   >   30/2_test.dat

sort  -R  -t , iris.data  >  30/3.dat
head -45   30/3.dat    >   30/3_train.dat
tail -105  30/3.dat    >   30/3_test.dat

sort  -R  -t , iris.data  > 30/4.dat
head -45  30/4.dat    >   30/4_train.dat
tail -105 30/4.dat    >   30/4_test.dat

sort  -R  -t , iris.data  > 30/5.dat
head -45  30/5.dat    >   30/5_train.dat
tail -105 30/5.dat    >   30/5_test.dat

sort  -R  -t , iris.data  > 30/6.dat
head -45   30/6.dat  >   30/6_train.dat
tail -105  30/6.dat  >   30/6_test.dat

sort  -R  -t , iris.data  > 30/7.dat
head -45   30/7.dat  >   30/7_train.dat
tail -105  30/7.dat  >   30/7_test.dat

sort  -R  -t , iris.data  > 30/8.dat
head -45   30/8.dat  >   30/8_train.dat
tail -105  30/8.dat  >   30/8_test.dat

sort  -R  -t , iris.data  > 30/9.dat
head -45   30/9.dat  >   30/9_train.dat
tail -105  30/9.dat  >   30/9_test.dat

sort  -R  -t , iris.data  > 30/10.dat
head -45   30/10.dat  >   30/10_train.dat
tail -105  30/10.dat  >   30/10_test.dat

## Generate 50-50 split
## 10 sets of it

sort  -R  -t , iris.data    > 50/1.dat
head -75   50/1.dat   > 50/1_train.dat
tail -75   50/1.dat   > 50/1_test.dat  

sort  -R  -t , iris.data    > 50/2.dat
head -75   50/2.dat   > 50/2_train.dat
tail -75   50/2.dat   > 50/2_test.dat  

sort  -R  -t , iris.data    > 50/3.dat
head -75   50/3.dat   > 50/3_train.dat
tail -75   50/3.dat   > 50/3_test.dat  

sort  -R  -t , iris.data    > 50/4.dat
head -75   50/4.dat   > 50/4_train.dat
tail -75   50/4.dat   > 50/4_test.dat  

sort  -R  -t , iris.data    > 50/5.dat
head -75   50/5.dat   > 50/5_train.dat
tail -75   50/5.dat   > 50/5_test.dat  

sort  -R  -t , iris.data    > 50/6.dat
head -75   50/6.dat   > 50/6_train.dat
tail -75   50/6.dat   > 50/6_test.dat  

sort  -R  -t , iris.data    > 50/7.dat
head -75   50/7.dat   > 50/7_train.dat
tail -75   50/7.dat   > 50/7_test.dat  

sort  -R  -t , iris.data    > 50/8.dat
head -75   50/8.dat   > 50/8_train.dat
tail -75   50/8.dat   > 50/8_test.dat  

sort  -R  -t , iris.data    > 50/9.dat
head -75   50/9.dat   > 50/9_train.dat
tail -75   50/9.dat   > 50/9_test.dat  

sort  -R  -t , iris.data    > 50/10.dat
head -75   50/10.dat   > 50/10_train.dat
tail -75   50/10.dat   > 50/10_test.dat  

##############################################################################
##############################################################################


