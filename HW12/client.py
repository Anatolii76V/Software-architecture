import requests

base_url = "http://127.0.0.1:8000"


def get_data():
    response = requests.get(f"{base_url}/get_data")
    return response.json() if response.status_code == 200 else f"Не удалось получить данные: {response.status_code}"


def add_data():
    new_data = {"key": "value"}
    response = requests.post(f"{base_url}/add_data", json=new_data)
    return response.json() if response.status_code == 200 else f"Не удалось добавить данные: {response.status_code}"


def update_data(data_id, updated_data):
    response = requests.put(f"{base_url}/update_data/{data_id}", json=updated_data)
    return response.json() if response.status_code == 200 else f"Не удалось обновить данные: {response.status_code}"


def delete_data(data_id):
    response = requests.delete(f"{base_url}/delete_data/{data_id}")
    return response.json() if response.status_code == 200 else f"Не удалось удалить данные: {response.status_code}"


if __name__ == "__main__":
    data = get_data()
    print("Полученные данные:", data)

    added_data = add_data()
    print("Добавленные данные:", added_data)

    data_id_to_update = 1
    updated_data = {"key": "updated_value"}
    updated = update_data(data_id_to_update, updated_data)
    print("Обновлено:", updated)

    data_id_to_delete = 1
    deleted = delete_data(data_id_to_delete)
    print("Удалено:", deleted)
