package uz.pdp.b6cinemarestservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.b6cinemarestservice.model.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@EqualsAndHashCode(callSuper = true)
@Entity(name = "attachment_contents")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttachmentContent extends AbsEntity {

    private byte[] data;

    @OneToOne
    private Attachment attachment;


}
