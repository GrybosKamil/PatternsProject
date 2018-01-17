package com.grybos.kamil.patternsproject.model.user.dto;

import com.grybos.kamil.patternsproject.model.user.Organizer;
import lombok.Data;

@Data
public class OrganizerDTO extends MemberDTO {

    private String descrption;

    public OrganizerDTO(Organizer organizer) {
        super(organizer);
        this.descrption = organizer.getDescription();
    }
}
