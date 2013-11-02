(defproject org.clojars.magomimmo/enfocus "2.1.0-SNAPSHOT"
  :description "DOM manipulation tool for clojurescript inspired by Enlive"
  :url "https://github.com/magomimmo/enfocus/tree/tutorial-20"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}

  :min-lein-version "2.1.2"

  :source-paths ["src/clj" "src/cljs"]
  :test-paths ["test/clj" "test/cljs"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1847"]
                 [domina "1.0.2"]
                 [org.jsoup/jsoup "1.7.2"]]

  :plugins [[lein-cljsbuild "0.3.4"]
            [com.cemerick/clojurescript.test "0.1.0"]]
  
  :hooks [leiningen.cljsbuild]

  :cljsbuild
  {:crossovers [enfocus.enlive.syntax]
   :crossover-jar true

   :builds {:whitespace
             {:source-paths ["src/cljs" "test/cljs"]
              ; :jar true don't to this
              :compiler
              {:output-to "dev-resources/public/js/whitespace.js"
               :optimizations :whitespace
               :pretty-print true}}

             :simple
             {:source-paths ["src/cljs" "test/cljs"]
              :compiler
              {:output-to "dev-resources/public/js/simple.js"
               :optimizations :simple
               :pretty-print false}}

             :advanced
             {:source-paths ["src/cljs" "test/cljs"]
              :compiler
              {:output-to "dev-resources/public/js/advanced.js"
               :optimizations :advanced
               :pretty-print false}}}

   :test-commands {"whitespace"
                   ["phantomjs" :runner "dev-resources/public/js/whitespace.js"]

                   "simple"
                   ["phantomjs" :runner "dev-resources/public/js/simple.js"]

                   "advanced"
                   ["phantomjs" :runner "dev-resources/public/js/advanced.js"]}})

