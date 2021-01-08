import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {

    private Person passenger;
    private Date checkInTime;
    private boolean ifLuggage;
    private AirportSection departureGate;
    private AirportSection destinationGate;
    // An ArrayList that contains objects VisitedStore which are the stores of the departure's airport that passenger visited
    // A passenger may not visit any of the airport's store
    private ArrayList<VisitedStore> departureVisitedStores;


    /**
     * Constructor of the class
     * Creates a ticket with the specified passenger, checkIn time, luggage and gates of the airports of departure and destination
     * @param passenger An object Person representing the passenger of this ticket
     * @param checkInTime The time when passenger arrives to the airport
     * @param ifLuggage  A variable that says if passenger has luggages
     * @param departureGateName The gate of the departure's airport
     * @param destinationGateName The gate of the destination's airport
     */
    public Ticket(Person passenger, String checkInTime, boolean ifLuggage, AirportSection departureGate, AirportSection destinationGate) {
        this.passenger = passenger;
        setCheckInTime(checkInTime);
        this.ifLuggage = ifLuggage;
        this.departureGate = departureGate;
        this.destinationGate = destinationGate;
        this.departureVisitedStores = new ArrayList<VisitedStore>();
    }


    /**
     * Sets the passenger of the ticket
     * @param passenger Object Person containing the passenger of this ticket
     * @see Person
     */
    public void setPassenger(Person passenger) {
        this.passenger = passenger;
    }


    /**
     * Gets the passenger of the ticket
     * @return Person representing the passenger of this ticket
     */
    public Person getPassenger() {
        return this.passenger;
    }


    /**
     * Sets the time when passenger arrives to the airport
     * @param checkInTime String containing the time when passenger arrives to the airport
     */
    public void setCheckInTime(String checkInTime) {
        // handle ParseException if input has other form
        try {
        // convert String to Date (HH:mm)
        this.checkInTime = new SimpleDateFormat("HH:mm").parse(checkInTime);
        } catch(ParseException e) {
            e.printStackTrace();
            System.out.println("You should type checkInTime in format 'HH:mm'");
        }
    }


    /**
     * Gets the time when passenger arrives to the airport
     * @return Date representing the time when passenger arrives to the airport
     */
    public Date getCheckInTime() {
		return checkInTime;
    }


    /**
     * Sets the variable ifLuggage which has the information about having luggages
     * @param ifLuggage Boolean containing the information about having luggages
     */
    public void setIfLuggage(boolean ifLuggage) {
		this.ifLuggage = ifLuggage;
    }


    /**
     * Gets the variable ifLuggage that declares if passenger has luggages
     * @return boolean depending on whether this passenger has luggages
     */
    public boolean getIfLuggage() {
		return ifLuggage;
	}


    /**
     * Sets the gate of the departure's airport
     * @param departureGateName Object AirportSection containing the gate of the departure's airport
     * @see AirportSection
     */
    public void setDepartureGate(AirportSection departureGate) {
        this.departureGate = departureGate;
    }


    /**
     * Gets the gate of the departure's airport
     * @return AirportSection representing the gate of the departure's airport
     */
    public AirportSection getDepartureGate() {
        return this.departureGate;
    }


    /**
     * Sets the gate of the destination's airport
     * @param destinationGateName Object AirportSection containing the gate of the destination's airport
     * @see AirportSection
     */
    public void setDestinationGate(AirportSection destinationGate) {
        this.destinationGate = destinationGate;
    }


    /**
     * Gets the gate of the destination's airport
     * @return AirportSection representing the gate of the destination's airport
     */
    public AirportSection getDestinationGate() {
        return this.destinationGate;
    }


    /**
     * Adds an object VisitedStore to the ArrayList departureVisitedStore
     * Check if this object already exists into the ArrayList departureVisitedStore
     * @param store Object VisitedStore containing a store of the departure's airport that passenger visited
     * @see VisitedStore
     */
    public void addDepartureVisitedStore(VisitedStore store) {
        if(!this.departureVisitedStores.contains(store)) {
            this.departureVisitedStores.add(store);
        } else {
               System.out.println("This store has already been visited");
        }
    }


    /**
     * Gets the ArrayList departureVisitedStores with all stores that passenger visited
     * @return ArrayList<VisitedStore> containing objects VisitedStore representing the stores that passenger visited
     */
    public ArrayList<VisitedStore> getDepartureVisitedStores() {
        return this.departureVisitedStores;
    }

}
