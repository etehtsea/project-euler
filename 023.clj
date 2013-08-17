(ns project-euler.problem23)

(defn proper-divisors [n]
  (let [divisors (filter #(zero? (rem n %)) (range 2 (inc (Math/sqrt n))))]
    (set (cons 1 (mapcat #(vector % (/ n %)) divisors)))))

(defn proper-divisors-sum [n]
  (reduce + (proper-divisors n)))

(defn abundant? [n]
  (> (proper-divisors-sum n) n))

(def max-num (inc 20161))

(def abundants
  (vec (filter abundant? (range 12 max-num))))

(defn abundants-sums []
  (for [x abundants y abundants
        :while (<= y x)]
    (+ x y)))

(defn result []
  (reduce + (clojure.set/difference (set (range 1 max-num))
                                    (set (abundants-sums)))))
