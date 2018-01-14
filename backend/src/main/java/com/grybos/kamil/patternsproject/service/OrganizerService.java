package com.grybos.kamil.patternsproject.service;

import com.grybos.kamil.patternsproject.model.Organizer;
import com.grybos.kamil.patternsproject.model.Wallet;
import com.grybos.kamil.patternsproject.model.factory.OrganizerFactory;
import com.grybos.kamil.patternsproject.model.factory.WalletFactory;
import com.grybos.kamil.patternsproject.repository.OrganizerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizerService {

    @Autowired
    OrganizerRepository organizerRepository;
    @Autowired
    OrganizerFactory organizerFactory;
    @Autowired
    WalletFactory walletFactory;

    private static final Logger logger = LoggerFactory.getLogger(OrganizerService.class);

    public void create(String username, String name) {
        logger.info("create");
        Organizer m = organizerFactory.create(username, name, walletFactory.create());
        organizerRepository.save(m);
    }

    public void create(String username, String name, Wallet wallet) {
        logger.info("create");
        Organizer m = organizerFactory.create(username, name, wallet);
        organizerRepository.save(m);
    }

    public Organizer findByUsername(String username) {
        return organizerRepository.findByUsername(username);
    }

    public Organizer createNotFoundOrganizer() {
        return organizerFactory.createNotFoundOrganizer();
    }

    public Organizer createNotFoundOrganizer(String username) {
        return organizerFactory.createNotFoundOrganizer(username);
    }
}