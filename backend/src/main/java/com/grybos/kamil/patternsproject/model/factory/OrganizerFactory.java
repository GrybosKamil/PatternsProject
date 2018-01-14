package com.grybos.kamil.patternsproject.model.factory;

//import com.grybos.kamil.patternsproject.model.Money;
import com.grybos.kamil.patternsproject.model.Organizer;
import org.springframework.stereotype.Component;

@Component
public class OrganizerFactory {

    public Organizer create(String username, String name) {
        return new Organizer(username, name);
    }

    public Organizer create(String username, String name,
                            long money
//                            Money money
    ) {
        return new Organizer(username, name, money);
    }

    public Organizer createNotFoundOrganizer(String username) {
        return new Organizer(username, "Not found organizer");
    }

    public Organizer createNotFoundOrganizer() {
        return new Organizer("Not found organizer", "Not found organizer");
    }
}
