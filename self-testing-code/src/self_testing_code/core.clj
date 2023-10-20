(ns self-testing-code.core)

(defn delivery-fee
  [price]
  (let [max-delivery-fee 15
        mid-delivery-fee 5
        min-delivery-fee 0
        lowest-price-limit 100
        highest-price-limit 200
        ]
    (if (<= price lowest-price-limit)
      max-delivery-fee
      (if (<= price highest-price-limit)
        mid-delivery-fee
        min-delivery-fee))))


(defn substituir-nome
  [nomes nome-novo]
  (assoc nomes 0 nome-novo)
  )

(substituir-nome ["valmir" "dodd" "mariano"] "josé")