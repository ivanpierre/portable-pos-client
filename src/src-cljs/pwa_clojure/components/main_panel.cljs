(ns pwa-clojure.components.mai-panel
  (:require [reagent.core :as r]
            [pwa-clojure.components.numpad :as numpad]))

(defn Composant
  ""
  [func id & args]
  (if (string? func)
    [:div {:id (name id) :key (name id) :width "100%" :height "100%"} func]
    (apply func args)))

(defn portrait []
  ;(> (.height js/windows) (.width js/windows)))
  js/windows)
  
(defn main-panel []
  [:div#main-panel])
;   (map #(apply Composant %) map-pattern)])

(defn render-component [component id]
  (r/render component (.getElementById js/document id)))

(defn ^:export render-main-panel []
  (render-component [main-panel] "app"))
