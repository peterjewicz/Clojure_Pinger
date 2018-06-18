(ns pinger.core
  (:gen-class)
  (:require [clj-http.client :as client]
            [clojure.java.jdbc :as j]
            [pinger.dbcontroller :as db]
            [pinger.handlers :as handlers]))

; Main Thread
; Should loop through all sites in DB
; Creates a new thread for each site to check
; Ping them to check if the site is loading correclty

;TODO Change this to be pulled from a DB - This is just for testing purposes
;(def sites ["http://www.totalwebconnections.com", "https://www.simpleleadtrackers.com", "https://www.lifting-buddys.com"])

(defn ping-sites
  "Handles The Thread That Pings Sites"
  [site]
  (try
    (def request-result (client/get site {:accept :json}))
    (handlers/handle-ping-success site)
  (catch Exception e
    (handlers/handle-ping-failure site))))

(defn run-loop [max sites]
  (loop [n max]
    (when (pos? n)
      (doseq [i sites]
        (println i)
        (thread (ping-sites i)))
        (Thread/sleep 5000)
      (recur (dec n)))))


(defn test-query
  []
  (try
    (def result (client/get "http://www.totalwebconnections.com/asdasdad" {:as :json}))
    (println result)
    (result :status)
    ; (result :request-time)
  (catch Exception e
    (println "Error")
    (.getMessage  e)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Server Starting")
  ; (def urls (query-sites))
  ; (run-loop 100000 urls)
  (test-query)
  )
