(ns cinema.nos.gerenciamento-salas-test
  (:require [clojure.test :refer :all]
            [cinema.nos.gerenciamento-salas :as salas]))

(deftest test-gerenciamento-salas
  (testing "Cadastro de sala"
    (reset! salas/salas [])
    (salas/cadastrar-sala "Sala 1" 50)
    (is (= 1 (count @salas/salas)))
    (is (= {:nome "Sala 1" :capacidade 50} (first @salas/salas)))
    (salas/cadastrar-sala "Sala 1" 50)
    (is (= 1 (count @salas/salas))))

  (testing "Listagem de salas"
    (let [output (with-out-str (salas/listar-salas))]
      (is (clojure.string/includes? output "Sala: Sala 1 | Capacidade: 50"))))

  (testing "Atualização de capacidade"
    (salas/atualizar-sala "Sala 1" 60)
    (is (= 60 (:capacidade (first @salas/salas))))
    (let [output (with-out-str (salas/atualizar-sala "Sala 2" 100))]
      (is (clojure.string/includes? output "A sala Sala 2 não foi encontrada."))))

  (testing "Remoção de sala"
    (salas/remover-sala "Sala 1")
    (is (empty? @salas/salas))
    (let [output (with-out-str (salas/remover-sala "Sala 2"))]
      (is (clojure.string/includes? output "A sala Sala 2 não foi encontrada.")))))
