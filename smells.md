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
- [older_prefix](src/test/java/naming/older_prefix): Лишние префиксы в названии тестов
- [no_action_or_assertion](src/test/java/naming/no_action_or_assertion): В имени теста нет действия или проверяемых условий
### speed
- [unnecessary_robolectric](src/test/java/speed/unnecessary_robolectric): Используется Robolectric там, где нет Android специфики
- [unnecessary_android_instrumentation](src/test/java/speed/unnecessary_android_instrumentation): Используется `androidTest` там, можно запустить тест на хосте
