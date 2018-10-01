(ns pwa-clojure.views
  (:require [hiccup.page :refer [html5 include-js]]
            [pwa-clojure.pages :as pages]
            [pwa-clojure.server.data :as data]))

(defn css [name]
  [:link {:rel "stylesheet" :href name}])

(defn layout [component title seo-fields]
  {:headers {"Content-Type" "text/html"}
   :body
   (html5
    [:head {:profile "http://www.w3.org/2005/10/profile"} ; needed for favicon change
     [:title title]
     (css "/css/main.css")
     ;[:link {:rel "stylesheet" :href "/css/main.css"}]
     (css "/css/numpad.css")
     (css "/css/vente.css")
     (css "https://fonts.googleapis.com/css?family=Cardo:400,700,400italic|Open+Sans:400,800")
     ;[:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css?family=Cardo:400,700,400italic|Open+Sans:400,800"}]
     [:link {:rel "manifest" :href "/manifest.json"}]
     [:link {:rel "icon" :type "image/png" :href "/favicon.png"}]
     [:meta {:name "description" :content "Home Page"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
     [:meta {:name "apple-mobile-web-app-capable" :content "yes"}]
     [:meta {:name "apple-mobile-web-app-status-bar-style" :content "black"}]
     [:meta {:name "apple-mobile-web-app-title" :content "Portable POS"}]]
    [:body
     [:div#app component]
     (include-js "/js/main.js")])})

(defn- seo-fields [handler data]
  (case handler
    :home-page [[:meta {:name "description" :content "Home Page"}]]
    []))

(defn pwa-page [handler {:keys [route-params]}]
  (let [[data-handler data-args] (first (pages/data-requirements handler route-params))
        data (data/load-data data-handler data-args)
        component (pages/pwa-component handler data)]
    (layout component (pages/title handler data) (seo-fields handler data))))

(defn empty-component []
  [:div
   "L'application démarre"
   [:div.app-loading]])

(defn shell-page [request]
  (layout (empty-component) "PWA App!" []))
