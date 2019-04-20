package lesson3;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "ROOM")
public class Room  extends IdEntity{
    private long id;
    private int numberOfGuests;
    private double price;
    private int breakfastIncluded;
    private int petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room() {
    }

    public Room(int numberOfGuests, double price, int breakfastIncluded, int petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    @Id
    @SequenceGenerator(name = "RM_SEQ", sequenceName = "ROOM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RM_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name = "NUMBEROFGUESTS")
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    @Column(name = "BREAKFASTINCLUDED")
    public int getBreakfastIncluded() {
        return breakfastIncluded;
    }

    @Column(name = "PETSALLOWED")
    public int getPetsAllowed() {
        return petsAllowed;
    }

    @Column(name = "DATEAVAILABLEFROM")
    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "HOTEL_ID")
    public Hotel getHotel() {
        return hotel;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBreakfastIncluded(int breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public void setPetsAllowed(int pastAllowed) {
        this.petsAllowed = pastAllowed;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (numberOfGuests != room.numberOfGuests) return false;
        if (Double.compare(room.price, price) != 0) return false;
        if (breakfastIncluded != room.breakfastIncluded) return false;
        if (petsAllowed != room.petsAllowed) return false;
        if (dateAvailableFrom != null ? !dateAvailableFrom.equals(room.dateAvailableFrom) : room.dateAvailableFrom != null)
            return false;
        return hotel != null ? hotel.equals(room.hotel) : room.hotel == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = numberOfGuests;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + breakfastIncluded;
        result = 31 * result + petsAllowed;
        result = 31 * result + (dateAvailableFrom != null ? dateAvailableFrom.hashCode() : 0);
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvailableFrom=" + dateAvailableFrom +
                ", hotel=" + hotel +
                '}';
    }
}
