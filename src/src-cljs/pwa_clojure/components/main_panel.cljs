(ns pwa-clojure.components.main-panel
  (:require [reagent.core :as r]
            [re-frame.core :refer [reg-event-db reg-sub subscribe dispatch]]
            [pwa-clojure.app-state :as db]
            [pwa-clojure.components.numpad :refer [Numpad]]))

(def base-main-panel '([:div#main] [:div#app-infos] [:div#app-action] [Numpad]))

(defn MainPanel [panel-map]
  (let [orientation (subscribe [:orientation])]
    (into [:div#main-panel {:class @orientation}] panel-map)))

(defn ^:export TopPanel    ;; this is new
  []
  (let [ready?  (subscribe [:initialised?])]
    (if-not @ready?         ;; do we have good data?
      [:div "Initialising ..."]   ;; tell them we are working on it
      [MainPanel base-main-panel])))      ;; all good, render this component

(defn ^:export load-app []
  []
  (dispatch [:initialise-db])
  (r/render [TopPanel] (js/document.getElementById "app")))
