(ns nmc-rest.core
  (:gen-class)
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [clojure.tools.cli :refer [cli]]
            [nmc-rest.config :as config]
            [nmc-rest.handler :as handler]))

(def description
  "A rest api around the namecoin blockchain")

(def default-config-msg
  "Using the default configuration. You can generate this config using the -d
  flag. You can change the configuration by piping the default one to a file,
  editing, and passing that file in using the -c flag")

(defn -main [& args]
  (let [[opts _ halp]
          (cli args ["-c" "--config" "Configuration file"]
                    ["-d" "--dump" "Dump default configuration to stdout"
                      :flag true]
                    ["-h" "--help" "Print help" :default false])]

    (cond
      (not (false? (opts :help))) (do (print description "\n\n" halp "\n")
                                      (flush)
                                      (System/exit 0))

      (opts :dump) (do (print config/default-config-str)
                       (flush)
                       (System/exit 0))

      (get opts :config false) (config/load-config (opts :config))
      :else (println default-config-msg))

    (run-jetty handler/app (config/cget :rest))))
