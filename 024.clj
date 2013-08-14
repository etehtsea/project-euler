(ns project-euler.problem24
  (:require [clojure.math.combinatorics :as combo]))

(defn nth-permutations [n r]
  (nth (combo/permutations r) (dec n)))

; (time (println (nth-permutations 1000000 (range 10))))
