(ns cljsh.core
  (:require [clojure.string :as string]
            [cljs.nodejs :as nodejs]
            [replumb.core :as replumb]))

(nodejs/enable-util-print!)

(def fs (nodejs/require "fs"))

(defn node-read-file-sync
  [filename]
  (.readFileSync fs filename "utf-8"))

(defn -main [& args]
  (replumb/read-eval-call {:target :nodejs}
                          (fn [result]
                            (when-not (:success? result)
                              (println "it didn't work :(")))
                          (node-read-file-sync (first args))))
(set! *main-cli-fn* -main)
