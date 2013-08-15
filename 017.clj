(ns project-euler.problem17
  (:require [clojure.test :refer [deftest is]]))

(def upto-20
  ["_" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"
   "ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen"
   "eighteen" "nineteen"])

(def upto-100
  ["_" "_" "twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty"
   "ninety"])

(defn number-to-words [n]
  (cond
   (or (< n 1) (> n 1000)) (throw (Exception. "Number should be from 1 to 1000"))
   (= n 1000) "one thousand"
   (< n 20) (upto-20 n)
   (zero? (rem n 100)) (str (upto-20 (quot n 100)) " hundred")
   (> n 100) (str (upto-20 (quot n 100))
                  " hundred and "
                  (number-to-words (rem n 100)))
   (zero? (rem n 10)) (upto-100 (quot n 10))
   (> n 20) (str (upto-100 (quot n 10))
                 "-"
                 (number-to-words (rem n 10)))))

(defn count-letters [r]
  (count (filter #(Character/isLetter %) (mapcat (comp seq number-to-words) r))))

(deftest number-to-words-test
  (is (thrown? Exception (number-to-words 1001)))
  (is (= "seventeen" (number-to-words 17)))
  (is (= "twenty" (number-to-words 20)))
  (is (= "forty-two" (number-to-words 42)))
  (is (= "five hundred" (number-to-words 500)))
  (is (= "three hundred and forty-two" (number-to-words 342)))
  (is (= "one hundred and fifteen" (number-to-words 115)))
  (is (= "one thousand" (number-to-words 1000)))
  (is (thrown? Exception (number-to-words -1))))

(clojure.test/run-tests 'project-euler.problem17)
