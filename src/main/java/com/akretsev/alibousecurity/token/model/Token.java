package com.akretsev.alibousecurity.token.model;

import com.akretsev.alibousecurity.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String tokenValue;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private TokenType tokenType = TokenType.BEARER;

    private boolean revoked;

    private boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
}
