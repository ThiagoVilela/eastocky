package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Thiago on 26/03/2017.
 */
@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario extends GenericModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public int id;

    @Column(nullable=false,unique=false,length=50)
    public String nome;

    @Column(nullable=false,unique=true,length=50)
    public String email;

    @Column(nullable=false,unique=true,length=50)
    public String senha;

    @Column(nullable=false,unique=false)
    public int nivelAcesso;

}
