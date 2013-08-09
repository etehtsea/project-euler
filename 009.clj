(ns project-euler.problem9)

(def pythagorean-triples
  (for [c (range 1 (java.lang.Integer/MAX_VALUE)) b (range 1 c) a (range 1 b)
        :when (= (+ (* b b) (* a a)) (* c c))]
    [a b c]))

(defn thousand-sum-triple-product []
  (letfn [(thousand-sum-triple []
            (some #(if (= 1000 (reduce + %)) %) pythagorean-triples))]
    (reduce * (thousand-sum-triple))))
