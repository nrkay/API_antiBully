package com.example.antiBully.service;

import com.example.antiBully.advice.exception.DataNotFoundException;
import com.example.antiBully.dto.Province.RequestProvince;
import com.example.antiBully.model.Province;
import com.example.antiBully.repository.ProvinceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private ModelMapper modelMapper;

    //find by id
    public Province findById(UUID id){
        return provinceRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Province is Not Found"));
    }

    //add province
    public Province addProvince(RequestProvince request){
        return provinceRepository.save(modelMapper.map(request, Province.class));
    }

    //edit province
    public Province editProvince(UUID id, RequestProvince request){
        var provinceExist = findById(id);
        return provinceExist.setName(request.getName());
    }

    //delete province
    public void deleteProvince(UUID id){
        var dataExist = findById(id);
        provinceRepository.delete(dataExist);
    }

}
