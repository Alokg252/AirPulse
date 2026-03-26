# AirPulse

A Spring Boot application for managing flight bookings, user accounts, and chat functionality.

## Features

- **Flight Management**: Browse and book flights
- **User Management**: User registration and profile management
- **Chat Support**: Built-in chat functionality
- **Database Migrations**: Liquibase-based schema management

## Project Structure

```
src/main/java/com/flarecon/AirPulse/
├── AirPulseApplication.java       # Main application entry point
├── Constants.java                  # Application constants
├── chat/                           # Chat service and controllers
├── controller/                     # REST API endpoints
│   ├── flight/                    # Flight-related endpoints
│   ├── user/                      # User-related endpoints
│   └── test/                      # Test endpoints
├── model/                          # Domain models
│   ├── core/                      # Core entities
│   ├── flight/                    # Flight-related entities
│   └── user/                      # User-related entities
├── repository/                     # Data access layer
├── service/                        # Business logic layer
├── spring/                         # Spring configuration
├── tools/                          # Utility tools
└── utils/                          # Helper utilities
```

## Prerequisites

- Java 21 or higher
- Gradle 7.0 or higher
- A relational database (configured in application.yaml)

## Building the Project

```bash
./gradlew build
```

## Running the Project

```bash
./gradlew bootRun
```

The application will start on the default port specified in `application.yaml`.

## Configuration

Application configuration can be found in:
- `src/main/resources/application.yaml` - Main application configuration
- `src/main/resources/db/changelog/` - Database migration scripts

## Database Migrations

Database migrations are managed using Liquibase. Migration files are located in:
```
src/main/resources/db/changelog/
```

Migrations are applied automatically on application startup.

## Testing

Run the test suite with:

```bash
./gradlew test
```

Test reports are available in `build/reports/tests/test/index.html`

## License

(Add your license information here)
