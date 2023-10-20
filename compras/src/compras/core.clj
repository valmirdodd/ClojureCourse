(ns compras.core)

;; Carrinho de compras
(defn compras
  []
  {:tomate {:quantidade 2 :preco 5}
   :arroz  {:quantidade 1 :preco 4}
   :feijao {:quantidade 2 :preco 10}})

(compras)

(get (compras) :tomate)
((compras) :tomate) ;; cuidado com este modo pois se compraas retornar null vai ser gerado um erro "null pointer exception"
(:tomate (compras))

(:preco (:tomate (compras)))
(:quantidade (:tomate (compras)))

(:preco (:banana (compras)) 0)
(:quantidade (:banana (compras)) 0)

(:batata (compras)) ;; não existe batata -> retorna nulo
(:batata (compras) {}) ;; não existe batata -> retorna objeto vazio
(:batata (compras) {:quantidade 0 :preco 0}) ;; não existe batata -> retorna objeto preenchido

