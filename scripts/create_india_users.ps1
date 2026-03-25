$BaseUrl = "http://localhost:8070"
$AuthHeader = @{"AuthPulse" = "Pulse eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbG9rIiwiaWF0IjoxNzc0NDE0MDA2LCJleHAiOjE3NzQ0Nzg4MDZ9.40J8fyCm4A6ZhP7GC2AqPLsvHQ_o7XC5Hn1SOHQxXCI"}

$user1 = @{
    username = "raj_kumar"
    email = "raj.kumar@email.com"
    name = "Raj Kumar"
    gender = "MALE"
    dob = "1990-05-15"
    password = "password123"
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/user/create" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $user1
Write-Host "✓ raj_kumar" -ForegroundColor Green

$user2 = @{
    username = "priya_singh"
    email = "priya.singh@email.com"
    name = "Priya Singh"
    gender = "FEMALE"
    dob = "1992-08-22"
    password = "password123"
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/user/create" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $user2
Write-Host "✓ priya_singh" -ForegroundColor Green

$user3 = @{
    username = "amit_patel"
    email = "amit.patel@email.com"
    name = "Amit Patel"
    gender = "MALE"
    dob = "1988-03-10"
    password = "password123"
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/user/create" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $user3
Write-Host "✓ amit_patel" -ForegroundColor Green

$user4 = @{
    username = "neha_reddy"
    email = "neha.reddy@email.com"
    name = "Neha Reddy"
    gender = "FEMALE"
    dob = "1995-11-28"
    password = "password123"
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/user/create" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $user4
Write-Host "✓ neha_reddy" -ForegroundColor Green

$user5 = @{
    username = "arjun_das"
    email = "arjun.das@email.com"
    name = "Arjun Das"
    gender = "MALE"
    dob = "1991-07-05"
    password = "password123"
} | ConvertTo-Json
Invoke-RestMethod -Uri "$BaseUrl/user/create" -Method POST -ContentType "application/json" -Headers $AuthHeader -Body $user5
Write-Host "✓ arjun_das" -ForegroundColor Green

Write-Host ""
Write-Host "✓ 5 Users Created" -ForegroundColor Cyan

