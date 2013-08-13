(ns project-euler.problem14)

(defn collatz-seq [n]
  (let [next (if (even? n) (/ n 2) (inc (* 3 n)))]
    (if (= n 1) [1] (cons n (collatz-seq next)))))

(defn longest-chain [upto]
  (apply max-key second
         (pmap #(vector % (count (collatz-seq %))) (range 1 upto))))
