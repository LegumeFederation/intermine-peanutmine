#!/bin/sh

date > started
#cd dbmodel
#./go
#cd ..
cd integrate
./go
cd ..
cd postprocess
./go
cd ..
cd webapp
./go
cd ..
date > ended
