(ns pwa-clojure.components.numpad
  (:require [reagent.core :as r]))

(defn touche
  [id nom]
  [:button  {:id (name id)
             :key (name id)
             :display "block"
             :width "100%"
             :height "100%"}
            (str nom)])

(def map-numeric
  {:eff "EFF"
   :n1 "1"
   :n1 "2"
   :n1 "3"
   :n1 "4"
   :n1 "5"
   :n1 "6"
   :n1 "7"
   :n1 "8"
   :n1 "9"
   :n1 "0"
   :ent "E<br>N<br>T"})

(def map-float
  (conj (map-numeric) {:point "."}))

(def keys
  [:l1 :l2 :l3
   :r1 :r2
   :eff
   :c1 :c2 :c3 :c4 :c5
   :n1 :n2 :n3
   :n4 :n5 :n6
   :n7 :n8 :n9
   :n0 :point :ent])

(defn mapping [map]
  [[:l1 ""]
   [:l2 ""]
   [:l3 ""]
   [:r1 ""]
   [:r2 ""]
   [:EFF "EFF"]
   [:c1 ""]
   [:c2 ""]
   [:c3 ""]
   [:c4 ""]
   [:c5 ""]
   [:n1 "1"]
   [:n2 "2"]
   [:n3 "3"]
   [:n4 "4"]
   [:n5 "5"]
   [:n6 "6"]
   [:n7 "7"]
   [:n8 "8"]
   [:n9 "9"]
   [:n0 "0"]
   [:point "."]
   [:ENT "E<br>N<br>T"]])

(defn numpad [key-pattern]
  (into [:div.numpad {:key "numpad"}] (map touche key-pattern)))

(defn render-component [component id]
  (r/render component (.getElementById js/document id)))

(defn render-numpad []
  (render-component [numpad (mapping map-float)] "app"))
