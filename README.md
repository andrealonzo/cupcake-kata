This is my implementation of the cupcake kata from here:  https://codingdojo.org/kata/cupcake/

I have expanded it to make this a fully functional webservice.  Here are the requirements.

Welcome to the bakery where we have cupcakes, cookies, and all other types of pastries.  We LOVE toppings such as chocolate, nuts, etc.  

We are creating a website where a customer can choose a pastry and add as many toppings as they want.  Each pastry has a base price and each topping has its own base price.  To get the total price for each pastry, you would add up the base price of the pastry plus the prices of all toppings.

For example, if you had a cupcake ($1.00) with chocolate ($.10) and nuts($.20), the total price would be $1.30.

Also, the name of that pastry and topping combination should get "Cupcake with chocolate and nuts".  If you had 3 toppings, it should say "Cupcake with chocolate, nuts and sprinkles".  If there are no toppings, is should just say "Cupcake".

We can take orders and add as many pastry/topping combinations as they want.  The order would contain the list of pastry/topping combinations, their names, and individual prices.  The order would also have an order name and the total price of the order.

We will be adding discount bundles in the future.  