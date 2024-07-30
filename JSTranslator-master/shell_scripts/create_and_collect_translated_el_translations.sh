#!/bin/bash
# Automatic copy of translation files to local folder together with a catalogue
# for easy reviewing and corrections, enabling to copy back with copy_back_translations.sh
# Anthony Savidis, March 2022
echo "Copying translation files to local all 'el' translated files ..."
TRANS_DIR="/j/Docs/Projects/University/ΚΤΠΕ/ΚΑΤΑΡΤΙΣΗ ΥΠ ΕΡΓΑΣΙΑΣ/ΑΩΖ/eLarning Platform/JSTranslator/Translations"
PLATFORM_DIR="/j/Developments/nuntius-main/"
CATALOGUE_FILE="catalogue.txt"
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
    cp "$target" "$tran"
    echo "Copying $tran..."
    echo "$target" >> "$TRANS_DIR/$CATALOGUE_FILE"
    let counter++
done
echo "Finished!"
