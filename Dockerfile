FROM clojure

WORKDIR /clj
ADD . /clj
VOLUME /clj

# 3449 is default http and websocket port that figwheel uses to communicate
EXPOSE 3449
# 7888 is the default nrepl port
EXPOSE 7888

RUN lein deps
RUN lein cljsbuild once dev worker
CMD lein figwheel dev
