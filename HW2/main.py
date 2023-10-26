# Класс, представляющий биржу, отслеживающую цены на акции
class StockMarket:
    def __init__(self):
        self._observers = []  # Список наблюдателей
        self._stock_price = None  # Цена на акцию

    # Метод для добавления наблюдателя
    def attach_investor(self, investor):
        if investor not in self._observers:
            self._observers.append(investor)

    # Метод для удаления наблюдателя
    def detach_investor(self, investor):
        if investor in self._observers:
            self._observers.remove(investor)

    # Метод для оповещения наблюдателей об изменениях цены на акцию
    def notify_investors(self):
        for investor in self._observers:
            investor.update()

    # Метод для установки цены на акцию и оповещения наблюдателей
    def set_stock_price(self, price):
        self._stock_price = price
        self.notify_investors()

    # Метод для получения текущей цены на акцию
    def get_stock_price(self):
        return self._stock_price


# Класс, представляющий инвестора, который отслеживает изменения цен на акции
class Investor:
    def __init__(self, name, stock_market):
        self._name = name  # Имя инвестора
        self._stock_market = stock_market  # Биржа, которую инвестор отслеживает
        self._stock_market.attach_investor(self)  # Регистрация инвестора на бирже

    # Метод для обновления инвестора о текущей цене на акцию
    def update(self):
        stock_price = self._stock_market.get_stock_price()
        print(f"Инвестор {self._name} получил обновленную информацию. Текущая цена акции составляет {stock_price}.")


# Пример использования шаблона "Наблюдатель"
if __name__ == "__main__":
    # Создание объекта биржи
    stock_market = StockMarket()

    # Создание объектов инвесторов и их регистрация на бирже
    investor1 = Investor("Василий", stock_market)
    investor2 = Investor("Сергей", stock_market)

    # Изменение цены на акцию и оповещение наблюдателей
    stock_market.set_stock_price(100)
    stock_market.set_stock_price(120)

    # Отмена регистрации одного из инвесторов на бирже
    stock_market.detach_investor(investor2)

    # Изменение цены на акцию и оповещение оставшихся наблюдателей
    stock_market.set_stock_price(150)
