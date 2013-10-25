(defproject org.clojars/magomimmo/enfocus "2.1.0-SNAPSHOT"
  :description "DOM manipulation tool for clojurescript inspired by Enlive"
  :url "http://github.com/magomimmo/enfocus"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}

  :min-lein-version "2.2.0"

  :source-paths ["src/clj"]
  :test-paths ["test/clj"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1934"]
                 [org.clojars.magomimmo/domina "1.0.3-SNAPSHOT"]
                 [org.jsoup/jsoup "1.7.2"]]

  :plugins [[lein-cljsbuild "0.3.4"]]

  :hooks [leiningen.cljsbuild]

  :cljsbuild
  {:crossovers [enfocus.enlive.syntax]
   :crossover-jar true

   :builds {:deploy
            {:source-paths ["src/cljs"]
             :jar true
             :compiler
             {:output-to "dev-resources/public/js/deploy.js"
              :optimizations :whitespace
              :pretty-print true}}}})
