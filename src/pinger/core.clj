(ns pinger.core
  (:gen-class)
  (:require [clojure.core.async
    :as a
    :refer [>! <! >!! <!! go go-loop chan buffer close! thread
    alts! alts!! timeout]]
    [clj-http.client :as client]))

;Load needed files
(load "handlers");

; Main Thread
; Should loop through all sites in DB
; Creates a new thread for each site to check
; Ping them to check if the site is loading correclty

;TODO Change this to be pulled from a DB - This is just for testing purposes
(def sites ['http://www.totalwebconnections.com', 'https://www.simpleleadtracker.com', 'https://www.lifting-buddy.com'])

(defn ping-sites
  "Handles The Thread That Pings Sites"
  []
  (Thread/sleep 10000)
  (try
    (def request-result (client/get "http://totalwessbconnections.com" {:accept :json}))
  (catch Exception e
    (handle-ping-failure))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Server Starting")

  (doseq [i sites]
    (thread (ping-sites)))
    (Thread/sleep 20000))
