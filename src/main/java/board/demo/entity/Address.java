package board.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AddressId; // 주소id

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private Integer owner; // 회원id

    private Integer zipCode; // 우편번호

    @Column(name = "detail_addr")
    private String detailAddress; // 상세주소

}
