Feature: Verify eCommerce flow

Background:
  Given user open TutorialsNinja homepage

@Smoke
Scenario Outline: Verify registration
  Given user open TutorialNinja registration page
  When user enter firstname "<firstname>"
  And user enter lastname "<lastname>"
  And user enter registration email "<email>"
  And user enter telephone "<telephone>"
  And user enter registration password "<password>"
  And user enter confirm password "<confirmPassword>"
  And user click on privacy policy checkbox
  And user Click on continue button
  Then registration execute successfully

Examples:
  | firstname | lastname | email               | telephone   | password  | confirmPassword |
  | Ritika    | Agrawal  | ritika12@gmail.com  | 1234567891  | Test@123  | Test@123       |