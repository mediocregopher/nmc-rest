(defproject nmc-rest "0.0.1"
  :description "A thin REST API on top of the namecoin blockchain."
  :url "github.com/mediocregopher/nmc-rest"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [me.raynes/conch "0.5.0"]
                 [cheshire "5.3.0"]
                 [org.clojars.mediocregopher/my-compojure "0.1.0"]
                 [compojure "1.1.5"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler nmc-rest.handler/app}
  :main nmc-rest.core)
