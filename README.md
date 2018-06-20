# Test Smells

Легко написать плохой тест, сложно написать хороший.

В этом репозитории лежат работающие примеры тестов, содержащих разнообразные проблемы. Мы выделили основные проблемы, назвали их `Test Smells` и написали рекомендации, как их избежать.

Код использует обычные для Android разработки JUnit4 тесты с Mockito.


## Структура
Смеллы разложены по пакетам в `test/java/`

Идентификатор смела это имя пакета. 

Например, в пакете `code_wall` лежит смелл "Стена текста".

В пакетах лежат файлы с тестами, содержащие примеры хороших `@Good` и плохих `@Bad` тестов.

## structure
- [many_tests_in_one](src/test/java/structure/many_tests_in_one): Много тестов в одном тестовом методе
## general
- [multiple_asserts](src/test/java/general/multiple_asserts): Методы содержат несколько ассертов
- [code_wall](src/test/java/general/multiple_asserts/code_wall): Стена текста
## naming
- [older_prefix](src/test/java/naming/older_prefix): Лишние префиксы в названии тестов
- [no_details](src/test/java/naming/no_details): Имя не рассказывает, что должен проверять тест
## speed
- [unnecessary_robolectric](src/test/java/speed/unnecessary_robolectric): Используется Robolectric там, где нет Android специфики
