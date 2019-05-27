package lesson4.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "ORDERS")
public class Order  extends IdEntity  {
    private long id;
    private User userOrdered;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order() {
    }

    public Order(User userOrdered, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.userOrdered = userOrdered;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    @Id
    @SequenceGenerator(name = "ORD_SEQ", sequenceName = "ORDER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORD_SEQ")
    @Column (name = "ID")
    public long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name="USER_ORDERED", nullable=false)
    public User getUserOrdered() {
        return userOrdered;
    }

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ROOM_ID")
    public Room getRoom() {
        return room;
    }

    @Column (name = "DATE_FROM")
    public Date getDateFrom() {
        return dateFrom;
    }

    @Column (name = "DATE_TO")
    public Date getDateTo() {
        return dateTo;
    }

    @Column (name = "MONEY_PAID")
    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserOrdered(User userOrdered) {
        this.userOrdered = userOrdered;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", moneyPaid=" + moneyPaid +
                '}';
    }
}
