(ns cljsh.core
  (:require [clojure.string :as string]
            [cljs.nodejs :as nodejs]
            [replumb.core :as replumb]))


(nodejs/enable-util-print!)

(def fs (nodejs/require "fs"))

(defn node-read-file-sync
  [filename]
  (.readFileSync fs filename "utf-8"))

(defn read-file-with-callback
  [file-path src-cb]
  (try
   (src-cb (node-read-file-sync file-path))
   (catch :default e
     (src-cb nil))))

(defn -main [& args]
  (let [options (replumb/options :nodejs
                                 ["lib"]
                                 read-file-with-callback)
        merged-options (merge options
                              {:context :statement
                               :verbose false})]

    (replumb/read-eval-call merged-options
                            (fn [result]
                              (when-not (:success? result)
                                (-> result
                                    replumb/result->string
                                    println)))
                          (node-read-file-sync (first args)))))
(set! *main-cli-fn* -main)
