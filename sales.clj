(use 'clojure.java.io)
(defn readCustomerData [file_name]
  (with-open [rdr (reader file_name)]
    (doseq [line (line-seq rdr)]
    (println line)))
)

(readCustomerData "cust.txt")

(defn displayMenu []
  (println "*** Sales Menu ***\n------------------")
  (println "1. Display Customer Table")
  (println "2. Display Product Table")
  (println "3. Display Sales Table")
  (println "4. Total Sales for Customer")
  (println "5. Total Count for Product")
  (println "6. Exit")
  (println "\nEnter an option?")
  (def var (read-line))
  (println var)
)

(displayMenu)
