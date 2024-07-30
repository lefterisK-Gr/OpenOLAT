#!/bin/bash
# Backups all existing el property files.
# Anthony Savidis, Feb 2022
echo Backing up all "'el'" properties with "'_backup'" suffix...
DIR="/j/Developments/OpenOLAT-16.2/src/main/java/org/olat/"
if [[ ! -d "$DIR" ]] 
then 
    DIR="/k/Developments/OpenOLAT-16.2/src/main/java/org/olat/"
fi
cd $DIR
find ./ -type f -name *_el.properties -exec cp '{}' '{}'_backup \; -print
echo Done!
