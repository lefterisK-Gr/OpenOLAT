#!/bin/bash
# Recreates all el property files from respective translation text files.
# This step is carried out after translation and reviewing to finalize
# property files before building the platform.
# Anthony Savidis, April 2022
echo Recreating  "'el'" properties from translated text files...
DIR="/c/Users/PLATO 8/eclipse-workspace/OpenOLAT.16.2/"
if [[ ! -d "$DIR" ]] 
then 
    echo "$DIR"
    DIR="/k/Developments/OpenOLAT-16.2/"
fi
cd "$DIR"
counter=0
for file in $(find ./ -type f -name '*_el.properties_tran.txt')
do 
    target=${file//"_tran.txt"/""} 
    echo $file $target
    native2ascii -encoding UTF-8 $file $target
    let counter++
done
echo "$counter el property files recreated!"
echo Finished!