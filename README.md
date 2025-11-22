# kotlin-maven-ui-api-tests (refactor)

Production-style Kotlin Maven test project that includes:
- API tests (RestAssured)
- UI tests (Selenium + WebDriverManager)
- Page Object pattern
- Test configuration via `test.properties`
- Allure JUnit5 integration
- Example of BaseTest separation and API client

How to run:
- Build & run tests:
  mvn test

Notes:
- Configure `src/test/resources/test.properties` for BASE_URL and UI_URL.
- Allure and TestContainers are included but require setup in CI as desired.
