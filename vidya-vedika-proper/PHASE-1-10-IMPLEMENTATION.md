# Vidya Vedika — Phase 1 to Phase 10 Integrated Implementation

This release consolidates the requested architecture and implementation into one repository.

## Phase map
1. Foundation: React/Vite, Java 21/Spring Boot, Maven modules, Docker/config.
2. Security: JWT/BCrypt foundation, protected gateway architecture, environment secrets.
3. User Management: user profile persistence and APIs.
4. Learning: lessons, vocabulary, daily tasks and user lesson progress.
5. AI Practice: provider abstraction, Ollama adapter, fallback provider, sentence correction and practice.
6. Mock Interviews: sessions, questions, answers, scoring and history.
7. Admin: dashboard/audit foundation and privileged management boundary.
8. Analytics/Support: dashboard data foundation, contributions and notifications persistence.
9. Production Engineering: validation, global errors, Docker, CI verification, environment templates.
10. Release: integrated repository, production-readiness gate and deployment documentation.

## Verification
Run backend:
`cd backend && mvn clean verify`

Run frontend:
`cd frontend && npm ci && npm run build`

Run local infrastructure according to `infrastructure/docker/docker-compose.yml`.

Do not put real secrets in source control. Configure production secrets using the deployment platform's secret manager/environment settings.

## Important
Production release approval must be based on successful CI builds, integration tests, security review, deployment smoke tests, backup/restore verification, and load testing in the target environment.
