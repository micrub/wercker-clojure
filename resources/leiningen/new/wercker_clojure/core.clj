(ns {{namespace}}
  (:use org.httpkit.server)
  (:require [ring.middleware.reload :as reload])
  (:gen-class))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defn start-server [port]
  (reset!
    server
    (run-server
      (reload/wrap-reload #'app)
      {:port port
       :ip "0.0.0.0"
       :worker-name-prefix "{{namespace}}"}))
  (println "Serving on port: " port))

(defn stop-server []
  (@server :timeout 100)
  (reset! server nil)
  (println "Stopped server."))

(defn -main
  [& args]
  (let [port 8080]
    (start-server port)))
