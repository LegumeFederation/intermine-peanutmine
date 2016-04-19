#!/bin/sh
date > started
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
