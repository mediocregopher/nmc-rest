(ns nmc-rest.nmcd
  (:require [me.raynes.conch :refer [with-programs]]
            [cheshire.core :refer [parse-string]]))

(defn nmcd
  "Calls namecoind and passes any given arguments to it (after calling name on
  them, to turn them into strings), then parses the json response"
  [& args]
  (parse-string
    (with-programs [namecoind]
      (apply namecoind (map name args)))
    true))

(defn name-show
  "Calls 'namecoind name_show <n>'"
  [n]
  (nmcd :name_show n))
