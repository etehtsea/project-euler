(ns project-euler.problem7
  (:require [clojure.test :refer [with-test is]]))

(def prime-numbers
  (filter #(.isProbablePrime (BigInteger/valueOf %) 5)
          (range 2 (java.lang.Integer/MAX_VALUE))))

(with-test
  (defn nth-prime-number [n]
    (nth prime-numbers (- n 1)))
  (is (= 13 (nth-prime-number 6))))

(clojure.test/run-tests 'project-euler.problem7)
