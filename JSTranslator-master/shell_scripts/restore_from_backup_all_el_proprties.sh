#!/bin/bash
# Restores from original property backups all existing el property files.
# Anthony Savidis, Feb 2022
echo Restoring from their backups all "'el'" properties ...
DIR="/j/Developments/nuntius-main/"
if [[ ! -d "$DIR" ]] 
then 
    DIR="/k/Developments/nuntius-main/"
fi
cd $DIR
find ./ -type f -name *_el.properties -exec cp '{}'_backup '{}' \; -print
echo Done!
