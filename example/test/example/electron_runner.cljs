(ns example.electron-runner
  (:require [cljs.test :as test]
            [doo.runner :refer-macros [doo-all-tests doo-tests]]
            [example.core-test]
            [example.electron-test]))

(doo-tests 'example.core-test
           'example.electron-test)
