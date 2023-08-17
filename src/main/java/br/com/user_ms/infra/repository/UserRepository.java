package br.com.user_ms.infra.repository;


import br.com.user_ms.infra.repository.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> {
}
