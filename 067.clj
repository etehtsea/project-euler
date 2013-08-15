(ns project-euler.problem67
  (:require [clojure.string :as str]))

(def triangle
  (let [data (slurp "http://projecteuler.net/project/triangle.txt")
        lines (str/split data #"\n")
        nums (map #(str/split % #"\s") lines)
        to-int #(Integer/parseInt %)]
    (map #(map to-int %) nums)))

(defn triangle-max-sum [t]
  (let [next-row (fn [cl nl]
                   (map + (map #(apply max %) (partition 2 1 cl)) nl))]
    (first (reduce next-row (reverse t)))))
