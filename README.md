# kotlin-maven-ui-api-tests

Тестовый проект на Kotlin с Maven в стиле production, который включает в себя:

- API-тесты (RestAssured)
- UI-тесты (Selenium + WebDriverManager)
- Паттерн Page Object
- Настройку тестов через test.properties
- Интеграцию с Allure и JUnit5
- Пример разделения BaseTest и API-клиента

Как запускать:
- Собрать и запустить тесты:
mvn test

Примечания:
- Настройте src/test/resources/test.properties для BASE_URL и UI_URL.
- Allure и TestContainers включены, но требуют настройки в CI по необходимости.

