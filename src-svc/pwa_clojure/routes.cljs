(ns pwa-clojure.routes)

(def pwa-routes
  [""
   {"/" :home-page}])

(def api-routes
  ["/api"
   {["/characters/" :character-id] :character
    "/characters" :characters}])
