(defproject pinger "0.1.0-SNAPSHOT"
  :description "A simple application that pings sites to check they're alive and records results to the DB"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                [org.clojure/core.async "0.4.474"]
                [clj-http "3.9.0"]
                [mysql/mysql-connector-java "8.0.11"]
                [org.clojure/java.jdbc "0.7.6"]]
  :main ^:skip-aot pinger.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
