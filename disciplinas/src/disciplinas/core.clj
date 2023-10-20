(ns disciplinas.core
  (:require [clojure.string :refer [upper-case join]]))

;; Desafio: criar uma função que, dado um conjunto (vetor)
;; de disciplinas e o semestre da discente, deve:
;; - filtrar a lista para exibir disciplinas restantes (do semestre atual ou superior)
;; - transformar nome da disciplina para maiúsculo e descartar demais informações
;; - criar uma string concatenando os nomes de todas as disciplinas filtradas
;; Exemplo de entrada:
;; [{:nome "Estrutura de Dados" :semestre 2}
;;  {:nome "Algorítimos" :semestre 1}
;;  {:nome "Inteligência Artificial" :semestre 3}] 2
;; Saída esperada: "ESTRUTURA DE DADOS, INTELIGÊNCIA ARTIFICIAL"

(defn disciplinas
  []
  [{:nome "Estrutura de Dados" :semestre 2}
   {:nome "Algorítimos" :semestre 1}
   {:nome "Inteligência Artificial" :semestre 3}])

(defn nomes-disciplinas-restantes
  [disciplinas semestre-atual]
  (join ", " (map upper-case (map :nome (filter #(>= (:semestre %) semestre-atual) disciplinas)))))

;; mesma função, agora usando threading last
(defn nomes-disciplinas-restantes
  [disciplinas semestre-atual]
  (--> disciplinas
       (filter #(>= (:semestre %) semestre-atual))
       (map :nome)
       (map upper-case)
       (join ", ")))

;; mesma função, agora usando threading first
(defn nomes-disciplinas-restantes
  [disciplinas semestre-atual]
  (-> disciplinas
       (filter #(>= (:semestre %) semestre-atual))
       (map :nome)
       (map upper-case)
       (join ", ")))

(nomes-disciplinas-restantes (disciplinas) 2)

