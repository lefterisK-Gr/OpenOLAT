#!/bin/bash
# Automatic convertion of translation files to symbolic links
# and collections into a single folder for easy reviewing.
# Anthony Savidis, February 2022
echo "Creating symbolic links for all 'el' translated files ..."
LINKS_DIR="/j/Docs/Projects/University/ΚΤΠΕ/ΚΑΤΑΡΤΙΣΗ ΥΠ ΕΡΓΑΣΙΑΣ/ΑΩΖ/eLarning Platform/JSTranslator/Links"
PLATFORM_DIR="/j/Developments/nuntius-main/"
HDD="j:"
if [[ ! -d "$PLATFORM_DIR" ]] 
then 
    PLATFORM_DIR="/k/Developments/nuntius-main/"
    LINKS_DIR="/k/Docs/Projects/University/ΚΤΠΕ/ΚΑΤΑΡΤΙΣΗ ΥΠ ΕΡΓΑΣΙΑΣ/ΑΩΖ/eLarning Platform/JSTranslator/Links"
    HDD="k:"
fi
cd $PLATFORM_DIR
windows() { [[ -n "$WINDIR" ]]; }
counter=0
name="el_tran_";
for target in $(find "$PLATFORM_DIR" -type f -name '*_el.properties_tran.txt')
do 
    link="$name$counter.txt"
    if windows; then
        target=${target//\//\\}         # /  to \ for
        target=${target//\\k/"$HDD"}    # \k to k:
        call="mklink \"${link}\" \"${target}\""
        echo "$call"
        cmd <<< $call
    else
         ln -s "$target" "$link"
    fi
    let counter++
done
echo "Moving all symbolic links to the specified folder..."
mv ${PLATFORM_DIR}el_tran_*.txt "$LINKS_DIR"
echo "Finished!"
