# Дипломный проект по тестированию интернет-магазина [Tasty Coffee](https://shop.tastycoffee.ru/)

## Содержание:

* <a href="#annotation">Описание</a>
* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Тест кейсы</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#jenkins">Запуск тестов в Jenkins</a>
* <a href="#allure">Отчеты в Allure</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#testops">Интеграция с Jira</a>
* <a href="#telegram">Уведомления в Telegram с использованием бота</a>
* <a href="#video">Пример прогона теста в Selenoid</a>

<a id="annotation"></a>
## Описание
Тестовый проект состоит из веб-тестов UI.\
Краткий список интересных фактов о проекте:
- [x] `Page Object` проектирование
- [x] Возможность локального и удалённого запуска тестов
- [x] Возможность запуска как всех тестов, так и отдельно по каждому определенному тегу
- [x] Использование `Faker` для генерации данных
- [x] Интеграция с `Allure TestOps`
- [x] Возможность запуска тестов напрямую из `Allure TestOps`
- [x] Интеграция с `Jira`
- [x] Автотесты оформлены как тестовая документация посредством аннотаций `Allure`

<a id="tools"></a>
## Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/logo/IntelliJ_IDEA.png" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/logo/GitHub.png" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/logo/Java_logo.png" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/logo/Gradle.png" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/logo/JUnit5.png" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/logo/Selenide.png" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="images/logo/Selenoid.png" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/logo/Jenkins.png" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/logo/AllureReports.png" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="images/logo/AllureTestOps.svg" width="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img alt="Jira" height="50" src="images/logo/Jira.png" width="50"/></a>  
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/logo/Telegram.png" width="50"/></a>
</div>

<code>Java</code> - основной язык проекта.\
<code>Selenide</code> - используемый фреймворк. \
<code>Gradle</code> — используется как инструмент автоматизации сборки.\
<code>JUnit5</code> — фреймворк модульного тестирования для выполнения тестов.\
<code>Selenoid</code> — для удаленного запуска браузера в Docker контейнерах.\
<code>Jenkins</code> — CI/CD для запуска тестов удаленно.\
<code>Allure Report</code> — для визуализации результатов тестирования.\
<code>Allure TestOps</code> — как система управления тестированием.\
<code>Telegram Bot</code> — для уведомлений о результатах тестирования.\
<code>Jira</code> — как инструмент управления проектом и таск-трекер.

**Allure Report**, **AllureTestOps** и **Telegram Bot** используются для визуализации результатов тестирования.\

Allure-отчет включает в себя:
* шаги выполнения тестов;
* скриншот страницы в браузере в момент окончания автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения автотеста.

<a id="cases"></a>
## Тест кейсы

Проект содержит следующие автоматизированные кейсы:
- События вызванные нажатием кнопки "Купить" на странице товара
- Добавление товара в корзину
- Очищение корзины
- Выбор варианта помола кофе
- Аутентификация пользователя с корректными данными
- Отказ пользователю в аутентификации
- Редактирование личных данных пользователя
- Редактирование аватара пользователя 

А также следующие ручные кейсы:
- Добавление товара в избранное

<a id="console"></a>
##  Запуск тестов из терминала
### Локальный запуск тестов

```bash
gradle clean test
```

### Удаленный запуск тестов

```bash
clean ${TASK}
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserVersion=${BROWSER_VERSION}
-DremoteSelenoidUrl=${REMOTE_SELENOID_URL}
-DbaseUrl=${BASE_URL}
```

### Для запуска удаленных тестов необходимо передать значение:

> `${TASK}` - таска для запуска тестов по определенному тегу.
>
> `${BROWSER}` - наименование браузера (_по умолчанию - <code>chrome</code>_).
>
> `${BROWSER_SIZE}` - размер окна браузера (_по умолчанию - <code>1980x1080</code>_).
>
> `${BROWSER_VERSION}` - номер версии браузера (_по умолчанию - <code>100.0</code>_).
>
> `${REMOTE_SELENOID_URL}` - адрес удаленного сервера Selenoid.
>
> `${BASE_URL}` - URL-адрес сайта онлайн-магазина.

<a id="jenkins"></a>
## Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/final_project_tastycoffee_web/)
Сборка с параметрами позволяет перед запуском изменить параметры для сборки (путем выбора из списка или прямым указанием значения).
<p align="center">
  <img src="images/readme_files/screenshots/JenkinsParameterizedJob.png" alt="Jenkins" width="800">
</p>

После выполнения сборки в блоке <code>История сборок</code> напротив номера сборки появится
значки *Allure Report* и *Allure TestOps*, клик по которым позволит ознакомиться с более детальными отчетами о пройденных тестах.

<a id="allure"></a>
## Отчет в [Allure Report](https://jenkins.autotests.cloud/job/final_project_tastycoffee_web/44/allure/)
### Основной дашборд
<p align="center">
  <img src="images/readme_files/screenshots/AllureReportOverview.png" alt="allure-report-overview" width="900">
</p>

### Тесты
<p align="center">
  <img src="images/readme_files/screenshots/AllureReportSuites.png" alt="allure-report-suites" width="900">
</p>

### Графики
<p align="center">
  <img src="images/readme_files/screenshots/AllureReportGraphs.png" alt="allure-report-graphs" width="900">
</p>

<a id="testops"></a>
##  Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/28349)

### Основной дашборд

<p align="center">
  <img src="images/readme_files/screenshots/AllureTestOpsDashboards.png" alt="allure-testops-dashboard" width="900">
</p>

### Автоматизированные тест-кейсы

<p align="center">
  <img src="images/readme_files/screenshots/AllureTestOpsTestCases.png" alt="allure-testops-testcase" width="900">
</p>

### Пример мануального тест-кейса

<p align="center">
  <img src="images/readme_files/screenshots/AllureTestOpsTestCaseManual.png" alt="allure-testops-testcase-manual" width="900">
</p>

### Запуски сборок 

<p align="center">
  <img src="images/readme_files/screenshots/AllureTestOpsLaunches.png" alt="allure-testops-launches" width="900">
</p>

<a id="jira"></a>
## Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-842"> Jira </a>
<p align="center">
<img src="images/readme_files/screenshots/Jira.png">
</p>

<a id="telegram"></a>
## Уведомления в Telegram с использованием бота

<p align="center">
<img title="Telegram Notifications" src="images/readme_files/screenshots/Telegram.png" alt="telegram" width="900>
</p>

<a id="video"></a>
## Пример прогона теста в Selenoid

<p align="center">
  <img src="images/readme_files/video/video.mp4">
</p>
