1. Interfaces provide common methods which can be implemented and
   defined in other classes.

2. Interface methods only have method signatures not definitions.

3. A class can implement different interfaces.

4. Class implementing an interface should define all the methods declared
   in the interface.

5. Interface actual use-case Example:
   i.Suppose you are constructing a payment gateway with multiple
     payment options such as Crypto, PayPal, Card.
   ii. All the underlying functionalities are the same in each case but
       the implementation are different so each class(Crypto, PayPal,Card)
       will have different implementations.

6. Code Snippet:
   public interface PaymentProcessor{
      public void validateCredential();
      public void checkStatus();
   }
   
   class Card implements PaymentProcessor{
       //Implementation of Card using validateCredentials(), checkStatus()
   }

   class Crypto implements PaymentProcessor{
       //Implementation of Crypto using validateCredentials(), checkStatus()
   }

   class Paypal implements PaymentProcessor{
       //Implementation of Paypal using validateCredentials(), checkStatus()
   }