(ns cinema.nos.cadastro-filmes
    (:require [clojure.core.async :as async]))

(def filmes (atom []))

(defn cadastrar-filme [titulo duracao]
      (swap! filmes conj {:titulo titulo :duracao duracao})
      (println (str "Filme cadastrado: " titulo " (" duracao " min)")))

(defn listar-filmes []
  @filmes)




