(ns cinema.nos.gerenciamento-salas
  (:require [clojure.core.async :as async]))

(def salas (atom []))

(defn cadastrar-sala [nome capacidade]
  (if (some #(= (:nome %) nome) @salas)
    (println (str "A sala " nome " já está cadastrada."))
    (do
      (swap! salas conj {:nome nome :capacidade capacidade})
      (println (str "Sala cadastrada: " nome " com capacidade para " capacidade " pessoas.")))))

(defn listar-salas []
  (if (empty? @salas)
    (println "Nenhuma sala cadastrada.")
    (doseq [sala @salas]
      (println (str "Sala: " (:nome sala) " | Capacidade: " (:capacidade sala))))))

(defn atualizar-sala [nome nova-capacidade]
  (let [sala (some #(when (= (:nome %) nome) %) @salas)]
    (if sala
      (do
        (swap! salas #(mapv (fn [s] (if (= (:nome s) nome)
                                      (assoc s :capacidade nova-capacidade)
                                      s)) %))
        (println (str "A capacidade da sala " nome " foi atualizada para " nova-capacidade " pessoas.")))
      (println (str "A sala " nome " não foi encontrada.")))))

(defn remover-sala [nome]
  (if (some #(= (:nome %) nome) @salas)
    (do
      (swap! salas (fn [salas] (remove #(= (:nome %) nome) salas)))
      (println (str "Sala removida: " nome)))
    (println (str "A sala " nome " não foi encontrada."))))