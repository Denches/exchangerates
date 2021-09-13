## Техническое задание

Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:  
если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную [https://giphy.com/search/rich](https://giphy.com/search/rich)
если ниже - [https://giphy.com/search/broke](https://giphy.com/search/broke)  
**Ссылки**  
[REST API курсов валют](https://docs.openexchangerates.org/)   
[REST API гифок](https://developers.giphy.com/docs/api#quick-start-guide)   
**Must Have**  
Сервис на Spring Boot 2 + Java / Kotlin  
Запросы приходят на HTTP endpoint, туда передается код валюты  
Для взаимодействия с внешними сервисами используется Feign  
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки  
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)  
Для сборки должен использоваться Gradle  
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску  
**Nice to Have**  
Сборка и запуск Docker контейнера с этим сервисом»

## Запуск
Склонировать репозиторий, выполнив команду:  
`git clone https://github.com/Denches/exchangerates.git`  
Перейдя в корневую папку проекта собрать проект:  
`gradlew build`  
Собрать докер-образ с произвольным именем, в нашем случае rate:  
`docker image build -t rate .`  
Запустить контейнер с нашим образом:  
`docker run -p 8080:8080 docker.io/library/rate`
## Endpoints
`/api/gif`  
Возвращает гифку в зависимости от курса валют  
**Parameters**  
symbols: string (RUB)  
**Пример**  
http://localhost:8080/api/gif?symbols=RUB  
`/api/*`  
Возвращает гифку в зависимости от курса валюты (RUB)  
**Пример**  
`http://localhost:8080/`  
