package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.b6cinemarestservice.model.Attachment;
import uz.pdp.b6cinemarestservice.model.AttachmentContent;

import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {

    AttachmentContent findByAttachment(Attachment attachment);



}
