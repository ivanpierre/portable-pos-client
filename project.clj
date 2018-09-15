(defproject pwa-clojure "0.0.1-SNAPSHOT"
  :description "A simple example to build a PWA app with ClojureScript"

  :source-paths ["src-clj"]

  :dependencies [; Clojure
                 [org.clojure/clojure "1.9.0"]
                 [ring "1.5.0"]

                 ; ClojureScript
                 [org.clojure/clojurescript "1.10.339"]
                 [com.cemerick/url "0.1.1"] ; just for service worker
                 [reagent "0.8.1"]
                 [re-frame "0.10.6"]]

  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-figwheel "0.5.14"]]

  :clean-targets ^{:protect false} [:target-path :compile-path
                                    "resources/public/service-worker.js"
                                    "resources/public/js"]

  :main pwa-clojure.main

  :figwheel [:repl false]

  :cljsbuild
  {:builds {:dev {:source-paths ["src-cljs"]
                  :compiler {:output-to "resources/public/js/main.js"
                             :output-dir "resources/public/js/compiled/out"
                             :asset-path "js/compiled/out" ;; <--- relative URL of output-dir
                             :main pwa-clojure.main
                             :optimizations :none
                             :pretty-print true}}

            :prod {:source-paths ["src-cljs"]
                   :compiler {:output-to "resources/public/js/main.js"
                              :main pwa-clojure.main
                              :optimizations :advanced
                              :pretty-print false}}

            :worker {:source-paths ["src-svc"]
                     :compiler {:output-to "resources/public/service-worker.js"
                                ; We are in advanced compilation, so no compilations in ressources
                                :main pwa-clojure.service-worker
                                :optimizations :advanced
                                :pretty-print false}}}}

  :ring {:handler pwa-clojure.app/app
         :nrepl {:start? true}})
