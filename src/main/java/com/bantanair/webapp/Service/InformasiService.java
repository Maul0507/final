package com.bantanair.webapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bantanair.webapp.Model.Informasi;
import com.bantanair.webapp.Repository.InfromasiRepository;

@Service
public class InformasiService {

    @Autowired
    private InfromasiRepository infromasiRepository;

    public List<Informasi> getAll(){
        return infromasiRepository.findAll();
    }

    public Informasi createInformasi(Informasi informasi){
        Informasi informasi2 = infromasiRepository.save(informasi);
        return informasi2;
    }
    
}
