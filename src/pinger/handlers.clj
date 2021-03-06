(ns pinger.handlers
  (:require [pinger.dbcontroller :as db]))
;Functions that handle success or failure of the ping


(defn handle-ping-success
  "Handler for when a site is successfully pinged"
  [site]
  (println "Site Is Up!")
  (db/insert-on-success site))

(defn handle-ping-failure
  "Handler for When a Site is Down"
  [site]
  (println "Error - Site is Down" site)
  (db/insert-on-fail site))
