(ns filter-map-reduce.core)

;; DESAFIO 1
;; =========

;; Imagine que tenhamos um vetor de números onde cada número representa o
;; ano que o estudante está.
;; Exemplo [5 6 6] ; Temos 1 estudante no quinto ano e dois no sexto

;; DESAFIO 1: crie uma função que recebe este vetor como entrada e retorna a
;; quantidade de estudantes que estão no quinto ano

;; [5 5 6 7 8 6 5 5] -> [5 5 5 5] -> 4

(defn esta-no-quinto-ano?
  [ano]
  (= ano 5))

(defn quantidade-estudantes-quinto-ano
  [estudantes]
  ;; (filter predicado coleção) --> predicado é uma função que retorna um boolean
  ;; exemplo 1 -> usando função nomeada
  (count (filter esta-no-quinto-ano? estudantes)))

(defn quantidade-estudantes-quinto-ano
  [estudantes]
  ;; (filter predicado coleção) --> predicado é uma função que retorna um boolean
  ;; exemplo 2 -> usando função anônima | modo 1
  (count (filter (fn [ano] (= ano 5)) estudantes)))

(defn quantidade-estudantes-quinto-ano
  [estudantes]
  ;; (filter predicado coleção) --> predicado é uma função que retorna um boolean
  ;; exemplo 3 -> usando função anônima | modo 2
  (count (filter #(= 5 %) estudantes)))

(quantidade-estudantes-quinto-ano [5 5 6 7 8 6 5 5])



;; DESAFIO 2
;; =========

;; Crie uma função que recebe um vetor de idades e retorne a soma
;; [5 10 6] -> 21
;; reduce trabalha com função de primeira ordem

(defn soma-das-idades
  [idades]
  (reduce + idades))

(soma-das-idades [5 10 6])



;; DESAFIO 3
;; =========

;; Crie uma função que recebe um vetor de nomes e retorne tamanho médio dos nomes
;; ["Márcio" "João"] -> 5


;; sem utilizar o Let
(defn tamanho-medio-dos-nomes
  [vetor-nomes]
  (/ (reduce + (map count vetor-nomes)) (count vetor-nomes)))


;; utilizando o Let
(defn tamanho-medio-dos-nomes
  [vetor-nomes]
  (let [vetor-tamanho-nomes (map count vetor-nomes)
        quantidade-nomes (count vetor-nomes)]
    (/ (reduce + vetor-tamanho-nomes) quantidade-nomes)))


(tamanho-medio-dos-nomes ["Márcio" "João"])



;; DESAFIO 4
;; =========

;; Crie uma função que recebe um vetor de nomes e retorne tamanho médio dos nomes,
;; ignorando nomes com 3 ou menos caracteres
;; ["Márcio" "João"] -> 5
;; utilizando o Let
(defn tamanho-medio-dos-nomes-longos
  [vetor-nomes]
  (let [vetor-tamanho-nomes (filter #(> % 3) (map count vetor-nomes))
        quantidade-nomes (count vetor-tamanho-nomes)]
    (/ (reduce + vetor-tamanho-nomes) quantidade-nomes)))

(tamanho-medio-dos-nomes-longos ["Márcio" "João", "Zé" "Dodd"])

