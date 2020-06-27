Feature: Launch General store hybrid Mobile App and perform some operation 

@SmokeTest @Functional @login 
Scenario: Login to the General store App 
	Given launch general Store hybrid App 
	Then  select the country where you want to shop 
	Then  enter your name 
	Then select your gender 
	Then click on Let's shop button 
	
	
	
@Functional @ProductPage 
Scenario:
Navigate to the product page and scroll for some product then click on Add to cart link 
	Given launch general Store hybrid App 
	Then  select the country where you want to shop 
	Then  enter your name 
	Then select your gender 
	Then click on Let's shop button 
	And search for PG3 product 
	And search for product "Jordan 6 Rings" 
	Then fetch the product price from product 
	Then click on Add to cart link 
	
@NegativeTest @SmokeTest
Scenario: Perform some negative testing for Generalstore application 
	Given launch general Store hybrid App 
	Then  select the country where you want to shop 
	Then click on Let's shop button 
	Then verify Toast message from UI 
	
@listProducts 
Scenario: Find out list of product from product page 
	Given launch general Store hybrid App 
	Then  select the country where you want to shop 
	Then  enter your name 
	Then select your gender 
	Then click on Let's shop button 
	Then search list of product and find out "Air Jordan 9 Retro" 
	
	
@Addcart 
Scenario:
select two product from product page and verify that product is selected in cart page 
	Given launch general Store hybrid App 
	Then Open notification from mobile 
	Then find all notification 
	And clear the all notifications from mobile phone 
	Then  select the country where you want to shop 
	Then  enter your name 
	Then select your gender 
	Then click on Let's shop button 
	And search for PG3 product 
	And search for product "Converse All Star" 
	And click on Add cart link 
	And verify two product are available in cart page 
	Then sum of two product amount is same as Total Purchase Amount
	And click on "Please read our terms of conditions" link
	Then click on checkbox from Total purchase amount page
	Then click on Visit to the website to complete purchase button
	And It will navigate to WEB-VIEW APP
	Then Perform some operation inside the WEB-VIEW APP
	Then Again Navigate to NativeApp
	
	
@notifications
Scenario: Notification from Mobile 
Given Open notification from mobile
Then find all notification
And clear the all notifications from mobile phone
	
	
	
	
	
	