{
	"info": {
		"_postman_id": "d66aec3a-d45c-4b8a-a73b-2e887fb6d911",
		"name": "Personas",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Alta Persona Multipart",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					},
					{
						"key": "",
						"value": "",
						"type": "text",
						"disabled": true
					}
				],
				"body": {
					"mode": "formdata",
					"formdata": [
						{
							"key": "fotoPersona",
							"type": "file",
							"src": ""
						},
						{
							"key": "persona",
							"type": "file",
							"src": ""
						}
					]
				},
				"url": {
					"raw": "http://localhost:8080/persona",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"persona"
					]
				}
			},
			"response": []
		},
		{
			"name": "Buscar por edad",
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/personas?edad=35",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"personas"
					],
					"query": [
						{
							"key": "edad",
							"value": "35"
						}
					]
				},
				"description": "Buscar persona por nombre"
			},
			"response": []
		},
		{
			"name": "Buscar por DNI",
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/personas?dni=94607510",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"personas"
					],
					"query": [
						{
							"key": "dni",
							"value": "94607510"
						}
					]
				},
				"description": "Buscar persona por nombre"
			},
			"response": []
		},
		{
			"name": "Buscar por nombre y edad",
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/personas?nombre=oskarina",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"personas"
					],
					"query": [
						{
							"key": "nombre",
							"value": "oskarina"
						}
					]
				},
				"description": "Buscar persona por nombre"
			},
			"response": []
		},
		{
			"name": "Listar todos",
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/personas",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"personas"
					]
				},
				"description": "Buscar persona por nombre"
			},
			"response": []
		},
		{
			"name": "Obtener foto x DNI",
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/foto/94607510.jpg",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"foto",
						"94607510.jpg"
					]
				}
			},
			"response": []
		}
	]
}