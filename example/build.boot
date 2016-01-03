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
  test-cljs {:debug? true
             :namespaces #{"example.core-test"
                           "example.failing-test"}})

(deftask electron []
  (task-options!
    test-cljs {:debug? true
               :js-env :electron
               :namespaces #{"example.electron-test"
                             "example.core-test"
                             "example.failing-test"}
               :cljs-opts {:externs ["externs/electron.js"]}}))

(deftask add-tests []
  (merge-env! :source-paths #{"test"})
  identity)

(deftask add-failures []
  (merge-env! :source-paths #{"failing-tests"})
  identity)

(deftask deps [])
