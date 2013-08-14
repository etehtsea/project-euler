(ns project-euler.problem25)

(defn fib []
  (map first (iterate (fn [[a b]] [b (+' a b)]) [0 1])))

(defn find-n-digit [n]
  (first (keep-indexed #(if (>= (count (str %2)) n) %) (fib))))
