(ns nmc-rest.config
    (:require [clojure.tools.reader.edn :as edn]))

(def default-config-str "
;; This is an example configuration for nmc-rest. It contains all the default
;; values for the various options, change them as needed.
{

    ;; Options for the HTTP REST API (OMG CAPS). These are the most common ones
    ;; that'll be used, you can find a full list of available options at:
    ;; http://mmcgrana.github.io/ring/ring.adapter.jetty.html
    :rest {
            :host \"0.0.0.0\"
            :port 3000
          }

}
")

(def config-atom (atom {}))

(defn cget
    "Given key you want from the config, returns that key. Key can be multiple layers deep, for
    instance: (cget :redis :host)"
    [& keys]
    (get-in @config-atom keys))

(defn put-default-config
    "Given a filename puts the example config there (complete with comments)"
    [filename]
    (spit filename default-config-str))

(defn load-config-str
    "Given a string, loads it in as configuration"
    [config-str]
    (->> config-str
         (edn/read-string)
         (reset! config-atom)))

(defn load-config
    "Given a filename, loads it in as configuration"
    [filename]
    (-> filename
        (slurp)
        (load-config-str)))

(load-config-str default-config-str)
