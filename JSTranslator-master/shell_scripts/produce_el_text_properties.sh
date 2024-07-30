#!/bin/bash
# Produces the text ascii equivalent(escaped unicode) only for 
# all existing el property files. 
# Anthony Savidis, April 2022
DIR="/j/Developments/OpenOLAT-16.2/"
if [[ ! -d "$DIR" ]] 
then 
    DIR="/k/Developments/OpenOLAT-16.2/"
fi
cd $DIR
find ./ -type f -name *_el.properties -exec native2ascii -reverse -encoding UTF-8 '{}' '{}'.txt \; -print