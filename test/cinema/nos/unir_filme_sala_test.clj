(ns cinema.nos.unir-filme-sala-test
  (:require [clojure.test :refer :all]
            [cinema.nos.cadastro-filmes :as filmes]
            [cinema.nos.gerenciamento-salas :as salas]
            [cinema.nos.unir-filme-sala :as unir]))

(deftest test-unir-filme-sala
  (testing "Unir filme com sala existente"
    (reset! filmes/filmes [])
    (reset! salas/salas [])
    (filmes/cadastrar-filme "The Matrix" 120)
    (salas/cadastrar-sala "Sala 1" 50)

    (let [saida (with-out-str (unir/unir-filme-sala "The Matrix" "Sala 1"))]
      (is (.contains saida "Filme \"The Matrix\" combinado com a sala \"Sala 1\" com sucesso."))))

  (testing "Erro ao unir filme inexistente com sala existente"
    (reset! filmes/filmes [])
    (reset! salas/salas [])
    (salas/cadastrar-sala "Sala 1" 50)

    (let [saida (with-out-str (unir/unir-filme-sala "Rei Leão" "Sala 1"))]
      (is (.contains saida "Erro: O filme \"Rei Leão\" não está cadastrado."))))

  (testing "Erro ao unir filme existente com sala inexistente"
    (reset! filmes/filmes [])
    (reset! salas/salas [])
    (filmes/cadastrar-filme "Filme A" 120)

    (let [saida (with-out-str (unir/unir-filme-sala "O Rei Leão" "Sala 2"))]
      (is (.contains saida "Erro: A sala \"Sala 2\" não está cadastrada."))))

  (testing "Erro ao unir filme e sala inexistentes"
    (reset! filmes/filmes [])
    (reset! salas/salas [])

    (let [saida (with-out-str (unir/unir-filme-sala "Avatar" "Sala 1"))]
      (is (.contains saida "Erro: O filme \"Avatar\" não está cadastrado.")))))