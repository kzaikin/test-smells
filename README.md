Этот проект содержит `Test Smells` - примеры плохого дизайна и реализации юнит тестов. Все примеры взяты из реальных пулл-реквестов. Рядом с плохим примером всегда лежит способ избавиться от проблемы, сделав тест лучше.

Смеллы сформулированы так, чтобы на них можно было давать ссылку в пул-реквесте.

Цель проекта - помогать во внедрении юнит-тестирования в новые и существующие проекты.

Код использует `JUnit4` тесты с `Mockito` и `Hamcrest`, но принципы смеллов не зависят от инструментов, и применимы к любым фреймворкам для тестирования и языкам.

## Структура
Смеллы разложены по пакетам в `test/java/`

Идентификатор смела это имя пакета. 

Например, в пакете `code_wall` лежит смелл "Стена текста".

В пакетах лежат файлы с тестами, содержащие примеры хороших `@Good` и плохих `@Bad` тестов.

## Test Smells
### long_name
### structure
- [multiple_asserts](src/test/java/structure/multiple_asserts): Методы содержат несколько ассертов
- [many_tests_in_one](src/test/java/structure/many_tests_in_one): Много тестов в одном тестовом методе
- [repeating_setup](src/test/java/structure/repeating_setup): Повторяется настройка тестовых методов
### readability
- [code_wall](src/test/java/readability/code_wall): Стена текста
### improper_tools
- [inherit_for_verify](src/test/java/improper_tools/inherit_for_verify): Наследование для отслеживания переданных аргументов
### reliability
- [inherit_for_override](src/test/java/reliability/inherit_for_override): Наследование проверяемого класса для переопределения поведения
### naming
- [long_name](src/test/java/naming/long_name): Слишком длинное имя тестового метода
- [older_prefix](src/test/java/naming/older_prefix): Лишние префиксы в названии тестов
- [no_action_or_assertion](src/test/java/naming/no_action_or_assertion): В имени теста нет действия или проверяемых условий
### speed
- [unnecessary_robolectric](src/test/java/speed/unnecessary_robolectric): Используется Robolectric там, где нет Android специфики
- [unnecessary_android_instrumentation](src/test/java/speed/unnecessary_android_instrumentation): Используется `androidTest` там, можно запустить тест на хосте

## LICENSE
This work is under [Apache license](LICENSE)
