## Сброс SharedPreferences после Robolectric теста
В Robolectric тестах не надо сбрасывать SharedPreferences. 

### Проблемы
Ненужный код по сбросу настроек.

### Теория
Robolectric в каждом новом тесте заново инициализиреует SharedPreferences, их изменение в одном тесте не влияет на другие.

### Что делать
Менять SharedPreferences в тестах как угодно, и не сбрасывать значения на значения по умолчанию.
Внимание, в AndroidInstrumentation тестах сбрасывать SharedPrefernces на значения по умолчанию, наоборот, нужно!