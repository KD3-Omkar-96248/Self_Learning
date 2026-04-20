import java.util.*;

class Product 
{
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) 
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Order 
{
    Map<Integer, Integer> items;
    double totalAmount;

    public Order(Map<Integer, Integer> items, double totalAmount)
    {
        this.items = new HashMap<>(items); 
        this.totalAmount = totalAmount;
    }

    public void displayOrder(Map<Integer, Product> productCatalog)
    {
        System.out.println("Order Details:");
        for (Map.Entry<Integer, Integer> entry : items.entrySet()) 
        {
            Product p = productCatalog.get(entry.getKey());
            System.out.println(p.name + " x " + entry.getValue() + 
                               " = ₹" + (p.price * entry.getValue()));
        }
        System.out.println("Total: ₹" + totalAmount);
    }
}

public class ShoppingCartApp
{

    static Map<Integer, Product> productCatalog = new HashMap<>();
    static Map<Integer, Integer> cart = new HashMap<>();
    static List<Order> orderHistory = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        productCatalog.put(1, new Product(1, "Laptop", 50000));
        productCatalog.put(2, new Product(2, "Phone", 20000));
        productCatalog.put(3, new Product(3, "Headphones", 2000));

        int choice;

        do
        {
            System.out.println("\n==== Shopping Cart Menu ====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Remove from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. View Order History");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    viewProducts();
                    break;

                case 2:
                    addToCart(sc);
                    break;

                case 3:
                    removeFromCart(sc);
                    break;

                case 4:
                    viewCart();
                    break;

                case 5:
                    checkout();
                    break;

                case 6:
                    viewOrderHistory();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } 
        while (choice != 0);

        sc.close();
    }

    static void viewProducts() 
    {
        System.out.println("\nAvailable Products:");
        for (Product p : productCatalog.values()) 
        {
            System.out.println(p.id + ". " + p.name + " - ₹" + p.price);
        }
    }

    static void addToCart(Scanner sc) 
    {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (!productCatalog.containsKey(id))
        {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        if (qty <= 0)
        {
            System.out.println("Invalid quantity!");
            return;
        }

        cart.put(id, cart.getOrDefault(id, 0) + qty);
        System.out.println("Product added to cart.");
    }

    static void removeFromCart(Scanner sc) 
    {
        System.out.print("Enter Product ID to remove: ");
        int id = sc.nextInt();

        if (!cart.containsKey(id))
        {
            System.out.println("Product not in cart!");
            return;
        }

        cart.remove(id);
        System.out.println("Product removed from cart.");
    }

    static void viewCart()
    {
        if (cart.isEmpty())
        {
            System.out.println("Cart is empty!");
            return;
        }

        double total = 0;
        System.out.println("\nCart Items:");
        for (Map.Entry<Integer, Integer> entry : cart.entrySet())
        {
            Product p = productCatalog.get(entry.getKey());
            int qty = entry.getValue();
            double cost = p.price * qty;
            total += cost;

            System.out.println(p.name + " x " + qty + " = ₹" + cost);
        }

        System.out.println("Total: ₹" + total);
    }

    static void checkout()
    {
        if (cart.isEmpty()) 
        {
            System.out.println("Cart is empty!");
            return;
        }

        double total = 0;
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) 
        {
            Product p = productCatalog.get(entry.getKey());
            total += p.price * entry.getValue();
        }

        Order order = new Order(cart, total);
        orderHistory.add(order);

        cart.clear();

        System.out.println("Order placed successfully! Total: ₹" + total);
    }

    static void viewOrderHistory()
    {
        if (orderHistory.isEmpty()) 
        {
            System.out.println("No orders placed yet!");
            return;
        }

        int i = 1;
        for (Order order : orderHistory) 
        {
            System.out.println("\nOrder #" + i++);
            order.displayOrder(productCatalog);
        }
    }
}