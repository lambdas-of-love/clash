(ns cljsh.core)

(def fs (js/require "fs"))

(defn slurp [file-path]
  (str (.readFileSync fs file-path)))
