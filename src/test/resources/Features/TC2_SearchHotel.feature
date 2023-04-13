@SearchHotel
Feature: Verifying AdactinHotel SearchHotel module page

  Scenario Outline: Verifying Adactin Hotel Search Hotel module page by entering all the fields and navigate to selecthotel page
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Satheeshkumarjeya!"
    When User enter all the fields "<location>","<hotels>","<roomType>","<numberofRooms>","<checkinDate>","<checkoutDate>","<adultPerroom>" and "<childperRoom>"
    Then User should navigate to Select Hotel and verify the success message "Select Hotel" 

    Examples: 
      | userName          | passWord  | location | hotels      | roomType | numberofRooms | checkinDate | checkoutDate | adultPerroom | childperRoom |
      | Satheeshkumarjeya | 123456789 | Sydney   | Hotel Creek | Standard | 2 - Two       | 07/02/2023  | 08/02/2023   | 2 - Two      | 2 - Two      |

  Scenario Outline: Verifying AdactinHotel SearchHotel module page by entering only the mandatory  fields and navigate to selecthotel page
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Satheeshkumarjeya!"
    When User enter only the mandatory fields "<location>","<numberofRooms>","<checkinDate>","<checkoutDate>" and "<adultPerroom>"
    Then User should navigate to Select Hotel and verify the success message "Select Hotel"

    Examples: 
      | userName          | passWord  | location | numberofRooms | checkinDate | checkoutDate | adultPerroom |
      | Satheeshkumarjeya | 123456789 | Sydney   | 2 - Two       | 07/02/2023  | 08/02/2023   | 2 - Two      |

  Scenario Outline: Verifying AdactinHotel SearchHotel module page Date checking
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Satheeshkumarjeya!"
    When User enter all the fields "<location>","<hotels>","<roomType>","<numberofRooms>","<checkinDate>","<checkoutDate>","<adultPerroom>" and "<childperRoom>"
    Then User should verify after search with the error message "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName          | passWord  | location | hotels      | roomType | numberofRooms | checkinDate | checkoutDate | adultPerroom | childperRoom |
      | Satheeshkumarjeya | 123456789 | Sydney   | Hotel Creek | Standard | 2 - Two       | 08/02/2023  | 07/02/2023   | 2 - Two      | 2 - Two      |

  Scenario Outline: Verifying AdactinHotel SearchHotel module page by performing search option  withoutentering all the fields
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Satheeshkumarjeya!"
    When User click the search option
    Then User should verify after search hotel with the errormessage "Please Select a Location"

    Examples: 
      | userName          | passWord  |
      | Satheeshkumarjeya | 123456789 |
