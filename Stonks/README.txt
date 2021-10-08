Student name: Marco Solari
Student number: 200258469

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called Stocks.

This superclass is extended into at least two subclasses called BlueChip, GrowthStock and Speculative.

For each of the named subclasses complete the following...

Subclass 1.

Subclass BlueChip extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are int dividends, method setDividend() and method getDividend()

These/this new properties/property are used by the subclass in the following way: The variable dividends is calculated as 5% of the value of the stock using the setDividend() method and is then added to the users cash value as dividends
pay the user over time. The getDividends() method simply returns this value. Dividends is used on lines 105, 108 and 111 of the BlueChip class. The method setDividends() is declared on line 102 of the BlueChip class and is used on line 96 
of said class. The getDividend() method is set on line 102 of the BlueChip class and is called on lines 185 and 188 or the Market class. 


Subclass BlueChip extends the superclass by overriding the following methods (there must be at least one): printPattern() line 35, Performance() line 49, Cycle line 62

These overridden methods are used in the working code in the following places: printPattern() line 58 of the Market Class
									       Performance()  line 194 of the Market Class
									       Cycle()        line 181 of the Market Class 

Subclass 2.

Subclass Speculative extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are int excitement, method setExcitement()

These/this new properties/property are used by the subclass in the following way: the integer excitement is used to increase the amount that the stock price rises as this is a higly volatile stock. On line 78 of the Speculative class
the price of the stocks is increased by excitement as a percentage. The method setExcitement() uses the random function to create a number between 0 and 20.



Subclass Speculative extends the superclass by overriding the following methods (there must be at least one):  printPattern() line 40, Performance() line 53, Cycle line 66

These overridden methods are used in the working code in the following places: printPattern() line 69 of the Market Class
									       Performance() line 194 of the Market Class
									       Cycle() line 181 of the Market class	 



Subclass 3.

Subclass GrowthStock extends the superclass but doesn't add any instance variables, instead the subclass overrides methods and has different values for some shared variables such as growth pattern which is set on line 31.

The growth pattern is shared amonst all subclasses and the superclass but are all unique to each class and is called in line 35 of the printPattern() method (line 28) so each class prints a unique statement.



Subclass Speculative extends the superclass by overriding the following methods (there must be at least one):  printPattern() line 28, Performance() line 42, Cycle line 54

These overridden methods are used in the working code in the following places: printPattern() line 80 of the Market Class
									       Performance() line 194 of the Market Class
									       Cycle() line 181 of the Market class	 


LEVEL TWO

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in the market class line 56. The name of the superclass used this example is Stocks and the subclasses used are BlueChip.

Late dynamic binding can be seen the class market and line 58

The substitution principle is required so that an array of superclass elements can be type casted into subclasses to serve different purposes and add variety. Late dynamic binding is also necessary for differentiation
of which method should be called within classes so the correct methods are called appropriately. The example of line 58 is the printPattern() method which will give a brief description of the stock depending on which class it is.


Example 2.

The substitution principle can be seen in use in class market line 67. The name of the superclass used this example is Stocks and the subclass used is Speculative.

Late dynamic binding can be seen in class market line 181.

This example of the substitution principle is similar to the one above but is necessary in setting the types of Stocks objects throughout the program to ensure they have different behaviour and profiles.
Late dynamic binding with the method cycle() is called dependant on which object type calls it which isn't decided until run time. Each class has this method but it's contents are different in terms of random increases and decreases
to price and other elements such as dividends for BlueChip objects, making this necessary to ensure all stocks act according to their profiles. 
