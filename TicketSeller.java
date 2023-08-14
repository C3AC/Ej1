import java.util.Random;
import java.util.Scanner;

public class TicketSeller {
    
    class Buyer {
        Random random = new Random();
        String name;
        String dpi;
        int ticket = random.nextInt(3);
        public Buyer(String name, String dpi) {
            this.name = name;
            this.dpi = dpi;
        }


        private String getNameString() { 
            return name;
        }
        private int getLocal() { 
            return ticket; 
        }
    }
    
    class Localidad{
        int availableTickets= 20;
        int price;

        public Localidad(int price) {
            this.price = price; 
        }
        private int getPrice(){
            return price;
        }
        private int getavailability() { 
            return availableTickets;
        }
    }

    class Sell{
        Random random = new Random();
        int ticketCount; 
        int maxBudget; 

        public Sell(int ticketCount, int maxBudget) { 
            this.ticketCount = ticketCount;
            this.maxBudget = maxBudget;
        }

        private int getCount() {
            return ticketCount; 
        }
        private int getBudget() {
            return maxBudget;
        }
        private boolean isTicketEligible() {
            int ticket= random.nextInt(33000)+1;
            int a = random.nextInt(15000);
            int b = random.nextInt(15000);
            return (ticket + a + b) % 2 == 0;
        }
    }

    public static void main(String[] args) {
        int total = 0; 
        Scanner scanner = new Scanner(System.in);
        int choice;
        TicketSeller ticketSeller = new TicketSeller();
        
        System.out.println("Para ingresar, active un comprador");
        System.out.println("Ingrese el nombre:");
        String name = scanner.next();
            
        System.out.println("Ingrese el DPI:");
        String dpi = scanner.next();
            
        TicketSeller.Buyer buyer = ticketSeller.new Buyer(name, dpi);
        System.out.println("Bienvenido");


        // Inicializador de Localidades 
        TicketSeller.Localidad Localidad1 = ticketSeller.new Localidad(400);
        TicketSeller.Localidad Localidad5 = ticketSeller.new Localidad(695);
        TicketSeller.Localidad Localidad10= ticketSeller.new Localidad(2350);

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
                case 1:                     // Modificar información del usuario
                    System.out.println("Ingrese el nombre:");
                    name = scanner.next();

                    System.out.println("Ingrese el DPI:");
                    dpi = scanner.next();

                    buyer = ticketSeller.new Buyer(name, dpi);
                    System.out.println("Bienvenido");
                    break;
                
                case 2:                     // Comprar boletos en cliente

                System.out.println("Ingrese la cantidad de tickets a comprar para " + buyer.getNameString());
                int ticketcount = scanner.nextInt();
                System.out.println("Ingrese su presupuesto maximo: ");
                int maxBudget = scanner.nextInt();
                TicketSeller.Sell venta = ticketSeller.new Sell(ticketcount, maxBudget);
                
                switch (buyer.getLocal()) {
                    
                    case 0: 
                    System.out.println("Se ha seleccionado la Localidad 1");
                    if (venta.isTicketEligible()) { 
                        if (venta.getBudget() > Localidad1.getPrice()*venta.getCount()) {
                            if (venta.getCount() > Localidad1.availableTickets) { 
                                System.out.println("No se puede vender la cantidad de tickets solicitadas, se vendera la mayor cantidad posible");
                                total = total + (Localidad1.getPrice()*Localidad1.availableTickets);
                                Localidad1.availableTickets = 0;
                                System.out.println("Boletos comprados exitosamente");
                            }
                            else {
                                total = total + (Localidad1.getPrice()*venta.getCount());
                                Localidad1.availableTickets = Localidad1.availableTickets - venta.getCount();
                                System.out.println("Boletos comprados exitosamente");
                            }
                        }
                        else {
                            System.out.println("El precio de compra supera su presupuesto");
                        }
                    }
                    else { 
                        System.out.println("Compra no realizable");
                    }
                
                    break;

                    case 1: 
                    System.out.println("Se ha seleccionado la Localidad 5");
                    if (venta.isTicketEligible()) { 
                        if (venta.getBudget() > Localidad5.getPrice()*venta.getCount()) {
                            if (venta.getCount() > Localidad5.availableTickets) { 
                                System.out.println("No se puede vender la cantidad de tickets solicitadas, se vendera la mayor cantidad posible");
                                total = total + (Localidad5.getPrice()*Localidad5.availableTickets);
                                Localidad5.availableTickets = 0;
                                System.out.println("Boletos comprados exitosamente");
                            }
                            else {
                                total = total + (Localidad1.getPrice()*venta.getCount());
                                Localidad5.availableTickets = Localidad5.availableTickets - venta.getCount();
                                System.out.println("Boletos comprados exitosamente");
                            }
                        }
                        else {
                            System.out.println("El precio de compra supera su presupuesto");
                        }
                    }
                    else { 
                        System.out.println("Compra no realizable");
                    }
                
                    break;
                    
                    case 2:
                    System.out.println("Se ha seleccionado la Localidad 10");
                    if (venta.isTicketEligible()) { 
                        if (venta.getBudget() > Localidad10.getPrice()*venta.getCount()) {
                            if (venta.getCount() > Localidad10.availableTickets) { 
                                System.out.println("No se puede vender la cantidad de tickets solicitadas, se vendera la mayor cantidad posible");
                                total = total + (Localidad10.getPrice()*Localidad10.availableTickets);
                                Localidad10.availableTickets = 0;
                                System.out.println("Boletos comprados exitosamente");
                            }
                            else {
                                total = total + (Localidad10.getPrice()*venta.getCount());
                                Localidad10.availableTickets = Localidad10.availableTickets - venta.getCount();
                                System.out.println("Boletos comprados exitosamente");
                            }
                        }
                        else {
                            System.out.println("El precio de compra supera su presupuesto");
                        }
                    }
                    else { 
                        System.out.println("Compra no realizable");
                    }

                    break;
                default: 
                    System.out.println("Argumento de localidad invalido");
                }
                break; 
                case 3:              // Comprobar disponibilidad total
                    System.out.println("La cantidad de tickets en la Localidad 1 es de " + Localidad1.getavailability());
                    System.out.println("La cantidad de tickets en la Localidad 5 es de " + Localidad5.getavailability());
                    System.out.println("La cantidad de tickets en la Localidad 10 es de " + Localidad10.getavailability());
                    break;
                case 4:          // Comprobar disponibilidad individual

                    System.out.println("1. Localidad 1");
                    System.out.println("2. Localidad 5");
                    System.out.println("3. Localidad 10");
                    int select = scanner.nextInt();

                switch (select) {

                    case 1: 
                    System.out.println("Quedan " + Localidad1.getavailability() + " tickets");
                    break;
                    
                    case 2:
                    System.out.println("Quedan " + Localidad5.getavailability() + " tickets");
                    break;

                    case 3: 
                    System.out.println("Quedan " + Localidad10.getavailability() + " tickets");
                    break;

                    default: 
                        System.out.println("Opción no válida. Por favor, selecciona nuevamente: ");
                }
                    break;
                case 5:                    // Dinero recolectado
                    System.out.println("El total de dinero generado hasta el momento es de $" + total);

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