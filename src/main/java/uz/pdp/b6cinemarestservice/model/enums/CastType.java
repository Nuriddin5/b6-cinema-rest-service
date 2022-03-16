package uz.pdp.b6cinemarestservice.model.enums;

import java.util.Arrays;

public enum CastType {
    CAST_ACTOR("Aktyor"),
    CAST_DIRECTOR("Rejisyor");


    String displayName;

    CastType(String displayName) {
        this.displayName = displayName;
    }


    public static CastType getCastByDisplayName(String displayNameDto){

        return Arrays.stream(
                        CastType.values())
                .filter(castType -> castType.displayName.equals(displayNameDto)).findFirst().get();
    }
}
