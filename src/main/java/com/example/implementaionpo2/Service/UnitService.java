package com.example.implementaionpo2.Service;

import com.example.implementaionpo2.Entity.Unit;
import com.example.implementaionpo2.Entity.User;
import com.example.implementaionpo2.Repository.UnitRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public void addSampleUnit(){
        Unit u1 = new Unit();
        u1.setName("kg");

        Unit u2 = new Unit();
        u2.setName("szt");

        Unit u3 = new Unit();
        u3.setName("g");

        Unit u4 = new Unit();
        u4.setName("l");

        Unit u5 = new Unit();
        u5.setName("brak");

        unitRepository.save(u1);
        unitRepository.save(u2);
        unitRepository.save(u3);
        unitRepository.save(u4);
        unitRepository.save(u5);
    }
    public Unit getUnitById(Long unitId) {
        return unitRepository.findById(unitId).orElse(null);
    }
}
