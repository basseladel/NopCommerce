Feature: User Registeration
   check user can register to e-commerce website
   Scenario: User Registeration
   Given the user is in home page 
   When the user click on register link
   And the user enters "<firstname>" , "<lastname>", "<email>", "<password>"
   Then the user registered successfully
   
   Examples:
		| firstname | lastname | email | | password |
		| Bassel | Adel | b.asdffdsa@gmail.com | | 12345678 |
		| Baher | Adel | b.asssa@gmail.com | | 12345678 |
		| Mo | Salah | m.salah@gmail.com | | 12345678 |
