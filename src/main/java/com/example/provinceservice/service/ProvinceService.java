package com.example.provinceservice.service;

import com.example.provinceservice.model.Province;
import com.example.provinceservice.repository.ProvinceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProvinceService {

    private final ProvinceRepository provinceRepository;
    public List<Province> getProvinces(){
        return provinceRepository.findAll();
    }

    public Province createProvince(Province newProvince) {
        return provinceRepository.save(newProvince);
    }

    public void deleteProvince(String id) {
        provinceRepository.deleteById(id);
    }

    public Province getProvinceById(String id) {
        return provinceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Province not found"));

    }

    public void updateProvince(String id, Province newProvince) {
        Province oldProvince = getProvinceById(id);
        oldProvince.setName(newProvince.getName());
        provinceRepository.save(oldProvince);
    }
}
