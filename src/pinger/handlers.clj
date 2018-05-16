;Functions that handle success or failure of the ping


(defn handle-ping-success
  "Handler for when a site is successfully pinged"
  [request-result]
  (println "Site Is Up!"))

(defn handle-ping-failure
  "Handler for When a Site is Down"
  []
  (println "Error - Site is Down"))
