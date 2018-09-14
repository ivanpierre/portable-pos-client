(ns pwa-clojure.app
  (:require [ring.middleware.resource :as resources]
            [ring.middleware.content-type :as content-type]))

(def app
  (-> (constantly {:status 404, :body "not found"})
      (resources/wrap-resource "public")
      (content-type/wrap-content-type)))
