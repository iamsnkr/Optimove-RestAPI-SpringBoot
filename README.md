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
