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
    public void deleteinformasi(Integer id){
        infromasiRepository.deleteById(id);
    }

    public Informasi getInformasiById(Integer id){
        return infromasiRepository.findById(id).orElse(null);
    }

    public Informasi  updateinformasi(Integer id, Informasi informasi){

        Informasi informasi2 = getInformasiById(id);
    
        if(informasi2 != null){
            informasi2.setId(informasi.getId());
            informasi2.setJudul(informasi.getJudul());
            informasi2.setIsi(informasi.getIsi());
    
            Informasi upinformasi = infromasiRepository.save(informasi2);
    
            return upinformasi;
        }
    
        return null;
    }
    
}
