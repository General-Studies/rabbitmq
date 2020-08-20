#!/bin/bash

curl --location --request POST 'localhost:8081/api/producer/send-user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "jether.rodrigues",
    "email": "jetherrodrigues@gmail.com"
}'