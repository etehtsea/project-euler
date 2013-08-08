(ns project-euler.problem6
  (:require [clojure.test :refer [with-test is]]))

(with-test
  (defn sums-difference [n]
    (letfn [(sum-of-squares [n]
              (reduce + (map #(* % %) (range 1 (+ n 1)))))
            (square-of-sum [n]
              (let [sum (reduce + (range 1 (+ n 1)))]
                (* sum sum)))]
      (- (square-of-sum n) (sum-of-squares n))))
  (is (= 2640 (sums-difference 10))))

(clojure.test/run-tests 'project-euler.problem6)
