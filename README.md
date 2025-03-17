# Wildberries homeTest

| Dependencies      | Version |
|-------------------|---------|
| Java              | 17.0.6  |
| JUnit             | 5.11.0  |
| Allure            | 2.29.1  |
| JDK               | 17.0.6  |
| Maven             | 3.9.9   |
| Selenide          | 7.7.3   |
| Webdriver manager | 5.9.3   |

| Plugin         | Version | configuration |
|----------------|---------|---------------|
| Maven-surefire | 3.1.2   |               |

# Running default tests

`mvn clean test`

## Запуск для chrome browser

```bash
mvn clean test -Dbrowser=chrome
```

## Запуск для yandex browser

```bash
mvn clean test -Dbrowser=yandex

Для запуска в терминале Commande prompt:
mvn clean test -Dbrowser=yandex -Ddriver.version=version of nearest chromium -Dwebdriver.yandex.bin=path to browser
```

## Запуск для firefox browser

```bash
mvn clean test -Dbrowser=firefox
```