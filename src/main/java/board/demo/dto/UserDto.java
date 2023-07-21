package board.demo.dto;

import board.demo.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private Integer userId; // 회원id

    private String name; // 이름

    private String email; // 메일

    private Integer gender; // 성별

//    private Integer addressId; // 주소id
//
//    private Integer zipCode; // 우편번호
//
//    private String detailAddress; // 상세주소

    @Builder
    public UserDto(Integer userId,
                   String name,
                   String email,
                   Integer gender) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public User toEntity() {
        User user = User.builder()
                .name(this.name)
                .email(this.email)
                .gender(this.gender)
                .build();
        return user;
    }
//    @Builder
//    public UserDto(Integer userId,
//                   String name,
//                   String email,
//                   Integer gender,
//                   Integer addressId,
//                   Integer zipCode,
//                   String detailAddress) {
//        this.userId = userId;
//        this.name = name;
//        this.email = email;
//        this.gender = gender;
//        this.addressId = addressId;
//        this.zipCode = zipCode;
//        this.detailAddress = detailAddress;
//    }
}
