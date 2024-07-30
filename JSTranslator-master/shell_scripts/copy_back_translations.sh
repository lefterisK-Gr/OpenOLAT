#!/bin/bash
# Automatic copy of temporary tran files back to the original el translations.
# Anthony Savidis, March 2022
echo "Copying back temporary tran files to the original 'el' translated files ..."
TRANS_DIR="/j/Docs/Projects/University/ΚΤΠΕ/ΚΑΤΑΡΤΙΣΗ ΥΠ ΕΡΓΑΣΙΑΣ/ΑΩΖ/eLarning Platform/JSTranslator/Translations"
PLATFORM_DIR="/j/Developments/nuntius-main/"
HDD="j:"
if [[ ! -d "$PLATFORM_DIR" ]] 
then 
    PLATFORM_DIR="/k/Developments/nuntius-main/"
    TRANS_DIR="/k/Docs/Projects/University/ΚΤΠΕ/ΚΑΤΑΡΤΙΣΗ ΥΠ ΕΡΓΑΣΙΑΣ/ΑΩΖ/eLarning Platform/JSTranslator/Translations"
    HDD="k:"
fi
cd $PLATFORM_DIR
counter=0
name="el_tran_";
for target in $(find "$PLATFORM_DIR" -type f -name '*_el.properties_tran.txt')
do 
    tran="$TRANS_DIR/$name$counter.txt"
    cp "$tran" "$target"
    echo "Copying $tran => $target..."
    let counter++
done
echo "Finished!"
