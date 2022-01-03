<<<<<<< HEAD
# SeleniumCourse
=======
# final_project

Test 1

Add user with API https://bookstore.toolsqa.com/Account/v1/User
Go to https://demoqa.com/login
Login with added account
Click on 'Delete Account'
Validate popup message 'User Deleted'
Try to login with deleted account credentials
Validate error text 'Invalid username or password!'
Call https://bookstore.toolsqa.com/Account/v1/Authorized with deleted credentials
Validate response message "User not found!"

Test 2
Go to https://demoqa.com/books
Write 'O'Reilly Media' in search textbox
Call https://bookstore.toolsqa.com/BookStore/v1/Books
Validate that count of books with publisher 'O'Reilly Media' is equals to returned list size in UI
Validate that book with title 'Understanding ECMAScript 6' is the last element in UI and in API
>>>>>>> ba5d8b9d64fc0924d1a67f4ddfaea3e966ec9f42
