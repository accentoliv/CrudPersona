package com.crudpersona.crudpersona.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="personas")
public class Persona {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    @Setter @Getter
    private int id;

    @Column(name="nombres")
    @Setter @Getter
    private String nombres;

    @Column(name="apellidos")
    @Setter @Getter
    private String apellidos;

    @Column(name="direccion")
    @Setter @Getter
    private String direccion;

    @Column(name="numero")
    @Setter @Getter
    private String numero;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id && Objects.equals(nombres, persona.nombres) && Objects.equals(apellidos, persona.apellidos) && Objects.equals(direccion, persona.direccion) && Objects.equals(numero, persona.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombres, apellidos, direccion, numero);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
