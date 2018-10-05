(ns pwa-clojure.main
  (:require [reagent.core :as r]
            [pwa-clojure.components.vente :refer [render-vente]]
            [pwa-clojure.app-state :refer [app-state]]))

(defn- make-progressive! []
  (when js/navigator.serviceWorker
    (.register js/navigator.serviceWorker "/js/worker/service-worker.js")))

(defonce app-loaded (r/atom false))
(defn load-app []
  (when-not @app-loaded
    (reset! app-loaded true)))

(defn ^:export start-cljs-app []
  ;(navigation/move-to-page (get-current-path) load-app)
  ; (console.log "loading main.cljs with path : " (get-current-path))
  (js.console.log "Enter in start-cljs-app")
  (load-app)
  (make-progressive!))

(defn ^:export fig-reload-hook []
  (js/console.log "fig-reload-hook")
  (swap! app-state update-in [:__figwheel_counter] inc))

; (js/console.log "loading main.cljs")
; (start-cljs-app)
