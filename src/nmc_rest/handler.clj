(ns nmc-rest.handler
  (:require [compojure.core :refer :all]
            compojure.handler
            compojure.route
            [cheshire.core :refer [generate-string]]
            [nmc-rest.nmcd :refer :all]))

(defroutes app-routes
  (GET "/" [] "A REST API for the namecoin blockchain")
  (GET "/v1" [] "")

  (GET "/v1/n/:name" {{n :name} :params}
    (when-let [ret (name-show n)]
      { :headers { "Content-Type" "application/json" }
        :body (generate-string ret) }))

  (GET "/v1/n/:name/:field" {{n :name f :field} :params}
    (when-let [ret-n (name-show n)]
      (when-let [ret (ret-n f)]
        { :headers { "Content-Type" "text/plain" }
          :body ret })))

  (compojure.route/not-found ""))

(def app
  (compojure.handler/api app-routes))
