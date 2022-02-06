package click.whosnext.restapiback.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import click.whosnext.restapiback.domains.Queue;

@Repository
public interface QueueRepository extends JpaRepository<Queue, UUID> {

}
