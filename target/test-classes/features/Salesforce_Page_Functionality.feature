Feature: Salesforce_Page_Functionality.


  @Login_Scenario_Invalid
  Scenario Outline: Login Scenario Invalid
   Given User refer the "<filename>"
    When User enters text in text field "Username" from given sheet "<SheetName>"
    When User enters text in text field "Password" from given sheet "<SheetName>"
    And User click on the "Login_Button"
    And Verify the "Actual message" with "Expected message" from given sheet "<SheetName>"
    
   Examples: 
      | SheetName | filename|
      | TestData  | Salesforce_Page_Functionality.xlsx|
      
      
  @Login_Scenario_valid
  Scenario Outline: Login Scenario valid
   Given User refer the "<filename>"
    When User enters text in text field "Username" from given sheet "<SheetName>"
    When User enters text in text field "Password" from given sheet "<SheetName>"
    And User click on the "Login_Button"
    
   Examples: 
      | SheetName | filename|
      | TestData  | Salesforce_Page_Functionality.xlsx|
           

  @Login_Scenario_Valid-Sales_User_No
  Scenario Outline: Login Scenario Valid-Sales User No
    Given User refer the "<filename>"
    When User enters text in text field "Username" from given sheet "<SheetName>"
    When User enters text in text field "Password" from given sheet "<SheetName>"
    And User click on the "Button"
    And User click on the "Profile_Icon"
    And Verify the "Profile_Name" with "Swapnil" from given sheet "<SheetName>"

   Examples: 
      | SheetName | filename|
      | TestData  | Salesforce_Page_Functionality.xlsx|  
   
    @Lead_Creation
    Scenario Outline: Lead Creation
   
    Given User refer the "<filename>"
    When User enters text in text field "Username" from given sheet "<SheetName>"
    When User enters text in text field "Password" from given sheet "<SheetName>"
    And User click on the "Login_Button"
    And User click on the "Applauncher"
    And User click on the "SearchBox"
    When User enters text in text field "SearchBox" from given sheet "<SheetName>"
    And User click on the "Search_text"
    And User click on the "Leads"
    And User click on the "NewLeadCreationButton"
    And User click on the "SalutationDropDown"
    And User click on the "Professor"
    When User enters text in text field "FirstName" from given sheet "<SheetName>"
    When User enters text in text field "LastName" from given sheet "<SheetName>"
    When User enters text in text field "Company" from given sheet "<SheetName>"
    When User enters text in text field "Phone" from given sheet "<SheetName>" 
    When User enters text in text field "Email" from given sheet "<SheetName>" 
    And User click on the "LeadStatus"
    And User click on the "Working-Contacted"
    And User click on the "Save"
    And Verify the "Actual Lead Created message" with "Expected Lead Created message" from given sheet "<SheetName>" 
     Examples: 
      | SheetName | filename|
      | TestData  | Salesforce_Page_Functionality.xlsx|
      
    @Lead_Deletion
    Scenario Outline: Lead Deletion
    
    Given User refer the "<filename>"
    When User enters text in text field "Username" from given sheet "<SheetName>"
    When User enters text in text field "Password" from given sheet "<SheetName>"
    And User click on the "Login_Button"
    And User click on the "Applauncher"
    And User click on the "SearchBox"
    When User enters text in text field "SearchBox" from given sheet "<SheetName>"
    And User click on the "Search_text"
    And User click on the "Leads"
    When User click on the "DownArrow"
     And User click on the "DeleteOption"
     And User click on the "DeleteButton"
     Then Verify the "Actual Lead Delete message" with "Expected Lead Delete message" from given sheet "<SheetName>" 
     
     Examples: 
      | SheetName | filename|
      | TestData  | Salesforce_Page_Functionality.xlsx|
      
     
      
    
      
      
  
      
     
