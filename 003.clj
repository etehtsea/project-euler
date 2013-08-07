(ns project-euler.problem3
  (:require [clojure.test :refer [with-test is]]))

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) 5))

(with-test
  (defn largest-prime-factor [number]
    (let [upper (Math/round (Math/sqrt number))
          primes (filter prime? (range upper 2 -1))]
      (some #(if (zero? (mod number %)) %) primes)))
  (is (= 29 (largest-prime-factor 13195))))

(clojure.test/run-tests 'project-euler.problem3)
