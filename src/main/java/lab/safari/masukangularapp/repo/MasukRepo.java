/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.safari.masukangularapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lab.safari.masukangularapp.entity.Masuk;
/**
 *
 * @author User
 */
@Repository
public interface MasukRepo extends JpaRepository<Masuk, String> {
	Masuk findOneById(String id);
    
    
}
