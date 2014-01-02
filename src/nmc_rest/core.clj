(ns nmc-rest.core
  (:gen-class)
  (:require [my-compojure.core :refer [conf-load-cli conf-get run]]
            [nmc-rest.handler :as handler]))

(def description
  "A rest api around the namecoin blockchain")

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

(defn -main [& args]
  (conf-load-cli description default-config-str args)
  (run handler/app (conf-get :rest)))
