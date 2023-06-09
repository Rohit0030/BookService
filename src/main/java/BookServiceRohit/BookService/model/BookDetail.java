package BookServiceRohit.BookService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @SequenceGenerator(name = "seq_post", allocationSize = 1)
    @Column(name = "Id")
    long id;

    String book_author;
    String purchase_date;

    int days;
    @OneToOne(mappedBy = "book_detail")
    @JsonBackReference
    private MemberModel memberModel;

    public BookDetail() {
    }

    public BookDetail(long id, String book_author, String purchase_date, int days,MemberModel memberModel) {
        this.id = id;
        this.book_author = book_author;
        this.purchase_date = purchase_date;
        this.days = days;
        this.memberModel=memberModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public MemberModel getMemberModel() {
        return memberModel;
    }

    public void setMemberModel(MemberModel memberModel) {
        this.memberModel = memberModel;
    }
}
