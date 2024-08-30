# -ECommerceWebsite
Online Shopping and Order Management System

The scenario represents an example of exception handling in Java within the context of a simple e-commerce website for ordering products online. The scenario is that a user can place an order for a product, make a payment for it, and then have it delivered. The code uses different types of exceptions to handle errors that might occur during the ordering process.
Here is a brief description of how the code works:

The ‘ECommerceWebsite’ class contains the main logic for the ordering process, including methods for placing an order, making a payment, and delivering the order. These methods can throw different types of exceptions, depending on the nature of the error.
The ‘Order’ class represents a single order that a user can place on the website. Each order can have one or more products associated with it and has a unique ID that is generated automatically.
The ‘Product’ class represents a single product that can be ordered on the website. Each product has a name, a price, and a stock level that is tracked by the website.
The ‘OrderException’ class is a superclass that represents a general exception that can occur during the ordering process. This class is used to catch any unexpected errors that might appear.
The ‘ProductException’, ‘StockException’, ‘PaymentException’, and ‘DeliveryException’ classes are all subclasses of ‘OrderException’ that represent specific types of exceptions that can occur during the ordering process. These classes are used to catch and handle errors related to the product, stock level, payment, and delivery, respectively.
The code uses various object-oriented programming concepts such as inheritance, method overriding, and constructor overloading to create a well-structured and modular codebase.
During the ordering process, the user selects a product, enters the quantity they wish to order, and provides payment information. The code then checks whether the product is in stock, whether the payment is valid, and whether the delivery information is correct. If any errors occur during this process, the appropriate exception is thrown, and the user is notified of the error.
Once the order has been successfully placed, the code generates a unique order ID and adds the order to a list of active orders. The user can then track the order using the order ID and receive updates on its delivery status.
Overall, this code demonstrates how to handle exceptions in Java within the context of an e-commerce website and shows how to use object-oriented programming concepts to create a well-structured and modular codebase.

Name of all Exceptions: 
The following exceptions are created and handled in this implementation:
1.ProductException: This exception is thrown if there is an error related to the product, such as if the product is not found or if there is an issue with its attributes.
2.StockException: This exception is thrown if there is insufficient stock available for the product.
3.PaymentException: This exception is thrown if there is an error related to the payment method or payment amount.
4.DeliveryException: This exception is thrown if there is an error related to the delivery of the order, such as an invalid tracking number.

All of these exceptions are subclasses of the ‘OrderException’ class, which represents a general exception that can occur during the ordering process. The ‘OrderException’ class is used to catch any unexpected errors that might occur.
