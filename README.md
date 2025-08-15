printf '%s\n' \
'## Run gameflix-auth with Docker' \
'' \
'### Build the app JAR' \
'./mvnw clean install' \
'' \
'### Build the Docker image' \
'docker build -t gameflix-auth .' \
'' \
'### Run the container' \
'docker run -p 8080:8080 gameflix-auth' \
'' \
'### Test endpoints' \
'curl -X POST http://localhost:8080/register \\' \
'-H "Content-Type: application/json" \\' \
'-d '\''{"username":"user1","password":"pass1"}'\''' \
'' \
'curl -X POST http://localhost:8080/login \\' \
'-H "Content-Type: application/json" \\' \
'-d '\''{"username":"user1","password":"pass1"}'\''' \
'' \

> README.md

