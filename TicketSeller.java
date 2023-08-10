import java.util.Scanner;
import java.util.Random;

public class TicketSeller {
    private static final int TOTAL_TICKETS = 60;
    private static final int LOCALITIES_COUNT = 3;
    private static final int TICKETS_PER_LOCALITY = TOTAL_TICKETS / LOCALITIES_COUNT;
    private static final int[] TICKET_PRICES = { 400, 695, 2350 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locality[] localities = initializeLocalities();

        while (true) {
            System.out.println("Ingrese el nombre:");
            String name = scanner.nextLine();
            System.out.println("Ingrese el DPI:");
            String dpi = scanner.nextLine();
            System.out.println("Ingrese la cantidad de boletos a comprar:");
            int ticketCount = Integer.parseInt(scanner.nextLine());
            System.out.println("Ingrese el presupuesto máximo:");
            int maxBudget = Integer.parseInt(scanner.nextLine());

            TicketRequest request = new TicketRequest(name, dpi, ticketCount, maxBudget);
            int ticket = generateRandomNumber(33000);
            if (isTicketEligible(ticket)) {
                Locality locality = assignRandomLocality(localities);
                processRequest(request, locality);
            }
        }
    }

    private static Locality[] initializeLocalities() {
        Locality[] localities = new Locality[LOCALITIES_COUNT];
        for (int i = 0; i < localities.length; i++) {
            localities[i] = new Locality(i + 1, TICKETS_PER_LOCALITY, TICKET_PRICES[i]);
        }
        return localities;
    }

    private static int generateRandomNumber(int range) {
        Random rand = new Random();
        return rand.nextInt(range) + 1;
    }

    private static boolean isTicketEligible(int ticket) {
        int a = generateRandomNumber(15000);
        int b = generateRandomNumber(15000);
        return (ticket + a + b) % 2 == 0;
    }

    private static Locality assignRandomLocality(Locality[] localities) {
        return localities[generateRandomNumber(LOCALITIES_COUNT) - 1];
    }

    private static void processRequest(TicketRequest request, Locality locality) {
        if (locality.validateAndSell(request)) {
            System.out.println("Boletos vendidos con éxito!");
        } else {
            System.out.println("No se pudieron vender los boletos.");
        }
    }
}

class TicketRequest {
    String name;
    String dpi;
    int ticketCount;
    int maxBudget;

    public TicketRequest(String name, String dpi, int ticketCount, int maxBudget) {
        this.name = name;
        this.dpi = dpi;
        this.ticketCount = ticketCount;
        this.maxBudget = maxBudget;
    }
}

class Locality {
    int id;
    int availableTickets;
    int price;

    public Locality(int id, int availableTickets, int price) {
        this.id = id;
        this.availableTickets = availableTickets;
        this.price = price;
    }

    public boolean validateAndSell(TicketRequest request) {
        if (availableTickets == 0) return false;
        if (request.maxBudget < price) return false;

        int ticketsToSell = Math.min(request.ticketCount, availableTickets);
        availableTickets -= ticketsToSell;
        return true;
}
}