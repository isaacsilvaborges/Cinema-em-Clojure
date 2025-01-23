(ns cinema.nos.gerenciamento-filmes-test
  (:require [cinema.nos.cadastro-filmes :refer :all]
            [cinema.nos.gerenciamento-filmes :refer :all]
            [clojure.test :refer :all]))

(deftest testar-remover-filme
  (reset! filmes [])
  (let [titulo "O Rei Leão"
        duracao 88]
    (cadastrar-filme titulo duracao)
    (is (= (count @filmes) 1))
    (remover-filme titulo)
    (is (= (count @filmes) 0))))

(deftest testar-buscar-filme
  (reset! filmes [])
  (let [titulo "O Rei Leão"
        duracao 88]
    (cadastrar-filme titulo duracao)
    (is (= (count @filmes) 1))
    (is (= (buscar-filme titulo) (println (str "Filme encontrado: " titulo " (" duracao " min)"))))
    (is (= (buscar-filme "Avatar") (println "O filme Avatar não foi encontrado.")))))