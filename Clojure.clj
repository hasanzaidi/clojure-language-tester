; Change namespace in Repl to devicelicenses.subscriptions
(in-ns 'devicelicenses.subscriptions)

; prints value appended to value "body"
(prn "value " body)

; Load a file
(load-file "/home/hasan/workspace/eapi/Course/project.clj")

; Read in a file to variable s
(def s (slurp "/home/hasan/Desktop/SubscriberEngagement.csv"))

; Imports environ.core library as env into REPL
(require '[environ.core :refer [env]])

; Imports Java class into REPL
(import '[com.amazonaws ClientConfiguration])

; To look up a value in list don't use contains? as that just looks up a key  (which for a vector is the index)
(contains? [10 20 30] 20)    ; Don't use this
(some #(= % 20) [10 20 30])  ; Use this

; Thread first (->) inserts previous result as *first* argument into next function
(-> 5
  (* 7)
  (inc))  ; => 36
; is equivalent to (inc (* 5 7))

; Thread last (->>) inserts previous result as *last* argument into next function
(->> (range 5)
  (filter even?)
  (reduce +))  ; => 6
;is equivalent to (reduce + (filter even? (range 5)))

; Three ways to access a value for a :key
(:key my-map) 
(my-map :key) 
(get my-map :key)

; If the key to a map is not a keyword (i.e. starting with :) then can only use get
(get my-map key)

; Get the size of a list
(count [1 4 9 16 25])

; Runs the function "nth" with a variable split-line and against each element in the "needed-col-indexes" list
(map #(nth split-line %) needed-col-indexes))

; Combines a list of maps into a single one
(into {} ({:a "1"} {:b "2"}))

; Combines two vectors into a single one
(into [1 2 3] [4 5 6])

; Example of overloading a function
(defn x-chop
  ([name chop-type]
     (str "I " chop-type " chop " name "! Take that!"))
  ([name]
     (x-chop name "karate")))

; Comments out function so it won't be called when loading file in REPL
(comment
  (defn foo [x]
    (inc x))
  )

; To create a new Dynamo table "my-table" using Faraday library
(far/create-table client-opts :my-table
  [:id :n]  ; Primary key named "id", (:n => number type)
  {:throughput {:read 1 :write 1} ; Read & write capacity (units/sec)
   :block? true ; Block thread during table creation
   })