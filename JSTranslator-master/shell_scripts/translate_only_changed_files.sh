#!/bin/bash
# Automatic copy of translation files to local folder together with a catalogue
# for easy reviewing and corrections, enabling to copy back with copy_back_translations.sh
# Anthony Savidis, March 2022
echo "Copying translation files to local all 'el' translated files ..."
echo Recreating  "'el'" properties from translated text files...
DIR="/c/Users/PLATO 8/eclipse-workspace/OpenOLAT.16.2/"
if [[ ! -d "$DIR" ]] 
then 
    echo "$DIR"
    DIR="/k/Developments/OpenOLAT-16.2/"
fi
cd "$DIR"
git status > changes.txt
echo "Finished!"
