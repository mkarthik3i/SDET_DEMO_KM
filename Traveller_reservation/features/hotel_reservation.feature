Feature: Vaccation Reservation package booking

@test
Scenario: Verify the user can accept All cookies at Home Page
 Given Launch the application
  When Click "Accept All Cookies" button on Home Page
  Then Verify "Accept All cookies" button is disappeared

@test
Scenario: Verify user can search with desired country - places to visit booking
	Given Launch the application
	 When Search "India" in search box 
	 Then Select "India" in dynamic dropdown

@test
Scenario: Verify user can book the vacation package/destination
  Given Launch the application
   When Select the available date in the calendar
	  And Select 2 adults from the drop down
   Then verify the price calculation
   When click "Book Online" button on calender page
   Then verify the user lands to traveller accommodation page

@test
Scenario: Verify user lands to traveller details page
 Given Launch the application
  When Expand the Date, Departure & traveller page
  Then Verify displayed the Date and Departure details
   And Select 2 people in accommodation page
   And Click "Select your room and Continue" button
  Then Verify the user lands traveller details page 
   
@test
Scenario: Verify user can enter their details for Hotel room reservation
 Given Launch the application
  When Enter the mandatory fields in passenger details page
   And Click "Continue" button on passenger details page
  Then Verify the traveller Confirmation Details on the page 
   And Verify the "Book Now" button is enabled
  
	
	
	