@BookHotel
Feature: Verifying AdactinHotel SelectHotel module page

  Scenario Outline: Verifying Adactin Hotel Book A Hotel module page by entering all the fields and navigate to Booking Confirmation page
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Satheeshkumarjeya!"
    When User enter all the fields "<location>","<hotels>","<roomType>","<numberofRooms>","<checkinDate>","<checkoutDate>","<adultPerroom>" and "<childperRoom>"
    Then User should navigate to Select Hotel and verify the success message "Select Hotel"
    When User Perform select and click continue
    Then User should navigate to Book A Hotel page and verify the success message "Book A Hotel"
    When User enter all the fields "<firstName>","<lastName>" and "<billingAddress>"
      | creditcardNo     | creditcardType   | selectMonth | selectYear | cvv |
      | 1234567890123456 | American Express | January     |       2022 | 123 |
      | 2345678901234567 | VISA             | February    |       2022 | 234 |
      | 3456789012345678 | Master Card      | March       |       2022 | 456 |
    Then User should verify after the booknow the page navigates to "Booking Confirmation" and save orderid
    Examples: 
      | userName          | passWord  | location | hotels      | roomType | numberofRooms | checkinDate | checkoutDate | adultPerroom | childperRoom | firstName | lastName | billingAddress |
      | Satheeshkumarjeya | 123456789 | Sydney   | Hotel Creek | Standard | 2 - Two       | 07/02/2023  | 08/02/2023   | 2 - Two      | 2 - Two      | R         | Arun     | OMR            |

  Scenario Outline: Verifying Adactin Hotel Book A Hotel module page without entering all the required fields
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Satheeshkumarjeya!"
    When User enter all the fields "<location>","<hotels>","<roomType>","<numberofRooms>","<checkinDate>","<checkoutDate>","<adultPerroom>" and "<childperRoom>"
    Then User should navigate to Select Hotel and verify the success message "Select Hotel"
    When User Perform select and click continue
    Then User should navigate to Book A Hotel page and verify the success message "Book A Hotel"
    When User perform Booknow option
    Then User should verify after he booknow errormessage "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName          | passWord  | location | hotels      | roomType | numberofRooms | checkinDate | checkoutDate | adultPerroom | childperRoom |
      | Satheeshkumarjeya | 123456789 | Sydney   | Hotel Creek | Standard | 2 - Two       | 07/02/2023  | 08/02/2023   | 2 - Two      | 2 - Two      |
