{:dev {:resources-paths ["dev-resources"]
                   :test-paths ["test/clj" "test/cljs"]
                   :dependencies [[com.cemerick/piggieback "0.1.2"]
                                  [ring "1.2.1"]
                                  [compojure "1.1.6"]]
                   :plugins [[com.cemerick/clojurescript.test "0.2.1"]]
       :test-paths ["test/clj" "target/test/clj" "test/cljs" "target/test/cljs"]
       
       :dependencies [[com.cemerick/piggieback "0.1.0"]
                      [ring "1.2.0"]
                      [compojure "1.1.5"]]
       
       :plugins [[com.cemerick/clojurescript.test "0.1.0"]
                 [com.keminglabs/cljx "0.3.0"]]

       :cljx {:builds [{:source-paths ["test/cljx"]
                        :output-path "target/test/clj"
                        :rules :clj}

                       {:source-paths ["test/cljx"]
                        :output-path "target/test/cljs"
                        :rules :cljs}]}

       :cljsbuild
       {:builds {:whitespace
                 {:source-paths ["src/cljs" "test/cljs" "src/brepl" "target/test/cljs"]
                  :compiler
                  {:output-to "dev-resources/public/js/whitespace.js"
                   :optimizations :whitespace
                   :pretty-print true}}
                             
                 :simple
                 {:source-paths ["src/cljs" "test/cljs" "target/test/cljs"]
                  :compiler
                  {:output-to "dev-resources/public/js/simple.js"
                   :optimizations :simple
                   :pretty-print false}}
                             
                 :advanced
                 {:source-paths ["src/cljs" "test/cljs" "target/test/cljs"]
                  :compiler
                  {:output-to "dev-resources/public/js/advanced.js"
                   :optimizations :advanced
                   :pretty-print false}}}
        :test-commands {"whitespace"
                        ["phantomjs" :runner "dev-resources/public/js/whitespace.js"]

                        "simple"
                        ["phantomjs" :runner "dev-resources/public/js/simple.js"]

                        "advanced"
                        ["phantomjs" :runner "dev-resources/public/js/advanced.js"]}}
       :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
       :injections [(require '[cljs.repl.browser :as brepl]
                             '[cemerick.piggieback :as pb])
                    (defn browser-repl []
                      (pb/cljs-repl :repl-env
                                    (brepl/repl-env :port 9000)))]}}
