package com.clasesWithAngela.clasesConAngela.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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

//EqualsAndHashCode: Genera automáticamente los métodos:
//equals() → para comparar si dos objetos son iguales.
//hashCode() → para usar el objeto en colecciones como Set o Map.
//OnlyExplicitlyIncluded = true: Le dice Loombok
//“No incluyas todos los campos en el equals y hashCode, solo los que yo marque con @EqualsAndHashCode.Include”.
//Esto es muy útil con entidades JPA, porque no quieres comparar todos los campos del objeto, solo el id (la clave primaria).
//Si compararas todos los campos, podrías tener errores o incluso bucles infinitos si hay relaciones entre entidades
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

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

    //Esta se usa dentro de la entidad cuando usas: onlyExplicitlyIncluded = true
    //Marca el campo que sí se debe incluir en la comparación (equals y hashCode).
    @EqualsAndHashCode.Include
    private int id;

    private String first_name;
    private String second_name;
    private String first_surname;
    private String second_surname;

    //Aca es facil de entender decimos que va a ser de uno a muchos 1:M (OneToMany)
    //Y lo de adentro significa que student es la dueña de EntollmentsModel ya que es una foreign key
    //Luego decimos que es cascada tod0, asi que si se crea o se elimina un estudiante se eliminara
    //Tambien en enrollment lo que este relacionado
    //fetch = FetchType.Lazy: Esta opción se usa en anotaciones de relaciones JPA, como @OneToMany, @ManyToOne, etc.
    //Controla cuándo se carga la relación desde la base de datos.
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    //Aca decimos que va a cambiar el atributo que especificamos arriba en comillas ""
    //Osea el "student", va a ser un cambio en la BD afectando el campo que esta conectado en EnrollmentsModel.
    //JsonManagedReference: Sirven para evitar bucles infinitos al convertir tus entidades en JSON.
    //Jackson te deja marcar qué lado de la relación es el “padre” (el que se muestra) y cuál es el “hijo”
    //(el que se ignora para no hacer el bucle).
    @JsonManagedReference("student-enrollments")
    private Set<EnrollmentsModel> enrollment;
}