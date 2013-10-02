(defproject enfocus "2.0.0-SNAPSHOT"
  :description "DOM manipulation tool for clojurescript inspired by Enlive"
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [domina "1.0.2-SNAPSHOT"]
                 [org.jsoup/jsoup "1.7.2"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild
  {:crossover [enfocus.enlive.syntax]
   :crossover-jar true
   :builds
   {:whitespace
    {:source-paths ["src/cljs"]
     :compiler
     {:output-dir "../testing/resources/public/cljs"
      :output-to "../testing/resources/public/cljs/enfocus.js"
      :optimizations :whitespace
      :pretty-print true}}}})

