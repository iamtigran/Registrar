package Kings.Registrar.service;

import org.springframework.beans.factory.annotation.Autowired;

public class CountOfKingsByName {

    @Autowired
    private KingService kingService;

    public void checkKingOccurrences(String name) {
        int count = kingService.countKingsByName(name);
        System.out.println("Occurrences of " + name + ": " + count);
    }

}
