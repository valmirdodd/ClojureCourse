(ns imc.logic)

;; IMC = (peso / (altura ^ 2))
;; Até (abaixo) 18,5: peso baixo
;; De 18,5 e até (abaixo) 25: peso ideal
;; Acima de 25 (incluso): acima do peso ideal

(defn- valor-imc [peso altura]
  (/ peso (* altura altura)))

(defn- esta-abaixo-do-peso?
  [valor-imc]
  (< valor-imc 18.5))

(defn- esta-acima-do-peso?
  [valor-imc]
  (>= valor-imc 25))

(defn- esta-no-peso-ideal?
  [valor-imc]
  (and ((>= valor-imc 18.5) (< valor-imc 25))))

(defn indicador-imc [peso altura]
  (let [imc-calculado (valor-imc peso altura)]
    (if (esta-abaixo-do-peso? imc-calculado)
      :peso-baixo
      (if (esta-acima-do-peso? imc-calculado)
        :peso-acima
        :peso-ideal))))


(valor-imc 83.5 1.82)
(esta-abaixo-do-peso? 18.5)
(esta-acima-do-peso? 18.5)
(indicador-imc 61.279 1.82)

(indicador-imc 83.5 1.82)


