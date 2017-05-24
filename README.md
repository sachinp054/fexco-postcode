fexco-postcode appilaction is for searching addresses in Ireland and UK, based on postcodes. Api is designed and developed as per the task-proposal (task-proposal.md).

<b>Key points:-</b>

1- Mongodb is being used for persiting searched addresses. 

2- Cache is being used for optimizing address search.

3- This is assured that for each eircode or postcode third party api will be hit only once. If there comes another request for same eircode/postcode search address will be retrieved from cache or db and parsed as per the query parameters.

<b>Build And Run Application:-</b>

Create Docker image of application with prod profile and install-

./mvnw clean package -Pprod docker:build

To run the application execute below command in project root directory-

docker-compose up -d (to run in background)
