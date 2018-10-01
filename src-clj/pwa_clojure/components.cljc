(ns pwa-clojure.components)
;  (:require #?@(:cljs [[pwa-clojure.actions :as actions]])))

; (def navigate #?(:cljs actions/navigate :clj (constantly nil)))
; (def download-character #?(:cljs actions/download-character :clj (constantly nil)))

; (defn pwa-link [{:keys [href] :as params} & children]
;   (into [:a (assoc params :on-click #(navigate % href))]
;         children))

(defn home-component [{:keys [characters]}]
  "home-component")

