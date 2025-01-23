(ns cinema.nos.cinema
  (:require [cinema.nos.cadastro-filmes :as cadastro]
            [cinema.nos.gerenciamento-filmes :as gerenciamento]
            [cinema.nos.unir-filme-sala :as unir]
            [cinema.nos.gerenciamento-salas :as salas]
            [clojure.core.async :as async]))

(defn interagir []
  (cadastro/cadastrar-filme "Inception" 148)
  (cadastro/cadastrar-filme "The Matrix" 136)

  (println "Filmes cadastrados:")
  (println (cadastro/listar-filmes))

  (gerenciamento/buscar-filme "Inception")

  (gerenciamento/remover-filme "The Matrix")

  (gerenciamento/buscar-filme "The Matrix")

  (salas/cadastrar-sala "Sala 1" 100)
  (salas/cadastrar-sala "Sala 2" 150)

  (println "Salas cadastradas:")
  (println (salas/listar-salas))

  (unir/unir-filme-sala "Inception" "Sala 1"))

(interagir)