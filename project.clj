(defproject o-grande-cinema "0.1.0-SNAPSHOT"
  :description "Cinema"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/core.async "1.5.648"]]
  :plugins [[com.jakemccrary/lein-test-refresh "0.24.1"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "1.1.1"]]
                   :source-paths ["src"]
                   :test-paths ["test"]}}
  :main cinema.core)