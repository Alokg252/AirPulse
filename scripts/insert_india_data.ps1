# Indian Cities Data - PowerShell Script
$BaseUrl = "http://localhost:8070"
$AuthHeader = @{"AuthPulse" = "Pulse eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbG9rIiwiaWF0IjoxNzc0NDE0MDA2LCJleHAiOjE3NzQ0Nzg4MDZ9.40J8fyCm4A6ZhP7GC2AqPLsvHQ_o7XC5Hn1SOHQxXCI"}

# Flights
$flight1 = @{
    flightNumber = "AI101"
    fromCity = "Delhi"
    toCity = "Mumbai"
    departureTime = "2026-02-15T08:00:00+05:30"
    arrivalTime = "2026-02-15T10:30:00+05:30"
    price = 5500.00
    availableSeats = 120
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight1
Write-Host "✓ AI101" -ForegroundColor Green

$flight2 = @{
    flightNumber = "SG201"
    fromCity = "Delhi"
    toCity = "Mumbai"
    departureTime = "2026-02-20T14:00:00+05:30"
    arrivalTime = "2026-02-20T16:30:00+05:30"
    price = 6000.00
    availableSeats = 100
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight2
Write-Host "✓ SG201" -ForegroundColor Green

$flight3 = @{
    flightNumber = "BA301"
    fromCity = "Delhi"
    toCity = "Mumbai"
    departureTime = "2026-03-10T18:00:00+05:30"
    arrivalTime = "2026-03-10T20:30:00+05:30"
    price = 5800.00
    availableSeats = 90
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight3
Write-Host "✓ BA301" -ForegroundColor Green

$flight4 = @{
    flightNumber = "AI102"
    fromCity = "Delhi"
    toCity = "Bangalore"
    departureTime = "2026-02-18T09:00:00+05:30"
    arrivalTime = "2026-02-18T11:45:00+05:30"
    price = 7500.00
    availableSeats = 110
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight4
Write-Host "✓ AI102" -ForegroundColor Green

$flight5 = @{
    flightNumber = "SG202"
    fromCity = "Delhi"
    toCity = "Bangalore"
    departureTime = "2026-03-15T15:30:00+05:30"
    arrivalTime = "2026-03-15T18:15:00+05:30"
    price = 7800.00
    availableSeats = 105
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight5
Write-Host "✓ SG202" -ForegroundColor Green

$flight6 = @{
    flightNumber = "AI103"
    fromCity = "Mumbai"
    toCity = "Bangalore"
    departureTime = "2026-02-22T07:00:00+05:30"
    arrivalTime = "2026-02-22T09:30:00+05:30"
    price = 4200.00
    availableSeats = 130
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight6
Write-Host "✓ AI103" -ForegroundColor Green

$flight7 = @{
    flightNumber = "SG203"
    fromCity = "Mumbai"
    toCity = "Bangalore"
    departureTime = "2026-03-20T13:00:00+05:30"
    arrivalTime = "2026-03-20T15:30:00+05:30"
    price = 4500.00
    availableSeats = 125
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight7
Write-Host "✓ SG203" -ForegroundColor Green

$flight8 = @{
    flightNumber = "AI104"
    fromCity = "Mumbai"
    toCity = "Chennai"
    departureTime = "2026-02-25T10:00:00+05:30"
    arrivalTime = "2026-02-25T12:45:00+05:30"
    price = 3800.00
    availableSeats = 140
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight8
Write-Host "✓ AI104" -ForegroundColor Green

$flight9 = @{
    flightNumber = "BA302"
    fromCity = "Mumbai"
    toCity = "Chennai"
    departureTime = "2026-03-25T16:00:00+05:30"
    arrivalTime = "2026-03-25T18:45:00+05:30"
    price = 4100.00
    availableSeats = 135
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight9
Write-Host "✓ BA302" -ForegroundColor Green

$flight10 = @{
    flightNumber = "AI105"
    fromCity = "Bangalore"
    toCity = "Kolkata"
    departureTime = "2026-03-01T11:00:00+05:30"
    arrivalTime = "2026-03-01T14:30:00+05:30"
    price = 6800.00
    availableSeats = 95
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight10
Write-Host "✓ AI105" -ForegroundColor Green

$flight11 = @{
    flightNumber = "SG204"
    fromCity = "Bangalore"
    toCity = "Kolkata"
    departureTime = "2026-03-22T17:30:00+05:30"
    arrivalTime = "2026-03-22T21:00:00+05:30"
    price = 7200.00
    availableSeats = 100
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight11
Write-Host "✓ SG204" -ForegroundColor Green

$flight12 = @{
    flightNumber = "AI106"
    fromCity = "Delhi"
    toCity = "Hyderabad"
    departureTime = "2026-03-05T08:30:00+05:30"
    arrivalTime = "2026-03-05T10:45:00+05:30"
    price = 6500.00
    availableSeats = 115
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight12
Write-Host "✓ AI106" -ForegroundColor Green

$flight13 = @{
    flightNumber = "BA303"
    fromCity = "Delhi"
    toCity = "Hyderabad"
    departureTime = "2026-03-28T14:30:00+05:30"
    arrivalTime = "2026-03-28T16:45:00+05:30"
    price = 6800.00
    availableSeats = 110
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight13
Write-Host "✓ BA303" -ForegroundColor Green

$flight14 = @{
    flightNumber = "AI107"
    fromCity = "Chennai"
    toCity = "Pune"
    departureTime = "2026-03-08T09:15:00+05:30"
    arrivalTime = "2026-03-08T11:30:00+05:30"
    price = 3200.00
    availableSeats = 145
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight14
Write-Host "✓ AI107" -ForegroundColor Green

$flight15 = @{
    flightNumber = "SG205"
    fromCity = "Chennai"
    toCity = "Pune"
    departureTime = "2026-03-30T15:45:00+05:30"
    arrivalTime = "2026-03-30T18:00:00+05:30"
    price = 3500.00
    availableSeats = 140
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/flights" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $flight15
Write-Host "✓ SG205" -ForegroundColor Green

Write-Host ""
Write-Host "Creating bookings..." -ForegroundColor Yellow

# Bookings
$b1 = @{ flightId = 1; userId = 1 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b1
Write-Host "✓ Booking 1" -ForegroundColor Green

$b2 = @{ flightId = 2; userId = 1 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b2
Write-Host "✓ Booking 2" -ForegroundColor Green

$b3 = @{ flightId = 3; userId = 2 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b3
Write-Host "✓ Booking 3" -ForegroundColor Green

$b4 = @{ flightId = 4; userId = 2 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b4
Write-Host "✓ Booking 4" -ForegroundColor Green

$b5 = @{ flightId = 5; userId = 3 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b5
Write-Host "✓ Booking 5" -ForegroundColor Green

$b6 = @{ flightId = 6; userId = 3 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b6
Write-Host "✓ Booking 6" -ForegroundColor Green

$b7 = @{ flightId = 7; userId = 4 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b7
Write-Host "✓ Booking 7" -ForegroundColor Green

$b8 = @{ flightId = 8; userId = 4 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b8
Write-Host "✓ Booking 8" -ForegroundColor Green

$b9 = @{ flightId = 9; userId = 5 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b9
Write-Host "✓ Booking 9" -ForegroundColor Green

$b10 = @{ flightId = 10; userId = 5 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b10
Write-Host "✓ Booking 10" -ForegroundColor Green

$b11 = @{ flightId = 11; userId = 1 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b11
Write-Host "✓ Booking 11" -ForegroundColor Green

$b12 = @{ flightId = 12; userId = 2 } | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/api/bookings" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $b12
Write-Host "✓ Booking 12" -ForegroundColor Green

Write-Host ""
Write-Host "✓ 15 Flights" -ForegroundColor Cyan
Write-Host "✓ 12 Bookings" -ForegroundColor Cyan

