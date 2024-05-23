Here's how to run the provided Docker commands to create databases for your Spring Boot REST API project:

1. MySQL Database:

This command creates a detached (-d) MySQL container named by default (--name=""). It sets the root password (MYSQL_ROOT_PASSWORD) to "root" and maps the container's port 3309 to the host machine's port 3306 (-p 3309:3306). Additionally, it forces lowercase table names (--lower_case_table_names=1).

Instructions:

Open a terminal window.
Run the following command, replacing "root" with your desired password if needed:
Bash
**docker run -d -e MYSQL_ROOT_PASSWORD=root -p 3309:3306 mysql --lower_case_table_names=1**
Use code with caution.
content_copy
2. MongoDB Database:

This command creates a detached (-d) MongoDB container named "mongodb". It sets the root username (MONGO_INITDB_ROOT_USERNAME) and password (MONGO_INITDB_ROOT_PASSWORD) to "root" and maps the container's port 27017 to the host machine's port 27017 (-p 27017:27017).

Instructions:

Open a terminal window.
Run the following command:
Bash
**docker run -d --name mongodb -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root -p 27017:27017 mongo**
Use code with caution.
content_copy
Important Notes:

These commands set the root password for both databases to "root". This is for demonstration purposes only. In production environments, use strong and unique passwords.
Make sure Docker is installed and running on your system before using these commands.
Depending on your Spring Boot application configuration, you might need to adjust the connection details (host, port, username, password) to connect to the databases from your application.
