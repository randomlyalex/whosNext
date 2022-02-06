package click.whosnext.restapiback.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import click.whosnext.restapiback.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
