(ns piger.dbcontroller)

;All the database query and connection info should be saved here

(def mysql-db {:dbtype "mysql"
               :dbname "pinger"
               :user "peter"
               :password ""
               :serverTimezone "UTC"
               :useSSL "false"})


(defn query-sites
  "Grabs the sites to ping against"
  []
  (j/query mysql-db
  ["select * from sites"]
  {:row-fn :url}))



(defn insert-on-success
  "Query to update DB on successfull ping"
  [site]
  (j/insert-multi! mysql-db :successful_pings
  [{:site_id 1 :timestamp (System/currentTimeMillis)}]))

(defn insert-on-fail
  "Query to update DB on a failed ping"
  [site]
  (j/insert-multi! mysql-db :failed_pings
  [{:site_id 1 :failure_time (System/currentTimeMillis) :failure_reason "Not Sure Yet" :site_url site}]))
