(ns pwa-clojure.components.numpad
  (:require [reagent.core :as r]))

(defn Touche
  [id nom]
  [:button {:id (str "t" (name id)) :key (str "t" (name id)) :display "block" :width "100%" :height "100%"} (str nom)])

(def map-default
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
   [:ENT "E\nN\nT"]])

(defn Numpad [key-pattern]
  (reduce conj [:div.numpad {:key "numpad"}] (map #(apply Touche %) key-pattern)))

(defn render-component [component id]
  (r/render component (.getElementById js/document id)))

(defn render-numpad []
  (render-component [Numpad map-default] "app"))

