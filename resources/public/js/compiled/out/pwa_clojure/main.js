// Compiled by ClojureScript 1.10.339 {}
goog.provide('pwa_clojure.main');
goog.require('cljs.core');
goog.require('pwa_clojure.app_state');
pwa_clojure.main.make_progressive_BANG_ = (function pwa_clojure$main$make_progressive_BANG_(){
if(cljs.core.truth_(navigator.serviceWorker)){
return navigator.serviceWorker.register("/service-worker.js");
} else {
return null;
}
});
if((typeof pwa_clojure !== 'undefined') && (typeof pwa_clojure.main !== 'undefined') && (typeof pwa_clojure.main.app_loaded !== 'undefined')){
} else {
pwa_clojure.main.app_loaded = cljs.core.atom.call(null,false);
}
pwa_clojure.main.load_app = (function pwa_clojure$main$load_app(){
if(cljs.core.truth_(cljs.core.deref.call(null,pwa_clojure.main.app_loaded))){
return null;
} else {
cljs.core.reset_BANG_.call(null,pwa_clojure.main.app_loaded,true);

return pwa_clojure.main.main.call(null,pwa_clojure.main.component);
}
});
pwa_clojure.main.start_cljs_app = (function pwa_clojure$main$start_cljs_app(){
pwa_clojure.main.load_app.call(null);

return pwa_clojure.main.make_progressive_BANG_.call(null);
});
goog.exportSymbol('pwa_clojure.main.start_cljs_app', pwa_clojure.main.start_cljs_app);
pwa_clojure.main.start_cljs_app.call(null);

//# sourceMappingURL=main.js.map
