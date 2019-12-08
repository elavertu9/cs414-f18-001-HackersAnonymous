# Development manual
A step by step guide for building our project

Building the server 

###  build.sh:
* Usage: ./build.sh
* Purpose: Running this script will install the frontend dependencies (npm install) and will install the backend dependencies (mvn clean install). After building the server you will need to run host_frontend.sh and host_backend.sh. You will need 2 terminal tabs/windows open to do this

### host_frontend.sh:

* Usage: Run this script by typing ./host_frontend.sh
* Purpose: Hosts the frontend code using webpack and npm (npm run dev)		

### host_backend.sh:

* Usage: Run this script by typing ./host_backend.sh <Version>
* Purpose: Hosts the backend code using java jar (java -jar backend-.jar)		

To determine the version look in backend/pom.xml or backend/target after building the project.w and watch the results in the right.
