(ns pwa-clojure.main
  (:require [reagent.core :as r]
            ; [pwa-clojure.components.vente :refer [render-vente]]
            [pwa-clojure.components.main-panel :refer [load-app]]
            [re-frame.core :refer [reg-event-db reg-sub subscribe]]
            [re-frame.db :refer [app-db]]))

(defn- make-progressive! []
  (when js/navigator.serviceWorker
    (.register js/navigator.serviceWorker "/js/worker/service-worker.js")))

(defn ^:export main []
  ;(navigation/move-to-page (get-current-path) load-app)
  ; (console.log "loading main.cljs with path : " (get-current-path))
  (js.console.log "Enter in start-cljs-app")
  (load-app)
  (make-progressive!))

(defn ^:export fig-reload-hook []
  (js/console.log "fig-reload-hook")
  (swap! app-db update-in [:__figwheel_counter] inc))

(js/console.log "loading main.cljs")
; (start-cljs-app)
