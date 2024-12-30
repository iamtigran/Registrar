package Kings.Registrar.service;

import Kings.Registrar.Other.RomanNumeralConverter;
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
        Integer existingKing = getAllKings().indexOf(king);
        String name = king.getName();
        if (existingKing != null) {
            RomanNumeralConverter converter = new RomanNumeralConverter();
            int count = countKingsByName(name) + 1;
            king.setNumb(converter.convertToRoman(count));
            king.setName(name);
        } else {
            king.setName(name);
            king.setNumb("I");
        }

        return kingRepository.save(king);
    }

    public int countKingsByName(String name) {
        return kingRepository.countByName(name);

    }
}
