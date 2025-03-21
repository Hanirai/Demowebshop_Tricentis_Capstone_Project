Feature: Register using mail id

Background: Given Home page of website

@registerwithvalidemail
Scenario Outline: Register on the website with new mail id
When click on register
And Choose gender
And Enter "<First name>" in first name field
And Enter "<Second name>" in second name field
And Enter "<Email>" in email field
And Enter "<Password>" in password field
And Enter "<Confirm password>" in confirm password field
And click on register button
Then Registered successfuly

Examples:
|First name   |Second name  |Email                 |Password    |Confirm password |
|Hani         |Rai          |haniiigrai@gmail.com   |pass@123    |pass@123         |

@registerwithinvalidemail
Scenario Outline: Register on the website with invalid email
When Click on logout
And click on register
And Choose gender
And Enter "<First name>" in first name field
And Enter "<Second name>" in second name field
And Enter "<Email>" in email field
And Enter "<Password>" in password field
And Enter "<Confirm password>" in confirm password field
And click on register button
Then Invalid email

Examples: 
|First name   |Second name  |Email              |Password    |Confirm password |
|Hani         |Rai          |abhi@gmail.com     |pass@123    |pass@123         |

@loginwithvalidcredentials
Scenario Outline: Login with valid credentials
When Click on login
And Enter "<Email>" in email field
And Enter "<Password>" in password field
And Click on login button
Then Logged in successfully

Examples:
|Email              |Password   |
|hanigra@gmail.com  |pass@123   |

@loginwithinvalidcredentials
Scenario Outline: Login with valid credentials
When Click on logout
When Click on login
And Enter "<Email>" in email field
And Enter "<Password>" in password field
And Click on login button
Then invalid login credentials

Examples:
|Email             |Password|
|mon@gmail.com     |user12   |

@Forgotpasswordwithvalidemail
Scenario Outline: Forgot password with valid email
When Click on login
And Click on Forgot password
And Enter "<Email>" in email field
And Click on recover button
Then Email sent message displayed

Examples:
|Email            |
|hanigr@gmail.com   |

@Forgotpasswordwithinvalidemail
Scenario Outline: Forgot password with valid email
When Click on login
And Click on Forgot password
And Enter "<Email>" in email field
And Click on recover button
Then Email does not exist  message displayed

Examples:
|Email           |
|abhipurush@gmail.com   |
    
