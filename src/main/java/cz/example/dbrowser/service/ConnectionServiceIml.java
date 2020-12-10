package cz.example.dbrowser.service;

import cz.example.dbrowser.domain.DbConnection;
import cz.example.dbrowser.repository.DbConnectionRepository;
import cz.example.dbrowser.service.dto.DbConnectionDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConnectionServiceIml implements ConnectionService {

    private final DbConnectionRepository dbConnectionRepository;

    @Override
    public DbConnection saveDbConnection(DbConnectionDTO dbConnection) {
        DbConnection newDbConnection = new DbConnection();
        newDbConnection.setDatabaseName(dbConnection.getDatabaseName());
        newDbConnection.setName(dbConnection.getName());
        newDbConnection.setHostname(dbConnection.getHostname());
        newDbConnection.setPort(dbConnection.getPort());
        newDbConnection.setUsername(dbConnection.getUsername());
        newDbConnection.setPassword(dbConnection.getPassword());

        return dbConnectionRepository.save(newDbConnection);
    }

    @Override
    public DbConnection updateDbConnection(Long dbConnectionId, DbConnectionDTO dbConnection) {
        DbConnection connectionToUpdate = dbConnectionRepository.getOne(dbConnectionId);
        connectionToUpdate.setDatabaseName(dbConnection.getDatabaseName());
        connectionToUpdate.setName(dbConnection.getName());
        connectionToUpdate.setHostname(dbConnection.getHostname());
        connectionToUpdate.setPort(dbConnection.getPort());
        connectionToUpdate.setUsername(dbConnection.getUsername());
        connectionToUpdate.setPassword(dbConnection.getPassword());
        return dbConnectionRepository.save(connectionToUpdate);
    }

    @Override
    public void deleteDbConnection(Long dbConnectionId) {
        dbConnectionRepository.deleteById(dbConnectionId);
    }

    @Override
    public DbConnection getDbConnection(Long dbConnectionId) {
        return dbConnectionRepository.findById(dbConnectionId).orElseThrow();
    }
}
