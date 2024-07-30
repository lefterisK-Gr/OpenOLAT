#!/bin/bash
# Creates the catalogues of all language property files (de, en, el)
# Anthony Savidis, April 2022
TO_DIR="/j/Developments/OpenOLAT-16.2/"
CAT_DIR="/j/Docs/Projects/University/ΚΤΠΕ/ΚΑΤΑΡΤΙΣΗ ΥΠ ΕΡΓΑΣΙΑΣ/ΑΩΖ/eLarning Platform/JSTranslator/Data"
if [[ ! -d "$TO_DIR" ]] 
then 
    TO_DIR="/k/Developments/OpenOLAT-16.2/"
    CAT_DIR="/k/Docs/Projects/University/ΚΤΠΕ/ΚΑΤΑΡΤΙΣΗ ΥΠ ΕΡΓΑΣΙΑΣ/ΑΩΖ/eLarning Platform/JSTranslator/Data"
fi 
cd $TO_DIR
echo making "'de'" catalogue...
find ./ -type f -name *_de.properties > all_de_property_files.txt
echo done "'de'" catalogue.
echo making "'en'" catalogue...
find ./ -type f -name *_en.properties > all_en_property_files.txt
echo done "'en'" catalogue.
echo making "'el'" catalogue...
find ./ -type f -name *_el.properties > all_el_property_files.txt
echo done "'el'" catalogue.
mv all_??_property_files.txt "$CAT_DIR"
