(ns project-euler.problem30)

(def power 5)

(def powers
  (vec (map #(int (Math/pow % power)) (range 10))))

(defn digitize [n]
  (if (zero? (quot n 10))
    [(rem n 10)]
    (cons (rem n 10) (digitize (quot n 10)))))

(defn narcissistic? [n]
  (= n (reduce + (map #(nth powers %) (digitize n)))))

(defn result []
  (let [max (* (nth powers 9) 6)]
    (reduce + (filter narcissistic? (range 2 max)))))
