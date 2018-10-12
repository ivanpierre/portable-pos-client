(ns pwa-clojure.server
  (:require
    [ring.middleware.content-type :refer :all]
    [ring.middleware.resource :refer :all]
    [ring.middleware.not-modified :refer :all]))
;    [ring.util.response :refer :all]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})

(def app
   (-> handler
       (wrap-resource "public")
       wrap-content-type
       wrap-not-modified))

; (defn main [] (println "coucou"))
