import java.util.*;

class ECommerceException extends Exception
{
    public ECommerceException(String message) 
    {
        super(message);
    }
}

class PaymentException extends ECommerceException 
{
    public PaymentException (String message) 
    {
        super(message);
    }
}

class InventoryException extends ECommerceException 
{
    public InventoryException(String message)
    {
        super(message);
    }
}

class ShippingException extends ECommerceException
{
    public ShippingException(String message)
    {
        super(message);
    }
}

public class ECommerceApp 
{

    public static void processPayment(double amount) throws PaymentException {
        if (amount <= 0) 
        {
            throw new PaymentException("Invalid payment amount!");
        } 
        else if (amount > 50000) 
        {
            throw new PaymentException("Payment exceeds limit!");
        } 
        else 
        {
            System.out.println("Payment of ₹" + amount + " processed successfully.");
        }
    }

    public static void checkInventory(int stock, int requested) throws InventoryException {
        if (requested <= 0)
        {
            throw new InventoryException("Requested quantity must be greater than 0!");
        }
        else if (requested > stock)
        {
            throw new InventoryException("Insufficient stock available!");
        } 
        else 
        {
            System.out.println("Inventory available. Order can be fulfilled.");
        }
    }

    public static void processShipping(String address) throws ShippingException {
        if (address == null || address.trim().isEmpty())
        {
            throw new ShippingException("Invalid shipping address!");
        } 
        else if (address.length() < 10)
        {
            throw new ShippingException("Address too short!");
        }
        else 
        {
            System.out.println("Shipping to: " + address);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        try 
        {
            System.out.print("Enter payment amount: ");
            double amount = sc.nextDouble();
            processPayment(amount);
            
            System.out.print("Enter available stock: ");
            int stock = sc.nextInt();

            System.out.print("Enter requested quantity: ");
            int requested = sc.nextInt();
            checkInventory(stock, requested);

            sc.nextLine();

            System.out.print("Enter shipping address: ");
            String address = sc.nextLine();
            processShipping(address);

            System.out.println("\nOrder processed successfully!");

        } 
        catch (PaymentException | InventoryException | ShippingException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input type! Please enter correct values.");
        }
        finally 
        {
            sc.close();
            System.out.println("Application finished.");
        }
    }
}