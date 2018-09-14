(ns pwa-clojure.main
  (:require [pwa-clojure.app-state :as app-state]))

; (defn- get-current-path []
;   js/window.location.pathname)

; (defn- get-container [name]
;   (.getElementById js/window.document name))

(defn- make-progressive! []
  (when js/navigator.serviceWorker
    (-> (.register js/navigator.serviceWorker "service-worker.js")
        (.then (fn [reg]
                 (.log js/console "reg ok " (.scope reg))))
        (.catch (fn [error]
                  (.log js/console "reg nok " error))))))

(defonce app-loaded (atom false))
(defn load-app []
  (when-not @app-loaded
    (reset! app-loaded true)
    ;(main component)
))

(defn ^:export start-cljs-app []
  (load-app)
  (make-progressive!))

(start-cljs-app)
