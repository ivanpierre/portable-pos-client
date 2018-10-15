(ns pwa-clojure.components.numpad
  (:require [reagent.core :as r]))

(defn touche
  [id nom]
  (let [button-name (if (array? nom) (first nom) nom)
        button-text (if (array? nom) (second nom) nom)]  
      [:bouton   {:id button-name
                  :key button-text
                  :display "block"
                  :visible (if nom "true" "false")
                  :width "100%"
                  :height "100%"}
          (button-name)]))

(def touches
  '(:c1 :l1 :l2 :l3 :eff
    :c2 :n1 :n2 :n3 :r1
    :c3 :n4 :n5 :n6 :r2
    :c4 :n7 :n8 :n9    
        :n0 :point :ent))

(def empty-map
 (into {} #(array % nil) touches))

(def map-numeric
  (conj empty-map 
   {:eff ["EFF" "\b"]
    :n1 "1"
    :n2 "2"
    :n3 "3"
    :n4 "4"
    :n5 "5"
    :n6 "6"
    :n7 "7"
    :n8 "8"
    :n9 "9"
    :n0 "0"
    :ent ["E<br>N<br>T" "\n"]}))

(def map-float
  (conj map-numeric 
    {:point "."}))

(defn mapping [map-def]
  (into [] (seq map-def)))

(defn numpad [key-pattern]
  (into [:div#numpad {:key "numpad"}] (map touche key-pattern)))

(defn render-component [component id]
  (r/render component (.getElementById js/document id)))

(defn render-numpad [map]
  (render-component [numpad (mapping map)] "numpad-pos"))

