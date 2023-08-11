import java.util.Random;
import java.util.Scanner;

public class TicketSeller {
    
    class Buyer {
        Random random = new Random();

        String name;
        String dpi;
        int localityinfo = random.nextInt(3);
        static boolean isObjectCreated = false;

        public Buyer(String name, String dpi) {
            this.name = name;
            this.dpi = dpi;
        }
        private boolean isTicketEligible(int ticket) {;
            int a = random.nextInt(15000);
            int b = random.nextInt(15000);
            return (ticket + a + b) % 2 == 0;
        }

        private String getNameString() { 
            return name;
        }
    }
    
    class Localities {
        String[] id = {"Localidad 1", "Localidad 5", "Localidad 10"};
        int[] availableTickets = {20, 20, 20};
        int[] price = {400, 695, 2350};
    }

    class Sell {
        Buyer comprador;
        int ticketCount; 
        int maxBudget;

        public sell(int ticketCount, int maxBudget) { 
            this.buyer = comprador;
            this.ticketCount = ticketCount;
            this.maxBudget = maxBudget;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        TicketSeller ticketSeller = new TicketSeller();

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Nuevo Comprador");
            System.out.println("2. Comprar Boletos");
            System.out.println("3. Comprobar disponibilidad total");
            System.out.println("4. Comprobar disponibilidad individual");
            System.out.println("5. Dinero total");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Ingrese el nombre:");
                    String name = scanner.next();

                    System.out.println("Ingrese el DPI:");
                    String dpi = scanner.next();

                    TicketSeller.Buyer comprador = ticketSeller.new Buyer(name, dpi);
                    System.out.println("Bienvenido " + comprador.getNameString()); 
                    break;
                case 2:
                    // Comprar boletos en cliente definido por choice
                    break;
                case 3:
                    // Comprobar disponibilidad total
                    break;
                case 4:
                    // Comprobar disponibilidad individual
                    break;
                case 5:
                    // Dinero recolectado
                    break; 
                case 6:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, selecciona nuevamente.");
            
            }
        }
    }
}