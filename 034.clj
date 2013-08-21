(ns project-euler.problem34)

(defn factorial [n]
  (reduce *' (range 1 (inc n))))

(defn digitize [n]
  (if (zero? (quot n 10))
    [(rem n 10)]
    (cons (rem n 10) (digitize (quot n 10)))))

(defn digits-facts [n]
  (map factorial (digitize n)))

(defn facts-sum [n]
  (reduce + (digits-facts n)))

(defn digit-factorials []
  (filter #(= % (facts-sum %)) (range 3 100000)))

(defn digit-factorials-sum []
  (reduce + (digit-factorials)))
