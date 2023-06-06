Feature: Epam site feature
  Scenario: domain is working
    Given browser installed
    When go to "https://www.epam.com/"
    Then Epam load website

  Scenario: "LEARNMORE" button working
    Given we are at "https://www.epam.com/"
    When we push "LEARNMORE" button
    Then button readdress us to "https://www.epam.com/support-ukraine"

  Scenario: Any page contains footer at the end
    Given go to "https://www.epam.com"
    When we scroll to the end of page
    Then footer appears at the end of page

  Scenario: Search by keyword
    Given User input word "{keyword}"
    When user click search button
    Then result matches "{keyword}"
    Examples:
        |    keyword      |
        |    BlockChain   |
        |    Cloud        |
        |    DevOps       |
        |    Open Source  |
        |    RPA          |

  Scenario Outline: Services page localization
    Given go to "https://www.epam.com/services"
    When press "Global (EN)", then "{language}"
    Then site localization is "{language}"
    Examples:
    |          language          |
    |    Україна (Українська)    |
    |    Polska (Polski)         |
    |    India (English)         |
    |    DACH (Deutsch)          |

  Scenario: Contact Us button working
    Given go to "https://www.epam.com/"
    When click "Contact us" button
    Then moving to "https://www.epam.com/about/who-we-are/contact"

  Scenario: "ABOUT" widget working
    Given go to "https://www.epam.com/"
    When we push "ABOUT" widget
    Then widget move us to "https://www.epam.com/about"

  Scenario: Moving to main page from any page
    Given go to "https://www.epam.com/our-work" 
    When press icon "<EPAM>" in the upper left corner
    Then move to main page
