Feature: BPM_SastaSafar_Web


  @Find_flight_process_
  Scenario Outline: Find flight process 


      Given User refer the "<filename>"  
      When Verify the "Home page" with "Home_Page_Title" from given sheet "<SheetName>" 
      When User click on the "From text field" 
      When User enters text in text field "From" from given sheet "<SheetName>" 
      When User click on the "Chennai (MAA)"
      When User click on the "To text field" 
      When User enters text in text field "To_1" from given sheet "<SheetName>" 
      When User click on the "Goa (GOI)"
      When User click on the "Depature Date" 
      When User click on the "Date"
      When User click on the "TRAVELLERS & CABIN Drop down" 
      When User click on the "Class Drop down" 
      When User click on the "Economy" 
      When User click on the "Done button"
      Then User click on the "Search button"


      Examples:
        | SheetName | filename |
        | TestData | BPM_SastaSafar_Web.xlsx |


  @Ways_of_booking_tickets_for_trip_Flight
  Scenario Outline: Ways of booking tickets for trip Flight


      Given User refer the "<filename>"  
      When Verify the "Home page" with "Home_Page_Title" from given sheet "<SheetName>" 
      When User click on the "FLIGHT tab"
      When Verify the "flight home page" with "flight home page title" from given sheet "<SheetName>" 
      When User click on the "Round trip radio button"
      When User click on the "From text field" 
      When User enters text in text field "From" from given sheet "<SheetName>" 
      When User click on the "Chennai (MAA)"
      When User click on the "To text field" 
      When User enters text in text field "To_2" from given sheet "<SheetName>" 
      When User click on the "Goa (GOI)"
      When User click on the "Depature Date" 
      When User click on the "Date"
      When User click on the "Add Return Date" 
      When User click on the "Date1"
      When User click on the "TRAVELLERS & CABIN Drop down" 
      When User click on the "Class Drop down" 
      When User click on the "Economy" 
      When User click on the "Done button"
      Then User click on the "Search button"


      Examples:
        | SheetName | filename |
        | TestData | BPM_SastaSafar_Web.xlsx |


  @Ways_of_booking_tickets_for_trip_Bus
  Scenario Outline: Ways of booking tickets for trip Bus


      Given User refer the "<filename>"  
      When Verify the "Home page" with "Home_Page_Title" from given sheet "<SheetName>" 
      When User click on the "BUS tab"
      When Verify the "Bus home page" with "Bus home page title" from given sheet "<SheetName>" 
      When User click on the "Bus Search From text field" 
      When User enters text in text field "Bus Search From" from given sheet "<SheetName>" 
      When User click on the "Chennai"
      When User click on the "Bus Search To text field" 
      When User enters text in text field "Bus Search To" from given sheet "<SheetName>" 
      When User click on the "Hyderabad"
      When User click on the "Bus Depature Date" 
      When User click on the "Date"
      Then User click on the "Bus Search button"


      Examples:
        | SheetName | filename |
        | TestData | BPM_SastaSafar_Web.xlsx |


  @Ways_of_booking_tickets_for_trip_Packages_
  Scenario Outline: Ways of booking tickets for trip Packages 


      Given User refer the "<filename>"  
      When Verify the "Home page" with "Home_Page_Title" from given sheet "<SheetName>" 
      When User click on the "PACKAGES tab"
      Then Verify the "packages home page" with "packages home page title" from given sheet "<SheetName>" 


      Examples:
        | SheetName | filename |
        | TestData | BPM_SastaSafar_Web.xlsx |
        
       
   @Ways_of_booking_tickets_for_trip_Packages_
  	Scenario Outline: Ways of booking tickets for trip Packages 


      Given User refer the "<filename>"  
      When Verify the "Home page" with "Home_Page_Title" from given sheet "<SheetName>" 
      When User click on the "PACKAGES tab"
      Then Verify the "packages home page" with "packages home page title" from given sheet "<SheetName>" 


      Examples:
        | SheetName | filename |
        | TestData | BPM_SastaSafar_Web.xlsx |


