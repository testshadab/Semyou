Feature: Login tests

  @Fogotpass
  Scenario Outline: Login into application
    Given Application login page
    Then click on RetrievePassword link
    Then enter fpemail in "<FPEmail>" field
    Then click on Fogotpass button
    And Verify "<FPEmailVal>" for "<FPEmail>" validation message for Forgotpassword

    Examples: 
      | FPEmail               | FPEmailVal                                 |
     # |                     | Please fill out this field.                |
     # | dg                  | Please enter an email address.             |
     # | dg12  test%^        | Please enter an email address.             |
      | cdem@autobill.biz   | Could Not Found Entity/Invalid Email       |
     # | cdemo1@autobill.biz | Password reset link has been mailed to you |
