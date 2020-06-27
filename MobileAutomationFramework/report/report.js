$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Launch General store hybrid Mobile App and perform some operation",
  "description": "",
  "id": "launch-general-store-hybrid-mobile-app-and-perform-some-operation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 44,
  "name": "",
  "description": "select two product from product page and verify that product is selected in cart page",
  "id": "launch-general-store-hybrid-mobile-app-and-perform-some-operation;",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 43,
      "name": "@Addcart"
    }
  ]
});
formatter.step({
  "line": 46,
  "name": "launch general Store hybrid App",
  "keyword": "Given "
});
formatter.step({
  "line": 47,
  "name": "Open notification from mobile",
  "keyword": "Then "
});
formatter.step({
  "line": 48,
  "name": "find all notification",
  "keyword": "Then "
});
formatter.step({
  "line": 49,
  "name": "clear the all notifications from mobile phone",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "select the country where you want to shop",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "enter your name",
  "keyword": "Then "
});
formatter.step({
  "line": 52,
  "name": "select your gender",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "click on Let\u0027s shop button",
  "keyword": "Then "
});
formatter.step({
  "line": 54,
  "name": "search for PG3 product",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "search for product \"Converse All Star\"",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "click on Add cart link",
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "verify two product are available in cart page",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "sum of two product amount is same as Total Purchase Amount",
  "keyword": "Then "
});
formatter.step({
  "line": 59,
  "name": "click on \"Please read our terms of conditions\" link",
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "click on checkbox from Total purchase amount page",
  "keyword": "Then "
});
formatter.step({
  "line": 61,
  "name": "click on Visit to the website to complete purchase button",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "It will navigate to WEB-VIEW APP",
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "Perform some operation inside the WEB-VIEW APP",
  "keyword": "Then "
});
formatter.step({
  "line": 64,
  "name": "Again Navigate to NativeApp",
  "keyword": "Then "
});
formatter.match({
  "location": "General_Store_Step.launch_general_Store_hybrid_App()"
});
formatter.result({
  "duration": 53302307121,
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefination.General_Store_Step.launch_general_Store_hybrid_App(General_Store_Step.java:37)\r\n\tat ✽.Given launch general Store hybrid App(login.feature:46)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "General_Store_Step.open_notification_from_mobile()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.find_all_notification()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.clear_the_all_notifications_from_mobile_phone()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.select_the_country_where_you_want_to_shop()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.enter_your_name()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.select_your_gender()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.click_on_Let_s_shop_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.search_for_PG_product()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Converse All Star",
      "offset": 20
    }
  ],
  "location": "General_Store_Step.search_for_product(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.click_on_Add_cart_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.verify_two_product_are_available_in_cart_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.sum_of_two_product_amount_is_same_as_Total_Purchase_Amount()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Please read our terms of conditions",
      "offset": 10
    }
  ],
  "location": "General_Store_Step.click_on_link(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.click_on_checkbox_from_Total_purchase_amount_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.click_on_Visit_to_the_website_to_complete_purchase_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.it_will_navigate_to_WEB_VIEW_APP()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.perform_some_operation_inside_the_WEB_VIEW_APP()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "General_Store_Step.again_Navigate_to_NativeApp()"
});
formatter.result({
  "status": "skipped"
});
});