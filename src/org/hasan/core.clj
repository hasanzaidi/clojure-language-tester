; Code snippets which can't really be expressed in unit test
(ns org.hasan.core)

(defn foo
  "prints value appended to argument"
  [x]
  ; prints value appended to value "body"
		(prn "value " x)
)

; Example of overloading a function
(defn x-chop
  ([name chop-type]
     (str "I " chop-type " chop " name "! Take that!"))
  ([name]
     (x-chop name "karate"))
)