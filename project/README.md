# Introdurre clojurescript.test nel progetto enfocus

In questo documento raccolgo le idee che via via mi vengono in mente
per inserire clojurescript.test come libreria per scrivere qualche
unit test per enfocus.

## Installazione di clojurescript test

La prima cosa da fare è, evidentemente, quella di aggiungere
clojurescript.test alle dipendenze del progetto. Per il momento non
definisco il profilo dev, ma quando avrò capito bene come fare andare
questo marchingegno, sposterò quanto necessario per il test sotto il
profilo dev.

```clj
(defproject enfocus "2.0.0-SNAPSHOT"
  ...
  :dependencies [...
	             [com.cemerick/clojurescript.test "0.0.4"]]
  ...)
```

## Intallazione di phantomsjs

La seconda cosa da fare è installare phantomjs. L'installazione di
phantomsjs è molto semplice, basta seguire le istruzioni online.

## Configurazione di phantomjs nel progetto

Bisogna aggiungere lo script di chas (i.e. phantomjs.js) nella
directory `runners` creata nel progetto.

## Configurazione dei comandi di test con cljsbuild

E' necessario aggiungere dei comandi di test nel cljsbuild. Vedi qui sotto

```clj
(defproject enfocus "2.0.0-SNAPSHOT"
  ...
  :cljsbuild
  {...
   :builds
   {:whitespace
     ...}
   :test-commands {"whitespace" 
                   ["runners/phantomjs.js" 
                    "resources/public/js/whitespace.js"]}})
```

Si noti che il file `whitespace.js` è quello generato in fase di
compilazione da cljsbuild. Tale file deve contenere sia i sorgenti di
enfocus che i sorgenti dei testi di enfocus.

## Directory layout dei test

In generale è buona norma mettere i sorgenti degli unit test nella
directory `test/cljs` che quindi va a sua volta aggiunta alla lista
delle directory che cljsbuild utilizza per generare il javascript che
poi viene passato a phantomsjs per l'esecuzione dei test.

```clj
(defproject enfocus "2.0.0-SNAPSHOT"
  ...
  :cljsbuild
  {...
   :builds
   {:whitespace
     {:source-paths ["src/cljs" "test/cljs"]
      ...}}})
```

## resources vs. dev-resources

Bisogna decidere dove salvare suddetto file javascript. La prima
ipotesti è di salvarlo nelle directory `resources/public/js` con il
nome `whitespace.js`. Quando avrò capito meglio come funziona tutta la
meccanica credo che bisgonerà salvare tutte le risorse (i.e. pagine
html, i css e il javascript generato sotto la directory
`dev-resources/public/js` che apparentemente è già nel classpath del progetto
come risulta dal comando seguente:

```bash
lein classpath
/Users/mimmo/devel/enfocus/project/test:
/Users/mimmo/devel/enfocus/project/src/clj:
/Users/mimmo/devel/enfocus/project/dev-resources:
/Users/mimmo/devel/enfocus/project/resources:
...
```

## File html da utilizzare

La manipolazione del DOM avviene a partire da una pagina HTML che
viene caricata nel browser e che il browser stesso interpreta e
trasforma in DOM.

Sarebbe interassante capire se possiamo partire da una pagina vuota,
ma che eveidentemente contiene il riferimento al jvascript generato
dalla compilazione, oppure sia meglio partire da una pagina già
sufficientemente elaborata per soddisfare i vari test.

A naso mi sembra che la prima ipotesi sia la migliore. In entrambi i
casi, comunque, bisgnerà pernsare a come eventualmente utilizzare le
fixture, e in particolare la modalità `:each` per riportare la pagina
alla situazione di partenza dopo l'esecuzione di ogni test.

Una possibile semplicissima pagina di partenza potrebbe essere la seguente:

```html
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Enfocus Unit Testing</title>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="css/test.css">
</head>
<body>
	<!-- Enfocus Unit Testing -->
    
    <script src="js/whitespace.js"></script>

</body>
</html>
```

Tale pagina include anche un css di test definito da enfocus
(verificare se server davvero)



