# Vidya Vedika — Phase 10 Integrated Release

This is the integrated final-phase codebase assembled from the project requirements. It includes the monorepo, React frontend, Spring Boot services, authentication/JWT foundation, persistence layers, AI abstraction, admin/user/language/learning/interview/payment/notification modules, Docker infrastructure and CI scaffolding.

## Important verification status

This package was assembled for local development. Run `mvn clean verify` and `npm install && npm run build` on a machine with Java 21, Maven 3.9+, Node 20+ and Docker installed. Do not treat a successful ZIP creation as a substitute for those builds.

## Architecture

React -> API Gateway -> Auth/User/Language/Learning/AI/Interview/Payment/Notification/Admin services -> MySQL

## Production hardening checklist

- Replace development secrets with deployment secret storage.
- Configure HTTPS and a real CORS allow-list.
- Use separate database/schema credentials per service in production.
- Add distributed tracing/metrics/log aggregation.
- Add Testcontainers integration tests for every persistence service.
- Configure backups, migrations and rollback procedures.
- Configure real email/notification providers before enabling those workflows.
- Configure an AI provider or Ollama for AI features.

## Local start

1. Copy `.env.example` to `.env`.
2. Start infrastructure: `docker compose -f infrastructure/docker/docker-compose.yml up -d mysql`.
3. Backend: `cd backend && mvn clean verify`.
4. Start required Spring Boot services.
5. Frontend: `cd frontend && npm install && npm run dev`.

## API documentation

Each Spring Boot service exposes Actuator health when configured. Add Springdoc/OpenAPI dependency and deployment configuration if API UI is required in the target environment.
