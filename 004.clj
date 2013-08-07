(ns project-euler.problem4
  (:require [clojure.test :refer [with-test is]]))

(defn palindrome? [n]
  (let [nstr (.toString n)]
    (= nstr (apply str (reverse nstr)))))

(defn extremum [digits]
  (Integer. (apply str (repeat digits "9"))))

(defn n-digits-numbers [d]
  (range (extremum d) (extremum (- d 1)) -1))

(with-test
  (defn largest-palindrome-product [digits]
    (let [nums (n-digits-numbers digits)
          palindrome-product #(if (palindrome? (* % %2)) (* % %2))
          pals (map #(some (partial palindrome-product %) nums) nums)]
      (apply max (remove nil? pals))))
  (is (= 9009 (largest-palindrome-product 2))))

(clojure.test/run-tests 'project-euler.problem4)
