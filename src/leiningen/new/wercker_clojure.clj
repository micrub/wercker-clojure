(ns leiningen.new.wercker-clojure
  (:require [leiningen.new.templates :refer
               [renderer year date project-name ->files
                sanitize-ns name-to-path multi-segment]]
            [leiningen.core.main :as main]))

(def render (renderer "wercker-clojure"))

(defn wercker-clojure
  "FIXME: write documentation"
  [name]
  (let [main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
                            :name (project-name name)
                            :namespace main-ns
                            :nested-dirs (name-to-path main-ns)
                            :year (year)
                            :date (date)}]
    (main/info "Generating fresh 'lein new' wercker-clojure project.")
    (->files data
             ["intro.md" (render "intro.md" data)]
             ["CHANGELOG.md" (render "CHANGELOG.md" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             [".gitignore" (render "gitignore" data)]
             [".hgignore" (render "hgignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["test/{{sanitized}}/core_test.clj" (render "core_test.clj" data)])))
