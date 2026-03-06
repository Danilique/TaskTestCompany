# Todo App - Appium Test Automation

Automated test suite for the **Todo** Android app built with Appium, Java, and Cucumber BDD.

## Tech Stack
- Java 17
- Appium 2.x + UIAutomator2
- Cucumber 7 (BDD)
- JUnit 4
- Allure Reports
- GitHub Actions (CI)

## Project Structure
```
src/test/
├── java/com/todo/
│   ├── pages/          # Page Object Model
│   ├── steps/          # Cucumber step definitions
│   ├── runners/        # Test runner
│   └── utils/          # Driver config, waits
└── resources/
    ├── features/       # Gherkin feature files
    ├── config.properties
    └── allure.properties
```

## Test Coverage
### Task Creation
- Create task with title only
- Create task with title and description
- Validation: empty title shows error
- Cancel task creation

### Task Management
- View task details
- Edit existing task
- Mark task as complete
- Delete a task
- Cancel deletion

## Prerequisites
- Java 17+
- Android SDK + Emulator
- Node.js 18+
- Appium 2.x

## Setup
Install Appium:
```bash
npm install -g appium@2.0.0
appium driver install uiautomator2
```

Place the Todo APK at:
```
src/test/resources/app/todo.apk
```

Update `src/test/resources/config.properties` with your device details.

## Running Tests

Run all tests:
```bash
./gradlew test
```

Run only smoke tests:
```bash
./gradlew test -Dcucumber.tags="@smoke"
```

## Reports
After running, open the Allure report:
```bash
allure serve build/allure-results
```

## CI/CD
Push to `main` or `develop` to trigger the GitHub Actions pipeline automatically.