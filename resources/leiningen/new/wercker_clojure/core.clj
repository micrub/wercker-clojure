(ns {{namespace}}
  (:use org.httpkit.server)
  (:gen-class))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defn -main
  [& args]
  (let [port 8080]
    (println "Listening on port: " port)
    (run-server app {:port port
                     :ip "0.0.0.0"
                     :worker-name-prefix "{{namespace}}"})))
