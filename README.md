fexco-postcode application is for searching addresses in Ireland and UK, based on postcodes. Api is designed and developed as per the task-proposal (task-proposal.md).

<b>Key points:-</b>

1- Mongodb is being used for persisting searched addresses. 

2- Cache is being used for optimizing address search.

3- This is assured that for each eircode or postcode third party api will be hit only once. If there comes another request for same eircode/postcode search address will be retrieved from cache or db and parsed as per the query parameters.

<b>Build And Run Application:-</b>

Create Docker image of application with prod profile and install-

./mvnw clean package -Pprod docker:build

To run the application execute below command in project root directory-

docker-compose up -d (to run in background)

<b>Endpoints </b>

For endpoint documentation, swagger is used. Simply hitting the url machine-ip:8080/swagger-ui.html will take to the home page.
Using the same interfce we can execute api for multiple eirCode/postCode

1- For fetching address based on eircode - /address/ie/{eirCode}
1- For fetching address based on postcode - /address/uk/{postcode}
