(ns pwa-clojure.pages
  (:require [pwa-clojure.components :as components]))

(def pages
  {:home-page {:data-fn (constantly [[:characters {}]])
               :component #'components/home-component
               :title-fn (constantly "Portable POS page :pages/home-page")}})

(defn data-requirements [handler params]
  (let [data-fn (get-in pages [handler :data-fn])]
    (data-fn params)))

(defn title [handler data]
  (let [title-fn (get-in pages [handler :title-fn])]
    (title-fn data)))

(defn pwa-component [handler data]
  (let [component (get-in pages [handler :component])]
    (component data)))
