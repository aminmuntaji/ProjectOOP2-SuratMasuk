package lab.safari.masukangularapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab.safari.masukangularapp.entity.Masuk;
import lab.safari.masukangularapp.repo.MasukRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;


@RestController
public class ApiController {

	@RequestMapping("/get-nama")
	public Map<String, Object> getNama(){
		Map<String, Object> result = new HashMap();
		result.put("nama", "Dio");

		return result;
	}
        @Autowired
        private MasukRepo masukRepo;

	//-- aplikasi mahasiswa 
	@RequestMapping("/daftar-masuk")
        public List<Masuk> ambilDaftarMasuk(){
            return masukRepo.findAll();
        }

    @RequestMapping(value = "/tambah-msk", method = RequestMethod.POST)
    public void tambahData(@RequestBody Masuk msk){
    	//System.out.println("nim : " + mhs.getNim());
    	//System.out.println("nama : " + mhs.getNama());
    	//System.out.println("jurusan : " + mhs.getJurusan());
    	masukRepo.save(msk);
    }

    @RequestMapping("/get-msk-by-id/{id}")
    public Masuk getMskById(@PathVariable("id") String id) {
    	return masukRepo.findOneById(id);
    }

    @RequestMapping(value = "/hapus-data/{id}", method = RequestMethod.DELETE)
    public void hapusData(@PathVariable("id") String id){
        masukRepo.delete(id);
    }


    @RequestMapping("/keluar")
    public void keluar(HttpServletRequest req, 
        HttpServletResponse resp) {
        Authentication auth = SecurityContextHolder
            .getContext().getAuthentication();
        new SecurityContextLogoutHandler()
            .logout(req, resp, auth);
    }


}