(ns imc.logic-test
  (:require [clojure.test :refer :all]
            [imc.logic :refer :all]))

;; IMC = (peso / (altura ^ 2))
;; Até (abaixo) 18,5: peso baixo
;; De 18,5 e até (abaixo) 25: peso ideal
;; Acima de 25 (incluso): acima do peso ideal

(deftest imc-test
  (testing "Dado um IMC menor que 18,5, então deve retornar 'peso baixo'"
    (is (= :peso-baixo (indicador-imc 61.279 1.82))))

  (testing "Dado um IMC entre 18,5 e 24,9, então deve retornar 'peso ideal'"
    (is (= :peso-ideal (indicador-imc 61.28 1.82)))
    (is (= :peso-ideal (indicador-imc 82.805 1.82))))

  (testing "Dado um IMC acima 24,9, então deve retornar 'acima do peso ideal'"
    (is (= :peso-acima (indicador-imc 82.81 1.82)))))


