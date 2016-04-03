(defproject cljsh "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.40"]
                 [replumb/replumb "0.2.1"]]
  :clean-targets [:target-path "out"]
  :plugins [[lein-cljsbuild "1.1.1"]]
  :cljsbuild {
    :builds [{
        :source-paths ["src"]
        :compiler {
          :target        :nodejs
          :main          cljsh.core
          :output-to     "out/main.js"
          :output-dir    "out"
          :optimizations :none}}]})

