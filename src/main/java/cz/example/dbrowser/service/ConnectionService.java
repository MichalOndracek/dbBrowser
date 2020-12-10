package cz.example.dbrowser.service;

import cz.example.dbrowser.domain.DbConnection;
import cz.example.dbrowser.service.dto.DbConnectionDTO;

public interface ConnectionService {

    DbConnection saveDbConnection(DbConnectionDTO dbConnection);

    DbConnection updateDbConnection(Long dbConnectionId, DbConnectionDTO dbConnection);

    void deleteDbConnection(Long dbConnectionId);

    DbConnection getDbConnection(Long dbConnectionId);
}
