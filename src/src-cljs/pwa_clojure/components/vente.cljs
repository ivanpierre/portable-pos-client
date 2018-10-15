(ns pwa-clojure.components.vente
  (:require [reagent.core :as r]
            [pwa-clojure.components.numpad :as numpad]))

(defn Composant
  ""
  [func id & args]
  (if (string? func)
    [:div {:id (name id) :key (name id) :width "100%" :height "100%"} func]
    (apply func args)))

(def map-vente
  [["Articles" :articles "Articles"]
   ["Ticket" :ticket "Ticket"]
   ["Courant" :courant "Articles"]
   [numpad/numpad :numpad numpad/map-float]])

(defn Vente [map-pattern]
  [:div#main.vente
   (map #(apply Composant %) map-pattern)])

(defn render-component [component id]
  (r/render component (.getElementById js/document id)))

(defn ^:export render-vente []
  (render-component [Vente map-vente] "app"))
