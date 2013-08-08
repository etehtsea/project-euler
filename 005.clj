(ns project-euler.problem5
  (:require [clojure.test :refer [with-test is]]))

(defn evenly-divisible? [n num]
  (if (every? #(zero? (rem num %)) (range 1 n)) num))

(with-test
  (defn smallest-multiple-upto [n]
    (let [nums (range n (java.lang.Integer/MAX_VALUE) n)]
      (some (partial evenly-divisible? n) nums)))
  (is (= 2520 (smallest-multiple-upto 10))))

(clojure.test/run-tests 'project-euler.problem5)
