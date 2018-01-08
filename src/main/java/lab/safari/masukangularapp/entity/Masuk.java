/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.safari.masukangularapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author User
 */
@Entity
public class Masuk {
    
    @Id @Getter @Setter
    private String id;

    @Column @Getter @Setter
    private String tanggal_surat;
    
    @Column @Getter @Setter
    private String judul;
    
    @Column @Getter @Setter
    private String kepada;
    
}
