(ns cinema.nos.gerenciamento-filmes
  (:require [cinema.nos.cadastro-filmes :as cadastro]))

(defn remover-filme [titulo]
  (let [filme-existe? (some #(= (:titulo %) titulo) @cadastro/filmes)]
    (if filme-existe?
      (do
        (swap! cadastro/filmes (fn [filmes] (remove #(= (:titulo %) titulo) filmes)))
        (println (str "Filme removido: " titulo)))
      (println (str "O filme " titulo " não foi encontrado.")))))

(defn buscar-filme [titulo]
  (let [filme (some #(when (= (:titulo %) titulo) %) @cadastro/filmes)]
    (if filme
      (println (str "Filme encontrado: " (:titulo filme) " (" (:duracao filme) " min)"))
      (println (str "O filme " titulo " não foi encontrado.")))))