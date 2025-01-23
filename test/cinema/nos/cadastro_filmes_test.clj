(ns cinema.nos.cadastro-filmes-test
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

(deftest testar-listar-filmes
  (reset! filmes [])
  (let [filmes-para-cadastrar [{:titulo "O Rei Leão" :duracao 88}
                               {:titulo "Avatar" :duracao 162}]]

    (doseq [{:keys [titulo duracao]} filmes-para-cadastrar]
      (cadastrar-filme titulo duracao))

    (is (= (listar-filmes) filmes-para-cadastrar))))