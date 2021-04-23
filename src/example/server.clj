(ns example.server
  (:require [reitit.ring :as ring]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.cors :refer [wrap-cors]]
            [reitit.dev.pretty :as pretty]))

(defn handler [_]
  {:status 200, :body "hello app"})

(def app
  (ring/ring-handler
   (ring/router
    ["/" {:get handler}]
    {:exception pretty/exception
     :data {:middleware [[wrap-cors :access-control-allow-origin [#".*"]
                                    :access-control-allow-methods [:get :put :post :patch :delete]]]}})
   (ring/create-default-handler {:not-found (constantly {:status 404 :body "Not found"})})))

(defn start []
  (jetty/run-jetty #'app {:port 3000, :join? false})
  (println "server running in port 3000"))

(comment
  (start))
