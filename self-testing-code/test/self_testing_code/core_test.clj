(ns self-testing-code.core-test
  (:require [clojure.test :refer :all]
            [self-testing-code.core :refer :all]))


(deftest ainda-nao-sei-o-nome-test
  (let [max-delivery-fee 15
        mid-delivery-fee 5
        min-delivery-fee 0
        origin-array-names ["josé" "joão" "maria"]
        name-to-replace "arnaldo"
        replaced-array-names ["arnaldo" "joão" "maria"]]
   (testing "Given a purchase with a value of less than R$ 100,00, then the delivery fee should be R$ 15,00"
     (is (= max-delivery-fee (delivery-fee 0.01)))
     (is (= max-delivery-fee (delivery-fee 100))))

   (testing "given a purchase valued between R$ 100,00 and R$ 200,00, then the delivery fee should be R$ 5,00"
     (is (= mid-delivery-fee (delivery-fee 100.01)))
     (is (= mid-delivery-fee (delivery-fee 200))))

   (testing "given a purchase worth more than R$ 200,00, then the delivery fee should be R$ 0,00"
     (is (= min-delivery-fee (delivery-fee 200.01)))
     (is (= min-delivery-fee (delivery-fee 1000))))

   testing "given an array with three names and one more name, then this name must replace the first name in the array"
     (is (= replaced-array-names (substituir-nome origin-array-names name-to-replace)))
   ))
