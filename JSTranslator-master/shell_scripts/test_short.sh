#!/bin/bash
counter=0
name="el_tran_"
target="/k/Developments/nuntius-main/target/classes/org/olat/user/_i18n/LocalStrings_el.properties_tran.txt"
hdd="k:" 
target=${target//\//\\}         # /  to \ for
target=${target//\\k/"$hdd"}    # \k to k:
echo "$target"
link="$name$counter.txt"
call="mklink \"${link}\" \"${target}\""
cmd <<< $call
#cmd <<< "mklink \"${link}\" \"J:\Developments\nuntius-main\target\classes\org\olat\user\_i18n\LocalStrings_el.properties_tran.txt\""
