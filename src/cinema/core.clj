(ns cinema.core
  (:gen-class)
  (:require [cinema.nos.cinema :as cinema]))

(defn -main
  [& args]
  (cinema/interagir))