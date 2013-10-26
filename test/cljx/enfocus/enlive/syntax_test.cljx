#+clj (ns enfocus.enlive.syntax-test
        (:require [clojure.test :refer [deftest are is testing]]
                  [enfocus.enlive.syntax :refer [convert]]))

#+cljs (ns enfocus.enlive.syntax-test
         (:require-macros [cemerick.cljs.test :refer (deftest is are testing)])
         (:require [cemerick.cljs.test :as t]
                   [enfocus.enlive.syntax :refer [convert]]))

(deftest convert-test 
  (is (= 0 1)))
