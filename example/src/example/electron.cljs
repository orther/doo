(ns example.electron)

(def electron (js/require "electron"))
(def app (.-app (.-remote electron)))
(def electronScreen (.-screen electron))
