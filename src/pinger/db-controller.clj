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
