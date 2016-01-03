(set-env!
 :source-paths    #{"src"}
 :resource-paths  #{"resources"}
 :dependencies '[[org.clojure/core.async      "0.1.346.0-17112a-alpha"]
                 [org.clojure/clojurescript   "1.7.170"]
                 [crisptrutski/boot-cljs-test "0.2.1-SNAPSHOT"]
                 [doo                         "0.1.7-SNAPSHOT"]])

(require
 '[crisptrutski.boot-cljs-test :refer [test-cljs]])

(task-options!
  test-cljs {:namespaces #{"example.failing-test"
                           "example.core-test"}})

(deftask electron []
  (task-options!
    test-cljs {:namespaces #{"example.electron-test"
                             "example.core-test"}
               :js-env     :electron
               :cljs-opts {:externs ["externs/electron.js"]}}))

(deftask add-tests []
  (set-env! :source-paths #(conj % "test"))
  identity)

(deftask add-failures []
  (set-env! :source-paths #(conj % "failing-tests"))
  identity)

(deftask deps [])
