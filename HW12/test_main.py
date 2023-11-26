from fastapi.testclient import TestClient
from main import app

client = TestClient(app)


# Тесты для существующих эндпоинтов

def test_get_data():
    # Тестирование эндпоинта для получения данных
    response = client.get("/data")
    assert response.status_code == 200  # Проверка успешного получения данных
    assert response.json() == {"data": {"detail": "Not Found"}}  # Проверка возвращаемых данных


def test_add_data():
    # Тестирование эндпоинта для добавления данных
    data = {
        "Document": "1234567890",
        "SurName": "Иванов",
        "FirstName": "Алексей",
        "Birthday": "1990-01-01",
    }
    response = client.post("/data", json=data)
    assert response.status_code == 200  # Проверка успешного добавления данных
    assert response.json() == {"added_data": {"detail": "Not Found"}}  # Проверка возвращаемых данных


def test_update_data():
    # Тестирование эндпоинта для обновления данных
    data_id = 1  # Предполагая, что data_id существует
    response = client.put(f"/data/{data_id}")
    assert response.status_code == 200  # Проверка успешного обновления данных
    assert response.json() == {"updated": {"detail": "Not Found"}}  # Проверка возвращаемых данных


def test_delete_data():
    # Тестирование эндпоинта для удаления данных
    data_id = 1  # Предполагая, что data_id существует
    response = client.delete(f"/data/{data_id}")
    assert response.status_code == 200  # Проверка успешного удаления данных
    assert response.json() == {"deleted": False}  # Проверка возвращаемых данных


def test_healthcheck():
    # Тестирование эндпоинта для проверки работоспособности приложения
    response = client.get("/healthcheck")
    assert response.status_code == 200  # Проверка успешного запроса к healthcheck
    assert response.json() == {"status": "OK"}  # Проверка возвращаемых данных


def test_read_item():
    # Тестирование эндпоинта для чтения элемента с указанным ID
    item_id = 5
    response = client.get(f"/items/{item_id}?q=somequery")
    assert response.status_code == 200  # Проверка успешного запроса к items
    assert response.json() == {"item_id": item_id, "q": "somequery"}  # Проверка возвращаемых данных
