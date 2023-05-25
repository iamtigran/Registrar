package Kings.Registrar.service;

import Kings.Registrar.entity.King;
import Kings.Registrar.repository.KingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KingService {

    @Autowired
    private KingRepository kingRepository;

    public List<King> getAllKings() {
        return kingRepository.findAll();
    }

    public King addKing(King king) {
        King existingKing = kingRepository.findByName(king.getName());
        String name = king.getName();
        if (existingKing != null) {
            king.setNumb(countKingsByName(name));
        }
        king.setName(name);
        return kingRepository.save(king);
    }

    public int countKingsByName(String name) {
        return kingRepository.countByName(name);
    }
}
