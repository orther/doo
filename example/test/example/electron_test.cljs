(ns example.electron-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [clojure.string :refer [split]]
            [example.electron :as electron]))

(deftest electron-app-path
  (is (= (last (split (.getAppPath electron/app) #"/"))
         "runner.electron")))
