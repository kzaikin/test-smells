Этот проект содержит `Test Smells` - примеры плохого дизайна и реализации юнит тестов. Все примеры взяты из реальных пулл-реквестов. Рядом с плохим примером всегда лежит способ избавиться от проблемы, сделав тест лучше.

Цель проекта - помогать во внедрении юнит-тестирования в новые и существующие проекты.

В репозитории можно найти не только примеры плохого дизайна тестов, но и простые и эффективные примеры рекомендуемых практик.

Код использует `JUnit4` тесты с `Mockito` и `Hamcrest`, но принципы смеллов не зависят от инструментов, и применимы к любым фреймворкам для тестирования и языкам.

## Структура
Смеллы разложены по пакетам в `test/java/`

Идентификатор смела это имя пакета. 

Например, в пакете `code_wall` лежит смелл "Стена текста".

В пакетах лежат файлы с тестами, содержащие примеры хороших `@Good` и плохих `@Bad` тестов.

## Test Smells
### structure
- [multiple_asserts](src/test/java/structure/multiple_asserts): Методы содержат несколько ассертов
- [many_tests_in_one](src/test/java/structure/many_tests_in_one): Много тестов в одном тестовом методе
- [repeating_setup](src/test/java/structure/repeating_setup): Повторяется настройка тестовых методов
### general
- [code_wall](src/test/java/general/code_wall): Стена текста
### naming
- [older_prefix](src/test/java/naming/older_prefix): Лишние префиксы в названии тестов
- [no_action_or_assertion](src/test/java/naming/no_action_or_assertion): В имени теста нет действия или проверяемых условий
### speed
- [unnecessary_robolectric](src/test/java/speed/unnecessary_robolectric): Используется Robolectric там, где нет Android специфики

## LICENSE
This work is under [Apache license](LICENSE)
