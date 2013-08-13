(ns project-euler.problem12)

;; Copied from
;; http://clojuredocs.org/clojure_contrib/clojure.contrib.lazy-seqs/primes
(def primes
  (concat
   [2 3 5 7]
   (lazy-seq
    (let [primes-from
          (fn primes-from [n [f & r]]
            (if (some #(zero? (rem n %))
                      (take-while #(<= (* % %) n) primes))
              (recur (+ n f) r)
              (lazy-seq (cons n (primes-from (+ n f) r)))))
          wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6  4  2
                        6 4 6 8 4 2 4 2 4 8 6 4 6 2  4  6
                        2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
      (primes-from 11 wheel)))))

(defn prime-factors [number]
  (let [largest-prime-factor
        (fn [number]
          (let [upper (Math/round (Math/sqrt number))]
            (some #(if (zero? (mod number %)) %) (take upper primes))))
        biggest (largest-prime-factor number)]
    (if (nil? biggest)
      [number]
      (cons biggest
            (prime-factors (/ number (largest-prime-factor number)))))))

(defn first-with-over-divisors [d]
  (let [triangle-numbers (map #(/ (* % (+ % 1)) 2) (iterate inc 1))
        factors-count
        (fn [n]
          (reduce * (map #(+ % 1) (vals (frequencies (prime-factors n))))))]
    (some #(if (<= d (factors-count %)) %) triangle-numbers)))

;; (time (project-euler.problem12/first-with-over-divisors 500))
;; "Elapsed time: 679.514 msecs"
