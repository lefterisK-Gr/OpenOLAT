// Automatic translator of language terms in java property files
// to target languages via Google Cloud Translate API.
// Here used for de->el translation.
// Anthony Savidis, February 2022.

const { assert }        = require('console');
const fileSystem        = require('fs');
const propsReader       = require('properties-reader');
const fromLanguage      = 'de';
const toLanguage        = 'el';
const api               = "AIzaSyAHj6FhEg7osqjzuAx6cMK7KnzPj3KlJs4";
const googleTranslate   = require('google-translate')(api);
const configData        = JSON.parse(fileSystem.readFileSync('config.json'));
const sleep             = require('system-sleep');

////////////////////////////////////////////////////////////////////
// Put here any custom terms (in lowcase) using the 'en' values where we 
// wish to have custom translations.

// en->el
var customTerms_en2el = {
    "administrator"     : "Διαχειριστής"    ,
    "editor"            : "Συντάκτης"       ,
    "author"            : "Συγγραφέας"      ,
    "configuration"     : "Ρυθμίσεις"       ,
    "login"             : "Είσοδος"         ,
    "signin"            : "Σύνδεση"         ,
    "signout"           : "Αποσύνδεση"      ,
    "coach"             : "Σύμβουλος"       ,
    "config"            : "Ρυθμίσεις"       ,
    "admin"             : "Διαχειριστής"    ,
    "signin"            : "Είσοδος"         ,
    "signout"           : "Εξοδος"          ,
    "sign-in"           : "Είσοδος"         ,
    "sign-out"          : "Εξοδος"          ,
    "course"            : "Μάθημα"          ,
    "mode"              : "Κατάσταση"
};

var customTerms_all = {
    "en:el" : customTerms_en2el
};

////////////////////////////////////////////////////////////////////

// el->el
var improvedTerms_el = {
    "διαμόρφωση"        : "Ρυθμίσεις",
    "σύνδεση"           : "Είσοδος",
    "αποσύνδεση"        : "Έξοδος"
};

function ImprovedTranslationEL (term, key) {

    function CapitaliseTranslationEL (term) {
        let first = term.substring(0,1).toUpperCase();
        return first + term.substring(1);
    }

    let termLower = term.toLowerCase();

    if (improvedTerms_el.hasOwnProperty(termLower)) {
        console.log('Improving term ' + key + ' in language el translation');
        return improvedTerms_el[termLower];
    }
    else
        return CapitaliseTranslationEL(term);
}

var improveTermFuncs = {
    "be"    : (s)=>s,
    "en"    : (s)=>s,
    "el"    : ImprovedTranslationEL
};

////////////////////////////////////////////////////////////////////

const DE_CATALOGUE_PATH     = 'Data/all_de_property_files.txt';
const DE_PROPERTY_SUFFIX    = "LocalStrings_de.properties";
const EN_PROPERTY_SUFFIX    = "LocalStrings_en.properties";
const EL_PROPERTY_SUFFIX    = "LocalStrings_el.properties";
const CROPPED_PROPERTY_LEN  = DE_PROPERTY_SUFFIX.length;
const MAIN_PATH             = "/Developments/OpenOLAT-16.2/";

var deCatalogue              = new Array();

var ignoredCatalogueFiles_de = [
  "./target/test-classes/org/olat/core/util/i18n/junittestdata/subtest/_i18n/LocalStrings_de.properties",
  "./target/test-classes/org/olat/core/util/i18n/junittestdata/_i18n/LocalStrings_de.properties"
];

////////////////////////////////////////////////////////////////////

function ReadFileLines (action, inPath) {
    fileSystem.readFileSync(
        inPath, 'utf-8'
    ).split(
        /\r?\n/
    ).forEach(
        action
    );
}

//****************************

function DumpCatalogue (inCatalogue) {
    for (const s of inCatalogue)
        console.log(s);
}

//****************************

ReadFileLines(
    (line) => {
        if (line.length) {
            assert(line.length >= CROPPED_PROPERTY_LEN);
            if (!ignoredCatalogueFiles_de.includes(line)) 
                deCatalogue.push(line.slice(0, -CROPPED_PROPERTY_LEN));
        }
    }, 
    DE_CATALOGUE_PATH
);

if (configData.verboseCatalogues)
    DumpCatalogue(deCatalogue);

////////////////////////////////////////////////////////////////////

function MakeLanguagePropertyFileName (langId, isTranslated)  
    { return 'LocalStrings_' + langId + '.properties' + (isTranslated ? '_tran' : '') + '.txt'; }

function MakeLanguagePropertyFilePath (langId, folder, isTranslated)  
    { return MAIN_PATH + folder + MakeLanguagePropertyFileName(langId, isTranslated); }

//****************************

function ReadProperties (inFile) {
    let result = {};
    if (fileSystem.existsSync(inFile)) {
        let props = propsReader(inFile, 'utf-8');
        props.each(
            (key, value) => result[key] = value
        );
    }
    return result;
}

//****************************

var totalTranslatedFiles    = 0;
var totalTranslatedTerms    = 0;
var totalTranslatedChars    = 0;
var totalRetainedTerms      = 0;
var shouldEndTranslation    = false;
var translatedFiles         = new Array();

//****************************
// FIXME: the output is readable text but not compatibe with native encoding!
// LocalStrings_el.properties.txt: text/plain; charset=ISO-8859-1


function WriteTranslatedTextPropertiesFile (props, path) {
    let content = '';
    for (const key in props)
        content += (key + '=' + props[key] + "\n");
    if (configData.sleepFileMsecs)
        sleep(configData.sleepFileMsecs);
        
    fileSystem.writeFile(
        path, content, "utf8",
        function (err) {
            if (err) throw err;
        }
    );
}

//****************************

function LogTranslatedFiles() { 
    if (configData.logTranslatedFiles) {
        let content = '';
        translatedFiles.forEach(
            (value, index, array) => content += value + '\n'
        );
        fileSystem.writeFile(
            configData.logFile, content,
            function (err) {
                if (err) throw err;
            }
        );
    }
}

//****************************
var currTranslationCounter = 0;

async function TranslateLanguageProrerty (fromLang, toLang, folder) {

    let fromPath        = MakeLanguagePropertyFilePath(fromLang, folder, false);

    if (!fileSystem.existsSync(fromPath)) // retain subsequent auto translations
        fromPath = MakeLanguagePropertyFilePath(fromLang, folder, true);

    let toPath          = MakeLanguagePropertyFilePath(toLang, folder, true);
    let fromProps       = ReadProperties(fromPath);
    let toRetainedPath  = MakeLanguagePropertyFilePath(toLang, folder, configData.reworkTranslatedFiles);
    let toProps         = ReadProperties(toRetainedPath); // read from any existing original / translated terms
    let total           = Object.keys(fromProps).length;
    let improveTermFunc = improveTermFuncs[toLang];
    let customTermsKey  = fromLang + ':' + toLang;
    let customTerms     = customTerms_all[customTermsKey];

    console.log("Tran: (", currTranslationCounter++, ") " + fromPath + ', ' + fromLang + '->' + toLang);
    
    function CheckFinished () {
        if (!--total) {

            WriteTranslatedTextPropertiesFile(toProps, toPath);

            ++totalTranslatedFiles;
            translatedFiles.push(fromPath);
            if (configData.maxTranslatedPropertyFiles == totalTranslatedFiles)
                shouldEndTranslation = true;
                
            if (configData.verboseCompletions) {
                console.log('Finished property file' + fromPath);
                console.log('Total translated files till now ' + totalTranslatedFiles);
                console.log('Total translated terms till now ' + totalTranslatedTerms);
                console.log('Total retained terms till now '   + totalRetainedTerms);
                console.log('Total translated chars till now ' + totalTranslatedChars);                
            }
        }
    }

    // These have special meaning in olat and should never be translated.
    function IsSpecialRetainedValue (value) {
        let s1 = value.substring(0,2);
        let s2 = value.substring(0,3); 
        return s1 == "$:" || s2 == "\\$:" || s2 == "$\\:"; 
    }

    function AlwaysTranslate (value)
        { return value.includes("$:"); }

    for (const key in fromProps) {             

        let value     = fromProps[key];
        let valLower  = value.toLowerCase();

        if (IsSpecialRetainedValue(value)) {
            ++totalRetainedTerms;
            toProps[key] = value;
            if (configData.verboseSpecialRetainedTerms)
                console.log('Retaining special ' + value);
            CheckFinished();
        }
        else
        if (!AlwaysTranslate(value) && toProps.hasOwnProperty(key)) {  // retain existing or already translated properties

            ++totalRetainedTerms;
            let tranValue   =  toProps[key];
            let translation = improveTermFunc(tranValue, key);
            let isImproved  = (translation != tranValue);

            if (isImproved)
                toProps[key] = translation;
            if (configData.verboseRetainedTerms)
                console.log('Retaining ' + tranValue);
            if (configData.verboseTranslations)
                console.log('Retaining ' + (isImproved? 'and improving ' : '') + 'term ' + key + ' in language ' + toLang);
            CheckFinished();
        }
        else
        if (customTerms != undefined && customTerms.hasOwnProperty(valLower)) { // apply custom translations
            ++totalRetainedTerms;
            let translation = customTerms[valLower];
            toProps[key] = translation;
            if (configData.verboseTranslations)
                console.log('Custom->' + value + ':' + translation);
            CheckFinished();
        }
        else { // translate new terms

             if (configData.verboseTranslations)
                console.log('Asking translation for ' + key + ':' + value);

            sleep(configData.sleepMsecs); // important to avoid overloading HTTP request buffer

            await googleTranslate.translate(
                value, 
                fromLang, 
                toLang, 
                (err, translation) => {
                    
                    if (translation == undefined)
                        console.log(err);
                    assert(translation != undefined, "Too many requests!");

                    toProps[key] = improveTermFunc(translation.translatedText, key);
                    ++totalTranslatedTerms;
                    totalTranslatedChars += translation.originalText.length;
                    if (configData.verboseTranslations)
                        console.log(translation.originalText + ':' + translation.translatedText);
                    CheckFinished();
                }
            );
        }
    };
}

//****************************

function TranslateCatalogue (inCatalogue, fromLang, toLang) {
    for (const folder of inCatalogue) {
        TranslateLanguageProrerty(fromLang, toLang, folder);
        if (shouldEndTranslation)
            break;
    }
}

//****************************

async function Test() {
    
    let props = ReadProperties(configData.testInput);
    let total = Object.keys(props).length;
    
    // this is an async process!
    
    for (const key in props) {
    
        let value = props[key];
        console.log("Property " + value);
        function CheckFinished () {
            if (!--total) {
                console.log('Finished!');
                WriteTranslatedTextPropertiesFile(props, configData.testOutput);
            }
        }
    
        googleTranslate.translate(
            value, 
            fromLanguage, 
            toLanguage, (err, translation) => {
                console.log(translation.originalText + ':' + translation.translatedText);
                props[key] = translation.translatedText;
                CheckFinished();
            }
        );        
    };

}

//****************************

if (!configData.runTest) {

    if (configData.de2enTranslate) 
        TranslateCatalogue(
            deCatalogue, 
            "de", 
            "en"
        ).then();

    if (configData.de2elTranslate) 
        TranslateCatalogue(
            deCatalogue, 
            "de", 
            "el"
        );
    LogTranslatedFiles();
}
else {
    Test();
 }

////////////////////////////////////////////////////////////////////