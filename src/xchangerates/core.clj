(ns xchangerates.core
  (:require [clojure-csv.core :as csv]
            [clojure.java.io :as io]
            [mount.core :refer [defstate]]
            [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [site]]
            [org.httpkit.server :refer [run-server]]))

(def xchange-csv (io/resource "UNdata_Export_20180630_193836824.csv"))

(def xchange-data-store (atom nil))

(defn start-app []
  (atom (read-string (slurp (io/resource "config.edn")))))

(defn stop-app [s]
  (reset! s nil))

(defstate state :start (start-app)
  :stop (stop-app state))

(defn get-root []
  "Hello, world!")

(defroutes routes
  (GET "/" [] "Hello, world!"))

(defn start-server []
  (atom (run-server (site routes) {:port 8090})))

(defn stop-server [s]
  (let [derefed @s]
    (when-not (nil? derefed)
     (derefed :timeout 100)
     (reset! s nil))))

(defstate web-server :start (start-server)
  :stop (stop-server web-server))

;; (defstate db-conn :start (connect-db)
  ;; :stop (disconnect-db db-conn))

(defn load-exchange-data
  []
  (reset! xchange-data-store
     (csv/parse-csv (slurp xchange-csv ))))
;; ,eb

;; ,ss to switch to repl

;;,s n
(load-exchange-data)

(count @xchange-data-store)

(first @xchange-data-store)
