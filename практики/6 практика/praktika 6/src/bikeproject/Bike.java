package bikeproject;
//реализация интерфейса байкпартс
public class Bike implements BikeParts {

    private String handleBars, frame, tyres, seatType;
    private int numGears;
    private final String make;

    public Bike() {
        this.make = COMPANY_NAME;
    }

    public Bike(String handleBars, String frame, String tyres, String seatType, int numGears) {
        this.handleBars = handleBars;
        this.frame = frame;
        this.tyres = tyres;
        this.seatType = seatType;
        this.numGears = numGears;
        this.make = COMPANY_NAME;
    }

    protected void printDescription() {
        System.out.println("\n" + this.make + "\n"
                + "This bike has " + this.handleBars + " handlebars on a "
                + this.frame + " frame with " + this.numGears + " gears."
                + "\nIt has a " + this.seatType + " seat with " + this.tyres + " tyres.");
    }

    @Override
    public String getMake() {
        return make;
    }
}