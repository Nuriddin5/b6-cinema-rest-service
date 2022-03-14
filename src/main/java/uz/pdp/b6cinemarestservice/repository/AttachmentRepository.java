package uz.pdp.b6cinemarestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.b6cinemarestservice.model.Attachment;
import uz.pdp.b6cinemarestservice.model.PriceCategory;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {



}
