package com.example.umc.domain;

import jakarta.persistence.*;
import lombok.*;
import com.example.umc.domain.common.BaseEntity;

import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String content;

    @NonNull
    private Double rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

//    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
//    private List<ReviewImage> reviewImageList;

}
