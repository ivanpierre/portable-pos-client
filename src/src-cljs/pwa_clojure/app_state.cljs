(ns pwa-clojure.app-state
  (:require [cljs.reader]
            [cljs.spec.alpha :as s]
            [re-frame.core :refer [reg-event-db reg-sub subscribe]]))

;; -- Default app-db Value  ---------------------------------------------------
;;
;; When the application first starts, this will be the value put in app-db
;; Unless, of course, there are todos in the LocalStore (see further below)
;; Look in:
;;   1.  `core.cljs` for  "(dispatch-sync [:initialise-db])"
;;   2.  `events.cljs` for the registration of :initialise-db handler
;;

(reg-sub   ;; we can check if there is data
  :initialised?          ;; usage (subscribe [:initialised?])
  (fn  [db _]
    (not (empty? db))))  ;; do we have data

(defn orientation []
  (if (> (.-innerHeight js/window) (.-innerWidth js/window))
     "portrait"
     "landscape"))

(reg-sub
  :orientation
  (fn [db _]
    (:orientation db)))

(reg-event-db
   :initialise-db
   (fn [db _]
     (assoc db
       :orientation (orientation))))
