(ns project-euler.problem15)

(defn factorial [n]
  (reduce *' (range 1 (inc n))))

(defn lattice-paths [n]
  (let [fact (bigint (factorial n))]
    (/ (factorial (* 2 n)) (* fact fact))))
