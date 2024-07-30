#!/bin/bash
# Automatic copy of custom made el translation files across repositories.
# Anthony Savidis, April 2022
echo "Copying 'el' translated files across repositories (nuntius to olat) ..."
FROM_DIR="/j/Developments/nuntius-main/target/classes/org/olat/"
TO_DIR="/j/Developments/OpenOLAT-16.2/src/main/java/org/olat/"
if [[ ! -d "$FROM_DIR" ]] 
then 
    FROM_DIR="/k/Developments/nuntius-main/target/classes/org/olat/"
    TO_DIR="/k/Developments/OpenOLAT-16.2/src/main/java/org/olat/"
fi
cd $FROM_DIR
counter=0
missing=0
for src in $(find "$FROM_DIR" -type f -name '*_el.properties')
do 
    target=${src//"$FROM_DIR"/"$TO_DIR"} 
    cp "$src" "$target"
    if [[ ! -f "$target" ]]
    then
        echo "$target" >> "missing_translations.txt"
        let missing++
    fi
    let counter++
done
echo "$counter el property files copied!"
echo "$missing el property files not found at target!"
echo "Finished!"
