Here's how to run the provided Docker commands to create databases for your Spring Boot REST API project:

**1. MySQL Database:**

This command creates a detached (-d) MySQL container named by default (--name=""). It sets the root password (MYSQL_ROOT_PASSWORD) to "root" and maps the container's port 3309 to the host machine's port 3306 (-p 3309:3306). Additionally, it forces lowercase table names (--lower_case_table_names=1).

Here's how to run the provided Docker commands to create databases for your Spring Boot REST API project:

**1. MySQL Database:**

**Instructions:**

Open a terminal window.
Run the following command
```bash
docker run -d -e MYSQL_ROOT_PASSWORD=root -p 3309:3306 mysql --lower_case_table_names=1
```

**2. MongoDB Database:**

**Instructions:**

Open a terminal window.
Run the following command:
```Bash
docker run -d --name mongodb -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root -p 27017:27017 mongo
```
Depending on your Spring Boot application configuration, you might need to adjust the connection details (host, port, username, password) to connect to the databases from your application.


**Get The Optimove Data from MYSQL**
```bash
http://localhost:8080/api/kafka/kafkadata
```

**Get The UseCaseAndTopics Data from MONGODB**
```bash
http://localhost:8080/api/kafka/kafkadata
```

**Get The Kafka Data**
```bash
http://localhost:8080/api/kafka/kafkadata
```


**Data Retrieval:**

**Get The Optimove Data from MYSQL and Get The UseCaseAndTopics Data from MONGODB:** 
- Optimove data is likely retrieved from a MySQL database.
- UseCaseAndTopics data is retrieved from a MongoDB database.

**Data Processing:**
Get The Kafka Data: it is triggering the storage of the combined data.
Here's a possible scenario:
After retrieving and potentially combining Optimove and UseCaseAndTopics data and this API call will store it in a MySQL database for further processing or storage.
