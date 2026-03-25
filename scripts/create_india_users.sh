#!/bin/bash
BASE_URL="http://localhost:8070"
AUTH_HEADER="AuthPulse: Pulse eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbG9rIiwiaWF0IjoxNzc0NDE0MDA2LCJleHAiOjE3NzQ0Nzg4MDZ9.40J8fyCm4A6ZhP7GC2AqPLsvHQ_o7XC5Hn1SOHQxXCI"

curl -X POST "$BASE_URL/user/create" \
  -H "Content-Type: application/json" \
  -H "$AUTH_HEADER" \
  -d '{"username":"raj_kumar","email":"raj.kumar@email.com","name":"Raj Kumar","gender":"MALE","dob":"1990-05-15","password":"password123"}' && echo ""

curl -X POST "$BASE_URL/user/create" \
  -H "Content-Type: application/json" \
  -H "$AUTH_HEADER" \
  -d '{"username":"priya_singh","email":"priya.singh@email.com","name":"Priya Singh","gender":"FEMALE","dob":"1992-08-22","password":"password123"}' && echo ""

curl -X POST "$BASE_URL/user/create" \
  -H "Content-Type: application/json" \
  -H "$AUTH_HEADER" \
  -d '{"username":"amit_patel","email":"amit.patel@email.com","name":"Amit Patel","gender":"MALE","dob":"1988-03-10","password":"password123"}' && echo ""

curl -X POST "$BASE_URL/user/create" \
  -H "Content-Type: application/json" \
  -H "$AUTH_HEADER" \
  -d '{"username":"neha_reddy","email":"neha.reddy@email.com","name":"Neha Reddy","gender":"FEMALE","dob":"1995-11-28","password":"password123"}' && echo ""

curl -X POST "$BASE_URL/user/create" \
  -H "Content-Type: application/json" \
  -H "$AUTH_HEADER" \
  -d '{"username":"arjun_das","email":"arjun.das@email.com","name":"Arjun Das","gender":"MALE","dob":"1991-07-05","password":"password123"}' && echo ""

echo "5 Users Created"

