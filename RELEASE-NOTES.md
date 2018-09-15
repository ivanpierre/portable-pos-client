# Release Notes for the project state

## 14/09/18 Cleaned application with compilation (not working)
project with `:worker`, `:dev` and `:prod` profiles for the ClojureScript compilation.

Compilation :

`lein cljsbuild once` _profile_.

Compilation result in the `resources` directory.

Internal HTTPD server with `Jetty` compilation and launching :

`lein run`
