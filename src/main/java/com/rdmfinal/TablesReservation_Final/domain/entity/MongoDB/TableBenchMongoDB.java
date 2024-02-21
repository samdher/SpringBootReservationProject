package com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Getter
@Setter
@ToString
@Document
public class TableBenchMongoDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idTableBench;
    private int noPesons;
    private String ubication;
    private boolean isReserved;

    public TableBenchMongoDB(){

    }

    public TableBenchMongoDB(int noPesons, String ubication, boolean isReserved){
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
        TableBenchMongoDB tableBench = (TableBenchMongoDB) o;
        return getIdTableBench() != null && Objects.equals(getIdTableBench(), tableBench.getIdTableBench());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
