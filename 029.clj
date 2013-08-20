(ns project-euler.problem29)

(defn distinct-powers [n]
  (let [combs (for [x (range 2 (inc n)) y (range 2 (inc n))]
                [x y])]
    (apply sorted-set (map (fn [[x y]] (Math/pow x y)) combs))))

(defn result [n]
  (count (distinct-powers n)))
