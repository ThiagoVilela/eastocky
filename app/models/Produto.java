package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Thiago on 26/03/2017.
 */
@Entity(name = "produto")
@Table(name = "produto")
public class Produto extends GenericModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public int id;

    @Column(nullable=false,unique=false)
    private double codigo;

}
