#+clj (ns enfocus.enlive.syntax-test
        (:require [clojure.test :refer [deftest are is testing]]
                  [enfocus.enlive.syntax :refer [convert]]))

#+cljs (ns enfocus.enlive.syntax-test
         (:require-macros [cemerick.cljs.test :refer (deftest testing are)])
         (:require [cemerick.cljs.test :as t]
                   [enfocus.enlive.syntax :refer [convert]]))

(deftest convert-test
  (testing "Unit Test for (convert arg) function\n"

    (testing "Edge Cases\n"
        (are [expected actual] (= expected actual)
            true false))))
