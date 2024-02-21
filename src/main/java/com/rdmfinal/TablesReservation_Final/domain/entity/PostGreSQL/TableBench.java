package com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class TableBench {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMesa;
    private int noPesons;
    private String ubication;
    private boolean isReserved;

    public TableBench(){

    }

    public TableBench(int noPesons,String ubication,boolean isReserved){
        this.noPesons = noPesons;
        this.ubication = ubication;
        this.isReserved = isReserved;
    }
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TableBench tableBench = (TableBench) o;
        return getIdMesa() != null && Objects.equals(getIdMesa(), tableBench.getIdMesa());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
