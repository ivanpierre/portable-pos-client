(ns pwa-clojure.app-state
  (:require [cljs.reader]
            [cljs.spec.alpha :as s]
            [re-frame.core :as re-frame]))

;; -- Default app-db Value  ---------------------------------------------------
;;
;; When the application first starts, this will be the value put in app-db
;; Unless, of course, there are todos in the LocalStore (see further below)
;; Look in:
;;   1.  `core.cljs` for  "(dispatch-sync [:initialise-db])"
;;   2.  `events.cljs` for the registration of :initialise-db handler
;;

(def default-db           ;; what gets put into app-db by default.
  {:server  nil           ;; Server infos
   :pos nil               ;; Pos infos
   :cashier nil           ;; cashier infos
   :module nil})          ;; current module

;; Current state
(def ^:export app-state (atom nil))
