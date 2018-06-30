(ns xchangerates.core
  (:require [clojure-csv.core :as csv]
            [clojure.java.io :as io]))


(def xchange-csv (io/resource "UNdata_Export_20180630_193836824.csv"))

(def xchange-data-store (atom nil))
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
