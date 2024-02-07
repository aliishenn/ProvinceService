package com.example.provinceservice.controller;

import com.example.provinceservice.model.Province;
import com.example.provinceservice.service.ProvinceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("provinces")
@AllArgsConstructor
public class ProvinceController {

    private final ProvinceService provinceService;



    @GetMapping
    public ResponseEntity<List<Province>> getProvinces(){



        return new ResponseEntity<>(provinceService.getProvinces(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getProvince(@PathVariable String id){
        return new ResponseEntity<>(getProvinceById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Province> createProvince(@RequestBody Province newProvince){

return new ResponseEntity<>(provinceService.createProvince(newProvince), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> getProvince(@PathVariable String id,@RequestBody Province newProvince){
        provinceService.updateProvince(id,newProvince);

        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("(/id)")
    public ResponseEntity<Void> deleteProvince(@PathVariable String id){
        provinceService.deleteProvince(id);

        return new ResponseEntity<>(OK);
    }

    private Province getProvinceById(String id){
        return provinceService.getProvinceById(id);

    }
}
