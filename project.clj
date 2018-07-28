(defproject xchangerates "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clojure-csv "2.0.2"]
                 [byte-streams "0.2.4"]
                 [org.apache.commons/commons-csv "1.5"]
                 [org.clojure/data.csv "0.1.4"] ;; does not escape the special chars
                 [aysylu/loom "0.5.4"]
                 [mount "0.1.12"]
                 [compojure "1.5.2"]
                 [http-kit "2.2.0"]
                 [clj-http "3.9.0"]
                 [javax.servlet/servlet-api "2.5"]]
  :profiles {:dev {:source-paths ["dev" "src" "test"]} 
             :dependencies [[org.clojure/tools.namespace "0.2.11"]
                            [pjstadig/humane-test-output "0.7.1"]]
             :injections [(require 'pjstadig.humane-test-output)
                          (pjstadig.humane-test-output/activate!)]})
 

