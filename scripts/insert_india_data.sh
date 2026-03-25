#!/bin/bash
BASE_URL="http://localhost:8080"
AUTH_HEADER="AuthPulse: Pulse eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbG9rIiwiaWF0IjoxNzc0NDE0MDA2LCJleHAiOjE3NzQ0Nzg4MDZ9.40J8fyCm4A6ZhP7GC2AqPLsvHQ_o7XC5Hn1SOHQxXCI"

# Flights
curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"AI101","fromCity":"Delhi","toCity":"Mumbai","departureTime":"2026-02-15T08:00:00+05:30","arrivalTime":"2026-02-15T10:30:00+05:30","price":5500.00,"availableSeats":120}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"SG201","fromCity":"Delhi","toCity":"Mumbai","departureTime":"2026-02-20T14:00:00+05:30","arrivalTime":"2026-02-20T16:30:00+05:30","price":6000.00,"availableSeats":100}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"BA301","fromCity":"Delhi","toCity":"Mumbai","departureTime":"2026-03-10T18:00:00+05:30","arrivalTime":"2026-03-10T20:30:00+05:30","price":5800.00,"availableSeats":90}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"AI102","fromCity":"Delhi","toCity":"Bangalore","departureTime":"2026-02-18T09:00:00+05:30","arrivalTime":"2026-02-18T11:45:00+05:30","price":7500.00,"availableSeats":110}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"SG202","fromCity":"Delhi","toCity":"Bangalore","departureTime":"2026-03-15T15:30:00+05:30","arrivalTime":"2026-03-15T18:15:00+05:30","price":7800.00,"availableSeats":105}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"AI103","fromCity":"Mumbai","toCity":"Bangalore","departureTime":"2026-02-22T07:00:00+05:30","arrivalTime":"2026-02-22T09:30:00+05:30","price":4200.00,"availableSeats":130}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"SG203","fromCity":"Mumbai","toCity":"Bangalore","departureTime":"2026-03-20T13:00:00+05:30","arrivalTime":"2026-03-20T15:30:00+05:30","price":4500.00,"availableSeats":125}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"AI104","fromCity":"Mumbai","toCity":"Chennai","departureTime":"2026-02-25T10:00:00+05:30","arrivalTime":"2026-02-25T12:45:00+05:30","price":3800.00,"availableSeats":140}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"BA302","fromCity":"Mumbai","toCity":"Chennai","departureTime":"2026-03-25T16:00:00+05:30","arrivalTime":"2026-03-25T18:45:00+05:30","price":4100.00,"availableSeats":135}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"AI105","fromCity":"Bangalore","toCity":"Kolkata","departureTime":"2026-03-01T11:00:00+05:30","arrivalTime":"2026-03-01T14:30:00+05:30","price":6800.00,"availableSeats":95}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"SG204","fromCity":"Bangalore","toCity":"Kolkata","departureTime":"2026-03-22T17:30:00+05:30","arrivalTime":"2026-03-22T21:00:00+05:30","price":7200.00,"availableSeats":100}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"AI106","fromCity":"Delhi","toCity":"Hyderabad","departureTime":"2026-03-05T08:30:00+05:30","arrivalTime":"2026-03-05T10:45:00+05:30","price":6500.00,"availableSeats":115}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"BA303","fromCity":"Delhi","toCity":"Hyderabad","departureTime":"2026-03-28T14:30:00+05:30","arrivalTime":"2026-03-28T16:45:00+05:30","price":6800.00,"availableSeats":110}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"AI107","fromCity":"Chennai","toCity":"Pune","departureTime":"2026-03-08T09:15:00+05:30","arrivalTime":"2026-03-08T11:30:00+05:30","price":3200.00,"availableSeats":145}' && echo ""

curl -X POST "$BASE_URL/api/flights" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightNumber":"SG205","fromCity":"Chennai","toCity":"Pune","departureTime":"2026-03-30T15:45:00+05:30","arrivalTime":"2026-03-30T18:00:00+05:30","price":3500.00,"availableSeats":140}' && echo ""

echo "Bookings..."

curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":1,"userId":1}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":2,"userId":1}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":3,"userId":2}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":4,"userId":2}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":5,"userId":3}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":6,"userId":3}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":7,"userId":4}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":8,"userId":4}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":9,"userId":5}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":10,"userId":5}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":11,"userId":1}' && echo ""
curl -X POST "$BASE_URL/api/bookings" -H "Content-Type: application/json" -H "$AUTH_HEADER" -d '{"flightId":12,"userId":2}' && echo ""

echo "Done"

