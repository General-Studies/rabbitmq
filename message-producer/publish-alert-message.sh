#!/bin/bash

curl --location --request POST 'localhost:8081/api/producer/send-alert' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Alerta de tempestade na sua cidade"
}'