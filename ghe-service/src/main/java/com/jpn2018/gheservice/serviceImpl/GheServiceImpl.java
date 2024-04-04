package com.jpn2018.gheservice.serviceImpl;

import com.jpn2018.gheservice.entity.Ghe;
import com.jpn2018.gheservice.repository.GheRepository;
import com.jpn2018.gheservice.service.GheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GheServiceImpl implements GheService {

    @Autowired
    GheRepository gheRepository;

    @Override
    public Ghe saveGhe(Ghe ghe) {
        return gheRepository.save(ghe);
    }

    @Override
    public List<Ghe> getListGhe() {
        return gheRepository.findAll();
    }

    @Override
    public Ghe getGheById(Long gheId) {
        Optional<Ghe> ghe = gheRepository.findById(gheId);
        if (!ghe.isPresent()) {
            //exception
            System.out.println("ghe not found");
        }
        return ghe.get();
    }

    @Override
    public void deleteGheById(Long gheId) {
        gheRepository.deleteById(gheId);
    }

    @Override
    public Ghe updateGhe(Long gheId, Ghe ghe) {
        Ghe oldGhe = gheRepository.findById(gheId).get();
        oldGhe.setNumberChair(ghe.getNumberChair());
        oldGhe.setType(ghe.getType());
        oldGhe.setStatus(ghe.isStatus());
        oldGhe.setPhongchieuId(ghe.getPhongchieuId());
        return gheRepository.save(oldGhe);
    }
}
