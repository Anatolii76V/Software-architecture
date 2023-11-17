from fastapi import FastAPI, HTTPException, Depends
from pydantic import BaseModel
from typing import List
import databases
import sqlalchemy

# Инициализация FastAPI приложения
app = FastAPI()

# Подключение к базе данных SQLite
DATABASE_URL = "sqlite:///./clinic.db"
database = databases.Database(DATABASE_URL)
metadata = sqlalchemy.MetaData()

# Определение таблиц в базе данных: Clients, Consultations
clients = sqlalchemy.Table(
    "Clients",
    metadata,
    sqlalchemy.Column("ClientId", sqlalchemy.Integer, primary_key=True),
    sqlalchemy.Column("Document", sqlalchemy.String(50)),
    sqlalchemy.Column("SurName", sqlalchemy.String(50)),
    sqlalchemy.Column("FirstName", sqlalchemy.String(50)),
    sqlalchemy.Column("Patronymic", sqlalchemy.String(50)),
    sqlalchemy.Column("Birthday", sqlalchemy.String(50)),
)

consultations = sqlalchemy.Table(
    "Consultations",
    metadata,
    sqlalchemy.Column("ConsultationId", sqlalchemy.Integer, primary_key=True),
    sqlalchemy.Column("ClientId", sqlalchemy.Integer),
    sqlalchemy.Column("PetId", sqlalchemy.Integer),
    sqlalchemy.Column("ConsultationDate", sqlalchemy.String(50)),
    sqlalchemy.Column("Description", sqlalchemy.String(200)),
)

# Создание базы данных
engine = sqlalchemy.create_engine(
    DATABASE_URL, connect_args={"check_same_thread": False}
)
metadata.create_all(engine)


# Модели данных Pydantic для клиентов и консультаций
class Client(BaseModel):
    Document: str
    SurName: str
    FirstName: str
    Patronymic: str
    Birthday: str


class Consultation(BaseModel):
    ClientId: int
    PetId: int
    ConsultationDate: str
    Description: str


# Репозиторий для работы с клиентами
class ClientRepository:
    async def create_client(self, client: Client):
        query = clients.insert().values(**client.dict())
        return await database.execute(query)

    async def get_all_clients(self) -> List[Client]:
        query = clients.select()
        return await database.fetch_all(query)

    async def update_client(self, client_id: int, client: Client):
        query = clients.update().where(clients.c.ClientId == client_id).values(**client.dict())
        return await database.execute(query)

    async def delete_client(self, client_id: int):
        query = clients.delete().where(clients.c.ClientId == client_id)
        return await database.execute(query)


@app.put("/clients/edit/{client_id}", response_model=Client)
async def update_client(client_id: int, client: Client):
    return await client_repository.update_client(client_id, client)


@app.delete("/clients/delete/{client_id}", response_model=int)
async def delete_client(client_id: int):
    return await client_repository.delete_client(client_id)


# Репозиторий для работы с консультациями
class ConsultationRepository:
    async def create_consultation(self, consultation: Consultation):
        query = consultations.insert().values(**consultation.dict())
        return await database.execute(query)

    async def get_consultations_by_client_id(self, client_id: int) -> List[Consultation]:
        query = consultations.select().where(consultations.c.ClientId == client_id)
        return await database.fetch_all(query)


# Создание экземпляров репозиториев
client_repository = ClientRepository()
consultation_repository = ConsultationRepository()


# Роуты FastAPI для работы с клиентами
@app.post("/clients/create", response_model=Client)
async def create_client(client: Client):
    return await client_repository.create_client(client)


@app.get("/clients/all", response_model=List[Client])
async def get_all_clients():
    return await client_repository.get_all_clients()


# Роуты FastAPI для работы с консультациями
@app.post("/consultations/create", response_model=Consultation)
async def create_consultation(consultation: Consultation):
    return await consultation_repository.create_consultation(consultation)


@app.get("/consultations/{client_id}", response_model=List[Consultation])
async def get_consultations_by_client_id(client_id: int):
    return await consultation_repository.get_consultations_by_client_id(client_id)


# Функция запуска/остановки подключения к базе данных
@app.on_event("startup")
async def startup():
    await database.connect()


@app.on_event("shutdown")
async def shutdown():
    await database.disconnect()


# consultation_repository.py

class ConsultationRepository:
    def create(self, consultation_data):
        # Логика создания записи о консультации в базе данных
        pass

    def update(self, consultation_id, updated_consultation_data):
        # Логика обновления записи о консультации в базе данных
        pass

    def delete(self, consultation_id):
        # Логика удаления записи о консультации из базы данных
        pass

    def get_all(self):
        # Получение всех записей о консультациях из базы данных
        pass

    def get_by_id(self, consultation_id):
        # Получение записи о консультации по идентификатору из базы данных
        pass


from fastapi import APIRouter

router = APIRouter()


@router.post("/consultations/create")
def create_consultation(consultation_data: dict):
    # Обработка запроса на создание записи о консультации с использованием репозитория
    pass


@router.put("/consultations/edit/{consultation_id}")
def update_consultation(consultation_id: int, updated_consultation_data: dict):
    # Обработка запроса на обновление записи о консультации с использованием репозитория
    pass


@router.delete("/consultations/delete/{consultation_id}")
def delete_consultation(consultation_id: int):
    # Обработка запроса на удаление записи о консультации с использованием репозитория
    pass


@router.get("/consultations/get-all")
def get_all_consultations():
    # Обработка запроса на получение всех записей о консультациях с использованием репозитория
    pass


@router.get("/consultations/get/{consultation_id}")
def get_consultation_by_id(consultation_id: int):
    # Обработка запроса на получение записи о консультации по идентификатору с использованием репозитория
    pass
