(ns pwa-clojure.main
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]
            [pwa-clojure.app :as app]))

(def http-port 3000)

(defn -main []
  (jetty/run-jetty app/app {:port http-port}))
