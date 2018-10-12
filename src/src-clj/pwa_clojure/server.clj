(ns pwa-clojure.server
  (:require
    [ring.middleware.content-type :refer :all]
    [ring.middleware.resource :refer :all]
    [ring.middleware.not-modified :refer :all]
    [ring.util.response :refer :all]))

(def app
   (-> (response "Page non trouvée")
       (wrap-resource "public")
       wrap-content-type
       wrap-not-modified))

; (defn main [] (println "coucou"))
