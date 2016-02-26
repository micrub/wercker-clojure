(ns leiningen.new.wercker-clojure
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "wercker-clojure"))

(defn wercker-clojure
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' wercker-clojure project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
