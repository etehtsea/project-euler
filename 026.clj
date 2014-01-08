(ns project-euler.problem26)

(defn remainders
  ([n] (remainders (numerator n) (denominator n) []))
  ([num den acc]
     (let [rmnd (rem (* num 10) den)]
       (if (some #(= rmnd %) acc)
         acc
         (remainders rmnd den (conj acc rmnd))))))

(defn repeating-count [n]
  (let [r (remainders n)]
    (if (some zero? r) 0 (count r))))

(defn reciprocal-cycles [upto]
  (let [find-max (fn [n max]
                   (let [crc (repeating-count (/ 1 n))]
                     (if (> (:count max) crc) max {:num n :count crc})))]
    (loop [n upto max {:num 0 :count 0}]
      (if (> (:count max) n)
        max
        (recur (dec n) (find-max n max))))))
