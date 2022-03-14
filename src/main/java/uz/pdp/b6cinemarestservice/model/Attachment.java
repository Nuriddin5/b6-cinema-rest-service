package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Entity(name = "attachments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attachment extends AbsEntity {

    private String fileName;


    private String contentType;

    private long size;


}
