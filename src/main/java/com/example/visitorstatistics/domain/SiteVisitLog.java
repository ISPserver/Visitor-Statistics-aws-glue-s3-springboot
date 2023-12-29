package com.example.visitorstatistics.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SiteVisitLog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("디바이스")
    private String device;

    @Comment("사용자 아이디")
    private String userId;

    private String osFamily;

    private String osVersion;

    private String browserFamily;

    private String browserVersion;

    @Enumerated(EnumType.STRING)
    private final SiteLogType type = SiteLogType.VISIT;

    protected LocalDateTime dateTime = LocalDateTime.now();

    protected LocalDate date = dateTime.toLocalDate();

    public SiteVisitLog(String userId) {
        this.userId = userId;
    }
}
