package com.example.antiBully.service;

import com.example.antiBully.advice.exception.DataNotFoundException;
import com.example.antiBully.dto.Community.RequestCommunity;
import com.example.antiBully.dto.Community.ResponseCommunity;
import com.example.antiBully.model.Communities;
import com.example.antiBully.repository.CommunitiesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class CommunitiesService {
    @Autowired
    private CommunitiesRepository communitiesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProvinceService provinceService;

    //add
    public ResponseCommunity addData(RequestCommunity requestCommunity, UUID idProvince){
        var existProvince = provinceService.findById(idProvince);
        Communities data = Communities.builder()
                .image(requestCommunity.getImage())
                .name(requestCommunity.getName())
                .slogan(requestCommunity.getSlogan())
                .address(requestCommunity.getAddress())
                .phone(requestCommunity.getPhone())
                .wa(requestCommunity.getWa())
                .instagram(requestCommunity.getInstagram())
                .twitter(requestCommunity.getTwitter())
                .province(existProvince).build();
        communitiesRepository.save(data);
        ResponseCommunity dataAdd = modelMapper.map(data, ResponseCommunity.class);
        dataAdd.setProvince(existProvince.getName());
        return dataAdd;
    }

    //find by id
    public Communities findById(UUID id){
        return communitiesRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Data is Not Found"));
    }

    //find all
    public List<ResponseCommunity> findAll(){
        List<Communities> responseData = communitiesRepository.findAll();
        return responseData.stream().map(e -> modelMapper.map(e, ResponseCommunity.class))
                .collect(Collectors.toList());
    }

    //edit
    public ResponseCommunity editData(UUID idProvince, RequestCommunity reques, UUID idCommunity){
        var existProvince = provinceService.findById(idProvince);
        var existData = findById(idCommunity);
        existData.setName(reques.getName());
        existData.setSlogan(reques.getSlogan());
        existData.setAddress(reques.getAddress());
        existData.setPhone(reques.getPhone());
        existData.setWa(reques.getWa());
        existData.setInstagram(reques.getInstagram());
        existData.setTwitter(reques.getTwitter());
        existData.setDeskripsi(reques.getDeskripsi());
        existData.setProvince(existProvince);
        Communities editData = communitiesRepository.save(existData);
        ResponseCommunity response = modelMapper.map(editData, ResponseCommunity.class);
        response.setProvince(existProvince.getName());
        return  response;
    }

    //delete
    public void deleteData(UUID id){
        var existData = findById(id);
        communitiesRepository.delete(existData);
    }

}
