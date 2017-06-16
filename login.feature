@allloginscen

Feature: Login tests

  @vlaidlogin
  Scenario Outline: Login into application
    Given Application login page
    Then enter email in "<Email>" field
    Then enter password in "<Password>" field
    Then click on Login button
    Then click on user icon drop down button
    Then click on Logout icon
    Then verify Login button

    Examples: 
      | Email               | Password |
      | cdemo1@autobill.biz | udoy12#  |
      
      

  @invlaidlogin
  Scenario Outline: Login into application
    Given Application login page
    Then enter email in "<Email>" field
    Then enter password in "<Password>" field
    Then click on Login button
    And Verify "<EmailVal>" for "<Email>" validation message for username
    And Verify "<passwordVal>" for "<Password>" validation message for password
    And Verify "<loginErrorMsg>" for "<Email>" and "<Password>" validation for all invalid credentials

    Examples: 
      | Email               | Password | EmailVal                       | passwordVal                 | loginErrorMsg             |
     |                     |          | Please fill out this field.    |                             |                           |
     # | cdemo1@autobill.biz |          |                                | Please fill out this field. |                           |
     # |                     | udoy12#  | Please fill out this field.    |                             |                           |
     # | dg                  |          | Please enter an email address. |                             |                           |
     # | dg12                | andy1165 | Please enter an email address. |                             |                           |
     # |                     | udoy12   |                                | Please fill out this field. |                           |
    #  | cdemo1@autobill.biz | udoy12   |                                |                             | Invalid Email or Password |
      | cdem@autobill.biz   | udoy12#  |                                |                             | Invalid Email or Password |
