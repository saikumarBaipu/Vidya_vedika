# Vidya Vedika

A production-oriented foundation for an AI language learning and mock interview platform.

## Stack
- React + Vite + TypeScript
- Java 21 + Spring Boot 3.5
- Spring Cloud Gateway
- MySQL 8.4
- JWT + BCrypt in Auth Service
- AI provider fallback architecture

## Run frontend
```powershell
cd frontend
npm install
npm run dev
```
Open http://localhost:5173

## Run backend with Maven
Install Maven 3.9+ and Java 21.

```powershell
cd backend
mvn clean package -DskipTests
java -jar auth-service/target/auth-service-1.0.0.jar
java -jar api-gateway/target/api-gateway-1.0.0.jar
```

For all modules, build with `mvn clean package`.

## Docker
```powershell
cd infrastructure/docker
docker compose up --build
```

The compose file starts MySQL, Auth Service and API Gateway. Other services can be built and added as resources permit.

## API examples
POST `/api/auth/register`
```json
{"name":"Demo User","email":"demo@example.com","password":"Password123"}
```

POST `/api/auth/login`
```json
{"email":"demo@example.com","password":"Password123"}
```

GET `/api/languages`

POST `/api/ai/correction`
```json
{"sentence":"I am go to school yesterday."}
```

## Important
This repository contains real executable service code for the initial vertical slice. Features not yet implemented should not be represented as complete production functionality. Extend the modules incrementally following the Vidya Vedika specification.
