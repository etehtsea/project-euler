(ns project-euler.problem28)

(defn add [n]
  (nth (iterate #(inc %) 2) (- n 3)))

(defn next-square [n]
  (let [r (- n 2)]
    (map #(+ % (add n))
         (take 4 (range (* r r) (Double/POSITIVE_INFINITY) (add n))))))

(defn diagonals [n]
  (lazy-cat [1] (mapcat next-square (range 3 (inc n) 2))))

(defn diagonals-sum [n]
  (reduce + (diagonals n)))
