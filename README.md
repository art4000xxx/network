# Клиент-серверное приложение с диалогом

## Описание
Этот проект реализует клиент-серверное приложение на Java с использованием сокетов. Сервер принимает подключения, ведёт диалог с клиентом в 3 шага и отвечает в зависимости от полученных данных. Задача выполнена в рамках задания "Клиент-сервер с рюшечками".

### Функционал
1. Сервер запрашивает у клиента имя ("Write your name").
2. Сервер спрашивает, является ли клиент ребёнком ("Are you a child? (yes/no)").
3. В зависимости от ответа клиента ("yes" или "no"), сервер отправляет приветствие:
   - "Welcome to the kids area, [имя]! Let's play!" для "yes".
   - "Welcome to the adult zone, [имя]! Have a good rest, or a good working day!" для "no".

### Используемые технологии
- Java (Socket, ServerSocket)
- Порт: 8080
- Хост: 127.0.0.1 (вместо netology.homework из-за проблем с резолвингом)

## Установка и запуск
1. Убедитесь, что у вас установлен JDK (например, версия 17).
2. Откройте проект в IntelliJ IDEA (папка `C:\Users\art40\IdeaProjects\network`).
3. Убедитесь, что оба файла (`Server.java` и `Client.java`) находятся в папке `src`.

### Запуск сервера
1. Откройте `Server.java`.
2. Нажмите `Run 'Server.main()'` в IDEA.
3. В консоли появится: `Server started on port 8080`.

### Запуск клиента
1. Убедитесь, что сервер запущен.
2. Откройте `Client.java`.
3. Нажмите `Run 'Client.main()'` в IDEA.
4. Ожидаемый вывод клиента:
   Server: Write your name
Sent name: Alex
Server: Are you a child? (yes/no)
Sent response: yes
Server: Welcome to the kids area, Alex! Let's play!

## Заметки
- В задании требовалось использовать хост `netology.homework`, но резолвинг через файл `hosts` не сработал:
- Добавлена строка `127.0.0.1   netology.homework` в `C:\Windows\System32\drivers\etc\hosts`.
- `ping netology.homework` выдаёт ошибку "не удалось обнаружить узел".
- Пробовал: очистку DNS (`ipconfig /flushdns`), перезагрузку, пересоздание файла — без успеха.
- Поэтому в коде используется `127.0.0.1`. Функционал диалога полностью реализован.

## Автор
art4000xxx
