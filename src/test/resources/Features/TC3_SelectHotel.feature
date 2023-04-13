@SelectHotel
Feature: Verifying AdactinHotel SelectHotel module page

  Scenario Outline: Verifying Adactin Hotel Select Hotel page by selecting a hotel
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Satheeshkumarjeya!"
    When User enter all the fields "<location>","<hotels>","<roomType>","<numberofRooms>","<checkinDate>","<checkoutDate>","<adultPerroom>" and "<childperRoom>"
    Then User should navigate to Select Hotel and verify the success message "Select Hotel"
    When User Perform select and click continue
    Then User should navigate to Book A Hotel page and verify the success message "Book A Hotel"

    Examples: 
      | userName          | passWord  | location | hotels      | roomType | numberofRooms | checkinDate | checkoutDate | adultPerroom | childperRoom |
      | Satheeshkumarjeya | 123456789 | Sydney   | Hotel Creek | Standard | 2 - Two       | 07/02/2023  | 08/02/2023   | 2 - Two      | 2 - Two      |

  Scenario Outline: Verifying Adactin Hotel Select Hotel page without selecting a hotel
    Given User is on Adactinpage
    When User perform login "<userName>","<passWord>"
    Then User should verify after login success message "Hello Satheeshkumarjeya!"
    When User enter all the fields "<location>","<hotels>","<roomType>","<numberofRooms>","<checkinDate>","<checkoutDate>","<adultPerroom>" and "<childperRoom>"
    Then User should navigate to Select Hotel and verify the success message "Select Hotel"
    When User Perform continue
    Then User should verify after continue with the error message "Please Select a Hotel"

    Examples: 
      | userName          | passWord  | location | hotels      | roomType | numberofRooms | checkinDate | checkoutDate | adultPerroom | childperRoom |
      | Satheeshkumarjeya | 123456789 | Sydney   | Hotel Creek | Standard | 2 - Two       | 07/02/2023  | 08/02/2023   | 2 - Two      | 2 - Two      |
