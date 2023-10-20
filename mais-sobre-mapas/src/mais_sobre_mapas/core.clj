(ns mais-sobre-mapas.core)

(conj [1 2 3] 4)
(conj [1 2 3] 4 5)
(conj [1 2 3] "valmir")
(conj [1 2 3] [4 5])
(pop [1 2 3])
(peek [1 2 3])

;; Simular uma função que vai retornar as compras do cliente
(defn compras
  []
  {:tomate {:quantidade 2 :preco 5}
   :arroz {:quantidade 1 :preco 4}
   :feijao {:quantidade 2 :preco 10}})

(compras)

(peek (compras)) ;; não aceita
(pop (compras)) ;; não aceita

(conj (compras) {:alface {:quantidade 3 :preco 7}})
(assoc (compras) :alface {:quantidade 3 :preco 7})
(dissoc (compras) :arroz :feijao)
(assoc (compras) :tomate {:quantidade 12 :preco 15})

(update {:nome "valmir" :idade 57} :idade inc)

((compras) :tomate)
(update-in (compras) [:tomate :preco] inc)
((update-in (compras) [:tomate :preco] inc) :tomate)

(update-in (compras) [:tomate :preco] * 1.05)


