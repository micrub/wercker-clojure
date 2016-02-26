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
             ["intro.md" (render "intro.md" data)]
             ["CHANGELOG.md" (render "CHANGELOG.md" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             [".gitignore" (render "gitignore" data)]
             [".hgignore" (render "hgignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}/test.clj" (render "test.clj" data)]
             ["test/{{sanitized}}/core.clj" (render "clojure.clj" data)])))
