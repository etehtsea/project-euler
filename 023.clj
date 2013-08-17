(ns project-euler.problem23)

(defn proper-divisors [n]
  (let [divisors (filter #(zero? (rem n %)) (range 2 (inc (Math/sqrt n))))]
    (set (cons 1 (mapcat #(vector % (/ n %)) divisors)))))

(defn proper-divisors-sum [n]
  (reduce + (proper-divisors n)))

(def max-num (inc 20161))

(def abundants-sums
  (let [abundant? #(> (proper-divisors-sum %) %)
        abundants (vec (filter abundant? (range 12 max-num)))]
    (set (for [x abundants y abundants
               :while (<= y x)]
           (+ x y)))))

(defn result []
  (reduce + (remove abundants-sums (range 1 max-num))))
