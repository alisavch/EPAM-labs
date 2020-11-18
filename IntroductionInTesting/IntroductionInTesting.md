​		

| Test Case ID           | TC_Functionality_01                                  |                   |                   |
| :--------------------- | ---------------------------------------------------- | ----------------- | ----------------- |
| **Priority**           | Средний                                              |                   |                   |
| **Description**        | Поиск кроссовок Nike Epic React Flyknit 2 по фильтру |                   |                   |
| **Module**             |                                                      |                   |                   |
| **Prepared By**        | Alina Savchuk                                        | **Date Prepared** | 21-September-2020 |
| **Reviewed / Updated** | Kirill Sergeevich Kalyga                             | **Date Reviewed** | 22-September-2020 |

| **Sl. No.** | Step Description                                         | **Expected Results**                       |
| ----------- | -------------------------------------------------------- | ------------------------------------------ |
| 1           | Перейти на https://nike.com/                             | Сайт должен открыться                      |
| 2           | Нажать "женщины-обувь-бег"                               | Каталог к беговыми кроссовками             |
| 3           | Выбрать из предложенного Nike React Infinity Run Flyknit | Страница с Nike React Infinity Run Flyknit |
|             |                                                          |                                            |

  											

------



| Test Case ID           | TC_Functionality_02                                          |                   |                   |
| :--------------------- | ------------------------------------------------------------ | ----------------- | ----------------- |
| **Priority**           | Средний                                                      |                   |                   |
| **Description**        | Добавление кроссовок в корзину не авторизированному пользователю |                   |                   |
| **Module**             |                                                              |                   |                   |
| **Prepared By**        | Alina Savchuk                                                | **Date Prepared** | 21-September-2020 |
| **Reviewed / Updated** | Kirill Sergeevich Kalyga                                     | **Date Reviewed** | 22-September-2020 |
|                        |                                                              |                   |                   |

| **Sl. No.** | Step Description                                             | **Expected Results**                                         |
| ----------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1           | Открыть товар по ссылке https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500 | Страница с кроссовками   
  2           | Выбрать размер 9
| 3           | Добавить в корзину Nike Epic React Flyknit 2                 | Уведомление, что в корзину добавлен товар Nike Epic React Flyknit 2 с ценой 5 180 |
| 4           | Перейти в корзину                                            | В корзине Nike Epic React Flyknit 2 с ценой 5 180            |

  															

------



| Test Case ID           | TC_Functionality_03                      |                   |                   |
| :--------------------- | ---------------------------------------- | ----------------- | ----------------- |
| **Priority**           | Средний                                  |                   |                   |
| **Description**        | Оформить заказ кроссовок без регистрации |                   |                   |
| **Module**             |                                          |                   |                   |
| **Prepared By**        | Alina Savchuk                            | **Date Prepared** | 21-September-2020 |
| **Reviewed / Updated** | Kirill Sergeevich Kalyga                 | **Date Reviewed** | 22-September-2020 |
| **Actual Results**     |                                          | **Date Tested**   | 21-September-2020 |

| **Sl. No.** | Step Description                                             | **Expected Results**                  |
| ----------- | ------------------------------------------------------------ | ------------------------------------- |
| 1           | Перейти к оформлению заказа с Nike Epic React Flyknit 2 (цена 5 180) | Страница с заполнением данных         |
| 2           | Заполнить обязательные поля Фамилия, Имя Отчество, Почтовый индекс, Регион, Улица и номер дома, Телефон для доставки, Адрес эл. почты | Проверки на валидность                |
| 3           | Товар остался прежним с теми же ценой и описанием , проверяем свои введенные данные и появляется пункт с оплатой | Товар не изменился и переход к оплате |
| 4           | Ввод карты                                                   | Оплата                                |
|             |                                                              |                                       |
|             |                                                              |                                       |

  															

------



| Test Case ID           | TC_Functionality_04                                    |                   |                   |
| :--------------------- | ------------------------------------------------------ | ----------------- | ----------------- |
| **Priority**           | Средний                                                |                   |                   |
| **Description**        | Не оформить заказ до конца и оставить вкладку открытой |                   |                   |
| **Module**             |                                                        |                   |                   |
| **Prepared By**        | Alina Savchuk                                          | **Date Prepared** | 21-September-2020 |
| **Reviewed / Updated** | Kirill Sergeevich Kalyga                               | **Date Reviewed** | 22-September-2020 |
| **Actual Results**     |                                                        | **Date Tested**   | 21-September-2020 |

| **Sl. No.** | Step Description                                             | **Expected Results**        |
| ----------- | ------------------------------------------------------------ | --------------------------- |
| 1           | Добавить товар в корзину и перейти к оформлению заказа       | Офомрление заказа           |
| 2           | Заполнить несколько полей формы и оставить страницу включенной от 5мин | Ошибка  и возврат к корзине |

  												

------



| Test Case ID           | TC_Functionality_05 -поменять       |                   |                   |
| :--------------------- | ----------------------------------- | ----------------- | ----------------- |
| **Priority**           | Средний                             |                   |                   |
| **Description**        | Узнать информацию о способах оплаты |                   |                   |
| **Module**             |                                     |                   |                   |
| **Prepared By**        | Alina Savchuk                       | **Date Prepared** | 21-September-2020 |
| **Reviewed / Updated** | Kirill Sergeevich Kalyga            | **Date Reviewed** | 22-September-2020 |
| **Actual Results**     |                                     | **Date Tested**   | 21-September-2020 |

| **Sl. No.** | Step Description               | **Expected Results**               |
| ----------- | ------------------------------ | ---------------------------------- |
| 1           | Кнопка "помощь" в футере сайта |                                    |
| 2           | В поиске ввести оплата         |                                    |
| 3           | Выбрать пункт "способы оплаты" | Перечень карт и интернет-кошельков |

  																

------



| Test Case ID           | TC_Functionality_06                            |                   |                   |
| :--------------------- | ---------------------------------------------- | ----------------- | ----------------- |
| **Priority**           | Средний                                        |                   |                   |
| **Description**        | Проверка на сохранение пользовательских данных |                   |                   |
| **Module**             |                                                |                   |                   |
| **Prepared By**        | Alina Savchuk                                  | **Date Prepared** | 21-September-2020 |
| **Reviewed / Updated** | Kirill Sergeevich Kalyga                       | **Date Reviewed** | 22-September-2020 |
| **Actual Results**     |                                                | **Date Tested**   | 21-September-2020 |

| **Sl. No.** | Step Description                                             | **Expected Results**                                         |
| ----------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1           | Не авторизовываться на сайте                                 |                                                              |
| 2           | Перейти по ссылке https://www.nike.com/ru/t/%D0%BF%D0%BB%D0%B0%D1%82%D1%8C%D0%B5-sportswear-swoosh-8FwhWC/CU5674-011 |                                                              |
| 3           | Добавить этот товар в корзину                                | В корзине товар  Nike Sportswear Swoosh                      |
| 4           | Перейти по ссылке https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-air-zoom-tempo-next-GmFCVV/CI9924-100 |                                                              |
| 5           | Добавить второй товар в корзину                              | В корзине товар Nike Air Zoom Tempo NEXT                     |
| 6           | Нажать "войти" и авторизоваться в аккаунт                    |                                                              |
| 7           | Перейти в корзину                                            | Убедиться, что ранее добавленные товары без авторизации есть в корзине |

  															

------



| Test Case ID           | TC_MobileVersion_07        |                   |                   |
| :--------------------- | -------------------------- | ----------------- | ----------------- |
| **Priority**           | Средний                    |                   |                   |
| **Description**        | Удаление товара из корзины |                   |                   |
| **Module**             |                            |                   |                   |
| **Prepared By**        | Alina Savchuk              | **Date Prepared** | 21-September-2020 |
| **Reviewed / Updated** | Kirill Sergeevich Kalyga   | **Date Reviewed** | 22-September-2020 |
| **Actual Results**     |                            | **Date Tested**   | 21-September-2020 |

| **Sl. No.** | Step Description                                             | **Expected Results**                              |
| ----------- | ------------------------------------------------------------ | ------------------------------------------------- |
| 1           | Добавить в корзину платье Nike Sportswear Swoosh и сумку Nike Heritage | 2 товара добавлено (общ сумма 6 698+750-доставка) |
| 2           | Удалить из корзины сумку                                     | 1 товар на сумму 4 799 +750-доставка              |

  														

------





| Test Case ID           | TC_Functionality_08                                          |                   |                   |
| :--------------------- | ------------------------------------------------------------ | ----------------- | ----------------- |
| **Priority**           | Средний                                                      |                   |                   |
| **Description**        | Проверить сайт с отключенными cookie и проверить их продолжительность действия |                   |                   |
| **Module**             |                                                              |                   |                   |
| **Prepared By**        | Alina Savchuk                                                | **Date Prepared** | 21-September-2020 |
| **Reviewed / Updated** | Kirill Sergeevich Kalyga                                     | **Date Reviewed** | 22-September-2020 |
|                        |                                                              |                   |                   |

| **Sl. No.** | Step Description                                             | **Expected Results**                                        |
| ----------- | ------------------------------------------------------------ | ----------------------------------------------------------- |
| 1           | Перейти на https://nike.com/                                 | Сайт должен открыться                                       |
| 2           | Перейти по ссылке https://www.nike.com/ru/t/%D0%BF%D0%BB%D0%B0%D1%82%D1%8C%D0%B5-sportswear-swoosh-8FwhWC/CU5674-011 |                                                             |
| 2           | Добавить в корзину товар                                     | Товар добавлен в корзину                                    |
| 3           | Отключить cookie                                             | Необходимо ввести страну геолокации и в корзине будет пусто |

  															

------



| Test Case ID           | TC_Functionality_09                             |                   |                   |
| :--------------------- | ----------------------------------------------- | ----------------- | ----------------- |
| **Priority**           | Высокий                                         |                   |                   |
| **Description**        | Оформление заказа на сумму более 1млн рос. руб. |                   |                   |
| **Module**             |                                                 |                   |                   |
| **Prepared By**        | Alina Savchuk                                   | **Date Prepared** | 21-September-2020 |
| **Reviewed / Updated** | Kirill Sergeevich Kalyga                        | **Date Reviewed** | 22-September-2020 |
|                        |                                                 |                   |                   |

| **Sl. No.** | Step Description                                            | **Expected Results**         | **Actual Results**                               |
| ----------- | ----------------------------------------------------------- | ---------------------------- | ------------------------------------------------ |
| 1           | Перейти на https://nike.com/                                | Сайт должен открыться        | Как и ожидалось                                  |
| 2           | Положить в корзину товаров более 15 шт (и каждого по 10 шт) | Корзина на сумму более 1 млн | Ошибка, что нельзя оформить заказ на такую сумму |

  												

------



| Test Case ID           | TC_Functionality_10                   |                   |                   |
| :--------------------- | ------------------------------------- | ----------------- | ----------------- |
| **Priority**           | Высокий                               |                   |                   |
| **Description**        | Проверка поддержки карт других банков |                   |                   |
| **Module**             |                                       |                   |                   |
| **Prepared By**        | Alina Savchuk                         | **Date Prepared** | 21-September-2020 |
| **Reviewed / Updated** | Kirill Sergeevich Kalyga              | **Date Reviewed** | 22-September-2020 |
| **Actual Results**     |                                       | **Date Tested**   | 21-September-2020 |

| **Sl. No.** | Step Description                                             | **Expected Results**                    |
| ----------- | ------------------------------------------------------------ | --------------------------------------- |
| 1           | Перейти по ссылке https://www.nike.com/ru/t/%D0%BF%D0%BB%D0%B0%D1%82%D1%8C%D0%B5-sportswear-swoosh-8FwhWC/CU5674-011 |                                         |
| 2           | Добавить этот товар в корзину                                | В корзине товар  Nike Sportswear Swoosh |
| 3           | Перейти к оформлению заказа                                  |                                         |
| 4           | Ввести карту Dancort 5019 5555 4444 5555                     | Не поддерживается тип данной карты      |

  															

------

