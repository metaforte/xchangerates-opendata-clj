(ns xchangerates.core
  (:require [clojure-csv.core :as csv]
            [clojure.java.io :as io]
            [mount.core :refer [defstate]]))

(def xchange-csv (io/resource "UNdata_Export_20180630_193836824.csv"))

(def xchange-data-store (atom nil))

(defn start-app []
  (atom (read-string (slurp (io/resource "config.edn")))))

(defn stop-app [s]
  (reset! s nil))

(defstate state :start (start-app)
  :stop (stop-app state))

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
