(defproject pwa-clojure "0.1.1-SNAPSHOT"
  :description "A simple example of to build a PWA app with clojurescript"

  :source-paths ["src-clj"]

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [bidi "2.1.4"]
                 [hiccup "1.0.5"]
                 [cheshire "5.8.1"]
                 [ring "1.7.0"]
                 [clj-http "3.9.1"]
                 [com.cemerick/url "0.1.1"]
                 [cljs-ajax "0.7.4"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.6"]
                 [com.bhauman/rebel-readline "0.1.4"]
                 [figwheel-sidecar "0.5.16"]
                 [cider/piggieback "0.3.9"]
                 [refactor-nrepl "2.4.0"]]

  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-ring "0.8.7"]
            [lein-figwheel "0.5.16"]]

  :clean-targets ^{:protect false} [:target-path :compile-path
                                    "resources/public/js"]

  :main pwa-clojure.main

  :ring {:handler pwa-clojure.app/app
         :nrepl {:start? true}}

  ;:repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]} ;; <-- Note

  :cljsbuild
  {:builds {:dev
            {:source-paths ["src-cljs"]
             :watch-paths ["src-cljs"]
             :figwheel {; :websocket-host "optiflex.ivanpierre.world"
                        :load-warninged-code false
                        :on-jsload "pwa-clojure.main/fig-reload-hook"
                        :websocket-url "ws://optiflex.ivanpierre.world:3449/figwheel-ws"}
             :compiler {:output-to "resources/public/js/dev/main.js"
                        :output-dir "resources/public/js/dev"
                        :asset-path "js/dev" ;; <--- relative URL of output-dir
                        :main pwa-clojure.main
                        :optimizations :none
                        :pretty-print true}}

            :prod
            {:source-paths ["src-cljs"]
             :compiler {:output-to "resources/public/js/prod/main.js"
                        :output-dir "resources/public/js/prod"
                        :asset-path "js/prod" ;; <--- relative URL of output-dir
                        :main pwa-clojure.main
                        :optimizations :advanced
                        :pretty-print false}}

            :worker
            {:source-paths ["src-svc" "src-cljs"]
             :compiler {:output-to "resources/public/js/worker/service-worker.js"
                        :output-dir "resources/public/js/worker"
                        :asset-path "js/worker" ;; <--- relative URL of output-dir
                        :main pwa-clojure.service-worker
                        :optimizations :advanced
                        :pretty-print false}}}}

  ;; Main figwheel config
  :figwheel
   {:http-server-root "public" ;; this will be in resources/
                ; :server-ip   "0.0.0.0"     ;; default is "localhost"
    ; :websocket-host "optiflex.ivanpierre.world"

                ; :nrepl-host  "0.0.0.0"
    :nrepl-port  7888

                ;; CSS reloading (optional)
                ;; :css-dirs has no default value
                ;; if :css-dirs is set figwheel will detect css file changes and
                ;; send them to the browser
    :css-dirs ["resources/public/css"]

                ;; A list of ClojureScript source directories to be watched and compiled on change.

                ;; The directories in :watch-dirs are passed to the compiler as source directories.
                ;; For this reason, any entry in the watch directories must be on the classpath
                ;; and must point to the root directory of a ClojureScript namespace source tree.}

                ;; I.E. If your example.core namespace is located at src/cljs/example/core.cljs
                ;; you cannot use src as an element of :watch-dirs, you must use the path
                ;; to the root directory of the namespace tree src/cljs.
            ;:watch-dirs ["src-cljs" "src-clj"]

                ;; Server Ring Handler (optional)
                ;; if you want to embed a ring handler into the figwheel http-kit
                ;; server
                ;; :ring-handler pwa-clojure.app/app

                ;; Clojure Macro reloading
                ;; disable clj file reloading
                ; :reload-clj-files false
                ;; or specify which suffixes will cause the reloading
                ; :reload-clj-files {:clj true :cljc false}

                ;; To be able to open files in your editor from the heads up display
                ;; you will need to put a script on your path.
                ;; that script will have to take a file path, a line number and a column
                ;; ie. in  ~/bin/myfile-opener
                ;; #! /bin/sh
                ;; emacsclient -n +$2:$3 $1
                ;;
    :open-file-command "myfile-opener"

                ;; if you want to disable the REPL
                ;; :repl false

                ;; Print to console
    ;:websocket-host "optiflex.ivanpierre.world"

    ;; :client-print-to :console

                ;; to configure a different figwheel logfile path
                ;; :server-logfile "tmp/logs/figwheel-logfile.log"

                ;; Start an nREPL server into the running figwheel process

            ;:connect-url "ws://optiflex.local/figwheel-connect"

                ;; Load CIDER, refactor-nrepl and piggieback middleware
    :nrepl-middleware ["cider.nrepl/cider-middleware"
                        "refactor-nrepl.middleware/wrap-refactor"
                        "cider.piggieback/wrap-cljs-repl"]})

                ;; if you need to watch files with polling instead of FS events
                ;; :hawk-options {:watcher :polling}
                ;; ^ this can be useful in Docker environments

                ;; if your project.clj contains conflicting builds,
                ;; you can choose to only load the builds specified
                ;; on the command line
                ;; :load-all-builds false ; default is true
