# Vidya Vedika - Next Phase

Implemented in this build:
- Auth database migration with Flyway
- Gateway JWT validation
- Gateway injects authenticated user context headers
- Admin route authorization at gateway
- Public auth endpoints remain accessible
- Environment-driven JWT secret

Build requirement: Java 21 and Maven 3.9+.

Run from backend:
`mvn clean verify`
