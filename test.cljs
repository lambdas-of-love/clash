(ns main.test
  (:require [cljsh.core :as sh]))

(println "hello world!")
(.log js/console "hello!")

(println "I have"
         (count (sh/slurp "test.cljs"))
         "characters.")
