Инструкция по установке:
1. Скачать файл с репозитория
2. Установить базу данных MySQL(название базы test, пароль root), удаленный сервер Tomcat 7,8
3. Для создания базы данных запустить src/main/database_test/create_db_and_table, для заполнения src/main/database_test/fill_table
4. В файле src/main/resources/META-INF/persistence.xml для свойства "hibernate.connection.url" нужно вместо локалхост указать реальный адрес сервера БД и порт, на котором она настроена
5. Для открытия приложения в браузере перейти по ссылке http://localhost:8080/crudtesttask
