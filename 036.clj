(ns project-euler.problem36)

(defn palindromes [base]
  (letfn [(make-palindrome
            ([n] [(make-palindrome (quot n base) n)
                  (make-palindrome n n)])
            ([n res]
               (if (> n 0)
                 (recur (quot n base) (+' (*' base res) (mod n base)))
                 res)))]
    (mapcat make-palindrome (range 1 (Double/POSITIVE_INFINITY)))))

(defn palindrome? [n]
  (let [nstr (str n)]
    (= nstr (apply str (reverse nstr)))))

(defn double-based-palindromes-sum [n]
  (let [pals (take-while (partial > n) (palindromes 10))
        pals-with-bins (map #(vec [% (Long/toBinaryString %)]) pals)
        double-pals (filter #(every? palindrome? %) pals-with-bins)]
    (reduce (fn [acc d] (+' acc (first d))) 0 double-pals)))
