# fixture-backend

## GET - /teams   -> Todos los equipos
#### Respuesta:
```javascript
[
    {
        "id": 1,
        "nombre": "Lanus",
        "imagen": "iamgen.jpg"
    },
    {
        "id": 2,
        "nombre": "Independiente",
        "imagen": "iamgen.jpg"
    }...
]
```

## GET - /table   -> Tabla de puntajes y estadisticas
#### Respuesta:
```javascript
[
    {
        "id": 1,
        "equipo": {
            "id": 1,
            "nombre": "Lanus",
            "imagen": "aa"
        },
        "partidosJugados": 1,
        "partidosGanados": 1,
        "partidosEmpatados": 0,
        "partidosPerdidos": 0,
        "diferenciaDeGoles": 2,
        "puntos": 3
    },
    {
        "id": 2,
        "equipo": {
            "id": 2,
            "nombre": "Independiente",
            "imagen": "aa"
        },
        "partidosJugados": 1,
        "partidosGanados": 0,
        "partidosEmpatados": 0,
        "partidosPerdidos": 1,
        "diferenciaDeGoles": -2,
        "puntos": 0
    }...
]
```

## GET - /matches -> Todos los partidos
#### Respuesta:
```javascript
[
    {
        "id": 1,
        "local": {
            "id": 1,
            "nombre": "Lanus",
            "imagen": "aa"
        },
        "visitante": {
            "id": 2,
            "nombre": "Independiente",
            "imagen": "aa"
        },
        "golesLocal": 3,
        "golesVisitante": 1
    },
    {
        "id": 2,
        "local": {
            "id": 3,
            "nombre": "Racing",
            "imagen": "aa"
        },
        "visitante": {
            "id": 4,
            "nombre": "Boca",
            "imagen": "aa"
        },
        "golesLocal": -1,
        "golesVisitante": -1
    }
]
```
## POST - /team   -> Crear un equipo
#### Body:
```javascript
{
  "nombre":"Independiente",
  "imagen":"https://images.com/indep.png"
}
```
#### Respuesta: 
```javascript
{
    "id": 1,
    "nombre": "Independiente",
    "imagen":"https://images.com/indep.png"
}
```
## POST - /new_match   -> Crear un partido
#### Body:
```javascript
{
  "idLocal":1,
  "idVisitante":2
}
```
#### Respuesta: 
```javascript
{
    "id": 1,
    "local": {
        "id": 1,
        "nombre": "Lanus",
        "imagen": "aa"
    },
    "visitante": {
        "id": 2,
        "nombre": "Independiente",
        "imagen": "aa"
    },
    "golesLocal": -1,
    "golesVisitante": -1
}
```

## POST - /tournament  -> Crear un torneo
#### Body:
```javascript
{
  "nombre":"Liga A"
}
```
#### Respuesta: 
```javascript
{
    "id": 1,
    "nombre": "Liga A",
    "fechas": [],
    "fechaHabilitida": 0
}
```
## POST - /result  -> Cargar resultados a un partido
#### Body:
```javascript
{
  "idPartido":1,
  "golesLocal":3,
  "golesVisitante":1
}
```
#### Respuesta: 
```javascript
{
    "id": 1,
    "local": {
        "id": 1,
        "nombre": "Lanus",
        "imagen": "aa"
    },
    "visitante": {
        "id": 2,
        "nombre": "Independiente",
        "imagen": "aa"
    },
    "golesLocal": 3,
    "golesVisitante": 1
}
```

