package id.luannv.e_learning.entity;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;



import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(
    name = "lookup_values",
    uniqueConstraints = @UniqueConstraint(columnNames = {"lookup_cd", "lookup_group"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LookupValue extends BaseEntity{
    @Column(name = "id", nullable = false, unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "lookup_value", length = 255, nullable = false)
    String lookupValue;
    @Column(name = "lookup_cd", nullable = false)
    Integer lookupCd;
    @Column(name = "lookup_group", length = 20, nullable = false)
    String lookupGroup;
    @Column(name = "status_flg", nullable = false, columnDefinition = "tinyint default 1")
    Integer statusFlg;
    @Column(name = "description", length = 255)
    String description;
}

