package BookServiceRohit.BookService.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class MemberModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @SequenceGenerator(name = "seq_post", allocationSize = 1)
    @Column(name = "Id")
    long id;
    @Column(name = "Name", nullable = false)
    String name;

    @Column(name = "Address")
    String address;

    @OneToOne(cascade =CascadeType.ALL)
    private BookDetail book_name;

    @Column(name = "Mobile_Number")

    long mobile_number;

    @Column(name = "Pan_number")
    String pan_number;


    public MemberModel() {
    }

    public MemberModel(long id, String name, String address, BookDetail book_name, long mobile_number, String pan_number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.book_name = book_name;
        this.mobile_number = mobile_number;
        this.pan_number = pan_number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BookDetail getBook_name() {
        return book_name;
    }

    public void setBook_name(BookDetail book_name) {
        this.book_name = book_name;
    }

    public long getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(long mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getPan_number() {
        return pan_number;
    }

    public void setPan_number(String pan_number) {
        this.pan_number = pan_number;
    }
}