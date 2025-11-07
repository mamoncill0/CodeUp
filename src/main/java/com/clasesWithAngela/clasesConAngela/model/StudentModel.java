package com.clasesWithAngela.clasesConAngela.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

//Aca hacemos que Spring Boot entienda que es una entidad y se cree en la BD
@Entity

//Esta es la que genera automaticamente todos los getters, setters, toString, equals y hashcode.
@Data

//Crea un constructor con todos los campos como parámetros automaticamente.
@AllArgsConstructor

//Crea automaticamente el constructor vacio.
@NoArgsConstructor

//Aca se crea (si no existe) o se sincroniza (si ya existe) con la BD, esto va de la mano con el @Entity
//Porque le estamos diciendo que vamos a crear una tabla student y student es un Model osea una entidad.
//En resumen el name = "" dice como se va a llamar la nueva tabla.
@Table(name = "student")
public class StudentModel {

    //Esto se entiende facilmente, indicamos que esta es la clave primaria osea el Id
    @Id
    //Le dice a JPA que ese ID se genera automáticamente por la base de datos (autoincremental).
    //Y el parametro Strategy define como se genera que en este caso es un GenerationType, osea tipo de
    //Generacion y el IDENTITY dice la base de datos usa auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Y este es el ID privado que es el que va a recibir tod0 lo que especificamos arriba
    private int id;

    private String first_name;
    private String second_name;
    private String first_surname;
    private String second_surname;

    //Aca es facil de entender decimos que va a ser de uno a muchos 1:M (OneToMany)
    //Y lo de adentro significa que student es la dueña de EntollmentsModel ya que es una foreign key
    //Luego decimos que es cascada tod0, asi que si se crea o se elimina un estudiante se eliminara
    //Tambien en enrollment lo que este relacionado
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    //Aca decimos que va a cambiar el atributo que especificamos arriba en comillas ""
    //Osea el "student", va a ser un cambio en la BD afectando el campo que esta conectado en EnrollmentsModel
    private Set<EnrollmentsModel> enrollment;
}
