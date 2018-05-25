(use 'clojure.string)
(defn readCustomerData [file_name]
  (def lines (split-lines (slurp file_name)))
  (def cust-map (sorted-map))
  (defrecord Customer [custId name address phoneNumber])
  (doseq [[i row] (map-indexed vector lines)]
    (def info_field (split row #"\|"))
    (let [[cust_id name address phone_number :as everything] info_field]
      (def record (->Customer cust_id name address phone_number))
      (def cust-map (conj cust-map {cust_id record}))
    )
  )
)

(defn readProductData [file_name]
  (def data (slurp file_name))
  (def lines (split-lines data))
  (def product-map (sorted-map))
  (defrecord Product [prodId itemDescription unitCost])
  (doseq [[i row] (map-indexed vector lines)]
    (def info_field (split row #"\|"))
    (let [[prod_id item_description unit_cost] info_field]
      (def record (->Product prod_id item_description unit_cost))
      (def prod-map (conj prod-map {prod_id record}))
      (println prod-map)))
)

(defn readSalesData [file_name]
  (def lines (split-lines (slurp file_name)))
  (def sales-map (sorted-map))
  (defrecord Sales [salesId custId prodId itemCount])
  (doseq [[i row] (map-indexed vector lines)]
    (def info_field (split row #"\|"))
    (let [[sales_id cust_id prod_id item_count] info_field]
      (def record (->Sales sales_id cust_id prod_id item_count))
      (def sales-map (conj sales-map {sales_id record}))
      (println sales-map)))
)

(readCustomerData "cust.txt")

(defn displayCustomerTable []
  (doseq [[k v] cust-map] (print k ":" "[") (pr (:name v) (:address v) (:phoneNumber v)) (println "]"))
)

(defn displayProductTable []
  (doseq [[k v] product-map] (print k ":" "[") (pr (:itemDescription v) (:unitCost v)) (println "]"))
)

(displayCustomerTable)

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
