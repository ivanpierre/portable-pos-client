(ns pwa-clojure.server
  (:require
    [ring.middleware.content-type :refer [warp-content-type]]
    [ring.middleware.resource :refer [warp-resource]]
    [ring.middleware.not-modified :refer [warp-not-modified]]
    [ring.util.response :as [response]]))

(def app
  (-> (response "Original not changed")
      (warp-resource "public")
      warp-content-type
      warp-not-modified))
