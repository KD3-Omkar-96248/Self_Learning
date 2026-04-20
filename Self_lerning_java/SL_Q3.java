import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Animal 
{
    protected String name;

    public Animal(String name) 
    {
        this.name = name;
    }

    public abstract void makeSound();
    public String getName()
    { return name; }
}

class Lion extends Animal 
{
    public Lion(String name) 
    { super(name); }
    
    @Override
    public void makeSound() 
    {
        System.out.println(" > " + name + " the Lion: ROARS!");
    }
}

class Penguin extends Animal 
{
    public Penguin(String name) 
    { super(name); }
    
    @Override
    public void makeSound() 
    {
        System.out.println(" > " + name + " the Penguin: HONKS!");
    }
}

class Enclosure 
{
    private String type;
    private List<Animal> animals; 

    public Enclosure(String type) 
    {
        this.type = type;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) 
    {
        animals.add(animal);
    }

    public String getType() 
    { return type; }

    public void showResidents() 
    {
        if (animals.isEmpty()) 
        {
            System.out.println("The " + type + " enclosure is currently empty.");
        } 
        else 
        {
            System.out.println("\nResidents of " + type + " Enclosure:");
            for (Animal a : animals) 
            {
                a.makeSound();
            }
        }
    }
}

public class ZooManagementSystem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        List<Enclosure> zooEnclosures = new ArrayList<>();

        System.out.println("=== Welcome to the Zoo Builder ===");

        System.out.print("How many enclosures does your zoo have? ");
        int numEnclosures = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numEnclosures; i++) 
        {
            System.out.print("Enter name for enclosure #" + (i + 1) + " (e.g., Savanna): ");
            zooEnclosures.add(new Enclosure(sc.nextLine()));
        }

        boolean adding = true;
        while (adding) 
        {
            System.out.println("\n--- Add an Animal ---");
            System.out.println("1. Add Lion\n2. Add Penguin\n3. Finish and Show Zoo");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 3) 
            {
                adding = false;
                break;
            }

            System.out.print("Enter Animal Name: ");
            String animalName = sc.nextLine();

            System.out.println("Which enclosure should " + animalName + " go into?");
            for (int i = 0; i < zooEnclosures.size(); i++) {
                System.out.println(i + ". " + zooEnclosures.get(i).getType());
            }
            int encIndex = sc.nextInt();
            sc.nextLine();

            Animal newAnimal = (choice == 1) ? new Lion(animalName) : new Penguin(animalName);
            
            zooEnclosures.get(encIndex).addAnimal(newAnimal);
            System.out.println(animalName + " added successfully!");
        }

        System.out.println("\n\n======= FINAL ZOO REPORT =======");
        for (Enclosure e : zooEnclosures) 
        {
            e.showResidents();
        }
        
        System.out.println("\nClosing Zoo System...");
        sc.close();
    }
}