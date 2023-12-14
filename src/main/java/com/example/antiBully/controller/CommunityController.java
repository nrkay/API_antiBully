package com.example.antiBully.controller;

import com.example.antiBully.dto.Community.RequestCommunity;
import com.example.antiBully.dto.Community.ResponseCommunity;
import com.example.antiBully.dto.responData.ResponseHandler;
import com.example.antiBully.model.Communities;
import com.example.antiBully.service.CommunitiesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Validated
@RequestMapping("/api/comunity")
public class CommunityController {

    @Autowired
    private CommunitiesService communitiesService;

    @Autowired
    private ModelMapper modelMapper;
    //add data
    @PostMapping("/")
    public ResponseEntity<Object> addData(@RequestParam("id") UUID id,
                                          @RequestBody RequestCommunity requestCommunity){
        ResponseCommunity response = communitiesService.addData(requestCommunity, id);
        return ResponseHandler.generateResponse("Successfully Create Data", HttpStatus.OK, response);
    }

    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getData(@PathVariable("id") UUID id){
        Communities response = communitiesService.findById(id);
        return ResponseHandler.generateResponse("Data is Found",
                HttpStatus.OK,
                modelMapper.map(response, ResponseCommunity.class));
    }

    //edit data
    @PutMapping("/{id}/{idprovince}")
    public ResponseEntity<Object> editData(@RequestBody RequestCommunity request,
                                           @PathVariable("id") UUID id,
                                           @PathVariable("idprovince") UUID idProvince){
       ResponseCommunity responseCommunity = communitiesService.editData(idProvince, request, id);
       return ResponseHandler.generateResponse("Edit Data id Successfull",
               HttpStatus.OK,
               responseCommunity);
    }

    //delete data
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteData(@PathVariable UUID id){
        communitiesService.deleteData(id);
        return new ResponseEntity<>("{\"message\": \"Data successfully deleted.\"}", HttpStatus.OK);

    }
}
