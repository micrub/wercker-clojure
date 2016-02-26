(ns {{namespace}}
  (:use org.httpkit.server)
  (:gen-class))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defn -main
  [& args]
  (run-server app {:port 8080
                   :ip "0.0.0.0"
                   :worker-name-prefix "{{namespace}}"}))
