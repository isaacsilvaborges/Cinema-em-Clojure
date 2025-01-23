(ns cinema.nos.unir-filme-sala
  (:require [cinema.nos.cadastro-filmes :as filmes]
            [cinema.nos.gerenciamento-salas :as salas]))

(defn unir-filme-sala [titulo sala]
  (let [filme (some #(when (= (:titulo %) titulo) %) @filmes/filmes)
        sala-existe (some #(= (:nome %) sala) @salas/salas)]
    (cond
      (nil? filme) (println (str "Erro: O filme \"" titulo "\" não está cadastrado."))
      (nil? sala-existe) (println (str "Erro: A sala \"" sala "\" não está cadastrada."))
      :else (println (str "Filme \"" titulo "\" combinado com a sala \"" sala "\" com sucesso.")))))
