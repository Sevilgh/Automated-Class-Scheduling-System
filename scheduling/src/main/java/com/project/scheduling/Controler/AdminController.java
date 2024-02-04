package com.project.scheduling.Controler;


import java.util.List;
import java.util.Optional;

import com.project.scheduling.Model.Admin;
import com.project.scheduling.Repository.AdminRepository;
import com.project.scheduling.appProgram.Driver;
import com.project.scheduling.test.algo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;





    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/admin")
    List<Admin> all() {
        return (List<Admin>) adminRepository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/admin")
    Admin newAdmin(@RequestBody Admin newAdmin) {
        String[] a=new String[3];


        System.out.print("xoda bezanad bar kamarat");
        return adminRepository.save(newAdmin);

    }

    // Single item

    @GetMapping("/admin/{id}")
    Optional<Admin> one(@PathVariable int id){
        algo a=new algo();
        a.zz();
       /* Driver driver=new Driver();
        driver.start();*/
        return adminRepository.findById(id);

    }


    @PutMapping("/admin/{id}")
    Admin replaceAdmin(@RequestBody Admin newAdmin, @PathVariable("id") Integer id) {

        return adminRepository.findById(id)
                .map(admin -> {
                    admin.setFirstName(newAdmin.getFirstName());
                    admin.setLastName(newAdmin.getLastName());
                    admin.setPassword(newAdmin.getPassword());
                    admin.setCode(newAdmin.getCode());
                    return adminRepository.save(admin);
                })
                .orElseGet(() -> {
                    newAdmin.setId(id);
                    return adminRepository.save(newAdmin);
                });
    }

    @DeleteMapping("/admin/{id}")
    void deleteAdmin(@PathVariable Integer id) {
        adminRepository.deleteById(id);
    }
}