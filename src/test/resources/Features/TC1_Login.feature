@Login
Feature: Verifying AdactinHotel login details

  Scenario Outline: Verifying AdactinHotel login with valid test data
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Satheeshkumarjeya!"

    Examples: 
      | userName          | passWord  |
      | Satheeshkumarjeya | 123456789 |

  Scenario Outline: Verifying AdactinHotel login with valid test data
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>" with enterkey
    Then User should verify after login success message "Hello Satheeshkumarjeya!"

    Examples: 
      | userName          | passWord  |
      | Satheeshkumarjeya | 123456789 |

  Scenario Outline: Verifying AdactinHotel login with Invalid test data
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify the login error message contains "Invalid Login details or Your Password might have expired. Click here to reset your password".

    Examples: 
      | userName          | passWord |
      | Satheeshkumarjeya |     1234 |
