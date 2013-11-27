(defproject org.clojars.magomimmo/enfocus "2.1.0-SNAPSHOT"
  :description "DOM manipulation tool for clojurescript inspired by Enlive"
  :url "https://github.com/magomimmo/enfocus/tree/tutorial-20"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}

  :min-lein-version "2.2.0"

  :source-paths ["src/clj" "src/cljs"]
  

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2069"]
                 [domina "1.0.2"]
                 [org.jsoup/jsoup "1.7.2"]]

  :plugins [[lein-cljsbuild "1.0.0"]]
  
  :hooks [leiningen.cljsbuild]

  :cljsbuild
  {:crossovers [enfocus.enlive.syntax]
   :crossover-jar true

   :builds {:deploy
             {:source-paths ["src/cljs"]
              ;:jar true ; DON'T DO THIS
              :compiler
              {:output-to "dev-resources/public/js/deploy.js"
               :optimizations :none
               :pretty-print false}}}})

