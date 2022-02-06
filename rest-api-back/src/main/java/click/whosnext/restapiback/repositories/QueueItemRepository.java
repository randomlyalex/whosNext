package click.whosnext.restapiback.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import click.whosnext.restapiback.domains.QueueItem;

@Repository
public interface QueueItemRepository extends JpaRepository<QueueItem, UUID> {


}
