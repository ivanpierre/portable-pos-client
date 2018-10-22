(ns pwa-clojure.components.bouton
 (:require [reagent.core :as r]
           [clojure.string :as s]))

(defn Bouton [name]
  (if (s/blank? name)
    [:button {:visible "false"}]
    [:button {:visible "true"} name]))
