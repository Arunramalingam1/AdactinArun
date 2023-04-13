@CancelBooking
Feature: Verifying AdactinHotel BookingConfirmation module page by cancelling the order id

  Scenario Outline: Verifying AdactinHotel BookingConfirmation module page by cancelling the generated order id
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
   
    When User performs cancellation of generated orderid
    Then User Should verify after cancel sucess message "The booking has been cancelled."

    Examples: 
      | userName          | passWord  | location | hotels      | roomType | numberofRooms | checkinDate | checkoutDate | adultPerroom | childperRoom | firstName | lastName | billingAddress |
      | Satheeshkumarjeya | 123456789 | Sydney   | Hotel Creek | Standard | 2 - Two       | 07/02/2023  | 08/02/2023   | 2 - Two      | 2 - Two      | R         | Arun     | OMR            |

  Scenario Outline: Verifying AdactinHotel page by cancelling the existing order id
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Satheeshkumarjeya!"
    When User perform Booked Itinerary and search "<orderID>" to cancel the existing Order Id
    Then User Should verify after cancel sucess message "The booking has been cancelled."

    Examples: 
      | userName          | passWord  | orderID    |
      | Satheeshkumarjeya | 123456789 | 2H0239S373 |
