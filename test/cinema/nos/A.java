package cinema.nos;(ns cinema.nos.cadastro-filmes-test
  (:require [cinema.nos.cadastro-filmes :refer :all]
            [clojure.test :refer :all]))

(deftest testar-cadastro-filme
  (reset! filmes [])
  (let [titulo "O Rei Leão"
        duracao 88]
    (cadastrar-filme titulo duracao)
    (is (= (count @filmes) 1))
    (is (= (:titulo (first @filmes)) titulo))
    (is (= (:duracao (first @filmes)) duracao))))