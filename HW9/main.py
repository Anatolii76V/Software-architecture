from typing import List
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from datetime import datetime

app = FastAPI()


# Определение модели данных для прогноза погоды
class WeatherForecast(BaseModel):
    date: datetime
    temperatureC: int


# управляющий класс хранением данных о прогнозе погоды
class WeatherForecastHolder:
    def __init__(self):
        self.values = []  # Список для хранения прогнозов погоды

    # Метод для добавления прогноза погоды
    def add(self, date: datetime, temperatureC: int):
        forecast = WeatherForecast(date=date, temperatureC=temperatureC)
        self.values.append(forecast)
        return True

    # Метод для обновления прогноза погоды
    def update(self, date: datetime, temperatureC: int):
        for forecast in self.values:
            if forecast.date == date:
                forecast.temperatureC = temperatureC
                return True
        return False

    # Метод для удаления прогноза погоды
    def delete(self, date: datetime):
        self.values = [forecast for forecast in self.values if forecast.date != date]
        return True

    # Метод для получения прогнозов погоды за определенный период
    def get(self, from_date: datetime, to_date: datetime) -> List[WeatherForecast]:
        return [forecast for forecast in self.values if from_date <= forecast.date <= to_date]


# Создание экземпляра класса WeatherForecastHolder
weather_forecast_holder = WeatherForecastHolder()


# Обработчик POST-запроса для добавления прогноза погоды
@app.post("/add-data")
def add_data(date: datetime, temperatureC: int):
    return {"result": weather_forecast_holder.add(date, temperatureC)}


# Обработчик PUT-запроса для обновления прогноза погоды
@app.put("/update-data")
def update_data(date: datetime, temperatureC: int):
    return {"result": weather_forecast_holder.update(date, temperatureC)}


# Обработчик DELETE-запроса для удаления прогноза погоды
@app.delete("/delete-data")
def delete_data(date: datetime):
    return {"result": weather_forecast_holder.delete(date)}


# Обработчик GET-запроса для получения прогнозов погоды за определенный период
@app.get("/get-data")
def get_data(from_date: datetime, to_date: datetime):
    return weather_forecast_holder.get(from_date, to_date)
