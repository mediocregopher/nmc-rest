(defproject nmc-rest "0.0.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.reader "0.7.4"]
                 [org.clojure/tools.cli "0.2.2"]
                 [me.raynes/conch "0.5.0"]
                 [cheshire "5.3.0"]
                 [compojure "1.1.5"]
                 [ring/ring-jetty-adapter "1.2.0-RC1"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler nmc-rest.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}}
  :main nmc-rest.core)
