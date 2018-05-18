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
  (j/query mysql-db
  ["insert (?, ?, ?, ?) into failed_pings"]))

(defn insert-on-fail
  "Query to update DB on a failed ping"
  [site]
  (j/query mysql-db
  ["insert (?, ?, ?) into successful_pings"]))
