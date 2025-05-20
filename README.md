# pet-clinic

  Sample cUrl

`curl --location 'http://localhost:8080/api/v1/owners' \
--header 'Content-Type: application/json' \
--data '{
    "firstName":"Yogesh",
    "lastName":"Kale",
    "address":"Pune",
    "city":"Pune",
    "telephone":"8208356143"
}'`

`curl --location 'http://localhost:8080/api/v1/owners/2'`

`curl --location 'http://localhost:8080/api/v1/owners/pets/1'`

