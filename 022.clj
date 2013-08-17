(ns project-euler.problem22
  (:require [clojure.string :as str]))

(defn names []
  (let [data (slurp "http://projecteuler.net/project/names.txt")
        stripped (str/replace data #"\"" "")]
    (sort (str/split stripped #","))))

(defn pos-sum [name]
  (letfn [(to-pos [c]
            (- (int c) 64))]
    (reduce + (map to-pos name))))

(defn name-scores [names]
  (map-indexed (fn [idx name] (* (inc idx) (pos-sum name))) names))

(defn total-name-scores [names]
  (reduce + (name-scores names)))
