(ns banco.imposto.logic-test
  (:require [clojure.test :refer :all]
            [banco.imposto.logic :as l]))

;; Solicitação do cliente
;; Valores abaixo de 1.000 reais não tem imposto retido na fonte
;; Acima disso, pagam 10% de impposto

(deftest imposto-retido-fonte-test
  (testing "Dado um valor abaixo de 1.000 reais, então o imposto retido deve ser igual a zero"
    (is (= 0 (l/imposto-retido-fonte 1)))
    (is (= 0 (l/imposto-retido-fonte 999.00))))

  (testing "Dado um valor igual ou superior a 1.000 reais, o imposto retido deve ser igual a 10%")
  (is (= 100.00 (l/imposto-retido-fonte 1000)))
  (is (= 90000.00 (l/imposto-retido-fonte 900000))))
