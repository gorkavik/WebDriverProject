#language:ru
#encoding:UTF-8

  @param
  Функционал: Параметризированный запуск тестов

    Структура сценария: Проверка цены книг <gadgetName>
      Допустим открыта страница "https://demowebshop.tricentis.com/books"
      Когда выполнено нажатие на ссылку "<bookName>"
      Тогда цена книги равна "<bookPrice>"

      Примеры:
      |bookName|bookPrice|
      |Computing and Internet|10.00|
      |Science|51.00|