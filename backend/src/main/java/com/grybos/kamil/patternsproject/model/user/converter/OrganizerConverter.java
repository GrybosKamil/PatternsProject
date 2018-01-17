package com.grybos.kamil.patternsproject.model.user.converter;

import com.grybos.kamil.patternsproject.model.user.Organizer;
import com.grybos.kamil.patternsproject.model.user.dto.OrganizerDTO;

public class OrganizerConverter {

    public static OrganizerDTO toOrganizerDTO(Organizer organizer) {
        return new OrganizerDTO(organizer);
    }
}
