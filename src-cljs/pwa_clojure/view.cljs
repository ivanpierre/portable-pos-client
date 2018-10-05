(ns todomvc.views
  (:require [reagent.core  :as reagent]
            [re-frame.core :refer [subscribe dispatch]]
            [clojure.string :as str]))

(defn server-select
  []
  [:div
   [:section#pos-app]])

(defn main-pos-module
  []
  (if (seq @(subscribe [:module]))
    [logged-in-module]
    [module-start :vente]))

(defn main-pos-casheer
  []
  (if (seq @(subscribe [:casheer]))
    [logged-in-casheer]
    [casheer-login]))

(defn main-pos-pos
  []
  (if (seq @(subscribe [:pos]))
    [logged-in-pos]
    [pos-login]))

(defn main-pos-server
  []
  (if (seq @(subscribe [:server]))
    [logged-in-server]
    [server-login]))



