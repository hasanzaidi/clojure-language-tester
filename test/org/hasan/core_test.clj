(ns org.hasan.core-test
  (:require [clojure.test :refer :all]
            [org.hasan.core :refer :all]))

(testing "Vectors"
  (testing "combining-two-vectors"
    (is (= [1 2 3 4 5 6] (into [1 2 3] [4 5 6])))
  )
  (testing "count length of vector"
    (is (= 5 (count [1 4 9 16 25])))
  )
  (testing "looking up value in vector"
    (is (= true (some #(= % 20) [10 20 30])))
  )
  (testing "contains looks up key of vector (which is index)"
    (is (= false (contains? [10 20 30] 4)))
    (is (= true (contains? [10 20 30] 2)))
  )
)

(testing "Maps"
  (testing "Three ways to access a value in a map"
    (is (= "1" (:a {:a "1" :b "2"})))
    (is (= "1" ({:a "1" :b "2"} :a)))
    (is (= "1" (get {:a "1" :b "2"} :a)))
  )
  (testing "Only way to access a value in a map if key is not a keyword (i.e. starting with :)"
    (is (= "1" (get {"a" "1" "b" "2"} "a")))
  )
)

(testing "Threading"
  (testing "Thread first (->) inserts previous result as *first* argument into next function"
    (is (= 36 (-> 5
    												  (* 7)
    												  (inc))  
    ))
  )
  (testing "Thread last (->>) inserts previous result as *last* argument into next function"
    (is (= 6 (->> (range 5)
																			(filter even?)
                   (reduce +))
    ))
  )
)

(testing "IO"
  (testing "Reading in a file"
    (is (= "Hello world!" (slurp "resources/myfile.txt")))
  )
)
