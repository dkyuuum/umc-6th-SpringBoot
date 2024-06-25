package com.example.umc.domain;

import jakarta.persistence.*;
import lombok.*;
import com.example.umc.domain.common.BaseEntity;
import com.example.umc.domain.mapping.MemberPrefer;

import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPrefers;
}
