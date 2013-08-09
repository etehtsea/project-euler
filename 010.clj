(ns project-euler.problem10
  (:require [clojure.test :refer [with-test is]]))

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) 20))

(with-test
  (defn sum-of-primes [max]
    (let [primes (filter prime? (range 2 (+ max 1)))]
      (reduce + primes)))
  (is (= 17 (sum-of-primes 10))))

(clojure.test/run-tests 'project-euler.problem10)
