(defproject ring-example "0.1.0-SNAPSHOT"
  :description ""
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring-cors "0.1.13"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [metosin/reitit "0.5.12"]]
  :repl-options {:init-ns example.server})
