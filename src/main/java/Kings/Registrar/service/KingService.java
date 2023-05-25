package Kings.Registrar.service;

import Kings.Registrar.entity.King;
import Kings.Registrar.repository.KingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class KingService {

    @Autowired
    private KingRepository kingRepository;

    public List<King> getAllKings() {
        return kingRepository.findAll();
    }

    public King addKing(King king) {
        Integer existingKing = getAllKings().indexOf(king);
        String name = king.getName();
        if (existingKing != null) {
            king.setNumb(countKingsByName(name)+1);
            king.setName(name);
        }
        else {
            king.setName(name);
            king.setNumb(1);
        }

        return kingRepository.save(king);
    }

    public int countKingsByName(String name) {
       return kingRepository.countByName(name);

    }
}
