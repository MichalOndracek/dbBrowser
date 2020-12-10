package cz.example.dbrowser.repository;

import cz.example.dbrowser.domain.DbConnection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbConnectionRepository extends JpaRepository<DbConnection, Long> {
}
