(ns project-euler.problem21)

(defn proper-divisors [n]
  (let [divisors (filter #(zero? (rem n %)) (range 2 (Math/sqrt n)))]
    (cons 1 (mapcat #(vector % (/ n %)) divisors))))

(defn proper-divisors-sum [n]
  (reduce + (proper-divisors n)))

(defn amicable-numbers [r]
  (let [pairs (map #(sorted-set % (proper-divisors-sum %)) r)
        amicable-pairs (keys (filter #(> (last %) 1) (frequencies pairs)))]
    (mapcat vec amicable-pairs)))

(defn amicable-numbers-sum [r]
  (reduce + (amicable-numbers r)))
