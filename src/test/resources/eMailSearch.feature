@MailSearch

Feature: Search Emails in Yandex

  @P1
  Scenario Outline: Ope7d3n
    When I type in LOGIN value <e-mail>
    When I type in PASSWORD value <password>
    And I click on Enter in login form
    And I type <searchValue> in search box and click Enter

    Then User clicks on <subject> found email
    And Subject is <subject>
    And Body is <body>
    Then User log-out

    Examples:
      | e-mail               | password | searchValue | subject         | body         |
      | crystal.service.test | crystal  | crystal     | Subject example | Body example |


